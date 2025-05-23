package com.tencent.mobileqq.troop.avatar;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected static Map<String, i> f294546d;

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.api.handler.b f294547a;

    /* renamed from: b, reason: collision with root package name */
    private b f294548b;

    /* renamed from: c, reason: collision with root package name */
    public String f294549c;

    public e(String str, Class<? extends i> cls, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, cls, appInterface);
            return;
        }
        this.f294548b = d();
        this.f294547a = (com.tencent.mobileqq.troop.api.handler.b) appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAvatarHandlerName());
        this.f294549c = str;
        if (f294546d == null) {
            f294546d = new HashMap();
        }
        if (f294546d.get(str) == null) {
            f294546d.put(str, h.a(cls));
        }
    }

    private b d() {
        return new com.tencent.mobileqq.troop.avatar.impl.a();
    }

    public void b(Observer observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) observer);
        } else {
            f294546d.get(this.f294549c).addObserver(observer);
        }
    }

    public void c(String str, int i3, ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), arrayList);
            return;
        }
        com.tencent.mobileqq.troop.api.handler.b bVar = this.f294547a;
        if (bVar != null) {
            bVar.I(str, i3, arrayList);
        }
    }

    public ArrayList<g> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return f294546d.get(this.f294549c).a();
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f294547a = null;
        }
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        com.tencent.mobileqq.troop.api.handler.b bVar = this.f294547a;
        if (bVar != null) {
            bVar.o2(str);
        }
    }

    public void h(Observer observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) observer);
        } else {
            f294546d.get(this.f294549c).b(observer);
        }
    }
}
