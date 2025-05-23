package com.tencent.bugly.traffic.statistic;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MobileFrontendStatistic extends AbstractTrafficStatistic {
    @Override // com.tencent.bugly.traffic.statistic.AbstractTrafficStatistic
    public int getFrontState() {
        return 1;
    }

    @Override // com.tencent.bugly.traffic.statistic.AbstractTrafficStatistic
    public int getNetworkState() {
        return 2;
    }
}
