package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p extends c implements com.tencent.avcore.camera.callback.b {

    /* renamed from: i, reason: collision with root package name */
    private boolean f74178i = false;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference<a> f74179m = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    private void k() {
        this.f73477e = 0;
        this.f73478f = false;
    }

    private void m() {
        VideoAppInterface.N().k0(new Object[]{38, 2, -1});
    }

    @Override // com.tencent.avcore.camera.callback.b
    public void a() {
        k();
    }

    @Override // com.tencent.avcore.camera.callback.b
    public void b(boolean z16) {
        if (r.h0() != null && n.e().f() != null && (n.e().f().f73035i == 3 || n.e().f().f73035i == 4 || n.e().f().f73060o0)) {
            n.e().f().V2 = false;
        }
        i(z16);
    }

    @Override // com.tencent.avcore.camera.callback.b
    public int c(int i3, boolean z16) {
        boolean z17;
        if (i3 == -1) {
            m();
            return -1;
        }
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        return j(z17, z16);
    }

    @Override // com.tencent.av.c
    public void e() {
        com.tencent.av.opengl.effects.m R = r.h0().R(true);
        if (R != null) {
            h(R);
        } else {
            QLog.i("CameraDataProcess", 1, "checkEffectCtrl, ctrl is null.");
        }
    }

    @Override // com.tencent.av.c
    public void g() {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.i("CameraDataProcess", 2, "notifyCameraNoData, seq[" + d16 + "]");
        }
        VideoAppInterface.N().k0(new Object[]{38, 1, Long.valueOf(d16)});
    }

    public void i(boolean z16) {
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        int i3 = f16.f73035i;
        if (i3 != 2 && i3 != 1) {
            if (i3 == 4 && !f16.O) {
                f16.p0(d16, "CloseCameraRunnable.2", 3);
            }
        } else if (z16 && f16.v()) {
            f16.c0(d16, false);
            if (!f16.O) {
                f16.p0(d16, "CloseCameraRunnable.1", 1);
                f16.M0 = true;
                QLog.d("CameraDataProcess", 1, "afterCloseCamera isOnlyAudio=true " + f16.f73030h);
            }
        } else {
            QLog.d("CameraDataProcess", 1, "afterCloseCamera not same session  " + f16.f73030h + " " + f16.U2 + " " + z16);
        }
        r.h0().w2(f16.f73035i);
        com.tencent.av.utils.p pVar = this.f73476d;
        this.f73476d = null;
        if (pVar != null) {
            pVar.d();
        }
    }

    public int j(boolean z16, boolean z17) {
        long d16 = com.tencent.av.utils.e.d();
        int i3 = n.e().f().f73035i;
        if (z16) {
            n.e().f().S = false;
            n.e().f().M0 = false;
            n.e().f().c0(d16, true);
            if (n.e().f().f73035i == 1) {
                if (!n.e().f().f73098x2) {
                    n.e().f().p0(d16, "afterOpenCamera.1", 2);
                }
            } else if (n.e().f().f73035i == 3 || n.e().f().f73035i == 4) {
                n.e().f().p0(d16, "afterOpenCamera.2", 4);
            }
            r.h0().w2(n.e().f().f73035i);
            r.h0().i2(0);
            if (n.e().f().f73035i == 3 || n.e().f().f73035i == 4 || n.e().f().f73060o0) {
                n.e().f().V2 = true;
            }
        }
        return i3;
    }

    public void l() {
        WeakReference<a> weakReference = this.f74179m;
        if (weakReference != null) {
            weakReference.clear();
        }
        if (QLog.isColorLevel()) {
            QLog.i("SurfaceTag", 2, "clearSwitchCameraListener, isStart[" + this.f74178i + "]");
        }
    }

    public void n(boolean z16, a aVar) {
        this.f74178i = z16;
        this.f74179m = new WeakReference<>(aVar);
        if (QLog.isColorLevel()) {
            QLog.i("SurfaceTag", 2, "setSwitchStart, isStart[" + z16 + "], listener[" + aVar + "]");
        }
    }

    @Override // com.tencent.av.c, com.tencent.avcore.camera.callback.c
    public void onPreviewData(com.tencent.avcore.camera.data.c cVar) {
        a aVar;
        if (cVar.j()) {
            cVar.l();
            if (QLog.isColorLevel()) {
                QLog.e("OnPreviewData", 2, "onPreviewData data is null");
                return;
            }
            return;
        }
        if (this.f74178i) {
            if (QLog.isColorLevel()) {
                QLog.i("SurfaceTag", 2, "onPreviewData, first frame for switchCamera");
            }
            WeakReference<a> weakReference = this.f74179m;
            if (weakReference == null) {
                aVar = null;
            } else {
                aVar = weakReference.get();
            }
            if (aVar != null) {
                aVar.a();
            }
            this.f74178i = false;
        }
        super.onPreviewData(cVar);
    }
}
