package com.tencent.biz.qqcircle.beans;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import e30.b;
import e30.d;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StUserRecomInfo;
import java.util.List;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleDitto$StItemInfo;

/* loaded from: classes4.dex */
public class QFSFeedPymkBean {
    private int authType;
    private String avatarUrl;
    private byte[] busiReport;
    private String datongJsonData;
    private String fansNum;
    private List<b> feeds;
    private int followState;
    private boolean mIsFirstData = false;
    private String name;
    private String recommend;
    private List<FeedCloudMeta$StUser> relationUserList;
    private List<FeedCloudCommon$Entry> tagList;
    private String traceId;
    private String uin;
    private String worksNum;

    public QFSFeedPymkBean(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, String str) {
        this.uin = "";
        this.avatarUrl = "";
        this.name = "";
        this.followState = 0;
        this.recommend = "";
        this.authType = 0;
        this.worksNum = "";
        this.fansNum = "";
        this.uin = qQCircleDitto$StItemInfo.f429300id.get();
        this.avatarUrl = QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.urlInfo.get(), "user_avatar_url");
        this.name = qQCircleDitto$StItemInfo.name.get();
        this.followState = qQCircleDitto$StItemInfo.buttonInfo.buttonValue.get();
        List<FeedCloudCommon$Entry> list = qQCircleDitto$StItemInfo.busiInfo.get();
        this.fansNum = QCirclePluginUtil.getValueFromListEntry(list, "fansnum");
        this.worksNum = QCirclePluginUtil.getValueFromListEntry(list, "feedcount");
        if (qQCircleDitto$StItemInfo.des.get().size() > 0) {
            this.recommend = qQCircleDitto$StItemInfo.des.get().get(0);
        }
        this.authType = getUserVerifiedType(qQCircleDitto$StItemInfo);
        this.feeds = d.b(qQCircleDitto$StItemInfo.feeds.get());
        this.datongJsonData = qQCircleDitto$StItemInfo.datongJsonData.get();
        this.busiReport = qQCircleDitto$StItemInfo.busiReport.get().toByteArray();
        this.traceId = str;
        this.relationUserList = qQCircleDitto$StItemInfo.relationUserList.get();
        this.tagList = qQCircleDitto$StItemInfo.userTagList.get();
    }

    private int getUserVerifiedType(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo != null && qQCircleDitto$StItemInfo.busiInfo.get() != null) {
            String valueFromListEntry = QCirclePluginUtil.getValueFromListEntry(qQCircleDitto$StItemInfo.busiInfo.get(), "user-certification");
            if (valueFromListEntry.equals(String.valueOf(1))) {
                return 1;
            }
            if (valueFromListEntry.equals(String.valueOf(2))) {
                return 2;
            }
            return 0;
        }
        return 0;
    }

    public int getAuthType() {
        return this.authType;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public byte[] getBusiReport() {
        return this.busiReport;
    }

    public String getDatongJsonData() {
        return this.datongJsonData;
    }

    public String getFansNum() {
        return this.fansNum;
    }

    public List<b> getFeedBlockData() {
        return this.feeds;
    }

    public int getFollowState() {
        return this.followState;
    }

    public boolean getIsFirstData() {
        return this.mIsFirstData;
    }

    public String getName() {
        return this.name;
    }

    public String getRecommend() {
        return this.recommend;
    }

    public List<FeedCloudMeta$StUser> getRelationUserList() {
        return this.relationUserList;
    }

    public List<FeedCloudCommon$Entry> getTagList() {
        return this.tagList;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUin() {
        return this.uin;
    }

    public String getWorksNum() {
        return this.worksNum;
    }

    public void setIsFirstData(boolean z16) {
        this.mIsFirstData = z16;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public QFSFeedPymkBean(FeedCloudMeta$StUserRecomInfo feedCloudMeta$StUserRecomInfo, String str) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        this.uin = "";
        this.avatarUrl = "";
        this.name = "";
        this.followState = 0;
        this.recommend = "";
        this.authType = 0;
        this.worksNum = "";
        this.fansNum = "";
        if (feedCloudMeta$StUserRecomInfo == null || (feedCloudMeta$StUser = feedCloudMeta$StUserRecomInfo.user) == null) {
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = feedCloudMeta$StUser.get();
        this.uin = feedCloudMeta$StUser2.f398463id.get();
        this.avatarUrl = feedCloudMeta$StUser2.icon.iconUrl.get();
        this.name = feedCloudMeta$StUser2.nick.get();
        this.followState = feedCloudMeta$StUser2.followState.get();
        this.authType = QCirclePluginUtil.getAuthType(feedCloudMeta$StUser2.get());
        this.recommend = feedCloudMeta$StUserRecomInfo.recomReason.get();
        this.fansNum = String.valueOf(feedCloudMeta$StUser2.fansCount.get());
        QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
        try {
            qQCircleBase$StUserBusiData.mergeFrom(feedCloudMeta$StUser2.busiData.get().toByteArray());
            this.worksNum = String.valueOf(qQCircleBase$StUserBusiData.feedNum.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        this.feeds = d.b(feedCloudMeta$StUserRecomInfo.stFeedList.get());
        this.datongJsonData = feedCloudMeta$StUserRecomInfo.datongJsonData.get();
        this.busiReport = feedCloudMeta$StUserRecomInfo.busiReport.get().toByteArray();
        this.traceId = str;
        this.relationUserList = feedCloudMeta$StUserRecomInfo.relationUserList.get();
        this.tagList = feedCloudMeta$StUserRecomInfo.userTagList.get();
    }
}
