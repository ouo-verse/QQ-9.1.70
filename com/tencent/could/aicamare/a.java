package com.tencent.could.aicamare;

import android.hardware.Camera;
import com.tencent.could.aicamare.callback.CameraEventListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements Camera.AutoFocusCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f99914a;

    public a(d dVar) {
        this.f99914a = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z16, Camera camera2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f99914a.f99923e = false;
            this.f99914a.a("cameraFocus focus: " + z16);
            CameraEventListener cameraEventListener = this.f99914a.f99920b;
            if (cameraEventListener != null) {
                cameraEventListener.onAutoFocusSucceed();
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), camera2);
    }
}
