package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor == null) {
            this.mFixedHeightMajor = new TypedValue();
        }
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor == null) {
            this.mFixedHeightMinor = new TypedValue();
        }
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor == null) {
            this.mFixedWidthMajor = new TypedValue();
        }
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor == null) {
            this.mFixedWidthMinor = new TypedValue();
        }
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor == null) {
            this.mMinWidthMajor = new TypedValue();
        }
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor == null) {
            this.mMinWidthMinor = new TypedValue();
        }
        return this.mMinWidthMinor;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onAttachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        boolean z16;
        boolean z17;
        int measuredWidth;
        TypedValue typedValue;
        int i17;
        int i18;
        float fraction;
        TypedValue typedValue2;
        int i19;
        int i26;
        float fraction2;
        TypedValue typedValue3;
        int i27;
        int i28;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z18 = true;
        if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
            z16 = true;
        } else {
            z16 = false;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (mode == Integer.MIN_VALUE) {
            if (z16) {
                typedValue3 = this.mFixedWidthMinor;
            } else {
                typedValue3 = this.mFixedWidthMajor;
            }
            if (typedValue3 != null && (i27 = typedValue3.type) != 0) {
                if (i27 == 5) {
                    fraction3 = typedValue3.getDimension(displayMetrics);
                } else if (i27 == 6) {
                    int i29 = displayMetrics.widthPixels;
                    fraction3 = typedValue3.getFraction(i29, i29);
                } else {
                    i28 = 0;
                    if (i28 > 0) {
                        Rect rect = this.mDecorPadding;
                        i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i28 - (rect.left + rect.right), View.MeasureSpec.getSize(i3)), 1073741824);
                        z17 = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            if (z16) {
                                typedValue2 = this.mFixedHeightMajor;
                            } else {
                                typedValue2 = this.mFixedHeightMinor;
                            }
                            if (typedValue2 != null && (i19 = typedValue2.type) != 0) {
                                if (i19 == 5) {
                                    fraction2 = typedValue2.getDimension(displayMetrics);
                                } else if (i19 == 6) {
                                    int i36 = displayMetrics.heightPixels;
                                    fraction2 = typedValue2.getFraction(i36, i36);
                                } else {
                                    i26 = 0;
                                    if (i26 > 0) {
                                        Rect rect2 = this.mDecorPadding;
                                        i16 = View.MeasureSpec.makeMeasureSpec(Math.min(i26 - (rect2.top + rect2.bottom), View.MeasureSpec.getSize(i16)), 1073741824);
                                    }
                                }
                                i26 = (int) fraction2;
                                if (i26 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i3, i16);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z17 && mode == Integer.MIN_VALUE) {
                            if (!z16) {
                                typedValue = this.mMinWidthMinor;
                            } else {
                                typedValue = this.mMinWidthMajor;
                            }
                            if (typedValue != null && (i17 = typedValue.type) != 0) {
                                if (i17 != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (i17 == 6) {
                                    int i37 = displayMetrics.widthPixels;
                                    fraction = typedValue.getFraction(i37, i37);
                                } else {
                                    i18 = 0;
                                    if (i18 > 0) {
                                        Rect rect3 = this.mDecorPadding;
                                        i18 -= rect3.left + rect3.right;
                                    }
                                    if (measuredWidth < i18) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                                        if (z18) {
                                            super.onMeasure(makeMeasureSpec, i16);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i18 = (int) fraction;
                                if (i18 > 0) {
                                }
                                if (measuredWidth < i18) {
                                }
                            }
                        }
                        z18 = false;
                        if (z18) {
                        }
                    }
                }
                i28 = (int) fraction3;
                if (i28 > 0) {
                }
            }
        }
        z17 = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i3, i16);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z17) {
            if (!z16) {
            }
            if (typedValue != null) {
                if (i17 != 5) {
                }
                i18 = (int) fraction;
                if (i18 > 0) {
                }
                if (measuredWidth < i18) {
                }
            }
        }
        z18 = false;
        if (z18) {
        }
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.mAttachListener = onAttachListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDecorPadding(int i3, int i16, int i17, int i18) {
        this.mDecorPadding.set(i3, i16, i17, i18);
        if (ViewCompat.isLaidOut(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mDecorPadding = new Rect();
    }
}
