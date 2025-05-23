package com.tencent.zplan.common.utils;

import android.os.Build;
import android.util.Log;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static char[] f385289a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length == 16) {
            char[] cArr = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = bArr[i16];
                int i17 = i3 + 1;
                char[] cArr2 = f385289a;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr[i17] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            if (Build.VERSION.SDK_INT == 23) {
                return String.valueOf(cArr);
            }
            return new String(cArr);
        }
        return "";
    }

    private static void b(String str, Throwable th5) {
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            a16.e("andygzyu-MD5", 1, str, th5);
        } else {
            Log.e("andygzyu-MD5", str, th5);
        }
    }

    public static String c(String str) {
        byte[] d16 = d(str);
        if (d16 == null) {
            return "";
        }
        return a(d16);
    }

    public static byte[] d(String str) {
        try {
            try {
                try {
                    return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e16) {
                    b("toMD5Byte for " + str + ", source.getBytes crash!", e16);
                    return null;
                }
            } catch (Exception e17) {
                b("toMD5Byte for " + str + ", MessageDigest.getInstance crash!", e17);
                return null;
            }
        } catch (Throwable th5) {
            b("toMD5Byte for " + str + " exception", th5);
            return null;
        }
    }
}
