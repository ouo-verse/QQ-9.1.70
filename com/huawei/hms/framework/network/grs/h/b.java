package com.huawei.hms.framework.network.grs.h;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37039a = "b";

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f37040b = Pattern.compile("[0-9]*[a-z|A-Z]*[\u4e00-\u9fa5]*");

    public static String a(String str) {
        return a(str, KeyPropertiesCompact.DIGEST_SHA256);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i3 = 1;
        if (str.length() == 1) {
            return "*";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i16 = 0; i16 < str.length(); i16++) {
            String str2 = str.charAt(i16) + "";
            if (f37040b.matcher(str2).matches()) {
                if (i3 % 2 == 0) {
                    str2 = "*";
                }
                i3++;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    private static String a(String str, String str2) {
        String str3;
        String str4;
        try {
        } catch (UnsupportedEncodingException unused) {
            str3 = f37039a;
            str4 = "encrypt UnsupportedEncodingException";
        }
        try {
            return a(MessageDigest.getInstance(str2).digest(str.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException unused2) {
            str3 = f37039a;
            str4 = "encrypt NoSuchAlgorithmException";
            Logger.w(str3, str4);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                sb5.append("0");
            }
            sb5.append(hexString);
        }
        return sb5.toString();
    }
}
