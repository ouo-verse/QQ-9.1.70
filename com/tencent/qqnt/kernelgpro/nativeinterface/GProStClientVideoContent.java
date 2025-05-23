package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStClientVideoContent {
    public String taskId = "";
    public String videoId = "";
    public String videoUrl = "";
    public String coverUrl = "";

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String toString() {
        return "GProStClientVideoContent{taskId=" + this.taskId + ",videoId=" + this.videoId + ",videoUrl=" + this.videoUrl + ",coverUrl=" + this.coverUrl + ",}";
    }
}
