package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupRobotInfo {
    public long apiMark;
    public long appid;
    public String callName;
    public String desc;
    public int enabledGroups;
    public String extraInfo;
    public ArrayList<String> fallbackList;
    public int joinTime;
    public ArrayList<Long> miniappIds;
    public String name;
    public int offline;
    public int order;
    public int robotType;
    public long robotUin;
    public int showAddFriend;
    public int showInvite;
    public int status;
    public String verify;
    public String welcomeMsg;

    public GroupRobotInfo() {
        this.name = "";
        this.desc = "";
        this.welcomeMsg = "";
        this.callName = "";
        this.verify = "";
        this.fallbackList = new ArrayList<>();
        this.miniappIds = new ArrayList<>();
        this.extraInfo = "";
    }

    public long getApiMark() {
        return this.apiMark;
    }

    public long getAppid() {
        return this.appid;
    }

    public String getCallName() {
        return this.callName;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getEnabledGroups() {
        return this.enabledGroups;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public ArrayList<String> getFallbackList() {
        return this.fallbackList;
    }

    public int getJoinTime() {
        return this.joinTime;
    }

    public ArrayList<Long> getMiniappIds() {
        return this.miniappIds;
    }

    public String getName() {
        return this.name;
    }

    public int getOffline() {
        return this.offline;
    }

    public int getOrder() {
        return this.order;
    }

    public int getRobotType() {
        return this.robotType;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public int getShowAddFriend() {
        return this.showAddFriend;
    }

    public int getShowInvite() {
        return this.showInvite;
    }

    public int getStatus() {
        return this.status;
    }

    public String getVerify() {
        return this.verify;
    }

    public String getWelcomeMsg() {
        return this.welcomeMsg;
    }

    public void setApiMark(long j3) {
        this.apiMark = j3;
    }

    public void setAppid(long j3) {
        this.appid = j3;
    }

    public void setCallName(String str) {
        this.callName = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setEnabledGroups(int i3) {
        this.enabledGroups = i3;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setFallbackList(ArrayList<String> arrayList) {
        this.fallbackList = arrayList;
    }

    public void setJoinTime(int i3) {
        this.joinTime = i3;
    }

    public void setMiniappIds(ArrayList<Long> arrayList) {
        this.miniappIds = arrayList;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOffline(int i3) {
        this.offline = i3;
    }

    public void setOrder(int i3) {
        this.order = i3;
    }

    public void setRobotType(int i3) {
        this.robotType = i3;
    }

    public void setRobotUin(long j3) {
        this.robotUin = j3;
    }

    public void setShowAddFriend(int i3) {
        this.showAddFriend = i3;
    }

    public void setShowInvite(int i3) {
        this.showInvite = i3;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public void setVerify(String str) {
        this.verify = str;
    }

    public void setWelcomeMsg(String str) {
        this.welcomeMsg = str;
    }

    public String toString() {
        return "GroupRobotInfo{robotUin=" + this.robotUin + ",name=" + this.name + ",status=" + this.status + ",desc=" + this.desc + ",enabledGroups=" + this.enabledGroups + ",welcomeMsg=" + this.welcomeMsg + ",callName=" + this.callName + ",showInvite=" + this.showInvite + ",offline=" + this.offline + ",verify=" + this.verify + ",fallbackList=" + this.fallbackList + ",joinTime=" + this.joinTime + ",order=" + this.order + ",appid=" + this.appid + ",apiMark=" + this.apiMark + ",miniappIds=" + this.miniappIds + ",robotType=" + this.robotType + ",extraInfo=" + this.extraInfo + ",showAddFriend=" + this.showAddFriend + ",}";
    }

    public GroupRobotInfo(long j3, String str, int i3, String str2, int i16, String str3, String str4, int i17, int i18, String str5, ArrayList<String> arrayList, int i19, int i26, long j16, long j17, ArrayList<Long> arrayList2, int i27, String str6, int i28) {
        this.name = "";
        this.desc = "";
        this.welcomeMsg = "";
        this.callName = "";
        this.verify = "";
        this.fallbackList = new ArrayList<>();
        new ArrayList();
        this.robotUin = j3;
        this.name = str;
        this.status = i3;
        this.desc = str2;
        this.enabledGroups = i16;
        this.welcomeMsg = str3;
        this.callName = str4;
        this.showInvite = i17;
        this.offline = i18;
        this.verify = str5;
        this.fallbackList = arrayList;
        this.joinTime = i19;
        this.order = i26;
        this.appid = j16;
        this.apiMark = j17;
        this.miniappIds = arrayList2;
        this.robotType = i27;
        this.extraInfo = str6;
        this.showAddFriend = i28;
    }
}
