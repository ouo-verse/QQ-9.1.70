package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProSaveMsgReq implements Serializable {
    public long adId;
    public String content;
    public long guildId;
    public String headImage;
    public String jumpText;
    public String jumpUrl;
    long serialVersionUID;
    public String title;

    public GProSaveMsgReq() {
        this.serialVersionUID = 1L;
        this.headImage = "";
        this.title = "";
        this.content = "";
        this.jumpText = "";
        this.jumpUrl = "";
    }

    public long getAdId() {
        return this.adId;
    }

    public String getContent() {
        return this.content;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getHeadImage() {
        return this.headImage;
    }

    public String getJumpText() {
        return this.jumpText;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAdId(long j3) {
        this.adId = j3;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setHeadImage(String str) {
        this.headImage = str;
    }

    public void setJumpText(String str) {
        this.jumpText = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "GProSaveMsgReq{adId=" + this.adId + ",headImage=" + this.headImage + ",title=" + this.title + ",content=" + this.content + ",jumpText=" + this.jumpText + ",jumpUrl=" + this.jumpUrl + ",guildId=" + this.guildId + ",}";
    }

    public GProSaveMsgReq(long j3, String str, String str2, String str3, String str4, String str5, long j16) {
        this.serialVersionUID = 1L;
        this.adId = j3;
        this.headImage = str;
        this.title = str2;
        this.content = str3;
        this.jumpText = str4;
        this.jumpUrl = str5;
        this.guildId = j16;
    }
}
