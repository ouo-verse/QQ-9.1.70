package com.tencent.mobileqq.msf.core.stepcount;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class StepCounterConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_SSO_STEP_REPORT = "StepAlarmReceiver_long_time_report";
    public static final String ATTR_ACTIVE_REPORT_INTERVAL = "activeReportInterval";
    public static final String ATTR_HAS_SHUTDOWN_FLAG = "health_has_shutdown_flag";
    public static final String ATTR_IS_REPORT_STEP = "health_is_report_step";
    public static final String ATTR_LAST_SENSOR_EVENT_TIME = "health_last_sensor_event_time";
    public static final String ATTR_MAX_RECORD_DAYS = "maxRecordDays";
    public static final String ATTR_PASSIVE_REPORT_INTERVAL = "passiveReportInterval";
    public static final String ATTR_STEP_CADENCE = "stepCadence";
    public static final String ATTR_STEP_COUNTER_ENABLE = "health_step_counter_enable";
    public static final String ATTR_STEP_COUNTER_MODE = "stepCounterMode";
    public static final String ATTR_STEP_COUNT_HISTORY = "health_step_count_history";
    public static final String ATTR_STEP_REPORT_CALLER = "health_step_report_caller";
    public static final String BEACON_PARAM_KEY_DATA1 = "data1";
    public static final String BEACON_PARAM_KEY_DATA2 = "data2";
    public static final String BEACON_PARAM_KEY_EXT0 = "ext0";
    public static final String BEACON_PARAM_KEY_EXT1 = "ext1";
    public static final String BEACON_PARAM_KEY_EXT2 = "ext2";
    public static final String BEACON_PARAM_KEY_SRC_ID = "src_id";
    public static final String CMD_HEALTH_SWITCH = "cmd_health_switch";
    public static final String CMD_REFRESH_STEPS = "cmd_refresh_steps";
    public static final String CMD_RESET_STEP = "cmd_reset_step";
    public static final String CMD_UPDATE_CONFIG = "cmd_step_update_config";
    public static final String CMD_UPDATE_LAST_REPORT_TIME = "cmd_update_lastreport_time";
    public static final int DEFAULT_ACTIVE_REPORT_INTERVAL = 600;
    public static final int DEFAULT_MAX_RECORD_DAYS = 7;
    public static final int DEFAULT_PASSIVE_REPORT_INTERVAL = 1200;
    public static final int DEFAULT_STEP_CADENCE = 300;
    public static final int DEFAULT_STEP_COUNTER_MODE = 0;
    public static final int STEP_COUNTER_MODE_ATTACH = 1;
    public static final int STEP_COUNTER_MODE_DISABLE = 0;
    public static final int STEP_COUNTER_MODE_ENABLE = 2;
    public static final int STEP_REPORT_CALLER_LEBA = 6;
    public static final int STEP_REPORT_CALLER_LOGIN = 5;
    public static final int STEP_REPORT_CALLER_NEW_MAIN = 7;
    public static final int STEP_REPORT_CALLER_NEW_SENSOR = 8;
    public static final int STEP_REPORT_CALLER_PA = 2;
    public static final int STEP_REPORT_CALLER_SENSOR = 1;
    public static final int STEP_REPORT_CALLER_TIME_NEW_DAY = 4;
    public static final int STEP_REPORT_CALLER_TIME_PEAK = 3;
    public static final int STEP_REPORT_CALLER_UNKNOWN = -1;

    public StepCounterConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
