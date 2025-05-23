package com.tencent.imsdk.message;

/* compiled from: P */
/* loaded from: classes7.dex */
public class VideoElement extends MessageBaseElement {
    private int snapshotDownloadFlag;
    private String snapshotDownloadUrl;
    private String snapshotFilePath;
    private int snapshotFileSize;
    private int snapshotHeight;
    private String snapshotType;
    private String snapshotUUID;
    private int snapshotWidth;
    private int videoBusinessID;
    private int videoDownloadFlag;
    private String videoDownloadUrl;
    private int videoDuration;
    private String videoFilePath;
    private int videoFileSize;
    private String videoType;
    private String videoUUID;

    public VideoElement() {
        setElementType(5);
    }

    public int getSnapshotDownloadFlag() {
        return this.snapshotDownloadFlag;
    }

    public String getSnapshotDownloadUrl() {
        return this.snapshotDownloadUrl;
    }

    public String getSnapshotFilePath() {
        return this.snapshotFilePath;
    }

    public int getSnapshotFileSize() {
        return this.snapshotFileSize;
    }

    public int getSnapshotHeight() {
        return this.snapshotHeight;
    }

    public String getSnapshotType() {
        return this.snapshotType;
    }

    public String getSnapshotUUID() {
        return this.snapshotUUID;
    }

    public int getSnapshotWidth() {
        return this.snapshotWidth;
    }

    public int getVideoBusinessID() {
        return this.videoBusinessID;
    }

    public int getVideoDownloadFlag() {
        return this.videoDownloadFlag;
    }

    public String getVideoDownloadUrl() {
        return this.videoDownloadUrl;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public String getVideoFilePath() {
        return this.videoFilePath;
    }

    public int getVideoFileSize() {
        return this.videoFileSize;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public String getVideoUUID() {
        return this.videoUUID;
    }

    public void setSnapshotFilePath(String str) {
        this.snapshotFilePath = str;
    }

    public void setVideoDuration(int i3) {
        this.videoDuration = i3;
    }

    public void setVideoFilePath(String str) {
        this.videoFilePath = str;
    }

    public void setVideoType(String str) {
        this.videoType = str;
    }

    @Override // com.tencent.imsdk.message.MessageBaseElement
    public boolean update(MessageBaseElement messageBaseElement) {
        if (this.elementType == messageBaseElement.elementType) {
            VideoElement videoElement = (VideoElement) messageBaseElement;
            if (this.videoFilePath.equals(videoElement.videoFilePath) && this.snapshotFilePath.equals(videoElement.snapshotFilePath)) {
                this.videoUUID = videoElement.videoUUID;
                this.videoType = videoElement.videoType;
                this.videoFileSize = videoElement.videoFileSize;
                this.videoDuration = videoElement.videoDuration;
                this.videoDownloadUrl = videoElement.videoDownloadUrl;
                this.videoDownloadFlag = videoElement.videoDownloadFlag;
                this.videoBusinessID = videoElement.videoBusinessID;
                this.snapshotUUID = videoElement.snapshotUUID;
                this.snapshotType = videoElement.snapshotType;
                this.snapshotFileSize = videoElement.snapshotFileSize;
                this.snapshotWidth = videoElement.snapshotWidth;
                this.snapshotHeight = videoElement.snapshotHeight;
                this.snapshotDownloadUrl = videoElement.snapshotDownloadUrl;
                this.snapshotDownloadFlag = videoElement.snapshotDownloadFlag;
                return true;
            }
            return false;
        }
        return false;
    }
}
