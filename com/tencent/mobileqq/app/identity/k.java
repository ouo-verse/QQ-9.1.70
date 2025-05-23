package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class k implements r81.b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQSafeBlockApi/Inject_SecurityBlockConfig.yml", version = 1)
    protected static ArrayList<Class<? extends r81.b>> f195793b;

    /* renamed from: a, reason: collision with root package name */
    private r81.b f195794a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21814);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList<Class<? extends r81.b>> arrayList = new ArrayList<>();
        f195793b = arrayList;
        arrayList.add(j.class);
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            this.f195794a = f195793b.get(0).newInstance();
        } catch (Exception e16) {
            QLog.e("PhoneUnityProxy", 1, "PhoneUnityProxy new instance error : ", e16);
        }
    }

    @Override // r81.b
    public boolean a(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity)).booleanValue();
        }
        return this.f195794a.a(activity);
    }
}
