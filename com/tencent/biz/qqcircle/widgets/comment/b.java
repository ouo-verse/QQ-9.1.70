package com.tencent.biz.qqcircle.widgets.comment;

import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.mobileqq.R;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f93565a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: b, reason: collision with root package name */
    private static final StringBuffer f93566b = new StringBuffer(25);

    /* renamed from: c, reason: collision with root package name */
    private static StringBuilder f93567c = new StringBuilder(32);

    private static String a(long j3, long j16, boolean z16) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i3 = calendar.get(5);
        int i16 = calendar.get(11);
        int i17 = calendar.get(12);
        int i18 = calendar.get(1);
        int i19 = calendar.get(2) + 1;
        int i26 = calendar.get(6);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        int i27 = calendar2.get(1);
        int h16 = h(i18, i26, i27, calendar2.get(6));
        StringBuilder sb5 = f93567c;
        sb5.delete(0, sb5.length());
        if (h16 == 1) {
            StringBuilder sb6 = f93567c;
            sb6.append("\u6628\u5929 ");
            if (i16 < 10) {
                valueOf3 = "0" + i16;
            } else {
                valueOf3 = Integer.valueOf(i16);
            }
            sb6.append(valueOf3);
            sb6.append(":");
            if (i17 < 10) {
                valueOf4 = "0" + i17;
            } else {
                valueOf4 = Integer.valueOf(i17);
            }
            sb6.append(valueOf4);
            return sb6.toString();
        }
        if (h16 == 2) {
            StringBuilder sb7 = f93567c;
            sb7.append("\u524d\u5929 ");
            if (i16 < 10) {
                valueOf = "0" + i16;
            } else {
                valueOf = Integer.valueOf(i16);
            }
            sb7.append(valueOf);
            sb7.append(":");
            if (i17 < 10) {
                valueOf2 = "0" + i17;
            } else {
                valueOf2 = Integer.valueOf(i17);
            }
            sb7.append(valueOf2);
            return sb7.toString();
        }
        return g(i3, i18, i19, i27, z16);
    }

    public static String b(long j3) {
        return c(j3, "-");
    }

    public static String c(long j3, String str) {
        Object valueOf;
        Object valueOf2;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i3 = calendar.get(5);
        int i16 = calendar.get(1);
        int i17 = calendar.get(2) + 1;
        StringBuilder sb5 = f93567c;
        sb5.delete(0, sb5.length());
        StringBuilder sb6 = f93567c;
        sb6.append(i16);
        sb6.append(str);
        if (i17 < 10) {
            valueOf = "0" + i17;
        } else {
            valueOf = Integer.valueOf(i17);
        }
        sb6.append(valueOf);
        sb6.append(str);
        if (i3 < 10) {
            valueOf2 = "0" + i3;
        } else {
            valueOf2 = Integer.valueOf(i3);
        }
        sb6.append(valueOf2);
        return sb6.toString();
    }

    public static String d(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        String a16 = h.a(R.string.ih9);
        String a17 = h.a(R.string.ih_);
        String a18 = h.a(R.string.ih8);
        long j16 = (currentTimeMillis - j3) / 1000;
        if (j16 < 60) {
            return a16;
        }
        if (j16 < 3600) {
            return String.format(a17, Long.valueOf(j16 / 60));
        }
        if (j16 < 86400) {
            return String.format(a18, Long.valueOf((j16 / 60) / 60));
        }
        return a(j3, currentTimeMillis, false);
    }

    public static String e(long j3, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        String a16 = h.a(R.string.ih9);
        String a17 = h.a(R.string.ih_);
        String a18 = h.a(R.string.ih8);
        long j16 = (currentTimeMillis - j3) / 1000;
        if (j16 < 60) {
            return a16;
        }
        if (j16 < 3600) {
            return String.format(a17, Long.valueOf(j16 / 60));
        }
        if (j16 < 86400) {
            return String.format(a18, Long.valueOf((j16 / 60) / 60));
        }
        return a(j3, currentTimeMillis, z16);
    }

    public static String f(long j3) {
        return HostStaticInvokeHelper.getQMessageDateTime(f93566b, j3, true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, true);
    }

    private static String g(int i3, int i16, int i17, int i18, boolean z16) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        if (z16) {
            if (i18 != i16) {
                StringBuilder sb5 = f93567c;
                sb5.append(i16);
                sb5.append("\u5e74");
                sb5.append(i17);
                sb5.append("\u6708");
                sb5.append(i3);
                sb5.append("\u65e5");
                return sb5.toString();
            }
            StringBuilder sb6 = f93567c;
            sb6.append(i17);
            sb6.append("\u6708");
            sb6.append(i3);
            sb6.append("\u65e5");
            return sb6.toString();
        }
        if (i18 != i16) {
            StringBuilder sb7 = f93567c;
            sb7.append(i16);
            sb7.append("-");
            if (i17 < 10) {
                valueOf3 = "0" + i17;
            } else {
                valueOf3 = Integer.valueOf(i17);
            }
            sb7.append(valueOf3);
            sb7.append("-");
            if (i3 < 10) {
                valueOf4 = "0" + i3;
            } else {
                valueOf4 = Integer.valueOf(i3);
            }
            sb7.append(valueOf4);
            return sb7.toString();
        }
        StringBuilder sb8 = f93567c;
        if (i17 < 10) {
            valueOf = "0" + i17;
        } else {
            valueOf = Integer.valueOf(i17);
        }
        sb8.append(valueOf);
        sb8.append("-");
        if (i3 < 10) {
            valueOf2 = "0" + i3;
        } else {
            valueOf2 = Integer.valueOf(i3);
        }
        sb8.append(valueOf2);
        return sb8.toString();
    }

    private static int h(int i3, int i16, int i17, int i18) {
        if (i17 != i3) {
            int i19 = 0;
            while (i3 < i17) {
                if ((i3 % 4 == 0 && i3 % 100 != 0) || i3 % 400 == 0) {
                    i19 += 366;
                } else {
                    i19 += 365;
                }
                i3++;
            }
            return i19 + (i18 - i16);
        }
        return i18 - i16;
    }
}
