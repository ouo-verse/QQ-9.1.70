package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes27.dex */
public final class mvP1o extends yLOCn {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList<Integer> f382309e;

    /* renamed from: a, reason: collision with root package name */
    public String f382310a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f382311b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f382312c;

    /* renamed from: d, reason: collision with root package name */
    public String f382313d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        new ArrayList().add("");
        new HashMap().put("", "");
        f382309e = new ArrayList<>();
        f382309e.add(0);
    }

    public mvP1o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382310a = "";
        this.f382311b = null;
        this.f382312c = null;
        this.f382313d = "";
    }

    @Override // com.tencent.turingcam.yLOCn
    public void a(QjsR0 qjsR0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qjsR0);
            return;
        }
        qjsR0.a(this.f382310a, 0);
        qjsR0.a((Collection) this.f382311b, 1);
        qjsR0.a((Map) this.f382312c, 2);
        String str = this.f382313d;
        if (str != null) {
            qjsR0.a(str, 4);
        }
    }
}
