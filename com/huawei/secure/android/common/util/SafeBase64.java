package com.huawei.secure.android.common.util;

import android.util.Base64;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SafeBase64 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38015a = "SafeBase64";

    SafeBase64() {
    }

    public static byte[] decode(byte[] bArr, int i3) {
        try {
            return Base64.decode(bArr, i3);
        } catch (Exception e16) {
            Log.e(f38015a, e16.getClass().getSimpleName() + " , message0 : " + e16.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i3) {
        try {
            return Base64.encode(bArr, i3);
        } catch (Exception e16) {
            Log.e(f38015a, e16.getClass().getSimpleName() + " , message3 : " + e16.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i3) {
        try {
            return Base64.encodeToString(bArr, i3);
        } catch (Exception e16) {
            Log.e(f38015a, e16.getClass().getSimpleName() + " , message5 : " + e16.getMessage());
            return "";
        }
    }

    public static byte[] decode(byte[] bArr, int i3, int i16, int i17) {
        try {
            return Base64.decode(bArr, i3, i16, i17);
        } catch (Exception e16) {
            Log.e(f38015a, e16.getClass().getSimpleName() + " , message1 : " + e16.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i3, int i16, int i17) {
        try {
            return Base64.encode(bArr, i3, i16, i17);
        } catch (Exception e16) {
            Log.e(f38015a, e16.getClass().getSimpleName() + " , message4 : " + e16.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i3, int i16, int i17) {
        try {
            return Base64.encodeToString(bArr, i3, i16, i17);
        } catch (Exception e16) {
            Log.e(f38015a, e16.getClass().getSimpleName() + " , message6 : " + e16.getMessage());
            return "";
        }
    }

    public static byte[] decode(String str, int i3) {
        try {
            return Base64.decode(str, i3);
        } catch (Exception e16) {
            Log.e(f38015a, e16.getClass().getSimpleName() + " , message2 : " + e16.getMessage());
            return new byte[0];
        }
    }
}
