package com.tencent.qqmini.sdk.launcher;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.annotation.BindClass;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.LogProxy;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.log.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IBuild;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniServer;
import com.tencent.qqmini.sdk.launcher.shell.IServiceEvent;
import com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.utils.ProcessUtil;
import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class AppLoaderFactory {
    public static final String LOG_FLAG_LIFECYCLE = " [MiniLifecycle] ";
    public static final String TAG = "minisdk-start";
    private static volatile AppLoaderFactory instance;
    private static volatile byte[] lock = new byte[0];

    @BindClass(className = "com.tencent.qqmini.sdk.ipc.AppBrandProxy")
    private IAppBrandProxy appBrandProxy;
    private BaselibLoader baselibLoader;

    @BindClass(className = "com.tencent.qqmini.sdk.core.Build")
    private IBuild build;

    @BindClass(className = "com.tencent.qqmini.sdk.manager.CommonManager")
    private ICommonManager commonManager;
    private boolean hasFieldsInitialized = false;
    private boolean hasFullInitialized = false;
    private volatile Context mContext;
    private String mProcessName;

    @BindClass(className = "com.tencent.qqmini.sdk.core.MiniAppEnv")
    private IMiniAppEnv miniAppEnv;

    @BindClass(className = "com.tencent.qqmini.sdk.cache.MiniCacheFreeManager")
    private IMiniCacheFreeManager miniCacheFreeManager;

    @BindClass(className = "com.tencent.qqmini.sdk.log.LogImpl")
    private Log miniLog;

    @BindClass(className = "com.tencent.qqmini.sdk.server.MiniServer")
    private IMiniServer miniServer;

    @BindClass(className = "com.tencent.qqmini.sdk.core.proxy.FakeProxyManager")
    private IProxyManager proxyManager;

    private void bindFields() {
        bindLogField();
        for (Field field : getClass().getDeclaredFields()) {
            AppBrandUtil.bindField(this, field);
        }
    }

    private void bindLogField() {
        if (QMLog.getLog() != null) {
            return;
        }
        AppBrandUtil.bindField(this, "miniLog");
        QMLog.setLog(this.miniLog);
        QMLog.w(TAG, "QMLog prepared through plan B !");
    }

    public static AppLoaderFactory g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AppLoaderFactory();
                }
            }
        }
        return instance;
    }

    private void prepareQMLog() {
        try {
            Field declaredField = Class.forName("com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope").getDeclaredField("PROXY_SERVICES");
            declaredField.setAccessible(true);
            final LogProxy logProxy = (LogProxy) ((Class) ((HashMap) declaredField.get(null)).get(LogProxy.class)).newInstance();
            QMLog.setLog(new Log() { // from class: com.tencent.qqmini.sdk.launcher.AppLoaderFactory.2
                @Override // com.tencent.qqmini.sdk.launcher.log.Log
                public void d(String str, String str2, Throwable th5) {
                    logProxy.log(2, str, str2, th5);
                }

                @Override // com.tencent.qqmini.sdk.launcher.log.Log
                public void e(String str, String str2, Throwable th5) {
                    logProxy.log(5, str, str2, th5);
                }

                @Override // com.tencent.qqmini.sdk.launcher.log.Log
                public int getLogLevel() {
                    return 1;
                }

                @Override // com.tencent.qqmini.sdk.launcher.log.Log
                public void i(String str, String str2, Throwable th5) {
                    logProxy.log(3, str, str2, th5);
                }

                @Override // com.tencent.qqmini.sdk.launcher.log.Log
                public boolean isColorLevel() {
                    return logProxy.isColorLevel();
                }

                @Override // com.tencent.qqmini.sdk.launcher.log.Log
                public void w(String str, String str2, Throwable th5) {
                    logProxy.log(4, str, str2, th5);
                }
            });
            QMLog.w(TAG, "QMLog prepared!");
        } catch (Throwable th5) {
            QMLog.e(TAG, "bindLogField exception!", th5);
        }
    }

    public Class findClass(String str) {
        return MiniAppDexLoader.g().findClass(str);
    }

    @Deprecated
    public IAppBrandProxy getAppBrandProxy() {
        return this.appBrandProxy;
    }

    public BaselibLoader getBaselibLoader() {
        return this.baselibLoader;
    }

    public ICommonManager getCommonManager() {
        return this.commonManager;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getCurrentProcessName() {
        return getProcessName();
    }

    public IMiniAppEnv getMiniAppEnv() {
        return this.miniAppEnv;
    }

    public IMiniCacheFreeManager getMiniCacheFreeManager() {
        return this.miniCacheFreeManager;
    }

    public IMiniServer getMiniServer() {
        return this.miniServer;
    }

    public IMiniServiceManager getMiniServiceManager() {
        if (isMainProcess()) {
            return getMiniServer().getMiniServiceManager();
        }
        return getMiniAppEnv().getMiniServiceManager();
    }

    public String getProcessName() {
        if (TextUtils.isEmpty(this.mProcessName)) {
            this.mProcessName = ProcessUtil.getProcessName(this.mContext);
        }
        return this.mProcessName;
    }

    public IProxyManager getProxyManager() {
        return this.proxyManager;
    }

    public IBuild getSDKBuild() {
        return this.build;
    }

    public void init(Context context, Configuration configuration) {
        if (this.hasFullInitialized) {
            return;
        }
        this.mContext = context;
        if (context == null) {
            QMLog.i(TAG, " init mContext is null ");
        }
        initFields(context, configuration);
        QMLog.d(TAG, "packageName = " + this.mContext.getPackageName() + ", currentProcessName = " + getCurrentProcessName());
        this.appBrandProxy.init(context, new IServiceEvent() { // from class: com.tencent.qqmini.sdk.launcher.AppLoaderFactory.1
            @Override // com.tencent.qqmini.sdk.launcher.shell.IServiceEvent
            public void onEvent(int i3) {
                QMLog.i(AppLoaderFactory.TAG, "onEvent: " + i3);
            }
        });
        if (isMainProcess()) {
            QMLog.i(TAG, "main process, init MiniServer");
            this.miniServer.init(context, configuration);
        } else {
            QMLog.i(TAG, "sub process, init env.");
            this.miniAppEnv.init(context, configuration);
        }
        this.hasFullInitialized = true;
    }

    public void initFields(Context context, Configuration configuration) {
        if (this.hasFieldsInitialized) {
            return;
        }
        this.mContext = context;
        if (context == null) {
            QMLog.i(TAG, " initFields mContext is null ");
        }
        prepareQMLog();
        MiniAppDexLoader.g().init(context, configuration.dexLoaderEnable, configuration.dexConfig, configuration.localDexEnable);
        MiniAppDexLoader.g().loadDex();
        bindFields();
        this.hasFieldsInitialized = true;
    }

    public boolean isMainProcess() {
        return this.mContext.getPackageName().equals(getCurrentProcessName());
    }

    public void setBaselibLoader(BaselibLoader baselibLoader) {
        if (baselibLoader != null) {
            this.baselibLoader = baselibLoader;
        }
    }
}
