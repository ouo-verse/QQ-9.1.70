package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Betelnut extends CanisMinor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList<Blackberry> f375429e;

    /* renamed from: a, reason: collision with root package name */
    public long f375430a;

    /* renamed from: b, reason: collision with root package name */
    public int f375431b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<Blackberry> f375432c;

    /* renamed from: d, reason: collision with root package name */
    public int f375433d;

    public Betelnut() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375430a = 0L;
        this.f375431b = 0;
        this.f375432c = null;
        this.f375433d = 0;
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Canesatici canesatici) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canesatici);
            return;
        }
        canesatici.a(this.f375430a, 0);
        canesatici.a(this.f375431b, 1);
        canesatici.a((Collection) this.f375432c, 2);
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Caelum caelum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) caelum);
            return;
        }
        this.f375430a = caelum.a(this.f375430a, 0, true);
        this.f375431b = caelum.a(this.f375431b, 1, true);
        if (f375429e == null) {
            ArrayList<Blackberry> arrayList = new ArrayList<>();
            f375429e = arrayList;
            arrayList.add(new Blackberry());
        }
        this.f375432c = (ArrayList) caelum.a((Caelum) f375429e, 2, true);
    }
}
