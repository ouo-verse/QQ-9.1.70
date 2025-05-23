package com.tencent.luggage.wxa.x;

import android.util.Log;
import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import com.tencent.luggage.wxa.q.e;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class c {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f144440a;

        /* renamed from: b, reason: collision with root package name */
        public final long f144441b;

        public a(int i3, long j3) {
            this.f144440a = i3;
            this.f144441b = j3;
        }

        public static a a(e eVar, l lVar) {
            eVar.b(lVar.f135088a, 0, 8);
            lVar.e(0);
            return new a(lVar.f(), lVar.j());
        }
    }

    public static b a(e eVar) {
        com.tencent.luggage.wxa.n0.a.a(eVar);
        l lVar = new l(16);
        if (a.a(eVar, lVar).f144440a != v.b("RIFF")) {
            return null;
        }
        eVar.b(lVar.f135088a, 0, 4);
        lVar.e(0);
        int f16 = lVar.f();
        if (f16 != v.b("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + f16);
            return null;
        }
        a a16 = a.a(eVar, lVar);
        while (a16.f144440a != v.b("fmt ")) {
            eVar.a((int) a16.f144441b);
            a16 = a.a(eVar, lVar);
        }
        com.tencent.luggage.wxa.n0.a.b(a16.f144441b >= 16);
        eVar.b(lVar.f135088a, 0, 16);
        lVar.e(0);
        int l3 = lVar.l();
        int l16 = lVar.l();
        int k3 = lVar.k();
        int k16 = lVar.k();
        int l17 = lVar.l();
        int l18 = lVar.l();
        int i3 = (l16 * l18) / 8;
        if (l17 == i3) {
            int b16 = v.b(l18);
            if (b16 == 0) {
                Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + l18);
                return null;
            }
            if (l3 != 1 && l3 != 65534) {
                Log.e("WavHeaderReader", "Unsupported WAV format type: " + l3);
                return null;
            }
            eVar.a(((int) a16.f144441b) - 16);
            return new b(l16, k3, k16, l17, l18, b16);
        }
        throw new o("Expected block alignment: " + i3 + "; got: " + l17);
    }

    public static void a(e eVar, b bVar) {
        com.tencent.luggage.wxa.n0.a.a(eVar);
        com.tencent.luggage.wxa.n0.a.a(bVar);
        eVar.a();
        l lVar = new l(8);
        a a16 = a.a(eVar, lVar);
        while (a16.f144440a != v.b("data")) {
            Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a16.f144440a);
            long j3 = a16.f144441b + 8;
            if (a16.f144440a == v.b("RIFF")) {
                j3 = 12;
            }
            if (j3 <= TTL.MAX_VALUE) {
                eVar.c((int) j3);
                a16 = a.a(eVar, lVar);
            } else {
                throw new o("Chunk is too large (~2GB+) to skip; id: " + a16.f144440a);
            }
        }
        eVar.c(8);
        bVar.a(eVar.getPosition(), a16.f144441b);
    }
}
