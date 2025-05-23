package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u000e\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", "featureCategory", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "featuredTitle", "c", "featuredSubTitle", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendItem;", "Ljava/util/List;", "()Ljava/util/List;", "featureGuild", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.f, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeaturedGuilds {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProRecommendCategory featureCategory;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String featuredTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String featuredSubTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<IGProRecommendItem> featureGuild;

    /* JADX WARN: Multi-variable type inference failed */
    public FeaturedGuilds(@NotNull IGProRecommendCategory featureCategory, @NotNull String featuredTitle, @NotNull String featuredSubTitle, @NotNull List<? extends IGProRecommendItem> featureGuild) {
        Intrinsics.checkNotNullParameter(featureCategory, "featureCategory");
        Intrinsics.checkNotNullParameter(featuredTitle, "featuredTitle");
        Intrinsics.checkNotNullParameter(featuredSubTitle, "featuredSubTitle");
        Intrinsics.checkNotNullParameter(featureGuild, "featureGuild");
        this.featureCategory = featureCategory;
        this.featuredTitle = featuredTitle;
        this.featuredSubTitle = featuredSubTitle;
        this.featureGuild = featureGuild;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final IGProRecommendCategory getFeatureCategory() {
        return this.featureCategory;
    }

    @NotNull
    public final List<IGProRecommendItem> b() {
        return this.featureGuild;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFeaturedSubTitle() {
        return this.featuredSubTitle;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getFeaturedTitle() {
        return this.featuredTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeaturedGuilds)) {
            return false;
        }
        FeaturedGuilds featuredGuilds = (FeaturedGuilds) other;
        if (Intrinsics.areEqual(this.featureCategory, featuredGuilds.featureCategory) && Intrinsics.areEqual(this.featuredTitle, featuredGuilds.featuredTitle) && Intrinsics.areEqual(this.featuredSubTitle, featuredGuilds.featuredSubTitle) && Intrinsics.areEqual(this.featureGuild, featuredGuilds.featureGuild)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.featureCategory.hashCode() * 31) + this.featuredTitle.hashCode()) * 31) + this.featuredSubTitle.hashCode()) * 31) + this.featureGuild.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeaturedGuilds(featureCategory=" + this.featureCategory + ", featuredTitle=" + this.featuredTitle + ", featuredSubTitle=" + this.featuredSubTitle + ", featureGuild=" + this.featureGuild + ")";
    }
}
