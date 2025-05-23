package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class JSFunction extends JSObject {
    static IPatchRedirector $redirector_;
    private String mFuncName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSFunction(long j3, JSContext jSContext) {
        super(j3, jSContext, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), jSContext);
        }
    }

    public String getFuncName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mFuncName;
    }

    public JSValue invoke(@Nullable JSValue jSValue, JSValue[] jSValueArr) {
        long j3;
        JSValue wrapAsJSValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSValue, (Object) jSValueArr);
        }
        if (jSValue != null) {
            checkSameJSContext(jSValue);
        }
        for (JSValue jSValue2 : jSValueArr) {
            checkSameJSContext(jSValue2);
        }
        long[] jArr = new long[jSValueArr.length];
        for (int i3 = 0; i3 < jSValueArr.length; i3++) {
            jArr[i3] = jSValueArr[i3].pointer;
        }
        synchronized (this.jsContext.jsRuntime) {
            long checkClosed = this.jsContext.checkClosed();
            long j16 = this.pointer;
            if (jSValue != null) {
                j3 = jSValue.pointer;
            } else {
                j3 = 0;
            }
            wrapAsJSValue = this.jsContext.wrapAsJSValue(QuickJS.invokeValueFunction(checkClosed, j16, j3, jArr));
        }
        return wrapAsJSValue;
    }

    public JSValue invokeWithoutLock(@Nullable JSValue jSValue, @NonNull JSValue[] jSValueArr) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSValue) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSValue, (Object) jSValueArr);
        }
        if (jSValue != null) {
            checkSameJSContext(jSValue);
        }
        for (JSValue jSValue2 : jSValueArr) {
            checkSameJSContext(jSValue2);
        }
        long[] jArr = new long[jSValueArr.length];
        for (int i3 = 0; i3 < jSValueArr.length; i3++) {
            jArr[i3] = jSValueArr[i3].pointer;
        }
        long checkClosed = this.jsContext.checkClosed();
        long j16 = this.pointer;
        if (jSValue != null) {
            j3 = jSValue.pointer;
        } else {
            j3 = 0;
        }
        return this.jsContext.wrapAsJSValue(QuickJS.invokeValueFunction(checkClosed, j16, j3, jArr));
    }

    public void setFuncName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.mFuncName = str;
        }
    }
}
