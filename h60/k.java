package h60;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.adapter.an;
import com.tencent.biz.qqcircle.adapter.aq;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchFilterActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.search.viewmodel.QFSSearchViewModel;
import com.tencent.biz.qqcircle.immersive.views.search.QFSSearchMixTabBlockContainer;
import com.tencent.biz.qqcircle.immersive.views.search.event.QFSSearchCheckPlayEvent;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.qqcircle.immersive.views.search.util.l;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.extendsblock.SingleViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StCorrectionInfo;
import feedcloud.FeedCloudRead$StGetSearchPageRsp;
import feedcloud.FeedCloudRead$StSearchBannerInfo;
import feedcloud.FeedCloudRead$StSearchGame;
import feedcloud.FeedCloudRead$StSearchGameCollection;
import feedcloud.FeedCloudRead$StSearchGameDesc;
import feedcloud.FeedCloudRead$StSearchHotEventInfo;
import feedcloud.FeedCloudRead$StSearchKuikly;
import feedcloud.FeedCloudRead$StSearchMiniApp;
import feedcloud.FeedCloudRead$StSearchMixPageTagInfo;
import feedcloud.FeedCloudRead$StSearchMixPageUserInfo;
import feedcloud.FeedCloudRead$StSearchMixTag;
import feedcloud.FeedCloudRead$StSearchPublisher;
import feedcloud.FeedCloudRead$StSearchRelatedGoods;
import feedcloud.FeedCloudRead$StSearchSubTag;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k extends e80.i implements SimpleEventReceiver {
    private p70.i F;
    private String G;
    private View H;
    l I;
    private final x90.a J;
    private final an K;
    private final aq L;
    private final v80.c M;
    private final u90.a N;
    private final t90.a P;
    private final u90.b Q;
    private final y90.a R;
    private final v90.a S;
    private final e90.b T;
    private final k90.b U;
    private final w90.a V;
    private final z80.c W;
    private final p80.a X;
    private final q90.a Y;
    private t30.f Z;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements OnTaskListener<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<p70.i> f404442a;

        public b(p70.i iVar) {
            this.f404442a = new WeakReference<>(iVar);
        }

        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
        public void onComplete(Object... objArr) {
            p70.i iVar;
            if (objArr != null && objArr.length == 5 && (iVar = this.f404442a.get()) != null) {
                iVar.o2(((Boolean) objArr[0]).booleanValue(), ((Long) objArr[1]).longValue(), (String) objArr[2], (FeedCloudRead$StGetSearchPageRsp) objArr[3], ((Boolean) objArr[4]).booleanValue());
            }
        }
    }

    public k() {
        super(R.id.f52532a2, null, 1, 1);
        this.I = new l();
        x90.a aVar = new x90.a(null);
        this.J = aVar;
        an anVar = new an(null);
        this.K = anVar;
        aq aqVar = new aq(null);
        this.L = aqVar;
        v80.c cVar = new v80.c(null);
        this.M = cVar;
        u90.a aVar2 = new u90.a(null);
        this.N = aVar2;
        t90.a aVar3 = new t90.a(null);
        this.P = aVar3;
        u90.b bVar = new u90.b(null);
        this.Q = bVar;
        y90.a aVar4 = new y90.a(null);
        this.R = aVar4;
        v90.a aVar5 = new v90.a(null);
        this.S = aVar5;
        e90.b bVar2 = new e90.b(null);
        this.T = bVar2;
        k90.b bVar3 = new k90.b(null);
        this.U = bVar3;
        w90.a aVar6 = new w90.a(null);
        this.V = aVar6;
        z80.c cVar2 = new z80.c(null);
        this.W = cVar2;
        p80.a aVar7 = new p80.a();
        this.X = aVar7;
        q90.a aVar8 = new q90.a(null);
        this.Y = aVar8;
        this.mPeerBlocks.add(aVar3);
        this.mPeerBlocks.add(aVar);
        this.mPeerBlocks.add(aVar8);
        this.mPeerBlocks.add(anVar);
        this.mPeerBlocks.add(aqVar);
        this.mPeerBlocks.add(cVar);
        this.mPeerBlocks.add(bVar);
        this.mPeerBlocks.add(aVar2);
        this.mPeerBlocks.add(aVar4);
        this.mPeerBlocks.add(aVar5);
        this.mPeerBlocks.add(bVar2);
        this.mPeerBlocks.add(bVar3);
        this.mPeerBlocks.add(cVar2);
        this.mPeerBlocks.add(aVar6);
        this.mPeerBlocks.add(aVar7);
        initListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Aa(UIStateData uIStateData) {
        QLog.d("QFSSearchResultPart", 1, "[handleHotRankResult] has hot rank block feed");
        if (uIStateData != null) {
            this.F.J2((List) uIStateData.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba() {
        if (this.W.j0() != null) {
            this.W.j0().observe(getHostFragment(), new Observer() { // from class: h60.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    k.this.Aa((UIStateData) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ca(LoadInfo loadInfo, Object obj) {
        List<FeedCloudCommon$Entry> g16;
        if (this.F == null) {
            return;
        }
        String c16 = p.c(this.f407299i, this.G);
        QFSSearchInfo qFSSearchInfo = this.f407300m;
        if (qFSSearchInfo == null) {
            g16 = null;
        } else {
            g16 = qFSSearchInfo.g();
        }
        if (loadInfo.isLoadMoreState()) {
            Ka();
            this.I.e(true);
            this.F.C2(c16, this.I, g16);
        } else if (loadInfo.isRefreshState()) {
            Ka();
            this.I.e(false);
            this.F.C2(c16, this.I, g16);
        }
    }

    private void Da(String str) {
        List<FeedCloudCommon$Entry> g16;
        Ka();
        this.I.e(false);
        QFSSearchInfo qFSSearchInfo = this.f407300m;
        if (qFSSearchInfo == null) {
            g16 = null;
        } else {
            g16 = qFSSearchInfo.g();
        }
        if (!TextUtils.isEmpty(this.G)) {
            this.I.g(false);
            this.F.C2(str, this.I, g16);
            com.tencent.biz.qqcircle.manager.k.d().a(str);
        } else {
            this.F.C2(this.f407299i, this.I, g16);
            com.tencent.biz.qqcircle.manager.k.d().a(this.f407299i);
        }
    }

    private void Ea(boolean z16) {
        QFSSearchViewModel qFSSearchViewModel = (QFSSearchViewModel) QCirclePluginUtil.getQCircleBaseFragment(getContext()).getViewModel(QFSSearchViewModel.class);
        if (qFSSearchViewModel != null) {
            qFSSearchViewModel.E.b(z16, QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE);
        }
    }

    private boolean Ia(boolean z16) {
        QFSSearchInfo qFSSearchInfo;
        if ((this.G != null || ((qFSSearchInfo = this.f407300m) != null && qFSSearchInfo.e() == 23)) && !z16 && this.H != null) {
            return true;
        }
        return false;
    }

    private void Ja(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        this.K.i0(false);
        this.M.i0(false);
        if (uIStateData.getData().searchGameCollection.get().has()) {
            this.K.i0(true);
        }
        FeedCloudRead$StSearchBannerInfo feedCloudRead$StSearchBannerInfo = uIStateData.getData().bannerInfo.get();
        if (feedCloudRead$StSearchBannerInfo.has() && !feedCloudRead$StSearchBannerInfo.banners.isEmpty()) {
            this.M.i0(true);
        }
    }

    private void Ka() {
        p70.i iVar;
        QFSSearchInfo qFSSearchInfo = this.f407300m;
        if (qFSSearchInfo != null && (iVar = this.F) != null) {
            iVar.H2(qFSSearchInfo.e());
        }
    }

    private void La(UIStateData<List<e30.b>> uIStateData) {
        if (this.F != null && !uIStateData.getIsLoadMore()) {
            this.F.F2(false);
            this.F.I2(System.currentTimeMillis());
        }
    }

    @Deprecated
    private boolean M9(List<FeedCloudMeta$StFeed> list, List<FeedCloudMeta$StFeed> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!Objects.equals(list.get(i3).f398449id.get(), list2.get(i3).f398449id.get())) {
                return false;
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSSearchCheckPlayEvent());
        return true;
    }

    private static List<FeedCloudMeta$StFeed> N9(List<e30.b> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (e30.b bVar : list) {
            FeedCloudMeta$StFeed g16 = bVar.g();
            if (p.w(g16)) {
                g16 = u.c(bVar);
            }
            arrayList.add(g16);
        }
        return arrayList;
    }

    private void O9(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, str);
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_USER_SOURCE, Integer.valueOf(p.s(getContext())));
        QFSSearchInfo qFSSearchInfo = this.f407300m;
        if (qFSSearchInfo != null) {
            hashMap.put("xsj_query_text", qFSSearchInfo.f());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_QUERY_SOURCE, Integer.valueOf(this.f407300m.e()));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.SEARCH_QUERY_ID, this.f407300m.c());
        }
        this.H = getHostFragment().getView();
        ua0.i.i(getActivity(), this.H, QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE, hashMap);
    }

    private void P9(String str, boolean z16) {
        if (Ia(z16)) {
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: h60.f
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.xa();
                }
            });
            QFSSearchInfo qFSSearchInfo = this.f407300m;
            if (qFSSearchInfo != null) {
                VideoReport.setPageParams(this.H, QCircleDaTongConstant.ElementParamKey.XSJ_QUERY_SOURCE, Integer.valueOf(qFSSearchInfo.e()));
            }
            if (str != null) {
                VideoReport.setPageParams(this.H, QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, str);
            }
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: h60.g
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.za();
                }
            });
        }
    }

    private List<FeedCloudMeta$StFeed> Q9() {
        if (this.W.getDataList() != null && !this.W.getDataList().isEmpty() && (this.W.getDataList().get(0) instanceof FeedCloudRead$StSearchHotEventInfo)) {
            return ((FeedCloudRead$StSearchHotEventInfo) this.W.getDataList().get(0)).feedList.get();
        }
        return null;
    }

    private List<FeedCloudMeta$StFeed> R9() {
        if (this.T.getDataList() != null && !this.T.getDataList().isEmpty() && (this.T.getDataList().get(0) instanceof FeedCloudRead$StSearchMixPageTagInfo)) {
            return ((FeedCloudRead$StSearchMixPageTagInfo) this.T.getDataList().get(0)).feeds.get();
        }
        return null;
    }

    private List<FeedCloudMeta$StFeed> S9() {
        if (this.U.getDataList() != null && !this.U.getDataList().isEmpty() && (this.U.getDataList().get(0) instanceof FeedCloudRead$StSearchMixPageUserInfo)) {
            return ((FeedCloudRead$StSearchMixPageUserInfo) this.U.getDataList().get(0)).feeds.get();
        }
        return null;
    }

    private String T9(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        if (uIStateData.getData() != null && uIStateData.getData().searchReportData != null) {
            return uIStateData.getData().searchReportData.get();
        }
        return "";
    }

    private void U9(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchKuikly feedCloudRead$StSearchKuikly = uIStateData.getData().searchKuikly.get();
        if (TextUtils.isEmpty(feedCloudRead$StSearchKuikly.page_name.get())) {
            RFWLog.d("QFSSearchResultPart", RFWLog.USR, "handleActivityBlock pageName is null");
            this.P.setBlockVisible(false);
            return;
        }
        p70.i iVar = this.F;
        if (iVar != null) {
            this.P.i0(iVar.e2());
        }
        this.P.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchKuikly);
        this.P.setDatas(arrayList);
    }

    private void V9(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchBannerInfo feedCloudRead$StSearchBannerInfo = uIStateData.getData().bannerInfo.get();
        if (feedCloudRead$StSearchBannerInfo.banners.isEmpty()) {
            this.K.setBlockVisible(false);
            return;
        }
        this.K.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchBannerInfo);
        this.K.setDatas(arrayList);
    }

    private void W9(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        QLog.w("QFSSearchResultPart", 1, "handleEmptyRsp() return empty data");
        if (uIStateData.getIsLoadMore()) {
            this.X.notifyLoadingComplete(true);
        } else {
            u1();
        }
    }

    private void X9(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        String msg2 = uIStateData.getMsg();
        if (TextUtils.isEmpty(msg2)) {
            msg2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8);
        }
        QLog.w("QFSSearchResultPart", 1, "handleErrorRsp() return error\uff01code:" + uIStateData.getRetCode() + " errMsg:" + msg2);
        if (uIStateData.getIsLoadMore()) {
            QCircleToast.o(msg2, 0);
            this.X.notifyLoadingComplete(true);
        } else {
            S2(msg2, uIStateData.getRetCode());
        }
    }

    private void Y9(UIStateData<List<e30.b>> uIStateData) {
        List<e30.b> data = uIStateData.getData();
        if (data == null) {
            data = new ArrayList<>();
        }
        this.X.setDatas(data);
    }

    private void Z9(UIStateData<List<e30.b>> uIStateData) {
        QFSSearchPrerenderManager.E(getContext()).b("feed", N9(uIStateData.getData()));
        this.X.setDatas(uIStateData.getData());
        this.X.getLoadInfo().setFinish(uIStateData.getIsFinish());
        this.X.notifyLoadingComplete(true);
        B9();
    }

    private void aa(QFSSearchFilterActionEvent qFSSearchFilterActionEvent) {
        p70.i iVar;
        if (p.u(getContext(), qFSSearchFilterActionEvent.getContextHashCode()) && (iVar = this.F) != null) {
            iVar.E2(qFSSearchFilterActionEvent.getFilters());
            Fa();
            Da(p.c(this.f407299i, this.G));
            this.X.getLoadInfo().setFinish(false);
            this.X.notifyLoadingComplete(true);
            X6();
        }
    }

    private void ba(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchHotEventInfo feedCloudRead$StSearchHotEventInfo = uIStateData.getData().searchHotEventInfo.get();
        if (feedCloudRead$StSearchHotEventInfo.feedList.isEmpty()) {
            this.W.setBlockVisible(false);
            return;
        }
        this.W.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchHotEventInfo);
        if (!M9(Q9(), feedCloudRead$StSearchHotEventInfo.feedList.get())) {
            this.W.setDatas(arrayList);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: h60.i
            @Override // java.lang.Runnable
            public final void run() {
                k.this.Ba();
            }
        });
        QFSSearchPrerenderManager.E(getContext()).b("hotRank", feedCloudRead$StSearchHotEventInfo.feedList.get());
    }

    private void ca(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchMixPageTagInfo feedCloudRead$StSearchMixPageTagInfo = uIStateData.getData().mixPageTagInfo.get();
        if (feedCloudRead$StSearchMixPageTagInfo.feeds.isEmpty()) {
            this.T.setBlockVisible(false);
            return;
        }
        this.T.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchMixPageTagInfo);
        if (!M9(R9(), feedCloudRead$StSearchMixPageTagInfo.feeds.get())) {
            this.T.setDatas(arrayList);
        }
        QFSSearchPrerenderManager.E(getContext()).b("mixTag", feedCloudRead$StSearchMixPageTagInfo.feeds.get());
    }

    private void da(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchMixPageUserInfo feedCloudRead$StSearchMixPageUserInfo = uIStateData.getData().mixPageUserInfo.get();
        if (feedCloudRead$StSearchMixPageUserInfo.feeds.isEmpty()) {
            this.U.setBlockVisible(false);
            return;
        }
        this.U.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchMixPageUserInfo);
        if (!M9(S9(), feedCloudRead$StSearchMixPageUserInfo.feeds.get())) {
            this.U.setDatas(arrayList);
        }
        QFSSearchPrerenderManager.E(getContext()).b("art", feedCloudRead$StSearchMixPageUserInfo.feeds.get());
    }

    private void ea(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchPublisher feedCloudRead$StSearchPublisher = uIStateData.getData().searchPublisherInfo.get();
        if (feedCloudRead$StSearchPublisher.items.get().isEmpty()) {
            this.V.setBlockVisible(false);
            return;
        }
        this.V.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchPublisher);
        this.V.setDatas(arrayList);
    }

    private void ga(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StCorrectionInfo feedCloudRead$StCorrectionInfo = uIStateData.getData().correction_info.get();
        if (feedCloudRead$StCorrectionInfo.has() && !TextUtils.isEmpty(feedCloudRead$StCorrectionInfo.correction_word.get())) {
            this.J.setBlockVisible(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedCloudRead$StCorrectionInfo);
            this.J.setDatas(arrayList);
            return;
        }
        this.J.setBlockVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(UIStateData<List<e30.b>> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        int state = uIStateData.getState();
        if (state != 2 && state != 3) {
            if (state == 7) {
                QLog.e("QFSSearchResultPart", 1, "handleModify");
                Y9(uIStateData);
                return;
            }
            return;
        }
        Z9(uIStateData);
        La(uIStateData);
    }

    private void ia(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchGameDesc feedCloudRead$StSearchGameDesc = uIStateData.getData().searchGameDesc.get();
        if (TextUtils.isEmpty(feedCloudRead$StSearchGameDesc.content.get())) {
            this.N.setBlockVisible(false);
            return;
        }
        this.N.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchGameDesc);
        this.N.setDatas(arrayList);
    }

    private void initListener() {
        this.J.setQueryFixClickListener(new com.tencent.biz.qqcircle.immersive.search.a() { // from class: h60.e
            @Override // com.tencent.biz.qqcircle.immersive.search.a
            public final void a(QFSSearchInfo qFSSearchInfo) {
                k.this.na(qFSSearchInfo);
            }
        });
    }

    private void ja(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchGame feedCloudRead$StSearchGame = uIStateData.getData().searchGameInfo.get();
        if (feedCloudRead$StSearchGame.items.get().isEmpty()) {
            this.Q.setBlockVisible(false);
            return;
        }
        this.Q.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchGame);
        this.Q.setDatas(arrayList);
    }

    private void la(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchGameCollection feedCloudRead$StSearchGameCollection = uIStateData.getData().searchGameCollection.get();
        if (!feedCloudRead$StSearchGameCollection.has()) {
            this.M.setBlockVisible(false);
            return;
        }
        this.M.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchGameCollection);
        this.M.setDatas(arrayList);
    }

    private void ma(Object obj) {
        if (!(obj instanceof QFSSearchInfo) || this.F == null) {
            return;
        }
        Fa();
        List<FeedCloudCommon$Entry> list = null;
        this.G = null;
        this.I.f(true);
        this.I.g(true);
        this.F.E2(null);
        QFSSearchInfo qFSSearchInfo = (QFSSearchInfo) obj;
        this.f407300m = qFSSearchInfo;
        p80.a aVar = this.X;
        if (aVar != null) {
            aVar.setCurrentSearchInfo(qFSSearchInfo);
        }
        this.J.setCurrentSearchInfo(this.f407300m);
        this.L.setCurrentSearchInfo(this.f407300m);
        this.f407299i = this.f407300m.f();
        QLog.i("QFSSearchResultPart", 1, "#handleSearchKeywordMessage: keyword=" + this.f407299i);
        O9("");
        if (PreLoader.exists("2018")) {
            PreLoader.addListener("2018", new b(this.F));
            this.F.G2(this.f407299i);
        } else {
            QFSSearchInfo qFSSearchInfo2 = this.f407300m;
            if (qFSSearchInfo2 != null) {
                int e16 = qFSSearchInfo2.e();
                this.F.H2(e16);
                if (p.x(e16)) {
                    this.I.f(false);
                }
            }
            this.I.e(false);
            QFSSearchInfo qFSSearchInfo3 = this.f407300m;
            if (qFSSearchInfo3 != null) {
                list = qFSSearchInfo3.g();
            }
            this.F.C2(this.f407299i, this.I, list);
        }
        X6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(QFSSearchInfo qFSSearchInfo) {
        String f16;
        List<FeedCloudCommon$Entry> g16;
        if (this.F == null) {
            return;
        }
        this.I.f(false);
        this.f407300m = qFSSearchInfo;
        if (qFSSearchInfo == null) {
            f16 = "";
        } else {
            f16 = qFSSearchInfo.f();
        }
        this.f407299i = f16;
        QFSSearchInfo qFSSearchInfo2 = this.f407300m;
        if (qFSSearchInfo2 != null) {
            this.F.H2(qFSSearchInfo2.e());
        }
        Ka();
        this.J.setCurrentSearchInfo(this.f407300m);
        QFSSearchInfo qFSSearchInfo3 = this.f407300m;
        if (qFSSearchInfo3 == null) {
            g16 = null;
        } else {
            g16 = qFSSearchInfo3.g();
        }
        this.F.C2(this.f407299i, this.I, g16);
        com.tencent.biz.qqcircle.manager.k.d().a(this.f407299i);
        A9(R.drawable.km5);
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(QFSSearchInfo qFSSearchInfo, String str) {
        String f16;
        if (this.F == null) {
            return;
        }
        this.f407300m = qFSSearchInfo;
        if (qFSSearchInfo == null) {
            f16 = "";
        } else {
            f16 = qFSSearchInfo.f();
        }
        this.f407299i = f16;
        this.G = str;
        QFSSearchInfo qFSSearchInfo2 = this.f407300m;
        if (qFSSearchInfo2 != null) {
            this.F.H2(qFSSearchInfo2.e());
        }
        Da(p.c(this.f407299i, str));
        A9(R.drawable.km5);
        NestScrollRecyclerView recyclerView = this.mBlockContainer.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    private void pa(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchMiniApp feedCloudRead$StSearchMiniApp = uIStateData.getData().searchMiniAppInfo.get();
        if (feedCloudRead$StSearchMiniApp.items.get().isEmpty()) {
            this.S.setBlockVisible(false);
            return;
        }
        this.S.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchMiniApp);
        this.S.setDatas(arrayList);
    }

    private void qa(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        if (wa() && !TextUtils.isEmpty(uIStateData.getData().videoCollection.collectionID.get())) {
            this.Y.i0(this.f407300m);
            this.Y.setBlockVisible(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(uIStateData.getData().videoCollection.get());
            this.Y.setDatas(arrayList);
        }
    }

    private void ra(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        FeedCloudRead$StSearchRelatedGoods feedCloudRead$StSearchRelatedGoods = uIStateData.getData().searchRelatedGoodsInfo.get();
        if (feedCloudRead$StSearchRelatedGoods.items.get().isEmpty()) {
            this.R.setBlockVisible(false);
            return;
        }
        this.R.setBlockVisible(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudRead$StSearchRelatedGoods);
        this.R.setDatas(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        boolean z16;
        if (uIStateData == null) {
            return;
        }
        P9(T9(uIStateData), uIStateData.getIsLoadMore());
        int state = uIStateData.getState();
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state == 4) {
                    X9(uIStateData);
                }
            } else {
                ua(uIStateData);
                z16 = true;
                Ea(z16);
            }
        } else {
            W9(uIStateData);
        }
        z16 = false;
        Ea(z16);
    }

    private void ta(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        List<FeedCloudRead$StSearchSubTag> list = uIStateData.getData().subTags.get();
        if (wa()) {
            ((QFSSearchMixTabBlockContainer) this.mBlockContainer).e(this.f407299i, list, this.G);
            ((QFSSearchMixTabBlockContainer) this.mBlockContainer).setSubTagClickListener(new com.tencent.biz.qqcircle.immersive.search.b() { // from class: h60.h
                @Override // com.tencent.biz.qqcircle.immersive.search.b
                public final void a(QFSSearchInfo qFSSearchInfo, String str) {
                    k.this.oa(qFSSearchInfo, str);
                }
            });
        }
    }

    private void ua(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        if (uIStateData.getData() == null) {
            QLog.e("QFSSearchResultPart", 1, "handleSuccessRsp data is null");
            W9(uIStateData);
        }
        QFSSearchPrerenderManager.E(getContext()).u();
        G4();
        if (!uIStateData.getIsLoadMore()) {
            O9(T9(uIStateData));
            VideoReport.traversePage(this.mBlockContainer);
        }
        Ja(uIStateData);
        ga(uIStateData);
        ta(uIStateData);
        ja(uIStateData);
        la(uIStateData);
        ia(uIStateData);
        U9(uIStateData);
        ra(uIStateData);
        pa(uIStateData);
        V9(uIStateData);
        ba(uIStateData);
        ca(uIStateData);
        da(uIStateData);
        ea(uIStateData);
        qa(uIStateData);
        va(uIStateData);
    }

    private void va(UIStateData<FeedCloudRead$StGetSearchPageRsp> uIStateData) {
        if (uIStateData != null && uIStateData.getData() != null) {
            FeedCloudRead$StSearchMixTag feedCloudRead$StSearchMixTag = uIStateData.getData().searchMixTag.get();
            if (TextUtils.isEmpty(feedCloudRead$StSearchMixTag.tagInfo.tagName.get())) {
                this.L.setBlockVisible(false);
                return;
            }
            this.L.setBlockVisible(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedCloudRead$StSearchMixTag);
            this.L.setDatas(arrayList);
            this.L.i0(T9(uIStateData));
            return;
        }
        this.L.setBlockVisible(false);
    }

    private boolean wa() {
        return this.mBlockContainer instanceof QFSSearchMixTabBlockContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xa() {
        VideoReport.reportPgOut(this.H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void za() {
        VideoReport.reportPgIn(this.H);
    }

    public void Fa() {
        Ga();
        x9();
        if (wa()) {
            ((QFSSearchMixTabBlockContainer) this.mBlockContainer).b();
        }
    }

    public void Ga() {
        Iterator<MultiViewBlock> it = this.mPeerBlocks.iterator();
        while (it.hasNext()) {
            MultiViewBlock next = it.next();
            if (next instanceof SingleViewBlock) {
                ((SingleViewBlock) next).setBlockVisible(false);
            } else {
                next.setDatas(Collections.emptyList());
            }
        }
    }

    public void Ha(i60.a aVar) {
        this.U.i0(aVar);
    }

    @Override // i60.d, i60.b
    public void S2(String str, long j3) {
        super.S2(str, j3);
        if (this.G != null) {
            Ga();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        arrayList.add(QFSSearchFilterActionEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchResultPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if ("qfs_search_action_with_keyword".equals(str)) {
            ma(obj);
        }
    }

    @Override // e80.i, i60.d, com.tencent.biz.qqcircle.immersive.part.QFSBaseBlockPart, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QFSSearchPrerenderManager.E(getContext()).c(getActivity());
        this.mBlockContainer.setEnableRefresh(true);
        this.mBlockContainer.setEnableLoadMore(true);
        this.mBlockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.mBlockContainer.setRefreshHeader(new RefreshHeaderView(getContext()));
        p70.i iVar = (p70.i) getViewModel(p70.i.class);
        this.F = iVar;
        iVar.O1(getContext());
        this.F.i2().observe(getHostFragment(), new Observer() { // from class: h60.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                k.this.sa((UIStateData) obj);
            }
        });
        this.F.h2().observe(getHostFragment(), new Observer() { // from class: h60.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                k.this.ha((UIStateData) obj);
            }
        });
        this.Z = new t30.f(getTAG(), t30.f.S1(this.X.getRecyclerView()), this.F.h2());
        String b26 = this.F.b2();
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.mGlobalViewModelKey = b26;
        w20.a.j().registerDisplaySurface(b26, this.F);
        qCircleExtraTypeInfo.pageType = 1;
        this.mBlockContainer.setExtraTypeInfo(qCircleExtraTypeInfo);
        if (wa()) {
            ((QFSSearchMixTabBlockContainer) this.mBlockContainer).setFragment(getHostFragment());
        }
        this.X.l0(qCircleExtraTypeInfo);
        this.X.addOnScrollListener(new a());
        this.X.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: h60.d
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                k.this.Ca(loadInfo, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // e80.i, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // e80.i, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.Z.onPause();
    }

    @Override // e80.i, com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        this.Z.onResume();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSearchFilterActionEvent) {
            aa((QFSSearchFilterActionEvent) simpleBaseEvent);
        }
    }

    @Override // i60.d, i60.b
    public void u1() {
        super.u1();
        z9(0, 0, 0, 0);
        if (this.G != null && wa()) {
            Ga();
            ((QFSSearchMixTabBlockContainer) this.mBlockContainer).d();
            z9(0, getContext().getResources().getDimensionPixelSize(R.dimen.c_a), 0, 0);
        }
    }
}
