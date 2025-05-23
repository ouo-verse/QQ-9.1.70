package com.tencent.qfsmonet.process.common;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes22.dex */
public class MonetCommonParams {
    static IPatchRedirector $redirector_;
    private static Context mApplicationContext;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26363);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mApplicationContext = null;
        }
    }

    public MonetCommonParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public static Context getApplicationContext() {
        return mApplicationContext;
    }

    public static void saveApplicationContext(@NonNull Context context) {
        mApplicationContext = context.getApplicationContext();
    }
}
