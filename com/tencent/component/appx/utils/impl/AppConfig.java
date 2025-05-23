package com.tencent.component.appx.utils.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.component.appx.utils.IAppConfig;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AppConfig implements IAppConfig {
    private static final String SSO_CONF_DIR = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
    private static final String SSO_CONF_FILENAME = "testserver";
    private static final String TAG = "AppConfig";
    Context context;
    private Logger logger = LoggerFactory.getLogger(TAG);
    String versionName = null;
    int versionCode = 0;

    public AppConfig(Context context) {
        this.context = context;
    }

    @Override // com.tencent.component.appx.utils.IAppConfig
    public int getVersionCode() {
        if (this.versionCode == 0) {
            try {
                this.versionCode = InstalledAppListMonitor.getPackageInfo(this.context.getPackageManager(), this.context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e16) {
                this.logger.warn(e16.getMessage());
            }
        }
        return this.versionCode;
    }

    @Override // com.tencent.component.appx.utils.IAppConfig
    public String getVersionName() {
        if (this.versionName == null) {
            try {
                this.versionName = InstalledAppListMonitor.getPackageInfo(this.context.getPackageManager(), this.context.getPackageName(), 0).versionName;
            } catch (Exception unused) {
                this.versionName = "unknown";
            }
        }
        return this.versionName;
    }

    @Override // com.tencent.component.appx.utils.IAppConfig
    public boolean isDebugEnv() {
        return false;
    }

    @Override // com.tencent.component.appx.utils.IAppConfig
    public boolean isTestEnv() {
        return new File(SSO_CONF_DIR, SSO_CONF_FILENAME).exists();
    }
}
