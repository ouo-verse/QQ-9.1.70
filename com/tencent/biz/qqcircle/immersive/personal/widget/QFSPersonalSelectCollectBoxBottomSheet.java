package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.personal.adapter.n;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalCollectBoxEvent;
import com.tencent.biz.qqcircle.immersive.personal.part.y;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSCollectBoxAddFeedRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetCollectBoxListRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSMoveCollectBoxRequest;
import com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$AddFavoritesFeedsRsp;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudFavoritessvr$GetFavoritesListRsp;
import feedcloud.FeedCloudFavoritessvr$MoveFavoritesFeedsRsp;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalSelectCollectBoxBottomSheet extends QFSBaseBottomSheetDialog implements View.OnClickListener {
    private static final int N = cx.a(414.0f);
    private View E;
    private final View F;
    private final com.tencent.biz.qqcircle.immersive.personal.bean.r G;
    private View H;
    private QCircleBlockContainer I;
    private com.tencent.biz.qqcircle.immersive.personal.adapter.n J;
    private y K;
    private String L;
    private final QCircleReportBean M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$GetFavoritesListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f89326a;

        a(boolean z16) {
            this.f89326a = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$GetFavoritesListRsp feedCloudFavoritessvr$GetFavoritesListRsp) {
            if (z16 && j3 == 0 && feedCloudFavoritessvr$GetFavoritesListRsp != null) {
                List<FeedCloudFavoritessvr$FavoritesInfo> list = feedCloudFavoritessvr$GetFavoritesListRsp.favorites_list.get();
                if (!this.f89326a) {
                    QFSPersonalSelectCollectBoxBottomSheet.this.g0(list);
                } else {
                    List<FeedCloudFavoritessvr$FavoritesInfo> dataList = QFSPersonalSelectCollectBoxBottomSheet.this.J.getDataList();
                    dataList.addAll(list);
                    QFSPersonalSelectCollectBoxBottomSheet.this.g0(dataList);
                }
                boolean z17 = !feedCloudFavoritessvr$GetFavoritesListRsp.has_more.get();
                QFSPersonalSelectCollectBoxBottomSheet.this.J.getLoadInfo().setFinish(z17);
                QFSPersonalSelectCollectBoxBottomSheet.this.J.notifyLoadingComplete(true, z17);
                QFSPersonalSelectCollectBoxBottomSheet.this.L = feedCloudFavoritessvr$GetFavoritesListRsp.attch_info.get();
                return;
            }
            QLog.e("QFSPersonalSelectCollectBoxBottomSheet", 1, "moveCollectBox error:" + j3 + "  errorMsg:" + str);
            QFSPersonalSelectCollectBoxBottomSheet.this.e0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements MultiViewBlock.OnLoadDataDelegate {
        b() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState()) {
                QFSPersonalSelectCollectBoxBottomSheet.this.n0(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$AddFavoritesFeedsRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f89329a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f89330b;

        c(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, List list) {
            this.f89329a = feedCloudFavoritessvr$FavoritesInfo;
            this.f89330b = list;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$AddFavoritesFeedsRsp feedCloudFavoritessvr$AddFavoritesFeedsRsp) {
            if (z16 && j3 == 0 && feedCloudFavoritessvr$AddFavoritesFeedsRsp != null) {
                QFSPersonalSelectCollectBoxBottomSheet.this.dismiss();
                this.f89329a.cover_url.set(((FeedCloudMeta$StFeed) this.f89330b.get(0)).cover.picUrl.get());
                QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent = new QFSPersonalCollectBoxEvent(6);
                qFSPersonalCollectBoxEvent.setFavoritesInfo(this.f89329a);
                qFSPersonalCollectBoxEvent.setFeedList(this.f89330b);
                SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent);
                QFSPublishTipsUtils qFSPublishTipsUtils = new QFSPublishTipsUtils();
                qFSPublishTipsUtils.t(QFSPersonalSelectCollectBoxBottomSheet.this.M);
                qFSPublishTipsUtils.v(QFSPersonalSelectCollectBoxBottomSheet.this.F, this.f89329a, null);
                return;
            }
            QLog.e("QFSPersonalSelectCollectBoxBottomSheet", 1, "addCollectBoxFeed error:" + j3 + "  errorMsg:" + str);
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188723xg), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$MoveFavoritesFeedsRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f89332a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f89333b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f89334c;

        d(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, List list, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo2) {
            this.f89332a = feedCloudFavoritessvr$FavoritesInfo;
            this.f89333b = list;
            this.f89334c = feedCloudFavoritessvr$FavoritesInfo2;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$MoveFavoritesFeedsRsp feedCloudFavoritessvr$MoveFavoritesFeedsRsp) {
            if (z16 && j3 == 0 && feedCloudFavoritessvr$MoveFavoritesFeedsRsp != null) {
                this.f89332a.cover_url.set(((FeedCloudMeta$StFeed) this.f89333b.get(0)).cover.picUrl.get());
                PBInt64Field pBInt64Field = this.f89332a.feed_num;
                pBInt64Field.set(pBInt64Field.get() + feedCloudFavoritessvr$MoveFavoritesFeedsRsp.dst_delta_num.get());
                QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent = new QFSPersonalCollectBoxEvent(5);
                qFSPersonalCollectBoxEvent.setFavoritesInfo(this.f89334c);
                qFSPersonalCollectBoxEvent.setFeedList(this.f89333b);
                SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent);
                QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent2 = new QFSPersonalCollectBoxEvent(6);
                qFSPersonalCollectBoxEvent2.setFavoritesInfo(this.f89332a);
                SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent2);
                QFSPersonalSelectCollectBoxBottomSheet.this.dismiss();
                QFSPublishTipsUtils qFSPublishTipsUtils = new QFSPublishTipsUtils();
                qFSPublishTipsUtils.t(QFSPersonalSelectCollectBoxBottomSheet.this.M);
                qFSPublishTipsUtils.v(QFSPersonalSelectCollectBoxBottomSheet.this.F, this.f89332a, this.f89334c);
                return;
            }
            QLog.e("QFSPersonalSelectCollectBoxBottomSheet", 1, "moveCollectBox error:" + j3 + "  errorMsg:" + str);
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f188723xg), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends RecyclerView.OnScrollListener {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            QFSPersonalSelectCollectBoxBottomSheet.this.getBehavior().setDraggable(!recyclerView.canScrollVertically(-1));
        }
    }

    public QFSPersonalSelectCollectBoxBottomSheet(@NonNull Context context, @NonNull View view, @NonNull com.tencent.biz.qqcircle.immersive.personal.bean.r rVar, QCircleReportBean qCircleReportBean) {
        super(context);
        this.K = new y();
        this.F = view;
        this.G = rVar;
        this.M = qCircleReportBean;
        initView();
        j0();
        m0();
        n0(false);
    }

    private void Z(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        List<FeedCloudMeta$StFeed> b16 = this.G.b();
        long size = feedCloudFavoritessvr$FavoritesInfo.feed_num.get() + b16.size();
        int i3 = QFSPersonalCollectBoxAddFeedBottomSheet.S;
        if (size > i3) {
            QCircleToast.o(this.C.getString(R.string.f187993vh, Integer.valueOf(i3)), 0);
        } else {
            VSNetworkHelper.getInstance().sendRequest(new QFSCollectBoxAddFeedRequest(feedCloudFavoritessvr$FavoritesInfo.f398434id.get(), b16), new c(feedCloudFavoritessvr$FavoritesInfo, b16));
        }
    }

    private void a0(boolean z16) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CREATE_COLLECT_FOLDER_BUTTON);
        if (this.G.a() != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.G.a().f398434id.get()));
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CHOOSE_COLLECT_FOLDER_POPUP_SOURCE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.personal.utils.j.f(this.G.c())));
        QCircleReportBean qCircleReportBean = this.M;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        if (z16) {
            str = "ev_xsj_abnormal_clck";
        } else {
            str = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str, buildElementParams);
    }

    private void b0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CHOOSE_COLLECT_FOLDER_POPUP);
        if (this.G.a() != null) {
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.G.a().f398434id.get()));
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_CHOOSE_COLLECT_FOLDER_POPUP_SOURCE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.personal.utils.j.f(this.G.c())));
        QCircleReportBean qCircleReportBean = this.M;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private void c0() {
        if (this.G.c() == 1) {
            QFSPublishTipsUtils qFSPublishTipsUtils = new QFSPublishTipsUtils();
            qFSPublishTipsUtils.t(this.M);
            qFSPublishTipsUtils.w(this.F, this.G.b().get(0), false);
        }
    }

    private void d0() {
        this.K.M9(uq3.c.n3(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(String str) {
        y yVar = this.K;
        if (yVar == null) {
            return;
        }
        yVar.M9(str, null);
    }

    private void f0(View view) {
        int i3;
        if (this.G.c() == 1) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        com.tencent.biz.qqcircle.immersive.personal.bean.n nVar = new com.tencent.biz.qqcircle.immersive.personal.bean.n(i3);
        nVar.d(this.G.a());
        nVar.e(this.G.b());
        new QFSPersonalNewCollectBoxBottomSheet(this.C, this.F, nVar, this.M).show();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(List<FeedCloudFavoritessvr$FavoritesInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (this.G.c() == 2) {
            for (FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo : list) {
                if (this.G.a().f398434id.get() != feedCloudFavoritessvr$FavoritesInfo.f398434id.get()) {
                    arrayList.add(feedCloudFavoritessvr$FavoritesInfo);
                }
            }
        } else {
            arrayList.addAll(list);
        }
        if (arrayList.isEmpty()) {
            d0();
        } else {
            this.J.setDatas(arrayList);
            this.K.E9();
        }
    }

    private void i0() {
        com.tencent.biz.qqcircle.immersive.personal.adapter.n nVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.n(null);
        this.J = nVar;
        nVar.m0(this.G);
        this.J.setReportBean(this.M);
        this.J.setOnLoadDataDelegate(new b());
        this.J.l0(new n.b() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.u
            @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.n.b
            public final void a(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, QCircleBaseWidgetView qCircleBaseWidgetView) {
                QFSPersonalSelectCollectBoxBottomSheet.this.k0(i3, feedCloudFavoritessvr$FavoritesInfo, qCircleBaseWidgetView);
            }
        });
        this.I.registerBlock(this.J);
        this.I.getBlockMerger().setNoMoreHint(com.tencent.biz.qqcircle.utils.h.a(R.string.f1921346o));
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.f168734gn4, (ViewGroup) null);
        this.E = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.f165218li0);
        this.H = this.E.findViewById(R.id.ypi);
        this.I = (QCircleBlockContainer) this.E.findViewById(R.id.f34310yt);
        this.K.onInitView(frameLayout);
        setContentView(this.E);
        b0();
        a0(false);
        i0();
    }

    private void j0() {
        this.E.findViewById(R.id.f167033k60).setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.getRecyclerView().addOnScrollListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(int i3, FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, QCircleBaseWidgetView qCircleBaseWidgetView) {
        if (this.G.c() == 2) {
            l0(feedCloudFavoritessvr$FavoritesInfo);
        } else {
            Z(feedCloudFavoritessvr$FavoritesInfo);
        }
    }

    private void l0(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo) {
        FeedCloudFavoritessvr$FavoritesInfo a16 = this.G.a();
        List<FeedCloudMeta$StFeed> b16 = this.G.b();
        long size = feedCloudFavoritessvr$FavoritesInfo.feed_num.get() + b16.size();
        int i3 = QFSPersonalCollectBoxAddFeedBottomSheet.S;
        if (size > i3) {
            QCircleToast.o(this.C.getString(R.string.f187993vh, Integer.valueOf(i3)), 0);
        } else {
            VSNetworkHelper.getInstance().sendRequest(new QFSMoveCollectBoxRequest(a16.f398434id.get(), feedCloudFavoritessvr$FavoritesInfo.f398434id.get(), b16), new d(feedCloudFavoritessvr$FavoritesInfo, b16, a16));
        }
    }

    private void m0() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.height = N;
        this.E.setLayoutParams(layoutParams);
        getBehavior().setPeekHeight(layoutParams.height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(boolean z16) {
        String str;
        QFSGetCollectBoxListRequest.a aVar = new QFSGetCollectBoxListRequest.a(QCirclePluginGlobalInfo.m().f398463id.get());
        if (z16) {
            str = this.L;
        } else {
            str = "";
        }
        VSNetworkHelper.getInstance().sendRequest(aVar.f(str).a(), new a(z16));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSPersonalSelectCollectBoxBottomSheet")) {
            int id5 = view.getId();
            if (id5 == R.id.ypi) {
                f0(view);
                a0(true);
            } else if (id5 == R.id.f167033k60) {
                dismiss();
                c0();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
