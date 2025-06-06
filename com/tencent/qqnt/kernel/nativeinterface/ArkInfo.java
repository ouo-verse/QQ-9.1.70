package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ArkInfo {
    public String appId;
    public String bizChinese;
    public String bizsrc;
    public long collect;
    public String createTime;
    public String expireTime;
    public long forward;
    public int isPermanent;
    public ArrayList<Integer> matchScene;
    public String owners;
    public String param;
    public long reply;
    public String rtxOperator;
    public int status;
    public String testUins;
    public String triggerScene;
    public String updateTime;
    public String whiteJumpUrls;
    public String whiteResUrls;

    public ArkInfo() {
        this.appId = "";
        this.bizsrc = "";
        this.matchScene = new ArrayList<>();
        this.param = "";
        this.bizChinese = "";
        this.triggerScene = "";
        this.expireTime = "";
        this.owners = "";
        this.rtxOperator = "";
        this.testUins = "";
        this.whiteJumpUrls = "";
        this.whiteResUrls = "";
        this.createTime = "";
        this.updateTime = "";
    }

    public String getAppId() {
        return this.appId;
    }

    public String getBizChinese() {
        return this.bizChinese;
    }

    public String getBizsrc() {
        return this.bizsrc;
    }

    public long getCollect() {
        return this.collect;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public long getForward() {
        return this.forward;
    }

    public int getIsPermanent() {
        return this.isPermanent;
    }

    public ArrayList<Integer> getMatchScene() {
        return this.matchScene;
    }

    public String getOwners() {
        return this.owners;
    }

    public String getParam() {
        return this.param;
    }

    public long getReply() {
        return this.reply;
    }

    public String getRtxOperator() {
        return this.rtxOperator;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTestUins() {
        return this.testUins;
    }

    public String getTriggerScene() {
        return this.triggerScene;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getWhiteJumpUrls() {
        return this.whiteJumpUrls;
    }

    public String getWhiteResUrls() {
        return this.whiteResUrls;
    }

    public String toString() {
        return "ArkInfo{appId=" + this.appId + ",bizsrc=" + this.bizsrc + ",matchScene=" + this.matchScene + ",param=" + this.param + ",bizChinese=" + this.bizChinese + ",triggerScene=" + this.triggerScene + ",expireTime=" + this.expireTime + ",isPermanent=" + this.isPermanent + ",owners=" + this.owners + ",rtxOperator=" + this.rtxOperator + ",status=" + this.status + ",testUins=" + this.testUins + ",whiteJumpUrls=" + this.whiteJumpUrls + ",whiteResUrls=" + this.whiteResUrls + ",forward=" + this.forward + ",reply=" + this.reply + ",collect=" + this.collect + ",createTime=" + this.createTime + ",updateTime=" + this.updateTime + ",}";
    }

    public ArkInfo(String str, String str2, ArrayList<Integer> arrayList, String str3, String str4, String str5, String str6, int i3, String str7, String str8, int i16, String str9, String str10, String str11, long j3, long j16, long j17, String str12, String str13) {
        this.appId = "";
        this.bizsrc = "";
        new ArrayList();
        this.appId = str;
        this.bizsrc = str2;
        this.matchScene = arrayList;
        this.param = str3;
        this.bizChinese = str4;
        this.triggerScene = str5;
        this.expireTime = str6;
        this.isPermanent = i3;
        this.owners = str7;
        this.rtxOperator = str8;
        this.status = i16;
        this.testUins = str9;
        this.whiteJumpUrls = str10;
        this.whiteResUrls = str11;
        this.forward = j3;
        this.reply = j16;
        this.collect = j17;
        this.createTime = str12;
        this.updateTime = str13;
    }
}
