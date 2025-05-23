package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendItemForumChannel implements Serializable {
    public int endColor;
    public int hotFeedNum;
    public String hotIcon;
    public int hotValue;
    public String hotValueTitle;
    public int index;
    public String inviteCode;
    long serialVersionUID;
    public int startColor;
    public int type;

    public GProRecommendItemForumChannel() {
        this.serialVersionUID = 1L;
        this.hotValueTitle = "";
        this.hotIcon = "";
        this.inviteCode = "";
    }

    public int getEndColor() {
        return this.endColor;
    }

    public int getHotFeedNum() {
        return this.hotFeedNum;
    }

    public String getHotIcon() {
        return this.hotIcon;
    }

    public int getHotValue() {
        return this.hotValue;
    }

    public String getHotValueTitle() {
        return this.hotValueTitle;
    }

    public int getIndex() {
        return this.index;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public int getStartColor() {
        return this.startColor;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProRecommendItemForumChannel{hotFeedNum=" + this.hotFeedNum + ",index=" + this.index + ",hotValue=" + this.hotValue + ",hotValueTitle=" + this.hotValueTitle + ",type=" + this.type + ",startColor=" + this.startColor + ",endColor=" + this.endColor + ",hotIcon=" + this.hotIcon + ",inviteCode=" + this.inviteCode + ",}";
    }

    public GProRecommendItemForumChannel(int i3, int i16, int i17, String str, int i18, int i19, int i26, String str2, String str3) {
        this.serialVersionUID = 1L;
        this.hotFeedNum = i3;
        this.index = i16;
        this.hotValue = i17;
        this.hotValueTitle = str;
        this.type = i18;
        this.startColor = i19;
        this.endColor = i26;
        this.hotIcon = str2;
        this.inviteCode = str3;
    }
}
