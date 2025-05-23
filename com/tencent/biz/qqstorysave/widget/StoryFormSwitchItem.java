package com.tencent.biz.qqstorysave.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.FormItemConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StoryFormSwitchItem extends RelativeLayout implements FormItemConstants {
    private Drawable C;
    private int D;
    private int E;
    private Drawable F;
    private int G;
    private int H;
    private Switch I;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f94541d;

    /* renamed from: e, reason: collision with root package name */
    private int f94542e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f94543f;

    /* renamed from: h, reason: collision with root package name */
    private int f94544h;

    /* renamed from: i, reason: collision with root package name */
    private int f94545i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f94546m;

    public StoryFormSwitchItem(Context context) {
        this(context, null);
    }

    public static Drawable a(Resources resources, int i3) {
        return new ColorDrawable(-1);
    }

    private void b() {
        TextView textView = new TextView(getContext());
        this.f94546m = textView;
        textView.setId(R.id.cjp);
        if (!TextUtils.isEmpty(this.f94541d)) {
            this.f94546m.setText(this.f94541d);
        }
        this.f94546m.setSingleLine(true);
        this.f94546m.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158563j1));
        this.f94546m.setTextColor(getResources().getColorStateList(R.color.skin_black));
        this.f94546m.setGravity(19);
        this.f94546m.setEllipsize(TextUtils.TruncateAt.END);
        setLeftIcon(this.C, this.D, this.E);
        setRightIcon(this.F, this.G, this.H);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f94545i;
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        addView(this.f94546m, layoutParams);
        Switch r06 = new Switch(getContext());
        this.I = r06;
        r06.setChecked(this.f94543f);
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.f94546m, false);
            AccessibilityUtil.n(this.I, false);
            if (TextUtils.isEmpty(getContentDescription())) {
                setContentDescription(this.f94546m.getText());
            }
        }
        this.I.setId(R.id.cjo);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = this.f94545i;
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        addView(this.I, layoutParams2);
        setBackgroundDrawable(a(getResources(), this.f94542e));
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        Switch r06 = this.I;
        if (r06 != null && r06.getVisibility() != 8) {
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.I.isChecked());
            accessibilityNodeInfo.setClassName(Switch.class.getName());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        try {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f94544h, 1073741824));
            setMeasuredDimension(getMeasuredWidth(), this.f94544h);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FormSwitchItem", 2, e16.toString());
            }
            setMinimumHeight(this.f94544h);
            super.onMeasure(i3, i16);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Switch r06;
        if (AppSetting.f99565y && (r06 = this.I) != null && r06.getVisibility() == 0) {
            if (motionEvent.getAction() == 0) {
                super.onTouchEvent(motionEvent);
            } else if (motionEvent.getAction() == 1) {
                this.I.setChecked(!r3.isChecked());
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBgType(int i3) {
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
            throw new RuntimeException("Parameter bgType is illegal!");
        }
        this.f94542e = i3;
        setBackgroundDrawable(a(getResources(), this.f94542e));
    }

    public void setChecked(boolean z16) {
        Switch r06 = this.I;
        if (r06 != null) {
            r06.setChecked(z16);
            sendAccessibilityEvent(1);
        }
    }

    public void setCustomHeight(int i3) {
        if (i3 > 0) {
            this.f94544h = i3;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(false);
        TextView textView = this.f94546m;
        if (textView != null) {
            textView.setEnabled(z16);
        }
        Switch r06 = this.I;
        if (r06 != null) {
            r06.setEnabled(z16);
        }
    }

    public void setLeftIcon(Drawable drawable) {
        TextView textView = this.f94546m;
        if (textView != null) {
            this.C = drawable;
            if (drawable == null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            if (drawable.getIntrinsicHeight() > this.f94544h) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f94544h);
                this.f94546m.setCompoundDrawables(drawable, null, null, null);
            } else {
                this.f94546m.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f94546m.setCompoundDrawablePadding(this.f94545i);
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch r06 = this.I;
        if (r06 != null) {
            r06.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setRightIcon(Drawable drawable) {
        TextView textView = this.f94546m;
        if (textView != null) {
            this.F = drawable;
            if (drawable == null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            if (drawable.getIntrinsicHeight() > this.f94544h) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f94544h);
                this.f94546m.setCompoundDrawables(null, null, drawable, null);
            } else {
                this.f94546m.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            }
            this.f94546m.setCompoundDrawablePadding(this.f94545i);
        }
    }

    public void setText(CharSequence charSequence) {
        if (this.f94546m != null) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.f94541d = charSequence;
                this.f94546m.setText(charSequence);
                this.f94546m.setTextColor(getResources().getColorStateList(R.color.skin_black));
                return;
            }
            this.f94546m.setVisibility(8);
        }
    }

    public StoryFormSwitchItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.aes);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158564j2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FormItem);
        this.f94545i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FormItem_customPadding, dimensionPixelSize);
        this.f94544h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FormItem_customHeight, dimensionPixelSize2);
        this.f94541d = obtainStyledAttributes.getString(R.styleable.FormItem_switchText);
        this.C = obtainStyledAttributes.getDrawable(R.styleable.FormItem_leftIcon);
        this.D = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FormItem_leftIconWidth, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FormItem_leftIconHeight, 0);
        this.E = dimensionPixelSize3;
        this.E = Math.min(this.f94544h, dimensionPixelSize3);
        this.F = obtainStyledAttributes.getDrawable(R.styleable.FormItem_rightIcon);
        this.G = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FormItem_rightIconWidth, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FormItem_rightIconHeight, 0);
        this.H = dimensionPixelSize4;
        this.H = Math.min(this.f94544h, dimensionPixelSize4);
        this.f94543f = obtainStyledAttributes.getBoolean(R.styleable.FormItem_switchChecked, false);
        this.f94542e = obtainStyledAttributes.getInt(R.styleable.FormItem_bgType, 0);
        obtainStyledAttributes.recycle();
        b();
    }

    public void setLeftIcon(Drawable drawable, int i3, int i16) {
        if (drawable == null || this.f94546m == null || i3 < 0 || i16 < 0) {
            return;
        }
        if (i3 <= 0 || i16 <= 0) {
            if (i3 == 0 || i16 == 0) {
                setRightIcon(drawable);
                return;
            }
            return;
        }
        this.C = drawable;
        this.D = i3;
        int min = Math.min(this.f94544h, i16);
        this.E = min;
        drawable.setBounds(0, 0, this.D, min);
        this.f94546m.setCompoundDrawables(null, null, drawable, null);
        this.f94546m.setCompoundDrawablePadding(this.f94545i);
    }

    public void setRightIcon(Drawable drawable, int i3, int i16) {
        if (drawable == null || this.f94546m == null || i3 < 0 || i16 < 0) {
            return;
        }
        if (i3 <= 0 || i16 <= 0) {
            if (i3 == 0 || i16 == 0) {
                setRightIcon(drawable);
                return;
            }
            return;
        }
        this.F = drawable;
        this.G = i3;
        int min = Math.min(this.f94544h, i16);
        this.H = min;
        drawable.setBounds(0, 0, this.G, min);
        this.f94546m.setCompoundDrawables(null, null, drawable, null);
        this.f94546m.setCompoundDrawablePadding(this.f94545i);
    }
}
