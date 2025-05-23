package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStFeed implements Serializable {
    public int allowFeedComment;
    public int auditStatus;
    public int commentCount;
    public long createTime;
    public long createTimeNs;
    public long discussionNum;
    public int feedSourceType;
    public int feedType;
    public int feedViolationType;
    public long groupCode;
    public boolean isDeleted;
    public int mediaLockCount;
    public boolean needWebview;
    public long updateTime;
    long serialVersionUID = 1;
    public String idd = "";
    public GProStRichText title = new GProStRichText();
    public GProStRichText subtitle = new GProStRichText();
    public GProStUser poster = new GProStUser();
    public ArrayList<GProStVideo> videos = new ArrayList<>();
    public GProStRichText contents = new GProStRichText();
    public GProStEmotionReactionInfo emotionReaction = new GProStEmotionReactionInfo();
    public ArrayList<GProStComment> vecCommentList = new ArrayList<>();
    public GProStShare share = new GProStShare();
    public GProStVisitor visitorInfo = new GProStVisitor();
    public ArrayList<GProStImage> images = new ArrayList<>();
    public GProStPoiInfoV2 poiInfo = new GProStPoiInfoV2();
    public ArrayList<GProStTagInfo> tagInfos = new ArrayList<>();
    public byte[] busiReport = new byte[0];
    public ArrayList<Integer> opMaskList = new ArrayList<>();
    public GProStOpinfo opinfo = new GProStOpinfo();
    public ArrayList<GProFeedEntry> extInfoList = new ArrayList<>();
    public String patternInfo = "";
    public GProStChannelInfo channelInfo = new GProStChannelInfo();
    public GProStFeedSummary summary = new GProStFeedSummary();
    public GProStRecomInfo recomInfo = new GProStRecomInfo();
    public GProFeedMetaData meta = new GProFeedMetaData();
    public GProTopInfo topInfo = new GProTopInfo();
    public ArrayList<GProStChannelSign> recommendChannels = new ArrayList<>();
    public GProTotalLike totalLike = new GProTotalLike();
    public GProInteraction latestInteraction = new GProInteraction();
    public GProTotalPrefer totalPrefer = new GProTotalPrefer();
    public String defaultBackgroundImg = "";
    public GProStImage cover = new GProStImage();
    public GProRecommendCard recommendCard = new GProRecommendCard();
    public ArrayList<GProStRichTextTopicContent> topicContents = new ArrayList<>();
    public ArrayList<GProStRichTextGroupContent> groupContentList = new ArrayList<>();
    public GProStBusinessCard businessCard = new GProStBusinessCard();
    public ArrayList<Integer> functionList = new ArrayList<>();
    public GProChannelTopInfo channelTopInfo = new GProChannelTopInfo();
    public GProContentWithStyle contentWithStyle = new GProContentWithStyle();
    public GProThirdBar thirdBar = new GProThirdBar();
    public String floatFeedViewTag = "";
    public String feedViolationText = "";
    public String clientTaskId = "";
    public ArrayList<GProStComment> externalCommentList = new ArrayList<>();
    public ArrayList<GProStUser> externalLikeUserList = new ArrayList<>();

    public int getAllowFeedComment() {
        return this.allowFeedComment;
    }

    public int getAuditStatus() {
        return this.auditStatus;
    }

    public byte[] getBusiReport() {
        return this.busiReport;
    }

    public GProStBusinessCard getBusinessCard() {
        return this.businessCard;
    }

    public GProStChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public GProChannelTopInfo getChannelTopInfo() {
        return this.channelTopInfo;
    }

    public String getClientTaskId() {
        return this.clientTaskId;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public GProContentWithStyle getContentWithStyle() {
        return this.contentWithStyle;
    }

    public GProStRichText getContents() {
        return this.contents;
    }

    public GProStImage getCover() {
        return this.cover;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getCreateTimeNs() {
        return this.createTimeNs;
    }

    public String getDefaultBackgroundImg() {
        return this.defaultBackgroundImg;
    }

    public long getDiscussionNum() {
        return this.discussionNum;
    }

    public GProStEmotionReactionInfo getEmotionReaction() {
        return this.emotionReaction;
    }

    public ArrayList<GProFeedEntry> getExtInfoList() {
        return this.extInfoList;
    }

    public ArrayList<GProStComment> getExternalCommentList() {
        return this.externalCommentList;
    }

    public ArrayList<GProStUser> getExternalLikeUserList() {
        return this.externalLikeUserList;
    }

    public int getFeedSourceType() {
        return this.feedSourceType;
    }

    public int getFeedType() {
        return this.feedType;
    }

    public String getFeedViolationText() {
        return this.feedViolationText;
    }

    public int getFeedViolationType() {
        return this.feedViolationType;
    }

    public String getFloatFeedViewTag() {
        return this.floatFeedViewTag;
    }

    public ArrayList<Integer> getFunctionList() {
        return this.functionList;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public ArrayList<GProStRichTextGroupContent> getGroupContentList() {
        return this.groupContentList;
    }

    public String getIdd() {
        return this.idd;
    }

    public ArrayList<GProStImage> getImages() {
        return this.images;
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public GProInteraction getLatestInteraction() {
        return this.latestInteraction;
    }

    public int getMediaLockCount() {
        return this.mediaLockCount;
    }

    public GProFeedMetaData getMeta() {
        return this.meta;
    }

    public boolean getNeedWebview() {
        return this.needWebview;
    }

    public ArrayList<Integer> getOpMaskList() {
        return this.opMaskList;
    }

    public GProStOpinfo getOpinfo() {
        return this.opinfo;
    }

    public String getPatternInfo() {
        return this.patternInfo;
    }

    public GProStPoiInfoV2 getPoiInfo() {
        return this.poiInfo;
    }

    public GProStUser getPoster() {
        return this.poster;
    }

    public GProStRecomInfo getRecomInfo() {
        return this.recomInfo;
    }

    public GProRecommendCard getRecommendCard() {
        return this.recommendCard;
    }

    public ArrayList<GProStChannelSign> getRecommendChannels() {
        return this.recommendChannels;
    }

    public GProStShare getShare() {
        return this.share;
    }

    public GProStRichText getSubtitle() {
        return this.subtitle;
    }

    public GProStFeedSummary getSummary() {
        return this.summary;
    }

    public ArrayList<GProStTagInfo> getTagInfos() {
        return this.tagInfos;
    }

    public GProThirdBar getThirdBar() {
        return this.thirdBar;
    }

    public GProStRichText getTitle() {
        return this.title;
    }

    public GProTopInfo getTopInfo() {
        return this.topInfo;
    }

    public ArrayList<GProStRichTextTopicContent> getTopicContents() {
        return this.topicContents;
    }

    public GProTotalLike getTotalLike() {
        return this.totalLike;
    }

    public GProTotalPrefer getTotalPrefer() {
        return this.totalPrefer;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public ArrayList<GProStComment> getVecCommentList() {
        return this.vecCommentList;
    }

    public ArrayList<GProStVideo> getVideos() {
        return this.videos;
    }

    public GProStVisitor getVisitorInfo() {
        return this.visitorInfo;
    }

    public String toString() {
        return "GProStFeed{idd=" + this.idd + ",title=" + this.title + ",subtitle=" + this.subtitle + ",poster=" + this.poster + ",videos=" + this.videos + ",contents=" + this.contents + ",createTime=" + this.createTime + ",emotionReaction=" + this.emotionReaction + ",commentCount=" + this.commentCount + ",vecCommentList=" + this.vecCommentList + ",share=" + this.share + ",visitorInfo=" + this.visitorInfo + ",images=" + this.images + ",poiInfo=" + this.poiInfo + ",tagInfos=" + this.tagInfos + ",busiReport=" + this.busiReport + ",opMaskList=" + this.opMaskList + ",opinfo=" + this.opinfo + ",extInfoList=" + this.extInfoList + ",patternInfo=" + this.patternInfo + ",channelInfo=" + this.channelInfo + ",createTimeNs=" + this.createTimeNs + ",summary=" + this.summary + ",recomInfo=" + this.recomInfo + ",meta=" + this.meta + ",topInfo=" + this.topInfo + ",recommendChannels=" + this.recommendChannels + ",updateTime=" + this.updateTime + ",totalLike=" + this.totalLike + ",latestInteraction=" + this.latestInteraction + ",discussionNum=" + this.discussionNum + ",feedType=" + this.feedType + ",totalPrefer=" + this.totalPrefer + ",defaultBackgroundImg=" + this.defaultBackgroundImg + ",groupCode=" + this.groupCode + ",feedSourceType=" + this.feedSourceType + ",cover=" + this.cover + ",recommendCard=" + this.recommendCard + ",needWebview=" + this.needWebview + ",topicContents=" + this.topicContents + ",groupContentList=" + this.groupContentList + ",businessCard=" + this.businessCard + ",functionList=" + this.functionList + ",auditStatus=" + this.auditStatus + ",channelTopInfo=" + this.channelTopInfo + ",contentWithStyle=" + this.contentWithStyle + ",thirdBar=" + this.thirdBar + ",mediaLockCount=" + this.mediaLockCount + ",floatFeedViewTag=" + this.floatFeedViewTag + ",feedViolationText=" + this.feedViolationText + ",feedViolationType=" + this.feedViolationType + ",clientTaskId=" + this.clientTaskId + ",isDeleted=" + this.isDeleted + ",allowFeedComment=" + this.allowFeedComment + ",externalCommentList=" + this.externalCommentList + ",externalLikeUserList=" + this.externalLikeUserList + ",}";
    }
}
