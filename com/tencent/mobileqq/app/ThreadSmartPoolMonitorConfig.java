package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ThreadSmartPoolMonitorConfig {
    static IPatchRedirector $redirector_ = null;
    protected static final String BEACON_KEY_JOB_COST = "jobCost";
    protected static final String BEACON_KEY_JOB_INFO = "jobInfo";
    protected static final String BEACON_KEY_JOB_NAME = "jobName";
    protected static final String BEACON_KEY_JOB_STACK = "jobStacktrace";
    protected static final String BEACON_KEY_JOB_TYPE = "jobType";
    protected static final String BEACON_KEY_REVISION = "revision";
    protected static final String BEACON_KEY_THREAD_POOL_BLOCK_MONITOR = "threadPoolBlockingMonitor";
    protected static final String CONFIG_ENABLE_KEY = "ThreadPoolMonitorConfigEnable";
    protected static final String CONFIG_KEY = "PoolMonitorConfig";
    private static final long DEFAULT_BLOCKING_TIME_THRESHOLD = 30000;
    private static final int DEFAULT_BLOCK_TIMES_THRESHOLD = 1;
    private static final long DEFAULT_CHECK_PERIOD = 30000;
    private static final long DEFAULT_JOB_REPORT_TIME_THRESHOLD = 60000;
    protected static final String FILE_COMMON = "common_mmkv_configurations";
    protected static final String GENERAL_THREAD = "GeneralThread";
    private static final String KEY_BLOCKING_TIME_THRESHOLD = "blockingTimeThreshold";
    private static final String KEY_BLOCK_TIMES_THRESHOLD = "blockTimesThreshold";
    private static final String KEY_CHECK_PERIOD = "checkPeriod";
    private static final String KEY_JOB_REPORT_TIME_THRESHOLD = "jobReportTimeThreshold";
    private static final String TAG = "ThreadSmartPoolMonitorConfig";
    private int blockTimesThreshold;
    private long blockingTimeThreshold;
    private long checkPeriod;
    private boolean isFeatureSwitchEnable;
    private long jobReportTimeThreshold;

    public ThreadSmartPoolMonitorConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isFeatureSwitchEnable = false;
        this.jobReportTimeThreshold = 20000L;
        this.blockingTimeThreshold = 30000L;
        this.checkPeriod = 30000L;
        this.blockTimesThreshold = 1;
    }

    public static boolean getMonitorFeatureSwitchState() {
        return false;
    }

    private void initConfig() {
        this.isFeatureSwitchEnable = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeBool(CONFIG_ENABLE_KEY, false);
        QLog.d(TAG, 2, "ThreadSmartPoolMonitorConfig CONFIG_ENABLE_KEY:" + this.isFeatureSwitchEnable);
    }

    public static ThreadSmartPoolMonitorConfig parse(String str) {
        JSONObject jSONObject;
        ThreadSmartPoolMonitorConfig threadSmartPoolMonitorConfig = new ThreadSmartPoolMonitorConfig();
        QLog.d(TAG, 2, str + " needReportBlock:" + threadSmartPoolMonitorConfig.isFeatureSwitchEnable);
        if (threadSmartPoolMonitorConfig.isFeatureSwitchEnable) {
            try {
                JSONObject jSONObject2 = new JSONObject(QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeString(CONFIG_KEY, ""));
                if (jSONObject2.has(str)) {
                    jSONObject = jSONObject2.getJSONObject(str);
                } else {
                    QLog.d(TAG, 2, "Don't have " + str + " config, use general config");
                    jSONObject = jSONObject2.getJSONObject(GENERAL_THREAD);
                }
                QLog.d(TAG, 2, str + " config content:" + jSONObject);
                threadSmartPoolMonitorConfig.blockingTimeThreshold = jSONObject.optLong(KEY_BLOCKING_TIME_THRESHOLD, 30000L);
                threadSmartPoolMonitorConfig.checkPeriod = jSONObject.optLong(KEY_CHECK_PERIOD, 30000L);
                threadSmartPoolMonitorConfig.blockTimesThreshold = jSONObject.optInt(KEY_BLOCK_TIMES_THRESHOLD, 1);
                threadSmartPoolMonitorConfig.jobReportTimeThreshold = jSONObject.optLong(KEY_JOB_REPORT_TIME_THRESHOLD, 60000L);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "parse config error:" + e16);
            }
        }
        return threadSmartPoolMonitorConfig;
    }

    public static void setConfigData(Map<String, String> map) {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        if (map != null && !map.isEmpty()) {
            String str = map.get(CONFIG_KEY);
            if (TextUtils.isEmpty(str)) {
                QLog.d(TAG, 1, "data error, PoolMonitorConfig is empty.");
                return;
            }
            QLog.d(TAG, 2, "setConfigData:" + str);
            from.encodeBool(CONFIG_ENABLE_KEY, true);
            from.encodeString(CONFIG_KEY, str);
            return;
        }
        from.encodeBool(CONFIG_ENABLE_KEY, false);
    }

    public int getBlockTimesThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.blockTimesThreshold;
    }

    public long getBlockingTimeThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.blockingTimeThreshold;
    }

    public long getCheckPeriod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.checkPeriod;
    }

    public boolean getFeatureSwitchState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isFeatureSwitchEnable;
    }

    public long getJobReportTimeThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.jobReportTimeThreshold;
    }
}
