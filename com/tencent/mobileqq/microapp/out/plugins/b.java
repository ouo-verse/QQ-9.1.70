package com.tencent.mobileqq.microapp.out.plugins;

import android.content.Intent;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class b implements MiniAppController.ActivityResultListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246027a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f246028b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f246029c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ OtherJsPlugin f246030d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(OtherJsPlugin otherJsPlugin, String str, String str2, int i3) {
        this.f246030d = otherJsPlugin;
        this.f246027a = str;
        this.f246028b = str2;
        this.f246029c = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, otherJsPlugin, str, str2, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.microapp.sdk.MiniAppController.ActivityResultListener
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (com.tencent.mobileqq.microapp.appbrand.b.c.b(this.f246027a)) {
            com.tencent.mobileqq.microapp.appbrand.b.c.a(OtherJsPlugin.TAG, 2, this.f246027a, "doOnActivityResult requestCode=" + i3 + ",resultCode=" + i16 + ",data=" + intent);
        }
        if (i3 == 5) {
            this.f246030d.callbackSettingEvent(this.f246028b, this.f246027a, this.f246029c);
        }
    }
}
