package com.tencent.av.share;

import android.text.TextUtils;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.Pair;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static void a() {
        l("0X800A3DC");
    }

    public static void b() {
        l("0X800A2BA");
    }

    public static void c() {
        l("0X800B5A2");
    }

    public static void d() {
        l("0X800B5A1");
    }

    public static Pair<Integer, Integer> e(int i3, int i16) {
        int i17;
        int i18 = 2;
        if (i16 == ((IShareChatApi) QRoute.api(IShareChatApi.class)).getLinkTypeNoVerify()) {
            i17 = 1;
        } else {
            if (i16 != ((IShareChatApi) QRoute.api(IShareChatApi.class)).getLinkTypeNeedVerify()) {
                return null;
            }
            i17 = 2;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 123) {
                                return null;
                            }
                            i18 = 7;
                        } else {
                            i18 = 4;
                        }
                    } else {
                        i18 = 3;
                    }
                }
            } else {
                i18 = 1;
            }
        } else {
            i18 = 5;
        }
        return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i17));
    }

    public static void f() {
        l("0X800A2C0");
    }

    public static void g(int i3, String str) {
        if (i3 == 1) {
            ReportController.o(null, "dc00898", "", "", "0X800A3E2", "0X800A3E2", 0, 0, "", str, "", "");
        }
    }

    public static void h() {
        l("0X800A2C2");
    }

    public static void i() {
        l("0X800B5A0");
    }

    public static void j(int i3) {
        String str;
        if (i3 != 0) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        return;
                    } else {
                        str = "0X800A2C1";
                    }
                } else {
                    str = "0X800A2BF";
                }
            } else {
                str = "0X800A2BE";
            }
        } else {
            str = "0X800A2C3";
        }
        l(str);
    }

    public static void k() {
        l("0X800A2BD");
    }

    static void l(String str) {
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    public static void m(int i3, int i16) {
        Pair<Integer, Integer> e16 = e(i3, i16);
        if (e16 == null) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800A2BB", "0X800A2BB", e16.first.intValue(), 0, String.valueOf(e16.second.intValue()), "", "", "");
    }

    public static void n(int i3, int i16, int i17, String str) {
        String str2;
        String str3;
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 99) {
                    return;
                } else {
                    str2 = "0X800A2BC";
                }
            } else {
                str2 = "0X800A3E1";
            }
        } else {
            str2 = "0X800A3E3";
        }
        String str4 = str2;
        Pair<Integer, Integer> e16 = e(i3, i16);
        if (e16 == null) {
            return;
        }
        int intValue = e16.first.intValue();
        String valueOf = String.valueOf(e16.second);
        if (!TextUtils.isEmpty(str)) {
            str3 = str;
        } else {
            str3 = valueOf;
        }
        ReportController.o(null, "dc00898", "", "", str4, str4, intValue, 0, str3, "", "", "");
    }

    public static void o() {
        l("0X800A3DB");
    }

    public static void p() {
        l("0X800A2B9");
    }
}
