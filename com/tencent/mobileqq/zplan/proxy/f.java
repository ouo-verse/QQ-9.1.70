package com.tencent.mobileqq.zplan.proxy;

import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0016J6\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0016J6\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/f;", "Llx4/b;", "", com.heytap.mcssdk.a.a.f36102l, "eventCode", "", "params", "", "a", "pageCode", "modeCode", "c", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f implements lx4.b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String pageCode, String modeCode, String eventCode, Map map) {
        Intrinsics.checkNotNullParameter(pageCode, "$pageCode");
        Intrinsics.checkNotNullParameter(modeCode, "$modeCode");
        Intrinsics.checkNotNullParameter(eventCode, "$eventCode");
        String str = pageCode + "#" + modeCode + "#" + eventCode;
        HashMap<String, String> hashMap = new HashMap<>();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String account = runtime != null ? runtime.getAccount() : null;
        if (account == null) {
            account = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(account, "BaseApplicationImpl.getA\u2026().runtime?.account ?: \"\"");
        }
        hashMap.put("qqUin", account);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        if (map != null) {
            hashMap.putAll(map);
        }
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            sb5.append(entry.getKey());
            sb5.append(":");
            sb5.append(entry.getValue());
            sb5.append(";");
        }
        QLog.d("ZPlanBeaconReportUtil", 1, "report " + str + " ; params:  " + ((Object) sb5));
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).report3DPerformance(str, hashMap);
    }

    @Override // lx4.b
    public void a(String appKey, String eventCode, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        if (Intrinsics.areEqual(appKey, "0AND0YAG6R40RLM6")) {
            t74.r.d(appKey, eventCode, params);
            return;
        }
        QLog.i("QQZPlanDengTaReportProxy", 1, "report: " + appKey + ", " + eventCode + ", " + params);
    }

    @Override // lx4.b
    public void b(final String pageCode, final String modeCode, final String eventCode, final Map<String, String> params) {
        Intrinsics.checkNotNullParameter(pageCode, "pageCode");
        Intrinsics.checkNotNullParameter(modeCode, "modeCode");
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        QLog.d("QQZPlanDengTaReportProxy", 1, "reportToDTGY, pageCode: " + pageCode + ", modeCode: " + modeCode + ", eventCode: " + eventCode);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.proxy.e
            @Override // java.lang.Runnable
            public final void run() {
                f.e(pageCode, modeCode, eventCode, params);
            }
        }, 128, null, false);
    }

    @Override // lx4.b
    public void c(String pageCode, String modeCode, String eventCode, Map<String, String> params) {
        Intrinsics.checkNotNullParameter(pageCode, "pageCode");
        Intrinsics.checkNotNullParameter(modeCode, "modeCode");
        Intrinsics.checkNotNullParameter(eventCode, "eventCode");
        QLog.d("QQZPlanDengTaReportProxy", 1, "ReportToDT, pageCode: " + pageCode + ", modeCode: " + modeCode + ", eventCode: " + eventCode);
        t74.r.c(pageCode, modeCode, eventCode, params);
    }
}
