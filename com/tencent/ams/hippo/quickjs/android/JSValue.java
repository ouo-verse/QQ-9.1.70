package com.tencent.ams.hippo.quickjs.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class JSValue {
    static IPatchRedirector $redirector_;
    final JSContext jsContext;
    final long pointer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSValue(long j3, JSContext jSContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), jSContext);
        } else {
            this.pointer = j3;
            this.jsContext = jSContext;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends JSValue> T cast(Class<T> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        }
        if (cls.isInstance(this)) {
            return this;
        }
        throw new JSDataException("expected: " + cls.getSimpleName() + ", actual: " + getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void checkSameJSContext(JSValue jSValue) {
        if (jSValue.jsContext == this.jsContext) {
        } else {
            throw new IllegalStateException("Two JSValues are not from the same JSContext");
        }
    }
}
