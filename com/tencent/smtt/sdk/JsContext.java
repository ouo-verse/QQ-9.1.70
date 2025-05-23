package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class JsContext {

    /* renamed from: a, reason: collision with root package name */
    private final JsVirtualMachine f368963a;

    /* renamed from: b, reason: collision with root package name */
    private final IX5JsContext f368964b;

    /* renamed from: c, reason: collision with root package name */
    private ExceptionHandler f368965c;

    /* renamed from: d, reason: collision with root package name */
    private String f368966d;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ExceptionHandler {
        void handleException(JsContext jsContext, JsError jsError);
    }

    public JsContext(Context context) {
        this(new JsVirtualMachine(context));
    }

    public static JsContext current() {
        return (JsContext) X5JsCore.a();
    }

    public void addJavascriptInterface(Object obj, String str) {
        this.f368964b.addJavascriptInterface(obj, str);
    }

    public void destroy() {
        this.f368964b.destroy();
    }

    public void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback, null);
    }

    public JsValue evaluateScript(String str) {
        return evaluateScript(str, null);
    }

    public void evaluateScriptAsync(String str, final android.webkit.ValueCallback<JsValue> valueCallback, URL url) {
        android.webkit.ValueCallback<IX5JsValue> valueCallback2;
        if (valueCallback == null) {
            valueCallback2 = null;
        } else {
            valueCallback2 = new android.webkit.ValueCallback<IX5JsValue>() { // from class: com.tencent.smtt.sdk.JsContext.1
                @Override // android.webkit.ValueCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(IX5JsValue iX5JsValue) {
                    JsValue jsValue;
                    android.webkit.ValueCallback valueCallback3 = valueCallback;
                    if (iX5JsValue == null) {
                        jsValue = null;
                    } else {
                        jsValue = new JsValue(JsContext.this, iX5JsValue);
                    }
                    valueCallback3.onReceiveValue(jsValue);
                }
            };
        }
        this.f368964b.evaluateScriptAsync(str, valueCallback2, url);
    }

    public ExceptionHandler exceptionHandler() {
        return this.f368965c;
    }

    public byte[] getNativeBuffer(int i3) {
        return this.f368964b.getNativeBuffer(i3);
    }

    public int getNativeBufferId() {
        return this.f368964b.getNativeBufferId();
    }

    public String name() {
        return this.f368966d;
    }

    public void removeJavascriptInterface(String str) {
        this.f368964b.removeJavascriptInterface(str);
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler) {
        this.f368965c = exceptionHandler;
        if (exceptionHandler == null) {
            this.f368964b.setExceptionHandler(null);
        } else {
            this.f368964b.setExceptionHandler(new android.webkit.ValueCallback<IX5JsError>() { // from class: com.tencent.smtt.sdk.JsContext.2
                @Override // android.webkit.ValueCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(IX5JsError iX5JsError) {
                    JsContext.this.f368965c.handleException(JsContext.this, new JsError(iX5JsError));
                }
            });
        }
    }

    public void setName(String str) {
        this.f368966d = str;
        this.f368964b.setName(str);
    }

    public int setNativeBuffer(int i3, byte[] bArr) {
        return this.f368964b.setNativeBuffer(i3, bArr);
    }

    public void stealValueFromOtherCtx(String str, JsContext jsContext, String str2) {
        this.f368964b.stealValueFromOtherCtx(str, jsContext.f368964b, str2);
    }

    public JsVirtualMachine virtualMachine() {
        return this.f368963a;
    }

    public JsContext(JsVirtualMachine jsVirtualMachine) {
        if (jsVirtualMachine != null) {
            this.f368963a = jsVirtualMachine;
            IX5JsContext a16 = jsVirtualMachine.a();
            this.f368964b = a16;
            try {
                a16.setPerContextData(this);
                return;
            } catch (AbstractMethodError unused) {
                return;
            }
        }
        throw new IllegalArgumentException("The virtualMachine value can not be null");
    }

    public void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback, URL url) {
        this.f368964b.evaluateJavascript(str, valueCallback, url);
    }

    public JsValue evaluateScript(String str, URL url) {
        IX5JsValue evaluateScript = this.f368964b.evaluateScript(str, url);
        if (evaluateScript == null) {
            return null;
        }
        return new JsValue(this, evaluateScript);
    }
}
