package com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmethodmonitor.pandoraevent.PandoraEventReportHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import ee2.c;
import ge2.b;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DBReportStrategy implements a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f261933a = false;

    private static boolean e(Context context) {
        return QMMKV.from(context, "common_mmkv_configurations").decodeBool("is_need_migrate", true);
    }

    @Deprecated
    private static List<fe2.a> f() {
        ArrayList arrayList = new ArrayList();
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext == null) {
            QLog.d("PandoraExEvent.DBReportStrategy", 1, "[oldDataQuery] context is null");
            return arrayList;
        }
        if (!f261933a) {
            List<fe2.a> d16 = b.a(applicationContext, PandoraEventReportHelper.a()).d();
            f261933a = true;
            return d16;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, boolean z16) {
        QLog.d("PandoraExEvent.DBReportStrategy", 1, "setNeedMigrate isNeedMigrate: " + z16);
        QMMKV.from(context, "common_mmkv_configurations").encodeBool("is_need_migrate", z16);
    }

    @Override // com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.a
    public void a(final ee2.b bVar, boolean z16) {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext == null) {
            QLog.d("PandoraExEvent.DBReportStrategy", 1, "[onEventRecord] context is null");
            return;
        }
        String a16 = PandoraEventReportHelper.a();
        final ge2.a b16 = ge2.a.b(applicationContext, a16);
        if (a16 == null) {
            g(applicationContext, true);
        }
        if (a16 == null) {
            a16 = "0";
        }
        String str = bVar.f396189b;
        String str2 = bVar.f396192e;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        String str4 = bVar.f396191d;
        if (str4 != null) {
            str3 = str4;
        }
        final String f16 = he2.b.f(a16, str, str2, str3);
        if (z16) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.DBReportStrategy.1
                @Override // java.lang.Runnable
                public void run() {
                    b16.d(new fe2.a(bVar, null, f16, 1));
                }
            }, 32, null, false, 0L);
        } else {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.DBReportStrategy.2
                @Override // java.lang.Runnable
                public void run() {
                    b16.c(new fe2.a(bVar, null, f16, 1));
                }
            }, 32, null, false, 0L);
        }
    }

    @Override // com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.a
    public void b(final String str) {
        final Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext == null) {
            QLog.d("PandoraExEvent.DBReportStrategy", 1, "[handleAfterLogin] context is null");
            return;
        }
        if (!e(applicationContext)) {
            QLog.d("PandoraExEvent.DBReportStrategy", 1, "[handleAfterLogin] isNeedMigrate is false");
            return;
        }
        final ge2.a b16 = ge2.a.b(applicationContext, null);
        final ge2.a b17 = ge2.a.b(applicationContext, str);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.DBReportStrategy.3
            @Override // java.lang.Runnable
            public void run() {
                List<fe2.a> e16 = b16.e();
                if (e16.size() > 0) {
                    for (fe2.a aVar : e16) {
                        String str2 = str;
                        if (str2 == null) {
                            str2 = "0";
                        }
                        ee2.b bVar = aVar.f398368d;
                        String str3 = bVar.f396189b;
                        String str4 = bVar.f396192e;
                        if (str4 == null) {
                            str4 = "";
                        }
                        aVar.f398365a = he2.b.f(str2, str3, str4, bVar.f396191d);
                        b17.d(aVar);
                    }
                    b16.a();
                }
                DBReportStrategy.g(applicationContext, false);
            }
        }, 32, null, false, 0L);
        QLog.d("PandoraExEvent.DBReportStrategy", 1, "[handleAfterLogin] have copied public DB to current accountID DB");
    }

    @Override // com.tencent.mobileqq.qmethodmonitor.pandoraevent.reportimpl.a
    public void c() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext != null) {
            String a16 = PandoraEventReportHelper.a();
            ge2.a b16 = ge2.a.b(applicationContext, a16);
            List<fe2.a> e16 = b16.e();
            e16.addAll(f());
            if (e16.size() > 0) {
                for (fe2.a aVar : e16) {
                    ee2.b bVar = aVar.f398368d;
                    String str = bVar.f396189b;
                    String str2 = bVar.f396192e;
                    if (str2 == null) {
                        str2 = "";
                    }
                    aVar.f398366b = he2.b.e(a16, str, str2);
                    ee2.b bVar2 = aVar.f398368d;
                    bVar2.f396192e = he2.b.g(bVar2.f396189b, bVar2.f396192e);
                    c.b(aVar);
                }
                b16.a();
            }
        }
    }
}
