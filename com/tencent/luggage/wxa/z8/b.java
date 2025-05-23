package com.tencent.luggage.wxa.z8;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b implements LifecycleOwner {

    /* renamed from: a, reason: collision with root package name */
    public static final b f146383a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f146384b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f146385a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.z8.a invoke() {
            return new com.tencent.luggage.wxa.z8.a();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(a.f146385a);
        f146384b = lazy;
    }

    public final com.tencent.luggage.wxa.z8.a a() {
        return (com.tencent.luggage.wxa.z8.a) f146384b.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return a();
    }
}
