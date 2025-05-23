package com.tencent.biz.qqcircle.immersive.utils;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bj {
    private static Rect a(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        if (feedCloudMeta$StFeed == null) {
            QLog.d("VFS-QFSVideoContentUtils", 4, "[getCoordinateInfo] feed == null, end flow.");
            return null;
        }
        if (ab.v(feedCloudMeta$StFeed)) {
            QLog.d("VFS-QFSVideoContentUtils", 1, "[getCoordinateInfo] video land scape, end flow.");
            return null;
        }
        if (!c(feedCloudMeta$StFeed)) {
            return null;
        }
        long j3 = feedCloudMeta$StFeed.yuhengContentInfos.vertices.width.get();
        long j16 = feedCloudMeta$StFeed.yuhengContentInfos.vertices.height.get();
        List<Long> list = feedCloudMeta$StFeed.yuhengContentInfos.vertices.coordinate.get();
        if (j16 == 0 || j3 == 0 || list.size() != 4) {
            return null;
        }
        float f16 = (float) j3;
        float f17 = i3;
        int longValue = (int) (((((float) (list.get(2).longValue() - list.get(0).longValue())) * 1.0f) / f16) * f17);
        float f18 = (float) j16;
        float f19 = i16;
        int longValue2 = (int) (((((float) (list.get(3).longValue() - list.get(1).longValue())) * 1.0f) / f18) * f19);
        int longValue3 = (int) (((((float) list.get(0).longValue()) * 1.0f) / f16) * f17);
        int longValue4 = (int) (((((float) list.get(1).longValue()) * 1.0f) / f18) * f19);
        QLog.d("VFS-QFSVideoContentUtils", 1, "[getFeedContentRect] contentWidth: " + longValue + " | contentHeight: " + longValue2 + " | contentStartX: " + longValue3 + " | contentStartY: " + longValue4);
        return new Rect(longValue3, longValue4, longValue, longValue2);
    }

    public static Rect b(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16, int i17, int i18) {
        Rect rect = new Rect(0, 0, i17, i18);
        if (feedCloudMeta$StFeed != null && i17 > 0 && i18 > 0) {
            if (a(feedCloudMeta$StFeed, i17, i18) == null) {
                return rect;
            }
            float max = Math.max(i3 / r3.right, 1.0f);
            float max2 = Math.max(i16 / r3.bottom, 1.0f);
            int i19 = (int) (i17 * max);
            int i26 = (int) (i18 * max2);
            int i27 = (int) (((i26 - i16) / 2) - (r3.top * max2));
            QLog.d("VFS-QFSVideoContentUtils", 1, "[getTargetRect] enabled coordinate, videoWidth: " + i19 + " | videoHeight: " + i26 + " | widthScale: " + max + " | heightScale: " + max2 + " | contentTopMargin: " + i27 + " | targetW: " + i19 + " | targetH: " + i26);
            return new Rect(0, i27, i19, i26);
        }
        return rect;
    }

    private static boolean c(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.yuhengContentInfos.has() && feedCloudMeta$StFeed.yuhengContentInfos.vertices.has()) {
            return true;
        }
        return false;
    }
}
