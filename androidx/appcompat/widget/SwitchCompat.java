package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;
    private static final Property<SwitchCompat, Float> THUMB_POS = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: androidx.appcompat.widget.SwitchCompat.1
        @Override // android.util.Property
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.mThumbPosition);
        }

        @Override // android.util.Property
        public void set(SwitchCompat switchCompat, Float f16) {
            switchCompat.setThumbPosition(f16.floatValue());
        }
    };
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};

    public SwitchCompat(@NonNull Context context) {
        this(context, null);
    }

    private void animateThumbToCheckedState(boolean z16) {
        float f16;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, THUMB_POS, f16);
        this.mPositionAnimator = ofFloat;
        ofFloat.setDuration(250L);
        this.mPositionAnimator.setAutoCancel(true);
        this.mPositionAnimator.start();
    }

    private void applyThumbTint() {
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            if (this.mHasThumbTint || this.mHasThumbTintMode) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                this.mThumbDrawable = mutate;
                if (this.mHasThumbTint) {
                    DrawableCompat.setTintList(mutate, this.mThumbTintList);
                }
                if (this.mHasThumbTintMode) {
                    DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
                }
                if (this.mThumbDrawable.isStateful()) {
                    this.mThumbDrawable.setState(getDrawableState());
                }
            }
        }
    }

    private void applyTrackTint() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            if (this.mHasTrackTint || this.mHasTrackTintMode) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                this.mTrackDrawable = mutate;
                if (this.mHasTrackTint) {
                    DrawableCompat.setTintList(mutate, this.mTrackTintList);
                }
                if (this.mHasTrackTintMode) {
                    DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
                }
                if (this.mTrackDrawable.isStateful()) {
                    this.mTrackDrawable.setState(getDrawableState());
                }
            }
        }
    }

    private void cancelPositionAnimator() {
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float constrain(float f16, float f17, float f18) {
        if (f16 < f17) {
            return f17;
        }
        if (f16 > f18) {
            return f18;
        }
        return f16;
    }

    private boolean getTargetCheckedState() {
        if (this.mThumbPosition > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f16;
        if (ViewUtils.isLayoutRtl(this)) {
            f16 = 1.0f - this.mThumbPosition;
        } else {
            f16 = this.mThumbPosition;
        }
        return (int) ((f16 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            Rect rect2 = this.mTempRect;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.mThumbDrawable;
            if (drawable2 != null) {
                rect = DrawableUtils.getOpticalBounds(drawable2);
            } else {
                rect = DrawableUtils.INSETS_NONE;
            }
            return ((((this.mSwitchWidth - this.mThumbWidth) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    private boolean hitThumb(float f16, float f17) {
        if (this.mThumbDrawable == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i3 = this.mSwitchTop;
        int i16 = this.mTouchSlop;
        int i17 = i3 - i16;
        int i18 = (this.mSwitchLeft + thumbOffset) - i16;
        int i19 = this.mThumbWidth + i18;
        Rect rect = this.mTempRect;
        int i26 = i19 + rect.left + rect.right + i16;
        int i27 = this.mSwitchBottom + i16;
        if (f16 <= i18 || f16 >= i26 || f17 <= i17 || f17 >= i27) {
            return false;
        }
        return true;
    }

    private Layout makeLayout(CharSequence charSequence) {
        int i3;
        TransformationMethod transformationMethod = this.mSwitchTransformationMethod;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.mTextPaint;
        if (charSequence2 != null) {
            i3 = (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint));
        } else {
            i3 = 0;
        }
        return new StaticLayout(charSequence2, textPaint, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
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

    private void stopDrag(MotionEvent motionEvent) {
        boolean z16;
        this.mTouchMode = 0;
        boolean z17 = true;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isChecked = isChecked();
        if (z16) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) > this.mMinFlingVelocity) {
                if (!ViewUtils.isLayoutRtl(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z17 = false;
                }
            } else {
                z17 = getTargetCheckedState();
            }
        } else {
            z17 = isChecked;
        }
        if (z17 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z17);
        cancelSuperTouch(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i3;
        int i16;
        Rect rect2 = this.mTempRect;
        int i17 = this.mSwitchLeft;
        int i18 = this.mSwitchTop;
        int i19 = this.mSwitchRight;
        int i26 = this.mSwitchBottom;
        int thumbOffset = getThumbOffset() + i17;
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            rect = DrawableUtils.getOpticalBounds(drawable);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i27 = rect2.left;
            thumbOffset += i27;
            if (rect != null) {
                int i28 = rect.left;
                if (i28 > i27) {
                    i17 += i28 - i27;
                }
                int i29 = rect.top;
                int i36 = rect2.top;
                if (i29 > i36) {
                    i3 = (i29 - i36) + i18;
                } else {
                    i3 = i18;
                }
                int i37 = rect.right;
                int i38 = rect2.right;
                if (i37 > i38) {
                    i19 -= i37 - i38;
                }
                int i39 = rect.bottom;
                int i46 = rect2.bottom;
                if (i39 > i46) {
                    i16 = i26 - (i39 - i46);
                    this.mTrackDrawable.setBounds(i17, i3, i19, i16);
                }
            } else {
                i3 = i18;
            }
            i16 = i26;
            this.mTrackDrawable.setBounds(i17, i3, i19, i16);
        }
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i47 = thumbOffset - rect2.left;
            int i48 = thumbOffset + this.mThumbWidth + rect2.right;
            this.mThumbDrawable.setBounds(i47, i18, i48, i26);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i47, i18, i48, i26);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f16, float f17) {
        super.drawableHotspotChanged(f16, f17);
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f16, f17);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, f16, f17);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        boolean z16 = false;
        if (drawable != null && drawable.isStateful()) {
            z16 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            z16 |= drawable2.setState(drawableState);
        }
        if (z16) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.mSwitchPadding;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.mSwitchPadding;
        }
        return compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
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

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.mPositionAnimator.end();
            this.mPositionAnimator = null;
        }
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
        int width;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.mSwitchTop;
        int i16 = this.mSwitchBottom;
        int i17 = i3 + rect.top;
        int i18 = i16 - rect.bottom;
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable != null) {
            if (this.mSplitTrack && drawable2 != null) {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            layout = this.mOnLayout;
        } else {
            layout = this.mOffLayout;
        }
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.mTextColors;
            if (colorStateList != null) {
                this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i17 + i18) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        if (isChecked()) {
            charSequence = this.mTextOn;
        } else {
            charSequence = this.mTextOff;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(text);
            sb5.append(TokenParser.SP);
            sb5.append(charSequence);
            accessibilityNodeInfo.setText(sb5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        int width;
        int i26;
        int i27;
        int i28;
        int i29;
        super.onLayout(z16, i3, i16, i17, i18);
        int i36 = 0;
        if (this.mThumbDrawable != null) {
            Rect rect = this.mTempRect;
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
            i19 = Math.max(0, opticalBounds.left - rect.left);
            i36 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            i19 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            i26 = getPaddingLeft() + i19;
            width = ((this.mSwitchWidth + i26) - i19) - i36;
        } else {
            width = (getWidth() - getPaddingRight()) - i36;
            i26 = (width - this.mSwitchWidth) + i19 + i36;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                i28 = getPaddingTop();
                i27 = this.mSwitchHeight;
            } else {
                i29 = getHeight() - getPaddingBottom();
                i28 = i29 - this.mSwitchHeight;
                this.mSwitchLeft = i26;
                this.mSwitchTop = i28;
                this.mSwitchBottom = i29;
                this.mSwitchRight = width;
            }
        } else {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i27 = this.mSwitchHeight;
            i28 = paddingTop - (i27 / 2);
        }
        i29 = i27 + i28;
        this.mSwitchLeft = i26;
        this.mSwitchTop = i28;
        this.mSwitchBottom = i29;
        this.mSwitchRight = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = makeLayout(this.mTextOn);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = makeLayout(this.mTextOff);
            }
        }
        Rect rect = this.mTempRect;
        Drawable drawable = this.mThumbDrawable;
        int i26 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i17 = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
            i18 = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            i17 = 0;
            i18 = 0;
        }
        if (this.mShowText) {
            i19 = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2);
        } else {
            i19 = 0;
        }
        this.mThumbWidth = Math.max(i19, i17);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i26 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i27 = rect.left;
        int i28 = rect.right;
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable3);
            i27 = Math.max(i27, opticalBounds.left);
            i28 = Math.max(i28, opticalBounds.right);
        }
        int max = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + i27 + i28);
        int max2 = Math.max(i26, i18);
        this.mSwitchWidth = max;
        this.mSwitchHeight = max2;
        super.onMeasure(i3, i16);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.mTextOn;
        } else {
            charSequence = this.mTextOff;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r0 != 3) goto L44;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f16;
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i3 = this.mTouchMode;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            float x16 = motionEvent.getX();
                            int thumbScrollRange = getThumbScrollRange();
                            float f17 = x16 - this.mTouchX;
                            if (thumbScrollRange != 0) {
                                f16 = f17 / thumbScrollRange;
                            } else if (f17 > 0.0f) {
                                f16 = 1.0f;
                            } else {
                                f16 = -1.0f;
                            }
                            if (ViewUtils.isLayoutRtl(this)) {
                                f16 = -f16;
                            }
                            float constrain = constrain(this.mThumbPosition + f16, 0.0f, 1.0f);
                            if (constrain != this.mThumbPosition) {
                                this.mTouchX = x16;
                                setThumbPosition(constrain);
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
                super.onTouchEvent(motionEvent);
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
        float f16;
        super.setChecked(z16);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
            animateThumbToCheckedState(isChecked);
            return;
        }
        cancelPositionAnimator();
        if (isChecked) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        setThumbPosition(f16);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setShowText(boolean z16) {
        if (this.mShowText != z16) {
            this.mShowText = z16;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z16) {
        this.mSplitTrack = z16;
        invalidate();
    }

    public void setSwitchMinWidth(int i3) {
        this.mSwitchMinWidth = i3;
        requestLayout();
    }

    public void setSwitchPadding(int i3) {
        this.mSwitchPadding = i3;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i3) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i3, androidx.appcompat.R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.mTextColors = colorStateList;
        } else {
            this.mTextColors = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0) {
            float f16 = dimensionPixelSize;
            if (f16 != this.mTextPaint.getTextSize()) {
                this.mTextPaint.setTextSize(f16);
                requestLayout();
            }
        }
        setSwitchTypefaceByIndex(obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
            this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
        } else {
            this.mSwitchTransformationMethod = null;
        }
        obtainStyledAttributes.recycle();
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
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f16) {
        this.mThumbPosition = f16;
        invalidate();
    }

    public void setThumbResource(int i3) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), i3));
    }

    public void setThumbTextPadding(int i3) {
        this.mThumbTextPadding = i3;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i3) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), i3));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.mTrackTintList = colorStateList;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.mTrackTintMode = mode;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mThumbDrawable && drawable != this.mTrackDrawable) {
            return false;
        }
        return true;
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.s_);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = androidx.appcompat.R.styleable.SwitchCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i3, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i3, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_android_thumb);
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.SwitchCompat_track);
        this.mTrackDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.mTextOn = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOn);
        this.mTextOff = obtainStyledAttributes.getText(androidx.appcompat.R.styleable.SwitchCompat_android_textOff);
        this.mShowText = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.mThumbTintList = colorStateList;
            this.mHasThumbTint = true;
        }
        PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.mThumbTintMode != parseTintMode) {
            this.mThumbTintMode = parseTintMode;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(androidx.appcompat.R.styleable.SwitchCompat_trackTint);
        if (colorStateList2 != null) {
            this.mTrackTintList = colorStateList2;
            this.mHasTrackTint = true;
        }
        PorterDuff.Mode parseTintMode2 = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.mTrackTintMode != parseTintMode2) {
            this.mTrackTintMode = parseTintMode2;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int resourceId = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, i3);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.mTextPaint.getTypeface() == null || this.mTextPaint.getTypeface().equals(typeface)) && (this.mTextPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        this.mTextPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }
}
