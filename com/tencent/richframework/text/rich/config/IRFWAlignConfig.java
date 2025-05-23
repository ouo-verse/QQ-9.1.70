package com.tencent.richframework.text.rich.config;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRFWAlignConfig {
    void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Drawable drawable);

    int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, Drawable drawable);

    void setDesiredSize(int i3, int i16);
}
