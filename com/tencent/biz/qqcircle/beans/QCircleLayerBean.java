package com.tencent.biz.qqcircle.beans;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StVideo;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleLayerBean extends QCircleInitBean {
    private static final String TAG = "QCircleLayerBean";
    private int aggregationType;
    private String feedTransRecomTraceId;
    private String globalViewModelKey;
    private boolean isUseLoadingPic;
    private transient FeedCloudMeta$StImage mCacheFeedCover;
    private transient FeedCloudMeta$StVideo mCacheFeedVideo;
    private byte[] mFeedCoverByteArray;
    private byte[] mFeedVideoByteArray;
    private boolean mIsGetFeedList;
    private int mPageCode;
    private String mPrePersonalPageUin;
    private QFSTagPolymerizationBean mQfsTagPolymerizationBean;
    private boolean mReUsePlayerWhenExit;
    private QCircleTagChallengeInfo mTagChallengeInfo;
    private QCircleInitBean mTransInitBean;
    private QFSTransitionAnimBean mTransitionAnimBean;
    private int picPos;
    private boolean isSupportDragExit = true;
    private boolean mNeedReleaseOtherPlayer = true;
    private int mPreRenderType = 10000;
    private boolean mIsCollection = false;
    private String unifiedId = "";
    private String unifiedType = "";
    private String songMid = "";
    private String jumpSchema = "";
    private boolean isShareFromArk = false;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class QFSTagPolymerizationBean implements Serializable {
        private static final long serialVersionUID = -2241403078680738610L;
        public String feedCount;
        public String feedTagPageFromType = "0";
        public String operationActivityId;
        public String polymerizationScheme;
        public String tagViews;
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class SourceRect implements Serializable {
        int bottom;
        int left;
        int right;
        int top;

        public SourceRect(int i3, int i16, int i17, int i18) {
            this.left = i3;
            this.top = i16;
            this.right = i17;
            this.bottom = i18;
        }

        public int getBottom() {
            return this.bottom;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        public int getTop() {
            return this.top;
        }

        public void setBottom(int i3) {
            this.bottom = i3;
        }

        public void setLeft(int i3) {
            this.left = i3;
        }

        public void setRight(int i3) {
            this.right = i3;
        }

        public void setTop(int i3) {
            this.top = i3;
        }

        public String toString() {
            return "SourceRect{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }
    }

    public boolean enableReUseWhenExit() {
        return this.mReUsePlayerWhenExit;
    }

    public int getAggregationType() {
        return this.aggregationType;
    }

    public FeedCloudMeta$StImage getFeedCover() {
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.mCacheFeedCover;
        if (feedCloudMeta$StImage != null && feedCloudMeta$StImage.has()) {
            return this.mCacheFeedCover;
        }
        FeedCloudMeta$StImage feedCloudMeta$StImage2 = new FeedCloudMeta$StImage();
        try {
            feedCloudMeta$StImage2.mergeFrom(this.mFeedCoverByteArray);
            this.mCacheFeedCover = feedCloudMeta$StImage2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getFeedCover exception: ", e16.toString());
            this.mCacheFeedCover = null;
        }
        return feedCloudMeta$StImage2;
    }

    public FeedCloudMeta$StVideo getFeedVideo() {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = this.mCacheFeedVideo;
        if (feedCloudMeta$StVideo != null && feedCloudMeta$StVideo.has()) {
            return this.mCacheFeedVideo;
        }
        FeedCloudMeta$StVideo feedCloudMeta$StVideo2 = new FeedCloudMeta$StVideo();
        try {
            feedCloudMeta$StVideo2.mergeFrom(this.mFeedVideoByteArray);
            this.mCacheFeedVideo = feedCloudMeta$StVideo2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getFeedVideo exception: ", e16.toString());
            this.mCacheFeedVideo = null;
        }
        return feedCloudMeta$StVideo2;
    }

    public String getGlobalViewModelKey() {
        return this.globalViewModelKey;
    }

    public String getJumpSchema() {
        return this.jumpSchema;
    }

    public int getPageCode() {
        return this.mPageCode;
    }

    public int getPicPos() {
        return this.picPos;
    }

    public String getPrePersonalPageUin() {
        return this.mPrePersonalPageUin;
    }

    @Nullable
    public QFSTagPolymerizationBean getQfsTagPolymerizationBean() {
        return this.mQfsTagPolymerizationBean;
    }

    public int getRenderType() {
        return this.mPreRenderType;
    }

    public String getSongMid() {
        return this.songMid;
    }

    public QCircleTagChallengeInfo getTagChallengeInfo() {
        return this.mTagChallengeInfo;
    }

    public QCircleInitBean getTransInitBean() {
        return this.mTransInitBean;
    }

    public QFSTransitionAnimBean getTransitionAnimBean() {
        return this.mTransitionAnimBean;
    }

    public String getUnifiedId() {
        return this.unifiedId;
    }

    public String getUnifiedType() {
        return this.unifiedType;
    }

    public boolean isGetFeedList() {
        return this.mIsGetFeedList;
    }

    public boolean isShareFromArk() {
        return this.isShareFromArk;
    }

    public boolean isSupportDragExit() {
        return this.isSupportDragExit;
    }

    public boolean isUseLoadingPic() {
        return this.isUseLoadingPic;
    }

    public boolean ismIsCollection() {
        return this.mIsCollection;
    }

    public boolean needReleaseOtherPlayer() {
        return this.mNeedReleaseOtherPlayer;
    }

    public QCircleLayerBean setAggregationType(int i3) {
        this.aggregationType = i3;
        return this;
    }

    public QCircleLayerBean setCurrentIsCollection(boolean z16) {
        this.mIsCollection = z16;
        return this;
    }

    public void setFeedCover(FeedCloudMeta$StImage feedCloudMeta$StImage) {
        if (feedCloudMeta$StImage != null) {
            this.mFeedCoverByteArray = feedCloudMeta$StImage.toByteArray();
            this.mCacheFeedCover = null;
        }
    }

    public void setFeedVideo(FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
        if (feedCloudMeta$StVideo != null) {
            this.mFeedVideoByteArray = feedCloudMeta$StVideo.toByteArray();
            this.mCacheFeedVideo = null;
        }
    }

    public void setGetFeedList(boolean z16) {
        this.mIsGetFeedList = z16;
    }

    public void setGlobalViewModelKey(String str) {
        this.globalViewModelKey = str;
    }

    public QCircleLayerBean setIsShareFromArk(Boolean bool) {
        this.isShareFromArk = bool.booleanValue();
        return this;
    }

    public QCircleLayerBean setJumpSchema(String str) {
        this.jumpSchema = str;
        return this;
    }

    public QCircleLayerBean setNeedReleaseOtherSceneIdPlayer(boolean z16) {
        this.mNeedReleaseOtherPlayer = z16;
        return this;
    }

    public void setPageCode(int i3) {
        this.mPageCode = i3;
    }

    public void setPicPos(int i3) {
        this.picPos = i3;
    }

    public void setPrePersonalPageUin(String str) {
        this.mPrePersonalPageUin = str;
    }

    public QCircleLayerBean setPreRenderType(int i3) {
        this.mPreRenderType = i3;
        return this;
    }

    public void setQfsTagPolymerizationBean(QFSTagPolymerizationBean qFSTagPolymerizationBean) {
        this.mQfsTagPolymerizationBean = qFSTagPolymerizationBean;
    }

    public void setReUsePlayerWhenExit(boolean z16) {
        this.mReUsePlayerWhenExit = z16;
    }

    public QCircleLayerBean setSongMid(String str) {
        this.songMid = str;
        return this;
    }

    public void setSupportDragExit(boolean z16) {
        this.isSupportDragExit = z16;
    }

    public void setTagChallengeInfo(QCircleTagChallengeInfo qCircleTagChallengeInfo) {
        this.mTagChallengeInfo = qCircleTagChallengeInfo;
    }

    public void setTransInitBean(QCircleInitBean qCircleInitBean) {
        this.mTransInitBean = qCircleInitBean;
    }

    public void setTransitionAnimBean(QFSTransitionAnimBean qFSTransitionAnimBean) {
        this.mTransitionAnimBean = qFSTransitionAnimBean;
    }

    public QCircleLayerBean setUnifiedId(String str) {
        this.unifiedId = str;
        return this;
    }

    public QCircleLayerBean setUnifiedType(String str) {
        this.unifiedType = str;
        return this;
    }

    public void setUseLoadingPic(boolean z16) {
        this.isUseLoadingPic = z16;
    }
}
