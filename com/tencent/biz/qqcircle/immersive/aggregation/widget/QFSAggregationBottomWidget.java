package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.immersive.QFSBlockContainer;
import com.tencent.biz.qqcircle.immersive.QFSFlowAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import w30.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAggregationBottomWidget extends QCircleBaseWidgetView<List<e30.b>> implements LifecycleOwner, SimpleEventReceiver {
    private int C;
    private double D;
    private float E;
    private float F;
    private float G;
    private RecyclerView H;

    /* renamed from: d, reason: collision with root package name */
    private final LifecycleRegistry f84774d;

    /* renamed from: e, reason: collision with root package name */
    private final QFSFlowAggregationFragment f84775e;

    /* renamed from: f, reason: collision with root package name */
    private QFSBlockContainer f84776f;

    /* renamed from: h, reason: collision with root package name */
    private QFSFlowAggregationViewModel f84777h;

    /* renamed from: i, reason: collision with root package name */
    private w30.b f84778i;

    /* renamed from: m, reason: collision with root package name */
    private QFSAggregationBottomHintView f84779m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState() && QFSAggregationBottomWidget.this.f84777h != null) {
                QLog.i("QFSAggregationBottomWidget", 1, "onLoadData loadMore");
                QFSAggregationBottomWidget.this.f84777h.loadMore();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements b.c {
        b() {
        }

        @Override // w30.b.c
        public void a(int i3, e30.b bVar, View view) {
            if (o83.a.f422212a.d()) {
                QFSAggregationBottomWidget.this.q0(i3, bVar, view);
            } else {
                QFSAggregationBottomWidget.this.p0(i3, bVar, view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends RecyclerView.OnScrollListener {
        c() {
        }

        private void handleScrollStateChanged(int i3) {
            QCircleAspectScrollProcessor.getInstance().onScrollState(QFSAggregationBottomWidget.this, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
            handleScrollStateChanged(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements Observer<UIStateData<List<e30.b>>> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<e30.b>> uIStateData) {
            QFSAggregationBottomWidget.this.y0(uIStateData);
        }
    }

    public QFSAggregationBottomWidget(@NonNull Context context, QFSFlowAggregationFragment qFSFlowAggregationFragment) {
        super(context);
        initView();
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f84774d = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        this.f84775e = qFSFlowAggregationFragment;
        this.C = ViewConfiguration.get(context).getScaledTouchSlop();
        this.E = ImmersiveUtils.getScreenWidth();
        this.D = Math.tan(0.5235987755982988d);
        D0();
    }

    private void A0(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        if (this.f84778i == null) {
            return;
        }
        if (uIStateData.getIsLoadMore()) {
            this.f84778i.addAll(uIStateData.getData());
        } else {
            this.f84778i.setDatas(uIStateData.getData());
        }
        this.f84778i.getLoadInfo().setFinish(z16);
        this.f84779m.k0();
    }

    private void B0(View view) {
        QFSBlockContainer qFSBlockContainer = (QFSBlockContainer) view.findViewById(R.id.t5g);
        this.f84776f = qFSBlockContainer;
        ViewGroup.LayoutParams layoutParams = qFSBlockContainer.getLayoutParams();
        layoutParams.height = cx.b(getContext()) - cx.h();
        QLog.d("QFSAggregationBottomWidget", 2, "initBlockContainer : width =" + layoutParams.width + " , height : " + layoutParams.height);
        setLayoutParams(layoutParams);
        this.f84776f.setLayoutManagerType(2, 3);
        this.f84776f.getRecyclerView().setNestedScrollingEnabled(true);
        this.f84776f.registerBlock(this.f84778i);
        this.f84776f.setRefreshing(false);
        this.f84776f.setEnableLoadMore(true);
        this.f84776f.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        if (getContext() != null) {
            QFSNormalNoMoreHintView qFSNormalNoMoreHintView = new QFSNormalNoMoreHintView(getContext());
            qFSNormalNoMoreHintView.setHintTextColor(getContext().getResources().getColorStateList(R.color.qui_common_text_tertiary));
            this.f84776f.getBlockMerger().setCustomNoMoreDataView(qFSNormalNoMoreHintView);
        }
        this.f84776f.getRecyclerView().addOnScrollListener(new c());
        this.f84776f.start();
    }

    private void C0() {
        w30.b bVar = new w30.b(new Bundle());
        this.f84778i = bVar;
        bVar.setOnLoadDataDelegate(new a());
        this.f84778i.o0(new b());
    }

    private void D0() {
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel = (QFSFlowAggregationViewModel) getViewModel(this.f84775e, QFSFlowAggregationViewModel.class);
        this.f84777h = qFSFlowAggregationViewModel;
        qFSFlowAggregationViewModel.a2().observe(this, new d());
    }

    private boolean E0() {
        w30.b bVar = this.f84778i;
        if (bVar != null && !bVar.k0()) {
            return false;
        }
        return true;
    }

    private void initView() {
        C0();
        B0(this);
        this.f84779m = (QFSAggregationBottomHintView) findViewById(R.id.x_w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i3, e30.b bVar, View view) {
        if (bVar == null) {
            return;
        }
        QCircleLayerBean s06 = s0(i3, bVar);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i16 = iArr[0];
        s06.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], view.getWidth() + i16, iArr[1] + view.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(bVar.g().cover.picUrl.get()));
        com.tencent.biz.qqcircle.launcher.c.u(getContext(), s06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i3, e30.b bVar, View view) {
        if (bVar != null && this.f84777h.p2()) {
            QCircleLayerBean s06 = s0(i3, bVar);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i16 = iArr[0];
            s06.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], view.getWidth() + i16, iArr[1] + view.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(bVar.g().cover.picUrl.get()));
            s06.setCurrentIsCollection(this.f84777h.M.booleanValue()).setUnifiedType(this.f84777h.j2()).setUnifiedId(this.f84777h.i2()).setSongMid(this.f84777h.h2()).setAggregationType(this.f84775e.sh()).setIsShareFromArk(this.f84777h.g2()).setJumpSchema(this.f84777h.c2());
            com.tencent.biz.qqcircle.launcher.c.u(getContext(), s06);
            return;
        }
        QLog.w("QFSAggregationBottomWidget", 1, "isDataReady:" + this.f84777h.p2());
    }

    private void r0() {
        if (E0()) {
            this.f84779m.l0("", h.a(R.string.f188043vm));
            QLog.i(getLogTag(), 1, "checkEmptyContentOperation  isEmptyContent");
        }
    }

    private QCircleLayerBean s0(int i3, e30.b bVar) {
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setFeed(bVar.g());
        qCircleLayerBean.setTransInitBean(QCirclePluginUtil.getQCircleInitBean(getContext()));
        qCircleLayerBean.setDataPosInList(i3);
        qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
        qCircleLayerBean.setGlobalViewModelKey(this.f84777h.k2());
        qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
        qCircleLayerBean.setPageCode(hashCode());
        return qCircleLayerBean;
    }

    private void u0(QCircleFeedEvent qCircleFeedEvent) {
        boolean n06 = this.f84778i.n0(qCircleFeedEvent.mTargetId);
        QLog.i(getLogTag(), 1, "handleFSFeedEvent removeFeed  feedId = " + qCircleFeedEvent.mTargetId + " | result = " + n06);
    }

    private void v0(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        String msg2;
        w30.b bVar;
        QLog.e("QFSAggregationBottomWidget", 1, "handleFeedsRsp() return empty data");
        if (uIStateData.getIsLoadMore() && (bVar = this.f84778i) != null && bVar.getNUM_BACKGOURND_ICON() > 0) {
            this.f84778i.getLoadInfo().setFinish(z16);
            return;
        }
        if (uIStateData.getMsg() == null) {
            msg2 = h.a(R.string.f188043vm);
        } else {
            msg2 = uIStateData.getMsg();
        }
        this.f84779m.l0("", msg2);
    }

    private void w0(UIStateData<List<e30.b>> uIStateData) {
        String msg2;
        if (uIStateData.getMsg() == null) {
            msg2 = h.a(R.string.f181603e8);
        } else {
            msg2 = uIStateData.getMsg();
        }
        QLog.e("QFSAggregationBottomWidget", 1, "handleFeedsRsp() return error\uff01errMsg:" + msg2);
        w30.b bVar = this.f84778i;
        if (bVar != null && bVar.getNUM_BACKGOURND_ICON() > 0) {
            cj.c(false, uIStateData.getRetCode(), msg2, 1, QCircleToast.f91645e);
        }
        this.f84779m.m0("", msg2);
    }

    private void x0(QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent.mState == 3) {
            u0(qCircleFeedEvent);
            r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(UIStateData<List<e30.b>> uIStateData) {
        boolean z16;
        w30.b bVar;
        if (uIStateData == null) {
            return;
        }
        boolean isFinish = uIStateData.getIsFinish();
        int state = uIStateData.getState();
        if (state != 0) {
            if (state != 1) {
                z16 = false;
                if (state != 2) {
                    if (state != 3) {
                        if (state == 4) {
                            w0(uIStateData);
                        }
                    } else {
                        A0(uIStateData, isFinish);
                    }
                } else {
                    A0(uIStateData, isFinish);
                }
                if (!z16 && (bVar = this.f84778i) != null) {
                    bVar.getLoadInfo().setFinish(isFinish);
                    this.f84778i.notifyLoadingComplete(true);
                    return;
                }
            }
            this.f84779m.n0();
        } else {
            v0(uIStateData, isFinish);
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFeedEvent.class);
        arrayList.add(QFSLayerFeedPosSyncEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g7f;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f84774d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSAggregationBottomWidget";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f84774d.setCurrentState(Lifecycle.State.STARTED);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                float abs = Math.abs(this.F - x16);
                float abs2 = Math.abs(this.G - y16);
                if (x16 - this.F > this.C && abs * this.D > abs2) {
                    return true;
                }
            }
        } else {
            this.F = motionEvent.getX();
            this.G = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFeedEvent) {
            x0((QCircleFeedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSLayerFeedPosSyncEvent) {
            z0((QFSLayerFeedPosSyncEvent) simpleBaseEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            float x16 = motionEvent.getX();
            float f16 = this.F;
            if (x16 - f16 > 0.0f && x16 - f16 >= this.E / 4.0f && (getContext() instanceof Activity)) {
                ((Activity) getContext()).onBackPressed();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setParentRecyclerView(NestScrollRecyclerView nestScrollRecyclerView) {
        this.H = nestScrollRecyclerView;
    }

    public void z0(@NonNull QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        QLog.d("QFSAggregationBottomWidget", 4, "QFSLayerFeedPosSyncEvent position = " + qFSLayerFeedPosSyncEvent.getPos());
        if (this.f84778i != null && this.f84777h != null && qFSLayerFeedPosSyncEvent.getPageCode() == hashCode()) {
            ad.f(this.f84778i.getDataList(), this.f84778i.getParentRecyclerView(), this.H, qFSLayerFeedPosSyncEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(List<e30.b> list, int i3) {
    }
}
