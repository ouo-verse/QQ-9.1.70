package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.Time;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes20.dex */
public class en {

    /* renamed from: a, reason: collision with root package name */
    private static Calendar f307733a;

    /* renamed from: b, reason: collision with root package name */
    private static StringBuffer f307734b;

    /* renamed from: c, reason: collision with root package name */
    private static int f307735c;

    /* renamed from: d, reason: collision with root package name */
    private static int f307736d;

    /* renamed from: e, reason: collision with root package name */
    private static ThreadLocal<DateFormat> f307737e;

    /* renamed from: f, reason: collision with root package name */
    private static ThreadLocal<DateFormat> f307738f;

    /* renamed from: g, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/Establish/Inject_LocalManager.yml", version = 1)
    static com.tencent.mobileqq.inject.j f307739g;

    /* renamed from: h, reason: collision with root package name */
    private static ArrayList f307740h;

    static {
        ArrayList arrayList = new ArrayList();
        f307740h = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.r.class);
        f307737e = new ThreadLocal<>();
        f307738f = new ThreadLocal<>();
    }

    private static int a(int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i3 != i18) {
            return 5;
        }
        if (i17 == i26) {
            return 1;
        }
        if (i17 == i26 + 1) {
            return 2;
        }
        if (i17 == i26 + 2) {
            return 3;
        }
        return 4;
    }

    public static int b(long j3) {
        try {
            f307733a.setTimeInMillis(System.currentTimeMillis());
            int i3 = f307733a.get(1);
            int i16 = f307733a.get(2);
            int i17 = f307733a.get(6);
            f307733a.setTimeInMillis(j3);
            return a(i3, i16, i17, f307733a.get(1), f307733a.get(2), f307733a.get(6));
        } catch (Exception e16) {
            QLog.e("calTimeInterval", 2, e16.getMessage());
            return -1;
        }
    }

    private static void c() {
        boolean z16;
        if (f307739g == null) {
            z();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[AutoInject] inject:");
                if (f307739g != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("TimeFormatterUtils", 2, sb5.toString());
            }
        }
    }

    public static CharSequence d(Context context, int i3, long j3) {
        return e(context, i3, j3, true);
    }

    public static CharSequence e(Context context, int i3, long j3, boolean z16) {
        return f(context, i3, j3, z16, false);
    }

    public static CharSequence f(Context context, int i3, long j3, boolean z16, boolean z17) {
        SimpleDateFormat simpleDateFormat;
        StringBuilder sb5 = new StringBuilder();
        try {
            simpleDateFormat = (SimpleDateFormat) l();
        } catch (Resources.NotFoundException unused) {
            simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR);
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        if (z17) {
            simpleDateFormat2.applyPattern("yyyy/MM/dd");
        }
        if (i3 == 0) {
            sb5.append(simpleDateFormat2.toLocalizedPattern());
            StringBuilder sb6 = new StringBuilder();
            sb5.append(" ");
            sb6.append((Object) android.text.format.DateFormat.format(sb5.toString(), j3));
            sb6.append(u().format(Long.valueOf(j3)));
            return sb6.toString();
        }
        return n(context, j3, sb5, simpleDateFormat2, i3, z16, z17);
    }

    public static String g(Context context, long j3) {
        return h(context, j3, false);
    }

    public static String h(Context context, long j3, boolean z16) {
        String str;
        String str2;
        f307733a.setTimeInMillis(System.currentTimeMillis());
        int i3 = f307733a.get(1);
        int i16 = f307733a.get(2);
        int i17 = f307733a.get(6);
        f307733a.setTimeInMillis(j3);
        int a16 = a(i3, i16, i17, f307733a.get(1), f307733a.get(2), f307733a.get(6));
        String str3 = "HH:mm:ss";
        if (a16 != 1) {
            if (a16 != 2) {
                if (a16 != 3) {
                    if (a16 != 4) {
                        if (a16 != 5) {
                            return null;
                        }
                        if (z16) {
                            str2 = "yyyy-MM-dd HH:mm:ss";
                        } else {
                            str2 = TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT;
                        }
                        return new SimpleDateFormat(str2, context.getResources().getConfiguration().locale).format(new Date(j3));
                    }
                    if (z16) {
                        str = "MM-dd HH:mm:ss";
                    } else {
                        str = "MM-dd HH:mm";
                    }
                    return new SimpleDateFormat(str, context.getResources().getConfiguration().locale).format(new Date(j3));
                }
                if (!z16) {
                    str3 = DateUtil.DATE_FORMAT_HOUR;
                }
                return String.format("%s %s", HardCodeUtil.qqStr(R.string.f208585d4), new SimpleDateFormat(str3, context.getResources().getConfiguration().locale).format(new Date(j3)));
            }
            if (!z16) {
                str3 = DateUtil.DATE_FORMAT_HOUR;
            }
            return String.format("%s %s", HardCodeUtil.qqStr(R.string.f208525cy), new SimpleDateFormat(str3, context.getResources().getConfiguration().locale).format(new Date(j3)));
        }
        if (!z16) {
            str3 = DateUtil.DATE_FORMAT_HOUR;
        }
        return new SimpleDateFormat(str3, context.getResources().getConfiguration().locale).format(new Date(j3));
    }

    public static String i(long j3) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j3));
    }

    public static String j(int i3, boolean z16) {
        int i16;
        if (i3 >= 86400000) {
            return "unknown";
        }
        float f16 = i3;
        int i17 = (int) (f16 / 3600000.0f);
        int i18 = (int) ((f16 % 3600000.0f) / 60000.0f);
        if (z16) {
            i16 = Math.round((f16 % 60000.0f) / 1000.0f);
        } else {
            i16 = (int) ((f16 % 60000.0f) / 1000.0f);
        }
        if (i17 > 0) {
            return String.format("%02d:%02d:%02d", Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i16));
        }
        return String.format("%02d:%02d", Integer.valueOf(i18), Integer.valueOf(i16));
    }

    public static int k(long j3) {
        f307733a.setTimeInMillis(j3 + f307736d);
        return f307733a.get(11);
    }

    private static synchronized DateFormat l() {
        DateFormat dateFormat;
        synchronized (en.class) {
            if (f307738f.get() == null) {
                f307738f.set(android.text.format.DateFormat.getDateFormat(BaseApplication.getContext()));
            }
            dateFormat = f307738f.get();
        }
        return dateFormat;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x008e, code lost:
    
        if (r9 < r5) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m(long j3, Calendar calendar) {
        Time time = new Time();
        time.set(j3);
        long currentTimeMillis = System.currentTimeMillis();
        Time time2 = new Time();
        time2.set(currentTimeMillis);
        int i3 = time2.yearDay;
        int i16 = i3 - 1;
        int i17 = i3 - 7;
        int i18 = time.year;
        int i19 = time2.year;
        if (i18 == i19) {
            int i26 = time.yearDay;
            if (i3 < i26) {
                return -1;
            }
            if (i3 == i26) {
                return R.string.f208685dd;
            }
            if (i26 != i16) {
                if (i26 < i16 && i26 > i17) {
                    switch (time.weekDay) {
                        case 0:
                            return R.string.f208655da;
                        case 1:
                            return R.string.f207725as;
                        case 2:
                            return R.string.f208725dh;
                        case 3:
                            return R.string.f208735di;
                        case 4:
                            return R.string.f208675dc;
                        case 5:
                            return R.string.f207655al;
                        case 6:
                            return R.string.f208415cn;
                        default:
                            return -1;
                    }
                }
                return R.string.f207575ad;
            }
            return R.string.f208765dl;
        }
        if (i18 + 1 == i19) {
            long j16 = (((currentTimeMillis - j3) + 86400000) - 1) / 86400000;
            if (j16 > 0 && j16 <= 7) {
                if (j16 != 1) {
                    switch (time.weekDay) {
                        case 6:
                            return R.string.f208415cn;
                    }
                }
                return R.string.f208765dl;
            }
            return R.string.f207475a4;
        }
    }

    private static CharSequence n(Context context, long j3, StringBuilder sb5, SimpleDateFormat simpleDateFormat, int i3, boolean z16, boolean z17) {
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        String str;
        Time time = new Time();
        time.set(j3);
        Time time2 = new Time();
        time2.setToNow();
        boolean z28 = false;
        if ((i3 & 2) != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if ((i3 & 1) != 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if ((i3 & 4) != 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (time.year != time2.year) {
            sb5.append(simpleDateFormat.toLocalizedPattern());
            sb5.append(" ");
        } else {
            int i16 = time.yearDay;
            int i17 = time2.yearDay;
            if (i16 != i17) {
                int abs = Math.abs(i17 - i16);
                if (time2.yearDay > time.yearDay) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (!z27) {
                    sb5.append(simpleDateFormat.toLocalizedPattern());
                    sb5.append(" ");
                } else {
                    if (abs == 1 && z19) {
                        sb5.append(context.getString(R.string.f208765dl));
                        sb5.append(" ");
                        if (!z16) {
                            return sb5.toString().trim();
                        }
                        return sb5.toString() + w(context, j3);
                    }
                    if (abs == 2 && z26) {
                        sb5.append(context.getString(R.string.f207485a5));
                        sb5.append(" ");
                        if (!z16) {
                            return sb5.toString().trim();
                        }
                        return sb5.toString() + w(context, j3);
                    }
                    if (abs > 1 && abs < 7 && z18) {
                        sb5.append("EEEE");
                        sb5.append(" ");
                    } else if (time.year == time2.year) {
                        if (z17) {
                            str = "MM/dd";
                        } else {
                            str = "MM-dd";
                        }
                        sb5.append(str);
                        sb5.append(" ");
                    } else {
                        sb5.append(simpleDateFormat.toLocalizedPattern());
                        sb5.append(" ");
                    }
                }
            } else {
                z28 = true;
            }
        }
        if (!z28 && !z16) {
            return android.text.format.DateFormat.format(sb5.toString().trim(), j3);
        }
        return ((Object) android.text.format.DateFormat.format(sb5.toString(), j3)) + w(context, j3);
    }

    public static String o(long j3, String str) {
        if (j3 <= 0) {
            return null;
        }
        return new SimpleDateFormat(str).format(new Date(j3));
    }

    public static String p(long j3, boolean z16, String str) {
        return q(f307734b, j3, z16, str);
    }

    public static String q(StringBuffer stringBuffer, long j3, boolean z16, String str) {
        return r(stringBuffer, j3, z16, str, false);
    }

    public static String r(StringBuffer stringBuffer, long j3, boolean z16, String str, boolean z17) {
        return s(stringBuffer, j3, z16, str, z17, false);
    }

    public static String s(StringBuffer stringBuffer, long j3, boolean z16, String str, boolean z17, boolean z18) {
        boolean z19;
        String str2;
        SimpleDateFormat simpleDateFormat;
        if (stringBuffer != null) {
            stringBuffer.setLength(0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            int m3 = m(j3, calendar);
            if (m3 != -1 && m3 != R.string.f207475a4 && m3 != R.string.f207575ad) {
                if (m3 != R.string.f208685dd) {
                    stringBuffer.append(BaseApplication.getContext().getString(m3));
                }
                z19 = true;
            } else {
                z19 = false;
            }
            int i3 = calendar.get(11);
            int i16 = calendar.get(12);
            if (z19) {
                if (m3 == R.string.f208685dd) {
                    stringBuffer.append(w(BaseApplication.getContext(), j3));
                } else if (z17 && m3 == R.string.f208765dl) {
                    stringBuffer.append(TokenParser.SP);
                    stringBuffer.append(w(BaseApplication.getContext(), j3));
                } else if (!z16) {
                    stringBuffer.append(TokenParser.SP);
                    stringBuffer.append(i3);
                    stringBuffer.append(':');
                    if (i16 < 10) {
                        stringBuffer.append('0');
                    }
                    stringBuffer.append(i16);
                }
            } else {
                String str3 = "yyyy/MM/dd";
                if (TextUtils.isEmpty(str)) {
                    if (m3 == R.string.f207475a4) {
                        if (z18) {
                            str2 = "yyyy/MM/dd";
                        } else {
                            str2 = "yy-MM-dd";
                        }
                    } else if (z18) {
                        str2 = "MM/dd";
                    } else {
                        str2 = "MM-dd";
                    }
                } else {
                    str2 = str;
                }
                if (!z18) {
                    str3 = "yy-MM-dd";
                }
                try {
                    simpleDateFormat = new SimpleDateFormat(str2);
                } catch (Exception unused) {
                    simpleDateFormat = new SimpleDateFormat(str3);
                }
                stringBuffer.append(simpleDateFormat.format(calendar.getTime()));
                if (!z16) {
                    stringBuffer.append(TokenParser.SP);
                    stringBuffer.append(i3);
                    stringBuffer.append(':');
                    if (i16 < 10) {
                        stringBuffer.append('0');
                    }
                    stringBuffer.append(i16);
                }
            }
            QLog.d("getRecentMessageDateTime", 1, "show time: " + stringBuffer.toString(), " timeStamp: " + j3);
            return stringBuffer.toString();
        }
        return null;
    }

    public static String t(Context context, long j3) {
        f307733a.setTimeInMillis(System.currentTimeMillis());
        int i3 = f307733a.get(1);
        int i16 = f307733a.get(2);
        int i17 = f307733a.get(6);
        f307733a.setTimeInMillis(j3);
        int a16 = a(i3, i16, i17, f307733a.get(1), f307733a.get(2), f307733a.get(6));
        if (a16 != 1) {
            if (a16 != 2) {
                if (a16 != 3) {
                    if (a16 != 4) {
                        if (a16 != 5) {
                            return null;
                        }
                        return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT, context.getResources().getConfiguration().locale).format(new Date(j3));
                    }
                    return new SimpleDateFormat("MM-dd HH:mm", context.getResources().getConfiguration().locale).format(new Date(j3));
                }
                return String.format("%s %s", HardCodeUtil.qqStr(R.string.f208545d0), new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, context.getResources().getConfiguration().locale).format(new Date(j3)));
            }
            return String.format("%s %s", HardCodeUtil.qqStr(R.string.f208605d6), new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, context.getResources().getConfiguration().locale).format(new Date(j3)));
        }
        return String.format("%s %s", HardCodeUtil.qqStr(R.string.f208535cz), new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, context.getResources().getConfiguration().locale).format(new Date(j3)));
    }

    private static synchronized DateFormat u() {
        DateFormat dateFormat;
        synchronized (en.class) {
            if (f307737e.get() == null) {
                f307737e.set(android.text.format.DateFormat.getTimeFormat(BaseApplication.getContext()));
            }
            dateFormat = f307737e.get();
        }
        return dateFormat;
    }

    public static long v(long j3) {
        if (j3 == 0) {
            j3 = System.currentTimeMillis();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((j3 / 1000) * 1000);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    private static String w(Context context, long j3) {
        int i3;
        c();
        com.tencent.mobileqq.inject.j jVar = f307739g;
        if ((jVar != null && !jVar.isLocaleCN()) || TimeUtilsExt.f307362a.a()) {
            return u().format(Long.valueOf(j3));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i16 = calendar.get(11);
        int i17 = 12;
        int i18 = calendar.get(12);
        if (i16 < 6) {
            i3 = R.string.f207605ag;
        } else if (i16 < 12) {
            i3 = R.string.f208435cp;
        } else if (i16 < 18) {
            i3 = R.string.f207435a0;
        } else {
            i3 = R.string.f207795az;
        }
        if (i16 != 12) {
            i17 = i16 % 12;
        }
        String valueOf = String.valueOf(i17);
        String valueOf2 = String.valueOf(i18);
        if (i18 < 10) {
            valueOf2 = "0" + valueOf2;
        }
        return context.getString(i3) + valueOf + ":" + valueOf2;
    }

    public static int x(long j3) {
        f307733a.setTimeInMillis(j3 + f307736d);
        return f307733a.get(12);
    }

    public static void y() {
        TimeZone timeZone = TimeZone.getTimeZone(DateUtil.TIME_ZONE_8);
        TimeZone timeZone2 = TimeZone.getDefault();
        f307735c = timeZone.getRawOffset();
        f307736d = f307735c - timeZone2.getRawOffset();
        f307733a = Calendar.getInstance();
        f307734b = new StringBuffer();
    }

    @QAutoInitMethod
    static void z() {
        f307739g = (com.tencent.mobileqq.inject.j) com.tencent.mobileqq.qroute.utils.b.a(f307740h);
    }
}
