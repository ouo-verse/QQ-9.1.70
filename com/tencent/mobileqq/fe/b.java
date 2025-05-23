package com.tencent.mobileqq.fe;

import android.os.Build;
import com.tencent.mobileqq.dt.Dtn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static a f205813a;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f205814a;

        /* renamed from: b, reason: collision with root package name */
        String f205815b;

        /* renamed from: c, reason: collision with root package name */
        String f205816c;

        /* renamed from: d, reason: collision with root package name */
        String f205817d;

        /* renamed from: e, reason: collision with root package name */
        String f205818e;

        /* renamed from: f, reason: collision with root package name */
        String f205819f;

        /* renamed from: g, reason: collision with root package name */
        String f205820g;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12948);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f205813a = new a();
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        a aVar = f205813a;
        StringBuilder sb5 = new StringBuilder();
        String str5 = Build.VERSION.RELEASE;
        sb5.append(str5);
        sb5.append("#");
        sb5.append(Build.BRAND);
        sb5.append("#");
        sb5.append(DeviceInfoMonitor.getModel());
        aVar.f205817d = sb5.toString();
        a aVar2 = f205813a;
        aVar2.f205814a = str;
        aVar2.f205815b = e.b().f();
        a aVar3 = f205813a;
        aVar3.f205819f = str2;
        aVar3.f205818e = str3;
        aVar3.f205816c = str5;
        aVar3.f205820g = str4;
        Dtn a16 = Dtn.a();
        a aVar4 = f205813a;
        a16.initGlobalConfig(aVar4.f205814a, aVar4.f205815b, aVar4.f205816c, aVar4.f205817d, aVar4.f205818e, aVar4.f205819f, aVar4.f205820g);
    }
}
