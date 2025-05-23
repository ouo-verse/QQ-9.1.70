package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.base.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\f\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/c;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/l;", "", "getItemType", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "newItem", "", "areContentsTheSame", "", "a", "", "toString", "hashCode", "", "other", "equals", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/d;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/d;", "b", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/d;", "raw", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/d;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ConfigBannerData implements com.tencent.mobileqq.guild.discoveryv2.content.base.l {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ConfigTabBanner raw;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RecommendExtData recommendExtData;

    public ConfigBannerData(@NotNull ConfigTabBanner raw, @NotNull RecommendExtData recommendExtData) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        this.raw = raw;
        this.recommendExtData = recommendExtData;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    @Nullable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void getChangePayload(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof ConfigBannerData) && Intrinsics.areEqual(((ConfigBannerData) newItem).raw, this.raw)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.a(this, hVar);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ConfigTabBanner getRaw() {
        return this.raw;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigBannerData)) {
            return false;
        }
        ConfigBannerData configBannerData = (ConfigBannerData) other;
        if (Intrinsics.areEqual(this.raw, configBannerData.raw) && Intrinsics.areEqual(this.recommendExtData, configBannerData.recommendExtData)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return l.a.b(this);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.c();
    }

    public int hashCode() {
        return (this.raw.hashCode() * 31) + this.recommendExtData.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConfigBannerData(raw=" + this.raw + ", recommendExtData=" + this.recommendExtData + ")";
    }
}
