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
import com.tencent.biz.qqcircle.utils.QFSCommentSheetView;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ba extends com.tencent.biz.qqcircle.bizparts.b {
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
    private final List<View> f82920d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private QFSCommentSheetView f82921e;

    /* renamed from: f, reason: collision with root package name */
    private QFSVideoView f82922f;

    /* renamed from: h, reason: collision with root package name */
    private View f82923h;

    /* renamed from: i, reason: collision with root package name */
    private View f82924i;

    /* renamed from: m, reason: collision with root package name */
    private int f82925m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ba.this.ea();
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
            Iterator it = ba.this.f82920d.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(1.0f);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d implements QFSCommentSheetView.h {
        d() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.h
        public void a(float f16) {
            float f17;
            if (!ba.this.L) {
                QLog.e("QFSCommentSlideVideoAnimPart", 1, "onScrollChanged mEnable = false");
                return;
            }
            if (ba.this.f82921e != null && ba.this.f82921e.getVisibility() != 8 && ba.this.f82922f != null && ba.this.f82922f.getLayoutParams() != null) {
                if (ba.this.X9()) {
                    QLog.d("QFSCommentSlideVideoAnimPart", 1, "hasHappenConfigChange = true");
                    if (com.tencent.biz.qqcircle.utils.bz.k()) {
                        ba.this.ga();
                    }
                    ba.this.f82921e.setTag(null);
                    ba.this.L = false;
                    if (ba.this.f82923h != null) {
                        ba.this.f82923h.setVisibility(8);
                        ba.this.f82923h.setTag(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                if (!ba.M && ba.this.f82922f.getLayoutParams().height == -1) {
                    QLog.e("QFSCommentSlideVideoAnimPart", 1, "onScrollChanged return SUPPORT_FULL_SCREEN_ANIM=" + ba.M + ",mVideoView.getLayoutParams().height=" + ba.this.f82922f.getLayoutParams().height);
                    return;
                }
                if (ba.this.f82921e.n() == 0) {
                    QLog.d("QFSCommentSlideVideoAnimPart", 1, "[onTopUpdate] mHalfScreenView seems not layout");
                    return;
                }
                float n3 = ba.this.f82921e.n() - f16;
                float r16 = n3 / ba.this.f82921e.r();
                float s16 = ba.this.f82921e.s() / ((float) ba.this.V9());
                if (s16 > 1.0f) {
                    f17 = ba.this.f82921e.s() - ((float) ba.this.V9());
                    s16 = 1.0f;
                } else {
                    f17 = 0.0f;
                }
                float f18 = 1.0f - ((1.0f - s16) * r16);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ba.this.f82922f.getLayoutParams();
                layoutParams.height = (int) (ba.this.E * f18);
                layoutParams.width = (int) (ba.this.F * f18);
                int i3 = (int) (((ba.this.G * (1.0f - r16)) + f17) - ((((float) ba.this.I) * r16) * s16));
                if (i3 > ba.this.G) {
                    i3 = ba.this.G;
                }
                layoutParams.topMargin = i3;
                layoutParams.gravity = 49;
                ba.this.f82922f.setLayoutParams(layoutParams);
                if (ba.this.f82923h != null) {
                    ba.this.f82923h.setLayoutParams(layoutParams);
                }
                QLog.d("QFSCommentSlideVideoAnimPart", 4, "[onTopUpdate] y: " + f16 + ", height: " + layoutParams.height + ", width: " + layoutParams.width + ", topMargin: " + layoutParams.topMargin + ", currentScrollY: " + n3 + ", currentScrollScale: " + r16);
                return;
            }
            QLog.e("QFSCommentSlideVideoAnimPart", 1, "slideView is gone, still receive onScrollChange or mTopLinkView is null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class e implements QFSCommentSheetView.i {
        e() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.i
        public void onDismiss() {
            QLog.d("QFSCommentSlideVideoAnimPart", 1, "dismiss ani part" + hashCode());
            ba.this.ha(true);
            if (ba.this.R9()) {
                ba.this.ia(false);
                ba.this.ga();
            } else {
                QLog.d("QFSCommentSlideVideoAnimPart", 1, "onDismiss return: page not enable");
            }
        }
    }

    public ba() {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.biz.qqcircle.bizparts.az
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ba.this.ca(valueAnimator);
            }
        };
        aa(animatorUpdateListener);
        Z9(animatorUpdateListener);
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

    private void S9() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_cover_size", true)) {
            return;
        }
        this.f82923h = com.tencent.biz.qqcircle.immersive.utils.ax.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long V9() {
        long j3 = this.H;
        if (j3 != 0 && N) {
            return j3;
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X9() {
        QFSCommentSheetView qFSCommentSheetView = this.f82921e;
        if (qFSCommentSheetView != null && (qFSCommentSheetView.getTag() instanceof Boolean) && ((Boolean) this.f82921e.getTag()).booleanValue()) {
            return true;
        }
        return false;
    }

    private void Y9(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup) && view != getPartRootView()) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != view && childAt.getId() != U9() && childAt.getVisibility() == 0) {
                    this.f82920d.add(childAt);
                }
            }
            if (view.getParent() instanceof View) {
                Y9((View) view.getParent());
            }
        }
    }

    private void Z9(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(200L);
        this.K = duration;
        duration.addListener(new b());
        this.K.addUpdateListener(animatorUpdateListener);
    }

    private void aa(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.J = duration;
        duration.addListener(new a());
        this.J.addUpdateListener(animatorUpdateListener);
    }

    private boolean ba() {
        boolean I0 = com.tencent.biz.qqcircle.immersive.utils.r.I0(this.f82922f.getData());
        boolean isFolderScreenOpenMode = TransitionHelper.isFolderScreenOpenMode(getContext());
        boolean k3 = com.tencent.biz.qqcircle.utils.bz.k();
        boolean equals = QCircleDaTongConstant.PageId.PG_XSJ_QZEON_VIDEO_UGC_MID_PAG.equals(getReportBean().getDtCustomPagId());
        QLog.d("QFSCommentSlideVideoAnimPart", 1, "[isNotSupportFullScreenShow] | isVideoLandScape: " + I0 + " | isFolderScreenOpenMode: " + isFolderScreenOpenMode + " | isAllowLandscape: " + k3 + " | isQZoneMiddlePage" + equals);
        if (!I0 || isFolderScreenOpenMode || k3 || equals) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ca(ValueAnimator valueAnimator) {
        if (!(valueAnimator.getAnimatedValue() instanceof Float)) {
            return;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator<View> it = this.f82920d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(floatValue);
        }
    }

    private void da(QFSVideoView qFSVideoView) {
        this.L = true;
        this.C = qFSVideoView.getLayoutParams().height;
        this.D = qFSVideoView.getLayoutParams().width;
        this.E = qFSVideoView.getHeight();
        this.F = qFSVideoView.getWidth();
        this.G = qFSVideoView.getTop();
        this.H = 0L;
        this.I = 0L;
        QLog.d("QFSCommentSlideVideoAnimPart", 1, " recordViewParams mLayoutWidth=" + this.D + ", mLayoutHeight=" + this.C + ", mTopMargin=" + this.G + ", videoView:", Integer.valueOf(qFSVideoView.hashCode()));
        if (!N) {
            QLog.i("QFSCommentSlideVideoAnimPart", 1, "not open recognize content");
            return;
        }
        FeedCloudMeta$StFeed data = this.f82922f.getData();
        if (data == null) {
            QLog.i("QFSCommentSlideVideoAnimPart", 1, "recordViewParams mFeedInfo == null");
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
                QLog.i("QFSCommentSlideVideoAnimPart", 1, "recordViewParams yuhengContentInfos invalid, mFeedInfo=" + data.f398449id.get());
                return;
            }
        }
        QLog.i("QFSCommentSlideVideoAnimPart", 1, "recordViewParams not yuhengContentInfos.vertices, mFeedInfo=" + data.f398449id.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        Iterator<View> it = this.f82920d.iterator();
        while (it.hasNext()) {
            it.next().setAlpha(1.0f);
            it.remove();
        }
        com.tencent.biz.qqcircle.immersive.utils.r.Z0(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        if (!this.L) {
            QLog.e("QFSCommentSlideVideoAnimPart", 1, "resetLinkView mEnable = false");
            return;
        }
        this.L = false;
        if (this.f82922f == null) {
            QLog.e("QFSCommentSlideVideoAnimPart", 1, "resetLinkView mVideoView == null");
            return;
        }
        int na5 = na();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.D, this.C);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = na5;
        this.f82922f.setLayoutParams(layoutParams);
        View view = this.f82923h;
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        QLog.d("QFSCommentSlideVideoAnimPart", 1, " resetLinkView mLayoutWidth=" + this.D + ", mLayoutHeight=" + this.C, ", layoutParams.topMargin=", Integer.valueOf(layoutParams.topMargin), ", videoView:", this.f82922f.hashCode() + ", bottomMargin:" + na5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(boolean z16) {
        int i3;
        if (QCirclePluginUtil.isInLocalActivity(getActivity())) {
            View view = this.f82924i;
            int paddingLeft = view.getPaddingLeft();
            int paddingTop = this.f82924i.getPaddingTop();
            int paddingRight = this.f82924i.getPaddingRight();
            if (z16) {
                i3 = this.f82925m;
            } else {
                i3 = 0;
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(boolean z16) {
        if (z16) {
            ma();
            ja();
        } else {
            la();
        }
    }

    private void ja() {
        if (this.J.isRunning()) {
            this.J.cancel();
        }
        this.K.start();
    }

    private void la() {
        if (this.K.isRunning()) {
            this.K.cancel();
        }
        this.J.start();
    }

    private void ma() {
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference == null) {
            QLog.e("QFSCommentSlideVideoAnimPart", 1, "videoView isn't exist");
            return;
        }
        this.f82922f = weakReference.get();
        S9();
        QFSVideoView qFSVideoView = this.f82922f;
        if (qFSVideoView != null && qFSVideoView.getVisibility() == 0) {
            int[] iArr = new int[2];
            this.f82922f.getLocationInWindow(iArr);
            if (iArr[0] == 0 && iArr[1] == 0) {
                QLog.e("QFSCommentSlideVideoAnimPart", 1, "showVideoViewOnly but video view isn't in window");
                return;
            } else {
                da(this.f82922f);
                Y9(this.f82922f);
                return;
            }
        }
        QLog.e("QFSCommentSlideVideoAnimPart", 1, "videoView is null or is not visible");
    }

    private int na() {
        if (this.f82922f == null) {
            return 0;
        }
        if (ba() && (!com.tencent.biz.qqcircle.utils.bz.k() || !com.tencent.biz.qqcircle.immersive.utils.o.c(this.f82922f.getData()))) {
            return 0;
        }
        ViewParent parent = this.f82922f.getParent();
        if (!(parent instanceof ViewGroup)) {
            return 0;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        return (int) (((viewGroup.getHeight() / 2) - (((viewGroup.getHeight() + r1) * 0.88f) / 1.88f)) + DisplayUtil.getTopHeight(getContext()));
    }

    public int T9() {
        return R.id.f47571xn;
    }

    public int U9() {
        return R.id.u28;
    }

    public int W9() {
        return R.id.u2_;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return W9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentSlideVideoAnimPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return N;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        View findViewById = view.findViewById(U9());
        this.f82924i = findViewById;
        this.f82925m = findViewById.getPaddingBottom();
        QFSCommentSheetView qFSCommentSheetView = (QFSCommentSheetView) view.findViewById(T9());
        this.f82921e = qFSCommentSheetView;
        qFSCommentSheetView.d(new c());
        this.f82921e.e(new d());
        this.f82921e.c(new e());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        if (this.L && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_cover_size", true)) {
            com.tencent.biz.qqcircle.immersive.utils.ax.e(this.f82923h);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c implements QFSCommentSheetView.k {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowDefaultStart() {
            QLog.d("QFSCommentSlideVideoAnimPart", 1, "show ani part" + hashCode());
            ba.this.ha(false);
            if (!ba.this.R9()) {
                QLog.d("QFSCommentSlideVideoAnimPart", 1, "onShow return: page not enable");
            } else if (!ba.this.L) {
                ba.this.ia(true);
            } else {
                QLog.d("QFSCommentSlideVideoAnimPart", 1, "onShow return: isEnableSlide: true");
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowTotalStart() {
            QLog.d("QFSCommentSlideVideoAnimPart", 1, "show ani part" + hashCode());
            ba.this.ha(false);
            if (!ba.this.R9()) {
                QLog.d("QFSCommentSlideVideoAnimPart", 1, "onShow return: page not enable");
            } else if (!ba.this.L) {
                ba.this.ia(true);
            } else {
                QLog.d("QFSCommentSlideVideoAnimPart", 1, "onShow return: isEnableSlide: true");
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowDefault() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onShowTotal() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSCommentSheetView.k
        public void onStateChange(int i3) {
        }
    }
}
