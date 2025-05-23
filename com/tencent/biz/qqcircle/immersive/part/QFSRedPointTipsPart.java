package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRedPointTipsEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleCounter$RedPointInfo;

/* loaded from: classes4.dex */
public class QFSRedPointTipsPart extends u implements SimpleEventReceiver, View.OnClickListener, IOrderElement {
    private static final int H = ViewUtils.dpToPx(44.0f);
    private final Runnable C;
    private String D;
    private List<String> E;
    private int F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private View f87554d;

    /* renamed from: e, reason: collision with root package name */
    private View f87555e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAvatarListView f87556f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f87557h;

    /* renamed from: i, reason: collision with root package name */
    private View f87558i;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f87559m;

    /* renamed from: com.tencent.biz.qqcircle.immersive.part.QFSRedPointTipsPart$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ QFSRedPointTipsPart this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f87554d == null) {
                return;
            }
            com.tencent.biz.qqcircle.immersive.manager.e.a().inactivateElement(this.this$0);
        }
    }

    private void A9() {
        ViewStub viewStub;
        if (this.f87554d != null || (viewStub = (ViewStub) this.f87558i.findViewById(R.id.f5183296)) == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.f87554d = inflate;
        inflate.setOnClickListener(this);
        this.f87555e = this.f87554d.findViewById(R.id.f56882lt);
        this.f87556f = (QCircleAvatarListView) this.f87554d.findViewById(R.id.f47941yn);
        this.f87557h = (TextView) this.f87554d.findViewById(R.id.f47961yp);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f87555e.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.gravity = 1;
        this.f87555e.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f87554d.getLayoutParams();
        layoutParams2.topMargin = com.tencent.biz.qqcircle.immersive.utils.r.K(getContext()) + H;
        this.f87554d.setLayoutParams(layoutParams2);
    }

    private void B9() {
        String str;
        if (this.f87554d == null) {
            return;
        }
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        QQCircleCounter$RedPointInfo friendRedPointInfoByAppId = QCircleHostRedPointHelper.getFriendRedPointInfoByAppId(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        if (friendRedPointInfoByAppId == null) {
            str = "";
        } else {
            str = friendRedPointInfoByAppId.extend.get();
        }
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, str);
        VideoReport.setElementId(this.f87554d, QCircleDaTongConstant.ElementId.EM_XSJ_FRIEND_BUBBLE);
        VideoReport.setElementParams(this.f87554d, buildElementParams);
        VideoReport.setElementExposePolicy(this.f87554d, ExposurePolicy.REPORT_ALL);
    }

    private void C9(QFSRedPointTipsEvent qFSRedPointTipsEvent) {
        if (!qFSRedPointTipsEvent.isShow()) {
            E9();
            return;
        }
        this.E = qFSRedPointTipsEvent.getSenderList();
        this.D = qFSRedPointTipsEvent.getTipsText();
        this.F = qFSRedPointTipsEvent.getLeftMargin();
        this.G = true;
        if (com.tencent.biz.qqcircle.immersive.manager.e.a().isElementActivating(this)) {
            QLog.d("QFSRedPointTipsPart", 1, "element is showing. ");
            H9();
        } else {
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this);
        }
    }

    private void D9() {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleSelectTabEvent(9).needSmoothScroll());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E9() {
        View view = this.f87554d;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(getContext());
        if (x16 != null) {
            x16.i(this.f87554d);
        }
        com.tencent.biz.qqcircle.helpers.y.g().x(false);
    }

    private void F9() {
        if (this.f87554d == null) {
            return;
        }
        this.f87554d.startAnimation((AlphaAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.f154911tg));
    }

    private void G9() {
        if (this.f87554d == null) {
            return;
        }
        AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.f154912th);
        alphaAnimation.setAnimationListener(new a());
        this.f87554d.startAnimation(alphaAnimation);
    }

    private void H9() {
        View view = this.f87554d;
        if (view == null) {
            return;
        }
        view.measure(0, 0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f87554d.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = this.F - (this.f87554d.getMeasuredWidth() / 2);
            this.f87554d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        if (getContext() == null) {
            return "";
        }
        return String.valueOf(getContext().hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSRedPointTipsEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "bubble_tip";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSRedPointTipsPart";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 102;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (this.f87558i == null) {
            return false;
        }
        View view = this.f87554d;
        if ((view != null && view.getVisibility() == 0) || TextUtils.isEmpty(this.D) || com.tencent.biz.qqcircle.helpers.y.g().o() || com.tencent.biz.qqcircle.helpers.y.g().p()) {
            return false;
        }
        return this.G;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f47951yo) {
            D9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        this.G = false;
        A9();
        B9();
        com.tencent.biz.qqcircle.helpers.y.g().x(true);
        QCircleHostRedPointHelper.setFriendRedPointRead(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE, true);
        List<String> list = this.E;
        if (list != null && list.size() > 3) {
            this.f87556f.setData(this.E.subList(0, 3));
        } else {
            this.f87556f.setData(this.E);
        }
        this.f87557h.setText(this.D);
        this.f87554d.setVisibility(0);
        z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(getContext());
        if (x16 != null) {
            x16.b(this.f87554d);
        }
        H9();
        F9();
        this.f87559m.removeCallbacks(this.C);
        this.f87559m.postDelayed(this.C, 5000L);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f87558i = view;
        com.tencent.biz.qqcircle.helpers.y.g().x(false);
        SimpleEventBus.getInstance().registerReceiver(this);
        com.tencent.biz.qqcircle.immersive.manager.e.a().addElement(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSRedPointTipsEvent) {
            C9((QFSRedPointTipsEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QFSRedPointTipsPart.this.E9();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
