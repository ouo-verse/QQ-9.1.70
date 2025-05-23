package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.feed.av;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedItemScaleGestureEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class du extends u implements SimpleEventReceiver {
    private View C;
    private View D;
    private ImageView E;
    private ImageView F;
    private FeedCloudMeta$StFeed G;
    private String H;
    private boolean I;
    private long J;
    private View M;
    private av.b N;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f87995f;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f87996h;

    /* renamed from: i, reason: collision with root package name */
    private QFSViewPager f87997i;

    /* renamed from: m, reason: collision with root package name */
    private View f87998m;

    /* renamed from: d, reason: collision with root package name */
    private final List<View> f87993d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final List<View> f87994e = new ArrayList();
    private final Drawable K = ContextCompat.getDrawable(RFWApplication.getApplication(), R.drawable.qui_pause_filled_white);
    private final Drawable L = ContextCompat.getDrawable(RFWApplication.getApplication(), R.drawable.qui_play_filled_icon_white);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            du.this.ha();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            du.this.ia(true);
            du.this.f87994e.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Iterator it = du.this.f87993d.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            du.this.ia(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<du> f88001a;

        public c(du duVar) {
            this.f88001a = new WeakReference<>(duVar);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            du duVar = this.f88001a.get();
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (duVar != null && duVar.G != null) {
                buildElementParams.put("xsj_feed_id", duVar.H);
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, duVar.G.poster.f398463id.get());
                buildElementParams.put("xsj_custom_pgid", duVar.getDtPageId());
            }
            return buildElementParams;
        }
    }

    private void J9() {
        if (this.f87998m == null) {
            View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f52352_k)).inflate();
            this.f87998m = inflate;
            inflate.setVisibility(8);
            this.E = (ImageView) this.f87998m.findViewById(R.id.f52342_j);
            this.F = (ImageView) this.f87998m.findViewById(R.id.f52362_l);
            com.tencent.mobileqq.qui.b.f276860a.a(this.f87998m, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        }
        W9();
        V9();
        L9();
    }

    private void K9() {
        if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            QLog.d("QFSVideoScaleGestureHandlePart", 1, "already clearUI.");
            return;
        }
        QLog.d("QFSVideoScaleGestureHandlePart", 1, "clearUI.");
        com.tencent.biz.qqcircle.immersive.utils.ax.i(getContext(), false, true);
        View view = this.M;
        if (view != null) {
            T9(view);
        }
        S9();
        la();
    }

    private void L9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", this.H);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.G.poster.f398463id.get());
        buildElementParams.put("xsj_custom_pgid", getDtPageId());
        VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_CLEAR_SCREEN_INTERFACE_OPERATE);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, "close");
        VideoReport.setElementParams(this.E, buildElementParams);
        ImageView imageView = this.E;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(imageView, exposurePolicy);
        VideoReport.setElementId(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_CLEAR_SCREEN_INTERFACE_OPERATE);
        VideoReport.setEventDynamicParams(this.F, new c(this));
        VideoReport.setElementExposePolicy(this.F, exposurePolicy);
    }

    private void M9(boolean z16) {
        if (this.f87997i != null) {
            QLog.d("QFSVideoScaleGestureHandlePart", 1, "set mHoriViewPager enable slide. enable: " + z16);
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(z16, getContext()));
            this.f87997i.setScrollable(z16);
        }
    }

    private void N9() {
        oa();
        ja(false);
        M9(true);
        ga(false);
        ma(true);
        Q9(true);
        com.tencent.biz.qqcircle.utils.ce.d(this.f87998m, "exit", this.G, getDtPageId(), System.currentTimeMillis() - this.J);
    }

    private void O9(QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent.mState != 3) {
            return;
        }
        N9();
    }

    private void P9(QFSFeedItemScaleGestureEvent qFSFeedItemScaleGestureEvent) {
        String str;
        if (aa(qFSFeedItemScaleGestureEvent.mHashCode)) {
            QLog.e("QFSVideoScaleGestureHandlePart", 1, "handleScaleGestureEvent isCurPage: false, hashcode: " + qFSFeedItemScaleGestureEvent.mHashCode + ", current page hashcode: " + com.tencent.biz.qqcircle.utils.ce.b(getContext()));
            return;
        }
        if (qFSFeedItemScaleGestureEvent.getType() == 0) {
            av.b playStatusProvider = qFSFeedItemScaleGestureEvent.getPlayStatusProvider();
            if (playStatusProvider != null) {
                playStatusProvider.a(new av.a() { // from class: com.tencent.biz.qqcircle.immersive.part.dq
                    @Override // com.tencent.biz.qqcircle.immersive.feed.av.a
                    public final void a(boolean z16) {
                        du.this.R9(z16);
                    }
                });
            }
            this.N = playStatusProvider;
            return;
        }
        if (!qFSFeedItemScaleGestureEvent.isPic()) {
            return;
        }
        int type = qFSFeedItemScaleGestureEvent.getType();
        this.G = qFSFeedItemScaleGestureEvent.getFeed();
        if (qFSFeedItemScaleGestureEvent.getFeed() == null) {
            str = "";
        } else {
            str = qFSFeedItemScaleGestureEvent.getFeed().f398449id.get();
        }
        this.H = str;
        J9();
        if (type == 1) {
            this.M = qFSFeedItemScaleGestureEvent.getDetectorView();
            this.I = com.tencent.biz.qqcircle.utils.ce.c(getContext());
            if (!com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
                ga(true);
                K9();
                M9(false);
                com.tencent.biz.qqcircle.immersive.utils.bc.a(50L);
            }
            ma(false);
            ja(false);
            Q9(false);
            return;
        }
        if (type == 2) {
            if (qFSFeedItemScaleGestureEvent.getScale() < 1.0f && this.I) {
                N9();
            } else {
                ja(true);
                ma(true);
                if (!this.I && com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
                    this.J = System.currentTimeMillis();
                    com.tencent.biz.qqcircle.utils.ce.d(this.f87998m, BaseConstants.BROADCAST_USERSYNC_ENTER, this.G, getDtPageId(), 0L);
                }
            }
            Q9(true);
            return;
        }
        if (type == 3) {
            N9();
        }
    }

    private void Q9(boolean z16) {
        int i3;
        if (getPartRootView() != null && getPartRootView().getRootView() != null && getActivity() != null) {
            if (QCircleHostGlobalInfo.getFolderUIType() == 2) {
                QLog.d("QFSVideoScaleGestureHandlePart", 1, "[handleSeekBarArea] is in dynamic page.");
                return;
            }
            View findViewById = getPartRootView().getRootView().findViewById(R.id.f33020vb);
            if (findViewById == null) {
                findViewById = getActivity().findViewById(R.id.f33020vb);
            }
            if (findViewById == null) {
                QLog.d("QFSVideoScaleGestureHandlePart", 1, "[handleSeekBarArea] can not find seek area. ");
                return;
            }
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            findViewById.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9(boolean z16) {
        Drawable drawable;
        ImageView imageView = this.F;
        if (imageView == null) {
            return;
        }
        if (z16) {
            drawable = this.K;
        } else {
            drawable = this.L;
        }
        imageView.setImageDrawable(drawable);
    }

    private void S9() {
        View findViewById;
        if (getActivity() == null || (findViewById = getActivity().findViewById(R.id.f34610zm)) == null) {
            return;
        }
        this.f87993d.add(findViewById);
        this.f87994e.add(findViewById);
    }

    private void T9(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup) && view != getPartRootView()) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != view) {
                    int id5 = childAt.getId();
                    if ((id5 == R.id.vg5 || id5 == R.id.f98925oe) && !this.f87994e.contains(childAt)) {
                        this.f87994e.add(childAt);
                    }
                    if (id5 == R.id.v9e) {
                        this.C = childAt;
                    } else if (id5 != R.id.f45121r1) {
                        if (viewGroup.getId() == R.id.f40881fk) {
                            if (id5 != R.id.v9n && id5 != R.id.f40921fo) {
                                if (id5 == 0) {
                                    this.f87993d.add(childAt);
                                }
                                if (id5 == R.id.f34380z0) {
                                    this.f87994e.add(childAt);
                                }
                            }
                        }
                        if (id5 == R.id.f489421c) {
                            this.D = childAt;
                        } else if (id5 != R.id.f56182jx && childAt.getVisibility() == 0) {
                            this.f87993d.add(childAt);
                        }
                    }
                }
            }
            if (view.getParent() instanceof View) {
                T9((View) view.getParent());
            }
        }
    }

    private void U9() {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.part.dr
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                du.this.ca(valueAnimator);
            }
        };
        Y9(animatorUpdateListener);
        X9(animatorUpdateListener);
    }

    private void V9() {
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.ds
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                du.this.da(view);
            }
        });
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.dt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                du.this.ea(view);
            }
        });
    }

    private void W9() {
        av.b bVar = this.N;
        if (bVar == null) {
            return;
        }
        R9(bVar.isPlaying());
    }

    private void X9(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(200L);
        this.f87996h = duration;
        duration.addListener(new b());
        this.f87996h.addUpdateListener(animatorUpdateListener);
    }

    private void Y9(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.f87995f = duration;
        duration.addListener(new a());
        this.f87995f.addUpdateListener(animatorUpdateListener);
    }

    private boolean aa(int i3) {
        if (i3 == 0) {
            QLog.e("QFSVideoScaleGestureHandlePart", 1, "isCurrentPage event hashcode is 0. ");
            return true;
        }
        if (i3 != com.tencent.biz.qqcircle.utils.ce.b(getContext())) {
            return true;
        }
        return false;
    }

    private boolean ba() {
        Object broadcastGetMessage = broadcastGetMessage("qfs_is_teen_mode_window_show", null);
        if (broadcastGetMessage instanceof Boolean) {
            return ((Boolean) broadcastGetMessage).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ca(ValueAnimator valueAnimator) {
        if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator<View> it = this.f87993d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void da(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        N9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ea(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        av.b bVar = this.N;
        if (bVar != null) {
            bVar.b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void ga(boolean z16) {
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(21, this.H, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDtPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_CLEAR_SCREEN_INTERFACE_PAGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha() {
        Iterator<View> it = this.f87993d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
            it.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(boolean z16) {
        int i3;
        for (View view : this.f87994e) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private void ja(boolean z16) {
        int i3;
        View view = this.f87998m;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void la() {
        if (this.f87995f.isRunning()) {
            this.f87995f.cancel();
        }
        if (!com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            this.f87996h.start();
            com.tencent.biz.qqcircle.utils.ce.f(getContext());
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(getContext());
            if (x16 != null) {
                x16.l(RFWOrderElementManager.OrderMode.ROB_MODE);
            }
        }
    }

    private void ma(boolean z16) {
        float f16;
        View view = this.C;
        if (view == null) {
            return;
        }
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        view.setAlpha(f16);
    }

    private void na() {
        if (this.f87996h.isRunning()) {
            this.f87996h.cancel();
        }
        if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            this.f87995f.start();
            com.tencent.biz.qqcircle.utils.ce.a(getContext());
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(getContext());
            if (x16 != null) {
                x16.m();
            }
        }
    }

    private void oa() {
        if (!com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            QLog.d("QFSVideoScaleGestureHandlePart", 1, "already showUI.");
            return;
        }
        QLog.d("QFSVideoScaleGestureHandlePart", 1, "showUI.");
        na();
        if (!ba() && !QCirclePanelStateEvent.isSpecifiedPanelShowing(5) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(7)) {
            com.tencent.biz.qqcircle.immersive.utils.ax.i(getContext(), true, true);
        }
    }

    public boolean Z9() {
        View view = this.f87998m;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSFeedItemScaleGestureEvent.class);
        arrayList.add(QCircleFeedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (Z9()) {
            N9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NonNull View view) {
        super.onInitView(view);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f87997i = (QFSViewPager) view.findViewById(R.id.vg6);
        U9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.biz.qqcircle.utils.ce.a(activity);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            this.J = System.currentTimeMillis();
            com.tencent.biz.qqcircle.utils.ce.d(this.f87998m, BaseConstants.BROADCAST_USERSYNC_ENTER, this.G, getDtPageId(), 0L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            com.tencent.biz.qqcircle.utils.ce.d(this.f87998m, "exit", this.G, getDtPageId(), System.currentTimeMillis() - this.J);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFeedItemScaleGestureEvent) {
            P9((QFSFeedItemScaleGestureEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleFeedEvent) {
            O9((QCircleFeedEvent) simpleBaseEvent);
        }
    }
}
