package com.tencent.gdtad.util;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet;

/* compiled from: P */
/* loaded from: classes6.dex */
final class GdtVideoUtil {
    private static final String TAG = "GdtVideoUtil";
    private static volatile TPVCodecCapabilityForGet sTPVCodecCapabilityForGet;

    GdtVideoUtil() {
    }

    static TPVCodecCapabilityForGet getHevcCompatibilityInfo() {
        TPVCodecCapabilityForGet tPVCodecCapabilityForGet;
        if (sTPVCodecCapabilityForGet != null) {
            return sTPVCodecCapabilityForGet;
        }
        try {
            tPVCodecCapabilityForGet = com.tencent.superplayer.utils.e.c(172);
        } catch (Throwable th5) {
            GdtLog.e(TAG, "[getHevcCompatibilityInfo]", th5);
            tPVCodecCapabilityForGet = null;
        }
        if (tPVCodecCapabilityForGet == null) {
            GdtLog.e(TAG, "[getHevcCompatibilityInfo] error");
            return null;
        }
        if (tPVCodecCapabilityForGet.getMaxLumaSamples() != -1 && tPVCodecCapabilityForGet.getMaxFramerateFormaxLumaSamples() != -1) {
            sTPVCodecCapabilityForGet = tPVCodecCapabilityForGet;
            return sTPVCodecCapabilityForGet;
        }
        GdtLog.e(TAG, "[getHevcCompatibilityInfo] error");
        return null;
    }
}
