package com.tencent.biz.qqcircle.immersive.repository.foldertab;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.debug.recommend.data.RecExptInfo;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.m;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QFSGetFeedListByPoolIDRequest;
import com.tencent.biz.qqcircle.requests.QFSGetFriendFeedListRequest;
import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerPreRenderHelper;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.Call;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import cooperation.qqcircle.report.QFSAuthorUinMonitorManager;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$RecomReed;
import feedcloud.FeedCloudMeta$AdvertClientInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTabRequestSender {

    /* renamed from: a, reason: collision with root package name */
    private final String f89751a;

    /* renamed from: b, reason: collision with root package name */
    private final String f89752b;

    /* renamed from: c, reason: collision with root package name */
    private final l f89753c;

    /* renamed from: d, reason: collision with root package name */
    private Call.OnRspCallBack f89754d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Call.OnRspCallBack {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f89763d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m.a f89764e;

        a(long j3, m.a aVar) {
            this.f89763d = j3;
            this.f89764e = aVar;
        }

        @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
        public void onReceive(boolean z16, long j3, String str, Object obj, Object obj2, Bundle bundle) {
            com.tencent.biz.qqcircle.immersive.manager.j.h().l(z16, j3, obj, obj2);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z17 = obj instanceof QCircleTabGetFeedListRequest;
            if (z17) {
                QCircleFolderFunnelCollect.setLoadFeedInfo(j3 + "-" + ((QCircleTabGetFeedListRequest) obj).getRealRequestSendCount() + "-" + (currentTimeMillis - this.f89763d));
            }
            if (z16 && j3 == 0) {
                if (z17 && (obj2 instanceof FeedCloudRead$StGetFeedListRsp)) {
                    QFSTabRequestSender.this.r(j3, str, obj, obj2, this.f89764e);
                    return;
                }
                return;
            }
            QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest = (QCircleTabGetFeedListRequest) obj;
            boolean b16 = this.f89764e.b();
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
            int type = QFSTabRequestSender.this.f89753c.G().getType();
            int i3 = this.f89764e.f89818i;
            QFSTabRequestSender.this.f89753c.a(UIStateData.obtainError(str).setRetCode(j3).setLoadMore(this.f89764e.b()));
            QLog.d(QFSTabRequestSender.this.n(), 1, "requestFeedsData onReceive: dispatch Error: Action:" + this.f89764e.f89810a + " | TraceId:" + qCircleTabGetFeedListRequest.getTraceId() + " | SeqId:" + qCircleTabGetFeedListRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isLoadMore:" + b16 + " | isCache:" + isProtocolCache + " | tabType:" + type + " | mRepository:" + QFSTabRequestSender.this.f89753c + " | pullSceneType:" + i3 + " | sourceType: " + qCircleTabGetFeedListRequest.getResponseSourceType());
        }
    }

    public QFSTabRequestSender(@NonNull String str, @NonNull l lVar) {
        this.f89751a = str;
        this.f89753c = lVar;
        this.f89752b = String.valueOf(lVar.G().getSource());
    }

    private void A(QFSTabFeedViewModel.c cVar, List<e30.b> list, Collection<e30.b> collection, boolean z16, boolean z17) {
        list.addAll(collection);
        cVar.f86642a.clear();
        cVar.f86642a.addAll(list);
        this.f89753c.c(cVar);
        this.f89753c.y(new ArrayList(collection));
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_folder_request_use_same_list", true)) {
            list = cVar.f86642a;
        }
        if (list.size() > 0) {
            if (!z16) {
                w20.a.j().initOrUpdateGlobalState((List) list, true);
            }
            this.f89753c.a(UIStateData.obtainSuccess(z16).setData(z17, list).setFinish(cVar.f86645d));
            return;
        }
        this.f89753c.a(UIStateData.obtainEmpty().setLoadMore(z17).setFinish(cVar.f86645d));
    }

    private boolean B(@NonNull QFSTabFeedViewModel.c cVar, e30.b bVar, List<e30.b> list, Collection<e30.b> collection) {
        return y(cVar, l(bVar, new ArrayList(list), collection));
    }

    private void C(boolean z16, boolean z17) {
        String str;
        String str2;
        if (z17) {
            return;
        }
        if (z16) {
            str = QCirclePeriodCollect.PERIOD_GET_PAGE_CACHE_RSP;
            str2 = "4";
        } else {
            str = QCirclePeriodCollect.PERIOD_GET_PAGE_NET_RSP;
            str2 = "3";
        }
        QCirclePeriodCollect.record(this.f89752b, str);
        QCirclePeriodCollect.setState(this.f89752b, str2);
    }

    private void D(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        boolean v3 = gb0.b.v(feedCloudMeta$StFeed);
        String str = feedCloudMeta$StFeed.video.fileId.get();
        if (PreLoader.exists(str) && RFWPlayerPreRenderHelper.getInstance().isPreRender(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            v3 = true;
        }
        QCircleFolderFunnelCollect.recordVideoPreloadInfo(v3, z16);
    }

    private void E(@NonNull m.a aVar, boolean z16) {
        if (this.f89752b.equals(String.valueOf(10)) && !z16) {
            cc0.e.f30630e = System.currentTimeMillis();
            QLog.d(n(), 1, "resetRerankStatus sPageRefreshToken:" + cc0.e.f30630e);
        }
    }

    private void G(m.a aVar, QFSTabFeedViewModel.c cVar, Call.OnRspCallBack onRspCallBack) {
        String str;
        FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2;
        QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest;
        boolean z16 = cVar.f86650i;
        QLog.d(n(), 1, "sendRequestBySender isLoadMore:" + aVar.b() + ",isOneFeedDiskCacheScreen:" + z16);
        boolean b16 = aVar.b();
        if (z16 && k30.n.d()) {
            QLog.d(n(), 1, "sendRequestBySender isLoadMore change to false\uff1bneed send refresh request");
            b16 = false;
        }
        QCirclePeriodCollect.record(this.f89752b, QCirclePeriodCollect.PERIOD_REQUEST_PAGE_BY_NET);
        QCircleTabInfo G = this.f89753c.G();
        QCircleTabGetFeedListRequest.b p16 = new QCircleTabGetFeedListRequest.b().p(G);
        String str2 = null;
        if (b16) {
            str = cVar.f86644c;
        } else {
            str = null;
        }
        QCircleTabGetFeedListRequest.b h16 = p16.h(str);
        if (!b16) {
            str2 = cVar.f86643b;
        }
        QCircleTabGetFeedListRequest.b m3 = h16.m(str2);
        if (uq3.o.i()) {
            feedCloudMeta$StGPSV2 = com.tencent.biz.qqcircle.c.e().d();
        } else {
            feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
        }
        QCircleTabGetFeedListRequest.b k3 = m3.j(feedCloudMeta$StGPSV2).l(aVar.f89818i).i(aVar.f89820k).n(aVar.f89821l).k(aVar.b());
        int type = G.getType();
        if (type == 9) {
            qCircleTabGetFeedListRequest = new QFSGetFriendFeedListRequest(k3);
        } else if (type != 12 && type != 13) {
            qCircleTabGetFeedListRequest = new QCircleTabGetFeedListRequest(k3);
        } else {
            k3.o(G.getContentPoolId());
            QFSGetFeedListByPoolIDRequest qFSGetFeedListByPoolIDRequest = new QFSGetFeedListByPoolIDRequest(k3);
            qFSGetFeedListByPoolIDRequest.mRequest.extInfo.mapInfo.addAll(G.getExtInfo());
            qCircleTabGetFeedListRequest = qFSGetFeedListByPoolIDRequest;
        }
        qCircleTabGetFeedListRequest.setRetryCount(1);
        List<FeedCloudCommon$Entry> list = qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.get();
        qCircleTabGetFeedListRequest.mRequest.extInfo.set(this.f89753c.o(!b16));
        Q(qCircleTabGetFeedListRequest);
        S(qCircleTabGetFeedListRequest);
        qCircleTabGetFeedListRequest.setEnableCache(aVar.f89812c);
        qCircleTabGetFeedListRequest.mRequest.extInfo.setHasFlag(true);
        if (list.size() != 0) {
            qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.addAll(list);
        }
        qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
        qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.add(r.H());
        qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.add(m());
        J(aVar.f89820k, qCircleTabGetFeedListRequest);
        R(aVar, qCircleTabGetFeedListRequest);
        L(aVar, qCircleTabGetFeedListRequest);
        P(qCircleTabGetFeedListRequest);
        N(aVar, qCircleTabGetFeedListRequest, cVar);
        M(aVar, qCircleTabGetFeedListRequest);
        K(qCircleTabGetFeedListRequest, cVar);
        E(aVar, b16);
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().h(false).addExtraData(p(aVar.f89818i, b16)).addRspInterceptor(new eb0.b()).addRequest(qCircleTabGetFeedListRequest).m250setRspOnCallBack(onRspCallBack).execute();
        com.tencent.biz.qqcircle.immersive.manager.j.h().k(qCircleTabGetFeedListRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        l lVar = this.f89753c;
        if (lVar != null) {
            lVar.D(System.currentTimeMillis());
        }
    }

    private void J(QCircleFolderBean qCircleFolderBean, QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest) {
        if (qCircleFolderBean != null && qCircleFolderBean.getSchemeAttrs() != null && qCircleFolderBean.getSchemeAttrs().size() != 0) {
            String str = qCircleFolderBean.getSchemeAttrs().get("trace_id");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("qq_trace_id");
            feedCloudCommon$Entry.value.set(str);
            qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
        }
    }

    private void K(QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest, @NonNull QFSTabFeedViewModel.c cVar) {
        if (uq3.c.B() && bc0.a.g().c() && this.f89752b.equals(String.valueOf(10))) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("get_ads_cache");
            feedCloudCommon$Entry.value.set("1");
            qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
            FeedCloudMeta$AdvertClientInfo d16 = bc0.a.g().d(cVar.c());
            if (d16 != null) {
                qCircleTabGetFeedListRequest.mRequest.extInfo.recomNeedInfo.unreadAdsInfo.set(ByteStringMicro.copyFrom(d16.toByteArray()));
            }
            bc0.a.g().b();
        }
    }

    private void L(@NonNull m.a aVar, QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest) {
        String str;
        if (aVar.f89817h) {
            str = "1";
        } else {
            str = "0";
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("refresh_type");
        feedCloudCommon$Entry.value.set(str);
        qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
    }

    private void M(@NonNull m.a aVar, @NonNull QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest) {
        if (TextUtils.equals(aVar.f89810a, "pre_pull")) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("per_pull_flag");
            feedCloudCommon$Entry.value.set("1");
            qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
        }
    }

    private void N(@NonNull m.a aVar, QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest, QFSTabFeedViewModel.c cVar) {
        if (!this.f89752b.equals(String.valueOf(10))) {
            return;
        }
        qCircleTabGetFeedListRequest.mRequest.extInfo.recomNeedInfo.setHasFlag(true);
        O(qCircleTabGetFeedListRequest, cVar);
        T(aVar, qCircleTabGetFeedListRequest, cVar);
    }

    private void O(QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest, @NonNull QFSTabFeedViewModel.c cVar) {
        List<FeedCloudMeta$StFeed> curNormalPreloadFeeds = QCircleColdBootPreloadFeedManagerV2.getInstance().getCurNormalPreloadFeeds();
        if (curNormalPreloadFeeds != null) {
            QLog.d(n(), 1, "wrapPreloadFeedsInfo before filter size:", Integer.valueOf(curNormalPreloadFeeds.size()));
            Iterator<e30.b> it = cVar.c().iterator();
            while (it.hasNext()) {
                curNormalPreloadFeeds.remove(it.next().g());
            }
            QLog.d(n(), 1, "wrapPreloadFeedsInfo after filter size:", Integer.valueOf(curNormalPreloadFeeds.size()));
            qCircleTabGetFeedListRequest.mRequest.extInfo.recomNeedInfo.preloadFeeds.set(e30.d.c(curNormalPreloadFeeds));
        }
    }

    private void P(QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest) {
        RecExptInfo k3;
        if (this.f89752b.equals(String.valueOf(10)) && (k3 = QCirclePluginGlobalInfo.k()) != null && !TextUtils.isEmpty(k3.exptConfig)) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("expermodel");
            feedCloudCommon$Entry.value.set(k3.jsonString);
            qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
            QLog.d(n(), 1, "wrapRecExptConfig done,config:", k3.exptConfig);
        }
    }

    private void Q(@NonNull QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest) {
        byte[] s16 = this.f89753c.s();
        if (s16 != null && s16.length > 0) {
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry.key.set("common_reddot_trans");
            feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(s16));
            qCircleTabGetFeedListRequest.mRequest.extInfo.mapBytesInfo.add(feedCloudCommon$BytesEntry);
            QLog.d(n(), 1, "do wrapRedPointTrans");
        }
    }

    private void R(m.a aVar, @NonNull QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest) {
        QCircleFolderBean qCircleFolderBean;
        if (this.f89752b.equals(String.valueOf(10)) && aVar.f89810a.equals("init") && (qCircleFolderBean = aVar.f89820k) != null && qCircleFolderBean.getSchemeJumpInfo() != null) {
            FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
            feedCloudCommon$BytesEntry.key.set("schemejump");
            feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(aVar.f89820k.getSchemeJumpInfo()));
            qCircleTabGetFeedListRequest.mRequest.extInfo.mapBytesInfo.add(feedCloudCommon$BytesEntry);
            QLog.d(n(), 1, "wrapSchemeJumpInfo done");
        }
    }

    private void S(@NonNull QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest) {
        QLog.d(n(), 1, "do wrapTransMapInfo");
        PBRepeatMessageField<FeedCloudCommon$Entry> p16 = this.f89753c.p();
        if (p16 != null) {
            qCircleTabGetFeedListRequest.mRequest.extInfo.mapInfo.addAll(p16.get());
        }
    }

    private void T(@NonNull m.a aVar, QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest, @NonNull QFSTabFeedViewModel.c cVar) {
        List<FeedCloudCommon$RecomReed> list;
        List<FeedCloudCommon$RecomReed> arrayList = new ArrayList<>();
        if (aVar.f89810a.equals("refresh")) {
            list = q(cVar);
        } else {
            if (aVar.f89817h) {
                arrayList = q(cVar);
            }
            List<FeedCloudCommon$RecomReed> k3 = this.f89753c.k();
            if (k3 != null) {
                arrayList.addAll(k3);
            }
            list = arrayList;
        }
        QLog.d(n(), 1, "wrapUnexposedFeedsInfo size:", Integer.valueOf(list.size()));
        qCircleTabGetFeedListRequest.mRequest.extInfo.recomNeedInfo.unableExpoFeeds.set(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<FeedCloudMeta$StFeed> list, String str) {
        for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
            ba.a(feedCloudMeta$StFeed, str);
            QFSAuthorUinMonitorManager.getInstance().addTraceId(feedCloudMeta$StFeed.f398449id.get(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(m.a aVar, Call.OnRspCallBack onRspCallBack) {
        QFSTabFeedViewModel.c cVar;
        if (this.f89753c.d().getValue() != null) {
            cVar = this.f89753c.d().getValue();
        } else {
            cVar = new QFSTabFeedViewModel.c();
        }
        G(aVar, cVar, onRspCallBack);
    }

    private void k(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (feedCloudRead$StGetFeedListRsp == null) {
            return;
        }
        try {
            long parseLong = Long.parseLong(fb0.b.c(feedCloudRead$StGetFeedListRsp.extInfo.mapInfo, "KEY_RSP_TIME", "0"));
            l lVar = this.f89753c;
            if (lVar != null) {
                lVar.A(parseLong);
            }
            QCircleFolderFunnelCollect.record(QCircleFolderFunnelCollect.PERIOD_PRE_LOAD_FEED_RECEIVE, parseLong);
        } catch (Exception e16) {
            QLog.e(n(), 1, "requestFeedsData preloadRspTime convert error:" + e16);
        }
    }

    private List<e30.b> l(@NonNull e30.b bVar, @NonNull List<e30.b> list, @NonNull Collection<e30.b> collection) {
        List<e30.b> m3 = this.f89753c.m(list);
        if (m3 == null) {
            QLog.e(n(), 1, "getRealInsertExecutedOutput error,remain feeds is null!");
            return null;
        }
        if (list.removeAll(m3)) {
            QLog.d(n(), 1, "getRealInsertExecutedOutput left unexposed feed size:", Integer.valueOf(list.size()));
            if (collection.remove(bVar)) {
                m3.add(bVar);
                m3.addAll(list);
                m3.addAll(collection);
                QLog.d(n(), 1, "filter pre insert feeds,filter feed size:", Integer.valueOf(collection.size()), ",output size:", Integer.valueOf(m3.size()));
                return m3;
            }
        }
        return null;
    }

    private FeedCloudCommon$Entry m() {
        String d16 = wa0.c.f().d();
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("AlgId");
        feedCloudCommon$Entry.value.set(d16);
        QLog.d(n(), 1, "getAlgIdEntry:" + d16);
        return feedCloudCommon$Entry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        return this.f89751a + "_QFSTabRequestSender";
    }

    private e30.b o(@NonNull Collection<e30.b> collection) {
        for (e30.b bVar : collection) {
            if (bVar != null && bVar.g() != null && bVar.g().recomInfo.reorderType.get() == 1) {
                return bVar;
            }
        }
        return null;
    }

    @NonNull
    private List<FeedCloudCommon$RecomReed> q(@NonNull QFSTabFeedViewModel.c cVar) {
        ArrayList arrayList = new ArrayList();
        l lVar = this.f89753c;
        if (lVar == null) {
            return arrayList;
        }
        List<FeedCloudMeta$StFeed> r16 = lVar.r(cVar.c());
        if (r16 != null) {
            arrayList.addAll(e30.d.c(r16));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final long j3, final String str, Object obj, Object obj2, @NonNull final m.a aVar) {
        QFSTabFeedViewModel.c cVar;
        final QCircleTabGetFeedListRequest qCircleTabGetFeedListRequest = (QCircleTabGetFeedListRequest) obj;
        final FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = (FeedCloudRead$StGetFeedListRsp) obj2;
        final boolean b16 = aVar.b();
        final boolean isProtocolCache = VSNetworkHelper.isProtocolCache(str);
        final int type = this.f89753c.G().getType();
        final int contentPoolId = this.f89753c.G().getContentPoolId();
        final int i3 = aVar.f89818i;
        C(isProtocolCache, b16);
        if (this.f89753c.d().getValue() != null) {
            cVar = this.f89753c.d().getValue();
        } else {
            cVar = new QFSTabFeedViewModel.c();
        }
        final QFSTabFeedViewModel.c cVar2 = cVar;
        if (t(aVar, cVar2, isProtocolCache)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.QFSTabRequestSender.3
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(QFSTabRequestSender.this.n(), 1, "requestFeedsData onReceive: dispatch Success: Action:" + aVar.f89810a + " | TraceId:" + qCircleTabGetFeedListRequest.getTraceId() + " | SeqId:" + qCircleTabGetFeedListRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str + " | isLoadMore:" + b16 + " | isCache:" + isProtocolCache + " | tabType:" + type + " | contentPoolId:" + contentPoolId + " | pullSceneType:" + i3 + " | isSilenceInsertModel:" + aVar.f89817h);
                QFSTabFeedViewModel.c cVar3 = new QFSTabFeedViewModel.c();
                QFSTabRequestSender.this.f89753c.C(null);
                QFSTabRequestSender.this.f89753c.B(null);
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(feedCloudRead$StGetFeedListRsp.vecFeed.get());
                QFSFeedRspProcessUtils.n(cVar2, b16);
                QFSFeedRspProcessUtils.f(cVar3, feedCloudRead$StGetFeedListRsp);
                QFSFeedRspProcessUtils.h(cVar3, feedCloudRead$StGetFeedListRsp);
                QFSFeedRspProcessUtils.j(cVar3, feedCloudRead$StGetFeedListRsp);
                QFSFeedRspProcessUtils.m(cVar3, feedCloudRead$StGetFeedListRsp);
                QFSFeedRspProcessUtils.g(cVar3, copyOnWriteArrayList, aVar.b());
                QFSFeedRspProcessUtils.i(feedCloudRead$StGetFeedListRsp);
                QFSTabRequestSender.this.I();
                QFSTabRequestSender.this.i(copyOnWriteArrayList, qCircleTabGetFeedListRequest.getTraceId());
                QFSTabRequestSender.this.w(copyOnWriteArrayList);
                QFSTabRequestSender.this.x(cVar3, copyOnWriteArrayList, b16, isProtocolCache, aVar);
                com.tencent.biz.qqcircle.immersive.utils.d.f90201a.l(qCircleTabGetFeedListRequest.getTraceId());
            }
        };
        if (z20.h.b()) {
            RFWThreadManager.getInstance().execOnSubThread(runnable);
        } else {
            RFWThreadManager.getInstance().execOnNetThread(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(List list, boolean z16, boolean z17, m.a aVar, QFSTabFeedViewModel.c cVar) {
        int i3;
        int i16;
        long currentTimeMillis = System.currentTimeMillis();
        QFSTabFeedViewModel.c value = this.f89753c.d().getValue();
        if (value == null) {
            value = new QFSTabFeedViewModel.c();
        }
        List<e30.b> synchronizedList = Collections.synchronizedList(new ArrayList(value.f86642a));
        Collection<e30.b> b16 = y.b(synchronizedList, list);
        boolean z18 = false;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        if (b16 != null) {
            i16 = b16.size();
        } else {
            i16 = 0;
        }
        QLog.d(n(), 1, "postFeedData respOriginSize size\uff1a" + i3 + ",respFilterSize size:" + i16 + ",curFeeds:" + synchronizedList.size());
        if (b16 == null) {
            QLog.w(n(), 1, "postFeedData filteredRspFeeds=null");
            return;
        }
        e30.b o16 = o(b16);
        if (z16 && !z17 && o16 != null) {
            z18 = true;
        }
        if (aVar.f89817h && aVar.b()) {
            z(cVar, synchronizedList, b16);
            return;
        }
        if (z18 && B(cVar, o16, synchronizedList, b16)) {
            QLog.d(n(), 1, "postRealInsertFeedData");
            return;
        }
        A(cVar, synchronizedList, b16, z17, z16);
        long currentTimeMillis2 = System.currentTimeMillis();
        QLog.d(n(), 1, "postNormalFeedData cost:" + (currentTimeMillis2 - currentTimeMillis));
    }

    private Call.OnRspCallBack v(@NonNull m.a aVar) {
        a aVar2 = new a(System.currentTimeMillis(), aVar);
        this.f89754d = aVar2;
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(List<FeedCloudMeta$StFeed> list) {
        if (uq3.c.B() && bc0.a.g().c() && this.f89752b.equals(String.valueOf(10)) && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = list.get(i3);
                if (feedCloudMeta$StFeed.iscachedAdsFeeds.get()) {
                    arrayList.add(feedCloudMeta$StFeed);
                    list.remove(feedCloudMeta$StFeed);
                }
            }
            bc0.a.g().a(arrayList);
        }
    }

    private boolean y(@NonNull QFSTabFeedViewModel.c cVar, List<e30.b> list) {
        if (list == null) {
            return false;
        }
        QLog.d(n(), 1, "postFeedDataByModify");
        cVar.f86642a.clear();
        cVar.f86642a.addAll(list);
        this.f89753c.c(cVar);
        if (list.size() > 0) {
            w20.a.j().initOrUpdateGlobalState((List) list, true);
            this.f89753c.a(UIStateData.obtainModify().setDataList(cVar.f86642a).setFinish(cVar.f86645d));
        }
        return true;
    }

    private void z(@NonNull QFSTabFeedViewModel.c cVar, List<e30.b> list, Collection<e30.b> collection) {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            int min = Math.min(list.size(), this.f89753c.j().a() + 1);
            if (min > 0) {
                arrayList.addAll(list.subList(0, min));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        arrayList2.addAll(collection);
        QLog.d(n(), 1, "postHotspotFeedData dealWith SilenceInsertModel filteredRspFeeds size:" + collection.size() + ",remainsList size:" + arrayList.size());
        y(cVar, arrayList2);
    }

    public void F(m.a aVar) {
        H(aVar, v(aVar));
    }

    public void H(final m.a aVar, final Call.OnRspCallBack onRspCallBack) {
        boolean b16 = h20.c.b();
        QLog.d(n(), 1, "[sendRequestBySender] enableBuildRequestInSubThread:" + b16);
        if (b16) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.QFSTabRequestSender.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSTabRequestSender.this.j(aVar, onRspCallBack);
                }
            });
        } else {
            j(aVar, onRspCallBack);
        }
    }

    protected Bundle p(int i3, boolean z16) {
        int i16;
        QCircleTabInfo G = this.f89753c.G();
        Bundle bundle = new Bundle();
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo = G.mTab;
        if (qQCircleFeedBase$StTabInfo != null) {
            i16 = qQCircleFeedBase$StTabInfo.tabType.get();
        } else {
            i16 = -1;
        }
        bundle.putInt("extra_key_tab_type", i16);
        bundle.putInt("extra_key_pull_scene_type", i3);
        bundle.putBoolean("extra_key_is_load_more", z16);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public void s(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, @NonNull m.a aVar) {
        QFSTabFeedViewModel.c cVar;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(feedCloudRead$StGetFeedListRsp.vecFeed.get());
        if (this.f89753c.d().getValue() != null) {
            cVar = this.f89753c.d().getValue();
        } else {
            cVar = new QFSTabFeedViewModel.c();
        }
        QFSTabFeedViewModel.c cVar2 = new QFSTabFeedViewModel.c();
        int type = this.f89753c.G().getType();
        int i3 = aVar.f89818i;
        QLog.d(n(), 1, "requestFeedsData onReceive from Preload: dispatch Success: Action:" + aVar.f89810a + " | tabType:" + type + " | pullSceneType:" + i3);
        if (copyOnWriteArrayList.size() > 0) {
            D(copyOnWriteArrayList.get(0));
        }
        QCirclePeriodCollect.record(this.f89752b, QCirclePeriodCollect.PERIOD_GET_PAGE_NET_RSP);
        QCirclePeriodCollect.setState(this.f89752b, "1");
        k(feedCloudRead$StGetFeedListRsp);
        QFSFeedRspProcessUtils.n(cVar, false);
        QFSFeedRspProcessUtils.f(cVar2, feedCloudRead$StGetFeedListRsp);
        QFSFeedRspProcessUtils.h(cVar2, feedCloudRead$StGetFeedListRsp);
        QFSFeedRspProcessUtils.j(cVar2, feedCloudRead$StGetFeedListRsp);
        QFSFeedRspProcessUtils.m(cVar2, feedCloudRead$StGetFeedListRsp);
        QFSFeedRspProcessUtils.g(cVar2, copyOnWriteArrayList, aVar.b());
        x(cVar2, copyOnWriteArrayList, false, false, aVar);
    }

    protected boolean t(m.a aVar, @NonNull QFSTabFeedViewModel.c cVar, boolean z16) {
        if (z16) {
            if (cVar.f86642a.size() > 0 || "refresh".equals(aVar.f89810a) || "load_more".equals(aVar.f89810a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    void x(final QFSTabFeedViewModel.c cVar, List<FeedCloudMeta$StFeed> list, final boolean z16, final boolean z17, @NonNull final m.a aVar) {
        final List<e30.b> c16 = QFSFeedRspProcessUtils.c(list, z17);
        y.l(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.repository.foldertab.o
            @Override // java.lang.Runnable
            public final void run() {
                QFSTabRequestSender.this.u(c16, z16, z17, aVar, cVar);
            }
        });
    }
}
