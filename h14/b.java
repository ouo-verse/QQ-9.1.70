package h14;

import android.app.Application;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    public ReportData a(String str, String str2, DumpResult dumpResult, Map<String, String> map) {
        if (dumpResult != null) {
            try {
                JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
                if (map != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("uuid", entry.getKey());
                        jSONObject.put("leakobj", entry.getValue());
                        jSONArray.mo162put(jSONObject);
                    }
                    makeAttributes.put("extra_leak", jSONArray);
                }
                makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.e(BaseInfo.app));
                makeAttributes.put(ReportDataBuilder.KEY_64_BIT_FLAG, BaseInfo.is64Bit);
                makeAttributes.put("leakobj", str);
                makeAttributes.put("uuid", str2);
                String str3 = dumpResult.zipFilePath;
                makeAttributes.put("fileObj", str3);
                makeAttributes.put("stage", com.tencent.rmonitor.common.lifecycle.a.f());
                String str4 = dumpResult.hprofPath;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("hprof_file", str4.substring(str4.lastIndexOf(File.separator) + 1));
                Application application = BaseInfo.app;
                UserMeta userMeta = BaseInfo.userMeta;
                JSONObject makeParam = ReportDataBuilder.makeParam(application, "memory", BuglyMonitorName.MEMORY_JAVA_LEAK, userMeta);
                makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
                makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject2);
                ReportData reportData = new ReportData(userMeta.uin, 1, QZLog.MEMORY_LEAK, makeParam);
                reportData.getReportStrategy().setUploadStrategy(ReportStrategy.UploadStrategy.UPLOAD_WIFI);
                reportData.addFile(str3, true, true);
                reportData.setShouldRecordLinkData(true);
                s04.b.j().f(reportData);
                s04.b.j().a(false, reportData);
                ReporterMachine.f365411g.reportNow(reportData, null);
                return reportData;
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_MemoryLeakReporter", th5);
            }
        }
        return null;
    }
}
