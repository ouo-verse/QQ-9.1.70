package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HexUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38003a = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f38004b = "HexUtil";

    HexUtil() {
    }

    public static String byteArray2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                sb5.append('0');
            }
            sb5.append(hexString);
        }
        return sb5.toString();
    }

    public static byte[] hexStr2ByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes("UTF-8");
            for (int i3 = 0; i3 < length; i3++) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(RelationNTPushServiceImpl.PRE_HEX_STRING);
                int i16 = i3 * 2;
                sb5.append(new String(new byte[]{bytes[i16]}, "UTF-8"));
                bArr[i3] = (byte) (((byte) (Byte.decode(sb5.toString()).byteValue() << 4)) ^ Byte.decode(RelationNTPushServiceImpl.PRE_HEX_STRING + new String(new byte[]{bytes[i16 + 1]}, "UTF-8")).byteValue());
            }
        } catch (UnsupportedEncodingException e16) {
            e = e16;
            Log.e(f38004b, "hex string 2 byte UnsupportedEncodingException or NumberFormatException : " + e.getMessage());
        } catch (NumberFormatException e17) {
            e = e17;
            Log.e(f38004b, "hex string 2 byte UnsupportedEncodingException or NumberFormatException : " + e.getMessage());
        } catch (Exception e18) {
            Log.e(f38004b, "byte array 2 hex string exception : " + e18.getMessage());
        }
        return bArr;
    }

    public static String byteArray2HexStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return byteArray2HexStr(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e16) {
            Log.e(f38004b, "byte array 2 hex string UnsupportedEncodingException : " + e16.getMessage());
            return "";
        } catch (Exception e17) {
            Log.e(f38004b, "byte array 2 hex string exception : " + e17.getMessage());
            return "";
        }
    }
}
