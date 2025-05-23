package com.google.android.exoplayer2.drm;

import android.util.Pair;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class WidevineUtil {
    public static final String PROPERTY_LICENSE_DURATION_REMAINING = "LicenseDurationRemaining";
    public static final String PROPERTY_PLAYBACK_DURATION_REMAINING = "PlaybackDurationRemaining";

    WidevineUtil() {
    }

    private static long getDurationRemainingSec(Map<String, String> map, String str) {
        if (map != null) {
            try {
                String str2 = map.get(str);
                if (str2 != null) {
                    return Long.parseLong(str2);
                }
                return -9223372036854775807L;
            } catch (NumberFormatException unused) {
                return -9223372036854775807L;
            }
        }
        return -9223372036854775807L;
    }

    public static Pair<Long, Long> getLicenseDurationRemainingSec(DrmSession<?> drmSession) {
        Map<String, String> queryKeyStatus = drmSession.queryKeyStatus();
        if (queryKeyStatus == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(getDurationRemainingSec(queryKeyStatus, PROPERTY_LICENSE_DURATION_REMAINING)), Long.valueOf(getDurationRemainingSec(queryKeyStatus, PROPERTY_PLAYBACK_DURATION_REMAINING)));
    }
}
