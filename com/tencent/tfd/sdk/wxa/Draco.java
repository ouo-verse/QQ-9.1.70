package com.tencent.tfd.sdk.wxa;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Draco {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Cdo> f375595a;

    /* renamed from: b, reason: collision with root package name */
    public static Eridanus f375596b;

    /* renamed from: c, reason: collision with root package name */
    public static String f375597c;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Draco$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Cstrictfp f375598a;

        /* renamed from: b, reason: collision with root package name */
        public int f375599b;

        public Cdo(Cstrictfp cstrictfp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cstrictfp);
            } else {
                this.f375599b = 0;
                this.f375598a = cstrictfp;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Draco$do>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Draco$do>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Draco$do>, java.util.concurrent.ConcurrentHashMap] */
    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62559);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f375595a = concurrentHashMap;
        concurrentHashMap.put("C892BA2", new Cdo(new Lacerta()));
        f375595a.put("43780D5", new Cdo(new Lacerta()));
        f375595a.put("7CD3AF2", new Cdo(new Lacerta()));
        f375595a.put("22792AF", new Cdo(new Gemini()));
        f375597c = "";
        try {
            f375597c = Cepheus.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable unused) {
        }
    }
}
