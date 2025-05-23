package com.tencent.luggage.wxa.l0;

import android.net.Uri;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class t implements g {

    /* renamed from: a, reason: collision with root package name */
    public final g f132858a;

    /* renamed from: b, reason: collision with root package name */
    public final f f132859b;

    public t(g gVar, f fVar) {
        this.f132858a = (g) com.tencent.luggage.wxa.n0.a.a(gVar);
        this.f132859b = (f) com.tencent.luggage.wxa.n0.a.a(fVar);
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public long a(j jVar) {
        long a16 = this.f132858a.a(jVar);
        if (jVar.f132786e == -1 && a16 != -1) {
            jVar = new j(jVar.f132782a, jVar.f132784c, jVar.f132785d, a16, jVar.f132787f, jVar.f132788g);
        }
        this.f132859b.a(jVar);
        return a16;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public void close() {
        try {
            this.f132858a.close();
        } finally {
            this.f132859b.close();
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public Uri getUri() {
        return this.f132858a.getUri();
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public int read(byte[] bArr, int i3, int i16) {
        int read = this.f132858a.read(bArr, i3, i16);
        if (read > 0) {
            this.f132859b.write(bArr, i3, read);
        }
        return read;
    }
}
