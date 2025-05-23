package com.tencent.bugly.traffic;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.bugly.traffic.statistic.AbstractTrafficStatistic;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.a;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s04.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TrafficReport {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "TrafficReport";

    public static JSONObject makeReportParams(int i3, ArrayList<TrafficMsg> arrayList, List<AbstractTrafficStatistic> list) throws JSONException {
        String str;
        String str2;
        JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
        makeAttributes.put("process_name", a.e(BaseInfo.app));
        makeAttributes.put(JsonRuleKey.OPERATOR, TrafficMonitor.operatorName);
        makeAttributes.put(TVKDataBinder.KEY_REPORT_TYPE, 2);
        makeAttributes.put("exception_type", i3);
        if (i3 != 0) {
            b.j().g(makeAttributes);
            b.j().c(false, BuglyMonitorName.TRAFFIC_DETAIL, makeAttributes);
        } else {
            b.j().c(true, BuglyMonitorName.TRAFFIC_DETAIL, makeAttributes);
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<AbstractTrafficStatistic> it = list.iterator();
        while (true) {
            str = "http";
            if (!it.hasNext()) {
                break;
            }
            AbstractTrafficStatistic next = it.next();
            for (Map.Entry<String, TrafficMsg> entry : next.getAutoMaps().entrySet()) {
                Iterator<AbstractTrafficStatistic> it5 = it;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("collect_type", entry.getValue().mCollectType);
                jSONObject2.put("traffic_type", com.tencent.mobileqq.msf.core.quicksend.b.A);
                jSONObject2.put("peer_name", entry.getKey());
                jSONObject2.put("front_state", TrafficTools.frontStateToString(next.getFrontState()));
                jSONObject2.put("net_type", TrafficTools.netStateToString(next.getNetworkState()));
                jSONObject2.put("send", entry.getValue().mTx);
                jSONObject2.put("recv", entry.getValue().mRx);
                jSONArray.mo162put(jSONObject2);
                it = it5;
                makeAttributes = makeAttributes;
            }
            JSONObject jSONObject3 = makeAttributes;
            Iterator<AbstractTrafficStatistic> it6 = it;
            for (Iterator<Map.Entry<String, TrafficMsg>> it7 = next.getCustomMaps().entrySet().iterator(); it7.hasNext(); it7 = it7) {
                Map.Entry<String, TrafficMsg> next2 = it7.next();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("collect_type", next2.getValue().mCollectType);
                jSONObject4.put("traffic_type", "http");
                jSONObject4.put("peer_name", next2.getKey());
                jSONObject4.put("front_state", TrafficTools.frontStateToString(next.getFrontState()));
                jSONObject4.put("net_type", TrafficTools.netStateToString(next.getNetworkState()));
                jSONObject4.put("send", next2.getValue().mTx);
                jSONObject4.put("recv", next2.getValue().mRx);
                jSONArray.mo162put(jSONObject4);
            }
            it = it6;
            makeAttributes = jSONObject3;
        }
        Object obj = makeAttributes;
        if (jSONArray.length() <= 0) {
            return null;
        }
        jSONObject.put("metrics", jSONArray);
        if (i3 != 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<TrafficMsg> it8 = arrayList.iterator();
            while (it8.hasNext()) {
                TrafficMsg next3 = it8.next();
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("collect_type", next3.mCollectType);
                Iterator<TrafficMsg> it9 = it8;
                if (next3.mCollectType.equalsIgnoreCase("auto")) {
                    str2 = com.tencent.mobileqq.msf.core.quicksend.b.A;
                } else {
                    str2 = str;
                }
                jSONObject5.put("traffic_type", str2);
                jSONObject5.put("peer_name", next3.mHost);
                jSONObject5.put("front_state", TrafficTools.frontStateToString(next3.mFore));
                jSONObject5.put("net_type", TrafficTools.netStateToString(next3.mNet));
                jSONObject5.put("send", next3.mTx);
                jSONObject5.put("recv", next3.mRx);
                jSONObject5.put("start_time", 0);
                jSONObject5.put("end_time", next3.mTime);
                jSONArray2.mo162put(jSONObject5);
                it8 = it9;
                str = str;
            }
            jSONObject.put("connection_details", jSONArray2);
        }
        JSONObject makeParam = ReportDataBuilder.makeParam(BaseInfo.app, "resource", BuglyMonitorName.TRAFFIC_DETAIL, BaseInfo.userMeta);
        makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, obj);
        makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
        return makeParam;
    }

    public static void report(int i3, ArrayList<TrafficMsg> arrayList, List<AbstractTrafficStatistic> list) {
        if (arrayList.isEmpty()) {
            return;
        }
        try {
            JSONObject makeReportParams = makeReportParams(i3, arrayList, list);
            if (makeReportParams != null) {
                reportInternal(makeReportParams);
            }
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
    }

    public static void reportInternal(JSONObject jSONObject) {
        ReportData reportData = new ReportData(BaseInfo.userMeta.uin, 1, BuglyMonitorName.TRAFFIC_DETAIL, jSONObject);
        reportData.getReportStrategy().setUploadStrategy(ReportStrategy.UploadStrategy.UPLOAD_ANY);
        ReporterMachine.f365411g.reportNow(reportData, null);
    }
}
