package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStTagInfo implements Serializable {
    public int followState;
    public int isRecommend;
    public int isSelected;
    public int isTop;
    public int status;
    public int tagBaseStatus;
    public int tagTotalFeed;
    public int tagTotalUser;
    public int tagType;
    public long tagViewHistory;
    public long userViewHistory;
    long serialVersionUID = 1;
    public String tagId = "";
    public String tagName = "";
    public String tagDec = "";
    public ArrayList<GProStUser> userListList = new ArrayList<>();
    public ArrayList<GProStFeedAbstract> feedListList = new ArrayList<>();
    public String tagWording = "";
    public GProStShare shareInfo = new GProStShare();
    public GProStTagMedalInfo medal = new GProStTagMedalInfo();
    public GProStTagOperateInfo optInfo = new GProStTagOperateInfo();
    public String operateIconUrl = "";
    public String tagReport = "";
    public String tagIconUrl = "";

    public ArrayList<GProStFeedAbstract> getFeedListList() {
        return this.feedListList;
    }

    public int getFollowState() {
        return this.followState;
    }

    public int getIsRecommend() {
        return this.isRecommend;
    }

    public int getIsSelected() {
        return this.isSelected;
    }

    public int getIsTop() {
        return this.isTop;
    }

    public GProStTagMedalInfo getMedal() {
        return this.medal;
    }

    public String getOperateIconUrl() {
        return this.operateIconUrl;
    }

    public GProStTagOperateInfo getOptInfo() {
        return this.optInfo;
    }

    public GProStShare getShareInfo() {
        return this.shareInfo;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTagBaseStatus() {
        return this.tagBaseStatus;
    }

    public String getTagDec() {
        return this.tagDec;
    }

    public String getTagIconUrl() {
        return this.tagIconUrl;
    }

    public String getTagId() {
        return this.tagId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String getTagReport() {
        return this.tagReport;
    }

    public int getTagTotalFeed() {
        return this.tagTotalFeed;
    }

    public int getTagTotalUser() {
        return this.tagTotalUser;
    }

    public int getTagType() {
        return this.tagType;
    }

    public long getTagViewHistory() {
        return this.tagViewHistory;
    }

    public String getTagWording() {
        return this.tagWording;
    }

    public ArrayList<GProStUser> getUserListList() {
        return this.userListList;
    }

    public long getUserViewHistory() {
        return this.userViewHistory;
    }

    public String toString() {
        return "GProStTagInfo{tagId=" + this.tagId + ",tagName=" + this.tagName + ",tagDec=" + this.tagDec + ",userListList=" + this.userListList + ",feedListList=" + this.feedListList + ",tagTotalUser=" + this.tagTotalUser + ",tagTotalFeed=" + this.tagTotalFeed + ",tagWording=" + this.tagWording + ",tagType=" + this.tagType + ",followState=" + this.followState + ",shareInfo=" + this.shareInfo + ",isTop=" + this.isTop + ",isSelected=" + this.isSelected + ",userViewHistory=" + this.userViewHistory + ",medal=" + this.medal + ",status=" + this.status + ",optInfo=" + this.optInfo + ",tagBaseStatus=" + this.tagBaseStatus + ",isRecommend=" + this.isRecommend + ",tagViewHistory=" + this.tagViewHistory + ",operateIconUrl=" + this.operateIconUrl + ",tagReport=" + this.tagReport + ",tagIconUrl=" + this.tagIconUrl + ",}";
    }
}
