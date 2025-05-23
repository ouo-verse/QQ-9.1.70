package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes19.dex */
public class v {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f293987a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f293988b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<com.tencent.mobileqq.troop.api.config.b> f293989c;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static v f293990a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45305);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f293990a = new v(null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45306);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f293987a = new AtomicBoolean(false);
        f293988b = new Object();
        f293989c = new ArrayList<>();
    }

    /* synthetic */ v(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
    }

    public static v a() {
        return b.f293990a;
    }

    private static void b() {
        ArrayList<Class<? extends com.tencent.mobileqq.troop.api.config.b>> arrayList = com.tencent.mobileqq.imcore.config.extension.a.f238011d;
        if (arrayList != null) {
            Iterator<Class<? extends com.tencent.mobileqq.troop.api.config.b>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293989c.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("TroopAddFriendHandlerProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(@NonNull AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface);
            return;
        }
        Iterator<com.tencent.mobileqq.troop.api.config.b> it = f293989c.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface);
        }
    }

    public void d(@NonNull AppInterface appInterface, String str, HashMap<String, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, str, hashMap);
            return;
        }
        Iterator<com.tencent.mobileqq.troop.api.config.b> it = f293989c.iterator();
        while (it.hasNext()) {
            it.next().b(appInterface, str, hashMap);
        }
    }

    v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
