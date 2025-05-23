package com.tencent.ams.hippo.quickjs.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JSBoolean extends JSValue {
    static IPatchRedirector $redirector_;
    private final boolean value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSBoolean(long j3, JSContext jSContext, boolean z16) {
        super(j3, jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), jSContext, Boolean.valueOf(z16));
        } else {
            this.value = z16;
        }
    }

    public boolean getBoolean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.value;
    }
}
