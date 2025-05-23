package com.tencent.guild.aio.input.at.utils;

import android.util.SparseIntArray;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f111118a = new SparseIntArray();

    public static <T extends ze1.a<?>> T a(xe1.a<T> aVar) {
        if (aVar instanceof xe1.b) {
            return new to0.d((xe1.b) aVar);
        }
        if (aVar instanceof com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a) {
            return new bp0.a((com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a) aVar);
        }
        return null;
    }

    public static int b(int i3, int i16) {
        return f111118a.get(i3, 0) & i16;
    }

    public static boolean c(int i3, int i16) {
        SparseIntArray sparseIntArray = f111118a;
        int i17 = sparseIntArray.get(i3, 0);
        if ((i17 & i16) != 0) {
            return false;
        }
        sparseIntArray.put(i3, i16 | i17);
        return true;
    }

    public static void d(ze1.a<?> aVar) {
        if (aVar instanceof to0.d) {
            ((to0.d) aVar).destroy();
        }
    }

    public static boolean e(int i3, int i16) {
        SparseIntArray sparseIntArray = f111118a;
        int i17 = sparseIntArray.get(i3, 0);
        if ((i17 & i16) == 0) {
            return false;
        }
        sparseIntArray.put(i3, (~i16) & i17);
        return true;
    }
}
