package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendRobotDrawCard implements Serializable {
    public String botMsgId;
    public String imgUrl;
    public GProRecommendRobotInfo robotInfo;
    long serialVersionUID;
    public String title;
    public String userMsgId;

    public GProRecommendRobotDrawCard() {
        this.serialVersionUID = 1L;
        this.robotInfo = new GProRecommendRobotInfo();
        this.title = "";
        this.imgUrl = "";
        this.userMsgId = "";
        this.botMsgId = "";
    }

    public String getBotMsgId() {
        return this.botMsgId;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public GProRecommendRobotInfo getRobotInfo() {
        return this.robotInfo;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUserMsgId() {
        return this.userMsgId;
    }

    public String toString() {
        return "GProRecommendRobotDrawCard{robotInfo=" + this.robotInfo + ",title=" + this.title + ",imgUrl=" + this.imgUrl + ",userMsgId=" + this.userMsgId + ",botMsgId=" + this.botMsgId + ",}";
    }

    public GProRecommendRobotDrawCard(GProRecommendRobotInfo gProRecommendRobotInfo, String str, String str2, String str3, String str4) {
        this.serialVersionUID = 1L;
        new GProRecommendRobotInfo();
        this.robotInfo = gProRecommendRobotInfo;
        this.title = str;
        this.imgUrl = str2;
        this.userMsgId = str3;
        this.botMsgId = str4;
    }
}
