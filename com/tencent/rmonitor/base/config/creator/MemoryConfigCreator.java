package com.tencent.rmonitor.base.config.creator;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.data.NatMemPluginConfig;
import com.tencent.rmonitor.base.config.data.c;
import com.tencent.rmonitor.base.config.data.h;
import com.tencent.rmonitor.base.config.data.i;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.config.e;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MemoryConfigCreator implements e {
    @Override // com.tencent.rmonitor.base.config.e
    public k createConfig(String str) {
        return null;
    }

    @Override // com.tencent.rmonitor.base.config.e
    public m createPluginConfig(String str) {
        if (BuglyMonitorName.MEMORY_JAVA_CEILING.equals(str)) {
            return new h();
        }
        if (BuglyMonitorName.MEMORY_BIG_BITMAP.equals(str)) {
            return new m(BuglyMonitorName.MEMORY_BIG_BITMAP, false, 100, 0.0f, 150);
        }
        if (BuglyMonitorName.MEMORY_JAVA_LEAK.equals(str)) {
            return new i();
        }
        if (BuglyMonitorName.FD_ANALYZE.equals(str)) {
            return new com.tencent.rmonitor.base.config.data.e();
        }
        if (BuglyMonitorName.NATIVE_MEMORY_ANALYZE.equals(str)) {
            return new NatMemPluginConfig();
        }
        if (BuglyMonitorName.ASAN.equals(str)) {
            return new c();
        }
        return null;
    }
}
