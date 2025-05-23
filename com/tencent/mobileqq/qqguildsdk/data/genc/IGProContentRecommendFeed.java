package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProContentRecommendFeed extends Serializable {
    int getAuditStatus();

    IGProMVPBusinessCard getBusinessCard();

    long getCreateTime();

    IGProImage getCustomCover();

    int getFeedContentType();

    IGProFeedStat getFeedStat();

    int getFeedType();

    ArrayList<Integer> getFunctionList();

    IGProFeedGuildInfo getGuildInfo();

    String getIdd();

    IGProImage getImage();

    long getLastModifiedTime();

    boolean getNeedWebview();

    IGProPoster getPoster();

    IGProMVPRichText getRichText();

    ArrayList<IGProGuildLabel> getTags();

    String getTitle();

    int getTotalImageCount();

    ArrayList<IGProVideo> getVideos();

    String toString();
}
