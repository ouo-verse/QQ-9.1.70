package com.tencent.luggage.wxa.gr;

import com.tencent.luggage.wxa.fn.c;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static int a(int i3, int i16) {
        return com.tencent.luggage.wxa.lr.a.a(i3, i16);
    }

    public static int b(int i3, int i16) {
        return a(i3, i16);
    }

    public static int c(int i3, int i16) {
        return com.tencent.luggage.wxa.lr.a.b(i3) + com.tencent.luggage.wxa.lr.a.a(i16) + i16;
    }

    public static int a(int i3, String str) {
        return com.tencent.luggage.wxa.lr.a.a(i3, str);
    }

    public static int a(int i3, boolean z16) {
        return com.tencent.luggage.wxa.lr.a.a(i3, z16);
    }

    public static int a(int i3, double d16) {
        return com.tencent.luggage.wxa.lr.a.a(i3, d16);
    }

    public static int a(int i3, float f16) {
        return com.tencent.luggage.wxa.lr.a.a(i3, f16);
    }

    public static int a(int i3, long j3) {
        return com.tencent.luggage.wxa.lr.a.a(i3, j3);
    }

    public static int a(int i3, c cVar) {
        return com.tencent.luggage.wxa.lr.a.a(i3, cVar);
    }

    public static int a(int i3, int i16, LinkedList linkedList) {
        int i17;
        int i18 = 0;
        if (linkedList == null) {
            return 0;
        }
        switch (i16) {
            case 1:
                i17 = 0;
                while (i18 < linkedList.size()) {
                    i17 += a(i3, (String) linkedList.get(i18));
                    i18++;
                }
                break;
            case 2:
                i17 = 0;
                while (i18 < linkedList.size()) {
                    i17 += a(i3, ((Integer) linkedList.get(i18)).intValue());
                    i18++;
                }
                break;
            case 3:
                i17 = 0;
                while (i18 < linkedList.size()) {
                    i17 += a(i3, ((Long) linkedList.get(i18)).longValue());
                    i18++;
                }
                break;
            case 4:
                i17 = 0;
                while (i18 < linkedList.size()) {
                    i17 += a(i3, ((Double) linkedList.get(i18)).doubleValue());
                    i18++;
                }
                break;
            case 5:
                i17 = 0;
                while (i18 < linkedList.size()) {
                    i17 += a(i3, ((Float) linkedList.get(i18)).floatValue());
                    i18++;
                }
                break;
            case 6:
                i17 = 0;
                while (i18 < linkedList.size()) {
                    i17 += a(i3, (c) linkedList.get(i18));
                    i18++;
                }
                break;
            case 7:
                i17 = 0;
                while (i18 < linkedList.size()) {
                    i17 += a(i3, ((Boolean) linkedList.get(i18)).booleanValue());
                    i18++;
                }
                break;
            case 8:
                i17 = 0;
                while (i18 < linkedList.size()) {
                    i17 += c(i3, ((com.tencent.luggage.wxa.fn.b) linkedList.get(i18)).a());
                    i18++;
                }
                break;
            default:
                throw new IllegalArgumentException("The data type was not found, the id used was " + i16);
        }
        return i17;
    }
}
