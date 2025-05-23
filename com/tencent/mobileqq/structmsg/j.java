package com.tencent.mobileqq.structmsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f290427a;

    /* renamed from: b, reason: collision with root package name */
    public String f290428b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f290429c;

    /* renamed from: d, reason: collision with root package name */
    public List<j> f290430d;

    /* renamed from: e, reason: collision with root package name */
    public j f290431e;

    /* renamed from: f, reason: collision with root package name */
    public int f290432f;

    public String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        Map<String, String> map = this.f290429c;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        List<j> list = this.f290430d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public j c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (j) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        List<j> list = this.f290430d;
        if (list != null && list.size() > i3) {
            return this.f290430d.get(i3);
        }
        return null;
    }
}
