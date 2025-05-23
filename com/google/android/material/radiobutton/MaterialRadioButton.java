package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.internal.o;
import g1.c;
import z0.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* renamed from: f, reason: collision with root package name */
    private static final int f34012f = 2131953434;

    /* renamed from: h, reason: collision with root package name */
    private static final int[][] f34013h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private ColorStateList f34014d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34015e;

    public MaterialRadioButton(@NonNull Context context) {
        this(context, null);
    }

    private ColorStateList a() {
        if (this.f34014d == null) {
            int d16 = a.d(this, com.tencent.mobileqq.R.attr.a7o);
            int d17 = a.d(this, com.tencent.mobileqq.R.attr.f155473a82);
            int d18 = a.d(this, com.tencent.mobileqq.R.attr.a8g);
            int[][] iArr = f34013h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = a.h(d18, d16, 1.0f);
            iArr2[1] = a.h(d18, d17, 0.54f);
            iArr2[2] = a.h(d18, d17, 0.38f);
            iArr2[3] = a.h(d18, d17, 0.38f);
            this.f34014d = new ColorStateList(iArr, iArr2);
        }
        return this.f34014d;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f34015e && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z16) {
        this.f34015e = z16;
        if (z16) {
            CompoundButtonCompat.setButtonTintList(this, a());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.b5h);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = f34012f;
        Context context2 = getContext();
        TypedArray h16 = o.h(context2, attributeSet, w0.a.f443886g5, i3, i16, new int[0]);
        int i17 = w0.a.f443898h5;
        if (h16.hasValue(i17)) {
            CompoundButtonCompat.setButtonTintList(this, c.a(context2, h16, i17));
        }
        this.f34015e = h16.getBoolean(w0.a.f443909i5, false);
        h16.recycle();
    }
}
