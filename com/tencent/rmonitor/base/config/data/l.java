package com.tencent.rmonitor.base.config.data;

import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.rmonitor.common.logger.LogState;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public float f365318a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, m> f365319b = new ConcurrentHashMap<>(10);

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, k> f365320c = new ConcurrentHashMap<>(3);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a(String str) {
        if (Logger.f365497g.f() < LogState.INFO.getValue()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(300);
        sb5.append("dump for ");
        sb5.append(str);
        sb5.append(", {");
        try {
            Iterator<Map.Entry<String, m>> it = this.f365319b.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                m value = it.next().getValue();
                if (i3 > 0) {
                    sb5.append(", ");
                }
                sb5.append(value.name);
                sb5.append(":");
                sb5.append(value.enabled);
                i3++;
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_config", th5);
        }
        sb5.append("}");
        Logger.f365497g.i("RMonitor_config", sb5.toString());
    }

    public k b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        k kVar = this.f365320c.get(str);
        if (kVar == null && (kVar = ConfigCreatorProxy.d().createConfig(str)) != null) {
            this.f365320c.put(str, kVar);
        }
        if (kVar == null) {
            return c(str);
        }
        return kVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public m c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        m mVar = this.f365319b.get(str);
        if (mVar == null && (mVar = ConfigCreatorProxy.d().createPluginConfig(str)) != null) {
            this.f365319b.put(str, mVar);
        }
        if (mVar == null) {
            Logger.f365497g.d("RMonitor_config", "getPluginConfig, pluginName: " + str + " with null config");
        }
        return mVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<String> d(List<String> list) {
        ArrayList arrayList = null;
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                m c16 = c(it.next());
                if (c16 != null && c16.enabled) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c16.name);
                }
            }
        }
        return arrayList;
    }
}
