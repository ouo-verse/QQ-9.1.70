package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleShareItemClickEvent;
import com.tencent.biz.qqcircle.utils.bq;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedBottomShareGuideView extends c implements View.OnClickListener, SimpleEventReceiver {
    private static final List<Integer> J;
    private FrameLayout D;
    private ViewFlipper E;
    private TextView F;
    private View G;
    private View H;
    private Runnable I;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ViewFlipper> f90570a;

        public b(ViewFlipper viewFlipper) {
            this.f90570a = new WeakReference<>(viewFlipper);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            ViewFlipper viewFlipper = this.f90570a.get();
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (viewFlipper != null && (viewFlipper.getCurrentView() instanceof TextView)) {
                buildElementParams.put("xsj_item_name", ((TextView) viewFlipper.getCurrentView()).getText().toString());
            }
            return buildElementParams;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        J = arrayList;
        arrayList.add(0);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(14);
    }

    public QFSFeedBottomShareGuideView(@NonNull com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
    }

    private void A() {
        if (this.E != null && this.F != null) {
            int t46 = uq3.c.t4();
            if (t46 != 0) {
                if (t46 != 1) {
                    if (t46 == 2) {
                        this.F.setText("\u5206\u4eab\u7ed9\u597d\u53cb\uff0c\u901f\u6765\u56f4\u89c2");
                        this.F.setVisibility(0);
                        this.E.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.F.setText("\u5206\u4eab\u89c6\u9891\uff0c\u52a0\u901f\u6d41\u91cf\u66dd\u5149");
                this.F.setVisibility(0);
                this.E.setVisibility(8);
                return;
            }
            this.F.setVisibility(8);
            this.E.setVisibility(0);
            this.E.setDisplayedChild(new Random().nextInt(this.E.getChildCount()));
        }
    }

    private boolean B() {
        ViewFlipper viewFlipper = this.E;
        if (viewFlipper != null && viewFlipper.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private boolean C() {
        boolean z16;
        boolean z17;
        if (this.f90602e == null) {
            return false;
        }
        boolean isFromMainProduct = QCirclePluginUtil.isFromMainProduct(j());
        boolean isPrivateFeed = QCirclePluginUtil.isPrivateFeed(this.f90602e);
        boolean d16 = bq.d("sp_key_share_guild_showed_last_time", "sp_key_share_guild_count", uq3.c.r4() / 86400, uq3.c.s4());
        if (com.tencent.biz.qqcircle.immersive.utils.r.z().size() >= uq3.c.H2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z(this.f90601d) && !z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean J2 = com.tencent.biz.qqcircle.immersive.utils.r.J(l());
        if (!isFromMainProduct || isPrivateFeed || !z17 || d16 || J2) {
            return false;
        }
        return true;
    }

    private void D() {
        if (this.D != null) {
            QLog.d("QFSFeedBottomShareGuideView", 1, "mLayout has inflate");
            return;
        }
        ViewStub viewStub = (ViewStub) this.f90604h.findViewById(R.id.f34700zv);
        this.G = this.f90604h.findViewById(R.id.f34510zc);
        this.H = this.f90604h.findViewById(R.id.f39941d1);
        if (viewStub != null && this.f90602e != null) {
            View inflate = viewStub.inflate();
            this.D = (FrameLayout) inflate.findViewById(R.id.f34680zt);
            this.E = (ViewFlipper) inflate.findViewById(R.id.f34690zu);
            this.F = (TextView) inflate.findViewById(R.id.f34670zs);
            this.D.setOnClickListener(this);
            x();
            this.I = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedBottomShareGuideView.2
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("QFSFeedBottomShareGuideView", 1, "[mShowShareGuideViewRunnable] startShowAnim");
                    QFSFeedBottomShareGuideView.this.H();
                }
            };
        }
    }

    private void E() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed) && QCirclePluginUtil.isFromMainProduct(j())) {
            QLog.d("QFSFeedBottomShareGuideView", 1, "[handleShareItemClickEvent] saveSharedOwnerFeed");
            com.tencent.biz.qqcircle.immersive.utils.r.c1(l(), true);
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z16) {
        int i3;
        FrameLayout frameLayout = this.D;
        if (frameLayout == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        frameLayout.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (!B()) {
            return;
        }
        this.E.startFlipping();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        FrameLayout frameLayout = this.D;
        if (frameLayout != null && this.E != null && this.F != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat.setDuration(250L);
            ofFloat.setStartDelay(80L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.G, "translationY", DisplayUtil.dip2px(j(), 42.0f), 0.0f);
            ofFloat2.setDuration(250L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.H, "translationY", DisplayUtil.dip2px(j(), 42.0f), 0.0f);
            ofFloat3.setDuration(250L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(330L);
            animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat);
            animatorSet.start();
            animatorSet.addListener(new a());
            FrameLayout frameLayout2 = this.D;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(4);
            }
        }
    }

    private void I() {
        if (!B()) {
            return;
        }
        this.E.stopFlipping();
    }

    public static void J(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSFeedBottomShareGuideView", 1, "[updateHasDoAnimShareGuideView] mFeedBlockData is null");
        } else {
            bVar.o("share_guide_has_do_animation", Boolean.TRUE);
        }
    }

    private void w() {
        if (this.I != null) {
            n().removeCallbacks(this.I);
        }
    }

    private void x() {
        FrameLayout frameLayout = this.D;
        if (frameLayout != null && this.f90602e != null && this.E != null) {
            VideoReport.setElementId(frameLayout, QCircleDaTongConstant.ElementId.EM_XSJ_SHARE_GUIDE_BAR);
            VideoReport.setElementReuseIdentifier(this.D, QCircleDaTongConstant.ElementId.EM_XSJ_SHARE_GUIDE_BAR + this.f90602e.f398449id.get());
            if (uq3.c.t4() != 0) {
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.put("xsj_item_name", this.F.getText().toString());
                VideoReport.setElementParams(this.D, buildElementParams);
                return;
            }
            VideoReport.setEventDynamicParams(this.D, new b(this.E));
        }
    }

    private void y(QCircleShareItemClickEvent qCircleShareItemClickEvent) {
        if (qCircleShareItemClickEvent != null && J.contains(Integer.valueOf(qCircleShareItemClickEvent.getAction()))) {
            E();
        }
    }

    public static boolean z(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSFeedBottomShareGuideView", 1, "[hasDoAnimShareGuideView] mFeedBlockData is null");
            return false;
        }
        Object b16 = bVar.b("share_guide_has_do_animation");
        if (!(b16 instanceof Boolean)) {
            return false;
        }
        QLog.e("QFSFeedBottomShareGuideView", 1, "[hasDoAnimShareGuideView] hasDoAnim =" + b16);
        return ((Boolean) b16).booleanValue();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleShareItemClickEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 125;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return C();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.D != null && view.getId() == R.id.f34680zt) {
            s(new com.tencent.biz.qqcircle.immersive.feed.event.ab(6));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void onDestroy() {
        super.onDestroy();
        com.tencent.biz.qqcircle.immersive.utils.r.L0();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        D();
        A();
        w();
        n().postDelayed(this.I, 2000L);
        QLog.d("QFSFeedBottomShareGuideView", 1, "[onElementActivated] postDelayed runnable");
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        w();
        F(false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleShareItemClickEvent) {
            y((QCircleShareItemClickEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        I();
        w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QFSFeedBottomShareGuideView.this.F(true);
            com.tencent.biz.qqcircle.immersive.utils.r.b(QFSFeedBottomShareGuideView.this.l());
            bq.h("sp_key_share_guild_showed_last_time", "sp_key_share_guild_count", uq3.c.s4());
            QFSFeedBottomShareGuideView.J(QFSFeedBottomShareGuideView.this.f90601d);
            QFSFeedBottomShareGuideView.this.G();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
