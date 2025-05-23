package com.tencent.mobileqq.signature;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.richstatus.k;
import com.tencent.mobileqq.vas.inject.ISignatureStatusManager;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f288429b;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_ISignatureStatusManager.yml", version = 2)
    public ISignatureStatusManager f288430a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f288429b = arrayList;
        arrayList.add(k.class);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            a();
        }
    }

    @QAutoInitMethod
    void a() {
        this.f288430a = (ISignatureStatusManager) com.tencent.mobileqq.qroute.utils.b.a(f288429b);
    }
}
