package com.tencent.mobileqq.data.dt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g {

    /* renamed from: h, reason: collision with root package name */
    private static volatile g f203145h;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f203147b;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, Float> f203149d;

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, Map<String, Float>> f203150e;

    /* renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<String, Float> f203151f;

    /* renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, Map<String, Float>> f203152g;

    /* renamed from: a, reason: collision with root package name */
    private String f203146a = "";

    /* renamed from: c, reason: collision with root package name */
    private boolean f203148c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "intent.action.QQDtSamplingManager.onUpdate".equals(intent.getAction())) {
                QLog.d("QQDtSamplingConfig", 1, MobileQQ.processName + " receive broadcast:intent.action.QQDtSamplingManager.onUpdate");
                g.this.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VideoReport.clearAllSampleRate();
            g.this.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals(NewIntent.ACTION_ACCOUNT_CHANGED)) {
                g.this.p();
            }
        }
    }

    public g() {
        ConcurrentHashMap<String, Float> concurrentHashMap = new ConcurrentHashMap<>();
        this.f203149d = concurrentHashMap;
        ConcurrentHashMap<String, Map<String, Float>> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.f203150e = concurrentHashMap2;
        this.f203151f = new ConcurrentHashMap<>();
        this.f203152g = new ConcurrentHashMap<>();
        d();
        Float valueOf = Float.valueOf(100.0f);
        concurrentHashMap.put("pg_aio", valueOf);
        HashMap hashMap = new HashMap();
        hashMap.put("imp", valueOf);
        hashMap.put("imp_end", valueOf);
        hashMap.put("clck", valueOf);
        concurrentHashMap2.put("em_discover_button", hashMap);
        this.f203147b = e();
        r();
        l();
    }

    public static g c() {
        if (f203145h == null) {
            synchronized (g.class) {
                if (f203145h == null) {
                    f203145h = new g();
                }
            }
        }
        return f203145h;
    }

    private JSONObject e() {
        try {
            String decodeString = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("mmkv_key_toggle_dataset" + this.f203146a, "");
            QLog.d("QQDtSamplingConfig", 1, "[loadDataFromMMKVByKey], key = mmkv_key_toggle_dataset" + this.f203146a + " value = " + decodeString);
            if (!TextUtils.isEmpty(decodeString)) {
                return new JSONObject(decodeString);
            }
            return null;
        } catch (Exception e16) {
            QLog.e("QQDtSamplingConfig", 1, " loadDataFromMMKVByKey throw exception,", e16);
            return null;
        }
    }

    private void i(JSONObject jSONObject, Map<String, Map<String, Float>> map) {
        if (jSONObject == null) {
            QLog.d("QQDtSamplingConfig", 1, " [parseSamplingMapConfig] json data is null");
            return;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                HashMap hashMap = new HashMap();
                Iterator keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String str2 = (String) keys2.next();
                    hashMap.put(str2, Float.valueOf((float) jSONObject2.getDouble(str2)));
                }
                map.put(str, hashMap);
                if (QLog.isColorLevel()) {
                    QLog.d("QQDtSamplingConfig", 2, "[parseSamplingMapConfig], key = " + str + ", rateMap = " + hashMap);
                }
            }
        } catch (JSONException e16) {
            QLog.e("QQDtSamplingConfig", 1, "[parseSamplingMapConfig]:" + e16);
        }
    }

    private void j(JSONObject jSONObject, Map<String, Float> map) {
        if (jSONObject == null) {
            QLog.d("QQDtSamplingConfig", 1, " [parseSamplingMapConfig] json data is null");
            return;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                double d16 = jSONObject.getDouble(str);
                map.put(str, Float.valueOf((float) d16));
                if (QLog.isColorLevel()) {
                    QLog.d("QQDtSamplingConfig", 2, "[parseSamplingMapConfig], key = " + str + ", value = " + d16);
                }
            }
        } catch (JSONException e16) {
            QLog.e("QQDtSamplingConfig", 1, "[parseSamplingMapConfig]:" + e16);
        }
    }

    private void k() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        MobileQQ.sMobileQQ.registerReceiver(new c(), intentFilter);
    }

    private void l() {
        if (MobileQQ.sProcessId != 1) {
            MobileQQ.sMobileQQ.registerReceiver(new a(), new IntentFilter("intent.action.QQDtSamplingManager.onUpdate"));
            MobileQQ.sMobileQQ.registerReceiver(new b(), new IntentFilter("intent.action.QQDtSamplingManager.afterLogin"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            this.f203146a = firstSimpleAccount.getUin();
            if (QLog.isColorLevel()) {
                QLog.d("QQDtSamplingConfig", 2, "[trySetFirstUin], currentUin = " + this.f203146a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f203147b = e();
        r();
        h();
    }

    private void r() {
        QLog.d("QQDtSamplingConfig", 1, MobileQQ.processName + " [convertJsonToData]:" + this.f203147b);
        this.f203151f.clear();
        this.f203152g.clear();
        JSONObject jSONObject = this.f203147b;
        if (jSONObject != null) {
            try {
                this.f203148c = jSONObject.optBoolean("disableSample", false);
                j(this.f203147b.getJSONObject("page"), this.f203151f);
                i(this.f203147b.getJSONObject(DTConstants.TAG.ELEMENT), this.f203152g);
            } catch (Exception e16) {
                QLog.e("QQDtSamplingConfig", 1, " onUpdateConfigFromToggle throw exception,", e16);
            }
        }
    }

    public void d() {
        p();
        k();
    }

    public void f() {
        QLog.d("QQDtSamplingConfig", 1, "[onUpdateConfigAfterLogin]");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            this.f203146a = peekAppRuntime.getCurrentUin();
        }
        VideoReport.clearAllSampleRate();
        q();
        n();
    }

    public void g(AppRuntime appRuntime) {
        this.f203147b = ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject("dtSampleConfigs", "");
        r();
        h();
    }

    public void h() {
        if (this.f203148c) {
            VideoReport.clearAllSampleRate();
            QLog.d("QQDtSamplingConfig", 1, MobileQQ.processName + " [onUpdateDTSamplingConfig], close dt sampling");
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(this.f203151f);
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(this.f203152g);
        for (Map.Entry<String, Float> entry : this.f203149d.entrySet()) {
            concurrentHashMap.putIfAbsent(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Map<String, Float>> entry2 : this.f203150e.entrySet()) {
            concurrentHashMap2.putIfAbsent(entry2.getKey(), entry2.getValue());
        }
        QLog.d("QQDtSamplingConfig", 1, MobileQQ.processName + " [onUpdateDTSamplingConfig], pageSamplingMap = " + concurrentHashMap + "\nelementSamplingMap = " + concurrentHashMap2);
        VideoReport.setPageSampleRate(concurrentHashMap);
        VideoReport.setElementId2EventId2SampleRate(concurrentHashMap2);
    }

    public void m() {
        if (this.f203147b == null) {
            QLog.d("QQDtSamplingConfig", 1, "[saveToggleDataToMMKV], toggleDataSet is null");
            return;
        }
        try {
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString("mmkv_key_toggle_dataset" + this.f203146a, this.f203147b.toString());
            QLog.d("QQDtSamplingConfig", 1, "[saveToggleDataToMMKV], key = mmkv_key_toggle_dataset" + this.f203146a + " value = " + this.f203147b.toString());
        } catch (Exception e16) {
            QLog.e("QQDtSamplingConfig", 1, "[saveToggleDataToMMKV] throw exception", e16);
        }
    }

    public void n() {
        QLog.d("QQDtSamplingConfig", 1, "send broadcast: intent.action.QQDtSamplingManager.afterLogin");
        MobileQQ.sMobileQQ.sendBroadcast(new Intent("intent.action.QQDtSamplingManager.afterLogin"));
    }

    public void o() {
        QLog.d("QQDtSamplingConfig", 1, "send broadcast: intent.action.QQDtSamplingManager.onUpdate");
        MobileQQ.sMobileQQ.sendBroadcast(new Intent("intent.action.QQDtSamplingManager.onUpdate"));
    }
}
