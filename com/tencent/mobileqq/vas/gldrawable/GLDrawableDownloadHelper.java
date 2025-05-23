package com.tencent.mobileqq.vas.gldrawable;

import android.media.MediaCodecInfo;
import android.os.Build;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.util.ArrayList;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes20.dex */
public class GLDrawableDownloadHelper {
    private static boolean supportAvc = true;

    static {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                GLDrawableDownloadHelper.supportAvc = !Utils.getHardwareDecodec("video/avc").isEmpty();
                if (VasStatisticCollector.isHit()) {
                    int i3 = Build.VERSION.SDK_INT;
                    ArrayList<MediaCodecInfo> hardwareDecodec = Utils.getHardwareDecodec("video/avc");
                    String str2 = "";
                    if (hardwareDecodec.size() <= 0) {
                        str = "";
                    } else {
                        str = hardwareDecodec.get(0).getName();
                    }
                    ArrayList<MediaCodecInfo> hardwareDecodec2 = Utils.getHardwareDecodec("video/hevc");
                    if (hardwareDecodec2.size() > 0) {
                        str2 = hardwareDecodec2.get(0).getName();
                    }
                    VasStatisticCollector.report("gldrawable_video_codec", (Pair<String, String>[]) new Pair[]{new Pair("avc", str), new Pair("hevc", str2), new Pair(DTConstants.TAG.API, String.valueOf(i3)), new Pair("level", String.valueOf(DeviceInfoUtils.getPerfLevel()))});
                }
            }
        });
    }

    public static boolean isSupportHardwareCodec() {
        return supportAvc;
    }
}
