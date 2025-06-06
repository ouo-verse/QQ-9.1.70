package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotBaseInfo {
    public boolean allowInvitedToGroup;
    public boolean allowedAddC2C;
    public boolean allowedAddGroup;
    public long apiMark;
    public long appid;
    public int enabledGroups;
    public int joinTime;
    public long miniAppIds;
    public int offline;
    public int order;
    public int robotBizType;
    public int robotSource;
    public int robotType;
    public long robotUin;
    public int status;
    public String name = "";
    public String desc = "";
    public String robotAvatar = "";
    public String welcomeMsg = "";
    public String callName = "";
    public String verify = "";
    public String fallback = "";
    public String extraInfo = "";
    public String robotUid = "";
    public String ownerEntity = "";
    public RobtoCreateInfo createInfo = new RobtoCreateInfo();
    public RobotStatus robotStatus = RobotStatus.values()[0];
    public ArrayList<Long> categoryIds = new ArrayList<>();
    public ActiveMessageConfig activeMsgConfig = new ActiveMessageConfig();

    public ActiveMessageConfig getActiveMsgConfig() {
        return this.activeMsgConfig;
    }

    public boolean getAllowInvitedToGroup() {
        return this.allowInvitedToGroup;
    }

    public boolean getAllowedAddC2C() {
        return this.allowedAddC2C;
    }

    public boolean getAllowedAddGroup() {
        return this.allowedAddGroup;
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

    public ArrayList<Long> getCategoryIds() {
        return this.categoryIds;
    }

    public RobtoCreateInfo getCreateInfo() {
        return this.createInfo;
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

    public String getFallback() {
        return this.fallback;
    }

    public int getJoinTime() {
        return this.joinTime;
    }

    public long getMiniAppIds() {
        return this.miniAppIds;
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

    public String getOwnerEntity() {
        return this.ownerEntity;
    }

    public String getRobotAvatar() {
        return this.robotAvatar;
    }

    public int getRobotBizType() {
        return this.robotBizType;
    }

    public int getRobotSource() {
        return this.robotSource;
    }

    public RobotStatus getRobotStatus() {
        return this.robotStatus;
    }

    public int getRobotType() {
        return this.robotType;
    }

    public String getRobotUid() {
        return this.robotUid;
    }

    public long getRobotUin() {
        return this.robotUin;
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

    public String toString() {
        return "RobotBaseInfo{robotUin=" + this.robotUin + ",name=" + this.name + ",status=" + this.status + ",desc=" + this.desc + ",robotAvatar=" + this.robotAvatar + ",enabledGroups=" + this.enabledGroups + ",welcomeMsg=" + this.welcomeMsg + ",callName=" + this.callName + ",allowedAddGroup=" + this.allowedAddGroup + ",allowInvitedToGroup=" + this.allowInvitedToGroup + ",offline=" + this.offline + ",verify=" + this.verify + ",fallback=" + this.fallback + ",joinTime=" + this.joinTime + ",order=" + this.order + ",appid=" + this.appid + ",apiMark=" + this.apiMark + ",miniAppIds=" + this.miniAppIds + ",robotType=" + this.robotType + ",extraInfo=" + this.extraInfo + ",allowedAddC2C=" + this.allowedAddC2C + ",robotUid=" + this.robotUid + ",ownerEntity=" + this.ownerEntity + ",robotBizType=" + this.robotBizType + ",createInfo=" + this.createInfo + ",robotStatus=" + this.robotStatus + ",robotSource=" + this.robotSource + ",categoryIds=" + this.categoryIds + ",activeMsgConfig=" + this.activeMsgConfig + ",}";
    }
}
