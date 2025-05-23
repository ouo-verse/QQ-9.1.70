package com.tencent.luggage.wxa.tn;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static int f141590a;

    public static void a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        new h().a(context, charSequence, charSequence2);
        if (charSequence2 != null) {
            f141590a = charSequence2.toString().hashCode();
        }
    }
}
