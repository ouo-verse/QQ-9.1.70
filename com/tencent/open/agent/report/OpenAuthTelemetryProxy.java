package com.tencent.open.agent.report;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;

/* loaded from: classes22.dex */
public class OpenAuthTelemetryProxy {

    /* renamed from: com.tencent.open.agent.report.OpenAuthTelemetryProxy$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f340480d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f340481e;

        @Override // java.lang.Runnable
        public void run() {
            this.f340480d.putString(IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, this.f340481e);
            QIPCClientHelper.getInstance().getClient().callServer("open_sdk_qipc_module", "action_open_auth_telemetry_report", this.f340480d, null);
        }
    }

    public static void b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", str);
        a("ACTION_INIT", bundle);
    }

    public static void c() {
        a("ACTION_CLICK_CANCEL", null);
    }

    public static void d() {
        a("ACTION_CLICK_SUBMIT", null);
    }

    public static void e(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isSuccess", z16);
        a("ACTION_AUTH_RESULT", bundle);
    }

    public static void f() {
        a("ACTION_UI_SHOWED", null);
    }

    private static void a(String str, Bundle bundle) {
    }
}
