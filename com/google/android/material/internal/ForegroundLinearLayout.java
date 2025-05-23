package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.LinearLayoutCompat;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private Drawable f33758d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f33759e;

    /* renamed from: f, reason: collision with root package name */
    private final Rect f33760f;

    /* renamed from: h, reason: collision with root package name */
    private int f33761h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f33762i;

    /* renamed from: m, reason: collision with root package name */
    boolean f33763m;

    public ForegroundLinearLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f33758d;
        if (drawable != null) {
            if (this.f33763m) {
                this.f33763m = false;
                Rect rect = this.f33759e;
                Rect rect2 = this.f33760f;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f33762i) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f33761h, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    @TargetApi(21)
    public void drawableHotspotChanged(float f16, float f17) {
        super.drawableHotspotChanged(f16, f17);
        Drawable drawable = this.f33758d;
        if (drawable != null) {
            drawable.setHotspot(f16, f17);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f33758d;
        if (drawable != null && drawable.isStateful()) {
            this.f33758d.setState(getDrawableState());
        }
    }

    @Override // android.view.View
    @Nullable
    public Drawable getForeground() {
        return this.f33758d;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.f33761h;
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f33758d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f33763m = z16 | this.f33763m;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f33763m = true;
    }

    @Override // android.view.View
    public void setForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f33758d;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f33758d);
            }
            this.f33758d = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f33761h == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i3) {
        if (this.f33761h != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f33761h = i3;
            if (i3 == 119 && this.f33758d != null) {
                this.f33758d.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f33758d) {
            return false;
        }
        return true;
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f33759e = new Rect();
        this.f33760f = new Rect();
        this.f33761h = 119;
        this.f33762i = true;
        this.f33763m = false;
        TypedArray h16 = o.h(context, attributeSet, w0.a.f443974o3, i3, 0, new int[0]);
        this.f33761h = h16.getInt(w0.a.f443998q3, this.f33761h);
        Drawable drawable = h16.getDrawable(w0.a.f443986p3);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f33762i = h16.getBoolean(w0.a.f444010r3, true);
        h16.recycle();
    }
}
