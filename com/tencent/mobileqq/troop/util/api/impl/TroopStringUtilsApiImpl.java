package com.tencent.mobileqq.troop.util.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.util.api.ITroopStringUtilsApi;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopStringUtilsApiImpl implements ITroopStringUtilsApi {
    static IPatchRedirector $redirector_;

    public TroopStringUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.util.api.ITroopStringUtilsApi
    public String cutByteByUtf8(byte[] bArr, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, i3);
        }
        if (bArr == null) {
            return null;
        }
        int i16 = i3 - 1;
        int i17 = 0;
        for (int i18 = i16; i18 >= 0 && bArr[i18] < 0; i18--) {
            i17++;
        }
        int i19 = i17 % 3;
        if (i19 == 0) {
            return new String(bArr, 0, i3, "utf-8");
        }
        if (i19 == 1) {
            return new String(bArr, 0, i16, "utf-8");
        }
        if (i19 != 2) {
            return null;
        }
        return new String(bArr, 0, i3 - 2, "utf-8");
    }
}
