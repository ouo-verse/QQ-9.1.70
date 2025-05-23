package com.tencent.mobileqq.intervideo.audioroom.webview;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* loaded from: classes15.dex */
public abstract class BaseQQVoiceWebViewPlugin extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private JsBridgeListener f238129d;

    public BaseQQVoiceWebViewPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Context) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return getClass().getSimpleName();
    }

    @Nullable
    public QQVoiceWebView getWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQVoiceWebView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            return (QQVoiceWebView) bVar.e();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @Deprecated
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (str2 == null || !str2.equalsIgnoreCase(getNameSpace())) {
            return false;
        }
        this.f238129d = jsBridgeListener;
        return handleJsRequest(str, str2, str3, strArr);
    }

    protected abstract boolean handleJsRequest(String str, String str2, String str3, String... strArr);

    protected void onJsComplete(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, obj);
            return;
        }
        JsBridgeListener jsBridgeListener = this.f238129d;
        if (jsBridgeListener != null) {
            jsBridgeListener.c(obj);
        }
    }

    protected void onJsError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        JsBridgeListener jsBridgeListener = this.f238129d;
        if (jsBridgeListener != null) {
            jsBridgeListener.e(str);
        }
    }
}
