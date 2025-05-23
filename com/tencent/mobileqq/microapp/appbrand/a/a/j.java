package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class j extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private Set f245942b;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashSet hashSet = new HashSet();
        this.f245942b = hashSet;
        hashSet.add("requestPayment");
        this.f245942b.add("getLocation");
        this.f245942b.add("openLocation");
        this.f245942b.add("chooseLocation");
        this.f245942b.add("chooseVideo");
        this.f245942b.add("saveVideoToPhotosAlbum");
        this.f245942b.add("chooseImage");
        this.f245942b.add("previewImage");
        this.f245942b.add("getImageInfo");
        this.f245942b.add("saveImageToPhotosAlbum");
        this.f245942b.add("openSetting");
        this.f245942b.add("getSetting");
        this.f245942b.add("scanCode");
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.a.a.a
    public Set a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f245942b : (Set) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.a.a.a
    public String a(String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, str, str2, baseAppBrandWebview, Integer.valueOf(i3));
        }
        MiniAppController miniAppController = MiniAppController.getInstance();
        com.tencent.mobileqq.microapp.appbrand.a aVar = this.f245908a.f245924a;
        return miniAppController.handleNativeRequest(aVar.f245899d, aVar.f245896a, str, str2, baseAppBrandWebview, i3);
    }
}
