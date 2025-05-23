package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CleanFileDetail {
    public int chatType;
    public String fileName;
    public String filePath;
    public long fileSize;
    public long fileTime;
    public long forwardSubMsgId;
    public long msgId;
    public String peerUid;
    public boolean wildFile;

    public CleanFileDetail() {
        this.peerUid = "";
        this.fileName = "";
        this.filePath = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getFileTime() {
        return this.fileTime;
    }

    public long getForwardSubMsgId() {
        return this.forwardSubMsgId;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public boolean getWildFile() {
        return this.wildFile;
    }

    public CleanFileDetail(long j3, long j16, String str, int i3, long j17, String str2, long j18, String str3, boolean z16) {
        this.msgId = j3;
        this.forwardSubMsgId = j16;
        this.peerUid = str;
        this.chatType = i3;
        this.fileTime = j17;
        this.fileName = str2;
        this.fileSize = j18;
        this.filePath = str3;
        this.wildFile = z16;
    }
}
