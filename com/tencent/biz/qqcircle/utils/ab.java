package com.tencent.biz.qqcircle.utils;

import android.util.Pair;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ab {
    public static Pair<Integer, Integer> a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        float f16;
        int i17;
        Pair<Integer, Integer> pair = new Pair<>(0, 0);
        if (feedCloudMeta$StFeed != null) {
            if (feedCloudMeta$StFeed.type.get() == 3) {
                int screenWidth = ImmersiveUtils.getScreenWidth();
                float f17 = i3 / i16;
                if (f17 >= 1.7777778f) {
                    f16 = screenWidth / 1.7777778f;
                } else {
                    if (f17 > 0.75f && f17 <= 1.7777778f) {
                        i17 = (int) (screenWidth / f17);
                        return new Pair<>(Integer.valueOf(screenWidth), Integer.valueOf(i17));
                    }
                    f16 = screenWidth / 0.75f;
                }
                i17 = (int) f16;
                return new Pair<>(Integer.valueOf(screenWidth), Integer.valueOf(i17));
            }
            if (feedCloudMeta$StFeed.type.get() == 2) {
                List<FeedCloudMeta$StImage> list = feedCloudMeta$StFeed.images.get();
                int screenWidth2 = ImmersiveUtils.getScreenWidth();
                if (list.size() > 0) {
                    FeedCloudMeta$StImage feedCloudMeta$StImage = list.get(0);
                    if (feedCloudMeta$StImage.width.get() != 0 && feedCloudMeta$StImage.height.get() != 0) {
                        return new Pair<>(Integer.valueOf(screenWidth2), Integer.valueOf((int) (screenWidth2 * Math.max(Math.min(feedCloudMeta$StImage.height.get() / feedCloudMeta$StImage.width.get(), 1.3333334f), 0.5625f))));
                    }
                }
            }
        }
        return pair;
    }

    public static List<QQCircleDitto$StItemInfo> b(List<QQCircleDitto$StItemInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo : list) {
                if (qQCircleDitto$StItemInfo != null && qQCircleDitto$StItemInfo.buttonInfo.buttonValue.get() == 0 && !QCircleFollowManager.getInstance().isUinFollowed(qQCircleDitto$StItemInfo.f429300id.get())) {
                    arrayList.add(qQCircleDitto$StItemInfo);
                }
            }
        }
        return arrayList;
    }
}
