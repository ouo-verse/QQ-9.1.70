package com.tencent.mobileqq.qwallet.pet.data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0004B;\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0016\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R'\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/d;", "", "", "Lcom/tencent/mobileqq/qwallet/pet/data/b;", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qwallet/pet/data/e;", "Lcom/tencent/mobileqq/qwallet/pet/data/e;", "c", "()Lcom/tencent/mobileqq/qwallet/pet/data/e;", "infoBase", "b", "Lcom/tencent/mobileqq/qwallet/pet/data/b;", "d", "()Lcom/tencent/mobileqq/qwallet/pet/data/b;", "petDownloadDetail", "", "Lcom/tencent/mobileqq/qwallet/pet/data/k;", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "subActionMap", "clothDownloadDetail", "<init>", "(Lcom/tencent/mobileqq/qwallet/pet/data/e;Lcom/tencent/mobileqq/qwallet/pet/data/b;Ljava/util/Map;Lcom/tencent/mobileqq/qwallet/pet/data/b;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class d {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e infoBase;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final DownloadDetail petDownloadDetail;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Map<k, DownloadDetail> subActionMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final DownloadDetail clothDownloadDetail;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/data/d$a;", "", "Lcom/tencent/mobileqq/qwallet/pet/data/e;", "infoBase", "Lcom/tencent/mobileqq/qwallet/pet/data/d;", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.data.d$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final d a(@NotNull e infoBase) {
            LinkedHashMap linkedHashMap;
            int collectionSizeOrDefault;
            int mapCapacity;
            int coerceAtLeast;
            Intrinsics.checkNotNullParameter(infoBase, "infoBase");
            DownloadDetail b16 = jl2.b.f410584a.b(ModelType.PET, infoBase.getPetDownloadUrl());
            List<k> e16 = infoBase.e();
            if (e16 != null) {
                List<k> list = e16;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (k kVar : list) {
                    Pair pair = new Pair(kVar, jl2.b.f410584a.b(ModelType.PET, kVar.getSubActionUrl()));
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
            } else {
                linkedHashMap = null;
            }
            return new d(infoBase, b16, linkedHashMap, jl2.b.f410584a.b(ModelType.CLOTH, infoBase.getClothDownloadUrl()));
        }

        Companion() {
        }
    }

    public d(@NotNull e infoBase, @Nullable DownloadDetail downloadDetail, @Nullable Map<k, DownloadDetail> map, @Nullable DownloadDetail downloadDetail2) {
        Intrinsics.checkNotNullParameter(infoBase, "infoBase");
        this.infoBase = infoBase;
        this.petDownloadDetail = downloadDetail;
        this.subActionMap = map;
        this.clothDownloadDetail = downloadDetail2;
    }

    @NotNull
    public final List<DownloadDetail> a() {
        List mutableListOf;
        List<DownloadDetail> filterNotNull;
        List filterNotNull2;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this.petDownloadDetail, this.clothDownloadDetail);
        Map<k, DownloadDetail> map = this.subActionMap;
        if (map != null) {
            filterNotNull2 = CollectionsKt___CollectionsKt.filterNotNull(map.values());
            mutableListOf.addAll(filterNotNull2);
        }
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        return filterNotNull;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final DownloadDetail getClothDownloadDetail() {
        return this.clothDownloadDetail;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final e getInfoBase() {
        return this.infoBase;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final DownloadDetail getPetDownloadDetail() {
        return this.petDownloadDetail;
    }

    @Nullable
    public final Map<k, DownloadDetail> e() {
        return this.subActionMap;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (Intrinsics.areEqual(this.infoBase, dVar.infoBase) && Intrinsics.areEqual(this.petDownloadDetail, dVar.petDownloadDetail) && Intrinsics.areEqual(this.subActionMap, dVar.subActionMap) && Intrinsics.areEqual(this.clothDownloadDetail, dVar.clothDownloadDetail)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = this.infoBase.hashCode() * 31;
        DownloadDetail downloadDetail = this.petDownloadDetail;
        int i3 = 0;
        if (downloadDetail == null) {
            hashCode = 0;
        } else {
            hashCode = downloadDetail.hashCode();
        }
        int i16 = (hashCode3 + hashCode) * 31;
        Map<k, DownloadDetail> map = this.subActionMap;
        if (map == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = map.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        DownloadDetail downloadDetail2 = this.clothDownloadDetail;
        if (downloadDetail2 != null) {
            i3 = downloadDetail2.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return this.infoBase + " pet:" + this.petDownloadDetail + " sub:" + this.subActionMap + " cloth:" + this.clothDownloadDetail;
    }
}
