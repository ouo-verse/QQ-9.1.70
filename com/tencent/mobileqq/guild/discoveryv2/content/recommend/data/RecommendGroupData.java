package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0096\u0001J\u0011\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0096\u0001J\u0011\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0096\u0001J\u0011\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0096\u0001J\u0011\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0096\u0001J\u0011\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0096\u0001J-\u0010\u000f\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u000e0\u000eH\u0096\u0001J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0012\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGroupData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGroup;", "", "getGroupCode", "", "kotlin.jvm.PlatformType", "getGroupMembers", "getGroupName", "getGroupSummary", "getHeadUrl", "getJoinGroupAuth", "getJoinText", "Ljava/util/ArrayList;", "getRecommendReasons", "", "getItemType", "recommendItem", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "getRecommendItem", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendGroupData implements l<IGProRecommendContentItem>, IGProContentRecommendGroup {
    private final /* synthetic */ IGProContentRecommendGroup $$delegate_0;

    @NotNull
    private final RecommendExtData recommendExtData;

    @NotNull
    private final IGProRecommendContentItem recommendItem;

    public RecommendGroupData(@NotNull IGProRecommendContentItem recommendItem, @NotNull RecommendExtData recommendExtData) {
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        this.recommendItem = recommendItem;
        this.recommendExtData = recommendExtData;
        this.$$delegate_0 = recommendItem.getGroup();
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

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public long getGroupCode() {
        return this.$$delegate_0.getGroupCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getGroupMembers() {
        return this.$$delegate_0.getGroupMembers();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getGroupName() {
        return this.$$delegate_0.getGroupName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getGroupSummary() {
        return this.$$delegate_0.getGroupSummary();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getHeadUrl() {
        return this.$$delegate_0.getHeadUrl();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return l.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.g();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getJoinGroupAuth() {
        return this.$$delegate_0.getJoinGroupAuth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public String getJoinText() {
        return this.$$delegate_0.getJoinText();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public RecommendExtData getRecommendExtData() {
        return this.recommendExtData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGroup
    public ArrayList<String> getRecommendReasons() {
        return this.$$delegate_0.getRecommendReasons();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public IGProRecommendContentItem getRecommendItem() {
        return this.recommendItem;
    }
}
