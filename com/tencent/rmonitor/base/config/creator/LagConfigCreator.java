package com.tencent.rmonitor.base.config.creator;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.data.g;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.config.data.o;
import com.tencent.rmonitor.base.config.e;

/* compiled from: P */
/* loaded from: classes25.dex */
public class LagConfigCreator implements e {
    @Override // com.tencent.rmonitor.base.config.e
    public k createConfig(String str) {
        return null;
    }

    @Override // com.tencent.rmonitor.base.config.e
    public m createPluginConfig(String str) {
        if (BuglyMonitorName.LOOPER_STACK.equals(str)) {
            return new g();
        }
        if ("work_thread_lag".equals(str)) {
            return new o();
        }
        return null;
    }
}
