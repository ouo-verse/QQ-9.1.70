package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.FontSettingManager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    private static char[] f307428a = new char[32];

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f307429b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String a(long j3) {
        return b(j3, 160);
    }

    public static String b(long j3, int i3) {
        char c16;
        int i16;
        int i17;
        if (j3 < 0) {
            j3 = 0;
        }
        double d16 = j3;
        if (j3 < 1048576) {
            if (j3 < 1024) {
                c16 = 'B';
            } else {
                d16 /= 1024.0d;
                c16 = 'K';
            }
        } else if (j3 < 1073741824) {
            d16 /= 1048576.0d;
            c16 = 'M';
        } else {
            d16 /= 1.073741824E9d;
            c16 = 'G';
        }
        int i18 = (int) (0.005d + d16);
        if (i18 < 100) {
            if (i18 < 10) {
                i16 = 1;
            } else {
                i16 = 2;
            }
        } else if (i18 < 1000) {
            i16 = 3;
        } else if (i18 < 10000) {
            i16 = 4;
        } else {
            i16 = 5;
        }
        if (c16 != 'B') {
            if (FontSettingManager.getFontLevel() > 18.0f && i3 < 160) {
                i17 = i16 + 2;
            } else {
                i18 = (int) ((d16 * 100.0d) + 0.5d);
                i17 = i16 + 5;
            }
        } else {
            i17 = i16 + 1;
        }
        char[] cArr = f307428a;
        if (i17 > cArr.length) {
            cArr = new char[i17];
        }
        int i19 = i17 - 1;
        cArr[i19] = 'B';
        if (c16 != 'B') {
            if (FontSettingManager.getFontLevel() > 18.0f && i3 < 160) {
                i19--;
                cArr[i19] = c16;
            } else {
                int i26 = i19 - 1;
                cArr[i26] = c16;
                int i27 = i26 - 1;
                char[] cArr2 = f307429b;
                cArr[i27] = cArr2[i18 % 10];
                int i28 = i18 / 10;
                int i29 = i27 - 1;
                cArr[i29] = cArr2[i28 % 10];
                i18 = i28 / 10;
                i19 = i29 - 1;
                cArr[i19] = '.';
            }
        }
        do {
            i19--;
            cArr[i19] = f307429b[i18 % 10];
            i18 /= 10;
            if (i18 <= 0) {
                break;
            }
        } while (i19 > 0);
        return new String(cArr, 0, i17);
    }
}
