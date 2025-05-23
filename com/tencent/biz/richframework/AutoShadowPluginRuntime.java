package com.tencent.biz.richframework;

import android.app.Application;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;

@Deprecated
/* loaded from: classes5.dex */
public class AutoShadowPluginRuntime {
    private static volatile AutoShadowPluginRuntime sPluginGlobalConfig;
    private Application mApplication;

    public AutoShadowPluginRuntime() {
        if (RFWApplication.getApplication() instanceof Application) {
            this.mApplication = RFWApplication.getApplication();
        }
    }

    public static AutoShadowPluginRuntime getInstance() {
        if (sPluginGlobalConfig == null) {
            synchronized (AutoShadowPluginRuntime.class) {
                if (sPluginGlobalConfig == null) {
                    sPluginGlobalConfig = new AutoShadowPluginRuntime();
                }
            }
        }
        return sPluginGlobalConfig;
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public void setApplication(Application application) {
        this.mApplication = application;
    }
}
