package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.s;
import com.tencent.mobileqq.ar.t;
import com.tencent.mobileqq.ar.u;
import com.tencent.mobileqq.ar.w;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class c implements s, t, u, SDKInitListener {
    private w I;
    private a K;
    private b L;
    private long M;
    private InterfaceC7406c N;

    /* renamed from: d, reason: collision with root package name */
    private boolean f198538d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f198539e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f198540f = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f198541h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f198542i = false;

    /* renamed from: m, reason: collision with root package name */
    private int f198543m = 0;
    private boolean C = true;
    private boolean D = true;
    private boolean E = false;
    private boolean F = false;
    private int G = 0;
    private int H = 0;
    private boolean J = false;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a();

        void b();

        void c(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void a(int i3);

        void b();

        void c();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.model.c$c, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC7406c {
        void f(ARCommonConfigInfo aRCommonConfigInfo);
    }

    public c(w wVar) {
        this.I = wVar;
    }

    private void A() {
        int i3 = 0;
        if (n(2L)) {
            i3 = 0 + this.f198540f;
        }
        if (n(8L)) {
            i3 += this.f198543m;
        }
        a aVar = this.K;
        if (aVar != null) {
            aVar.c(i3 / 2);
        }
    }

    private void B() {
        if (this.f198538d && this.f198541h) {
            a aVar = this.K;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        if (!this.f198539e && !this.f198542i && this.K != null) {
            QLog.d("ScanEntryResourceDelegate", 1, "ARBaseSo res download fail");
            this.K.b();
        }
    }

    private boolean n(long j3) {
        if ((this.M & 2) != 0) {
            return true;
        }
        return false;
    }

    private void w(long j3) {
        long j16 = 2 & j3;
        if (j16 != 0 && !this.f198539e) {
            h();
        }
        if ((j3 & 8) != 0 && !this.f198542i) {
            o();
        }
        if (j16 != 0) {
            if (!this.E || !this.f198542i) {
                g();
            }
        }
    }

    @Override // com.tencent.mobileqq.ar.u
    public void F(int i3) {
        QLog.d("ScanEntryResourceDelegate", 1, "onArSoDownloadProcess process." + i3);
        this.f198540f = i3;
        A();
    }

    @Override // com.tencent.mobileqq.ar.t
    public void a(int i3) {
        b bVar;
        if (i3 != 0) {
            if (i3 == 1) {
                this.D = true;
                this.F = false;
                this.H = 100;
            }
        } else {
            this.C = true;
            this.E = false;
            this.G = 100;
        }
        if (this.C && this.D && (bVar = this.L) != null) {
            bVar.b();
        }
    }

    @Override // com.tencent.mobileqq.ar.t
    public void b(int i3, int i16) {
        if (i3 != 0) {
            if (i3 == 1) {
                this.H = i16;
            }
        } else {
            this.G = i16;
        }
        b bVar = this.L;
        if (bVar != null) {
            bVar.a((this.G + this.H) / 2);
        }
    }

    @Override // com.tencent.mobileqq.ar.t
    public void c(int i3, int i16) {
        if (i3 != 0) {
            if (i3 == 1) {
                this.D = false;
                this.F = false;
            }
        } else {
            this.C = false;
            this.E = false;
        }
        if (this.L != null) {
            QLog.d("ScanEntryResourceDelegate", 1, "face so download not ready download fail");
            this.L.c();
        }
    }

    public void d() {
        this.M = 0L;
        this.K = null;
        this.L = null;
    }

    public boolean f(int i3) {
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 8) {
                    return false;
                }
                return this.f198541h;
            }
            if (!this.C || !this.D) {
                return false;
            }
            return true;
        }
        return this.f198538d;
    }

    public void g() {
        this.D = true;
        this.C = true;
        this.E = false;
        this.G = 100;
        QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceSoReady=%s mFaceSoDownloading=%s", true, Boolean.valueOf(this.F)));
        QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARFaceResources mIsFaceModelReady=%s mFaceModelDownloading=%s", Boolean.valueOf(this.C), Boolean.valueOf(this.E)));
    }

    public void h() {
        try {
            boolean l3 = this.I.l();
            this.f198538d = l3;
            if (!l3) {
                this.f198539e = true;
                this.I.g();
            } else {
                this.f198539e = false;
                this.f198540f = 100;
            }
            QLog.d("ScanEntryResourceDelegate", 1, String.format("downloadARResource mIsArSoReady=%s mArSoDownloading=%s", Boolean.valueOf(this.f198538d), Boolean.valueOf(this.f198539e)));
        } catch (Exception unused) {
            QLog.d("ScanEntryResourceDelegate", 1, "downloadARResource fail");
        }
    }

    @Override // com.tencent.mobileqq.ar.s
    public void j(ArEffectConfig arEffectConfig) {
        ARDeviceController.b().g(arEffectConfig);
    }

    @Override // com.tencent.mobileqq.ar.s
    public void m(ARCommonConfigInfo aRCommonConfigInfo) {
        if (this.J) {
            return;
        }
        InterfaceC7406c interfaceC7406c = this.N;
        if (interfaceC7406c != null) {
            interfaceC7406c.f(aRCommonConfigInfo);
        }
        this.J = true;
    }

    public void o() {
        boolean isSDKReady = QQVideoPlaySDKManager.isSDKReady();
        this.f198541h = isSDKReady;
        if (!isSDKReady) {
            this.f198542i = true;
            if (!QQVideoPlaySDKManager.isSDKReady()) {
                QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), this);
            }
        } else {
            this.f198542i = false;
            this.f198543m = 100;
        }
        QLog.d("ScanEntryResourceDelegate", 1, String.format("installVideoPlugin mIsVideoPluginReady=%s mVideoPluginDownloading=%s", Boolean.valueOf(this.f198541h), Boolean.valueOf(this.f198542i)));
    }

    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
    public void onSDKInited(boolean z16) {
        QLog.d("ScanEntryResourceDelegate", 1, "onSDKInited result." + z16);
        if (z16) {
            this.f198541h = true;
            this.f198542i = false;
            this.f198543m = 100;
            B();
            return;
        }
        this.f198541h = false;
        this.f198542i = false;
        B();
    }

    @Override // com.tencent.mobileqq.ar.u
    public void p() {
        this.f198538d = false;
        this.f198539e = false;
        B();
    }

    public boolean q() {
        if (this.f198538d && this.f198541h) {
            return true;
        }
        return false;
    }

    public boolean r() {
        if (this.C && this.D) {
            return true;
        }
        return false;
    }

    public boolean s() {
        boolean z16;
        boolean z17 = false;
        if (n(2L) && !f(2)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (n(8L)) {
            if (z16 && f(8)) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (n(4L)) {
            if (z16 && f(4)) {
                z17 = true;
            }
            return z17;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.ar.u
    public void t() {
        this.f198538d = true;
        this.f198539e = false;
        this.f198540f = 100;
        B();
    }

    public boolean u() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (n(2L)) {
            z16 = this.f198539e;
        } else {
            z16 = false;
        }
        if (n(8L)) {
            z17 = this.f198542i;
        } else {
            z17 = false;
        }
        if (n(4L) && (this.E || this.F)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z16 && !z17 && !z18) {
            return false;
        }
        return true;
    }

    public void v(int i3) {
        QLog.d("ScanEntryResourceDelegate", 2, "notifyVoiceScanStatusChange state.", Integer.valueOf(i3));
        w wVar = this.I;
        if (wVar != null) {
            try {
                wVar.n(i3);
            } catch (Exception e16) {
                QLog.d("ScanEntryResourceDelegate", 1, "notifyVoiceScanStatusChange fail.", e16);
            }
        }
    }

    public void x(long j3, a aVar, b bVar) {
        if (j3 == 0) {
            return;
        }
        this.M = j3;
        this.K = aVar;
        this.L = bVar;
        w(j3);
    }

    public void y() {
        long j3 = this.M;
        if (j3 == 0) {
            return;
        }
        x(j3, this.K, this.L);
    }

    public void z(InterfaceC7406c interfaceC7406c) {
        this.N = interfaceC7406c;
    }

    @Override // com.tencent.mobileqq.ar.s
    public void k() {
    }

    @Override // com.tencent.mobileqq.ar.s
    public void onDownloadSuccess() {
    }

    @Override // com.tencent.mobileqq.ar.s
    public void e(int i3) {
    }

    @Override // com.tencent.mobileqq.ar.s
    public void l(ArConfigInfo arConfigInfo) {
    }

    @Override // com.tencent.mobileqq.ar.s
    public void i(long j3, long j16) {
    }
}
