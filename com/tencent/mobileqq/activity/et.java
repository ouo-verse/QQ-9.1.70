package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
/* loaded from: classes9.dex */
public class et {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Removed duplicated region for block: B:112:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(QZoneManagerImp qZoneManagerImp, boolean z16, boolean z17) {
        int i3;
        int i16;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        String str;
        int i17;
        String str2;
        int i18;
        String str3;
        int i19;
        String str4;
        int i26;
        String str5;
        int i27;
        String str6;
        int i28;
        String str7;
        String str8;
        int i29;
        String str9;
        String str10;
        int i36;
        String str11;
        QZoneCountInfo qZoneCountInfo;
        QZoneCountInfo qZoneCountInfo2;
        QZoneCountInfo qZoneCountInfo3;
        QZoneCountInfo qZoneCountInfo4;
        QZoneCountInfo qZoneCountInfo5;
        boolean z36;
        int i37 = 2;
        if (QLog.isColorLevel()) {
            QLog.i("QZoneEntryReporterInLeba", 2, "Leba isTableModel:" + z17);
        }
        boolean z37 = false;
        if (qZoneManagerImp != null) {
            i3 = qZoneManagerImp.j(1);
        } else {
            i3 = 0;
        }
        if (qZoneManagerImp != null) {
            i16 = qZoneManagerImp.j(2);
        } else {
            i16 = 0;
        }
        String str12 = "";
        if (i3 <= 0 && i16 <= 0) {
            QZoneCountInfo qZoneCountInfo6 = null;
            if (qZoneManagerImp != null) {
                qZoneCountInfo = qZoneManagerImp.k(6);
            } else {
                qZoneCountInfo = null;
            }
            if (qZoneManagerImp != null) {
                qZoneCountInfo2 = qZoneManagerImp.k(61);
            } else {
                qZoneCountInfo2 = null;
            }
            if (qZoneManagerImp != null) {
                qZoneCountInfo3 = qZoneManagerImp.k(3);
            } else {
                qZoneCountInfo3 = null;
            }
            if (qZoneManagerImp != null) {
                qZoneCountInfo4 = qZoneManagerImp.k(1013);
            } else {
                qZoneCountInfo4 = null;
            }
            if (qZoneManagerImp != null) {
                qZoneCountInfo5 = qZoneManagerImp.k(1017);
            } else {
                qZoneCountInfo5 = null;
            }
            if (qZoneManagerImp != null) {
                qZoneCountInfo6 = qZoneManagerImp.k(1018);
            }
            if (com.tencent.mobileqq.service.qzone.c.l(qZoneManagerImp) && qZoneCountInfo3 != null && !TextUtils.isEmpty(qZoneCountInfo3.strShowMsg)) {
                str12 = qZoneCountInfo3.strShowMsg;
                z36 = true;
            } else {
                z36 = false;
            }
            z29 = z36;
            if (!z36 && com.tencent.mobileqq.service.qzone.c.b(qZoneManagerImp) && qZoneCountInfo != null && !TextUtils.isEmpty(qZoneCountInfo.strShowMsg)) {
                str12 = qZoneCountInfo.strShowMsg;
                z26 = true;
                z36 = true;
            } else {
                z26 = false;
            }
            if (!z36 && com.tencent.mobileqq.service.qzone.c.c(qZoneManagerImp) && qZoneCountInfo5 != null && !TextUtils.isEmpty(qZoneCountInfo5.strShowMsg)) {
                str12 = qZoneCountInfo5.strShowMsg;
                z36 = true;
                z28 = true;
            } else {
                z28 = false;
            }
            if (!z36 && com.tencent.mobileqq.service.qzone.c.k(qZoneManagerImp) && qZoneCountInfo4 != null && !TextUtils.isEmpty(qZoneCountInfo4.strShowMsg)) {
                str12 = qZoneCountInfo4.strShowMsg;
                z36 = true;
                z27 = true;
            } else {
                z27 = false;
            }
            if (!z36 && com.tencent.mobileqq.service.qzone.c.a(qZoneManagerImp) && qZoneCountInfo6 != null && !TextUtils.isEmpty(qZoneCountInfo6.strShowMsg)) {
                str12 = qZoneCountInfo6.strShowMsg;
                z19 = true;
                z36 = true;
            } else {
                z19 = false;
            }
            if (!z36 && com.tencent.mobileqq.service.qzone.c.g(qZoneManagerImp) && qZoneCountInfo2 != null && !TextUtils.isEmpty(qZoneCountInfo2.strShowMsg)) {
                str12 = qZoneCountInfo2.strShowMsg;
                z18 = true;
                z37 = true;
            } else {
                z18 = false;
                str = str12;
                z37 = z36;
                String str13 = "1";
                String str14 = "2";
                if (z37) {
                    if (i3 <= 0) {
                        if (i16 <= 0) {
                            if (z16) {
                                i36 = 1;
                            } else {
                                i36 = 2;
                            }
                            if (z17) {
                                str11 = "1";
                            } else {
                                str11 = "2";
                            }
                            LpReportInfo_pf00064.report(637, 13, i36, str11, "0", null);
                            return;
                        }
                        if (z16) {
                            i37 = 1;
                        }
                        if (z17) {
                            str9 = "1";
                        } else {
                            str9 = "2";
                        }
                        if (i16 <= 1) {
                            str10 = "1";
                        } else {
                            str10 = "2";
                        }
                        LpReportInfo_pf00064.report(637, 11, i37, str9, str10, null);
                        return;
                    }
                    if (i16 <= 0) {
                        if (z16) {
                            i29 = 1;
                        } else {
                            i29 = 2;
                        }
                        if (z17) {
                            str14 = "1";
                        }
                        LpReportInfo_pf00064.report(637, 12, i29, str14, "0", null);
                        return;
                    }
                    if (z16) {
                        i37 = 1;
                    }
                    if (z17) {
                        str8 = "1";
                    } else {
                        str8 = "2";
                    }
                    if (i16 > 1) {
                        str13 = "2";
                    }
                    LpReportInfo_pf00064.report(637, 14, i37, str8, str13, null);
                    return;
                }
                if (z29) {
                    if (z16) {
                        i28 = 1;
                    } else {
                        i28 = 2;
                    }
                    if (z17) {
                        str7 = "1";
                    } else {
                        str7 = "2";
                    }
                    LpReportInfo_pf00064.report(637, 15, i28, str7, null, str);
                    return;
                }
                if (z26) {
                    if (z16) {
                        i27 = 1;
                    } else {
                        i27 = 2;
                    }
                    if (z17) {
                        str6 = "1";
                    } else {
                        str6 = "2";
                    }
                    LpReportInfo_pf00064.report(637, 17, i27, str6, null, str);
                    return;
                }
                if (z18) {
                    if (z16) {
                        i26 = 1;
                    } else {
                        i26 = 2;
                    }
                    if (z17) {
                        str5 = "1";
                    } else {
                        str5 = "2";
                    }
                    LpReportInfo_pf00064.report(637, 16, i26, str5, null, str);
                    return;
                }
                if (z27) {
                    if (z16) {
                        i19 = 1;
                    } else {
                        i19 = 2;
                    }
                    if (z17) {
                        str4 = "1";
                    } else {
                        str4 = "2";
                    }
                    LpReportInfo_pf00064.report(637, 46, i19, str4, null, str);
                    return;
                }
                if (z28) {
                    if (z16) {
                        i18 = 1;
                    } else {
                        i18 = 2;
                    }
                    if (z17) {
                        str3 = "1";
                    } else {
                        str3 = "2";
                    }
                    LpReportInfo_pf00064.report(637, 48, i18, str3, null, str);
                    return;
                }
                if (z19) {
                    if (z16) {
                        i17 = 1;
                    } else {
                        i17 = 2;
                    }
                    if (z17) {
                        str2 = "1";
                    } else {
                        str2 = "2";
                    }
                    LpReportInfo_pf00064.report(637, 47, i17, str2, null, str);
                    return;
                }
                return;
            }
        } else {
            z18 = false;
            z19 = false;
            z26 = false;
            z27 = false;
            z28 = false;
            z29 = false;
        }
        str = str12;
        String str132 = "1";
        String str142 = "2";
        if (z37) {
        }
    }
}
