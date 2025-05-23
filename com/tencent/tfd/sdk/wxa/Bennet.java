package com.tencent.tfd.sdk.wxa;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Bennet {
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
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = Integer.valueOf(str.substring(i16, i16 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }
}
