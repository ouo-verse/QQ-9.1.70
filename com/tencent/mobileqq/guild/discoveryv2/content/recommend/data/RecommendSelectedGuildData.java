package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendSelectedGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSelectedGuildCard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0007\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u0004H\u0096\u0001J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendSelectedGuildData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendSelectedGuild;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSelectedGuildCard;", "kotlin.jvm.PlatformType", "getSelectedGuilds", "", "getItemType", "recommendItem", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "getRecommendItem", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendSelectedGuildData implements l<IGProRecommendContentItem>, IGProContentRecommendSelectedGuild {
    private final /* synthetic */ IGProContentRecommendSelectedGuild $$delegate_0;

    @NotNull
    private final RecommendExtData recommendExtData;

    @NotNull
    private final IGProRecommendContentItem recommendItem;

    public RecommendSelectedGuildData(@NotNull IGProRecommendContentItem recommendItem, @NotNull RecommendExtData recommendExtData) {
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        this.recommendItem = recommendItem;
        this.recommendExtData = recommendExtData;
        this.$$delegate_0 = recommendItem.getContentRecommendSelectedGuild();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.a(this, hVar);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.b(this, hVar);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.c(this, hVar);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return l.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.f();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public RecommendExtData getRecommendExtData() {
        return this.recommendExtData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendSelectedGuild
    public ArrayList<IGProSelectedGuildCard> getSelectedGuilds() {
        return this.$$delegate_0.getSelectedGuilds();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public IGProRecommendContentItem getRecommendItem() {
        return this.recommendItem;
    }
}
