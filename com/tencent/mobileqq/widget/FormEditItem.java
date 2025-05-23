package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FormEditItem extends RelativeLayout implements FormItemConstants {
    private TextView C;
    private Drawable D;
    private int E;
    private int F;
    private TextView G;
    private EditText H;
    private CharSequence I;
    protected boolean J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private final boolean R;
    private final Rect S;
    private final Paint T;
    private ViewTreeObserver.OnGlobalLayoutListener U;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f315647d;

    /* renamed from: e, reason: collision with root package name */
    private int f315648e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f315649f;

    /* renamed from: h, reason: collision with root package name */
    private int f315650h;

    /* renamed from: i, reason: collision with root package name */
    private int f315651i;

    /* renamed from: m, reason: collision with root package name */
    private int f315652m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            FormEditItem.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            FormEditItem formEditItem = FormEditItem.this;
            formEditItem.Q = formEditItem.getMeasuredWidth();
            FormEditItem.this.f();
        }
    }

    public FormEditItem(Context context) {
        this(context, null);
    }

    private void c() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = (this.Q - this.N) - (this.f315652m * 2);
        Drawable drawable = this.D;
        int i26 = 0;
        if (drawable != null) {
            int i27 = this.E;
            if (i27 == 0) {
                i27 = drawable.getIntrinsicWidth();
            }
            i3 = i27 + this.f315652m;
        } else {
            i3 = 0;
        }
        if (!TextUtils.isEmpty(this.f315647d)) {
            i16 = (int) this.C.getPaint().measureText(this.f315647d.toString());
        } else {
            i16 = 0;
        }
        int i28 = i3 + i16;
        if (i28 > 0) {
            i19 -= this.f315652m;
        }
        if (!TextUtils.isEmpty(this.f315649f)) {
            i17 = (int) this.G.getPaint().measureText(this.f315649f.toString());
        } else {
            i17 = 0;
        }
        int i29 = i19 / 2;
        if (i28 >= i29 && i17 >= i29) {
            i17 = i29;
            i28 = i17;
        } else if (i28 > i29 && i17 < i29) {
            int i36 = i19 - i17;
            if (i28 < i36) {
                i26 = i36 - i28;
            } else {
                i28 = i36;
            }
        } else {
            if (i28 < i29 && i17 > i29) {
                i18 = i19 - i28;
                if (i17 >= i18) {
                    i17 = i18;
                }
            } else {
                i18 = i19 - i28;
            }
            i26 = i18 - i17;
        }
        this.L = i28;
        this.M = i17;
        this.P = this.N + i26;
    }

    @TargetApi(16)
    private void d() {
        setFocusable(true);
        setClickable(true);
        TextView textView = new TextView(getContext());
        this.G = textView;
        textView.setId(R.id.cjn);
        this.G.setTextColor(o.a(getResources(), this.f315650h));
        this.G.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158563j1));
        this.G.setGravity(19);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.rightMargin = this.f315652m;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        if (this.J) {
            this.G.setSingleLine(true);
            this.G.setEllipsize(TextUtils.TruncateAt.END);
            this.G.setDuplicateParentStateEnabled(true);
        } else {
            int i3 = this.f315652m;
            layoutParams.topMargin = i3;
            layoutParams.bottomMargin = i3;
        }
        addView(this.G, layoutParams);
        EditText editText = new EditText(getContext());
        this.H = editText;
        editText.setId(R.id.cjl);
        this.H.setMinWidth(this.N);
        this.H.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158563j1));
        this.H.setTextColor(-16777216);
        this.H.setGravity(21);
        this.H.setBackgroundDrawable(null);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = this.f315652m;
        layoutParams2.addRule(0, R.id.cjn);
        layoutParams2.addRule(15);
        addView(this.H, layoutParams2);
        if (!TextUtils.isEmpty(this.I)) {
            this.H.setHintTextColor(-7829368);
            this.H.setHint(this.I);
        }
        TextView textView2 = new TextView(getContext());
        this.C = textView2;
        textView2.setId(R.id.cjm);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f158563j1);
        this.C.setTextColor(getResources().getColorStateList(R.color.skin_black));
        this.C.setTextSize(0, dimensionPixelSize);
        this.C.setGravity(19);
        setLeftIcon(this.D, this.E, this.F);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        int i16 = this.f315652m;
        layoutParams3.leftMargin = i16;
        if (this.J) {
            this.C.setSingleLine(true);
            this.C.setEllipsize(TextUtils.TruncateAt.END);
            this.C.setDuplicateParentStateEnabled(true);
        } else {
            layoutParams3.topMargin = i16;
            layoutParams3.bottomMargin = i16;
            setMinimumHeight(this.f315651i);
        }
        layoutParams3.addRule(9);
        layoutParams3.addRule(0, R.id.cjl);
        layoutParams3.addRule(15);
        this.C.setMaxWidth(this.L);
        addView(this.C, layoutParams3);
        getViewTreeObserver().addOnGlobalLayoutListener(this.U);
        if (this.f315648e >= 0) {
            setBackgroundDrawable(o.h(getResources(), this.f315648e, false, this.J));
        }
    }

    public static void e(TextView textView, int i3, CharSequence charSequence, boolean z16) {
        int i16;
        if (textView != null) {
            textView.setWidth(i3);
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            if (isEmpty) {
                charSequence = "";
            }
            if (isEmpty && !z16) {
                i16 = 8;
            } else {
                i16 = 0;
            }
            textView.setText(charSequence);
            textView.setContentDescription(charSequence);
            textView.setVisibility(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        boolean z16;
        if (this.Q > 0) {
            c();
            TextView textView = this.C;
            int i3 = this.L;
            CharSequence charSequence = this.f315647d;
            if (this.D != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            e(textView, i3, charSequence, z16);
            e(this.G, this.M, this.f315649f, false);
            this.H.setMaxWidth(this.P);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if ((!o.l() || !this.K) && this.R) {
            int i3 = this.f315648e;
            if (i3 == 1 || i3 == 2) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                this.S.set(FormItemConstants.PADDING_DEFAULT_BG_DIVIDER, measuredHeight - FormItemConstants.HEIGHT_DEFAULT_BG_DIVIDER, measuredWidth, measuredHeight);
                canvas.drawRect(this.S, this.T);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.J) {
            try {
                super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f315651i, 1073741824));
                setMeasuredDimension(getMeasuredWidth(), this.f315651i);
                return;
            } catch (Exception unused) {
                setMinimumHeight(this.f315651i);
                super.onMeasure(i3, i16);
                return;
            }
        }
        super.onMeasure(i3, i16);
    }

    public void setBgType(int i3) {
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
            throw new RuntimeException("Parameter bgType is illegal!");
        }
        this.f315648e = i3;
        setBackgroundDrawable(o.h(getResources(), this.f315648e, false, this.K));
    }

    public void setCustomHeight(int i3) {
        if (i3 > 0 && this.J) {
            this.f315651i = i3;
            requestLayout();
        }
    }

    public void setLeftIcon(Drawable drawable) {
        TextView textView = this.C;
        if (textView != null) {
            this.D = drawable;
            if (drawable == null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            if (drawable.getIntrinsicHeight() > this.f315651i) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f315651i);
                this.C.setCompoundDrawables(drawable, null, null, null);
            } else {
                this.C.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.C.setCompoundDrawablePadding(this.f315652m);
        }
    }

    public void setLeftText(CharSequence charSequence) {
        if (this.C != null) {
            this.f315647d = charSequence;
            f();
        }
    }

    public void setRightText(CharSequence charSequence) {
        this.f315649f = charSequence;
        f();
    }

    public void setUseCardUIStyle(boolean z16) {
        this.K = z16;
    }

    public FormEditItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        this.L = -2;
        this.M = -2;
        this.Q = 0;
        this.S = new Rect();
        this.T = new Paint();
        this.U = new a();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.aes);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158564j2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410081i2);
        this.f315652m = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410125m2, dimensionPixelSize);
        this.f315651i = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410114l2, dimensionPixelSize2);
        this.f315647d = obtainStyledAttributes.getString(jj2.b.f410195s2);
        this.D = obtainStyledAttributes.getDrawable(jj2.b.f410159p2);
        this.E = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410183r2, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410171q2, 0);
        this.F = dimensionPixelSize3;
        this.F = Math.min(this.f315651i, dimensionPixelSize3);
        this.f315649f = obtainStyledAttributes.getString(jj2.b.A2);
        this.f315650h = obtainStyledAttributes.getInt(jj2.b.B2, 0);
        this.f315648e = obtainStyledAttributes.getInt(jj2.b.f410092j2, -1);
        this.J = obtainStyledAttributes.getBoolean(jj2.b.f410238w2, true);
        this.K = obtainStyledAttributes.getBoolean(jj2.b.f410103k2, true);
        this.I = obtainStyledAttributes.getString(jj2.b.f410136n2);
        try {
            i3 = context.getResources().getDimensionPixelSize(R.dimen.f158558iw);
        } catch (Resources.NotFoundException e16) {
            e16.printStackTrace();
            i3 = 300;
        }
        this.N = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410147o2, i3);
        obtainStyledAttributes.recycle();
        az.b();
        this.R = az.d();
        this.T.setAntiAlias(true);
        this.T.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
        d();
    }

    public void setLeftIcon(Drawable drawable, int i3, int i16) {
        if (drawable == null || this.C == null || i3 < 0 || i16 < 0) {
            return;
        }
        if (i3 <= 0 || i16 <= 0) {
            if (i3 == 0 || i16 == 0) {
                setLeftIcon(drawable);
                return;
            }
            return;
        }
        this.D = drawable;
        this.E = i3;
        int min = Math.min(this.f315651i, i16);
        this.F = min;
        drawable.setBounds(0, 0, this.E, min);
        this.C.setCompoundDrawables(drawable, null, null, null);
        this.C.setCompoundDrawablePadding(this.f315652m);
    }
}
