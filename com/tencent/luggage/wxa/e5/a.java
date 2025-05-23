package com.tencent.luggage.wxa.e5;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f124538a = new a();

    public static final int a(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return obj.hashCode() & 65535;
    }

    public final Pair a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{R.attr.taskOpenEnterAnimation, R.attr.taskOpenExitAnimation});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026r.taskOpenExitAnimation))");
        Pair pair = new Pair(Integer.valueOf(obtainStyledAttributes.getResourceId(0, 0)), Integer.valueOf(obtainStyledAttributes.getResourceId(1, 0)));
        obtainStyledAttributes.recycle();
        return pair;
    }

    public static final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Pair a16 = f124538a.a((Context) activity);
        activity.overridePendingTransition(((Number) a16.component1()).intValue(), ((Number) a16.component2()).intValue());
    }
}
