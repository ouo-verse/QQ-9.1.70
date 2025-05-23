package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleShoppingGoodsInfoBean;
import com.tencent.biz.qqcircle.events.QCircleShoppingCartPopWindowEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class QFSMainShoppingCartPart extends u implements SimpleEventReceiver, View.OnClickListener {
    private LinearLayout C;
    private FrameLayout D;
    private ViewStub E;
    private LinearLayout F;
    private FeedCloudMeta$StFeed G;
    private ArrayList<MultiViewBlock> H = new ArrayList<>();
    private boolean I;
    private String J;

    /* renamed from: d, reason: collision with root package name */
    private q70.a f87431d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleBlockContainer f87432e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.adapter.ar f87433f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleShoppingGoodsInfoBean f87434h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f87435i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleSlidBottomView f87436m;

    private void D9(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f54562fj);
        this.E = viewStub;
        LinearLayout linearLayout = (LinearLayout) viewStub.inflate().findViewById(R.id.f84684mx);
        this.C = linearLayout;
        this.f87432e = (QCircleBlockContainer) linearLayout.findViewById(R.id.f32680ue);
        this.f87436m = (QCircleSlidBottomView) this.C.findViewById(R.id.f32690uf);
        this.D = (FrameLayout) this.C.findViewById(R.id.f32660uc);
        this.F = (LinearLayout) this.C.findViewById(R.id.f32670ud);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.y1m);
        this.f87435i = imageView;
        imageView.setOnClickListener(this);
        I9();
    }

    private void E9() {
        com.tencent.biz.qqcircle.adapter.ar arVar = new com.tencent.biz.qqcircle.adapter.ar(null, this.f87434h, this.f87431d);
        this.f87433f = arVar;
        arVar.setBlockVisible(true);
        if (getReportBean() != null) {
            this.f87433f.setReportBean(getReportBean());
        }
        this.H.add(this.f87433f);
        this.f87432e.getRecyclerView().setItemAnimator(new EnhanceItemAnimator());
        QLog.d("QFSMainShoppingCartPart", 1, "register shop Block ");
        this.f87432e.registerBlock(this.H);
        this.f87432e.start();
        this.I = true;
    }

    private void F9() {
        if (getPartRootView() != null && this.E == null) {
            D9(getPartRootView());
            G9();
            H9();
        }
    }

    private void G9() {
        this.f87436m.setOnClickListener(new a());
        this.f87436m.e(new b());
        com.tencent.biz.qqcircle.immersive.utils.ax.c(this.f87436m, getPageId(), com.tencent.biz.qqcircle.utils.cx.a(10.0f));
    }

    private void H9() {
        if (this.f87431d == null) {
            this.f87431d = (q70.a) getViewModel(q70.a.class);
        }
        this.f87431d.N1().observe(getHostFragment(), new Observer<QCircleShoppingGoodsInfoBean>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainShoppingCartPart.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean) {
                if (qCircleShoppingGoodsInfoBean != null) {
                    QFSMainShoppingCartPart.this.f87434h = qCircleShoppingGoodsInfoBean;
                    if ((QFSMainShoppingCartPart.this.f87433f == null || QFSMainShoppingCartPart.this.f87433f.l0() == null || !TextUtils.equals(QFSMainShoppingCartPart.this.f87434h.getDesc(), QFSMainShoppingCartPart.this.f87433f.l0().getDesc())) && QFSMainShoppingCartPart.this.F != null) {
                        QFSMainShoppingCartPart.this.F.setVisibility(0);
                    }
                    QFSMainShoppingCartPart.this.initBlockContainer();
                    QFSMainShoppingCartPart.this.getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSMainShoppingCartPart.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QFSMainShoppingCartPart.this.F != null) {
                                QFSMainShoppingCartPart.this.F.setVisibility(8);
                            }
                        }
                    }, 100L);
                }
            }
        });
    }

    private void I9() {
        QCircleSlidBottomView qCircleSlidBottomView;
        QCircleBlockContainer qCircleBlockContainer = this.f87432e;
        if (qCircleBlockContainer == null) {
            QLog.d("QFSMainShoppingCartPart", 1, "[updateBlockContainerPadding] block container not is null.");
            return;
        }
        if (qCircleBlockContainer.getContext() == null) {
            return;
        }
        if (getPageId() == 57 && (qCircleSlidBottomView = this.f87436m) != null) {
            qCircleSlidBottomView.setIsShoppingCart(true);
            this.f87436m.f();
        }
        QCircleBlockContainer qCircleBlockContainer2 = this.f87432e;
        qCircleBlockContainer2.setPadding(qCircleBlockContainer2.getPaddingLeft(), this.f87432e.getPaddingTop(), this.f87432e.getPaddingRight(), 0);
        if (getPageId() == 57) {
            QCircleBlockContainer qCircleBlockContainer3 = this.f87432e;
            qCircleBlockContainer3.setPadding(qCircleBlockContainer3.getPaddingLeft(), this.f87432e.getPaddingTop(), this.f87432e.getPaddingRight(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBlockContainer() {
        if (this.I && this.H.size() > 0) {
            return;
        }
        this.f87432e.setLayoutManagerType(1, 1);
        this.f87432e.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        this.f87432e.setParentFragment(getHostFragment());
        this.f87432e.setEnableLoadMore(true);
        this.f87432e.setEnableRefresh(false);
        this.f87432e.setParentFragment(getHostFragment());
        this.f87432e.getRecyclerView().setNestedScrollingEnabled(true);
        E9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleShoppingCartPopWindowEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMainShoppingCartPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QCircleSlidBottomView qCircleSlidBottomView = this.f87436m;
        if (qCircleSlidBottomView != null && qCircleSlidBottomView.getVisibility() == 0) {
            this.f87436m.g();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.y1m) {
            this.f87436m.g();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        H9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.immersive.utils.ax.b(this.f87436m);
        getMainHandler().removeCallbacksAndMessages(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        getMainHandler().removeCallbacksAndMessages(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleShoppingCartPopWindowEvent) {
            QCircleShoppingCartPopWindowEvent qCircleShoppingCartPopWindowEvent = (QCircleShoppingCartPopWindowEvent) simpleBaseEvent;
            FeedCloudMeta$StFeed feed = qCircleShoppingCartPopWindowEvent.getFeed();
            this.J = qCircleShoppingCartPopWindowEvent.getJumpUrl();
            this.f87431d = (q70.a) getViewModel(q70.a.class);
            if (this.G == null || !feed.f398449id.get().equals(this.G.f398449id.get())) {
                this.G = feed;
                this.f87431d.Q1(feed, this.J);
                F9();
                this.F.setVisibility(0);
            }
            this.f87436m.x(this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
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
        public /* synthetic */ void onConfigurationChanged() {
            com.tencent.biz.qqcircle.utils.ad.a(this);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onDismiss() {
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(true, QFSMainShoppingCartPart.this.getContext()));
            com.tencent.biz.qqcircle.immersive.utils.ax.h(QFSMainShoppingCartPart.this.getContext(), true);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onShow() {
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(false, QFSMainShoppingCartPart.this.getContext()));
            com.tencent.biz.qqcircle.immersive.utils.ax.h(QFSMainShoppingCartPart.this.getContext(), false);
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onStatusChange(int i3) {
        }

        @Override // com.tencent.biz.qqcircle.utils.QCircleSlidBottomView.d
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
        }
    }
}
