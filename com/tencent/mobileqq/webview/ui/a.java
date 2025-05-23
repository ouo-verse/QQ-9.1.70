package com.tencent.mobileqq.webview.ui;

import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.v;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final v f314845a;

    /* renamed from: b, reason: collision with root package name */
    public String f314846b;

    public a(v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar);
        } else {
            this.f314846b = null;
            this.f314845a = vVar;
        }
    }

    public void a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        } else {
            if (z16) {
                if (!TextUtils.isEmpty(str)) {
                    this.f314846b = str;
                    return;
                }
                return;
            }
            this.f314846b = str;
        }
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        TouchWebView u16 = this.f314845a.u();
        if (u16 != null && !TextUtils.isEmpty(this.f314846b)) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("code", 0);
                jSONObject.put("message", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                jSONObject2.put("subIndex", i3);
                jSONObject.put("data", jSONObject2);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            u16.callJs(WebViewPlugin.toJsScript(this.f314846b, jSONObject, null));
        }
    }
}
