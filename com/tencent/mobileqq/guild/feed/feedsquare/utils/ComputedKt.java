package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\"-\u0010\u0006\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"1\u0010\n\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lkotlin/Function2;", "", "", "a", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "ObjectEquals", "", "b", "getArrayContentEquals", "ArrayContentEquals", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ComputedKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Function2<Object, Object, Boolean> f219274a = new Function2<Object, Object, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.ComputedKt$ObjectEquals$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final Boolean invoke(@Nullable Object obj, @Nullable Object obj2) {
            return Boolean.valueOf(Intrinsics.areEqual(obj, obj2));
        }
    };

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Function2<Object[], Object[], Boolean> f219275b = new Function2<Object[], Object[], Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.ComputedKt$ArrayContentEquals$1
        @Override // kotlin.jvm.functions.Function2
        @NotNull
        public final Boolean invoke(@NotNull Object[] a16, @NotNull Object[] b16) {
            Intrinsics.checkNotNullParameter(a16, "a");
            Intrinsics.checkNotNullParameter(b16, "b");
            return Boolean.valueOf(ArraysKt.contentDeepEquals(a16, b16));
        }
    };

    @NotNull
    public static final Function2<Object, Object, Boolean> a() {
        return f219274a;
    }
}
