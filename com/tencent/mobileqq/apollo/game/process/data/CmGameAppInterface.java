package com.tencent.mobileqq.apollo.game.process.data;

import android.content.Intent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.l;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.IToolProcEventListener;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CmGameAppInterface extends BaseToolAppInterface implements IToolProcEventListener {

    /* renamed from: d, reason: collision with root package name */
    private EntityManagerFactory f194375d;

    /* renamed from: e, reason: collision with root package name */
    private Map<Integer, Manager> f194376e;

    public CmGameAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        this.f194376e = new HashMap(20);
        QLog.i("CmGameAppInterface", 1, "new CmGameAppInterface obj.");
    }

    private Manager f(int i3) {
        Manager manager = this.f194376e.get(Integer.valueOf(i3));
        if (manager != null) {
            return manager;
        }
        synchronized (this.f194376e) {
            if (i3 == QQManagerFactory.DOWNLOADER_FACTORY) {
                manager = new DownloaderFactory(this);
            }
            if (this.f194376e.get(Integer.valueOf(i3)) != null) {
                manager = this.f194376e.get(Integer.valueOf(i3));
            } else if (manager != null) {
                this.f194376e.put(Integer.valueOf(i3), manager);
            }
        }
        return manager;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        if (this.f194375d == null) {
            this.f194375d = l.d(getAccount(), super.getEntityManagerFactory());
        }
        return this.f194375d;
    }

    @Override // mqq.app.AppRuntime
    public synchronized Manager getManager(int i3) {
        Manager f16;
        f16 = f(i3);
        if (f16 == null) {
            f16 = super.getManager(i3);
        }
        return f16;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        return "cmshowgame_module";
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        synchronized (this.f194376e) {
            Set<Integer> keySet = this.f194376e.keySet();
            if (keySet.size() == 0) {
                return;
            }
            Iterator<Integer> it = keySet.iterator();
            while (it.hasNext()) {
                Manager manager = this.f194376e.get(it.next());
                if (manager != null) {
                    try {
                        manager.onDestroy();
                    } catch (Exception e16) {
                        QLog.e("CmGameAppInterface", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY, e16);
                    }
                }
            }
            this.f194376e.clear();
        }
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveLegalExitProcAction(Intent intent) {
        return false;
    }

    @Override // mqq.app.IToolProcEventListener
    public void onBeforeExitProc() {
        QLog.i("CmGameAppInterface", 1, "[onBeforeExitProc]");
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveAccountAction(String str, Intent intent) {
        QLog.i("CmGameAppInterface", 1, "[onReceiveAccountAction]");
        return false;
    }
}
