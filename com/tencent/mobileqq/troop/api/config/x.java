package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<e> f293993a;

    /* renamed from: b, reason: collision with root package name */
    private static x f293994b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45310);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f293993a = new ArrayList<>();
        }
    }

    x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            b();
        }
    }

    public static x a() {
        if (f293994b == null) {
            synchronized (x.class) {
                if (f293994b == null) {
                    f293994b = new x();
                }
            }
        }
        return f293994b;
    }

    private static void b() {
        ArrayList<Class<? extends e>> arrayList = com.tencent.mobileqq.imcore.config.extension.a.f238016i;
        if (arrayList != null) {
            Iterator<Class<? extends e>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293993a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("TroopBatchInfoHandlerProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(@NonNull AppInterface appInterface, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) troopInfo);
            return;
        }
        Iterator<e> it = f293993a.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, troopInfo);
        }
    }
}
