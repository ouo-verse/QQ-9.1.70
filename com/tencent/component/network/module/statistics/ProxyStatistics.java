package com.tencent.component.network.module.statistics;

import android.content.Context;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.statistics.common.FixedLinkedList;
import com.tencent.component.network.utils.NetworkUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ProxyStatistics {
    private final Map<String, StatisticsUnit> mDominantUnitCache;
    private final Map<String, FixedLinkedList<StatisticsUnit>> mStatisticsCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class InstanceHolder {
        static final ProxyStatistics INSTANCE = new ProxyStatistics();

        InstanceHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class StatisticsUnit {
        public boolean allowProxy;
        public boolean apnProxy;

        public StatisticsUnit() {
            this.allowProxy = false;
            this.apnProxy = false;
            if (NetworkManager.isWap()) {
                this.allowProxy = true;
                this.apnProxy = true;
            } else {
                this.allowProxy = false;
                this.apnProxy = false;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof StatisticsUnit)) {
                return false;
            }
            StatisticsUnit statisticsUnit = (StatisticsUnit) obj;
            if (this.allowProxy == statisticsUnit.allowProxy && this.apnProxy && statisticsUnit.apnProxy) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((527 + (this.allowProxy ? 1 : 0)) * 31) + (this.apnProxy ? 1 : 0);
        }
    }

    public static ProxyStatistics getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void updateStatistics(List<StatisticsUnit> list, String str) {
        StatisticsUnit statisticsUnit;
        boolean z16;
        if (list == null) {
            return;
        }
        synchronized (this.mDominantUnitCache) {
            statisticsUnit = this.mDominantUnitCache.get(str);
            if (statisticsUnit == null) {
                statisticsUnit = new StatisticsUnit();
                this.mDominantUnitCache.put(str, statisticsUnit);
            }
        }
        boolean z17 = false;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (StatisticsUnit statisticsUnit2 : list) {
            if (statisticsUnit2 != null) {
                i3++;
                if (statisticsUnit2.allowProxy) {
                    i16++;
                }
                if (statisticsUnit2.apnProxy) {
                    i17++;
                }
            }
        }
        if (i3 > 0) {
            float f16 = i3;
            if (i16 / f16 > 0.5f) {
                z16 = true;
            } else {
                z16 = false;
            }
            statisticsUnit.allowProxy = z16;
            if (i17 / f16 > 0.5f) {
                z17 = true;
            }
            statisticsUnit.apnProxy = z17;
        }
    }

    public boolean getAPNProxy() {
        StatisticsUnit statisticsUnit;
        String apnValue = NetworkManager.getApnValue();
        synchronized (this.mDominantUnitCache) {
            statisticsUnit = this.mDominantUnitCache.get(apnValue);
            if (statisticsUnit == null) {
                statisticsUnit = new StatisticsUnit();
                this.mDominantUnitCache.put(apnValue, statisticsUnit);
            }
        }
        return statisticsUnit.apnProxy;
    }

    public boolean getAllowProxy() {
        StatisticsUnit statisticsUnit;
        String apnValue = NetworkManager.getApnValue();
        synchronized (this.mDominantUnitCache) {
            statisticsUnit = this.mDominantUnitCache.get(apnValue);
            if (statisticsUnit == null) {
                statisticsUnit = new StatisticsUnit();
                this.mDominantUnitCache.put(apnValue, statisticsUnit);
            }
        }
        return statisticsUnit.allowProxy;
    }

    public void report(Context context, boolean z16, boolean z17) {
        if (!NetworkUtils.isMobileConnected(context)) {
            return;
        }
        StatisticsUnit statisticsUnit = new StatisticsUnit();
        statisticsUnit.allowProxy = z16;
        statisticsUnit.apnProxy = z17;
        synchronized (this.mStatisticsCache) {
            String apnValue = NetworkManager.getApnValue();
            FixedLinkedList<StatisticsUnit> fixedLinkedList = this.mStatisticsCache.get(apnValue);
            if (fixedLinkedList == null) {
                fixedLinkedList = new FixedLinkedList<>(3, false);
                this.mStatisticsCache.put(apnValue, fixedLinkedList);
            }
            fixedLinkedList.add(0, statisticsUnit);
            updateStatistics(fixedLinkedList, apnValue);
        }
    }

    ProxyStatistics() {
        this.mStatisticsCache = new HashMap();
        this.mDominantUnitCache = new HashMap();
    }
}
