package com.tencent.mobileqq.microapp.sdk;

import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BridgeInfo {
    static IPatchRedirector $redirector_;
    public int callbackId;
    private WeakReference webviewRef;

    public BridgeInfo(BaseAppBrandWebview baseAppBrandWebview, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseAppBrandWebview, i3);
        } else {
            this.webviewRef = new WeakReference(baseAppBrandWebview);
            this.callbackId = i3;
        }
    }

    public BaseAppBrandWebview getWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseAppBrandWebview) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        WeakReference weakReference = this.webviewRef;
        if (weakReference != null) {
            return (BaseAppBrandWebview) weakReference.get();
        }
        return null;
    }
}
