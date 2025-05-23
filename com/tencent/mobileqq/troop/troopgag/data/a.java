package com.tencent.mobileqq.troop.troopgag.data;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f300221a;

    /* renamed from: b, reason: collision with root package name */
    public String f300222b;

    /* renamed from: c, reason: collision with root package name */
    public int f300223c;

    /* renamed from: d, reason: collision with root package name */
    public e f300224d;

    /* renamed from: e, reason: collision with root package name */
    public d f300225e;

    /* renamed from: f, reason: collision with root package name */
    public List<TroopMemberInfo> f300226f;

    /* renamed from: g, reason: collision with root package name */
    public c f300227g;

    /* renamed from: h, reason: collision with root package name */
    public b f300228h;

    /* renamed from: i, reason: collision with root package name */
    public int f300229i;

    public a(String str, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) eVar);
            return;
        }
        this.f300229i = -1;
        this.f300221a = str;
        this.f300224d = eVar;
        this.f300223c = 1;
    }

    public a(String str, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) dVar);
            return;
        }
        this.f300229i = -1;
        this.f300221a = str;
        this.f300225e = dVar;
        this.f300223c = 2;
    }

    public a(String str, List<TroopMemberInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) list);
            return;
        }
        this.f300229i = -1;
        this.f300221a = str;
        this.f300226f = list;
        this.f300223c = 3;
    }

    public a(String str, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) cVar);
            return;
        }
        this.f300229i = -1;
        this.f300221a = str;
        this.f300227g = cVar;
        this.f300223c = 4;
    }

    public a(String str, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bVar);
            return;
        }
        this.f300229i = -1;
        this.f300221a = str;
        this.f300228h = bVar;
        this.f300223c = 5;
    }

    public a(String str, String str2, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, bVar);
            return;
        }
        this.f300229i = -1;
        this.f300221a = str;
        this.f300222b = str2;
        this.f300228h = bVar;
        this.f300223c = 5;
    }
}
