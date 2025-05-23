package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "a", "Ljava/util/List;", "()Ljava/util/List;", "bannerItemList", "<init>", "(Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ConfigTabBanner {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<IGProRecommendContentItem> bannerItemList;

    /* JADX WARN: Multi-variable type inference failed */
    public ConfigTabBanner(@NotNull List<? extends IGProRecommendContentItem> bannerItemList) {
        Intrinsics.checkNotNullParameter(bannerItemList, "bannerItemList");
        this.bannerItemList = bannerItemList;
    }

    @NotNull
    public final List<IGProRecommendContentItem> a() {
        return this.bannerItemList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ConfigTabBanner) && Intrinsics.areEqual(this.bannerItemList, ((ConfigTabBanner) other).bannerItemList)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.bannerItemList.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConfigTabBanner(bannerItemList=" + this.bannerItemList + ")";
    }
}
