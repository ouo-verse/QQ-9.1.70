package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARLocalControl implements ARLocalMarkerRecog.a, ARLocalFaceRecog.a, ARLocalGestureCircleRecog.b {

    /* renamed from: k, reason: collision with root package name */
    private static final Object f197805k = new Object();

    /* renamed from: i, reason: collision with root package name */
    private boolean f197814i;

    /* renamed from: a, reason: collision with root package name */
    private long f197806a = 0;

    /* renamed from: b, reason: collision with root package name */
    ARLocalMarkerRecog f197807b = null;

    /* renamed from: c, reason: collision with root package name */
    public ARLocalFaceRecog f197808c = null;

    /* renamed from: d, reason: collision with root package name */
    ARLocalGestureCircleRecog f197809d = null;

    /* renamed from: e, reason: collision with root package name */
    a f197810e = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f197811f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f197812g = false;

    /* renamed from: h, reason: collision with root package name */
    Object f197813h = new Object();

    /* renamed from: j, reason: collision with root package name */
    private boolean f197815j = false;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void D(long j3, ab abVar);
    }

    private void l(final Context context, final int i3, final int i16, final ARScanStarFaceConfigInfo aRScanStarFaceConfigInfo) {
        QLog.i("AREngine_ARLocalControl", 1, "initFaceRecogAsync start.");
        final long currentTimeMillis = System.currentTimeMillis();
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARLocalControl.1
            @Override // java.lang.Runnable
            public void run() {
                if ((ARLocalControl.this.f197806a & 4) != 0) {
                    ARFacePreviewResample aRFacePreviewResample = new ARFacePreviewResample();
                    aRFacePreviewResample.e(i3, i16, 17);
                    int d16 = aRFacePreviewResample.d();
                    int c16 = aRFacePreviewResample.c();
                    ARLocalControl.this.f197808c = new ARLocalFaceRecog();
                    ARLocalControl.this.f197808c.t(aRFacePreviewResample);
                    ARLocalControl aRLocalControl = ARLocalControl.this;
                    if (!aRLocalControl.f197808c.i(context, d16, c16, aRScanStarFaceConfigInfo, aRLocalControl)) {
                        ARLocalControl.this.f197808c = null;
                    }
                }
                synchronized (ARLocalControl.f197805k) {
                    ARLocalControl.this.f197814i = true;
                    ARLocalControl.f197805k.notifyAll();
                }
                QLog.i("AREngine_ARLocalControl", 1, String.format("initFaceRecogAsync end. time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            }
        }, null, true);
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog.a
    public void a(z zVar) {
        o(1L, zVar);
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog.b
    public void b(y yVar) {
        o(4096L, yVar);
    }

    @Override // com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.a
    public void c(x xVar) {
        o(4L, xVar);
    }

    public boolean g(o oVar) {
        ARLocalFaceRecog aRLocalFaceRecog;
        if (!this.f197812g || (aRLocalFaceRecog = this.f197808c) == null) {
            return false;
        }
        return aRLocalFaceRecog.a(oVar);
    }

    public boolean h(String str, String str2, ArCloudConfigInfo arCloudConfigInfo) {
        ARLocalMarkerRecog aRLocalMarkerRecog;
        if (!this.f197812g || (aRLocalMarkerRecog = this.f197807b) == null) {
            return false;
        }
        return aRLocalMarkerRecog.K(str, str2, arCloudConfigInfo);
    }

    public boolean i(boolean z16, int i3, int i16) {
        if (z16) {
            if (this.f197809d == null) {
                ARLocalGestureCircleRecog aRLocalGestureCircleRecog = new ARLocalGestureCircleRecog();
                this.f197809d = aRLocalGestureCircleRecog;
                if (!aRLocalGestureCircleRecog.r(i3, i16, this)) {
                    this.f197809d = null;
                    return false;
                }
                this.f197811f = true;
                this.f197809d.A();
                this.f197812g = true;
            }
            this.f197806a |= 4096;
        } else {
            this.f197806a &= -4097;
        }
        this.f197815j = z16;
        return z16;
    }

    public float[] j(int i3, int i16) {
        ARLocalMarkerRecog aRLocalMarkerRecog;
        if (!this.f197811f || (aRLocalMarkerRecog = this.f197807b) == null) {
            return null;
        }
        return aRLocalMarkerRecog.N(i3, i16);
    }

    public boolean k(Context context, long j3, int i3, int i16, ArConfigInfo arConfigInfo, ArrayList<ArCloudConfigInfo> arrayList, ARScanStarFaceConfigInfo aRScanStarFaceConfigInfo, a aVar) {
        ARLocalGestureCircleRecog aRLocalGestureCircleRecog;
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i("AREngine_ARLocalControl", 1, String.format("init start. mIsInited=%s recogType=%s imageWidth=%s imageHeight=%s", Boolean.valueOf(this.f197811f), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16)));
        if (this.f197811f) {
            return true;
        }
        this.f197806a = j3;
        this.f197810e = aVar;
        l(context, i3, i16, aRScanStarFaceConfigInfo);
        QLog.i("AREngine_ARLocalControl", 1, "init running. marker recog start.");
        long currentTimeMillis2 = System.currentTimeMillis();
        if ((this.f197806a & 1) != 0) {
            ARLocalMarkerRecog aRLocalMarkerRecog = new ARLocalMarkerRecog();
            this.f197807b = aRLocalMarkerRecog;
            aRLocalGestureCircleRecog = null;
            if (!aRLocalMarkerRecog.O(i3, i16, arConfigInfo, arrayList, this)) {
                this.f197807b = null;
            }
        } else {
            aRLocalGestureCircleRecog = null;
        }
        if ((this.f197806a & 4096) != 0) {
            ARLocalGestureCircleRecog aRLocalGestureCircleRecog2 = new ARLocalGestureCircleRecog();
            this.f197809d = aRLocalGestureCircleRecog2;
            if (!aRLocalGestureCircleRecog2.r(i3, i16, this)) {
                this.f197809d = aRLocalGestureCircleRecog;
            }
        }
        QLog.i("AREngine_ARLocalControl", 1, String.format("init running. marker recog end. time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)));
        Object obj = f197805k;
        synchronized (obj) {
            if (!this.f197814i) {
                QLog.i("AREngine_ARLocalControl", 1, "init running. face recog has not init complete, wait...");
                try {
                    LockMethodProxy.wait(obj);
                } catch (Exception unused) {
                }
            }
            QLog.i("AREngine_ARLocalControl", 1, "init running. face recog init complete.");
        }
        if (this.f197807b == null && this.f197808c == null && this.f197809d == null) {
            this.f197811f = false;
        } else {
            this.f197811f = true;
        }
        this.f197812g = false;
        QLog.i("AREngine_ARLocalControl", 1, String.format("init end. mIsInited=%s time cost:%sms", Boolean.valueOf(this.f197811f), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        ARReport.c().i(System.currentTimeMillis() - currentTimeMillis, this.f197811f);
        return this.f197811f;
    }

    public boolean m(long j3) {
        ARLocalGestureCircleRecog aRLocalGestureCircleRecog;
        ARLocalFaceRecog aRLocalFaceRecog;
        ARLocalMarkerRecog aRLocalMarkerRecog;
        if ((1 & j3) != 0 && (aRLocalMarkerRecog = this.f197807b) != null) {
            return aRLocalMarkerRecog.Q();
        }
        if ((4 & j3) != 0 && (aRLocalFaceRecog = this.f197808c) != null) {
            return aRLocalFaceRecog.l();
        }
        if ((j3 & 4096) != 0 && (aRLocalGestureCircleRecog = this.f197809d) != null) {
            return aRLocalGestureCircleRecog.s();
        }
        return true;
    }

    public boolean n(long j3) {
        ARLocalFaceRecog aRLocalFaceRecog;
        if ((j3 & 4) != 0 && (aRLocalFaceRecog = this.f197808c) != null) {
            return aRLocalFaceRecog.m();
        }
        return true;
    }

    public void o(long j3, ab abVar) {
        a aVar;
        synchronized (this.f197813h) {
            if (this.f197812g && (aVar = this.f197810e) != null) {
                aVar.D(j3, abVar);
            }
        }
    }

    public void p(long j3, byte[] bArr) {
        if (bArr != null && this.f197812g) {
            if (this.f197815j) {
                ARLocalGestureCircleRecog aRLocalGestureCircleRecog = this.f197809d;
                if (aRLocalGestureCircleRecog != null) {
                    aRLocalGestureCircleRecog.w(j3, bArr);
                    return;
                }
                return;
            }
            ARLocalMarkerRecog aRLocalMarkerRecog = this.f197807b;
            if (aRLocalMarkerRecog != null) {
                aRLocalMarkerRecog.R(j3, bArr);
            }
            ARLocalFaceRecog aRLocalFaceRecog = this.f197808c;
            if (aRLocalFaceRecog != null) {
                aRLocalFaceRecog.o(j3, bArr);
            }
        }
    }

    public void q(long j3) {
        ARLocalGestureCircleRecog aRLocalGestureCircleRecog;
        ARLocalFaceRecog aRLocalFaceRecog;
        ARLocalMarkerRecog aRLocalMarkerRecog;
        QLog.i("AREngine_ARLocalControl", 1, "pause. recogType = " + j3);
        if ((1 & j3) != 0 && (aRLocalMarkerRecog = this.f197807b) != null) {
            aRLocalMarkerRecog.S();
        }
        if ((4 & j3) != 0 && (aRLocalFaceRecog = this.f197808c) != null) {
            aRLocalFaceRecog.p();
        }
        if ((j3 & 4096) != 0 && (aRLocalGestureCircleRecog = this.f197809d) != null) {
            aRLocalGestureCircleRecog.x();
        }
    }

    public void r() {
        ARLocalGestureCircleRecog aRLocalGestureCircleRecog;
        if (this.f197815j && (aRLocalGestureCircleRecog = this.f197809d) != null && !aRLocalGestureCircleRecog.s()) {
            this.f197809d.y();
        }
    }

    public void s(long j3) {
        ARLocalGestureCircleRecog aRLocalGestureCircleRecog;
        ARLocalFaceRecog aRLocalFaceRecog;
        ARLocalMarkerRecog aRLocalMarkerRecog;
        QLog.i("AREngine_ARLocalControl", 1, "resume. recogType = " + j3);
        if ((1 & j3) != 0 && (aRLocalMarkerRecog = this.f197807b) != null) {
            aRLocalMarkerRecog.T();
        }
        if ((4 & j3) != 0 && (aRLocalFaceRecog = this.f197808c) != null) {
            aRLocalFaceRecog.s();
        }
        if ((j3 & 4096) != 0 && (aRLocalGestureCircleRecog = this.f197809d) != null) {
            aRLocalGestureCircleRecog.z();
        }
    }

    public boolean t() {
        QLog.i("AREngine_ARLocalControl", 1, "start start.");
        if (!this.f197811f) {
            return false;
        }
        if (this.f197812g) {
            return true;
        }
        ARLocalMarkerRecog aRLocalMarkerRecog = this.f197807b;
        if (aRLocalMarkerRecog != null && !aRLocalMarkerRecog.U()) {
            this.f197812g = false;
            QLog.i("AREngine_ARLocalControl", 1, "start end. marker recog start failed. mIsStarted = " + this.f197812g);
            return this.f197812g;
        }
        ARLocalFaceRecog aRLocalFaceRecog = this.f197808c;
        if (aRLocalFaceRecog != null && !aRLocalFaceRecog.v()) {
            this.f197812g = false;
            QLog.i("AREngine_ARLocalControl", 1, "start end. face recog start failed. mIsStarted = " + this.f197812g);
            return this.f197812g;
        }
        ARLocalGestureCircleRecog aRLocalGestureCircleRecog = this.f197809d;
        if (aRLocalGestureCircleRecog != null && !aRLocalGestureCircleRecog.A()) {
            this.f197812g = false;
            QLog.i("AREngine_ARLocalControl", 1, "start end. gesture circle recog start failed. mIsStarted = " + this.f197812g);
            return this.f197812g;
        }
        this.f197812g = true;
        QLog.i("AREngine_ARLocalControl", 1, "start end. mIsStarted = " + this.f197812g);
        return true;
    }

    public void u() {
        QLog.i("AREngine_ARLocalControl", 1, "stop start.");
        if (!this.f197811f || !this.f197812g) {
            return;
        }
        ARLocalMarkerRecog aRLocalMarkerRecog = this.f197807b;
        if (aRLocalMarkerRecog != null) {
            aRLocalMarkerRecog.V();
        }
        ARLocalFaceRecog aRLocalFaceRecog = this.f197808c;
        if (aRLocalFaceRecog != null) {
            aRLocalFaceRecog.w();
        }
        ARLocalGestureCircleRecog aRLocalGestureCircleRecog = this.f197809d;
        if (aRLocalGestureCircleRecog != null) {
            aRLocalGestureCircleRecog.B();
        }
        this.f197812g = false;
        QLog.i("AREngine_ARLocalControl", 1, "stop end. mIsStarted = " + this.f197812g);
    }

    public void v() {
        QLog.i("AREngine_ARLocalControl", 1, "uninit start.");
        if (!this.f197811f) {
            return;
        }
        ARLocalMarkerRecog aRLocalMarkerRecog = this.f197807b;
        if (aRLocalMarkerRecog != null) {
            aRLocalMarkerRecog.W();
        }
        ARLocalFaceRecog aRLocalFaceRecog = this.f197808c;
        if (aRLocalFaceRecog != null) {
            aRLocalFaceRecog.x();
        }
        ARLocalGestureCircleRecog aRLocalGestureCircleRecog = this.f197809d;
        if (aRLocalGestureCircleRecog != null) {
            aRLocalGestureCircleRecog.C();
        }
        this.f197811f = false;
        QLog.i("AREngine_ARLocalControl", 1, "uninit end. mIsInited = " + this.f197811f);
    }
}
