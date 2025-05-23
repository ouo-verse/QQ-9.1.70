package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes19.dex */
public class af {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f293960a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f293961b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<n> f293962c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45321);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293960a = new AtomicBoolean(false);
        f293961b = new Object();
        f293962c = new ArrayList<>();
    }

    public static void a() {
        synchronized (f293961b) {
            if (f293960a.get()) {
                return;
            }
            ArrayList<Class<? extends n>> arrayList = com.tencent.mobileqq.imcore.config.extension.a.f238013f;
            if (arrayList != null) {
                Iterator<Class<? extends n>> it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        f293962c.add(it.next().newInstance());
                    } catch (Throwable th5) {
                        QLog.i("TroopMemberListHandlerProcessorConfig", 1, "Init Fail", th5);
                    }
                }
            }
            f293960a.set(true);
        }
    }

    public static void b(String str, List<TroopMemberInfo> list) {
        Iterator<n> it = f293962c.iterator();
        while (it.hasNext()) {
            it.next().a(str, list);
        }
    }

    public static void c(@NonNull AppInterface appInterface, TroopInfo troopInfo, ArrayList<String> arrayList) {
        Iterator<n> it = f293962c.iterator();
        while (it.hasNext()) {
            it.next().b(appInterface, troopInfo, arrayList);
        }
    }

    public static void d(String str) {
        Iterator<n> it = f293962c.iterator();
        while (it.hasNext()) {
            it.next().c(str);
        }
    }
}
