package com.tencent.avcore.camera.callback;

import android.graphics.SurfaceTexture;
import com.tencent.avcore.camera.callback.a;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends a implements SurfaceTexture.OnFrameAvailableListener {
    static IPatchRedirector $redirector_;

    public e(com.tencent.avcore.camera.b bVar, c cVar) {
        super(bVar, cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) cVar);
        }
    }

    @Override // com.tencent.avcore.camera.callback.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.avcore.camera.callback.a
    public void f(long j3, SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), surfaceTexture);
            return;
        }
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(this);
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i("SurfaceTag", "setPreviewCallback, seq[" + j3 + "], surfaceTexture[" + surfaceTexture + "]");
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceTexture);
            return;
        }
        com.tencent.avcore.camera.data.c.d(surfaceTexture);
        a(this.f77407h);
        int i3 = com.tencent.avcore.camera.b.f77378u;
        int i16 = com.tencent.avcore.camera.b.f77379v;
        f fVar = this.f77404d;
        int i17 = this.f77407h.f77410a;
        int k3 = this.f77405e.k();
        int i18 = com.tencent.avcore.camera.b.f77382y;
        boolean B = this.f77405e.B();
        a.C0780a c0780a = this.f77407h;
        fVar.a(i17, k3, i18, B, c0780a.f77412c, c0780a.f77413d, c0780a.f77411b, 0, i3, i16);
        if (this.f77406f != null) {
            com.tencent.avcore.camera.data.c k16 = com.tencent.avcore.camera.data.c.k();
            long j3 = this.f77404d.f77424k;
            int i19 = com.tencent.avcore.camera.b.f77380w;
            a.C0780a c0780a2 = this.f77407h;
            int i26 = c0780a2.f77410a;
            int i27 = c0780a2.f77411b;
            if (this.f77405e.k() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            k16.g(j3, surfaceTexture, i3, i16, i19, i26, i27, z16, com.tencent.avcore.camera.b.f77382y, System.currentTimeMillis());
            this.f77406f.onPreviewData(k16);
        }
    }
}
