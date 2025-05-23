package com.tencent.luggage.wxa.o8;

import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public float f136199a;

    /* renamed from: b, reason: collision with root package name */
    public float f136200b;

    /* renamed from: c, reason: collision with root package name */
    public int f136201c;

    /* renamed from: d, reason: collision with root package name */
    public int f136202d;

    /* renamed from: e, reason: collision with root package name */
    public float f136203e;

    /* renamed from: f, reason: collision with root package name */
    public int f136204f;

    /* renamed from: g, reason: collision with root package name */
    public int f136205g;

    public a(float f16, float f17, int i3, int i16, float f18, int i17, int i18) {
        this.f136199a = f16;
        this.f136200b = f17;
        this.f136201c = i3;
        this.f136202d = i16;
        this.f136203e = f18;
        this.f136204f = i17;
        this.f136205g = i18;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Float.compare(this.f136199a, aVar.f136199a) == 0 && Float.compare(this.f136200b, aVar.f136200b) == 0 && this.f136201c == aVar.f136201c && this.f136202d == aVar.f136202d && Float.compare(this.f136203e, aVar.f136203e) == 0 && this.f136204f == aVar.f136204f && this.f136205g == aVar.f136205g) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((Float.floatToIntBits(this.f136199a) * 31) + Float.floatToIntBits(this.f136200b)) * 31) + this.f136201c) * 31) + this.f136202d) * 31) + Float.floatToIntBits(this.f136203e)) * 31) + this.f136204f) * 31) + this.f136205g;
    }

    public String toString() {
        String format = String.format(Locale.ENGLISH, "fps(%.2f, %.2f, %d, %d, %.2f%%)", Arrays.copyOf(new Object[]{Float.valueOf(this.f136199a), Float.valueOf(this.f136200b), Integer.valueOf(this.f136201c), Integer.valueOf(this.f136202d), Float.valueOf(this.f136203e * 100)}, 5));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public a() {
        this(0.0f, 0.0f, 0, 0, 0.0f, 0, 0);
    }
}
