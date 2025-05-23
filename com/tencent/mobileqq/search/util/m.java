package com.tencent.mobileqq.search.util;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f285058a = {1, 2, 3, 4};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f285059b = {6};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f285060c = {7};

    public static int a(int i3) {
        for (int i16 : f285058a) {
            if (i16 == i3) {
                return 1;
            }
        }
        for (int i17 : f285059b) {
            if (i17 == i3) {
                return 2;
            }
        }
        for (int i18 : f285060c) {
            if (i18 == i3) {
                return 3;
            }
        }
        return 0;
    }
}
