package com.tencent.qqlive.tvkplayer.qqliveasset.common;

import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKPositionTransformUtils {
    private static final String TAG = "TVKPlayer[TVKPositionTransformUtils]";

    public static long adjustServerSkipEndPositionForEmbeddedAd(long j3, TVKNetVideoInfo tVKNetVideoInfo) {
        if (j3 <= 0) {
            return j3;
        }
        if (!hasEmbeddedAdDots(tVKNetVideoInfo)) {
            return j3;
        }
        int durationSec = tVKNetVideoInfo.getDurationSec() * 1000;
        List<TVKNetVideoInfo.EmbeddedAdDot> embeddedAdDotList = tVKNetVideoInfo.getEmbeddedAdDotList();
        Iterator<TVKNetVideoInfo.EmbeddedAdDot> it = embeddedAdDotList.iterator();
        while (it.hasNext()) {
            durationSec += it.next().getAdDurationMs();
        }
        for (int size = embeddedAdDotList.size() - 1; size >= 0; size--) {
            if (j3 > durationSec - embeddedAdDotList.get(size).getEndTimeMs()) {
                j3 += embeddedAdDotList.get(size).getAdDurationMs();
            }
        }
        return j3;
    }

    public static long adjustServerSkipStartPositionForEmbeddedAd(long j3, TVKNetVideoInfo tVKNetVideoInfo) {
        if (j3 <= 0) {
            return j3;
        }
        if (!hasEmbeddedAdDots(tVKNetVideoInfo)) {
            return j3;
        }
        for (TVKNetVideoInfo.EmbeddedAdDot embeddedAdDot : tVKNetVideoInfo.getEmbeddedAdDotList()) {
            if (j3 > embeddedAdDot.getStartTimeMs()) {
                j3 += embeddedAdDot.getAdDurationMs();
            }
        }
        return j3;
    }

    public static long adjustSkipEndPositionForEmbeddedAd(long j3, TVKNetVideoInfo tVKNetVideoInfo) {
        if (j3 <= 0) {
            return j3;
        }
        if (!hasEmbeddedAdDots(tVKNetVideoInfo)) {
            return j3;
        }
        int durationSec = tVKNetVideoInfo.getDurationSec() * 1000;
        List<TVKNetVideoInfo.EmbeddedAdDot> embeddedAdDotList = tVKNetVideoInfo.getEmbeddedAdDotList();
        Iterator<TVKNetVideoInfo.EmbeddedAdDot> it = embeddedAdDotList.iterator();
        while (it.hasNext()) {
            durationSec += it.next().getAdDurationMs();
        }
        int size = embeddedAdDotList.size() - 1;
        int i3 = 0;
        while (true) {
            if (size < 0 || j3 <= durationSec - embeddedAdDotList.get(size).getEndTimeMs()) {
                break;
            }
            if (j3 < durationSec - embeddedAdDotList.get(size).getStartTimeMs()) {
                i3 = (int) (i3 + (j3 - (durationSec - embeddedAdDotList.get(size).getEndTimeMs())));
                break;
            }
            i3 += embeddedAdDotList.get(size).getAdDurationMs();
            size--;
        }
        return j3 - i3;
    }

    public static long adjustSkipEndPositionForVodPreview(long j3, TVKNetVideoInfo tVKNetVideoInfo) {
        if (isVodPreview(tVKNetVideoInfo)) {
            return 0L;
        }
        return j3;
    }

    public static long adjustSkipStartPositionForEmbeddedAd(long j3, TVKNetVideoInfo tVKNetVideoInfo) {
        if (j3 <= 0) {
            return j3;
        }
        if (!hasEmbeddedAdDots(tVKNetVideoInfo)) {
            return j3;
        }
        Iterator<TVKNetVideoInfo.EmbeddedAdDot> it = tVKNetVideoInfo.getEmbeddedAdDotList().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TVKNetVideoInfo.EmbeddedAdDot next = it.next();
            if (j3 <= next.getStartTimeMs()) {
                break;
            }
            if (j3 <= next.getEndTimeMs()) {
                i3 = (int) (i3 + (j3 - next.getStartTimeMs()));
                break;
            }
            i3 += next.getAdDurationMs();
        }
        return j3 - i3;
    }

    public static long adjustSkipStartPositionForPluginAd(long j3, TVKNetVideoInfo tVKNetVideoInfo) {
        long j16 = 0;
        if (j3 <= 0) {
            return j3;
        }
        if (!hasPluginAd(tVKNetVideoInfo)) {
            return j3;
        }
        for (TVKNetVideoInfo.PluginAdInfo pluginAdInfo : tVKNetVideoInfo.getAdInfo().getPluginAdInfos()) {
            double d16 = j3;
            double d17 = j16;
            if (d16 < (pluginAdInfo.getStartTimeSec() * 1000.0d) + d17) {
                break;
            }
            j3 = (long) (d16 + (pluginAdInfo.getDurationSec() * 1000.0d));
            j16 = (long) (d17 + (pluginAdInfo.getDurationSec() * 1000.0d));
        }
        return j3;
    }

    public static long adjustSkipStartPositionForVodPreview(long j3, TVKNetVideoInfo tVKNetVideoInfo) {
        if (!isVodPreview(tVKNetVideoInfo)) {
            return j3;
        }
        long previewStartPositionSec = tVKNetVideoInfo.getPreviewStartPositionSec() * 1000;
        long previewDurationSec = (tVKNetVideoInfo.getPreviewDurationSec() * 1000) + previewStartPositionSec;
        if (j3 < previewStartPositionSec || j3 >= previewDurationSec) {
            return previewStartPositionSec;
        }
        return j3;
    }

    private static boolean hasEmbeddedAdDots(TVKNetVideoInfo tVKNetVideoInfo) {
        if (!(tVKNetVideoInfo instanceof TVKVodVideoInfo)) {
            TVKLogUtil.i(TAG, "Not vodVideoInfo, without EmbeddedAdDots");
            return false;
        }
        if (tVKNetVideoInfo.getEmbeddedAdDotList() != null && !tVKNetVideoInfo.getEmbeddedAdDotList().isEmpty()) {
            return true;
        }
        TVKLogUtil.i(TAG, "embeddedAdDotList is Empty");
        return false;
    }

    private static boolean hasPluginAd(TVKNetVideoInfo tVKNetVideoInfo) {
        if (!(tVKNetVideoInfo instanceof TVKVodVideoInfo)) {
            TVKLogUtil.i(TAG, "Not vodVideoInfo, without pluginAd");
            return false;
        }
        if (tVKNetVideoInfo.getAdInfo() != null && tVKNetVideoInfo.getAdInfo().getPluginAdInfos() != null && !tVKNetVideoInfo.getAdInfo().getPluginAdInfos().isEmpty()) {
            return true;
        }
        TVKLogUtil.i(TAG, "pluginAdInfo is empty ");
        return false;
    }

    private static boolean isVodPreview(TVKNetVideoInfo tVKNetVideoInfo) {
        if ((tVKNetVideoInfo instanceof TVKVodVideoInfo) && tVKNetVideoInfo.isPreview()) {
            return true;
        }
        return false;
    }
}
