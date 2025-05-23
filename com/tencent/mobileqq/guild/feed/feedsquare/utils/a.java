package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00028\u00010\u0003BG\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u00a2\u0006\u0004\b \u0010!J&\u0010\b\u001a\u00028\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR+\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "K", "T", "Lkotlin/properties/ReadOnlyProperty;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", HippyTextInputController.COMMAND_getValue, "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "keys", "Lkotlin/Function2;", "", "b", "Lkotlin/jvm/functions/Function2;", "getEquals", "()Lkotlin/jvm/functions/Function2;", "equals", "Lkotlin/Function1;", "c", "Lkotlin/jvm/functions/Function1;", "getCompute", "()Lkotlin/jvm/functions/Function1;", "compute", "d", "Ljava/lang/Object;", "_value", "e", "lastKey", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a<K, T> implements ReadOnlyProperty<Object, T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<K> keys;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<K, K, Boolean> equals;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<K, T> compute;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private T _value;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private K lastKey;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function0<? extends K> keys, @NotNull Function2<? super K, ? super K, Boolean> equals, @NotNull Function1<? super K, ? extends T> compute) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(equals, "equals");
        Intrinsics.checkNotNullParameter(compute, "compute");
        this.keys = keys;
        this.equals = equals;
        this.compute = compute;
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public T getValue(@Nullable Object thisRef, @NotNull KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        K invoke = this.keys.invoke();
        if (this._value == null || !this.equals.invoke(invoke, this.lastKey).booleanValue()) {
            this._value = this.compute.invoke(invoke);
            this.lastKey = invoke;
        }
        T t16 = this._value;
        Intrinsics.checkNotNull(t16);
        return t16;
    }
}
