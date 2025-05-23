package com.tencent.mobileqq.app.msgcache;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class CacheConstants {
    static IPatchRedirector $redirector_ = null;
    public static int CACHE_TYPE_A = 0;
    public static int CACHE_TYPE_A_NUM = 0;
    public static int CACHE_TYPE_B = 0;
    public static int CACHE_TYPE_B_NUM = 0;
    protected static int MESSAGE_AFTER_DEL_COUNT = 0;
    public static final int MESSAGE_CACHE_INIT_AHEAD_NUM = 15;
    protected static int MESSAGE_MAX_COUNT = 0;
    protected static final int MESSAGE_OP_DELAY_TIME = 300000;
    public static long MONITOR_LOGIN_TIME = 0;
    public static int MONITOR_MAINTAIN_COUNT = 0;
    public static int MONITOR_MAX_APPEAR_COUNT = 0;
    public static String MSGLRUCACHE_MONITER_LOGIN = null;
    public static int MSG_CACHE_INIT_ADJUST_SWITCH_DEGREE = 0;
    public static int MSG_LRU_CACHE_SWITCH_DEGREE = 0;
    public static int OP_WEIGHT_GET = 0;
    public static int OP_WEIGHT_GET_AIO = 0;
    protected static int OP_WEIGHT_INIT = 0;
    protected static int OP_WEIGHT_MAX = 0;
    protected static int OP_WEIGHT_MIN = 0;
    public static int OP_WEIGHT_SCAN = 0;
    public static final int REPORT_OPEN_AIO_INTENAL = 14400000;
    public static String SP_KEY_CACHEINITADJUST_SWITCH;
    public static String SP_KEY_MSGLRUCACHE_SWITCH;
    public static String SP_KEY_REPORT_AIO_LAST_TIME;
    public static String SP_MSGLRUCACHE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40451);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SP_MSGLRUCACHE = "sp_msglrucache";
        SP_KEY_MSGLRUCACHE_SWITCH = "sp_key_msglrucache_switch";
        SP_KEY_CACHEINITADJUST_SWITCH = "sp_key_cacheinitadjust_switch";
        SP_KEY_REPORT_AIO_LAST_TIME = "sp_key_report_aio_last_time";
        MESSAGE_MAX_COUNT = 1600;
        MESSAGE_AFTER_DEL_COUNT = 1400;
        CACHE_TYPE_A = 1;
        CACHE_TYPE_B = 2;
        CACHE_TYPE_A_NUM = 40;
        CACHE_TYPE_B_NUM = 20;
        OP_WEIGHT_MAX = 10;
        OP_WEIGHT_MIN = 0;
        OP_WEIGHT_INIT = 5;
        OP_WEIGHT_SCAN = -1;
        OP_WEIGHT_GET_AIO = 2;
        OP_WEIGHT_GET = 1;
        MSG_LRU_CACHE_SWITCH_DEGREE = 0;
        MSG_CACHE_INIT_ADJUST_SWITCH_DEGREE = 1;
        MSGLRUCACHE_MONITER_LOGIN = "msglrucacheMoniterLogin";
        MONITOR_MAINTAIN_COUNT = 100;
        MONITOR_MAX_APPEAR_COUNT = 10;
        MONITOR_LOGIN_TIME = 60000L;
    }

    public CacheConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getTypeFromKey(String str) {
        if (str != null) {
            try {
                if (str.contains(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
                    if (split.length >= 2) {
                        return Integer.valueOf(split[1]).intValue();
                    }
                    return 0;
                }
                return 0;
            } catch (Exception e16) {
                e16.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static String getUinFromKey(String str) {
        if (str != null && str.contains(ContainerUtils.FIELD_DELIMITER)) {
            return str.split(ContainerUtils.FIELD_DELIMITER)[0];
        }
        return str;
    }
}
