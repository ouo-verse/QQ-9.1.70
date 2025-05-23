package com.tencent.rmonitor.base.config.creator;

import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.rmonitor.base.config.data.a;
import com.tencent.rmonitor.base.config.data.f;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.config.data.n;
import com.tencent.rmonitor.base.config.e;
import java.util.HashMap;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class DefaultConfigCreator implements e {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, m> f365299a = new HashMap<>(12);

    private m a(String str) {
        if (this.f365299a.size() == 0) {
            b();
        }
        return this.f365299a.get(str);
    }

    private void b() {
        this.f365299a.put("list_metric", new f("list_metric"));
        this.f365299a.put(BuglyMonitorName.FLUENCY_METRIC, new f(BuglyMonitorName.FLUENCY_METRIC));
        this.f365299a.put(BuglyMonitorName.MEMORY_METRIC, new m(BuglyMonitorName.MEMORY_METRIC, false, 100, 0.001f));
        this.f365299a.put(BuglyMonitorName.MEMORY_METRIC_OF_SUB_PROCESS, new m(BuglyMonitorName.MEMORY_METRIC_OF_SUB_PROCESS, false, 100, 0.001f));
        this.f365299a.put(BuglyMonitorName.LAUNCH, new a());
        this.f365299a.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, new m(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, false, 10, 0.1f));
        this.f365299a.put("io", new m("io", false, 10, 0.1f));
        this.f365299a.put("battery", new m("battery", false, 10, 0.1f));
        this.f365299a.put("device", new m("device", false, 1, 0.001f));
        this.f365299a.put(BuglyMonitorName.TRAFFIC, new m(BuglyMonitorName.TRAFFIC, false, 1000, 0.5f, 0.0f, 100));
        this.f365299a.put(BuglyMonitorName.BATTERY_ELEMENT_METRIC, new m(BuglyMonitorName.BATTERY_ELEMENT_METRIC, false, 1000, 0.5f, 0.0f, 100));
        this.f365299a.put(BuglyMonitorName.BATTERY_METRIC, new m(BuglyMonitorName.BATTERY_METRIC, false, 1000, 0.5f, 0.0f, 1));
        this.f365299a.put(BuglyMonitorName.PAGE_LAUNCH, new m(BuglyMonitorName.PAGE_LAUNCH, false, 1000, 0.0f, 0.5f, 1));
    }

    @Override // com.tencent.rmonitor.base.config.e
    public k createConfig(String str) {
        if (k.ATTA_CONFIG_KEY.equals(str)) {
            return new com.tencent.rmonitor.sla.a();
        }
        if ("safe_mode".equals(str)) {
            return new n();
        }
        return null;
    }

    @Override // com.tencent.rmonitor.base.config.e
    public m createPluginConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        m a16 = a(str);
        if (a16 != null) {
            return a16.mo105clone();
        }
        return a16;
    }
}
