package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class aj {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<r> f293971a;

    /* renamed from: b, reason: collision with root package name */
    private static aj f293972b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63872);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f293971a = new ArrayList<>();
        }
    }

    aj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            b();
        }
    }

    public static aj a() {
        if (f293972b == null) {
            synchronized (aj.class) {
                if (f293972b == null) {
                    f293972b = new aj();
                }
            }
        }
        return f293972b;
    }

    private static void b() {
        ArrayList<Class<? extends r>> arrayList = com.tencent.mobileqq.troop.api.config.extension.a.f293978b;
        if (arrayList != null) {
            Iterator<Class<? extends r>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293971a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("TroopRedDotHandlerProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(@NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) str);
            return;
        }
        Iterator<r> it = f293971a.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, str);
        }
    }

    public void d(@NonNull AppInterface appInterface, long j3, @NonNull com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, Long.valueOf(j3), aVar);
            return;
        }
        Iterator<r> it = f293971a.iterator();
        while (it.hasNext()) {
            it.next().b(appInterface, j3, aVar);
        }
    }
}
