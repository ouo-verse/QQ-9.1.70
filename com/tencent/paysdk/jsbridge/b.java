package com.tencent.paysdk.jsbridge;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.paysdk.api.o;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class b {
    static IPatchRedirector $redirector_;
    protected o mWebView;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callJsFunction(String str, JSONObject jSONObject, o.a aVar) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, jSONObject, aVar);
            return;
        }
        if (jSONObject != null) {
            str2 = "javascript:(" + str + "(" + jSONObject.toString() + "))";
        } else {
            str2 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + str + "()";
        }
        this.mWebView.l(str2, aVar);
    }

    public abstract String getName();

    public abstract void onJsDestroy();
}
