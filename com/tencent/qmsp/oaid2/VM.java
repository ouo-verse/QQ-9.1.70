package com.tencent.qmsp.oaid2;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VM {
    static IPatchRedirector $redirector_;

    public VM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getVendorInfo(Context context, IVendorCallback iVendorCallback) {
        return new VendorManager().getVendorInfo(context, iVendorCallback);
    }
}
