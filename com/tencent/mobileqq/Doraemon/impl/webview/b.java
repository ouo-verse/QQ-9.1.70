package com.tencent.mobileqq.Doraemon.impl.webview;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements com.tencent.mobileqq.Doraemon.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<CustomWebView> f154217a;

    /* renamed from: b, reason: collision with root package name */
    private String f154218b;

    public b(CustomWebView customWebView, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) customWebView, (Object) jSONObject);
        } else {
            this.f154217a = new WeakReference<>(customWebView);
            this.f154218b = jSONObject.optString("__nativeAPICallID__");
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.a
    public void onComplete() {
        CustomWebView customWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!TextUtils.isEmpty(this.f154218b) && (customWebView = this.f154217a.get()) != null) {
            customWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.f154218b + "', 4]);");
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.a
    public void onFailure(int i3, String str) {
        CustomWebView customWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(this.f154218b) && (customWebView = this.f154217a.get()) != null) {
            customWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.f154218b + "', 3, " + i3 + ", '" + str + "']);");
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.a
    public void onPermission(int i3) {
        CustomWebView customWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (!TextUtils.isEmpty(this.f154218b) && (customWebView = this.f154217a.get()) != null) {
            customWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.f154218b + "', 1, " + i3 + "]);");
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.a
    public void onSuccess(JSONObject jSONObject) {
        CustomWebView customWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            return;
        }
        if (!TextUtils.isEmpty(this.f154218b) && (customWebView = this.f154217a.get()) != null) {
            customWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.f154218b + "', 2, " + jSONObject.toString() + "]);");
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.a
    public void onTrigger(JSONObject jSONObject) {
        CustomWebView customWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSONObject);
            return;
        }
        if (!TextUtils.isEmpty(this.f154218b) && (customWebView = this.f154217a.get()) != null) {
            customWebView.callJs("(window.NativeApi && NativeApi.execNativeAPICallback).apply(window, ['" + this.f154218b + "', 5, " + jSONObject.toString() + "]);");
        }
    }
}
