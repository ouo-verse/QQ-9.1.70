package com.tencent.rmonitor.natmem;

import android.app.Application;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    private static boolean a(String str) {
        if (str != null && new File(str).exists()) {
            return true;
        }
        return false;
    }

    public static void b(String str, String str2, String str3, int i3, IReporter.ReportCallback reportCallback) {
        ArrayList arrayList = new ArrayList();
        if (a(str)) {
            arrayList.add(str);
        }
        if (a(str2)) {
            arrayList.add(str2);
        }
        if (a(str3)) {
            arrayList.add(str3);
        }
        String str4 = e14.c.c() + "dump_NatMem_" + e14.c.b(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss") + ".zip";
        if (!FileUtil.l(arrayList, str4, false)) {
            Logger.f365497g.e("RMonitor_NatMem_Reporter", "dump zip file failed!");
            return;
        }
        try {
            JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
            makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.e(BaseInfo.app));
            makeAttributes.put(ReportDataBuilder.KEY_64_BIT_FLAG, BaseInfo.is64Bit);
            makeAttributes.put("fileObj", str4);
            makeAttributes.put("stage", com.tencent.rmonitor.common.lifecycle.a.f());
            if (i3 == 1) {
                makeAttributes.put("memory_type", "vmsize");
            } else if (i3 == 2) {
                makeAttributes.put("memory_type", "physical");
            }
            makeAttributes.put("max_physical_pss", NatMemMonitor.getInstance().f().f());
            makeAttributes.put("max_vitural_vss", NatMemMonitor.getInstance().f().h());
            makeAttributes.put("sys_min_size", NatMemMonitor.getInstance().f().k());
            makeAttributes.put("enable_sys_hook", NatMemMonitor.getInstance().f().d());
            makeAttributes.put("sys_sample_factor", NatMemMonitor.getInstance().f().l());
            makeAttributes.put("app_min_size", NatMemMonitor.getInstance().f().b());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mem_ceiling_info", str);
            jSONObject.put("mem_history_info", str2);
            jSONObject.put("smaps_info", str3);
            jSONObject.put("file_stacks", str);
            Application application = BaseInfo.app;
            UserMeta userMeta = BaseInfo.userMeta;
            JSONObject makeParam = ReportDataBuilder.makeParam(application, "memory", BuglyMonitorName.NATIVE_MEMORY_ANALYZE, userMeta);
            makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
            makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
            makeParam.put(ReportDataBuilder.KEY_STACK_TYPE, 1);
            ReportData reportData = new ReportData(userMeta.uin, 1, "NatMem", makeParam);
            reportData.addFile(str4, true, true);
            reportData.setShouldRecordLinkData(true);
            s04.b.j().f(reportData);
            s04.b.j().a(false, reportData);
            ReporterMachine.f365411g.reportNow(reportData, reportCallback);
        } catch (JSONException e16) {
            Logger.f365497g.c("RMonitor_NatMem_Reporter", e16);
        }
    }
}
