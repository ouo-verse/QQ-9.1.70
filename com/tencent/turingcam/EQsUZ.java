package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class EQsUZ extends yLOCn {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<uAnWx> f381792a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f381793b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21166);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            new ArrayList().add(new uAnWx());
            new HashMap().put("", "");
        }
    }

    public EQsUZ() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381792a = null;
            this.f381793b = null;
        }
    }

    @Override // com.tencent.turingcam.yLOCn
    public void a(QjsR0 qjsR0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qjsR0);
            return;
        }
        qjsR0.a("", 0);
        qjsR0.a((Collection) this.f381792a, 1);
        Map<String, String> map = this.f381793b;
        if (map != null) {
            qjsR0.a((Map) map, 2);
        }
    }
}
