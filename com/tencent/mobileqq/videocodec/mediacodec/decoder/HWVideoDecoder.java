package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes20.dex */
public class HWVideoDecoder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private b f312530a;

    /* renamed from: b, reason: collision with root package name */
    private Thread f312531b;

    /* renamed from: c, reason: collision with root package name */
    private DecodeRunnable f312532c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class DecodeRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        @NonNull
        private final d C;
        ByteBuffer[] D;
        ByteBuffer[] E;
        MediaCodec.BufferInfo F;
        private boolean G;
        private boolean H;
        boolean I;
        long J;
        private long K;
        private long L;
        private final AtomicLong M;
        private final AtomicLong N;
        private boolean P;
        public final long Q;
        private final a R;
        private final a S;
        private volatile boolean T;
        private final Object U;
        private final String V;

        /* renamed from: d, reason: collision with root package name */
        private String f312533d;

        /* renamed from: e, reason: collision with root package name */
        private MediaExtractor f312534e;

        /* renamed from: f, reason: collision with root package name */
        private MediaCodec f312535f;

        /* renamed from: h, reason: collision with root package name */
        private Surface f312536h;

        /* renamed from: i, reason: collision with root package name */
        private int f312537i;

        /* renamed from: m, reason: collision with root package name */
        private int f312538m;

        public DecodeRunnable(@NonNull String str, Surface surface, d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, surface, dVar);
                return;
            }
            this.f312533d = "HWVideoDecoder.DecodeRunnable";
            this.G = false;
            this.H = false;
            this.I = false;
            this.J = System.currentTimeMillis();
            this.K = 0L;
            this.L = 0L;
            this.M = new AtomicLong(-1L);
            this.N = new AtomicLong(-1L);
            this.P = false;
            this.T = false;
            this.U = new Object();
            this.f312533d = "HWVideoDecoder.DecodeRunnable." + hashCode();
            hd0.c.l("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: %s", str);
            this.f312536h = surface;
            this.C = dVar == null ? new c() : dVar;
            this.V = str;
            long c16 = com.tencent.mobileqq.editor.composite.util.a.c(str);
            this.Q = c16;
            this.R = new a(str, 0, true, false, 0L, c16);
            this.S = new a(str, 0, true, false, 0L, c16);
        }

        private boolean a(boolean z16, long j3) {
            if (!this.P) {
                return z16;
            }
            if (!z16) {
                return z16;
            }
            if (this.H) {
                return false;
            }
            long j16 = this.N.get();
            if (j16 <= 0) {
                return z16;
            }
            a aVar = this.S;
            if (j16 > aVar.f312543e && j16 < aVar.f312544f) {
                if (j16 > j3) {
                    if (QLog.isColorLevel()) {
                        QLog.d("HWVideoDecoder.DecodeRunnable", 2, "checkToRender, do not render, renderpos:" + j16 + " sampletime:" + j3);
                    }
                    return false;
                }
                this.N.compareAndSet(j16, -1L);
                return z16;
            }
            this.N.compareAndSet(j16, -1L);
            if (QLog.isColorLevel()) {
                QLog.d("HWVideoDecoder.DecodeRunnable", 2, "checkToRender, not in playrange, pos:" + j16 + ": [" + this.S.f312543e + "-" + this.S.f312544f + "]");
            }
            return z16;
        }

        private boolean b(boolean z16) {
            boolean z17;
            int dequeueOutputBuffer = this.f312535f.dequeueOutputBuffer(this.F, 10000L);
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer != -1) {
                        if ((this.F.flags & 4) != 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d(this.f312533d, 2, "output EOS");
                            }
                            this.H = true;
                        }
                        boolean a16 = a(z16, this.K / 1000);
                        if (QLog.isColorLevel()) {
                            QLog.d(this.f312533d, 2, "checkToRender, render :" + a16 + " info.presentationTimeUs:" + (this.F.presentationTimeUs / 1000) + " - " + (System.currentTimeMillis() - this.J));
                        }
                        if (!this.S.f312541c && a16) {
                            while (this.F.presentationTimeUs / 1000 > System.currentTimeMillis() - this.J) {
                                try {
                                    LockMethodProxy.sleep(10L);
                                } catch (InterruptedException e16) {
                                    e16.printStackTrace();
                                    this.I = true;
                                }
                            }
                        }
                        if (a16 && this.F.size != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        this.f312535f.releaseOutputBuffer(dequeueOutputBuffer, z17);
                        if (z17) {
                            try {
                                this.C.a(this.F.presentationTimeUs * 1000);
                            } catch (InterruptedException e17) {
                                e17.printStackTrace();
                                this.I = true;
                            }
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d(this.f312533d, 2, "dequeueOutputBuffer timed out!");
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(this.f312533d, 2, "New format " + this.f312535f.getOutputFormat());
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f312533d, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
                }
                this.E = this.f312535f.getOutputBuffers();
            }
            return true;
        }

        private long c(int i3, long j3, long j16) {
            long j17;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return j3 + j16;
                    }
                    return j3 - j16;
                }
                Long.signum(j16);
                j17 = j16 * 2;
            } else {
                j17 = j16 / 2;
            }
            return j3 + j17;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00c0, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean g() {
            int i3;
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.f312534e = mediaExtractor;
            try {
                mediaExtractor.setDataSource(this.V);
                int i16 = 0;
                while (true) {
                    if (i16 >= this.f312534e.getTrackCount()) {
                        break;
                    }
                    try {
                        MediaFormat trackFormat = this.f312534e.getTrackFormat(i16);
                        String string = trackFormat.getString("mime");
                        if (string.startsWith("video/")) {
                            this.f312537i = trackFormat.getInteger("width");
                            this.f312538m = trackFormat.getInteger("height");
                            this.f312534e.selectTrack(i16);
                            a aVar = this.S;
                            if (aVar.f312546h) {
                                i3 = aVar.f312545g;
                            } else {
                                i3 = 0;
                            }
                            trackFormat.setInteger("rotation-degrees", i3);
                            try {
                                this.f312535f = MediaCodec.createDecoderByType(string);
                                if (this.f312536h.isValid()) {
                                    this.f312535f.configure(trackFormat, this.f312536h, (MediaCrypto) null, 0);
                                } else {
                                    throw new RuntimeException("surface is not valid.");
                                }
                            } catch (Throwable th5) {
                                if (Thread.interrupted()) {
                                    QLog.e(this.f312533d, 2, "Thread is interrupted.", th5);
                                } else {
                                    RuntimeException runtimeException = new RuntimeException(th5);
                                    if (!this.I) {
                                        this.C.onDecodeError(1, runtimeException);
                                    }
                                    QLog.e(this.f312533d, 2, "decode configure error", th5);
                                }
                                return false;
                            }
                        } else {
                            i16++;
                        }
                    } catch (IllegalArgumentException e16) {
                        if (Thread.interrupted()) {
                            QLog.e(this.f312533d, 2, "Thread is interrupted.", e16);
                        } else {
                            this.C.onDecodeError(1, new RuntimeException(e16));
                            QLog.e(this.f312533d, 2, "decode configure getTrackFormat error", e16);
                        }
                        return false;
                    }
                }
            } catch (IOException e17) {
                e17.printStackTrace();
                return false;
            }
        }

        private void h(boolean z16) {
            if (!this.G) {
                i();
            }
            if (!this.H) {
                b(z16);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b1, code lost:
        
            if (r1 < r9) goto L36;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean i() {
            long j3;
            int dequeueInputBuffer = this.f312535f.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = this.D[dequeueInputBuffer];
                if (this.S.f312540b == 3) {
                    long j16 = this.K - 1000;
                    if ("xiaomi".equalsIgnoreCase(Build.MANUFACTURER) && "MI 6".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                        MediaExtractor mediaExtractor = this.f312534e;
                        if (j16 < 0) {
                            j16 = 0;
                        }
                        mediaExtractor.seekTo(j16, 1);
                    } else {
                        MediaExtractor mediaExtractor2 = this.f312534e;
                        if (j16 < 0) {
                            j16 = 0;
                        }
                        mediaExtractor2.seekTo(j16, 0);
                    }
                }
                int readSampleData = this.f312534e.readSampleData(byteBuffer, 0);
                long sampleTime = this.f312534e.getSampleTime();
                a aVar = this.S;
                long j17 = aVar.f312543e * 1000;
                long j18 = aVar.f312544f * 1000;
                if (QLog.isColorLevel()) {
                    QLog.d("HWVideoDecoder.DecodeRunnable", 2, "intput sampleTime = " + sampleTime + " sampleSize = " + readSampleData + " endTime = " + j18);
                }
                if (readSampleData >= 0 && (j18 <= 0 || sampleTime <= j18)) {
                    int i3 = this.S.f312540b;
                    if (i3 == 3) {
                        if (j17 > 0) {
                            j3 = j17;
                        } else {
                            j3 = 10000;
                        }
                    }
                    long j19 = sampleTime - this.K;
                    this.K = sampleTime;
                    long c16 = c(i3, this.L, j19);
                    this.L = c16;
                    this.f312535f.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, c16, 0);
                    this.f312534e.advance();
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(this.f312533d, 2, "InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=" + sampleTime + " endTime=" + j18 + " startTime=" + j17 + " sampleSize=" + readSampleData);
                }
                this.f312535f.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                this.G = true;
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.w(this.f312533d, 2, "queueSampleToCodec inIndex = " + dequeueInputBuffer);
            }
            return false;
        }

        private void j() {
            a aVar = this.S;
            if (aVar.f312540b == 3) {
                this.K = aVar.f312544f * 1000;
            } else {
                this.K = 0L;
            }
        }

        private long k(long j3) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.f312535f.flush();
            } catch (RuntimeException e16) {
                QLog.e("HWVideoDecoder.DecodeRunnable", 1, "decoder flush error " + e16.toString());
            }
            this.f312534e.seekTo(j3, 0);
            long sampleTime = this.f312534e.getSampleTime();
            this.C.onDecodeSeekTo(sampleTime / 1000);
            this.J = System.currentTimeMillis();
            this.G = false;
            this.H = false;
            if (sampleTime == -1) {
                j();
            }
            this.K = sampleTime;
            this.L = 0L;
            if (QLog.isColorLevel()) {
                QLog.d(this.f312533d, 4, "end seekTo seekTime=0 timecost=" + (System.currentTimeMillis() - currentTimeMillis) + " seekTargetTimeUs:" + j3 + " realStartTime:" + sampleTime);
            }
            return sampleTime;
        }

        private boolean r() {
            if (this.f312535f == null) {
                QLog.e(this.f312533d, 2, "Can't find video info!");
                return false;
            }
            this.C.onDecodeStart();
            try {
                this.f312535f.start();
                try {
                    this.D = this.f312535f.getInputBuffers();
                    this.E = this.f312535f.getOutputBuffers();
                    this.F = new MediaCodec.BufferInfo();
                    this.J = System.currentTimeMillis();
                    a aVar = this.S;
                    if (aVar.f312540b == 3) {
                        this.K = aVar.f312544f * 1000;
                        return true;
                    }
                    return true;
                } catch (Exception e16) {
                    if (!this.I) {
                        this.C.onDecodeError(2, e16);
                    }
                    QLog.e(this.f312533d, 2, "decode start error2", e16);
                    return false;
                }
            } catch (Throwable th5) {
                if (Thread.interrupted()) {
                    QLog.e(this.f312533d, 2, "Thread is interrupted.", th5);
                } else {
                    RuntimeException runtimeException = new RuntimeException(th5);
                    if (!this.I) {
                        this.C.onDecodeError(2, runtimeException);
                    }
                    QLog.e(this.f312533d, 2, "decode start error", th5);
                }
                return false;
            }
        }

        public int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.f312538m;
        }

        public int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.f312537i;
        }

        public void l(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            } else {
                this.M.set(j3 * 1000);
            }
        }

        public void m(@NonNull a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            if (!TextUtils.equals(this.V, aVar.f312539a)) {
                hd0.c.t("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
            }
            q(aVar.f312540b);
            o(aVar.f312543e, aVar.f312544f);
            p(aVar.f312542d);
            n(aVar.f312541c);
            a aVar2 = this.R;
            aVar2.f312545g = aVar.f312545g;
            aVar2.f312546h = aVar.f312546h;
        }

        public void n(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.R.f312541c = z16;
            }
        }

        public void o(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            if (j3 >= 0 && j16 >= 0) {
                if (j16 >= j3) {
                    long j17 = this.Q;
                    if (j3 >= j17) {
                        hd0.c.i("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=%d, videoDuration=%d", Long.valueOf(j3), Long.valueOf(this.Q));
                        return;
                    }
                    if (j16 > j17) {
                        j16 = j17;
                    }
                    if (j16 != 0) {
                        j17 = j16;
                    }
                    a aVar = this.R;
                    if (j3 == aVar.f312543e && j17 == aVar.f312544f) {
                        hd0.c.v("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", Long.valueOf(j3), Long.valueOf(j17));
                        return;
                    }
                    aVar.f312543e = j3;
                    aVar.f312544f = j17;
                    if (aVar.f312540b == 3) {
                        l(j17);
                        return;
                    } else {
                        l(j3);
                        return;
                    }
                }
                throw new IllegalArgumentException("end time should not less than start time");
            }
            throw new IllegalArgumentException("both start time and end time should not less than 0");
        }

        public void p(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.R.f312542d = z16;
            }
        }

        public void q(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.R.f312540b = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.S.a(this.R);
            if (!g() || !r()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(this.f312533d, 2, "decode ready time cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            while (!Thread.interrupted() && !this.I) {
                a aVar = this.R;
                int i3 = aVar.f312540b;
                a aVar2 = this.S;
                if (i3 != aVar2.f312540b && i3 == 3) {
                    this.K = aVar2.f312544f * 1000;
                }
                aVar2.a(aVar);
                a aVar3 = this.S;
                long j3 = aVar3.f312543e * 1000;
                long j16 = aVar3.f312544f * 1000;
                long j17 = this.M.get();
                if (j17 >= 0 && j17 >= j3 && j17 <= j16) {
                    k(j17);
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.M.compareAndSet(j17, -1L);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    h(true);
                } catch (Throwable th5) {
                    if (Thread.interrupted()) {
                        QLog.e(this.f312533d, 2, "Thread is interrupted.", th5);
                    } else {
                        RuntimeException runtimeException = new RuntimeException(th5);
                        if (!this.I) {
                            this.C.onDecodeError(3, runtimeException);
                        }
                        QLog.e(this.f312533d, 2, "decode configure error", th5);
                        return;
                    }
                }
                if (z16 && QLog.isColorLevel()) {
                    QLog.d(this.f312533d, 2, "decode ready time cost=" + (System.currentTimeMillis() - currentTimeMillis2));
                }
                if (this.H) {
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f312533d, 2, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                    }
                    a aVar4 = this.S;
                    if (aVar4.f312542d) {
                        if (aVar4.f312540b == 3) {
                            j3 = j16;
                        }
                        k(j3);
                        this.C.onDecodeRepeat();
                    }
                }
                if (this.T) {
                    try {
                        synchronized (this.U) {
                            if (!this.I) {
                                LockMethodProxy.wait(this.U);
                            }
                        }
                        this.J = System.currentTimeMillis() - (this.F.presentationTimeUs / 1000);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                        this.I = true;
                    }
                }
            }
            try {
                this.f312535f.stop();
                this.f312535f.release();
                this.f312534e.release();
            } catch (Exception e17) {
                QLog.e("HWVideoDecoder.DecodeRunnable", 1, "decoder stop error " + e17.toString());
            }
            if (this.H) {
                this.C.onDecodeFinish();
            } else {
                this.C.onDecodeCancel();
            }
        }
    }

    public HWVideoDecoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(a aVar, Surface surface, d dVar) {
        if (aVar != null && surface != null) {
            hd0.c.l("HWVideoDecoder", "startDecode config = %s", aVar);
            Thread thread = this.f312531b;
            if (thread != null) {
                e();
                try {
                    thread.join();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
            DecodeRunnable decodeRunnable = new DecodeRunnable(aVar.f312539a, surface, dVar);
            this.f312532c = decodeRunnable;
            decodeRunnable.m(aVar);
            Thread newFreeThread = ThreadManagerV2.newFreeThread(this.f312532c, "HWVideoDecoder-Thread", 8);
            this.f312531b = newFreeThread;
            newFreeThread.start();
            return;
        }
        throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f312532c.e();
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f312532c.f();
    }

    public void c(a aVar, int i3, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, aVar, Integer.valueOf(i3), onFrameAvailableListener, dVar);
            return;
        }
        b bVar = new b(i3, onFrameAvailableListener);
        this.f312530a = bVar;
        d(aVar, bVar.f312547a, dVar);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Thread thread = this.f312531b;
        if (thread != null) {
            thread.interrupt();
        }
        this.f312531b = null;
        this.f312532c = null;
    }
}
