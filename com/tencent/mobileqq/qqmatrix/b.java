package com.tencent.mobileqq.qqmatrix;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    Map<String, String> f274129a;

    /* renamed from: b, reason: collision with root package name */
    Map<String, String> f274130b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqmatrix.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static class C8416b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f274131a = new b();
    }

    private void a(Map<String, String> map, JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String valueOf = String.valueOf(keys.next());
            map.put(valueOf, jSONObject.getString(valueOf));
        }
    }

    public static b b() {
        return C8416b.f274131a;
    }

    private Map<String, String> i(String str) {
        String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(str, "");
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(decodeString)) {
            return hashMap;
        }
        try {
            a(hashMap, new JSONObject(decodeString));
        } catch (JSONException e16) {
            QLog.e("QQThreadMonitorConfig", 1, "[loadToggleDataFromMMKV]:" + e16.toString());
        }
        return hashMap;
    }

    private static void k(Map<String, String> map, String str) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (map != null && !map.isEmpty()) {
            try {
                from.encodeString(str, new JSONObject(map).toString());
                return;
            } catch (Exception e16) {
                QLog.e("QQThreadMonitorConfig", 1, "[saveToggleDataToMMKV]:" + e16.toString());
                return;
            }
        }
        from.encodeString(str, "");
    }

    public int c() {
        Map<String, String> map = this.f274129a;
        if (map == null || map.isEmpty()) {
            return 400;
        }
        try {
            return Integer.parseInt(this.f274129a.get("thread_num_threshold"));
        } catch (NumberFormatException e16) {
            if (!QLog.isColorLevel()) {
                return 400;
            }
            QLog.e("QQThreadMonitorConfig", 2, "[getMatrixThreadNumThreshold] error:" + e16.toString());
            return 400;
        }
    }

    public long d() {
        Map<String, String> map = this.f274129a;
        if (map == null || map.isEmpty()) {
            return 43200000L;
        }
        try {
            return Long.parseLong(this.f274129a.get("report_interval"));
        } catch (NumberFormatException e16) {
            if (!QLog.isColorLevel()) {
                return 43200000L;
            }
            QLog.e("QQThreadMonitorConfig", 2, "[getMatrixThreadReportTimeInterval] error:" + e16.toString());
            return 43200000L;
        }
    }

    public int e() {
        Map<String, String> map = this.f274129a;
        if (map == null || map.isEmpty()) {
            return 3;
        }
        try {
            return Integer.parseInt(this.f274129a.get("top_size"));
        } catch (NumberFormatException e16) {
            if (!QLog.isColorLevel()) {
                return 3;
            }
            QLog.e("QQThreadMonitorConfig", 2, "[getMatrixTopSize] error:" + e16.toString());
            return 3;
        }
    }

    public int f() {
        Map<String, String> map = this.f274129a;
        if (map == null || map.isEmpty()) {
            return 300;
        }
        try {
            return Integer.parseInt(this.f274129a.get("start_hook_threshold"));
        } catch (NumberFormatException e16) {
            if (!QLog.isColorLevel()) {
                return 300;
            }
            QLog.e("QQThreadMonitorConfig", 2, "[getStartHookThreadNumThreshold] error:" + e16.toString());
            return 300;
        }
    }

    public JSONArray g() {
        Map<String, String> map = this.f274129a;
        if (map != null && !map.isEmpty()) {
            try {
                return new JSONArray(this.f274129a.get("leak_allow_list"));
            } catch (JSONException e16) {
                QLog.e("QQThreadMonitorConfig", 1, "[getThreadLeakAllowlist]:" + e16.toString());
                return new JSONArray();
            }
        }
        return new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        this.f274130b = i("matrix_toggle_data_traffic");
        this.f274129a = i("matrix_toggle_data_leak");
        QLog.d("QQThreadMonitorConfig", 2, "trafficMonitorDataSet:" + this.f274130b);
        QLog.d("QQThreadMonitorConfig", 2, "threadLeakMonitorDataSet:" + this.f274129a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(AppRuntime appRuntime) {
        this.f274129a = ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isEnabledWithDataSet("qq_toggle_matrix_thread_hook", "");
        this.f274130b = ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isEnabledWithDataSet("qq_toggle_matrix_traffic_monitor", "");
        QLog.d("QQThreadMonitorConfig", 1, "[processTrafficData]" + this.f274130b);
        Map<String, String> map = this.f274130b;
        if (map != null && !map.isEmpty()) {
            String str = this.f274130b.get("traffic_json_config");
            if (TextUtils.isEmpty(str)) {
                QLog.e("QQThreadMonitorConfig", 1, "[updateDataSets] traffic_json_config is Empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    this.f274130b.put(str2, String.valueOf(jSONObject.get(str2)));
                }
            } catch (JSONException e16) {
                QLog.e("QQThreadMonitorConfig", 1, "[updateDataSets]:" + e16.toString());
            }
            this.f274130b.remove("traffic_json_config");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        k(this.f274129a, "matrix_toggle_data_leak");
        k(this.f274130b, "matrix_toggle_data_traffic");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        QLog.d("QQThreadMonitorConfig", 1, "send ACTION_TOGGLE_UPDATE");
        MobileQQ.sMobileQQ.sendBroadcast(new Intent("com.tencent.matrix.toggle.onUpdate"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(AppRuntime appRuntime) {
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable("qq_toggle_matrix_thread_hook", false);
        QLog.d("QQThreadMonitorConfig", 1, MobileQQ.processName + " [isLeakToggle]:" + isFeatureSwitchEnable);
        boolean isFeatureSwitchEnable2 = iFeatureRuntimeService.isFeatureSwitchEnable("qq_toggle_matrix_traffic_monitor", false);
        QLog.d("QQThreadMonitorConfig", 1, MobileQQ.processName + " [isTrafficToggle]:" + isFeatureSwitchEnable2);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        from.encodeBool("matrix_toggle_leak", isFeatureSwitchEnable);
        from.encodeBool("matrix_toggle_traffic", isFeatureSwitchEnable2);
    }

    b() {
        this.f274130b = new HashMap();
        this.f274129a = new HashMap();
    }
}
