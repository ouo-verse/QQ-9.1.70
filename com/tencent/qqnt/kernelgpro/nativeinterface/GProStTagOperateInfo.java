package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStTagOperateInfo implements Serializable {
    public long activityEndTime;
    public long activityStartTime;
    public long beWhiteEndTime;
    public long beWhiteStartTime;
    public int isWhite;
    long serialVersionUID = 1;
    public String createUser = "";
    public String coverURL = "";
    public String desc = "";
    public String backgroundURL = "";
    public String bannerURL = "";
    public String bannerSkipLink = "";
    public String recommendReason = "";
    public String publishSchema = "";

    public long getActivityEndTime() {
        return this.activityEndTime;
    }

    public long getActivityStartTime() {
        return this.activityStartTime;
    }

    public String getBackgroundURL() {
        return this.backgroundURL;
    }

    public String getBannerSkipLink() {
        return this.bannerSkipLink;
    }

    public String getBannerURL() {
        return this.bannerURL;
    }

    public long getBeWhiteEndTime() {
        return this.beWhiteEndTime;
    }

    public long getBeWhiteStartTime() {
        return this.beWhiteStartTime;
    }

    public String getCoverURL() {
        return this.coverURL;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIsWhite() {
        return this.isWhite;
    }

    public String getPublishSchema() {
        return this.publishSchema;
    }

    public String getRecommendReason() {
        return this.recommendReason;
    }

    public String toString() {
        return "GProStTagOperateInfo{createUser=" + this.createUser + ",coverURL=" + this.coverURL + ",desc=" + this.desc + ",backgroundURL=" + this.backgroundURL + ",bannerURL=" + this.bannerURL + ",bannerSkipLink=" + this.bannerSkipLink + ",activityStartTime=" + this.activityStartTime + ",activityEndTime=" + this.activityEndTime + ",recommendReason=" + this.recommendReason + ",isWhite=" + this.isWhite + ",beWhiteStartTime=" + this.beWhiteStartTime + ",beWhiteEndTime=" + this.beWhiteEndTime + ",publishSchema=" + this.publishSchema + ",}";
    }
}
