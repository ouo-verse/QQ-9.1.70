package com.tencent.rfix.loader.track;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.rfix.loader.log.RFixLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TimeTracker {
    private static final String TAG = "RFix.TimeTracker";
    private static final HashMap<TimeTrackType, Long> beginTracks = new HashMap<>();
    private static final HashMap<TimeTrackType, Long> endTracks = new HashMap<>();
    private static final HashMap<TimeTrackType, Long> recordTracks = new HashMap<>();

    public static synchronized void beginTrack(TimeTrackType timeTrackType) {
        synchronized (TimeTracker.class) {
            beginTracks.put(timeTrackType, Long.valueOf(System.nanoTime()));
        }
    }

    public static synchronized void endTrack(TimeTrackType timeTrackType) {
        synchronized (TimeTracker.class) {
            endTracks.put(timeTrackType, Long.valueOf(System.nanoTime()));
        }
    }

    public static synchronized long getTrackTimeMillis(TimeTrackType timeTrackType) {
        synchronized (TimeTracker.class) {
            Long l3 = beginTracks.get(timeTrackType);
            Long l16 = endTracks.get(timeTrackType);
            if (l3 != null && l16 != null) {
                return TimeUnit.NANOSECONDS.toMillis(l16.longValue() - l3.longValue());
            }
            Long l17 = recordTracks.get(timeTrackType);
            if (l17 != null) {
                return l17.longValue();
            }
            return -1L;
        }
    }

    public static synchronized void printTrackTimes() {
        synchronized (TimeTracker.class) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\nRFix Time Track:\n");
            ArrayList<TimeTrackType> arrayList = new ArrayList();
            arrayList.addAll(beginTracks.keySet());
            arrayList.addAll(recordTracks.keySet());
            Collections.sort(arrayList);
            for (TimeTrackType timeTrackType : arrayList) {
                sb5.append(timeTrackType);
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(getTrackTimeMillis(timeTrackType));
                sb5.append("ms\n");
            }
            RFixLog.d(TAG, sb5.toString());
        }
    }

    public static synchronized void recordTrack(TimeTrackType timeTrackType, long j3) {
        synchronized (TimeTracker.class) {
            recordTracks.put(timeTrackType, Long.valueOf(j3));
        }
    }
}
