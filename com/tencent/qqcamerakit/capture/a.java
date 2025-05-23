package com.tencent.qqcamerakit.capture;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqcamerakit.capture.CameraHandler;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.capture.camera.CameraControl;
import com.tencent.qqcamerakit.capture.cameraextend.a;
import com.tencent.qqcamerakit.common.e;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements c.b {
    static IPatchRedirector $redirector_;
    private static HandlerThread D;
    public static int E;
    c.a C;

    /* renamed from: d, reason: collision with root package name */
    private CameraHandler f344794d;

    /* renamed from: e, reason: collision with root package name */
    private CameraObservable f344795e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.qqcamerakit.capture.cameraextend.b f344796f;

    /* renamed from: h, reason: collision with root package name */
    private c.b f344797h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f344798i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f344799m;

    /* compiled from: P */
    /* renamed from: com.tencent.qqcamerakit.capture.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    class C9357a implements c.a {
        static IPatchRedirector $redirector_;

        C9357a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.qqcamerakit.capture.c.a
        public void onAutoFocusCallback(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            c.a aVar = a.this.C;
            if (aVar != null) {
                aVar.onAutoFocusCallback(z16);
            }
            if (!z16) {
                a.this.u();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b implements c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f344801d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f344802e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f344803f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ c.b f344804h;

        b(d dVar, String str, int i3, c.b bVar) {
            this.f344801d = dVar;
            this.f344802e = str;
            this.f344803f = i3;
            this.f344804h = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, dVar, str, Integer.valueOf(i3), bVar);
            }
        }

        @Override // com.tencent.qqcamerakit.capture.c.a
        public void onAutoFocusCallback(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (e.f()) {
                e.a("CameraProxy", 2, "onAutoFocusCallback requestFocus when capture, ", Boolean.valueOf(z16));
            }
            a.this.h(this.f344801d, this.f344802e, this.f344803f, this.f344804h);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 46)) {
            redirector.redirect((short) 46);
        } else {
            E = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Handler handler, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, handler, Boolean.valueOf(z16));
            return;
        }
        this.f344798i = false;
        this.f344799m = false;
        if (D == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Camera Handler Thread");
            D = baseHandlerThread;
            baseHandlerThread.start();
        }
        this.f344795e = new CameraObservable(handler);
        com.tencent.qqcamerakit.capture.camerastrategy.a.a(z16);
        this.f344794d = new CameraHandler(D.getLooper(), this.f344795e);
    }

    private void B(SurfaceTexture surfaceTexture, com.tencent.qqcamerakit.capture.b bVar) {
        try {
            this.f344794d.obtainMessage(1002, new Object[]{surfaceTexture, bVar}).sendToTarget();
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(d dVar, String str, int i3, c.b bVar) {
        int i16;
        this.f344797h = bVar;
        com.tencent.qqcamerakit.common.a.b(str);
        CameraHandler.c cVar = new CameraHandler.c();
        cVar.f344782a = str;
        cVar.f344783b = dVar;
        cVar.f344784c = this;
        cVar.f344786e = k();
        cVar.f344785d = i3;
        if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            i16 = 1010;
        } else {
            i16 = 301;
        }
        this.f344794d.obtainMessage(i16, cVar).sendToTarget();
        if (e.f()) {
            e.a("CameraProxy", 2, "takePicture, file = ", str, ", orientation = ", Integer.valueOf(i3));
        }
    }

    private void o(Exception exc) {
        if (e.f()) {
            e.a("CameraProxy", 2, "onDispatchThreadException, ", exc);
        }
        this.f344795e.b(11, -2, "", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                this.f344794d.obtainMessage(1031).sendToTarget();
            } else {
                this.f344794d.obtainMessage(101).sendToTarget();
            }
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    public void A(float f16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Float.valueOf(f16));
            return;
        }
        try {
            if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                i3 = 1040;
            } else {
                i3 = 601;
            }
            this.f344794d.obtainMessage(i3, (int) (f16 * 100.0f), 0).sendToTarget();
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    protected void C(SurfaceTexture surfaceTexture, com.tencent.qqcamerakit.capture.b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, surfaceTexture, bVar, Boolean.valueOf(z16));
            return;
        }
        if (surfaceTexture != null) {
            z(surfaceTexture);
        }
        if (bVar != null) {
            y(bVar, z16);
        }
        try {
            this.f344794d.obtainMessage(204).sendToTarget();
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        try {
            if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                this.f344794d.obtainMessage(1021).sendToTarget();
            }
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(boolean z16) {
        int i3;
        com.tencent.qqcamerakit.capture.cameraextend.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        int i16 = 1;
        if (k() == 1 && (bVar = this.f344796f) != null && bVar.f344880a) {
            bVar.a(z16);
            return;
        }
        if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            i3 = 1050;
        } else {
            i3 = 401;
        }
        CameraHandler cameraHandler = this.f344794d;
        if (!z16) {
            i16 = 2;
        }
        cameraHandler.obtainMessage(i3, i16, 0).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(com.tencent.qqcamerakit.common.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) dVar);
        } else {
            this.f344795e.c(dVar);
        }
    }

    @Override // com.tencent.qqcamerakit.capture.c.b
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
            return;
        }
        if (this.f344797h != null) {
            if (this.f344799m) {
                E(false);
            }
            this.f344797h.a(str);
            if (!com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                try {
                    this.f344794d.obtainMessage(204).sendToTarget();
                } catch (RuntimeException e16) {
                    o(e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void d(int i3, boolean z16) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (e.f()) {
            e.a("CameraProxy", 2, "cameraCreate, cameraCreate has created, ", Boolean.valueOf(this.f344798i));
        }
        this.f344798i = true;
        if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            i16 = 1001;
        } else {
            i16 = 1;
        }
        try {
            CameraHandler cameraHandler = this.f344794d;
            if (z16) {
                i17 = 1;
            }
            cameraHandler.obtainMessage(i16, i3, i17).sendToTarget();
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (e.f()) {
            e.a("CameraProxy", 2, "cameraDestroyed, cameraCreate has created, ", Boolean.valueOf(this.f344798i));
        }
        if (!this.f344798i) {
            return;
        }
        this.f344798i = false;
        try {
            this.C = null;
            if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                this.f344794d.obtainMessage(1003).sendToTarget();
            } else {
                this.f344794d.sendEmptyMessage(2);
                if (z16) {
                    this.f344794d.b(3500L, "release camera");
                }
            }
            q();
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(SurfaceTexture surfaceTexture, com.tencent.qqcamerakit.capture.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) surfaceTexture, (Object) bVar);
            return;
        }
        if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            if (surfaceTexture == null) {
                this.f344794d.a(3, 40, "[Camera2]no surface", new Object[0]);
                return;
            } else {
                B(surfaceTexture, bVar);
                return;
            }
        }
        if (surfaceTexture != null) {
            C(surfaceTexture, bVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        try {
            if (!com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                this.f344794d.sendEmptyMessage(205);
                if (z16) {
                    this.f344794d.b(3500L, "stop preview");
                }
            }
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(d dVar, boolean z16, String str, int i3, c.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, dVar, Boolean.valueOf(z16), str, Integer.valueOf(i3), bVar);
            return;
        }
        if (this.f344799m) {
            E(true);
        }
        if (!z16 && !com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            s(new a.C9360a(true), null, new b(dVar, str, i3, bVar));
        } else {
            h(dVar, str, i3, bVar);
        }
    }

    public Object j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return iPatchRedirector.redirect((short) 34, (Object) this);
        }
        if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            return com.tencent.qqcamerakit.capture.camera2.b.Q().L();
        }
        return CameraControl.l().i();
    }

    protected int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            com.tencent.qqcamerakit.capture.camera2.b.Q();
            return com.tencent.qqcamerakit.capture.camera2.b.V;
        }
        return CameraControl.l().f344812i;
    }

    public long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Long) iPatchRedirector.redirect((short) 21, (Object) this)).longValue();
        }
        if (!com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            return 0L;
        }
        return com.tencent.qqcamerakit.capture.camera2.b.Q().M();
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        if (!com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            return 0;
        }
        return com.tencent.qqcamerakit.capture.camera2.b.Q().N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, i3)).booleanValue();
        }
        if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
            com.tencent.qqcamerakit.capture.camera2.b.Q();
            if (com.tencent.qqcamerakit.capture.camera2.b.Z(i3)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(com.tencent.qqcamerakit.common.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) dVar);
        } else {
            this.f344795e.a(dVar, 1, 2, 3, 4, 5, 6, 8, 9, 10);
        }
    }

    protected void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
        } else {
            this.f344797h = null;
        }
    }

    public void r(Matrix matrix, c.a aVar, int i3, int i16, int i17, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, matrix, aVar, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        a.C9360a c9360a = new a.C9360a();
        c9360a.f344870a = f16;
        c9360a.f344871b = f17;
        c9360a.f344872c = i16;
        c9360a.f344873d = i17;
        c9360a.f344874e = ((i3 + 45) / 90) * 90;
        this.C = aVar;
        s(c9360a, matrix, new C9357a());
    }

    public void s(a.C9360a c9360a, Matrix matrix, c.a aVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, c9360a, matrix, aVar);
            return;
        }
        try {
            if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                c9360a.f344876g = aVar;
                i3 = 1030;
            } else {
                c9360a.f344876g = aVar;
                if (c9360a.a()) {
                    c9360a.f344877h = com.tencent.qqcamerakit.capture.cameraextend.a.a(matrix, c9360a.f344870a, c9360a.f344871b, c9360a.f344872c, c9360a.f344873d, 1.0f);
                    c9360a.f344878i = com.tencent.qqcamerakit.capture.cameraextend.a.a(matrix, c9360a.f344870a, c9360a.f344871b, c9360a.f344872c, c9360a.f344873d, 1.5f);
                }
                i3 = 102;
            }
            this.f344794d.obtainMessage(i3, c9360a).sendToTarget();
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    public void t(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            if (!com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                return;
            }
            try {
                this.f344794d.obtainMessage(1080, i3, 0, Long.valueOf(j3)).sendToTarget();
            } catch (RuntimeException e16) {
                o(e16);
            }
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        try {
            if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                this.f344794d.obtainMessage(1032).sendToTarget();
            } else {
                this.f344794d.obtainMessage(103).sendToTarget();
            }
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, activity, Boolean.valueOf(z16));
            return;
        }
        com.tencent.qqcamerakit.capture.cameraextend.b bVar = new com.tencent.qqcamerakit.capture.cameraextend.b(activity);
        this.f344796f = bVar;
        bVar.f344880a = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(d dVar, d dVar2, d dVar3, int i3, String str, int i16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, dVar, dVar2, dVar3, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        try {
            if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                i18 = 1005;
            } else {
                i18 = 3;
            }
            Object[] objArr = new Object[5];
            objArr[0] = dVar;
            objArr[1] = dVar2;
            objArr[2] = dVar3;
            objArr[3] = Integer.valueOf(i3);
            if (com.tencent.qqcamerakit.capture.camerastrategy.a.f344888b) {
                objArr[4] = Integer.valueOf(i16);
            } else {
                objArr[4] = str;
            }
            E = i17;
            this.f344794d.obtainMessage(i18, objArr).sendToTarget();
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    protected void y(com.tencent.qqcamerakit.capture.b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bVar, Boolean.valueOf(z16));
            return;
        }
        try {
            CameraHandler cameraHandler = this.f344794d;
            if (!z16) {
                i3 = 0;
            }
            cameraHandler.obtainMessage(203, i3, 0, bVar).sendToTarget();
        } catch (RuntimeException e16) {
            o(e16);
        }
    }

    protected void z(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) surfaceTexture);
            return;
        }
        try {
            this.f344794d.obtainMessage(201, surfaceTexture).sendToTarget();
        } catch (RuntimeException e16) {
            o(e16);
        }
    }
}
