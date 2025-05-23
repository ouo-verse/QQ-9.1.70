package com.tencent.luggage.wxa.l3;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {
    public static final boolean a(com.tencent.luggage.wxa.d6.b bVar, Intent intent) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        return a(bVar, intent, null, 2, null);
    }

    public static final boolean b(com.tencent.luggage.wxa.d6.b bVar, Intent intent, String key) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!intent.hasExtra(key)) {
            return false;
        }
        try {
            bVar.a(intent.getByteArrayExtra(key));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final void a(com.tencent.luggage.wxa.d6.b bVar, Intent intent, String key) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(key, "key");
        intent.putExtra(key, bVar.b());
    }

    public static /* synthetic */ boolean a(com.tencent.luggage.wxa.d6.b bVar, Intent intent, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "action";
        }
        return b(bVar, intent, str);
    }
}
