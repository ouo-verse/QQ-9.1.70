package com.tencent.biz.richframework.network.util;

import android.util.Pair;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VSNetworkSpeedTest {
    private static final long LOG_RUNNABLE_DELAY = 5000;
    public static final String NETWORK_SPEED_LOG_INTERVAL = "rfw_newwork_speed_log_interval";
    private static final double RATE_ALL_FAILED = 0.0d;
    private static final double RATE_ALL_SUCCEED = 1.0d;
    private static final double RATE_UNKNOWN = -1.0d;
    private static final String TAG = "VSNetworkSpeedTest";
    private static final long TEST_SPEED_INTERVAL = 10000;
    private static volatile long sTestSpeedInterval = -1;
    private final Queue<NetworkEvent> mNetworkEvents = new ConcurrentLinkedQueue();
    private NetworkEvent mLastEvent = null;
    private final List<NetworkEventListener> mNetworkEventListeners = new CopyOnWriteArrayList();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class NetworkEvent {
        public boolean isSuccess;
        public long requestCost;
        public long timestamp = System.currentTimeMillis();
        public String type;

        NetworkEvent(String str, boolean z16) {
            this.type = str;
            this.isSuccess = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface NetworkEventListener {
        void onNewEvent(NetworkEvent networkEvent);
    }

    private void dispatchNetWorkEvent(NetworkEvent networkEvent) {
        for (int i3 = 0; i3 < this.mNetworkEventListeners.size(); i3++) {
            NetworkEventListener networkEventListener = this.mNetworkEventListeners.get(i3);
            if (networkEventListener != null) {
                networkEventListener.onNewEvent(networkEvent);
            }
        }
    }

    private static long getConfigSpeedInterval() {
        return RFWConfig.getConfigValue(NETWORK_SPEED_LOG_INTERVAL, 5000L);
    }

    private static long getTestSpeedInterval() {
        if (sTestSpeedInterval == -1) {
            sTestSpeedInterval = getConfigSpeedInterval();
        }
        return sTestSpeedInterval;
    }

    private void removeTimeoutEvent() {
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.mNetworkEvents.isEmpty()) {
            NetworkEvent peek = this.mNetworkEvents.peek();
            if (peek != null) {
                if (currentTimeMillis - peek.timestamp > getTestSpeedInterval()) {
                    this.mNetworkEvents.poll();
                } else {
                    return;
                }
            }
        }
    }

    public void collectNetWorkError(String str) {
        NetworkEvent networkEvent = new NetworkEvent(str, false);
        this.mNetworkEvents.add(networkEvent);
        this.mLastEvent = networkEvent;
        removeTimeoutEvent();
        dispatchNetWorkEvent(networkEvent);
    }

    public void collectNetWorkSucceed(String str, long j3) {
        NetworkEvent networkEvent = new NetworkEvent(str, true);
        networkEvent.requestCost = j3;
        this.mNetworkEvents.add(networkEvent);
        this.mLastEvent = networkEvent;
        removeTimeoutEvent();
        dispatchNetWorkEvent(networkEvent);
    }

    public Pair<Double, Double> getSpeedAndSucceedRate() {
        removeTimeoutEvent();
        if (this.mNetworkEvents.isEmpty()) {
            NetworkEvent networkEvent = this.mLastEvent;
            if (networkEvent == null) {
                return new Pair<>(Double.valueOf(-1.0d), Double.valueOf(-1.0d));
            }
            if (networkEvent.isSuccess) {
                return new Pair<>(Double.valueOf(networkEvent.requestCost), Double.valueOf(1.0d));
            }
            return new Pair<>(Double.valueOf(-1.0d), Double.valueOf(RATE_ALL_FAILED));
        }
        int i3 = 0;
        long j3 = 0;
        for (NetworkEvent networkEvent2 : this.mNetworkEvents) {
            if (networkEvent2.isSuccess) {
                i3++;
                j3 += networkEvent2.requestCost;
            }
        }
        return new Pair<>(Double.valueOf(j3 / this.mNetworkEvents.size()), Double.valueOf(i3 / this.mNetworkEvents.size()));
    }

    public void registerNetWorkEventListener(NetworkEventListener networkEventListener) {
        this.mNetworkEventListeners.add(networkEventListener);
    }

    public void unregisterNetWorkEventListener(NetworkEventListener networkEventListener) {
        this.mNetworkEventListeners.remove(networkEventListener);
    }
}
