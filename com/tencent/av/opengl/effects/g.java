package com.tencent.av.opengl.effects;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.avcore.data.RecordParam;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.ByteBuffer;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g extends s implements SurfaceTexture.OnFrameAvailableListener {
    private Surface I;
    private int J;
    private SurfaceTexture K;
    private float[] L;
    private int M;
    private int N;
    private RenderBuffer P;
    private tv.b Q;
    private float[] R;
    private b X;
    private final int E = 1;
    private final int F = 2;
    private final int G = 3;
    private boolean H = false;
    private RenderBuffer S = null;
    private ByteBuffer T = null;
    private byte[] U = null;
    private z V = null;
    private boolean W = true;
    private final RecordParam Y = new RecordParam();
    private final RecordParam Z = new RecordParam();

    /* renamed from: a0, reason: collision with root package name */
    private final a f73974a0 = new a();

    /* renamed from: b0, reason: collision with root package name */
    private long f73975b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    private long f73976c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    private long f73977d0 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f73978a;

        /* renamed from: b, reason: collision with root package name */
        public long f73979b;

        /* renamed from: c, reason: collision with root package name */
        public long f73980c;

        /* renamed from: d, reason: collision with root package name */
        public long f73981d;

        /* renamed from: e, reason: collision with root package name */
        public long f73982e;

        /* renamed from: f, reason: collision with root package name */
        public long f73983f;

        /* renamed from: g, reason: collision with root package name */
        public long f73984g;

        a() {
        }

        public void a(long j3, long j16, long j17, long j18, long j19) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f73978a++;
            this.f73979b = (this.f73979b + j3) / 2;
            this.f73980c = (this.f73980c + j16) / 2;
            this.f73981d = (this.f73981d + j17) / 2;
            this.f73982e = (this.f73982e + j18) / 2;
            this.f73983f = (this.f73983f + j19) / 2;
            this.f73984g = elapsedRealtime;
        }

        public void b() {
            if (QLog.isColorLevel()) {
                QLog.i("PerfData", 2, String.format(Locale.getDefault(), "addPerfData, [count: %s, oes2NormalCost: %s, gpuDrawCost: %s, readPixelCost:%s, sendDataCost:%s, totalCost:%s", Long.valueOf(this.f73978a), Long.valueOf(this.f73979b), Long.valueOf(this.f73980c), Long.valueOf(this.f73981d), Long.valueOf(this.f73982e), Long.valueOf(this.f73983f)));
            }
        }

        public void c() {
            this.f73978a = 0L;
            this.f73979b = 0L;
            this.f73980c = 0L;
            this.f73981d = 0L;
            this.f73982e = 0L;
            this.f73983f = 0L;
            this.f73984g = 0L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface b {
        void b(Bitmap bitmap, RecordParam recordParam);

        void e(byte[] bArr, int i3, int i16, RecordParam recordParam);
    }

    @RequiresApi(api = 21)
    public g() {
    }

    private void l() {
        if (!this.H) {
            return;
        }
        if (!this.Z.isValid() && !this.Y.isValid()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("EGLScreenCaptureThread", 4, "check, param not valid.");
            }
        } else {
            s();
        }
        this.D.removeMessages(3);
        this.D.sendEmptyMessageDelayed(3, 2000L);
    }

    private void m() {
        boolean update = this.Y.update(this.Z);
        RenderBuffer renderBuffer = this.P;
        if (renderBuffer == null || update) {
            if (renderBuffer != null) {
                renderBuffer.destroy();
            }
            RecordParam recordParam = this.Y;
            this.P = new RenderBuffer(recordParam.width, recordParam.height, 33984);
        }
        if (this.W) {
            RenderBuffer renderBuffer2 = this.S;
            if (renderBuffer2 == null || update) {
                if (renderBuffer2 != null) {
                    renderBuffer2.destroy();
                }
                RecordParam recordParam2 = this.Y;
                this.S = new RenderBuffer(recordParam2.width, recordParam2.height, 33985);
            }
            if (this.V == null) {
                z zVar = new z();
                this.V = zVar;
                zVar.i();
            }
            if (update) {
                z zVar2 = this.V;
                RecordParam recordParam3 = this.Y;
                zVar2.m(recordParam3.width, recordParam3.height);
            }
            if (this.T == null || update) {
                RecordParam recordParam4 = this.Y;
                this.T = ByteBuffer.allocate(((recordParam4.width * recordParam4.height) * 3) / 2);
            }
        }
        if (this.U == null || update) {
            RecordParam recordParam5 = this.Y;
            this.U = new byte[((recordParam5.width * recordParam5.height) * 3) / 2];
        }
    }

    @RequiresApi(api = 21)
    private void p() {
        this.J = GlUtil.createTexture(36197);
        GLES20.glBindTexture(36197, 0);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.J);
        this.K = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this, n());
        this.K.setDefaultBufferSize(this.M, this.N);
        this.I = new Surface(this.K);
        this.Q = new tv.b();
        this.H = true;
        this.f73976c0 = 0L;
        this.f73975b0 = 0L;
        this.f73977d0 = 0L;
        this.f73974a0.c();
        if (QLog.isColorLevel()) {
            QLog.i("EGLScreenCaptureThread", 2, "initGLEnv");
        }
    }

    private void r() {
        this.H = false;
        this.D.removeMessages(3);
        tv.b bVar = this.Q;
        if (bVar != null) {
            bVar.b();
            this.Q = null;
        }
        RenderBuffer renderBuffer = this.P;
        if (renderBuffer != null) {
            renderBuffer.destroy();
        }
        RenderBuffer renderBuffer2 = this.S;
        if (renderBuffer2 != null) {
            renderBuffer2.destroy();
            this.S = null;
        }
        z zVar = this.V;
        if (zVar != null) {
            zVar.b();
            this.V = null;
        }
        SurfaceTexture surfaceTexture = this.K;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.K = null;
        }
        Surface surface = this.I;
        if (surface != null) {
            surface.release();
            this.I = null;
        }
        this.f73974a0.b();
        this.f73976c0 = 0L;
        this.f73975b0 = 0L;
        this.f73977d0 = 0L;
        if (QLog.isColorLevel()) {
            QLog.i("EGLScreenCaptureThread", 2, "releaseGLEnv");
        }
    }

    private void s() {
        long j3;
        long j16;
        long j17;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m();
        this.P.bind();
        if (this.R == null) {
            int i3 = this.M;
            int i16 = this.N;
            RecordParam recordParam = this.Y;
            float[] caculateCenterCropMvpMatrix = GPUBaseFilter.caculateCenterCropMvpMatrix(i3, i16, recordParam.width, recordParam.height);
            this.R = caculateCenterCropMvpMatrix;
            Matrix.scaleM(caculateCenterCropMvpMatrix, 0, 1.0f, -1.0f, 1.0f);
        }
        this.Q.a(36197, this.J, this.L, this.R);
        this.P.unbind();
        long abs = Math.abs(SystemClock.elapsedRealtime() - elapsedRealtime);
        long j18 = 0;
        if (this.W) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.S.bind();
            this.V.c(this.P.getTexId());
            j3 = Math.abs(SystemClock.elapsedRealtime() - elapsedRealtime2);
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            RecordParam recordParam2 = this.Y;
            GLES20.glReadPixels(0, 0, recordParam2.width, (recordParam2.height * 3) / 8, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.T);
            this.S.unbind();
            j16 = Math.abs(SystemClock.elapsedRealtime() - elapsedRealtime3);
            ByteBuffer byteBuffer = this.T;
            byte[] bArr = this.U;
            RecordParam recordParam3 = this.Y;
            byteBuffer.get(bArr, 0, ((recordParam3.width * recordParam3.height) * 3) / 2);
            this.T.clear();
            b bVar = this.X;
            if (bVar != null) {
                long elapsedRealtime4 = SystemClock.elapsedRealtime();
                bVar.e(this.U, 100, 0, this.Y);
                j18 = SystemClock.elapsedRealtime() - elapsedRealtime4;
            }
            j17 = j18;
        } else {
            int texId = this.P.getTexId();
            RecordParam recordParam4 = this.Y;
            Bitmap captureFrame = GlUtil.captureFrame(texId, recordParam4.width, recordParam4.height, 0);
            b bVar2 = this.X;
            if (bVar2 != null) {
                long elapsedRealtime5 = SystemClock.elapsedRealtime();
                bVar2.b(captureFrame, this.Y);
                j17 = SystemClock.elapsedRealtime() - elapsedRealtime5;
                j3 = 0;
                j16 = 0;
            } else {
                j3 = 0;
                j16 = 0;
                j17 = 0;
            }
        }
        long elapsedRealtime6 = SystemClock.elapsedRealtime();
        this.f73977d0 = elapsedRealtime6;
        this.f73974a0.a(abs, j3, j16, j17, elapsedRealtime6 - elapsedRealtime);
    }

    @Override // com.tencent.av.opengl.effects.s
    @RequiresApi(api = 21)
    public void j(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    l();
                    return;
                }
                return;
            } else {
                r();
                i();
                return;
            }
        }
        h();
        p();
    }

    public Handler n() {
        return this.D;
    }

    public Surface o() {
        return this.I;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (!this.H) {
            return;
        }
        this.f73976c0++;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f73975b0 = elapsedRealtime;
        if (this.L == null) {
            this.L = new float[16];
        }
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.L);
        float timestamp = (float) surfaceTexture.getTimestamp();
        if (timestamp == 0.0f) {
            if (QLog.isDevelopLevel()) {
                QLog.i("EGLScreenCaptureThread", 4, "onFrameAvailable, time[" + timestamp + "]");
                return;
            }
            return;
        }
        long abs = Math.abs(elapsedRealtime - this.f73977d0);
        boolean z16 = false;
        if (this.f73977d0 != 0 && abs < this.Y.intervalTime) {
            z16 = true;
        }
        long j3 = 2000;
        if (z16) {
            j3 = Math.min(this.Y.intervalTime - abs, 2000L);
        }
        this.D.removeMessages(3);
        this.D.sendEmptyMessageDelayed(3, j3);
        if (z16) {
            return;
        }
        if (this.Z.isValid() || this.Y.isValid()) {
            s();
        }
    }

    @RequiresApi(api = 18)
    public void q(boolean z16) {
        Handler handler;
        if (QLog.isDevelopLevel()) {
            QLog.i("EGLScreenCaptureThread", 4, "quit");
        }
        Handler handler2 = this.D;
        if (handler2 != null) {
            handler2.sendEmptyMessage(2);
        }
        if (z16 && (handler = this.D) != null) {
            handler.getLooper().quitSafely();
        }
    }

    public void t(b bVar) {
        this.X = bVar;
    }

    public void u(int i3, int i16) {
        this.M = i3;
        this.N = i16;
    }

    public void v() {
        this.D.sendEmptyMessage(1);
    }

    public void w(RecordParam recordParam) {
        if (recordParam != null && recordParam.isValid()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("EGLScreenCaptureThread", 4, "updateRecordParam cur[" + this.Z + "], come[" + recordParam + "]");
            }
            this.Z.update(recordParam);
        }
    }
}
