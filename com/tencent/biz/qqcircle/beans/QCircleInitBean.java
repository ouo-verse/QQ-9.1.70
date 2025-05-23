package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPoiInfoV2;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleFeedBase$StBusiInfoCommentListData;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase$StPolyLike;
import qqcircle.QQCircleFeedBase$StSimulateData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleInitBean implements Serializable {
    public static final int MAIN_STATE_MESSAGE_PAGE = 2;
    public static final int MAIN_STATE_PERSONAL_PAGE = 1;
    private static final String TAG = "QCircleInitBean";
    private static final long serialVersionUID = 1521697368712552843L;
    private HotEventInfo hotEventInfo;
    private boolean isSingleFeed;
    protected String mAction;
    private QCircleActionBean mActionBean;
    private byte[] mBusiInfoDataByteArray;
    private transient FeedCloudCommon$StCommonExt mCacheCommentExt;
    private transient FeedCloudMeta$StFeed mCacheFeed;
    private transient FeedCloudMeta$StPoiInfoV2 mCachePoiInfo;
    private transient QQCircleFeedBase$StPolyLike mCachePolyLike;
    private transient FeedCloudMeta$StTagInfo mCacheTagInfo;
    private transient FeedCloudMeta$StUser mCacheUser;
    private String mCategory;
    private QFSCommentExtendInfo mCommentExtentInfo;
    private byte[] mCommonExtInfo;
    public int mDataPosInList;
    private boolean mDisableFoot;
    private int mDrawerId;
    private boolean mEnableUsePlayerSize;
    private long mEnterTime;
    private QCircleExtraTypeInfo mExtraTypeInfo;
    private byte[] mFeedByteArray;
    private String mFeedId;
    private byte[] mFeedListBusiReqByteArray;
    private int mFromPage;
    private QCircleReportBean mFromReportBean;
    public String mInviteUin;
    private boolean mIsMiddlePage;
    private boolean mIsMiniPage;
    private boolean mIsStartNewIntent;
    private String mLaunchFrom;
    private String mLaunchId;
    private int mLaunchTo;
    private String mLayerBizAssemblerType;
    private boolean mNeedHideBottomCommentBtn;
    private byte[] mPoiInfoByteArray;
    private byte[] mPolyLikeByteArray;
    private int mPolymerizationType;
    private String mProgressCallbackId;
    private int mPymkJumpType;
    private String mQQVideoBusinessFeedID;
    protected HashMap<String, String> mSchemeAttrs;
    protected HashMap<String, byte[]> mSchemeBytes;
    private byte[] mSimulateDataByteArray;
    private List<String> mSourceIds;
    private byte[] mTagInfoByteArray;
    private byte[] mUserByteArray;
    public long mVideoCurrentPosition;
    private boolean enableSplash = false;
    private boolean enableMemoryCache = true;
    private String mPymkTranferData = null;
    private boolean mOpenPymk = false;
    private boolean mAVStateController = true;
    private boolean mForceFromNetwork = false;
    private boolean mIsAutoShowPanel = false;
    private boolean mEnableReleaseAudioFocus = true;
    private final Map<String, Serializable> mBusinessMap = new ConcurrentHashMap();
    private boolean mEnableUpDragExit = false;
    private int mClientFromType = 0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class QCircleActionBean implements Serializable {
        private static final long serialVersionUID = 3536612350755570794L;
        public QQCircleFeedBase$StBusiInfoCommentListData mBusiInfoCommentListDataFromCommentInfo;
        public List<String> mCommentPanelLikeTabAnchorUinList;
        public List<String> mCommentPanelPushTabAnchorUinList;
        public boolean mIsShowDetailSharePanel;
        public String mItemTopAnimationCommentId;
        public String mItemTopAnimationReplyId;
        public int mLightInteractListRequestType;
        public boolean mNeedCancelLikeToast;
        public boolean mOnlyShowCommentKeyboard = false;
        public boolean mShowCommentPanel;
        public int mShowCommentPanelTabIndex;
        public boolean mShowInputKeyboard;
        public boolean mShowLightInteractListPanel;
        public boolean mShowSharePanel;
        public boolean mShowSharePanelTopAction;
        public boolean mShowTopSharePanel;
    }

    public boolean enableReleaseAudioFocus() {
        return this.mEnableReleaseAudioFocus;
    }

    public boolean enableUsePlayerSize() {
        return this.mEnableUsePlayerSize;
    }

    public boolean getAVStateController() {
        return this.mAVStateController;
    }

    public String getAction() {
        return this.mAction;
    }

    public QCircleActionBean getActionBean() {
        return this.mActionBean;
    }

    public byte[] getBusiInfoData() {
        return this.mBusiInfoDataByteArray;
    }

    public Serializable getBusinessData(@NonNull String str) {
        return this.mBusinessMap.get(str);
    }

    public int getClientFromType() {
        return this.mClientFromType;
    }

    public QFSCommentExtendInfo getCommentExtentInfo() {
        return this.mCommentExtentInfo;
    }

    public FeedCloudCommon$StCommonExt getCommonExtInfo() {
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = this.mCacheCommentExt;
        if (feedCloudCommon$StCommonExt != null && feedCloudCommon$StCommonExt.has()) {
            return this.mCacheCommentExt;
        }
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt2 = new FeedCloudCommon$StCommonExt();
        try {
            byte[] bArr = this.mCommonExtInfo;
            if (bArr != null && bArr.length > 0) {
                feedCloudCommon$StCommonExt2.mergeFrom(bArr);
                this.mCacheCommentExt = feedCloudCommon$StCommonExt2;
            }
        } catch (Exception e16) {
            QLog.e("getCommonExtInfo error", 1, e16, new Object[0]);
        }
        return feedCloudCommon$StCommonExt2;
    }

    public byte[] getCommonExtInfoByteArray() {
        return this.mCommonExtInfo;
    }

    public int getDataPosInList() {
        return this.mDataPosInList;
    }

    public int getDrawerId() {
        return this.mDrawerId;
    }

    public long getEnterTime() {
        return this.mEnterTime;
    }

    public QCircleExtraTypeInfo getExtraTypeInfo() {
        if (this.mExtraTypeInfo == null) {
            this.mExtraTypeInfo = new QCircleExtraTypeInfo();
        }
        return this.mExtraTypeInfo;
    }

    public FeedCloudMeta$StFeed getFeed() {
        FeedCloudMeta$StFeed a16 = u40.a.a();
        if (a16 != null && TextUtils.equals(a16.f398449id.get(), this.mFeedId)) {
            QLog.e(TAG, 4, "[getFeed] use cache feed");
            return a16;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.mCacheFeed;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.has()) {
            return this.mCacheFeed;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = new FeedCloudMeta$StFeed();
        try {
            feedCloudMeta$StFeed2.mergeFrom(this.mFeedByteArray);
            this.mCacheFeed = feedCloudMeta$StFeed2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getFeed exception: ", e16.toString());
            this.mCacheFeed = null;
        }
        return feedCloudMeta$StFeed2;
    }

    public byte[] getFeedByteArray() {
        return this.mFeedByteArray;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public QQCircleFeedBase$StFeedListBusiReqData getFeedListBusiReq() {
        QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData = new QQCircleFeedBase$StFeedListBusiReqData();
        byte[] bArr = this.mFeedListBusiReqByteArray;
        if (bArr != null) {
            try {
                qQCircleFeedBase$StFeedListBusiReqData.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(TAG, 1, "getFeedListBusiReq except:" + e16.toString());
            }
        }
        return qQCircleFeedBase$StFeedListBusiReqData;
    }

    public byte[] getFeedListBusiReqByteArray() {
        return this.mFeedListBusiReqByteArray;
    }

    public int getFromPage() {
        return this.mFromPage;
    }

    public QCircleReportBean getFromReportBean() {
        return this.mFromReportBean;
    }

    public HotEventInfo getHotEventInfo() {
        return this.hotEventInfo;
    }

    public String getLaunchFrom() {
        return this.mLaunchFrom;
    }

    public String getLaunchId() {
        return this.mLaunchId;
    }

    public int getLaunchTo() {
        return this.mLaunchTo;
    }

    public String getLayerBizAssemblerType() {
        return this.mLayerBizAssemblerType;
    }

    public boolean getOpenPymk() {
        return this.mOpenPymk;
    }

    public FeedCloudMeta$StPoiInfoV2 getPoiInfo() {
        FeedCloudMeta$StPoiInfoV2 feedCloudMeta$StPoiInfoV2 = this.mCachePoiInfo;
        if (feedCloudMeta$StPoiInfoV2 != null && feedCloudMeta$StPoiInfoV2.has()) {
            return this.mCachePoiInfo;
        }
        FeedCloudMeta$StPoiInfoV2 feedCloudMeta$StPoiInfoV22 = new FeedCloudMeta$StPoiInfoV2();
        try {
            byte[] bArr = this.mPoiInfoByteArray;
            if (bArr != null) {
                feedCloudMeta$StPoiInfoV22.mergeFrom(bArr);
                this.mCachePoiInfo = feedCloudMeta$StPoiInfoV22;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getPoiInfo exception:", e16.toString());
            this.mCachePoiInfo = null;
        }
        return feedCloudMeta$StPoiInfoV22;
    }

    public byte[] getPoiInfoByteArray() {
        return this.mPoiInfoByteArray;
    }

    public QQCircleFeedBase$StPolyLike getPolyLike() {
        QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike = this.mCachePolyLike;
        if (qQCircleFeedBase$StPolyLike != null && qQCircleFeedBase$StPolyLike.has()) {
            return this.mCachePolyLike;
        }
        QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike2 = new QQCircleFeedBase$StPolyLike();
        try {
            qQCircleFeedBase$StPolyLike2.mergeFrom(this.mPolyLikeByteArray);
            this.mCachePolyLike = qQCircleFeedBase$StPolyLike2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getPolyLike exception:", e16.toString());
            this.mCachePolyLike = null;
        }
        return qQCircleFeedBase$StPolyLike2;
    }

    public int getPolymerizationType() {
        return this.mPolymerizationType;
    }

    public String getProgressCallbackId() {
        return this.mProgressCallbackId;
    }

    public int getPymkJumpType() {
        return this.mPymkJumpType;
    }

    public String getPymkTranferData() {
        return this.mPymkTranferData;
    }

    public String getQQVideoBusinessFeedID() {
        return this.mQQVideoBusinessFeedID;
    }

    public HashMap<String, String> getSchemeAttrs() {
        return this.mSchemeAttrs;
    }

    public HashMap<String, byte[]> getSchemeBytes() {
        return this.mSchemeBytes;
    }

    public QQCircleFeedBase$StSimulateData getSimulateData() {
        QQCircleFeedBase$StSimulateData qQCircleFeedBase$StSimulateData = new QQCircleFeedBase$StSimulateData();
        try {
            qQCircleFeedBase$StSimulateData.mergeFrom(this.mSimulateDataByteArray);
        } catch (Exception e16) {
            QLog.e("getSimulateData error", 1, e16, new Object[0]);
        }
        return qQCircleFeedBase$StSimulateData;
    }

    public byte[] getSimulateDataByteArray() {
        return this.mSimulateDataByteArray;
    }

    public List<String> getSourceIds() {
        return this.mSourceIds;
    }

    public FeedCloudMeta$StTagInfo getTagInfo() {
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = this.mCacheTagInfo;
        if (feedCloudMeta$StTagInfo != null && feedCloudMeta$StTagInfo.has()) {
            return this.mCacheTagInfo;
        }
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo2 = new FeedCloudMeta$StTagInfo();
        try {
            feedCloudMeta$StTagInfo2.mergeFrom(this.mTagInfoByteArray);
            this.mCacheTagInfo = feedCloudMeta$StTagInfo2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getTagInfo exception:", e16.toString());
            this.mCacheTagInfo = null;
        }
        return feedCloudMeta$StTagInfo2;
    }

    public byte[] getTagInfoByteArray() {
        return this.mTagInfoByteArray;
    }

    public String getUin() {
        FeedCloudMeta$StUser user = getUser();
        if (user != null) {
            return user.f398463id.get();
        }
        return null;
    }

    public FeedCloudMeta$StUser getUser() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.mCacheUser;
        if (feedCloudMeta$StUser != null && feedCloudMeta$StUser.has()) {
            return this.mCacheUser;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser2 = new FeedCloudMeta$StUser();
        try {
            feedCloudMeta$StUser2.mergeFrom(this.mUserByteArray);
            this.mCacheUser = feedCloudMeta$StUser2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getUser exception", e16.toString());
            this.mCacheUser = null;
        }
        return feedCloudMeta$StUser2;
    }

    public long getVideoCurrentPosition() {
        return this.mVideoCurrentPosition;
    }

    public String getmCategory() {
        return this.mCategory;
    }

    public boolean isAutoShowPanel() {
        return this.mIsAutoShowPanel;
    }

    public boolean isDisableFoot() {
        return this.mDisableFoot;
    }

    public boolean isEnableMemoryCache() {
        return this.enableMemoryCache;
    }

    public boolean isEnableSplash() {
        return this.enableSplash;
    }

    public boolean isEnableUpDragExit() {
        return this.mEnableUpDragExit;
    }

    public boolean isForceFromNetwork() {
        return this.mForceFromNetwork;
    }

    public boolean isMiddlePage() {
        return this.mIsMiddlePage;
    }

    public boolean isMiniPage() {
        return this.mIsMiniPage;
    }

    public boolean isNeedHideBottomCommentBtn() {
        return this.mNeedHideBottomCommentBtn;
    }

    public boolean isSingleFeed() {
        return this.isSingleFeed;
    }

    public boolean isStartNewIntent() {
        return this.mIsStartNewIntent;
    }

    public void putBusinessData(@NonNull String str, @NonNull Serializable serializable) {
        this.mBusinessMap.put(str, serializable);
    }

    public void setAVStateController(boolean z16) {
        this.mAVStateController = z16;
    }

    public void setAction(String str) {
        this.mAction = str;
    }

    public void setActionBean(QCircleActionBean qCircleActionBean) {
        this.mActionBean = qCircleActionBean;
    }

    public void setAutoShowPanel(boolean z16) {
        this.mIsAutoShowPanel = z16;
    }

    public void setBusiInfoData(byte[] bArr) {
        if (bArr != null) {
            this.mBusiInfoDataByteArray = bArr;
        }
    }

    public void setClientFromType(int i3) {
        this.mClientFromType = i3;
    }

    public void setCommentExtentInfo(QFSCommentExtendInfo qFSCommentExtendInfo) {
        this.mCommentExtentInfo = qFSCommentExtendInfo;
    }

    public void setCommonExtInfo(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        if (feedCloudCommon$StCommonExt != null) {
            this.mCommonExtInfo = feedCloudCommon$StCommonExt.toByteArray();
        }
    }

    public void setDataPosInList(int i3) {
        this.mDataPosInList = i3;
    }

    public void setDisableFoot(boolean z16) {
        this.mDisableFoot = z16;
    }

    public void setDrawerId(int i3) {
        this.mDrawerId = i3;
    }

    public void setEnableMemoryCache(boolean z16) {
        this.enableMemoryCache = z16;
    }

    public void setEnableReleaseAudioFocus(boolean z16) {
        this.mEnableReleaseAudioFocus = z16;
    }

    public void setEnableSplash(boolean z16) {
        this.enableSplash = z16;
    }

    public void setEnableUpDragExit(boolean z16) {
        QLog.d(TAG, 1, "setEnableUpDragExit:" + z16);
        this.mEnableUpDragExit = z16;
    }

    public void setEnableUsePlayerSize(boolean z16) {
        this.mEnableUsePlayerSize = z16;
    }

    public void setEnterTime(long j3) {
        this.mEnterTime = j3;
    }

    public void setExtraTypeInfo(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.mExtraTypeInfo = qCircleExtraTypeInfo;
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null) {
            this.mFeedByteArray = feedCloudMeta$StFeed.toByteArray();
            this.mCacheFeed = null;
            this.mFeedId = feedCloudMeta$StFeed.f398449id.get();
        }
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public void setFeedListBusiReqData(QQCircleFeedBase$StFeedListBusiReqData qQCircleFeedBase$StFeedListBusiReqData) {
        if (qQCircleFeedBase$StFeedListBusiReqData != null) {
            this.mFeedListBusiReqByteArray = qQCircleFeedBase$StFeedListBusiReqData.toByteArray();
        }
    }

    public void setForceFromNetwork(boolean z16) {
        this.mForceFromNetwork = z16;
    }

    public void setFromPage(int i3) {
        this.mFromPage = i3;
    }

    public void setFromReportBean(QCircleReportBean qCircleReportBean) {
        if (qCircleReportBean != null) {
            this.mFromReportBean = qCircleReportBean.m466clone();
        }
    }

    public void setHotEventInfo(HotEventInfo hotEventInfo) {
        this.hotEventInfo = hotEventInfo;
    }

    public void setIsMiddlePage(boolean z16) {
        this.mIsMiddlePage = z16;
    }

    public void setIsMiniPage(boolean z16) {
        this.mIsMiniPage = z16;
    }

    public void setLaunchFrom(String str) {
        this.mLaunchFrom = str;
    }

    public void setLaunchId(String str) {
        this.mLaunchId = str;
    }

    public void setLaunchTo(int i3) {
        this.mLaunchTo = i3;
    }

    public void setLayerBizAssemblerType(String str) {
        this.mLayerBizAssemblerType = str;
    }

    public void setNeedHideBottomCommentBtn(boolean z16) {
        this.mNeedHideBottomCommentBtn = z16;
    }

    public void setOpenPymk(boolean z16) {
        this.mOpenPymk = z16;
    }

    public void setPoiInfo(FeedCloudMeta$StPoiInfoV2 feedCloudMeta$StPoiInfoV2) {
        if (feedCloudMeta$StPoiInfoV2 != null) {
            this.mPoiInfoByteArray = feedCloudMeta$StPoiInfoV2.toByteArray();
            this.mCachePoiInfo = null;
        }
    }

    public void setPolyLike(QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike) {
        if (qQCircleFeedBase$StPolyLike != null) {
            this.mPolyLikeByteArray = qQCircleFeedBase$StPolyLike.toByteArray();
            this.mCachePolyLike = null;
        }
    }

    public void setPolymerizationType(int i3) {
        this.mPolymerizationType = i3;
    }

    public void setProgressCallbackId(String str) {
        this.mProgressCallbackId = str;
    }

    public void setPymkJumpType(int i3) {
        this.mPymkJumpType = i3;
    }

    public void setPymkTranferData(String str) {
        this.mPymkTranferData = str;
    }

    public void setQQVideoBusinessFeedID(String str) {
        this.mQQVideoBusinessFeedID = str;
    }

    public void setSchemeAttrs(HashMap<String, String> hashMap) {
        this.mSchemeAttrs = hashMap;
    }

    public void setSchemeBytes(HashMap<String, byte[]> hashMap) {
        this.mSchemeBytes = hashMap;
    }

    public void setSimulateData(QQCircleFeedBase$StSimulateData qQCircleFeedBase$StSimulateData) {
        if (qQCircleFeedBase$StSimulateData != null) {
            this.mSimulateDataByteArray = qQCircleFeedBase$StSimulateData.toByteArray();
        }
    }

    public void setSingleFeed(boolean z16) {
        this.isSingleFeed = z16;
    }

    public void setSourceIds(List<String> list) {
        this.mSourceIds = list;
    }

    public void setSourceType(int i3) {
        if (this.mExtraTypeInfo == null) {
            this.mExtraTypeInfo = new QCircleExtraTypeInfo();
        }
        this.mExtraTypeInfo.sourceType = i3;
    }

    public void setStartNewIntent(boolean z16) {
        this.mIsStartNewIntent = z16;
    }

    public void setTagInfo(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        if (feedCloudMeta$StTagInfo != null) {
            this.mTagInfoByteArray = feedCloudMeta$StTagInfo.toByteArray();
            this.mCacheTagInfo = null;
        }
    }

    public void setUin(String str) {
        if (str != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(str);
            this.mUserByteArray = feedCloudMeta$StUser.toByteArray();
            this.mCacheUser = null;
        }
    }

    public void setUser(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser != null) {
            this.mUserByteArray = feedCloudMeta$StUser.toByteArray();
            this.mCacheUser = null;
        }
    }

    public void setVideoCurrentPosition(long j3) {
        this.mVideoCurrentPosition = j3;
    }

    public void setmCategory(String str) {
        this.mCategory = str;
    }
}
