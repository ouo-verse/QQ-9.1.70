package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.graphics.Paint;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final Paint f239244a;

    /* renamed from: c, reason: collision with root package name */
    private float f239246c;

    /* renamed from: d, reason: collision with root package name */
    private float f239247d;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Character, Float> f239245b = new HashMap(256);

    /* renamed from: e, reason: collision with root package name */
    private int f239248e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Paint paint) {
        this.f239244a = paint;
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.f239247d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.f239246c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c(char c16) {
        if (c16 == 0) {
            return 0.0f;
        }
        Float f16 = this.f239245b.get(Character.valueOf(c16));
        if (f16 != null) {
            return f16.floatValue();
        }
        float measureText = this.f239244a.measureText(Character.toString(c16));
        this.f239245b.put(Character.valueOf(c16), Float.valueOf(measureText));
        return measureText;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f239248e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f239245b.clear();
        Paint.FontMetrics fontMetrics = this.f239244a.getFontMetrics();
        float f16 = fontMetrics.bottom;
        float f17 = fontMetrics.top;
        this.f239246c = f16 - f17;
        this.f239247d = -f17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i3) {
        this.f239248e = i3;
    }
}
