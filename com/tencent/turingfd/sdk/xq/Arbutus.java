package com.tencent.turingfd.sdk.xq;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Arbutus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Cdo> f382574a;

    /* renamed from: b, reason: collision with root package name */
    public static Avocado f382575b;

    /* renamed from: c, reason: collision with root package name */
    public static String f382576c;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.Arbutus$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Dorado f382577a;

        /* renamed from: b, reason: collision with root package name */
        public int f382578b;

        public Cdo(Dorado dorado) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dorado);
            } else {
                this.f382578b = 0;
                this.f382577a = dorado;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10026);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f382574a = concurrentHashMap;
        concurrentHashMap.put("C892BA2", new Cdo(new Bilberry()));
        f382574a.put("43780D5", new Cdo(new Bilberry()));
        f382574a.put("7CD3AF2", new Cdo(new Bilberry()));
        f382574a.put("22792AF", new Cdo(new Bergamot()));
        f382576c = "";
        try {
            f382576c = Vulpecula.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable unused) {
        }
    }
}
