package com.tencent.mobileqq.microapp.appbrand.a.a;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    Set f245909b;

    /* renamed from: c, reason: collision with root package name */
    public long f245910c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f245909b = null;
        HashSet hashSet = new HashSet();
        this.f245909b = hashSet;
        hashSet.add("showKeyboard");
        this.f245909b.add("hideKeyboard");
        this.f245909b.add(InputJsPlugin.EVENT_UPDATE_INPUT);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.a.a.a
    public Set a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f245909b : (Set) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.a.a.a
    public String a(String str, String str2, BaseAppBrandWebview baseAppBrandWebview, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, str, str2, baseAppBrandWebview, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("InputJsPlugin", 2, "handleNativeRequest: " + str + " |jsonParams: " + str2 + " |callbackId:" + i3);
        }
        if ("showKeyboard".equals(str)) {
            if (System.currentTimeMillis() - this.f245910c <= 1000) {
                return "";
            }
            this.f245910c = System.currentTimeMillis();
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new c(this, baseAppBrandWebview, str2, i3), 200L);
            return "";
        }
        if ("hideKeyboard".equals(str)) {
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new d(this, baseAppBrandWebview, str2, i3));
            return "";
        }
        if (!InputJsPlugin.EVENT_UPDATE_INPUT.equals(str)) {
            return "";
        }
        com.tencent.mobileqq.microapp.appbrand.b.a.a(new e(this, str2, baseAppBrandWebview, str, i3));
        return "";
    }
}
