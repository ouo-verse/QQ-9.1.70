package com.qq.e.comm.plugin.base.ad.definition;

import com.qq.e.comm.plugin.base.ad.b;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f38755a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f38756b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f38757c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f38758d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f38759e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f38760f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f38761g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f38762h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f38763i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f38764j;

    /* renamed from: n, reason: collision with root package name */
    private static final /* synthetic */ a[] f38765n;

    /* renamed from: k, reason: collision with root package name */
    private b f38766k;

    /* renamed from: l, reason: collision with root package name */
    private int f38767l;

    /* renamed from: m, reason: collision with root package name */
    private int f38768m;

    static {
        b bVar = b.BANNER;
        a aVar = new a("BANNER_240", 0, bVar, 240, 38);
        f38755a = aVar;
        a aVar2 = new a("BANNER_320", 1, bVar, 320, 50);
        f38756b = aVar2;
        a aVar3 = new a("BANNER_480", 2, bVar, 480, 75);
        f38757c = aVar3;
        a aVar4 = new a("BANNER_640", 3, bVar, 640, 100);
        f38758d = aVar4;
        b bVar2 = b.INTERSTITIAL;
        a aVar5 = new a("INTERSTITIAL_300", 4, bVar2, 300, 250);
        f38759e = aVar5;
        a aVar6 = new a("INTERSTITIAL_600", 5, bVar2, 600, 500);
        f38760f = aVar6;
        a aVar7 = new a("APPWALL_72", 6, b.APP_WALL, 72, 72);
        f38761g = aVar7;
        b bVar3 = b.SPLASH;
        a aVar8 = new a("SPLASH_320", 7, bVar3, 320, 480);
        f38762h = aVar8;
        a aVar9 = new a("SPLASH_640", 8, bVar3, 640, 960);
        f38763i = aVar9;
        a aVar10 = new a("FEEDS_1000", 9, b.FEEDS, 1000, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA);
        f38764j = aVar10;
        f38765n = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10};
    }

    a(String str, int i3, b bVar, int i16, int i17) {
        this.f38766k = bVar;
        this.f38767l = i16;
        this.f38768m = i17;
    }

    public int a() {
        return this.f38767l;
    }

    public int b() {
        return this.f38768m;
    }
}
