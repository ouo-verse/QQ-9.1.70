package com.tencent.richframework.text.rich.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.richframework.text.rich.config.IRFWAlignConfig;
import com.tencent.richframework.text.rich.config.RFWSystemEmotionAlignConfig;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWSystemEmotionSpan extends EmoticonSpan {
    private final IRFWAlignConfig alignConfig;

    public RFWSystemEmotionSpan(int i3, int i16, int i17) {
        super(i3, i16, i17);
        RFWSystemEmotionAlignConfig rFWSystemEmotionAlignConfig = new RFWSystemEmotionAlignConfig();
        this.alignConfig = rFWSystemEmotionAlignConfig;
        rFWSystemEmotionAlignConfig.setDesiredSize(i16, i16);
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        this.alignConfig.draw(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint, getDrawable());
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        return this.alignConfig.getSize(paint, charSequence, i3, i16, fontMetricsInt, getDrawable());
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan
    public void setSize(int i3) {
        super.setSize(i3);
        this.alignConfig.setDesiredSize(i3, i3);
    }
}
