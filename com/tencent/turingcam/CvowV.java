package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class CvowV extends yLOCn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f381754a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<uAnWx> f381755b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f381756c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f381757d;

    /* renamed from: e, reason: collision with root package name */
    public sUvea f381758e;

    /* renamed from: f, reason: collision with root package name */
    public String f381759f;

    /* renamed from: g, reason: collision with root package name */
    public int f381760g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19678);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            new ArrayList().add(new uAnWx());
            new HashMap().put("", "");
        }
    }

    public CvowV() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381754a = "";
        this.f381755b = null;
        this.f381756c = null;
        this.f381757d = null;
        this.f381758e = null;
        this.f381759f = "";
        this.f381760g = 0;
    }

    @Override // com.tencent.turingcam.yLOCn
    public void a(QjsR0 qjsR0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qjsR0);
            return;
        }
        qjsR0.a(this.f381754a, 0);
        qjsR0.a((Collection) this.f381755b, 1);
        qjsR0.a(this.f381756c, 2);
        Map<String, String> map = this.f381757d;
        if (map != null) {
            qjsR0.a((Map) map, 3);
        }
        sUvea suvea = this.f381758e;
        if (suvea != null) {
            qjsR0.a((yLOCn) suvea, 4);
        }
        String str = this.f381759f;
        if (str != null) {
            qjsR0.a(str, 5);
        }
        qjsR0.a(0, 6);
        qjsR0.a(this.f381760g, 7);
    }
}
