package com.tencent.mobileqq.troop.api.config;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ab {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f293947a;

    /* renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f293948b;

    /* renamed from: c, reason: collision with root package name */
    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_IMCoreTroopInfoServiceConfig.yml", version = 1)
    private static ArrayList<Class<? extends i>> f293949c;

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<i> f293950d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45313);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293947a = new Object();
        f293948b = new AtomicBoolean(false);
        ArrayList<Class<? extends i>> arrayList = new ArrayList<>();
        f293949c = arrayList;
        arrayList.add(com.tencent.mobileqq.activity.troop.a.class);
        f293950d = new ArrayList<>();
    }

    public static void a() {
        if (QLog.isColorLevel()) {
            QLog.d("TroopInfoServiceConfig", 2, "call init from ", MobileQQ.processName, " init = ", Boolean.valueOf(f293948b.get()));
        }
        synchronized (f293947a) {
            if (f293948b.get()) {
                return;
            }
            b();
            f293948b.set(true);
        }
    }

    private static void b() {
        ArrayList<Class<? extends i>> arrayList = f293949c;
        if (arrayList != null) {
            Iterator<Class<? extends i>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293950d.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.e("TroopInfoServiceConfig", 1, "Init Fail,", th5);
                }
            }
        }
    }

    public static void c(String str, TroopInfo troopInfo) {
        ArrayList<i> arrayList = f293950d;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(str, troopInfo);
            }
        }
    }
}
