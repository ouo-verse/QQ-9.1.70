package org.tencwebrtc;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RTCStatsReport {
    private final Map<String, RTCStats> stats;
    private final long timestampUs;

    public RTCStatsReport(long j3, Map<String, RTCStats> map) {
        this.timestampUs = j3;
        this.stats = map;
    }

    @CalledByNative
    private static RTCStatsReport create(long j3, Map map) {
        return new RTCStatsReport(j3, map);
    }

    public Map<String, RTCStats> getStatsMap() {
        return this.stats;
    }

    public double getTimestampUs() {
        return this.timestampUs;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{ timestampUs: ");
        sb5.append(this.timestampUs);
        sb5.append(", stats: [\n");
        boolean z16 = true;
        for (RTCStats rTCStats : this.stats.values()) {
            if (!z16) {
                sb5.append(",\n");
            }
            sb5.append(rTCStats);
            z16 = false;
        }
        sb5.append(" ] }");
        return sb5.toString();
    }
}
