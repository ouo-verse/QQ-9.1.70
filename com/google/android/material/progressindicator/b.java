package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    @Px
    public int f33950a;

    /* renamed from: b, reason: collision with root package name */
    @Px
    public int f33951b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public int[] f33952c = new int[0];

    /* renamed from: d, reason: collision with root package name */
    @ColorInt
    public int f33953d;

    /* renamed from: e, reason: collision with root package name */
    public int f33954e;

    /* renamed from: f, reason: collision with root package name */
    public int f33955f;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.cvd);
        TypedArray h16 = o.h(context, attributeSet, w0.a.Q, i3, i16, new int[0]);
        this.f33950a = g1.c.d(context, h16, w0.a.Y, dimensionPixelSize);
        this.f33951b = Math.min(g1.c.d(context, h16, w0.a.X, 0), this.f33950a / 2);
        this.f33954e = h16.getInt(w0.a.U, 0);
        this.f33955f = h16.getInt(w0.a.R, 0);
        c(context, h16);
        d(context, h16);
        h16.recycle();
    }

    private void c(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i3 = w0.a.S;
        if (!typedArray.hasValue(i3)) {
            this.f33952c = new int[]{z0.a.b(context, R.attr.a88, -1)};
            return;
        }
        if (typedArray.peekValue(i3).type != 1) {
            this.f33952c = new int[]{typedArray.getColor(i3, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i3, -1));
        this.f33952c = intArray;
        if (intArray.length != 0) {
        } else {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    private void d(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i3 = w0.a.W;
        if (typedArray.hasValue(i3)) {
            this.f33953d = typedArray.getColor(i3, -1);
            return;
        }
        this.f33953d = this.f33952c[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float f16 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f33953d = z0.a.a(this.f33953d, (int) (f16 * 255.0f));
    }

    public boolean a() {
        if (this.f33955f != 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f33954e != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();
}
