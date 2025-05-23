package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class MediaCodecWrapper {
    private static final int MAX_RETRY_COUNT = 10;
    private static final long WAIT_TRANSIENT_MS = 20;
    private final String TAG = "MediaCodecWrapper@" + Integer.toHexString(hashCode());
    private MediaCodec mediaCodec;
    private final VideoDecoder videoDecoder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaCodecWrapper(VideoDecoder videoDecoder) {
        this.videoDecoder = videoDecoder;
    }

    private boolean isLollipop() {
        return true;
    }

    private void resetMediaCodec(MediaFormat mediaFormat) throws IOException {
        if (isLollipop()) {
            this.mediaCodec.reset();
            return;
        }
        try {
            this.mediaCodec.stop();
        } catch (Exception unused) {
        }
        MediaCodecManager.releaseCodec(this.mediaCodec);
        this.mediaCodec = MediaCodecManager.createDecoder(mediaFormat);
    }

    private void tryLogMediaCodecError(MediaCodec.CodecException codecException) {
        Logger.e(this.TAG, "CodecException - isTransient = " + codecException.isTransient() + " , isRecoverable = " + codecException.isRecoverable() + " , errorCode = " + codecException.getErrorCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean decoderConfigure(MediaFormat mediaFormat, Surface surface) throws IOException {
        Logger.i(this.TAG, "decoderConfigure() called with: inputFormat = [" + mediaFormat + "], outputSurface = [" + surface + "]");
        this.mediaCodec = MediaCodecManager.createDecoder(mediaFormat);
        int i3 = 0;
        while (true) {
            i3++;
            try {
                Logger.d(this.TAG, "createdDecoder---time---" + i3);
                if (i3 > 10) {
                    return false;
                }
                this.mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
                Logger.i(this.TAG, "decoderConfigure() called with: outputFormat = [" + this.mediaCodec.getOutputFormat() + "]");
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (!(e16 instanceof MediaCodec.CodecException) || (!((MediaCodec.CodecException) e16).isTransient() && !((MediaCodec.CodecException) e16).isRecoverable())) {
                    MediaCodecManager.releaseCodec(this.mediaCodec);
                    throw e16;
                }
            }
        }
        MediaCodecManager.releaseCodec(this.mediaCodec);
        throw e16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int dequeueInputBuffer() {
        try {
            return this.mediaCodec.dequeueInputBuffer(1000L);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "dequeueInputBuffer", e16);
            if (isLollipop() && (e16 instanceof MediaCodec.CodecException)) {
                tryLogMediaCodecError((MediaCodec.CodecException) e16);
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    return dequeueInputBuffer();
                }
            }
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo) {
        try {
        } catch (Exception e16) {
            Logger.e(this.TAG, "dequeueOutputBuffer", e16);
            if (isLollipop() && (e16 instanceof MediaCodec.CodecException)) {
                tryLogMediaCodecError((MediaCodec.CodecException) e16);
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    return dequeueOutputBuffer(bufferInfo);
                }
            }
            throw e16;
        }
        return this.mediaCodec.dequeueOutputBuffer(bufferInfo, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flushDecoder() {
        this.mediaCodec.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ByteBuffer getInputBuffer(int i3) {
        try {
            return DecoderUtils.getInputBuffer(this.mediaCodec, i3);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "getInputBuffer", e16);
            if (isLollipop() && (e16 instanceof MediaCodec.CodecException)) {
                tryLogMediaCodecError((MediaCodec.CodecException) e16);
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    return getInputBuffer(i3);
                }
            }
            throw e16;
        }
    }

    public MediaCodec getMediaCodec() {
        return this.mediaCodec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ByteBuffer getOnputBuffer(int i3) {
        try {
            return DecoderUtils.getOutputBuffer(this.mediaCodec, i3);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "getOutputBuffer", e16);
            if (isLollipop() && (e16 instanceof MediaCodec.CodecException)) {
                tryLogMediaCodecError((MediaCodec.CodecException) e16);
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    return getOnputBuffer(i3);
                }
            }
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void queueInputBuffer(int i3, int i16, int i17, long j3, int i18) {
        try {
            this.mediaCodec.queueInputBuffer(i3, i16, i17, j3, i18);
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "queueInputBuffer", e16);
            if (isLollipop() && (e16 instanceof MediaCodec.CodecException)) {
                tryLogMediaCodecError((MediaCodec.CodecException) e16);
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    queueInputBuffer(i3, i16, i17, j3, i18);
                }
            }
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (this.mediaCodec == null) {
            return;
        }
        ThreadPool.execute(new Runnable() { // from class: com.tencent.tav.decoder.MediaCodecWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        MediaCodecWrapper.this.videoDecoder.releaseOutputBuffer();
                        MediaCodecWrapper.this.mediaCodec.stop();
                        MediaCodecManager.releaseCodec(MediaCodecWrapper.this.mediaCodec);
                    } catch (Exception e16) {
                        Logger.e(MediaCodecWrapper.this.TAG, "release: ", e16);
                    }
                    MediaCodecWrapper.this.mediaCodec = null;
                } finally {
                    MediaCodecWrapper.this.mediaCodec = null;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void releaseOutputBuffer(int i3, boolean z16) {
        try {
            this.mediaCodec.releaseOutputBuffer(i3, z16);
            if (z16) {
                this.videoDecoder.lastFrameValid = true;
            }
        } catch (Error | Exception e16) {
            Logger.e(this.TAG, "releaseOutputBuffer", e16);
            if (isLollipop() && (e16 instanceof MediaCodec.CodecException)) {
                tryLogMediaCodecError((MediaCodec.CodecException) e16);
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    releaseOutputBuffer(i3, z16);
                }
            }
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void reset(Surface surface, MediaFormat mediaFormat) {
        if (this.videoDecoder.isReleased) {
            return;
        }
        Logger.d(this.TAG, "reset");
        try {
            resetMediaCodec(mediaFormat);
            decoderConfigure(mediaFormat, surface);
            startDecoder(surface, mediaFormat);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void startDecoder(Surface surface, MediaFormat mediaFormat) {
        try {
            this.mediaCodec.start();
        } catch (Exception e16) {
            Logger.e(this.TAG, "startDecoder, mediaFormat:" + mediaFormat.toString(), e16);
            if (isLollipop() && (e16 instanceof MediaCodec.CodecException)) {
                tryLogMediaCodecError((MediaCodec.CodecException) e16);
                if (((MediaCodec.CodecException) e16).isTransient()) {
                    waitTime(20L);
                    startDecoder(surface, mediaFormat);
                    return;
                } else if (((MediaCodec.CodecException) e16).isRecoverable()) {
                    reset(surface, mediaFormat);
                    return;
                }
            }
            this.videoDecoder.release(false);
            throw e16;
        }
    }

    synchronized void waitTime(long j3) {
        try {
            this.videoDecoder.wait(j3);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }
}
