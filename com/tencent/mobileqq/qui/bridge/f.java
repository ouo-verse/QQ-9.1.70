package com.tencent.mobileqq.qui.bridge;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f implements td0.e {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // td0.e
    public boolean getBoolean(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        return QMMKV.from(RFWApplication.getApplication(), "common_mmkv_configurations").decodeBool(str, z16);
    }
}
