package com.tencent.mtt.hippy.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.mtt.hippy.BuildConfig;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.a.a.a.c;
import com.tencent.mtt.hippy.a.a.a.d;
import com.tencent.mtt.hippy.dom.b;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public static int f336905a = 4003;

    /* renamed from: b, reason: collision with root package name */
    public static int f336906b = 4004;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mtt.hippy.a.b f336908d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<HippyEngineContext> f336909e;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, c> f336907c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private boolean f336910f = true;

    public a() {
        com.tencent.mtt.hippy.a.a.a.b bVar = new com.tencent.mtt.hippy.a.a.a.b(this);
        com.tencent.mtt.hippy.a.a.a.a aVar = new com.tencent.mtt.hippy.a.a.a.a(this);
        d dVar = new d(this);
        this.f336907c.put(bVar.a(), bVar);
        this.f336907c.put(aVar.a(), aVar);
        this.f336907c.put(dVar.a(), dVar);
    }

    public a a(HippyEngineContext hippyEngineContext, com.tencent.mtt.hippy.a.b bVar) {
        this.f336909e = new WeakReference<>(hippyEngineContext);
        this.f336908d = bVar;
        b domManager = hippyEngineContext.getDomManager();
        if (domManager != null) {
            domManager.a(this);
        }
        return this;
    }

    public HippyEngineContext b() {
        WeakReference<HippyEngineContext> weakReference = this.f336909e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void a() {
        if (b() == null) {
            return;
        }
        b domManager = b().getDomManager();
        if (domManager != null) {
            domManager.a((b.a) null);
        }
        Iterator<c> it = this.f336907c.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // com.tencent.mtt.hippy.dom.b.a
    public void b(boolean z16) {
        if (!this.f336910f || z16) {
            return;
        }
        ((com.tencent.mtt.hippy.a.a.a.b) this.f336907c.get("DOM")).b();
    }

    public void a(int i3, JSONObject jSONObject) {
        if (this.f336908d == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", i3);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject2.put("result", jSONObject);
            LogUtils.d("Inspector", "rspToFrontend, msg=" + jSONObject2.toString());
            this.f336908d.a(jSONObject2.toString());
        } catch (Exception e16) {
            LogUtils.e("Inspector", "rspToFrontEnd, exception:", e16);
        }
    }

    private void a(HippyEngineContext hippyEngineContext) {
        Iterator<Map.Entry<String, c>> it = this.f336907c.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(hippyEngineContext);
        }
    }

    public void a(com.tencent.mtt.hippy.a.a.b.c cVar) {
        String a16 = cVar.a();
        if (this.f336908d == null || a16 == null) {
            return;
        }
        LogUtils.d("Inspector", "sendEventToFrontend, eventJson=" + a16);
        this.f336908d.a(a16);
    }

    public void a(String str) {
        String str2;
        String str3;
        if (b() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("contextName", str);
            Context context = b().getGlobalConfigs().getContext();
            if (context != null) {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
                str2 = packageInfo.packageName;
                str3 = packageInfo.versionName;
            } else {
                str2 = "";
                str3 = "";
            }
            jSONObject.put("bundleId", str2);
            jSONObject.put("hostVersion", str3);
            jSONObject.put("sdkVersion", BuildConfig.LIBRARY_VERSION);
            a(new com.tencent.mtt.hippy.a.a.b.c("TDFRuntime.updateContextInfo", jSONObject));
        } catch (Exception e16) {
            LogUtils.e("Inspector", "updateContextName, exception:", e16);
        }
    }

    public void a(boolean z16) {
        this.f336910f = z16;
    }

    public boolean a(HippyEngineContext hippyEngineContext, String str) {
        c cVar;
        if (TextUtils.isEmpty(str)) {
            LogUtils.e("Inspector", "dispatchReqFromFrontend, msg null");
            return false;
        }
        LogUtils.d("Inspector", "dispatchReqFromFrontend, msg=" + str);
        if ("chrome_socket_closed".equals(str)) {
            a(hippyEngineContext);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("method");
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split("\\.");
                if (split.length > 1) {
                    String str2 = split[0];
                    if (!TextUtils.isEmpty(str2) && this.f336907c.containsKey(str2) && (cVar = this.f336907c.get(str2)) != null) {
                        return cVar.b(hippyEngineContext, split[1], jSONObject.optInt("id"), jSONObject.optJSONObject("params"));
                    }
                }
            }
        } catch (Exception e16) {
            LogUtils.e("Inspector", "dispatchReqFromFrontend, exception:", e16);
        }
        return false;
    }
}
