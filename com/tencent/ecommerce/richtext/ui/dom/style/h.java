package com.tencent.ecommerce.richtext.ui.dom.style;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public float[] f105381a = new float[4];

    /* renamed from: b, reason: collision with root package name */
    public float[] f105382b = new float[2];

    /* renamed from: c, reason: collision with root package name */
    public FlexLayoutDirection f105383c = FlexLayoutDirection.LTR;

    public void a(h hVar) {
        float[] fArr = this.f105381a;
        float[] fArr2 = hVar.f105381a;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = fArr2[3];
        float[] fArr3 = this.f105382b;
        float[] fArr4 = hVar.f105382b;
        fArr3[0] = fArr4[0];
        fArr3[1] = fArr4[1];
        this.f105383c = hVar.f105383c;
    }

    public void b() {
        Arrays.fill(this.f105381a, 0.0f);
        Arrays.fill(this.f105382b, Float.NaN);
        this.f105383c = FlexLayoutDirection.LTR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (l.a(hVar.f105381a[0], this.f105381a[0]) && l.a(hVar.f105381a[1], this.f105381a[1]) && l.a(hVar.f105381a[2], this.f105381a[2]) && l.a(hVar.f105381a[3], this.f105381a[3]) && l.a(hVar.f105382b[1], this.f105382b[1]) && l.a(hVar.f105382b[0], this.f105382b[0])) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "layout: {left: " + this.f105381a[0] + ", top: " + this.f105381a[1] + ", width: " + this.f105382b[0] + ", height: " + this.f105382b[1] + ", direction: " + this.f105383c + "}";
    }
}
