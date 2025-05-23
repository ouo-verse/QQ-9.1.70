package cb4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ui.ZPlanViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import n74.cn;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004J\u0006\u0010\r\u001a\u00020\tJ\u0018\u0010\u000e\u001a\u00020\u00022\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0016\u0010\"\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u0016\u0010&\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0018R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010/\u00a8\u00064"}, d2 = {"Lcb4/g;", "", "", "w", "Lkotlin/Function0;", "cb", "p", "k", "v", "Lcom/tencent/sqshow/zootopia/utils/ui/ZPlanViewState;", "targetState", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "r", tl.h.F, "Ln74/cn;", "a", "Ln74/cn;", "mBinding", "b", "Lcom/tencent/sqshow/zootopia/utils/ui/ZPlanViewState;", "mState", "", "c", UserInfo.SEX_FEMALE, "mHideAlpha", "d", "mShowAlpha", "e", "mHideTransX", "f", "mShowTransX", "g", "mHideScaleX", "mShowScaleX", "i", "mHideScaleY", "j", "mShowScaleY", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mTargetView", "", "l", "Z", "mAnimRunning", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mPendingTask", "<init>", "(Ln74/cn;)V", DomainData.DOMAIN_NAME, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final cn mBinding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ZPlanViewState mState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float mHideAlpha;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mShowAlpha;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mHideTransX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mShowTransX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mHideScaleX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mShowScaleX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mHideScaleY;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float mShowScaleY;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mTargetView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean mAnimRunning;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Runnable mPendingTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"cb4/g$b", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b extends oc4.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f30587e;

        b(Function0<Unit> function0) {
            this.f30587e = function0;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            g.this.t(ZPlanViewState.HIDE);
            Function0<Unit> function0 = this.f30587e;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"cb4/g$c", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class c extends oc4.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f30589e;

        c(Function0<Unit> function0) {
            this.f30589e = function0;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            g.this.t(ZPlanViewState.SHOW);
            Function0<Unit> function0 = this.f30589e;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public g(cn mBinding) {
        Intrinsics.checkNotNullParameter(mBinding, "mBinding");
        this.mBinding = mBinding;
        this.mState = ZPlanViewState.HIDE;
        this.mShowAlpha = 1.0f;
        this.mHideTransX = mBinding.getRoot().getContext().getResources().getDimension(R.dimen.f12547r) / 3.0f;
        this.mShowScaleX = 1.0f;
        this.mHideScaleY = 0.35f;
        this.mShowScaleY = 1.0f;
        LinearLayout linearLayout = mBinding.f419043d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.contentLinearLayout");
        this.mTargetView = linearLayout;
        this.mPendingTask = new Runnable() { // from class: cb4.b
            @Override // java.lang.Runnable
            public final void run() {
                g.s();
            }
        };
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(g this$0, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(function0);
    }

    private final void k(final Function0<Unit> cb5) {
        v();
        QLog.i("SmallHomeBubbleAnimHelper_", 1, "animToHideImpl pivotX:" + this.mTargetView.getPivotX() + ", pivotY:" + this.mTargetView.getPivotY());
        if (this.mAnimRunning) {
            this.mPendingTask = new Runnable() { // from class: cb4.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.l(g.this, cb5);
                }
            };
            return;
        }
        if (this.mState == ZPlanViewState.HIDE) {
            if (cb5 != null) {
                cb5.invoke();
                return;
            }
            return;
        }
        this.mAnimRunning = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new b(cb5));
        LinearLayout linearLayout = this.mTargetView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, com.tencent.luggage.wxa.c8.c.f123400v, linearLayout.getAlpha(), this.mHideAlpha);
        ofFloat.setDuration(100L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setStartDelay(60L);
        animatorSet.play(ofFloat);
        LinearLayout linearLayout2 = this.mTargetView;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout2, "translationX", linearLayout2.getTranslationX(), this.mHideTransX);
        ofFloat2.setDuration(160L);
        ofFloat2.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.b());
        animatorSet.play(ofFloat2);
        LinearLayout linearLayout3 = this.mTargetView;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout3, BasicAnimation.KeyPath.SCALE_X, linearLayout3.getScaleX(), this.mHideScaleX);
        ofFloat3.setDuration(160L);
        ofFloat3.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.b());
        animatorSet.play(ofFloat3);
        LinearLayout linearLayout4 = this.mTargetView;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout4, BasicAnimation.KeyPath.SCALE_Y, linearLayout4.getScaleY(), this.mHideScaleY);
        ofFloat4.setDuration(160L);
        ofFloat4.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.b());
        animatorSet.play(ofFloat4);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(g this$0, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(g this$0, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p(function0);
    }

    private final void p(final Function0<Unit> cb5) {
        v();
        QLog.i("SmallHomeBubbleAnimHelper_", 1, "animToShowImpl pivotX:" + this.mTargetView.getPivotX() + ", pivotY:" + this.mTargetView.getPivotY());
        if (this.mAnimRunning) {
            this.mPendingTask = new Runnable() { // from class: cb4.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.q(g.this, cb5);
                }
            };
            return;
        }
        if (this.mState == ZPlanViewState.SHOW) {
            if (cb5 != null) {
                cb5.invoke();
                return;
            }
            return;
        }
        this.mAnimRunning = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new c(cb5));
        LinearLayout linearLayout = this.mTargetView;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, com.tencent.luggage.wxa.c8.c.f123400v, linearLayout.getAlpha(), this.mShowAlpha);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(60L);
        animatorSet.play(ofFloat);
        LinearLayout linearLayout2 = this.mTargetView;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout2, "translationX", linearLayout2.getTranslationX(), this.mShowTransX);
        ofFloat2.setDuration(260L);
        ofFloat2.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.d());
        animatorSet.play(ofFloat2);
        LinearLayout linearLayout3 = this.mTargetView;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout3, BasicAnimation.KeyPath.SCALE_X, linearLayout3.getScaleX(), this.mShowScaleX);
        ofFloat3.setDuration(230L);
        ofFloat3.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.d());
        animatorSet.play(ofFloat3);
        LinearLayout linearLayout4 = this.mTargetView;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(linearLayout4, BasicAnimation.KeyPath.SCALE_Y, linearLayout4.getScaleY(), this.mShowScaleY);
        ofFloat4.setDuration(230L);
        ofFloat4.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.d());
        animatorSet.play(ofFloat4);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(g this$0, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(ZPlanViewState targetState) {
        this.mState = targetState;
        if (targetState == ZPlanViewState.HIDE) {
            this.mBinding.getRoot().setVisibility(4);
        }
        this.mAnimRunning = false;
        this.mPendingTask.run();
        this.mPendingTask = new Runnable() { // from class: cb4.f
            @Override // java.lang.Runnable
            public final void run() {
                g.u();
            }
        };
    }

    private final void v() {
        this.mTargetView.setPivotX(r0.getWidth());
        this.mTargetView.setPivotY(r0.getHeight() / 2);
    }

    private final void w() {
        this.mState = ZPlanViewState.HIDE;
        this.mTargetView.setAlpha(this.mHideAlpha);
        this.mTargetView.setTranslationX(this.mHideScaleX);
        this.mTargetView.setScaleX(this.mHideScaleX);
        this.mTargetView.setScaleY(this.mHideScaleY);
        this.mBinding.getRoot().setVisibility(4);
    }

    public final void h(final Function0<Unit> cb5) {
        this.mTargetView.post(new Runnable() { // from class: cb4.a
            @Override // java.lang.Runnable
            public final void run() {
                g.j(g.this, cb5);
            }
        });
    }

    public final void m(final Function0<Unit> cb5) {
        this.mBinding.getRoot().setVisibility(0);
        this.mTargetView.post(new Runnable() { // from class: cb4.c
            @Override // java.lang.Runnable
            public final void run() {
                g.o(g.this, cb5);
            }
        });
    }

    /* renamed from: r, reason: from getter */
    public final ZPlanViewState getMState() {
        return this.mState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(g gVar, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        gVar.h(function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void n(g gVar, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = null;
        }
        gVar.m(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u() {
    }
}
