package com.tencent.mobileqq.profilecard.bussiness.circle;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.profilecard.bussiness.circle.BaseProfileCircleComponent;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import qqcircle.QQCircleFeedBase$StMainPageBusiRspData;
import qqcircle.QQCircleMainPageProfile$GetQQProfileFeedListRsp;
import tianshu.QQCircleTianShu$AdItem;

/* loaded from: classes16.dex */
public class QCircleProfileViewModel extends BaseViewModel implements IDataDisplaySurface<e30.b> {
    static IPatchRedirector $redirector_ = null;
    private static final int CACHE_SIZE = 5;
    private static final String TAG = "QCircleProfileViewModel";
    private static final LruCache<String, BaseProfileCircleComponent.ProfileCircleCacheBean> sCircleBeanCache;
    private static String sCurrentUin;
    private String mFeedAttachInfo;
    private final List<e30.b> mFeedList;
    public MutableLiveData<UIStateData<List<e30.b>>> mFeedListLiveData;
    private BaseProfileCircleComponent.ProfileCircleTianShuBean mTianShuBean;
    private BaseProfileCircleComponent.QCircleProfileTitleInfoBean mTitleInfoBean;
    private String mUin;
    private int mVideoPlayCtl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class BusinessRspParseData {
        static IPatchRedirector $redirector_;
        public long requestTimeInterval;
        public BaseProfileCircleComponent.ProfileCircleTianShuBean tianShuBean;
        public BaseProfileCircleComponent.QCircleProfileTitleInfoBean titleInfoBean;

        BusinessRspParseData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74076);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            sCircleBeanCache = new LruCache<>(5);
            sCurrentUin = "";
        }
    }

    public QCircleProfileViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mFeedListLiveData = new MutableLiveData<>();
        this.mFeedList = new CopyOnWriteArrayList();
        this.mVideoPlayCtl = 0;
        this.mFeedAttachInfo = null;
    }

    public static void clearCacheData() {
        sCircleBeanCache.evictAll();
    }

    private void filterRepeatedFeed(List<e30.b> list, List<e30.b> list2) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2;
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            Iterator<e30.b> it = list2.iterator();
            while (it.hasNext()) {
                e30.b next = it.next();
                if (next != null) {
                    feedCloudMeta$StFeed = next.g();
                } else {
                    feedCloudMeta$StFeed = null;
                }
                if (feedCloudMeta$StFeed != null) {
                    for (e30.b bVar : list) {
                        if (bVar != null) {
                            feedCloudMeta$StFeed2 = bVar.g();
                        } else {
                            feedCloudMeta$StFeed2 = null;
                        }
                        if (feedCloudMeta$StFeed2 != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), feedCloudMeta$StFeed2.f398449id.get())) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    private void handleCacheResponse(BaseProfileCircleComponent.ProfileCircleCacheBean profileCircleCacheBean) {
        if (profileCircleCacheBean == null) {
            QLog.e(getTAG(), 1, "[handleCacheResponse] cacheBean is null");
            return;
        }
        this.mFeedAttachInfo = profileCircleCacheBean.getFeedAttachInfo();
        this.mTianShuBean = profileCircleCacheBean.getTianShuBean();
        this.mTitleInfoBean = profileCircleCacheBean.getTitleInfoBean();
        this.mVideoPlayCtl = profileCircleCacheBean.getVideoPlayCtl();
        this.mFeedList.clear();
        this.mFeedList.addAll(transFormFeedListToBlockList(profileCircleCacheBean.getStFeedList()));
        if (this.mFeedList.isEmpty()) {
            QLog.e(getTAG(), 1, "[handleCacheResponse] set empty data");
            this.mFeedListLiveData.postValue(UIStateData.obtainEmpty().setLoadMore(false));
        } else {
            QLog.d(getTAG(), 1, "[handleCacheResponse] set success data");
            this.mFeedListLiveData.postValue(UIStateData.obtainSuccess(true).setData(false, this.mFeedList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQCircleProfileResponse(boolean z16, long j3, String str, QQCircleMainPageProfile$GetQQProfileFeedListRsp qQCircleMainPageProfile$GetQQProfileFeedListRsp, boolean z17, boolean z18) {
        QCircleProfileViewModel qCircleProfileViewModel;
        boolean z19;
        boolean z26;
        int i3;
        if (z16 && j3 == 0 && qQCircleMainPageProfile$GetQQProfileFeedListRsp != null) {
            this.mFeedAttachInfo = qQCircleMainPageProfile$GetQQProfileFeedListRsp.feedAttchInfo.get();
            List<FeedCloudMeta$StFeed> list = qQCircleMainPageProfile$GetQQProfileFeedListRsp.vecFeed.get();
            Object obj = "";
            if (!z17) {
                this.mFeedList.clear();
                BusinessRspParseData parseBusinessRspData = parseBusinessRspData(qQCircleMainPageProfile$GetQQProfileFeedListRsp);
                this.mTianShuBean = parseBusinessRspData.tianShuBean;
                this.mTitleInfoBean = parseBusinessRspData.titleInfoBean;
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_profile_disable_video_auto_play", false);
                if (isSwitchOn) {
                    i3 = 0;
                } else {
                    i3 = qQCircleMainPageProfile$GetQQProfileFeedListRsp.videoPlayCtl.get();
                }
                this.mVideoPlayCtl = i3;
                z19 = false;
                updateCacheData(this.mUin, list, this.mTianShuBean, this.mTitleInfoBean, this.mFeedAttachInfo, parseBusinessRspData.requestTimeInterval, i3);
                String tag = getTAG();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[handleQCircleProfileResponse] refresh, feed size:");
                if (list != null) {
                    obj = Integer.valueOf(list.size());
                }
                sb5.append(obj);
                sb5.append(", requestTimeInterval:");
                sb5.append(parseBusinessRspData.requestTimeInterval);
                sb5.append(", configDisableAutoPlay:");
                sb5.append(isSwitchOn);
                sb5.append(", videoPlayCtl:");
                qCircleProfileViewModel = this;
                sb5.append(qCircleProfileViewModel.mVideoPlayCtl);
                QLog.d(tag, 1, sb5.toString());
            } else {
                qCircleProfileViewModel = this;
                z19 = false;
                String tag2 = getTAG();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("[handleQCircleProfileResponse] loadMore, feed size:");
                if (list != null) {
                    obj = Integer.valueOf(list.size());
                }
                sb6.append(obj);
                QLog.d(tag2, 1, sb6.toString());
            }
            ArrayList<e30.b> transFormFeedListToBlockList = qCircleProfileViewModel.transFormFeedListToBlockList(list);
            qCircleProfileViewModel.filterRepeatedFeed(qCircleProfileViewModel.mFeedList, transFormFeedListToBlockList);
            qCircleProfileViewModel.mFeedList.addAll(transFormFeedListToBlockList);
            if (qQCircleMainPageProfile$GetQQProfileFeedListRsp.isFinish.get() > 0) {
                z26 = true;
            } else {
                z26 = z19;
            }
            if (qCircleProfileViewModel.mFeedList.isEmpty()) {
                QLog.e(getTAG(), 1, "[handleQCircleProfileResponse] set empty data");
                qCircleProfileViewModel.mFeedListLiveData.postValue(UIStateData.obtainEmpty().setRetCode(j3).setLoadMore(z17).setFinish(z26));
                return;
            } else {
                QLog.d(getTAG(), 1, "[handleQCircleProfileResponse] set success data");
                qCircleProfileViewModel.mFeedListLiveData.postValue(UIStateData.obtainSuccess(z18).setData(z17, qCircleProfileViewModel.mFeedList).setFinish(z26));
                return;
            }
        }
        QLog.e(getTAG(), 1, "[handleQCircleProfileResponse] set error data, uin:" + this.mUin);
        this.mFeedListLiveData.postValue(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(z17));
        removeCacheData(this.mUin);
    }

    private BusinessRspParseData parseBusinessRspData(QQCircleMainPageProfile$GetQQProfileFeedListRsp qQCircleMainPageProfile$GetQQProfileFeedListRsp) {
        List<QQCircleTianShu$AdItem> list;
        BusinessRspParseData businessRspParseData = new BusinessRspParseData();
        if (qQCircleMainPageProfile$GetQQProfileFeedListRsp == null) {
            return businessRspParseData;
        }
        QQCircleFeedBase$StMainPageBusiRspData qQCircleFeedBase$StMainPageBusiRspData = new QQCircleFeedBase$StMainPageBusiRspData();
        try {
            qQCircleFeedBase$StMainPageBusiRspData.mergeFrom(qQCircleMainPageProfile$GetQQProfileFeedListRsp.busiRspData.get().toByteArray());
            if (qQCircleFeedBase$StMainPageBusiRspData.qqProfileGuideCopywriting.has() && (list = qQCircleFeedBase$StMainPageBusiRspData.qqProfileGuideCopywriting.get().value.lst.get()) != null && !list.isEmpty()) {
                businessRspParseData.tianShuBean = new BaseProfileCircleComponent.ProfileCircleTianShuBean(list.get(0));
            }
            BaseProfileCircleComponent.QCircleProfileTitleInfoBean qCircleProfileTitleInfoBean = new BaseProfileCircleComponent.QCircleProfileTitleInfoBean();
            qCircleProfileTitleInfoBean.fansCount = qQCircleMainPageProfile$GetQQProfileFeedListRsp.fansCount.get();
            qCircleProfileTitleInfoBean.fansValueStyle = qQCircleMainPageProfile$GetQQProfileFeedListRsp.fansValueStyle.get();
            try {
                qCircleProfileTitleInfoBean.fuelCount = qQCircleFeedBase$StMainPageBusiRspData.fuelValue.get();
                qCircleProfileTitleInfoBean.fuelValueStyle = qQCircleFeedBase$StMainPageBusiRspData.fuelValueStyle.get();
                qCircleProfileTitleInfoBean.redPointInfo = qQCircleFeedBase$StMainPageBusiRspData.RedPointInfo.get();
                businessRspParseData.titleInfoBean = qCircleProfileTitleInfoBean;
                businessRspParseData.requestTimeInterval = qQCircleFeedBase$StMainPageBusiRspData.timeInterval.get();
            } catch (Exception e16) {
                QLog.e(getTAG(), 1, "[parseBusinessRspData] titleInfo error, " + e16);
            }
            return businessRspParseData;
        } catch (Exception e17) {
            QLog.e(getTAG(), 1, "[parseBusinessRspData] error ", e17);
            return businessRspParseData;
        }
    }

    private void updateCacheData(String str, List<FeedCloudMeta$StFeed> list, BaseProfileCircleComponent.ProfileCircleTianShuBean profileCircleTianShuBean, BaseProfileCircleComponent.QCircleProfileTitleInfoBean qCircleProfileTitleInfoBean, String str2, long j3, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sCircleBeanCache.put(str, new BaseProfileCircleComponent.ProfileCircleCacheBean(list, profileCircleTianShuBean, qCircleProfileTitleInfoBean, str2, j3, System.currentTimeMillis(), i3));
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData(Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.mFeedListLiveData : (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) objArr);
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return TAG;
    }

    public BaseProfileCircleComponent.ProfileCircleTianShuBean getTianShuBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseProfileCircleComponent.ProfileCircleTianShuBean) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mTianShuBean;
    }

    public BaseProfileCircleComponent.QCircleProfileTitleInfoBean getTitleInfoBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BaseProfileCircleComponent.QCircleProfileTitleInfoBean) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mTitleInfoBean;
    }

    public String getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mUin;
    }

    public int getVideoPlayCtl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mVideoPlayCtl;
    }

    @Override // com.tencent.richframework.data.idata.IDataDisplaySurface
    public void loadMoreForDisplaySurface(Object... objArr) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objArr);
            return;
        }
        if (getDisplaySurfaceData().getValue() != null && getDisplaySurfaceData().getValue().getState() != 1) {
            getDisplaySurfaceData().getValue().setState(1);
            if (objArr.length > 1) {
                Object obj = objArr[1];
                if (obj instanceof Context) {
                    context = (Context) obj;
                    requestQCircleProfileData(context, true);
                }
            }
            context = null;
            requestQCircleProfileData(context, true);
        }
    }

    public void removeCacheData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            sCircleBeanCache.remove(str);
        }
    }

    public void requestQCircleProfileData(Context context, boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, context, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(this.mUin)) {
            QLog.e(getTAG(), 1, "[requestQCircleProfileData] mUin is empty");
            return;
        }
        BaseProfileCircleComponent.ProfileCircleCacheBean profileCircleCacheBean = sCircleBeanCache.get(this.mUin);
        if (profileCircleCacheBean != null && profileCircleCacheBean.canUseCacheData()) {
            z17 = true;
        }
        QLog.d(getTAG(), 1, "[requestQCircleProfileData] uin:" + this.mUin + ", canUseCacheData:" + z17 + ", isLoadMore:" + z16 + ", mFeedAttachInfo:" + this.mFeedAttachInfo);
        if (z17 && !z16) {
            handleCacheResponse(profileCircleCacheBean);
            return;
        }
        IQCircleService g16 = com.tencent.mobileqq.activity.qcircle.utils.c.g();
        String str2 = this.mUin;
        if (z16) {
            str = this.mFeedAttachInfo;
        } else {
            str = null;
        }
        g16.refreshMainPageFeed(context, str2, str, new VSDispatchObserver.OnVSRspCallBack<QQCircleMainPageProfile$GetQQProfileFeedListRsp>(z16) { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.QCircleProfileViewModel.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean val$isLoadMore;

            {
                this.val$isLoadMore = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QCircleProfileViewModel.this, Boolean.valueOf(z16));
                }
            }

            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z18, long j3, String str3, QQCircleMainPageProfile$GetQQProfileFeedListRsp qQCircleMainPageProfile$GetQQProfileFeedListRsp) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, baseRequest, Boolean.valueOf(z18), Long.valueOf(j3), str3, qQCircleMainPageProfile$GetQQProfileFeedListRsp);
                    return;
                }
                boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[requestQCircleProfileData] onReceive: dispatch Success:");
                sb5.append(z18);
                sb5.append(" \uff5c cmd:");
                sb5.append(baseRequest.getCmd());
                sb5.append(" | TraceId:");
                sb5.append(baseRequest.getTraceId());
                sb5.append(" | SeqId:");
                sb5.append(baseRequest.getCurrentSeq());
                sb5.append(" | retCode:");
                sb5.append(j3);
                sb5.append(" | retMessage:");
                sb5.append(str3);
                sb5.append(" | isLoadMore:");
                sb5.append(this.val$isLoadMore);
                sb5.append(" | responseAttachInfo:");
                sb5.append(QCircleProfileViewModel.this.mFeedAttachInfo);
                sb5.append(" | isFinish: ");
                sb5.append(qQCircleMainPageProfile$GetQQProfileFeedListRsp == null ? "" : Integer.valueOf(qQCircleMainPageProfile$GetQQProfileFeedListRsp.isFinish.get()));
                sb5.append(" | isCache: ");
                sb5.append(isProtocolCache);
                sb5.append(" | uin: ");
                sb5.append(QCircleProfileViewModel.this.mUin);
                QLog.d(QCircleProfileViewModel.TAG, 1, sb5.toString());
                RFWThreadManager.getInstance().execOnSubThread(new Runnable(z18, j3, str3, qQCircleMainPageProfile$GetQQProfileFeedListRsp, isProtocolCache) { // from class: com.tencent.mobileqq.profilecard.bussiness.circle.QCircleProfileViewModel.1.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$errMsg;
                    final /* synthetic */ boolean val$isCache;
                    final /* synthetic */ boolean val$isSuccess;
                    final /* synthetic */ long val$retCode;
                    final /* synthetic */ QQCircleMainPageProfile$GetQQProfileFeedListRsp val$sp;

                    {
                        this.val$isSuccess = z18;
                        this.val$retCode = j3;
                        this.val$errMsg = str3;
                        this.val$sp = qQCircleMainPageProfile$GetQQProfileFeedListRsp;
                        this.val$isCache = isProtocolCache;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(z18), Long.valueOf(j3), str3, qQCircleMainPageProfile$GetQQProfileFeedListRsp, Boolean.valueOf(isProtocolCache));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            QCircleProfileViewModel.this.handleQCircleProfileResponse(this.val$isSuccess, this.val$retCode, this.val$errMsg, this.val$sp, anonymousClass1.val$isLoadMore, this.val$isCache);
                        }
                    }
                });
            }
        });
    }

    public void setCurrentUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, sCurrentUin)) {
            clearCacheData();
        }
        sCurrentUin = str;
    }

    public void setUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.mUin = str;
        }
    }

    public ArrayList<e30.b> transFormFeedListToBlockList(List<FeedCloudMeta$StFeed> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this, (Object) list);
        }
        ArrayList<e30.b> arrayList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            Iterator<FeedCloudMeta$StFeed> it = list.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new e30.b(it.next()).p());
                } catch (Exception e16) {
                    QLog.d(TAG, 1, "[transFormFeedListToBlockList] exception:" + e16.getMessage());
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public MutableLiveData<UIStateData<List<e30.b>>> getDisplaySurfaceData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.mFeedListLiveData : (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
    }
}
