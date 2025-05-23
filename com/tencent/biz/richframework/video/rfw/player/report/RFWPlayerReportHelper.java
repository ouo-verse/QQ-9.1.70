package com.tencent.biz.richframework.video.rfw.player.report;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class RFWPlayerReportHelper {
    private static List<FeedCloudCommon$Entry> addCommonKey(RFWPlayerOptions rFWPlayerOptions, List<FeedCloudCommon$Entry> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(QCircleReportHelper.newEntry("video_url", rFWPlayerOptions.getRealPlayUrl()));
        return arrayList;
    }

    public static void report(RFWPlayer rFWPlayer, RFWPlayerOptions rFWPlayerOptions, String str, List<FeedCloudCommon$Entry> list) {
        if (rFWPlayer != null && rFWPlayerOptions != null && !TextUtils.isEmpty(str)) {
            RFWVideoReporter.getInstance().report(rFWPlayer.getVideoPlayId(), str, rFWPlayerOptions.getIOC().getBusinessReportInfo(), addCommonKey(rFWPlayerOptions, list));
        }
    }
}
