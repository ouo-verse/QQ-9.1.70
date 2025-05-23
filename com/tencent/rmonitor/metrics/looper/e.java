package com.tencent.rmonitor.metrics.looper;

import com.tencent.rmonitor.base.meta.DropFrameResultMeta;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {
    private static boolean a(long[] jArr) {
        for (long j3 : jArr) {
            if (j3 < 0) {
                return true;
            }
        }
        return false;
    }

    public static int b(DropFrameResultMeta dropFrameResultMeta) {
        int i3;
        if (dropFrameResultMeta == null || e(dropFrameResultMeta, 500L)) {
            return 1;
        }
        if (f(dropFrameResultMeta.refreshCount) <= 0) {
            i3 = 64;
        } else {
            i3 = 0;
        }
        if (f(dropFrameResultMeta.refreshDuration) <= 0) {
            return i3 | 128;
        }
        return i3;
    }

    public static int c(DropFrameResultMeta dropFrameResultMeta) {
        if (dropFrameResultMeta == null || e(dropFrameResultMeta, 10L)) {
            return 1;
        }
        int d16 = d(dropFrameResultMeta);
        if (dropFrameResultMeta.totalDuration > 43200000) {
            d16 |= 2;
        }
        if (f(dropFrameResultMeta.refreshDuration) > dropFrameResultMeta.totalDuration) {
            return d16 | 128;
        }
        return d16;
    }

    private static int d(DropFrameResultMeta dropFrameResultMeta) {
        int i3;
        if (dropFrameResultMeta.suspendDuration < 0) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        if (dropFrameResultMeta.hitchesDuration < 0) {
            i3 |= 8;
        }
        if (a(dropFrameResultMeta.refreshCount)) {
            i3 |= 16;
        }
        if (a(dropFrameResultMeta.refreshDuration)) {
            return i3 | 32;
        }
        return i3;
    }

    private static boolean e(@NotNull DropFrameResultMeta dropFrameResultMeta, long j3) {
        long j16 = dropFrameResultMeta.totalDuration;
        if (j16 >= j3 && j16 >= dropFrameResultMeta.suspendDuration && j16 >= dropFrameResultMeta.hitchesDuration) {
            return false;
        }
        return true;
    }

    private static long f(long[] jArr) {
        long j3 = 0;
        for (long j16 : jArr) {
            j3 += j16;
        }
        return j3;
    }
}
