package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalCollectBoxAddFeedAdapter;
import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalCollectBoxDetailBean;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPersonalCollectBoxEvent;
import com.tencent.biz.qqcircle.immersive.personal.part.y;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSCollectBoxAddFeedRequest;
import com.tencent.biz.qqcircle.immersive.personal.request.QFSGetCollectBoxFeedListRequest;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudFavoritessvr$AddFavoritesFeedsRsp;
import feedcloud.FeedCloudFavoritessvr$FavoritesInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalCollectBoxAddFeedBottomSheet extends QFSBaseBottomSheetDialog implements View.OnClickListener {
    private static final int Q = (int) (cx.f() * 0.9d);
    public static final int R;
    public static final int S;
    private View E;
    private final View F;
    private final com.tencent.biz.qqcircle.immersive.personal.bean.f G;
    private TextView H;
    private QCircleBlockContainer I;
    private QFSPersonalCollectBoxAddFeedAdapter J;
    private y K;
    private String L;
    private final List<Integer> M;
    private final QCircleReportBean N;
    private final List<com.tencent.biz.qqcircle.immersive.personal.bean.e> P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState()) {
                QFSPersonalCollectBoxAddFeedBottomSheet.this.p0(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedListRsp> {
        b() {
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
            boolean z17;
            if (z16 && j3 == 0 && feedCloudRead$StGetFeedListRsp != null) {
                QFSPersonalCollectBoxAddFeedBottomSheet.this.L = feedCloudRead$StGetFeedListRsp.feedAttchInfo.get();
                ArrayList arrayList = new ArrayList();
                QFSPersonalCollectBoxAddFeedBottomSheet.this.q0(arrayList, feedCloudRead$StGetFeedListRsp.vecFeed.get());
                QFSPersonalCollectBoxAddFeedBottomSheet.this.P.addAll(arrayList);
                if (feedCloudRead$StGetFeedListRsp.isFinish.get() == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && QFSPersonalCollectBoxAddFeedBottomSheet.this.P.size() < 12) {
                    QFSPersonalCollectBoxAddFeedBottomSheet.this.p0(true);
                    return;
                }
                arrayList.clear();
                arrayList.addAll(QFSPersonalCollectBoxAddFeedBottomSheet.this.J.getDataList());
                arrayList.addAll(QFSPersonalCollectBoxAddFeedBottomSheet.this.P);
                QFSPersonalCollectBoxAddFeedBottomSheet.this.P.clear();
                QFSPersonalCollectBoxAddFeedBottomSheet.this.k0(arrayList);
                QFSPersonalCollectBoxAddFeedBottomSheet.this.J.getLoadInfo().setFinish(z17);
                QFSPersonalCollectBoxAddFeedBottomSheet.this.J.notifyLoadingComplete(true, z17);
                return;
            }
            QLog.e("QFSPersonalCollectBoxAddFeedBottomSheet", 1, "requestCollectBoxFeedList error:" + j3 + "  errorMsg:" + str);
            QFSPersonalCollectBoxAddFeedBottomSheet.this.j0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            QFSPersonalCollectBoxAddFeedBottomSheet.super.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements VSDispatchObserver.OnVSRspCallBack<FeedCloudFavoritessvr$AddFavoritesFeedsRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudFavoritessvr$FavoritesInfo f89229a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f89230b;

        e(FeedCloudFavoritessvr$FavoritesInfo feedCloudFavoritessvr$FavoritesInfo, List list) {
            this.f89229a = feedCloudFavoritessvr$FavoritesInfo;
            this.f89230b = list;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudFavoritessvr$AddFavoritesFeedsRsp feedCloudFavoritessvr$AddFavoritesFeedsRsp) {
            if (z16 && j3 == 0 && feedCloudFavoritessvr$AddFavoritesFeedsRsp != null) {
                QFSPersonalCollectBoxAddFeedBottomSheet.this.dismiss();
                this.f89229a.cover_url.set(((FeedCloudMeta$StFeed) this.f89230b.get(0)).cover.picUrl.get());
                QFSPersonalCollectBoxEvent qFSPersonalCollectBoxEvent = new QFSPersonalCollectBoxEvent(6);
                qFSPersonalCollectBoxEvent.setFavoritesInfo(this.f89229a);
                qFSPersonalCollectBoxEvent.setFeedList(this.f89230b);
                SimpleEventBus.getInstance().dispatchEvent(qFSPersonalCollectBoxEvent);
                if (QFSPersonalCollectBoxAddFeedBottomSheet.this.G.b() != 3) {
                    QFSPersonalCollectBoxDetailBean qFSPersonalCollectBoxDetailBean = new QFSPersonalCollectBoxDetailBean();
                    qFSPersonalCollectBoxDetailBean.setFavoritesInfo(this.f89229a);
                    com.tencent.biz.qqcircle.launcher.c.b0(((QFSBaseBottomSheetDialog) QFSPersonalCollectBoxAddFeedBottomSheet.this).C, qFSPersonalCollectBoxDetailBean);
                    return;
                }
                return;
            }
            QLog.e("QFSPersonalCollectBoxAddFeedBottomSheet", 1, "addCollectBoxFeed error:" + j3 + "  errorMsg:" + str);
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f187973vf), 0);
            QFSPersonalCollectBoxAddFeedBottomSheet.this.H.setEnabled(true);
        }
    }

    static {
        int o06;
        int p06;
        if (RFWApplication.isDebug()) {
            o06 = 10;
        } else {
            o06 = uq3.o.o0(50);
        }
        R = o06;
        if (RFWApplication.isDebug()) {
            p06 = 20;
        } else {
            p06 = uq3.o.p0(100);
        }
        S = p06;
    }

    public QFSPersonalCollectBoxAddFeedBottomSheet(@NonNull Context context, @NonNull View view, @NonNull com.tencent.biz.qqcircle.immersive.personal.bean.f fVar, QCircleReportBean qCircleReportBean) {
        super(context);
        this.K = new y();
        this.M = new ArrayList();
        this.P = new ArrayList();
        this.F = view;
        this.G = fVar;
        this.N = qCircleReportBean;
        getBehavior().setDraggable(false);
        initView();
        m0();
        o0();
        p0(false);
    }

    private void d0(boolean z16) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CREATE_COLLECT_FOLDER_ADD_CANCEL_BTN);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.G.a().f398434id.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ADD_CONTENT_SOURCE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.personal.utils.j.b(this.G.b())));
        QCircleReportBean qCircleReportBean = this.N;
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

    private void e0(boolean z16) {
        String str;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CREATE_COLLECT_FOLDER_ADD_CONFIRM_BTN);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ADD_CONTENT_SOURCE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.personal.utils.j.b(this.G.b())));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.G.a().f398434id.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_NAME, this.G.a().title.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SELECT_PRODUCT_NUM, Integer.valueOf(this.M.size()));
        buildElementParams.put("xsj_feed_id", com.tencent.biz.qqcircle.immersive.personal.utils.j.e(r0()));
        QCircleReportBean qCircleReportBean = this.N;
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

    private void f0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_COLLECT_FOLDER_ADD_CONTENT_POPUP);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ID, Long.valueOf(this.G.a().f398434id.get()));
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_COLLECT_FOLDER_ADD_CONTENT_SOURCE, Integer.valueOf(com.tencent.biz.qqcircle.immersive.personal.utils.j.b(this.G.b())));
        QCircleReportBean qCircleReportBean = this.N;
        if (qCircleReportBean != null) {
            buildElementParams.put("xsj_custom_pgid", qCircleReportBean.getDtPageId());
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", buildElementParams);
    }

    private void g0() {
        String[] f16 = cu.f(uq3.c.y1(), "\n");
        if (f16.length >= 2) {
            this.K.M9(f16[0], f16[1]);
        } else {
            this.K.M9(f16[0], "");
        }
    }

    private void i0(View view) {
        this.H.setEnabled(false);
        FeedCloudFavoritessvr$FavoritesInfo a16 = this.G.a();
        List<FeedCloudMeta$StFeed> r06 = r0();
        VSNetworkHelper.getInstance().sendRequest(new QFSCollectBoxAddFeedRequest(a16.f398434id.get(), r06), new e(a16, r06));
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.gkc, (ViewGroup) null);
        this.E = inflate;
        this.H = (TextView) inflate.findViewById(R.id.f107736b8);
        FrameLayout frameLayout = (FrameLayout) this.E.findViewById(R.id.f165218li0);
        this.I = (QCircleBlockContainer) this.E.findViewById(R.id.f34310yt);
        this.K.onInitView(frameLayout);
        this.K.K9(true);
        setContentView(this.E);
        l0();
        f0();
        e0(false);
        d0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(String str) {
        y yVar = this.K;
        if (yVar == null) {
            return;
        }
        yVar.M9(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(List<com.tencent.biz.qqcircle.immersive.personal.bean.e> list) {
        if (list.isEmpty()) {
            g0();
        } else {
            this.J.setDatas(list);
            this.K.E9();
        }
    }

    private void l0() {
        this.I.setLayoutManagerType(2, 3);
        QFSPersonalCollectBoxAddFeedAdapter qFSPersonalCollectBoxAddFeedAdapter = new QFSPersonalCollectBoxAddFeedAdapter(null);
        this.J = qFSPersonalCollectBoxAddFeedAdapter;
        qFSPersonalCollectBoxAddFeedAdapter.setOnLoadDataDelegate(new a());
        this.J.x0(new QFSPersonalCollectBoxAddFeedAdapter.b() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.i
            @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalCollectBoxAddFeedAdapter.b
            public final void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, View view) {
                QFSPersonalCollectBoxAddFeedBottomSheet.this.n0(i3, eVar, view);
            }
        });
        this.I.registerBlock(this.J);
        this.I.getBlockMerger().setNoMoreHint(com.tencent.biz.qqcircle.utils.h.a(R.string.f1921346o));
        this.I.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(3);
    }

    private void m0() {
        this.E.findViewById(R.id.f167033k60).setOnClickListener(this);
        this.H.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, View view) {
        com.tencent.biz.qqcircle.immersive.personal.bean.g gVar = (com.tencent.biz.qqcircle.immersive.personal.bean.g) eVar;
        boolean i16 = gVar.i();
        if (i16) {
            this.M.remove(Integer.valueOf(i3));
        } else {
            int size = this.M.size();
            int i17 = R;
            if (size >= i17) {
                QCircleToast.o(this.C.getString(R.string.f188003vi, Integer.valueOf(i17)), 0);
                this.J.v0(i3);
                return;
            }
            long j3 = size;
            if (this.G.b() != 2) {
                j3 += this.G.a().feed_num.get();
            }
            int i18 = S;
            if (j3 >= i18) {
                QCircleToast.o(this.C.getString(R.string.f187993vh, Integer.valueOf(i18)), 0);
                this.J.v0(i3);
                return;
            }
            this.M.add(Integer.valueOf(i3));
        }
        gVar.j(!i16);
        this.J.v0(i3);
        s0();
    }

    private void o0() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.height = Q;
        this.E.setLayoutParams(layoutParams);
        getBehavior().setPeekHeight(layoutParams.height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(boolean z16) {
        String str;
        boolean z17;
        int i3;
        if (z16) {
            str = this.L;
        } else {
            str = "";
        }
        String str2 = str;
        long j3 = this.G.a().f398434id.get();
        if (this.G.b() == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        VSNetworkHelper.getInstance().sendRequest(new QFSGetCollectBoxFeedListRequest(j3, true, z17, str2, i3), new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(List<com.tencent.biz.qqcircle.immersive.personal.bean.e> list, List<FeedCloudMeta$StFeed> list2) {
        for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list2) {
            com.tencent.biz.qqcircle.immersive.personal.bean.g gVar = new com.tencent.biz.qqcircle.immersive.personal.bean.g(new e30.b(feedCloudMeta$StFeed));
            list.add(gVar);
            if (this.G.b() == 2 && TextUtils.equals(bh.d(feedCloudMeta$StFeed.extInfo.get(), "isAdded"), "1")) {
                gVar.j(true);
                this.M.add(Integer.valueOf(list.indexOf(gVar)));
                s0();
            }
        }
    }

    private List<FeedCloudMeta$StFeed> r0() {
        Collections.sort(this.M);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.M.iterator();
        while (it.hasNext()) {
            arrayList.add(this.J.i0().get(it.next().intValue()).g());
        }
        return arrayList;
    }

    private void s0() {
        this.H.setEnabled(!this.M.isEmpty());
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog
    protected boolean N() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSBaseBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.H.isEnabled()) {
            QCircleCustomDialog.P(this.C, null, com.tencent.biz.qqcircle.utils.h.a(R.string.f187983vg), R.string.cancel, R.string.f170901b10, new c(), new d()).show();
        } else {
            super.dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSPersonalCollectBoxAddFeedBottomSheet")) {
            int id5 = view.getId();
            if (id5 == R.id.f107736b8) {
                i0(view);
                e0(true);
            } else if (id5 == R.id.f167033k60) {
                dismiss();
                d0(true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
