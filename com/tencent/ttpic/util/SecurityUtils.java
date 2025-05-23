package com.tencent.ttpic.util;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SecurityUtils {
    private static final String TAG = "SecurityUtils";
    private static String sSignMD5;

    private static String byteArrayToHex(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i3 = 0;
        for (byte b16 : bArr) {
            int i16 = i3 + 1;
            cArr2[i3] = cArr[(b16 >>> 4) & 15];
            i3 = i16 + 1;
            cArr2[i16] = cArr[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr2);
    }

    public static String getSignMD5(Context context) {
        if (TextUtils.isEmpty(sSignMD5)) {
            sSignMD5 = Coffee.getDefaultSign();
        }
        return sSignMD5;
    }

    public static String stringMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes());
            return byteArrayToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String stringSHA1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return byteArrayToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
