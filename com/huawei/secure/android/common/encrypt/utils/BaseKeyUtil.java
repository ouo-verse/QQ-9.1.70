package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BaseKeyUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37837a = "BaseKeyUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f37838b = 16;

    /* renamed from: c, reason: collision with root package name */
    private static final int f37839c = 16;

    /* renamed from: d, reason: collision with root package name */
    private static final int f37840d = 10000;

    /* renamed from: e, reason: collision with root package name */
    private static final int f37841e = 32;

    /* renamed from: f, reason: collision with root package name */
    private static final int f37842f = 1;

    private static int a(int i3, int i16, int i17) {
        if (i16 < i3) {
            i3 = i16;
        }
        return i17 < i3 ? i17 : i3;
    }

    public static String exportHexRootKey(String str, String str2, String str3, byte[] bArr, int i3, boolean z16) {
        return HexUtil.byteArray2HexStr(exportRootKey(str, str2, str3, bArr, i3, z16));
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, boolean z16) {
        return exportRootKey(str, str2, str3, bArr, 16, z16);
    }

    public static byte[] exportRootKey32(String str, String str2, String str3, byte[] bArr, boolean z16) {
        return exportRootKey(str, str2, str3, bArr, 32, z16);
    }

    public static byte[] exportRootKey32Iteration1(String str, String str2, String str3, byte[] bArr, boolean z16) {
        return exportRootKey(str, str2, str3, bArr, 1, 32, z16);
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKeyIteration1(String str, String str2, String str3, byte[] bArr, boolean z16) {
        return exportRootKey(str, str2, str3, bArr, 1, 16, z16);
    }

    private static boolean a(int i3) {
        return i3 >= 16;
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i3, boolean z16) {
        return exportRootKey(str, str2, str3, bArr, 10000, i3, z16);
    }

    private static boolean a(int i3, byte[] bArr) {
        return a(i3) & a(bArr);
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i3, int i16, boolean z16) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        int a16 = a(hexStr2ByteArray.length, hexStr2ByteArray2.length, hexStr2ByteArray3.length);
        if (a(a16, bArr)) {
            char[] cArr = new char[a16];
            for (int i17 = 0; i17 < a16; i17++) {
                cArr[i17] = (char) ((hexStr2ByteArray[i17] ^ hexStr2ByteArray2[i17]) ^ hexStr2ByteArray3[i17]);
            }
            if (!z16) {
                b.c(f37837a, "exportRootKey: sha1");
                return PBKDF2.pbkdf2(cArr, bArr, i3, i16 * 8);
            }
            b.c(f37837a, "exportRootKey: sha256");
            return PBKDF2.pbkdf2SHA256(cArr, bArr, i3, i16 * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    private static boolean a(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static byte[] exportRootKey(String str, String str2, String str3, String str4, int i3, boolean z16) {
        return exportRootKey(str, str2, str3, HexUtil.hexStr2ByteArray(str4), i3, z16);
    }
}
