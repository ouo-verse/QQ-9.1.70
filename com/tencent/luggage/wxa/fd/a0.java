package com.tencent.luggage.wxa.fd;

import android.content.Context;
import com.tencent.luggage.wxa.tk.n;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f125627a = new a0();

    public static final String a(Context context, String str) {
        boolean contains$default;
        if (context == null) {
            context = com.tencent.luggage.wxa.tn.z.c();
        }
        if (str == null) {
            str = "";
        }
        String ua5 = com.tencent.luggage.wxa.tk.n.a(context, str, (n.a) com.tencent.luggage.wxa.h1.e.a(n.a.class));
        Intrinsics.checkNotNullExpressionValue(ua5, "ua");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) ua5, (CharSequence) "MiniProgramEnv/android", false, 2, (Object) null);
        if (!contains$default) {
            ua5 = ua5 + " MiniProgramEnv/android";
        }
        Intrinsics.checkNotNullExpressionValue(ua5, "ua");
        return ua5;
    }
}
