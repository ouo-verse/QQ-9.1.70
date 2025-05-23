package l14;

import android.app.Application;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static d f413651b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f413652a = false;

    d() {
    }

    public static d a() {
        if (f413651b == null) {
            synchronized (d.class) {
                if (f413651b == null) {
                    f413651b = new d();
                }
            }
        }
        return f413651b;
    }

    private void c(g gVar) {
        int i3;
        long c16 = gVar.c();
        if (c16 <= 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        long e16 = gVar.e();
        if (e16 <= 0 && BaseInfo.is64Bit.booleanValue()) {
            i3 |= 4;
        }
        if (e16 <= 0 && !BaseInfo.is64Bit.booleanValue()) {
            i3 |= 2;
        }
        long a16 = gVar.a();
        if (a16 <= 0) {
            i3 |= 8;
        }
        com.tencent.rmonitor.sla.g.a("memory", BuglyMonitorName.MEMORY_METRIC, String.valueOf(200000 | i3), ReportDataBuilder.getClientIdentify(BaseInfo.userMeta), c16 + "," + e16 + "," + a16);
    }

    JSONObject b(h hVar) throws JSONException {
        if (hVar.k()) {
            JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
            makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.e(BaseInfo.app));
            makeAttributes.put(ReportDataBuilder.KEY_64_BIT_FLAG, BaseInfo.is64Bit);
            hVar.m(makeAttributes);
            Logger.f365497g.i("RMonitor_MemoryQuantile", "makeAttribute, " + makeAttributes);
            return makeAttributes;
        }
        return null;
    }

    public void d() {
        if (!this.f413652a) {
            this.f413652a = true;
            if (f.f().g()) {
                try {
                    h h16 = f.f().h();
                    JSONObject b16 = b(h16);
                    if (b16 != null) {
                        Application application = BaseInfo.app;
                        UserMeta userMeta = BaseInfo.userMeta;
                        JSONObject makeParam = ReportDataBuilder.makeParam(application, "metric", BuglyMonitorName.MEMORY_METRIC, userMeta);
                        e(makeParam, h16);
                        makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, b16);
                        ReportData reportData = new ReportData(userMeta.uin, 1, "QUANTILE_EVENT", makeParam);
                        reportData.getReportStrategy().setUploadStrategy(ReportStrategy.UploadStrategy.UPLOAD_ANY);
                        ReporterMachine.f365411g.reportNow(reportData, new a());
                    } else {
                        c(h16.e());
                    }
                } catch (Throwable th5) {
                    Logger.f365497g.c("RMonitor_MemoryQuantile", th5);
                    e.a("json_parser_error", th5.toString());
                }
                f.f().r(false);
            }
        }
    }

    public void e(JSONObject jSONObject, h hVar) throws JSONException {
        if (!TextUtils.isEmpty(hVar.f())) {
            jSONObject.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, hVar.f());
        }
        if (!TextUtils.isEmpty(hVar.c())) {
            jSONObject.put(ReportDataBuilder.KEY_LAUNCH_ID, hVar.c());
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements IReporter.ReportCallback {
        a() {
        }

        @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
        public void onFailure(int i3, @NonNull String str, int i16, int i17) {
            Logger.f365497g.e("RMonitor_MemoryQuantile", "reportQuantileEvent fail! errorCode = " + i3 + ", errorMsg = " + str);
        }

        @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
        public void onSuccess(int i3, int i16) {
            Logger.f365497g.d("RMonitor_MemoryQuantile", "reportQuantileEvent success!");
        }

        @Override // com.tencent.bugly.common.reporter.IReporter.ReportCallback
        public void onCached() {
        }
    }
}
