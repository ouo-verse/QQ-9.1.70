package com.tencent.luggage.wxa.qg;

import android.net.Uri;
import com.tencent.luggage.wxa.qg.l;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n extends j {
    public static int A = 3;
    public static boolean B;

    /* renamed from: x, reason: collision with root package name */
    public com.tencent.luggage.wxa.rg.l f138764x;

    /* renamed from: y, reason: collision with root package name */
    public int f138765y;

    /* renamed from: z, reason: collision with root package name */
    public String f138766z;

    public n(String str, com.tencent.luggage.wxa.tg.i iVar, s sVar, com.tencent.luggage.wxa.rg.c cVar, com.tencent.luggage.wxa.tg.e eVar, com.tencent.luggage.wxa.rg.l lVar) {
        super(str, iVar, sVar, 30000, 12000, true, eVar);
        this.f138765y = 0;
        this.f138764x = lVar;
        if (!B) {
            A = com.tencent.luggage.wxa.og.a.a().h();
            B = true;
        }
    }

    @Override // com.tencent.luggage.wxa.qg.j, com.tencent.luggage.wxa.qg.e
    public long a(g gVar) {
        this.f138766z = gVar.f138709g;
        try {
            return super.a(gVar);
        } catch (l.a e16) {
            return a(gVar, (String) null, e16);
        }
    }

    @Override // com.tencent.luggage.wxa.qg.j, com.tencent.luggage.wxa.qg.e
    public int read(byte[] bArr, int i3, int i16) {
        try {
            return super.read(bArr, i3, i16);
        } catch (l.a e16) {
            return a(bArr, i3, i16, e16);
        }
    }

    public final long a(g gVar, String str, l.a aVar) {
        int i3 = aVar instanceof l.f ? ((l.f) aVar).f138762b : 0;
        String uri = gVar.f138703a.toString();
        com.tencent.luggage.wxa.tg.h.a(4, i(), "retryOpen url=" + uri + " with responseCode=" + i3);
        if (Thread.currentThread().isInterrupted()) {
            throw aVar;
        }
        if (A > 0) {
            com.tencent.luggage.wxa.tg.h.a(4, i(), "httpRetryLogic is null");
            throw aVar;
        }
        throw aVar;
    }

    public final int a(byte[] bArr, int i3, int i16, l.a aVar) {
        com.tencent.luggage.wxa.tg.h.a(4, i(), "read source error occurred " + aVar.toString());
        this.f138765y = this.f138765y + 1;
        long d16 = h().f138705c + d();
        int i17 = this.f138765y * 2000;
        com.tencent.luggage.wxa.tg.h.a(4, i(), "retrying after " + i17 + " ms, read start at offset " + d16 + " retry " + this.f138765y + "/" + A);
        try {
            LockMethodProxy.sleep(i17);
            g gVar = new g(Uri.parse(getUri()), 0L, d16, -1L, null, 0, this.f138766z, h().f138710h);
            if (Thread.currentThread().isInterrupted()) {
                throw aVar;
            }
            if (this.f138765y < A) {
                if (!this.f138764x.w()) {
                    a(gVar);
                    return read(bArr, i3, i16);
                }
                com.tencent.luggage.wxa.tg.h.a(4, i(), "abort retry videoRequest is cancelling " + this.f138764x);
                throw new l.c("readRetry interrupted " + this.f138764x, h());
            }
            throw aVar;
        } catch (InterruptedException unused) {
            com.tencent.luggage.wxa.tg.h.a(5, i(), "readRetry interrupted");
            throw aVar;
        }
    }
}
