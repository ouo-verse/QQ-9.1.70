package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tfd.sdk.wxa.Cherry;
import com.tencent.tfd.sdk.wxa.Scorpius;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Filbert {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f375609a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f375610b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f375611c;

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f375612d;

    /* renamed from: e, reason: collision with root package name */
    public static Bryony f375613e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f375609a = new AtomicBoolean(false);
        f375610b = new AtomicBoolean(false);
        f375611c = new Object();
        f375612d = new AtomicBoolean(false);
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List<com.tencent.tfd.sdk.wxa.Foxnut>, java.util.ArrayList] */
    public static void a(Bryony bryony) {
        Cherry cherry = Cherry.f375527h;
        cherry.f375530a = bryony;
        if (!cherry.f375532c) {
            cherry.f375532c = true;
            Cgoto.a(bryony.f375463f);
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TuringFdCore_77_" + UrsaMinor.f375742a + "_wxa", -8);
            baseHandlerThread.start();
            cherry.f375531b = new Cherry.Cdo(baseHandlerThread.getLooper(), bryony.f375463f);
            Chestnut chestnut = new Chestnut(cherry.f375531b);
            cherry.f375533d = chestnut;
            Codlin codlin = Codlin.f375548h;
            codlin.f375554e = bryony;
            codlin.f375555f = chestnut;
            codlin.f375551b.put(40, Integer.valueOf(bryony.f375478u ? 1 : 0));
            codlin.f375551b.put(17, Integer.valueOf(bryony.f375478u ? 1 : 0));
            new Carambola(cherry).start();
        }
        Context context = bryony.f375463f;
        Solar.f375694a = bryony;
        Scorpius.f375682d = context;
        if (Coconut.f375544e.a(context, "enable_risk_click", UrsaMinor.f375743b)) {
            Pegasus.a(context);
            Log.i("TRCDM", "erc");
            Scorpius.Cdo cdo = Scorpius.f375683e;
            Scorpius.Cif cif = Scorpius.f375684f;
            synchronized (Cranberry.class) {
                Cranberry.f375568a.add(cdo);
                Cranberry.f375569b = cif;
                ComaBerenices.a(context.getApplicationContext(), Cranberry.f375572e);
            }
            ComaBerenices.f375562f = true;
        }
        new Damson(bryony.f375463f).start();
    }

    public static int b(Bryony bryony) {
        AtomicBoolean atomicBoolean = f375609a;
        if (atomicBoolean.get()) {
            return 0;
        }
        boolean z16 = true;
        if (bryony.f375466i) {
            TextUtils.isEmpty(bryony.f375468k);
            String str = bryony.f375468k;
            try {
                if (TextUtils.isEmpty(str)) {
                    System.loadLibrary("108168wxa");
                } else {
                    System.load(str);
                }
            } catch (Throwable th5) {
                Log.w("TuringFdJava", th5);
                z16 = false;
            }
            f375609a.set(z16);
            if (!z16) {
                Log.e("TuringFdJava", "load so failure");
            }
        } else {
            atomicBoolean.set(true);
        }
        return f375609a.get() ? 0 : -10001;
    }

    public static int c(Bryony bryony) {
        Object obj;
        Object obj2;
        Object obj3;
        Context context = bryony.f375463f;
        HashMap hashMap = new HashMap();
        Coconut coconut = Coconut.f375544e;
        String str = "1";
        if (coconut.a(context, "e_w_d", false)) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("2008", obj);
        if (coconut.a(context, "e_r_d", true)) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put("2009", obj2);
        if (coconut.a(context, "e_w_nd", true)) {
            obj3 = "1";
        } else {
            obj3 = "0";
        }
        hashMap.put("2010", obj3);
        if (!coconut.a(context, "e_r_nd", true)) {
            str = "0";
        }
        hashMap.put("2011", str);
        try {
            if (Equuleus.b(TNative$aa.i77(new SparseArray(), context, hashMap)) == 0) {
                return 0;
            }
            return -10020;
        } catch (Throwable unused) {
            return -10020;
        }
    }

    public static String b() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(String.format(Locale.SIMPLIFIED_CHINESE, "TuringFD v%d", 77));
        sb5.append(" (94ACE82254FE3A76");
        sb5.append(", wxa");
        sb5.append(", 1aab0a6");
        StringBuilder sb6 = new StringBuilder();
        if (sb6.toString().length() > 0) {
            sb6.append(";");
        }
        sb6.append("rfr");
        if (sb6.toString().length() > 0) {
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
        if (sb8.toString().length() > 0) {
            sb8.append(";");
        }
        sb8.append(ServiceConst.EXTRA_WUP);
        if (sb8.toString().length() > 0) {
            sb8.append(";");
        }
        sb8.append("108168");
        sb5.append(sb8.toString());
        sb5.append(String.format(Locale.SIMPLIFIED_CHINESE, ", compiled %s)", "2023_05_22_17_28_21"));
        Bryony bryony = f375613e;
        if (bryony != null) {
            sb5.append(" [");
            StringBuilder sb9 = new StringBuilder();
            StringBuilder a16 = Pyxis.a("url(");
            a16.append(bryony.f375467j);
            a16.append(")");
            String sb10 = a16.toString();
            if (sb9.toString().length() > 0) {
                sb9.append(";");
            }
            sb9.append(sb10);
            String str = "c(" + bryony.f375464g + ")";
            if (sb9.toString().length() > 0) {
                sb9.append(";");
            }
            sb9.append(str);
            if (bryony.B) {
                if (sb9.toString().length() > 0) {
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
        if (!f375609a.get()) {
            return -10001;
        }
        if (UrsaMinor.f375742a == 0) {
            return -10018;
        }
        if (!f375610b.get()) {
            return -10002;
        }
        Csynchronized csynchronized = f375613e.f375459b;
        if (csynchronized == null) {
            csynchronized = Bryony.D;
        }
        return !csynchronized.userAgreement() ? -10019 : 0;
    }
}
