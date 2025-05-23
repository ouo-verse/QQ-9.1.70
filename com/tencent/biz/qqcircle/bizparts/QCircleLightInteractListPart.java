package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseLightInteractWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractDividerWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPolyLikeWidget;
import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.qqcircle.widgets.QFSLightInteractOpenLikeWidget;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLightInteractInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase$LightInteractionBusiData;

/* loaded from: classes4.dex */
public class QCircleLightInteractListPart extends com.tencent.biz.qqcircle.bizparts.b {
    private FeedCloudMeta$StFeed C;
    private int D;
    private com.tencent.biz.qqcircle.viewmodels.b E;
    private QCircleStatusView F;
    private QCirclePanelLoadingView G;
    private TextView H;
    private ImageView I;
    private QCircleExtraTypeInfo J = new QCircleExtraTypeInfo();
    private int K;
    private String L;
    private com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> M;
    private ViewStub N;
    private com.tencent.biz.qqcircle.bizparts.g P;

    /* renamed from: d, reason: collision with root package name */
    private QCircleSlidBottomView f82688d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleBlockContainer f82689e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f82690f;

    /* renamed from: h, reason: collision with root package name */
    private View f82691h;

    /* renamed from: i, reason: collision with root package name */
    private LightInteractListAdapter f82692i;

    /* renamed from: m, reason: collision with root package name */
    private e30.b f82693m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleLightInteractListPart.this.f82688d.g();
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (QCircleLightInteractListPart.this.C == null) {
                str = "";
            } else {
                str = QCircleLightInteractListPart.this.C.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(15, str, false));
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements MultiViewBlock.OnLoadDataDelegate {
        c() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState()) {
                QCircleLightInteractListPart.this.E.N1(QCircleLightInteractListPart.this.C, true, false, QCircleLightInteractListPart.this.K, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e implements Observer<UIStateData<List<FeedCloudMeta$StLightInteractInfo>>> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable UIStateData<List<FeedCloudMeta$StLightInteractInfo>> uIStateData) {
            QCircleLightInteractListPart.this.L9(uIStateData);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.ViewHolder {
        public f(View view) {
            super(view);
        }

        public void l(Object obj, int i3, int i16, FeedCloudMeta$StFeed feedCloudMeta$StFeed, QCircleExtraTypeInfo qCircleExtraTypeInfo) {
            View view = this.itemView;
            if (view instanceof QCircleBaseLightInteractWidget) {
                ((QCircleBaseLightInteractWidget) view).k0(feedCloudMeta$StFeed, qCircleExtraTypeInfo, i16);
                ((QCircleBaseLightInteractWidget) this.itemView).setData(obj, i3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public e30.b f82701a;

        /* renamed from: b, reason: collision with root package name */
        public FeedCloudMeta$StFeed f82702b;

        /* renamed from: c, reason: collision with root package name */
        public String f82703c;

        /* renamed from: d, reason: collision with root package name */
        public int f82704d;

        /* renamed from: e, reason: collision with root package name */
        public int f82705e;
    }

    private void G9() {
        if (getPartRootView() != null && this.N == null) {
            a aVar = new a();
            ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.f31380qw);
            this.N = viewStub;
            QCircleSlidBottomView qCircleSlidBottomView = (QCircleSlidBottomView) viewStub.inflate().findViewById(R.id.f31380qw);
            this.f82688d = qCircleSlidBottomView;
            this.f82691h = qCircleSlidBottomView.findViewById(R.id.f31420r0);
            this.f82688d.setOnClickListener(aVar);
            this.f82688d.e(K9());
            this.f82689e = (QCircleBlockContainer) this.f82688d.findViewById(R.id.f31410qz);
            this.f82691h.setOnClickListener(aVar);
            this.f82690f = (FrameLayout) this.f82688d.findViewById(R.id.f30850pg);
            this.F = (QCircleStatusView) this.f82688d.findViewById(R.id.f31390qx);
            this.G = (QCirclePanelLoadingView) this.f82688d.findViewById(R.id.f31400qy);
            this.H = (TextView) this.f82688d.findViewById(R.id.f55572i_);
            this.I = (ImageView) this.f82688d.findViewById(R.id.f41911ic);
            TextView textView = this.H;
            if (textView != null) {
                textView.setVisibility(8);
            }
            ImageView imageView = this.I;
            if (imageView != null) {
                imageView.setVisibility(8);
                this.I.setOnClickListener(aVar);
            }
            N9();
        }
    }

    private void H9() {
        String str;
        FrameLayout frameLayout = this.f82690f;
        if (frameLayout == null) {
            return;
        }
        VideoReport.setElementId(frameLayout, J9(this.K));
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.d(this.f82693m));
        e30.b bVar = this.f82693m;
        if (bVar != null && bVar.g() != null && this.f82693m.g().opMask2 != null && this.f82693m.g().opMask2.get() != null) {
            if (this.C.opMask2.get().contains(40)) {
                str = "original";
            } else {
                str = WinkDaTongReportConstant.ElementParamValue.REPRINT;
            }
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FEED_LABEL_NAME, str);
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PARENT_EMID, QCircleDaTongConstant.ElementId.EM_XSJ_FEED);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.D + 1));
        VideoReport.setElementParams(this.f82690f, buildElementParams);
        VideoReport.setElementExposePolicy(this.f82690f, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", this.f82690f, null);
    }

    private void I9(UIStateData<List<FeedCloudMeta$StLightInteractInfo>> uIStateData) {
        String a16;
        if (uIStateData.getState() == 4) {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f184743mp);
        } else {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f182993hz);
        }
        if (!uIStateData.getIsLoadMore() && this.f82692i.getItemCount() <= 0) {
            this.f82692i.clearData();
            P9(false, false, false);
            Q9(a16);
        } else {
            this.F.setVisibility(8);
            P9(false, true, false);
        }
    }

    private String J9(int i3) {
        if (i3 == 1) {
            return QCircleDaTongConstant.ElementId.EM_XSJ_ROCKETS_LIST;
        }
        if (i3 == 10) {
            return QCircleDaTongConstant.ElementId.EM_XSJ_LIKES_LIST_PANEL;
        }
        return QCircleDaTongConstant.ElementId.EM_XSJ_LIKES_LIST;
    }

    @NonNull
    private QCircleSlidBottomView.d K9() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9(UIStateData<List<FeedCloudMeta$StLightInteractInfo>> uIStateData) {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.G;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        int state = uIStateData.getState();
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state != 4) {
                    return;
                }
            } else {
                R9(uIStateData);
                return;
            }
        }
        I9(uIStateData);
    }

    private void M9() {
        boolean z16;
        int i3;
        int i16;
        int a16;
        TextView textView = this.H;
        if (textView != null && this.I != null && this.f82691h != null && this.f82689e != null) {
            if (this.K == 10) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i17 = 8;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            ImageView imageView = this.I;
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView.setVisibility(i16);
            View view = this.f82691h;
            if (!z16) {
                i17 = 0;
            }
            view.setVisibility(i17);
            if (z16) {
                this.H.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f184133l2));
                a16 = com.tencent.biz.qqcircle.utils.cx.a(42.0f);
            } else {
                a16 = com.tencent.biz.qqcircle.utils.cx.a(30.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.f82689e.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).setMargins(0, a16, 0, 0);
            }
        }
    }

    private void N9() {
        new LinearLayoutManager(getPartRootView().getContext()).setOrientation(1);
        this.f82689e.setLayoutManagerType(1, 1);
        this.f82689e.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(2);
        this.f82689e.setEnableLoadMore(true);
        this.f82689e.setEnableRefresh(false);
        this.f82689e.setParentFragment(getHostFragment());
        this.f82689e.getRecyclerView().setNestedScrollingEnabled(true);
        ArrayList<MultiViewBlock> arrayList = new ArrayList<>();
        O9(arrayList);
        LightInteractListAdapter lightInteractListAdapter = new LightInteractListAdapter(null);
        this.f82692i = lightInteractListAdapter;
        arrayList.add(lightInteractListAdapter);
        this.f82692i.setOnLoadDataDelegate(new c());
        this.f82689e.registerBlock(arrayList);
        this.f82689e.getRecyclerView().addOnScrollListener(new d());
        this.f82692i.k0(this.f82689e.getRecyclerView());
        this.f82689e.start();
    }

    private void O9(ArrayList<MultiViewBlock> arrayList) {
        if (arrayList == null) {
            return;
        }
        com.tencent.biz.qqcircle.bizparts.g gVar = new com.tencent.biz.qqcircle.bizparts.g(null);
        this.P = gVar;
        arrayList.add(gVar);
    }

    private void Q9(String str) {
        if (this.F != null && this.P != null) {
            boolean isOwner = QCirclePluginUtil.isOwner(this.C.poster.f398463id.get());
            boolean equals = com.tencent.biz.qqcircle.utils.h.a(R.string.f182993hz).equals(str);
            if (isOwner && equals) {
                this.P.j0(0);
            } else {
                this.P.j0(8);
                this.F.x0(str);
            }
        }
    }

    private void R9(UIStateData<List<FeedCloudMeta$StLightInteractInfo>> uIStateData) {
        if (uIStateData.getData() != null) {
            if (!uIStateData.getIsLoadMore()) {
                this.F.setVisibility(8);
                if (this.f82688d.t()) {
                    this.f82692i.j0(uIStateData.getData(), this.C, this.D);
                }
            } else if (this.f82688d.t()) {
                this.F.setVisibility(8);
                this.f82692i.addData(uIStateData.getData());
            }
            P9(true, uIStateData.getIsLoadMore(), uIStateData.getIsFinish());
        }
    }

    private void S9() {
        com.tencent.biz.qqcircle.viewmodels.b bVar = (com.tencent.biz.qqcircle.viewmodels.b) getViewModel(this.C.f398449id.get() + this.K, com.tencent.biz.qqcircle.viewmodels.b.class);
        this.E = bVar;
        if (bVar == null) {
            return;
        }
        bVar.L1().removeObservers(getHostFragment());
        this.E.L1().observe(getHostFragment(), new e());
        this.E.N1(this.C, false, false, this.K, this.L);
        if (this.P != null) {
            if (QCirclePluginUtil.isOwner(this.C.poster.f398463id.get())) {
                this.P.setBlockVisible(true);
                this.P.i0(this.C);
            } else {
                this.P.setBlockVisible(false);
            }
        }
    }

    public void P9(boolean z16, boolean z17, boolean z18) {
        if (this.f82689e != null && this.f82692i.getBlockMerger() != null) {
            this.f82692i.getLoadInfo().setCurrentState(4);
            this.f82692i.getLoadInfo().setFinish(z18);
            this.f82689e.setRefreshing(false);
            this.f82692i.getBlockMerger().showHint(false);
            this.f82692i.getBlockMerger().setNoMoreHint("");
            this.f82692i.getBlockMerger().onLoadMoreCompleted(z16, z18);
            QLog.d("QCircleLightInteractListPart", 4, "iscuccess:" + z16 + " isfinish:" + z18);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleLightInteractListPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.bizparts.b
    public int getPageId() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getPageId("QCircleLightInteractListPart", qCircleReportBean);
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.M;
        if (aVar != null) {
            return QCircleReportBean.getPageId("QCircleLightInteractListPart", aVar.getReportBean());
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        QCircleSlidBottomView qCircleSlidBottomView;
        QCircleSlidBottomView qCircleSlidBottomView2;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        int i3;
        if (obj instanceof g) {
            G9();
            g gVar = (g) obj;
            this.C = gVar.f82702b;
            this.f82693m = gVar.f82701a;
            this.D = gVar.f82704d;
            this.L = gVar.f82703c;
            this.K = gVar.f82705e;
        }
        String str2 = "";
        if (str.equals("light_interact_list_show")) {
            QCircleExtraTypeInfo qCircleExtraTypeInfo = this.J;
            if (qCircleExtraTypeInfo != null) {
                qCircleExtraTypeInfo.mFeed = this.C;
                qCircleExtraTypeInfo.mPlayScene = 1;
                qCircleExtraTypeInfo.mDataPosition = this.D + 1;
            }
            this.f82689e.getBlockMerger().resetTryToLoadMoreCount();
            this.f82692i.clearData();
            if (!HostNetworkUtils.isNetworkAvailable()) {
                Q9("");
            } else {
                S9();
                QCirclePanelLoadingView qCirclePanelLoadingView = this.G;
                if (qCirclePanelLoadingView != null && (qCircleSlidBottomView2 = this.f82688d) != null) {
                    qCirclePanelLoadingView.o0(qCircleSlidBottomView2.k());
                    this.F.setVisibility(8);
                }
            }
            if (this.f82688d != null) {
                if (uq3.c.g6()) {
                    this.f82688d.f();
                }
                this.f82688d.x(this.f82690f);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.C;
                if (feedCloudMeta$StFeed2 != null) {
                    str2 = feedCloudMeta$StFeed2.f398449id.get();
                }
                simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(15, str2, true));
                QCircleExtraTypeInfo qCircleExtraTypeInfo2 = this.J;
                if (qCircleExtraTypeInfo2 != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo2.mFeed) != null) {
                    QCircleLpReportDc05501.DataBuilder a16 = ua0.c.a(feedCloudMeta$StFeed);
                    if (this.K == 1) {
                        i3 = 87;
                    } else {
                        i3 = 70;
                    }
                    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(a16.setActionType(i3).setSubActionType(1).setToUin(this.J.mFeed.poster.f398463id.get()).setIndex(this.J.mDataPosition).setPageId(getPageId())));
                }
                M9();
            }
            H9();
            return;
        }
        if (str.equals("light_interact_list_dismiss") && (qCircleSlidBottomView = this.f82688d) != null) {
            qCircleSlidBottomView.g();
            SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.C;
            if (feedCloudMeta$StFeed3 != null) {
                str2 = feedCloudMeta$StFeed3.f398449id.get();
            }
            simpleEventBus2.dispatchEvent(new QCirclePanelStateEvent(15, str2, false));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        String str;
        QCircleSlidBottomView qCircleSlidBottomView = this.f82688d;
        if (qCircleSlidBottomView != null && qCircleSlidBottomView.getVisibility() == 0) {
            this.f82688d.g();
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.C;
            if (feedCloudMeta$StFeed == null) {
                str = "";
            } else {
                str = feedCloudMeta$StFeed.f398449id.get();
            }
            simpleEventBus.dispatchEvent(new QCirclePanelStateEvent(15, str, false));
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.immersive.utils.ax.b(this.f82688d);
    }

    public void setReportBeanAgent(com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar) {
        this.M = aVar;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.b, com.tencent.biz.qqcircle.richframework.part.a
    public QCircleReportBean getReportBean() {
        QCircleReportBean qCircleReportBean = this.mReportBean;
        if (qCircleReportBean != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractListPart", qCircleReportBean).m466clone();
        }
        com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> aVar = this.M;
        if (aVar != null) {
            return QCircleReportBean.getReportBean("QCircleLightInteractListPart", aVar.getReportBean()).m466clone();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class LightInteractListAdapter extends com.tencent.biz.qqcircle.bizparts.a<FeedCloudMeta$StLightInteractInfo> {
        private int C;
        private RecyclerView D;

        /* renamed from: m, reason: collision with root package name */
        private FeedCloudMeta$StFeed f82694m;

        public LightInteractListAdapter(Bundle bundle) {
            super(bundle);
        }

        private void i0() {
            RecyclerView recyclerView = this.D;
            if (recyclerView != null) {
                if (recyclerView.isComputingLayout()) {
                    this.D.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart.LightInteractListAdapter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LightInteractListAdapter.this.notifyDataSetChanged();
                        }
                    }, 500L);
                } else {
                    notifyDataSetChanged();
                }
            }
        }

        public void addData(List<FeedCloudMeta$StLightInteractInfo> list) {
            List<E> list2 = this.mDataList;
            list2.addAll(list2.size(), list);
            i0();
        }

        @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
        public void clearData() {
            this.mDataList.clear();
            i0();
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mDataList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            FeedCloudMeta$StLightInteractInfo feedCloudMeta$StLightInteractInfo = (FeedCloudMeta$StLightInteractInfo) this.mDataList.get(i3);
            QQCircleFeedBase$LightInteractionBusiData qQCircleFeedBase$LightInteractionBusiData = new QQCircleFeedBase$LightInteractionBusiData();
            try {
                qQCircleFeedBase$LightInteractionBusiData.mergeFrom(feedCloudMeta$StLightInteractInfo.busiData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("LightInteractListAdapter", 1, "getItemViewType except:" + e16.toString());
            }
            if (TextUtils.isEmpty(qQCircleFeedBase$LightInteractionBusiData.splitItemText.get())) {
                return QCircleLightInteractListPart.this.K;
            }
            return -1;
        }

        @Override // com.tencent.biz.qqcircle.bizparts.a
        protected String getLogTag() {
            return "LightInteractListAdapter";
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
        public int getViewTypeCount() {
            return 2;
        }

        public void j0(List<FeedCloudMeta$StLightInteractInfo> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
            this.f82694m = feedCloudMeta$StFeed;
            this.C = i3;
            if (list != null) {
                this.mDataList.clear();
                i0();
                this.mDataList.addAll(list);
                i0();
            }
        }

        public void k0(RecyclerView recyclerView) {
            this.D = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            if (this.mDataList.size() > i3 && (viewHolder instanceof f)) {
                ((f) viewHolder).l(this.mDataList.get(i3), i3, this.C, this.f82694m, QCircleLightInteractListPart.this.J);
            }
        }

        @Override // com.tencent.biz.qqcircle.bizparts.a
        @NonNull
        public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            if (i3 != 2 && i3 != 4) {
                if (i3 == -1) {
                    QCircleLightInteractDividerWidget qCircleLightInteractDividerWidget = new QCircleLightInteractDividerWidget(getContext(), i3);
                    qCircleLightInteractDividerWidget.setReportBeanAgent(QCircleLightInteractListPart.this);
                    return new f(qCircleLightInteractDividerWidget);
                }
                if (i3 == 10) {
                    QFSLightInteractOpenLikeWidget qFSLightInteractOpenLikeWidget = new QFSLightInteractOpenLikeWidget(getContext(), i3);
                    qFSLightInteractOpenLikeWidget.setReportBeanAgent(QCircleLightInteractListPart.this);
                    qFSLightInteractOpenLikeWidget.setExtraTypeInfo(QCircleLightInteractListPart.this.J);
                    return new f(qFSLightInteractOpenLikeWidget);
                }
                QCircleLightInteractPushWidget qCircleLightInteractPushWidget = new QCircleLightInteractPushWidget(getContext(), i3);
                qCircleLightInteractPushWidget.setReportBeanAgent(QCircleLightInteractListPart.this);
                qCircleLightInteractPushWidget.setSlideBottomViewContainer(QCircleLightInteractListPart.this.f82688d);
                return new f(qCircleLightInteractPushWidget);
            }
            QCircleLightInteractPolyLikeWidget qCircleLightInteractPolyLikeWidget = new QCircleLightInteractPolyLikeWidget(getContext(), i3, QCircleLightInteractListPart.this.K);
            qCircleLightInteractPolyLikeWidget.setReportBeanAgent(QCircleLightInteractListPart.this);
            return new f(qCircleLightInteractPolyLikeWidget);
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
        public void loadData(LoadInfo loadInfo) {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
        public void onInitBlock(Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements QCircleSlidBottomView.d {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public /* synthetic */ void a() {
            com.tencent.biz.qqcircle.utils.ad.c(this);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onConfigurationChanged() {
            if (QCircleLightInteractListPart.this.f82688d == null) {
                return;
            }
            QCircleLightInteractListPart.this.f82688d.f();
            QCircleLightInteractListPart.this.f82688d.y();
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onDismiss() {
            int i3;
            int i16;
            QCircleLightInteractListPart.this.f82689e.getRecyclerView().scrollToPosition(0);
            QCircleLightInteractListPart.this.f82689e.getBlockMerger().resetTryToLoadMoreCount();
            QCircleLightInteractListPart.this.f82692i.clearData();
            QCircleLightInteractListPart.this.P9(true, false, true);
            if (QCircleLightInteractListPart.this.J != null && QCircleLightInteractListPart.this.J.mFeed != null) {
                QCircleLpReportDc05501.DataBuilder a16 = ua0.c.a(QCircleLightInteractListPart.this.J.mFeed);
                if (QCircleLightInteractListPart.this.K == 1) {
                    i3 = 87;
                } else {
                    i3 = 75;
                }
                QCircleLpReportDc05501.DataBuilder actionType = a16.setActionType(i3);
                if (QCircleLightInteractListPart.this.K == 1) {
                    i16 = 6;
                } else {
                    i16 = 2;
                }
                QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(actionType.setSubActionType(i16).setToUin(QCircleLightInteractListPart.this.J.mFeed.poster.f398463id.get()).setIndex(QCircleLightInteractListPart.this.J.mDataPosition).setPageId(QCircleLightInteractListPart.this.getPageId())));
            }
            com.tencent.biz.qqcircle.immersive.utils.ax.g(QCircleLightInteractListPart.this.getContext(), true);
            QLog.d("QCircleLightInteractListPart", 4, "dismiss");
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onShow() {
            com.tencent.biz.qqcircle.immersive.utils.ax.g(QCircleLightInteractListPart.this.getContext(), false);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onStatusChange(int i3) {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
        }
    }
}
