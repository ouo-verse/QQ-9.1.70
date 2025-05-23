package com.tencent.halley.common.a.b;

import com.tencent.halley.common.a.h;
import com.tencent.halley.common.utils.d;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    private static int a(int i3, String str, int i16, Map<String, String> map) {
        String str2;
        int i17 = 100;
        if (i3 == 0 && map != null && com.tencent.halley.common.f.a.a(str, i16, map)) {
            map.put("B28", "1");
            str2 = "report_req_ssl_first_denominator_value";
        } else {
            String str3 = i3 == 0 ? "report_req_succ_denominator_value" : b(i3) ? "report_req_nonet_fail_denominator_value" : "report_req_other_fail_denominator_value";
            if (i3 != 0 && !b(i3)) {
                i17 = 1;
            }
            str2 = str3;
        }
        return a(str2, i17);
    }

    private static int b(String str, int i3) {
        if (str.equals("HLDisconnEvent")) {
            return -2;
        }
        return c((i3 == 0 || b(i3)) ? "self_report_succ_denominator_value" : "self_report_fail_denominator_value", (i3 == 0 || b(i3)) ? 100 : 2);
    }

    private static int c(int i3) {
        String str = i3 == 0 ? "report_conn_succ_denominator_value" : b(i3) ? "report_conn_nonet_fail_denominator_value" : "report_conn_other_fail_denominator_value";
        int i16 = 100;
        if (i3 != 0 && !b(i3)) {
            i16 = 1;
        }
        return a(str, i16);
    }

    private static int d(int i3) {
        String str;
        int i16;
        if (i3 == 0) {
            str = "report_security_req_succ_denominator_value";
        } else {
            str = "report_security_req_fail_denominator_value";
        }
        if (i3 == 0) {
            i16 = 100;
        } else {
            i16 = 1;
        }
        return a(str, i16);
    }

    private static int e(int i3) {
        String str;
        if (i3 == 0) {
            str = "report_msg_push_succ_denominator_value";
        } else {
            str = "report_msg_push_fail_denominator_value";
        }
        return a(str, 1);
    }

    public static int a(String str, int i3) {
        int a16 = h.a("report_all_events", -1, 1, 1);
        if (a16 == 1) {
            return 1;
        }
        if (a16 == -1) {
            return 0;
        }
        return c(str, i3);
    }

    private static boolean b(int i3) {
        return i3 == -4 || i3 == -3 || i3 == -288;
    }

    private static int c(String str, int i3) {
        int a16 = h.a(str, 0, Integer.MAX_VALUE, i3);
        d.b("halley-cloud-SamplingUtils", "getReportDenominatorValue for key:" + str + ",default:" + i3 + ",denominator:" + a16);
        return a16;
    }

    public static int a(String str, int i3, int i16, Map<String, String> map) {
        if (i3 == 2) {
            return b(str, i16);
        }
        if ("HLHttpDirect".equals(str) && map != null && "event".equals(map.get("B15"))) {
            return b(str, i16);
        }
        if ("HLConnEvent".equals(str)) {
            return c(i16);
        }
        if ("HLSecurityEvent".equals(str)) {
            return d(i16);
        }
        if ("HLDisconnEvent".equals(str)) {
            return a("report_disconn_denominator_value", 2);
        }
        if ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str) || "HLHttpDirect".equals(str)) {
            return a(i16, str, i3, map);
        }
        if ("HLPushEvent".equals(str)) {
            return a("report_push_denominator_value", 10);
        }
        if ("B_DLSDK_Result".equals(str)) {
            return a("report_mass_download_denominator_value", 1);
        }
        if ("HLDownTiny".equals(str)) {
            return a("report_ease_download_denominator_value", 10);
        }
        if ("HLMsgClickEvent".equals(str) || "HLMsgProcessEvent".equals(str) || "HLMsgDispatchEvent".equals(str)) {
            return e(i16);
        }
        return 0;
    }

    public static boolean a(int i3) {
        return i3 > 0 && i3 <= Integer.MAX_VALUE && new Random().nextInt(i3) == 0;
    }
}
