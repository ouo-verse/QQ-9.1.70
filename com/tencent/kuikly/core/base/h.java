package com.tencent.kuikly.core.base;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000bB\t\b\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0013B\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0016B)\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/kuikly/core/base/h;", "", "", "toString", "other", "", "equals", "", com.tencent.luggage.wxa.c8.c.f123400v, DomainData.DOMAIN_NAME, "", "a", "J", "hexColor", "b", "Ljava/lang/String;", "colorString", "<init>", "()V", "(J)V", "alpha01", "(JF)V", "(Ljava/lang/String;)V", "", "red255", "green255", "blue255", "(IIIF)V", "c", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final h f117174d;

    /* renamed from: e, reason: collision with root package name */
    private static final h f117175e;

    /* renamed from: f, reason: collision with root package name */
    private static final h f117176f;

    /* renamed from: g, reason: collision with root package name */
    private static final h f117177g;

    /* renamed from: h, reason: collision with root package name */
    private static final h f117178h;

    /* renamed from: i, reason: collision with root package name */
    private static final h f117179i;

    /* renamed from: j, reason: collision with root package name */
    private static final h f117180j;

    /* renamed from: k, reason: collision with root package name */
    private static final h f117181k;

    /* renamed from: l, reason: collision with root package name */
    private static final h f117182l;

    /* renamed from: m, reason: collision with root package name */
    private static final h f117183m;

    /* renamed from: n, reason: collision with root package name */
    private static final h f117184n;

    /* renamed from: o, reason: collision with root package name */
    private static final h f117185o;

    /* renamed from: p, reason: collision with root package name */
    private static final h f117186p;

    /* renamed from: q, reason: collision with root package name */
    private static final h f117187q;

    /* renamed from: r, reason: collision with root package name */
    private static final h f117188r;

    /* renamed from: s, reason: collision with root package name */
    private static final h f117189s;

    /* renamed from: t, reason: collision with root package name */
    private static final h f117190t;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long hexColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String colorString;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0017\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u001b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\u001d\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000eR\u0017\u0010\u001f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010\u000eR\u0017\u0010!\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u000eR\u0017\u0010#\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b$\u0010\u000eR\u0017\u0010%\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b&\u0010\u000e\u00a8\u0006)"}, d2 = {"Lcom/tencent/kuikly/core/base/h$a;", "", "", "colorString", "", "o", "", "alpha01", "Lcom/tencent/kuikly/core/base/h;", "a", "p", "BLACK", "Lcom/tencent/kuikly/core/base/h;", "b", "()Lcom/tencent/kuikly/core/base/h;", "BLUE", "c", "RED", "i", "GREEN", "f", "WHITE", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "TRANSPARENT", "j", "TRANSPARENT_WHITE", "k", "GRAY", "e", "Black", "d", "Green", tl.h.F, "White", DomainData.DOMAIN_NAME, "Transparent", "l", "Gray", "g", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.h$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h a(float alpha01) {
            return new h(0, 0, 0, alpha01);
        }

        public final h b() {
            return h.f117174d;
        }

        public final h c() {
            return h.f117175e;
        }

        public final h d() {
            return h.f117183m;
        }

        public final h e() {
            return h.f117182l;
        }

        public final h f() {
            return h.f117177g;
        }

        public final h g() {
            return h.f117190t;
        }

        public final h h() {
            return h.f117186p;
        }

        public final h i() {
            return h.f117176f;
        }

        public final h j() {
            return h.f117180j;
        }

        public final h k() {
            return h.f117181k;
        }

        public final h l() {
            return h.f117189s;
        }

        public final h m() {
            return h.f117178h;
        }

        public final h n() {
            return h.f117187q;
        }

        public final long o(String colorString) {
            Intrinsics.checkNotNullParameter(colorString, "colorString");
            try {
                return com.tencent.kuikly.core.utils.a.f118267a.b(colorString);
            } catch (Exception unused) {
                return 4278190335L;
            }
        }

        public final h p(float alpha01) {
            return new h(255, 255, 255, alpha01);
        }

        Companion() {
        }
    }

    static {
        h hVar = new h(4278190080L);
        f117174d = hVar;
        h hVar2 = new h(4278190335L);
        f117175e = hVar2;
        h hVar3 = new h(4294901760L);
        f117176f = hVar3;
        h hVar4 = new h(4278255360L);
        f117177g = hVar4;
        h hVar5 = new h(4294967295L);
        f117178h = hVar5;
        h hVar6 = new h(4294967040L);
        f117179i = hVar6;
        h hVar7 = new h(0L);
        f117180j = hVar7;
        f117181k = new h(255, 255, 255, 0.0f);
        h hVar8 = new h(4288256409L);
        f117182l = hVar8;
        f117183m = hVar;
        f117184n = hVar2;
        f117185o = hVar3;
        f117186p = hVar4;
        f117187q = hVar5;
        f117188r = hVar6;
        f117189s = hVar7;
        f117190t = hVar8;
    }

    public h() {
        this.colorString = "";
    }

    public final h n(float alpha) {
        return new h(this.hexColor, alpha);
    }

    public String toString() {
        String str = this.colorString;
        return str.length() == 0 ? String.valueOf(this.hexColor) : str;
    }

    public h(long j3) {
        this.colorString = "";
        this.hexColor = j3;
    }

    public h(long j3, float f16) {
        this.colorString = "";
        this.hexColor = Long.parseLong(i.a((int) (f16 * 255)) + i.b((16711680 & j3) >> 16) + i.b((65280 & j3) >> 8) + i.b(j3 & 255), CharsKt.checkRadix(16));
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof h)) {
            return false;
        }
        h hVar = (h) other;
        return Intrinsics.areEqual(this.colorString, hVar.colorString) && this.hexColor == hVar.hexColor;
    }

    public h(String colorString) {
        Intrinsics.checkNotNullParameter(colorString, "colorString");
        this.colorString = colorString;
    }

    public h(int i3, int i16, int i17, float f16) {
        this.colorString = "";
        this.hexColor = Long.parseLong(i.a((int) (f16 * 255)) + i.a(i3) + i.a(i16) + i.a(i17), CharsKt.checkRadix(16));
    }
}
