package com.tencent.turingcam;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ShGzN {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, spXPg> f382022a;

    /* renamed from: b, reason: collision with root package name */
    public static wmqhz f382023b;

    /* renamed from: c, reason: collision with root package name */
    public static String f382024c;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public QmgHg f382025a;

        /* renamed from: b, reason: collision with root package name */
        public int f382026b;

        public spXPg(QmgHg qmgHg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qmgHg);
            } else {
                this.f382026b = 0;
                this.f382025a = qmgHg;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12119);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f382022a = concurrentHashMap;
        concurrentHashMap.put("C892BA2", new spXPg(new nyvKz()));
        f382022a.put("43780D5", new spXPg(new nyvKz()));
        f382022a.put("7CD3AF2", new spXPg(new nyvKz()));
        f382022a.put("22792AF", new spXPg(new y8N3A()));
        f382024c = "";
        try {
            f382024c = LmseU.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable unused) {
        }
    }
}
