package com.tencent.mobileqq.search.util;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.search.BaseSearchEntryModel;

/* compiled from: P */
/* loaded from: classes18.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private static volatile z f285098a;

    public static z b() {
        return f285098a;
    }

    @NonNull
    public static z c() {
        z b16 = b();
        if (b16 == null) {
            z zVar = new z();
            f(zVar);
            return zVar;
        }
        return b16;
    }

    public static boolean d() {
        if (f285098a != null) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (f285098a != null) {
            return true;
        }
        return false;
    }

    public static void f(z zVar) {
        f285098a = zVar;
    }

    public BaseSearchEntryModel a(int i3, int i16) {
        com.tencent.mobileqq.search.i iVar = new com.tencent.mobileqq.search.i(i3, i16);
        iVar.x(256);
        return iVar;
    }
}
