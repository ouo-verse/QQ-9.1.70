package gb0;

import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerStartNewPlayAction;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import feedcloud.FeedCloudMeta$StVideoUrl;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final a f401687a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(float f16);
    }

    public d(a aVar) {
        this.f401687a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo c16 = c(feedCloudMeta$StFeed);
        float computeCacheTimeS = RFWVideoUtils.computeCacheTimeS(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), c16.playUrl.get(), c16.fileId.get(), (int) RFWPlayerStartNewPlayAction.getVideoRate(c16.videoRate.get()));
        if (computeCacheTimeS != 0.0f) {
            RFWLog.d("QFSVideoCanPlayTimesWrapper", RFWLog.USR, "calCanPlayTime cacheTime:" + computeCacheTimeS + ";feedId:" + feedCloudMeta$StFeed.f398449id.get());
            a aVar = this.f401687a;
            if (aVar != null) {
                aVar.a(computeCacheTimeS);
                return;
            }
            return;
        }
        for (FeedCloudMeta$StVideoUrl feedCloudMeta$StVideoUrl : c16.vecVideoUrl.get()) {
            float computeCacheTimeS2 = RFWVideoUtils.computeCacheTimeS(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO(), feedCloudMeta$StVideoUrl.playUrl.get(), c16.fileId.get(), (int) RFWPlayerStartNewPlayAction.getVideoRate(feedCloudMeta$StVideoUrl.videoRate.get()));
            if (computeCacheTimeS2 > 0.0f) {
                RFWLog.d("QFSVideoCanPlayTimesWrapper", RFWLog.USR, "calCanPlayTime from vecVideo url, cacheTime:" + computeCacheTimeS2 + ";feedId:" + feedCloudMeta$StFeed.f398449id.get());
                a aVar2 = this.f401687a;
                if (aVar2 != null) {
                    aVar2.a(computeCacheTimeS2);
                    return;
                }
                return;
            }
        }
        a aVar3 = this.f401687a;
        if (aVar3 != null) {
            aVar3.a(0.0f);
        }
    }

    public void b(final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: gb0.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.d(feedCloudMeta$StFeed);
            }
        });
    }

    public FeedCloudMeta$StVideo c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = feedCloudMeta$StFeed.video.get();
        FeedCloudMeta$StFeed d16 = u.d(feedCloudMeta$StFeed);
        if (d16 != null) {
            RFWLog.d("QFSVideoCanPlayTimesWrapper", RFWLog.USR, "getRealNeedPlayVideoInfo use ad feed url;feedId:" + feedCloudMeta$StFeed.f398449id.get());
            return d16.video.get();
        }
        return feedCloudMeta$StVideo;
    }
}
