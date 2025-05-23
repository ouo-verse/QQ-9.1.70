package com.tencent.ecommerce.richtext.ui.dom.style;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public FlexLayoutDirection f105388a;

    /* renamed from: b, reason: collision with root package name */
    public FlexDirection f105389b;

    /* renamed from: c, reason: collision with root package name */
    public FlexJustifyContent f105390c;

    /* renamed from: d, reason: collision with root package name */
    public FlexAlign f105391d;

    /* renamed from: e, reason: collision with root package name */
    public FlexAlign f105392e;

    /* renamed from: f, reason: collision with root package name */
    public FlexAlign f105393f;

    /* renamed from: g, reason: collision with root package name */
    public FlexPositionType f105394g;

    /* renamed from: h, reason: collision with root package name */
    public FlexWrap f105395h;

    /* renamed from: i, reason: collision with root package name */
    public float f105396i;

    /* renamed from: j, reason: collision with root package name */
    public o f105397j = new o();

    /* renamed from: k, reason: collision with root package name */
    public o f105398k = new o();

    /* renamed from: l, reason: collision with root package name */
    public o f105399l = new o();

    /* renamed from: m, reason: collision with root package name */
    public float[] f105400m = new float[4];

    /* renamed from: n, reason: collision with root package name */
    public float[] f105401n = new float[2];

    /* renamed from: o, reason: collision with root package name */
    public float[] f105402o = new float[2];

    /* renamed from: p, reason: collision with root package name */
    public float f105403p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public float f105404q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    public float f105405r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f105406s = Float.NaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k() {
        b();
    }

    public void a(k kVar) {
        this.f105388a = kVar.f105388a;
        this.f105389b = kVar.f105389b;
        this.f105390c = kVar.f105390c;
        this.f105391d = kVar.f105391d;
        this.f105393f = kVar.f105393f;
        this.f105392e = kVar.f105392e;
        this.f105394g = kVar.f105394g;
        this.f105395h = kVar.f105395h;
        this.f105396i = kVar.f105396i;
        this.f105397j = kVar.f105397j;
        this.f105398k = kVar.f105398k;
        this.f105399l = kVar.f105399l;
        float[] fArr = this.f105400m;
        float[] fArr2 = kVar.f105400m;
        fArr[1] = fArr2[1];
        fArr[3] = fArr2[3];
        fArr[0] = fArr2[0];
        fArr[2] = fArr2[2];
        float[] fArr3 = this.f105401n;
        float[] fArr4 = kVar.f105401n;
        fArr3[0] = fArr4[0];
        fArr3[1] = fArr4[1];
        this.f105403p = kVar.f105403p;
        this.f105404q = kVar.f105404q;
        this.f105405r = kVar.f105405r;
        this.f105406s = kVar.f105406s;
        this.f105402o[1] = kVar.f105404q;
    }

    public void b() {
        this.f105388a = FlexLayoutDirection.INHERIT;
        this.f105389b = FlexDirection.COLUMN;
        this.f105390c = FlexJustifyContent.FLEX_START;
        this.f105391d = FlexAlign.FLEX_START;
        this.f105393f = FlexAlign.STRETCH;
        this.f105392e = FlexAlign.AUTO;
        this.f105394g = FlexPositionType.RELATIVE;
        this.f105395h = FlexWrap.NOWRAP;
        this.f105396i = 0.0f;
        this.f105397j.d();
        this.f105398k.d();
        this.f105399l.d();
        Arrays.fill(this.f105400m, Float.NaN);
        Arrays.fill(this.f105401n, Float.NaN);
        Arrays.fill(this.f105402o, Float.NaN);
        this.f105403p = Float.NaN;
        this.f105404q = Float.NaN;
        this.f105405r = Float.NaN;
        this.f105406s = Float.NaN;
    }

    public String toString() {
        return "direction =" + this.f105388a + "\nflexDirection =" + this.f105389b + "\njustifyContent=" + this.f105390c + "\nalignContent =" + this.f105391d + "\nalignItems =" + this.f105393f + "\nalignSelf =" + this.f105392e + "\npositionType =" + this.f105394g + "\nflexWrap =" + this.f105395h + "\nflex =" + this.f105396i + "\nmargin =" + this.f105397j + "\npadding =" + this.f105398k + "\nborder =" + this.f105399l + "\nposition[POSITION_TOP] =" + this.f105400m[1] + "\nposition[POSITION_BOTTOM] =" + this.f105400m[3] + "\nposition[POSITION_LEFT] =" + this.f105400m[0] + "\nposition[POSITION_RIGHT] =" + this.f105400m[2] + "\nposition[DIMENSION_WIDTH] =" + this.f105400m[0] + "\nposition[DIMENSION_HEIGHT] =" + this.f105400m[1] + "\nminWidth =" + this.f105403p + "\nminHeight =" + this.f105404q + "\nmaxWidth =" + this.f105405r + "\nmaxHeight =" + this.f105406s + "\n";
    }
}
