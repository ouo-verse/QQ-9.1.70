package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes11.dex */
public class HardCodeUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "HardCodeUtil";
    public static Context sContex;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sContex = BaseApplication.getContext();
        }
    }

    public HardCodeUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String qqStr(int i3) {
        try {
            return sContex.getResources().getString(i3);
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
