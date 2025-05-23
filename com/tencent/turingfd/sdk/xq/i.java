package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.turingfd.sdk.xq.Cnative;
import com.tencent.turingfd.sdk.xq.Vermillion;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f383364a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f383365b;

    /* renamed from: c, reason: collision with root package name */
    public static final Berry f383366c;

    /* renamed from: d, reason: collision with root package name */
    public static final Berry f383367d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f383364a = new AtomicBoolean(false);
        f383365b = new AtomicBoolean(false);
        f383366c = new Berry(false);
        f383367d = new Berry(true);
    }

    public static void a(Strawberry strawberry) {
        Context context;
        Vermillion vermillion = Vermillion.f383180l;
        vermillion.f383183a = strawberry;
        if (!vermillion.f383185c) {
            vermillion.f383185c = true;
            Celse.a(strawberry.c());
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("TuringFdCore_89_" + Nectarine.f382928a + "_xq", -8);
            baseHandlerThread.start();
            vermillion.f383184b = new Vermillion.Cdo(baseHandlerThread.getLooper(), strawberry.c());
            Walnut walnut = new Walnut(vermillion.f383184b);
            vermillion.f383186d = walnut;
            Watermelon watermelon = Watermelon.f383208g;
            watermelon.f383213d = strawberry;
            watermelon.f383214e = walnut;
            int[] iArr = Cclass.f383240a;
            if (iArr.length > 0) {
                synchronized (watermelon.f383210a) {
                    for (int i3 : iArr) {
                        watermelon.f383210a.add(Integer.valueOf(i3));
                    }
                }
            }
            watermelon.b();
            new Tangerine(vermillion).start();
        }
        Guava.f382801c = strawberry;
        UrsaMinor<Cwhile> ursaMinor = Gooseberry.f382788a;
        if (Warden.f383204f.a("enable_risk_click", Nectarine.f382929b)) {
            if (Build.VERSION.SDK_INT >= 28 && !Ccatch.a()) {
                Codlin.a();
            }
            Log.i("TRCDM", "erc");
            k kVar = Gooseberry.f382792e;
            synchronized (Cnative.class) {
                WeakHashMap<Activity, Object> weakHashMap = Cnative.f383401a;
                if (kVar != null) {
                    synchronized (Celse.class) {
                        context = Celse.f383328a;
                    }
                    if (context instanceof Application) {
                        Application application = (Application) context;
                        AtomicReference<Cnative.Cdo> atomicReference = Cnative.f383402b;
                        synchronized (atomicReference) {
                            if (atomicReference.get() == null) {
                                BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread("TuringDispatch");
                                baseHandlerThread2.start();
                                Cnative.Cdo cdo = new Cnative.Cdo(new Cthrow(baseHandlerThread2.getLooper(), kVar));
                                atomicReference.set(cdo);
                                application.registerActivityLifecycleCallbacks(cdo);
                            }
                        }
                    }
                }
            }
        }
        f.f383333e.f383334a = strawberry;
    }

    public static int b(Strawberry strawberry) {
        AtomicBoolean atomicBoolean = f383364a;
        if (atomicBoolean.get()) {
            return 0;
        }
        boolean z16 = true;
        if (strawberry.f383086h) {
            TextUtils.isEmpty(strawberry.f383089k);
            String str = strawberry.f383089k;
            try {
                if (TextUtils.isEmpty(str)) {
                    System.loadLibrary("turingxq");
                } else {
                    System.load(str);
                }
            } catch (Throwable th5) {
                Log.w("TuringFdJava", th5);
                z16 = false;
            }
            f383364a.set(z16);
            if (!z16) {
                Log.e("TuringFdJava", "load so failure");
            }
        } else {
            atomicBoolean.set(true);
        }
        return f383364a.get() ? 0 : -10001;
    }

    public static int c(Strawberry strawberry) {
        Object obj;
        Object obj2;
        Object obj3;
        Context c16 = strawberry.c();
        HashMap hashMap = new HashMap();
        Warden warden = Warden.f383204f;
        boolean a16 = Bryony.a();
        String str = "1";
        if (a16 && warden.a("e_w_d", false)) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("2008", obj);
        if (a16 && warden.a("e_r_d", true)) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put("2009", obj2);
        if (a16 && warden.a("e_w_nd", true)) {
            obj3 = "1";
        } else {
            obj3 = "0";
        }
        hashMap.put("2010", obj3);
        if (!a16 || !warden.a("e_r_nd", true)) {
            str = "0";
        }
        hashMap.put("2011", str);
        hashMap.put("2025", "0");
        try {
            int b16 = Bagasse.b(TNative$aa.i89_A931D6BEC30CD812(new SparseArray(), c16, hashMap, f383366c, f383367d, a.f383219a.b()));
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

    public static String b() {
        Strawberry strawberry;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(String.format(Locale.SIMPLIFIED_CHINESE, "TuringFD v%d", 89));
        sb5.append(" (A931D6BEC30CD812");
        sb5.append(", xq");
        sb5.append(", 7c2183b");
        StringBuilder sb6 = new StringBuilder();
        if (!sb6.toString().isEmpty()) {
            sb6.append(";");
        }
        sb6.append("tss");
        if (!sb6.toString().isEmpty()) {
            sb6.append(";");
        }
        sb6.append("rfr");
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
        sb8.append(ServiceConst.EXTRA_WUP);
        if (!sb8.toString().isEmpty()) {
            sb8.append(";");
        }
        sb8.append("105668");
        sb5.append(sb8.toString());
        sb5.append(String.format(Locale.SIMPLIFIED_CHINESE, ", compiled %s)", "2024_07_23_15_52_43"));
        synchronized (Strawberry.class) {
            strawberry = Strawberry.C;
        }
        if (strawberry != null) {
            sb5.append(" [");
            StringBuilder sb9 = new StringBuilder();
            StringBuilder a16 = Flat.a("url(");
            a16.append(TextUtils.join(",", strawberry.f383087i));
            a16.append(")");
            String sb10 = a16.toString();
            if (!sb9.toString().isEmpty()) {
                sb9.append(";");
            }
            sb9.append(sb10);
            String str = "c(" + strawberry.f383084f + ")";
            if (!sb9.toString().isEmpty()) {
                sb9.append(";");
            }
            sb9.append(str);
            if (strawberry.f383104z) {
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

    public static Gemini a(Context context) {
        int a16 = a();
        if (a16 != 0) {
            return Sultana.a(a16);
        }
        return Vermillion.f383180l.a(context, true, 1);
    }

    public static int a() {
        Strawberry strawberry;
        if (!f383364a.get()) {
            return -10001;
        }
        if (Nectarine.f382928a == 0) {
            return -10018;
        }
        if (!f383365b.get()) {
            return -10002;
        }
        synchronized (Strawberry.class) {
            strawberry = Strawberry.C;
        }
        return !strawberry.d().userAgreement() ? -10019 : 0;
    }

    public static Haw a(Context context, boolean z16) {
        int a16 = a();
        if (a16 != 0) {
            Log.i("TuringDebug", "init error : " + a16);
            return new Haw(a16);
        }
        return Guava.a(context, (Map<Integer, String>) null, z16 ? 1 : 0, 0L);
    }
}
