package com.tencent.ark.open.delegate;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.Logger;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkDelegateManager {
    private static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static final String TAG = "ArkApp.ArkDelegateManager";
    Config mConfig;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Config {
        public ark.ApplicationCallback applicationCallback;
        public Context context;
        public ArkViewImplement.InputCallback inputCallback;
        public IArkDelegateNet netDelegate;
        public String processName;
        public String qqVersion;
        public String rootDir;
        public IArkDelegateSetup setupDelegate;
        public IArkDelegateSSO ssoDelegate;

        public boolean isValid() {
            if (!TextUtils.isEmpty(this.rootDir) && this.processName != null && this.context != null && this.setupDelegate != null && this.inputCallback != null && this.applicationCallback != null && this.netDelegate != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static final ArkDelegateManager gInstance = new ArkDelegateManager();

        Holder() {
        }
    }

    public static ArkDelegateManager getInstance() {
        return Holder.gInstance;
    }

    public static boolean setupArkEnvironment(boolean z16) {
        IArkDelegateSetup setupDelegate = getInstance().getSetupDelegate();
        if (setupDelegate != null) {
            setupDelegate.setupArkEnvironment(z16);
            return true;
        }
        return false;
    }

    public ark.ApplicationCallback getApplicationCallback() {
        Config config = this.mConfig;
        if (config == null) {
            return null;
        }
        return config.applicationCallback;
    }

    public Context getApplicationContext() {
        Context context;
        Config config = this.mConfig;
        if (config == null || (context = config.context) == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public ArkViewImplement.InputCallback getInputCallback() {
        Config config = this.mConfig;
        if (config == null) {
            return null;
        }
        return config.inputCallback;
    }

    public IArkDelegateNet getNetDelegate() {
        Config config = this.mConfig;
        if (config == null) {
            return null;
        }
        return config.netDelegate;
    }

    public String getProcessName() {
        return this.mConfig.processName;
    }

    public IArkDelegateSSO getSSODelegate() {
        Config config = this.mConfig;
        if (config == null) {
            return null;
        }
        return config.ssoDelegate;
    }

    public IArkDelegateSetup getSetupDelegate() {
        Config config = this.mConfig;
        if (config == null) {
            return null;
        }
        return config.setupDelegate;
    }

    public boolean init(Config config) {
        if (!config.isValid()) {
            return false;
        }
        this.mConfig = config;
        setupArkEnvironment(true);
        ArkUtil.createDir(config.rootDir);
        ArkEnvironmentManager.getInstance().setRootDirecotry(config.rootDir);
        ArkEnvironmentManager.getInstance().setQQVersion(config.qqVersion);
        Logger.logI(TAG, "ark init with dir:" + config.rootDir + ", process=" + config.processName + ", qqVersion=" + config.qqVersion);
        return true;
    }
}
