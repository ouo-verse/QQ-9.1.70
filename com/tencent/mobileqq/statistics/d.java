package com.tencent.mobileqq.statistics;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f289977a;

    /* renamed from: b, reason: collision with root package name */
    private static long f289978b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile int f289979c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile int f289980d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile int f289981e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile int f289982f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile int f289983g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile int f289984h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile int f289985i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile int f289986j;

    /* renamed from: k, reason: collision with root package name */
    private static volatile int f289987k;

    /* renamed from: l, reason: collision with root package name */
    private static volatile int f289988l;

    /* renamed from: m, reason: collision with root package name */
    private static volatile int f289989m;

    /* renamed from: n, reason: collision with root package name */
    private static volatile int f289990n;

    /* renamed from: o, reason: collision with root package name */
    private static HashMap<String, Long> f289991o;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f289992p;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f289993q;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75417);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f289977a = false;
        f289991o = new HashMap<>();
        f289992p = false;
        f289993q = true;
    }

    public static void a(int i3, int i16, int i17, int i18) {
        int i19;
        if (f289992p && f289977a) {
            if (i17 != 0) {
                if (i17 != 1) {
                    i19 = 2;
                } else {
                    i19 = 1;
                }
            } else {
                i19 = 0;
            }
            if (i3 == 0) {
                if (i16 == 0) {
                    c(i19, i18);
                } else if (i16 == 1) {
                    b(i19, i18);
                }
            }
            if (i3 == 1) {
                if (i16 == 0) {
                    e(i19, i18);
                } else if (i16 == 1) {
                    d(i19, i18);
                }
            }
            if (f289993q) {
                QLog.d("FightMsgReporter", 1, "add count = " + i18 + ",uinType = " + i17);
            }
        }
    }

    private static void b(int i3, int i16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    f289981e += i16;
                    return;
                }
                return;
            }
            f289979c += i16;
            return;
        }
        f289980d += i16;
    }

    private static void c(int i3, int i16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    f289984h += i16;
                    return;
                }
                return;
            }
            f289982f += i16;
            return;
        }
        f289983g += i16;
    }

    private static void d(int i3, int i16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    f289987k += i16;
                    return;
                }
                return;
            }
            f289985i += i16;
            return;
        }
        f289986j += i16;
    }

    private static void e(int i3, int i16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    f289990n += i16;
                    return;
                }
                return;
            }
            f289988l += i16;
            return;
        }
        f289989m += i16;
    }

    public static void f(String str, long j3, long j16) {
        if (!f289992p) {
            return;
        }
        if (!f289977a) {
            i();
        }
        long h16 = h(0, str, 1, j16);
        int max = (int) (j3 - Math.max(h16, j16));
        a(0, 1, 1, max);
        k(0, str, 1, j3);
        if (f289993q) {
            QLog.d("FightMsgReporter", 1, "computeTroopMsgNew.value:" + String.format("%s_%d_%d_%d_%d", str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(h16), Integer.valueOf(max)));
        }
    }

    private static String g(String str, int i3, String str2, int i16) {
        return String.format("%d_%s_%d_%s", Integer.valueOf(i3), str2, Integer.valueOf(i16), str);
    }

    private static long h(int i3, String str, int i16, long j3) {
        String g16 = g(BaseApplicationImpl.getApplication().getRuntime().getAccount(), i3, str, i16);
        if (f289991o.containsKey(g16)) {
            return f289991o.get(g16).longValue();
        }
        return j3;
    }

    private static void i() {
        f289992p = false;
        BaseApplication context = BaseApplication.getContext();
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        f289980d = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_new_friend", 0)).intValue();
        f289979c = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_new_troop", 0)).intValue();
        f289981e = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_new_other", 0)).intValue();
        f289983g = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_new_friend_aio", 0)).intValue();
        f289982f = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_new_troop_aio", 0)).intValue();
        f289984h = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_new_other_aio", 0)).intValue();
        f289986j = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_readed_friend", 0)).intValue();
        f289985i = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_readed_troop", 0)).intValue();
        f289987k = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_readed_other", 0)).intValue();
        f289989m = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_readed_friend_aio", 0)).intValue();
        f289988l = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_readed_troop_aio", 0)).intValue();
        f289990n = ((Integer) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_funnel_report_readed_other_aio", 0)).intValue();
        f289978b = ((Long) com.tencent.mobileqq.utils.p.c(context, "f_msg_report_preference", account, "key_msg_report_time", Long.valueOf(System.currentTimeMillis()))).longValue();
        if (f289993q) {
            QLog.d("FightMsgReporter", 1, "init.value:" + String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d_%d", Boolean.valueOf(f289992p), Integer.valueOf(f289980d), Integer.valueOf(f289979c), Integer.valueOf(f289983g), Integer.valueOf(f289982f), Integer.valueOf(f289986j), Integer.valueOf(f289985i), Integer.valueOf(f289989m), Integer.valueOf(f289988l), Long.valueOf(f289978b)));
        }
        f289977a = true;
    }

    public static void j() {
        if (f289992p && f289977a) {
            BaseApplication context = BaseApplication.getContext();
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_new_friend", Integer.valueOf(f289980d));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_new_troop", Integer.valueOf(f289979c));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_new_other", Integer.valueOf(f289981e));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_new_friend_aio", Integer.valueOf(f289983g));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_new_troop_aio", Integer.valueOf(f289982f));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_new_other_aio", Integer.valueOf(f289984h));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_readed_friend", Integer.valueOf(f289986j));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_readed_troop", Integer.valueOf(f289985i));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_readed_other", Integer.valueOf(f289987k));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_readed_friend_aio", Integer.valueOf(f289989m));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_readed_troop_aio", Integer.valueOf(f289988l));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_funnel_report_readed_other_aio", Integer.valueOf(f289990n));
            com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, "key_msg_report_time", Long.valueOf(f289978b));
            if (f289993q) {
                QLog.d("FightMsgReporter", 1, "saveToSp.value:" + String.format("%b_%d_%d_%d_%d_%d_%d_%d_%d_%d", Boolean.valueOf(f289992p), Integer.valueOf(f289980d), Integer.valueOf(f289979c), Integer.valueOf(f289983g), Integer.valueOf(f289982f), Integer.valueOf(f289986j), Integer.valueOf(f289985i), Integer.valueOf(f289989m), Integer.valueOf(f289988l), Long.valueOf(f289978b)));
            }
        }
    }

    private static void k(int i3, String str, int i16, long j3) {
        BaseApplication context = BaseApplication.getContext();
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        String g16 = g(account, i3, str, i16);
        f289991o.put(g16, Long.valueOf(j3));
        com.tencent.mobileqq.utils.p.e(context, "f_msg_report_preference", account, false, g16, Long.valueOf(j3));
    }
}
