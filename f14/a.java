package f14;

import android.app.Application;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public void a(DumpResult dumpResult, String str) {
        if (!dumpResult.success) {
            Logger.f365497g.e("RMonitor_MemoryCeiling_Reporter", "dump other file failed!");
            return;
        }
        try {
            JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
            makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.e(BaseInfo.app));
            makeAttributes.put(ReportDataBuilder.KEY_64_BIT_FLAG, BaseInfo.is64Bit);
            String str2 = dumpResult.zipFilePath;
            makeAttributes.put("fileObj", str2);
            makeAttributes.put("stage", com.tencent.rmonitor.common.lifecycle.a.f());
            makeAttributes.put(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, com.tencent.rmonitor.common.lifecycle.a.e());
            m k3 = ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.MEMORY_JAVA_CEILING);
            long maxMemory = Runtime.getRuntime().maxMemory();
            makeAttributes.put("threshold", (k3.threshold * maxMemory) / 100);
            makeAttributes.put("vm_max_size", maxMemory);
            makeAttributes.put("device_total_mem_size", DeviceInfoUtil.getRamTotalSize());
            makeAttributes.put("dump_reason", str);
            String str3 = dumpResult.hprofPath;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hprof_file", str3.substring(str3.lastIndexOf(File.separator) + 1));
            Application application = BaseInfo.app;
            UserMeta userMeta = BaseInfo.userMeta;
            JSONObject makeParam = ReportDataBuilder.makeParam(application, "memory", BuglyMonitorName.MEMORY_JAVA_CEILING, userMeta);
            makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
            makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
            ReportData reportData = new ReportData(userMeta.uin, 1, "MemoryCelling", makeParam);
            reportData.getReportStrategy().setUploadStrategy(ReportStrategy.UploadStrategy.UPLOAD_WIFI);
            reportData.addFile(str2, true, true);
            reportData.setShouldRecordLinkData(true);
            s04.b.j().f(reportData);
            s04.b.j().a(false, reportData);
            ReporterMachine.f365411g.reportNow(reportData, null);
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_MemoryCeiling_Reporter", th5);
        }
    }
}
