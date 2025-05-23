package com.tencent.mobileqq.systemmsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgAction;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;
    private static long A;
    private static long B;
    private static long C;
    private static long D;
    private static long E;
    private static long F;
    private static long G;
    private static long H;
    private static long I;
    private static long J;

    /* renamed from: a, reason: collision with root package name */
    private static long f291303a;

    /* renamed from: b, reason: collision with root package name */
    private static long f291304b;

    /* renamed from: c, reason: collision with root package name */
    private static long f291305c;

    /* renamed from: d, reason: collision with root package name */
    private static long f291306d;

    /* renamed from: e, reason: collision with root package name */
    private static long f291307e;

    /* renamed from: f, reason: collision with root package name */
    private static long f291308f;

    /* renamed from: g, reason: collision with root package name */
    private static long f291309g;

    /* renamed from: h, reason: collision with root package name */
    private static long f291310h;

    /* renamed from: i, reason: collision with root package name */
    private static long f291311i;

    /* renamed from: j, reason: collision with root package name */
    private static long f291312j;

    /* renamed from: k, reason: collision with root package name */
    private static long f291313k;

    /* renamed from: l, reason: collision with root package name */
    private static long f291314l;

    /* renamed from: m, reason: collision with root package name */
    private static long f291315m;

    /* renamed from: n, reason: collision with root package name */
    private static long f291316n;

    /* renamed from: o, reason: collision with root package name */
    private static long f291317o;

    /* renamed from: p, reason: collision with root package name */
    private static long f291318p;

    /* renamed from: q, reason: collision with root package name */
    private static long f291319q;

    /* renamed from: r, reason: collision with root package name */
    private static long f291320r;

    /* renamed from: s, reason: collision with root package name */
    private static long f291321s;

    /* renamed from: t, reason: collision with root package name */
    private static long f291322t;

    /* renamed from: u, reason: collision with root package name */
    private static long f291323u;

    /* renamed from: v, reason: collision with root package name */
    private static long f291324v;

    /* renamed from: w, reason: collision with root package name */
    private static long f291325w;

    /* renamed from: x, reason: collision with root package name */
    private static long f291326x;

    /* renamed from: y, reason: collision with root package name */
    private static long f291327y;

    /* renamed from: z, reason: collision with root package name */
    private static long f291328z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75832);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f291303a = 202000000L;
        f291304b = 213000000L;
        f291305c = 0L;
        long j3 = 0 + (213000000 - 202000000);
        f291306d = j3;
        f291307e = 480000000L;
        f291308f = 489000000L;
        f291309g = j3;
        long j16 = j3 + (489000000 - 480000000);
        f291310h = j16;
        f291311i = 2100000000L;
        f291312j = 2147000000L;
        f291313k = j16;
        long j17 = j16 + (2147000000 - 2100000000);
        f291314l = j17;
        f291315m = 2010000000L;
        f291316n = 2100000000L;
        f291317o = j17;
        long j18 = j17 + (2100000000 - 2010000000);
        f291318p = j18;
        f291319q = 2147000000L;
        f291320r = 2200000000L;
        f291321s = j18;
        long j19 = j18 + (2200000000L - 2147000000);
        f291322t = j19;
        f291323u = 4100000000L;
        f291324v = 4200000000L;
        f291325w = j19;
        long j26 = j19 + (4200000000L - 4100000000L);
        f291326x = j26;
        f291327y = 3800000000L;
        f291328z = 4000000000L;
        A = j26;
        long j27 = j26 + (4000000000L - 3800000000L);
        B = j27;
        C = 2601000000L;
        D = 2652000000L;
        E = 336000000L;
        F = 387000000L;
        G = 510000000L;
        H = 2010000000L;
        I = j27;
        J = j27 + (2010000000 - 510000000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static String a(long j3) {
        long j16;
        ?? r26;
        long j17 = f291305c;
        boolean z16 = false;
        if (j3 >= j17 && j3 < f291306d) {
            j16 = (j3 - j17) + f291303a;
            r26 = 0;
        } else {
            j16 = 0;
            r26 = -1;
        }
        long j18 = f291309g;
        boolean z17 = r26;
        if (j3 >= j18) {
            z17 = r26;
            if (j3 < f291310h) {
                j16 = (j3 - j18) + f291307e;
                z17 = false;
            }
        }
        long j19 = f291313k;
        boolean z18 = z17;
        if (j3 >= j19) {
            z18 = z17;
            if (j3 < f291314l) {
                j16 = (j3 - j19) + f291311i;
                z18 = false;
            }
        }
        long j26 = f291317o;
        boolean z19 = z18;
        if (j3 >= j26) {
            z19 = z18;
            if (j3 < f291318p) {
                j16 = (j3 - j26) + f291315m;
                z19 = false;
            }
        }
        long j27 = f291321s;
        boolean z26 = z19;
        if (j3 >= j27) {
            z26 = z19;
            if (j3 < f291322t) {
                j16 = (j3 - j27) + f291319q;
                z26 = false;
            }
        }
        long j28 = f291325w;
        boolean z27 = z26;
        if (j3 >= j28) {
            z27 = z26;
            if (j3 < f291326x) {
                j16 = (j3 - j28) + f291323u;
                z27 = false;
            }
        }
        long j29 = A;
        boolean z28 = z27;
        if (j3 >= j29) {
            z28 = z27;
            if (j3 < B) {
                int i3 = (j3 > E ? 1 : (j3 == E ? 0 : -1));
                j16 = (j3 - j29) + f291327y;
                z28 = false;
            }
        }
        long j36 = I;
        if (j3 >= j36 && j3 < J) {
            j16 = G + (j3 - j36);
        } else {
            z16 = z28;
        }
        if (!z16) {
            return String.valueOf(j16);
        }
        return null;
    }

    public static int b(int i3, int i16) {
        if (i3 == 1) {
            if (i16 == 1) {
                return 2;
            }
            if (i16 == 2) {
                return 3;
            }
            if (i16 != 3) {
                if (i16 == 4) {
                    return 8;
                }
                return i3;
            }
            return 7;
        }
        return i3;
    }

    public static int c(int i3, int i16, int i17) {
        if (i16 == 11) {
            if (i3 != 1) {
                return i3;
            }
        } else {
            if (i16 == 12) {
                if (i3 == 1) {
                    if (i17 != 1) {
                    }
                } else {
                    return i3;
                }
            } else if (i16 != 13) {
                if (i16 == 14) {
                    return 4;
                }
                if (i16 != 16) {
                    return i3;
                }
            }
            return 3;
        }
        return 2;
    }

    public static void d(structmsg$StructMsg structmsg_structmsg, int i3, String str, int i16) {
        List<structmsg$SystemMsgAction> list;
        if (structmsg_structmsg != null) {
            int i17 = structmsg_structmsg.msg_type.get();
            if (i17 != 1) {
                if (i17 == 2 && (list = structmsg_structmsg.f436065msg.actions.get()) != null && list.size() > i3 && g(structmsg_structmsg.f436065msg.sub_type.get(), structmsg_structmsg.f436065msg.group_msg_type.get())) {
                    structmsg_structmsg.f436065msg.msg_decided.set(list.get(i3).result.get());
                    structmsg_structmsg.f436065msg.msg_detail.set(str);
                    structmsg_structmsg.f436065msg.sub_type.set(c(structmsg_structmsg.f436065msg.sub_type.get(), list.get(i3).action_info.type.get(), structmsg_structmsg.f436065msg.group_msg_type.get()));
                    structmsg_structmsg.f436065msg.actions.clear();
                    return;
                }
                return;
            }
            List<structmsg$SystemMsgAction> list2 = structmsg_structmsg.f436065msg.actions.get();
            if (list2 != null && list2.size() > i3) {
                structmsg_structmsg.f436065msg.msg_decided.set(list2.get(i3).result.get());
                structmsg_structmsg.f436065msg.msg_detail.set(str);
                structmsg_structmsg.f436065msg.sub_type.set(b(structmsg_structmsg.f436065msg.sub_type.get(), list2.get(i3).action_info.type.get()));
                structmsg_structmsg.f436065msg.actions.clear();
            }
        }
    }

    public static boolean e(structmsg$StructMsg structmsg_structmsg, int i3, String str, String str2) {
        if (structmsg_structmsg != null && i3 != 0 && i3 != 3) {
            if (structmsg_structmsg.msg_type.get() == 1) {
                if (structmsg_structmsg.f436065msg.sub_type.get() == 9 || structmsg_structmsg.f436065msg.sub_type.get() == 10 || structmsg_structmsg.f436065msg.sub_type.get() == 1) {
                    structmsg_structmsg.f436065msg.msg_decided.set(str2);
                    structmsg_structmsg.f436065msg.msg_detail.set(str);
                    structmsg_structmsg.f436065msg.actions.clear();
                    return true;
                }
            } else if (structmsg_structmsg.msg_type.get() == 2) {
                structmsg_structmsg.f436065msg.sub_type.set(5);
                structmsg_structmsg.f436065msg.msg_decided.set(str2);
                structmsg_structmsg.f436065msg.msg_detail.set(str);
                structmsg_structmsg.f436065msg.actions.clear();
                return true;
            }
        }
        return false;
    }

    public static boolean f(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6 || i3 == 7 || i3 == 8 || i3 == 9 || i3 == 10 || i3 == 12 || i3 == 13) {
            return true;
        }
        return false;
    }

    private static boolean g(int i3, int i16) {
        if (i3 == 3 && (i16 == 10 || i16 == 11)) {
            return false;
        }
        return true;
    }
}
