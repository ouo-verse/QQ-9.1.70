package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class JsVirtualMachine {

    /* renamed from: a, reason: collision with root package name */
    private final Context f368973a;

    /* renamed from: b, reason: collision with root package name */
    private final IX5JsVirtualMachine f368974b;

    /* renamed from: c, reason: collision with root package name */
    private final HashSet<WeakReference<a>> f368975c;

    public JsVirtualMachine(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IX5JsContext a() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f368974b;
        if (iX5JsVirtualMachine == null) {
            a aVar = new a(this.f368973a);
            this.f368975c.add(new WeakReference<>(aVar));
            return aVar;
        }
        return iX5JsVirtualMachine.createJsContext();
    }

    public void destroy() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f368974b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.destroy();
            return;
        }
        Iterator<WeakReference<a>> it = this.f368975c.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() != null) {
                next.get().destroy();
            }
        }
    }

    public Looper getLooper() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f368974b;
        if (iX5JsVirtualMachine != null) {
            return iX5JsVirtualMachine.getLooper();
        }
        return Looper.myLooper();
    }

    public boolean isFallback() {
        if (this.f368974b == null) {
            return true;
        }
        return false;
    }

    public void onPause() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f368974b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onPause();
            return;
        }
        Iterator<WeakReference<a>> it = this.f368975c.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() != null) {
                next.get().a();
            }
        }
    }

    public void onResume() {
        IX5JsVirtualMachine iX5JsVirtualMachine = this.f368974b;
        if (iX5JsVirtualMachine != null) {
            iX5JsVirtualMachine.onResume();
            return;
        }
        Iterator<WeakReference<a>> it = this.f368975c.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() != null) {
                next.get().b();
            }
        }
    }

    public JsVirtualMachine(Context context, Looper looper) {
        this.f368975c = new HashSet<>();
        this.f368973a = context;
        this.f368974b = X5JsCore.a(context, looper);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class a implements IX5JsContext {

        /* renamed from: a, reason: collision with root package name */
        private WebView f368976a;

        public a(Context context) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                QmX5Webview qmX5Webview = new QmX5Webview(context);
                this.f368976a = qmX5Webview;
                qmX5Webview.getSettings().setJavaScriptEnabled(true);
            } else {
                Log.e("JsContext", "in system core, JsContext can just in mainLooper, current looper is " + Looper.myLooper());
            }
        }

        public void a() {
            WebView webView = this.f368976a;
            if (webView == null) {
                return;
            }
            webView.onPause();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void addJavascriptInterface(Object obj, String str) {
            WebView webView = this.f368976a;
            if (webView == null) {
                return;
            }
            webView.addJavascriptInterface(obj, str);
            this.f368976a.loadUrl("about:blank");
        }

        public void b() {
            WebView webView = this.f368976a;
            if (webView == null) {
                return;
            }
            webView.onResume();
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void destroy() {
            WebView webView = this.f368976a;
            if (webView == null) {
                return;
            }
            webView.clearHistory();
            this.f368976a.clearCache(true);
            this.f368976a.loadUrl("about:blank");
            this.f368976a.freeMemory();
            this.f368976a.pauseTimers();
            this.f368976a.destroy();
            this.f368976a = null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateJavascript(String str, final android.webkit.ValueCallback<String> valueCallback, URL url) {
            ValueCallback<String> valueCallback2;
            WebView webView = this.f368976a;
            if (webView == null) {
                return;
            }
            if (valueCallback == null) {
                valueCallback2 = null;
            } else {
                valueCallback2 = new ValueCallback<String>() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.1
                    @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onReceiveValue(String str2) {
                        valueCallback.onReceiveValue(str2);
                    }
                };
            }
            webView.evaluateJavascript(str, valueCallback2);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public IX5JsValue evaluateScript(String str, URL url) {
            WebView webView = this.f368976a;
            if (webView == null) {
                return null;
            }
            webView.evaluateJavascript(str, null);
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void evaluateScriptAsync(String str, final android.webkit.ValueCallback<IX5JsValue> valueCallback, URL url) {
            ValueCallback<String> valueCallback2;
            WebView webView = this.f368976a;
            if (webView == null) {
                return;
            }
            if (valueCallback == null) {
                valueCallback2 = null;
            } else {
                valueCallback2 = new ValueCallback<String>() { // from class: com.tencent.smtt.sdk.JsVirtualMachine.a.2
                    @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onReceiveValue(String str2) {
                        valueCallback.onReceiveValue(null);
                    }
                };
            }
            webView.evaluateJavascript(str, valueCallback2);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public byte[] getNativeBuffer(int i3) {
            return null;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int getNativeBufferId() {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void removeJavascriptInterface(String str) {
            WebView webView = this.f368976a;
            if (webView == null) {
                return;
            }
            webView.removeJavascriptInterface(str);
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public int setNativeBuffer(int i3, byte[] bArr) {
            return -1;
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setExceptionHandler(android.webkit.ValueCallback<IX5JsError> valueCallback) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setName(String str) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void setPerContextData(Object obj) {
        }

        @Override // com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext
        public void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
        }
    }
}
