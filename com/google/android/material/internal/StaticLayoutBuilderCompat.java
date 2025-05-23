package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
final class StaticLayoutBuilderCompat {

    /* renamed from: n, reason: collision with root package name */
    static final int f33771n = 1;

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f33772a;

    /* renamed from: b, reason: collision with root package name */
    private final TextPaint f33773b;

    /* renamed from: c, reason: collision with root package name */
    private final int f33774c;

    /* renamed from: e, reason: collision with root package name */
    private int f33776e;

    /* renamed from: l, reason: collision with root package name */
    private boolean f33783l;

    /* renamed from: d, reason: collision with root package name */
    private int f33775d = 0;

    /* renamed from: f, reason: collision with root package name */
    private Layout.Alignment f33777f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g, reason: collision with root package name */
    private int f33778g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private float f33779h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f33780i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private int f33781j = f33771n;

    /* renamed from: k, reason: collision with root package name */
    private boolean f33782k = true;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private TextUtils.TruncateAt f33784m = null;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th5) {
            super("Error thrown initializing StaticLayout " + th5.getMessage(), th5);
        }
    }

    StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i3) {
        this.f33772a = charSequence;
        this.f33773b = textPaint;
        this.f33774c = i3;
        this.f33776e = charSequence.length();
    }

    @NonNull
    public static StaticLayoutBuilderCompat b(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i3) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i3);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        TextDirectionHeuristic textDirectionHeuristic;
        if (this.f33772a == null) {
            this.f33772a = "";
        }
        int max = Math.max(0, this.f33774c);
        CharSequence charSequence = this.f33772a;
        if (this.f33778g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f33773b, max, this.f33784m);
        }
        int min = Math.min(charSequence.length(), this.f33776e);
        this.f33776e = min;
        if (this.f33783l && this.f33778g == 1) {
            this.f33777f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f33775d, min, this.f33773b, max);
        obtain.setAlignment(this.f33777f);
        obtain.setIncludePad(this.f33782k);
        if (this.f33783l) {
            textDirectionHeuristic = TextDirectionHeuristics.RTL;
        } else {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        }
        obtain.setTextDirection(textDirectionHeuristic);
        TextUtils.TruncateAt truncateAt = this.f33784m;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f33778g);
        float f16 = this.f33779h;
        if (f16 != 0.0f || this.f33780i != 1.0f) {
            obtain.setLineSpacing(f16, this.f33780i);
        }
        if (this.f33778g > 1) {
            obtain.setHyphenationFrequency(this.f33781j);
        }
        return obtain.build();
    }

    @NonNull
    public StaticLayoutBuilderCompat c(@NonNull Layout.Alignment alignment) {
        this.f33777f = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat d(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f33784m = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat e(int i3) {
        this.f33781j = i3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat f(boolean z16) {
        this.f33782k = z16;
        return this;
    }

    public StaticLayoutBuilderCompat g(boolean z16) {
        this.f33783l = z16;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat h(float f16, float f17) {
        this.f33779h = f16;
        this.f33780i = f17;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat i(@IntRange(from = 0) int i3) {
        this.f33778g = i3;
        return this;
    }
}
