package com.tencent.luggage.wxa.bh;

import android.os.Handler;
import com.tencent.luggage.wxa.l0.d;
import com.tencent.luggage.wxa.l0.j;
import com.tencent.luggage.wxa.l0.u;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements d, u {

    /* renamed from: j, reason: collision with root package name */
    public static final C6067a f122702j = new C6067a(null);

    /* renamed from: k, reason: collision with root package name */
    public static final int f122703k = 2000;

    /* renamed from: l, reason: collision with root package name */
    public static final long f122704l = 2000;

    /* renamed from: m, reason: collision with root package name */
    public static final long f122705m = 524288;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f122706a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.c f122707b;

    /* renamed from: c, reason: collision with root package name */
    public final b f122708c;

    /* renamed from: d, reason: collision with root package name */
    public int f122709d;

    /* renamed from: e, reason: collision with root package name */
    public long f122710e;

    /* renamed from: f, reason: collision with root package name */
    public long f122711f;

    /* renamed from: g, reason: collision with root package name */
    public long f122712g;

    /* renamed from: h, reason: collision with root package name */
    public long f122713h;

    /* renamed from: i, reason: collision with root package name */
    public long f122714i;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bh.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6067a {
        public C6067a() {
        }

        public /* synthetic */ C6067a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a() {
        this(null, null, 0, null, 15, null);
    }

    public final void a(int i3, long j3, long j16) {
    }

    public final void b() {
        this.f122714i = -1L;
    }

    public a(Handler handler, d.a aVar, int i3, com.tencent.luggage.wxa.n0.c clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.f122706a = handler;
        this.f122707b = clock;
        this.f122708c = new b(i3);
        this.f122714i = -1L;
    }

    @Override // com.tencent.luggage.wxa.l0.d
    public synchronized long a() {
        return this.f122714i;
    }

    @Override // com.tencent.luggage.wxa.l0.u
    public synchronized void a(Object source, j dataSpec) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
        if (this.f122709d == 0) {
            this.f122710e = this.f122707b.a();
        }
        this.f122709d++;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(Handler handler, d.a aVar, int i3, com.tencent.luggage.wxa.n0.c DEFAULT, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, aVar, i3, DEFAULT);
        handler = (i16 & 1) != 0 ? null : handler;
        aVar = (i16 & 2) != 0 ? null : aVar;
        i3 = (i16 & 4) != 0 ? f122703k : i3;
        if ((i16 & 8) != 0) {
            DEFAULT = com.tencent.luggage.wxa.n0.c.f135052a;
            Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        }
    }

    @Override // com.tencent.luggage.wxa.l0.u
    public synchronized void a(Object source, int i3) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f122711f += i3;
    }

    @Override // com.tencent.luggage.wxa.l0.u
    public synchronized void a(Object source) {
        long j3;
        Intrinsics.checkNotNullParameter(source, "source");
        com.tencent.luggage.wxa.n0.a.b(this.f122709d > 0);
        long a16 = this.f122707b.a();
        int i3 = (int) (a16 - this.f122710e);
        long j16 = i3;
        this.f122712g += j16;
        long j17 = this.f122713h;
        long j18 = this.f122711f;
        this.f122713h = j17 + j18;
        if (i3 > 0) {
            this.f122708c.a((int) Math.sqrt(j18), (float) ((8000 * j18) / j16));
            if (this.f122712g >= f122704l || this.f122713h >= f122705m) {
                float b16 = this.f122708c.b();
                if (!Float.isNaN(b16) && b16 >= 0.0f) {
                    j3 = b16;
                    this.f122714i = j3;
                }
                j3 = -1;
                this.f122714i = j3;
            }
        }
        a(i3, this.f122711f, this.f122714i);
        int i16 = this.f122709d - 1;
        this.f122709d = i16;
        if (i16 > 0) {
            this.f122710e = a16;
        }
        this.f122711f = 0L;
    }
}
