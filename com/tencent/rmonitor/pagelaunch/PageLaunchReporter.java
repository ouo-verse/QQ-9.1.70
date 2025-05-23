package com.tencent.rmonitor.pagelaunch;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes25.dex */
public class PageLaunchReporter {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(a aVar) {
        if (aVar == null || aVar.f365796c == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(ArrayList<a> arrayList) {
        try {
            if (arrayList.isEmpty()) {
                Logger.f365497g.i("PageLaunchReporter", "reportInternal with empty list");
                return;
            }
            JSONObject makeParam = ReportDataBuilder.makeParam(BaseInfo.app, "launch", BuglyMonitorName.PAGE_LAUNCH, BaseInfo.userMeta);
            if (makeParam == null) {
                return;
            }
            JSONObject makeAttributes = ReportDataBuilder.makeAttributes();
            makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.e(BaseInfo.app));
            makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    jSONArray.mo162put(next.c());
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pages", jSONArray);
            makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
            ReportData reportData = new ReportData(BaseInfo.userMeta.uin, 1, BuglyMonitorName.PAGE_LAUNCH, makeParam);
            s04.b.j().a(true, reportData);
            ReporterMachine.f365411g.reportNow(reportData, null);
        } catch (Throwable th5) {
            Logger.f365497g.b("PageLaunchReporter", "realReport", th5);
        }
    }

    public static void e(final ConcurrentHashMap<Integer, a> concurrentHashMap) {
        if (concurrentHashMap.isEmpty()) {
            Logger.f365497g.i("PageLaunchReporter", "reportNow with empty map");
        } else {
            ThreadManager.runInMonitorThread(new Runnable() { // from class: com.tencent.rmonitor.pagelaunch.PageLaunchReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = concurrentHashMap.keySet().iterator();
                    while (it.hasNext()) {
                        a aVar = (a) concurrentHashMap.get((Integer) it.next());
                        if (PageLaunchReporter.c(aVar)) {
                            arrayList.add(aVar);
                        } else {
                            Logger.f365497g.i("PageLaunchReporter", "pageLaunchInfo not valid," + aVar.f365796c + "," + aVar.f365798e);
                        }
                    }
                    PageLaunchReporter.d(arrayList);
                }
            }, 0L);
        }
    }
}
