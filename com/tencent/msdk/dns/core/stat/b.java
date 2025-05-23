package com.tencent.msdk.dns.core.stat;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.c.e.e;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.local.a;
import com.tencent.msdk.dns.core.n;
import com.tencent.msdk.dns.core.rest.share.a;
import com.tencent.msdk.dns.core.rest.share.g;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b implements com.tencent.msdk.dns.core.a<g> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f336380a;

    /* renamed from: b, reason: collision with root package name */
    public String f336381b;

    /* renamed from: c, reason: collision with root package name */
    public String f336382c;

    /* renamed from: d, reason: collision with root package name */
    public int f336383d;

    /* renamed from: e, reason: collision with root package name */
    public a.C9216a f336384e;

    /* renamed from: f, reason: collision with root package name */
    public a.C9218a f336385f;

    /* renamed from: g, reason: collision with root package name */
    public a.C9218a f336386g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.msdk.dns.core.c f336387h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f336388i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f336389j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f336390k;

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f336381b = "";
        this.f336382c = "";
        this.f336383d = -1;
        this.f336384e = a.C9216a.f336272e;
        a.C9218a c9218a = a.C9218a.f336318m;
        this.f336385f = c9218a;
        this.f336386g = c9218a;
        this.f336388i = false;
        this.f336389j = true;
        this.f336390k = false;
        if (context != null) {
            this.f336380a = e.c(context);
            return;
        }
        throw new IllegalArgumentException("context".concat(" can not be null"));
    }

    @Override // com.tencent.msdk.dns.core.a, com.tencent.msdk.dns.core.i.c
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f336388i;
    }

    @Override // com.tencent.msdk.dns.core.a
    public void b(n<g> nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) nVar);
        } else {
            if (nVar != null) {
                this.f336381b = nVar.u();
                this.f336382c = nVar.n();
                this.f336383d = nVar.p();
                return;
            }
            throw new IllegalArgumentException("lookupContext".concat(" can not be null"));
        }
    }

    @Override // com.tencent.msdk.dns.core.a
    public <Statistics extends i.c> void c(i iVar, Statistics statistics) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar, (Object) statistics);
            return;
        }
        if (iVar != null) {
            if (statistics != null) {
                boolean z17 = false;
                com.tencent.msdk.dns.base.log.c.g("%s.merge(%s, %s) called", super.toString(), iVar, statistics);
                if (!this.f336390k) {
                    this.f336388i = statistics.a();
                    this.f336390k = true;
                } else {
                    if (this.f336388i && statistics.a()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.f336388i = z16;
                }
                if (this.f336389j && statistics.e()) {
                    z17 = true;
                }
                this.f336389j = z17;
                f a16 = iVar.a();
                if ("Local".equals(a16.f336254a)) {
                    this.f336384e = (a.C9216a) statistics;
                    return;
                }
                int i3 = a16.f336255b;
                if (1 == i3) {
                    this.f336385f = (a.C9218a) statistics;
                    return;
                } else {
                    if (2 == i3) {
                        this.f336386g = (a.C9218a) statistics;
                        return;
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("stat".concat(" can not be null"));
        }
        throw new IllegalArgumentException("dns".concat(" can not be null"));
    }

    @Override // com.tencent.msdk.dns.core.a
    public void d(com.tencent.msdk.dns.core.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            if (cVar != null) {
                this.f336387h = cVar;
                return;
            }
            throw new IllegalArgumentException("ipSet".concat(" can not be null"));
        }
    }

    @Override // com.tencent.msdk.dns.core.i.c
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f336389j;
    }

    @Override // com.tencent.msdk.dns.core.a
    public String f() {
        String valueOf;
        String valueOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("v4_ips", com.tencent.msdk.dns.c.e.a.c(this.f336385f.f336376a, ","));
            jSONObject.put("v4_ttl", String.valueOf(this.f336385f.f336322h));
            jSONObject.put("v4_client_ip", String.valueOf(this.f336385f.f336321g));
            jSONObject.put("v6_ips", com.tencent.msdk.dns.c.e.a.c(this.f336386g.f336376a, ","));
            int i3 = this.f336386g.f336322h;
            if (i3 == 0) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(i3);
            }
            jSONObject.put("v6_ttl", valueOf);
            if ("0".equals(this.f336386g.f336321g)) {
                valueOf2 = "";
            } else {
                valueOf2 = String.valueOf(this.f336386g.f336321g);
            }
            jSONObject.put("v6_client_ip", valueOf2);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return super.toString() + "{netType='" + this.f336380a + "', hostname='" + this.f336381b + "', channel='" + this.f336382c + "', curNetStack=" + this.f336383d + ", localDnsStat=" + this.f336384e + ", restInetDnsStat=" + this.f336385f + ", restInet6DnsStat=" + this.f336386g + ", ipSet=" + this.f336387h + ", lookupSuccess=" + this.f336388i + ", lookupGetEmptyResponse=" + this.f336389j + ", hasBeenMerge=" + this.f336390k + '}';
    }
}
