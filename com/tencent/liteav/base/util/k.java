package com.tencent.liteav.base.util;

/* compiled from: P */
/* loaded from: classes7.dex */
public enum k {
    NORMAL(0),
    ROTATION_90(90),
    ROTATION_180(180),
    ROTATION_270(270);


    /* renamed from: e, reason: collision with root package name */
    private static final k[] f119030e = values();
    public final int mValue;

    k(int i3) {
        this.mValue = i3;
    }

    public static k a(int i3) {
        for (k kVar : f119030e) {
            if (kVar.mValue == i3) {
                return kVar;
            }
        }
        return NORMAL;
    }

    public static boolean b(int i3) {
        if (i3 != 0 && i3 != 90 && i3 != 180 && i3 != 270) {
            return false;
        }
        return true;
    }

    public static int a(k kVar) {
        if (kVar != null) {
            return kVar.mValue;
        }
        return NORMAL.mValue;
    }
}
