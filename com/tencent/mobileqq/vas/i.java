package com.tencent.mobileqq.vas;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i extends ReplacementSpan {

    /* renamed from: d, reason: collision with root package name */
    public int f309559d;

    /* renamed from: e, reason: collision with root package name */
    public int f309560e;

    public i(int i3, int i16) {
        this.f309559d = i3;
        this.f309560e = i16;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return 0;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
    }
}
