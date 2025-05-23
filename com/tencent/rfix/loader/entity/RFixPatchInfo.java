package com.tencent.rfix.loader.entity;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.storage.AbsStorableInfo;

/* loaded from: classes25.dex */
public class RFixPatchInfo extends AbsStorableInfo {
    private static final String CONFIG_ID = "config_id";
    private static final String CONFIG_TYPE = "config_type";
    private static final String EFFECT_IMMEDIATE = "effectImmediate";
    private static final String ENABLE_ASSERT_DEX = "enable_assert_dex";
    private static final String ENABLE_ASSERT_LIB = "enable_assert_lib";
    private static final String ENABLE_ASSERT_RES = "enable_assert_res";
    private static final String LAST_CONFIG_ID = "last_config_id";
    private static final String LAST_DOWNLOAD_RESULT = "last_download_result";
    private static final String LAST_INSTALL_RESULT = "last_install_result";
    private static final String MAIN_VERIFIED = "main_verified";
    private static final String PATCH_ID = "patch_id";
    private static final String PATCH_PROCESS = "patch_process";
    private static final String PATCH_TYPE = "patch_type";
    public static final String PATCH_TYPE_QFIX = "QFix";
    public static final String PATCH_TYPE_REDIRECT = "Redirect";
    public static final String PATCH_TYPE_TINKER = "Tinker";
    private static final String REMOVE_PATCH = "remove_patch";
    private static final String TAG = "RFix.RFixPatchInfo";
    public static final int UNINITIALIZED = -100;
    private static final String VERSION = "version";
    public int configId;
    public int configType;
    public boolean effectImmediate;
    public boolean enableAssertDex;
    public boolean enableAssertLib;
    public boolean enableAssertRes;
    public int lastConfigId;
    public int lastDownloadResult;
    public int lastInstallResult;
    public boolean mainVerified;
    public String patchId;
    public String patchProcess;
    public String patchType;
    public boolean removePatch;
    public String version;

    public RFixPatchInfo(Context context) {
        super(context, "rfix_patch_info", true, true);
    }

    public static boolean patchTypeValid(String str) {
        if (!PATCH_TYPE_QFIX.equals(str) && !PATCH_TYPE_REDIRECT.equals(str) && !PATCH_TYPE_TINKER.equals(str)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void loadStoreInfo() {
        synchronized (RFixPatchInfo.class) {
            super.loadStoreInfo();
        }
        this.lastConfigId = this.storage.getInt(LAST_CONFIG_ID, -100);
        this.lastDownloadResult = this.storage.getInt(LAST_DOWNLOAD_RESULT, -100);
        this.lastInstallResult = this.storage.getInt(LAST_INSTALL_RESULT, -100);
        this.configId = this.storage.getInt(CONFIG_ID, 0);
        this.configType = this.storage.getInt(CONFIG_TYPE, 0);
        this.patchProcess = this.storage.getString(PATCH_PROCESS, null);
        this.version = this.storage.getString("version", null);
        this.patchType = this.storage.getString(PATCH_TYPE, null);
        this.patchId = this.storage.getString(PATCH_ID, null);
        this.effectImmediate = this.storage.getBoolean(EFFECT_IMMEDIATE, false);
        this.enableAssertDex = this.storage.getBoolean("enable_assert_dex", false);
        this.enableAssertLib = this.storage.getBoolean("enable_assert_lib", false);
        this.enableAssertRes = this.storage.getBoolean("enable_assert_res", false);
        this.removePatch = this.storage.getBoolean(REMOVE_PATCH, false);
        this.mainVerified = this.storage.getBoolean(MAIN_VERIFIED, false);
        RFixLog.i(TAG, "loadStoreInfo " + this);
    }

    @Override // com.tencent.rfix.loader.storage.AbsStorableInfo
    public void saveStoreInfo() {
        this.storage.putInt(LAST_CONFIG_ID, this.lastConfigId);
        this.storage.putInt(LAST_DOWNLOAD_RESULT, this.lastDownloadResult);
        this.storage.putInt(LAST_INSTALL_RESULT, this.lastInstallResult);
        this.storage.putInt(CONFIG_ID, this.configId);
        this.storage.putInt(CONFIG_TYPE, this.configType);
        this.storage.putString(PATCH_PROCESS, this.patchProcess);
        this.storage.putString("version", this.version);
        this.storage.putString(PATCH_TYPE, this.patchType);
        this.storage.putString(PATCH_ID, this.patchId);
        this.storage.putBoolean(EFFECT_IMMEDIATE, this.effectImmediate);
        this.storage.putBoolean("enable_assert_dex", this.enableAssertDex);
        this.storage.putBoolean("enable_assert_lib", this.enableAssertLib);
        this.storage.putBoolean("enable_assert_res", this.enableAssertRes);
        this.storage.putBoolean(REMOVE_PATCH, this.removePatch);
        this.storage.putBoolean(MAIN_VERIFIED, this.mainVerified);
        synchronized (RFixPatchInfo.class) {
            super.saveStoreInfo();
        }
        RFixLog.i(TAG, "saveStoreInfo " + this);
    }

    @NonNull
    public String toString() {
        return "RFixPatchInfo{lastConfigId=" + this.lastConfigId + ", lastDownloadResult=" + this.lastDownloadResult + ", lastInstallResult=" + this.lastInstallResult + ", configId=" + this.configId + ", configType=" + this.configType + ", patchProcess=" + this.patchProcess + ", version=" + this.version + ", patchType=" + this.patchType + ", patchId=" + this.patchId + ", effectImmediate=" + this.effectImmediate + ", enableAssertDex=" + this.enableAssertDex + ", enableAssertLib=" + this.enableAssertLib + ", enableAssertRes=" + this.enableAssertRes + ", removePatch=" + this.removePatch + ", mainVerified=" + this.mainVerified + '}';
    }
}
