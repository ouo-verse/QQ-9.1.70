package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsDisSpecialTopic {
    public int isHotsearch;
    public int showType;
    public byte[] topicTitle = new byte[0];
    public byte[] titleColor = new byte[0];
    public byte[] iconUrl = new byte[0];
    public ArrayList<UfsDisTopicItem> topicItems = new ArrayList<>();
    public byte[] jumpUrl = new byte[0];
    public byte[] leftIconUrl = new byte[0];
    public byte[] moreText = new byte[0];
    public ArrayList<UfsDisTopicImage> topicImages = new ArrayList<>();

    public byte[] getIconUrl() {
        return this.iconUrl;
    }

    public int getIsHotsearch() {
        return this.isHotsearch;
    }

    public byte[] getJumpUrl() {
        return this.jumpUrl;
    }

    public byte[] getLeftIconUrl() {
        return this.leftIconUrl;
    }

    public byte[] getMoreText() {
        return this.moreText;
    }

    public int getShowType() {
        return this.showType;
    }

    public byte[] getTitleColor() {
        return this.titleColor;
    }

    public ArrayList<UfsDisTopicImage> getTopicImages() {
        return this.topicImages;
    }

    public ArrayList<UfsDisTopicItem> getTopicItems() {
        return this.topicItems;
    }

    public byte[] getTopicTitle() {
        return this.topicTitle;
    }

    public String toString() {
        return "UfsDisSpecialTopic{topicTitle=" + this.topicTitle + ",titleColor=" + this.titleColor + ",iconUrl=" + this.iconUrl + ",topicItems=" + this.topicItems + ",jumpUrl=" + this.jumpUrl + ",showType=" + this.showType + ",leftIconUrl=" + this.leftIconUrl + ",moreText=" + this.moreText + ",topicImages=" + this.topicImages + ",isHotsearch=" + this.isHotsearch + ",}";
    }
}
