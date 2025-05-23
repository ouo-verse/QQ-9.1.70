package com.tencent.bugly.traffic.statistic;

import com.tencent.bugly.traffic.TrafficMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class AbstractTrafficStatistic {
    protected long autoSize;
    protected long customSize;
    protected HashMap<String, TrafficMsg> autoMaps = new HashMap<>();
    protected HashMap<String, TrafficMsg> customMaps = new HashMap<>();

    private void processAutoType(TrafficMsg trafficMsg) {
        this.autoSize = this.autoSize + trafficMsg.mRx + trafficMsg.mTx;
        if (!this.autoMaps.containsKey(trafficMsg.mHost)) {
            this.autoMaps.put(trafficMsg.mHost, new TrafficMsg(trafficMsg));
            return;
        }
        TrafficMsg trafficMsg2 = this.autoMaps.get(trafficMsg.mHost);
        if (trafficMsg2 != null) {
            trafficMsg2.mRx += trafficMsg.mRx;
            trafficMsg2.mTx += trafficMsg.mTx;
            this.autoMaps.put(trafficMsg.mHost, trafficMsg2);
        }
    }

    private void processCustomType(TrafficMsg trafficMsg) {
        this.customSize = this.customSize + trafficMsg.mRx + trafficMsg.mTx;
        if (!this.customMaps.containsKey(trafficMsg.mHost)) {
            this.customMaps.put(trafficMsg.mHost, new TrafficMsg(trafficMsg));
            return;
        }
        TrafficMsg trafficMsg2 = this.customMaps.get(trafficMsg.mHost);
        if (trafficMsg2 != null) {
            trafficMsg2.mRx += trafficMsg.mRx;
            trafficMsg2.mTx += trafficMsg.mTx;
            this.customMaps.put(trafficMsg.mHost, trafficMsg2);
        }
    }

    private void processInternal(ArrayList<TrafficMsg> arrayList) {
        Iterator<TrafficMsg> it = arrayList.iterator();
        while (it.hasNext()) {
            TrafficMsg next = it.next();
            if (next.mCollectType.equalsIgnoreCase("auto") && next.mFore == getFrontState() && next.mNet == getNetworkState()) {
                processAutoType(next);
            } else if (next.mCollectType.equalsIgnoreCase("custom") && next.mFore == getFrontState() && next.mNet == getNetworkState()) {
                processCustomType(next);
            }
        }
    }

    public void clear() {
        this.autoMaps.clear();
        this.customMaps.clear();
        this.autoSize = 0L;
        this.customSize = 0L;
    }

    public Map<String, TrafficMsg> getAutoMaps() {
        return this.autoMaps;
    }

    public long getAutoSize() {
        return this.autoSize;
    }

    public Map<String, TrafficMsg> getCustomMaps() {
        return this.customMaps;
    }

    public long getCustomSize() {
        return this.customSize;
    }

    public int getFrontState() {
        return -1;
    }

    public int getNetworkState() {
        return -1;
    }

    public void process(ArrayList<TrafficMsg> arrayList) {
        clear();
        processInternal(arrayList);
    }
}
