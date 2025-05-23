package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes27.dex */
public final class LJPko extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList<IEttU> f381877d;

    /* renamed from: a, reason: collision with root package name */
    public int f381878a;

    /* renamed from: b, reason: collision with root package name */
    public int f381879b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<IEttU> f381880c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13940);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<IEttU> arrayList = new ArrayList<>();
        f381877d = arrayList;
        arrayList.add(new IEttU());
    }

    public LJPko() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381878a = 0;
        this.f381879b = 0;
        this.f381880c = null;
    }

    @Override // com.tencent.turingcam.UMDtK
    public UMDtK a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new LJPko() : (UMDtK) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) xjpd8);
            return;
        }
        int i3 = this.f381878a;
        if (i3 != 0) {
            xjpd8.a(i3, 0);
        }
        int i16 = this.f381879b;
        if (i16 != 0) {
            xjpd8.a(i16, 1);
        }
        ArrayList<IEttU> arrayList = this.f381880c;
        if (arrayList != null) {
            xjpd8.a((Collection) arrayList, 2);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) yunKQ);
            return;
        }
        this.f381878a = yunKQ.a(this.f381878a, 0, false);
        this.f381879b = yunKQ.a(this.f381879b, 1, false);
        this.f381880c = (ArrayList) yunKQ.a((YunKQ) f381877d, 2, false);
    }
}
