package com.tencent.qqprotect.sfcfg.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqprotect.sfcfg.api.ISafeCheckUtilApi;
import com.tencent.qqprotect.sfcfg.core.a;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SafeCheckUtilApiImpl implements ISafeCheckUtilApi {
    static IPatchRedirector $redirector_;

    public SafeCheckUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqprotect.sfcfg.api.ISafeCheckUtilApi
    public int getFileMD5(String str, String str2, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, str, str2, bArr)).intValue();
        }
        return a.a(str, str2, bArr);
    }
}
