package com.tencent.turingfd.sdk.xq;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Locale;

/* loaded from: classes27.dex */
public class Plum {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f383026a = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12392);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            new SecureRandom();
        }
    }

    public static String a(String str) {
        return str == null ? "" : str;
    }

    public static byte[] b(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toUpperCase().toCharArray();
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i16 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i16])) << 4));
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase(Locale.getDefault()));
        }
        return stringBuffer.toString();
    }

    public static String a(int i3) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb5.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(secureRandom.nextInt(62)));
        }
        return sb5.toString();
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    public static String a(byte[] bArr, String str) {
        try {
            if (str == null) {
                return new String(bArr);
            }
            return new String(bArr, str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
