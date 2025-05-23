package com.tencent.luggage.wxa.u;

import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.n0.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f141841a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f141791b = v.b("ftyp");

    /* renamed from: c, reason: collision with root package name */
    public static final int f141793c = v.b("avc1");

    /* renamed from: d, reason: collision with root package name */
    public static final int f141795d = v.b("avc3");

    /* renamed from: e, reason: collision with root package name */
    public static final int f141797e = v.b("hvc1");

    /* renamed from: f, reason: collision with root package name */
    public static final int f141799f = v.b("hev1");

    /* renamed from: g, reason: collision with root package name */
    public static final int f141801g = v.b("s263");

    /* renamed from: h, reason: collision with root package name */
    public static final int f141803h = v.b("d263");

    /* renamed from: i, reason: collision with root package name */
    public static final int f141805i = v.b("mdat");

    /* renamed from: j, reason: collision with root package name */
    public static final int f141807j = v.b("mp4a");

    /* renamed from: k, reason: collision with root package name */
    public static final int f141809k = v.b(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION);

    /* renamed from: l, reason: collision with root package name */
    public static final int f141811l = v.b("wave");

    /* renamed from: m, reason: collision with root package name */
    public static final int f141813m = v.b("lpcm");

    /* renamed from: n, reason: collision with root package name */
    public static final int f141815n = v.b("sowt");

    /* renamed from: o, reason: collision with root package name */
    public static final int f141817o = v.b("ac-3");

    /* renamed from: p, reason: collision with root package name */
    public static final int f141819p = v.b("dac3");

    /* renamed from: q, reason: collision with root package name */
    public static final int f141821q = v.b("ec-3");

    /* renamed from: r, reason: collision with root package name */
    public static final int f141823r = v.b("dec3");

    /* renamed from: s, reason: collision with root package name */
    public static final int f141825s = v.b("dtsc");

    /* renamed from: t, reason: collision with root package name */
    public static final int f141827t = v.b("dtsh");

    /* renamed from: u, reason: collision with root package name */
    public static final int f141829u = v.b("dtsl");

    /* renamed from: v, reason: collision with root package name */
    public static final int f141831v = v.b("dtse");

    /* renamed from: w, reason: collision with root package name */
    public static final int f141833w = v.b("ddts");

    /* renamed from: x, reason: collision with root package name */
    public static final int f141835x = v.b("tfdt");

    /* renamed from: y, reason: collision with root package name */
    public static final int f141837y = v.b("tfhd");

    /* renamed from: z, reason: collision with root package name */
    public static final int f141839z = v.b("trex");
    public static final int A = v.b("trun");
    public static final int B = v.b("sidx");
    public static final int C = v.b("moov");
    public static final int D = v.b("mvhd");
    public static final int E = v.b("trak");
    public static final int F = v.b("mdia");
    public static final int G = v.b("minf");
    public static final int H = v.b("stbl");
    public static final int I = v.b("avcC");
    public static final int J = v.b("hvcC");
    public static final int K = v.b("esds");
    public static final int L = v.b("moof");
    public static final int M = v.b("traf");
    public static final int N = v.b("mvex");
    public static final int O = v.b("mehd");
    public static final int P = v.b("tkhd");
    public static final int Q = v.b("edts");
    public static final int R = v.b("elst");
    public static final int S = v.b("mdhd");
    public static final int T = v.b("hdlr");
    public static final int U = v.b("stsd");
    public static final int V = v.b("pssh");
    public static final int W = v.b("sinf");
    public static final int X = v.b("schm");
    public static final int Y = v.b("schi");
    public static final int Z = v.b("tenc");

    /* renamed from: a0, reason: collision with root package name */
    public static final int f141790a0 = v.b("encv");

    /* renamed from: b0, reason: collision with root package name */
    public static final int f141792b0 = v.b("enca");

    /* renamed from: c0, reason: collision with root package name */
    public static final int f141794c0 = v.b("frma");

    /* renamed from: d0, reason: collision with root package name */
    public static final int f141796d0 = v.b("saiz");

    /* renamed from: e0, reason: collision with root package name */
    public static final int f141798e0 = v.b("saio");

    /* renamed from: f0, reason: collision with root package name */
    public static final int f141800f0 = v.b("sbgp");

    /* renamed from: g0, reason: collision with root package name */
    public static final int f141802g0 = v.b("sgpd");

    /* renamed from: h0, reason: collision with root package name */
    public static final int f141804h0 = v.b("uuid");

    /* renamed from: i0, reason: collision with root package name */
    public static final int f141806i0 = v.b("senc");

    /* renamed from: j0, reason: collision with root package name */
    public static final int f141808j0 = v.b("pasp");

    /* renamed from: k0, reason: collision with root package name */
    public static final int f141810k0 = v.b("TTML");

    /* renamed from: l0, reason: collision with root package name */
    public static final int f141812l0 = v.b("vmhd");

    /* renamed from: m0, reason: collision with root package name */
    public static final int f141814m0 = v.b("mp4v");

    /* renamed from: n0, reason: collision with root package name */
    public static final int f141816n0 = v.b("stts");

    /* renamed from: o0, reason: collision with root package name */
    public static final int f141818o0 = v.b("stss");

    /* renamed from: p0, reason: collision with root package name */
    public static final int f141820p0 = v.b("ctts");

    /* renamed from: q0, reason: collision with root package name */
    public static final int f141822q0 = v.b("stsc");

    /* renamed from: r0, reason: collision with root package name */
    public static final int f141824r0 = v.b("stsz");

    /* renamed from: s0, reason: collision with root package name */
    public static final int f141826s0 = v.b("stz2");

    /* renamed from: t0, reason: collision with root package name */
    public static final int f141828t0 = v.b("stco");

    /* renamed from: u0, reason: collision with root package name */
    public static final int f141830u0 = v.b("co64");

    /* renamed from: v0, reason: collision with root package name */
    public static final int f141832v0 = v.b("tx3g");

    /* renamed from: w0, reason: collision with root package name */
    public static final int f141834w0 = v.b("wvtt");

    /* renamed from: x0, reason: collision with root package name */
    public static final int f141836x0 = v.b("stpp");

    /* renamed from: y0, reason: collision with root package name */
    public static final int f141838y0 = v.b("c608");

    /* renamed from: z0, reason: collision with root package name */
    public static final int f141840z0 = v.b("samr");
    public static final int A0 = v.b("sawb");
    public static final int B0 = v.b("udta");
    public static final int C0 = v.b(PublicAccountMessageUtilImpl.META_NAME);
    public static final int D0 = v.b("ilst");
    public static final int E0 = v.b("mean");
    public static final int F0 = v.b("name");
    public static final int G0 = v.b("data");
    public static final int H0 = v.b("emsg");
    public static final int I0 = v.b("st3d");
    public static final int J0 = v.b("sv3d");
    public static final int K0 = v.b("proj");
    public static final int L0 = v.b("vp08");
    public static final int M0 = v.b("vp09");
    public static final int N0 = v.b("vpcC");
    public static final int O0 = v.b("camm");
    public static final int P0 = v.b("alac");

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6775a extends a {
        public final long Q0;
        public final List R0;
        public final List S0;

        public C6775a(int i3, long j3) {
            super(i3);
            this.Q0 = j3;
            this.R0 = new ArrayList();
            this.S0 = new ArrayList();
        }

        public void a(b bVar) {
            this.R0.add(bVar);
        }

        public C6775a d(int i3) {
            int size = this.S0.size();
            for (int i16 = 0; i16 < size; i16++) {
                C6775a c6775a = (C6775a) this.S0.get(i16);
                if (c6775a.f141841a == i3) {
                    return c6775a;
                }
            }
            return null;
        }

        public b e(int i3) {
            int size = this.R0.size();
            for (int i16 = 0; i16 < size; i16++) {
                b bVar = (b) this.R0.get(i16);
                if (bVar.f141841a == i3) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.u.a
        public String toString() {
            return a.a(this.f141841a) + " leaves: " + Arrays.toString(this.R0.toArray()) + " containers: " + Arrays.toString(this.S0.toArray());
        }

        public void a(C6775a c6775a) {
            this.S0.add(c6775a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends a {
        public final com.tencent.luggage.wxa.n0.l Q0;

        public b(int i3, com.tencent.luggage.wxa.n0.l lVar) {
            super(i3);
            this.Q0 = lVar;
        }
    }

    public a(int i3) {
        this.f141841a = i3;
    }

    public static String a(int i3) {
        return "" + ((char) ((i3 >> 24) & 255)) + ((char) ((i3 >> 16) & 255)) + ((char) ((i3 >> 8) & 255)) + ((char) (i3 & 255));
    }

    public static int b(int i3) {
        return i3 & 16777215;
    }

    public static int c(int i3) {
        return (i3 >> 24) & 255;
    }

    public String toString() {
        return a(this.f141841a);
    }
}
