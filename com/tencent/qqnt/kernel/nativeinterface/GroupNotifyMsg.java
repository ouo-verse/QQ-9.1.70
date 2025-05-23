package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupNotifyMsg implements IKernelModel, Serializable {
    public long actionTime;
    public int groupFlagExt3;
    public long joinGroupSuspiciousCode;
    public int localCategoryFlag;
    public int originMsgType;
    public long seq;
    long serialVersionUID = 1;
    public GroupNotifyMsgType type = GroupNotifyMsgType.values()[0];
    public GroupNotifyMsgStatus status = GroupNotifyMsgStatus.values()[0];
    public GroupNotifyGroup group = new GroupNotifyGroup();
    public GroupNotifyUser user1 = new GroupNotifyUser();
    public GroupNotifyUser user2 = new GroupNotifyUser();
    public GroupNotifyUser actionUser = new GroupNotifyUser();
    public GroupInviteExt invitationExt = new GroupInviteExt();
    public String postscript = "";
    public ArrayList<Long> repeatSeqs = new ArrayList<>();
    public String warningTips = "";
    public String templateSeq = "";
    public byte[] joinGroupTransInfo = new byte[0];
    public byte[] operateTransInfo = new byte[0];
    public String showModuleMsg = "";

    public long getActionTime() {
        return this.actionTime;
    }

    public GroupNotifyUser getActionUser() {
        return this.actionUser;
    }

    public GroupNotifyGroup getGroup() {
        return this.group;
    }

    public int getGroupFlagExt3() {
        return this.groupFlagExt3;
    }

    public GroupInviteExt getInvitationExt() {
        return this.invitationExt;
    }

    public long getJoinGroupSuspiciousCode() {
        return this.joinGroupSuspiciousCode;
    }

    public byte[] getJoinGroupTransInfo() {
        return this.joinGroupTransInfo;
    }

    public int getLocalCategoryFlag() {
        return this.localCategoryFlag;
    }

    public byte[] getOperateTransInfo() {
        return this.operateTransInfo;
    }

    public int getOriginMsgType() {
        return this.originMsgType;
    }

    public String getPostscript() {
        return this.postscript;
    }

    public ArrayList<Long> getRepeatSeqs() {
        return this.repeatSeqs;
    }

    public long getSeq() {
        return this.seq;
    }

    public String getShowModuleMsg() {
        return this.showModuleMsg;
    }

    public GroupNotifyMsgStatus getStatus() {
        return this.status;
    }

    public String getTemplateSeq() {
        return this.templateSeq;
    }

    public GroupNotifyMsgType getType() {
        return this.type;
    }

    public GroupNotifyUser getUser1() {
        return this.user1;
    }

    public GroupNotifyUser getUser2() {
        return this.user2;
    }

    public String getWarningTips() {
        return this.warningTips;
    }

    public void setActionTime(long j3) {
        this.actionTime = j3;
    }

    public void setActionUser(GroupNotifyUser groupNotifyUser) {
        this.actionUser = groupNotifyUser;
    }

    public void setGroup(GroupNotifyGroup groupNotifyGroup) {
        this.group = groupNotifyGroup;
    }

    public void setGroupFlagExt3(int i3) {
        this.groupFlagExt3 = i3;
    }

    public void setInvitationExt(GroupInviteExt groupInviteExt) {
        this.invitationExt = groupInviteExt;
    }

    public void setJoinGroupSuspiciousCode(long j3) {
        this.joinGroupSuspiciousCode = j3;
    }

    public void setJoinGroupTransInfo(byte[] bArr) {
        this.joinGroupTransInfo = bArr;
    }

    public void setLocalCategoryFlag(int i3) {
        this.localCategoryFlag = i3;
    }

    public void setOperateTransInfo(byte[] bArr) {
        this.operateTransInfo = bArr;
    }

    public void setOriginMsgType(int i3) {
        this.originMsgType = i3;
    }

    public void setPostscript(String str) {
        this.postscript = str;
    }

    public void setRepeatSeqs(ArrayList<Long> arrayList) {
        this.repeatSeqs = arrayList;
    }

    public void setSeq(long j3) {
        this.seq = j3;
    }

    public void setShowModuleMsg(String str) {
        this.showModuleMsg = str;
    }

    public void setStatus(GroupNotifyMsgStatus groupNotifyMsgStatus) {
        this.status = groupNotifyMsgStatus;
    }

    public void setTemplateSeq(String str) {
        this.templateSeq = str;
    }

    public void setType(GroupNotifyMsgType groupNotifyMsgType) {
        this.type = groupNotifyMsgType;
    }

    public void setUser1(GroupNotifyUser groupNotifyUser) {
        this.user1 = groupNotifyUser;
    }

    public void setUser2(GroupNotifyUser groupNotifyUser) {
        this.user2 = groupNotifyUser;
    }

    public void setWarningTips(String str) {
        this.warningTips = str;
    }

    public String toString() {
        return "GroupNotifyMsg{seq=" + this.seq + ",type=" + this.type + ",status=" + this.status + ",group=" + this.group + ",user1=" + this.user1 + ",user2=" + this.user2 + ",actionUser=" + this.actionUser + ",actionTime=" + this.actionTime + ",invitationExt=" + this.invitationExt + ",postscript=" + this.postscript + ",repeatSeqs=" + this.repeatSeqs + ",warningTips=" + this.warningTips + ",templateSeq=" + this.templateSeq + ",groupFlagExt3=" + this.groupFlagExt3 + ",joinGroupTransInfo=" + this.joinGroupTransInfo + ",operateTransInfo=" + this.operateTransInfo + ",showModuleMsg=" + this.showModuleMsg + ",originMsgType=" + this.originMsgType + ",joinGroupSuspiciousCode=" + this.joinGroupSuspiciousCode + ",localCategoryFlag=" + this.localCategoryFlag + ",}";
    }
}
