package com.tencent.mobileqq.loginregister;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class n implements r {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLoginImpl/Inject_login_register_config.yml", version = 1)
    public static ArrayList<Class<? extends r>> f242884b;

    /* renamed from: a, reason: collision with root package name */
    private r f242885a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41305);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        ArrayList<Class<? extends r>> arrayList = new ArrayList<>();
        f242884b = arrayList;
        arrayList.add(m.class);
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QLog.d("EquipLockProxy", 1, "sLockVasClazzList size : ", Integer.valueOf(f242884b.size()));
        try {
            this.f242885a = f242884b.get(0).newInstance();
        } catch (Exception e16) {
            QLog.e("EquipLockProxy", 1, "IEquipLockApi newInstance", e16);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.r
    public int a(AppRuntime appRuntime, Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, appRuntime, context, str, Boolean.valueOf(z16))).intValue();
        }
        return this.f242885a.a(appRuntime, context, str, z16);
    }
}
