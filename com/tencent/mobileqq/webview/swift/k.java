package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public abstract class k extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected Method getJsMethod(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Method) iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3));
        }
        if (!getNameSpace().equals(str)) {
            return null;
        }
        for (Method method : getClass().getDeclaredMethods()) {
            if (method.getName().equals(str2) && method.getParameterTypes().length == i3) {
                return method;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        if (r6.f314008c == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        callJs4OpenApi(r6, 0, com.tencent.mobileqq.webview.swift.JsBridgeListener.a(0, null, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        r6.c(null);
     */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        Object invoke;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        Method jsMethod = getJsMethod(str2, str3, strArr.length);
        if (jsMethod != null) {
            try {
                if (strArr.length == 0) {
                    invoke = jsMethod.invoke(this, new Object[0]);
                } else {
                    invoke = jsMethod.invoke(this, strArr);
                }
                Class<?> returnType = jsMethod.getReturnType();
                if (returnType != Void.TYPE && returnType != Void.class) {
                    if (jsBridgeListener != null) {
                        if (jsBridgeListener.f314008c) {
                            callJs4OpenApi(jsBridgeListener, 0, JsBridgeListener.a(0, invoke, null));
                        } else {
                            jsBridgeListener.c(invoke);
                        }
                    }
                    return true;
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
