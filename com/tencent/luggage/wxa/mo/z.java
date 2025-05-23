package com.tencent.luggage.wxa.mo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final z f134857a = new z();

    public static final void a(ViewGroup parent, Class viewClass, y yVar) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Constructor declaredConstructor = viewClass.getDeclaredConstructor(Context.class);
        declaredConstructor.setAccessible(true);
        View view = (View) declaredConstructor.newInstance(parent.getContext());
        if (yVar != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            yVar.a(view);
        }
        parent.addView(view);
    }
}
