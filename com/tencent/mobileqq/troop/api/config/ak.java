package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ak {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<s> f293973a;

    /* renamed from: b, reason: collision with root package name */
    private static ak f293974b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63874);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f293973a = new ArrayList<>();
        }
    }

    ak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            b();
        }
    }

    public static ak a() {
        if (f293974b == null) {
            synchronized (ak.class) {
                if (f293974b == null) {
                    f293974b = new ak();
                }
            }
        }
        return f293974b;
    }

    private static void b() {
        ArrayList<Class<? extends s>> arrayList = com.tencent.mobileqq.troop.api.config.extension.a.f293979c;
        if (arrayList != null) {
            Iterator<Class<? extends s>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293973a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("TroopSurveyHandlerProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(@NonNull AppInterface appInterface, @NonNull ToServiceMsg toServiceMsg, String str, @NonNull oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, toServiceMsg, str, oidb_sso_oidbssopkg);
            return;
        }
        Iterator<s> it = f293973a.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, toServiceMsg, str, oidb_sso_oidbssopkg);
        }
    }

    public void d(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        Iterator<s> it = f293973a.iterator();
        while (it.hasNext()) {
            it.next().b(str);
        }
    }
}
