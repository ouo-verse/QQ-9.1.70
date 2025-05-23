package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AioOperateGrayTipElement implements Serializable {
    public String fromGrpCodeOfTmpChat;
    public int operateType;
    public String peerUid;
    long serialVersionUID;

    public AioOperateGrayTipElement() {
        this.serialVersionUID = 1L;
        this.peerUid = "";
        this.fromGrpCodeOfTmpChat = "";
    }

    public String getFromGrpCodeOfTmpChat() {
        return this.fromGrpCodeOfTmpChat;
    }

    public int getOperateType() {
        return this.operateType;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "AioOperateGrayTipElement{operateType=" + this.operateType + ",peerUid=" + this.peerUid + ",fromGrpCodeOfTmpChat=" + this.fromGrpCodeOfTmpChat + ",}";
    }

    public AioOperateGrayTipElement(int i3, String str, String str2) {
        this.serialVersionUID = 1L;
        this.operateType = i3;
        this.peerUid = str;
        this.fromGrpCodeOfTmpChat = str2;
    }
}
