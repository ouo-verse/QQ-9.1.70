package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Segment extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList<Shaddock> f383062e;

    /* renamed from: a, reason: collision with root package name */
    public long f383063a;

    /* renamed from: b, reason: collision with root package name */
    public int f383064b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<Shaddock> f383065c;

    /* renamed from: d, reason: collision with root package name */
    public int f383066d;

    public Segment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383063a = 0L;
        this.f383064b = 0;
        this.f383065c = null;
        this.f383066d = 0;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f383063a, 0);
        solar.a(this.f383064b, 1);
        solar.a((Collection) this.f383065c, 2);
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serpens);
            return;
        }
        this.f383063a = serpens.a(this.f383063a, 0, true);
        this.f383064b = serpens.a(this.f383064b, 1, true);
        if (f383062e == null) {
            ArrayList<Shaddock> arrayList = new ArrayList<>();
            f383062e = arrayList;
            arrayList.add(new Shaddock());
        }
        this.f383065c = (ArrayList) serpens.a((Serpens) f383062e, 2, true);
    }
}
