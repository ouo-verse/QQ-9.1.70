package com.tencent.ttpic.videoshelf.libpag;

import android.util.Log;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import org.libpag.VideoDecoder;

/* loaded from: classes27.dex */
public class PagUtil {
    private static final String TAG = "PagUtil";

    public static boolean isSupportPag() {
        if (DeviceInstance.getSDKVersion() >= 21) {
            return true;
        }
        return false;
    }

    public static boolean isSupportPagForVideo() {
        if (DeviceInstance.getSDKVersion() > 18) {
            return true;
        }
        return false;
    }

    public static void useSoftDecode() {
        Log.i(TAG, "\u786c\u89e3\u89e3\u6709\u95ee\u9898\uff0c\u4f7f\u7528\u8f6f\u89e3");
        VideoDecoder.SetMaxHardwareDecoderCount(0);
    }
}
