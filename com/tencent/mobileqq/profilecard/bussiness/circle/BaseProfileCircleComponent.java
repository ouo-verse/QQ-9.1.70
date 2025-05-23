package com.tencent.mobileqq.profilecard.bussiness.circle;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolderManager;
import com.tencent.mobileqq.profilecard.bussiness.circle.view.ProfileCircleInfoView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QFSTianShuConstant;
import cooperation.qqcircle.report.datong.QCircleDTLoginReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import e30.d;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import qqcircle.QQCircleFeedBase$StPageRedPointInfo;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$MapEntry;

/* loaded from: classes16.dex */
public abstract class BaseProfileCircleComponent extends AbsQQProfileContentComponent implements ProfileQCircleItemViewHolderManager.IProfileQCircleItemClickListener, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_ = null;
    private static final String REPORT_EXT1_VALUE_FAN_NONE_FUE_YES = "2";
    private static final String REPORT_EXT1_VALUE_FAN_YES_FUE_NONE = "3";
    private static final String REPORT_EXT1_VALUE_FAN_YES_FUE_YES = "4";
    private static final String REPORT_EXT1_VALUE_NONE = "1";
    private static final String TAG = "BaseProfileCircleComponent";
    protected int circleInfoVisibleState;
    protected CircleFeedsDiffUtil diffUtil;
    protected boolean isBlacklist;
    private boolean isInitDtReport;
    String mFansText;
    int mFansValueStyle;
    String mFuelText;
    int mFuelValueStyle;
    protected boolean mHasStartPlayVideo;
    final AtomicBoolean mIsDoingRequest;
    boolean mIsRefreshFeed;
    protected final ProfileQCircleItemViewHolderManager mItemViewHolderManager;
    ProfileCircleInfoView mProfileCircleInfoView;
    volatile List<FeedCloudMeta$StFeed> mQQCircleFeeds;
    protected volatile boolean mQQCircleShouldReport;
    String mQcircleUpdateinfo;
    float mScreenWidth;
    volatile ProfileCircleTianShuBean mTianShuBean;
    WeakReferenceHandler mUiHandler;
    protected int mVideoPlayCtl;
    protected QCircleProfileViewModel mViewModel;
    protected String mViewModelKey;
    private View photoView;
    protected int photoVisibleState;
    private View redDotView;
    protected int redDotVisibleState;
    private View tipsView;
    protected int tipsVisibleState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class ProfileCircleCacheBean {
        static IPatchRedirector $redirector_;
        private final String mFeedAttachInfo;
        private final long mRequestTimeInterval;
        private final List<FeedCloudMeta$StFeed> mStFeedList;
        private final long mStartTime;
        private final ProfileCircleTianShuBean mTianShuBean;
        private final QCircleProfileTitleInfoBean mTitleInfoBean;
        private int mVideoPlayCtl;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProfileCircleCacheBean(List<FeedCloudMeta$StFeed> list, ProfileCircleTianShuBean profileCircleTianShuBean, QCircleProfileTitleInfoBean qCircleProfileTitleInfoBean, String str, long j3, long j16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, list, profileCircleTianShuBean, qCircleProfileTitleInfoBean, str, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
                return;
            }
            this.mStFeedList = list;
            this.mTianShuBean = profileCircleTianShuBean;
            this.mTitleInfoBean = qCircleProfileTitleInfoBean;
            this.mFeedAttachInfo = str;
            this.mRequestTimeInterval = j3;
            this.mStartTime = j16;
            this.mVideoPlayCtl = i3;
        }

        public boolean canUseCacheData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            if (!hashCache() || System.currentTimeMillis() - getStartTime() > getRequestTimeInterval() * 1000) {
                return false;
            }
            return true;
        }

        public String getFeedAttachInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.mFeedAttachInfo;
        }

        public long getRequestTimeInterval() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
            }
            return this.mRequestTimeInterval;
        }

        public List<FeedCloudMeta$StFeed> getStFeedList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mStFeedList;
        }

        public long getStartTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
            }
            return this.mStartTime;
        }

        public ProfileCircleTianShuBean getTianShuBean() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ProfileCircleTianShuBean) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mTianShuBean;
        }

        public QCircleProfileTitleInfoBean getTitleInfoBean() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (QCircleProfileTitleInfoBean) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.mTitleInfoBean;
        }

        public int getVideoPlayCtl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.mVideoPlayCtl;
        }

        public boolean hashCache() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            List<FeedCloudMeta$StFeed> list = this.mStFeedList;
            if (list != null && list.size() > 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class ProfileCircleTianShuBean {
        static IPatchRedirector $redirector_ = null;
        private static final int INVALID_TASK_TYPE = -1;
        private static final String SCHEMA = "schema";
        private static final String TASK_TYPE = "task_type";
        private static final String TEXT = "text";
        private QQCircleTianShu$AdItem adItem;
        private String schema;
        private int taskType;
        private String text;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProfileCircleTianShuBean(QQCircleTianShu$AdItem qQCircleTianShu$AdItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQCircleTianShu$AdItem);
            } else {
                this.taskType = -1;
                initData(qQCircleTianShu$AdItem);
            }
        }

        private void initData(QQCircleTianShu$AdItem qQCircleTianShu$AdItem) {
            this.adItem = qQCircleTianShu$AdItem;
            List<QQCircleTianShu$MapEntry> list = qQCircleTianShu$AdItem.argList.get();
            if (list != null && !list.isEmpty()) {
                for (QQCircleTianShu$MapEntry qQCircleTianShu$MapEntry : list) {
                    String str = qQCircleTianShu$MapEntry.key.get();
                    String str2 = qQCircleTianShu$MapEntry.value.get();
                    if (TASK_TYPE.equals(str)) {
                        try {
                            this.taskType = Integer.parseInt(str2);
                        } catch (NumberFormatException e16) {
                            QLog.w(BaseProfileCircleComponent.TAG, 1, "task type error ", e16);
                            return;
                        }
                    } else if ("text".equals(str)) {
                        this.text = str2;
                    } else if ("schema".equals(str)) {
                        this.schema = str2;
                    }
                }
            }
        }

        private boolean isActiveUserContrast() {
            if (this.taskType == 3) {
                return true;
            }
            return false;
        }

        private boolean isActiveUserExperiment() {
            int i3 = this.taskType;
            if (i3 != 4 && i3 != 5) {
                return false;
            }
            return true;
        }

        private boolean isLowActiveUserContrast() {
            if (this.taskType == 6) {
                return true;
            }
            return false;
        }

        private boolean isLowActiveUserExperiment() {
            int i3 = this.taskType;
            if (i3 != 7 && i3 != 8) {
                return false;
            }
            return true;
        }

        public String getAdId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            QQCircleTianShu$AdItem qQCircleTianShu$AdItem = this.adItem;
            if (qQCircleTianShu$AdItem == null) {
                return "";
            }
            return String.valueOf(qQCircleTianShu$AdItem.iAdId.get());
        }

        public String getSchema() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.schema;
        }

        public int getTaskType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.taskType;
        }

        public String getText() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.text;
        }

        public String getTraceInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            QQCircleTianShu$AdItem qQCircleTianShu$AdItem = this.adItem;
            if (qQCircleTianShu$AdItem == null) {
                return "";
            }
            return qQCircleTianShu$AdItem.traceinfo.get();
        }

        public boolean isInvalidType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (this.taskType != -1 && (isWithoutFeedContrast() || isWithoutFeedExperiment() || isWithFeedContrast() || isWithFeedExperiment())) {
                return false;
            }
            return true;
        }

        public boolean isWithFeedContrast() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            if (!isActiveUserContrast() && !isLowActiveUserContrast()) {
                return false;
            }
            return true;
        }

        public boolean isWithFeedExperiment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (!isActiveUserExperiment() && !isLowActiveUserExperiment()) {
                return false;
            }
            return true;
        }

        public boolean isWithoutFeedContrast() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            if (this.taskType == 1) {
                return true;
            }
            return false;
        }

        public boolean isWithoutFeedExperiment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            if (this.taskType == 2) {
                return true;
            }
            return false;
        }

        public void setSchema(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            } else {
                this.schema = str;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "ProfileCircleTianShuBean{taskType=" + this.taskType + ", text='" + this.text + "', schema='" + this.schema + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class QCircleProfileTitleInfoBean {
        static IPatchRedirector $redirector_;
        public long fansCount;
        public int fansValueStyle;
        public long fuelCount;
        public int fuelValueStyle;
        public QQCircleFeedBase$StPageRedPointInfo redPointInfo;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QCircleProfileTitleInfoBean() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "QCircleProfileTitleInfoBean{fansCount=" + this.fansCount + ", fansValueStyle=" + this.fansValueStyle + ", fuelCount=" + this.fuelCount + ", fuelValueStyle=" + this.fuelValueStyle + "}";
        }
    }

    public BaseProfileCircleComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.mIsDoingRequest = new AtomicBoolean(false);
        this.mQQCircleShouldReport = true;
        this.mFansValueStyle = 0;
        this.mFuelValueStyle = 0;
        this.mFansText = "";
        this.mFuelText = "";
        this.mIsRefreshFeed = false;
        this.isInitDtReport = false;
        this.photoVisibleState = 0;
        this.redDotVisibleState = 8;
        this.tipsVisibleState = 8;
        this.circleInfoVisibleState = 8;
        this.isBlacklist = false;
        this.mHasStartPlayVideo = false;
        this.mItemViewHolderManager = new ProfileQCircleItemViewHolderManager(this);
    }

    private void dtReportGuideText(View view, ProfileCircleTianShuBean profileCircleTianShuBean) {
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_tianshu_task_id", profileCircleTianShuBean.getAdId());
        if (profileCircleTianShuBean.isWithoutFeedExperiment()) {
            ProfileCardDtReportUtil.initElementWithExposureClickAndParams(view, ProfileCardDtReportUtil.DT_REPORT_EM_XSJ_ENTRANCE_TEXT, hashMap);
        } else if (profileCircleTianShuBean.isWithFeedExperiment()) {
            ProfileCardDtReportUtil.initElementWithExposureClickAndParams(view, ProfileCardDtReportUtil.DT_REPORT_EM_XSJ_GUIDANCE_DOC, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQCircleProfileDataResponse(UIStateData<List<e30.b>> uIStateData) {
        ProfileCircleTianShuBean profileCircleTianShuBean;
        QCircleProfileTitleInfoBean qCircleProfileTitleInfoBean;
        int i3 = 0;
        this.mIsDoingRequest.set(false);
        if (uIStateData == null) {
            QLog.e(getLogTag(), 1, "[handleQCircleProfileDataResponse] listUIStateData is null");
            return;
        }
        if (uIStateData.getState() == 4) {
            QLog.e(getLogTag(), 1, "[handleQCircleProfileDataResponse] response not success");
            return;
        }
        if (uIStateData.getIsLoadMore()) {
            QLog.e(getLogTag(), 1, "[handleQCircleProfileDataResponse] load more, not refresh data");
            return;
        }
        ArrayList<FeedCloudMeta$StFeed> d16 = d.d(uIStateData.getData());
        QCircleProfileViewModel qCircleProfileViewModel = this.mViewModel;
        String str = null;
        if (qCircleProfileViewModel != null) {
            profileCircleTianShuBean = qCircleProfileViewModel.getTianShuBean();
        } else {
            profileCircleTianShuBean = null;
        }
        QCircleProfileViewModel qCircleProfileViewModel2 = this.mViewModel;
        if (qCircleProfileViewModel2 != null) {
            qCircleProfileTitleInfoBean = qCircleProfileViewModel2.getTitleInfoBean();
        } else {
            qCircleProfileTitleInfoBean = null;
        }
        QCircleProfileViewModel qCircleProfileViewModel3 = this.mViewModel;
        if (qCircleProfileViewModel3 != null) {
            str = qCircleProfileViewModel3.getUin();
        }
        QCircleProfileViewModel qCircleProfileViewModel4 = this.mViewModel;
        if (qCircleProfileViewModel4 != null) {
            i3 = qCircleProfileViewModel4.getVideoPlayCtl();
        }
        this.mVideoPlayCtl = i3;
        this.mItemViewHolderManager.setVideoPlayCtl(i3);
        QLog.d(getLogTag(), 1, "[handleQCircleProfileDataResponse] uin:" + str + ", state:" + uIStateData.getState() + ", feeds.size:" + d16.size() + ", videoPlayCtl:" + this.mVideoPlayCtl);
        updateFansAndFuelsInfo(qCircleProfileTitleInfoBean, d16);
        this.mQQCircleFeeds = d16;
        this.mTianShuBean = profileCircleTianShuBean;
        this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.BaseProfileCircleComponent.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BaseProfileCircleComponent.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    BaseProfileCircleComponent baseProfileCircleComponent = BaseProfileCircleComponent.this;
                    baseProfileCircleComponent.makeOrRefreshQQCircle(((ProfileCardInfo) ((AbsComponent) baseProfileCircleComponent).mData).card);
                }
            }
        });
    }

    private void makeSureInitViewModel(String str) {
        String str2;
        if (this.mActivity == null) {
            QLog.e(TAG, 1, "[makeSureInitViewModel] error, mActivity is null");
            return;
        }
        if (this.mViewModel != null) {
            QLog.d(TAG, 1, "[makeSureInitViewModel] has init view model");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "[makeSureInitViewModel] error, uin is empty");
            return;
        }
        QCircleProfileViewModel qCircleProfileViewModel = (QCircleProfileViewModel) getViewModel(this.mActivity, str, QCircleProfileViewModel.class);
        this.mViewModel = qCircleProfileViewModel;
        if (qCircleProfileViewModel == null) {
            QLog.e(TAG, 1, "[makeSureInitViewModel] init fail");
            return;
        }
        this.mViewModelKey = str + "_" + this.mViewModel.hashCode();
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            str2 = appInterface.getCurrentUin();
        } else {
            str2 = "";
        }
        QLog.d(TAG, 1, "[makeSureInitViewModel] success, mViewModelKey:" + this.mViewModelKey + ", curUin:" + str2);
        this.mViewModel.setUin(str);
        this.mViewModel.setCurrentUin(str2);
        this.mViewModel.getDisplaySurfaceData().observe(this.mActivity, new Observer() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseProfileCircleComponent.this.handleQCircleProfileDataResponse((UIStateData) obj);
            }
        });
    }

    private void pausePlayVideo() {
        QLog.d(getLogTag(), 1, "[pausePlayVideo]");
        this.mItemViewHolderManager.pausePlayVideo(false);
    }

    private void reportLogin(String str, String str2) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_main_entrance", str);
        buildElementParams.put("xsj_sub_entrance", str2);
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PAGE_STACK_NUM, QCircleReportHelper.getQQCirclePageStackNum() + "");
        QCircleDTLoginReporter.executeDaTongLoginReport(buildElementParams);
    }

    private void resumePlayVideo() {
        QLog.d(getLogTag(), 1, "[resumePlayVideo]");
        this.mItemViewHolderManager.resumePlayVideo();
    }

    protected boolean canClickItemJumpLayer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        int i3 = this.mVideoPlayCtl;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    protected boolean canShowQCircleEntrance(ProfileCardInfo profileCardInfo) {
        boolean z16;
        Card card;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean t65 = uq3.c.t6();
        if (profileCardInfo != null && (card = profileCardInfo.card) != null && card.switchQQCircle == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d(TAG, 4, "isQCircleUser: " + t65 + ", isSwitchOpen: " + z16);
        if (t65 && z16) {
            return true;
        }
        return false;
    }

    protected void checkBlackListForbid(View view, View view2, View view3) {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, view, view2, view3);
            return;
        }
        this.photoView = view;
        this.redDotView = view2;
        this.tipsView = view3;
        int i18 = 8;
        if (view != null) {
            if (this.isBlacklist) {
                i17 = 8;
            } else {
                i17 = this.photoVisibleState;
            }
            view.setVisibility(i17);
        }
        if (view2 != null) {
            if (this.isBlacklist) {
                i16 = 8;
            } else {
                i16 = this.redDotVisibleState;
            }
            view2.setVisibility(i16);
        }
        if (view3 != null) {
            if (this.isBlacklist) {
                i3 = 8;
            } else {
                i3 = this.tipsVisibleState;
            }
            view3.setVisibility(i3);
        }
        ProfileCircleInfoView profileCircleInfoView = this.mProfileCircleInfoView;
        if (profileCircleInfoView != null) {
            if (!this.isBlacklist) {
                i18 = this.circleInfoVisibleState;
            }
            profileCircleInfoView.setVisibility(i18);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void dealReport(List<FeedCloudMeta$StFeed> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list);
            return;
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).card != null) {
            str = ((ProfileCardInfo) data).card.uin;
        } else {
            str = "";
        }
        if (this.mQQCircleShouldReport) {
            if (!TextUtils.isEmpty(this.mQcircleUpdateinfo)) {
                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(str).setActionType(3).setSubActionType(1).setThrActionType(3));
                this.mQQCircleShouldReport = false;
            } else if (list != null && list.size() > 0) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("ext1", getCircleProfileInfoExt1());
                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setToUin(str).setActionType(3).setSubActionType(1).setThrActionType(1).setExtras(hashMap));
                this.mQQCircleShouldReport = false;
            }
        }
    }

    protected void enterBySchema(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        QLog.d(TAG, 1, "enterBySchema, schema: " + str);
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.activity.qcircle.utils.c.g().enterByScheme(BaseApplication.getContext(), str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String getCardUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        DATA data = this.mData;
        if (data != 0 && ((ProfileCardInfo) data).card != null && ((ProfileCardInfo) data).card.uin != null) {
            return ((ProfileCardInfo) data).card.uin;
        }
        return null;
    }

    public String getCircleProfileInfoExt1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        int i3 = this.mFansValueStyle;
        if (i3 == 1 && this.mFuelValueStyle == 1) {
            return "4";
        }
        if (i3 == 1) {
            return "3";
        }
        if (this.mFuelValueStyle == 1) {
            return "2";
        }
        return "1";
    }

    protected String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return TAG;
    }

    protected <T extends ViewModel> T getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class<T> cls) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (T) iPatchRedirector.redirect((short) 25, this, viewModelStoreOwner, str, cls);
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStoreOwner);
        if (str == null) {
            str2 = cls.getCanonicalName();
            Objects.requireNonNull(str2);
        } else {
            str2 = str + cls.getCanonicalName();
        }
        return (T) viewModelProvider.get(str2, cls);
    }

    protected void handleForwardCircleMainPageClick(View view, QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo, Card card, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, view, qQAppInterface, profileCardInfo, card, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean isEntranceVisibility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        if (this.mViewContainer == 0) {
            return false;
        }
        return ((View) this.mViewContainer).getGlobalVisibleRect(new Rect());
    }

    protected void jumpLayerPage(View view, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, BitmapDrawable bitmapDrawable) {
        String str;
        FeedCloudMeta$StImage feedCloudMeta$StImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, view, Integer.valueOf(i3), feedCloudMeta$StFeed, bitmapDrawable);
            return;
        }
        w20.a.j().registerDisplaySurface(this.mViewModelKey, this.mViewModel);
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setGlobalViewModelKey(this.mViewModelKey);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        if (feedCloudMeta$StFeed != null) {
            qCircleLayerBean.setFeed(feedCloudMeta$StFeed);
            qCircleLayerBean.setDataPosInList(i3);
        }
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i16 = iArr[0];
            QFSTransitionAnimBean scaleType = qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], view.getWidth() + i16, iArr[1] + view.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (feedCloudMeta$StFeed != null && (feedCloudMeta$StImage = feedCloudMeta$StFeed.cover) != null) {
                str = feedCloudMeta$StImage.picUrl.get();
            } else {
                str = "";
            }
            QFSTransitionAnimBean imageUrl = scaleType.setImageUrl(str);
            imageUrl.setDisableBackTransitionWhenPosChanged(true);
            imageUrl.setCoverDrawable(bitmapDrawable);
            qCircleLayerBean.setTransitionAnimBean(imageUrl);
        }
        com.tencent.biz.qqcircle.launcher.c.u(this.mActivity, qCircleLayerBean);
        reportLogin(QCircleDaTongConstant.ElementParamValue.QQ_PROFILE, "content");
    }

    public abstract void jumpToNextPage();

    public abstract boolean makeOrRefreshQQCircle(Card card);

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent
    public void onBlacklistConfigureChange(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            if (this.isBlacklist == z17) {
                return;
            }
            this.isBlacklist = z17;
            checkBlackListForbid(this.photoView, this.redDotView, this.tipsView);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        super.onCreate(qBaseActivity, bundle);
        this.mUiHandler = new WeakReferenceHandler(Looper.getMainLooper(), null);
        DisplayMetrics displayMetrics = qBaseActivity.getResources().getDisplayMetrics();
        this.mScreenWidth = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.diffUtil = new CircleFeedsDiffUtil();
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.addProfileScrollListener(this);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QCircleProfileViewModel qCircleProfileViewModel = this.mViewModel;
        if (qCircleProfileViewModel != null && qCircleProfileViewModel.getDisplaySurfaceData() != null) {
            this.mViewModel.getDisplaySurfaceData().removeObservers(this.mActivity);
        }
        this.mQQCircleFeeds = null;
        this.mTianShuBean = null;
        ProfileCircleInfoView profileCircleInfoView = this.mProfileCircleInfoView;
        if (profileCircleInfoView != null) {
            profileCircleInfoView.onDestroy();
        }
        this.diffUtil = null;
        this.mItemViewHolderManager.releaseAllItemViewHolder();
        IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
        if (iProfileActivityDelegate != null) {
            iProfileActivityDelegate.removeProfileScrollListener(this);
            this.mDelegate = null;
        }
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.bussiness.circle.ProfileQCircleItemViewHolderManager.IProfileQCircleItemClickListener
    public void onItemClick(View view, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, BitmapDrawable bitmapDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, view, Integer.valueOf(i3), feedCloudMeta$StFeed, bitmapDrawable);
            return;
        }
        boolean canClickItemJumpLayer = canClickItemJumpLayer();
        QLog.d(getLogTag(), 1, "[onItemClick] clickPos:" + i3 + ", canClickItemJumpLayer:" + canClickItemJumpLayer);
        if (canClickItemJumpLayer) {
            jumpLayerPage(view, i3, feedCloudMeta$StFeed, bitmapDrawable);
            return;
        }
        DATA data = this.mData;
        if (data == 0) {
            QLog.e(getLogTag(), 1, "[onItemClick] mData is null");
        } else {
            handleForwardCircleMainPageClick(view, this.mQQAppInterface, (ProfileCardInfo) data, ((ProfileCardInfo) data).card, "content");
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mItemViewHolderManager.pausePlayVideo(true);
            super.onPause();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        if (!canShowQCircleEntrance((ProfileCardInfo) this.mData)) {
            setContainerVisible(false);
        } else {
            refreshFeed(((ProfileCardInfo) this.mData).card.uin);
            this.mItemViewHolderManager.resumePlayVideo();
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) absListView, i3);
            return;
        }
        if (i3 == 0) {
            boolean isEntranceVisibility = isEntranceVisibility();
            QLog.d(getLogTag(), 1, "[onScrollStateChanged] isEntranceVisibility:" + isEntranceVisibility);
            if (isEntranceVisibility) {
                if (this.mHasStartPlayVideo) {
                    resumePlayVideo();
                    return;
                } else {
                    startPlayVideo();
                    return;
                }
            }
            pausePlayVideo();
        }
    }

    public void refreshFeed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        if (this.mIsDoingRequest.compareAndSet(false, true)) {
            makeSureInitViewModel(str);
            if (this.mViewModel != null) {
                QLog.d(TAG, 1, "[refreshFeed] request qqcircle profile data");
                this.mViewModel.requestQCircleProfileData(this.mActivity, false);
            } else {
                QLog.d(TAG, 1, "[refreshFeed] fail, view model is null");
            }
        }
        this.mIsRefreshFeed = true;
    }

    protected void reportTianShu(int i3) {
        String adId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = String.valueOf(QCirclePluginUtil.getCurrentAccountLongUin());
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mPageId = QFSTianShuConstant.QCIRCLE_APP_ID;
        String str = "";
        if (this.mTianShuBean == null) {
            adId = "";
        } else {
            adId = this.mTianShuBean.getAdId();
        }
        tianShuReportData.mItemId = adId;
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        if (this.mTianShuBean != null) {
            str = this.mTianShuBean.getTraceInfo();
        }
        tianShuReportData.mTriggerInfo = str;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    public String schemaDtParams(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) str2);
        }
        return str + ContainerUtils.FIELD_DELIMITER + "xsj_tianshu_task_id" + ContainerUtils.KEY_VALUE_DELIMITER + str2 + ContainerUtils.FIELD_DELIMITER + "xsj_ref_pgid" + ContainerUtils.KEY_VALUE_DELIMITER + "qq_profile_page" + ContainerUtils.FIELD_DELIMITER + "xsj_main_entrance" + ContainerUtils.KEY_VALUE_DELIMITER + QCircleDaTongConstant.ElementParamValue.QQ_PROFILE + ContainerUtils.FIELD_DELIMITER + "xsj_sub_entrance" + ContainerUtils.KEY_VALUE_DELIMITER + QCircleDaTongConstant.ElementParamValue.GUIDANCE_DOC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setContainerVisible(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        VIEW view = this.mViewContainer;
        if (view != 0) {
            View view2 = (View) view;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    protected void setInfoViewClickListenerIfNeed(ProfileCircleTianShuBean profileCircleTianShuBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) profileCircleTianShuBean);
            return;
        }
        View childAt = this.mProfileCircleInfoView.getChildAt(0);
        if (childAt != null) {
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.BaseProfileCircleComponent.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseProfileCircleComponent.this);
                    }
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        BaseProfileCircleComponent.this.jumpToNextPage();
                        BaseProfileCircleComponent.this.reportTianShu(102);
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            dtReportGuideText(childAt, profileCircleTianShuBean);
        }
    }

    protected void setRedPoint(QQCircleFeedBase$StPageRedPointInfo qQCircleFeedBase$StPageRedPointInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) qQCircleFeedBase$StPageRedPointInfo);
            return;
        }
        if (qQCircleFeedBase$StPageRedPointInfo != null) {
            try {
                if (qQCircleFeedBase$StPageRedPointInfo.redTotalNum.get() > 0) {
                    if (!TextUtils.isEmpty(qQCircleFeedBase$StPageRedPointInfo.qqProfileInfo.txt.get())) {
                        this.mQcircleUpdateinfo = qQCircleFeedBase$StPageRedPointInfo.qqProfileInfo.txt.get();
                    } else {
                        this.mQcircleUpdateinfo = "";
                    }
                }
            } catch (Exception unused) {
                this.mQcircleUpdateinfo = "";
                return;
            }
        }
        this.mQcircleUpdateinfo = "";
    }

    protected void startPlayVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            if (this.mHasStartPlayVideo) {
                QLog.d(getLogTag(), 1, "[startPlayVideo] has started");
                return;
            }
            QLog.d(getLogTag(), 1, "[startPlayVideo] success");
            this.mItemViewHolderManager.playTargetVideo(0);
            this.mHasStartPlayVideo = true;
        }
    }

    protected void updateFansAndFuelsInfo(QCircleProfileTitleInfoBean qCircleProfileTitleInfoBean, List<FeedCloudMeta$StFeed> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) qCircleProfileTitleInfoBean, (Object) list);
            return;
        }
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null) {
            QLog.e(getLogTag(), 1, "[updateFansAndFuelsInfo] mActivity is null");
            return;
        }
        if (qCircleProfileTitleInfoBean == null) {
            QLog.e(getLogTag(), 1, "[updateFansAndFuelsInfo] titleInfoBean is null");
            return;
        }
        if (qCircleProfileTitleInfoBean.fansCount != 0) {
            this.mFansText = String.format(qBaseActivity.getString(R.string.f207395_w), QCircleHostUtil.fansNumberFormatTranfer(qCircleProfileTitleInfoBean.fansCount));
        }
        if (qCircleProfileTitleInfoBean.fuelCount != 0) {
            this.mFuelText = String.format(this.mActivity.getString(R.string.f207405_x), QCircleHostUtil.fansNumberFormatTranfer(qCircleProfileTitleInfoBean.fuelCount));
        }
        this.mFansValueStyle = qCircleProfileTitleInfoBean.fansValueStyle;
        this.mFuelValueStyle = qCircleProfileTitleInfoBean.fuelValueStyle;
        setRedPoint(qCircleProfileTitleInfoBean.redPointInfo);
        dealReport(list);
        QLog.d(TAG, 1, "updateFansAndFuelsInfo " + qCircleProfileTitleInfoBean.toString());
    }

    protected boolean updateGuideInfoIfNeed(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mProfileCircleInfoView.setVisibility(0);
        this.circleInfoVisibleState = 0;
        this.mProfileCircleInfoView.updateCirclePublishGuideInfo(str, i3);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        VIEW view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((BaseProfileCircleComponent) profileCardInfo);
        makeSureInitViewModel(getCardUin());
        boolean makeOrRefreshQQCircle = lambda$checkValidComponent$3 | makeOrRefreshQQCircle(((ProfileCardInfo) this.mData).card);
        if (makeOrRefreshQQCircle && !this.isInitDtReport && (view = this.mViewContainer) != 0) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposureClick((View) view, ProfileCardDtReportUtil.DT_REPORT_CIRCLE);
        }
        return makeOrRefreshQQCircle;
    }
}
