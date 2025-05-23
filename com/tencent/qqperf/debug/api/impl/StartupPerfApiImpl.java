package com.tencent.qqperf.debug.api.impl;

import com.tencent.mobileqq.startup.a;
import com.tencent.qqperf.debug.api.IStartupPerfApi;

/* loaded from: classes25.dex */
public class StartupPerfApiImpl implements IStartupPerfApi {
    @Override // com.tencent.qqperf.debug.api.IStartupPerfApi
    public long getShowCostTime() {
        return a.f289665f;
    }

    @Override // com.tencent.qqperf.debug.api.IStartupPerfApi
    public double getSyncMsgTime() {
        return a.f289666g;
    }
}
