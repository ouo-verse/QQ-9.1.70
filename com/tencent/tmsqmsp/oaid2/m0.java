package com.tencent.tmsqmsp.oaid2;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes26.dex */
public class m0 {
    public static boolean a() {
        if (l0.f380832a) {
            return l0.f380833b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void b(Context context) {
        l0.f380833b = p0.f380852f.a(l0.a(context));
        l0.f380832a = true;
    }

    public static String a(Context context) {
        if (l0.f380832a) {
            return p0.f380852f.a(l0.a(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
