package com.tencent.mobileqq.guild.home.viewmodels.header.processors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B/\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00110\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR)\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/c;", "", "T", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/a;", "a", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/a;", "b", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/a;", "processor", "", "Lkotlin/Pair;", "Ljava/util/List;", "()Ljava/util/List;", "headerBarData", "<init>", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/processors/a;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class c<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a<T> processor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<Integer, T>> headerBarData;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull a<T> processor, @NotNull List<? extends Pair<Integer, ? extends T>> headerBarData) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(headerBarData, "headerBarData");
        this.processor = processor;
        this.headerBarData = headerBarData;
    }

    @NotNull
    public final List<Pair<Integer, T>> a() {
        return this.headerBarData;
    }

    @NotNull
    public final a<T> b() {
        return this.processor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.processor, cVar.processor) && Intrinsics.areEqual(this.headerBarData, cVar.headerBarData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.processor.hashCode() * 31) + this.headerBarData.hashCode();
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        String f16 = this.processor.f();
        List<Pair<Integer, T>> list = this.headerBarData;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(pair.getFirst() + "/{" + pair.getSecond().getClass().getCanonicalName());
        }
        return "processor:" + f16 + ", itemData=" + arrayList;
    }
}
