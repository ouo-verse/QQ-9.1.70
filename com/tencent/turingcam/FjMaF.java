package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class FjMaF extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList<TUmP8> f381824e;

    /* renamed from: a, reason: collision with root package name */
    public long f381825a;

    /* renamed from: b, reason: collision with root package name */
    public int f381826b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<TUmP8> f381827c;

    /* renamed from: d, reason: collision with root package name */
    public int f381828d;

    public FjMaF() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381825a = 0L;
        this.f381826b = 0;
        this.f381827c = null;
        this.f381828d = 0;
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f381825a, 0);
        xjpd8.a(this.f381826b, 1);
        xjpd8.a((Collection) this.f381827c, 2);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) yunKQ);
            return;
        }
        this.f381825a = yunKQ.a(this.f381825a, 0, true);
        this.f381826b = yunKQ.a(this.f381826b, 1, true);
        if (f381824e == null) {
            ArrayList<TUmP8> arrayList = new ArrayList<>();
            f381824e = arrayList;
            arrayList.add(new TUmP8());
        }
        this.f381827c = (ArrayList) yunKQ.a((YunKQ) f381824e, 2, true);
    }
}
