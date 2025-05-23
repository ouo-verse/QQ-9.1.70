package com.tencent.av.business.manager.report;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    private static boolean a(String str, boolean z16, HashMap<String, String> hashMap) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, z16, 0L, 0L, hashMap, null);
        return true;
    }

    public static void b(long j3) {
        long j16;
        boolean z16;
        try {
            new HashMap();
            if (j3 > 0) {
                j16 = System.currentTimeMillis() - j3;
            } else {
                j16 = -1;
            }
            if (j16 > 2000) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("VideoBeaconReporter", 1, "event_QuaInviteClose, isSucceed[" + z16 + "],  ret[" + a("QuaInviteClose", z16, null) + "]");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoBeaconReporter", 2, "event_QuaInviteClose:", th5);
            }
        }
    }

    public static void c(int i3, long j3, long j16, String str) {
        boolean z16;
        QLog.d("VideoBeaconReporter", 1, "reportQuaOnCloseVideo_onCloseVideo :reason[" + i3 + "], param0[" + j3 + "], param1[" + j16 + "], param2[" + str + "], ");
        try {
            HashMap hashMap = new HashMap();
            if (j16 != 0) {
                i3 = ((int) j16) + 1000;
                if (str != null) {
                    try {
                        j3 = Long.parseLong(str);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VideoBeaconReporter", 2, "parseLong error:", e16);
                        }
                    }
                }
            }
            hashMap.put("reason", "" + i3);
            hashMap.put("error_code", "" + j3);
            if ((i3 == 1 && (j3 == 1 || j3 == 2)) || j3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("VideoBeaconReporter", 1, "event_QuaOnCloseVideo, isSucceed[" + z16 + "], node_reason[" + ((String) hashMap.get("reason")) + "], node_error_code[" + ((String) hashMap.get("error_code")) + "],     ret[" + a("QuaOnCloseVideo", z16, hashMap) + "]");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoBeaconReporter", 2, "event_QuaOnCloseVideo:", th5);
            }
        }
    }

    public static void d(boolean z16, boolean z17) {
        boolean z18;
        try {
            HashMap hashMap = new HashMap();
            if (z16) {
                hashMap.put("broadcast_created", "1");
            } else {
                hashMap.put("broadcast_created", "0");
            }
            if (z17) {
                hashMap.put("vchat_created", "1");
                z18 = true;
            } else {
                hashMap.put("vchat_created", "0");
                z18 = false;
            }
            QLog.d("VideoBeaconReporter", 1, "event_QuaProcessWakeUp, isSucceed[" + z18 + "], node_broadcast_created[" + ((String) hashMap.get("broadcast_created")) + "], node_vchat_created[" + ((String) hashMap.get("vchat_created")) + "],     ret[" + a("QuaProcessWakeUp", z18, hashMap) + "]");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoBeaconReporter", 2, "event_QuaProcessWakeUp:", th5);
            }
        }
    }

    public static void e() {
        try {
            QLog.d("VideoBeaconReporter", 1, "event_QuaVChatNewIntent, isSucceed[true],  ret[" + a("QuaVChatNewIntent", true, null) + "]");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoBeaconReporter", 2, "event_QuaVChatNewIntent:", th5);
            }
        }
    }
}
