package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProRecommendContentItem extends Serializable {
    byte[] getAdFeedModel();

    IGProContentFeedTopic getContentFeedTopic();

    IGProContentRecommendGuild getContentRecommendGuild();

    IGProContentRecommendHotLive getContentRecommendHotLive();

    IGProContentRecommendLive getContentRecommendLive();

    IGProContentRecommendSchema getContentRecommendSchema();

    IGProContentRecommendSelectedGuild getContentRecommendSelectedGuild();

    IGProContentRecommendVoice getContentRecommendVoice();

    IGProExtra getExtra();

    IGProContentRecommendFeed getFeed();

    IGProContentRecommendFeedsGuild getFeedsGuild();

    IGProContentRecommendGroup getGroup();

    IGProContentRecommendH5Kuikly getH5kuikly();

    int getItemType();

    IGProContentRecommendOneToOne getOneToOne();

    IGProContentRecommendRobot getRobot();

    byte[] getTianShuAdItem();

    String toString();
}
