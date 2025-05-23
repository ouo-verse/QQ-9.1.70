package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildFeedSearchRes extends Serializable {
    long getChannelId();

    long getCommentCount();

    String getContent();

    long getCreateTime();

    long getFavorCount();

    String getFeedId();

    int getFeedType();

    ArrayList<Integer> getFunctionList();

    long getGuildId();

    ArrayList<IGProFeedImageEntity> getImages();

    boolean getNeedWebview();

    String getNickName();

    byte[] getOriContents();

    long getTinyId();

    String getTitle();

    ArrayList<IGProFeedImageEntity> getVideos();

    String toString();
}
