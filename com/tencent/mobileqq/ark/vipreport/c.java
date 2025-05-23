package com.tencent.mobileqq.ark.vipreport;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.api.IArkIPCService;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.p;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements k91.a {

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements k91.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f199683a;

        a(String str) {
            this.f199683a = str;
        }

        @Override // k91.b
        public void a(boolean z16, Bundle bundle) {
            QLog.i("ArkApp.ArkVipReporterIPCHandler", 1, "onResultCallback, success=" + z16);
        }

        @Override // k91.b
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putString("content", this.f199683a);
            return bundle;
        }

        @Override // k91.b
        public String getMethod() {
            return "ARK.VipReport";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements BusinessObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (!z16) {
                QLog.i("ArkApp.ArkVipReporterIPCHandler", 1, "doVipReport(), sso request failed");
                return;
            }
            QLog.d("ArkApp.ArkVipReporterIPCHandler", 2, "doVipReport().server.back=" + obj);
        }
    }

    static void c(AppRuntime appRuntime, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("ArkApp.ArkVipReporterIPCHandler", 1, "doVipReport()=null");
            return;
        }
        p sso = ((IArkService) appRuntime.getRuntimeService(IArkService.class, "")).getSSO();
        if (sso == null) {
            return;
        }
        QLog.i("ArkApp.ArkVipReporterIPCHandler", 1, "doVipReport()=" + str);
        sso.sendAppMsg("ArkAppReport.VIPReport", str, 10000, 0, new b());
    }

    public static void d(String str) {
        ((IArkIPCService) QRoute.api(IArkIPCService.class)).call(new a(str));
    }

    @Override // k91.a
    public void a(Bundle bundle, k91.c cVar) {
        c(MobileQQ.sMobileQQ.waitAppRuntime(null), bundle.getString("content"));
        cVar.a(EIPCResult.createResult(0, new Bundle()));
    }

    @Override // k91.d
    public String getMethod() {
        return "ARK.VipReport";
    }
}
