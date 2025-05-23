package com.tencent.mobileqq.mqsafeedit;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class libsafeedit {
    static IPatchRedirector $redirector_;
    private static String mpwdText;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            mpwdText = "";
        }
    }

    public libsafeedit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static byte[] byteSafeEditTextToMD5(Boolean bool) {
        String str;
        if (!bool.booleanValue() || (str = getpwdText(bool.booleanValue())) == null) {
            return null;
        }
        return MD5.toMD5Byte(StringUtil.toSemiAngleString(str));
    }

    public static boolean checkPassLegal(String str) {
        if (mpwdText.equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean checkPassLen() {
        if (mpwdText.length() < 1) {
            return true;
        }
        return false;
    }

    public static void clearPassBuffer() {
        mpwdText = "";
    }

    public static void getLoginLegal(String str) {
        if (str != null && str.length() != 0) {
            mpwdText = str;
        }
    }

    public static String getpwdText(boolean z16) {
        if (z16) {
            return mpwdText;
        }
        return null;
    }

    public static String strSafeEditTextToMD5(Boolean bool) {
        String str;
        if (!bool.booleanValue() || (str = getpwdText(bool.booleanValue())) == null) {
            return null;
        }
        return MD5.toMD5(StringUtil.toSemiAngleString(str));
    }
}
