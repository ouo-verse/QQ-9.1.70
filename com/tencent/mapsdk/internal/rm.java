package com.tencent.mapsdk.internal;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes9.dex */
public class rm {

    /* renamed from: a, reason: collision with root package name */
    private static final int f150101a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static int f150102b;

    public static void a(Context context) {
        synchronized (rm.class) {
            f150102b = my.a(context).b(et.f148323z);
        }
    }

    public static void a(Context context, int i3) {
        synchronized (rm.class) {
            f150102b = i3;
            my.a(context).a(et.f148323z, i3);
        }
    }

    public static int a() {
        int i3;
        synchronized (rm.class) {
            i3 = f150102b;
        }
        return i3;
    }
}
