package com.tencent.av.ui;

import com.tencent.av.app.SessionInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ap {

    /* renamed from: a, reason: collision with root package name */
    public static String f75382a = "VoiceChangeDataReport";

    /* renamed from: b, reason: collision with root package name */
    static long f75383b = 0;

    /* renamed from: c, reason: collision with root package name */
    static int f75384c = 0;

    /* renamed from: d, reason: collision with root package name */
    static int f75385d = 0;

    /* renamed from: e, reason: collision with root package name */
    static int f75386e = 0;

    /* renamed from: f, reason: collision with root package name */
    static boolean f75387f = false;

    /* renamed from: g, reason: collision with root package name */
    static boolean f75388g = false;

    /* renamed from: h, reason: collision with root package name */
    static boolean f75389h = false;

    /* renamed from: i, reason: collision with root package name */
    static boolean f75390i = false;

    /* renamed from: j, reason: collision with root package name */
    static String f75391j = "0";

    /* renamed from: k, reason: collision with root package name */
    static String f75392k = "actAVFunChatVoiceChange";

    public static void a(SessionInfo sessionInfo) {
        if (f75389h && f75390i) {
            int i3 = sessionInfo.f73035i;
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3 || i3 == 4) {
                    int i16 = sessionInfo.f73063p;
                    if (i16 == 1) {
                        if (f75387f) {
                            if (f75385d == 0) {
                                c("0X8007E67", "");
                            } else {
                                c("0X8007E68", f75385d + "");
                            }
                        }
                        if (f75388g) {
                            if (f75386e == 0) {
                                c("0X8007E69", "");
                            } else {
                                c("0X8007E6A", f75386e + "");
                            }
                        }
                    } else if (i16 == 10) {
                        if (f75387f) {
                            if (f75385d == 0) {
                                c("0X8007E63", "");
                            } else {
                                c("0X8007E64", f75385d + "");
                            }
                        }
                        if (f75388g) {
                            if (f75386e == 0) {
                                c("0X8007E65", "");
                            } else {
                                c("0X8007E66", f75386e + "");
                            }
                        }
                    }
                }
            } else {
                if (f75387f) {
                    if (f75385d == 0) {
                        c("0X8007DC3", "");
                    } else {
                        c("0X8007DC2", f75385d + "");
                    }
                }
                if (f75388g) {
                    if (f75386e == 0) {
                        c("0X8007DC5", "");
                    } else {
                        c("0X8007DC4", f75386e + "");
                    }
                }
            }
            e(sessionInfo, 0);
            f75389h = false;
            f75390i = false;
            f75391j = "0";
        }
    }

    public static void b(int i3, String str) {
        AVCoreLog.printDebugLog(f75382a, String.format("onConnected sessionType = %s, roomid = %s", Integer.valueOf(i3), str));
        f75390i = true;
        f75391j = str;
        if (i3 != 1 && i3 != 3) {
            if (i3 == 2 || i3 == 4) {
                int i16 = f75384c;
                if (i16 != 0) {
                    f75386e = i16;
                }
                f75388g = true;
                return;
            }
            return;
        }
        int i17 = f75384c;
        if (i17 != 0) {
            f75385d = i17;
        }
        f75387f = true;
    }

    public static void c(String str, String str2) {
        AVCoreLog.printDebugLog(f75382a, String.format("reportClickEvent key = %s, type = %s, roomid = %s", str, str2, f75391j));
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, str2, "", f75391j, "");
    }

    public static void d(int i3, long j3) {
        HashMap hashMap = new HashMap();
        hashMap.put("typeid", i3 + "");
        hashMap.put("duration", j3 + "");
        UserAction.onUserAction(f75392k, true, -1L, -1L, hashMap, true);
        AVCoreLog.printDebugLog(f75382a, String.format("reportVoiceChange voiceType = %s, duration = %s", Integer.valueOf(i3), Long.valueOf(j3)));
    }

    public static void e(SessionInfo sessionInfo, int i3) {
        AVCoreLog.printDebugLog(f75382a, String.format("updateReportData sessionType = %d, voiceType = %d", Integer.valueOf(sessionInfo.f73035i), Integer.valueOf(i3)));
        long currentTimeMillis = System.currentTimeMillis();
        int i16 = f75384c;
        if (i16 != 0) {
            d(i16, (currentTimeMillis - f75383b) / 1000);
        }
        f75384c = i3;
        f75383b = currentTimeMillis;
        int i17 = sessionInfo.f73035i;
        if (i17 != 1 && i17 != 3) {
            if (i17 == 2 || i17 == 4) {
                if (i3 != 0) {
                    f75386e = i3;
                }
                f75388g = true;
                return;
            }
            return;
        }
        if (i3 != 0) {
            f75385d = i3;
        }
        f75387f = true;
    }
}
