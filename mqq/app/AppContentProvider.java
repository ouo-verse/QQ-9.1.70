package mqq.app;

import android.app.Application;
import android.content.ContentProvider;
import com.tencent.qphone.base.util.QLog;
import mqq.inject.MqqInjectorManager;

/* loaded from: classes28.dex */
public abstract class AppContentProvider extends ContentProvider {
    public String getModuleId() {
        return null;
    }

    public AppRuntime getRuntime(String str) {
        try {
            return MobileQQ.sMobileQQ.getAppRuntime(str).getAppRuntime(getModuleId());
        } catch (AccountNotMatchException e16) {
            QLog.e("mqq", 2, "AppContentProvider getRuntime, ", e16);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            ((Application) getContext().getApplicationContext()).onCreate();
            return false;
        } catch (Exception e16) {
            QLog.e("mqq", 2, "mqq.app.AppContentProvider.onCreate has exception", e16);
            MqqInjectorManager.instance().postNeedFixStartStepCapturedException(e16);
            return false;
        }
    }
}
