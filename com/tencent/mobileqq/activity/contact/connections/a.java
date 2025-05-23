package com.tencent.mobileqq.activity.contact.connections;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f181253a;

    /* renamed from: b, reason: collision with root package name */
    public int f181254b;

    /* renamed from: c, reason: collision with root package name */
    public String f181255c;

    /* renamed from: d, reason: collision with root package name */
    public String f181256d;

    /* renamed from: e, reason: collision with root package name */
    public String f181257e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f181258f;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof a) {
            if (this.f181253a == ((a) obj).f181253a) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "tab_id=" + this.f181253a + " recommend_count=" + this.f181254b + " tab_name=" + this.f181255c + " icon_url_select=" + this.f181256d + " icon_url_unselect=" + this.f181257e;
    }
}
