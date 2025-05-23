package org.light;

import java.util.Deque;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FastSeekHelper {
    public static final long SEEK_DONE = -1;
    private static final long SEEK_NOT_ACCURATE_DIFF = 50;
    private static final String TAG = "FastSeekHelper";
    private final SeekStatus seekStatus = new SeekStatus(-1, true);
    private final Deque<Long> timeStamps = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class SeekStatus {
        public boolean accurate;
        public long timestamp;

        public SeekStatus(long j3, boolean z16) {
            this.timestamp = j3;
            this.accurate = z16;
        }
    }

    public void addSeekTimestamp(long j3) {
        synchronized (this) {
            this.timeStamps.addLast(Long.valueOf(j3));
            if (this.timeStamps.size() > 2) {
                this.timeStamps.removeFirst();
            }
        }
    }

    public SeekStatus onSeekReadSample() {
        SeekStatus seekStatus;
        boolean z16;
        synchronized (this) {
            this.seekStatus.accurate = true;
            if (!this.timeStamps.isEmpty()) {
                SeekStatus seekStatus2 = this.seekStatus;
                if (this.timeStamps.size() <= 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                seekStatus2.accurate = z16;
                Long pollFirst = this.timeStamps.pollFirst();
                if (pollFirst != null) {
                    if (this.seekStatus.timestamp > pollFirst.longValue()) {
                        this.seekStatus.accurate = true;
                    }
                    this.seekStatus.timestamp = pollFirst.longValue();
                }
            }
            seekStatus = this.seekStatus;
            if (!seekStatus.accurate) {
                seekStatus.timestamp -= 50;
            }
        }
        return seekStatus;
    }

    public void reset() {
        SeekStatus seekStatus = this.seekStatus;
        seekStatus.timestamp = -1L;
        seekStatus.accurate = true;
    }
}
