package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/HorizontalGuildData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGuildData;", "", "getItemType", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "recommendItem", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class HorizontalGuildData extends RecommendGuildData {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalGuildData(@NotNull IGProRecommendContentItem recommendItem, @NotNull RecommendExtData recommendExtData) {
        super(recommendItem, recommendExtData);
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendGuildData, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.h();
    }
}
