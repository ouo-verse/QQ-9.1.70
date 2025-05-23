package com.tencent.mobileqq.openpay.api;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OpenApiFactory {
    static IPatchRedirector $redirector_;

    public OpenApiFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static IOpenApi getInstance(Context context, String str) {
        return getInstance(context);
    }

    public static IOpenApi getInstance(Context context) {
        if (context == null) {
            return null;
        }
        return new OpenApiImpl(context);
    }
}
