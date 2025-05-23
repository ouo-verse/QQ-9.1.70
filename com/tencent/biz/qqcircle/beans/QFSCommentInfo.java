package com.tencent.biz.qqcircle.beans;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import cooperation.qqcircle.report.QCircleReportBean;
import e30.b;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentInfo {
    public static int DETAIL_PAGE = 3;
    public static final int FROM_FEED_DESC_CLICK = 1;
    public static final int RELOCATION_TYPE_CENTER = 102;
    public static final int RELOCATION_TYPE_INPUT = 101;
    public static final int RELOCATION_TYPE_NONE = 100;
    public static final int RELOCATION_TYPE_OUTSIZE = 103;
    public static final int RELOCATION_TYPE_SCROLL_TOP = 104;
    public ActionBean mActionBean;
    public int mCmtPanelSource;
    public QCircleExtraTypeInfo mExtraTypeInfo;
    public FeedCloudMeta$StFeed mFeed;
    public b mFeedBlockData;
    public int mFrom;
    public QFSCommentInputWindowConfig mInputWinConfig;
    public boolean mIsShowEmotion;
    public boolean mIsShowMask;
    public boolean mNeedLocateComment;
    public int mPageType;
    public QCircleReportBean mReportBean;
    public FeedCloudMeta$StComment mTargetComment;
    public FeedCloudMeta$StReply mTargetReply;
    public int reqType;
    public int mRelocationScrollType = 100;
    public int mSendPreActionType = -1;
    public boolean mIsShowAiComment = true;
    public String mHintText = "";
    public String mCommentId = "";
    public String mHotCommentId = "";
    public int mHadAdBanner = 0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class ActionBean {
        public QCircleInitBean.QCircleActionBean mCommentInitBeanActionBean;
        public boolean mNeedDoCommentPraise;
        public boolean mNeedShowAt;
        public boolean mShowMaxHeight;
        public boolean mNeedShowTopFeedDesc = true;
        public boolean mIsNeedShowTopAnim = true;
        public int mShowCommentPanelTabIndex = 0;
    }
}
