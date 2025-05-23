package com.tencent.rmonitor.base.config.creator;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.bugly.network.NetQualityPluginConfig;
import com.tencent.rmonitor.base.config.data.TrafficDetailPluginConfig;
import com.tencent.rmonitor.base.config.data.d;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.config.e;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ResourceConfigCreator implements e {
    @Override // com.tencent.rmonitor.base.config.e
    public k createConfig(String str) {
        return null;
    }

    @Override // com.tencent.rmonitor.base.config.e
    public m createPluginConfig(String str) {
        if (BuglyMonitorName.TRAFFIC_DETAIL.equals(str)) {
            return new TrafficDetailPluginConfig();
        }
        if (BuglyMonitorName.NET_QUALITY.equals(str)) {
            return new NetQualityPluginConfig();
        }
        if (BuglyMonitorName.BATTERY_ELEMENT.equals(str)) {
            return new d();
        }
        return null;
    }
}
