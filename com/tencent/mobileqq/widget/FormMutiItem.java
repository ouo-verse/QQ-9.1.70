package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FormMutiItem extends FormSimpleItem {

    /* renamed from: b0, reason: collision with root package name */
    protected LinearLayout f315657b0;

    /* renamed from: c0, reason: collision with root package name */
    protected TextView f315658c0;

    /* renamed from: d0, reason: collision with root package name */
    protected TextView f315659d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f315660e0;

    /* renamed from: f0, reason: collision with root package name */
    protected int f315661f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f315662g0;

    /* renamed from: h0, reason: collision with root package name */
    protected int f315663h0;

    /* renamed from: i0, reason: collision with root package name */
    protected CharSequence f315664i0;

    /* renamed from: j0, reason: collision with root package name */
    protected CharSequence f315665j0;

    public FormMutiItem(Context context) {
        super(context);
        this.f315660e0 = 0;
        this.f315661f0 = 2;
        j();
    }

    private void j() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f315657b0 = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.f315658c0 = textView;
        textView.setSingleLine(true);
        this.f315658c0.setTextColor(o.a(getResources(), this.f315660e0));
        this.f315658c0.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.f158563j1));
        this.f315658c0.setGravity(19);
        this.f315658c0.setEllipsize(TextUtils.TruncateAt.END);
        this.f315658c0.setDuplicateParentStateEnabled(true);
        if (!TextUtils.isEmpty(this.f315664i0)) {
            this.f315658c0.setText(this.f315664i0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView2 = new TextView(getContext());
        this.f315659d0 = textView2;
        if (this.J) {
            textView2.setSingleLine(true);
            this.f315659d0.setEllipsize(TextUtils.TruncateAt.END);
            this.f315659d0.setDuplicateParentStateEnabled(true);
        } else {
            textView2.setSingleLine(false);
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.f158557iv);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158570j9);
        this.f315659d0.setTextColor(o.a(getResources(), this.f315661f0));
        this.f315659d0.setTextSize(0, dimensionPixelSize);
        this.f315659d0.setGravity(19);
        if (!TextUtils.isEmpty(this.f315665j0)) {
            this.f315659d0.setText(this.f315665j0);
        }
        this.f315657b0.addView(this.f315658c0, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = getResources().getDimensionPixelOffset(R.dimen.f158548il);
        if (!this.J) {
            layoutParams2.bottomMargin = getResources().getDimensionPixelOffset(R.dimen.f158554ir);
        }
        this.f315657b0.addView(this.f315659d0, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, R.id.cjm);
        layoutParams3.addRule(0, R.id.cjn);
        layoutParams3.addRule(15);
        addView(this.f315657b0, layoutParams3);
        setCustomHeight(getResources().getDimensionPixelSize(R.dimen.agu));
    }

    public void setFirstLineRightDrawalbe(Drawable drawable) {
        this.f315658c0.setCompoundDrawables(null, null, drawable, null);
    }

    public void setFirstLineText(CharSequence charSequence) {
        this.f315664i0 = charSequence;
        this.f315658c0.setText(charSequence);
    }

    public void setFirstLineTextColor(int i3) {
        this.f315660e0 = i3;
        this.f315658c0.setTextColor(i3);
    }

    public void setFirstLineTextSize(int i3) {
        this.f315662g0 = i3;
        this.f315658c0.setTextSize(i3);
    }

    public void setSecondLineText(CharSequence charSequence) {
        this.f315665j0 = charSequence;
        this.f315659d0.setText(charSequence);
    }

    public void setSecondLineTextColor(int i3) {
        this.f315659d0.setTextColor(this.f315661f0);
    }

    public void setSecondLineTextSize(int i3) {
        this.f315659d0.setTextSize(this.f315663h0);
    }

    public void setSecondLineTextViewPaddingRight(int i3) {
        TextView textView = this.f315659d0;
        textView.setPadding(textView.getPaddingLeft(), this.f315659d0.getPaddingTop(), i3, this.f315659d0.getPaddingBottom());
    }

    public void setSecondLineVisible(boolean z16) {
        boolean z17;
        int dimensionPixelSize;
        int i3 = 0;
        if (this.f315659d0.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 ^ z16) {
            TextView textView = this.f315659d0;
            if (!z16) {
                i3 = 8;
            }
            textView.setVisibility(i3);
            if (z16) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.agu);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.aeq);
            }
            setCustomHeight(dimensionPixelSize);
        }
    }

    public void setFirstLineText(int i3) {
        String string = getResources().getString(i3);
        this.f315664i0 = string;
        this.f315658c0.setText(string);
    }

    public void setSecondLineText(int i3) {
        String string = getResources().getString(i3);
        this.f315665j0 = string;
        this.f315659d0.setText(string);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r0 != null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FormMutiItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315660e0 = 0;
        this.f315661f0 = 2;
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FormItem);
            this.f315664i0 = typedArray.getString(R.styleable.FormItem_firstLineText);
            this.f315665j0 = typedArray.getString(R.styleable.FormItem_secondLineText);
        } catch (Throwable unused) {
        }
        typedArray.recycle();
        j();
    }
}
