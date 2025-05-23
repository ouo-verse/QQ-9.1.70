package com.tencent.mobileqq.zplan.aigc.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u0019\u0010!\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b\u001b\u0010 R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b\u000e\u0010 R\u0019\u0010$\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b\u001d\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "g", "()I", "type", "b", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "extra", "", "c", "J", tl.h.F, "()J", "ugcId", "d", "desc", "e", "icon", "f", "name", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "priceType", "gold", "i", "silver", "<init>", "(ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.k, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class OutfitItemInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String extra;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long ugcId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String desc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String icon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String name;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer priceType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer gold;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer silver;

    public OutfitItemInfo(int i3, String extra, long j3, String str, String icon, String name, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        this.type = i3;
        this.extra = extra;
        this.ugcId = j3;
        this.desc = str;
        this.icon = icon;
        this.name = name;
        this.priceType = num;
        this.gold = num2;
        this.silver = num3;
    }

    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getGold() {
        return this.gold;
    }

    /* renamed from: c, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final Integer getPriceType() {
        return this.priceType;
    }

    /* renamed from: f, reason: from getter */
    public final Integer getSilver() {
        return this.silver;
    }

    /* renamed from: g, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: h, reason: from getter */
    public final long getUgcId() {
        return this.ugcId;
    }

    public int hashCode() {
        int hashCode = ((((this.type * 31) + this.extra.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.ugcId)) * 31;
        String str = this.desc;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.icon.hashCode()) * 31) + this.name.hashCode()) * 31;
        Integer num = this.priceType;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.gold;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.silver;
        return hashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "OutfitItemInfo(type=" + this.type + ", extra=" + this.extra + ", ugcId=" + this.ugcId + ", desc=" + this.desc + ", icon=" + this.icon + ", name=" + this.name + ", priceType=" + this.priceType + ", gold=" + this.gold + ", silver=" + this.silver + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutfitItemInfo)) {
            return false;
        }
        OutfitItemInfo outfitItemInfo = (OutfitItemInfo) other;
        return this.type == outfitItemInfo.type && Intrinsics.areEqual(this.extra, outfitItemInfo.extra) && this.ugcId == outfitItemInfo.ugcId && Intrinsics.areEqual(this.desc, outfitItemInfo.desc) && Intrinsics.areEqual(this.icon, outfitItemInfo.icon) && Intrinsics.areEqual(this.name, outfitItemInfo.name) && Intrinsics.areEqual(this.priceType, outfitItemInfo.priceType) && Intrinsics.areEqual(this.gold, outfitItemInfo.gold) && Intrinsics.areEqual(this.silver, outfitItemInfo.silver);
    }
}
