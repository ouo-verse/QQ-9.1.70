package com.tencent.mobileqq.sharepanel.multiSelect.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0002+,B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView;", "Landroid/widget/HorizontalScrollView;", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "", "velocityX", "", "fling", "isToSecond", "setToView", "g", "d", "Z", "startScroll", "", "e", UserInfo.SEX_FEMALE, "startX", "f", "startY", h.F, "lastX", "i", "isInSecondView", "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$b;", "l", "()Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$b;", "setDelegate", "(Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$b;)V", "delegate", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class AnimateHorizontalSwitchView extends HorizontalScrollView {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final boolean D;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean startScroll;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float startX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float startY;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float lastX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isInSecondView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b delegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$a;", "", "", "needAnimation", "Z", "a", "()Z", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AnimateHorizontalSwitchView.D;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnimateHorizontalSwitchView.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AnimateHorizontalSwitchView.this.isInSecondView = true;
                AnimateHorizontalSwitchView.this.l().b(true);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnimateHorizontalSwitchView.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                AnimateHorizontalSwitchView.this.isInSecondView = false;
                AnimateHorizontalSwitchView.this.l().b(false);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$e", "Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$b;", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e implements b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView.b
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return b.a.b(this);
        }

        @Override // com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView.b
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                b.a.d(this, z16);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView.b
        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return b.a.c(this);
        }

        @Override // com.tencent.mobileqq.sharepanel.multiSelect.widget.AnimateHorizontalSwitchView.b
        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return b.a.a(this);
        }
    }

    static {
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40620);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        if (Build.VERSION.SDK_INT >= 26) {
            z16 = true;
        } else {
            z16 = false;
        }
        D = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimateHorizontalSwitchView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AnimateHorizontalSwitchView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.setScrollX(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AnimateHorizontalSwitchView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ViewGroup.LayoutParams layoutParams = this$0.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = (int) floatValue;
        this$0.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AnimateHorizontalSwitchView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.setScrollX(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(AnimateHorizontalSwitchView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        ViewGroup.LayoutParams layoutParams = this$0.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = (int) floatValue;
        this$0.setLayoutParams(marginLayoutParams);
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int velocityX) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, velocityX);
        }
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void g(boolean isToSecond) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, isToSecond);
            return;
        }
        if (isToSecond) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "scrollX", getScrollX(), this.delegate.a());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.widget.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AnimateHorizontalSwitchView.h(AnimateHorizontalSwitchView.this, valueAnimator);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            if (D) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "height", getHeight(), this.delegate.c());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.widget.c
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AnimateHorizontalSwitchView.i(AnimateHorizontalSwitchView.this, valueAnimator);
                    }
                });
                animatorSet.playTogether(ofInt, ofFloat);
            } else {
                animatorSet.playTogether(ofInt);
            }
            animatorSet.setDuration(200L);
            animatorSet.addListener(new c());
            animatorSet.start();
            return;
        }
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, "scrollX", getScrollX(), 0);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.widget.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimateHorizontalSwitchView.j(AnimateHorizontalSwitchView.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        if (D) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "height", getHeight(), this.delegate.d());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.widget.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AnimateHorizontalSwitchView.k(AnimateHorizontalSwitchView.this, valueAnimator);
                }
            });
            animatorSet2.playTogether(ofInt2, ofFloat2);
        } else {
            animatorSet2.playTogether(ofInt2);
        }
        animatorSet2.setDuration(200L);
        animatorSet2.addListener(new d());
        animatorSet2.start();
    }

    @NotNull
    public final b l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.delegate;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (!this.isInSecondView) {
            return false;
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.startScroll) {
                    return super.onInterceptTouchEvent(ev5);
                }
            } else if (this.startScroll) {
                this.startScroll = false;
                this.startX = 0.0f;
                this.lastX = 0.0f;
                return super.onInterceptTouchEvent(ev5);
            }
        } else if (ev5.getX() <= ViewUtils.dpToPx(getWidth() / 9)) {
            this.startScroll = true;
            this.startX = ev5.getX();
            this.startY = ev5.getY();
            return super.onInterceptTouchEvent(ev5);
        }
        return false;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (!this.isInSecondView) {
            return false;
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.lastX = this.startX;
                    this.startX = ev5.getX();
                    return super.onTouchEvent(ev5);
                }
            } else {
                if (ev5.getX() - this.lastX > 0.0f) {
                    g(false);
                } else {
                    g(true);
                }
                return super.onTouchEvent(ev5);
            }
        } else if (ev5.getX() <= ViewUtils.dpToPx(getHeight())) {
            this.startScroll = true;
            this.startX = ev5.getX();
            this.startY = ev5.getY();
            return super.onTouchEvent(ev5);
        }
        return false;
    }

    public final void setDelegate(@NotNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.delegate = bVar;
        }
    }

    public final void setToView(boolean isToSecond) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, isToSecond);
        } else if (isToSecond) {
            setScrollX(this.delegate.a());
            this.delegate.b(true);
        } else {
            setScrollX(0);
            this.delegate.b(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimateHorizontalSwitchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ AnimateHorizontalSwitchView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimateHorizontalSwitchView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.delegate = new e();
        } else {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/widget/AnimateHorizontalSwitchView$b;", "", "", "a", "d", "c", "", "isInSecondView", "", "b", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        int a();

        void b(boolean isInSecondView);

        int c();

        int d();

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class a {
            public static int a(@NotNull b bVar) {
                return DisplayUtil.getScreenHeight() / 2;
            }

            public static int b(@NotNull b bVar) {
                return ScreenUtil.SCREEN_WIDTH;
            }

            public static int c(@NotNull b bVar) {
                return (int) (ScreenUtil.SCREEN_HIGHT * 0.86f);
            }

            public static void d(@NotNull b bVar, boolean z16) {
            }
        }
    }
}
