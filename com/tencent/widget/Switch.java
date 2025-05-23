package com.tencent.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableView;
import com.tencent.util.SwitchHelper;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Switch extends CompoundButton implements SkinnableView {
    static IPatchRedirector $redirector_ = null;
    private static final int[] CHECKED_STATE_SET;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_PADDING;
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
    private TransformationMethod2 mSwitchTransformationMethod;
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

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Switch.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            THUMB_PADDING = x.c(BaseApplication.getContext(), 4.0f);
            CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        }
    }

    public Switch(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
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
        if (this.mThumbPosition >= getThumbScrollRange() / 2) {
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

    private boolean hasTextInSwitch() {
        CharSequence charSequence;
        CharSequence charSequence2 = this.mTextOn;
        if ((charSequence2 != null && !charSequence2.equals("")) || ((charSequence = this.mTextOff) != null && !charSequence.equals(""))) {
            return true;
        }
        return false;
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
        TransformationMethod2 transformationMethod2 = this.mSwitchTransformationMethod;
        if (transformationMethod2 != null) {
            charSequence = transformationMethod2.getTransformation(charSequence, this);
        }
        return new StaticLayout(charSequence, this.mTextPaint, (int) Math.ceil(Layout.getDesiredWidth(r1, r2)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void refreshDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof GradientDrawable) {
            SkinEngine.refreshGradientDrawable((GradientDrawable) drawable);
        } else if (drawable instanceof LayerDrawable) {
            SkinEngine.refreshLayerDrawable((LayerDrawable) drawable);
        } else if (drawable instanceof DrawableContainer) {
            SkinEngine.refreshGradientInContainer((DrawableContainer) drawable);
        }
        drawable.invalidateSelf();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.mSwitchPadding;
        }
        return compoundPaddingRight;
    }

    public int getSwitchMinWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (CharSequence) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (CharSequence) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Drawable) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mThumbDrawable;
    }

    public int getThumbTextPadding() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mThumbTextPadding;
    }

    public Drawable getTrackDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Drawable) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mTrackDrawable;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (int[]) iPatchRedirector.redirect((short) 30, (Object) this, i3);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Layout layout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) canvas);
            return;
        }
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
        int i36 = (i19 - rect2.left) + i29;
        int i37 = i19 + i29 + this.mThumbWidth + rect2.right;
        if (hasTextInSwitch()) {
            this.mThumbDrawable.setBounds(i36, i16, i37, i18);
        } else {
            Drawable drawable = this.mThumbDrawable;
            int i38 = THUMB_PADDING;
            drawable.setBounds(i36 + i38, i26 + i38, i37 - i38, i28 - i38);
        }
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
            canvas.translate(((i36 + i37) / 2) - (layout.getWidth() / 2), ((i26 + i28) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mOnLayout == null) {
            this.mOnLayout = makeLayout(this.mTextOn);
        }
        if (this.mOffLayout == null) {
            this.mOffLayout = makeLayout(this.mTextOff);
        }
        this.mTrackDrawable.getPadding(this.mTempRect);
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            i17 = drawable.getIntrinsicWidth();
        }
        int max = Math.max(Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()), i17);
        int max2 = Math.max(this.mSwitchMinWidth, this.mTrackDrawable.getIntrinsicWidth());
        int i18 = (this.mThumbTextPadding * 4) + max;
        Rect rect = this.mTempRect;
        int max3 = Math.max(max2, i18 + rect.left + rect.right);
        int intrinsicHeight = this.mTrackDrawable.getIntrinsicHeight();
        if (!hasTextInSwitch()) {
            this.mThumbWidth = intrinsicHeight;
        } else {
            this.mThumbWidth = max + (this.mThumbTextPadding * 2);
        }
        this.mSwitchWidth = max3;
        this.mSwitchHeight = intrinsicHeight;
        super.onMeasure(i3, i16);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(getMeasuredWidth(), intrinsicHeight);
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            refreshDrawable(this.mTrackDrawable);
            refreshDrawable(this.mThumbDrawable);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r0 != 3) goto L40;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) motionEvent)).booleanValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
            return;
        }
        super.setChecked(z16);
        setThumbPosition(isChecked());
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        super.setEnabled(z16);
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return;
        }
        if (!z16) {
            drawable.setAlpha(127);
        } else {
            drawable.setAlpha(255);
        }
    }

    public void setSwitchMinWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mSwitchMinWidth = i3;
            requestLayout();
        }
    }

    public void setSwitchPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mSwitchPadding = i3;
            requestLayout();
        }
    }

    public void setSwitchTextAppearance(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, i3);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, u51.a.f438340v1);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(u51.a.f438346x1);
        if (colorStateList != null) {
            this.mTextColors = colorStateList;
        } else {
            this.mTextColors = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438349y1, 0);
        if (dimensionPixelSize != 0) {
            float f16 = dimensionPixelSize;
            if (f16 != this.mTextPaint.getTextSize()) {
                this.mTextPaint.setTextSize(f16);
                requestLayout();
            }
        }
        setSwitchTypefaceByIndex(obtainStyledAttributes.getInt(u51.a.A1, -1), obtainStyledAttributes.getInt(u51.a.f438352z1, -1));
        if (obtainStyledAttributes.getBoolean(u51.a.f438343w1, false)) {
            AllCapsTransformationMethod allCapsTransformationMethod = new AllCapsTransformationMethod(getContext());
            this.mSwitchTransformationMethod = allCapsTransformationMethod;
            allCapsTransformationMethod.setLengthChangesAllowed(true);
        } else {
            this.mSwitchTransformationMethod = null;
        }
        obtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface, int i3) {
        Typeface create;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) typeface, i3);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) charSequence);
        } else {
            this.mTextOff = charSequence;
            requestLayout();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) charSequence);
        } else {
            this.mTextOn = charSequence;
            requestLayout();
        }
    }

    public void setThemeId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            this.mTrackDrawable = SwitchHelper.buildTrackDrawable(getContext(), i3);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) drawable);
        } else {
            this.mThumbDrawable = drawable;
            requestLayout();
        }
    }

    public void setThumbResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            setThumbDrawable(getContext().getResources().getDrawable(i3));
        }
    }

    public void setThumbTextPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.mThumbTextPadding = i3;
            requestLayout();
        }
    }

    public void setTrackDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) drawable);
        } else {
            this.mTrackDrawable = drawable;
            requestLayout();
        }
    }

    public void setTrackResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            setTrackDrawable(getContext().getResources().getDrawable(i3));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) drawable)).booleanValue();
        }
        if (!super.verifyDrawable(drawable) && drawable != this.mThumbDrawable && drawable != this.mTrackDrawable) {
            return false;
        }
        return true;
    }

    public Switch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.s_);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public Switch(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mTextPaint = new TextPaint(1);
        Resources resources = getResources();
        this.mTextPaint.density = resources.getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u51.a.f438304j1, i3, com.tencent.mobileqq.R.style.f174310vg);
        this.mThumbDrawable = resources.getDrawable(obtainStyledAttributes.getResourceId(u51.a.f438325q1, com.tencent.mobileqq.R.drawable.b57));
        this.mTrackDrawable = resources.getDrawable(obtainStyledAttributes.getResourceId(u51.a.f438331s1, com.tencent.mobileqq.R.drawable.b58));
        int i16 = obtainStyledAttributes.getInt(u51.a.f438316n1, 1000);
        if (i16 != 1000) {
            setThemeId(i16);
        }
        CharSequence text = obtainStyledAttributes.getText(u51.a.f438322p1);
        this.mTextOn = text;
        if (text == null) {
            this.mTextOn = "";
        }
        CharSequence text2 = obtainStyledAttributes.getText(u51.a.f438319o1);
        this.mTextOff = text2;
        if (text2 == null) {
            this.mTextOff = "";
        }
        this.mThumbTextPadding = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438328r1, 0);
        this.mSwitchMinWidth = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438307k1, 0);
        this.mSwitchPadding = obtainStyledAttributes.getDimensionPixelSize(u51.a.f438310l1, 0);
        int resourceId = obtainStyledAttributes.getResourceId(u51.a.f438313m1, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
        setEnabled(isEnabled());
        setOnClickListener(new a());
    }

    public void setSwitchTypeface(Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) typeface);
        } else if (this.mTextPaint.getTypeface() != typeface) {
            this.mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }
}
