package com.tencent.mobileqq.shortvideo.util;

import android.media.MediaMetadataRetriever;
import com.tencent.ttpic.baseutils.device.DeviceInstance;

/* compiled from: P */
/* loaded from: classes18.dex */
public class VideoUtil {
    public static long getDurationOfVideo(String str) {
        if (FileUtil.checkFileExist(str) && DeviceInstance.getSDKVersion() >= 10) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                return Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue();
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    public static float getHeightWidthRatioOfVideo(String str) {
        if (FileUtil.checkFileExist(str) && DeviceInstance.getSDKVersion() >= 10) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                mediaMetadataRetriever.release();
                return (Integer.valueOf(extractMetadata2).intValue() * 1.0f) / Integer.valueOf(extractMetadata).intValue();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return 0.0f;
    }
}
