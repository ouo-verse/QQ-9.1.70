package com.qzone.reborn.util;

import com.tencent.mobileqq.persistence.EntityManager;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes37.dex */
public class c {
    public static EntityManager a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getEntityManagerFactory(peekAppRuntime.getAccount()).createEntityManager();
        }
        return null;
    }
}
