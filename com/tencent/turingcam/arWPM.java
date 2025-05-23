package com.tencent.turingcam;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.turingcam.T0QUa;
import com.tencent.turingface.sdk.mfa.TNative$aa;
import com.tencent.turingface.sdk.mfa.a;
import com.tencent.turingface.sdk.mfa.b;
import com.tencent.turingface.sdk.mfa.g;
import com.tencent.turingface.sdk.mfa.m;
import com.tencent.turingface.sdk.mfa.n;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes27.dex */
public class arWPM {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final long f382133a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f382134b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f382135c;

    /* renamed from: d, reason: collision with root package name */
    public static final s7Dnc f382136d;

    /* renamed from: e, reason: collision with root package name */
    public static final s7Dnc f382137e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17374);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f382133a = System.currentTimeMillis();
        f382134b = new AtomicBoolean(false);
        f382135c = new AtomicBoolean(false);
        f382136d = new s7Dnc(false);
        f382137e = new s7Dnc(true);
    }

    public static void a(fBfpd fbfpd) {
        T0QUa t0QUa = T0QUa.f382050l;
        t0QUa.f382053a = fbfpd;
        if (!t0QUa.f382055c) {
            t0QUa.f382055c = true;
            eh5ma.a(fbfpd.c());
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TuringFdCore_91_" + WT9z5.f382088a + "_mfa", -8);
            baseHandlerThread.start();
            t0QUa.f382054b = new T0QUa.spXPg(baseHandlerThread.getLooper(), fbfpd.c());
            XStYH xStYH = new XStYH(t0QUa.f382054b);
            t0QUa.f382056d = xStYH;
            b bVar = b.f382488g;
            bVar.f382493d = fbfpd;
            bVar.f382494e = xStYH;
            Set<Integer> set = fbfpd.f382238y;
            if (set != null) {
                synchronized (bVar.f382490a) {
                    bVar.f382490a.addAll(set);
                }
            }
            String str = Build.BRAND;
            if ("xiaomi".equalsIgnoreCase(str) || "redmi".equalsIgnoreCase(str)) {
                synchronized (bVar.f382490a) {
                    bVar.f382490a.add(148);
                }
            }
            int[] iArr = p0hgx.f382335a;
            if (iArr.length > 0) {
                synchronized (bVar.f382490a) {
                    for (int i3 : iArr) {
                        bVar.f382490a.add(Integer.valueOf(i3));
                    }
                }
            }
            bVar.b();
            new ljcUp(t0QUa).start();
        }
        cPR64.a();
        n.f382543d.f382544a = fbfpd;
    }

    public static int b(fBfpd fbfpd) {
        AtomicBoolean atomicBoolean = f382134b;
        if (atomicBoolean.get()) {
            return 0;
        }
        boolean z16 = true;
        if (fbfpd.f382219f) {
            TextUtils.isEmpty(fbfpd.f382222i);
            String str = fbfpd.f382222i;
            try {
                if (TextUtils.isEmpty(str)) {
                    System.loadLibrary("turingmfa");
                } else {
                    System.load(str);
                }
            } catch (Throwable th5) {
                Log.w("TuringFdJava", th5);
                z16 = false;
            }
            f382134b.set(z16);
            if (!z16) {
                Log.e("TuringFdJava", "load so failure");
            }
        } else {
            atomicBoolean.set(true);
        }
        return f382134b.get() ? 0 : -10001;
    }

    public static int c(fBfpd fbfpd) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Context c16 = fbfpd.c();
        HashMap hashMap = new HashMap();
        ZY08E zy08e = ZY08E.f382121f;
        boolean a16 = d5HOq.a();
        String str = "1";
        if (a16 && zy08e.a("e_w_d", false)) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("2008", obj);
        if (a16 && zy08e.a("e_r_d", true)) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put("2009", obj2);
        if (a16 && zy08e.a("e_w_nd", true)) {
            obj3 = "1";
        } else {
            obj3 = "0";
        }
        hashMap.put("2010", obj3);
        if (a16 && zy08e.a("e_r_nd", true)) {
            obj4 = "1";
        } else {
            obj4 = "0";
        }
        hashMap.put("2011", obj4);
        if (!fbfpd.A) {
            str = "0";
        }
        hashMap.put("2025", str);
        hashMap.put("2028", "0");
        try {
            int b16 = SWw7W.b(TNative$aa.i91_FC6D5B0A7013DB60(new SparseArray(), c16, hashMap, f382136d, f382137e, V7ps4.f382068a.b()));
            if (b16 == 0) {
                return 0;
            }
            Log.e("TuringFdJava", "native init fail, err: " + b16);
            return -10020;
        } catch (Throwable th5) {
            Log.e("TuringFdJava", "native init exception", th5);
            return -10020;
        }
    }

    public static void d(fBfpd fbfpd) {
        if (fbfpd.f382231r) {
            com.tencent.turingface.sdk.mfa.a a16 = com.tencent.turingface.sdk.mfa.a.a();
            m mVar = fbfpd.f382214a;
            int i3 = fbfpd.f382234u;
            synchronized (a16) {
                if (mVar != null) {
                    if (a16.f382480b.compareAndSet(false, true)) {
                        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TuringFdTMFShark");
                        baseHandlerThread.start();
                        a.HandlerC10029a handlerC10029a = new a.HandlerC10029a(baseHandlerThread.getLooper(), mVar, new RbRz0(), i3);
                        a16.f382479a = handlerC10029a;
                        String str = g.f382510a;
                        Random random = Ckq8l.f381753a;
                        g.f382511b = "tmf_";
                        Message.obtain(handlerC10029a, 1).sendToTarget();
                    }
                }
            }
        }
    }

    public static String b() {
        fBfpd fbfpd;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(String.format(Locale.SIMPLIFIED_CHINESE, "TuringFD v%d", 91));
        sb5.append(" (FC6D5B0A7013DB60");
        sb5.append(", mfa");
        sb5.append(", 44f1e07");
        StringBuilder sb6 = new StringBuilder();
        if (!sb6.toString().isEmpty()) {
            sb6.append(";");
        }
        sb6.append("tss");
        if (!sb6.toString().isEmpty()) {
            sb6.append(";");
        }
        sb6.append("ite");
        if (!sb6.toString().isEmpty()) {
            sb6.append(";");
        }
        sb6.append("rs");
        String sb7 = sb6.toString();
        if (!TextUtils.isEmpty(sb7)) {
            sb5.append(", ");
            sb5.append(sb7);
        }
        sb5.append(", ");
        StringBuilder sb8 = new StringBuilder();
        if (!sb8.toString().isEmpty()) {
            sb8.append(";");
        }
        sb8.append("tmfshark");
        sb5.append(sb8.toString());
        sb5.append(String.format(Locale.SIMPLIFIED_CHINESE, ", compiled %s)", "2024_11_13_16_26_21"));
        synchronized (fBfpd.class) {
            fbfpd = fBfpd.B;
        }
        if (fbfpd != null) {
            sb5.append(" [");
            StringBuilder sb9 = new StringBuilder();
            StringBuilder a16 = tmnyR.a("url(");
            a16.append(TextUtils.join(",", fbfpd.f382220g));
            a16.append(")");
            String sb10 = a16.toString();
            if (!sb9.toString().isEmpty()) {
                sb9.append(";");
            }
            sb9.append(sb10);
            String str = "c(" + fbfpd.f382217d + ")";
            if (!sb9.toString().isEmpty()) {
                sb9.append(";");
            }
            sb9.append(str);
            if (fbfpd.f382236w) {
                if (!sb9.toString().isEmpty()) {
                    sb9.append(";");
                }
                sb9.append("ext");
            }
            sb5.append(sb9.toString());
            sb5.append("]");
        }
        return sb5.toString();
    }

    public static int a() {
        fBfpd fbfpd;
        if (!f382135c.get()) {
            return -10002;
        }
        if (WT9z5.f382088a == 0) {
            return -10018;
        }
        if (!f382134b.get()) {
            return -10001;
        }
        synchronized (fBfpd.class) {
            fbfpd = fBfpd.B;
        }
        return !fbfpd.d().a() ? -10019 : 0;
    }
}
