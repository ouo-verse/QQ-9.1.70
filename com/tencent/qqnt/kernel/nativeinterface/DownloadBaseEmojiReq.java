package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DownloadBaseEmojiReq {
    public String emojiId = "";
    public String groupName = "";
    public DownloadBaseEmojiInfo downloadInfo = new DownloadBaseEmojiInfo();

    public DownloadBaseEmojiInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public String getEmojiId() {
        return this.emojiId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String toString() {
        return "DownloadBaseEmojiReq{emojiId=" + this.emojiId + ",groupName=" + this.groupName + ",downloadInfo=" + this.downloadInfo + ",}";
    }
}
