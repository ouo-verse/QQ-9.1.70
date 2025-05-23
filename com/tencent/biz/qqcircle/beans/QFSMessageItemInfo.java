package com.tencent.biz.qqcircle.beans;

import com.tencent.biz.qqcircle.helpers.q;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StNoticeCategory;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMessageItemInfo {
    public static final int ITEM_TYPE_CATEGORY = -102;
    public static final int ITEM_TYPE_CHAT = -103;
    public static final int ITEM_TYPE_FRIEND_RECOMMEND = -104;
    public static final int ITEM_TYPE_FRIEND_RECOMMEND_CONTRACT_GUIDE = -1005;
    public static final int ITEM_TYPE_FRIEND_RECOMMEND_HEAD = -1002;
    public static final int ITEM_TYPE_HEAD = -101;
    public static final int ITEM_TYPE_LOAD_MORE = -1001;
    public static final int ITEM_TYPE_MSG_RECOMMEND = -1007;
    public static final int ITEM_TYPE_MSG_RECOMMEND_HEAD = -1006;
    public static final int ITEM_TYPE_NOTICE = -100;
    public static final int ITEM_TYPE_QUICK_THANK = -1004;
    public static final int ITEM_TYPE_SPILT_LINE = -1000;
    private FeedCloudMeta$StFeed mApertureExposeFeed;
    private boolean mCanShowHighLightUiStyle;
    private boolean mConsumeAperture;
    private boolean mHasShowApertureAnim;
    private boolean mHasShowBlueAnimation;
    private Map<Integer, FeedCloudMeta$StNoticeCategory> mHeadNoticeCategoryMap;
    private int mLaunchTo;
    private long mMessageTimestamp;
    private boolean mNeedTop;
    private QQCircleFeedBase$StNoticeBusiData mNoticeBusiData;
    private QCircleRecentDataInterface mRecentData;
    private FeedCloudMeta$StNotice mStNotice;
    private FeedCloudMeta$StNoticeCategory mStNoticeCategory;
    private String mTraceId;
    private int mType;
    private QQCircleBase$StUserBusiData mUserBusiData;
    private boolean mIsListTopItem = false;
    private boolean mForceRightArrow = false;
    private boolean mUseSmallAvatar = false;
    private boolean mIsHideTime = false;
    private boolean mRightAreaVerticalCenter = false;
    private boolean mIsNewMessage = false;
    private boolean mCanShowHeadCircle = true;

    public QFSMessageItemInfo(int i3) {
        this.mType = i3;
    }

    public boolean canShowAvatarLeftRedPoint() {
        if (!this.mCanShowHighLightUiStyle || !isRealNewMessage() || this.mType != -100) {
            return false;
        }
        return true;
    }

    public boolean canShowHeadCircle() {
        return this.mCanShowHeadCircle;
    }

    public boolean canShowNoAnimHighLight() {
        if (!this.mCanShowHighLightUiStyle || !isRealNewMessage() || this.mType != -100) {
            return false;
        }
        return true;
    }

    public FeedCloudMeta$StFeed getApertureExposeFeed() {
        return this.mApertureExposeFeed;
    }

    public Map<Integer, FeedCloudMeta$StNoticeCategory> getHeadNoticeCategoryMap() {
        return this.mHeadNoticeCategoryMap;
    }

    public int getLaunchTo() {
        return this.mLaunchTo;
    }

    public long getMessageTimestamp() {
        return this.mMessageTimestamp;
    }

    public String getMsgId() {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.mStNotice;
        if (feedCloudMeta$StNotice != null) {
            return feedCloudMeta$StNotice.feedId.get();
        }
        FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory = this.mStNoticeCategory;
        if (feedCloudMeta$StNoticeCategory != null) {
            return String.valueOf(feedCloudMeta$StNoticeCategory.f398455id.get());
        }
        return null;
    }

    public QQCircleFeedBase$StNoticeBusiData getNoticeBusiData() {
        return this.mNoticeBusiData;
    }

    public QCircleRecentDataInterface getRecentData() {
        return this.mRecentData;
    }

    public FeedCloudMeta$StNotice getStNotice() {
        return this.mStNotice;
    }

    public FeedCloudMeta$StNoticeCategory getStNoticeCategory() {
        return this.mStNoticeCategory;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public int getType() {
        return this.mType;
    }

    public QQCircleBase$StUserBusiData getUserBusiData() {
        return this.mUserBusiData;
    }

    public boolean hasConsumeAperture() {
        return this.mConsumeAperture;
    }

    public boolean hasShowApertureAnim() {
        return this.mHasShowApertureAnim;
    }

    public boolean isEnableThank() {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice = this.mStNotice;
        if (feedCloudMeta$StNotice != null && feedCloudMeta$StNotice.opMask.get().contains(7)) {
            return true;
        }
        return false;
    }

    public boolean isForceRightArrow() {
        return this.mForceRightArrow;
    }

    public boolean isHasShowBlueAnimation() {
        return this.mHasShowBlueAnimation;
    }

    public boolean isHideTime() {
        return this.mIsHideTime;
    }

    public boolean isListTopItem() {
        return this.mIsListTopItem;
    }

    public boolean isNeedTop() {
        return this.mNeedTop;
    }

    public boolean isNewMessage() {
        return this.mIsNewMessage;
    }

    public boolean isRealNewMessage() {
        if (!this.mIsNewMessage) {
            return false;
        }
        return !q.r().G(getMsgId());
    }

    public boolean isRightAreaVerticalCenter() {
        return this.mRightAreaVerticalCenter;
    }

    public void setApertureExposeFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mApertureExposeFeed = feedCloudMeta$StFeed;
    }

    public void setCanShowHeadCircle(boolean z16) {
        this.mCanShowHeadCircle = z16;
    }

    public void setCanShowHighLightUiStyle(boolean z16) {
        this.mCanShowHighLightUiStyle = z16;
    }

    public void setConsumed() {
        q.r().L(this);
    }

    public void setForceRightArrow(boolean z16) {
        this.mForceRightArrow = z16;
    }

    public void setHasConsumeAperture(boolean z16) {
        this.mConsumeAperture = z16;
    }

    public void setHasShowApertureAnim(boolean z16) {
        this.mHasShowApertureAnim = z16;
    }

    public void setHasShowBlueAnimation(boolean z16) {
        this.mHasShowBlueAnimation = z16;
    }

    public void setHeadNoticeCategoryMap(Map<Integer, FeedCloudMeta$StNoticeCategory> map) {
        this.mHeadNoticeCategoryMap = map;
    }

    public void setIsHideTime(boolean z16) {
        this.mIsHideTime = z16;
    }

    public void setIsListTopItem(boolean z16) {
        this.mIsListTopItem = z16;
    }

    public void setIsNewMessage(boolean z16) {
        this.mIsNewMessage = z16;
    }

    public void setLaunchTo(int i3) {
        this.mLaunchTo = i3;
    }

    public void setMessageTimestamp(long j3) {
        this.mMessageTimestamp = j3;
    }

    public void setNeedTop(boolean z16) {
        this.mNeedTop = z16;
    }

    public void setNoticeBusiData(QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        this.mNoticeBusiData = qQCircleFeedBase$StNoticeBusiData;
    }

    public void setRecentData(QCircleRecentDataInterface qCircleRecentDataInterface) {
        this.mRecentData = qCircleRecentDataInterface;
    }

    public void setRightAreaVerticalCenter(boolean z16) {
        this.mRightAreaVerticalCenter = z16;
    }

    public void setStNotice(FeedCloudMeta$StNotice feedCloudMeta$StNotice) {
        this.mStNotice = feedCloudMeta$StNotice;
    }

    public void setStNoticeCategory(FeedCloudMeta$StNoticeCategory feedCloudMeta$StNoticeCategory) {
        this.mStNoticeCategory = feedCloudMeta$StNoticeCategory;
    }

    public void setTraceId(String str) {
        this.mTraceId = str;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public void setUseSmallAvatar(boolean z16) {
        this.mUseSmallAvatar = z16;
    }

    public void setUserBusiData(QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData) {
        this.mUserBusiData = qQCircleBase$StUserBusiData;
    }

    public String toString() {
        return "QFSMessageItemInfo{mStNotice=" + this.mStNotice + ", mHeadNoticeCategoryMap=" + this.mHeadNoticeCategoryMap + ", mStNoticeCategory=" + this.mStNoticeCategory + ", mNoticeBusiData=" + this.mNoticeBusiData + ", mUserBusiData=" + this.mUserBusiData + ", mRecentData=" + this.mRecentData + ", mType=" + this.mType + ", mNeedTop=" + this.mNeedTop + ", mMessageTimestamp=" + this.mMessageTimestamp + ", mHasShowBlueAnimation=" + this.mHasShowBlueAnimation + ", mHasShowApertureAnim=" + this.mHasShowApertureAnim + ", mTraceId='" + this.mTraceId + "', mLaunchTo=" + this.mLaunchTo + ", mIsListTopItem=" + this.mIsListTopItem + '}';
    }

    public boolean useSmallAvatar() {
        return this.mUseSmallAvatar;
    }
}
