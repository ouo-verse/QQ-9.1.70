package com.tencent.qqmini.sdk.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FormSwitchItem extends RelativeLayout {
    public static final int BG_TYPE_BOTTOM = 3;
    public static final int BG_TYPE_MIDDLE = 2;
    public static final int BG_TYPE_SINGLE = 0;
    public static final int BG_TYPE_TOP = 1;
    private int mBgType;
    private boolean mChecked;
    private int mItemHeight;
    private Drawable mLeftIcon;
    private int mLeftIconHeight;
    private int mLeftIconWidth;
    protected boolean mNeedSetHeight;
    private int mPadding;
    private final Paint mPaint;
    private final Rect mRect;
    private Drawable mRightIcon;
    private int mRightIconHeight;
    private int mRightIconWidth;
    protected Switch mSwitch;
    private CharSequence mText;
    private TextView mTextView;
    private static final int COLOR_DEFAULT_BG_DIVIDER = Color.parseColor("#EBEDF5");
    private static final int PADDING_DEFAULT_BG_DIVIDER = ViewUtils.dpToPx(16.0f);
    private static final int HEIGHT_DEFAULT_BG_DIVIDER = ViewUtils.dpToPx(0.5f);

    public FormSwitchItem(Context context) {
        this(context, null);
    }

    public static Drawable getBgDrawable(Resources resources, int i3, boolean z16) {
        return resources.getDrawable(R.drawable.mini_sdk_skin_setting_strip_bg_unpressed);
    }

    private void initViews() {
        this.mTextView = new TextView(getContext());
        if (!TextUtils.isEmpty(this.mText)) {
            this.mTextView.setText(this.mText);
        }
        this.mTextView.setSingleLine(true);
        this.mTextView.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.mini_sdk_form_prime_textsize));
        this.mTextView.setTextColor(getResources().getColorStateList(R.color.mini_sdk_skin_black));
        this.mTextView.setGravity(19);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
        setLeftIcon(this.mLeftIcon, this.mLeftIconWidth, this.mLeftIconHeight);
        setRightIcon(this.mRightIcon, this.mRightIconWidth, this.mRightIconHeight);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.mPadding;
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        addView(this.mTextView, layoutParams);
        Switch r06 = new Switch(getContext());
        this.mSwitch = r06;
        r06.setChecked(this.mChecked);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = this.mPadding;
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        addView(this.mSwitch, layoutParams2);
        setBackgroundDrawable(getBgDrawable(getResources(), this.mBgType, isDefTheme()));
    }

    private boolean isDefTheme() {
        return true;
    }

    public Switch getSwitch() {
        return this.mSwitch;
    }

    public boolean isChecked() {
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            return r06.isChecked();
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3 = this.mBgType;
        if (i3 == 1 || i3 == 2) {
            if (isDefTheme()) {
                this.mPaint.setColor(COLOR_DEFAULT_BG_DIVIDER);
            } else {
                this.mPaint.setColor(0);
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.mRect.set(PADDING_DEFAULT_BG_DIVIDER, measuredHeight - HEIGHT_DEFAULT_BG_DIVIDER, measuredWidth, measuredHeight);
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
                if (QMLog.isColorLevel()) {
                    QMLog.d("FormSwitchItem", e16.toString());
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
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z16) {
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setChecked(z16);
            sendAccessibilityEvent(1);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(false);
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
            this.mTextView.setCompoundDrawablePadding(this.mPadding);
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Switch r06 = this.mSwitch;
        if (r06 != null) {
            r06.setOnCheckedChangeListener(onCheckedChangeListener);
        }
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
            this.mTextView.setCompoundDrawablePadding(this.mPadding);
        }
    }

    public void setText(CharSequence charSequence) {
        if (this.mTextView != null) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.mText = charSequence;
                this.mTextView.setText(charSequence);
                this.mTextView.setTextColor(getResources().getColorStateList(R.color.mini_sdk_skin_black));
                return;
            }
            this.mTextView.setVisibility(8);
        }
    }

    public FormSwitchItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRect = new Rect();
        Paint paint = new Paint();
        this.mPaint = paint;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mini_sdk_form_item_padding_p0);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mini_sdk_form_single_line_height);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MiniSdkFormItem);
        this.mPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MiniSdkFormItem_customPaddingSdk, dimensionPixelSize);
        this.mItemHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MiniSdkFormItem_customHeightSdk, dimensionPixelSize2);
        this.mText = obtainStyledAttributes.getString(R.styleable.MiniSdkFormItem_switchTextSdk);
        this.mLeftIcon = obtainStyledAttributes.getDrawable(R.styleable.MiniSdkFormItem_leftIconSdk);
        this.mLeftIconWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MiniSdkFormItem_leftIconWidthSdk, 0);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MiniSdkFormItem_leftIconHeightSdk, 0);
        this.mLeftIconHeight = dimensionPixelSize3;
        this.mLeftIconHeight = Math.min(this.mItemHeight, dimensionPixelSize3);
        this.mRightIcon = obtainStyledAttributes.getDrawable(R.styleable.MiniSdkFormItem_rightIconSdk);
        this.mRightIconWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MiniSdkFormItem_rightIconWidthSdk, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MiniSdkFormItem_rightIconHeightSdk, 0);
        this.mRightIconHeight = dimensionPixelSize4;
        this.mRightIconHeight = Math.min(this.mItemHeight, dimensionPixelSize4);
        this.mChecked = obtainStyledAttributes.getBoolean(R.styleable.MiniSdkFormItem_switchCheckedSdk, false);
        this.mBgType = obtainStyledAttributes.getInt(R.styleable.MiniSdkFormItem_bgTypeSdk, 0);
        obtainStyledAttributes.recycle();
        this.mNeedSetHeight = true;
        paint.setAntiAlias(true);
        paint.setColor(COLOR_DEFAULT_BG_DIVIDER);
        initViews();
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
        this.mTextView.setCompoundDrawables(null, null, drawable, null);
        this.mTextView.setCompoundDrawablePadding(this.mPadding);
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
        this.mTextView.setCompoundDrawablePadding(this.mPadding);
    }
}
