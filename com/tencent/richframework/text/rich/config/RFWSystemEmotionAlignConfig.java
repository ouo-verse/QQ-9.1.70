package com.tencent.richframework.text.rich.config;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWSystemEmotionAlignConfig extends RFWBaseEmotionAlignConfig {
    @Override // com.tencent.richframework.text.rich.config.RFWBaseEmotionAlignConfig
    public int getCustomSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt, int i17, int i18) {
        if (fontMetricsInt != null) {
            int i19 = fontMetricsInt.descent;
            int i26 = fontMetricsInt.ascent;
            if (i19 - i26 < i18) {
                int i27 = i26 + i19;
                fontMetricsInt.ascent = (i27 - i18) >> 1;
                fontMetricsInt.descent = (i27 + i18) >> 1;
            }
        }
        return i17;
    }

    @Override // com.tencent.richframework.text.rich.config.RFWBaseEmotionAlignConfig
    public int getTransY(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint, Paint.FontMetricsInt fontMetricsInt, int i26, int i27) {
        int i28 = fontMetricsInt.descent;
        return (((i18 - i27) + i28) - ((i28 - fontMetricsInt.ascent) >> 1)) + (i27 >> 1);
    }
}
