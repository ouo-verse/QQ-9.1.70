package com.tencent.mobileqq.qsec.qsecurity;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QSecConfig {
    static IPatchRedirector $redirector_ = null;
    public static byte[] CONFIG_KEY_BUF = null;
    public static int CONFIG_KEY_ID = 0;
    public static int CONFIG_TIME_GAP = 0;
    public static final int CONST_CONFIG_TASK_ID = 1;
    public static final int CONST_HEARTBEAT_TASK_ID = 0;
    public static final int CONST_KEYEXCHANGE_TASK_ID = 2;
    public static final int CONST_LUA_TASK_ID = 3;
    public static final int CONST_REPORT_TASK_ID = 4;
    public static final int DO_TYPE_DELE = 4;
    public static final int DO_TYPE_INIT = 3;
    public static final int DO_TYPE_START = 1;
    public static final int DO_TYPE_STOP = 2;
    public static int HEART_BEAT_SEQ_NUM;
    public static String business_guid;
    public static String business_o3did;
    public static int business_os;
    public static String business_q36;
    public static String business_qua;
    public static String business_seed;
    public static String business_uin;
    public static Context sContext;
    public static int sign_strategy;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20351);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HEART_BEAT_SEQ_NUM = 0;
        CONFIG_TIME_GAP = 5000;
        CONFIG_KEY_ID = 0;
        CONFIG_KEY_BUF = null;
        sContext = null;
        sign_strategy = 0;
        business_os = 1;
        business_guid = "";
        business_q36 = "";
        business_qua = "";
    }

    public QSecConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void setupBusinessInfo(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        sContext = context;
        business_qua = str6;
        business_uin = str;
        business_guid = str2;
        business_seed = str3;
        business_o3did = str4;
        business_q36 = str5;
    }
}
