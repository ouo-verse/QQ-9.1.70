package com.tencent.mobileqq.triton.screenrecord.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class MediaMuxerController {
    private static final boolean DEBUG = true;
    private static final int STATE_INIT = 0;
    private static final int STATE_PREPARED = 1;
    private static final int STATE_RELEASED = 4;
    private static final int STATE_STARTED = 2;
    private static final int STATE_STOPPED = 3;
    private static final String TAG = "MediaMuxerController";
    private volatile Callback mCallback;
    private boolean mIsStarted;
    private long mLastStoppedTime;
    private MediaMuxer mMediaMuxer;
    private final File mOutputPath;
    private long mStoppingNanos;
    private int mState = 0;
    private Map<MediaEncoder, EncoderStatus> mEncoders = new HashMap();
    private final Object mLock = new Object();

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface Callback {
        void onError(Exception exc);

        void onReady();

        void onReleased(File file);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class EncoderStatus {
        boolean mReady;
        boolean mReleased;

        EncoderStatus() {
        }
    }

    public MediaMuxerController(File file) {
        this.mOutputPath = file;
    }

    private void accumulateStoppingNanos() {
        if (this.mLastStoppedTime > 0) {
            this.mStoppingNanos += System.nanoTime() - this.mLastStoppedTime;
            this.mLastStoppedTime = 0L;
        }
    }

    private MediaMuxer createMediaMuxer() throws IOException {
        return new MediaMuxer(this.mOutputPath.getAbsolutePath(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addEncoder(MediaEncoder mediaEncoder) {
        synchronized (this.mLock) {
            if (this.mState == 0) {
                this.mEncoders.put(mediaEncoder, new EncoderStatus());
            } else {
                throw new IllegalStateException("current state must be STATE_INIT");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int addTrack(MediaEncoder mediaEncoder, MediaFormat mediaFormat) {
        synchronized (this.mLock) {
            if (this.mIsStarted) {
                throw new IllegalStateException("MediaMuxer has been started");
            }
        }
        int addTrack = this.mMediaMuxer.addTrack(mediaFormat);
        Logger.i(TAG, "addTrack, encoder=" + mediaEncoder + ",trackIx=" + addTrack + ",format=" + mediaFormat);
        return addTrack;
    }

    public File getOutputFile() {
        return this.mOutputPath;
    }

    public long getStoppingNanos() {
        return this.mStoppingNanos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyReady(MediaEncoder mediaEncoder) {
        Logger.d(TAG, "notifyReady, encoder=" + mediaEncoder);
        synchronized (this.mLock) {
            EncoderStatus encoderStatus = this.mEncoders.get(mediaEncoder);
            if (encoderStatus != null && !encoderStatus.mReady) {
                encoderStatus.mReady = true;
                Iterator<EncoderStatus> it = this.mEncoders.values().iterator();
                while (it.hasNext()) {
                    if (!it.next().mReady) {
                        return;
                    }
                }
                this.mMediaMuxer.start();
                this.mIsStarted = true;
                this.mLock.notifyAll();
                if (this.mCallback != null) {
                    this.mCallback.onReady();
                }
                Logger.d(TAG, "MediaMuxer started");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyReleased(MediaEncoder mediaEncoder) {
        Logger.d(TAG, "notifyReleased, encoder=" + mediaEncoder);
        synchronized (this.mLock) {
            EncoderStatus encoderStatus = this.mEncoders.get(mediaEncoder);
            if (encoderStatus != null && !encoderStatus.mReleased) {
                boolean z16 = true;
                encoderStatus.mReleased = true;
                Iterator<EncoderStatus> it = this.mEncoders.values().iterator();
                while (it.hasNext()) {
                    if (!it.next().mReleased) {
                        return;
                    }
                }
                if (!this.mIsStarted) {
                    Logger.w(TAG, "notifyReleased, mIsStarted=false");
                } else {
                    z16 = false;
                }
                this.mIsStarted = false;
                if (!z16) {
                    this.mMediaMuxer.stop();
                    this.mMediaMuxer.release();
                    if (this.mCallback != null) {
                        this.mCallback.onReleased(this.mOutputPath);
                    }
                } else if (this.mCallback != null) {
                    this.mCallback.onError(new IllegalStateException("MediaMuxer has not been started"));
                }
                Logger.d(TAG, "MediaMuxer released");
            }
        }
    }

    public void prepare() throws IOException {
        synchronized (this.mLock) {
            if (this.mState == 0) {
                this.mState = 1;
            } else {
                throw new IllegalStateException("current state must be STATE_INIT");
            }
        }
        this.mMediaMuxer = createMediaMuxer();
        Iterator<MediaEncoder> it = this.mEncoders.keySet().iterator();
        while (it.hasNext()) {
            it.next().prepare();
        }
    }

    public void release(boolean z16) {
        synchronized (this.mLock) {
            int i3 = this.mState;
            if (i3 == 4) {
                return;
            }
            if (i3 == 3) {
                this.mState = 4;
                Iterator<MediaEncoder> it = this.mEncoders.keySet().iterator();
                while (it.hasNext()) {
                    it.next().release(z16);
                }
                return;
            }
            throw new IllegalStateException("current state must be STATE_STOPPED, mState=" + this.mState);
        }
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void start() {
        synchronized (this.mLock) {
            int i3 = this.mState;
            if (i3 == 2) {
                return;
            }
            if (i3 != 1 && i3 != 3) {
                throw new IllegalStateException("current state must be STATE_PREPARED or STATE_STOPPED");
            }
            this.mState = 2;
            accumulateStoppingNanos();
            Iterator<MediaEncoder> it = this.mEncoders.keySet().iterator();
            while (it.hasNext()) {
                it.next().start();
            }
        }
    }

    public void stop() {
        synchronized (this.mLock) {
            int i3 = this.mState;
            if (i3 == 3) {
                return;
            }
            if (i3 == 2) {
                this.mState = 3;
                this.mLastStoppedTime = System.nanoTime();
                Iterator<MediaEncoder> it = this.mEncoders.keySet().iterator();
                while (it.hasNext()) {
                    it.next().stop();
                }
                return;
            }
            throw new IllegalStateException("current state must be STATE_STARTED, mState=" + this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean waitForStarted(long j3) {
        boolean z16;
        synchronized (this.mLock) {
            if (!this.mIsStarted) {
                try {
                    this.mLock.wait(j3);
                } catch (InterruptedException e16) {
                    Logger.d(TAG, "waitForStarted interrupted", e16);
                }
            }
            z16 = this.mIsStarted;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeSampleData(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.mMediaMuxer.writeSampleData(i3, byteBuffer, bufferInfo);
    }
}
