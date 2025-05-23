package com.tencent.thumbplayer.report.reportv2;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.common.log.TPLogUtil;

/* loaded from: classes26.dex */
public class TPReporterFactory {
    private static final String TAG = "TPReporterFactory";

    @Nullable
    public static ITPReporter createReporterWithType(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    TPLogUtil.e(TAG, "Type is not match ReporterType, return null");
                    return null;
                }
                return new TPPrepareFailReporter();
            }
            return new TPLiveReporter();
        }
        return new TPVodReporter();
    }
}
