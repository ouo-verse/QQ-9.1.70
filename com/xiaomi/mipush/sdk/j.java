package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.cg;
import com.xiaomi.push.dd;

/* compiled from: P */
/* loaded from: classes28.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f388065a = false;

    /* renamed from: b, reason: collision with root package name */
    private static jz4.a f388066b;

    /* JADX INFO: Access modifiers changed from: protected */
    public static jz4.a a() {
        return f388066b;
    }

    public static void b(Context context, jz4.a aVar) {
        f388066b = aVar;
        c(context);
    }

    public static void c(Context context) {
        boolean z16;
        jz4.a aVar = f388066b;
        boolean z17 = false;
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z18 = f388065a;
        if (!z18) {
            z17 = z16;
        }
        boolean z19 = true ^ z18;
        dd ddVar = null;
        if (!z17) {
            aVar = null;
        }
        if (z19) {
            ddVar = dd.a(context);
        }
        jz4.c.r(new cg(aVar, ddVar));
    }
}
