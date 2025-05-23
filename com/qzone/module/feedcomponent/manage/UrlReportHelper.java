package com.qzone.module.feedcomponent.manage;

import com.qzone.adapter.feedcomponent.d;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UrlReportHelper {
    public static void reportUrl(BusinessFeedData businessFeedData) {
        FeedPictureInfo pictureInfo;
        FeedPictureInfo pictureInfo2;
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.getLeftThumb() != null && (pictureInfo2 = businessFeedData.getLeftThumb().getPictureInfo()) != null && pictureInfo2.h() != null) {
            i.H().l2(pictureInfo2.h().url);
        }
        FeedPictureInfo[] u16 = d.u(businessFeedData, 1);
        if (u16 != null && u16.length > 0) {
            for (FeedPictureInfo feedPictureInfo : u16) {
                if (feedPictureInfo != null && feedPictureInfo.h() != null) {
                    i.H().l2(feedPictureInfo.h().url);
                }
            }
        }
        BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
        if (originalInfo == null) {
            return;
        }
        if (originalInfo.getLeftThumb() != null && (pictureInfo = originalInfo.getLeftThumb().getPictureInfo()) != null && pictureInfo.h() != null) {
            i.H().l2(pictureInfo.h().url);
        }
        FeedPictureInfo[] u17 = d.u(originalInfo, 1);
        if (u17 == null || u17.length <= 0) {
            return;
        }
        for (FeedPictureInfo feedPictureInfo2 : u17) {
            if (feedPictureInfo2 != null && feedPictureInfo2.h() != null) {
                i.H().l2(feedPictureInfo2.h().url);
            }
        }
    }
}
