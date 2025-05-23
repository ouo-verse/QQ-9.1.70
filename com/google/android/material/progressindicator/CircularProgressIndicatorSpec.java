package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;

/* loaded from: classes2.dex */
public final class CircularProgressIndicatorSpec extends b {

    /* renamed from: g, reason: collision with root package name */
    @Px
    public int f33944g;

    /* renamed from: h, reason: collision with root package name */
    @Px
    public int f33945h;

    /* renamed from: i, reason: collision with root package name */
    public int f33946i;

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.a6h);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        this(context, attributeSet, i3, CircularProgressIndicator.L);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.cv8);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.f159182cv3);
        TypedArray h16 = o.h(context, attributeSet, w0.a.L1, i3, i16, new int[0]);
        this.f33944g = Math.max(g1.c.d(context, h16, w0.a.O1, dimensionPixelSize), this.f33950a * 2);
        this.f33945h = g1.c.d(context, h16, w0.a.N1, dimensionPixelSize2);
        this.f33946i = h16.getInt(w0.a.M1, 0);
        h16.recycle();
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.b
    public void e() {
    }
}
