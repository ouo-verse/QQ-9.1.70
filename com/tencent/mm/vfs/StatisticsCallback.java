package com.tencent.mm.vfs;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface StatisticsCallback {
    public static final int PHASE_MAINTENANCE = 2;
    public static final int PHASE_MAINTENANCE_BEGIN = 1;
    public static final int PHASE_MAINTENANCE_CANCELLED = 4;
    public static final int PHASE_MAINTENANCE_END = 3;
    public static final int PHASE_MAINTENANCE_FAILURE = 5;
    public static final int PHASE_MAINTENANCE_FAST = 7;
    public static final int PHASE_MAINTENANCE_SKIPPED = 6;

    void deleteFiles(CancellationSignalCompat cancellationSignalCompat);

    void reportError(Throwable th5);

    void statistics(String str, int i3, Map<String, Object> map);
}
