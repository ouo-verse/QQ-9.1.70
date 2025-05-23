package com.tencent.luggage.wxa.qg;

import android.os.Handler;
import com.tencent.luggage.wxa.qg.b;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements b {

    /* renamed from: g, reason: collision with root package name */
    public static int f138711g;

    /* renamed from: h, reason: collision with root package name */
    public static long f138712h;

    /* renamed from: i, reason: collision with root package name */
    public static long f138713i;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f138714a;

    /* renamed from: b, reason: collision with root package name */
    public final c f138715b;

    /* renamed from: c, reason: collision with root package name */
    public final p f138716c;

    /* renamed from: d, reason: collision with root package name */
    public long f138717d;

    /* renamed from: e, reason: collision with root package name */
    public long f138718e;

    /* renamed from: f, reason: collision with root package name */
    public int f138719f;

    public h(Handler handler, b.a aVar) {
        this(handler, aVar, new q());
    }

    public final void a(int i3, long j3, long j16) {
    }

    @Override // com.tencent.luggage.wxa.qg.s
    public synchronized void onTransferEnd() {
        boolean z16;
        long j3;
        if (this.f138719f > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.tg.a.b(z16);
        long a16 = this.f138715b.a();
        int i3 = (int) (a16 - this.f138718e);
        f138711g = i3;
        if (i3 > 0) {
            long j16 = this.f138717d;
            this.f138716c.a((int) Math.sqrt(j16), (float) ((8000 * j16) / i3));
            float a17 = this.f138716c.a(0.5f);
            if (Float.isNaN(a17)) {
                j3 = -1;
            } else {
                j3 = a17;
            }
            long j17 = j3;
            f138712h = j17;
            f138713i = j17;
            a(f138711g, this.f138717d, j17);
        }
        int i16 = this.f138719f - 1;
        this.f138719f = i16;
        if (i16 > 0) {
            this.f138718e = a16;
        }
        this.f138717d = 0L;
    }

    @Override // com.tencent.luggage.wxa.qg.s
    public synchronized void onTransferStart() {
        if (this.f138719f == 0) {
            this.f138718e = this.f138715b.a();
        }
        this.f138719f++;
    }

    public h(Handler handler, b.a aVar, c cVar) {
        this(handler, aVar, cVar, 2000);
    }

    @Override // com.tencent.luggage.wxa.qg.s
    public synchronized void a(int i3) {
        this.f138717d += i3;
    }

    public h(Handler handler, b.a aVar, c cVar, int i3) {
        this.f138714a = handler;
        this.f138715b = cVar;
        this.f138716c = new p(i3);
        f138712h = -1L;
    }
}
