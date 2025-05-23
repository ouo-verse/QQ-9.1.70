package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class XnM3A extends yLOCn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f382098a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<uAnWx> f382099b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f382100c;

    /* renamed from: d, reason: collision with root package name */
    public sUvea f382101d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18200);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            new ArrayList().add(new uAnWx());
        }
    }

    public XnM3A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382098a = "";
        this.f382099b = null;
        this.f382100c = null;
        this.f382101d = null;
    }

    @Override // com.tencent.turingcam.yLOCn
    public void a(QjsR0 qjsR0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qjsR0);
            return;
        }
        qjsR0.a(this.f382098a, 0);
        qjsR0.a((Collection) this.f382099b, 1);
        byte[] bArr = this.f382100c;
        if (bArr != null) {
            qjsR0.a(bArr, 2);
        }
        sUvea suvea = this.f382101d;
        if (suvea != null) {
            qjsR0.a((yLOCn) suvea, 3);
        }
    }
}
