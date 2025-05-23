package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DiyDoutuHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String DIY_EMOJI_PREFIX = "diydoutu@";

    public DiyDoutuHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getPicId(String str) {
        String str2;
        int lastIndexOf;
        int lastIndexOf2;
        if (!TextUtils.isEmpty(str) && (lastIndexOf2 = str.lastIndexOf(DIY_EMOJI_PREFIX)) >= 0) {
            str2 = str.substring(lastIndexOf2, str.length());
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str2) && (lastIndexOf = str2.lastIndexOf(".")) >= 0) {
            return str2.substring(0, lastIndexOf);
        }
        return str2;
    }
}
