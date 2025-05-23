package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoticonOperateReport {
    static IPatchRedirector $redirector_ = null;
    public static final String REPORT_TAG_0X800AE20 = "0X800AE20";
    public static final String REPORT_TAG_0X800AE21 = "0X800AE21";
    public static final String REPORT_TAG_0X800AE22 = "0X800AE22";
    public static final String REPORT_TAG_0X800AE23 = "0X800AE23";
    public static final String REPORT_TAG_0X800AE24 = "0X800AE24";
    public static final String REPORT_TAG_0X800AE25 = "0X800AE25";
    public static final String REPORT_TAG_0X800AE27 = "0X800AE27";
    public static final String REPORT_TAG_0X800AE28 = "0X800AE28";
    public static final String REPORT_TAG_0X800AE29 = "0X800AE29";
    public static final String REPORT_TAG_0X800AE2A = "0X800AE2A";
    public static final String REPORT_TAG_0X800AE2B = "0X800AE2B";
    public static final String REPORT_TAG_0X800AE2C = "0X800AE2C";
    public static final String REPORT_TAG_0X800AE2E = "0X800AE2E";
    public static final String REPORT_TAG_0X800AE2F = "0X800AE2F";
    public static final String REPORT_TAG_0X800AE30 = "0X800AE30";
    public static final String REPORT_TAG_0X800AE31 = "0X800AE31";
    public static final String REPORT_TAG_0X800AE32 = "0X800AE32";
    public static final String REPORT_TAG_0X800AE33 = "0X800AE33";

    public EmoticonOperateReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reportAIOEmoticonMonitor(String str, String str2, int i3) {
        boolean z16;
        boolean z17;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            boolean equals = "0".equals(str);
            if (equals) {
                hashMap.put("receiveSuccess", str);
            } else {
                hashMap.put("receiveError", str);
            }
            z17 = equals;
        } else {
            if (!TextUtils.isEmpty(str2)) {
                z16 = "0".equals(str2);
                if (z16) {
                    hashMap.put("sendSuccess", str2);
                } else {
                    hashMap.put("sendError", str2);
                }
            } else {
                z16 = false;
            }
            z17 = z16;
        }
        hashMap.put("type", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), StatisticCollector.AIO_EMOTICON_MONITOR, z17, 0L, 0L, hashMap, null);
    }

    public static void reportAIOEmoticonMonitorReceiveStatus(String str, int i3) {
        reportAIOEmoticonMonitor(str, null, i3);
    }

    public static void reportAIOEmoticonMonitorSendStatus(String str, int i3) {
        reportAIOEmoticonMonitor(null, str, i3);
    }

    public static void reportEmoticonOperateMonitor(String str, String str2, String str3, int i3) {
        boolean z16;
        boolean z17;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            boolean equals = "0".equals(str);
            if (equals) {
                hashMap.put("addScucess", str);
            } else {
                hashMap.put("addError", str);
            }
            z17 = equals;
        } else {
            if (!TextUtils.isEmpty(str2)) {
                z16 = "0".equals(str2);
                if (z16) {
                    hashMap.put("deleteSuccess", str2);
                } else {
                    hashMap.put("deleteError", str2);
                }
            } else if (!TextUtils.isEmpty(str3)) {
                z16 = "0".equals(str3);
                if (z16) {
                    hashMap.put("getScucess", str3);
                } else {
                    hashMap.put("getError", str3);
                }
            } else {
                z16 = false;
            }
            z17 = z16;
        }
        hashMap.put("type", String.valueOf(i3));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), StatisticCollector.EMOTICON_OPERATE_MONITOR, z17, 0L, 0L, hashMap, null);
    }

    public static void reportEmoticonOperateMonitorAddStatus(String str, int i3) {
        reportEmoticonOperateMonitor(str, null, null, i3);
    }

    public static void reportEmoticonOperateMonitorDeleteStatus(String str, int i3) {
        reportEmoticonOperateMonitor(null, str, null, i3);
    }

    public static void reportEmoticonOperateMonitorGetStatus(String str, int i3) {
        reportEmoticonOperateMonitor(null, null, str, i3);
    }

    public static void reportFavAddEmotionEvent(AppInterface appInterface, int i3, String str, String str2) {
        String str3;
        String str4;
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        ReportController.o(appInterface, "dc00898", "", "", "0X800AEE5", "0X800AEE5", i3, 0, "", "", str3, str4);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void reportNewSoundEvent(AppRuntime appRuntime, String str, int i3, String str2) {
        int i16;
        int i17;
        String str3;
        if (i3 != -1) {
            int intValue = Integer.valueOf(EmoticonReportUtil.getAioMoreFlag(i3)).intValue();
            i16 = 1;
            if (intValue != 0) {
                if (intValue != 1) {
                    i16 = 2;
                    if (intValue != 2) {
                        if (intValue != 3) {
                            i17 = -1;
                        }
                    } else {
                        i16 = 4;
                    }
                } else {
                    i17 = 3;
                }
                if (i17 == -1) {
                    if (TextUtils.isEmpty(str2)) {
                        str3 = "";
                    } else {
                        str3 = str2;
                    }
                    ReportController.o(appRuntime, "dc00898", "", "", str, str, i17, 0, str3, "", "", "");
                    return;
                }
                return;
            }
        } else {
            i16 = 0;
        }
        i17 = i16;
        if (i17 == -1) {
        }
    }
}
