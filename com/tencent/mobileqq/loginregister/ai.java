package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.login.GatewayVerify$ReqBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ai implements u {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLoginImpl/Inject_login_register_config.yml", version = 1)
    private static ArrayList<Class<? extends u>> f242832b;

    /* renamed from: a, reason: collision with root package name */
    private u f242833a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41448);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ArrayList<Class<? extends u>> arrayList = new ArrayList<>();
        f242832b = arrayList;
        arrayList.add(ak.class);
    }

    public ai() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            if (f242832b.size() > 0) {
                this.f242833a = f242832b.get(0).newInstance();
            }
        } catch (Exception e16) {
            QLog.e("OpenSdkAccountProxy", 1, "OpenSdkAccountProxy newInstance", e16);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.u
    public void a(GatewayVerify$ReqBody gatewayVerify$ReqBody, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gatewayVerify$ReqBody, (Object) str);
            return;
        }
        u uVar = this.f242833a;
        if (uVar != null) {
            uVar.a(gatewayVerify$ReqBody, str);
        }
    }
}
