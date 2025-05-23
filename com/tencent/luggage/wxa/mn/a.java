package com.tencent.luggage.wxa.mn;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final CoroutineScope f134780a = new C6485a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mn.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6485a implements CoroutineScope {

        /* renamed from: a, reason: collision with root package name */
        public final CoroutineContext f134781a = EmptyCoroutineContext.INSTANCE.plus(Dispatchers.getMain().getImmediate());

        @Override // kotlinx.coroutines.CoroutineScope
        public CoroutineContext getCoroutineContext() {
            return this.f134781a;
        }
    }

    public static final CoroutineScope a() {
        return f134780a;
    }

    public static final CoroutineScope a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getContext() instanceof LifecycleOwner) {
            Object context = view.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            Lifecycle lifecycle = ((LifecycleOwner) context).getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "context as LifecycleOwner).lifecycle");
            return LifecycleKt.getCoroutineScope(lifecycle);
        }
        return f134780a;
    }
}
