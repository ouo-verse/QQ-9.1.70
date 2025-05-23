package com.tencent.kuikly.core.base;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002B\u001b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00018\u00008\b@\bX\u0088\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/kuikly/core/base/r;", "T", "Lkotlin/properties/ReadOnlyProperty;", "Lcom/tencent/kuikly/core/base/p;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Lcom/tencent/kuikly/core/base/p;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "initializer", "b", "Ljava/lang/String;", "_lastPagerId", "c", "Ljava/lang/Object;", "_value", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class r<T> implements ReadOnlyProperty<p, T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function1<String, T> initializer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String _lastPagerId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private T _value;

    /* JADX WARN: Multi-variable type inference failed */
    public r(Function1<? super String, ? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T getValue(p thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        String pagerId = thisRef.getPagerId();
        if (!Intrinsics.areEqual(pagerId, this._lastPagerId) || this._value == null) {
            this._value = this.initializer.invoke(pagerId);
        }
        this._lastPagerId = thisRef.getPagerId();
        return this._value;
    }
}
