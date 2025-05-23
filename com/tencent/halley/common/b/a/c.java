package com.tencent.halley.common.b.a;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f113306r;
    private com.tencent.halley.common.a.c.c A;
    private com.tencent.halley.common.a.a B;
    private String C;
    private String D;

    /* renamed from: o, reason: collision with root package name */
    public boolean f113307o;

    /* renamed from: p, reason: collision with root package name */
    public int f113308p;

    /* renamed from: q, reason: collision with root package name */
    public String f113309q;

    /* renamed from: s, reason: collision with root package name */
    private boolean f113310s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f113311t;

    /* renamed from: u, reason: collision with root package name */
    private int f113312u;

    /* renamed from: v, reason: collision with root package name */
    private g f113313v;

    /* renamed from: w, reason: collision with root package name */
    private f f113314w;

    /* renamed from: x, reason: collision with root package name */
    private b f113315x;

    /* renamed from: y, reason: collision with root package name */
    private com.tencent.halley.common.b.a f113316y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f113317z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14311);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f113306r = false;
        }
    }

    c(String str, Map<String, String> map, byte[] bArr, int i3, String str2, com.tencent.halley.common.a.c.c cVar, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, map, bArr, Integer.valueOf(i3), str2, cVar, str3);
            return;
        }
        this.f113307o = true;
        this.f113310s = false;
        this.f113311t = false;
        this.f113308p = -1;
        this.f113316y = com.tencent.halley.common.b.a.a();
        this.f113286b = str;
        this.f113287c = false;
        this.f113288d = map;
        this.f113289e = bArr;
        this.f113290f = i3;
        this.f113292h = str2;
        this.f113310s = false;
        this.f113312u = 0;
        this.f113317z = false;
        this.A = cVar;
        this.C = str3;
    }

    public static c a(String str, Map<String, String> map, byte[] bArr, int i3, String str2, com.tencent.halley.common.a.c.c cVar) {
        return new c(str, map, bArr, i3, str2, cVar, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0213 A[LOOP:0: B:23:0x0068->B:72:0x0213, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021b A[EDGE_INSN: B:73:0x021b->B:74:0x021b BREAK  A[LOOP:0: B:23:0x0068->B:72:0x0213], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final f b() {
        boolean z16;
        StringBuilder sb5;
        int i3;
        String sb6;
        String file;
        String ref;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        boolean z29 = true;
        if (!f113306r) {
            f113306r = true;
            try {
                String str = Build.VERSION.SDK;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.f113314w = new f("");
        try {
            URL url = new URL(this.f113286b);
            String host = url.getHost();
            this.f113315x = new b(url, this.f113286b);
            List<com.tencent.halley.common.a.a> a16 = this.f113315x.a(this.f113317z, url.getProtocol().toLowerCase().startsWith("https"));
            int size = a16.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i17 = this.f113290f;
            if (size > 1) {
                i17 /= 2;
            }
            int i18 = i17;
            boolean z36 = false;
            int i19 = 0;
            while (i19 < size) {
                this.f113298n.incrementAndGet();
                com.tencent.halley.common.a.a aVar = a16.get(i19);
                this.B = aVar;
                byte b16 = aVar.f113198e;
                if (b16 != 3 && b16 != 4) {
                    z16 = z29;
                } else {
                    z16 = z36;
                }
                if (z16) {
                    this.f113311t = z29;
                }
                b bVar = this.f113315x;
                if (aVar.b()) {
                    sb6 = bVar.f113303e;
                } else {
                    if (!bVar.f113302d.getProtocol().startsWith("https")) {
                        sb5 = new StringBuilder("http://");
                        sb5.append(aVar.f113196c);
                        sb5.append(":");
                        i3 = aVar.f113197d;
                    } else if (bVar.f113304f != 0) {
                        sb5 = new StringBuilder("https://");
                        sb5.append(aVar.f113196c);
                        sb5.append(":");
                        i3 = bVar.f113304f;
                    } else {
                        sb5 = new StringBuilder("https://");
                        sb5.append(aVar.f113196c);
                        sb5.append(":443");
                        sb6 = sb5.toString();
                        file = bVar.f113302d.getFile();
                        if (!TextUtils.isEmpty(file)) {
                            if (file.startsWith("/")) {
                                sb6 = sb6 + file;
                            } else {
                                sb6 = sb6 + "/" + file;
                            }
                        }
                        ref = bVar.f113302d.getRef();
                        if (!TextUtils.isEmpty(ref)) {
                            sb6 = sb6 + "#" + ref;
                        }
                    }
                    sb5.append(i3);
                    sb6 = sb5.toString();
                    file = bVar.f113302d.getFile();
                    if (!TextUtils.isEmpty(file)) {
                    }
                    ref = bVar.f113302d.getRef();
                    if (!TextUtils.isEmpty(ref)) {
                    }
                }
                String str2 = sb6;
                this.D = str2;
                int i26 = i19;
                int i27 = i18;
                int i28 = i18;
                boolean z37 = z36;
                g gVar = new g(host, str2, this.f113287c, this.f113288d, this.f113289e, i27, this.f113292h);
                this.f113313v = gVar;
                if (i26 == 0 && !this.f113310s) {
                    z17 = true;
                } else {
                    z17 = true;
                    gVar.f113332t = true;
                }
                if (com.tencent.halley.common.a.c.k() && i26 != 0) {
                    this.f113313v.f113328p = z17;
                }
                this.f113313v.f113330r = this.f113298n.get();
                g gVar2 = this.f113313v;
                gVar2.f113331s = this.f113307o;
                f b17 = gVar2.b();
                this.f113314w = b17;
                if (this.f113311t && b17.f113322a != 0 && com.tencent.halley.common.a.c.j()) {
                    com.tencent.halley.common.a.a aVar2 = this.B;
                    f fVar = this.f113314w;
                    com.tencent.halley.common.b.a.a(host, aVar2, fVar.f113322a, fVar.f113324c);
                }
                int elapsedRealtime2 = (int) (this.f113290f - (SystemClock.elapsedRealtime() - elapsedRealtime));
                f fVar2 = this.f113314w;
                int i29 = fVar2.f113322a;
                if ((i29 != 0 || (i16 = fVar2.f113324c) < 200 || i16 >= 400) && i29 != -20 && i29 != -300 && i29 != -306 && i29 != -292) {
                    z18 = z37 ? 1 : 0;
                } else {
                    z18 = true;
                }
                if (!z18 && i26 != size - 1 && elapsedRealtime2 > 200) {
                    z19 = z37 ? 1 : 0;
                } else {
                    z19 = true;
                }
                if (!z19 && i29 == -4) {
                    int a17 = h.a("direct_nonet_retry_gap", z37 ? 1 : 0, 10000, 3000);
                    if (this.f113313v.f113327o >= a17) {
                        z26 = true;
                        if (!z26) {
                            z27 = true;
                            z28 = true;
                        } else {
                            z27 = true;
                            a(true);
                            z28 = z37 ? 1 : 0;
                        }
                        if (!z28) {
                            break;
                        }
                        i19 = i26 + 1;
                        z36 = z37 ? 1 : 0;
                        z29 = z27;
                        i18 = i28;
                    } else {
                        SystemClock.sleep(j.a((int) (r9 - r6), 200, a17, 200));
                    }
                }
                z26 = z19;
                if (!z26) {
                }
                if (!z28) {
                }
            }
            return this.f113314w;
        } catch (MalformedURLException unused) {
            f fVar3 = this.f113314w;
            fVar3.f113322a = -300;
            return fVar3;
        }
    }

    public final void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        g gVar = this.f113313v;
        if (gVar == null) {
            return;
        }
        if (this.f113294j) {
            gVar.f113294j = true;
        }
        HashMap hashMap = new HashMap();
        if (z16) {
            hashMap.put("B46", "1");
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f113296l);
            hashMap.put("B22", sb5.toString());
        }
        if (!j.a(this.f113309q)) {
            hashMap.put("B15", this.f113309q);
        }
        if (!j.a(this.C)) {
            hashMap.put("B54", this.C);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("B82", this.f113292h);
        if (this.f113310s) {
            hashMap.put("B52", "1");
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.f113312u);
            hashMap.put("B58", sb6.toString());
        }
        hashMap2.put("B44", this.f113285a);
        if (!TextUtils.isEmpty(this.f113285a) && !this.f113285a.equals(this.D)) {
            hashMap2.put("B49", this.D);
        }
        com.tencent.halley.common.a.a aVar = this.B;
        if (aVar != null) {
            if (!aVar.b()) {
                hashMap2.put("B10", this.B.a());
            }
            if (this.B.f113194a != -1) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(this.B.f113194a);
                hashMap2.put("B45", sb7.toString());
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append((int) this.B.f113198e);
            hashMap2.put("B202", sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(this.B.f113195b);
            hashMap2.put("B204", sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(this.f113311t ? 1 : 0);
            hashMap2.put("B203", sb10.toString());
        }
        StringBuilder sb11 = new StringBuilder();
        sb11.append(this.f113298n.get());
        hashMap2.put("B53", sb11.toString());
        if (!TextUtils.isEmpty(this.f113315x.f113301c)) {
            hashMap2.put("B26", this.f113315x.f113301c);
        }
        if (this.f113295k) {
            hashMap2.put("B97", "1");
        }
        this.f113313v.a(hashMap, hashMap2);
    }

    @Override // com.tencent.halley.common.a.f
    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        this.f113297m = true;
        g gVar = this.f113313v;
        if (gVar == null) {
            return false;
        }
        gVar.a();
        return false;
    }
}
