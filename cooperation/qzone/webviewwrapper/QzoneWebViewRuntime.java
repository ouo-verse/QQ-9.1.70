package cooperation.qzone.webviewwrapper;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.l;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneWebViewRuntime extends AppInterface {
    private EntityManagerFactory emFactory;

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
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            return runtime.getAccount();
        }
        return null;
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        String account = getAccount();
        if (account != null) {
            synchronized (this) {
                if (this.emFactory == null) {
                    l d16 = l.d(account, super.getEntityManagerFactory());
                    d16.verifyAuthentication();
                    this.emFactory = d16;
                }
            }
            return this.emFactory;
        }
        throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }

    @Override // mqq.app.AppRuntime
    public Manager getManager(int i3) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            return runtime.getManager(i3);
        }
        return null;
    }

    @Override // mqq.app.AppRuntime
    public boolean isLogin() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null) {
            return runtime.isLogin();
        }
        return false;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QzoneWebViewPluginManager.getInstance().initApp(this);
    }
}
