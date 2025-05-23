package com.tencent.mobileqq.guild.discoveryv2.content.recommend.data;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGameGiftInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem;
import cooperation.qzone.QZoneRequestEncoder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b!\u0010\"J\u0011\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\u0096\u0001J\u0011\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\r\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0096\u0001J\u0011\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J-\u0010\u0013\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00120\u0012 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u00110\u0011H\u0096\u0001J-\u0010\u0015\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00140\u0014 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00140\u0014\u0018\u00010\u00110\u0011H\u0096\u0001J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u0018\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGuildData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;", "", "kotlin.jvm.PlatformType", QZoneRequestEncoder.KEY_COVER_REQ, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGameGiftInfo;", "getGiftInfo", "getGuildAvatar", "", "getGuildId", "getGuildIntro", "getGuildName", "getGuildProfile", "", "getJoinSig", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "getMedals", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildLabel;", "getTagList", "", "getItemType", "recommendItem", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "getRecommendItem", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExtData", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "getRecommendExtData", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendContentItem;Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class RecommendGuildData implements l<IGProRecommendContentItem>, IGProContentRecommendGuild {
    private final /* synthetic */ IGProContentRecommendGuild $$delegate_0;

    @NotNull
    private final RecommendExtData recommendExtData;

    @NotNull
    private final IGProRecommendContentItem recommendItem;

    public RecommendGuildData(@NotNull IGProRecommendContentItem recommendItem, @NotNull RecommendExtData recommendExtData) {
        Intrinsics.checkNotNullParameter(recommendItem, "recommendItem");
        Intrinsics.checkNotNullParameter(recommendExtData, "recommendExtData");
        this.recommendItem = recommendItem;
        this.recommendExtData = recommendExtData;
        this.$$delegate_0 = recommendItem.getContentRecommendGuild();
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

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getCover() {
        return this.$$delegate_0.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public IGProGameGiftInfo getGiftInfo() {
        return this.$$delegate_0.getGiftInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getGuildAvatar() {
        return this.$$delegate_0.getGuildAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public long getGuildId() {
        return this.$$delegate_0.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getGuildIntro() {
        return this.$$delegate_0.getGuildIntro();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getGuildName() {
        return this.$$delegate_0.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getGuildProfile() {
        return this.$$delegate_0.getGuildProfile();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l, com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public long getItemId() {
        return l.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.h
    public int getItemType() {
        return com.tencent.mobileqq.guild.discoveryv2.content.base.h.INSTANCE.q();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public byte[] getJoinSig() {
        return this.$$delegate_0.getJoinSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public ArrayList<IGProMedalInfo> getMedals() {
        return this.$$delegate_0.getMedals();
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public RecommendExtData getRecommendExtData() {
        return this.recommendExtData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public ArrayList<IGProGuildLabel> getTagList() {
        return this.$$delegate_0.getTagList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l
    @NotNull
    public IGProRecommendContentItem getRecommendItem() {
        return this.recommendItem;
    }
}
