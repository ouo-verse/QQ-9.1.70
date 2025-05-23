package com.tencent.qidian.controller;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final String f342852e;

    /* renamed from: d, reason: collision with root package name */
    public int f342853d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77543);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f342852e = a.class.getName();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342853d = hashCode();
        }
    }

    protected void a(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void b(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void c(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void d(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
    }

    protected void f(boolean z16, PubAccountNavigationMenu pubAccountNavigationMenu) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), pubAccountNavigationMenu);
        }
    }

    protected void g(boolean z16, QidianHandler.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void j(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void k(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void l(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void m(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), hashMap);
        }
    }

    protected void n(boolean z16, HashMap<String, Object> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), hashMap);
        }
    }

    @Override // com.tencent.qidian.controller.b, com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1018) {
            if (i3 != 1019) {
                if (i3 != 2001) {
                    if (i3 != 3001) {
                        switch (i3) {
                            case 1001:
                                i(z16, (HashMap) obj);
                                return;
                            case 1002:
                                n(z16, (HashMap) obj);
                                return;
                            case 1003:
                                j(z16, (HashMap) obj);
                                return;
                            case 1004:
                                a(z16, (HashMap) obj);
                                return;
                            case 1005:
                                b(z16, (HashMap) obj);
                                return;
                            case 1006:
                                if (obj != null) {
                                    g(z16, (QidianHandler.b) obj);
                                    return;
                                } else {
                                    g(z16, null);
                                    return;
                                }
                            case 1007:
                                c(z16, (HashMap) obj);
                                return;
                            case 1008:
                                m(z16, (HashMap) obj);
                                return;
                            case 1009:
                                h(z16, (HashMap) obj);
                                return;
                            case 1010:
                                k(z16, (HashMap) obj);
                                return;
                            default:
                                return;
                        }
                    }
                    f(z16, (PubAccountNavigationMenu) obj);
                    return;
                }
                e(z16);
                return;
            }
        } else {
            l(z16, (HashMap) obj);
        }
        d(z16, (HashMap) obj);
    }
}
