package com.tencent.luggage.wxa.ok;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.mm.plugin.appbrand.ui.SimplifiedLoadingProgressBar;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q extends RelativeLayout implements com.tencent.luggage.wxa.kl.i {

    /* renamed from: a, reason: collision with root package name */
    public View.OnClickListener f136627a;

    /* renamed from: b, reason: collision with root package name */
    public int f136628b;

    /* renamed from: c, reason: collision with root package name */
    public final int f136629c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f136630d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f136631e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f136632f;

    /* renamed from: g, reason: collision with root package name */
    public View f136633g;

    /* renamed from: h, reason: collision with root package name */
    public CircleProgressDrawable f136634h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            View.OnClickListener onClickListener = q.this.f136627a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f136628b = -16777216;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.bfj);
        this.f136629c = dimensionPixelSize;
        setLayoutParams(new ViewGroup.LayoutParams(-1, dimensionPixelSize));
        ImageView imageView = new ImageView(context);
        imageView.setPadding(context.getResources().getDimensionPixelSize(R.dimen.bp8), 0, context.getResources().getDimensionPixelSize(R.dimen.bp8), 0);
        imageView.setBackgroundResource(R.drawable.j2k);
        imageView.setImageResource(R.drawable.ofm);
        imageView.setId(R.id.s_s);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        imageView.setOnClickListener(new a());
        FrameLayout frameLayout = new FrameLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(20);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setMinimumWidth(context.getResources().getDimensionPixelSize(R.dimen.c1n));
        frameLayout.addView(imageView);
        this.f136631e = frameLayout;
        addView(frameLayout);
        this.f136630d = imageView;
        TextView textView = new TextView(context);
        textView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.bck));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setGravity(16);
        textView.setId(R.id.s_x);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        textView.setLayoutParams(layoutParams2);
        addView(textView);
        this.f136632f = textView;
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void a(boolean z16, i.a.EnumC6399a reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
    }

    public void b() {
        this.f136630d.setColorFilter(this.f136628b, PorterDuff.Mode.SRC_ATOP);
        this.f136632f.setTextColor(this.f136628b);
        CircleProgressDrawable circleProgressDrawable = this.f136634h;
        if (circleProgressDrawable != null) {
            circleProgressDrawable.a(this.f136628b);
            CircleProgressDrawable circleProgressDrawable2 = this.f136634h;
            View view = null;
            if (circleProgressDrawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgressLoadingDrawable");
                circleProgressDrawable2 = null;
            }
            View view2 = this.f136633g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgressBar");
            } else {
                view = view2;
            }
            a(circleProgressDrawable2, view);
        }
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void destroy() {
        CircleProgressDrawable circleProgressDrawable = this.f136634h;
        if (circleProgressDrawable != null) {
            circleProgressDrawable.stop();
        }
        removeAllViews();
        this.f136627a = null;
    }

    public double getBackgroundAlpha() {
        return 1.0d;
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public int getBackgroundColor() {
        ColorDrawable colorDrawable;
        Drawable background = super.getBackground();
        if (background instanceof ColorDrawable) {
            colorDrawable = (ColorDrawable) background;
        } else {
            colorDrawable = null;
        }
        if (colorDrawable != null) {
            return colorDrawable.getColor();
        }
        return 0;
    }

    @Nullable
    public View getCapsuleView() {
        return null;
    }

    public int getForegroundColor() {
        return this.f136628b;
    }

    @Nullable
    public CharSequence getMainTitle() {
        return this.f136632f.getText();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View view = this.f136633g;
        if (view != null && view.getVisibility() == 0) {
            CircleProgressDrawable circleProgressDrawable = this.f136634h;
            if (circleProgressDrawable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgressLoadingDrawable");
                circleProgressDrawable = null;
            }
            circleProgressDrawable.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CircleProgressDrawable circleProgressDrawable = this.f136634h;
        if (circleProgressDrawable != null) {
            circleProgressDrawable.stop();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f136629c, 1073741824));
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setBackButtonClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f136627a = onClickListener;
    }

    @Override // android.view.View, com.tencent.luggage.wxa.kl.i
    public void setBackgroundColor(int i3) {
        super.setBackgroundColor(i3);
        if (i3 != 0) {
            setWillNotDraw(false);
        } else {
            setWillNotDraw(true);
        }
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setCloseButtonClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f136627a = onClickListener;
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setForegroundColor(int i3) {
        this.f136628b = i3;
        b();
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setForegroundStyle(@NotNull String style) {
        Intrinsics.checkNotNullParameter(style, "style");
        setForegroundColor(i.b.a(style).f132666a);
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setLoadingIconVisibility(boolean z16) {
        CircleProgressDrawable circleProgressDrawable = null;
        if (z16) {
            if (this.f136633g == null) {
                a();
            }
            View view = this.f136633g;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgressBar");
                view = null;
            }
            view.setVisibility(0);
            CircleProgressDrawable circleProgressDrawable2 = this.f136634h;
            if (circleProgressDrawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgressLoadingDrawable");
                circleProgressDrawable2 = null;
            }
            circleProgressDrawable2.d();
            if (isAttachedToWindow()) {
                CircleProgressDrawable circleProgressDrawable3 = this.f136634h;
                if (circleProgressDrawable3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mProgressLoadingDrawable");
                } else {
                    circleProgressDrawable = circleProgressDrawable3;
                }
                circleProgressDrawable.start();
                return;
            }
            return;
        }
        View view2 = this.f136633g;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
        CircleProgressDrawable circleProgressDrawable4 = this.f136634h;
        if (circleProgressDrawable4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressLoadingDrawable");
        } else {
            circleProgressDrawable = circleProgressDrawable4;
        }
        circleProgressDrawable.stop();
    }

    @Override // com.tencent.luggage.wxa.kl.i
    public void setMainTitle(@Nullable CharSequence charSequence) {
        this.f136632f.setText(charSequence);
    }

    public void setNavHidden(boolean z16) {
        int i3;
        ImageView imageView = this.f136630d;
        if (!z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    public void setOptionButtonClickListener(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final void a() {
        this.f136634h = new com.tencent.luggage.wxa.il.i(getContext());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        View simplifiedLoadingProgressBar = new SimplifiedLoadingProgressBar(context);
        this.f136633g = simplifiedLoadingProgressBar;
        int a16 = com.tencent.luggage.wxa.kn.a.a(simplifiedLoadingProgressBar.getContext(), 3);
        simplifiedLoadingProgressBar.setPadding(a16, a16, a16, a16);
        simplifiedLoadingProgressBar.setId(R.id.s_o);
        int a17 = com.tencent.luggage.wxa.kn.a.a(simplifiedLoadingProgressBar.getContext(), 24);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a17, a17);
        layoutParams.addRule(15);
        layoutParams.addRule(0, this.f136632f.getId());
        layoutParams.addRule(16, this.f136632f.getId());
        simplifiedLoadingProgressBar.setLayoutParams(layoutParams);
        CircleProgressDrawable circleProgressDrawable = this.f136634h;
        CircleProgressDrawable circleProgressDrawable2 = null;
        if (circleProgressDrawable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressLoadingDrawable");
            circleProgressDrawable = null;
        }
        circleProgressDrawable.a(this.f136628b);
        CircleProgressDrawable circleProgressDrawable3 = this.f136634h;
        if (circleProgressDrawable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressLoadingDrawable");
        } else {
            circleProgressDrawable2 = circleProgressDrawable3;
        }
        a(circleProgressDrawable2, simplifiedLoadingProgressBar);
        addView(simplifiedLoadingProgressBar);
    }

    public final void a(CircleProgressDrawable circleProgressDrawable, View view) {
        if (view instanceof ProgressBar) {
            ((ProgressBar) view).setIndeterminateDrawable(circleProgressDrawable);
        } else if (view instanceof SimplifiedLoadingProgressBar) {
            ((SimplifiedLoadingProgressBar) view).setForeground(circleProgressDrawable);
        } else {
            view.setBackground(circleProgressDrawable);
        }
    }

    @Override // com.tencent.luggage.wxa.kl.i
    @NotNull
    public View getActionView() {
        return this;
    }

    public void setBackgroundAlpha(double d16) {
    }
}
