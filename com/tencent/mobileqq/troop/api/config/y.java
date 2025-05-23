package com.tencent.mobileqq.troop.api.config;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class y {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Object f293995a;

    /* renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f293996b;

    /* renamed from: c, reason: collision with root package name */
    @ConfigInject(configPath = "IMCore/src/main/resources/Inject_IMCoreTroopCommonConfig.yml", version = 1)
    private static ArrayList<Class<? extends f>> f293997c;

    /* renamed from: d, reason: collision with root package name */
    private static f f293998d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45311);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f293995a = new Object();
        f293996b = new AtomicBoolean(false);
        ArrayList<Class<? extends f>> arrayList = new ArrayList<>();
        f293997c = arrayList;
        arrayList.add(com.tencent.mobileqq.activity.troop.b.class);
        f293998d = null;
    }

    public static void a() {
        if (QLog.isColorLevel()) {
            QLog.d("TroopCommonCofig", 2, "call init from ", MobileQQ.processName, " init = ", Boolean.valueOf(f293996b.get()));
        }
        synchronized (f293995a) {
            if (f293996b.get()) {
                return;
            }
            b();
            f293996b.set(true);
        }
    }

    private static void b() {
        ArrayList<Class<? extends f>> arrayList = f293997c;
        if (arrayList != null && arrayList.size() == 1) {
            try {
                f293998d = f293997c.get(0).newInstance();
                return;
            } catch (Throwable th5) {
                QLog.e("TroopCommonCofig", 1, "Init Fail,", th5);
            }
        }
        QLog.e("TroopCommonCofig", 1, "Init Fail,", "TroopCommonConfig");
    }

    public static boolean c(AppRuntime appRuntime, TroopInfo troopInfo, boolean z16) {
        boolean z17;
        f fVar = f293998d;
        if (fVar != null) {
            z17 = fVar.a(appRuntime, troopInfo, z16);
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopCommonCofig", 2, "needGetMemberListForFTS(need:" + z17 + "), troop: " + troopInfo.getTroopUin() + " " + troopInfo.troopname + " wMemberNum: " + troopInfo.wMemberNum);
        }
        return z17;
    }
}
