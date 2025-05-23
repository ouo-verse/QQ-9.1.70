package com.tencent.qmsp.oaid2;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public class m0 {
    public static boolean a() {
        if (l0.f344241a) {
            return l0.f344242b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void b(Context context) {
        l0.f344242b = p0.f344260f.a(l0.a(context));
        l0.f344241a = true;
    }

    public static String a(Context context) {
        if (l0.f344241a) {
            return p0.f344260f.a(l0.a(context), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
