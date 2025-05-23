package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;
import g1.c;
import z0.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialCheckBox extends AppCompatCheckBox {

    /* renamed from: h, reason: collision with root package name */
    private static final int f33434h = 2131953433;

    /* renamed from: i, reason: collision with root package name */
    private static final int[][] f33435i = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private ColorStateList f33436d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33437e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33438f;

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    private ColorStateList b() {
        if (this.f33436d == null) {
            int[][] iArr = f33435i;
            int[] iArr2 = new int[iArr.length];
            int d16 = a.d(this, com.tencent.mobileqq.R.attr.a7o);
            int d17 = a.d(this, com.tencent.mobileqq.R.attr.a8g);
            int d18 = a.d(this, com.tencent.mobileqq.R.attr.f155473a82);
            iArr2[0] = a.h(d17, d16, 1.0f);
            iArr2[1] = a.h(d17, d18, 0.54f);
            iArr2[2] = a.h(d17, d18, 0.38f);
            iArr2[3] = a.h(d17, d18, 0.38f);
            this.f33436d = new ColorStateList(iArr, iArr2);
        }
        return this.f33436d;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f33437e && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        int i3;
        if (this.f33438f && TextUtils.isEmpty(getText()) && (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this)) != null) {
            if (ViewUtils.i(this)) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * i3;
            int save = canvas.save();
            canvas.translate(width, 0.0f);
            super.onDraw(canvas);
            canvas.restoreToCount(save);
            if (getBackground() != null) {
                Rect bounds = buttonDrawable.getBounds();
                DrawableCompat.setHotspotBounds(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
                return;
            }
            return;
        }
        super.onDraw(canvas);
    }

    public void setCenterIfNoTextEnabled(boolean z16) {
        this.f33438f = z16;
    }

    public void setUseMaterialThemeColors(boolean z16) {
        this.f33437e = z16;
        if (z16) {
            CompoundButtonCompat.setButtonTintList(this, b());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.a5c);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = f33434h;
        Context context2 = getContext();
        TypedArray h16 = o.h(context2, attributeSet, w0.a.W4, i3, i16, new int[0]);
        int i17 = w0.a.X4;
        if (h16.hasValue(i17)) {
            CompoundButtonCompat.setButtonTintList(this, c.a(context2, h16, i17));
        }
        this.f33437e = h16.getBoolean(w0.a.Z4, false);
        this.f33438f = h16.getBoolean(w0.a.Y4, true);
        h16.recycle();
    }
}
