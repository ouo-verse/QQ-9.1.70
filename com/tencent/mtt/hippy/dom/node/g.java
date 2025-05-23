package com.tencent.mtt.hippy.dom.node;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g extends CharacterStyle {

    /* renamed from: a, reason: collision with root package name */
    private final float f337423a;

    /* renamed from: b, reason: collision with root package name */
    private final float f337424b;

    /* renamed from: c, reason: collision with root package name */
    private final float f337425c;

    /* renamed from: d, reason: collision with root package name */
    private final int f337426d;

    public g(float f16, float f17, float f18, int i3) {
        this.f337423a = f16;
        this.f337424b = f17;
        this.f337425c = f18;
        this.f337426d = i3;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setShadowLayer(this.f337425c, this.f337423a, this.f337424b, this.f337426d);
    }
}
