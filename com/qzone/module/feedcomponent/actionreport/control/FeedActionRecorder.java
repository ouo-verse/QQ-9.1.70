package com.qzone.module.feedcomponent.actionreport.control;

import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedActionRecorder {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class SingletonHolder {
        static final FeedActionRecorder instance = new FeedActionRecorder();

        SingletonHolder() {
        }
    }

    public static final FeedActionRecorder getInstance() {
        return SingletonHolder.instance;
    }

    public void addAction(BusinessFeedData businessFeedData, int i3, long j3, int i16, int i17) {
        addAction(businessFeedData, i3, j3, i16, i17, 0, false);
    }

    public void addAction(BusinessFeedData businessFeedData, int i3, long j3, int i16, int i17, boolean z16) {
        addAction(businessFeedData, i3, j3, i16, i17, 0, z16);
    }

    public void addAction(BusinessFeedData businessFeedData, int i3, long j3, int i16, int i17, int i18) {
        addAction(businessFeedData, i3, j3, i16, i17, i18, false);
    }

    public void addAction(BusinessFeedData businessFeedData, int i3, long j3, int i16, int i17, int i18, boolean z16) {
        addAction(businessFeedData, i3, j3, 12, i16, i17, i18, z16, null, false, 0L);
    }

    public void addAction(BusinessFeedData businessFeedData, int i3, long j3, int i16, int i17, int i18, int i19, boolean z16, Object obj, boolean z17, long j16) {
        int i26;
        int i27;
        if (businessFeedData == null || businessFeedData.getFeedCommInfoV2() == null) {
            return;
        }
        int i28 = businessFeedData.feedType;
        if (i28 == 3) {
            i26 = !businessFeedData.getUser().isCanShowFamousIcon() ? i3 - 1 : i3;
            i27 = 2;
        } else {
            i26 = i3;
            i27 = i28 == 4098 ? 1 : i16;
        }
        if (z16) {
            if ((businessFeedData.getFeedCommInfoV2().reportfeedsattr & 1) == 0 && (businessFeedData.getFeedCommInfoV2().reportfeedsattr & 2) == 0 && ((businessFeedData.getFeedCommInfoV2().reportfeedsattr & 8) == 0 || i17 != 15)) {
                if (businessFeedData.feedType == 4098 && i17 == 14) {
                    i.H().C(i27, i17, i18, j3, null, businessFeedData, i26, i19, obj, z17);
                    return;
                }
                return;
            }
            if (businessFeedData.isRecommendFeed()) {
                i.H().w(businessFeedData.getRecommendReportUUID(), i27, i17, i18, businessFeedData, i26);
                return;
            } else if (businessFeedData.feedType != 3) {
                i.H().C(i27, i17, i18, j3, null, businessFeedData, i26, i19, obj, z17);
                return;
            } else {
                if (i17 == 15) {
                    i.H().C(i27, i17, i18, j3, null, businessFeedData, i26, i19, obj, z17);
                    return;
                }
                return;
            }
        }
        if (businessFeedData.isRecommendFeed()) {
            i.H().w(businessFeedData.getRecommendReportUUID(), i27, i17, i18, businessFeedData, i26);
        } else if ((businessFeedData.getFeedCommInfoV2().reportfeedsattr & 4) != 0) {
            i.H().C(i27, i17, i18, j3, null, businessFeedData, i26, i19, obj, z17);
        }
    }

    public void addActionPageType(BusinessFeedData businessFeedData, int i3, long j3, int i16, int i17, int i18) {
        if (businessFeedData == null) {
            return;
        }
        addAction(businessFeedData, i3, j3, i16, i17, i18, 0, false, null, businessFeedData.getFeedCommInfo().isRealTimeTTTReport(), 0L);
    }
}
