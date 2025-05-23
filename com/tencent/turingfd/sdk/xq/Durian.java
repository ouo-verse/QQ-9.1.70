package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Durian extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static List<String> f382725k;

    /* renamed from: l, reason: collision with root package name */
    public static List<String> f382726l;

    /* renamed from: a, reason: collision with root package name */
    public int f382727a;

    /* renamed from: b, reason: collision with root package name */
    public String f382728b;

    /* renamed from: c, reason: collision with root package name */
    public long f382729c;

    /* renamed from: d, reason: collision with root package name */
    public int f382730d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f382731e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f382732f;

    /* renamed from: g, reason: collision with root package name */
    public int f382733g;

    /* renamed from: h, reason: collision with root package name */
    public String f382734h;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f382735i;

    /* renamed from: j, reason: collision with root package name */
    public List<String> f382736j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f382725k = arrayList;
        arrayList.add("");
        ArrayList arrayList2 = new ArrayList();
        f382726l = arrayList2;
        arrayList2.add("");
    }

    public Durian() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382727a = 0;
        this.f382728b = "";
        this.f382729c = 0L;
        this.f382730d = 0;
        this.f382731e = null;
        this.f382732f = null;
        this.f382733g = 0;
        this.f382734h = "";
        this.f382735i = null;
        this.f382736j = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f382727a, 0);
        String str = this.f382728b;
        if (str != null) {
            solar.a(str, 1);
        }
        solar.a(this.f382729c, 2);
        solar.a(this.f382730d, 3);
        byte[] bArr = this.f382731e;
        if (bArr != null) {
            solar.a(bArr, 4);
        }
        byte[] bArr2 = this.f382732f;
        if (bArr2 != null) {
            solar.a(bArr2, 5);
        }
        solar.a(this.f382733g, 6);
        String str2 = this.f382734h;
        if (str2 != null) {
            solar.a(str2, 7);
        }
        List<String> list = this.f382735i;
        if (list != null) {
            solar.a((Collection) list, 8);
        }
        List<String> list2 = this.f382736j;
        if (list2 != null) {
            solar.a((Collection) list2, 9);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Durian)) {
            return false;
        }
        Durian durian = (Durian) obj;
        if (Triangulum.a(this.f382727a, durian.f382727a) && this.f382728b.equals(durian.f382728b) && Triangulum.a(this.f382729c, durian.f382729c) && Triangulum.a(this.f382730d, durian.f382730d) && this.f382731e.equals(durian.f382731e) && this.f382732f.equals(durian.f382732f) && Triangulum.a(this.f382733g, durian.f382733g) && this.f382734h.equals(durian.f382734h) && this.f382735i.equals(durian.f382735i) && this.f382736j.equals(durian.f382736j)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) serpens);
            return;
        }
        this.f382727a = serpens.a(this.f382727a, 0, true);
        this.f382728b = serpens.b(1, false);
        this.f382729c = serpens.a(this.f382729c, 2, false);
        this.f382730d = serpens.a(this.f382730d, 3, false);
        this.f382731e = serpens.a(4, false);
        this.f382732f = serpens.a(5, false);
        this.f382733g = serpens.a(this.f382733g, 6, false);
        this.f382734h = serpens.b(7, false);
        this.f382735i = (List) serpens.a((Serpens) f382725k, 8, false);
        this.f382736j = (List) serpens.a((Serpens) f382726l, 9, false);
    }
}
