package com.tenpay.sdk.view;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.CompoundButton;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Switch extends CompoundButton {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    private float mThumbPosition;
    private int mThumbTextPadding;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private VelocityTracker mVelocityTracker;

    public Switch(Context context) {
        this(context, null);
    }

    private void animateThumbToCheckedState(boolean z16) {
        setChecked(z16);
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private boolean getTargetCheckedState() {
        if (this.mThumbPosition >= getThumbScrollRange() / 2.0f) {
            return true;
        }
        return false;
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        drawable.getPadding(this.mTempRect);
        int i3 = this.mSwitchWidth - this.mThumbWidth;
        Rect rect = this.mTempRect;
        return (i3 - rect.left) - rect.right;
    }

    private boolean hitThumb(float f16, float f17) {
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i3 = this.mSwitchTop;
        int i16 = this.mTouchSlop;
        int i17 = i3 - i16;
        int i18 = (this.mSwitchLeft + ((int) (this.mThumbPosition + 0.5f))) - i16;
        int i19 = this.mThumbWidth + i18;
        Rect rect = this.mTempRect;
        int i26 = i19 + rect.left + rect.right + i16;
        int i27 = this.mSwitchBottom + i16;
        if (f16 > i18 && f16 < i26 && f17 > i17 && f17 < i27) {
            return true;
        }
        return false;
    }

    private Layout makeLayout(CharSequence charSequence) {
        return new StaticLayout("", this.mTextPaint, (int) Math.ceil(Layout.getDesiredWidth("", r2)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void setSwitchTypefaceByIndex(int i3, int i16) {
        Typeface typeface;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    typeface = null;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        setSwitchTypeface(typeface, i16);
    }

    private void setThumbPosition(boolean z16) {
        float f16;
        if (z16) {
            f16 = getThumbScrollRange();
        } else {
            f16 = 0.0f;
        }
        this.mThumbPosition = f16;
    }

    private void stopDrag(MotionEvent motionEvent) {
        boolean z16;
        boolean z17 = false;
        this.mTouchMode = 0;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            z16 = true;
        } else {
            z16 = false;
        }
        cancelSuperTouch(motionEvent);
        if (z16) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) > this.mMinFlingVelocity) {
                if (xVelocity > 0.0f) {
                    z17 = true;
                }
            } else {
                z17 = getTargetCheckedState();
            }
            animateThumbToCheckedState(z17);
            return;
        }
        animateThumbToCheckedState(isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setState(drawableState);
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.mSwitchPadding;
        }
        return compoundPaddingRight;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Layout layout;
        super.onDraw(canvas);
        int i3 = this.mSwitchLeft;
        int i16 = this.mSwitchTop;
        int i17 = this.mSwitchRight;
        int i18 = this.mSwitchBottom;
        this.mTrackDrawable.setBounds(i3, i16, i17, i18);
        this.mTrackDrawable.draw(canvas);
        canvas.save();
        this.mTrackDrawable.getPadding(this.mTempRect);
        Rect rect = this.mTempRect;
        int i19 = i3 + rect.left;
        int i26 = rect.top + i16;
        int i27 = i17 - rect.right;
        int i28 = i18 - rect.bottom;
        canvas.clipRect(i19, i16, i27, i18);
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i29 = (int) this.mThumbPosition;
        Rect rect2 = this.mTempRect;
        this.mThumbDrawable.setBounds((i19 - rect2.left) + i29, i16, i19 + i29 + this.mThumbWidth + rect2.right, i18);
        this.mThumbDrawable.draw(canvas);
        ColorStateList colorStateList = this.mTextColors;
        if (colorStateList != null) {
            this.mTextPaint.setColor(colorStateList.getColorForState(getDrawableState(), this.mTextColors.getDefaultColor()));
        }
        this.mTextPaint.drawableState = getDrawableState();
        if (getTargetCheckedState()) {
            layout = this.mOnLayout;
        } else {
            layout = this.mOffLayout;
        }
        if (layout != null) {
            canvas.translate(((r7 + r0) / 2) - (layout.getWidth() / 2), ((i26 + i28) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        int i27;
        super.onLayout(z16, i3, i16, i17, i18);
        setThumbPosition(isChecked());
        int width = getWidth() - getPaddingRight();
        int i28 = width - this.mSwitchWidth;
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                i26 = getPaddingTop();
                i19 = this.mSwitchHeight;
            } else {
                i27 = getHeight() - getPaddingBottom();
                i26 = i27 - this.mSwitchHeight;
                this.mSwitchLeft = i28;
                this.mSwitchTop = i26;
                this.mSwitchBottom = i27;
                this.mSwitchRight = width;
            }
        } else {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i19 = this.mSwitchHeight;
            i26 = paddingTop - (i19 / 2);
        }
        i27 = i19 + i26;
        this.mSwitchLeft = i28;
        this.mSwitchTop = i26;
        this.mSwitchBottom = i27;
        this.mSwitchRight = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.mOnLayout == null) {
            this.mOnLayout = makeLayout(this.mTextOn);
        }
        if (this.mOffLayout == null) {
            this.mOffLayout = makeLayout(this.mTextOff);
        }
        this.mTrackDrawable.getPadding(this.mTempRect);
        int max = Math.max(Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()), this.mThumbDrawable.getIntrinsicWidth());
        int max2 = Math.max(this.mSwitchMinWidth, this.mTrackDrawable.getIntrinsicWidth());
        int i17 = (this.mThumbTextPadding * 4) + max;
        Rect rect = this.mTempRect;
        int max3 = Math.max(max2, i17 + rect.left + rect.right);
        int intrinsicHeight = this.mTrackDrawable.getIntrinsicHeight();
        this.mThumbWidth = max + (this.mThumbTextPadding * 2);
        this.mSwitchWidth = max3;
        this.mSwitchHeight = intrinsicHeight;
        super.onMeasure(i3, i16);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(getMeasuredWidth(), intrinsicHeight);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r0 != 3) goto L34;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i3 = this.mTouchMode;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            float x16 = motionEvent.getX();
                            float max = Math.max(0.0f, Math.min(this.mThumbPosition + (x16 - this.mTouchX), getThumbScrollRange()));
                            if (max != this.mThumbPosition) {
                                this.mThumbPosition = max;
                                this.mTouchX = x16;
                                invalidate();
                            }
                            return true;
                        }
                    } else {
                        float x17 = motionEvent.getX();
                        float y16 = motionEvent.getY();
                        if (Math.abs(x17 - this.mTouchX) > this.mTouchSlop || Math.abs(y16 - this.mTouchY) > this.mTouchSlop) {
                            this.mTouchMode = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.mTouchX = x17;
                            this.mTouchY = y16;
                            return true;
                        }
                    }
                }
            }
            if (this.mTouchMode == 2) {
                stopDrag(motionEvent);
                return true;
            }
            this.mTouchMode = 0;
            this.mVelocityTracker.clear();
        } else {
            float x18 = motionEvent.getX();
            float y17 = motionEvent.getY();
            if (isEnabled() && hitThumb(x18, y17)) {
                this.mTouchMode = 1;
                this.mTouchX = x18;
                this.mTouchY = y17;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z16) {
        super.setChecked(z16);
        setThumbPosition(isChecked());
        invalidate();
    }

    public void setSwitchMinWidth(int i3) {
        this.mSwitchMinWidth = i3;
        requestLayout();
    }

    public void setSwitchNoSkin() {
        setTrackResource(com.tencent.mobileqq.R.drawable.f161429xb);
        setThumbResource(com.tencent.mobileqq.R.drawable.f161428xa);
    }

    public void setSwitchPadding(int i3) {
        this.mSwitchPadding = i3;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface, int i3) {
        Typeface create;
        if (i3 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i3);
            } else {
                create = Typeface.create(typeface, i3);
            }
            setSwitchTypeface(create);
            int i16 = (~(create != null ? create.getStyle() : 0)) & i3;
            this.mTextPaint.setFakeBoldText((i16 & 1) != 0);
            this.mTextPaint.setTextSkewX((i16 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setTextOff(CharSequence charSequence) {
        this.mTextOff = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.mTextOn = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        this.mThumbDrawable = drawable;
        requestLayout();
    }

    public void setThumbResource(int i3) {
        setThumbDrawable(getContext().getResources().getDrawable(i3));
    }

    public void setThumbTextPadding(int i3) {
        this.mThumbTextPadding = i3;
        requestLayout();
    }

    public void setTrackDrawable(Drawable drawable) {
        this.mTrackDrawable = drawable;
        requestLayout();
    }

    public void setTrackResource(int i3) {
        setTrackDrawable(getContext().getResources().getDrawable(i3));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mThumbDrawable && drawable != this.mTrackDrawable) {
            return false;
        }
        return true;
    }

    public Switch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.s_);
    }

    public Switch(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mTextPaint = new TextPaint(1);
        Resources resources = context.getResources();
        this.mTextPaint.density = resources.getDisplayMetrics().density;
        this.mThumbDrawable = resources.getDrawable(com.tencent.mobileqq.R.drawable.b57);
        this.mTrackDrawable = resources.getDrawable(com.tencent.mobileqq.R.drawable.b58);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.view.Switch.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.mTextPaint.getTypeface() != typeface) {
            this.mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }
}
