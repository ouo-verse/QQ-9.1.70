package com.tencent.tavkit.utils;

import androidx.annotation.NonNull;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Utils {
    public static boolean containsTime(@NonNull CMTime cMTime, TAVAudioConfiguration.VolumeEdge volumeEdge) {
        if (volumeEdge == null) {
            return false;
        }
        return containsTime(cMTime, volumeEdge.getTimeRange());
    }

    public static float getEdgeVolumeByTime(@NonNull CMTime cMTime, TAVAudioConfiguration.VolumeEdge volumeEdge, float f16) {
        return f16 * volumeEdge.getVolume(cMTime.sub(volumeEdge.getTimeRange().getStart()));
    }

    public static Float getEdgesVolume(@NonNull CMTime cMTime, List<TAVAudioConfiguration.VolumeEdge> list, float f16) {
        for (TAVAudioConfiguration.VolumeEdge volumeEdge : list) {
            if (containsTime(cMTime, volumeEdge)) {
                return Float.valueOf(getEdgeVolumeByTime(cMTime, volumeEdge, f16));
            }
        }
        return null;
    }

    public static boolean isRectValid(CGRect cGRect) {
        if (cGRect != null && isSizeValid(cGRect.size)) {
            return true;
        }
        return false;
    }

    public static boolean isSizeValid(CGSize cGSize) {
        if (cGSize != null && cGSize.width != 0.0f && cGSize.height != 0.0f) {
            return true;
        }
        return false;
    }

    private static boolean containsTime(@NonNull CMTime cMTime, CMTimeRange cMTimeRange) {
        if (cMTimeRange == null) {
            return false;
        }
        return cMTimeRange.containsTime(cMTime);
    }
}
