package com.tencent.weiyun.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Utils {
    static IPatchRedirector $redirector_ = null;
    private static final String SP_NAME = "com.tencent.weiyun.pref.device_info";

    Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String bytes2HexStr(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : bArr) {
                sb5.append(String.format("%02X", Byte.valueOf(b16)));
            }
            return sb5.toString();
        }
        return "";
    }

    private static String getSpString(Context context, String str, String str2) {
        if (context == null) {
            return str2;
        }
        return context.getSharedPreferences(SP_NAME, 0).getString(str, str2);
    }

    public static byte[] hexStr2Bytes(String str) {
        int length = str.length();
        if ((length & 1) == 0) {
            byte[] bArr = new byte[length >> 1];
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                int i17 = i3 + 1;
                bArr[i16] = (byte) (((Character.digit(str.charAt(i3), 16) << 4) | Character.digit(str.charAt(i17), 16)) & 255);
                i16++;
                i3 = i17 + 1;
            }
            return bArr;
        }
        throw new RuntimeException("Odd number of characters.");
    }

    public static String makeStringWithLength(String str, int i3) {
        StringBuilder sb5 = new StringBuilder(str);
        while (sb5.length() <= i3) {
            sb5.append(UUID.randomUUID().toString());
        }
        return sb5.substring(0, i3);
    }

    private static void saveSpString(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, 0);
        if (str2 == null) {
            sharedPreferences.edit().remove(str).commit();
        } else {
            sharedPreferences.edit().putString(str, str2).commit();
        }
    }

    public static byte[] str2Md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            return str.getBytes();
        }
    }
}
