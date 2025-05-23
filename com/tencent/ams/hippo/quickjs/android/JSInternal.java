package com.tencent.ams.hippo.quickjs.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class JSInternal extends JSValue {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSInternal(long j3, JSContext jSContext) {
        super(j3, jSContext);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), jSContext);
        }
    }
}
