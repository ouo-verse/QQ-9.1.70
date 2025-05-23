package com.tencent.luggage.wxa.w8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public Object f144110a;

    /* renamed from: b, reason: collision with root package name */
    public Function0 f144111b;

    /* renamed from: c, reason: collision with root package name */
    public final KMutableProperty1 f144112c;

    public a(Object obj, Function0 function0, KMutableProperty1 backingProperty) {
        Intrinsics.checkNotNullParameter(backingProperty, "backingProperty");
        this.f144110a = obj;
        this.f144111b = function0;
        this.f144112c = backingProperty;
    }

    public final Object a() {
        Object obj = this.f144110a;
        if (obj != null) {
            return obj;
        }
        Function0 function0 = this.f144111b;
        Intrinsics.checkNotNull(function0);
        return function0.invoke();
    }

    public final Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.f144112c.get(a());
    }

    public final void a(Object obj, KProperty property, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.f144112c.set(a(), obj2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Function0 receiver, KMutableProperty1 backingProperty) {
        this(null, receiver, backingProperty);
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(backingProperty, "backingProperty");
    }
}
