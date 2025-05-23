package com.tencent.gamecenter.wadl.sdk.common.c.b;

import android.os.Build;
import android.os.SystemClock;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d extends a {

    /* renamed from: s, reason: collision with root package name */
    private static boolean f107086s = false;

    /* renamed from: l, reason: collision with root package name */
    private g f107089l;

    /* renamed from: m, reason: collision with root package name */
    private f f107090m;

    /* renamed from: n, reason: collision with root package name */
    private b f107091n;

    /* renamed from: p, reason: collision with root package name */
    private boolean f107093p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.common.b.a f107094q;

    /* renamed from: r, reason: collision with root package name */
    private String f107095r;

    /* renamed from: j, reason: collision with root package name */
    public boolean f107087j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f107088k = false;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.gamecenter.wadl.sdk.common.c.a f107092o = com.tencent.gamecenter.wadl.sdk.common.c.a.a();

    public d(String str, boolean z16, Map<String, String> map, byte[] bArr, int i3, String str2, boolean z17, boolean z18) {
        this.f107060a = str;
        this.f107061b = z16;
        this.f107062c = map;
        this.f107063d = bArr;
        this.f107064e = i3;
        this.f107066g = str2;
        this.f107093p = z18;
    }

    public static d a(String str, boolean z16, Map<String, String> map, byte[] bArr, int i3, String str2, boolean z17) {
        return new d(str, z16, map, bArr, i3, str2, false, z17);
    }

    private void b() {
        if (!f107086s) {
            f107086s = true;
            try {
                String str = Build.VERSION.SDK;
            } catch (Exception e16) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("DirectRetryHttpTask", "disableConnectionReuseIfNecessary fail!", e16);
            }
        }
    }

    private boolean d() {
        int i3;
        f fVar = this.f107090m;
        int i16 = fVar.f107097a;
        if ((i16 != 0 || (i3 = fVar.f107099c) < 200 || i3 >= 400) && i16 != -20 && i16 != -300 && i16 != -306 && i16 != -292) {
            return false;
        }
        return true;
    }

    public f c() {
        boolean z16;
        boolean z17;
        b();
        int i3 = 0;
        this.f107090m = new f(0, "", 0);
        try {
            URL url = new URL(this.f107060a);
            String host = url.getHost();
            this.f107091n = new b(url, this.f107060a);
            List<com.tencent.gamecenter.wadl.sdk.common.b.a> a16 = this.f107091n.a(this.f107092o, this.f107093p, url.getProtocol().toLowerCase().startsWith("https"));
            int size = a16.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean z18 = true;
            int i16 = this.f107064e;
            if (size > 1) {
                i16 /= 2;
            }
            int i17 = i16;
            while (i3 < size) {
                this.f107068i.incrementAndGet();
                com.tencent.gamecenter.wadl.sdk.common.b.a aVar = a16.get(i3);
                this.f107094q = aVar;
                if (aVar.c()) {
                    z16 = z18;
                } else {
                    z16 = this.f107088k;
                }
                this.f107088k = z16;
                String a17 = this.f107091n.a(this.f107094q);
                this.f107095r = a17;
                this.f107089l = new g(host, a17, this.f107061b, this.f107062c, this.f107063d, i17, this.f107066g);
                if (com.tencent.gamecenter.wadl.sdk.common.b.c.k() && i3 != 0) {
                    z17 = true;
                    this.f107089l.f107112t = true;
                } else {
                    z17 = true;
                }
                this.f107089l.f107114v = this.f107068i.get();
                g gVar = this.f107089l;
                gVar.f107115w = this.f107087j;
                f c16 = gVar.c();
                this.f107090m = c16;
                if (this.f107088k && c16.f107097a != 0 && com.tencent.gamecenter.wadl.sdk.common.b.c.j()) {
                    com.tencent.gamecenter.wadl.sdk.common.c.a aVar2 = this.f107092o;
                    com.tencent.gamecenter.wadl.sdk.common.b.a aVar3 = this.f107094q;
                    f fVar = this.f107090m;
                    aVar2.a(host, aVar3, fVar.f107097a, fVar.f107099c);
                }
                i17 = (int) (this.f107064e - (SystemClock.elapsedRealtime() - elapsedRealtime));
                if (a(i3, size, i17)) {
                    break;
                }
                i3++;
                z18 = z17;
            }
            return this.f107090m;
        } catch (MalformedURLException unused) {
            f fVar2 = this.f107090m;
            fVar2.f107097a = -300;
            return fVar2;
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.b.e
    public boolean a() {
        this.f107067h = true;
        g gVar = this.f107089l;
        if (gVar == null) {
            return false;
        }
        gVar.a();
        return false;
    }

    private boolean a(int i3, int i16, int i17) {
        boolean z16 = d() || i3 == i16 - 1 || i17 <= 200;
        if (!z16 && this.f107090m.f107097a == -4) {
            int a16 = com.tencent.gamecenter.wadl.sdk.common.b.g.a("direct_nonet_retry_gap", 0, 10000, 3000);
            if (this.f107089l.f107111s >= a16) {
                return true;
            }
            SystemClock.sleep(com.tencent.gamecenter.wadl.sdk.common.e.g.a((int) (r4 - r0), 200, a16, 200));
        }
        return z16;
    }
}
