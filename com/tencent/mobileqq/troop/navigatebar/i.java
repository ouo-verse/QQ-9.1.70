package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Troop/Inject_BizTroopCustomizedConfig.yml", version = 1)
    private static ArrayList<Class<? extends d>> f298000b;

    /* renamed from: a, reason: collision with root package name */
    private d f298001a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64668);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ArrayList<Class<? extends d>> arrayList = new ArrayList<>();
        f298000b = arrayList;
        arrayList.add(j.class);
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            this.f298001a = f298000b.get(0).newInstance();
        } catch (Exception e16) {
            QLog.d("TroopNavigateManagerProxy", 1, "TroopNavigateManagerProxy new instance error : ", e16);
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f298001a.a();
        }
    }

    @Override // com.tencent.mobileqq.troop.navigatebar.d
    public TroopAioNavigateBarManager b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopAioNavigateBarManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        d dVar = this.f298001a;
        if (dVar == null) {
            return null;
        }
        return dVar.b();
    }
}
