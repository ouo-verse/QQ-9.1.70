package com.tencent.tgpa.lite.e;

import android.content.Context;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tgpa.lite.gradish.GradishWrapper;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes26.dex */
public class k {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f375941b = "-10";

    /* renamed from: a, reason: collision with root package name */
    private Timer f375942a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends TimerTask {
        static IPatchRedirector $redirector_;

        a(k kVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar);
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.tgpa.lite.d.a.a("OAID", k.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements j {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // com.tencent.tgpa.lite.e.j
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (str == null) {
                com.tencent.tgpa.lite.g.h.b("get oaid failed in this manufacturer, return null.", new Object[0]);
                String unused = k.f375941b = "-11";
            } else {
                com.tencent.tgpa.lite.g.h.b("get oaid success in this manufacturer.", new Object[0]);
                String unused2 = k.f375941b = str;
                com.tencent.tgpa.lite.g.j.b("OAID", k.f375941b);
            }
            if (k.this.f375942a != null) {
                com.tencent.tgpa.lite.g.h.a("get oaid callback timer cancled. ", new Object[0]);
                k.this.f375942a.cancel();
            }
            com.tencent.tgpa.lite.d.a.a("OAID", k.f375941b);
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String c() {
        return f375941b;
    }

    public void a() {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.tgpa.lite.g.h.c("start to get vendor oaid.", new Object[0]);
        BaseTimer baseTimer = new BaseTimer();
        this.f375942a = baseTimer;
        baseTimer.schedule(new a(this), 2000L);
        b bVar = new b();
        Context a16 = com.tencent.tgpa.lite.g.a.a();
        if (a16 == null) {
            com.tencent.tgpa.lite.g.h.b("get oaid failed, context is null.", new Object[0]);
            bVar.a("-10");
            return;
        }
        String lowerCase = com.tencent.tgpa.lite.g.d.e().toLowerCase();
        try {
            switch (lowerCase.hashCode()) {
                case -1619859642:
                    if (lowerCase.equals("blackshark")) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1320380160:
                    if (lowerCase.equals("oneplus")) {
                        c16 = '\t';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1206476313:
                    if (lowerCase.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1106355917:
                    if (lowerCase.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_LENOVO)) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -934971466:
                    if (lowerCase.equals("realme")) {
                        c16 = '\n';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -759499589:
                    if (lowerCase.equals("xiaomi")) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 3003984:
                    if (lowerCase.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_ASUS)) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 3418016:
                    if (lowerCase.equals("oppo")) {
                        c16 = '\b';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 3620012:
                    if (lowerCase.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 99462250:
                    if (lowerCase.equals("honor")) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 103777484:
                    if (lowerCase.equals("meizu")) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 105170387:
                    if (lowerCase.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_NUBIA)) {
                        c16 = '\f';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1864941562:
                    if (lowerCase.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING)) {
                        c16 = 11;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            switch (c16) {
                case 0:
                case 1:
                    bVar.a(GradishWrapper.getOAID(1));
                    return;
                case 2:
                    bVar.a(GradishWrapper.getOAID(2));
                    return;
                case 3:
                    bVar.a(GradishWrapper.getOAID(3));
                    return;
                case 4:
                    new com.tencent.tgpa.lite.e.a(a16, bVar).a();
                    return;
                case 5:
                case 6:
                    e eVar = new e(a16, bVar);
                    String b16 = eVar.b();
                    if (b16 == null || b16.length() <= 4) {
                        eVar.a();
                        return;
                    } else {
                        bVar.a(b16);
                        return;
                    }
                case 7:
                    new h(a16, bVar).a();
                    return;
                case '\b':
                case '\t':
                case '\n':
                    new m(a16, bVar).a();
                    return;
                case 11:
                    new o(a16, bVar).a();
                    return;
                case '\f':
                    new l(a16, bVar).a();
                    return;
                default:
                    new d(a16, bVar).a();
                    return;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            com.tencent.tgpa.lite.g.h.b("get oaid exception, ple call tgpa team!", new Object[0]);
        }
    }
}
