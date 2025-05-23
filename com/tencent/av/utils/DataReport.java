package com.tencent.av.utils;

import android.media.AudioManager;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.m;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DataReport {

    /* renamed from: a, reason: collision with root package name */
    static boolean f76668a = false;

    /* renamed from: b, reason: collision with root package name */
    static boolean f76669b = false;

    /* renamed from: c, reason: collision with root package name */
    static boolean f76670c = false;

    /* renamed from: d, reason: collision with root package name */
    static boolean f76671d = false;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        public static void a(boolean z16) {
            SessionInfo f16 = com.tencent.av.n.e().f();
            if (z16) {
                AVUtil.r("0X800BC0C", DataReport.v(f16), 2, "", "", "", "");
            }
        }

        public static void b() {
            DataReport.U("0X800A3D9", com.tencent.av.n.e().f().f73035i);
        }
    }

    public static void A() {
        if (f76668a) {
            return;
        }
        f76668a = true;
        if (com.tencent.av.n.e().f().z()) {
            int i3 = com.tencent.av.n.e().f().f73035i;
            if (i3 == 1) {
                T(null, "CliOper", "", "", "0X800437A", "0X800437A", 0, 0, "", "", "", "");
            } else if (i3 == 2) {
                T(null, "CliOper", "", "", "0X80043D5", "0X80043D5", 0, 0, "", "", "", "");
            }
        }
    }

    public static void B(boolean z16, boolean z17) {
        if (z16) {
            T(null, "CliOper", "", "", "0X8009F5A", "0X8009F5A", 0, 0, "", "", "", "");
        }
        if (z17) {
            T(null, "CliOper", "", "", "0X8009F5B", "0X8009F5B", 0, 0, "", "", "", "");
        }
    }

    public static void C() {
        String str;
        String str2;
        String str3;
        if (com.tencent.av.n.e().f().f73035i == 1) {
            str2 = "0X8004360";
            str3 = "0X8004361";
        } else {
            if (com.tencent.av.n.e().f().f73035i == 2) {
                str = "0X800444C";
            } else {
                str = "";
            }
            str2 = str;
            str3 = str2;
        }
        T(null, "CliOper", "", "", str2, str3, 0, 0, "", "", "", "");
    }

    public static void D() {
        String str;
        String str2;
        String str3;
        if (com.tencent.av.n.e().f().f73035i == 1) {
            str2 = "0X8004361";
            str3 = "0X8004362";
        } else {
            if (com.tencent.av.n.e().f().f73035i == 2) {
                str = "0X800444D";
            } else {
                str = "";
            }
            str2 = str;
            str3 = str2;
        }
        T(null, "CliOper", "", "", str2, str3, 0, 0, "", "", "", "");
    }

    public static void E() {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            if (com.tencent.av.n.e().f().z()) {
                if (com.tencent.av.n.e().f().K) {
                    T(null, "CliOper", "", "", "0X8004381", "0X8004381", 0, 0, "", "", "", "");
                    return;
                } else {
                    T(null, "CliOper", "", "", "0X8004382", "0X8004382", 0, 0, "", "", "", "");
                    return;
                }
            }
            if (com.tencent.av.n.e().f().K) {
                T(null, "CliOper", "", "", "0X8004353", "0X8004353", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0X8004354", "0X8004354", 0, 0, "", "", "", "");
                return;
            }
        }
        if (i3 == 2) {
            if (com.tencent.av.n.e().f().z()) {
                if (com.tencent.av.n.e().f().K) {
                    T(null, "CliOper", "", "", "0X80043DC", "0X80043DC", 0, 0, "", "", "", "");
                    return;
                } else {
                    T(null, "CliOper", "", "", "0X80043DD", "0X80043DD", 0, 0, "", "", "", "");
                    return;
                }
            }
            if (com.tencent.av.n.e().f().K) {
                T(null, "CliOper", "", "", "0X80043BE", "0X80043BE", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X80043BF", "0X80043BF", 0, 0, "", "", "", "");
            }
        }
    }

    public static void F(boolean z16, int i3) {
        if (z16) {
            if (i3 == 1) {
                T(null, "CliOper", "", "", "0X8004CF7", "0X8004CF7", 0, 0, "", "", "", "");
                return;
            } else if (i3 == 10) {
                T(null, "CliOper", "", "", "0X8005949", "0X8005949", 0, 0, "", "", "", "");
                return;
            } else {
                if (i3 == 2) {
                    T(null, "CliOper", "", "", "0X8004F5B", "0X8004F5B", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
        }
        if (i3 == 1) {
            T(null, "CliOper", "", "", "0X8004CF4", "0X8004CF4", 0, 0, "", "", "", "");
        } else if (i3 == 10) {
            T(null, "CliOper", "", "", "0X8005946", "0X8005946", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            T(null, "CliOper", "", "", "0X8004F58", "0X8004F58", 0, 0, "", "", "", "");
        }
    }

    public static void G(int i3) {
        if (i3 == 2) {
            T(null, "CliOper", "", "", "0X8004F5E", "0X8004F5E", 0, 0, "", "", "", "");
        } else if (i3 == 10) {
            T(null, "CliOper", "", "", "0X800594C", "0X800594C", 0, 0, "", "", "", "");
        } else if (i3 == 1) {
            T(null, "CliOper", "", "", "0X8004CFA", "0X8004CFA", 0, 0, "", "", "", "");
        }
    }

    public static void H(boolean z16, int i3) {
        if (i3 == 1) {
            if (z16) {
                T(null, "CliOper", "", "", "0X8004CF9", "0X8004CF9", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0X8004CF5", "0X8004CF5", 0, 0, "", "", "", "");
                return;
            }
        }
        if (i3 == 10) {
            if (z16) {
                T(null, "CliOper", "", "", "0X800594B", "0X800594B", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0X8005947", "0X8005947", 0, 0, "", "", "", "");
                return;
            }
        }
        if (i3 == 2) {
            if (z16) {
                T(null, "CliOper", "", "", "0X8004F5D", "0X8004F5D", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X8004F59", "0X8004F59", 0, 0, "", "", "", "");
            }
        }
    }

    public static void I(boolean z16) {
        if (z16) {
            T(null, "CliOper", "", "", "0X8005615", "0X8005615", 0, 0, "", "", "", "");
        }
    }

    public static void J(boolean z16, int i3) {
        if (z16) {
            if (i3 != 1) {
                if (i3 == 10) {
                    T(null, "CliOper", "", "", "0X8005926", "0X8005926", 0, 0, "", "", "", "");
                    return;
                } else {
                    if (i3 == 2) {
                        T(null, "CliOper", "", "", "0X80046CC", "0X80046CC", 0, 0, "", "", "", "");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i3 != 1) {
            if (i3 == 10) {
                T(null, "CliOper", "", "", "0X8005927", "0X8005927", 0, 0, "", "", "", "");
            } else if (i3 == 2) {
                T(null, "CliOper", "", "", "0X80046CD", "0X80046CD", 0, 0, "", "", "", "");
            }
        }
    }

    public static void K(boolean z16, boolean z17, int i3) {
        if (i3 == 1) {
            if (z17) {
                T(null, "CliOper", "", "", "0x80041BA", "0x80041BA", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0x80041BD", "0x80041BD", 0, 0, "", "", "", "");
                return;
            }
        }
        if (i3 == 10) {
            if (z16 && !z17) {
                T(null, "CliOper", "", "", "0x8005940", "0x8005940", 0, 0, "", "", "", "");
            }
            if (z17) {
                T(null, "CliOper", "", "", "0x800593D", "0x800593D", 0, 0, "", "", "", "");
            }
        }
    }

    public static void L(boolean z16, boolean z17, int i3) {
        if (i3 == 1) {
            if (z17) {
                T(null, "CliOper", "", "", "0X80041B9", "0X80041B9", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0X80041BC", "0X80041BC", 0, 0, "", "", "", "");
                return;
            }
        }
        if (i3 == 10) {
            if (z16 && !z17) {
                T(null, "CliOper", "", "", "0X800593F", "0X800593F", 0, 0, "", "", "", "");
            }
            if (z17) {
                T(null, "CliOper", "", "", "0X800593C", "0X800593C", 0, 0, "", "", "", "");
                return;
            }
            return;
        }
        if (i3 == 2) {
            if (z16 && !z17) {
                T(null, "CliOper", "", "", "0X80046E9", "0X80046E9", 0, 0, "", "", "", "");
            }
            if (z17) {
                T(null, "CliOper", "", "", "0X80046E6", "0X80046E6", 0, 0, "", "", "", "");
            }
        }
    }

    public static void M(boolean z16, int i3) {
        if (z16) {
            if (i3 == 10) {
                T(null, "CliOper", "", "", "0X800592B", "0X800592B", 0, 0, "", "", "", "");
                return;
            } else if (i3 == 2) {
                T(null, "CliOper", "", "", "0X80046D1", "0X80046D1", 0, 0, "", "", "", "");
                return;
            } else {
                if (i3 == 1) {
                    T(null, "CliOper", "", "", "0X8004CE7", "0X8004CE7", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
        }
        if (i3 == 10) {
            T(null, "CliOper", "", "", "0X800592C", "0X800592C", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            T(null, "CliOper", "", "", "0X80046D2", "0X80046D2", 0, 0, "", "", "", "");
        } else if (i3 == 1) {
            T(null, "CliOper", "", "", "0X8004CE6", "0X8004CE6", 0, 0, "", "", "", "");
        }
    }

    public static void N(int i3, int i16) {
        if (i16 != 0) {
            if (i16 != 90) {
                if (i16 != 180) {
                    if (i16 != 270) {
                        return;
                    }
                }
            }
            if (i3 == 1) {
                T(null, "CliOper", "", "", "0X8004429", "0X8004429", 0, 0, "", "", "", "");
                return;
            } else {
                if (i3 == 2) {
                    T(null, "CliOper", "", "", "0X800442C", "0X800442C", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
        }
        if (i3 == 1) {
            T(null, "CliOper", "", "", "0X800442A", "0X800442A", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            T(null, "CliOper", "", "", "0X800442B", "0X800442B", 0, 0, "", "", "", "");
        }
    }

    public static void O() {
        if (f76670c) {
            return;
        }
        f76670c = true;
        if (!com.tencent.av.n.e().f().N && !com.tencent.av.n.e().f().O) {
            T(null, "CliOper", "", "", "0X80043EB", "0X80043EB", 0, 0, "", "", "", "");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (com.tencent.av.utils.af.x() != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        if (com.tencent.av.utils.af.x() != false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void P(int i3) {
        int i16;
        String str;
        SessionInfo f16 = com.tencent.av.n.e().f();
        int i17 = f16.f73035i;
        String str2 = "0X800A154";
        if (i3 != m.l.A) {
            if (i3 != m.e.f76014a && i3 != m.b.f75998b) {
                String str3 = "0X800A156";
                if (i3 != m.l.L) {
                    if (i3 != m.e.f76015b) {
                        if (i3 == m.e.f76016c) {
                            str2 = "0X800A157";
                        } else if (i3 == m.e.f76017d) {
                            str2 = "0X800A158";
                        } else {
                            str3 = "0X800A15A";
                            if (i3 != m.l.K) {
                                if (i3 == m.e.f76018e) {
                                    i17 = v(f16);
                                } else if (i3 == m.e.f76019f) {
                                    str2 = "0X800A15B";
                                } else if (i3 == m.e.f76021h) {
                                    str2 = "0X800A15C";
                                } else if (i3 == m.l.B) {
                                    str2 = "0X800A15D";
                                } else if (i3 == m.e.f76023j) {
                                    str2 = "0X800A159";
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                    i16 = i17;
                    str = str3;
                }
                T(null, "dc00898", "", "", str, str, i16, 0, "", "", "", "");
            }
            i17 = v(f16);
            str2 = "0X800A155";
        }
        i16 = i17;
        str = str2;
        T(null, "dc00898", "", "", str, str, i16, 0, "", "", "", "");
    }

    public static void Q() {
        if (f76671d) {
            return;
        }
        f76671d = true;
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            T(null, "CliOper", "", "", "0X8004395", "0X8004395", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            T(null, "CliOper", "", "", "0X80043F3", "0X80043F3", 0, 0, "", "", "", "");
        }
    }

    public static void R() {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            T(null, "CliOper", "", "", "0X800435E", "0X800435E", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            T(null, "CliOper", "", "", "0X80043C9", "0X80043C9", 0, 0, "", "", "", "");
        }
    }

    public static void S() {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            T(null, "CliOper", "", "", "0X8004394", "0X8004394", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            T(null, "CliOper", "", "", "0X80043F2", "0X80043F2", 0, 0, "", "", "", "");
        }
    }

    public static void T(final AppRuntime appRuntime, final String str, final String str2, final String str3, final String str4, final String str5, final int i3, final int i16, final String str6, final String str7, final String str8, final String str9) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.DataReport.2
            @Override // java.lang.Runnable
            public void run() {
                ReportController.o(AppRuntime.this, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
            }
        }, 16, null, true);
    }

    static void U(String str, int i3) {
        T(null, "dc00898", "", "", str, str, i3, 0, "", "", "", "");
    }

    public static void V(int i3) {
        String str;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        str = "";
                    } else {
                        str = "0X8004E20";
                    }
                } else {
                    str = "0X8004E1F";
                }
            } else {
                str = "0X8004E21";
            }
        } else {
            str = "0X8004E22";
        }
        String str2 = str;
        T(null, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
    }

    public static void W() {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            if (com.tencent.av.n.e().f().I0) {
                T(null, "CliOper", "", "", "0X8004351", "0X8004351", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0X8004352", "0X8004352", 0, 0, "", "", "", "");
                return;
            }
        }
        if (i3 == 2) {
            if (com.tencent.av.n.e().f().I0) {
                T(null, "CliOper", "", "", "0X80043BC", "0X80043BC", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X80043BD", "0X80043BD", 0, 0, "", "", "", "");
            }
        }
    }

    public static void X(boolean z16) {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            if (z16) {
                if (!com.tencent.av.n.e().f().G) {
                    if (com.tencent.av.n.e().f().K) {
                        T(null, "CliOper", "", "", "0X8004356", "0X8004356", 0, 0, "", "", "", "");
                        return;
                    } else {
                        T(null, "CliOper", "", "", "0X8004355", "0X8004355", 0, 0, "", "", "", "");
                        return;
                    }
                }
                return;
            }
            if (com.tencent.av.n.e().f().f73100y0 > 0) {
                if (com.tencent.av.n.e().f().K) {
                    T(null, "CliOper", "", "", "0X8004384", "0X8004384", 0, 0, "", "", "", "");
                    return;
                } else {
                    T(null, "CliOper", "", "", "0X8004383", "0X8004383", 0, 0, "", "", "", "");
                    return;
                }
            }
            return;
        }
        if (i3 == 2) {
            if (z16) {
                if (!com.tencent.av.n.e().f().G) {
                    if (com.tencent.av.n.e().f().K) {
                        T(null, "CliOper", "", "", "0X80043C1", "0X80043C1", 0, 0, "", "", "", "");
                        return;
                    } else {
                        T(null, "CliOper", "", "", "0X80043C0", "0X80043C0", 0, 0, "", "", "", "");
                        return;
                    }
                }
                return;
            }
            if (com.tencent.av.n.e().f().f73100y0 > 0) {
                if (com.tencent.av.n.e().f().K) {
                    T(null, "CliOper", "", "", "0X80043DF", "0X80043DF", 0, 0, "", "", "", "");
                } else {
                    T(null, "CliOper", "", "", "0X80043DE", "0X80043DE", 0, 0, "", "", "", "");
                }
            }
        }
    }

    public static void Y(boolean z16, boolean z17) {
        if (z16) {
            if (z17) {
                T(null, "dc00898", "", "", "0X800A014", "0X800A014", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "dc00898", "", "", "0X800A015", "0X800A015", 0, 0, "", "", "", "");
                return;
            }
        }
        if (z17) {
            T(null, "dc00898", "", "", "0X800A016", "0X800A016", 0, 0, "", "", "", "");
        } else {
            T(null, "dc00898", "", "", "0X800A017", "0X800A017", 0, 0, "", "", "", "");
        }
    }

    public static void Z() {
        T(null, "CliOper", "", "", "0X8004E1B", "0X8004E1B", 0, 0, "", "", "", "");
    }

    public static void a() {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            T(null, "CliOper", "", "", "0X8004370", "0X8004370", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            T(null, "CliOper", "", "", "0X80043D0", "0X80043D0", 0, 0, "", "", "", "");
        }
    }

    public static void a0() {
        T(null, "CliOper", "", "", "0X8004E1D", "0X8004E1D", 0, 0, "", "", "", "");
    }

    public static void b(boolean z16) {
        int i3;
        int i16 = com.tencent.av.n.e().f().f73035i;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        T(null, "CliOper", "", "", "0X800BBB5", "0X800BBB5", i16, 0, String.valueOf(i3), "", "", "");
    }

    public static void b0(final boolean z16) {
        if (com.tencent.av.n.e().f().f73100y0 == 0) {
            return;
        }
        final AudioManager audioManager = (AudioManager) VideoAppInterface.N().getApp().getApplicationContext().getSystemService("audio");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.utils.DataReport.1
            /* JADX WARN: Removed duplicated region for block: B:33:0x00d4  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0129  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                char c16;
                String str;
                String str2;
                String str3;
                String str4;
                if (audioManager == null) {
                    return;
                }
                int i3 = com.tencent.av.n.e().f().E0;
                int streamVolume = (int) ((SystemMethodProxy.getStreamVolume(audioManager, i3) / audioManager.getStreamMaxVolume(i3)) * 100.0f);
                if (streamVolume < 30) {
                    c16 = 1;
                } else if (streamVolume >= 30 && streamVolume <= 70) {
                    c16 = 2;
                } else if (streamVolume > 70) {
                    c16 = 3;
                } else {
                    c16 = 0;
                }
                String str5 = com.tencent.av.n.e().f().F0;
                if (TraeConstants.DEVICE_EARPHONE.equals(str5)) {
                    str = "0";
                } else if (TraeConstants.DEVICE_SPEAKERPHONE.equals(str5)) {
                    str = "1";
                } else if (TraeConstants.DEVICE_WIRED_HEADSET.equals(str5)) {
                    str = "2";
                } else if (TraeConstants.DEVICE_BLUETOOTH_HEADSET.equals(str5)) {
                    str = "3";
                } else {
                    str = "4";
                }
                int i16 = com.tencent.av.n.e().f().f73035i;
                String str6 = null;
                if (i16 == 1) {
                    if (c16 != 1) {
                        if (c16 != 2) {
                            if (c16 == 3) {
                                if (z16) {
                                    str4 = "0X800437D";
                                } else {
                                    str4 = "0X8004380";
                                }
                            }
                            if (z16 && com.tencent.av.n.e().f().G) {
                                if (!audioManager.isBluetoothA2dpOn()) {
                                    if (!audioManager.isWiredHeadsetOn()) {
                                        str3 = "0";
                                    }
                                    str3 = "2";
                                }
                                str3 = "3";
                            }
                            str3 = str;
                        } else if (z16) {
                            str4 = "0X800437C";
                        } else {
                            str4 = "0X800437F";
                        }
                    } else if (z16) {
                        str4 = "0X800437B";
                    } else {
                        str4 = "0X800437E";
                    }
                    str6 = str4;
                    if (z16) {
                        if (!audioManager.isBluetoothA2dpOn()) {
                        }
                        str3 = "3";
                    }
                    str3 = str;
                } else {
                    if (i16 == 2) {
                        if (c16 != 1) {
                            if (c16 != 2) {
                                if (c16 == 3) {
                                    if (z16) {
                                        str2 = "0X80043D8";
                                    } else {
                                        str2 = "0X80043DB";
                                    }
                                }
                                if (z16 && com.tencent.av.n.e().f().G) {
                                    if (!audioManager.isBluetoothA2dpOn()) {
                                        if (!audioManager.isWiredHeadsetOn()) {
                                            str3 = "1";
                                        }
                                        str3 = "2";
                                    }
                                    str3 = "3";
                                }
                            } else if (z16) {
                                str2 = "0X80043D7";
                            } else {
                                str2 = "0X80043DA";
                            }
                        } else if (z16) {
                            str2 = "0X80043D6";
                        } else {
                            str2 = "0X80043D9";
                        }
                        str6 = str2;
                        if (z16) {
                            if (!audioManager.isBluetoothA2dpOn()) {
                            }
                            str3 = "3";
                        }
                    }
                    str3 = str;
                }
                String str7 = str6;
                if (str7 != null) {
                    DataReport.T(null, "CliOper", "", "", str7, str7, 0, 0, str3, "", "", "");
                }
            }
        }, 16, null, false);
    }

    public static void c() {
        T(null, "CliOper", "", "", "0X8004E1A", "0X8004E1A", 0, 0, "", "", "", "");
    }

    public static void d() {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            if (com.tencent.av.n.e().f().z()) {
                T(null, "CliOper", "", "", "0X800436C", "0X800436C", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0X800434D", "0X800434D", 0, 0, "", "", "", "");
                return;
            }
        }
        if (i3 == 2) {
            if (com.tencent.av.n.e().f().z()) {
                T(null, "CliOper", "", "", "0X80043CC", "0X80043CC", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X80043B8", "0X80043B8", 0, 0, "", "", "", "");
            }
        }
    }

    public static void e(boolean z16) {
        String str;
        String str2;
        if (z16) {
            str = "0X80049A9";
        } else {
            str = "0X80049B9";
        }
        if (z16) {
            str2 = "0X80049A9";
        } else {
            str2 = "0X80049B9";
        }
        T(null, "CliOper", "", "", str, str2, 0, 0, "", "", "", "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
    
        if (r15 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        if (r15 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        r14 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(boolean z16, boolean z17) {
        String str;
        String str2;
        String str3;
        if (z16) {
            str = "0X80049A3";
            str2 = "0X80049B2";
            if (z17) {
                str3 = "0X80049A3";
            } else {
                str3 = "0X80049B2";
            }
        } else {
            str = "0X80049A0";
            str2 = "0X80049AF";
            if (z17) {
                str3 = "0X80049A0";
            } else {
                str3 = "0X80049AF";
            }
        }
        T(null, "CliOper", "", "", str3, str, 0, 0, "", "", "", "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
    
        if (r15 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        if (r15 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        r14 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(boolean z16, boolean z17) {
        String str;
        String str2;
        String str3;
        if (z16) {
            str = "0X80049A4";
            str2 = "0X80049B3";
            if (z17) {
                str3 = "0X80049A4";
            } else {
                str3 = "0X80049B3";
            }
        } else {
            str = "0X80049A1";
            str2 = "0X80049B0";
            if (z17) {
                str3 = "0X80049A1";
            } else {
                str3 = "0X80049B0";
            }
        }
        T(null, "CliOper", "", "", str3, str, 0, 0, "", "", "", "");
    }

    public static void h() {
        T(null, "CliOper", "", "", "0X8004AD1", "0X8004AD1", 0, 0, "", "", "", "");
    }

    public static void i(boolean z16) {
        String str;
        if (z16) {
            str = "0X8004ACD";
        } else {
            str = "0X8004ACA";
        }
        String str2 = str;
        T(null, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
    }

    public static void j(boolean z16) {
        String str;
        if (z16) {
            str = "0X8004ACE";
        } else {
            str = "0X8004ACB";
        }
        String str2 = str;
        T(null, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
    }

    public static void k() {
        T(null, "CliOper", "", "", "0X8004AD0", "0X8004AD0", 0, 0, "", "", "", "");
    }

    public static void l(boolean z16) {
        String str;
        if (z16) {
            str = "0X8004ACC";
        } else {
            str = "0X8004AC9";
        }
        String str2 = str;
        T(null, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
    }

    public static void m(boolean z16) {
        String str;
        String str2;
        if (z16) {
            str = "0X80049A8";
        } else {
            str = "0X80049B8";
        }
        if (z16) {
            str2 = "0X80049A8";
        } else {
            str2 = "0X80049B8";
        }
        T(null, "CliOper", "", "", str, str2, 0, 0, "", "", "", "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
    
        if (r15 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        if (r15 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        r14 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(boolean z16, boolean z17) {
        String str;
        String str2;
        String str3;
        if (z16) {
            str = "0X80049A2";
            str2 = "0X80049B1";
            if (z17) {
                str3 = "0X80049A2";
            } else {
                str3 = "0X80049B1";
            }
        } else {
            str = "0X800499F";
            str2 = "0X80049AE";
            if (z17) {
                str3 = "0X800499F";
            } else {
                str3 = "0X80049AE";
            }
        }
        T(null, "CliOper", "", "", str3, str, 0, 0, "", "", "", "");
    }

    public static void o(int i3, int i16) {
        String str;
        String str2;
        String str3;
        boolean z16 = true;
        if (i16 != 1) {
            z16 = false;
        }
        if (i3 == m.l.f76062h) {
            String str4 = "0X8004368";
            if (z16) {
                str3 = "0X8004368";
            } else {
                str3 = "0X8004450";
            }
            if (!z16) {
                str4 = "0X8004450";
            }
            str2 = str4;
            str = str3;
        } else {
            str = "";
            str2 = str;
        }
        T(null, "CliOper", "", "", str, str2, 0, 0, "", "", "", "");
    }

    public static void p() {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            T(null, "CliOper", "", "", "0X8004388", "0X8004388", 0, 0, "", "", "", "");
        } else if (i3 == 2) {
            T(null, "CliOper", "", "", "0X80043E3", "0X80043E3", 0, 0, "", "", "", "");
        }
    }

    public static void q() {
        SessionInfo f16 = com.tencent.av.n.e().f();
        T(null, "dc00898", "", w(f16), "0X800A2CC", "0X800A2CC", f16.f73035i, 0, "", "", "", "");
    }

    public static void r(String str) {
        T(null, "dc00898", "", "", "0X800A2CD", "0X800A2CD", com.tencent.av.n.e().f().f73035i, 0, str, "", "", "");
    }

    public static void s() {
        String str;
        if (!com.tencent.av.n.e().f().X) {
            int i3 = com.tencent.av.n.e().f().A0;
            if (i3 != -1) {
                if (i3 != 0) {
                    if (i3 != 3) {
                        if (i3 != 12) {
                            if (i3 != 25) {
                                if (i3 != 54) {
                                    if (i3 != 42) {
                                        if (i3 != 43) {
                                            str = "8";
                                        } else {
                                            str = "5";
                                        }
                                    } else {
                                        str = "6";
                                    }
                                }
                            } else {
                                str = "7";
                            }
                        } else if (!com.tencent.av.n.e().f().W) {
                            str = "2";
                        } else {
                            str = "4";
                        }
                    } else {
                        str = "3";
                    }
                } else if (com.tencent.av.n.e().f().f73008c0 >= 0) {
                    str = "1";
                } else {
                    str = "0";
                }
            }
            str = "9";
        } else {
            str = "";
        }
        String str2 = str;
        int i16 = com.tencent.av.n.e().f().f73035i;
        if (i16 == 1) {
            if (com.tencent.av.n.e().f().z()) {
                T(null, "CliOper", "", "", "0X800438A", "0X800438A", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0X800435B", "0X800435B", 0, 0, str2, "", "", "");
                return;
            }
        }
        if (i16 == 2) {
            if (com.tencent.av.n.e().f().z()) {
                T(null, "CliOper", "", "", "0X80043E5", "0X80043E5", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X80043C6", "0X80043C6", 0, 0, str2, "", "", "");
            }
        }
    }

    public static void t() {
        if (com.tencent.av.n.e().f().z() && com.tencent.av.n.e().f().f73035i == 1 && !com.tencent.av.n.e().f().I0) {
            T(null, "CliOper", "", "", "0X8004379", "0X8004379", 0, 0, "", "", "", "");
        }
    }

    public static void u() {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            if (com.tencent.av.n.e().f().z()) {
                T(null, "CliOper", "", "", "0X800436B", "0X800436B", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0X800434C", "0X800434C", 0, 0, String.valueOf(ad.f(VideoAppInterface.N().getApp().getApplicationContext())), "", "", "");
                return;
            }
        }
        if (i3 == 2) {
            if (com.tencent.av.n.e().f().z()) {
                T(null, "CliOper", "", "", "0X80043CB", "0X80043CB", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X80043B7", "0X80043B7", 0, 0, String.valueOf(ad.f(VideoAppInterface.N().getApp().getApplicationContext())), "", "", "");
            }
        }
    }

    public static int v(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return 1;
        }
        int i3 = sessionInfo.f73035i;
        if (i3 != 1 && i3 != 2) {
            return i3;
        }
        if (sessionInfo.K()) {
            return 5;
        }
        return i3;
    }

    static String w(SessionInfo sessionInfo) {
        if (sessionInfo.E()) {
            return sessionInfo.f73091w;
        }
        if (sessionInfo.F()) {
            return String.valueOf(sessionInfo.P0);
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("DataReport", 1, "getUin, error, sessionInfo[" + sessionInfo + "]");
        }
        return sessionInfo.f73091w;
    }

    public static void x(boolean z16) {
        int i3 = com.tencent.av.n.e().f().f73035i;
        if (i3 == 1) {
            if (com.tencent.av.n.e().f().z()) {
                if (z16) {
                    T(null, "CliOper", "", "", "0X8004373", "0X8004373", 0, 0, "", "", "", "");
                } else {
                    T(null, "CliOper", "", "", "0X8004378", "0X8004378", 0, 0, "", "", "", "");
                }
            } else if (z16) {
                T(null, "CliOper", "", "", "0X800434F", "0X800434F", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X8004350", "0X8004350", 0, 0, "", "", "", "");
            }
        } else if (i3 == 2) {
            if (com.tencent.av.n.e().f().z()) {
                if (z16) {
                    T(null, "CliOper", "", "", "0X80043D3", "0X80043D3", 0, 0, "", "", "", "");
                } else {
                    T(null, "CliOper", "", "", "0X80043D4", "0X80043D4", 0, 0, "", "", "", "");
                }
            } else if (z16) {
                T(null, "CliOper", "", "", "0X80043BA", "0X80043BA", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X80043BB", "0X80043BB", 0, 0, "", "", "", "");
            }
        }
        if (com.tencent.av.n.e().f().f73067q == 1008) {
            if (z16) {
                T(null, "CliOper", "", "", "0X8005DA8", "0X8005DA8", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X8005DAA", "0X8005DAA", 0, 0, "", "", "", "");
            }
        }
    }

    public static void y() {
        String str;
        int i3 = com.tencent.av.n.e().f().A0;
        if (i3 != -1) {
            if (i3 != 0) {
                if (i3 != 3) {
                    if (i3 != 12) {
                        if (i3 != 25) {
                            if (i3 != 54) {
                                if (i3 != 42) {
                                    if (i3 != 43) {
                                        str = "8";
                                    } else {
                                        str = "5";
                                    }
                                } else {
                                    str = "6";
                                }
                            } else {
                                str = "10";
                            }
                        } else {
                            str = "7";
                        }
                    } else if (!com.tencent.av.n.e().f().W) {
                        str = "2";
                    } else {
                        str = "4";
                    }
                } else {
                    str = "3";
                }
            } else if (com.tencent.av.n.e().f().f73008c0 >= 0) {
                str = "1";
            } else {
                str = "0";
            }
        } else {
            str = "9";
        }
        String str2 = str;
        int i16 = com.tencent.av.n.e().f().f73035i;
        if (i16 == 1) {
            if (com.tencent.av.n.e().f().z()) {
                T(null, "CliOper", "", "", "0X8004389", "0X8004389", 0, 0, "", "", "", "");
                return;
            } else {
                T(null, "CliOper", "", "", "0X8004358", "0X8004358", 0, 0, str2, "", "", "");
                return;
            }
        }
        if (i16 == 2) {
            if (com.tencent.av.n.e().f().z()) {
                T(null, "CliOper", "", "", "0X80043E4", "0X80043E4", 0, 0, "", "", "", "");
            } else {
                T(null, "CliOper", "", "", "0X80043C3", "0X80043C3", 0, 0, str2, "", "", "");
            }
        }
    }

    public static void z() {
        if (f76669b) {
            return;
        }
        f76669b = true;
        if (com.tencent.av.n.e().f().N || com.tencent.av.n.e().f().O) {
            T(null, "CliOper", "", "", "0X800438F", "0X800438F", 0, 0, "", "", "", "");
        }
    }
}
