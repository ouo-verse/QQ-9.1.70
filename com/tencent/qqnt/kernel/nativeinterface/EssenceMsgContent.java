package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class EssenceMsgContent {
    public int faceIndex;
    public long fileSize;
    public int msgType;
    public String text = "";
    public String faceText = "";
    public String imageUrl = "";
    public String imageThumbnailUrl = "";
    public String shareTitle = "";
    public String shareSummary = "";
    public String shareBrief = "";
    public String shareUrl = "";
    public String shareAction = "";
    public String shareSource = "";
    public String shareImageUrl = "";
    public String fileName = "";
    public String fileThumbnailUrl = "";
    public String fileId = "";

    public int getFaceIndex() {
        return this.faceIndex;
    }

    public String getFaceText() {
        return this.faceText;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileThumbnailUrl() {
        return this.fileThumbnailUrl;
    }

    public String getImageThumbnailUrl() {
        return this.imageThumbnailUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getShareAction() {
        return this.shareAction;
    }

    public String getShareBrief() {
        return this.shareBrief;
    }

    public String getShareImageUrl() {
        return this.shareImageUrl;
    }

    public String getShareSource() {
        return this.shareSource;
    }

    public String getShareSummary() {
        return this.shareSummary;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "EssenceMsgContent{msgType=" + this.msgType + ",text=" + this.text + ",faceIndex=" + this.faceIndex + ",faceText=" + this.faceText + ",imageUrl=" + this.imageUrl + ",imageThumbnailUrl=" + this.imageThumbnailUrl + ",shareTitle=" + this.shareTitle + ",shareSummary=" + this.shareSummary + ",shareBrief=" + this.shareBrief + ",shareUrl=" + this.shareUrl + ",shareAction=" + this.shareAction + ",shareSource=" + this.shareSource + ",shareImageUrl=" + this.shareImageUrl + ",fileName=" + this.fileName + ",fileThumbnailUrl=" + this.fileThumbnailUrl + ",fileSize=" + this.fileSize + ",fileId=" + this.fileId + ",}";
    }
}
