package com.tencent.biz.qqcircle.manager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.immersive.events.QFSMainTabNetworkDataEvent;
import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudRead$StGetBusiInfoReq;
import feedcloud.FeedCloudRead$StGetBusiInfoRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StBusiInfoData;
import qqcircle.QQCircleFeedBase$StPolyLike;
import qqcircle.QQCircleFeedBase$StSubTabInfo;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleFolderTabInfoManager {

    /* renamed from: f, reason: collision with root package name */
    private static volatile QCircleFolderTabInfoManager f91475f;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<QQCircleFeedBase$StTabInfo>> f91476a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<QQCircleFeedBase$StSubTabInfo>> f91477b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f91478c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final int f91479d = uq3.c.v3(6);

    /* renamed from: e, reason: collision with root package name */
    private boolean f91480e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements OnTaskListener<Object> {
        a() {
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object... objArr) {
            if (objArr != null && objArr.length == 4) {
                QLog.d("QCircleFolderTabInfoManager", 1, "fetchNewDataFromPreload requestTabData onReceive: dispatch Success:" + objArr[0] + " | retCode:" + objArr[1] + " | retMessage:" + objArr[2]);
                QCircleFolderTabInfoManager.this.r(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (String) objArr[2], objArr[3]);
                com.tencent.a.a("qcircle_preload", "initTabsFromNetwork");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetBusiInfoRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetBusiInfoRsp feedCloudRead$StGetBusiInfoRsp) {
            QLog.d("QCircleFolderTabInfoManager", 1, "fetchNewDataNow requestTabData onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isCache:" + VSNetworkHelper.isProtocolCache(str));
            com.tencent.a.a("QCircleTabViewModel", "QCircleTabViewModel receive");
            QCircleFolderTabInfoManager.this.r(z16, j3, str, feedCloudRead$StGetBusiInfoRsp);
        }
    }

    public QCircleFolderTabInfoManager() {
        u();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_folder_get_cache_tab_by_file_thread", false)) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager.1
                @Override // java.lang.Runnable
                public void run() {
                    QCircleFolderTabInfoManager.this.t();
                }
            });
        } else {
            t();
        }
    }

    public static void A() {
        QLog.d("QCircleFolderTabInfoManager", 1, "releaseInstance");
        if (f91475f != null) {
            synchronized (QCircleFolderTabInfoManager.class) {
                if (f91475f != null) {
                    f91475f = null;
                    f91475f = new QCircleFolderTabInfoManager();
                }
            }
        }
    }

    private void B(QCircleGetTabListRequest qCircleGetTabListRequest) {
        VSNetworkHelper.getInstance().sendRequest(qCircleGetTabListRequest, new b());
    }

    private void D(String str) {
        if (this.f91478c.containsKey(str)) {
            int intValue = this.f91478c.get(str).intValue();
            QCirclePluginGlobalInfo.T(intValue);
            QLog.d("QCircleFolderTabInfoManager", 1, "setJumpTabType:", Integer.valueOf(intValue));
        }
    }

    private void F(List<QQCircleFeedBase$StTabInfo> list) {
        if (list == null) {
            return;
        }
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = new QQCircleFeedBase$StTabInfo();
        qQCircleFeedBase$StTabInfo.tabType.set(1);
        qQCircleFeedBase$StTabInfo.sourceType.set(1);
        qQCircleFeedBase$StTabInfo.tabName.set(com.tencent.biz.qqcircle.utils.h.a(R.string.f183283ir));
        list.add(qQCircleFeedBase$StTabInfo);
    }

    private void G(QCircleGetTabListRequest qCircleGetTabListRequest) {
        FeedCloudRead$StGetBusiInfoReq feedCloudRead$StGetBusiInfoReq;
        if (qCircleGetTabListRequest != null && (feedCloudRead$StGetBusiInfoReq = qCircleGetTabListRequest.mReq) != null) {
            FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = feedCloudRead$StGetBusiInfoReq.extInfo.get();
            H(feedCloudCommon$StCommonExt);
            I(feedCloudCommon$StCommonExt);
            qCircleGetTabListRequest.mReq.extInfo.set(feedCloudCommon$StCommonExt);
        }
    }

    private void H(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        if (feedCloudCommon$StCommonExt == null) {
            return;
        }
        List<FeedCloudCommon$BytesEntry> list = feedCloudCommon$StCommonExt.mapBytesInfo.get();
        String inviteId = QCircleReportHelper.getInstance().getInviteId();
        if (TextUtils.isEmpty(inviteId)) {
            return;
        }
        byte[] bytes = inviteId.getBytes();
        if (bytes != null) {
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry.key.set(QCircleReportHelper.MAP_KEY_CIRCLE_INVITE_ID);
            feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(bytes));
            list.add(feedCloudCommon$BytesEntry);
        }
        feedCloudCommon$StCommonExt.mapBytesInfo.set(list);
    }

    private void I(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        if (feedCloudCommon$StCommonExt == null) {
            return;
        }
        List<FeedCloudCommon$Entry> list = feedCloudCommon$StCommonExt.mapInfo.get();
        list.add(QCircleReportFirstLogin.getFirstLoginEntry());
        feedCloudCommon$StCommonExt.mapInfo.set(list);
    }

    private void J(List<QQCircleFeedBase$StTabInfo> list) {
        if (list == null) {
            return;
        }
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = new QQCircleFeedBase$StTabInfo();
        qQCircleFeedBase$StTabInfo.tabType.set(8);
        qQCircleFeedBase$StTabInfo.sourceType.set(55);
        qQCircleFeedBase$StTabInfo.tabName.set(com.tencent.biz.qqcircle.utils.h.a(R.string.f183293is));
        if (s()) {
            qQCircleFeedBase$StTabInfo.defaultSubTabindex.set(0);
            QLog.d("QCircleFolderTabInfoManager", 1, "default nearby");
        } else {
            qQCircleFeedBase$StTabInfo.defaultSubTabindex.set(1);
            QLog.d("QCircleFolderTabInfoManager", 1, "default select");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(com.tencent.biz.qqcircle.utils.h.a(R.string.f183303it), "pg_xsj_circle_nearby_page", 97002, 1));
        arrayList.add(d(com.tencent.biz.qqcircle.utils.h.a(R.string.f183273iq), QCircleDaTongConstant.PageId.PG_XSJ_CIRCLE_SELECTED_PAGE, 97001, 2));
        qQCircleFeedBase$StTabInfo.subTabInfo.set(arrayList);
        list.add(qQCircleFeedBase$StTabInfo);
    }

    private void K(List<QQCircleFeedBase$StTabInfo> list) {
        if (list == null) {
            return;
        }
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = new QQCircleFeedBase$StTabInfo();
        qQCircleFeedBase$StTabInfo.tabType.set(6);
        qQCircleFeedBase$StTabInfo.sourceType.set(10);
        qQCircleFeedBase$StTabInfo.tabName.set(com.tencent.biz.qqcircle.utils.h.a(R.string.f183313iu));
        list.add(qQCircleFeedBase$StTabInfo);
    }

    private List<QQCircleFeedBase$StTabInfo> L(@NonNull String[] strArr) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : strArr) {
                M(arrayList, Integer.parseInt(str));
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.d("QCircleFolderTabInfoManager", 1, "wrapTabByOrders failed,typeOrders:" + Arrays.toString(strArr) + e16.toString());
            ArrayList arrayList2 = new ArrayList();
            i(arrayList2);
            return arrayList2;
        }
    }

    private void M(@NonNull List<QQCircleFeedBase$StTabInfo> list, int i3) {
        if (i3 != 1) {
            if (i3 != 6) {
                if (i3 == 8) {
                    J(list);
                    return;
                }
                return;
            }
            K(list);
            return;
        }
        F(list);
    }

    private QQCircleFeedBase$StSubTabInfo d(String str, String str2, int i3, int i16) {
        QQCircleFeedBase$StSubTabInfo qQCircleFeedBase$StSubTabInfo = new QQCircleFeedBase$StSubTabInfo();
        qQCircleFeedBase$StSubTabInfo.tabName.set(str);
        qQCircleFeedBase$StSubTabInfo.dtPgID.set(str2);
        qQCircleFeedBase$StSubTabInfo.pageId.set(i3);
        qQCircleFeedBase$StSubTabInfo.sourceType.set(i16);
        qQCircleFeedBase$StSubTabInfo.pendantInfo.picUrl.set("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8860/quanzi/quanzi_tab_selected_deco.png");
        return qQCircleFeedBase$StSubTabInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void y(boolean z16, long j3, String str, Object obj) {
        FeedCloudRead$StGetBusiInfoRsp feedCloudRead$StGetBusiInfoRsp;
        com.tencent.a.e("handleTabListResponse");
        if (z16 && j3 == 0 && obj != null) {
            try {
                if (obj instanceof FeedCloudRead$StGetBusiInfoRsp) {
                    feedCloudRead$StGetBusiInfoRsp = (FeedCloudRead$StGetBusiInfoRsp) obj;
                } else if (obj instanceof byte[]) {
                    feedCloudRead$StGetBusiInfoRsp = new FeedCloudRead$StGetBusiInfoRsp().mergeFrom((byte[]) obj);
                } else {
                    feedCloudRead$StGetBusiInfoRsp = null;
                }
                if (feedCloudRead$StGetBusiInfoRsp == null) {
                    return;
                }
                QQCircleFeedBase$StBusiInfoData qQCircleFeedBase$StBusiInfoData = new QQCircleFeedBase$StBusiInfoData();
                byte[] byteArray = feedCloudRead$StGetBusiInfoRsp.busiRspData.get().toByteArray();
                qQCircleFeedBase$StBusiInfoData.mergeFrom(byteArray);
                com.tencent.biz.qqcircle.f.v().Y(byteArray);
                v(qQCircleFeedBase$StBusiInfoData);
                w(qQCircleFeedBase$StBusiInfoData);
                QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_GET_TAB_NET_RSP);
                com.tencent.a.a("handleTabListResponse", "");
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                QLog.d("QCircleFolderTabInfoManager", 1, "handleTabListResponse parse setBusiInfoData exception:", e16.toString());
                return;
            }
        }
        QLog.d("QCircleFolderTabInfoManager", 1, "handleTabListRsp isSuc:", Boolean.valueOf(z16), ",retCode:", Long.valueOf(j3), ",errMsg:", str);
    }

    private void g() {
        com.tencent.a.e("qcircle_preload");
        QLog.i("QCircleFolderTabInfoManager", 1, "fetchNewDataFromPreload");
        PreLoader.addListener("2002", new a());
    }

    private void i(List<QQCircleFeedBase$StTabInfo> list) {
        if (list == null) {
            return;
        }
        F(list);
        J(list);
        K(list);
    }

    @Nullable
    private List<QQCircleFeedBase$StTabInfo> j() {
        List<QQCircleFeedBase$StTabInfo> list = this.f91476a.get("default");
        if (list == null) {
            list = new ArrayList<>();
            i(list);
        }
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = list.get(0);
        if (s()) {
            qQCircleFeedBase$StTabInfo.defaultSubTabindex.set(0);
            QLog.d("QCircleFolderTabInfoManager", 1, "default nearby");
        } else {
            qQCircleFeedBase$StTabInfo.defaultSubTabindex.set(1);
            QLog.d("QCircleFolderTabInfoManager", 1, "default select");
        }
        return list;
    }

    public static QCircleFolderTabInfoManager m() {
        if (f91475f == null) {
            synchronized (QCircleFolderTabInfoManager.class) {
                if (f91475f == null) {
                    f91475f = new QCircleFolderTabInfoManager();
                }
            }
        }
        return f91475f;
    }

    private void n(QQCircleFeedBase$StBusiInfoData qQCircleFeedBase$StBusiInfoData) {
        List<QQCircleFeedBase$StPolyLike> list = qQCircleFeedBase$StBusiInfoData.allPolyInfo.get();
        if (list != null) {
            ha0.a.a().c(list);
            ha0.a.a().d((float) qQCircleFeedBase$StBusiInfoData.rewardData.myMoney.get());
        }
    }

    private boolean q(String str) {
        if (this.f91476a.containsKey(str)) {
            QLog.d("QCircleFolderTabInfoManager", 1, "getTabInfo in " + str + " level");
            D(str);
            return true;
        }
        return false;
    }

    private boolean s() {
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle");
        if (cachedLbsInfo != null && cachedLbsInfo.mLocation != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        long currentTimeMillis = System.currentTimeMillis();
        QQCircleFeedBase$StBusiInfoData m3 = com.tencent.biz.qqcircle.f.v().m();
        if (m3 != null && !m3.tabInfos.isEmpty()) {
            n(m3);
            this.f91476a.put("cache", m3.tabInfos.get());
            this.f91477b.put("cache", m3.gallerySubTabInfos.get());
            int z16 = z(m3, m3.tabInfos.get());
            this.f91478c.put("cache", Integer.valueOf(z16));
            QLog.d("QCircleFolderTabInfoManager", 1, "initCacheTabInfo done,size:" + m3.tabInfos.size() + ",jumpTabType:" + z16 + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        QLog.e("QCircleFolderTabInfoManager", 1, "initCacheTabInfo error,no cache tabInfo data");
    }

    private void u() {
        String s16 = com.tencent.biz.qqcircle.f.s();
        if (TextUtils.isEmpty(s16)) {
            QLog.d("QCircleFolderTabInfoManager", 1, "initDefaultTabInfo error,defaultTabTapeOrder:" + s16);
            return;
        }
        List<QQCircleFeedBase$StTabInfo> L = L(s16.split(","));
        this.f91476a.put("default", L);
        this.f91477b.put("default", k());
        this.f91478c.put("default", Integer.valueOf(this.f91479d));
        QLog.d("QCircleFolderTabInfoManager", 1, "initDefaultTabInfo done,size:" + L.size() + ",jumpTabType:" + this.f91479d);
    }

    private void v(QQCircleFeedBase$StBusiInfoData qQCircleFeedBase$StBusiInfoData) {
        if (qQCircleFeedBase$StBusiInfoData != null && qQCircleFeedBase$StBusiInfoData.has()) {
            QLog.d("QCircleFolderTabInfoManager", 1, "initNewPublishPromoteInfo, start ");
            QCirclePublishPromoteDataManager.f().i(qQCircleFeedBase$StBusiInfoData.publishAlienationButton.get(), qQCircleFeedBase$StBusiInfoData.publishToast.get());
            return;
        }
        QLog.d("QCircleFolderTabInfoManager", 1, "initNewPublishPromoteInfo, rsp is null ");
    }

    private void w(QQCircleFeedBase$StBusiInfoData qQCircleFeedBase$StBusiInfoData) {
        if (qQCircleFeedBase$StBusiInfoData != null && qQCircleFeedBase$StBusiInfoData.tabInfos.has()) {
            n(qQCircleFeedBase$StBusiInfoData);
            List<QQCircleFeedBase$StTabInfo> list = qQCircleFeedBase$StBusiInfoData.tabInfos.get();
            List<QQCircleFeedBase$StSubTabInfo> list2 = qQCircleFeedBase$StBusiInfoData.gallerySubTabInfos.get();
            int z16 = z(qQCircleFeedBase$StBusiInfoData, list);
            this.f91478c.put(QCircleDaTongConstant.ElementParamValue.NEW, Integer.valueOf(z16));
            this.f91476a.put(QCircleDaTongConstant.ElementParamValue.NEW, list);
            this.f91477b.put(QCircleDaTongConstant.ElementParamValue.NEW, list2);
            SimpleEventBus.getInstance().dispatchEvent(new QFSMainTabNetworkDataEvent(list));
            QLog.d("QCircleFolderTabInfoManager", 1, "initNewTabInfo done,size:", list.size() + ",jumpTabType:" + z16);
        }
    }

    private int z(QQCircleFeedBase$StBusiInfoData qQCircleFeedBase$StBusiInfoData, List<QQCircleFeedBase$StTabInfo> list) {
        int i3 = this.f91479d;
        if (!qQCircleFeedBase$StBusiInfoData.defaultTabIndex.has()) {
            QLog.d("QCircleFolderTabInfoManager", 1, "parseJumpTabType defaultTabIndex not set,use default");
            return i3;
        }
        try {
            return list.get(qQCircleFeedBase$StBusiInfoData.defaultTabIndex.get()).tabType.get();
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("QCircleFolderTabInfoManager", 1, "parseJumpTabType parse exception:", e16.toString());
            return i3;
        }
    }

    public void C(boolean z16) {
        this.f91480e = z16;
    }

    public boolean E(QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo) {
        if (!uq3.c.k5()) {
            QLog.d("QCircleFolderTabInfoManager", 1, "updateInfoIfNeed closed");
            return false;
        }
        List<QQCircleFeedBase$StTabInfo> list = this.f91476a.get(QCircleDaTongConstant.ElementParamValue.NEW);
        if (qQCircleFeedBase$StTabInfo != null && list != null && list.size() >= 0) {
            for (QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo2 : list) {
                if (qQCircleFeedBase$StTabInfo2.sourceType.get() == qQCircleFeedBase$StTabInfo.sourceType.get() && qQCircleFeedBase$StTabInfo2.subTabInfo.size() != qQCircleFeedBase$StTabInfo.subTabInfo.size()) {
                    qQCircleFeedBase$StTabInfo.defaultSubTabindex.set(qQCircleFeedBase$StTabInfo2.defaultSubTabindex.get());
                    qQCircleFeedBase$StTabInfo.subTabInfo.set(qQCircleFeedBase$StTabInfo2.subTabInfo.get());
                    QLog.d("QCircleFolderTabInfoManager", 1, "updateInfoIfNeed has new data");
                    return true;
                }
            }
            return false;
        }
        QLog.d("QCircleFolderTabInfoManager", 1, "updateInfoIfNeed no new data");
        return false;
    }

    public void f(final FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2, final QCircleFolderBean qCircleFolderBean) {
        boolean exists = PreLoader.exists("2002");
        QLog.d("QCircleFolderTabInfoManager", 1, "fetchNewData from Preload:" + exists);
        if (exists) {
            g();
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.manager.a
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleFolderTabInfoManager.this.x(feedCloudMeta$StGPSV2, qCircleFolderBean);
                }
            });
        }
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void x(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2, QCircleFolderBean qCircleFolderBean) {
        com.tencent.a.e("QCircleTabViewModel");
        try {
            QCircleGetTabListRequest qCircleGetTabListRequest = new QCircleGetTabListRequest(feedCloudMeta$StGPSV2, qCircleFolderBean);
            qCircleGetTabListRequest.setRetryCount(2);
            G(qCircleGetTabListRequest);
            QLog.d("QCircleFolderTabInfoManager", 1, "requestTabData(),CmdName:" + qCircleGetTabListRequest.get$cmd() + " | TraceId:" + qCircleGetTabListRequest.getTraceId() + " | SeqId:" + qCircleGetTabListRequest.getCurrentSeq());
            B(qCircleGetTabListRequest);
        } catch (NullPointerException e16) {
            QLog.e("QCircleFolderTabInfoManager", 1, "[error] ex: ", e16);
        }
    }

    @Nullable
    public List<QQCircleFeedBase$StSubTabInfo> k() {
        ArrayList arrayList = new ArrayList();
        QQCircleFeedBase$StSubTabInfo qQCircleFeedBase$StSubTabInfo = new QQCircleFeedBase$StSubTabInfo();
        qQCircleFeedBase$StSubTabInfo.tabName.set(com.tencent.biz.qqcircle.utils.h.a(R.string.f1907442x));
        qQCircleFeedBase$StSubTabInfo.sourceType.set(3);
        arrayList.add(qQCircleFeedBase$StSubTabInfo);
        return arrayList;
    }

    public boolean l() {
        return this.f91480e;
    }

    public List<QQCircleFeedBase$StTabInfo> o(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2, QCircleFolderBean qCircleFolderBean) {
        return p(feedCloudMeta$StGPSV2, qCircleFolderBean, true);
    }

    public List<QQCircleFeedBase$StTabInfo> p(FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2, QCircleFolderBean qCircleFolderBean, boolean z16) {
        if (z16) {
            f(feedCloudMeta$StGPSV2, qCircleFolderBean);
        }
        if (q(QCircleDaTongConstant.ElementParamValue.NEW)) {
            QLog.d("QCircleFolderTabInfoManager", 1, "getTabInfo in new level");
            return this.f91476a.get(QCircleDaTongConstant.ElementParamValue.NEW);
        }
        if (q("cache")) {
            QLog.d("QCircleFolderTabInfoManager", 1, "getTabInfo in cache level");
            return this.f91476a.get("cache");
        }
        QLog.d("QCircleFolderTabInfoManager", 1, "getTabInfo in default level");
        D("default");
        return j();
    }

    public void r(final boolean z16, final long j3, final String str, final Object obj) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.manager.b
            @Override // java.lang.Runnable
            public final void run() {
                QCircleFolderTabInfoManager.this.y(z16, j3, str, obj);
            }
        });
    }
}
