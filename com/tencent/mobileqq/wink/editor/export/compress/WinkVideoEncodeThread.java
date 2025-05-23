package com.tencent.mobileqq.wink.editor.export.compress;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkVideoEncodeThread extends BaseThread {
    private MediaCodec C;
    private WinkMuxerThread D;
    private AtomicBoolean E;
    private CountDownLatch F;
    private Exception G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private String M;
    private MediaExtractor N;
    private int P;
    private volatile CountDownLatch Q;
    private volatile Surface R;
    private n63.a S;
    private boolean T;
    private c U;

    public WinkVideoEncodeThread(c cVar, MediaExtractor mediaExtractor, WinkMuxerThread winkMuxerThread, int i3, int i16, int i17, int i18, int i19, String str, int i26, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        super("WinkVideoEncodeThread");
        this.T = false;
        this.D = winkMuxerThread;
        this.U = cVar;
        this.E = atomicBoolean;
        this.F = countDownLatch;
        this.N = mediaExtractor;
        this.H = i3;
        this.J = i17;
        this.I = i16;
        this.K = i18;
        this.P = i26;
        this.L = i19;
        this.M = str;
        this.Q = new CountDownLatch(1);
    }

    private void c(MediaCodec mediaCodec, String str, MediaFormat mediaFormat) {
        w53.b.f("WinkPublish-NCompress-WinkVideoEncodeThread", "mEncoder:" + mediaCodec.getName());
        QLog.i("WinkPublish-NCompress-WinkVideoEncodeThread", 1, "supportProfileHigh:" + a.o(mediaCodec, str, mediaFormat, 8, 512));
        int i3 = a.i(mediaCodec, str);
        if (i3 > 0 && this.H > i3) {
            QLog.e("WinkPublish-NCompress-WinkVideoEncodeThread", 1, this.H + " bitrate too large,set to:" + i3);
            this.H = (int) (((float) i3) * 0.9f);
        }
        mediaFormat.setInteger("bitrate", this.H);
        mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
        this.R = mediaCodec.createInputSurface();
        mediaCodec.start();
    }

    private void o() throws IOException {
        String str;
        String str2;
        r();
        this.Q.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i3 = (int) (1000000.0f / this.L);
        int i16 = -1;
        int i17 = -1;
        boolean z16 = false;
        int i18 = 0;
        boolean z17 = false;
        long j3 = -1;
        while (true) {
            if (this.T) {
                break;
            }
            if (this.E.get() && !z16) {
                this.C.signalEndOfInputStream();
                z16 = true;
            }
            int dequeueOutputBuffer = this.C.dequeueOutputBuffer(bufferInfo, 10000L);
            if (z16 && dequeueOutputBuffer == i16) {
                i18++;
                if (i18 > 10) {
                    QLog.e("WinkPublish-NCompress-WinkVideoEncodeThread", 1, "try again = " + i18);
                    break;
                }
            } else {
                i18 = 0;
            }
            if (dequeueOutputBuffer != i16) {
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.C.getOutputFormat();
                    if (i17 == i16) {
                        i17 = this.D.d(outputFormat);
                        this.D.p();
                        this.F.countDown();
                    }
                    QLog.e("WinkPublish-NCompress-WinkVideoEncodeThread", 1, "encode newFormat = " + outputFormat);
                } else if (dequeueOutputBuffer < 0) {
                    QLog.e("WinkPublish-NCompress-WinkVideoEncodeThread", 1, "unexpected dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer outputBuffer = this.C.getOutputBuffer(dequeueOutputBuffer);
                    if (bufferInfo.flags == 4) {
                        str2 = "WinkPublish-NCompress-WinkVideoEncodeThread";
                        if (bufferInfo.presentationTimeUs < 0) {
                            bufferInfo.presentationTimeUs = 0L;
                        }
                    } else {
                        str2 = "WinkPublish-NCompress-WinkVideoEncodeThread";
                    }
                    if (!z17 && j3 != -1 && bufferInfo.presentationTimeUs < (i3 / 2) + j3) {
                        str = str2;
                        QLog.e(str, 1, "lastVideoFrameTimeUs:" + j3 + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs + " VIDEO_FRAME_TIME_US:" + i3);
                        z17 = true;
                    } else {
                        str = str2;
                    }
                    if (z17) {
                        bufferInfo.presentationTimeUs = i3 + j3;
                        QLog.e(str, 1, "video :" + bufferInfo.presentationTimeUs);
                        z17 = false;
                    }
                    if (bufferInfo.flags != 2) {
                        j3 = bufferInfo.presentationTimeUs;
                    }
                    this.D.c(new n63.b(i17, outputBuffer, bufferInfo));
                    s(bufferInfo);
                    this.C.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (bufferInfo.flags == 4) {
                        QLog.e(str, 1, "encoderDone");
                        break;
                    }
                    i16 = -1;
                }
                i16 = -1;
            }
        }
        str = "WinkPublish-NCompress-WinkVideoEncodeThread";
        QLog.e(str, 1, "Video Encode Done!");
    }

    private void r() throws IOException {
        String str;
        if ("video/hevc".equals(this.M) && a.k()) {
            str = "video/hevc";
        } else {
            str = "video/avc";
        }
        QLog.e("WinkPublish-NCompress-WinkVideoEncodeThread", 1, "mimeType = " + str);
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, this.I, this.J);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("frame-rate", this.L);
        createVideoFormat.setInteger("i-frame-interval", this.K);
        if (str.equals("video/hevc")) {
            createVideoFormat.setInteger("profile", 2);
            createVideoFormat.setInteger("level", 16384);
            createVideoFormat.setInteger("color-standard", 6);
            createVideoFormat.setInteger("color-transfer", 6);
            createVideoFormat.setInteger("color-range", 2);
        }
        try {
            MediaCodec e16 = a.e(createVideoFormat, 0);
            this.C = e16;
            c(e16, str, createVideoFormat);
        } catch (Exception e17) {
            w53.b.d("WinkPublish-NCompress-WinkVideoEncodeThread", "initEncoder error", e17);
            if (uq3.c.X4()) {
                MediaCodec mediaCodec = this.C;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                MediaCodec e18 = a.e(createVideoFormat, 1);
                this.C = e18;
                c(e18, str, createVideoFormat);
                return;
            }
            throw e17;
        }
    }

    private void s(MediaCodec.BufferInfo bufferInfo) {
        long j3;
        n63.a aVar = this.S;
        if (aVar == null) {
            return;
        }
        if ((bufferInfo.flags & 4) > 0) {
            j3 = Long.MAX_VALUE;
        } else {
            j3 = bufferInfo.presentationTimeUs;
        }
        aVar.b(j3);
    }

    public void cancel() {
        this.T = true;
        if (this.Q != null) {
            this.Q.countDown();
        }
    }

    public Exception getException() {
        return this.G;
    }

    public CountDownLatch p() {
        return this.Q;
    }

    public Surface q() {
        return this.R;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0019, code lost:
    
        if (r2 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001c, code lost:
    
        r4.G = r2;
        w53.b.e("WinkPublish-NCompress-WinkVideoEncodeThread", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0041, code lost:
    
        if (r2 != null) goto L12;
     */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Exception exc;
        super.run();
        try {
            try {
                o();
                try {
                    MediaCodec mediaCodec = this.C;
                    if (mediaCodec != null) {
                        mediaCodec.stop();
                        this.C.release();
                    }
                } catch (Exception e16) {
                    e = e16;
                    exc = this.G;
                }
            } catch (Exception e17) {
                w53.b.e("WinkPublish-NCompress-WinkVideoEncodeThread", e17);
                this.G = e17;
                this.U.q();
                try {
                    if (this.C != null) {
                        this.C.stop();
                        this.C.release();
                    }
                } catch (Exception e18) {
                    e = e18;
                    exc = this.G;
                }
            }
        } catch (Throwable th5) {
            try {
                MediaCodec mediaCodec2 = this.C;
                if (mediaCodec2 != null) {
                    mediaCodec2.stop();
                    this.C.release();
                }
            } catch (Exception e19) {
                Exception exc2 = this.G;
                if (exc2 == null) {
                    exc2 = e19;
                }
                this.G = exc2;
                w53.b.e("WinkPublish-NCompress-WinkVideoEncodeThread", e19);
            }
            throw th5;
        }
    }

    public void t(n63.a aVar) {
        this.S = aVar;
    }
}
