package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.internal.o;
import com.tencent.mobileqq.R;

/* loaded from: classes2.dex */
public final class LinearProgressIndicatorSpec extends b {

    /* renamed from: g, reason: collision with root package name */
    public int f33947g;

    /* renamed from: h, reason: collision with root package name */
    public int f33948h;

    /* renamed from: i, reason: collision with root package name */
    boolean f33949i;

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.arb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.b
    public void e() {
        if (this.f33947g == 0) {
            if (this.f33951b <= 0) {
                if (this.f33952c.length < 3) {
                    throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
                }
                return;
            }
            throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
        }
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        this(context, attributeSet, i3, LinearProgressIndicator.L);
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        super(context, attributeSet, i3, i16);
        TypedArray h16 = o.h(context, attributeSet, w0.a.J3, R.attr.arb, LinearProgressIndicator.L, new int[0]);
        this.f33947g = h16.getInt(w0.a.K3, 1);
        this.f33948h = h16.getInt(w0.a.L3, 0);
        h16.recycle();
        e();
        this.f33949i = this.f33948h == 1;
    }
}
