package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f294550a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f294551b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f294552c;

    /* renamed from: d, reason: collision with root package name */
    public int f294553d;

    /* renamed from: e, reason: collision with root package name */
    public int f294554e;

    /* renamed from: f, reason: collision with root package name */
    public long f294555f;

    /* renamed from: g, reason: collision with root package name */
    public String f294556g;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f294554e = 0;
        }
    }

    public String a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        List<String> list = this.f294551b;
        if (list != null && list.size() != 0) {
            if (i3 < this.f294551b.size()) {
                return this.f294551b.get(i3);
            }
            return this.f294551b.get(r4.size() - 1);
        }
        return "";
    }
}
