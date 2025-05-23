package com.tencent.bugly.battery.stats;

import com.tencent.bugly.battery.data.BaseBatteryInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class AbstractStats {
    public long deduplicationTotalTime;
    protected long openNumLimit;
    protected long singleTimeLimit;
    protected long totalTimeLimit;
    protected ConcurrentLinkedQueue<BaseBatteryInfo> livingList = new ConcurrentLinkedQueue<>();
    protected ConcurrentLinkedQueue<BaseBatteryInfo> closedList = new ConcurrentLinkedQueue<>();
    protected ConcurrentLinkedQueue<TimeRanger> processTimeInfo = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class TimeRanger implements Comparable<TimeRanger> {
        long endTime;
        long startTime;

        public TimeRanger(long j3, long j16) {
            this.startTime = j3;
            this.endTime = j16;
        }

        @Override // java.lang.Comparable
        public int compareTo(TimeRanger timeRanger) {
            return Long.compare(this.startTime, timeRanger.startTime);
        }
    }

    public AbstractStats(long j3, long j16, long j17) {
        this.singleTimeLimit = j3;
        this.openNumLimit = j16;
        this.totalTimeLimit = j17;
    }

    private ArrayList<TimeRanger> findMixedTimeRanger(TimeRanger timeRanger, ArrayList<TimeRanger> arrayList) {
        ArrayList<TimeRanger> arrayList2 = new ArrayList<>();
        Iterator<TimeRanger> it = arrayList.iterator();
        while (it.hasNext()) {
            TimeRanger next = it.next();
            if (timeRanger.endTime > next.startTime && timeRanger.startTime < next.endTime) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    private TimeRanger getUpdatedTimeRanger(TimeRanger timeRanger, ArrayList<TimeRanger> arrayList) {
        if (arrayList.size() == 0) {
            return timeRanger;
        }
        timeRanger.startTime = Math.min(timeRanger.startTime, arrayList.get(0).startTime);
        timeRanger.endTime = Math.max(timeRanger.endTime, arrayList.get(arrayList.size() - 1).endTime);
        return timeRanger;
    }

    public void addLivingNode(BaseBatteryInfo baseBatteryInfo) {
        if (!this.livingList.contains(baseBatteryInfo)) {
            this.livingList.add(baseBatteryInfo);
        }
        Iterator<TimeRanger> it = this.processTimeInfo.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (it.next().startTime == baseBatteryInfo.startTime) {
                z16 = true;
            }
        }
        if (!z16) {
            this.processTimeInfo.add(new TimeRanger(baseBatteryInfo.startTime, 0L));
        }
    }

    public long calculateTotalTime(ArrayList<TimeRanger> arrayList) {
        int size = arrayList.size();
        ArrayList<TimeRanger> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < size; i3++) {
            TimeRanger timeRanger = arrayList.get(i3);
            ArrayList<TimeRanger> findMixedTimeRanger = findMixedTimeRanger(timeRanger, arrayList2);
            arrayList2.removeAll(findMixedTimeRanger);
            arrayList2.add(getUpdatedTimeRanger(timeRanger, findMixedTimeRanger));
            Collections.sort(arrayList2);
        }
        Iterator<TimeRanger> it = arrayList2.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            TimeRanger next = it.next();
            j3 += next.endTime - next.startTime;
        }
        return j3;
    }

    public long calculateTotalTimeInThisProcess(long j3) {
        ArrayList<TimeRanger> arrayList = new ArrayList<>();
        Iterator<TimeRanger> it = this.processTimeInfo.iterator();
        while (it.hasNext()) {
            TimeRanger next = it.next();
            TimeRanger timeRanger = new TimeRanger(next.startTime, j3);
            long j16 = next.endTime;
            if (j16 != 0) {
                timeRanger.endTime = j16;
            }
            arrayList.add(timeRanger);
        }
        return calculateTotalTime(arrayList);
    }

    public void clearExpiredNodes(long j3) {
        ArrayList arrayList = new ArrayList();
        Iterator<BaseBatteryInfo> it = this.closedList.iterator();
        while (it.hasNext()) {
            BaseBatteryInfo next = it.next();
            if (j3 - next.startTime >= 600000) {
                arrayList.add(next);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            this.closedList.remove((BaseBatteryInfo) it5.next());
        }
    }

    public ArrayList<BaseBatteryInfo> hasOpenNumExceededThreshold(long j3) {
        ArrayList<BaseBatteryInfo> arrayList = new ArrayList<>();
        Iterator<BaseBatteryInfo> it = this.livingList.iterator();
        while (it.hasNext()) {
            BaseBatteryInfo next = it.next();
            if (!next.numExpired && j3 - next.startTime < 600000) {
                arrayList.add(next);
            }
        }
        Iterator<BaseBatteryInfo> it5 = this.closedList.iterator();
        while (it5.hasNext()) {
            BaseBatteryInfo next2 = it5.next();
            if (!next2.numExpired && j3 - next2.startTime < 600000) {
                arrayList.add(next2);
            }
        }
        if (arrayList.size() > this.openNumLimit) {
            Iterator<BaseBatteryInfo> it6 = arrayList.iterator();
            while (it6.hasNext()) {
                it6.next().numExpired = true;
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    public ArrayList<BaseBatteryInfo> hasSingleTimeExpiredNodes(long j3) {
        ArrayList<BaseBatteryInfo> arrayList = new ArrayList<>();
        Iterator<BaseBatteryInfo> it = this.livingList.iterator();
        while (it.hasNext()) {
            BaseBatteryInfo next = it.next();
            if (!next.singleTimeExpired && j3 - next.startTime >= this.singleTimeLimit) {
                arrayList.add(next);
                next.singleTimeExpired = true;
            }
        }
        Iterator<BaseBatteryInfo> it5 = this.closedList.iterator();
        while (it5.hasNext()) {
            BaseBatteryInfo next2 = it5.next();
            if (!next2.singleTimeExpired && next2.endTime - next2.startTime >= this.singleTimeLimit) {
                arrayList.add(next2);
                next2.singleTimeExpired = true;
            }
        }
        return arrayList;
    }

    public ArrayList<BaseBatteryInfo> hasTotalTimeExpiredNodes(long j3) {
        ArrayList<BaseBatteryInfo> arrayList = new ArrayList<>();
        ArrayList<TimeRanger> arrayList2 = new ArrayList<>();
        Iterator<BaseBatteryInfo> it = this.livingList.iterator();
        while (it.hasNext()) {
            BaseBatteryInfo next = it.next();
            if (!next.totalTimeExpired && j3 - next.startTime < 600000) {
                arrayList.add(next);
            }
            arrayList2.add(new TimeRanger(next.startTime, j3));
        }
        Iterator<BaseBatteryInfo> it5 = this.closedList.iterator();
        while (it5.hasNext()) {
            BaseBatteryInfo next2 = it5.next();
            if (!next2.totalTimeExpired && j3 - next2.startTime < 600000) {
                arrayList.add(next2);
            }
            arrayList2.add(new TimeRanger(next2.startTime, next2.endTime));
        }
        long calculateTotalTime = calculateTotalTime(arrayList2);
        this.deduplicationTotalTime = calculateTotalTime;
        if (calculateTotalTime > this.totalTimeLimit) {
            Iterator<BaseBatteryInfo> it6 = arrayList.iterator();
            while (it6.hasNext()) {
                it6.next().totalTimeExpired = true;
            }
            return arrayList;
        }
        return new ArrayList<>();
    }
}
