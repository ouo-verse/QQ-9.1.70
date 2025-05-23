package com.tencent.tav.decoder;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SeekTimeStore {
    public static volatile boolean ENABLE = true;
    private static volatile long lastSeekTime;

    public static synchronized void clean() {
        synchronized (SeekTimeStore.class) {
            lastSeekTime = 0L;
        }
    }

    public static synchronized int compareNewSeekTime(long j3) {
        int i3;
        synchronized (SeekTimeStore.class) {
            if (ENABLE && lastSeekTime != 0) {
                i3 = (int) (j3 - lastSeekTime);
            } else {
                i3 = 0;
            }
        }
        return i3;
    }

    public static long getLastSeekTime() {
        return lastSeekTime;
    }

    public static synchronized void updateSeekTime(long j3) {
        synchronized (SeekTimeStore.class) {
            lastSeekTime = j3;
        }
    }
}
