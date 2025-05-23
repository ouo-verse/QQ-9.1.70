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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.QMultiImageTextView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QFormSimpleItem extends RelativeLayout implements FormItemConstants {
    protected static boolean mNeedFocusBg;
    protected Drawable mArrow;
    private int mArrowHeight;
    private int mArrowMaxWidth;
    private int mArrowWidth;
    private int mBgType;
    private boolean mCloseVipTheme;
    private final Drawable mDefaultArrowDrawable;
    private int mItemHeight;
    private Drawable mLeftIcon;
    private int mLeftIconHeight;
    private int mLeftIconWidth;
    private CharSequence mLeftText;
    private int mLeftTextColor;
    protected TextView mLeftTextView;
    protected int mLeftTextViewMaxWidth;
    private Drawable mListBackground;
    protected boolean mNeedSetHeight;
    private int mPadding;
    private final Paint mPaint;
    private final Rect mRect;
    protected Drawable mRightIcon;
    protected int mRightIconHeight;
    private int mRightIconMaxWidth;
    protected int mRightIconWidth;
    protected CharSequence mRightText;
    protected int mRightTextColor;
    private int mRightTextPadding;
    protected QMultiImageTextView mRightTextView;
    protected int mRightTextViewMaxWidth;
    protected boolean mShowArrow;
    private boolean mUseCardUI;

    public QFormSimpleItem(Context context) {
        this(context, null);
    }

    private boolean isDefTheme() {
        return QQTheme.isDefaultOrDIYTheme();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calucateTextMaxWidth() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26 = getResources().getDisplayMetrics().widthPixels;
        int i27 = this.mPadding;
        if (o.l()) {
            i3 = 4;
        } else {
            i3 = 2;
        }
        int i28 = i26 - (i27 * i3);
        if (this.mRightText == null) {
            Drawable drawable = this.mRightIcon;
            if (drawable != null && this.mShowArrow) {
                i19 = this.mRightIconMaxWidth + this.mPadding + this.mArrowMaxWidth;
            } else if (drawable != null && !this.mShowArrow) {
                i19 = this.mRightIconMaxWidth;
            } else if (drawable == null && this.mShowArrow) {
                i19 = this.mArrowMaxWidth;
            } else {
                i19 = 0;
            }
            this.mLeftTextViewMaxWidth = i28 - i19;
            this.mRightTextViewMaxWidth = 0;
            return;
        }
        int i29 = i28 - this.mPadding;
        Drawable drawable2 = this.mLeftIcon;
        if (drawable2 != null) {
            int i36 = this.mLeftIconWidth;
            if (i36 == 0) {
                i36 = drawable2.getIntrinsicWidth();
            }
            i16 = i36 + this.mPadding;
        } else {
            i16 = 0;
        }
        TextPaint paint = this.mLeftTextView.getPaint();
        CharSequence charSequence = this.mLeftText;
        if (charSequence != null) {
            i17 = i16 + ((int) paint.measureText(charSequence.toString()));
        } else {
            i17 = 0;
        }
        Drawable drawable3 = this.mRightIcon;
        if (drawable3 != null) {
            int i37 = this.mRightIconWidth;
            if (i37 == 0) {
                i37 = drawable3.getIntrinsicWidth();
            }
            i18 = i37 + 0 + this.mPadding;
        } else {
            i18 = 0;
        }
        if (this.mShowArrow) {
            i18 = i18 + this.mArrow.getIntrinsicWidth() + this.mPadding;
        }
        StaticLayout staticLayout = new StaticLayout(this.mRightText, this.mRightTextView.getPaint(), 100000, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int lineCount = staticLayout.getLineCount();
        int i38 = 0;
        for (int i39 = 0; i39 < lineCount; i39++) {
            i38 = (int) Math.max(i38, staticLayout.getLineWidth(i39));
        }
        int paddingLeft = i18 + i38 + this.mRightTextView.getPaddingLeft();
        int i46 = i29 / 2;
        if (i17 >= i46 && paddingLeft >= i46) {
            i17 = i46;
            paddingLeft = i17;
        } else if (i17 > i46 && paddingLeft < i46) {
            i17 = i29 - paddingLeft;
        } else if (i17 < i46 && paddingLeft > i46) {
            paddingLeft = i29 - i17;
        }
        this.mLeftTextViewMaxWidth = i17;
        this.mRightTextViewMaxWidth = paddingLeft;
    }

    protected ColorStateList getColorByTypeInternal(Resources resources, int i3) {
        if (this.mCloseVipTheme) {
            return o.d(resources, i3);
        }
        return o.a(resources, i3);
    }

    public TextView getLeftTextView() {
        return this.mLeftTextView;
    }

    public Drawable getRightIcon() {
        return this.mRightIcon;
    }

    public QMultiImageTextView getRightTextView() {
        return this.mRightTextView;
    }

    protected Drawable getSelectorByTypeInternal(Resources resources, int i3) {
        Drawable drawable = this.mListBackground;
        if (drawable == null) {
            return o.h(resources, i3, mNeedFocusBg, this.mUseCardUI);
        }
        return o.i(resources, i3, mNeedFocusBg, this.mUseCardUI, drawable);
    }

    protected void initViews() {
        setFocusable(true);
        setClickable(true);
        this.mLeftTextView = new TextView(getContext());
        if (!TextUtils.isEmpty(this.mLeftText)) {
            this.mLeftTextView.setText(this.mLeftText);
            this.mLeftTextView.setContentDescription(this.mLeftText);
        }
        this.mLeftTextView.setId(R.id.cjm);
        if (this.mNeedSetHeight) {
            this.mLeftTextView.setSingleLine(true);
            this.mLeftTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.mLeftTextView.setDuplicateParentStateEnabled(true);
        }
        this.mLeftTextView.setTextColor(getColorByTypeInternal(getResources(), this.mLeftTextColor));
        this.mLeftTextView.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158563j1));
        this.mLeftTextView.setGravity(19);
        setLeftIcon(this.mLeftIcon, this.mLeftIconWidth, this.mLeftIconHeight);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i3 = this.mPadding;
        layoutParams.leftMargin = i3;
        if (!this.mNeedSetHeight) {
            layoutParams.topMargin = i3;
            layoutParams.bottomMargin = i3;
            setMinimumHeight(this.mItemHeight);
        }
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.mLeftTextView.setMaxWidth(this.mLeftTextViewMaxWidth);
        addView(this.mLeftTextView, layoutParams);
        QMultiImageTextView qMultiImageTextView = new QMultiImageTextView(getContext());
        this.mRightTextView = qMultiImageTextView;
        qMultiImageTextView.setId(R.id.cjn);
        this.mRightTextView.setSingleLine(true);
        this.mRightTextView.setTextColor(getColorByTypeInternal(getResources(), this.mRightTextColor));
        this.mRightTextView.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158570j9));
        this.mRightTextView.setGravity(19);
        this.mRightTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.mRightTextView.setDuplicateParentStateEnabled(true);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = this.mPadding;
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        addView(this.mRightTextView, layoutParams2);
        updateRightViews();
        setBackgroundDrawable(getSelectorByTypeInternal(getResources(), this.mBgType));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (o.l() && this.mUseCardUI) {
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

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.mNeedSetHeight) {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
            setMeasuredDimension(getMeasuredWidth(), this.mItemHeight);
        } else {
            super.onMeasure(i3, i16);
        }
    }

    public void setArrowIcon(Drawable drawable) {
        this.mArrow = drawable;
    }

    public void setBgType(int i3) {
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
            throw new RuntimeException("Parameter bgType is illegal!");
        }
        this.mBgType = i3;
        setBackgroundDrawable(getSelectorByTypeInternal(getResources(), this.mBgType));
    }

    public void setCloseVipTheme(boolean z16) {
        this.mCloseVipTheme = z16;
    }

    public void setCustomHeight(int i3) {
        if (i3 > 0 && this.mNeedSetHeight) {
            this.mItemHeight = i3;
            requestLayout();
        }
    }

    public void setLeftIcon(Drawable drawable) {
        TextView textView = this.mLeftTextView;
        if (textView != null) {
            this.mLeftIcon = drawable;
            if (drawable == null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            if (drawable.getIntrinsicHeight() > this.mItemHeight) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mItemHeight);
                this.mLeftTextView.setCompoundDrawables(drawable, null, null, null);
            } else {
                this.mLeftTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.mLeftTextView.setCompoundDrawablePadding(this.mPadding);
        }
    }

    public void setLeftText(CharSequence charSequence) {
        TextView textView;
        if (!TextUtils.isEmpty(charSequence) && (textView = this.mLeftTextView) != null) {
            this.mLeftText = charSequence;
            textView.setText(charSequence);
            this.mLeftTextView.setTextColor(getColorByTypeInternal(getResources(), this.mLeftTextColor));
            this.mLeftTextView.setContentDescription(this.mLeftText);
        }
    }

    public void setLeftTextColor(int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 1 && i3 != 4) {
            throw new RuntimeException("Parameter colorType is illegal!");
        }
        if (this.mLeftText != null) {
            this.mLeftTextColor = i3;
            this.mLeftTextView.setTextColor(getColorByTypeInternal(getResources(), this.mLeftTextColor));
        }
    }

    public void setLeftTextNoColor(CharSequence charSequence) {
        TextView textView;
        if (!TextUtils.isEmpty(charSequence) && (textView = this.mLeftTextView) != null) {
            this.mLeftText = charSequence;
            textView.setText(charSequence);
            this.mLeftTextView.setContentDescription(this.mLeftText);
        }
    }

    public void setLeftTextSize(float f16) {
        TextView textView = this.mLeftTextView;
        if (textView != null) {
            textView.setTextSize(f16);
        }
    }

    public void setListBackground(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.mListBackground = drawable;
        setBackgroundDrawable(getSelectorByTypeInternal(getResources(), this.mBgType));
    }

    public void setRightIcon(Drawable drawable) {
        setRightIcon(drawable, 0, 0);
    }

    public void setRightText(CharSequence charSequence) {
        this.mRightText = charSequence;
        updateRightViews();
    }

    public void setRightTextColor(int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 1) {
            throw new RuntimeException("Parameter colorType is illegal!");
        }
        QMultiImageTextView qMultiImageTextView = this.mRightTextView;
        if (qMultiImageTextView != null) {
            this.mRightTextColor = i3;
            qMultiImageTextView.setVisibility(0);
            this.mRightTextView.setTextColor(getColorByTypeInternal(getResources(), this.mRightTextColor));
        }
    }

    public void setRightTextPadding(int i3) {
        this.mRightTextPadding = i3;
    }

    public void setUseCardUI(boolean z16) {
        this.mUseCardUI = z16;
    }

    public void showArrow(boolean z16) {
        this.mShowArrow = z16;
        updateRightViews();
    }

    protected void updateRightViews() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        Drawable drawable;
        if (this.mRightTextView == null) {
            return;
        }
        calucateTextMaxWidth();
        TextView textView = this.mLeftTextView;
        if (textView != null) {
            textView.setMaxWidth(this.mLeftTextViewMaxWidth);
        }
        if (isDefTheme()) {
            Drawable drawable2 = this.mRightIcon;
            if (drawable2 != null) {
                i3 = drawable2.getIntrinsicWidth();
                i16 = this.mRightIcon.getIntrinsicHeight();
            } else {
                i3 = 0;
                i16 = 0;
            }
            i17 = FormItemConstants.WIDTH_DEFAULT_ARROW;
            i18 = FormItemConstants.HEIGHT_DEFAULT_ARROW;
        } else {
            Drawable drawable3 = this.mArrow;
            if (drawable3 != null) {
                if (this.mCloseVipTheme) {
                    i19 = drawable3.getIntrinsicWidth();
                } else {
                    i19 = FormItemConstants.WIDTH_DEFAULT_ARROW;
                }
                i17 = i19;
                if (this.mCloseVipTheme) {
                    i26 = this.mArrow.getIntrinsicHeight();
                } else {
                    i26 = FormItemConstants.HEIGHT_DEFAULT_ARROW;
                }
                i18 = i26;
                i3 = 0;
                i16 = 0;
            } else {
                i3 = 0;
                i16 = 0;
                i17 = 0;
                i18 = 0;
            }
        }
        int i37 = this.mArrowWidth;
        if (i37 != -1) {
            i17 = i37;
        }
        int i38 = this.mArrowHeight;
        if (i38 != -1) {
            i18 = i38;
        }
        if (!TextUtils.isEmpty(this.mRightText)) {
            this.mRightTextView.setVisibility(0);
            this.mRightTextView.setText(this.mRightText);
            this.mRightTextView.setTextColor(getColorByTypeInternal(getResources(), this.mRightTextColor));
            this.mRightTextView.setContentDescription(this.mRightText);
            this.mRightTextView.setMaxWidth(this.mRightTextViewMaxWidth);
            Drawable drawable4 = this.mRightIcon;
            if (drawable4 != null && this.mShowArrow && (drawable = this.mArrow) != null) {
                if (this.mRightIconWidth > 0 && this.mRightIconHeight > 0) {
                    drawable.setBounds(0, 0, i17, i18);
                    this.mRightIcon.setBounds(0, 0, this.mRightIconWidth, this.mRightIconHeight);
                    this.mRightTextView.setCompoundDrawables(this.mRightIcon, null, this.mArrow, null);
                } else if (isDefTheme()) {
                    this.mArrow.setBounds(0, 0, i17, i18);
                    this.mRightIcon.setBounds(0, 0, i3, i16);
                    this.mRightTextView.setCompoundDrawables(this.mRightIcon, null, this.mArrow, null);
                } else {
                    this.mRightTextView.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, (Drawable) null, this.mArrow, (Drawable) null);
                }
                this.mRightTextView.setCompoundDrawablePadding(this.mRightTextPadding);
                return;
            }
            if (drawable4 != null && !this.mShowArrow) {
                int i39 = this.mRightIconWidth;
                if (i39 > 0 && (i36 = this.mRightIconHeight) > 0) {
                    drawable4.setBounds(0, 0, i39, i36);
                    this.mRightTextView.setCompoundDrawables(this.mRightIcon, null, null, null);
                } else {
                    this.mRightTextView.setCompoundDrawablesWithIntrinsicBounds(drawable4, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.mRightTextView.setCompoundDrawablePadding(this.mRightIconHeight);
                return;
            }
            if (drawable4 == null && this.mShowArrow && this.mArrow != null) {
                if (isDefTheme()) {
                    this.mArrow.setBounds(0, 0, i17, i18);
                    this.mRightTextView.setCompoundDrawables(null, null, this.mArrow, null);
                } else {
                    int i46 = this.mArrowWidth;
                    if (i46 == -1 && (i29 = this.mArrowHeight) == -1) {
                        if (i46 == -1 && i29 == -1) {
                            if (i46 == -1 && i29 == -1) {
                                this.mRightTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mArrow, (Drawable) null);
                            } else {
                                this.mArrow.setBounds(0, 0, i17, i18);
                                this.mRightTextView.setCompoundDrawables(null, null, this.mArrow, null);
                            }
                        } else {
                            this.mArrow.setBounds(0, 0, i17, i18);
                            this.mRightTextView.setCompoundDrawables(null, null, this.mArrow, null);
                        }
                    } else {
                        this.mArrow.setBounds(0, 0, i17, i18);
                        this.mRightTextView.setCompoundDrawables(null, null, this.mArrow, null);
                    }
                }
                this.mRightTextView.setCompoundDrawablePadding(this.mRightTextPadding);
                return;
            }
            if (drawable4 == null && !this.mShowArrow) {
                this.mRightTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.mRightTextView.setCompoundDrawablePadding(0);
                return;
            }
            return;
        }
        this.mRightTextView.setText("");
        Drawable drawable5 = this.mRightIcon;
        if (drawable5 != null && this.mShowArrow && this.mArrow != null) {
            this.mRightTextView.setVisibility(0);
            int i47 = this.mRightIconWidth;
            if (i47 > 0 && (i28 = this.mRightIconHeight) > 0) {
                this.mRightIcon.setBounds(0, 0, i47, i28);
                this.mArrow.setBounds(0, 0, i17, i18);
                this.mRightTextView.setCompoundDrawables(this.mRightIcon, null, this.mArrow, null);
            } else if (isDefTheme()) {
                this.mArrow.setBounds(0, 0, i17, i18);
                this.mRightIcon.setBounds(0, 0, i3, i16);
                this.mRightTextView.setCompoundDrawables(this.mRightIcon, null, this.mArrow, null);
            } else {
                this.mRightTextView.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, (Drawable) null, this.mArrow, (Drawable) null);
            }
            this.mRightTextView.setCompoundDrawablePadding(this.mRightIconHeight);
            return;
        }
        if (drawable5 != null && !this.mShowArrow) {
            this.mRightTextView.setVisibility(0);
            int i48 = this.mRightIconWidth;
            if (i48 > 0 && (i27 = this.mRightIconHeight) > 0) {
                this.mRightIcon.setBounds(0, 0, i48, i27);
                this.mRightTextView.setCompoundDrawables(this.mRightIcon, null, null, null);
            } else {
                this.mRightTextView.setCompoundDrawablesWithIntrinsicBounds(this.mRightIcon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.mRightTextView.setCompoundDrawablePadding(0);
            return;
        }
        if (drawable5 == null && this.mShowArrow) {
            this.mRightTextView.setVisibility(0);
            if (isDefTheme()) {
                Drawable drawable6 = this.mArrow;
                if (drawable6 != null) {
                    drawable6.setBounds(0, 0, i17, i18);
                }
                this.mRightTextView.setCompoundDrawables(null, null, this.mArrow, null);
            } else if (this.mArrowWidth == -1 && this.mArrowHeight == -1) {
                this.mRightTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mArrow, (Drawable) null);
            } else {
                Drawable drawable7 = this.mArrow;
                if (drawable7 != null) {
                    drawable7.setBounds(0, 0, i17, i18);
                }
                this.mRightTextView.setCompoundDrawables(null, null, this.mArrow, null);
            }
            this.mRightTextView.setCompoundDrawablePadding(0);
            return;
        }
        if (drawable5 == null && !this.mShowArrow) {
            this.mRightTextView.setVisibility(8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x013c, code lost:
    
        if (r3 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QFormSimpleItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRect = new Rect();
        this.mPaint = new Paint();
        this.mCloseVipTheme = false;
        this.mRightTextPadding = 8;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158564j2);
        this.mRightIconMaxWidth = (int) ((getResources().getDisplayMetrics().density * 35.0f) + 0.5d);
        this.mArrowMaxWidth = (int) ((getResources().getDisplayMetrics().density * 15.0f) + 0.5d);
        Drawable drawable = getResources().getDrawable(this.mCloseVipTheme ? R.drawable.common_arrow_right_selector : R.drawable.jae);
        this.mDefaultArrowDrawable = drawable;
        this.mArrow = drawable;
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, jj2.b.f410081i2);
            this.mPadding = typedArray.getDimensionPixelSize(jj2.b.f410125m2, getResources().getDimensionPixelSize(R.dimen.aes));
            this.mItemHeight = typedArray.getDimensionPixelSize(jj2.b.f410114l2, dimensionPixelSize);
            this.mLeftText = typedArray.getString(jj2.b.f410195s2);
            this.mLeftTextColor = typedArray.getInt(jj2.b.f410206t2, 0);
            this.mLeftIcon = typedArray.getDrawable(jj2.b.f410159p2);
            this.mLeftIconWidth = typedArray.getDimensionPixelSize(jj2.b.f410183r2, 0);
            int dimensionPixelSize2 = typedArray.getDimensionPixelSize(jj2.b.f410171q2, 0);
            this.mLeftIconHeight = dimensionPixelSize2;
            this.mLeftIconHeight = Math.min(this.mItemHeight, dimensionPixelSize2);
            this.mRightText = typedArray.getString(jj2.b.A2);
            this.mRightTextColor = typedArray.getInt(jj2.b.B2, 3);
            this.mRightIcon = typedArray.getDrawable(jj2.b.f410248x2);
            this.mRightIconWidth = typedArray.getDimensionPixelSize(jj2.b.f410270z2, 0);
            int dimensionPixelSize3 = typedArray.getDimensionPixelSize(jj2.b.f410259y2, 0);
            this.mRightIconHeight = dimensionPixelSize3;
            this.mRightIconHeight = Math.min(this.mItemHeight, dimensionPixelSize3);
            int i3 = u51.a.V;
            if (typedArray.getDrawable(i3) != null) {
                this.mArrow = typedArray.getDrawable(i3);
            }
            this.mArrowWidth = typedArray.getDimensionPixelSize(u51.a.X, -1);
            this.mArrowHeight = typedArray.getDimensionPixelSize(u51.a.W, -1);
            this.mShowArrow = typedArray.getBoolean(jj2.b.C2, false);
            this.mBgType = typedArray.getInt(jj2.b.f410092j2, 0);
            mNeedFocusBg = typedArray.getBoolean(jj2.b.f410228v2, true);
            this.mNeedSetHeight = typedArray.getBoolean(jj2.b.f410238w2, true);
            this.mUseCardUI = typedArray.getBoolean(jj2.b.f410103k2, true);
            this.mCloseVipTheme = typedArray.getBoolean(u51.a.f438276a0, false);
            this.mListBackground = typedArray.getDrawable(jj2.b.f410217u2);
        } catch (Throwable unused) {
        }
        typedArray.recycle();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
        initViews();
    }

    public void setRightIcon(Drawable drawable, int i3, int i16) {
        if (i3 < 0 || i16 < 0) {
            return;
        }
        this.mRightIconWidth = i3;
        this.mRightIconHeight = Math.min(this.mItemHeight, i16);
        this.mRightIcon = drawable;
        updateRightViews();
    }

    public void setLeftIcon(Drawable drawable, int i3, int i16) {
        if (drawable == null || this.mLeftTextView == null || i3 < 0 || i16 < 0) {
            return;
        }
        if (i3 <= 0 || i16 <= 0) {
            if (i3 == 0 || i16 == 0) {
                setLeftIcon(drawable);
                return;
            }
            return;
        }
        this.mLeftIcon = drawable;
        this.mLeftIconWidth = i3;
        int min = Math.min(this.mItemHeight, i16);
        this.mLeftIconHeight = min;
        drawable.setBounds(0, 0, i3, min);
        this.mLeftTextView.setCompoundDrawables(drawable, null, null, null);
        this.mLeftTextView.setCompoundDrawablePadding(this.mPadding);
    }
}
