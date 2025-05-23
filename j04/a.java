package j04;

import android.app.Application;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.rmonitor.base.db.table.TrafficInfoTable;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.TrafficInfo;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public static ReportData a(ArrayList<TrafficInfo> arrayList) {
        try {
            JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
            makeAttributes.put("process_name", com.tencent.rmonitor.common.util.a.e(BaseInfo.app));
            makeAttributes.put(JsonRuleKey.OPERATOR, NetworkWatcher.INSTANCE.getOperatorName());
            makeAttributes.put(TVKDataBinder.KEY_REPORT_TYPE, 1);
            makeAttributes.put("exception_type", 0);
            makeAttributes.put(ReportDataBuilder.KEY_HOT_PATCH, arrayList.get(0).getHotPatchNum());
            makeAttributes.put(ReportDataBuilder.KEY_USER_CUSTOM, arrayList.get(0).getUserData());
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<TrafficInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                TrafficInfo next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("collect_type", next.getType());
                if (next.getType().equals("custom")) {
                    jSONObject2.put("traffic_type", "http");
                } else {
                    jSONObject2.put("traffic_type", b.A);
                }
                jSONObject2.put("peer_name", next.getHost());
                jSONObject2.put("front_state", next.getFrontState());
                jSONObject2.put("net_type", next.getNetState());
                jSONObject2.put("send", next.getTx());
                jSONObject2.put("recv", next.getRx());
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put("metrics", jSONArray);
            Application application = BaseInfo.app;
            UserMeta userMeta = BaseInfo.userMeta;
            JSONObject makeParam = ReportDataBuilder.makeParam(application, "resource", BuglyMonitorName.TRAFFIC, userMeta);
            makeParam.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, arrayList.get(0).getProcessLaunchID());
            makeParam.put(ReportDataBuilder.KEY_LAUNCH_ID, arrayList.get(0).getLaunchID());
            makeParam.put("app_version", arrayList.get(0).getAppVersion());
            makeParam.put("process_name", arrayList.get(0).getProcessName());
            makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
            makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
            return new ReportData(userMeta.uin, 1, "Traffic", makeParam);
        } catch (Throwable th5) {
            Logger.f365497g.c("TrafficReport", th5);
            return null;
        }
    }

    public static ArrayList<ReportData> b() {
        ReportData a16;
        try {
            ArrayList<TrafficInfo> c16 = c();
            if (c16 != null && !c16.isEmpty()) {
                HashMap hashMap = new HashMap();
                Iterator<TrafficInfo> it = c16.iterator();
                while (it.hasNext()) {
                    TrafficInfo next = it.next();
                    if (!hashMap.containsKey(next.getProcessLaunchID())) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(next);
                        hashMap.put(next.getProcessLaunchID(), arrayList);
                    } else {
                        ((ArrayList) hashMap.get(next.getProcessLaunchID())).add(next);
                    }
                }
                ArrayList<ReportData> arrayList2 = new ArrayList<>();
                Iterator it5 = hashMap.entrySet().iterator();
                while (it5.hasNext()) {
                    ArrayList arrayList3 = (ArrayList) ((Map.Entry) it5.next()).getValue();
                    if (!arrayList3.isEmpty() && (a16 = a(arrayList3)) != null) {
                        arrayList2.add(a16);
                    }
                }
                TrafficInfoTable.g().d(c16);
                return arrayList2;
            }
            return null;
        } catch (Throwable th5) {
            Logger.f365497g.c("TrafficReport", th5);
            return null;
        }
    }

    private static ArrayList<TrafficInfo> c() {
        return (ArrayList) TrafficInfoTable.g().i(null, "process_name = ? AND process_launch_id != ? ", new String[]{com.tencent.rmonitor.common.util.a.e(BaseInfo.app), TraceGenerator.getProcessLaunchId()}, false, null, null, null, null);
    }
}
