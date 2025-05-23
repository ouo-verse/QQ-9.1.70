package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendContentItem;

/* loaded from: classes17.dex */
public class GGProRecommendContentItem implements IGProRecommendContentItem {
    public final GProRecommendContentItem mInfo;

    public GGProRecommendContentItem(GProRecommendContentItem gProRecommendContentItem) {
        this.mInfo = gProRecommendContentItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public byte[] getAdFeedModel() {
        return this.mInfo.getAdFeedModel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentFeedTopic getContentFeedTopic() {
        return new GGProContentFeedTopic(this.mInfo.getContentFeedTopic());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendGuild getContentRecommendGuild() {
        return new GGProContentRecommendGuild(this.mInfo.getContentRecommendGuild());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendHotLive getContentRecommendHotLive() {
        return new GGProContentRecommendHotLive(this.mInfo.getContentRecommendHotLive());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendLive getContentRecommendLive() {
        return new GGProContentRecommendLive(this.mInfo.getContentRecommendLive());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendSchema getContentRecommendSchema() {
        return new GGProContentRecommendSchema(this.mInfo.getContentRecommendSchema());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendSelectedGuild getContentRecommendSelectedGuild() {
        return new GGProContentRecommendSelectedGuild(this.mInfo.getContentRecommendSelectedGuild());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendVoice getContentRecommendVoice() {
        return new GGProContentRecommendVoice(this.mInfo.getContentRecommendVoice());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProExtra getExtra() {
        return new GGProExtra(this.mInfo.getExtra());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendFeed getFeed() {
        return new GGProContentRecommendFeed(this.mInfo.getFeed());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendFeedsGuild getFeedsGuild() {
        return new GGProContentRecommendFeedsGuild(this.mInfo.getFeedsGuild());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendGroup getGroup() {
        return new GGProContentRecommendGroup(this.mInfo.getGroup());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendH5Kuikly getH5kuikly() {
        return new GGProContentRecommendH5Kuikly(this.mInfo.getH5kuikly());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public int getItemType() {
        return this.mInfo.getItemType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendOneToOne getOneToOne() {
        return new GGProContentRecommendOneToOne(this.mInfo.getOneToOne());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public IGProContentRecommendRobot getRobot() {
        return new GGProContentRecommendRobot(this.mInfo.getRobot());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public byte[] getTianShuAdItem() {
        return this.mInfo.getTianShuAdItem();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendContentItem
    public String toString() {
        return this.mInfo.toString();
    }
}
