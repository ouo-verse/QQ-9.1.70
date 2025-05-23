package gb0;

import com.tencent.biz.qqcircle.richframework.preload.coldbootV2.QCircleColdBootPreloadFeedManagerV2;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static void a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || !ac0.a.b() || QQVideoPlaySDKManager.isSDKReady()) {
            return;
        }
        QLog.d("QCircleVideoPreloadUtils", 1, "preDownloadVideo real do");
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedCloudMeta$StFeed);
        fb0.b.b(arrayList, "enter_page");
        QCircleColdBootPreloadFeedManagerV2.getInstance().doPreloadImage(feedCloudMeta$StFeed);
        QCircleColdBootPreloadFeedManagerV2.getInstance().preDownloadVideo(feedCloudMeta$StFeed);
    }
}
