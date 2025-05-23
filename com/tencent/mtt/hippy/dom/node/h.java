package com.tencent.mtt.hippy.dom.node;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h extends MetricAffectingSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f337427a;

    /* renamed from: b, reason: collision with root package name */
    private final int f337428b;

    /* renamed from: c, reason: collision with root package name */
    private final String f337429c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<HippyFontScaleAdapter> f337430d;

    public h(int i3, int i16, String str, HippyFontScaleAdapter hippyFontScaleAdapter) {
        this.f337427a = i3;
        this.f337428b = i16;
        this.f337429c = str;
        this.f337430d = new WeakReference<>(hippyFontScaleAdapter);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        TypeFaceUtil.apply(textPaint, this.f337427a, this.f337428b, this.f337429c, this.f337430d.get());
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        TypeFaceUtil.apply(textPaint, this.f337427a, this.f337428b, this.f337429c, this.f337430d.get());
    }
}
