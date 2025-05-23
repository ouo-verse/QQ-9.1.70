package com.tencent.bugly.battery.stats;

import android.app.AlarmManager;
import android.app.PendingIntent;
import com.tencent.bugly.battery.data.AlarmInfo;
import com.tencent.bugly.battery.data.BaseBatteryInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AlarmStatsImpl {
    protected long openNumLimit;
    protected long openWakeUpNumLimit;
    protected ConcurrentLinkedQueue<BaseBatteryInfo> livingList = new ConcurrentLinkedQueue<>();
    protected ConcurrentLinkedQueue<BaseBatteryInfo> closedList = new ConcurrentLinkedQueue<>();
    protected ConcurrentLinkedQueue<BaseBatteryInfo> livingWakeUpList = new ConcurrentLinkedQueue<>();
    protected ConcurrentLinkedQueue<BaseBatteryInfo> closedWakeUpList = new ConcurrentLinkedQueue<>();

    public AlarmStatsImpl(long j3, long j16) {
        this.openNumLimit = j3;
        this.openWakeUpNumLimit = j16;
    }

    private void clearExpiredNodesInternal(long j3, ConcurrentLinkedQueue<BaseBatteryInfo> concurrentLinkedQueue) {
        ArrayList arrayList = new ArrayList();
        Iterator<BaseBatteryInfo> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            BaseBatteryInfo next = it.next();
            if (j3 - ((AlarmInfo) next).triggerAtMillis >= 600000) {
                arrayList.add(next);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            concurrentLinkedQueue.remove((BaseBatteryInfo) it5.next());
        }
    }

    private BaseBatteryInfo findNode(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener, ConcurrentLinkedQueue<BaseBatteryInfo> concurrentLinkedQueue) {
        Iterator<BaseBatteryInfo> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            BaseBatteryInfo next = it.next();
            if (next instanceof AlarmInfo) {
                AlarmInfo alarmInfo = (AlarmInfo) next;
                PendingIntent pendingIntent2 = alarmInfo.operation;
                if (pendingIntent2 == null || pendingIntent2 != pendingIntent) {
                    AlarmManager.OnAlarmListener onAlarmListener2 = alarmInfo.onAlarmListener;
                    if (onAlarmListener2 != null && onAlarmListener2 == onAlarmListener) {
                        return next;
                    }
                } else {
                    return next;
                }
            }
        }
        return null;
    }

    private boolean isWakedInPeriod(AlarmInfo alarmInfo, long j3, ConcurrentLinkedQueue<BaseBatteryInfo> concurrentLinkedQueue, ConcurrentLinkedQueue<BaseBatteryInfo> concurrentLinkedQueue2) {
        if (concurrentLinkedQueue2.contains(alarmInfo)) {
            long j16 = alarmInfo.endTime;
            long j17 = alarmInfo.triggerAtMillis;
            if (j16 > j17 && j3 - j17 < 600000 && !alarmInfo.numExpired) {
                return true;
            }
        }
        if (concurrentLinkedQueue.contains(alarmInfo)) {
            long j18 = alarmInfo.triggerAtMillis;
            if (j18 < j3 && j3 - j18 < 600000 && !alarmInfo.numExpired) {
                return true;
            }
        }
        return false;
    }

    private void markNodeExpired(ArrayList<BaseBatteryInfo> arrayList) {
        Iterator<BaseBatteryInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().numExpired = true;
        }
    }

    public void addLivingNode(BaseBatteryInfo baseBatteryInfo) {
        int i3 = ((AlarmInfo) baseBatteryInfo).type;
        if (i3 != 0 && i3 != 2) {
            if (!this.livingList.contains(baseBatteryInfo)) {
                this.livingList.add(baseBatteryInfo);
            }
        } else if (!this.livingWakeUpList.contains(baseBatteryInfo)) {
            this.livingWakeUpList.add(baseBatteryInfo);
        }
    }

    public void clearExpiredNodes(long j3) {
        clearExpiredNodesInternal(j3, this.livingList);
        clearExpiredNodesInternal(j3, this.closedList);
        clearExpiredNodesInternal(j3, this.livingWakeUpList);
        clearExpiredNodesInternal(j3, this.closedWakeUpList);
    }

    public ArrayList<BaseBatteryInfo> hasAlarmNumExceeded(long j3) {
        ArrayList<BaseBatteryInfo> arrayList = new ArrayList<>();
        Iterator<BaseBatteryInfo> it = this.livingList.iterator();
        while (it.hasNext()) {
            BaseBatteryInfo next = it.next();
            if (isWakedInPeriod((AlarmInfo) next, j3, this.livingList, this.closedList)) {
                arrayList.add(next);
            }
        }
        Iterator<BaseBatteryInfo> it5 = this.closedList.iterator();
        while (it5.hasNext()) {
            BaseBatteryInfo next2 = it5.next();
            if (isWakedInPeriod((AlarmInfo) next2, j3, this.livingList, this.closedList)) {
                arrayList.add(next2);
            }
        }
        if (arrayList.size() > this.openNumLimit) {
            markNodeExpired(arrayList);
            return arrayList;
        }
        return new ArrayList<>();
    }

    public ArrayList<BaseBatteryInfo> hasWakeUpAlarmNumExceeded(long j3) {
        ArrayList<BaseBatteryInfo> arrayList = new ArrayList<>();
        Iterator<BaseBatteryInfo> it = this.livingWakeUpList.iterator();
        while (it.hasNext()) {
            BaseBatteryInfo next = it.next();
            if (isWakedInPeriod((AlarmInfo) next, j3, this.livingWakeUpList, this.closedWakeUpList)) {
                arrayList.add(next);
            }
        }
        Iterator<BaseBatteryInfo> it5 = this.closedWakeUpList.iterator();
        while (it5.hasNext()) {
            BaseBatteryInfo next2 = it5.next();
            if (isWakedInPeriod((AlarmInfo) next2, j3, this.livingWakeUpList, this.closedWakeUpList)) {
                arrayList.add(next2);
            }
        }
        if (arrayList.size() > this.openWakeUpNumLimit) {
            markNodeExpired(arrayList);
            return arrayList;
        }
        return new ArrayList<>();
    }

    public void moveToCloseNode(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
        BaseBatteryInfo findNode = findNode(pendingIntent, onAlarmListener, this.livingList);
        if (findNode != null) {
            findNode.endTime = System.currentTimeMillis();
            this.livingList.remove(findNode);
            this.closedList.add(findNode);
        } else {
            BaseBatteryInfo findNode2 = findNode(pendingIntent, onAlarmListener, this.livingWakeUpList);
            if (findNode2 != null) {
                findNode2.endTime = System.currentTimeMillis();
                this.livingWakeUpList.remove(findNode2);
                this.closedWakeUpList.add(findNode2);
            }
        }
    }
}
