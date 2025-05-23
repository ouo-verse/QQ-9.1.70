package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendStreamInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import cooperation.qzone.QZoneRequestEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\r\u001a\n \t*\u0004\u0018\u00010\f0\fH\u0096\u0001J\u0011\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0011\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u001a\u0010\u0015\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendLiveData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendLive;", "", "getChannelId", "", "getChannelType", "", "kotlin.jvm.PlatformType", QZoneRequestEncoder.KEY_COVER_REQ, "getGuildId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFeedGuildInfo;", "getGuildInfo", "", "getJoinSig", "getLiveTitle", "getRoomId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendStreamInfo;", "getStreamInfo", "getItemType", "recommendItem", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "getRecommendItem", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendLiveData implements l<IGProRecommendContentItem>, IGProContentRecommendLive {
    private final /* synthetic */ IGProContentRecommendLive $$delegate_0;

    @NotNull
    private final RecommendExtData recommendExtData;

    @NotNull
    private final IGProRecommendContentItem recommendItem;

    public RecommendLiveData(@NotNull IGProRecommendContentItem recommendItem, @NotNull RecommendExtData recommendExtData) {
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        this.recommendItem = recommendItem;
        this.recommendExtData = recommendExtData;
        this.$$delegate_0 = recommendItem.getContentRecommendLive();
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

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public long getChannelId() {
        return this.$$delegate_0.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public int getChannelType() {
        return this.$$delegate_0.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public String getCover() {
        return this.$$delegate_0.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public long getGuildId() {
        return this.$$delegate_0.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public IGProFeedGuildInfo getGuildInfo() {
        return this.$$delegate_0.getGuildInfo();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return l.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.s();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public byte[] getJoinSig() {
        return this.$$delegate_0.getJoinSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public String getLiveTitle() {
        return this.$$delegate_0.getLiveTitle();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public RecommendExtData getRecommendExtData() {
        return this.recommendExtData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public long getRoomId() {
        return this.$$delegate_0.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendLive
    public IGProContentRecommendStreamInfo getStreamInfo() {
        return this.$$delegate_0.getStreamInfo();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public IGProRecommendContentItem getRecommendItem() {
        return this.recommendItem;
    }
}
