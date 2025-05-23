package com.qq.wx.voice.util;

import com.tencent.mobileqq.text.EmotcationConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Key {
    public static final int AUTHKEYLEN = 48;

    /* renamed from: a, reason: collision with root package name */
    private static String f41104a;

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f41105b = new byte[16];

    public static int convertChar(char c16) {
        if (c16 >= '0' && c16 <= '9') {
            return c16 - '0';
        }
        char c17 = 'a';
        if (c16 < 'a' || c16 > 'f') {
            c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
            if (c16 < 'A' || c16 > 'F') {
                return -1;
            }
        }
        return (c16 - c17) + 10;
    }

    public static int convertKey(String str, byte[] bArr) {
        if (str == null || str.length() <= 0 || str.length() % 2 != 0) {
            return 0;
        }
        for (int i3 = 0; i3 < str.length(); i3 += 2) {
            int convertChar = convertChar(str.charAt(i3));
            int convertChar2 = convertChar(str.charAt(i3 + 1));
            if (convertChar >= 0 && convertChar2 >= 0) {
                bArr[i3 / 2] = (byte) ((convertChar << 4) + convertChar2);
            } else {
                return -1;
            }
        }
        return 0;
    }

    public static String getAppID() {
        return f41104a;
    }

    public static int getAppidlen() {
        return 16;
    }

    public static byte[] getKey() {
        return f41105b;
    }

    public static int parseKey(String str) {
        if (str != null && str.length() == 48) {
            f41104a = str.substring(0, 16);
            return convertKey(str.substring(16), f41105b);
        }
        return -1;
    }
}
