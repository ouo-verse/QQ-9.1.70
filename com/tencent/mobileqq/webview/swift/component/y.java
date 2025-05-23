package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;

/* compiled from: P */
/* loaded from: classes20.dex */
public class y extends b.C8976b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.biz.common.util.c f314521e;

    public y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean g(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent)).booleanValue();
        }
        com.tencent.biz.common.util.c cVar = this.f314521e;
        if (cVar != null && cVar.g(i3, i16, intent)) {
            return true;
        }
        return false;
    }

    public boolean h(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) valueCallback, (Object) fileChooserParams)).booleanValue();
        }
        if (this.f314521e == null) {
            this.f314521e = new com.tencent.biz.common.util.c();
        }
        return this.f314521e.i(this.f314441d.getActivity(), 0, valueCallback, fileChooserParams);
    }

    public void i(ValueCallback<Uri> valueCallback, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, valueCallback, str, str2);
            return;
        }
        if (this.f314521e == null) {
            this.f314521e = new com.tencent.biz.common.util.c();
        }
        this.f314521e.n(this.f314441d.getActivity(), 0, valueCallback, str, str2);
    }
}
