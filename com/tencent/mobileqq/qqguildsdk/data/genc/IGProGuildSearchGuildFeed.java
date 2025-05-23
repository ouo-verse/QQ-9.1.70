package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildSearchGuildFeed extends Serializable {
    long getChannelId();

    long getCommentCount();

    String getContent();

    long getCreateTime();

    long getFavorCount();

    String getFeedId();

    int getFeedType();

    ArrayList<Integer> getFunctionList();

    long getGuildId();

    ArrayList<IGProGuildSearchFeedImageEntity> getImages();

    boolean getNeedWebview();

    String getNickName();

    byte[] getOriContents();

    long getTinyId();

    String getTitle();

    ArrayList<IGProGuildSearchFeedImageEntity> getVideos();

    String toString();
}
