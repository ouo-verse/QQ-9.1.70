package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.base.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001\tB%\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003R\u0017\u0010\u0017\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/u;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/l;", "", "getItemType", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/h;", "newItem", "", "areContentsTheSame", "", "a", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/t;", "b", "", "toString", "hashCode", "", "other", "equals", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "e", "Ljava/util/List;", "getRecommendItem", "()Ljava/util/List;", "recommendItem", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "f", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", tl.h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.u, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class SpecialActivityListData implements com.tencent.mobileqq.guild.discoveryv2.content.base.l {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<SpecialActivityData> recommendItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RecommendExtData recommendExtData;

    public SpecialActivityListData(@NotNull String title, @NotNull List<SpecialActivityData> recommendItem, @NotNull RecommendExtData recommendExtData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        this.title = title;
        this.recommendItem = recommendItem;
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
        if ((newItem instanceof SpecialActivityListData) && Intrinsics.areEqual(((SpecialActivityListData) newItem).recommendItem, this.recommendItem)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.a(this, hVar);
    }

    @NotNull
    public final List<SpecialActivityData> b() {
        List<SpecialActivityData> take;
        List<SpecialActivityData> take2;
        List<SpecialActivityData> emptyList;
        if (this.recommendItem.size() < 2) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        if (this.recommendItem.size() >= 4) {
            take2 = CollectionsKt___CollectionsKt.take(this.recommendItem, 4);
            return take2;
        }
        take = CollectionsKt___CollectionsKt.take(this.recommendItem, 2);
        return take;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpecialActivityListData)) {
            return false;
        }
        SpecialActivityListData specialActivityListData = (SpecialActivityListData) other;
        if (Intrinsics.areEqual(this.title, specialActivityListData.title) && Intrinsics.areEqual(this.recommendItem, specialActivityListData.recommendItem) && Intrinsics.areEqual(this.recommendExtData, specialActivityListData.recommendExtData)) {
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
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.a();
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.recommendItem.hashCode()) * 31) + this.recommendExtData.hashCode();
    }

    @NotNull
    public String toString() {
        return "SpecialActivityListData(title=" + this.title + ", recommendItem=" + this.recommendItem + ", recommendExtData=" + this.recommendExtData + ")";
    }
}
