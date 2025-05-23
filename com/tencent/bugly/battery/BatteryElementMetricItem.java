package com.tencent.bugly.battery;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BatteryElementMetricItem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "BatteryElementMetricItem";

    /* renamed from: id, reason: collision with root package name */
    public int f97808id;
    public String processName = "";
    public String processLaunchID = "";
    public String launchID = "";
    public String appVersion = "";
    public int locationFrequency = 0;
    public int wakeLockFrequency = 0;
    public int alarmFrequency = 0;
    public int alarmWakeUpFrequency = 0;
    public int alarmOtherFrequency = 0;
    public long processAliveInMs = 0;
    public long processForeInMs = 0;
    public long processBackInMs = 0;
    public String hotPatchNum = "";
    public JSONObject userData = new JSONObject();
    public JSONObject cpuTimeJson = new JSONObject();
    public HashMap<String, CpuTimePair> cpuTimePairHashMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class CpuTimePair {
        public long processCpuTimeInMs;
        public long totalCpuTimeInMs;

        CpuTimePair() {
        }
    }

    public void addCpuItem(String str, long j3, long j16) {
        if (this.cpuTimePairHashMap.get(str) != null) {
            CpuTimePair cpuTimePair = this.cpuTimePairHashMap.get(str);
            cpuTimePair.totalCpuTimeInMs += j3;
            cpuTimePair.processCpuTimeInMs += j16;
        } else {
            CpuTimePair cpuTimePair2 = new CpuTimePair();
            cpuTimePair2.processCpuTimeInMs = j16;
            cpuTimePair2.totalCpuTimeInMs = j3;
            this.cpuTimePairHashMap.put(str, cpuTimePair2);
        }
    }

    public JSONObject buildCpuTimeJson() {
        JSONObject jSONObject = new JSONObject();
        this.cpuTimeJson = jSONObject;
        try {
            jSONObject.put(DTConstants.TAG.ELEMENT, "cpu");
            this.cpuTimeJson.put("cpu_core", Runtime.getRuntime().availableProcessors());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, CpuTimePair> entry : this.cpuTimePairHashMap.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scene", entry.getKey());
                jSONObject2.put("total_cpu_time_in_ms", entry.getValue().totalCpuTimeInMs);
                jSONObject2.put("process_cpu_time_in_ms", entry.getValue().processCpuTimeInMs);
                jSONArray.mo162put(jSONObject2);
            }
            this.cpuTimeJson.put("cpu_time_details", jSONArray);
        } catch (JSONException e16) {
            Logger.f365497g.c(TAG, e16);
        }
        return this.cpuTimeJson;
    }
}
