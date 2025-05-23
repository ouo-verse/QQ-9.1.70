package com.tencent.mobileqq.activity.contacts.topentry;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f181757a;

    /* renamed from: b, reason: collision with root package name */
    public String f181758b;

    /* renamed from: c, reason: collision with root package name */
    public String f181759c;

    /* renamed from: d, reason: collision with root package name */
    public String f181760d;

    /* renamed from: e, reason: collision with root package name */
    public String f181761e;

    /* renamed from: f, reason: collision with root package name */
    public String f181762f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f181763g;

    /* renamed from: h, reason: collision with root package name */
    public int f181764h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f181765i;

    /* renamed from: j, reason: collision with root package name */
    public short f181766j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f181767k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f181768l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f181769m;

    /* renamed from: n, reason: collision with root package name */
    public Object f181770n;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean z16 = !TextUtils.isEmpty(this.f181758b);
        if (z16) {
            z16 = this.f181767k;
        }
        if (z16) {
            int i3 = this.f181757a;
            if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || this.f181766j != 0) {
                return true;
            }
            z16 = false;
        }
        return z16;
    }
}
