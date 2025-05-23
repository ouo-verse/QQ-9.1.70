package com.tencent.turingcam;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Ckq8l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Random f381753a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20214);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f381753a = new SecureRandom();
        }
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

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes("utf-8");
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
