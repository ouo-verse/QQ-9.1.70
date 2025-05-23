package kh;

import android.text.TextUtils;
import android.util.LruCache;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.tencent.biz.qqcircle.requests.QCircleVideoUrlAdapterRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleVideourlexchange$StGetVideoAdaptRsp;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements HttpRetryLogic {

    /* renamed from: c, reason: collision with root package name */
    private static final LruCache<String, FeedCloudMeta$StVideo> f412340c = new LruCache<>(100);

    /* renamed from: a, reason: collision with root package name */
    private final String f412341a;

    /* renamed from: b, reason: collision with root package name */
    private String f412342b;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface a {
        void onComplete();
    }

    public b(String str) {
        this.f412341a = str;
    }

    public static String d(BusinessFeedData businessFeedData, String str) {
        String a16 = ef.b.a(businessFeedData);
        if (TextUtils.isEmpty(a16)) {
            return str;
        }
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = f412340c.get(a16);
        String str2 = feedCloudMeta$StVideo == null ? null : feedCloudMeta$StVideo.playUrl.get();
        if (str2 == null || str2.trim().length() <= 0) {
            return str;
        }
        QLog.d("getExchangePlayUrl", 1, "user cachePlayurl");
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(com.qzone.reborn.feedx.video.c cVar, BusinessFeedData businessFeedData, a aVar, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        QQCircleVideourlexchange$StGetVideoAdaptRsp qQCircleVideourlexchange$StGetVideoAdaptRsp = obj instanceof QQCircleVideourlexchange$StGetVideoAdaptRsp ? (QQCircleVideourlexchange$StGetVideoAdaptRsp) obj : null;
        int size = qQCircleVideourlexchange$StGetVideoAdaptRsp == null ? -1 : qQCircleVideourlexchange$StGetVideoAdaptRsp.videos.size();
        QLog.d(e(cVar), 1, "exchangeQCircleVideoUrl onReceive, cmd : " + baseRequest.getCmd() + " | traceId : " + baseRequest.getTraceId() + " | isSuccess : " + z16 + " | retCode : " + j3 + " | exchangeVideoSize : " + size);
        if (z16 && j3 == 0 && size > 0 && (feedCloudMeta$StVideo = qQCircleVideourlexchange$StGetVideoAdaptRsp.videos.get(0)) != null) {
            String trim = feedCloudMeta$StVideo.playUrl.get().trim();
            if (trim.length() > 0) {
                QLog.d(e(cVar), 1, "exchangeQCircleVideoUrl success urlBeforeExchange : " + cVar.c() + ", urlAfterExchange : " + trim);
                this.f412342b = trim;
                g(cVar, businessFeedData, feedCloudMeta$StVideo);
            }
        }
        if (aVar != null) {
            aVar.onComplete();
        }
    }

    private void g(com.qzone.reborn.feedx.video.c cVar, BusinessFeedData businessFeedData, FeedCloudMeta$StVideo feedCloudMeta$StVideo) {
        String a16 = ef.b.a(businessFeedData);
        if (TextUtils.isEmpty(a16)) {
            QLog.e(e(cVar), 1, "putExchangeVideoInfoToCacheMap feedUinKey is empty");
        } else if (feedCloudMeta$StVideo == null) {
            QLog.e(e(cVar), 1, "putExchangeVideoInfoToCacheMap exchangeVideoInfo == null");
        } else {
            f412340c.put(a16, feedCloudMeta$StVideo);
        }
    }

    public void c(final BusinessFeedData businessFeedData, VideoInfo videoInfo, final com.qzone.reborn.feedx.video.c cVar, final a aVar) {
        if (!RFWVideoUtils.checkVideoUrlIsNeedChange(cVar.c())) {
            if (aVar != null) {
                aVar.onComplete();
                return;
            }
            return;
        }
        String a16 = ef.b.a(businessFeedData);
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = f412340c.get(a16);
        String str = feedCloudMeta$StVideo == null ? null : feedCloudMeta$StVideo.playUrl.get();
        if (str != null && str.trim().length() > 0 && !RFWVideoUtils.checkVideoUrlIsNeedChange(str)) {
            QLog.d(e(cVar), 1, "exchangeQCircleVideoUrl success hit Cache feedUinKey : " + a16 + ", videoExchange url : " + str);
            this.f412342b = str;
            if (aVar != null) {
                aVar.onComplete();
                return;
            }
            return;
        }
        QCircleVideoUrlAdapterRequest qCircleVideoUrlAdapterRequest = new QCircleVideoUrlAdapterRequest(b(cVar, videoInfo));
        qCircleVideoUrlAdapterRequest.setEnableCache(false);
        QLog.d(e(cVar), 1, "exchangeQCircleVideoUrl request");
        VSNetworkHelper.getInstance().sendRequest(qCircleVideoUrlAdapterRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: kh.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                b.this.f(cVar, businessFeedData, aVar, baseRequest, z16, j3, str2, obj);
            }
        });
    }

    @Override // com.tencent.oskplayer.proxy.HttpRetryLogic
    public String getRetryUrl(String str, int i3, int i16, Map<String, List<String>> map) {
        if (TextUtils.isEmpty(this.f412342b)) {
            return this.f412341a;
        }
        return this.f412342b;
    }

    private String e(com.qzone.reborn.feedx.video.c cVar) {
        if (cVar == null) {
            return "QCircleVideoHttpRetryLogic";
        }
        return "QCircleVideoHttpRetryLogic_" + cVar.s();
    }

    private FeedCloudMeta$StVideo b(com.qzone.reborn.feedx.video.c cVar, VideoInfo videoInfo) {
        if (cVar == null || videoInfo == null) {
            return null;
        }
        FeedCloudMeta$StVideo feedCloudMeta$StVideo = new FeedCloudMeta$StVideo();
        feedCloudMeta$StVideo.playUrl.set(cVar.c());
        feedCloudMeta$StVideo.width.set(videoInfo.width);
        feedCloudMeta$StVideo.height.set(videoInfo.height);
        return feedCloudMeta$StVideo;
    }
}
