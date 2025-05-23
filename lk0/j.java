package lk0;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j implements LineHeightSpan {

    /* renamed from: d, reason: collision with root package name */
    private int f414952d;

    public j(int i3) {
        this.f414952d = i3;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i3, int i16, int i17, int i18, Paint.FontMetricsInt fontMetricsInt) {
        int i19 = this.f414952d;
        int i26 = fontMetricsInt.descent;
        int i27 = fontMetricsInt.ascent;
        int i28 = (i19 - (i26 - i27)) / 2;
        fontMetricsInt.top -= i28;
        fontMetricsInt.bottom += i28;
        fontMetricsInt.ascent = i27 - i28;
        fontMetricsInt.descent = i26 + i28;
    }
}
