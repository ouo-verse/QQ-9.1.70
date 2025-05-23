package com.tencent.ams.hippo.quickjs.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class JSString extends JSValue {
    static IPatchRedirector $redirector_;
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSString(long j3, JSContext jSContext, String str) {
        super(j3, jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), jSContext, str);
        } else {
            this.value = str;
        }
    }

    public String getString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.value;
    }
}
