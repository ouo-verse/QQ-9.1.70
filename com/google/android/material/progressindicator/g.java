package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.b;

/* compiled from: P */
/* loaded from: classes2.dex */
abstract class g<S extends b> {

    /* renamed from: a, reason: collision with root package name */
    S f33983a;

    /* renamed from: b, reason: collision with root package name */
    protected f f33984b;

    public g(S s16) {
        this.f33983a = s16;
    }

    abstract void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17, @ColorInt int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(@NonNull Canvas canvas, @NonNull Paint paint);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@NonNull f fVar) {
        this.f33984b = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.f33983a.e();
        a(canvas, f16);
    }
}
