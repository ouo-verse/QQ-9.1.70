package com.tencent.mobileqq.qqexpand.utils;

import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f264086a = {"coverVertical.png", "coverVerticalSmall.png", "coverHorizontal.png", "expend_match_ellipisis.json", "expand_voice_animation2.json", "fire/fire_00.png", "bomb/bomb_00.png"};

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f264087b;

    static {
        HashSet hashSet = new HashSet(1);
        f264087b = hashSet;
        hashSet.add("matchAndAIOPageForNewVersion");
    }

    public static String a(int i3) {
        String str;
        if (i3 == 1) {
            str = "coverVertical.png";
        } else if (i3 == 2) {
            str = "coverVerticalSmall.png";
        } else {
            str = "coverHorizontal.png";
        }
        return b(str);
    }

    public static String b(String str) {
        return String.format("%s/%s", d(), str);
    }

    public static String[] c(String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                strArr2[i3] = b(strArr[i3]);
            }
            return strArr2;
        }
        return null;
    }

    public static String d() {
        return String.format("%s/matchChat", e.f());
    }

    private static boolean e(String[] strArr) {
        return e.g(c(strArr));
    }

    public static boolean f() {
        return e(f264086a);
    }
}
