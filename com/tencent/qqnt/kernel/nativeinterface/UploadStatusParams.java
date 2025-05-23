package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class UploadStatusParams {
    public int chatType;
    public long elemId;
    public long modelId;
    public long msgId;
    public String path;
    public String peerUid;
    public int status;

    public UploadStatusParams() {
        this.peerUid = "";
        this.path = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public long getElemId() {
        return this.elemId;
    }

    public long getModelId() {
        return this.modelId;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getPath() {
        return this.path;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public int getStatus() {
        return this.status;
    }

    public UploadStatusParams(long j3, long j16, long j17, String str, int i3, int i16, String str2) {
        this.msgId = j3;
        this.elemId = j16;
        this.modelId = j17;
        this.peerUid = str;
        this.chatType = i3;
        this.status = i16;
        this.path = str2;
    }
}
