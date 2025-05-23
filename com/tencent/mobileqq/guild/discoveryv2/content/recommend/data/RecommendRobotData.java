package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImageBasicInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\u0096\u0001J\u0011\u0010\u000b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\r\u001a\n \u0005*\u0004\u0018\u00010\f0\fH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0013\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\b\u0010\u0014\u001a\u00020\u0011H\u0016R\u001a\u0010\u0015\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendRobotData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendRobot;", "", "kotlin.jvm.PlatformType", "getAppId", "getButtonName", "getDesc", "", "getExtra", "getNickName", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProImageBasicInfo;", "getPicInfo", "", "getRobotUin", "getSchema", "", "getType", "getUid", "getItemType", "recommendItem", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "getRecommendItem", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendRobotData implements l<IGProRecommendContentItem>, IGProContentRecommendRobot {
    private final /* synthetic */ IGProContentRecommendRobot $$delegate_0;

    @NotNull
    private final RecommendExtData recommendExtData;

    @NotNull
    private final IGProRecommendContentItem recommendItem;

    public RecommendRobotData(@NotNull IGProRecommendContentItem recommendItem, @NotNull RecommendExtData recommendExtData) {
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        this.recommendItem = recommendItem;
        this.recommendExtData = recommendExtData;
        this.$$delegate_0 = recommendItem.getRobot();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.a(this, hVar);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.b(this, hVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getAppId() {
        return this.$$delegate_0.getAppId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getButtonName() {
        return this.$$delegate_0.getButtonName();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.mobileqq.guild.discoveryv2.content.base.h hVar) {
        return l.a.c(this, hVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getDesc() {
        return this.$$delegate_0.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public byte[] getExtra() {
        return this.$$delegate_0.getExtra();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return l.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.x();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getNickName() {
        return this.$$delegate_0.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public IGProImageBasicInfo getPicInfo() {
        return this.$$delegate_0.getPicInfo();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public RecommendExtData getRecommendExtData() {
        return this.recommendExtData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public long getRobotUin() {
        return this.$$delegate_0.getRobotUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getSchema() {
        return this.$$delegate_0.getSchema();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public int getType() {
        return this.$$delegate_0.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendRobot
    public String getUid() {
        return this.$$delegate_0.getUid();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public IGProRecommendContentItem getRecommendItem() {
        return this.recommendItem;
    }
}
