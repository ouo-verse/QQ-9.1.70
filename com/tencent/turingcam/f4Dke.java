package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f4Dke extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static qbihQ f382208e;

    /* renamed from: f, reason: collision with root package name */
    public static ArrayList<kGAMq> f382209f;

    /* renamed from: a, reason: collision with root package name */
    public int f382210a;

    /* renamed from: b, reason: collision with root package name */
    public int f382211b;

    /* renamed from: c, reason: collision with root package name */
    public qbihQ f382212c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<kGAMq> f382213d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21332);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382208e = new qbihQ();
        ArrayList<kGAMq> arrayList = new ArrayList<>();
        f382209f = arrayList;
        arrayList.add(new kGAMq());
    }

    public f4Dke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382210a = 0;
        this.f382211b = 0;
        this.f382212c = null;
        this.f382213d = null;
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new f4Dke() : (UMDtK) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) xjpd8);
            return;
        }
        int i3 = this.f382210a;
        if (i3 != 0) {
            xjpd8.a(i3, 0);
        }
        int i16 = this.f382211b;
        if (i16 != 0) {
            xjpd8.a(i16, 1);
        }
        qbihQ qbihq = this.f382212c;
        if (qbihq != null) {
            xjpd8.a((UMDtK) qbihq, 2);
        }
        ArrayList<kGAMq> arrayList = this.f382213d;
        if (arrayList != null) {
            xjpd8.a((Collection) arrayList, 3);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382210a = yunKQ.a(this.f382210a, 0, false);
        this.f382211b = yunKQ.a(this.f382211b, 1, false);
        this.f382212c = (qbihQ) yunKQ.a((UMDtK) f382208e, 2, false);
        this.f382213d = (ArrayList) yunKQ.a((YunKQ) f382209f, 3, false);
    }
}
