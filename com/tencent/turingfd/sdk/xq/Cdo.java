package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.do, reason: invalid class name */
/* loaded from: classes27.dex */
public final class Cdo extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static ArrayList<String> f383315g;

    /* renamed from: h, reason: collision with root package name */
    public static ArrayList<String> f383316h;

    /* renamed from: a, reason: collision with root package name */
    public int f383317a;

    /* renamed from: b, reason: collision with root package name */
    public int f383318b;

    /* renamed from: c, reason: collision with root package name */
    public int f383319c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f383320d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f383321e;

    /* renamed from: f, reason: collision with root package name */
    public String f383322f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13579);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        f383315g = arrayList;
        arrayList.add("");
        ArrayList<String> arrayList2 = new ArrayList<>();
        f383316h = arrayList2;
        arrayList2.add("");
    }

    public Cdo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383317a = 0;
        this.f383318b = 0;
        this.f383319c = 0;
        this.f383320d = null;
        this.f383321e = null;
        this.f383322f = "";
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f383317a, 0);
        int i3 = this.f383318b;
        if (i3 != 0) {
            solar.a(i3, 1);
        }
        int i16 = this.f383319c;
        if (i16 != 0) {
            solar.a(i16, 2);
        }
        ArrayList<String> arrayList = this.f383320d;
        if (arrayList != null) {
            solar.a((Collection) arrayList, 3);
        }
        ArrayList<String> arrayList2 = this.f383321e;
        if (arrayList2 != null) {
            solar.a((Collection) arrayList2, 4);
        }
        String str = this.f383322f;
        if (str != null) {
            solar.a(str, 5);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) serpens);
            return;
        }
        this.f383317a = serpens.a(this.f383317a, 0, false);
        this.f383318b = serpens.a(this.f383318b, 1, false);
        this.f383319c = serpens.a(this.f383319c, 2, false);
        this.f383320d = (ArrayList) serpens.a((Serpens) f383315g, 3, false);
        this.f383321e = (ArrayList) serpens.a((Serpens) f383316h, 4, false);
        this.f383322f = serpens.b(5, false);
    }
}
