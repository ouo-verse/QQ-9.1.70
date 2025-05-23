package com.tencent.mobileqq.wink.editor.export.compress;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.mediacodec.InputSurface;
import com.tencent.richmedia.videocompress.mediacodec.OutputSurface;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import n63.d;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkVideoDecodeThread extends BaseThread {
    private MediaExtractor C;
    private MediaCodec D;
    private AtomicBoolean E;
    private Exception F;
    private int G;
    private WinkVideoEncodeThread H;
    private InputSurface I;
    private OutputSurface J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private int P;
    private d Q;
    private c R;

    public WinkVideoDecodeThread(c cVar, WinkVideoEncodeThread winkVideoEncodeThread, MediaExtractor mediaExtractor, int i3, AtomicBoolean atomicBoolean, int i16, int i17, int i18, int i19) {
        super("WinkVideoDecodeThread");
        this.K = false;
        this.C = mediaExtractor;
        this.G = i3;
        this.E = atomicBoolean;
        this.H = winkVideoEncodeThread;
        this.R = cVar;
        this.L = i16;
        this.M = i17;
        this.N = i18;
        this.P = i19;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o() throws IOException {
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        boolean z18;
        int i17;
        int i18;
        boolean z19;
        int i19;
        int i26;
        try {
            if (!this.H.p().await(5L, TimeUnit.SECONDS)) {
                this.F = new TimeoutException("wait eglContext timeout!");
                return;
            }
            InputSurface inputSurface = new InputSurface(this.H.q());
            this.I = inputSurface;
            inputSurface.makeCurrent();
            p();
            int i27 = this.N;
            if (i27 != 0 && (i26 = this.P) != 0 && i27 > i26) {
                this.Q = new d(i27, i26);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int i28 = 0;
            int i29 = 0;
            boolean z26 = false;
            int i36 = 0;
            int i37 = 0;
            long j3 = -1;
            while (true) {
                int i38 = 1;
                if (i29 != 0 || this.K) {
                    break;
                }
                int i39 = -1;
                if (!z26) {
                    int sampleTrackIndex = this.C.getSampleTrackIndex();
                    if (sampleTrackIndex == this.G) {
                        int dequeueInputBuffer = this.D.dequeueInputBuffer(10000L);
                        if (dequeueInputBuffer >= 0) {
                            int readSampleData = this.C.readSampleData(this.D.getInputBuffer(dequeueInputBuffer), i28);
                            if (readSampleData < 0) {
                                this.D.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                                i29 = 1;
                            } else {
                                this.D.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.C.getSampleTime(), 0);
                                this.C.advance();
                            }
                        }
                    } else if (sampleTrackIndex == -1) {
                        i19 = 1;
                        if (i19 != 0) {
                            QLog.i("WinkPublish-NCompress-WinkVideoDecodeThread", 1, "inputDone");
                            int dequeueInputBuffer2 = this.D.dequeueInputBuffer(10000L);
                            if (dequeueInputBuffer2 >= 0) {
                                this.D.queueInputBuffer(dequeueInputBuffer2, 0, 0, 0L, 4);
                                z26 = true;
                            }
                        }
                    }
                    i19 = i28;
                    if (i19 != 0) {
                    }
                }
                boolean z27 = i29 ^ 1;
                if (i29 != 0) {
                    QLog.i("WinkPublish-NCompress-WinkVideoDecodeThread", 1, "decoderOutputAvailable:" + z27);
                }
                while (true) {
                    if (z27 != 0) {
                        int dequeueOutputBuffer = this.D.dequeueOutputBuffer(bufferInfo, 10000L);
                        if (z26 && dequeueOutputBuffer == i39) {
                            i36++;
                            if (i36 > 10) {
                                QLog.e("WinkPublish-NCompress-WinkVideoDecodeThread", i38, " tryAgain 10 times,force End!");
                                i3 = i28;
                                z16 = z26;
                                i29 = i38;
                                break;
                            }
                        } else {
                            i36 = i28;
                        }
                        if (dequeueOutputBuffer == i39) {
                            i3 = i28;
                            z16 = z26;
                            break;
                        }
                        if (dequeueOutputBuffer == -2) {
                            QLog.i("WinkPublish-NCompress-WinkVideoDecodeThread", i38, "decode newFormat = " + this.D.getOutputFormat());
                        } else if (dequeueOutputBuffer < 0) {
                            QLog.e("WinkPublish-NCompress-WinkVideoDecodeThread", i38, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                        } else {
                            boolean z28 = z26;
                            if (this.M > 0 && bufferInfo.presentationTimeUs >= r13 * 1000) {
                                bufferInfo.flags |= 4;
                                z18 = false;
                                i16 = 1;
                                z17 = true;
                            } else {
                                i16 = i29;
                                z17 = z28;
                                z18 = true;
                            }
                            if (this.L > 0) {
                                i17 = i16;
                                z16 = z17;
                                if (bufferInfo.presentationTimeUs < r12 * 1000) {
                                    i18 = 4;
                                    QLog.d("WinkPublish-NCompress-WinkVideoDecodeThread", 4, "drop frame startTime = " + this.L + " present time = " + (bufferInfo.presentationTimeUs / 1000));
                                    z18 = false;
                                } else {
                                    i18 = 4;
                                }
                            } else {
                                i17 = i16;
                                z16 = z17;
                                i18 = 4;
                            }
                            if (bufferInfo.flags == i18) {
                                this.D.releaseOutputBuffer(dequeueOutputBuffer, false);
                                QLog.i("WinkPublish-NCompress-WinkVideoDecodeThread", 1, "decoderDone");
                                i29 = 1;
                                i3 = 0;
                                break;
                            }
                            d dVar = this.Q;
                            if (dVar != null && dVar.a(i37)) {
                                QLog.d("WinkPublish-NCompress-WinkVideoDecodeThread", 4, "drop" + i37);
                                z18 = false;
                            }
                            i37++;
                            this.D.releaseOutputBuffer(dequeueOutputBuffer, z18);
                            if (z18) {
                                try {
                                    this.J.awaitNewImage();
                                    i3 = 0;
                                    z19 = false;
                                } catch (Exception e16) {
                                    i3 = 0;
                                    QLog.e("WinkPublish-NCompress-WinkVideoDecodeThread", 1, e16, new Object[0]);
                                    z19 = true;
                                }
                                if (!z19) {
                                    if (j3 == -1) {
                                        j3 = bufferInfo.presentationTimeUs;
                                        QLog.i("WinkPublish-NCompress-WinkVideoDecodeThread", 1, "videoStartTime:" + (j3 / 1000));
                                    }
                                    this.J.drawImage();
                                    this.I.setPresentationTime((bufferInfo.presentationTimeUs - j3) * 1000);
                                    this.I.swapBuffers();
                                    i29 = i17;
                                }
                            } else {
                                i3 = 0;
                            }
                            i29 = i17;
                            i28 = i3;
                            z26 = z16;
                            i38 = 1;
                            i39 = -1;
                        }
                        i3 = i28;
                        z16 = z26;
                        i28 = i3;
                        z26 = z16;
                        i38 = 1;
                        i39 = -1;
                    } else {
                        i3 = i28;
                        z16 = z26;
                        break;
                    }
                }
                i28 = i3;
                z26 = z16;
            }
            QLog.i("WinkPublish-NCompress-WinkVideoDecodeThread", 1, "Video Decode Done!");
            this.E.set(true);
        } catch (InterruptedException e17) {
            this.F = e17;
        }
    }

    private void p() throws IOException {
        MediaFormat trackFormat = this.C.getTrackFormat(this.G);
        this.J = new OutputSurface();
        try {
            this.D = a.d(trackFormat, 0);
            w53.b.f("WinkPublish-NCompress-WinkVideoDecodeThread", "mDecoder:" + this.D.getName());
            this.D.configure(trackFormat, this.J.getSurface(), (MediaCrypto) null, 0);
            this.D.start();
        } catch (Exception e16) {
            w53.b.d("WinkPublish-NCompress-WinkVideoDecodeThread", "initDecoder error", e16);
            if (uq3.c.X4()) {
                MediaCodec mediaCodec = this.D;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                this.D = a.d(trackFormat, 1);
                w53.b.f("WinkPublish-NCompress-WinkVideoDecodeThread", "mDecoder:" + this.D.getName());
                this.D.configure(trackFormat, this.J.getSurface(), (MediaCrypto) null, 0);
                this.D.start();
                return;
            }
            throw e16;
        }
    }

    public void cancel() {
        this.K = true;
    }

    public Exception getException() {
        return this.F;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            try {
                o();
                InputSurface inputSurface = this.I;
                if (inputSurface != null) {
                    inputSurface.release();
                }
                OutputSurface outputSurface = this.J;
                if (outputSurface != null) {
                    outputSurface.release();
                }
                try {
                    MediaCodec mediaCodec = this.D;
                    if (mediaCodec != null) {
                        mediaCodec.stop();
                        this.D.release();
                    }
                } catch (Exception e16) {
                    Exception exc = this.F;
                    if (exc == null) {
                        exc = e16;
                    }
                    this.F = exc;
                    QLog.e("WinkPublish-NCompress-WinkVideoDecodeThread", 1, e16, new Object[0]);
                }
            } catch (Exception e17) {
                QLog.e("WinkPublish-NCompress-WinkVideoDecodeThread", 1, e17, new Object[0]);
                this.F = e17;
                this.R.q();
                if (this.I != null) {
                    this.I.release();
                }
                OutputSurface outputSurface2 = this.J;
                if (outputSurface2 != null) {
                    outputSurface2.release();
                }
                try {
                    MediaCodec mediaCodec2 = this.D;
                    if (mediaCodec2 != null) {
                        mediaCodec2.stop();
                        this.D.release();
                    }
                } catch (Exception e18) {
                    Exception exc2 = this.F;
                    if (exc2 == null) {
                        exc2 = e18;
                    }
                    this.F = exc2;
                    QLog.e("WinkPublish-NCompress-WinkVideoDecodeThread", 1, e18, new Object[0]);
                }
            }
            this.E.set(true);
        } catch (Throwable th5) {
            InputSurface inputSurface2 = this.I;
            if (inputSurface2 != null) {
                inputSurface2.release();
            }
            OutputSurface outputSurface3 = this.J;
            if (outputSurface3 != null) {
                outputSurface3.release();
            }
            try {
                MediaCodec mediaCodec3 = this.D;
                if (mediaCodec3 != null) {
                    mediaCodec3.stop();
                    this.D.release();
                }
            } catch (Exception e19) {
                Exception exc3 = this.F;
                if (exc3 == null) {
                    exc3 = e19;
                }
                this.F = exc3;
                QLog.e("WinkPublish-NCompress-WinkVideoDecodeThread", 1, e19, new Object[0]);
            }
            this.E.set(true);
            throw th5;
        }
    }
}
