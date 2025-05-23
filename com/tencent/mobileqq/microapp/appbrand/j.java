package com.tencent.mobileqq.microapp.appbrand;

import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class j implements k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    FrameLayout f246005a;

    /* renamed from: b, reason: collision with root package name */
    private BaseActivity f246006b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList f246007c;

    public j(BaseActivity baseActivity, FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseActivity, (Object) frameLayout);
            return;
        }
        this.f246006b = baseActivity;
        this.f246007c = new LinkedList();
        this.f246005a = frameLayout;
    }

    public final void a(com.tencent.mobileqq.microapp.a.c cVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) str);
            return;
        }
        if (cVar == null) {
            return;
        }
        a a16 = a(cVar.f245823d, cVar.f245825f.getRuntimeType());
        if (a16 != null) {
            a16.a(cVar);
            return;
        }
        try {
            a aVar = new a(this.f246006b, this, cVar);
            aVar.a(str, false);
            b(aVar);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("AppBrandRuntimeContainer", 2, th5, new Object[0]);
            }
            a(cVar, th5);
            MiniAppConfig miniAppConfig = cVar.f245825f;
            com.tencent.mobileqq.microapp.app.b.a().a(new b.a(-1, miniAppConfig.config.mini_appid, miniAppConfig.getRuntimeType(), null));
        }
    }

    public a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.f246007c.size() < 2) {
            return null;
        }
        return (a) this.f246007c.get(1);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.k
    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f246007c.size() : ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntimeContainer", 2, "cleanup appRunTime size = " + c());
        }
        Iterator it = this.f246007c.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                this.f246005a.removeView(aVar.f245902g);
                aVar.a();
                it.remove();
            }
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.k
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            d();
            this.f246006b.finish();
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.k
    public final void c(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntimeContainer", 2, "removeAppBrandRunTime r=" + aVar);
        }
        if (aVar != null) {
            this.f246005a.removeView(aVar.f245902g);
            aVar.a();
            this.f246007c.remove(aVar);
        }
    }

    public final void b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        a aVar2 = (a) this.f246007c.peekLast();
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntimeContainer", 2, "addAppBrandRunTime currSize=" + c() + ",insertAppBrandRunTime=" + aVar + ",lastAppBrandRuntime=" + aVar2);
        }
        this.f246007c.push(aVar);
        this.f246005a.addView(aVar.f245902g);
        if (c() <= 10 || aVar2 == null) {
            return;
        }
        aVar2.b();
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntimeContainer", 2, "bringToFront appBrandRuntime=" + aVar);
        }
        if (aVar != null) {
            this.f246007c.remove(aVar);
            this.f246007c.push(aVar);
        }
    }

    public a a(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppBrandRuntimeContainer", 2, "getAppBrandRunTime appId=" + str + ",versionType=" + i3);
        }
        Iterator it = this.f246007c.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.f245896a.equals(str) && i3 == aVar.f245897b) {
                return aVar;
            }
        }
        return null;
    }

    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (a) this.f246007c.peek() : (a) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    private void a(com.tencent.mobileqq.microapp.a.c cVar, Throwable th5) {
        if (cVar == null || th5 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene", "AppBrandRuntimeContainer init");
            jSONObject.put("miniAppId", cVar.f245823d);
            com.tencent.mobileqq.microapp.widget.g gVar = cVar.f245821b;
            if (gVar != null) {
                jSONObject.put("page", gVar.f246134f);
            }
            StringBuilder sb5 = new StringBuilder(256);
            sb5.append(th5.toString());
            if (th5.getStackTrace() != null) {
                StackTraceElement[] stackTrace = th5.getStackTrace();
                for (int i3 = 0; i3 < stackTrace.length && i3 < 16; i3++) {
                    sb5.append("\n ");
                    sb5.append(stackTrace[i3].toString());
                }
            }
            VACDReportUtil.singleReport(jSONObject.toString(), "MiniAppStat", "MiniAppCrashReport", "Catch", (String) null, 88888, sb5.toString());
        } catch (Throwable unused) {
            if (QLog.isColorLevel()) {
                QLog.e("AppBrandRuntimeContainer", 2, th5, new Object[0]);
            }
        }
    }
}
