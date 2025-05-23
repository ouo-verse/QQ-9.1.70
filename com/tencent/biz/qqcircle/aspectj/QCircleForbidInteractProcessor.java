package com.tencent.biz.qqcircle.aspectj;

import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudMeta$StDittoFeed;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QCircleForbidInteractProcessor {
    public static boolean forbidInteractIfGuildFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudMeta$StDittoFeed feedCloudMeta$StDittoFeed;
        if (feedCloudMeta$StFeed == null || (feedCloudMeta$StDittoFeed = feedCloudMeta$StFeed.dittoFeed) == null || feedCloudMeta$StDittoFeed.dittoId.get() != 33) {
            return false;
        }
        showToastByInteractType(i3);
        return true;
    }

    private static void showToastByInteractType(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 5) {
                        if (i3 == 6) {
                            QCircleToast.o(h.a(R.string.f1921946u) + h.a(R.string.f19305496), 0);
                            return;
                        }
                        return;
                    }
                    QCircleToast.o(h.a(R.string.f1921946u) + h.a(R.string.f19043423), 0);
                    return;
                }
                QCircleToast.o(h.a(R.string.f1921946u) + h.a(R.string.f184893n4), 0);
                return;
            }
            QCircleToast.o(h.a(R.string.f1921946u) + h.a(R.string.f181813es), 0);
            return;
        }
        QCircleToast.o(h.a(R.string.f1921946u) + h.a(R.string.f1909843k), 0);
    }
}
