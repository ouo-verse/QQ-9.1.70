package com.tencent.ams.hippo.quickjs.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JSObject extends JSValue {
    static IPatchRedirector $redirector_ = null;
    public static int PROP_FLAG_CONFIGURABLE = 0;
    public static int PROP_FLAG_ENUMERABLE = 0;
    private static final int PROP_FLAG_MASK = 7;
    public static int PROP_FLAG_WRITABLE;
    private final Object javaObject;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14294);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        PROP_FLAG_CONFIGURABLE = 1;
        PROP_FLAG_WRITABLE = 2;
        PROP_FLAG_ENUMERABLE = 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSObject(long j3, JSContext jSContext, Object obj) {
        super(j3, jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), jSContext, obj);
        } else {
            this.javaObject = obj;
        }
    }

    public void defineProperty(int i3, JSValue jSValue, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), jSValue, Integer.valueOf(i16));
            return;
        }
        if ((i16 & (-8)) == 0) {
            synchronized (this.jsContext.jsRuntime) {
                this.jsContext.checkClosed();
                if (!QuickJS.defineValueProperty(this.jsContext.pointer, this.pointer, i3, jSValue.pointer, i16)) {
                    throw new JSEvaluationException(QuickJS.getException(this.jsContext.pointer));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Invalid flags: " + i16);
    }

    public Object getJavaObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.javaObject;
    }

    public JSValue getProperty(int i3) {
        JSValue wrapAsJSValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSValue) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        synchronized (this.jsContext.jsRuntime) {
            wrapAsJSValue = this.jsContext.wrapAsJSValue(QuickJS.getValueProperty(this.jsContext.checkClosed(), this.pointer, i3));
        }
        return wrapAsJSValue;
    }

    public void setProperty(int i3, JSValue jSValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) jSValue);
            return;
        }
        checkSameJSContext(jSValue);
        synchronized (this.jsContext.jsRuntime) {
            this.jsContext.checkClosed();
            if (!QuickJS.setValueProperty(this.jsContext.pointer, this.pointer, i3, jSValue.pointer)) {
                throw new JSEvaluationException(QuickJS.getException(this.jsContext.pointer));
            }
        }
    }

    public JSValue getProperty(String str) {
        JSValue wrapAsJSValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JSValue) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        synchronized (this.jsContext.jsRuntime) {
            wrapAsJSValue = this.jsContext.wrapAsJSValue(QuickJS.getValueProperty(this.jsContext.checkClosed(), this.pointer, str));
        }
        return wrapAsJSValue;
    }

    public void defineProperty(String str, JSValue jSValue, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, jSValue, Integer.valueOf(i3));
            return;
        }
        if ((i3 & (-8)) == 0) {
            synchronized (this.jsContext.jsRuntime) {
                this.jsContext.checkClosed();
                if (!QuickJS.defineValueProperty(this.jsContext.pointer, this.pointer, str, jSValue.pointer, i3)) {
                    throw new JSEvaluationException(QuickJS.getException(this.jsContext.pointer));
                }
            }
            return;
        }
        throw new IllegalArgumentException("Invalid flags: " + i3);
    }

    public void setProperty(String str, JSValue jSValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) jSValue);
            return;
        }
        checkSameJSContext(jSValue);
        synchronized (this.jsContext.jsRuntime) {
            this.jsContext.checkClosed();
            if (!QuickJS.setValueProperty(this.jsContext.pointer, this.pointer, str, jSValue.pointer)) {
                throw new JSEvaluationException(QuickJS.getException(this.jsContext.pointer));
            }
        }
    }
}
