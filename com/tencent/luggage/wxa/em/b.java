package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.ic.l;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public t f124924b;

    /* renamed from: d, reason: collision with root package name */
    public String f124926d;

    /* renamed from: g, reason: collision with root package name */
    public l f124929g;

    /* renamed from: h, reason: collision with root package name */
    public String f124930h;

    /* renamed from: i, reason: collision with root package name */
    public long f124931i;

    /* renamed from: j, reason: collision with root package name */
    public long f124932j;

    /* renamed from: a, reason: collision with root package name */
    public int f124923a = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public Pair f124925c = new Pair(-1L, -1L);

    /* renamed from: e, reason: collision with root package name */
    public long f124927e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f124928f = -1;

    public final int a() {
        return this.f124923a;
    }

    public final void b(long j3) {
        this.f124927e = j3;
    }

    public final long c() {
        return this.f124931i;
    }

    public final t d() {
        return this.f124924b;
    }

    public String toString() {
        return "AppBrandWorkerInfo(id=" + this.f124923a + ", workerEngine=" + this.f124924b + ", engineCreateTimestamp=" + this.f124925c + ", createFailErrorMsg=" + this.f124926d + ", jsInjectCost=" + this.f124927e + ", startInject=" + this.f124928f + ", service=" + this.f124929g + ')';
    }

    public final void a(int i3) {
        this.f124923a = i3;
    }

    public final void b(String str) {
        this.f124930h = str;
    }

    public final void c(long j3) {
        this.f124931i = j3;
    }

    public final void d(long j3) {
        this.f124928f = j3;
    }

    public final void a(t tVar) {
        this.f124924b = tVar;
    }

    public final long b() {
        return this.f124932j;
    }

    public final void a(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        this.f124925c = pair;
    }

    public final void a(String str) {
        this.f124926d = str;
    }

    public final void a(l lVar) {
        this.f124929g = lVar;
    }

    public final void a(long j3) {
        this.f124932j = j3;
    }
}
