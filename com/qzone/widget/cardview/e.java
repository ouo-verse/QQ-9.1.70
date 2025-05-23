package com.qzone.widget.cardview;

import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes37.dex */
class e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    static final double f60729a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(float f16, float f17, boolean z16) {
        return z16 ? (float) (f16 + ((1.0d - f60729a) * f17)) : f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(float f16, float f17, boolean z16) {
        return z16 ? (float) ((f16 * 1.5f) + ((1.0d - f60729a) * f17)) : f16 * 1.5f;
    }
}
