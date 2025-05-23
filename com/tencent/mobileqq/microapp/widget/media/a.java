package com.tencent.mobileqq.microapp.widget.media;

import android.hardware.Camera;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class a implements Camera.AutoFocusCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CameraSurfaceView f246216a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CameraSurfaceView cameraSurfaceView) {
        this.f246216a = cameraSurfaceView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cameraSurfaceView);
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z16, Camera camera2) {
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            f16 = this.f246216a.f();
            this.f246216a.a(f16);
        } else {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), camera2);
        }
    }
}
