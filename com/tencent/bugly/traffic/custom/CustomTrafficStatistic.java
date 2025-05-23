package com.tencent.bugly.traffic.custom;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CustomTrafficStatistic {
    private static final int HTTP_MONITOR_REPORT_THRESHOLD = 60000;
    private static final int QUEUELEN = 100;
    private static final String TAG = "CustomTrafficStatistic";
    private static boolean canMonitor = false;
    static volatile boolean hasReport = false;
    private static volatile CustomTrafficStatistic instance;
    private final ConcurrentLinkedQueue<SocketInfo> httpQueue = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<SocketInfo> socketQueue = new ConcurrentLinkedQueue<>();

    public static CustomTrafficStatistic getInstance() {
        if (instance == null) {
            synchronized (CustomTrafficStatistic.class) {
                if (instance == null) {
                    instance = new CustomTrafficStatistic();
                }
            }
        }
        canMonitor = ConfigProxy.INSTANCE.getConfig().i(BuglyMonitorName.TRAFFIC_DETAIL).com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.enabled;
        return instance;
    }

    public void addHttpToQueue(SocketInfo socketInfo) {
        if (!canMonitor) {
            Logger.f365497g.i(TAG, "addHttpToQueue failed");
        } else {
            this.httpQueue.add(socketInfo);
        }
    }

    public ConcurrentLinkedQueue<SocketInfo> getHttpQueue() {
        return this.httpQueue;
    }

    public ConcurrentLinkedQueue<SocketInfo> getSocketToQueue() {
        return this.socketQueue;
    }
}
