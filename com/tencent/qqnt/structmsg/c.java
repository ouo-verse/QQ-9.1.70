package com.tencent.qqnt.structmsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f362294a;

    /* renamed from: b, reason: collision with root package name */
    public String f362295b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f362296c;

    /* renamed from: d, reason: collision with root package name */
    public List<c> f362297d;

    /* renamed from: e, reason: collision with root package name */
    public c f362298e;

    /* renamed from: f, reason: collision with root package name */
    public int f362299f;

    public c(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) map);
            return;
        }
        this.f362299f = 1;
        this.f362295b = str;
        this.f362296c = map;
    }

    public void a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
            return;
        }
        if (this.f362297d == null) {
            this.f362297d = new ArrayList();
        }
        this.f362297d.add(cVar);
    }

    public String b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        Map<String, String> map = this.f362296c;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        List<c> list = this.f362297d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public c d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        List<c> list = this.f362297d;
        if (list != null && list.size() > i3) {
            return this.f362297d.get(i3);
        }
        return null;
    }
}
