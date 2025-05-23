package com.tencent.mobileqq.guild.feed.topic;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086\u0002J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/h;", "T", "", "", "toString", "o", "c", "", "list", "a", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class h<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<T> list;

    public h() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final h<T> a(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new h<>(list);
    }

    @NotNull
    public final List<T> b() {
        return this.list;
    }

    @NotNull
    public final h<T> c(@NotNull h<T> o16) {
        List<? extends T> plus;
        Intrinsics.checkNotNullParameter(o16, "o");
        plus = CollectionsKt___CollectionsKt.plus((Collection) this.list, (Iterable) o16.list);
        return a(plus);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof h) && Intrinsics.areEqual(this.list, ((h) other).list)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "size: " + this.list.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    public /* synthetic */ h(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
