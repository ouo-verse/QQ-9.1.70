package com.tencent.av.ui.part.invite.multi;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i3) {
        int i16;
        String str;
        synchronized (n.class) {
            SessionInfo f16 = n.e().f();
            if (f16 != null && n.e().c() >= 2) {
                int i17 = f16.f73043k;
                int i18 = f16.f73025g;
                String str2 = null;
                if (f16.f73060o0) {
                    if (i3 == 0) {
                        str2 = "0X8005BAA";
                    } else if (i3 == 1) {
                        str2 = "0X8005BAB";
                    } else if (i3 == 2) {
                        str2 = "0X8005BAC";
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("GaInviteSlidePart", 2, "double share, action:" + i3 + ", reportType:" + str2);
                    }
                } else {
                    int i19 = f16.S0;
                    if (i19 == 1 && f16.f73035i == 3) {
                        if (i3 == 0) {
                            str2 = "0X8005BB3";
                        } else if (i3 == 1) {
                            str2 = "0X8005BB4";
                        } else if (i3 == 2) {
                            str2 = "0X8005BB5";
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("GaInviteSlidePart", 2, "group audio, action:" + i3 + ", reportType:" + str2);
                        }
                    } else if (i19 == 1 && f16.f73035i == 4) {
                        if (i3 == 0) {
                            str2 = "0X8005BB6";
                        } else if (i3 == 1) {
                            str2 = "0X8005BB7";
                        } else if (i3 == 2) {
                            str2 = "0X8005BB8";
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("GaInviteSlidePart", 2, "group video, action:" + i3 + ", reportType:" + str2);
                        }
                    } else if (i19 == 2 && f16.f73035i == 3) {
                        if (i3 == 0) {
                            str2 = "0X8005BAD";
                        } else if (i3 == 1) {
                            str2 = "0X8005BAE";
                        } else if (i3 == 2) {
                            str2 = "0X8005BAF";
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("GaInviteSlidePart", 2, "discuss audio, action:" + i3 + ", reportType:" + str2);
                        }
                    } else if (i19 == 2 && f16.f73035i == 4) {
                        if (i3 == 0) {
                            str2 = "0X8005BB0";
                        } else if (i3 == 1) {
                            str2 = "0X8005BB1";
                        } else if (i3 == 2) {
                            str2 = "0X8005BB2";
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("GaInviteSlidePart", 2, "discuss video, action:" + i3 + ", reportType:" + str2);
                        }
                    } else {
                        int i26 = f16.f73035i;
                        if (i26 == 2 || ((i16 = f16.f73039j) == 2 && (i17 == 1 || i17 == 2))) {
                            if (i3 == 0) {
                                str2 = "0X8005BA7";
                            } else if (i3 == 1) {
                                str2 = "0X8005BA8";
                            } else if (i3 == 2) {
                                str2 = "0X8005BA9";
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("GaInviteSlidePart", 2, "double video, action:" + i3 + ", reportType:" + str2);
                            }
                        } else if (i26 != 1 && (i16 != 1 || (i17 != 1 && i17 != 2))) {
                            if (QLog.isColorLevel()) {
                                QLog.d("GaInviteSlidePart", 2, "nothing, action:" + i3 + ", reportType:" + ((String) null) + "SessionType:" + f16.f73035i + ", BeginSessionType:" + f16.f73039j + ", sessionStatus:" + i18 + ", state:" + i17);
                            }
                        } else {
                            if (i3 == 0) {
                                str = "0X8005BA4";
                            } else if (i3 == 1) {
                                str = "0X8005BA5";
                            } else {
                                if (i3 == 2) {
                                    str = "0X8005BA6";
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("GaInviteSlidePart", 2, "double audio, action:" + i3 + ", reportType:" + str2);
                                }
                            }
                            str2 = str;
                            if (QLog.isColorLevel()) {
                            }
                        }
                    }
                }
                String str3 = str2;
                if (str3 != null) {
                    ReportController.o(null, "CliOper", "", "", str3, str3, 0, 0, "", "", "", "");
                }
            }
        }
    }
}
