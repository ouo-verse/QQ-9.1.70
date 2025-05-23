package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DigestMsgElem {
    public int msgType;
    public DigestTextMsg textMsg = new DigestTextMsg();
    public DigestFaceMsg faceMsg = new DigestFaceMsg();
    public DigestImageMsg imageMsg = new DigestImageMsg();
    public DigestGroupFileMsg groupFileMsg = new DigestGroupFileMsg();
    public DigestShareMsg shareMsg = new DigestShareMsg();
    public DigestRichMsg richMsg = new DigestRichMsg();
    public DigestArkMsg arkMsg = new DigestArkMsg();

    public DigestArkMsg getArkMsg() {
        return this.arkMsg;
    }

    public DigestFaceMsg getFaceMsg() {
        return this.faceMsg;
    }

    public DigestGroupFileMsg getGroupFileMsg() {
        return this.groupFileMsg;
    }

    public DigestImageMsg getImageMsg() {
        return this.imageMsg;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public DigestRichMsg getRichMsg() {
        return this.richMsg;
    }

    public DigestShareMsg getShareMsg() {
        return this.shareMsg;
    }

    public DigestTextMsg getTextMsg() {
        return this.textMsg;
    }

    public String toString() {
        return "DigestMsgElem{msgType=" + this.msgType + ",textMsg=" + this.textMsg + ",faceMsg=" + this.faceMsg + ",imageMsg=" + this.imageMsg + ",groupFileMsg=" + this.groupFileMsg + ",shareMsg=" + this.shareMsg + ",richMsg=" + this.richMsg + ",arkMsg=" + this.arkMsg + ",}";
    }
}
