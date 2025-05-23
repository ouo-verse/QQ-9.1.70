package com.tencent.bugly.battery.stats;

import android.os.IBinder;
import com.tencent.bugly.battery.data.BaseBatteryInfo;
import com.tencent.bugly.battery.data.WakeLockInfo;
import com.tencent.bugly.battery.stats.AbstractStats;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class WakeLockStatsImpl extends AbstractStats {
    public WakeLockStatsImpl(long j3, long j16, long j17) {
        super(j3, j16, j17);
    }

    public BaseBatteryInfo moveToCloseNode(IBinder iBinder) {
        BaseBatteryInfo baseBatteryInfo;
        Iterator<BaseBatteryInfo> it = this.livingList.iterator();
        while (true) {
            if (it.hasNext()) {
                baseBatteryInfo = it.next();
                if ((baseBatteryInfo instanceof WakeLockInfo) && ((WakeLockInfo) baseBatteryInfo).token == iBinder) {
                    break;
                }
            } else {
                baseBatteryInfo = null;
                break;
            }
        }
        if (baseBatteryInfo == null) {
            return null;
        }
        baseBatteryInfo.endTime = System.currentTimeMillis();
        Iterator<AbstractStats.TimeRanger> it5 = this.processTimeInfo.iterator();
        while (it5.hasNext()) {
            AbstractStats.TimeRanger next = it5.next();
            if (next.startTime == baseBatteryInfo.startTime) {
                next.endTime = baseBatteryInfo.endTime;
            }
        }
        this.livingList.remove(baseBatteryInfo);
        this.closedList.add(baseBatteryInfo);
        return baseBatteryInfo;
    }
}
