package com.tencent.luggage.wxa.ii;

import android.util.Pair;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.fd.p0;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.mobileqq.R;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.fd.n f130424a;

    /* renamed from: b, reason: collision with root package name */
    public final a f130425b;

    /* renamed from: c, reason: collision with root package name */
    public final int f130426c;

    /* renamed from: d, reason: collision with root package name */
    public final int f130427d;

    /* renamed from: e, reason: collision with root package name */
    public volatile String f130428e;

    /* renamed from: f, reason: collision with root package name */
    public volatile String f130429f;

    /* renamed from: g, reason: collision with root package name */
    public final String f130430g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.bk.e f130431h;

    /* renamed from: i, reason: collision with root package name */
    public final com.tencent.luggage.wxa.v4.b f130432i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.bk.e eVar, int i3);
    }

    public b(com.tencent.luggage.wxa.ki.a aVar, a aVar2) {
        this.f130425b = aVar2;
        this.f130426c = aVar.f132022d;
        this.f130428e = aVar.f132018b;
        this.f130429f = aVar.f132016a;
        this.f130427d = aVar.f132020c;
        this.f130431h = aVar.f132032i;
        this.f130430g = aVar.f132026f;
        this.f130432i = aVar.G;
        this.f130424a = aVar.f132034j;
    }

    public boolean a(n0 n0Var, boolean z16) {
        if (!e.a.b(this.f130426c) || 1 != n0Var.h().f125922c) {
            return false;
        }
        com.tencent.luggage.wxa.y9.a.makeText(com.tencent.luggage.wxa.tn.z.c(), R.string.yzh, 1).show();
        return true;
    }

    public Pair b() {
        return new Pair(o0.a().a(this.f130428e, new String[0]), Boolean.FALSE);
    }

    @Override // java.lang.Runnable
    public void run() {
        Pair b16 = b();
        n0 n0Var = (n0) b16.first;
        boolean booleanValue = ((Boolean) b16.second).booleanValue();
        if (n0Var == null) {
            com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
            a();
            return;
        }
        if (a(n0Var, booleanValue)) {
            a();
            return;
        }
        com.tencent.luggage.wxa.j4.d a16 = w21.a.b().a(n0Var);
        if (a16 == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandPreLaunchProcess", "onGetWxaAttr, assembled NULL config with username(%s) appId(%s)", n0Var.f138465d, n0Var.f138467f);
            a();
            return;
        }
        a16.f125811d = this.f130426c;
        this.f130428e = a16.f125808a;
        this.f130429f = a16.G;
        if (this.f130426c == 0) {
            a16.f125812e = n0Var.h().f125924e;
        } else {
            String a17 = h.a().a(this.f130428e, this.f130426c);
            a16.P = a17;
            try {
                JSONObject c16 = com.tencent.luggage.wxa.xa.g.c(a17);
                a16.f125812e = c16.optString("device_orientation");
                a16.Q = c16.optBoolean("open_remote", false);
                a16.X = p0.a(a16.P);
            } catch (Exception unused) {
            }
        }
        if (this.f130431h == null) {
            this.f130431h = new com.tencent.luggage.wxa.bk.e();
        }
        a(a16, this.f130431h);
    }

    public void a() {
        a aVar = this.f130425b;
        if (aVar != null) {
            aVar.a(null, null, 2);
        }
    }

    public void a(com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.bk.e eVar) {
        a aVar = this.f130425b;
        if (aVar != null) {
            aVar.a(dVar, eVar, 1);
        }
    }
}
