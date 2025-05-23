package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RevokeElement implements Serializable {
    public boolean isSelfOperate;
    public String operatorMemRemark;
    public String operatorNick;
    public String operatorRemark;
    public long operatorRole;
    public long operatorTinyId;
    public String operatorUid;
    public String origMsgSenderMemRemark;
    public String origMsgSenderNick;
    public String origMsgSenderRemark;
    public String origMsgSenderUid;
    long serialVersionUID;
    public String wording;

    public RevokeElement() {
        this.serialVersionUID = 1L;
        this.operatorUid = "";
        this.origMsgSenderUid = "";
        this.wording = "";
    }

    public boolean getIsSelfOperate() {
        return this.isSelfOperate;
    }

    public String getOperatorMemRemark() {
        return this.operatorMemRemark;
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public String getOperatorRemark() {
        return this.operatorRemark;
    }

    public long getOperatorRole() {
        return this.operatorRole;
    }

    public long getOperatorTinyId() {
        return this.operatorTinyId;
    }

    public String getOperatorUid() {
        return this.operatorUid;
    }

    public String getOrigMsgSenderMemRemark() {
        return this.origMsgSenderMemRemark;
    }

    public String getOrigMsgSenderNick() {
        return this.origMsgSenderNick;
    }

    public String getOrigMsgSenderRemark() {
        return this.origMsgSenderRemark;
    }

    public String getOrigMsgSenderUid() {
        return this.origMsgSenderUid;
    }

    public String getWording() {
        return this.wording;
    }

    public String toString() {
        return "RevokeElement{operatorTinyId=" + this.operatorTinyId + ",operatorRole=" + this.operatorRole + ",operatorUid=" + this.operatorUid + ",operatorNick=" + this.operatorNick + ",operatorRemark=" + this.operatorRemark + ",operatorMemRemark=" + this.operatorMemRemark + ",origMsgSenderUid=" + this.origMsgSenderUid + ",origMsgSenderNick=" + this.origMsgSenderNick + ",origMsgSenderRemark=" + this.origMsgSenderRemark + ",origMsgSenderMemRemark=" + this.origMsgSenderMemRemark + ",isSelfOperate=" + this.isSelfOperate + ",wording=" + this.wording + ",}";
    }

    public RevokeElement(long j3, long j16, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z16, String str9) {
        this.serialVersionUID = 1L;
        this.operatorTinyId = j3;
        this.operatorRole = j16;
        this.operatorUid = str;
        this.operatorNick = str2;
        this.operatorRemark = str3;
        this.operatorMemRemark = str4;
        this.origMsgSenderUid = str5;
        this.origMsgSenderNick = str6;
        this.origMsgSenderRemark = str7;
        this.origMsgSenderMemRemark = str8;
        this.isSelfOperate = z16;
        this.wording = str9;
    }
}
