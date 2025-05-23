package com.tencent.gdtad.kuikly.module;

import androidx.annotation.Nullable;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private Map<GdtAdLoader, e> f109314a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private GdtAdLoader.Listener f109315b = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements GdtAdLoader.Listener {
        a() {
        }

        @Override // com.tencent.gdtad.aditem.GdtAdLoader.Listener
        public void onResponse(@Nullable GdtAdLoader gdtAdLoader) {
            h hVar;
            Object obj;
            if (gdtAdLoader != null && gdtAdLoader.getSession() != null) {
                e eVar = (e) f.this.f109314a.get(gdtAdLoader);
                f.this.f109314a.remove(gdtAdLoader);
                Object obj2 = null;
                if (eVar != null) {
                    hVar = eVar.f109311b;
                } else {
                    hVar = null;
                }
                if (hVar == null) {
                    QLog.e("GdtKuiklyModuleLoadAdDemoHandler", 1, "[onResponse] error, callback is null");
                    return;
                }
                try {
                    obj = GdtJsonPbUtil.pbToJson(gdtAdLoader.getSession().request);
                } catch (Throwable th5) {
                    QLog.e("GdtKuiklyModuleLoadAdDemoHandler", 1, "[onResponse] parse request failed", th5);
                    obj = null;
                }
                try {
                    obj2 = GdtJsonPbUtil.pbToJson(gdtAdLoader.getSession().response);
                } catch (Throwable th6) {
                    QLog.e("GdtKuiklyModuleLoadAdDemoHandler", 1, "[onResponse] parse response failed", th6);
                }
                JSONObject newJSONObject = AdJSONUtil.newJSONObject();
                AdJSONUtil.put(newJSONObject, "req", obj);
                AdJSONUtil.put(newJSONObject, "resp", obj2);
                QLog.i("GdtKuiklyModuleLoadAdDemoHandler", 1, "[onResponse] resp:" + obj2);
                hVar.invoke(newJSONObject);
                return;
            }
            QLog.e("GdtKuiklyModuleLoadAdDemoHandler", 1, "[onResponse] error, loader is not valid");
        }
    }
}
