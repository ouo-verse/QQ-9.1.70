package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.richtext.utils.e;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private String f262687c;

    /* renamed from: e, reason: collision with root package name */
    private String f262689e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> f262690f;

    /* renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f262685a = null;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, ArrayList<C8304b>> f262686b = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private boolean f262688d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            b.this.k(context, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public class C8304b {

        /* renamed from: a, reason: collision with root package name */
        public String f262692a;

        /* renamed from: b, reason: collision with root package name */
        public String f262693b;

        C8304b(String str, String str2) {
            this.f262692a = str;
            this.f262693b = str2;
        }
    }

    public b(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a aVar) {
        this.f262690f = null;
        this.f262690f = new WeakReference<>(aVar);
    }

    private void b() {
        this.f262685a = new a();
    }

    private void d() {
        if (this.f262688d) {
            return;
        }
        if (this.f262685a == null) {
            b();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        BaseApplicationImpl.getApplication().registerReceiver(this.f262685a, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        this.f262688d = true;
        this.f262686b = new HashMap<>();
    }

    private String e() {
        if (TextUtils.isEmpty(this.f262687c)) {
            return null;
        }
        return Uri.parse(this.f262687c).getHost();
    }

    private String f() {
        if (this.f262689e == null) {
            this.f262689e = String.valueOf(System.currentTimeMillis()) + ((int) (Math.random() * 1000000.0d));
        }
        return this.f262689e;
    }

    private String g() {
        WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> weakReference = this.f262690f;
        if (weakReference != null && weakReference.get() != null) {
            this.f262690f.get();
            return "https://qq.com";
        }
        return "https://qq.com";
    }

    private void h(String str, String str2) {
        WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> weakReference = this.f262690f;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f262690f.get().U(str, str2);
    }

    private void i(String str, JSONObject jSONObject) {
        WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> weakReference = this.f262690f;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f262690f.get().T(str, jSONObject);
    }

    private void l(String str, String str2, String str3) {
        if (this.f262686b == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        if (this.f262686b.containsKey(str)) {
            ArrayList<C8304b> arrayList = this.f262686b.get(str);
            arrayList.add(new C8304b(str2, str3));
            this.f262686b.put(str, arrayList);
        } else {
            ArrayList<C8304b> arrayList2 = new ArrayList<>();
            arrayList2.add(new C8304b(str2, str3));
            this.f262686b.put(str, arrayList2);
        }
    }

    private void n(String str, String str2, String str3) {
        if (this.f262686b == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || !this.f262686b.containsKey(str)) {
            return;
        }
        ArrayList<C8304b> remove = this.f262686b.remove(str);
        for (int i3 = 0; i3 < remove.size(); i3++) {
            C8304b c8304b = remove.get(i3);
            if (c8304b.f262692a.equals(str2) && c8304b.f262693b.equals(str3)) {
                remove.remove(c8304b);
            }
        }
        if (remove.size() > 0) {
            this.f262686b.put(str, remove);
        }
    }

    public void a(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("event", jSONObject.optString(AdMetricTag.EVENT_NAME, ""));
        String g16 = g();
        this.f262687c = g16;
        if (TextUtils.isEmpty(g16)) {
            if (QLog.isColorLevel()) {
                QLog.w("BridgeModule.event", 2, "source url is null");
            }
            h(str, "source url is null");
        } else if (TextUtils.isEmpty(optString)) {
            if (QLog.isColorLevel()) {
                QLog.w("BridgeModule.event", 2, "event name is null");
            }
            h(str, "event name is null");
        } else {
            d();
            WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> weakReference = this.f262690f;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            l(optString, jSONObject.optString(IECDtReport.ACTION_IDENTIFIER, this.f262690f.get().getViolaInstance().c()), str);
        }
    }

    public void c(JSONObject jSONObject, String str) {
        String str2 = "";
        String optString = jSONObject.optString("event", jSONObject.optString(AdMetricTag.EVENT_NAME, ""));
        String g16 = g();
        if (TextUtils.isEmpty(optString)) {
            if (QLog.isColorLevel()) {
                QLog.w("BridgeModule.event", 2, "event name is null");
            }
            h(str, "event name is null");
            return;
        }
        if (str == null && this.f262686b.containsKey(optString)) {
            str = this.f262686b.get(optString).get(0).f262693b;
        }
        String str3 = str;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            str2 = optJSONObject.toString();
        }
        String str4 = str2;
        if (e.f(jSONObject.opt("toNative"))) {
            p(optString, optJSONObject);
            i(str3, null);
        } else {
            q(g16, str4, str3, jSONObject, optString, optJSONObject);
        }
    }

    public void j() {
        if (this.f262688d && this.f262685a != null) {
            BaseApplicationImpl.getApplication().unregisterReceiver(this.f262685a);
            this.f262685a = null;
        }
        WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> weakReference = this.f262690f;
        if (weakReference != null) {
            weakReference.clear();
            this.f262690f = null;
        }
        HashMap<String, ArrayList<C8304b>> hashMap = this.f262686b;
        if (hashMap != null) {
            for (ArrayList<C8304b> arrayList : hashMap.values()) {
                if (arrayList != null && arrayList.size() > 0) {
                    arrayList.clear();
                }
            }
            this.f262686b.clear();
            this.f262686b = null;
        }
    }

    protected void m(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        HashMap<String, ArrayList<C8304b>> hashMap = this.f262686b;
        ArrayList<C8304b> arrayList = hashMap == null ? null : hashMap.get(str);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str2 = arrayList.get(i3).f262693b;
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("event", str);
                jSONObject3.put("data", jSONObject);
                jSONObject3.put("source", jSONObject2);
            } catch (JSONException e16) {
                QLog.e("BridgeModule.event", 1, e16.getMessage(), e16);
            }
            i(str2, jSONObject3);
        }
    }

    public void o(JSONObject jSONObject, String str) {
        WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> weakReference;
        String optString = jSONObject.optString("event", jSONObject.optString(AdMetricTag.EVENT_NAME, ""));
        if (TextUtils.isEmpty(optString)) {
            if (QLog.isColorLevel()) {
                QLog.w("BridgeModule.event", 2, "event name is null");
            }
            h(str, "event name is null");
        } else {
            if (this.f262686b != null && (weakReference = this.f262690f) != null && weakReference.get() != null) {
                n(optString, jSONObject.optString(IECDtReport.ACTION_IDENTIFIER, this.f262690f.get().getViolaInstance().c()), str);
            }
            i(str, new JSONObject());
        }
    }

    protected void k(Context context, Intent intent) {
        JSONObject jSONObject;
        String str;
        if (intent != null && intent.getBooleanExtra("broadcast", true)) {
            String stringExtra = intent.getStringExtra("unique");
            if (stringExtra == null || !stringExtra.equals(f())) {
                String stringExtra2 = intent.getStringExtra("event");
                if (TextUtils.isEmpty(stringExtra2)) {
                    return;
                }
                String stringExtra3 = intent.getStringExtra("data");
                JSONObject jSONObject2 = null;
                if (stringExtra3 != null) {
                    try {
                        jSONObject = new JSONObject(stringExtra3);
                    } catch (JSONException unused) {
                        return;
                    }
                } else {
                    jSONObject = null;
                }
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("domains");
                if (stringArrayListExtra == null) {
                    return;
                }
                String stringExtra4 = intent.getStringExtra("source");
                if (stringExtra4 != null) {
                    try {
                        jSONObject2 = new JSONObject(stringExtra4);
                    } catch (JSONException unused2) {
                        return;
                    }
                }
                String e16 = e();
                if (QLog.isColorLevel()) {
                    Object[] objArr = new Object[5];
                    WeakReference<com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a> weakReference = this.f262690f;
                    String str2 = "NULL";
                    if (weakReference == null) {
                        str = "NULL";
                    } else {
                        str = weakReference.toString();
                    }
                    objArr[0] = str;
                    objArr[1] = stringExtra2;
                    if (jSONObject != null) {
                        str2 = jSONObject.toString();
                    }
                    objArr[2] = str2;
                    objArr[3] = TextUtils.join(",", stringArrayListExtra);
                    objArr[4] = jSONObject2;
                    QLog.d("BridgeModule.event", 2, String.format("onReceive, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", objArr));
                }
                int size = stringArrayListExtra.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (AuthorizeConfig.P(stringArrayListExtra.get(i3), e16)) {
                        m(stringExtra2, jSONObject, jSONObject2);
                        return;
                    }
                }
            }
        }
    }

    private void q(String str, String str2, String str3, JSONObject jSONObject, String str4, JSONObject jSONObject2) {
        boolean z16;
        boolean z17;
        String str5;
        if (!TextUtils.isEmpty(str2) && str2.length() >= 460800) {
            if (QLog.isColorLevel()) {
                QLog.w("BridgeModule.event", 2, "param data is over size");
            }
            h(str3, "param data is over size");
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("options");
            ArrayList<String> arrayList = new ArrayList<>();
            if (optJSONObject != null) {
                z16 = optJSONObject.optBoolean("echo", true);
                z17 = optJSONObject.optBoolean("broadcast", true);
                JSONArray optJSONArray = optJSONObject.optJSONArray("domains");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        String optString = optJSONArray.optString(i3);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                }
            } else {
                z16 = true;
                z17 = true;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("url", str);
            if (arrayList.size() == 0 && !TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                if (parse.isHierarchical()) {
                    arrayList.add(parse.getHost());
                }
            }
            Intent intent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            intent.putExtra("broadcast", z17);
            intent.putExtra("unique", f());
            intent.putExtra("event", str4);
            if (jSONObject2 != null) {
                intent.putExtra("data", jSONObject2.toString());
            }
            intent.putStringArrayListExtra("domains", arrayList);
            intent.putExtra("source", jSONObject3.toString());
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[5];
                objArr[0] = this.f262690f.toString();
                objArr[1] = str4;
                if (jSONObject2 != null) {
                    str5 = jSONObject2.toString();
                } else {
                    str5 = "NULL";
                }
                objArr[2] = str5;
                objArr[3] = TextUtils.join(",", arrayList);
                objArr[4] = jSONObject3;
                QLog.d("BridgeModule.event", 2, String.format("send event broadcast, pluginReference: %s, event: %s, data: %s, domains: %s, source: %s", objArr));
            }
            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
            if (z16) {
                m(str4, jSONObject2, jSONObject3);
            }
        } catch (JSONException e16) {
            h(str3, e16.getMessage());
        }
    }

    private void p(String str, JSONObject jSONObject) {
    }
}
