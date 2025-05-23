package com.qzone.misc.web.webview;

import android.os.Bundle;
import com.qzone.common.account.LoginData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.l;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneWebViewRuntime extends AppInterface {

    /* renamed from: d, reason: collision with root package name */
    private EntityManagerFactory f48627d;

    public QzoneWebViewRuntime(BaseApplicationImpl baseApplicationImpl, String str) {
        super(baseApplicationImpl, str);
    }

    @Override // mqq.app.AppRuntime
    public String getAccount() {
        return getCurrentAccountUin();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        return BaseApplication.getContext();
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return 0;
    }

    @Override // mqq.app.AppRuntime
    public MobileQQ getApplication() {
        return BaseApplicationImpl.getApplication();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return LoginData.getInstance().getUinString();
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        String uinString = LoginData.getInstance().getUinString();
        if (uinString != null) {
            synchronized (this) {
                if (this.f48627d == null) {
                    l d16 = l.d(uinString, super.getEntityManagerFactory());
                    d16.verifyAuthentication();
                    this.f48627d = d16;
                }
            }
            return this.f48627d;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    @Override // mqq.app.AppRuntime
    public Manager getManager(int i3) {
        AppRuntime qZoneRuntime = LoginData.getInstance().getQZoneRuntime();
        if (qZoneRuntime != null) {
            return qZoneRuntime.getManager(i3);
        }
        return null;
    }

    @Override // mqq.app.AppRuntime
    public boolean isLogin() {
        AppRuntime qZoneRuntime = LoginData.getInstance().getQZoneRuntime();
        if (qZoneRuntime != null) {
            return qZoneRuntime.isLogin();
        }
        return false;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QzoneWebViewPluginManager.getInstance().initApp(this);
    }
}
