package com.tencent.rfix.loader.storage;

import android.content.Context;

/* loaded from: classes25.dex */
public class RFixGlobalPreferences extends AbsStorableInfo {
    public static final String KEY_AUTO_VERIFY_ENABLE = "key_auto_verify_enable";
    public static final String KEY_DISABLE_CONFIG = "key_disable_config";
    public static final String KEY_DUMMY_APP_UID = "key_dummy_app_uid";
    public static final String KEY_DUMMY_APP_VERSION = "key_dummy_app_version";
    private static final String KEY_LAST_INSTALL_RETRY_COUNT = "key_last_install_retry_count";
    private static final String KEY_LAST_INSTALL_VERSION = "key_last_install_version";
    private static final String KEY_SAFE_MODE_INTERCEPT_VERSION = "key_safe_mode_intercept_version";
    public static final String KEY_TEST_ENV_ENABLE = "key_test_env";
    public boolean autoVerifyEnable;
    public boolean disableConfig;
    public String dummyAppUid;
    public String dummyAppVersion;
    public int lastInstallRetryCount;
    public String lastInstallVersion;
    public String safeModeInterceptVersion;
    public boolean testEnvEnable;

    public RFixGlobalPreferences(Context context) {
        super(context, "rfix_global_preferences");
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void loadStoreInfo() {
        super.loadStoreInfo();
        this.testEnvEnable = this.storage.getBoolean("key_test_env", false);
        this.disableConfig = this.storage.getBoolean(KEY_DISABLE_CONFIG, false);
        this.autoVerifyEnable = this.storage.getBoolean(KEY_AUTO_VERIFY_ENABLE, false);
        this.dummyAppVersion = this.storage.getString(KEY_DUMMY_APP_VERSION, null);
        this.dummyAppUid = this.storage.getString(KEY_DUMMY_APP_UID, null);
        this.safeModeInterceptVersion = this.storage.getString(KEY_SAFE_MODE_INTERCEPT_VERSION, null);
        this.lastInstallVersion = this.storage.getString(KEY_LAST_INSTALL_VERSION, null);
        this.lastInstallRetryCount = this.storage.getInt(KEY_LAST_INSTALL_RETRY_COUNT, 0);
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void saveStoreInfo() {
        this.storage.putBoolean("key_test_env", this.testEnvEnable);
        this.storage.putBoolean(KEY_DISABLE_CONFIG, this.disableConfig);
        this.storage.putBoolean(KEY_AUTO_VERIFY_ENABLE, this.autoVerifyEnable);
        this.storage.putString(KEY_DUMMY_APP_VERSION, this.dummyAppVersion);
        this.storage.putString(KEY_DUMMY_APP_UID, this.dummyAppUid);
        this.storage.putString(KEY_SAFE_MODE_INTERCEPT_VERSION, this.safeModeInterceptVersion);
        this.storage.putString(KEY_LAST_INSTALL_VERSION, this.lastInstallVersion);
        this.storage.putInt(KEY_LAST_INSTALL_RETRY_COUNT, this.lastInstallRetryCount);
        super.saveStoreInfo();
    }
}
