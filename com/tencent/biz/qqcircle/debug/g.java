package com.tencent.biz.qqcircle.debug;

import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.y;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g {
    public static void a(List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> list) {
        if (list != null && d()) {
            list.add(y.class);
        }
    }

    public static boolean b() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_FEED_DEBUG_INFO_CONTROLLER, 0);
    }

    public static boolean c() {
        if (d() && b()) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        return QCircleApplication.isRDMVersion();
    }
}
