package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "featuredTitle", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;", "featuredCategory", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendItem;", "Ljava/util/List;", "()Ljava/util/List;", "featuredGuilds", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendCategory;Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class CategoryFeaturedGuilds {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String featuredTitle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IGProRecommendCategory featuredCategory;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<IGProRecommendItem> featuredGuilds;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryFeaturedGuilds(@NotNull String featuredTitle, @NotNull IGProRecommendCategory featuredCategory, @NotNull List<? extends IGProRecommendItem> featuredGuilds) {
        Intrinsics.checkNotNullParameter(featuredTitle, "featuredTitle");
        Intrinsics.checkNotNullParameter(featuredCategory, "featuredCategory");
        Intrinsics.checkNotNullParameter(featuredGuilds, "featuredGuilds");
        this.featuredTitle = featuredTitle;
        this.featuredCategory = featuredCategory;
        this.featuredGuilds = featuredGuilds;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final IGProRecommendCategory getFeaturedCategory() {
        return this.featuredCategory;
    }

    @NotNull
    public final List<IGProRecommendItem> b() {
        return this.featuredGuilds;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFeaturedTitle() {
        return this.featuredTitle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CategoryFeaturedGuilds)) {
            return false;
        }
        CategoryFeaturedGuilds categoryFeaturedGuilds = (CategoryFeaturedGuilds) other;
        if (Intrinsics.areEqual(this.featuredTitle, categoryFeaturedGuilds.featuredTitle) && Intrinsics.areEqual(this.featuredCategory, categoryFeaturedGuilds.featuredCategory) && Intrinsics.areEqual(this.featuredGuilds, categoryFeaturedGuilds.featuredGuilds)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.featuredTitle.hashCode() * 31) + this.featuredCategory.hashCode()) * 31) + this.featuredGuilds.hashCode();
    }

    @NotNull
    public String toString() {
        return "CategoryFeaturedGuilds(featuredTitle=" + this.featuredTitle + ", featuredCategory=" + this.featuredCategory + ", featuredGuilds=" + this.featuredGuilds + ")";
    }
}
