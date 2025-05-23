package com.tencent.smtt.flexbox;

import com.tencent.mtt.hippy.dom.flex.d;
import com.tencent.mtt.hippy.dom.flex.e;
import com.tencent.mtt.hippy.dom.flex.h;
import com.tencent.mtt.hippy.dom.flex.i;
import com.tencent.mtt.hippy.dom.flex.j;
import com.tencent.smtt.flexbox.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FlexNodeStyle {

    /* renamed from: a, reason: collision with root package name */
    private long f368899a;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mtt.hippy.dom.flex.b f368901c;

    /* renamed from: d, reason: collision with root package name */
    private e f368902d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mtt.hippy.dom.flex.a f368903e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mtt.hippy.dom.flex.a f368904f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mtt.hippy.dom.flex.a f368905g;

    /* renamed from: h, reason: collision with root package name */
    private i f368906h;

    /* renamed from: i, reason: collision with root package name */
    private j f368907i;

    /* renamed from: j, reason: collision with root package name */
    private h f368908j;

    /* renamed from: k, reason: collision with root package name */
    private a f368909k;

    /* renamed from: m, reason: collision with root package name */
    private float f368911m;

    /* renamed from: p, reason: collision with root package name */
    private final float[] f368914p;

    /* renamed from: q, reason: collision with root package name */
    private final float[] f368915q;

    /* renamed from: r, reason: collision with root package name */
    private final float[] f368916r;

    /* renamed from: s, reason: collision with root package name */
    private final float[] f368917s;

    /* renamed from: t, reason: collision with root package name */
    private float f368918t;

    /* renamed from: u, reason: collision with root package name */
    private float f368919u;

    /* renamed from: v, reason: collision with root package name */
    private float f368920v;

    /* renamed from: w, reason: collision with root package name */
    private float f368921w;

    /* renamed from: x, reason: collision with root package name */
    private float f368922x;

    /* renamed from: y, reason: collision with root package name */
    private float f368923y;

    /* renamed from: b, reason: collision with root package name */
    private d f368900b = d.LTR;

    /* renamed from: l, reason: collision with root package name */
    private float f368910l = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f368912n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    private float f368913o = 0.0f;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum a {
        DISPLAY_FLEX,
        DISPLAY_NONE
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public enum b {
        EDGE_LEFT,
        EDGE_TOP,
        EDGE_RIGHT,
        EDGE_BOTTOM,
        EDGE_START,
        EDGE_END,
        EDGE_HORIZONTAL,
        EDGE_VERTICAL,
        EDGE_ALL;

        public static b a(int i3) {
            switch (i3) {
                case 0:
                    return EDGE_LEFT;
                case 1:
                    return EDGE_TOP;
                case 2:
                    return EDGE_RIGHT;
                case 3:
                    return EDGE_BOTTOM;
                case 4:
                    return EDGE_START;
                case 5:
                    return EDGE_END;
                case 6:
                    return EDGE_HORIZONTAL;
                case 7:
                    return EDGE_VERTICAL;
                case 8:
                    return EDGE_ALL;
                default:
                    throw new IllegalArgumentException("Unknown enum value: " + i3);
            }
        }
    }

    public FlexNodeStyle(long j3) {
        this.f368899a = 0L;
        b bVar = b.EDGE_ALL;
        this.f368914p = new float[bVar.ordinal() + 1];
        this.f368915q = new float[bVar.ordinal() + 1];
        this.f368916r = new float[bVar.ordinal() + 1];
        this.f368917s = new float[bVar.ordinal() + 1];
        this.f368918t = 0.0f;
        this.f368919u = 0.0f;
        long nativeFlexNodeStyleNew = nativeFlexNodeStyleNew();
        this.f368899a = nativeFlexNodeStyleNew;
        if (nativeFlexNodeStyleNew != 0) {
            nativeSetFlexNode(nativeFlexNodeStyleNew, j3);
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    private native void nativeFlexNodeStyleFree(long j3);

    private native int nativeFlexNodeStyleGetAlignContent(long j3);

    private native int nativeFlexNodeStyleGetAlignItems(long j3);

    private native int nativeFlexNodeStyleGetAlignSelf(long j3);

    private native float nativeFlexNodeStyleGetAspectRatio(long j3);

    private native Object nativeFlexNodeStyleGetBorder(long j3, int i3);

    private native int nativeFlexNodeStyleGetDirection(long j3);

    private native int nativeFlexNodeStyleGetDisplay(long j3);

    private native float nativeFlexNodeStyleGetFlex(long j3);

    private native Object nativeFlexNodeStyleGetFlexBasis(long j3);

    private native int nativeFlexNodeStyleGetFlexDirection(long j3);

    private native float nativeFlexNodeStyleGetFlexGrow(long j3);

    private native float nativeFlexNodeStyleGetFlexShrink(long j3);

    private native int nativeFlexNodeStyleGetFlexWrap(long j3);

    private native Object nativeFlexNodeStyleGetHeight(long j3);

    private native int nativeFlexNodeStyleGetJustifyContent(long j3);

    private native Object nativeFlexNodeStyleGetMargin(long j3, int i3);

    private native Object nativeFlexNodeStyleGetMaxHeight(long j3);

    private native Object nativeFlexNodeStyleGetMaxWidth(long j3);

    private native Object nativeFlexNodeStyleGetMinHeight(long j3);

    private native Object nativeFlexNodeStyleGetMinWidth(long j3);

    private native int nativeFlexNodeStyleGetOverflow(long j3);

    private native Object nativeFlexNodeStyleGetPadding(long j3, int i3);

    private native Object nativeFlexNodeStyleGetPosition(long j3, int i3);

    private native int nativeFlexNodeStyleGetPositionType(long j3);

    private native Object nativeFlexNodeStyleGetWidth(long j3);

    private native long nativeFlexNodeStyleNew();

    private native void nativeFlexNodeStyleSetAlignContent(long j3, int i3);

    private native void nativeFlexNodeStyleSetAlignItems(long j3, int i3);

    private native void nativeFlexNodeStyleSetAlignSelf(long j3, int i3);

    private native void nativeFlexNodeStyleSetAspectRatio(long j3, float f16);

    private native void nativeFlexNodeStyleSetBorder(long j3, int i3, float f16);

    private native void nativeFlexNodeStyleSetDirection(long j3, int i3);

    private native void nativeFlexNodeStyleSetDisplay(long j3, int i3);

    private native void nativeFlexNodeStyleSetFlex(long j3, float f16);

    private native void nativeFlexNodeStyleSetFlexBasis(long j3, float f16);

    private native void nativeFlexNodeStyleSetFlexBasisAuto(long j3);

    private native void nativeFlexNodeStyleSetFlexBasisPercent(long j3, float f16);

    private native void nativeFlexNodeStyleSetFlexDirection(long j3, int i3);

    private native void nativeFlexNodeStyleSetFlexGrow(long j3, float f16);

    private native void nativeFlexNodeStyleSetFlexShrink(long j3, float f16);

    private native void nativeFlexNodeStyleSetFlexWrap(long j3, int i3);

    private native void nativeFlexNodeStyleSetHeight(long j3, float f16);

    private native void nativeFlexNodeStyleSetHeightAuto(long j3);

    private native void nativeFlexNodeStyleSetHeightPercent(long j3, float f16);

    private native void nativeFlexNodeStyleSetJustifyContent(long j3, int i3);

    private native void nativeFlexNodeStyleSetMargin(long j3, int i3, float f16);

    private native void nativeFlexNodeStyleSetMarginAuto(long j3, int i3);

    private native void nativeFlexNodeStyleSetMarginPercent(long j3, int i3, float f16);

    private native void nativeFlexNodeStyleSetMaxHeight(long j3, float f16);

    private native void nativeFlexNodeStyleSetMaxHeightPercent(long j3, float f16);

    private native void nativeFlexNodeStyleSetMaxWidth(long j3, float f16);

    private native void nativeFlexNodeStyleSetMaxWidthPercent(long j3, float f16);

    private native void nativeFlexNodeStyleSetMinHeight(long j3, float f16);

    private native void nativeFlexNodeStyleSetMinHeightPercent(long j3, float f16);

    private native void nativeFlexNodeStyleSetMinWidth(long j3, float f16);

    private native void nativeFlexNodeStyleSetMinWidthPercent(long j3, float f16);

    private native void nativeFlexNodeStyleSetOverflow(long j3, int i3);

    private native void nativeFlexNodeStyleSetPadding(long j3, int i3, float f16);

    private native void nativeFlexNodeStyleSetPaddingPercent(long j3, int i3, float f16);

    private native void nativeFlexNodeStyleSetPosition(long j3, int i3, float f16);

    private native void nativeFlexNodeStyleSetPositionPercent(long j3, int i3, float f16);

    private native void nativeFlexNodeStyleSetPositionType(long j3, int i3);

    private native void nativeFlexNodeStyleSetWidth(long j3, float f16);

    private native void nativeFlexNodeStyleSetWidthAuto(long j3);

    private native void nativeFlexNodeStyleSetWidthPercent(long j3, float f16);

    private native void nativeSetFlexNode(long j3, long j16);

    public d a() {
        return this.f368900b;
    }

    public com.tencent.mtt.hippy.dom.flex.b b() {
        return this.f368901c;
    }

    public e c() {
        return this.f368902d;
    }

    public com.tencent.mtt.hippy.dom.flex.a d() {
        return this.f368903e;
    }

    public com.tencent.mtt.hippy.dom.flex.a e() {
        return this.f368904f;
    }

    public com.tencent.mtt.hippy.dom.flex.a f() {
        return this.f368905g;
    }

    protected void finalize() throws Throwable {
        try {
            nativeFlexNodeStyleFree(this.f368899a);
        } finally {
            super.finalize();
        }
    }

    public i g() {
        return this.f368906h;
    }

    public j h() {
        return this.f368907i;
    }

    public h i() {
        return this.f368908j;
    }

    public float j() {
        return this.f368911m;
    }

    public float k() {
        return this.f368912n;
    }

    public com.tencent.smtt.flexbox.a l() {
        return new com.tencent.smtt.flexbox.a(this.f368913o, a.EnumC9794a.POINT);
    }

    public com.tencent.smtt.flexbox.a m() {
        return new com.tencent.smtt.flexbox.a(this.f368918t, a.EnumC9794a.POINT);
    }

    public com.tencent.smtt.flexbox.a n() {
        return new com.tencent.smtt.flexbox.a(this.f368919u, a.EnumC9794a.POINT);
    }

    public com.tencent.smtt.flexbox.a o() {
        return new com.tencent.smtt.flexbox.a(this.f368920v, a.EnumC9794a.POINT);
    }

    public com.tencent.smtt.flexbox.a p() {
        return new com.tencent.smtt.flexbox.a(this.f368921w, a.EnumC9794a.POINT);
    }

    public com.tencent.smtt.flexbox.a q() {
        return new com.tencent.smtt.flexbox.a(this.f368922x, a.EnumC9794a.POINT);
    }

    public com.tencent.smtt.flexbox.a r() {
        return new com.tencent.smtt.flexbox.a(this.f368923y, a.EnumC9794a.POINT);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("style: {");
        sb5.append("flex-direction: " + b().toString().toLowerCase() + ", ");
        if (j() != 0.0f) {
            sb5.append("flex-grow: " + j() + ", ");
        }
        if (l().a() != Float.NaN) {
            sb5.append("flex-basis: " + l().a() + ", ");
        }
        if (k() != 0.0f) {
            sb5.append("flex-shrink: " + k() + ", ");
        }
        if (c() != e.FLEX_START) {
            sb5.append("justifycontent: " + c().toString().toLowerCase() + ", ");
        }
        if (f() != com.tencent.mtt.hippy.dom.flex.a.FLEX_START) {
            sb5.append("aligncontent: " + f().toString().toLowerCase() + ", ");
        }
        if (d() != com.tencent.mtt.hippy.dom.flex.a.STRETCH) {
            sb5.append("alignitems: " + d().toString().toLowerCase() + ", ");
        }
        if (e() != com.tencent.mtt.hippy.dom.flex.a.AUTO) {
            sb5.append("alignself: " + e().toString().toLowerCase() + ", ");
        }
        if (h() != j.NOWRAP) {
            sb5.append("wrap: " + h().toString().toLowerCase() + ", ");
        }
        if (i() != h.VISIBLE) {
            sb5.append("overflow: " + i().toString().toLowerCase() + ", ");
        }
        if (g() != i.RELATIVE) {
            sb5.append("positionType: " + g().toString().toLowerCase() + ", ");
        }
        if (m().a() != 0.0f) {
            sb5.append("width: " + m().a() + ", ");
        }
        if (n().a() != 0.0f) {
            sb5.append("height: " + n().a() + ", ");
        }
        if (q().a() != 0.0f) {
            sb5.append("max-width: " + q().a() + ", ");
        }
        if (r().a() != 0.0f) {
            sb5.append("max-height: " + r().a() + ", ");
        }
        if (o().a() != 0.0f) {
            sb5.append("min-height: " + o().a() + ", ");
        }
        if (p().a() != 0.0f) {
            sb5.append("min-height: " + p().a() + ", ");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public com.tencent.smtt.flexbox.a a(b bVar) {
        return new com.tencent.smtt.flexbox.a(this.f368914p[bVar.ordinal()], a.EnumC9794a.POINT);
    }

    public com.tencent.smtt.flexbox.a b(b bVar) {
        return new com.tencent.smtt.flexbox.a(this.f368915q[bVar.ordinal()], a.EnumC9794a.POINT);
    }

    public com.tencent.smtt.flexbox.a c(b bVar) {
        return new com.tencent.smtt.flexbox.a(this.f368916r[bVar.ordinal()], a.EnumC9794a.POINT);
    }

    public com.tencent.smtt.flexbox.a d(b bVar) {
        return new com.tencent.smtt.flexbox.a(this.f368917s[bVar.ordinal()], a.EnumC9794a.POINT);
    }

    public void e(float f16) {
        this.f368918t = f16;
        nativeFlexNodeStyleSetWidth(this.f368899a, f16);
    }

    public void f(float f16) {
        this.f368919u = f16;
        nativeFlexNodeStyleSetHeight(this.f368899a, f16);
    }

    public void g(float f16) {
        this.f368920v = f16;
        nativeFlexNodeStyleSetMinWidth(this.f368899a, f16);
    }

    public void h(float f16) {
        this.f368921w = f16;
        nativeFlexNodeStyleSetMinHeight(this.f368899a, f16);
    }

    public void i(float f16) {
        this.f368922x = f16;
        nativeFlexNodeStyleSetMaxWidth(this.f368899a, f16);
    }

    public void j(float f16) {
        this.f368923y = f16;
        nativeFlexNodeStyleSetMaxHeight(this.f368899a, f16);
    }

    public void a(float f16) {
        this.f368910l = f16;
        nativeFlexNodeStyleSetFlex(this.f368899a, f16);
    }

    public void b(float f16) {
        this.f368911m = f16;
        nativeFlexNodeStyleSetFlexGrow(this.f368899a, f16);
    }

    public void c(float f16) {
        this.f368912n = f16;
        nativeFlexNodeStyleSetFlexShrink(this.f368899a, f16);
    }

    public void d(float f16) {
        this.f368913o = f16;
        nativeFlexNodeStyleSetFlexBasis(this.f368899a, f16);
    }

    public void a(com.tencent.mtt.hippy.dom.flex.a aVar) {
        this.f368903e = aVar;
        nativeFlexNodeStyleSetAlignItems(this.f368899a, aVar.ordinal());
    }

    public void b(com.tencent.mtt.hippy.dom.flex.a aVar) {
        this.f368904f = aVar;
        nativeFlexNodeStyleSetAlignSelf(this.f368899a, aVar.ordinal());
    }

    public void c(com.tencent.mtt.hippy.dom.flex.a aVar) {
        this.f368905g = aVar;
        nativeFlexNodeStyleSetAlignContent(this.f368899a, aVar.ordinal());
    }

    public void d(b bVar, float f16) {
        this.f368917s[bVar.ordinal()] = f16;
        nativeFlexNodeStyleSetPosition(this.f368899a, bVar.ordinal(), f16);
    }

    public void a(com.tencent.mtt.hippy.dom.flex.b bVar) {
        this.f368901c = bVar;
        nativeFlexNodeStyleSetFlexDirection(this.f368899a, bVar.ordinal());
    }

    public void b(b bVar, float f16) {
        this.f368915q[bVar.ordinal()] = f16;
        nativeFlexNodeStyleSetPadding(this.f368899a, bVar.ordinal(), f16);
    }

    public void c(b bVar, float f16) {
        this.f368916r[bVar.ordinal()] = f16;
        nativeFlexNodeStyleSetBorder(this.f368899a, bVar.ordinal(), f16);
    }

    public void a(d dVar) {
        this.f368900b = dVar;
        nativeFlexNodeStyleSetDirection(this.f368899a, dVar.ordinal());
    }

    public void a(e eVar) {
        int ordinal = eVar.ordinal();
        this.f368902d = eVar;
        nativeFlexNodeStyleSetJustifyContent(this.f368899a, ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? ordinal != 5 ? 1 : 8 : 7 : 6 : 3 : 2);
    }

    public void a(h hVar) {
        this.f368908j = hVar;
        nativeFlexNodeStyleSetOverflow(this.f368899a, hVar.ordinal());
    }

    public void a(i iVar) {
        this.f368906h = iVar;
        nativeFlexNodeStyleSetPositionType(this.f368899a, iVar.ordinal());
    }

    public void a(j jVar) {
        this.f368907i = jVar;
        nativeFlexNodeStyleSetFlexWrap(this.f368899a, jVar.ordinal());
    }

    public void a(a aVar) {
        this.f368909k = aVar;
        nativeFlexNodeStyleSetDisplay(this.f368899a, aVar.ordinal());
    }

    public void a(b bVar, float f16) {
        this.f368914p[bVar.ordinal()] = f16;
        nativeFlexNodeStyleSetMargin(this.f368899a, bVar.ordinal(), f16);
    }
}
