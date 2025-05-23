package com.tencent.tavkit.report;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FilterChainReportSession {

    @Nullable
    private static IReporter reporter;
    private Map<String, TimeConsumer> timeConsumerMap = new HashMap();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IReporter {
        void onCommit(Map<String, Long> map);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class TimeConsumer {
        private final String key;
        private long totalUs = 0;
        private long count = 0;

        public TimeConsumer(String str) {
            this.key = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getAvgTimeUs() {
            long j3 = this.count;
            if (j3 == 0) {
                return 0L;
            }
            return this.totalUs / j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tick(long j3) {
            this.totalUs += j3;
            this.count++;
        }
    }

    public static synchronized void setReporter(@Nullable IReporter iReporter) {
        synchronized (FilterChainReportSession.class) {
            reporter = iReporter;
        }
    }

    public void commit() {
        HashMap hashMap = new HashMap();
        for (TimeConsumer timeConsumer : this.timeConsumerMap.values()) {
            if (timeConsumer != null) {
                hashMap.put(timeConsumer.key, Long.valueOf(timeConsumer.getAvgTimeUs()));
            }
        }
        synchronized (FilterChainReportSession.class) {
            IReporter iReporter = reporter;
            if (iReporter != null) {
                iReporter.onCommit(hashMap);
            }
        }
    }

    public void tick(String str, long j3) {
        TimeConsumer timeConsumer = this.timeConsumerMap.get(str);
        if (timeConsumer == null) {
            timeConsumer = new TimeConsumer(str);
            this.timeConsumerMap.put(timeConsumer.key, timeConsumer);
        }
        timeConsumer.tick(j3 / 1000);
    }
}
