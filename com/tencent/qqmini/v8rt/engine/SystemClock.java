package com.tencent.qqmini.v8rt.engine;

/* compiled from: P */
/* loaded from: classes23.dex */
final class SystemClock {
    private static SystemClock sInstance = new SystemClock();

    SystemClock() {
    }

    public static SystemClock g() {
        return sInstance;
    }

    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    public void sleep(long j3) {
        android.os.SystemClock.sleep(j3);
    }

    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }
}
