package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.MultiImageTextView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FormSimpleItem extends RelativeLayout implements FormItemConstants {

    /* renamed from: a0, reason: collision with root package name */
    protected static boolean f315666a0;
    protected Drawable C;
    protected int D;
    protected int E;
    protected int F;
    protected boolean G;
    protected Drawable H;
    protected int I;
    protected boolean J;
    protected boolean K;
    protected TextView L;
    protected MultiImageTextView M;
    private int N;
    private int P;
    private int Q;
    private final Rect R;
    private final Paint S;
    protected int T;
    private int U;
    private int V;
    protected int W;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f315667d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f315668e;

    /* renamed from: f, reason: collision with root package name */
    private int f315669f;

    /* renamed from: h, reason: collision with root package name */
    private int f315670h;

    /* renamed from: i, reason: collision with root package name */
    private int f315671i;

    /* renamed from: m, reason: collision with root package name */
    protected CharSequence f315672m;

    public FormSimpleItem(Context context) {
        this(context, null);
    }

    private boolean g() {
        if (!"1000".equals(ThemeUtil.curThemeId) && !"999".equals(ThemeUtil.curThemeId)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26 = getResources().getDisplayMetrics().widthPixels;
        int i27 = this.P;
        if (o.l()) {
            i3 = 5;
        } else {
            i3 = 2;
        }
        int i28 = i26 - (i27 * i3);
        if (this.f315672m == null) {
            Drawable drawable = this.C;
            if (drawable != null && this.G) {
                i19 = this.U + this.P + this.V;
            } else if (drawable != null && !this.G) {
                i19 = this.U;
            } else if (drawable == null && this.G) {
                i19 = this.V;
            } else {
                i19 = 0;
            }
            this.W = i28 - i19;
            this.T = 0;
            return;
        }
        int i29 = i28 - this.P;
        Drawable drawable2 = this.f315668e;
        if (drawable2 != null) {
            int i36 = this.f315669f;
            if (i36 == 0) {
                i36 = drawable2.getIntrinsicWidth();
            }
            i16 = i36 + this.P;
        } else {
            i16 = 0;
        }
        TextPaint paint = this.L.getPaint();
        CharSequence charSequence = this.f315667d;
        if (charSequence != null) {
            i17 = i16 + ((int) paint.measureText(charSequence.toString()));
        } else {
            i17 = 0;
        }
        Drawable drawable3 = this.C;
        if (drawable3 != null) {
            int i37 = this.D;
            if (i37 == 0) {
                i37 = drawable3.getIntrinsicWidth();
            }
            i18 = i37 + 0 + this.P;
        } else {
            i18 = 0;
        }
        if (this.G) {
            i18 = i18 + this.H.getIntrinsicWidth() + this.P;
        }
        StaticLayout staticLayout = new StaticLayout(this.f315672m, this.M.getPaint(), 100000, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int lineCount = staticLayout.getLineCount();
        int i38 = 0;
        for (int i39 = 0; i39 < lineCount; i39++) {
            i38 = (int) Math.max(i38, staticLayout.getLineWidth(i39));
        }
        int paddingLeft = i18 + i38 + this.M.getPaddingLeft();
        int i46 = i29 / 2;
        if (i17 >= i46 && paddingLeft >= i46) {
            i17 = i46;
            paddingLeft = i17;
        } else if (i17 > i46 && paddingLeft < i46) {
            i17 = i29 - paddingLeft;
        } else if (i17 < i46 && paddingLeft > i46) {
            paddingLeft = i29 - i17;
        }
        this.W = i17;
        this.T = paddingLeft;
    }

    protected ColorStateList b(Resources resources, int i3) {
        return o.a(resources, i3);
    }

    public TextView c() {
        return this.L;
    }

    public MultiImageTextView d() {
        return this.M;
    }

    protected Drawable e(Resources resources, int i3) {
        return o.h(resources, i3, f315666a0, this.K);
    }

    protected void f() {
        setFocusable(true);
        setClickable(true);
        this.L = new TextView(getContext());
        if (!TextUtils.isEmpty(this.f315667d)) {
            this.L.setText(this.f315667d);
            this.L.setContentDescription(this.f315667d);
        }
        this.L.setId(R.id.cjm);
        if (this.J) {
            this.L.setSingleLine(true);
            this.L.setEllipsize(TextUtils.TruncateAt.END);
            this.L.setDuplicateParentStateEnabled(true);
        }
        this.L.setTextColor(b(getResources(), this.f315671i));
        this.L.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158563j1));
        this.L.setGravity(19);
        setLeftIcon(this.f315668e, this.f315669f, this.f315670h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i3 = this.P;
        layoutParams.leftMargin = i3;
        if (!this.J) {
            layoutParams.topMargin = i3;
            layoutParams.bottomMargin = i3;
            setMinimumHeight(this.N);
        }
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.L.setMaxWidth(this.W);
        addView(this.L, layoutParams);
        MultiImageTextView multiImageTextView = new MultiImageTextView(getContext());
        this.M = multiImageTextView;
        multiImageTextView.setId(R.id.cjn);
        this.M.setSingleLine(true);
        this.M.setTextColor(b(getResources(), this.F));
        this.M.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158570j9));
        this.M.setGravity(19);
        this.M.setEllipsize(TextUtils.TruncateAt.END);
        this.M.setDuplicateParentStateEnabled(true);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = this.P;
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        addView(this.M, layoutParams2);
        i();
        setBackgroundDrawable(e(getResources(), this.I));
    }

    public void h(boolean z16) {
        this.G = z16;
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        if (this.M == null) {
            return;
        }
        a();
        TextView textView = this.L;
        if (textView != null) {
            textView.setMaxWidth(this.W);
        }
        if (!g() && !"1103".equals(ThemeUtil.curThemeId)) {
            if (this.H != null) {
                i17 = FormItemConstants.WIDTH_DEFAULT_ARROW;
                i3 = 0;
                i18 = FormItemConstants.HEIGHT_DEFAULT_ARROW;
                i16 = 0;
            } else {
                i3 = 0;
                i16 = 0;
                i17 = 0;
                i18 = 0;
            }
        } else {
            Drawable drawable = this.C;
            if (drawable != null) {
                i3 = drawable.getIntrinsicWidth();
                i16 = this.C.getIntrinsicHeight();
            } else {
                i3 = 0;
                i16 = 0;
            }
            i17 = FormItemConstants.WIDTH_DEFAULT_ARROW;
            i18 = FormItemConstants.HEIGHT_DEFAULT_ARROW;
        }
        if (!TextUtils.isEmpty(this.f315672m)) {
            this.M.setVisibility(0);
            this.M.setText(this.f315672m);
            this.M.setTextColor(b(getResources(), this.F));
            this.M.setContentDescription(this.f315672m);
            this.M.setMaxWidth(this.T);
            Drawable drawable2 = this.C;
            if (drawable2 != null && this.G) {
                if (this.D > 0 && this.E > 0) {
                    Drawable drawable3 = this.H;
                    if (drawable3 != null) {
                        drawable3.setBounds(0, 0, i17, i18);
                    }
                    this.C.setBounds(0, 0, this.D, this.E);
                    this.M.setCompoundDrawables(this.C, null, this.H, null);
                } else {
                    Drawable drawable4 = this.H;
                    if (drawable4 != null) {
                        drawable4.setBounds(0, 0, i17, i18);
                        this.C.setBounds(0, 0, i3, i16);
                        this.M.setCompoundDrawables(this.C, null, this.H, null);
                    }
                }
                this.M.setCompoundDrawablePadding(8);
                return;
            }
            if (drawable2 != null && !this.G) {
                int i28 = this.D;
                if (i28 > 0 && (i27 = this.E) > 0) {
                    drawable2.setBounds(0, 0, i28, i27);
                    this.M.setCompoundDrawables(this.C, null, null, null);
                } else {
                    this.M.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.M.setCompoundDrawablePadding(8);
                return;
            }
            if (drawable2 == null && this.G) {
                Drawable drawable5 = this.H;
                if (drawable5 != null) {
                    drawable5.setBounds(0, 0, i17, i18);
                    this.M.setCompoundDrawables(null, null, this.H, null);
                }
                this.M.setCompoundDrawablePadding(8);
                return;
            }
            if (drawable2 == null && !this.G) {
                this.M.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.M.setCompoundDrawablePadding(0);
                return;
            }
            return;
        }
        this.M.setText("");
        Drawable drawable6 = this.C;
        if (drawable6 != null && this.G) {
            this.M.setVisibility(0);
            int i29 = this.D;
            if (i29 > 0 && (i26 = this.E) > 0) {
                this.C.setBounds(0, 0, i29, i26);
                Drawable drawable7 = this.H;
                if (drawable7 != null) {
                    drawable7.setBounds(0, 0, i17, i18);
                }
                this.M.setCompoundDrawables(this.C, null, this.H, null);
            } else {
                Drawable drawable8 = this.H;
                if (drawable8 != null) {
                    drawable8.setBounds(0, 0, i17, i18);
                    this.C.setBounds(0, 0, i3, i16);
                    this.M.setCompoundDrawables(this.C, null, this.H, null);
                }
            }
            this.M.setCompoundDrawablePadding(8);
            return;
        }
        if (drawable6 != null && !this.G) {
            this.M.setVisibility(0);
            int i36 = this.D;
            if (i36 > 0 && (i19 = this.E) > 0) {
                this.C.setBounds(0, 0, i36, i19);
                this.M.setCompoundDrawables(this.C, null, null, null);
            } else {
                this.M.setCompoundDrawablesWithIntrinsicBounds(this.C, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.M.setCompoundDrawablePadding(0);
            return;
        }
        if (drawable6 == null && this.G) {
            this.M.setVisibility(0);
            Drawable drawable9 = this.H;
            if (drawable9 != null) {
                drawable9.setBounds(0, 0, i17, i18);
                this.M.setCompoundDrawables(null, null, this.H, null);
            }
            this.M.setCompoundDrawablePadding(0);
            return;
        }
        if (drawable6 == null && !this.G) {
            this.M.setVisibility(8);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (o.l() && this.K) {
            return;
        }
        int i3 = this.I;
        if (i3 == 1 || i3 == 2) {
            if (g()) {
                this.S.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
            } else {
                this.S.setColor(0);
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.R.set(FormItemConstants.PADDING_DEFAULT_BG_DIVIDER, measuredHeight - FormItemConstants.HEIGHT_DEFAULT_BG_DIVIDER, measuredWidth, measuredHeight);
            canvas.drawRect(this.R, this.S);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.J) {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.N, 1073741824));
            setMeasuredDimension(getMeasuredWidth(), this.N);
        } else {
            super.onMeasure(i3, i16);
        }
    }

    public void setArrowIcon(Drawable drawable) {
        this.H = drawable;
    }

    public void setBgType(int i3) {
        setBgType(i3, false);
    }

    public void setCustomHeight(int i3) {
        if (i3 > 0 && this.J) {
            this.N = i3;
            requestLayout();
        }
    }

    public void setLeftIcon(Drawable drawable) {
        TextView textView = this.L;
        if (textView != null) {
            this.f315668e = drawable;
            if (drawable == null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            if (drawable.getIntrinsicHeight() > this.N) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.N);
                this.L.setCompoundDrawables(drawable, null, null, null);
            } else {
                this.L.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.L.setCompoundDrawablePadding(this.Q);
        }
    }

    public void setLeftText(CharSequence charSequence) {
        TextView textView;
        if (!TextUtils.isEmpty(charSequence) && (textView = this.L) != null) {
            this.f315667d = charSequence;
            textView.setText(charSequence);
            this.L.setTextColor(b(getResources(), this.f315671i));
            this.L.setContentDescription(this.f315667d);
        }
    }

    public void setLeftTextColor(int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 1 && i3 != 4 && i3 != 5) {
            throw new RuntimeException("Parameter colorType is illegal!");
        }
        if (this.f315667d != null) {
            this.f315671i = i3;
            this.L.setTextColor(b(getResources(), this.f315671i));
        }
    }

    public void setLeftTextNoColor(CharSequence charSequence) {
        TextView textView;
        if (!TextUtils.isEmpty(charSequence) && (textView = this.L) != null) {
            this.f315667d = charSequence;
            textView.setText(charSequence);
            this.L.setContentDescription(this.f315667d);
        }
    }

    public void setLeftTextSize(float f16) {
        TextView textView = this.L;
        if (textView != null) {
            textView.setTextSize(f16);
        }
    }

    public void setRightIcon(Drawable drawable) {
        setRightIcon(drawable, 0, 0);
    }

    public void setRightText(CharSequence charSequence) {
        this.f315672m = charSequence;
        i();
    }

    public void setRightTextColor(int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 1) {
            throw new RuntimeException("Parameter colorType is illegal!");
        }
        MultiImageTextView multiImageTextView = this.M;
        if (multiImageTextView != null) {
            this.F = i3;
            multiImageTextView.setVisibility(0);
            this.M.setTextColor(b(getResources(), this.F));
        }
    }

    public void setUseCardStyleUI(boolean z16) {
        this.K = z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0105, code lost:
    
        if (r2 != null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FormSimpleItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.R = new Rect();
        this.S = new Paint();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158564j2);
        this.U = (int) ((getResources().getDisplayMetrics().density * 35.0f) + 0.5d);
        this.V = (int) ((getResources().getDisplayMetrics().density * 15.0f) + 0.5d);
        this.H = getResources().getDrawable(R.drawable.jae);
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FormItem);
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.FormItem_customPadding, getResources().getDimensionPixelSize(R.dimen.aes));
            this.P = dimensionPixelSize2;
            this.Q = typedArray.getDimensionPixelSize(u51.a.f438285d0, dimensionPixelSize2);
            this.N = typedArray.getDimensionPixelSize(R.styleable.FormItem_customHeight, dimensionPixelSize);
            this.f315667d = typedArray.getString(R.styleable.FormItem_leftText);
            this.f315671i = typedArray.getInt(R.styleable.FormItem_leftTextColor, 0);
            this.f315668e = typedArray.getDrawable(R.styleable.FormItem_leftIcon);
            this.f315669f = typedArray.getDimensionPixelSize(R.styleable.FormItem_leftIconWidth, 0);
            int dimensionPixelSize3 = typedArray.getDimensionPixelSize(R.styleable.FormItem_leftIconHeight, 0);
            this.f315670h = dimensionPixelSize3;
            this.f315670h = Math.min(this.N, dimensionPixelSize3);
            this.f315672m = typedArray.getString(R.styleable.FormItem_rightText);
            this.F = typedArray.getInt(R.styleable.FormItem_rightTextColor, 3);
            this.C = typedArray.getDrawable(R.styleable.FormItem_rightIcon);
            this.D = typedArray.getDimensionPixelSize(R.styleable.FormItem_rightIconWidth, 0);
            int dimensionPixelSize4 = typedArray.getDimensionPixelSize(R.styleable.FormItem_rightIconHeight, 0);
            this.E = dimensionPixelSize4;
            this.E = Math.min(this.N, dimensionPixelSize4);
            this.G = typedArray.getBoolean(R.styleable.FormItem_showArrow, false);
            this.I = typedArray.getInt(R.styleable.FormItem_bgType, 0);
            f315666a0 = typedArray.getBoolean(R.styleable.FormItem_needFocusBg, true);
            this.J = typedArray.getBoolean(R.styleable.FormItem_needSetHeght, true);
            this.K = typedArray.getBoolean(R.styleable.FormItem_cardUIStyle, true);
        } catch (Throwable unused) {
        }
        typedArray.recycle();
        this.S.setAntiAlias(true);
        this.S.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
        f();
    }

    public void setBgType(int i3, boolean z16) {
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
            throw new RuntimeException("Parameter bgType is illegal!");
        }
        if (z16 || this.I != i3) {
            this.I = i3;
            setBackgroundDrawable(e(getResources(), this.I));
        }
    }

    public void setRightIcon(Drawable drawable, int i3, int i16) {
        if (i3 < 0 || i16 < 0) {
            return;
        }
        this.D = i3;
        this.E = Math.min(this.N, i16);
        this.C = drawable;
        i();
    }

    public void setLeftIcon(Drawable drawable, int i3, int i16) {
        if (drawable == null || this.L == null || i3 < 0 || i16 < 0) {
            return;
        }
        if (i3 <= 0 || i16 <= 0) {
            if (i3 == 0 || i16 == 0) {
                setLeftIcon(drawable);
                return;
            }
            return;
        }
        this.f315668e = drawable;
        this.f315669f = i3;
        int min = Math.min(this.N, i16);
        this.f315670h = min;
        drawable.setBounds(0, 0, i3, min);
        this.L.setCompoundDrawables(drawable, null, null, null);
        this.L.setCompoundDrawablePadding(this.Q);
    }
}
