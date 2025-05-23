package com.tencent.bugly.battery.stats;

import android.app.PendingIntent;
import com.tencent.bugly.battery.data.BaseBatteryInfo;
import com.tencent.bugly.battery.data.LocationInfo;
import com.tencent.bugly.battery.stats.AbstractStats;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LocationStatsImpl extends AbstractStats {
    public LocationStatsImpl(long j3, long j16, long j17) {
        super(j3, j16, j17);
    }

    public BaseBatteryInfo moveToCloseNode(int i3, PendingIntent pendingIntent) {
        BaseBatteryInfo baseBatteryInfo;
        LocationInfo locationInfo;
        int i16;
        PendingIntent pendingIntent2;
        Iterator<BaseBatteryInfo> it = this.livingList.iterator();
        while (true) {
            if (it.hasNext()) {
                baseBatteryInfo = it.next();
                if ((baseBatteryInfo instanceof LocationInfo) && (((i16 = (locationInfo = (LocationInfo) baseBatteryInfo).locationListener) != 0 && i16 == i3) || ((pendingIntent2 = locationInfo.pendingIntent) != null && pendingIntent2 == pendingIntent))) {
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
