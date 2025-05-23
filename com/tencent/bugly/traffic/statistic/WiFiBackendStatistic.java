package com.tencent.bugly.traffic.statistic;

/* compiled from: P */
/* loaded from: classes5.dex */
public class WiFiBackendStatistic extends AbstractTrafficStatistic {
    @Override // com.tencent.bugly.traffic.statistic.AbstractTrafficStatistic
    public int getFrontState() {
        return 2;
    }

    @Override // com.tencent.bugly.traffic.statistic.AbstractTrafficStatistic
    public int getNetworkState() {
        return 1;
    }
}
