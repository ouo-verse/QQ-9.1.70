package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMsgMaskMemberInfo {
    public long flagExPos;
    public int groupMsgHideSwitch;
    public long groupMsgMask;
    public int groupMsgPreviewSwitch;
    public int groupRingtoneId;
    public int groupRingtoneSwitch;
    public int groupVibrateSwitch;
    public int heartbeatTime;
    public String memberUid = "";

    public long getFlagExPos() {
        return this.flagExPos;
    }

    public int getGroupMsgHideSwitch() {
        return this.groupMsgHideSwitch;
    }

    public long getGroupMsgMask() {
        return this.groupMsgMask;
    }

    public int getGroupMsgPreviewSwitch() {
        return this.groupMsgPreviewSwitch;
    }

    public int getGroupRingtoneId() {
        return this.groupRingtoneId;
    }

    public int getGroupRingtoneSwitch() {
        return this.groupRingtoneSwitch;
    }

    public int getGroupVibrateSwitch() {
        return this.groupVibrateSwitch;
    }

    public int getHeartbeatTime() {
        return this.heartbeatTime;
    }

    public String getMemberUid() {
        return this.memberUid;
    }

    public String toString() {
        return "GroupMsgMaskMemberInfo{memberUid=" + this.memberUid + ",flagExPos=" + this.flagExPos + ",heartbeatTime=" + this.heartbeatTime + ",groupMsgMask=" + this.groupMsgMask + ",groupMsgHideSwitch=" + this.groupMsgHideSwitch + ",groupMsgPreviewSwitch=" + this.groupMsgPreviewSwitch + ",groupRingtoneSwitch=" + this.groupRingtoneSwitch + ",groupVibrateSwitch=" + this.groupVibrateSwitch + ",groupRingtoneId=" + this.groupRingtoneId + ",}";
    }
}
