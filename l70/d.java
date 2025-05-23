package l70;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import l70.a;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends b<FeedCloudMeta$StBarrage> {

    /* renamed from: c, reason: collision with root package name */
    private FeedCloudMeta$StFeed f413906c;

    public d(com.tencent.rfw.barrage.core.c cVar, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        super(cVar);
        this.f413906c = feedCloudMeta$StFeed;
    }

    private String e(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        if (feedCloudMeta$StFeed == null) {
            feedCloudMeta$StUser = null;
        } else {
            feedCloudMeta$StUser = feedCloudMeta$StFeed.poster;
        }
        if (feedCloudMeta$StUser == null) {
            return null;
        }
        return feedCloudMeta$StUser.f398463id.get();
    }

    @Override // l70.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.tencent.rfw.barrage.data.a a(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, int i3) {
        com.tencent.rfw.barrage.data.a aVar;
        if (feedCloudMeta$StBarrage != null && feedCloudMeta$StBarrage.feedPlayTime != null) {
            if (this.f413904a == null) {
                QLog.d("QDM-QFSNormalBarrageRenderDataConvert", 1, "[buildSingleBarrageRenderNone] barrage factory should not be null.");
                return null;
            }
            String e16 = e(this.f413906c);
            m70.a aVar2 = new m70.a();
            aVar2.d(feedCloudMeta$StBarrage);
            aVar2.c(e16);
            aVar2.f(QCirclePluginUtil.isQQSVipUser(feedCloudMeta$StBarrage.postUser.get()));
            try {
                aVar = this.f413904a.a(-2147483647, aVar2);
            } catch (Throwable th5) {
                QLog.e("QDM-QFSNormalBarrageRenderDataConvert", 1, "error: ", th5.getMessage());
                aVar = null;
            }
            if (aVar == null) {
                QLog.d("QDM-QFSNormalBarrageRenderDataConvert", 1, "[buildSingleBarrageRenderNone] barrage factory should not be null.");
                return null;
            }
            a.f(new a.C10708a().c(aVar).d(i3).e(this.f413905b), false);
            return aVar;
        }
        QLog.d("QDM-QFSNormalBarrageRenderDataConvert", 1, "[buildSingleBarrageRenderNone] barrage is null or barrage play time is null.");
        return null;
    }
}
