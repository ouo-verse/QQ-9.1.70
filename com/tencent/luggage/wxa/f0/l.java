package com.tencent.luggage.wxa.f0;

import android.text.TextUtils;
import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.s;
import com.tencent.luggage.wxa.q.k;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements com.tencent.luggage.wxa.q.d {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f125181g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f125182h = Pattern.compile("MPEGTS:(\\d+)");

    /* renamed from: a, reason: collision with root package name */
    public final String f125183a;

    /* renamed from: b, reason: collision with root package name */
    public final s f125184b;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.f f125186d;

    /* renamed from: f, reason: collision with root package name */
    public int f125188f;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f125185c = new com.tencent.luggage.wxa.n0.l();

    /* renamed from: e, reason: collision with root package name */
    public byte[] f125187e = new byte[1024];

    public l(String str, s sVar) {
        this.f125183a = str;
        this.f125184b = sVar;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        throw new IllegalStateException();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(com.tencent.luggage.wxa.q.f fVar) {
        this.f125186d = fVar;
        fVar.a(new k.a(-9223372036854775807L));
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        throw new IllegalStateException();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        int length = (int) eVar.getLength();
        int i3 = this.f125188f;
        byte[] bArr = this.f125187e;
        if (i3 == bArr.length) {
            this.f125187e = Arrays.copyOf(bArr, ((length != -1 ? length : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f125187e;
        int i16 = this.f125188f;
        int read = eVar.read(bArr2, i16, bArr2.length - i16);
        if (read != -1) {
            int i17 = this.f125188f + read;
            this.f125188f = i17;
            if (length == -1 || i17 != length) {
                return 0;
            }
        }
        a();
        return -1;
    }

    public final void a() {
        com.tencent.luggage.wxa.n0.l lVar = new com.tencent.luggage.wxa.n0.l(this.f125187e);
        try {
            com.tencent.luggage.wxa.j0.b.b(lVar);
            long j3 = 0;
            long j16 = 0;
            while (true) {
                String g16 = lVar.g();
                if (!TextUtils.isEmpty(g16)) {
                    if (g16.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = f125181g.matcher(g16);
                        if (matcher.find()) {
                            Matcher matcher2 = f125182h.matcher(g16);
                            if (matcher2.find()) {
                                j16 = com.tencent.luggage.wxa.j0.b.a(matcher.group(1));
                                j3 = s.c(Long.parseLong(matcher2.group(1)));
                            } else {
                                throw new o("X-TIMESTAMP-MAP doesn't contain media timestamp: " + g16);
                            }
                        } else {
                            throw new o("X-TIMESTAMP-MAP doesn't contain local timestamp: " + g16);
                        }
                    }
                } else {
                    Matcher a16 = com.tencent.luggage.wxa.j0.b.a(lVar);
                    if (a16 == null) {
                        a(0L);
                        return;
                    }
                    long a17 = com.tencent.luggage.wxa.j0.b.a(a16.group(1));
                    long b16 = this.f125184b.b(s.e((j3 + a17) - j16));
                    com.tencent.luggage.wxa.q.l a18 = a(b16 - a17);
                    this.f125185c.a(this.f125187e, this.f125188f);
                    a18.a(this.f125185c, this.f125188f);
                    a18.a(b16, 1, this.f125188f, 0, null);
                    return;
                }
            }
        } catch (com.tencent.luggage.wxa.h0.a e16) {
            throw new o(e16);
        }
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }

    public final com.tencent.luggage.wxa.q.l a(long j3) {
        com.tencent.luggage.wxa.q.l a16 = this.f125186d.a(0, 3);
        a16.a(com.tencent.luggage.wxa.m.j.a((String) null, "text/vtt", (String) null, -1, 0, this.f125183a, (com.tencent.luggage.wxa.p.a) null, j3));
        this.f125186d.e();
        return a16;
    }
}
