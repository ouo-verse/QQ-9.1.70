package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InviteGroupReq {
    public boolean hasShareMsgInfo;
    public long joinGroupCode;
    public int mainSourceId;
    public int subSourceId;
    public int verifyType;
    public ArrayList<InviteUidInfo> beInvitedUidInfo = new ArrayList<>();
    public String stringMsg = "";
    public String verifyToken = "";
    public ArrayList<ShareMsgInfo> shareMsgInfos = new ArrayList<>();

    public ArrayList<InviteUidInfo> getBeInvitedUidInfo() {
        return this.beInvitedUidInfo;
    }

    public boolean getHasShareMsgInfo() {
        return this.hasShareMsgInfo;
    }

    public long getJoinGroupCode() {
        return this.joinGroupCode;
    }

    public int getMainSourceId() {
        return this.mainSourceId;
    }

    public ArrayList<ShareMsgInfo> getShareMsgInfos() {
        return this.shareMsgInfos;
    }

    public String getStringMsg() {
        return this.stringMsg;
    }

    public int getSubSourceId() {
        return this.subSourceId;
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public int getVerifyType() {
        return this.verifyType;
    }

    public String toString() {
        return "InviteGroupReq{joinGroupCode=" + this.joinGroupCode + ",beInvitedUidInfo=" + this.beInvitedUidInfo + ",stringMsg=" + this.stringMsg + ",mainSourceId=" + this.mainSourceId + ",subSourceId=" + this.subSourceId + ",verifyToken=" + this.verifyToken + ",verifyType=" + this.verifyType + ",shareMsgInfos=" + this.shareMsgInfos + ",hasShareMsgInfo=" + this.hasShareMsgInfo + ",}";
    }
}
