package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class RobotMsgPushSetReq {
    public long groupId;
    public boolean isReceive;
    public long robotUin;
    public RobtMsgSettingType settingType;

    public RobotMsgPushSetReq() {
        this.settingType = RobtMsgSettingType.values()[0];
    }

    public long getGroupId() {
        return this.groupId;
    }

    public boolean getIsReceive() {
        return this.isReceive;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public RobtMsgSettingType getSettingType() {
        return this.settingType;
    }

    public String toString() {
        return "RobotMsgPushSetReq{robotUin=" + this.robotUin + ",settingType=" + this.settingType + ",isReceive=" + this.isReceive + ",groupId=" + this.groupId + ",}";
    }

    public RobotMsgPushSetReq(long j3, RobtMsgSettingType robtMsgSettingType, boolean z16, long j16) {
        RobtMsgSettingType robtMsgSettingType2 = RobtMsgSettingType.values()[0];
        this.robotUin = j3;
        this.settingType = robtMsgSettingType;
        this.isReceive = z16;
        this.groupId = j16;
    }
}
