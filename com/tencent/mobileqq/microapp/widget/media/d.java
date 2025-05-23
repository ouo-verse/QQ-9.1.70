package com.tencent.mobileqq.microapp.widget.media;

import android.hardware.Camera;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class d implements Camera.PictureCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246218a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f246219b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebviewContainer f246220c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f246221d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MiniAppCamera miniAppCamera, String str, String str2, WebviewContainer webviewContainer, int i3) {
        this.f246218a = str;
        this.f246219b = str2;
        this.f246220c = webviewContainer;
        this.f246221d = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, miniAppCamera, str, str2, webviewContainer, Integer.valueOf(i3));
        }
    }

    @Override // android.hardware.Camera.PictureCallback
    public void onPictureTaken(byte[] bArr, Camera camera2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, (Object) camera2);
        } else {
            CameraSurfaceView.f246169a.startPreview();
            ThreadManagerV2.excute(new e(this, bArr), 16, null, true);
        }
    }
}
