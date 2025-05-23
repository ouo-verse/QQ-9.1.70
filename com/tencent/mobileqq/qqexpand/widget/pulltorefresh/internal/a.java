package com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes16.dex */
public abstract class a extends LoadingLayoutBase {
    static final Interpolator I = new LinearInterpolator();
    private final FrameLayout C;
    private boolean D;
    private CharSequence E;
    private CharSequence F;
    private CharSequence G;
    private CharSequence H;

    /* renamed from: d, reason: collision with root package name */
    protected final ImageView f264247d;

    /* renamed from: e, reason: collision with root package name */
    protected final ProgressBar f264248e;

    /* renamed from: f, reason: collision with root package name */
    protected final PullToRefreshBase.Mode f264249f;

    /* renamed from: h, reason: collision with root package name */
    protected final PullToRefreshBase.Orientation f264250h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f264251i;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f264252m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static /* synthetic */ class C8325a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f264253a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f264254b;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            f264254b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f264254b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PullToRefreshBase.Orientation.values().length];
            f264253a = iArr2;
            try {
                iArr2[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f264253a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context);
        int i3;
        Drawable drawable;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable2;
        int i16;
        this.f264249f = mode;
        this.f264250h = orientation;
        if (C8325a.f264253a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(R.layout.f168398uv, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.f168397uu, this);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.cc7);
        this.C = frameLayout;
        this.f264251i = (TextView) frameLayout.findViewById(R.id.g5x);
        this.f264248e = (ProgressBar) frameLayout.findViewById(R.id.g5v);
        this.f264252m = (TextView) frameLayout.findViewById(R.id.g5w);
        this.f264247d = (ImageView) frameLayout.findViewById(R.id.g5s);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        int[] iArr = C8325a.f264254b;
        if (iArr[mode.ordinal()] != 1) {
            if (orientation == PullToRefreshBase.Orientation.VERTICAL) {
                i16 = 80;
            } else {
                i16 = 5;
            }
            layoutParams.gravity = i16;
            this.E = context.getString(R.string.d7w);
            this.F = context.getString(R.string.d7x);
            this.G = context.getString(R.string.d7y);
        } else {
            if (orientation == PullToRefreshBase.Orientation.VERTICAL) {
                i3 = 48;
            } else {
                i3 = 3;
            }
            layoutParams.gravity = i3;
            this.E = context.getString(R.string.d7t);
            this.F = context.getString(R.string.d7u);
            this.G = context.getString(R.string.d7v);
        }
        int i17 = tg2.a.S3;
        if (typedArray.hasValue(i17) && (drawable2 = typedArray.getDrawable(i17)) != null) {
            eh2.a.b(this, drawable2);
        }
        int i18 = tg2.a.W3;
        if (typedArray.hasValue(i18)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i18, typedValue);
            p(typedValue.data);
        }
        int i19 = tg2.a.f436147d4;
        if (typedArray.hasValue(i19)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(i19, typedValue2);
            o(typedValue2.data);
        }
        int i26 = tg2.a.X3;
        if (typedArray.hasValue(i26) && (colorStateList2 = typedArray.getColorStateList(i26)) != null) {
            setTextColor(colorStateList2);
        }
        int i27 = tg2.a.V3;
        if (typedArray.hasValue(i27) && (colorStateList = typedArray.getColorStateList(i27)) != null) {
            setSubTextColor(colorStateList);
        }
        int i28 = tg2.a.N3;
        if (typedArray.hasValue(i28)) {
            drawable = typedArray.getDrawable(i28);
        } else {
            drawable = null;
        }
        if (iArr[mode.ordinal()] != 1) {
            int i29 = tg2.a.Q3;
            if (typedArray.hasValue(i29)) {
                drawable = typedArray.getDrawable(i29);
            } else {
                int i36 = tg2.a.R3;
                if (typedArray.hasValue(i36)) {
                    drawable = typedArray.getDrawable(i36);
                }
            }
        } else {
            int i37 = tg2.a.P3;
            if (typedArray.hasValue(i37)) {
                drawable = typedArray.getDrawable(i37);
            } else {
                int i38 = tg2.a.O3;
                if (typedArray.hasValue(i38)) {
                    drawable = typedArray.getDrawable(i38);
                }
            }
        }
        setLoadingDrawable(drawable == null ? context.getResources().getDrawable(h()) : drawable);
        reset();
    }

    private void o(int i3) {
        TextView textView = this.f264252m;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i3);
        }
    }

    private void p(int i3) {
        TextView textView = this.f264251i;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i3);
        }
        TextView textView2 = this.f264252m;
        if (textView2 != null) {
            textView2.setTextAppearance(getContext(), i3);
        }
    }

    private void setSubHeaderText(CharSequence charSequence) {
        TextView textView = this.f264252m;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        TextView textView = this.f264252m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.f264251i;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.f264252m;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase
    public final void a() {
        reset();
        TextView textView = this.f264251i;
        if (textView != null) {
            textView.setText(this.E);
        }
        k();
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase
    public final void b() {
        TextView textView = this.f264251i;
        if (textView != null) {
            textView.setText(this.F);
        }
        if (this.D) {
            ((AnimationDrawable) this.f264247d.getDrawable()).start();
        } else {
            l();
        }
        TextView textView2 = this.f264252m;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase
    public final void d() {
        TextView textView = this.f264251i;
        if (textView != null) {
            textView.setText(this.G);
        }
        m();
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase
    public final int e() {
        if (C8325a.f264253a[this.f264250h.ordinal()] != 1) {
            return this.C.getHeight();
        }
        return this.C.getWidth();
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase
    public final void f(float f16) {
        if (!this.D) {
            j(f16);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase
    public void g() {
        TextView textView = this.f264251i;
        if (textView != null) {
            textView.setText(this.H);
        }
        ProgressBar progressBar = this.f264248e;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    protected abstract int h();

    protected abstract void i(Drawable drawable);

    protected abstract void j(float f16);

    protected abstract void k();

    protected abstract void l();

    protected abstract void m();

    protected abstract void n();

    public final void reset() {
        TextView textView = this.f264251i;
        if (textView != null) {
            textView.setText(this.E);
        }
        this.f264247d.setVisibility(0);
        if (this.D) {
            ((AnimationDrawable) this.f264247d.getDrawable()).stop();
        } else {
            n();
        }
        TextView textView2 = this.f264252m;
        if (textView2 != null) {
            if (TextUtils.isEmpty(textView2.getText())) {
                this.f264252m.setVisibility(8);
            } else {
                this.f264252m.setVisibility(0);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
        setSubHeaderText(charSequence);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public final void setLoadingDrawable(Drawable drawable) {
        this.f264247d.setImageDrawable(drawable);
        this.D = drawable instanceof AnimationDrawable;
        i(drawable);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setPullLabel(CharSequence charSequence) {
        this.E = charSequence;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setRefreshResultLabel(CharSequence charSequence) {
        this.H = charSequence;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setRefreshingLabel(CharSequence charSequence) {
        this.F = charSequence;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase, com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setReleaseLabel(CharSequence charSequence) {
        this.G = charSequence;
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.LoadingLayoutBase
    public void setTextTypeface(Typeface typeface) {
        this.f264251i.setTypeface(typeface);
    }
}
