package com.tencent.mobileqq.guild.feed.feedsquare.adapter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\u001c\u0010\u000e\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR*\u0010\u000e\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/a;", "T", "", "other", "", "equals", "", "hashCode", "a", "Ljava/lang/Object;", "v", "Lkotlin/Function2;", "b", "Lkotlin/jvm/functions/Function2;", "eq", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final T v;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<T, T, Boolean> eq;

    /* JADX WARN: Multi-variable type inference failed */
    public a(T t16, @NotNull Function2<? super T, ? super T, Boolean> eq5) {
        Intrinsics.checkNotNullParameter(eq5, "eq");
        this.v = t16;
        this.eq = eq5;
    }

    public boolean equals(@Nullable Object other) {
        a aVar;
        Function2<T, T, Boolean> function2 = this.eq;
        T t16 = this.v;
        T t17 = null;
        if (other instanceof a) {
            aVar = (a) other;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            t17 = aVar.v;
        }
        return function2.invoke(t16, t17).booleanValue();
    }

    public int hashCode() {
        T t16 = this.v;
        if (t16 != null) {
            return t16.hashCode();
        }
        return 0;
    }
}
