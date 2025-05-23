package com.tencent.ttpic;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.support.annotation.RequiresApi;
import com.tencent.ttpic.baseutils.log.LogUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CommonUtils {
    private static final String TAG = "CommonUtils";

    @RequiresApi(api = 23)
    private static int getMaxSupportedInstanceCount(String str) {
        MediaCodecInfo selectDecoder = selectDecoder(str);
        if (selectDecoder == null) {
            return 0;
        }
        try {
            return selectDecoder.getCapabilitiesForType(str).getMaxSupportedInstances();
        } catch (Throwable th5) {
            LogUtils.e("CommonUtils", th5.getMessage());
            th5.printStackTrace();
            return 0;
        }
    }

    public static int getPAGSupportedDecoderInstanceCount() {
        return Math.min(getMaxSupportedInstanceCount("video/avc"), getMaxSupportedInstanceCount("video/hevc"));
    }

    @RequiresApi(api = 17)
    private static MediaCodecInfo selectDecoder(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (!codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }
}
