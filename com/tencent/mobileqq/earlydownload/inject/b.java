package com.tencent.mobileqq.earlydownload.inject;

import com.tencent.mobileqq.earlydownload.processor.c;
import com.tencent.mobileqq.earlydownload.processor.d;
import com.tencent.mobileqq.earlydownload.processor.e;
import com.tencent.mobileqq.earlydownload.processor.f;
import com.tencent.mobileqq.earlydownload.processor.g;
import com.tencent.mobileqq.earlydownload.processor.h;
import com.tencent.mobileqq.earlydownload.processor.i;
import com.tencent.mobileqq.earlydownload.processor.j;
import com.tencent.mobileqq.earlydownload.processor.k;
import com.tencent.mobileqq.earlydownload.processor.l;
import com.tencent.mobileqq.earlydownload.processor.m;
import com.tencent.mobileqq.earlydownload.processor.n;
import com.tencent.mobileqq.earlydownload.processor.o;
import com.tencent.mobileqq.earlydownload.processor.p;
import com.tencent.mobileqq.earlydownload.processor.q;
import com.tencent.mobileqq.earlydownload.processor.r;
import com.tencent.mobileqq.earlydownload.processor.s;
import com.tencent.mobileqq.earlydownload.processor.t;
import com.tencent.mobileqq.earlydownload.processor.u;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/QQEarlyDownloadImpl/Inject_QQEarlyDownloadProcessor.yml", version = 1)
    private static ArrayList<a> f203925a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/QQEarlyDownloadImpl/Inject_QQEarlyDownloadProcessor.yml", version = 1)
    private static a f203926b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f203927c;

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList f203928d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20585);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f203928d = arrayList;
        arrayList.add(com.tencent.mobileqq.earlydownload.processor.b.class);
        ArrayList arrayList2 = new ArrayList();
        f203927c = arrayList2;
        arrayList2.add(com.tencent.mobileqq.earlydownload.processor.a.class);
        f203927c.add(com.tencent.mobileqq.earlydownload.processor.b.class);
        f203927c.add(c.class);
        f203927c.add(d.class);
        f203927c.add(e.class);
        f203927c.add(f.class);
        f203927c.add(g.class);
        f203927c.add(h.class);
        f203927c.add(i.class);
        f203927c.add(j.class);
        f203927c.add(o.class);
        f203927c.add(k.class);
        f203927c.add(l.class);
        f203927c.add(m.class);
        f203927c.add(n.class);
        f203927c.add(q.class);
        f203927c.add(r.class);
        f203927c.add(s.class);
        f203927c.add(t.class);
        f203927c.add(p.class);
        f203927c.add(u.class);
        f203925a = new ArrayList<>();
        c();
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @QAutoInitMethod
    private static void c() {
        f203926b = (a) com.tencent.mobileqq.qroute.utils.b.a(f203928d);
        com.tencent.mobileqq.qroute.utils.b.c(f203927c, f203925a);
        if (f203925a.size() > 0) {
            if (QLog.isColorLevel()) {
                Iterator<a> it = f203925a.iterator();
                while (it.hasNext()) {
                    QLog.i("EarlyHandlerProcessorFactory", 2, "inject name:" + it.next().getClass());
                }
            }
        } else {
            QLog.e("EarlyHandlerProcessorFactory", 1, "inject Failed !");
        }
        if (f203926b != null) {
            QLog.i("EarlyHandlerProcessorFactory", 1, "sHighLevelArNativeSoDownloadProcessorClasses inject name:" + f203926b.getClass());
            return;
        }
        QLog.e("EarlyHandlerProcessorFactory", 1, "sHighLevelArNativeSoDownloadProcessorClasses inject Failed !");
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        try {
            return f203926b.b();
        } catch (Exception e16) {
            QLog.d("EarlyHandlerProcessorFactory", 1, "getArNativeSoDownloadResName fail.", e16);
            return "";
        }
    }

    public ArrayList<a> b(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        return f203925a;
    }
}
