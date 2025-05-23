package com.tencent.aelight.camera.aioeditor.capture.text;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes32.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f66968a = {0, 64, 91, 96, 123, 8543, 8576, 12295, 19967, 40870, 65295, 65306, 65312, 65339, 65344, 65371, Integer.MAX_VALUE};

    /* renamed from: b, reason: collision with root package name */
    public static String f66969b = "[a-zA-Z0-9\\u4e00-\\u9fa5]";

    public static int a(char c16) {
        if (c(c16)) {
            return 3;
        }
        int binarySearch = Arrays.binarySearch(f66968a, (int) c16);
        if (binarySearch == -16 || binarySearch == -14 || binarySearch == -12 || binarySearch == -10 || binarySearch == -7 || binarySearch == -5 || binarySearch == -3 || binarySearch == 5) {
            return 0;
        }
        return Character.isHighSurrogate(c16) ? 2 : 1;
    }

    public static int b(String str) {
        return Character.codePointCount(str, 0, str.length());
    }

    private static boolean c(char c16) {
        if (c16 >= '0' && c16 <= '9') {
            return true;
        }
        return false;
    }
}
