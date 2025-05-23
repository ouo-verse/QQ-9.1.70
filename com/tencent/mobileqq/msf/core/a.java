package com.tencent.mobileqq.msf.core;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;
    private static long A = 0;
    private static String B = "none";
    private static long C = 0;
    private static long D = 30000;
    private static final int E = 10000;
    private static final long F = 600000;
    private static Handler G = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f247310a = "_decode_stat_";

    /* renamed from: b, reason: collision with root package name */
    private static final int f247311b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f247312c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f247313d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f247314e = 3;

    /* renamed from: f, reason: collision with root package name */
    private static final int f247315f = 4;

    /* renamed from: g, reason: collision with root package name */
    private static final int f247316g = 5;

    /* renamed from: h, reason: collision with root package name */
    private static final int f247317h = 6;

    /* renamed from: i, reason: collision with root package name */
    private static final int f247318i = 7;

    /* renamed from: j, reason: collision with root package name */
    private static final int f247319j = 8;

    /* renamed from: k, reason: collision with root package name */
    private static final int f247320k = 9;

    /* renamed from: l, reason: collision with root package name */
    private static final int f247321l = 10;

    /* renamed from: m, reason: collision with root package name */
    private static final int f247322m = 11;

    /* renamed from: n, reason: collision with root package name */
    private static final int f247323n = 12;

    /* renamed from: o, reason: collision with root package name */
    private static final int f247324o = 13;

    /* renamed from: p, reason: collision with root package name */
    public static String f247325p = "none";

    /* renamed from: q, reason: collision with root package name */
    private static int f247326q;

    /* renamed from: r, reason: collision with root package name */
    private static int f247327r;

    /* renamed from: s, reason: collision with root package name */
    private static int f247328s;

    /* renamed from: t, reason: collision with root package name */
    private static int f247329t;

    /* renamed from: u, reason: collision with root package name */
    private static int f247330u;

    /* renamed from: v, reason: collision with root package name */
    private static int f247331v;

    /* renamed from: w, reason: collision with root package name */
    private static int f247332w;

    /* renamed from: x, reason: collision with root package name */
    private static int f247333x;

    /* renamed from: y, reason: collision with root package name */
    private static int f247334y;

    /* renamed from: z, reason: collision with root package name */
    private static long f247335z;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class HandlerC8067a extends Handler {
        static IPatchRedirector $redirector_;

        HandlerC8067a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 10000) {
                a.f();
                a.G.sendEmptyMessageDelayed(10000, 600000L);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            G = new HandlerC8067a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static long c() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() + 86400000);
        return calendar.getTimeInMillis();
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() - 86400000);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static void e() {
        String str = null;
        try {
            str = BaseApplication.getContext().getSharedPreferences(CodecWarpper.tag, 0).getString(f247310a, null);
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str)) {
            A = c();
            f();
            G.sendEmptyMessageDelayed(10000, 600000L);
            QLog.d("CodecStatHelper", 4, "CodecStatHelper Restore " + g());
            return;
        }
        String[] split = str.split("\\|");
        if (split != null && split.length == 14) {
            f247326q = a(0, split);
            f247335z = b(1, split);
            f247327r = a(2, split);
            f247328s = a(3, split);
            f247329t = a(4, split);
            f247330u = a(5, split);
            f247331v = a(6, split);
            f247332w = a(7, split);
            f247333x = a(8, split);
            f247334y = a(9, split);
            A = b(10, split);
            B = split[11];
            C = b(12, split);
            f247325p = split[13];
            if (A == 0) {
                A = c();
                f();
                QLog.d("CodecStatHelper", 4, "CodecStatHelper Restore " + g());
            }
            G.sendEmptyMessageDelayed(10000, 600000L);
            QLog.d("CodecStatHelper", 4, "CodecStatHelper Restore " + g());
            return;
        }
        A = c();
        f();
        G.sendEmptyMessageDelayed(10000, 600000L);
        QLog.d("CodecStatHelper", 4, "CodecStatHelper Restore " + g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[Catch: Exception -> 0x00de, TryCatch #0 {Exception -> 0x00de, blocks: (B:3:0x0003, B:6:0x0015, B:8:0x003d, B:10:0x0041, B:14:0x004a, B:16:0x0054, B:17:0x006f, B:21:0x00ad), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f() {
        boolean z16;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > A) {
                String h16 = h();
                QLog.d("CodecStatHelper", 4, "CodecStatHelper Report " + h16);
                HashMap hashMap = new HashMap();
                hashMap.put("param_appSpec", h16);
                if (f247329t <= 0 && f247330u <= 0 && f247331v <= 0) {
                    z16 = true;
                    if (MsfService.getCore().getStatReporter() != null) {
                        com.tencent.mobileqq.msf.core.e0.h.a(hashMap);
                        MsfService.getCore().getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247660a0, z16, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    }
                    f247326q = 0;
                    f247327r = 0;
                    f247328s = 0;
                    f247329t = 0;
                    f247330u = 0;
                    f247331v = 0;
                    f247332w = 0;
                    f247333x = 0;
                    f247334y = 0;
                    A = 0L;
                    A = c();
                    f247335z = currentTimeMillis;
                    B = "none";
                    C = 0L;
                    f247325p = "none";
                    BaseApplication.getContext().getSharedPreferences(CodecWarpper.tag, 0).edit().putString(f247310a, g()).commit();
                    return;
                }
                z16 = false;
                if (MsfService.getCore().getStatReporter() != null) {
                }
                f247326q = 0;
                f247327r = 0;
                f247328s = 0;
                f247329t = 0;
                f247330u = 0;
                f247331v = 0;
                f247332w = 0;
                f247333x = 0;
                f247334y = 0;
                A = 0L;
                A = c();
                f247335z = currentTimeMillis;
                B = "none";
                C = 0L;
                f247325p = "none";
                BaseApplication.getContext().getSharedPreferences(CodecWarpper.tag, 0).edit().putString(f247310a, g()).commit();
                return;
            }
            String g16 = g();
            QLog.d("CodecStatHelper", 4, "CodecStatHelper Save " + g16);
            f247335z = currentTimeMillis;
            BaseApplication.getContext().getSharedPreferences(CodecWarpper.tag, 0).edit().putString(f247310a, g16).commit();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f247326q);
        stringBuffer.append("|");
        stringBuffer.append(f247335z);
        stringBuffer.append("|");
        stringBuffer.append(f247327r);
        stringBuffer.append("|");
        stringBuffer.append(f247328s);
        stringBuffer.append("|");
        stringBuffer.append(f247329t);
        stringBuffer.append("|");
        stringBuffer.append(f247330u);
        stringBuffer.append("|");
        stringBuffer.append(f247331v);
        stringBuffer.append("|");
        stringBuffer.append(f247332w);
        stringBuffer.append("|");
        stringBuffer.append(f247333x);
        stringBuffer.append("|");
        stringBuffer.append(f247334y);
        stringBuffer.append("|");
        stringBuffer.append(A);
        stringBuffer.append("|");
        stringBuffer.append(B);
        stringBuffer.append("|");
        stringBuffer.append(C);
        stringBuffer.append("|");
        stringBuffer.append(f247325p);
        return stringBuffer.toString();
    }

    public static String h() {
        int i3 = f247326q + f247327r + f247328s + f247329t + f247330u + f247331v + f247332w + f247333x + f247334y;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d());
        stringBuffer.append("|");
        stringBuffer.append(i3);
        stringBuffer.append("|");
        stringBuffer.append(f247327r);
        stringBuffer.append("|");
        stringBuffer.append(f247328s);
        stringBuffer.append("|");
        stringBuffer.append(f247329t);
        stringBuffer.append("|");
        stringBuffer.append(f247330u);
        stringBuffer.append("|");
        stringBuffer.append(f247331v);
        stringBuffer.append("|");
        stringBuffer.append(f247332w);
        stringBuffer.append("|");
        stringBuffer.append(f247333x);
        stringBuffer.append("|");
        stringBuffer.append(f247334y);
        stringBuffer.append("|");
        stringBuffer.append(f247326q);
        stringBuffer.append("|");
        stringBuffer.append(B);
        stringBuffer.append("|");
        stringBuffer.append(a(C));
        stringBuffer.append("|");
        stringBuffer.append(f247325p);
        return stringBuffer.toString();
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String a(long j3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        return simpleDateFormat.format(calendar.getTime());
    }

    private static long b(int i3, String[] strArr) {
        try {
            return Long.parseLong(strArr[i3]);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static void b(long j3) {
        C = j3;
    }

    private static int a(int i3, String[] strArr) {
        try {
            return Integer.parseInt(strArr[i3]);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void a(int i3) {
        if (i3 == 1) {
            f247327r++;
            return;
        }
        if (i3 == 2) {
            f247328s++;
            return;
        }
        if (System.currentTimeMillis() - C <= D) {
            f247326q++;
        } else {
            switch (i3) {
                case -7:
                    f247334y++;
                    break;
                case -6:
                    f247333x++;
                    break;
                case -5:
                    f247332w++;
                    break;
                case -4:
                    f247331v++;
                    break;
                case -3:
                    f247330u++;
                    break;
                case -2:
                    f247329t++;
                    break;
                default:
                    f247326q++;
                    break;
            }
        }
        B = a(System.currentTimeMillis());
        f();
    }
}
