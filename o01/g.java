package o01;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f421677a;

    /* renamed from: b, reason: collision with root package name */
    public final int f421678b;

    /* renamed from: c, reason: collision with root package name */
    public final int f421679c;

    /* renamed from: d, reason: collision with root package name */
    public final int f421680d;

    /* renamed from: e, reason: collision with root package name */
    public final h f421681e;

    /* renamed from: f, reason: collision with root package name */
    public final int f421682f;

    /* renamed from: g, reason: collision with root package name */
    public final int f421683g;

    /* renamed from: h, reason: collision with root package name */
    public final g f421684h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f421685i;

    public g(boolean z16, int i3, int i16, int i17, h hVar, int i18, int i19, g gVar) {
        this.f421677a = z16;
        this.f421678b = i3;
        this.f421679c = i16;
        this.f421680d = i17;
        this.f421681e = hVar;
        this.f421682f = i18;
        this.f421683g = i19;
        this.f421684h = gVar;
    }

    public final int hashCode() {
        return (((((this.f421678b * 31) + this.f421679c) * 31) + this.f421682f) * 31) + this.f421683g;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("QRCodeSquare(dark=");
        m3.append(this.f421677a);
        m3.append(", row=");
        m3.append(this.f421678b);
        m3.append(", col=");
        m3.append(this.f421679c);
        m3.append(", moduleSize=");
        m3.append(this.f421680d);
        m3.append(", squareInfo=");
        m3.append(this.f421681e);
        m3.append(", rowSize=");
        m3.append(this.f421682f);
        m3.append(", colSize=");
        m3.append(this.f421683g);
        m3.append(", parent=");
        m3.append(this.f421684h);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(g.class), Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        g gVar = (g) obj;
        return this.f421678b == gVar.f421678b && this.f421679c == gVar.f421679c && this.f421682f == gVar.f421682f && this.f421683g == gVar.f421683g;
    }

    public /* synthetic */ g(boolean z16, int i3, int i16, int i17, h hVar, int i18, int i19, g gVar, int i26) {
        this(z16, i3, i16, i17, (i26 & 16) != 0 ? new h(4, 11) : hVar, (i26 & 32) != 0 ? 1 : i18, (i26 & 64) != 0 ? 1 : i19, (i26 & 128) != 0 ? null : gVar);
    }
}
