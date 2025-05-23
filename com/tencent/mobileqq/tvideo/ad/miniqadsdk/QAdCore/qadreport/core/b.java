package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.SpaEffectReportActionKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import org.json.JSONObject;
import pw2.n;
import pw2.x;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f304041a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f304042b;

    /* renamed from: c, reason: collision with root package name */
    private static gv2.c f304043c = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a() {
        c();
    }

    public static void b(d dVar) {
        n.e("QADReportUtil", "checkReportAppSwitchBack() info = " + dVar);
        if ((dVar instanceof ew2.e) && d(((ew2.e) dVar).H())) {
            String jSONObject = dVar.m().toString();
            n.a("QADReportUtil", "checkReportAppSwitchBack() json = " + jSONObject);
            f304042b = jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        String str = f304042b;
        n.e("QADReportUtil", "checkReportAppSwitchFront() json = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            ew2.e D = ew2.e.D();
            D.e(jSONObject);
            D.J(x.a(SpaEffectReportActionKey.ID_APP_SWITCH_FRONT));
            n.e("QADReportUtil", "checkReportAppSwitchFront() url = " + D.q());
            ReportManager.INSTANCE.report(D, false, 3, null);
            f304042b = null;
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private static boolean d(String str) {
        if (!"187".equals(str) && !"191".equals(str) && !"253".equals(str) && !"257".equals(str) && !"299".equals(str) && !"305".equals(str)) {
            return false;
        }
        return true;
    }

    public static void e() {
        if (f304041a) {
            return;
        }
        f304041a = true;
        n.e("QADReportUtil", "registerAppSwitchFrontBackground()");
        ev2.a.b(f304043c);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements gv2.c {
        a() {
        }

        @Override // gv2.c
        public void a() {
            QAdThreadManager.INSTANCE.execIo(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.a();
                }
            });
        }

        @Override // gv2.c
        public void b() {
        }
    }
}
