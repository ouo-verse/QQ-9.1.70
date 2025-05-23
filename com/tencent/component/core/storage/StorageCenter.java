package com.tencent.component.core.storage;

import com.tencent.hy.common.store.a;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StorageCenter {
    public static boolean getBoolean(String str, boolean z16) {
        return a.a(str, z16);
    }

    public static float getFloat(String str, float f16) {
        return a.b(str, f16);
    }

    public static int getInt(String str, int i3) {
        return a.c(str, i3);
    }

    public static void putBoolean(String str, boolean z16) {
        a.d(str, z16);
    }

    public static void putFloat(String str, float f16) {
        a.e(str, f16);
    }

    public static void putInt(String str, int i3) {
        a.f(str, i3);
    }
}
