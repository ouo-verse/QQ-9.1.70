package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStVideo implements Serializable {
    public int approvalStatus;
    public int displayIndex;
    public int duration;
    public int fileSize;
    public int height;
    public int isQuic;
    public int mediaQualityRank;
    public float mediaQualityScore;
    public int orientation;
    public int transStatus;
    public int videoPrior;
    public int videoRate;
    public int videoSource;
    public int width;
    long serialVersionUID = 1;
    public String fileId = "";
    public String playUrl = "";
    public ArrayList<GProStVideoUrl> vecVideoUrlList = new ArrayList<>();
    public byte[] busiData = new byte[0];
    public String videoMD5 = "";
    public GProStImage cover = new GProStImage();
    public String patternId = "";

    public int getApprovalStatus() {
        return this.approvalStatus;
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public GProStImage getCover() {
        return this.cover;
    }

    public int getDisplayIndex() {
        return this.displayIndex;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getFileId() {
        return this.fileId;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIsQuic() {
        return this.isQuic;
    }

    public int getMediaQualityRank() {
        return this.mediaQualityRank;
    }

    public float getMediaQualityScore() {
        return this.mediaQualityScore;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public String getPatternId() {
        return this.patternId;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public int getTransStatus() {
        return this.transStatus;
    }

    public ArrayList<GProStVideoUrl> getVecVideoUrlList() {
        return this.vecVideoUrlList;
    }

    public String getVideoMD5() {
        return this.videoMD5;
    }

    public int getVideoPrior() {
        return this.videoPrior;
    }

    public int getVideoRate() {
        return this.videoRate;
    }

    public int getVideoSource() {
        return this.videoSource;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProStVideo{fileId=" + this.fileId + ",fileSize=" + this.fileSize + ",duration=" + this.duration + ",width=" + this.width + ",height=" + this.height + ",playUrl=" + this.playUrl + ",transStatus=" + this.transStatus + ",videoPrior=" + this.videoPrior + ",videoRate=" + this.videoRate + ",vecVideoUrlList=" + this.vecVideoUrlList + ",busiData=" + this.busiData + ",approvalStatus=" + this.approvalStatus + ",videoSource=" + this.videoSource + ",mediaQualityRank=" + this.mediaQualityRank + ",mediaQualityScore=" + this.mediaQualityScore + ",videoMD5=" + this.videoMD5 + ",isQuic=" + this.isQuic + ",orientation=" + this.orientation + ",cover=" + this.cover + ",patternId=" + this.patternId + ",displayIndex=" + this.displayIndex + ",}";
    }
}
