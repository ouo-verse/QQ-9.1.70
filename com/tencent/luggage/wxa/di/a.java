package com.tencent.luggage.wxa.di;

import com.tencent.luggage.wxa.mg.l;
import com.tencent.luggage.wxa.mg.n;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xg.e;
import com.tencent.luggage.wxa.xg.g;
import com.tencent.luggage.wxa.z7.c;
import com.tencent.luggage.wxa.zg.j;
import com.tencent.luggage.wxa.zg.k;
import com.tencent.luggage.wxa.zg.m;
import java.math.BigInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static final BigInteger f124265b = BigInteger.valueOf(1024);

    /* renamed from: a, reason: collision with root package name */
    public final b f124266a = new b(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.di.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C6141a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f124267a;

        static {
            int[] iArr = new int[e.values().length];
            f124267a = iArr;
            try {
                iArr[e.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f124267a[e.EXTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f124267a[e.EXTRACT_NOT_SUPPORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f124267a[e.DECODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f124267a[e.DECODE_NOT_SUPPORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f124267a[e.RENDER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f124267a[e.ILLEGAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f124267a[e.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public void b(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar, long j3) {
        int i3;
        if (gVar == null || eVar == null) {
            return;
        }
        b bVar = this.f124266a;
        if (bVar.f124273f <= 0) {
            w.b("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, but has not call onMediaPlayerVideoPrepareStart, why?");
            return;
        }
        if (bVar.f124274g <= 0) {
            bVar.f124274g = w0.c();
            i3 = 1;
            eVar.a(1234L, 21L, 1L, false);
            b bVar2 = this.f124266a;
            long j16 = bVar2.f124274g - bVar2.f124273f;
            bVar2.f124275h = j16;
            eVar.a(1234L, 23L, j16, false);
            w.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, prepareTime:%s", Long.valueOf(j16));
            if (n.b(gVar)) {
                eVar.a(1234L, 46L, 1L, false);
                eVar.a(1234L, 48L, j16, false);
            } else if (a(gVar)) {
                eVar.a(1234L, 93L, 1L, false);
                eVar.a(1234L, 95L, j16, false);
            } else if (n.c(gVar)) {
                eVar.a(1234L, 41L, 1L, false);
                eVar.a(1234L, 43L, j16, false);
            }
        } else {
            i3 = 1;
        }
        b bVar3 = this.f124266a;
        if (bVar3.f124272e > 0 || j3 <= 0) {
            return;
        }
        long j17 = (long) ((j3 * 1.0d) / 1000.0d);
        bVar3.f124272e = j17;
        eVar.a(1234L, 35L, 1L, false);
        Object[] objArr = new Object[i3];
        objArr[0] = Long.valueOf(j17);
        w.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoPrepareEnd, duration:%s", objArr);
    }

    public void c(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar) {
        if (eVar != null && !w0.c(this.f124266a.f124268a)) {
            b bVar = this.f124266a;
            if (bVar.f124273f > 0) {
                bVar.f124281n = w0.c();
                a(eVar, cVar, gVar, "onMediaPlayerVideoEnd");
            }
        }
    }

    public void d(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar) {
        if (gVar != null && eVar != null) {
            if (n.a(gVar)) {
                this.f124266a.f124269b = 3;
            } else if (a(gVar)) {
                this.f124266a.f124269b = 2;
            } else if (n.b(gVar)) {
                this.f124266a.f124269b = 1;
            } else if (n.c(gVar)) {
                this.f124266a.f124269b = 0;
            }
            b bVar = this.f124266a;
            if (bVar.f124273f <= 0) {
                bVar.f124273f = w0.c();
                eVar.a(1234L, 20L, 1L, false);
                if (n.b(gVar)) {
                    eVar.a(1234L, 45L, 1L, false);
                } else if (a(gVar)) {
                    eVar.a(1234L, 92L, 1L, false);
                } else if (n.c(gVar)) {
                    eVar.a(1234L, 40L, 1L, false);
                }
            }
        }
    }

    public void e(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar) {
        if (eVar != null && !w0.c(this.f124266a.f124268a)) {
            b bVar = this.f124266a;
            if (bVar.f124273f > 0) {
                bVar.f124280m = w0.c();
                a(eVar, cVar, gVar, "onMediaPlayerVideoStop");
            }
        }
    }

    public boolean a(g gVar) {
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f124268a;

        /* renamed from: b, reason: collision with root package name */
        public int f124269b;

        /* renamed from: c, reason: collision with root package name */
        public long f124270c;

        /* renamed from: d, reason: collision with root package name */
        public long f124271d;

        /* renamed from: e, reason: collision with root package name */
        public long f124272e;

        /* renamed from: f, reason: collision with root package name */
        public long f124273f;

        /* renamed from: g, reason: collision with root package name */
        public long f124274g;

        /* renamed from: h, reason: collision with root package name */
        public long f124275h;

        /* renamed from: i, reason: collision with root package name */
        public int f124276i;

        /* renamed from: j, reason: collision with root package name */
        public long f124277j;

        /* renamed from: k, reason: collision with root package name */
        public long f124278k;

        /* renamed from: l, reason: collision with root package name */
        public long f124279l;

        /* renamed from: m, reason: collision with root package name */
        public long f124280m;

        /* renamed from: n, reason: collision with root package name */
        public long f124281n;

        /* renamed from: o, reason: collision with root package name */
        public int f124282o;

        /* renamed from: p, reason: collision with root package name */
        public int f124283p;

        /* renamed from: q, reason: collision with root package name */
        public String f124284q;

        /* renamed from: r, reason: collision with root package name */
        public m.c f124285r;

        /* renamed from: s, reason: collision with root package name */
        public int f124286s;

        public b() {
            this.f124268a = "";
            this.f124269b = 0;
            this.f124270c = 0L;
            this.f124271d = 0L;
            this.f124272e = 0L;
            this.f124273f = 0L;
            this.f124274g = 0L;
            this.f124275h = 0L;
            this.f124276i = 0;
            this.f124277j = 0L;
            this.f124278k = 0L;
            this.f124279l = 0L;
            this.f124280m = 0L;
            this.f124281n = 0L;
            this.f124282o = 0;
            this.f124283p = 0;
            this.f124284q = "";
            this.f124285r = m.c.f146698e;
            this.f124286s = 0;
        }

        public void a(String str) {
            if (!w0.c(str)) {
                if (str.length() > 512) {
                    str = str.substring(0, 512);
                }
                this.f124268a = str;
                return;
            }
            this.f124268a = "";
        }

        public void b() {
            this.f124278k = 0L;
            this.f124279l = 0L;
        }

        public void a() {
            this.f124268a = "";
            this.f124269b = 0;
            this.f124270c = 0L;
            this.f124272e = 0L;
            this.f124271d = 0L;
            this.f124273f = 0L;
            this.f124274g = 0L;
            this.f124275h = 0L;
            this.f124276i = 0;
            this.f124278k = 0L;
            this.f124279l = 0L;
            this.f124277j = 0L;
            this.f124280m = 0L;
            this.f124281n = 0L;
            this.f124282o = 0;
            this.f124283p = 0;
            this.f124284q = "";
            this.f124285r = m.c.f146698e;
            this.f124286s = 0;
        }

        public /* synthetic */ b(C6141a c6141a) {
            this();
        }
    }

    public e a(int i3, int i16) {
        return e.a(i3, i16);
    }

    public void a(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar, long j3) {
        if (gVar == null || eVar == null) {
            return;
        }
        if (n.a(gVar)) {
            eVar.a(1234L, 140L, 1L, false);
            eVar.a(1234L, 141L, j3, false);
            this.f124266a.f124269b = 3;
        } else if (a(gVar)) {
            eVar.a(1234L, 87L, 1L, false);
            eVar.a(1234L, 88L, j3, false);
            this.f124266a.f124269b = 2;
        } else if (n.b(gVar)) {
            eVar.a(1234L, 3L, 1L, false);
            eVar.a(1234L, 4L, j3, false);
            this.f124266a.f124269b = 1;
        } else if (n.c(gVar)) {
            eVar.a(1234L, 0L, 1L, false);
            eVar.a(1234L, 1L, j3, false);
            this.f124266a.f124269b = 0;
        }
        eVar.a(1234L, 6L, 1L, false);
        this.f124266a.f124270c = j3;
        m mVar = (m) gVar.a(m.class);
        if (mVar != null) {
            this.f124266a.f124285r = mVar.t();
            mVar.a(new m.d() { // from class: k21.a
                @Override // com.tencent.luggage.wxa.zg.m.d
                public final void a() {
                    com.tencent.luggage.wxa.di.a.this.a();
                }
            });
        }
    }

    public void b(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar) {
        if (gVar == null || eVar == null) {
            return;
        }
        b bVar = this.f124266a;
        if (bVar.f124278k <= 0) {
            bVar.f124276i++;
            bVar.f124278k = w0.c();
            eVar.a(1234L, 50L, 1L, false);
            if (n.b(gVar)) {
                eVar.a(1234L, 98L, 1L, false);
            } else if (a(gVar)) {
                eVar.a(1234L, 103L, 1L, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.f124266a.f124286s++;
    }

    public void a(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar, long j3, String str) {
        if (gVar == null || eVar == null || w0.c(str)) {
            return;
        }
        eVar.a(1234L, 10L, 1L, false);
        if (j3 > 0) {
            eVar.a(1234L, 11L, 1L, false);
            long longValue = BigInteger.valueOf(j3).divide(f124265b).longValue();
            eVar.a(1234L, 13L, longValue, false);
            w.a("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onVideoPathChanged, cachedSize:%s, cachedSizeInKB:%s", Long.valueOf(j3), Long.valueOf(longValue));
        }
        this.f124266a.a(str);
        this.f124266a.f124271d = j3;
    }

    public void a(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar) {
        if (gVar == null || eVar == null) {
            return;
        }
        b bVar = this.f124266a;
        if (bVar.f124278k <= 0) {
            w.b("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, but has not call onMediaPlayerVideoBufferStart, why?");
            return;
        }
        if (bVar.f124279l <= 0) {
            bVar.f124279l = w0.c();
            eVar.a(1234L, 51L, 1L, false);
            b bVar2 = this.f124266a;
            long j3 = bVar2.f124279l - bVar2.f124278k;
            bVar2.f124277j += j3;
            eVar.a(1234L, 53L, j3, false);
            w.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoBufferEnd, bufferTime:%s", Long.valueOf(j3));
            if (n.b(gVar)) {
                eVar.a(1234L, 99L, 1L, false);
                eVar.a(1234L, 101L, j3, false);
            } else if (a(gVar)) {
                eVar.a(1234L, 104L, 1L, false);
                eVar.a(1234L, 106L, j3, false);
            }
        }
        this.f124266a.b();
    }

    public void a(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar, int i3, int i16, String str) {
        if (gVar == null || eVar == null) {
            return;
        }
        eVar.a(1234L, 65L, 1L, false);
        w.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "onMediaPlayerVideoError, what:%s, extra:%s, msg:%s", Integer.valueOf(i3), Integer.valueOf(i16), str);
        if (n.b(gVar)) {
            eVar.a(1234L, 75L, 1L, false);
        } else if (a(gVar)) {
            eVar.a(1234L, 109L, 1L, false);
        } else if (n.c(gVar)) {
            eVar.a(1234L, 70L, 1L, false);
        }
        if (n.c(gVar)) {
            if (!w0.c(str)) {
                if (str.equalsIgnoreCase("MEDIA_ERR_NETWORK")) {
                    eVar.a(1234L, 72L, 1L, false);
                } else if (str.equalsIgnoreCase("MEDIA_ERR_DECODE")) {
                    eVar.a(1234L, 73L, 1L, false);
                } else if (str.equalsIgnoreCase("MEDIA_ERR_SRC_NOT_SUPPORTED")) {
                    eVar.a(1234L, 71L, 1L, false);
                } else {
                    eVar.a(1234L, 74L, 1L, false);
                }
            }
        } else {
            e a16 = a(i3, i16);
            if (a16 != null) {
                switch (C6141a.f124267a[a16.ordinal()]) {
                    case 1:
                        if (n.b(gVar)) {
                            eVar.a(1234L, 116L, 1L, false);
                            break;
                        } else if (a(gVar)) {
                            eVar.a(1234L, 125L, 1L, false);
                            break;
                        }
                        break;
                    case 2:
                        if (n.b(gVar)) {
                            eVar.a(1234L, 117L, 1L, false);
                            break;
                        } else if (a(gVar)) {
                            eVar.a(1234L, 126L, 1L, false);
                            break;
                        }
                        break;
                    case 3:
                        if (n.b(gVar)) {
                            eVar.a(1234L, 118L, 1L, false);
                            break;
                        } else if (a(gVar)) {
                            eVar.a(1234L, 127L, 1L, false);
                            break;
                        }
                        break;
                    case 4:
                        if (n.b(gVar)) {
                            eVar.a(1234L, 119L, 1L, false);
                            break;
                        } else if (a(gVar)) {
                            eVar.a(1234L, 128L, 1L, false);
                            break;
                        }
                        break;
                    case 5:
                        if (n.b(gVar)) {
                            eVar.a(1234L, 120L, 1L, false);
                            break;
                        } else if (a(gVar)) {
                            eVar.a(1234L, 129L, 1L, false);
                            break;
                        }
                        break;
                    case 6:
                        if (n.b(gVar)) {
                            eVar.a(1234L, 121L, 1L, false);
                            break;
                        } else if (a(gVar)) {
                            eVar.a(1234L, 130L, 1L, false);
                            break;
                        }
                        break;
                    case 7:
                        if (n.b(gVar)) {
                            eVar.a(1234L, 122L, 1L, false);
                            break;
                        } else if (a(gVar)) {
                            eVar.a(1234L, 131L, 1L, false);
                            break;
                        }
                        break;
                    case 8:
                        if (n.b(gVar)) {
                            eVar.a(1234L, 123L, 1L, false);
                            break;
                        } else if (a(gVar)) {
                            eVar.a(1234L, 132L, 1L, false);
                            break;
                        }
                        break;
                }
            }
        }
        b bVar = this.f124266a;
        bVar.f124282o = i3;
        bVar.f124283p = i16;
        bVar.f124284q = str;
    }

    public void a(com.tencent.luggage.wxa.j8.e eVar, j.d dVar) {
        if (eVar != null) {
            if (dVar.f146674a) {
                eVar.a(1234L, 134L, 1L, false);
            }
            if (dVar.f146675b) {
                eVar.a(1234L, 135L, 1L, false);
            }
        }
    }

    public final void a(com.tencent.luggage.wxa.j8.e eVar, c cVar, g gVar, String str) {
        com.tencent.luggage.wxa.o.c cVar2;
        int i3;
        int i16;
        int i17;
        b bVar = this.f124266a;
        if (bVar.f124274g < bVar.f124273f) {
            w.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile, wired case, ignore reporting and reset data");
            this.f124266a.a();
            return;
        }
        String appId = cVar != null ? cVar.getAppId() : "";
        com.tencent.luggage.wxa.o.c cVar3 = k.f146687b;
        m mVar = (m) gVar.a(m.class);
        if (mVar != null) {
            int k3 = mVar.k();
            i16 = mVar.j();
            i17 = mVar.g();
            cVar2 = mVar.f();
            com.tencent.luggage.wxa.o.c m3 = mVar.m();
            i3 = k3;
            cVar3 = m3;
        } else {
            cVar2 = cVar3;
            i3 = 0;
            i16 = 0;
            i17 = 0;
        }
        int i18 = cVar2.f135951d;
        int i19 = cVar2.f135953f;
        int i26 = cVar2.f135954g;
        int i27 = cVar3.f135951d;
        int i28 = cVar3.f135953f;
        int i29 = cVar3.f135954g;
        int i36 = i16;
        b bVar2 = this.f124266a;
        int i37 = i17;
        w.d("MicroMsg.SameLayer.AppBrandVideoProfileReport", "reportVideoProfile:%s, appId:%s, proxy:%s, playerType:%s, playerCreateTime:%s, videoPath:%s, cachedSize:%s, duration:%s, prepareTime:%s, bufferCount:%s, bufferTime:%s, error(%s, %s, %s), minBufferMs:%s, maxBufferMs:%s, bufferForPlaybackMs:%s, fixNotifyErrorChannel: %d, lockCache: %b, useCronet: %b, interruptCache: %b, notifyErrorFix2FailCount: %d, audioRenderedCount: %d, audioDroppedCount: %d, audioMaxConsecutiveDroppedCount: %d, videoRenderedCount: %d, videoDroppedCount: %d, videoMaxConsecutiveDroppedCount: %d", str, appId, Boolean.valueOf(l.a().d()), Integer.valueOf(this.f124266a.f124269b), Long.valueOf(this.f124266a.f124270c), bVar2.f124268a, Long.valueOf(bVar2.f124271d), Long.valueOf(this.f124266a.f124272e), Long.valueOf(this.f124266a.f124275h), Integer.valueOf(this.f124266a.f124276i), Long.valueOf(this.f124266a.f124277j), Integer.valueOf(this.f124266a.f124282o), Integer.valueOf(this.f124266a.f124283p), this.f124266a.f124284q, Integer.valueOf(i3), Integer.valueOf(i36), Integer.valueOf(i37), Integer.valueOf(this.f124266a.f124285r.f146699a), Boolean.valueOf(this.f124266a.f124285r.f146700b), Boolean.valueOf(this.f124266a.f124285r.f146701c), Boolean.valueOf(this.f124266a.f124285r.f146702d), Integer.valueOf(this.f124266a.f124286s), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i29));
        b bVar3 = this.f124266a;
        eVar.a(18651, appId, Integer.valueOf(this.f124266a.f124269b), bVar3.f124268a, Long.valueOf(bVar3.f124275h), Long.valueOf(this.f124266a.f124272e), Long.valueOf(this.f124266a.f124271d), Integer.valueOf(this.f124266a.f124282o), Integer.valueOf(this.f124266a.f124283p), this.f124266a.f124284q, 1, Integer.valueOf(l.a().d() ? 1 : 0), Integer.valueOf(this.f124266a.f124276i), Long.valueOf(this.f124266a.f124277j), Long.valueOf(this.f124266a.f124270c), Long.valueOf(this.f124266a.f124273f), Long.valueOf(this.f124266a.f124274g), Long.valueOf(this.f124266a.f124280m), Long.valueOf(this.f124266a.f124281n), Integer.valueOf(i3), Integer.valueOf(i36), Integer.valueOf(i37), Integer.valueOf(this.f124266a.f124285r.f146699a), Integer.valueOf(this.f124266a.f124285r.f146700b ? 1 : 0), Integer.valueOf(this.f124266a.f124285r.f146701c ? 1 : 0), Integer.valueOf(this.f124266a.f124285r.f146702d ? 1 : 0), Integer.valueOf(this.f124266a.f124286s), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Integer.valueOf(i29));
        this.f124266a.a();
    }
}
