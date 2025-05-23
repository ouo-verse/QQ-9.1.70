package com.tencent.bugly.battery;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.battery.data.BaseBatteryInfo;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.d;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.custom.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BatteryElementReporter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "BatteryElementReporter";

    static JSONObject getExceptionThreshold() {
        JSONObject jSONObject = new JSONObject();
        d dVar = (d) ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.BATTERY_ELEMENT);
        try {
            jSONObject.put("single_location_duration_in_ms", dVar.f365311m);
            jSONObject.put("total_location_duration_in_ms", dVar.C);
            jSONObject.put("max_location_open_num", dVar.D);
            jSONObject.put("single_wakelock_duration_in_ms", dVar.E);
            jSONObject.put("total_wakelock_duration_in_ms", dVar.F);
            jSONObject.put("max_wakelock_open_num", dVar.G);
            jSONObject.put("max_alarm_open_num", dVar.H);
            jSONObject.put("max_wakeup_alarm_open_num", dVar.I);
            return jSONObject;
        } catch (JSONException e16) {
            throw new RuntimeException(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportAlarm(ArrayList<BaseBatteryInfo> arrayList, ArrayList<BaseBatteryInfo> arrayList2, long j3) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (!arrayList.isEmpty()) {
                jSONArray.mo162put("sum_alarm_frequency_exceed");
            }
            if (!arrayList2.isEmpty()) {
                jSONArray.mo162put("sum_wakeup_alarm_frequency_exceed");
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator<BaseBatteryInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray2.mo162put(it.next().toJSON(j3));
            }
            Iterator<BaseBatteryInfo> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(it5.next().toJSON(j3));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DTConstants.TAG.ELEMENT, NotificationCompat.CATEGORY_ALARM);
            jSONObject.put("frequency", arrayList.size());
            jSONObject.put("wakeup_frequency", arrayList2.size());
            jSONObject.put("duration_in_ms", 0);
            jSONObject.put("exception_threshold", getExceptionThreshold());
            jSONObject.put("exception_type", jSONArray);
            jSONObject.put("stacks", jSONArray2);
            reportInternal(jSONObject);
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
    }

    private static void reportInternal(JSONObject jSONObject) {
        try {
            JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
            try {
                JSONObject o16 = b.a().o();
                if (o16 != null) {
                    makeAttributes.put(ReportDataBuilder.KEY_USER_CUSTOM, o16);
                }
            } catch (JSONException e16) {
                Logger.f365497g.e(TAG, " getUserCustom, msg: " + e16.getMessage());
            }
            Application application = BaseInfo.app;
            UserMeta userMeta = BaseInfo.userMeta;
            JSONObject makeParam = ReportDataBuilder.makeParam(application, "resource", BuglyMonitorName.BATTERY_ELEMENT, userMeta);
            makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
            makeParam.put(ReportDataBuilder.KEY_BODY, jSONObject);
            ReporterMachine.f365411g.reportNow(new ReportData(userMeta.uin, 1, "BatteryElement", makeParam), null);
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportLocation(ArrayList<BaseBatteryInfo> arrayList, ArrayList<BaseBatteryInfo> arrayList2, ArrayList<BaseBatteryInfo> arrayList3, long j3, long j16) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (!arrayList.isEmpty()) {
                jSONArray.mo162put("single_location_duration_exceed");
            }
            if (!arrayList2.isEmpty()) {
                jSONArray.mo162put("sum_location_duration_exceed");
            }
            if (!arrayList3.isEmpty()) {
                jSONArray.mo162put("sum_location_frequency_exceed");
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(arrayList);
            hashSet.addAll(arrayList2);
            hashSet.addAll(arrayList3);
            ArrayList arrayList4 = new ArrayList(hashSet);
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                jSONArray2.mo162put(((BaseBatteryInfo) it.next()).toJSON(j3));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DTConstants.TAG.ELEMENT, "location");
            jSONObject.put("frequency", arrayList4.size());
            jSONObject.put("duration_in_ms", j16);
            jSONObject.put("exception_threshold", getExceptionThreshold());
            jSONObject.put("exception_type", jSONArray);
            jSONObject.put("stacks", jSONArray2);
            reportInternal(jSONObject);
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportWakeLock(ArrayList<BaseBatteryInfo> arrayList, ArrayList<BaseBatteryInfo> arrayList2, ArrayList<BaseBatteryInfo> arrayList3, long j3, long j16) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (!arrayList.isEmpty()) {
                jSONArray.mo162put("single_wake_lock_duration_exceed");
            }
            if (!arrayList2.isEmpty()) {
                jSONArray.mo162put("sum_wake_lock_duration_exceed");
            }
            if (!arrayList3.isEmpty()) {
                jSONArray.mo162put("sum_wake_lock_frequency_exceed");
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(arrayList);
            hashSet.addAll(arrayList2);
            hashSet.addAll(arrayList3);
            ArrayList arrayList4 = new ArrayList(hashSet);
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                jSONArray2.mo162put(((BaseBatteryInfo) it.next()).toJSON(j3));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DTConstants.TAG.ELEMENT, "wake_lock");
            jSONObject.put("frequency", arrayList4.size());
            jSONObject.put("duration_in_ms", j16);
            jSONObject.put("exception_threshold", getExceptionThreshold());
            jSONObject.put("exception_type", jSONArray);
            jSONObject.put("stacks", jSONArray2);
            reportInternal(jSONObject);
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
        }
    }
}
