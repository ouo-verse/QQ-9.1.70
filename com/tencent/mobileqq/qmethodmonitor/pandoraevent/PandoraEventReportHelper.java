package com.tencent.mobileqq.qmethodmonitor.pandoraevent;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.DBReportStrategy;
import ee2.b;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PandoraEventReportHelper {

    /* renamed from: a, reason: collision with root package name */
    public static int f261914a = 600000;

    /* renamed from: b, reason: collision with root package name */
    private static final com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.a f261915b = new DBReportStrategy();

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f261916c = new AtomicBoolean(false);

    public static String a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return peekAppRuntime.getAccount();
    }

    public static void b(String str) {
        f261915b.b(str);
    }

    public static void c(b bVar, boolean z16) {
        f261915b.a(bVar, z16);
        if (f261916c.compareAndSet(false, true)) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qmethodmonitor.pandoraevent.PandoraEventReportHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    PandoraEventReportHelper.d();
                }
            }, 32, null, false, f261914a);
        }
    }

    public static void d() {
        f261915b.c();
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qmethodmonitor.pandoraevent.PandoraEventReportHelper.2
            @Override // java.lang.Runnable
            public void run() {
                PandoraEventReportHelper.d();
            }
        }, 32, null, false, f261914a);
    }
}
