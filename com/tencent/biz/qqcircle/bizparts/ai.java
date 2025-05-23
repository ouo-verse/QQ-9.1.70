package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.QFSHalfScreenFloatingView;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class ai extends com.tencent.biz.qqcircle.bizparts.b {
    private static final boolean M = uq3.c.l6();
    private static final boolean N = uq3.c.n6();
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private long H;
    private long I;
    private ValueAnimator J;
    private ValueAnimator K;
    private boolean L;

    /* renamed from: d, reason: collision with root package name */
    private final List<View> f82868d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private QFSHalfScreenFloatingView f82869e;

    /* renamed from: f, reason: collision with root package name */
    private QFSVideoView f82870f;

    /* renamed from: h, reason: collision with root package name */
    private View f82871h;

    /* renamed from: i, reason: collision with root package name */
    private View f82872i;

    /* renamed from: m, reason: collision with root package name */
    private int f82873m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ai.this.ga();
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
            Iterator it = ai.this.f82868d.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(1.0f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c extends com.tencent.mobileqq.widget.qus.a {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.a, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
            QLog.d(ai.this.getLogTag(), 1, "show ani part" + ai.this.hashCode());
            ai.this.ia(false);
            if (!ai.this.R9()) {
                QLog.d(ai.this.getLogTag(), 1, "onShow return: page not enable");
                return;
            }
            if (!ai.this.S9()) {
                QLog.d(ai.this.getLogTag(), 1, "onShow return, disable video link");
            } else if (!ai.this.L) {
                ai.this.ja(true);
            } else {
                QLog.d(ai.this.getLogTag(), 1, "onShow return: isEnableSlide: true");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d implements QUSBaseHalfScreenFloatingView.k {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.k
        public void a(float f16) {
            float f17;
            if (!ai.this.L) {
                return;
            }
            if (ai.this.f82869e != null && ai.this.f82869e.getVisibility() != 8 && ai.this.f82870f != null && ai.this.f82870f.getLayoutParams() != null) {
                if (ai.this.Y9()) {
                    QLog.d(ai.this.getLogTag(), 1, "hasHappenConfigChange = true");
                    ai.this.f82869e.setTag(null);
                    ai.this.L = false;
                    if (ai.this.f82871h != null) {
                        ai.this.f82871h.setVisibility(8);
                        ai.this.f82871h.setTag(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                if (!ai.M && ai.this.f82870f.getLayoutParams().height == -1) {
                    QLog.e(ai.this.getLogTag(), 1, "onScrollChanged return SUPPORT_FULL_SCREEN_ANIM=" + ai.M + ",mVideoView.getLayoutParams().height=" + ai.this.f82870f.getLayoutParams().height);
                    return;
                }
                if (ai.this.f82869e.getHeight() == 0) {
                    QLog.d(ai.this.getLogTag(), 1, "[onTopUpdate] mHalfScreenView seems not layout");
                    return;
                }
                float height = (ai.this.f82869e.getHeight() - f16) / ai.this.f82869e.V();
                float W = ai.this.f82869e.W() / ((float) ai.this.W9());
                if (W > 1.0f) {
                    f17 = ai.this.f82869e.W() - ((float) ai.this.W9());
                    W = 1.0f;
                } else {
                    f17 = 0.0f;
                }
                float f18 = 1.0f - ((1.0f - W) * height);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ai.this.f82870f.getLayoutParams();
                layoutParams.height = (int) (ai.this.E * f18);
                layoutParams.width = (int) (ai.this.F * f18);
                layoutParams.topMargin = (int) (((ai.this.G * (1.0f - height)) + f17) - ((height * ((float) ai.this.I)) * W));
                layoutParams.gravity = 49;
                ai.this.f82870f.setLayoutParams(layoutParams);
                if (ai.this.f82871h != null) {
                    ai.this.f82871h.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            QLog.e(ai.this.getLogTag(), 1, "slideView is gone, still receive onScrollChange or mTopLinkView is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class e implements QUSBaseHalfScreenFloatingView.l {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
        public void onDismiss() {
            QLog.d(ai.this.getLogTag(), 1, "dismiss ani part" + ai.this.hashCode());
            ai.this.ia(true);
            if (ai.this.R9()) {
                ai.this.ja(false);
                ai.this.ha();
            } else {
                QLog.d(ai.this.getLogTag(), 1, "onDismiss return: page not enable");
            }
        }
    }

    public ai() {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.bizparts.ah
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ai.this.da(valueAnimator);
            }
        };
        ba(animatorUpdateListener);
        aa(animatorUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R9() {
        if (!(getHostFragment() instanceof QCircleBaseFragment)) {
            return true;
        }
        int pageId = ((QCircleBaseFragment) getHostFragment()).getPageId();
        if (pageId != Integer.MAX_VALUE && pageId != 97) {
            return true;
        }
        return false;
    }

    private void T9() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_cover_size", true)) {
            return;
        }
        this.f82871h = com.tencent.biz.qqcircle.immersive.utils.ax.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long W9() {
        long j3 = this.H;
        if (j3 != 0 && N) {
            return j3;
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Y9() {
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = this.f82869e;
        if (qFSHalfScreenFloatingView != null && (qFSHalfScreenFloatingView.getTag() instanceof Boolean) && ((Boolean) this.f82869e.getTag()).booleanValue()) {
            return true;
        }
        return false;
    }

    private void Z9(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup) && view != getPartRootView()) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != view && childAt.getId() != V9() && childAt.getVisibility() == 0) {
                    this.f82868d.add(childAt);
                }
            }
            if (view.getParent() instanceof View) {
                Z9((View) view.getParent());
            }
        }
    }

    private void aa(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(200L);
        this.K = duration;
        duration.addListener(new b());
        this.K.addUpdateListener(animatorUpdateListener);
    }

    private void ba(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.J = duration;
        duration.addListener(new a());
        this.J.addUpdateListener(animatorUpdateListener);
    }

    private boolean ca() {
        boolean I0 = com.tencent.biz.qqcircle.immersive.utils.r.I0(this.f82870f.getData());
        boolean isFolderScreenOpenMode = TransitionHelper.isFolderScreenOpenMode(getContext());
        boolean k3 = com.tencent.biz.qqcircle.utils.bz.k();
        boolean equals = QCircleDaTongConstant.PageId.PG_XSJ_QZEON_VIDEO_UGC_MID_PAG.equals(getReportBean().getDtCustomPagId());
        QLog.d(getLogTag(), 1, "[isNotSupportFullScreenShow] | isVideoLandScape: " + I0 + " | isFolderScreenOpenMode: " + isFolderScreenOpenMode + " | isAllowLandscape: " + k3 + " | isQZoneMiddlePage" + equals);
        if (!I0 || isFolderScreenOpenMode || k3 || equals) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void da(ValueAnimator valueAnimator) {
        if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator<View> it = this.f82868d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(floatValue);
        }
    }

    private void ea(QFSVideoView qFSVideoView) {
        this.L = true;
        this.C = qFSVideoView.getLayoutParams().height;
        this.D = qFSVideoView.getLayoutParams().width;
        this.E = qFSVideoView.getHeight();
        this.F = qFSVideoView.getWidth();
        this.G = qFSVideoView.getTop();
        this.H = 0L;
        this.I = 0L;
        QLog.d(getLogTag(), 1, " recordViewParams mLayoutWidth=" + this.D + ", mLayoutHeight=" + this.C + ", mTopMargin=" + this.G + ", videoView:", Integer.valueOf(qFSVideoView.hashCode()));
        if (!N) {
            QLog.i(getLogTag(), 1, "not open recognize content");
            return;
        }
        FeedCloudMeta$StFeed data = this.f82870f.getData();
        if (data == null) {
            QLog.i(getLogTag(), 1, "recordViewParams mFeedInfo == null");
            return;
        }
        if (data.yuhengContentInfos.has() && data.yuhengContentInfos.vertices.has()) {
            long j3 = data.yuhengContentInfos.vertices.height.get();
            List<Long> list = data.yuhengContentInfos.vertices.coordinate.get();
            if (j3 != 0 && list.size() == 4) {
                float f16 = (float) j3;
                this.H = ((((float) (list.get(3).longValue() - list.get(1).longValue())) * 1.0f) / f16) * this.E;
                this.I = ((((float) list.get(1).longValue()) * 1.0f) / f16) * this.E;
                return;
            } else {
                QLog.i(getLogTag(), 1, "recordViewParams yuhengContentInfos invalid, mFeedInfo=" + data.f398449id.get());
                return;
            }
        }
        QLog.i(getLogTag(), 1, "recordViewParams not yuhengContentInfos.vertices, mFeedInfo=" + data.f398449id.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        Iterator<View> it = this.f82868d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
            it.remove();
        }
        com.tencent.biz.qqcircle.immersive.utils.r.Z0(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha() {
        if (!this.L) {
            QLog.e(getLogTag(), 1, "resetLinkView mEnable = false");
            return;
        }
        this.L = false;
        if (this.f82870f == null) {
            QLog.e(getLogTag(), 1, "resetLinkView mVideoView == null");
            return;
        }
        int oa5 = oa();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.D, this.C);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = oa5;
        this.f82870f.setLayoutParams(layoutParams);
        View view = this.f82871h;
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        QLog.d(getLogTag(), 1, " resetLinkView mLayoutWidth=" + this.D + ", mLayoutHeight=" + this.C, ", layoutParams.topMargin=", Integer.valueOf(layoutParams.topMargin), ", videoView:", this.f82870f.hashCode() + ", bottomMargin:" + oa5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(boolean z16) {
        int i3;
        if (QCirclePluginUtil.isInLocalActivity(getActivity())) {
            View view = this.f82872i;
            int paddingLeft = view.getPaddingLeft();
            int paddingTop = this.f82872i.getPaddingTop();
            int paddingRight = this.f82872i.getPaddingRight();
            if (z16) {
                i3 = this.f82873m;
            } else {
                i3 = 0;
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja(boolean z16) {
        if (z16) {
            na();
            la();
        } else {
            ma();
        }
    }

    private void la() {
        if (this.J.isRunning()) {
            this.J.cancel();
        }
        this.K.start();
    }

    private void ma() {
        if (this.K.isRunning()) {
            this.K.cancel();
        }
        this.J.start();
    }

    private void na() {
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null) {
            QLog.e(getLogTag(), 1, "videoView isn't exist");
            return;
        }
        this.f82870f = weakReference.get();
        T9();
        QFSVideoView qFSVideoView = this.f82870f;
        if (qFSVideoView != null && qFSVideoView.getVisibility() == 0) {
            int[] iArr = new int[2];
            this.f82870f.getLocationInWindow(iArr);
            if (iArr[0] == 0 && iArr[1] == 0) {
                QLog.e(getLogTag(), 1, "showVideoViewOnly but video view isn't in window");
                return;
            } else {
                ea(this.f82870f);
                Z9(this.f82870f);
                return;
            }
        }
        QLog.e(getLogTag(), 1, "videoView is null or is not visible");
    }

    private int oa() {
        if (this.f82870f == null) {
            return 0;
        }
        if (ca() && (!com.tencent.biz.qqcircle.utils.bz.k() || !com.tencent.biz.qqcircle.immersive.utils.o.c(this.f82870f.getData()))) {
            return 0;
        }
        ViewParent parent = this.f82870f.getParent();
        if (!(parent instanceof ViewGroup)) {
            return 0;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        return (int) (((viewGroup.getHeight() / 2) - (((viewGroup.getHeight() + r1) * 0.88f) / 1.88f)) + DisplayUtil.getTopHeight(getContext()));
    }

    protected boolean S9() {
        return true;
    }

    public abstract int U9();

    public abstract int V9();

    public abstract int X9();

    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return X9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public abstract String getLogTag();

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return N;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        View findViewById = view.findViewById(V9());
        this.f82872i = findViewById;
        this.f82873m = findViewById.getPaddingBottom();
        QFSHalfScreenFloatingView qFSHalfScreenFloatingView = (QFSHalfScreenFloatingView) view.findViewById(U9());
        this.f82869e = qFSHalfScreenFloatingView;
        qFSHalfScreenFloatingView.j(new c());
        this.f82869e.l(new d());
        this.f82869e.T(new e());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        if (this.L && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_cover_size", true)) {
            com.tencent.biz.qqcircle.immersive.utils.ax.e(this.f82871h);
        }
    }
}
