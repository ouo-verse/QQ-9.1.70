package com.tencent.mobileqq.troop.api.config;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class al {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<t> f293975a;

    /* renamed from: b, reason: collision with root package name */
    private static al f293976b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45324);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f293975a = new ArrayList<>();
        }
    }

    al() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            b();
        }
    }

    public static al a() {
        if (f293976b == null) {
            synchronized (al.class) {
                if (f293976b == null) {
                    f293976b = new al();
                }
            }
        }
        return f293976b;
    }

    private static void b() {
        ArrayList<Class<? extends t>> arrayList = com.tencent.mobileqq.imcore.config.extension.a.f238017j;
        if (arrayList != null) {
            Iterator<Class<? extends t>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293975a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("TroopTokenHandlerProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(@NonNull AppInterface appInterface, @NonNull String str, @NonNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, str, obj);
            return;
        }
        Iterator<t> it = f293975a.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, str, obj);
        }
    }
}
