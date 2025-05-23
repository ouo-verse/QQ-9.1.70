package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FormSwitchItem extends RelativeLayout implements FormItemConstants {
    protected int mBgType;
    private boolean mChecked;
    private boolean mCloseVipTheme;
    private ColorStateList mColorStateList;
    private int mIconPadding;
    private int mItemHeight;
    private Drawable mLeftIcon;
    private int mLeftIconHeight;
    private int mLeftIconWidth;
    private Drawable mListBackground;
    protected boolean mNeedSetHeight;
    protected int mPadding;
    private final Paint mPaint;
    private ProgressBar mProgressBar;
    private final Rect mRect;
    private Drawable mRightIcon;
    private int mRightIconHeight;
    private int mRightIconWidth;
    protected Switch mSwitch;
    private CharSequence mText;
    private TextView mTextView;
    protected boolean mUseCardUIStyle;

    public FormSwitchItem(Context context) {
        this(context, null);
    }

    private void handleSwitchVipTheme() {
        if (this.mCloseVipTheme) {
            this.mSwitch.setTrackResource(R.drawable.loj);
        } else {
            this.mSwitch.setTrackResource(R.drawable.b58);
        }
    }

    private void initSwitch() {
        this.mSwitch.setChecked(this.mChecked);
        this.mSwitch.setId(R.id.cjo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = this.mPadding;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mSwitch, layoutParams);
        handleSwitchVipTheme();
    }

    private void initViews() {
        TextView textView = new TextView(getContext());
        this.mTextView = textView;
        textView.setId(R.id.cjp);
        if (!TextUtils.isEmpty(this.mText)) {
            this.mTextView.setText(this.mText);
        }
        this.mTextView.setSingleLine(true);
        this.mTextView.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158563j1));
        this.mTextView.setTextColor(getColorByTypeInternal());
        this.mTextView.setGravity(19);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        setLeftIcon(this.mLeftIcon, this.mLeftIconWidth, this.mLeftIconHeight);
        setRightIcon(this.mRightIcon, this.mRightIconWidth, this.mRightIconHeight);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mPadding;
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.addRule(0, R.id.cjo);
        addView(this.mTextView, layoutParams);
        this.mSwitch = new Switch(getContext());
        initSwitch();
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(this.mTextView, false);
            AccessibilityUtil.n(this.mSwitch, false);
        }
        setBackgroundDrawable(getSelectorByTypeInternal(getResources(), this.mBgType));
    }

    private boolean isDefTheme() {
        return az.d();
    }

    protected ColorStateList getColorByTypeInternal() {
        ColorStateList colorStateList = this.mColorStateList;
        if (colorStateList != null) {
            return colorStateList;
        }
        if (this.mCloseVipTheme) {
            return getResources().getColorStateList(R.color.skin_black_only_night);
        }
        return getResources().getColorStateList(R.color.qui_common_text_primary);
    }

    protected Drawable getSelectorByTypeInternal(Resources resources, int i3) {
        Drawable drawable = this.mListBackground;
        if (drawable == null) {
            return o.h(resources, i3, false, this.mUseCardUIStyle);
        }
        return o.i(resources, i3, false, this.mUseCardUIStyle, drawable);
    }

    public Switch getSwitch() {
        return this.mSwitch;
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public boolean isChecked() {
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            return r06.isChecked();
        }
        return false;
    }

    public boolean isProgressBarShowing() {
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar == null || progressBar.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (o.l() && this.mUseCardUIStyle) {
            return;
        }
        int i3 = this.mBgType;
        if (i3 == 1 || i3 == 2) {
            if (isDefTheme()) {
                this.mPaint.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
            } else {
                this.mPaint.setColor(0);
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.mRect.set(FormItemConstants.PADDING_DEFAULT_BG_DIVIDER, measuredHeight - FormItemConstants.HEIGHT_DEFAULT_BG_DIVIDER, measuredWidth, measuredHeight);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        Switch r06 = this.mSwitch;
        if (r06 != null && r06.getVisibility() != 8) {
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(this.mSwitch.isChecked());
            accessibilityNodeInfo.setContentDescription(this.mText);
            accessibilityNodeInfo.setClassName(Switch.class.getName());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.mNeedSetHeight) {
            try {
                super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
                setMeasuredDimension(getMeasuredWidth(), this.mItemHeight);
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("FormSwitchItem", 2, e16.toString());
                }
                setMinimumHeight(this.mItemHeight);
                super.onMeasure(i3, i16);
                return;
            }
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Switch r06;
        if (AppSetting.f99565y && (r06 = this.mSwitch) != null && r06.getVisibility() == 0) {
            if (motionEvent.getAction() == 0) {
                super.onTouchEvent(motionEvent);
            } else if (motionEvent.getAction() == 1) {
                this.mSwitch.setChecked(!r3.isChecked());
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBgType(int i3) {
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
            throw new RuntimeException("Parameter bgType is illegal!");
        }
        this.mBgType = i3;
        setBackgroundDrawable(getSelectorByTypeInternal(getResources(), this.mBgType));
    }

    public void setChecked(boolean z16) {
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setChecked(z16);
            sendAccessibilityEvent(1);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z16) {
        super.setClickable(z16);
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setClickable(z16);
        }
    }

    public void setCloseVipTheme(boolean z16) {
        this.mCloseVipTheme = z16;
        handleSwitchVipTheme();
    }

    public void setCustomHeight(int i3) {
        if (i3 > 0) {
            this.mItemHeight = i3;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setEnabled(z16);
        }
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setEnabled(z16);
        }
    }

    public void setLeftIcon(Drawable drawable) {
        TextView textView = this.mTextView;
        if (textView != null) {
            this.mLeftIcon = drawable;
            if (drawable == null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            if (drawable.getIntrinsicHeight() > this.mItemHeight) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mItemHeight);
                this.mTextView.setCompoundDrawables(drawable, null, null, null);
            } else {
                this.mTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.mTextView.setCompoundDrawablePadding(this.mIconPadding);
        }
    }

    public void setListBackground(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.mListBackground = drawable;
        setBackgroundDrawable(getSelectorByTypeInternal(getResources(), this.mBgType));
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setPadding(int i3) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        this.mPadding = i3;
        TextView textView = this.mTextView;
        if (textView != null && (layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams()) != null) {
            layoutParams2.leftMargin = i3;
        }
        Switch r06 = this.mSwitch;
        if (r06 != null && (layoutParams = (RelativeLayout.LayoutParams) r06.getLayoutParams()) != null) {
            layoutParams.rightMargin = i3;
        }
        requestLayout();
    }

    public void setRightIcon(Drawable drawable) {
        TextView textView = this.mTextView;
        if (textView != null) {
            this.mRightIcon = drawable;
            if (drawable == null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            if (drawable.getIntrinsicHeight() > this.mItemHeight) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mItemHeight);
                this.mTextView.setCompoundDrawables(null, null, drawable, null);
            } else {
                this.mTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            }
            this.mTextView.setCompoundDrawablePadding(this.mIconPadding);
        }
    }

    public void setText(CharSequence charSequence) {
        if (this.mTextView != null) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.mText = charSequence;
                this.mTextView.setText(charSequence);
                this.mTextView.setTextColor(getColorByTypeInternal());
                return;
            }
            this.mTextView.setVisibility(8);
        }
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.mColorStateList = colorStateList;
        this.mTextView.setTextColor(getColorByTypeInternal());
    }

    public void setUseCardUIStyle(boolean z16) {
        this.mUseCardUIStyle = z16;
    }

    public void showProgressBar(boolean z16) {
        if (z16) {
            ProgressBar progressBar = this.mProgressBar;
            if (progressBar != null) {
                if (progressBar.getVisibility() != 0) {
                    this.mProgressBar.setVisibility(0);
                    this.mSwitch.setVisibility(8);
                    return;
                }
                return;
            }
            this.mProgressBar = new ProgressBar(getContext(), null, 0);
            int a16 = az.a(getContext(), 24.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a16, a16);
            layoutParams.rightMargin = this.mPadding;
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.mProgressBar, layoutParams);
            this.mSwitch.setVisibility(8);
            this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.f160544jr));
            this.mProgressBar.setIndeterminate(true);
            return;
        }
        Switch r56 = this.mSwitch;
        if (r56 != null && r56.getVisibility() != 0) {
            ProgressBar progressBar2 = this.mProgressBar;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            this.mSwitch.setVisibility(0);
        }
    }

    public FormSwitchItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRect = new Rect();
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mCloseVipTheme = false;
        this.mColorStateList = null;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.aes);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f158564j2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u51.a.U);
        this.mPadding = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438282c0, dimensionPixelSize);
        this.mItemHeight = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438279b0, dimensionPixelSize2);
        this.mIconPadding = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438285d0, this.mPadding);
        this.mText = obtainStyledAttributes.getString(u51.a.f438312m0);
        this.mLeftIcon = obtainStyledAttributes.getDrawable(u51.a.f438288e0);
        this.mLeftIconWidth = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438294g0, 0);
        this.mLeftIconHeight = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438291f0, 0);
        this.mUseCardUIStyle = obtainStyledAttributes.getBoolean(u51.a.Z, true);
        this.mLeftIconHeight = Math.min(this.mItemHeight, this.mLeftIconHeight);
        this.mRightIcon = obtainStyledAttributes.getDrawable(u51.a.f438300i0);
        this.mRightIconWidth = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438306k0, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438303j0, 0);
        this.mRightIconHeight = dimensionPixelSize3;
        this.mRightIconHeight = Math.min(this.mItemHeight, dimensionPixelSize3);
        this.mChecked = obtainStyledAttributes.getBoolean(u51.a.f438309l0, false);
        this.mBgType = obtainStyledAttributes.getInt(u51.a.Y, 0);
        this.mListBackground = obtainStyledAttributes.getDrawable(u51.a.f438297h0);
        this.mCloseVipTheme = obtainStyledAttributes.getBoolean(u51.a.f438276a0, false);
        obtainStyledAttributes.recycle();
        this.mNeedSetHeight = true;
        paint.setAntiAlias(true);
        paint.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
        initViews();
    }

    public void setLeftIcon(int i3) {
        setLeftIcon(getContext().getResources().getDrawable(i3));
    }

    public void setRightIcon(Drawable drawable, int i3, int i16) {
        if (drawable == null || this.mTextView == null || i3 < 0 || i16 < 0) {
            return;
        }
        if (i3 <= 0 || i16 <= 0) {
            if (i3 == 0 || i16 == 0) {
                setRightIcon(drawable);
                return;
            }
            return;
        }
        this.mRightIcon = drawable;
        this.mRightIconWidth = i3;
        int min = Math.min(this.mItemHeight, i16);
        this.mRightIconHeight = min;
        drawable.setBounds(0, 0, this.mRightIconWidth, min);
        this.mTextView.setCompoundDrawables(null, null, drawable, null);
        this.mTextView.setCompoundDrawablePadding(this.mIconPadding);
    }

    public void setLeftIcon(Drawable drawable, int i3, int i16) {
        if (drawable == null || this.mTextView == null || i3 < 0 || i16 < 0) {
            return;
        }
        if (i3 <= 0 || i16 <= 0) {
            if (i3 == 0 || i16 == 0) {
                setRightIcon(drawable);
                return;
            }
            return;
        }
        this.mLeftIcon = drawable;
        this.mLeftIconWidth = i3;
        int min = Math.min(this.mItemHeight, i16);
        this.mLeftIconHeight = min;
        drawable.setBounds(0, 0, this.mLeftIconWidth, min);
        this.mTextView.setCompoundDrawables(drawable, null, null, null);
        this.mTextView.setCompoundDrawablePadding(this.mIconPadding);
    }
}
