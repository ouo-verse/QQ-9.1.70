package com.tencent.mobileqq.profilecard.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ProfileCodecUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String ADDRESS_SEPARATOR = "-";
    public static final String CODE_NO_LIMIT = "0";
    private static final String TAG = "CodecUtils";

    public ProfileCodecUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String decodeRemoteCode(long j3) {
        if (j3 == 0) {
            return "0";
        }
        StringBuilder sb5 = new StringBuilder(6);
        while (j3 != 0) {
            try {
                sb5.append((char) (j3 % 256));
                j3 >>= 8;
            } catch (OutOfMemoryError e16) {
                QLog.e(TAG, 1, "decodeRemoteCode fail.", e16);
                return "0";
            }
        }
        return sb5.reverse().toString();
    }

    public static int encodeLocCode(String str) {
        if (TextUtils.isEmpty(str) || str.equals("0")) {
            return 0;
        }
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += str.charAt(i16) << (((length - 1) - i16) * 8);
        }
        return i3;
    }
}
