package com.tencent.mobileqq.onlinestatus.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.AutoReplyManagerImpl;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.EventOnlineStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.util.af;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusManagerServiceImpl implements IOnlineStatusManagerService {
    private static boolean hasInit = false;
    private HashMap<String, com.tencent.mobileqq.onlinestatus.manager.j> mMgrMaps = new HashMap<>(4, 0.75f);

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService
    public void addConfigUpdateListener(ec2.d dVar) {
        if (dVar == null) {
            return;
        }
        com.tencent.mobileqq.onlinestatus.manager.t.f255980a.e(dVar);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService
    public <T extends com.tencent.mobileqq.onlinestatus.manager.j> T getManager(Class<T> cls) {
        return (T) this.mMgrMaps.get(cls.getName());
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        if (hasInit) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(new Throwable("OnlineStatusManagerService Create repeat"), appRuntime.toString());
        }
        QLog.d("OnlineStatusManagerServiceImpl", 1, "onCreate, appRuntime: ", appRuntime.toString(), " isLogin: ", Boolean.valueOf(appRuntime.isLogin()));
        if (appRuntime.isLogin()) {
            AppInterface appInterface = (AppInterface) appRuntime;
            this.mMgrMaps.put(com.tencent.mobileqq.onlinestatus.manager.f.class.getName(), new OnlineStatusDataManager(appInterface));
            this.mMgrMaps.put(com.tencent.mobileqq.onlinestatus.manager.e.class.getName(), new com.tencent.mobileqq.onlinestatus.manager.k());
            this.mMgrMaps.put(com.tencent.mobileqq.onlinestatus.manager.i.class.getName(), new OnlineStatusPermissionManager(appInterface));
            this.mMgrMaps.put(com.tencent.mobileqq.onlinestatus.manager.b.class.getName(), new AutoReplyManagerImpl(appInterface));
            this.mMgrMaps.put(com.tencent.mobileqq.onlinestatus.manager.h.class.getName(), new com.tencent.mobileqq.onlinestatus.manager.u(appInterface));
            this.mMgrMaps.put(com.tencent.mobileqq.onlinestatus.manager.d.class.getName(), new EventOnlineStatusManager(appInterface));
            this.mMgrMaps.put(com.tencent.mobileqq.onlinestatus.manager.g.class.getName(), new com.tencent.mobileqq.onlinestatus.manager.o());
        }
        hasInit = true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        Iterator<com.tencent.mobileqq.onlinestatus.manager.j> it = this.mMgrMaps.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        if (af.i()) {
            com.tencent.mobileqq.onlinestatus.manager.t.f255980a.g();
        }
        hasInit = false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService
    public void removeConfigUpdateListener(ec2.d dVar) {
        if (dVar == null) {
            return;
        }
        com.tencent.mobileqq.onlinestatus.manager.t.f255980a.k(dVar);
    }
}
