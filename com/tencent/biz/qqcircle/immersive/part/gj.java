package com.tencent.biz.qqcircle.immersive.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleVideoRateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSFeedItemScaleGestureEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSLockRateStatusChangeEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSVideoPauseEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
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
public class gj extends u implements SimpleEventReceiver {
    private View C;
    private View D;
    private ImageView E;
    private ImageView F;
    private TextView G;
    private FeedCloudMeta$StFeed H;
    private String I;
    private boolean J;
    private long K;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f88170f;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f88171h;

    /* renamed from: i, reason: collision with root package name */
    private QFSViewPager f88172i;

    /* renamed from: m, reason: collision with root package name */
    private View f88173m;

    /* renamed from: d, reason: collision with root package name */
    private final List<View> f88168d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final List<View> f88169e = new ArrayList();
    private final Drawable L = ContextCompat.getDrawable(RFWApplication.getApplication(), R.drawable.qui_pause_filled_white);
    private final Drawable M = ContextCompat.getDrawable(RFWApplication.getApplication(), R.drawable.qui_play_filled_icon_white);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            gj.this.oa();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            gj.this.pa(true);
            gj.this.f88169e.clear();
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
            Iterator it = gj.this.f88168d.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            gj.this.pa(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<gj> f88176a;

        public c(gj gjVar) {
            this.f88176a = new WeakReference<>(gjVar);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            String str2;
            gj gjVar = this.f88176a.get();
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            if (gjVar != null && gjVar.H != null) {
                buildElementParams.put("xsj_feed_id", gjVar.I);
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, gjVar.H.poster.f398463id.get());
                buildElementParams.put("xsj_custom_pgid", gjVar.getDtPageId());
                if (gjVar.ga()) {
                    str2 = "play";
                } else {
                    str2 = QCircleDaTongConstant.ElementParamValue.SUSPEND;
                }
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, str2);
            }
            return buildElementParams;
        }
    }

    private void K9() {
        if (this.f88173m == null) {
            View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f52382_n)).inflate();
            this.f88173m = inflate;
            inflate.setVisibility(8);
            this.E = (ImageView) this.f88173m.findViewById(R.id.f52372_m);
            this.F = (ImageView) this.f88173m.findViewById(R.id.f52402_p);
            this.G = (TextView) this.f88173m.findViewById(R.id.f52412_q);
            com.tencent.mobileqq.qui.b.f276860a.a(this.f88173m, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        }
        aa();
        Z9();
        M9();
    }

    private void L9() {
        if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            QLog.d("QFSVideoScaleGestureHandlePart", 1, "already clearUI.");
            return;
        }
        QLog.d("QFSVideoScaleGestureHandlePart", 1, "clearUI.");
        com.tencent.biz.qqcircle.immersive.utils.ax.i(getContext(), false, true);
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference != null) {
            X9(weakReference.get());
        }
        W9();
        ra();
    }

    private void M9() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_feed_id", this.I);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.H.poster.f398463id.get());
        buildElementParams.put("xsj_custom_pgid", getDtPageId());
        VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_CLEAR_SCREEN_INTERFACE_OPERATE);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, "close");
        VideoReport.setElementParams(this.E, buildElementParams);
        ImageView imageView = this.E;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(imageView, exposurePolicy);
        VideoReport.setElementId(this.G, QCircleDaTongConstant.ElementId.EM_XSJ_CLEAR_SCREEN_INTERFACE_OPERATE);
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, "speed");
        VideoReport.setElementParams(this.G, buildElementParams);
        VideoReport.setElementExposePolicy(this.G, exposurePolicy);
        VideoReport.setElementId(this.F, QCircleDaTongConstant.ElementId.EM_XSJ_CLEAR_SCREEN_INTERFACE_OPERATE);
        VideoReport.setEventDynamicParams(this.F, new c(this));
        VideoReport.setElementExposePolicy(this.F, exposurePolicy);
    }

    private void N9(boolean z16) {
        if (this.f88172i != null) {
            QLog.d("QFSVideoScaleGestureHandlePart", 1, "set mHoriViewPager enable slide. enable: " + z16);
            SimpleEventBus.getInstance().dispatchEvent(new QFSEnableSlideRightActionEvent(z16, getContext()));
            this.f88172i.setScrollable(z16);
        }
    }

    private void O9() {
        va();
        qa(false);
        N9(true);
        na(false);
        ta(true);
        U9(true);
        com.tencent.biz.qqcircle.utils.ce.d(this.f88173m, "exit", this.H, getDtPageId(), System.currentTimeMillis() - this.K);
    }

    private String P9(float f16) {
        if (f16 - 0.5f < 0.01f) {
            return "0.5x";
        }
        if (f16 - 1.0f >= 0.01f) {
            if (f16 - 1.5f < 0.01f) {
                return "1.5x";
            }
            if (f16 - 2.0f < 0.01f) {
                return "2x";
            }
        }
        return "1x";
    }

    private void Q9(QCircleFeedEvent qCircleFeedEvent) {
        if (qCircleFeedEvent.mState != 3) {
            return;
        }
        O9();
    }

    private void R9(QFSLockRateStatusChangeEvent qFSLockRateStatusChangeEvent) {
        if (this.G == null || !TextUtils.equals(qFSLockRateStatusChangeEvent.getFeedId(), this.I)) {
            return;
        }
        this.G.setText(P9(qFSLockRateStatusChangeEvent.getPlayRate()));
    }

    private void S9(QCircleVideoRateEvent qCircleVideoRateEvent) {
        if (!TextUtils.equals(qCircleVideoRateEvent.getFeedId(), this.I)) {
            return;
        }
        this.G.setText(P9(qCircleVideoRateEvent.getSelectedRate()));
    }

    private void T9(QFSFeedItemScaleGestureEvent qFSFeedItemScaleGestureEvent) {
        String str;
        if (qFSFeedItemScaleGestureEvent.isPic() || qFSFeedItemScaleGestureEvent.getType() == 0) {
            return;
        }
        if (ea(qFSFeedItemScaleGestureEvent.mHashCode)) {
            QLog.e("QFSVideoScaleGestureHandlePart", 1, "handleScaleGestureEvent isCurPage: false, hashcode: " + qFSFeedItemScaleGestureEvent.mHashCode + ", current page hashcode: " + com.tencent.biz.qqcircle.utils.ce.b(getContext()));
            return;
        }
        int type = qFSFeedItemScaleGestureEvent.getType();
        this.H = qFSFeedItemScaleGestureEvent.getFeed();
        if (qFSFeedItemScaleGestureEvent.getFeed() == null) {
            str = "";
        } else {
            str = qFSFeedItemScaleGestureEvent.getFeed().f398449id.get();
        }
        this.I = str;
        K9();
        if (type == 1) {
            this.J = com.tencent.biz.qqcircle.utils.ce.c(getContext());
            if (!com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
                na(true);
                L9();
                N9(false);
                com.tencent.biz.qqcircle.immersive.utils.bc.a(50L);
            }
            ta(false);
            qa(false);
            U9(false);
            return;
        }
        if (type == 2) {
            if (qFSFeedItemScaleGestureEvent.getScale() < 1.0f && this.J) {
                O9();
            } else {
                qa(true);
                ta(true);
                if (!this.J && com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
                    this.K = System.currentTimeMillis();
                    com.tencent.biz.qqcircle.utils.ce.d(this.f88173m, BaseConstants.BROADCAST_USERSYNC_ENTER, this.H, getDtPageId(), 0L);
                }
            }
            U9(true);
            return;
        }
        if (type == 3) {
            O9();
        }
    }

    private void U9(boolean z16) {
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

    private void V9(QFSVideoPauseEvent qFSVideoPauseEvent) {
        ImageView imageView;
        Drawable drawable;
        if (!ea(qFSVideoPauseEvent.mHashCode) && (imageView = this.F) != null) {
            if (qFSVideoPauseEvent.mIsPause) {
                drawable = this.M;
            } else {
                drawable = this.L;
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        QLog.e("QFSVideoScaleGestureHandlePart", 1, "handleVideoStateChange isCurPage: false, hashcode: " + qFSVideoPauseEvent.mHashCode + ", current page hashcode: " + com.tencent.biz.qqcircle.utils.ce.b(getContext()));
    }

    private void W9() {
        View findViewById;
        if (getActivity() == null || (findViewById = getActivity().findViewById(R.id.f34610zm)) == null) {
            return;
        }
        this.f88168d.add(findViewById);
        this.f88169e.add(findViewById);
    }

    private void X9(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup) && view != getPartRootView()) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != view) {
                    int id5 = childAt.getId();
                    if ((id5 == R.id.vg5 || id5 == R.id.f98925oe) && !this.f88169e.contains(childAt)) {
                        this.f88169e.add(childAt);
                    }
                    if (id5 == R.id.v9e) {
                        this.C = childAt;
                    } else if (id5 == R.id.f40881fk) {
                        int i16 = 0;
                        while (true) {
                            ViewGroup viewGroup2 = (ViewGroup) childAt;
                            if (i16 < viewGroup2.getChildCount()) {
                                View childAt2 = viewGroup2.getChildAt(i16);
                                if (childAt2.getId() != R.id.v9n) {
                                    if (childAt2.getVisibility() == 0) {
                                        this.f88168d.add(childAt2);
                                    }
                                    if (childAt2.getId() == R.id.f34380z0) {
                                        this.f88169e.add(childAt2);
                                    }
                                }
                                i16++;
                            }
                        }
                    } else if (id5 == R.id.va5) {
                        this.D = childAt;
                    } else if (childAt.getVisibility() == 0) {
                        this.f88168d.add(childAt);
                    }
                }
            }
            if (view.getParent() instanceof View) {
                X9((View) view.getParent());
            }
        }
    }

    private void Y9() {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.immersive.part.gf
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                gj.this.ia(valueAnimator);
            }
        };
        ca(animatorUpdateListener);
        ba(animatorUpdateListener);
    }

    private void Z9() {
        this.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.gg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                gj.this.ja(view);
            }
        });
        this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.gh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                gj.this.la(view);
            }
        });
        this.G.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.part.gi
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                gj.this.ma(view);
            }
        });
    }

    private void aa() {
        QFSVideoView qFSVideoView;
        Drawable drawable;
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference != null && (qFSVideoView = weakReference.get()) != null) {
            this.G.setText(P9(qFSVideoView.getPlayRate()));
            RFWPlayer qCirclePlayer = qFSVideoView.getQCirclePlayer();
            if (qCirclePlayer != null) {
                boolean isPlaying = qCirclePlayer.isPlaying();
                ImageView imageView = this.F;
                if (isPlaying) {
                    drawable = this.L;
                } else {
                    drawable = this.M;
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }

    private void ba(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(200L);
        this.f88171h = duration;
        duration.addListener(new b());
        this.f88171h.addUpdateListener(animatorUpdateListener);
    }

    private void ca(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.f88170f = duration;
        duration.addListener(new a());
        this.f88170f.addUpdateListener(animatorUpdateListener);
    }

    private boolean ea(int i3) {
        if (i3 == 0) {
            QLog.e("QFSVideoScaleGestureHandlePart", 1, "isCurrentPage event hashcode is 0. ");
            return true;
        }
        if (i3 != com.tencent.biz.qqcircle.utils.ce.b(getContext())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ga() {
        QFSVideoView qFSVideoView;
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null || (qFSVideoView = weakReference.get()) == null || qFSVideoView.getQCirclePlayer() == null) {
            return false;
        }
        return qFSVideoView.getQCirclePlayer().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDtPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_CLEAR_SCREEN_INTERFACE_PAGE;
    }

    private boolean ha() {
        Object broadcastGetMessage = broadcastGetMessage("qfs_is_teen_mode_window_show", null);
        if (broadcastGetMessage instanceof Boolean) {
            return ((Boolean) broadcastGetMessage).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ia(ValueAnimator valueAnimator) {
        if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator<View> it = this.f88168d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ja(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        O9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void la(View view) {
        QFSVideoView qFSVideoView;
        EventCollector.getInstance().onViewClickedBefore(view);
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference != null && (qFSVideoView = weakReference.get()) != null && qFSVideoView.getQCirclePlayer() != null) {
            if (qFSVideoView.getQCirclePlayer().isPlaying()) {
                qFSVideoView.pause();
                this.F.setImageDrawable(this.M);
                sa(true);
            } else {
                qFSVideoView.start();
                this.F.setImageDrawable(this.L);
                sa(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ma(View view) {
        QFSVideoView qFSVideoView;
        EventCollector.getInstance().onViewClickedBefore(view);
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference != null && (qFSVideoView = weakReference.get()) != null) {
            float playRate = qFSVideoView.getPlayRate();
            float f16 = 0.5f;
            float f17 = 1.0f;
            if (playRate - 0.5f >= 0.01f) {
                f17 = 1.5f;
                if (playRate - 1.0f >= 0.01f) {
                    f17 = 2.0f;
                    if (playRate - 1.5f >= 0.01f) {
                        if (playRate - 2.0f >= 0.01f) {
                            f16 = 0.0f;
                        }
                        String P9 = P9(f16);
                        qFSVideoView.setPlayRate(f16);
                        QCirclePluginGlobalInfo.k0(this.I, f16);
                        this.G.setText(P9);
                    }
                }
            }
            f16 = f17;
            String P92 = P9(f16);
            qFSVideoView.setPlayRate(f16);
            QCirclePluginGlobalInfo.k0(this.I, f16);
            this.G.setText(P92);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void na(boolean z16) {
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePanelStateEvent(21, this.I, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa() {
        Iterator<View> it = this.f88168d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
            it.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa(boolean z16) {
        int i3;
        for (View view : this.f88169e) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private void qa(boolean z16) {
        int i3;
        View view = this.f88173m;
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

    private void ra() {
        if (this.f88170f.isRunning()) {
            this.f88170f.cancel();
        }
        if (!com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            this.f88171h.start();
            com.tencent.biz.qqcircle.utils.ce.f(getContext());
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(getContext());
            if (x16 != null) {
                x16.l(RFWOrderElementManager.OrderMode.ROB_MODE);
            }
        }
    }

    private void sa(boolean z16) {
        int i3;
        View view = this.D;
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

    private void ta(boolean z16) {
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

    private void ua() {
        if (this.f88171h.isRunning()) {
            this.f88171h.cancel();
        }
        if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            this.f88170f.start();
            com.tencent.biz.qqcircle.utils.ce.a(getContext());
            z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(getContext());
            if (x16 != null) {
                x16.m();
            }
        }
    }

    private void va() {
        if (!com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            QLog.d("QFSVideoScaleGestureHandlePart", 1, "already showUI.");
            return;
        }
        QLog.d("QFSVideoScaleGestureHandlePart", 1, "showUI.");
        ua();
        if (!ha() && !QCirclePanelStateEvent.isSpecifiedPanelShowing(5) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(7)) {
            com.tencent.biz.qqcircle.immersive.utils.ax.i(getContext(), true, true);
        }
    }

    public boolean da() {
        View view = this.f88173m;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSFeedItemScaleGestureEvent.class);
        arrayList.add(QFSVideoPauseEvent.class);
        arrayList.add(QCircleVideoRateEvent.class);
        arrayList.add(QCircleFeedEvent.class);
        arrayList.add(QFSLockRateStatusChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (da()) {
            O9();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NonNull View view) {
        super.onInitView(view);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f88172i = (QFSViewPager) view.findViewById(R.id.vg6);
        Y9();
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
            this.K = System.currentTimeMillis();
            com.tencent.biz.qqcircle.utils.ce.d(this.f88173m, BaseConstants.BROADCAST_USERSYNC_ENTER, this.H, getDtPageId(), 0L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        if (com.tencent.biz.qqcircle.utils.ce.c(getContext())) {
            com.tencent.biz.qqcircle.utils.ce.d(this.f88173m, "exit", this.H, getDtPageId(), System.currentTimeMillis() - this.K);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSFeedItemScaleGestureEvent) {
            T9((QFSFeedItemScaleGestureEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSVideoPauseEvent) {
            V9((QFSVideoPauseEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleVideoRateEvent) {
            S9((QCircleVideoRateEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleFeedEvent) {
            Q9((QCircleFeedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSLockRateStatusChangeEvent) {
            R9((QFSLockRateStatusChangeEvent) simpleBaseEvent);
        }
    }
}
