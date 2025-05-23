package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPicPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSRatePlayGestureEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ez extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver {
    private ValueAnimator C;
    private ValueAnimator D;
    private ValueAnimator E;
    private TextView F;

    /* renamed from: d, reason: collision with root package name */
    private View f88077d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f88078e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f88079f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f88080h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f88081i;

    /* renamed from: m, reason: collision with root package name */
    private final List<View> f88082m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (ez.this.f88080h != null) {
                ez.this.f88080h.setAlpha(floatValue);
            }
            if (ez.this.f88081i != null) {
                ez.this.f88081i.setAlpha(1.0f - floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ez.this.Q9();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Iterator it = ez.this.f88082m.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(1.0f);
            }
        }
    }

    public ez() {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.part.ey
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ez.this.O9(valueAnimator);
            }
        };
        K9(animatorUpdateListener);
        J9(animatorUpdateListener);
        L9();
    }

    private void D9(String str, String str2) {
        TextView textView = this.f88078e;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.f88079f;
        if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    private void E9() {
        if (this.f88077d != null) {
            return;
        }
        View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f491221u)).inflate();
        this.f88077d = inflate;
        this.f88080h = (ImageView) inflate.findViewById(R.id.v76);
        this.f88081i = (ImageView) this.f88077d.findViewById(R.id.f81704ew);
        this.f88078e = (TextView) this.f88077d.findViewById(R.id.f491121t);
        this.F = (TextView) this.f88077d.findViewById(R.id.f491321v);
        this.f88079f = (TextView) this.f88077d.findViewById(R.id.f491021s);
        com.tencent.mobileqq.qui.b.f276860a.a(this.f88077d, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
    }

    private void F9(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        QFSImageBanner qFSImageBanner;
        View view = this.f88077d;
        if (view != null && this.E != null) {
            view.setVisibility(0);
            this.E.start();
            if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
                QLog.d("QFSPlayRateNotifyPart", 1, "already clearUi.");
                return;
            }
            com.tencent.biz.qqcircle.immersive.utils.ax.h(getContext(), false);
            if (com.tencent.biz.qqcircle.immersive.utils.y.j(feedCloudMeta$StFeed)) {
                WeakReference<QFSImageBanner> weakReference = QFSFeedChildPicPresenter.f85133m0;
                if (weakReference != null && (qFSImageBanner = weakReference.get()) != null) {
                    I9(qFSImageBanner);
                }
            } else {
                WeakReference<QFSVideoView> weakReference2 = QFSVideoView.D;
                if (weakReference2 != null) {
                    I9(weakReference2.get());
                }
            }
            H9();
            R9();
            return;
        }
        QLog.d("QFSPlayRateNotifyPart", 1, "clearUi return not init");
    }

    private void G9(QFSRatePlayGestureEvent qFSRatePlayGestureEvent) {
        String a16;
        String a17;
        String a18;
        String a19;
        FeedCloudMeta$StFeed feed = qFSRatePlayGestureEvent.getFeed();
        if (com.tencent.biz.qqcircle.immersive.utils.y.j(feed) && feed.images.size() <= 1) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
        int eventType = qFSRatePlayGestureEvent.getEventType();
        if (eventType != 0) {
            if (eventType != 1) {
                if (eventType != 3) {
                    if (eventType == 4) {
                        if (qFSRatePlayGestureEvent.getIsHitLockRate()) {
                            a18 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193474_a);
                            a19 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193604_n) + com.tencent.biz.qqcircle.utils.h.a(R.string.f193374_1);
                        } else {
                            a18 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193464__);
                            a19 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193454_9);
                        }
                        D9(a18, a19);
                        return;
                    }
                    return;
                }
                if (qFSRatePlayGestureEvent.getIsHitLockRate()) {
                    a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193594_m) + com.tencent.biz.qqcircle.utils.h.a(R.string.f193374_1);
                } else {
                    a17 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193444_8);
                }
                D9(com.tencent.biz.qqcircle.utils.h.a(R.string.f193474_a), a17);
                return;
            }
            T9();
            return;
        }
        P9(qFSRatePlayGestureEvent.getFeed(), qFSRatePlayGestureEvent.getPlayRate());
        F9(qFSRatePlayGestureEvent.getFeed());
        if (qFSRatePlayGestureEvent.getIsHitLockRate()) {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193594_m) + com.tencent.biz.qqcircle.utils.h.a(R.string.f193374_1);
        } else {
            a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f193444_8);
        }
        D9(com.tencent.biz.qqcircle.utils.h.a(R.string.f193474_a), a16);
    }

    private void H9() {
        View findViewById;
        if (getActivity() == null || (findViewById = getActivity().findViewById(R.id.f34610zm)) == null) {
            return;
        }
        this.f88082m.add(findViewById);
    }

    private void I9(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup) && view != getPartRootView()) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != view && childAt.getId() != R.id.f490821q) {
                    if (o70.a.a() && childAt.getId() == R.id.f40881fk) {
                        int i16 = 0;
                        while (true) {
                            ViewGroup viewGroup2 = (ViewGroup) childAt;
                            if (i16 < viewGroup2.getChildCount()) {
                                View childAt2 = viewGroup2.getChildAt(i16);
                                if (childAt2.getId() != R.id.v_j) {
                                    this.f88082m.add(childAt2);
                                }
                                i16++;
                            }
                        }
                    } else if (childAt.getId() != R.id.v9e && childAt.getVisibility() == 0) {
                        this.f88082m.add(childAt);
                    }
                }
            }
            if (view.getParent() instanceof View) {
                I9((View) view.getParent());
            }
        }
    }

    private void J9(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(200L);
        this.D = duration;
        duration.addListener(new c());
        this.D.addUpdateListener(animatorUpdateListener);
    }

    private void K9(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.C = duration;
        duration.addListener(new b());
        this.C.addUpdateListener(animatorUpdateListener);
    }

    private void L9() {
        ValueAnimator duration = ValueAnimator.ofFloat(0.8f, 0.2f).setDuration(500L);
        this.E = duration;
        duration.addUpdateListener(new a());
        this.E.setRepeatCount(-1);
        this.E.setRepeatMode(2);
    }

    private boolean M9(QFSRatePlayGestureEvent qFSRatePlayGestureEvent) {
        if (getActivity() == null || qFSRatePlayGestureEvent.getCurrentContextHashCode() != getActivity().hashCode()) {
            return false;
        }
        return true;
    }

    private boolean N9() {
        Object broadcastGetMessage = broadcastGetMessage("qfs_is_teen_mode_window_show", null);
        if (broadcastGetMessage instanceof Boolean) {
            return ((Boolean) broadcastGetMessage).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O9(ValueAnimator valueAnimator) {
        if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator<View> it = this.f88082m.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(floatValue);
        }
    }

    private void P9(FeedCloudMeta$StFeed feedCloudMeta$StFeed, float f16) {
        if ((getHostFragment() instanceof QCircleBaseFragment) && ((QCircleBaseFragment) getHostFragment()).getReportBean() != null) {
            com.tencent.biz.qqcircle.utils.cb.e(this.f88077d, feedCloudMeta$StFeed, f16, ((QCircleBaseFragment) getHostFragment()).getReportBean().getDtPageId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9() {
        Iterator<View> it = this.f88082m.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
            it.remove();
        }
    }

    private void R9() {
        if (this.C.isRunning()) {
            this.C.cancel();
        }
        this.D.start();
    }

    private void S9() {
        if (this.D.isRunning()) {
            this.D.cancel();
        }
        this.C.start();
    }

    private void T9() {
        View view = this.f88077d;
        if (view != null && this.E != null) {
            view.setVisibility(8);
            this.E.cancel();
            if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
                QLog.d("QFSPlayRateNotifyPart", 1, "is Clear UI.");
                return;
            }
            S9();
            if (!N9() && !QCirclePanelStateEvent.isSpecifiedPanelShowing(5) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(7)) {
                com.tencent.biz.qqcircle.immersive.utils.ax.h(getContext(), true);
                return;
            }
            return;
        }
        QLog.d("QFSPlayRateNotifyPart", 1, "showUI return not init");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSRatePlayGestureEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSRatePlayGestureEvent) {
            QFSRatePlayGestureEvent qFSRatePlayGestureEvent = (QFSRatePlayGestureEvent) simpleBaseEvent;
            if (M9(qFSRatePlayGestureEvent)) {
                E9();
                G9(qFSRatePlayGestureEvent);
            }
        }
    }
}
