package com.tencent.mobileqq.microapp.widget.media;

import android.media.MediaRecorder;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class g implements MediaRecorder.OnInfoListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebviewContainer f246224a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f246225b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f246226c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MiniAppCamera f246227d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MiniAppCamera miniAppCamera, WebviewContainer webviewContainer, String str, int i3) {
        this.f246227d = miniAppCamera;
        this.f246224a = webviewContainer;
        this.f246225b = str;
        this.f246226c = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, miniAppCamera, webviewContainer, str, Integer.valueOf(i3));
        }
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, mediaRecorder, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("MiniAppCamera", 2, "setOnInfoListener|reson: " + i3);
        if (i3 == 800) {
            this.f246227d.b(this.f246224a, this.f246225b, this.f246226c);
        }
    }
}
