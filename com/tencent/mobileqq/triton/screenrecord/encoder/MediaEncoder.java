package com.tencent.mobileqq.triton.screenrecord.encoder;

import android.media.MediaCodec;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class MediaEncoder implements Runnable {
    private static final boolean DEBUG = true;
    private static final int READY_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaEncoder";
    private static final int TIMEOUT_MS = 10000;
    private MediaCodec.BufferInfo mBufferInfo;
    private volatile Thread mEncoderThread;
    private MediaCodec mMediaCodec;
    private final MediaMuxerController mMuxerController;
    private boolean mMuxerStarted;
    private int mRequestDrain;
    private boolean mRequestRelease;
    private final Object mSync = new Object();
    private int mTrackIndex = -1;

    public MediaEncoder(MediaMuxerController mediaMuxerController) {
        if (mediaMuxerController != null) {
            this.mMuxerController = mediaMuxerController;
            mediaMuxerController.addEncoder(this);
            this.mBufferInfo = new MediaCodec.BufferInfo();
            return;
        }
        throw new NullPointerException("MediaMuxerController is null");
    }

    private void releaseCodec() {
        Logger.d(TAG, "releaseCodec, MediaEncoder: " + this);
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            } catch (Exception e16) {
                Logger.e(TAG, "failed to release MediaCodec, MediaEncoder: " + this, e16);
            }
        }
        if (!this.mMuxerStarted) {
            Logger.w(TAG, "releaseCodec, mMuxerStarted = false, MediaEncoder: " + this);
        }
        try {
            this.mMuxerController.notifyReleased(this);
        } catch (Exception e17) {
            Logger.e(TAG, "failed to stop muxer, MediaEncoder: " + this, e17);
        }
    }

    protected abstract MediaCodec createMediaCodec() throws IOException;

    protected void drain(boolean z16) {
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return;
        }
        if (z16) {
            signalEndOfInputStream(mediaCodec);
        }
        MediaMuxerController mediaMuxerController = this.mMuxerController;
        ByteBuffer[] outputBuffers = this.mMediaCodec.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (z16) {
                    Logger.i(TAG, "no output available, spinning to await EOS");
                } else {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                Logger.i(TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
                outputBuffers = this.mMediaCodec.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                Logger.i(TAG, "INFO_OUTPUT_FORMAT_CHANGED");
                if (!this.mMuxerStarted) {
                    this.mTrackIndex = mediaMuxerController.addTrack(this, this.mMediaCodec.getOutputFormat());
                    this.mMuxerStarted = true;
                    mediaMuxerController.notifyReady(this);
                    if (!mediaMuxerController.waitForStarted(5000L)) {
                        throw new IllegalStateException("muxer has not been started within 5000 millis");
                    }
                } else {
                    throw new IllegalStateException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Logger.w(TAG, "drain:unexpected result from encoder#dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    Logger.w(TAG, "encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    return;
                }
                if ((this.mBufferInfo.flags & 2) != 0) {
                    Logger.i(TAG, "drain:BUFFER_FLAG_CODEC_CONFIG");
                    this.mBufferInfo.size = 0;
                }
                MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                if (bufferInfo.size != 0) {
                    if (this.mMuxerStarted) {
                        mediaMuxerController.writeSampleData(this.mTrackIndex, byteBuffer, bufferInfo);
                    } else {
                        throw new IllegalStateException("drain:muxer hasn't started");
                    }
                } else if (z16 && !this.mMuxerStarted) {
                    Logger.w(TAG, "drain:muxer hasn't started, endOfStream, encoderStatus: " + dequeueOutputBuffer);
                    return;
                }
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                if ((this.mBufferInfo.flags & 4) != 0) {
                    if (!z16) {
                        Logger.w(TAG, "reached end of stream unexpectedly");
                        return;
                    } else {
                        Logger.i(TAG, "end of stream reached");
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void encode(ByteBuffer byteBuffer, int i3, long j3) {
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return;
        }
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            if (i3 <= 0) {
                Logger.i(TAG, "send BUFFER_FLAG_END_OF_STREAM");
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, j3, 4);
            } else {
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i3, j3, 0);
            }
        }
    }

    public boolean frameAvailableSoon() {
        synchronized (this.mSync) {
            if (this.mRequestRelease) {
                return false;
            }
            this.mRequestDrain++;
            this.mSync.notifyAll();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getPTSUs() {
        return (System.nanoTime() - this.mMuxerController.getStoppingNanos()) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void prepare() throws IOException {
        Logger.i(TAG, "prepare, MediaEncoder: " + this);
        MediaCodec createMediaCodec = createMediaCodec();
        this.mMediaCodec = createMediaCodec;
        onMediaCodecCreated(createMediaCodec);
        Logger.i(TAG, "prepare finishing, MediaEncoder: " + this);
        this.mEncoderThread = new BaseThread(this, getClass().getSimpleName());
        this.mEncoderThread.start();
        synchronized (this.mSync) {
            try {
                LockMethodProxy.wait(this.mSync);
            } catch (InterruptedException e16) {
                Logger.d(TAG, "MediaEncoder thread interrupted", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release(boolean z16) {
        Logger.d(TAG, "release, MediaEncoder: " + this);
        synchronized (this.mSync) {
            if (this.mRequestRelease) {
                return;
            }
            this.mRequestRelease = true;
            this.mSync.notifyAll();
            if (z16) {
                try {
                    this.mEncoderThread.join();
                } catch (InterruptedException e16) {
                    Logger.e(TAG, "release interrupted", e16);
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        boolean z17;
        Logger.i(TAG, "Encoder thread starts, MediaEncoder: " + this);
        synchronized (this.mSync) {
            this.mRequestRelease = false;
            this.mRequestDrain = 0;
            this.mSync.notify();
        }
        while (true) {
            synchronized (this.mSync) {
                z16 = this.mRequestRelease;
                int i3 = this.mRequestDrain;
                if (i3 > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    this.mRequestDrain = i3 - 1;
                }
                if (!z16 && !z17) {
                    try {
                        LockMethodProxy.wait(this.mSync);
                    } catch (InterruptedException e16) {
                        Logger.d(TAG, "MediaEncoder interrupted, MediaEncoder: " + this, e16);
                    }
                }
            }
            if (z16 || z17) {
                try {
                    drain(z16);
                } catch (Exception e17) {
                    Logger.e(TAG, "drain failed, MediaEncoder: " + this, e17);
                }
                if (z16) {
                    releaseCodec();
                    Logger.i(TAG, "Encoder thread exits, MediaEncoder: " + this);
                    return;
                }
            }
        }
    }

    protected void signalEndOfInputStream(MediaCodec mediaCodec) {
        Logger.d(TAG, "sending EOS to encoder");
        encode(null, 0, getPTSUs());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        Logger.d(TAG, "start, MediaEncoder: " + this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        Logger.d(TAG, "stop, MediaEncoder: " + this);
    }

    protected void onMediaCodecCreated(MediaCodec mediaCodec) {
    }
}
