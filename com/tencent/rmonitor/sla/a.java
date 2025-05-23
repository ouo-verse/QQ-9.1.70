package com.tencent.rmonitor.sla;

import android.text.TextUtils;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends k {

    /* renamed from: m, reason: collision with root package name */
    private final ConcurrentHashMap<String, Float> f365841m;

    public a() {
        ConcurrentHashMap<String, Float> concurrentHashMap = new ConcurrentHashMap<>();
        this.f365841m = concurrentHashMap;
        concurrentHashMap.put("default", Float.valueOf(0.0f));
    }

    public float b(String str) {
        float f16;
        Float f17;
        Float f18 = this.f365841m.get("default");
        if (f18 != null) {
            f16 = f18.floatValue();
        } else {
            f16 = 0.0f;
        }
        if (!TextUtils.isEmpty(str) && (f17 = this.f365841m.get(str)) != null) {
            return f17.floatValue();
        }
        return f16;
    }

    public void c(a aVar) {
        this.f365841m.clear();
        this.f365841m.putAll(aVar.f365841m);
    }

    @Override // com.tencent.rmonitor.base.config.data.k
    public String getName() {
        return k.ATTA_CONFIG_KEY;
    }

    @Override // com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                float f16 = (float) jSONObject.getDouble(str);
                if (f16 > 1.0d) {
                    f16 = 1.0f;
                } else if (f16 < 0.0f) {
                    f16 = 0.0f;
                }
                this.f365841m.put(str, Float.valueOf(f16));
            } catch (JSONException e16) {
                Logger.f365497g.e("RMonitor_config_atta", "parse, attaEvent: " + str + ", e: " + e16);
            }
        }
    }
}
