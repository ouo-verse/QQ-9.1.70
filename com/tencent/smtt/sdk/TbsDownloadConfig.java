package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TbsDownloadConfig {
    public static final int CMD_ID_DOWNLOAD_FILE = 101;
    public static final int CMD_ID_FILE_UPLOAD = 100;
    public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400;
    public static final int ERROR_DOWNLOAD = 2;
    public static final int ERROR_INSTALL = 5;
    public static final int ERROR_LOAD = 6;
    public static final int ERROR_NONE = 1;
    public static final int ERROR_REPORTED = 0;
    public static final int ERROR_UNZIP = 4;
    public static final int ERROR_VERIFY = 3;
    public static final int KEY_TODO = -1;

    /* renamed from: a, reason: collision with root package name */
    private static TbsDownloadConfig f369086a;

    /* renamed from: b, reason: collision with root package name */
    private Context f369087b;
    public SharedPreferences mPreferences;

    /* renamed from: c, reason: collision with root package name */
    private int f369088c = 0;
    public Map<String, Object> mSyncMap = new HashMap();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface TbsConfigKey {
        public static final String KEY_APP_METADATA = "app_metadata";
        public static final String KEY_APP_VERSIONCODE = "app_versioncode";
        public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
        public static final String KEY_APP_VERSIONNAME = "app_versionname";
        public static final String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
        public static final String KEY_COUNT_REQUEST_FAIL_IN_24HOURS = "count_request_fail_in_24hours";
        public static final String KEY_CPUTYPE_OTHER_STABLE_CORE = "tbs_cpu_type_other_stable_core";
        public static final String KEY_DECOUPLECOREVERSION = "tbs_decouplecoreversion";
        public static final String KEY_DESkEY_TOKEN = "tbs_deskey_token";
        public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
        public static final String KEY_DOWNLOADDECOUPLECORE = "tbs_downloaddecouplecore";
        public static final String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
        public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
        public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
        public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
        public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
        public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
        public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
        public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
        public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
        public static final String KEY_FULL_PACKAGE = "request_full_package";
        public static final String KEY_GUID = "tbs_guid";
        public static final String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
        public static final String KEY_IS_OVERSEA = "is_oversea";
        public static final String KEY_LAST_CHECK = "last_check";
        public static final String KEY_LAST_DOWNLOAD_DECOUPLE_CORE = "last_download_decouple_core";
        public static final String KEY_LAST_DOWNLOAD_STABLE_CORE_OTHER_CPU = "last_download_stable_core_other_cpu";
        public static final String KEY_LAST_REQUEST_SUCCESS = "last_request_success";
        public static final String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
        public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
        public static final String KEY_REQUEST_FAIL = "request_fail";
        public static final String KEY_RESPONSECODE = "tbs_responsecode";
        public static final String KEY_RETRY_INTERVAL = "retry_interval";
        public static final String KEY_STOP_PRE_OAT = "tbs_stop_preoat";
        public static final String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
        public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
        public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
        public static final String KEY_TBSDOWLOAD_FLOWCTR = "tbs_flowctr";
        public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
        public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
        public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
        public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE = "tbs_core_load_rename_file_lock_wait_enable";
        public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
        public static final String KEY_TBS_DOWNLOAD_V_TYPE = "tbs_download_version_type";
        public static final String KEY_USE_BACKUP_VERSION = "use_backup_version";
        public static final String KEY_USE_BUGLY = "tbs_use_bugly";
        public static final String KEY_USE_X5 = "use_x5";
    }

    TbsDownloadConfig(Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_config", 4);
        Context applicationContext = context.getApplicationContext();
        this.f369087b = applicationContext;
        if (applicationContext == null) {
            this.f369087b = context;
        }
    }

    public static synchronized TbsDownloadConfig getInstance(Context context) {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            if (f369086a == null) {
                f369086a = new TbsDownloadConfig(context);
            }
            tbsDownloadConfig = f369086a;
        }
        return tbsDownloadConfig;
    }

    public void clear() {
        try {
            this.mSyncMap.clear();
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.clear();
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public synchronized void commit() {
        try {
            SharedPreferences.Editor edit = this.mPreferences.edit();
            for (String str : this.mSyncMap.keySet()) {
                Object obj = this.mSyncMap.get(str);
                if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                }
            }
            edit.commit();
            this.mSyncMap.clear();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public synchronized long getBackupCoreMinFreeSpace() {
        int i3;
        try {
            i3 = 0;
            int i16 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, 0);
            if (i16 != 0) {
                i3 = i16;
            }
        } catch (Exception unused) {
            return 0L;
        }
        return (i3 * 1024 * 1024) + 209715200;
    }

    public int getCurrentDownloadInterruptCode() {
        return this.f369088c;
    }

    public synchronized int getDownloadFailedMaxRetrytimes() {
        int i3;
        i3 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, 0);
        if (i3 == 0) {
            i3 = 100;
        }
        return i3;
    }

    public synchronized int getDownloadInterruptCode() {
        int i3;
        if (!this.mPreferences.contains(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE)) {
            try {
                if (!new File(new File(this.f369087b.getFilesDir(), "shared_prefs"), "tbs_download_config").exists()) {
                    i3 = -97;
                } else if (!this.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD)) {
                    i3 = -96;
                } else {
                    i3 = -101;
                }
            } catch (Throwable unused) {
                i3 = -95;
            }
        } else {
            i3 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, -99);
            if (i3 == -119 || i3 == -121) {
                i3 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -119);
            }
            if (System.currentTimeMillis() - this.mPreferences.getLong(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_TIME, 0L) > 86400000) {
                i3 -= 98000;
            }
        }
        Context context = this.f369087b;
        if (context != null && "com.tencent.mobileqq".equals(context.getApplicationInfo().packageName) && !LocaleManager.MOBILE_COUNTRY_CODE_CN_STR.equals(Locale.getDefault().getCountry())) {
            return -320;
        }
        return (i3 * 1000) + this.mPreferences.getInt(TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, -1);
    }

    public synchronized long getDownloadMaxflow() {
        int i3;
        i3 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, 0);
        if (i3 == 0) {
            i3 = 20;
        }
        return i3 * 1024 * 1024;
    }

    public synchronized long getDownloadMinFreeSpace() {
        int i3;
        i3 = 0;
        int i16 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, 0);
        if (i16 != 0) {
            i3 = i16;
        }
        return i3 * 1024 * 1024;
    }

    public synchronized long getDownloadSingleTimeout() {
        long j3;
        j3 = this.mPreferences.getLong(TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, 0L);
        if (j3 == 0) {
            j3 = ShortVideoConstants.VIDEO_MAX_DURATION;
        }
        return j3;
    }

    public synchronized int getDownloadSuccessMaxRetrytimes() {
        int i3;
        i3 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, 0);
        if (i3 == 0) {
            i3 = 3;
        }
        return i3;
    }

    public synchronized long getRetryInterval() {
        if (TbsDownloader.getRetryIntervalInSeconds() >= 0) {
            return TbsDownloader.getRetryIntervalInSeconds();
        }
        int cfgRequestMinInterval = TbsPVConfig.getInstance(this.f369087b).getCfgRequestMinInterval();
        if (cfgRequestMinInterval >= 0) {
            return cfgRequestMinInterval;
        }
        return this.mPreferences.getLong(TbsConfigKey.KEY_RETRY_INTERVAL, 86400L);
    }

    public synchronized boolean getTbsCoreLoadRenameFileLockWaitEnable() {
        boolean z16;
        z16 = true;
        try {
            z16 = this.mPreferences.getBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, true);
        } catch (Exception unused) {
        }
        return z16;
    }

    public synchronized boolean isOverSea() {
        return this.mPreferences.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
    }

    public void saveDownloadInterruptCode() {
        try {
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.putInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, this.f369088c);
            edit.putLong(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_TIME, System.currentTimeMillis());
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public synchronized void setDownloadInterruptCode(int i3) {
        this.f369088c = i3;
    }

    public synchronized void setInstallInterruptCode(int i3) {
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putInt(TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, i3);
        edit.commit();
    }

    public synchronized void setTbsCoreLoadRenameFileLockWaitEnable(boolean z16) {
        try {
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.putBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, z16);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    public static synchronized TbsDownloadConfig getInstance() {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            tbsDownloadConfig = f369086a;
        }
        return tbsDownloadConfig;
    }

    @Deprecated
    public void uploadDownloadInterruptCodeIfNeeded(Context context) {
    }
}
