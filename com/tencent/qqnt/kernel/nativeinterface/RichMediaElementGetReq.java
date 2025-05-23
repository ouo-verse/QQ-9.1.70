package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RichMediaElementGetReq implements IKernelModel {
    public int chatType;
    public int downSourceType;
    public int downloadType;
    public long elementId;
    public long fileModelId;
    public String filePath;
    public long msgId;
    public String peerUid;
    public int thumbSize;
    public int triggerType;

    public RichMediaElementGetReq() {
        this.peerUid = "";
        this.filePath = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getDownSourceType() {
        return this.downSourceType;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public long getElementId() {
        return this.elementId;
    }

    public long getFileModelId() {
        return this.fileModelId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public void setChatType(int i3) {
        this.chatType = i3;
    }

    public void setDownSourceType(int i3) {
        this.downSourceType = i3;
    }

    public void setDownloadType(int i3) {
        this.downloadType = i3;
    }

    public void setElementId(long j3) {
        this.elementId = j3;
    }

    public void setFileModelId(long j3) {
        this.fileModelId = j3;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setMsgId(long j3) {
        this.msgId = j3;
    }

    public void setPeerUid(String str) {
        this.peerUid = str;
    }

    public void setThumbSize(int i3) {
        this.thumbSize = i3;
    }

    public void setTriggerType(int i3) {
        this.triggerType = i3;
    }

    public String toString() {
        return "RichMediaElementGetReq{msgId=" + this.msgId + ",peerUid=" + this.peerUid + ",chatType=" + this.chatType + ",elementId=" + this.elementId + ",downloadType=" + this.downloadType + ",thumbSize=" + this.thumbSize + ",filePath=" + this.filePath + ",fileModelId=" + this.fileModelId + ",downSourceType=" + this.downSourceType + ",triggerType=" + this.triggerType + ",}";
    }

    public RichMediaElementGetReq(long j3, String str, int i3, long j16, int i16, int i17, String str2, long j17, int i18, int i19) {
        this.msgId = j3;
        this.peerUid = str;
        this.chatType = i3;
        this.elementId = j16;
        this.downloadType = i16;
        this.thumbSize = i17;
        this.filePath = str2;
        this.fileModelId = j17;
        this.downSourceType = i18;
        this.triggerType = i19;
    }
}
