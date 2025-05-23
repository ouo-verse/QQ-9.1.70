package com.tencent.biz.qqcircle.widgets.polymerization;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.adapter.ag;
import com.tencent.biz.qqcircle.aspectj.QCircleAspectScrollProcessor;
import com.tencent.biz.qqcircle.beans.QCircleHotEventPolymerizationBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment;
import com.tencent.biz.qqcircle.immersive.QFSBlockContainer;
import com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationBottomHintView;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNormalNoMoreHintView;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.List;
import t30.f;

/* loaded from: classes5.dex */
public class QFSPolymerizationBottomView extends QCircleBaseWidgetView<List<e30.b>> implements LifecycleOwner, SimpleEventReceiver {
    private String C;
    private int D;
    private double E;
    private float F;
    private float G;
    private float H;
    private int I;
    private int J;
    protected int K;
    protected RecyclerView L;
    private RecyclerView M;
    private f N;

    /* renamed from: d, reason: collision with root package name */
    private final LifecycleRegistry f93778d;

    /* renamed from: e, reason: collision with root package name */
    private QFSBlockContainer f93779e;

    /* renamed from: f, reason: collision with root package name */
    private QCirclePolymerizationViewModel f93780f;

    /* renamed from: h, reason: collision with root package name */
    private ag f93781h;

    /* renamed from: i, reason: collision with root package name */
    private QFSAggregationBottomHintView f93782i;

    /* renamed from: m, reason: collision with root package name */
    private QCirclePolymerizationBean f93783m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements MultiViewBlock.OnLoadDataDelegate {
        a() {
        }

        @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
        public void onLoadData(LoadInfo loadInfo, Object obj) {
            if (loadInfo.isLoadMoreState() && QFSPolymerizationBottomView.this.f93780f != null) {
                QLog.i("QFSPolymerizationBottomView", 1, "onLoadData requestPolymerizationData");
                QFSPolymerizationBottomView.this.f93780f.g2(QFSPolymerizationBottomView.this.getContext(), QFSPolymerizationBottomView.this.f93783m, true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        private void handleScrollStateChanged(int i3) {
            QCircleAspectScrollProcessor.getInstance().onScrollState(QFSPolymerizationBottomView.this, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
            handleScrollStateChanged(i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            SafeGridLayoutManager safeGridLayoutManager = (SafeGridLayoutManager) recyclerView.getLayoutManager();
            QFSPolymerizationBottomView.this.I = safeGridLayoutManager.findFirstVisibleItemPosition();
            QFSPolymerizationBottomView.this.J = safeGridLayoutManager.findLastVisibleItemPosition();
            QFSPolymerizationBottomView qFSPolymerizationBottomView = QFSPolymerizationBottomView.this;
            qFSPolymerizationBottomView.K = ((qFSPolymerizationBottomView.I + QFSPolymerizationBottomView.this.J) / 2) / 3;
        }
    }

    public QFSPolymerizationBottomView(@NonNull Context context, NestScrollRecyclerView nestScrollRecyclerView) {
        super(context);
        this.C = null;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.M = nestScrollRecyclerView;
        I0(this);
        H0();
        G0(this);
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.f93778d = lifecycleRegistry;
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        this.D = ViewConfiguration.get(context).getScaledTouchSlop();
        this.F = ImmersiveUtils.getScreenWidth();
        this.E = Math.tan(0.5235987755982988d);
        J0();
    }

    private void A0(QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent.mState == 3) {
            x0(qCircleFeedEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(UIStateData<List<e30.b>> uIStateData) {
        boolean z16;
        ag agVar;
        if (uIStateData == null) {
            return;
        }
        boolean isFinish = uIStateData.getIsFinish();
        int state = uIStateData.getState();
        if (state != 0) {
            z16 = false;
            if (state != 2) {
                if (state != 3) {
                    if (state == 4) {
                        z0(uIStateData);
                    }
                } else {
                    F0(uIStateData, isFinish);
                }
            } else {
                F0(uIStateData, isFinish);
            }
            if (!z16 && (agVar = this.f93781h) != null) {
                agVar.getLoadInfo().setFinish(isFinish);
                this.f93781h.notifyLoadingComplete(true);
                this.L = this.f93781h.getParentRecyclerView();
                M0();
                return;
            }
        }
        y0(uIStateData, isFinish);
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(UIStateData<List<e30.b>> uIStateData) {
        RFWLog.d("QFSPolymerizationBottomView", RFWLog.USR, "handleModify");
        List<e30.b> data = uIStateData.getData();
        if (data == null) {
            data = new ArrayList<>();
        }
        ag agVar = this.f93781h;
        if (agVar != null) {
            agVar.setDatas(data);
        }
    }

    private void E0(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        ViewGroup.LayoutParams layoutParams = this.f93779e.getLayoutParams();
        layoutParams.width = bz.i(getContext());
        layoutParams.height = DisplayUtil.getInstantScreenHeight(getContext()) - cx.h();
        QLog.d("QFSPolymerizationBottomView", 1, "handleOnConfigEvent : width =" + layoutParams.width + " , height : " + layoutParams.height);
        this.f93779e.getRecyclerView().setLayoutParams(layoutParams);
        this.f93782i.setLayoutParams(layoutParams);
    }

    private void F0(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        if (this.f93781h == null) {
            return;
        }
        if (uIStateData.getIsLoadMore()) {
            this.f93781h.addAll(uIStateData.getData());
        } else {
            this.f93781h.setDatas(uIStateData.getData());
        }
        this.f93781h.getLoadInfo().setFinish(z16);
        this.f93782i.k0();
    }

    private void G0(View view) {
        QFSBlockContainer qFSBlockContainer = (QFSBlockContainer) view.findViewById(R.id.t5g);
        this.f93779e = qFSBlockContainer;
        ViewGroup.LayoutParams layoutParams = qFSBlockContainer.getLayoutParams();
        layoutParams.width = bz.i(getContext());
        layoutParams.height = DisplayUtil.getInstantScreenHeight(getContext()) - cx.h();
        this.f93779e.setLayoutParams(layoutParams);
        this.f93779e.setLayoutManagerType(2, 3);
        this.f93779e.getRecyclerView().setNestedScrollingEnabled(true);
        this.f93779e.registerBlock(this.f93781h);
        this.f93779e.setRefreshing(false);
        this.f93779e.setEnableLoadMore(true);
        this.f93779e.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        if (getContext() != null) {
            QFSNormalNoMoreHintView qFSNormalNoMoreHintView = new QFSNormalNoMoreHintView(getContext());
            qFSNormalNoMoreHintView.setHintTextColor(getContext().getResources().getColorStateList(R.color.qui_common_text_tertiary));
            this.f93779e.getBlockMerger().setCustomNoMoreDataView(qFSNormalNoMoreHintView);
        }
        this.f93779e.start();
    }

    private void H0() {
        ag r06 = new ag(new Bundle()).t0(0).r0(((QCirclePolymerizationViewModel) getViewModel((QCirclePolymerizationFragment) getQCircleBaseFragment(), QCirclePolymerizationViewModel.class)).X1());
        this.f93781h = r06;
        r06.setOnLoadDataDelegate(new a());
        this.f93781h.setReportBean(getReportBean());
        this.f93781h.s0(new ag.b() { // from class: com.tencent.biz.qqcircle.widgets.polymerization.a
            @Override // com.tencent.biz.qqcircle.adapter.ag.b
            public final void a(int i3, e30.b bVar, View view) {
                QFSPolymerizationBottomView.this.v0(i3, bVar, view);
            }
        });
        f fVar = new f(getLogTag(), this.f93781h, new f.b() { // from class: com.tencent.biz.qqcircle.widgets.polymerization.b
            @Override // t30.f.b
            public final void a(UIStateData uIStateData) {
                QFSPolymerizationBottomView.this.D0(uIStateData);
            }
        });
        this.N = fVar;
        fVar.a2(1);
        onResume();
    }

    private void I0(View view) {
        QFSAggregationBottomHintView qFSAggregationBottomHintView = (QFSAggregationBottomHintView) view.findViewById(R.id.x_w);
        this.f93782i = qFSAggregationBottomHintView;
        ViewGroup.LayoutParams layoutParams = qFSAggregationBottomHintView.getLayoutParams();
        layoutParams.width = bz.i(getContext());
        layoutParams.height = (DisplayUtil.getInstantScreenHeight(getContext()) - cx.h()) - cx.a(52.0f);
        this.f93782i.setLayoutParams(layoutParams);
    }

    private void J0() {
        QCirclePolymerizationViewModel qCirclePolymerizationViewModel = (QCirclePolymerizationViewModel) getViewModel((QCirclePolymerizationFragment) getQCircleBaseFragment(), QCirclePolymerizationViewModel.class);
        this.f93780f = qCirclePolymerizationViewModel;
        QCirclePolymerizationBean X1 = qCirclePolymerizationViewModel.X1();
        this.f93783m = X1;
        this.C = String.valueOf(X1.getPolymerizationType());
        w20.a.j().registerDisplaySurface(this.C, this.f93780f);
        this.f93780f.f92797m.observe((QCirclePolymerizationFragment) getQCircleBaseFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.widgets.polymerization.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPolymerizationBottomView.this.B0((UIStateData) obj);
            }
        });
    }

    private boolean K0(QCircleLayerBean.QFSTagPolymerizationBean qFSTagPolymerizationBean) {
        if (qFSTagPolymerizationBean != null && !"0".equals(qFSTagPolymerizationBean.feedTagPageFromType)) {
            return true;
        }
        return false;
    }

    private void L0(e30.b bVar, int i3) {
        if (this.f93783m.getPolymerizationType() == 63 && (this.f93783m instanceof QCircleHotEventPolymerizationBean)) {
            QCircleLpReportDc05507.DataBuilder c16 = ua0.c.c(bVar.g());
            c16.setPageId(303).setActionType(605).setSubActionType(2).setExt4(Integer.toString(i3 + 1));
            if (this.f93783m.getHotEventInfo() != null) {
                c16.setExt2(this.f93783m.getHotEventInfo().getId());
            }
            QCircleLpReportDc05507.report(c16);
        }
    }

    private void M0() {
        this.f93779e.getRecyclerView().addOnScrollListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int i3, e30.b bVar, View view) {
        if (bVar == null) {
            return;
        }
        QCircleLayerBean w06 = w0(i3, bVar);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i16 = iArr[0];
        w06.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i16, iArr[1], view.getWidth() + i16, iArr[1] + view.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(bVar.g().cover.picUrl.get()));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0 && (viewGroup.getChildAt(0) instanceof FrameLayout)) {
                FrameLayout frameLayout = (FrameLayout) viewGroup.getChildAt(0);
                if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                    w06.getTransitionAnimBean().setCoverDrawable(((ImageView) frameLayout.getChildAt(0)).getDrawable());
                }
            }
        }
        com.tencent.biz.qqcircle.launcher.c.u(getContext(), w06);
        L0(bVar, i3);
    }

    private QCircleLayerBean w0(int i3, e30.b bVar) {
        String str;
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setFeed(bVar.g());
        qCircleLayerBean.setDataPosInList(i3);
        qCircleLayerBean.setTransInitBean(this.f93783m);
        String str2 = this.C;
        if (str2 == null) {
            str2 = String.valueOf(this.f93783m.getPolymerizationType());
        }
        qCircleLayerBean.setGlobalViewModelKey(str2);
        qCircleLayerBean.setTagInfo(this.f93783m.getTagInfo());
        qCircleLayerBean.setPolymerizationType(this.f93783m.getPolymerizationType());
        qCircleLayerBean.setQfsTagPolymerizationBean(this.f93780f.Z1());
        if (K0(this.f93780f.Z1())) {
            str = "biz_wink_tag_polymerization";
        } else if (this.f93783m.getPolymerizationType() == 7) {
            str = "biz_polymerization";
        } else {
            str = "biz_data_share";
        }
        qCircleLayerBean.setLayerBizAssemblerType(str);
        qCircleLayerBean.setPageCode(hashCode());
        return qCircleLayerBean;
    }

    private void x0(QCircleFeedEvent qCircleFeedEvent) {
        ag agVar = this.f93781h;
        if (agVar == null) {
            QLog.e("QFSPolymerizationBottomView", 1, "[handleDeleteFeed] mFeedsBlock is null");
            return;
        }
        QLog.i("QFSPolymerizationBottomView", 1, "[handleDeleteFeed] feedId = " + qCircleFeedEvent.mTargetId + " | result = " + agVar.q0(qCircleFeedEvent.mTargetId));
        if (this.f93781h.getNUM_BACKGOURND_ICON() == 0) {
            QFSAggregationBottomHintView qFSAggregationBottomHintView = this.f93782i;
            if (qFSAggregationBottomHintView != null) {
                qFSAggregationBottomHintView.l0("", h.a(R.string.f188043vm));
            }
            QLog.i("QFSPolymerizationBottomView", 1, "[handleDeleteFeed] isEmptyContent");
        }
    }

    private void y0(UIStateData<List<e30.b>> uIStateData, boolean z16) {
        String msg2;
        ag agVar;
        QLog.e("QFSPolymerizationBottomView", 1, "handleFeedsRsp() return empty data");
        if (uIStateData.getIsLoadMore() && (agVar = this.f93781h) != null && agVar.getNUM_BACKGOURND_ICON() > 0) {
            this.f93781h.getLoadInfo().setFinish(z16);
            return;
        }
        if (uIStateData.getMsg() == null) {
            msg2 = h.a(R.string.f188043vm);
        } else {
            msg2 = uIStateData.getMsg();
        }
        this.f93782i.l0("", msg2);
    }

    private void z0(UIStateData<List<e30.b>> uIStateData) {
        String msg2;
        if (uIStateData.getMsg() == null) {
            msg2 = h.a(R.string.f181603e8);
        } else {
            msg2 = uIStateData.getMsg();
        }
        QLog.e("QFSPolymerizationBottomView", 1, "handleFeedsRsp() return error\uff01errMsg:" + msg2);
        ag agVar = this.f93781h;
        if (agVar != null && agVar.getNUM_BACKGOURND_ICON() > 0) {
            cj.c(false, uIStateData.getRetCode(), msg2, 1, QCircleToast.f91645e);
        }
        this.f93782i.m0("", msg2);
        if (!HostNetworkUtils.isNetworkAvailable() && getQCircleBaseFragment() != null) {
            getQCircleBaseFragment().getPartManager().broadcastMessage("publish_show_or_hide", Boolean.FALSE);
        }
    }

    public void C0(@NonNull QFSLayerFeedPosSyncEvent qFSLayerFeedPosSyncEvent) {
        QLog.d("QFSPolymerizationBottomView", 4, "QFSLayerFeedPosSyncEvent position = " + qFSLayerFeedPosSyncEvent.getPos());
        if (this.f93781h != null && this.f93783m != null && qFSLayerFeedPosSyncEvent.getPageCode() == hashCode()) {
            ad.f(this.f93781h.getDataList(), this.L, this.M, qFSLayerFeedPosSyncEvent);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSLayerFeedPosSyncEvent.class);
        arrayList.add(QCircleConfigChangeEvent.class);
        arrayList.add(QCircleFeedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gno;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.f93778d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPolymerizationBottomView";
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public QCircleBaseFragment getQCircleBaseFragment() {
        ViewModelStoreOwner viewModelStoreOwner = ViewTreeViewModelStoreOwner.get(this.M);
        if (viewModelStoreOwner instanceof QCircleBaseFragment) {
            return (QCircleBaseFragment) viewModelStoreOwner;
        }
        return super.getQCircleBaseFragment();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f93778d.setCurrentState(Lifecycle.State.STARTED);
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
                float abs = Math.abs(this.G - x16);
                float abs2 = Math.abs(this.H - y16);
                if (x16 - this.G > this.D && abs * this.E > abs2) {
                    return true;
                }
            }
        } else {
            this.G = motionEvent.getX();
            this.H = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onPause() {
        f fVar = this.N;
        if (fVar != null) {
            fVar.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSLayerFeedPosSyncEvent) {
            C0((QFSLayerFeedPosSyncEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            E0((QCircleConfigChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleFeedEvent) {
            A0((QCircleFeedEvent) simpleBaseEvent);
        }
    }

    public void onResume() {
        f fVar = this.N;
        if (fVar != null) {
            fVar.onResume();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            float x16 = motionEvent.getX();
            float f16 = this.G;
            if (x16 - f16 > 0.0f && x16 - f16 >= this.F / 4.0f && (getContext() instanceof Activity)) {
                ((Activity) getContext()).onBackPressed();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void bindData(List<e30.b> list, int i3) {
    }
}
