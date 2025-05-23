package com.qq.e.comm.util;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TimeRecorder {
    private ConcurrentHashMap<String, Long> mRecordList;
    private volatile long mStart;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        private static TimeRecorder sInstance = new TimeRecorder();

        Holder() {
        }
    }

    TimeRecorder() {
        this.mStart = 0L;
        this.mRecordList = new ConcurrentHashMap<>();
    }

    public static TimeRecorder getInstance() {
        return Holder.sInstance;
    }

    public void clear() {
        this.mRecordList.clear();
    }

    public long costFrom(String str) {
        if (this.mRecordList.containsKey(str) && this.mRecordList.get(str) != null) {
            return System.currentTimeMillis() - this.mRecordList.get(str).longValue();
        }
        GDTLogger.e("compute cost time fail because of invalid flag");
        return 0L;
    }

    public long costFromStart() {
        return System.currentTimeMillis() - this.mStart;
    }

    public void record(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Splash record fail because of invalid flag");
        } else {
            this.mRecordList.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void start() {
        this.mStart = System.currentTimeMillis();
    }
}
