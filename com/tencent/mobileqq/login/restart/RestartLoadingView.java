package com.tencent.mobileqq.login.restart;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/login/restart/RestartLoadingView;", "Landroid/widget/FrameLayout;", "", "g", "", "tipText", "", "isCanceledOnTouchOutside", "withAnim", tl.h.F, "e", "Landroid/view/View;", "d", "Landroid/view/View;", "contentView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tipTv", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "iconIv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class RestartLoadingView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView tipTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView iconIv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/login/restart/RestartLoadingView$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RestartLoadingView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                RestartLoadingView.this.g();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                RestartLoadingView.this.g();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    public /* synthetic */ RestartLoadingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(RestartLoadingView this$0, ValueAnimator valueAnimator) {
        Float f16;
        float f17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            f16 = (Float) animatedValue;
        } else {
            f16 = null;
        }
        if (f16 != null) {
            f17 = f16.floatValue();
        } else {
            f17 = 0.0f;
        }
        this$0.contentView.setAlpha(f17);
        this$0.tipTv.setAlpha(f17);
        this$0.iconIv.setAlpha(f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        ViewGroup viewGroup;
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(this);
            }
        } catch (Exception e16) {
            QLog.e("RestartLoadingView", 1, "remove error:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(boolean z16, RestartLoadingView this$0, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            Context context = this$0.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                l.f242636a.a(activity);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(RestartLoadingView this$0, ValueAnimator valueAnimator) {
        Float f16;
        float f17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            f16 = (Float) animatedValue;
        } else {
            f16 = null;
        }
        if (f16 != null) {
            f17 = f16.floatValue();
        } else {
            f17 = 1.0f;
        }
        this$0.contentView.setAlpha(f17);
        this$0.tipTv.setAlpha(f17);
        this$0.iconIv.setAlpha(f17);
    }

    public final void e(boolean withAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, withAnim);
            return;
        }
        if (withAnim) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(250L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.login.restart.t
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RestartLoadingView.f(RestartLoadingView.this, valueAnimator);
                }
            });
            ofFloat.addListener(new a());
            ofFloat.start();
        }
    }

    public final void h(@NotNull String tipText, final boolean isCanceledOnTouchOutside, boolean withAnim) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, tipText, Boolean.valueOf(isCanceledOnTouchOutside), Boolean.valueOf(withAnim));
            return;
        }
        Intrinsics.checkNotNullParameter(tipText, "tipText");
        this.tipTv.setText(tipText);
        TextView textView = this.tipTv;
        if (tipText.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 8;
        }
        textView.setVisibility(i3);
        this.iconIv.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 1));
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.restart.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestartLoadingView.i(isCanceledOnTouchOutside, this, view);
            }
        });
        if (withAnim) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(250L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.login.restart.v
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RestartLoadingView.j(RestartLoadingView.this, valueAnimator);
                }
            });
            ofFloat.start();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestartLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167841e51, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(co\u2026alog_loading, this, true)");
        this.contentView = inflate;
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.gravity = 17;
        }
        inflate.setClickable(true);
        View findViewById = findViewById(R.id.yt9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026qq.qqui.R.id.loading_tip)");
        this.tipTv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.ysu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(com.tencent\u2026q.qqui.R.id.loading_icon)");
        this.iconIv = (ImageView) findViewById2;
    }
}
