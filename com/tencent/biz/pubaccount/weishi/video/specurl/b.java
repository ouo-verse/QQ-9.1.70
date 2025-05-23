package com.tencent.biz.pubaccount.weishi.video.specurl;

import NS_KING_SOCIALIZE_META.VideoSpecUrl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/video/specurl/b;", "Lcom/tencent/biz/pubaccount/weishi/video/specurl/AbsWSVideoSpecStrategy;", "", "videoCoding", "LNS_KING_SOCIALIZE_META/VideoSpecUrl;", h.F, "c", "b", "", "videoSpecUrlMap", "<init>", "(Ljava/util/Map;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class b extends AbsWSVideoSpecStrategy {
    public b(Map<Integer, VideoSpecUrl> map) {
        super(map);
    }

    private final VideoSpecUrl h(int videoCoding) {
        VideoSpecUrl videoSpecUrl;
        List<VideoSpecUrl> e16;
        Map<Integer, VideoSpecUrl> f16 = f();
        if (f16 != null && (videoSpecUrl = f16.get(999)) != null && (e16 = e()) != null) {
            for (VideoSpecUrl videoSpecUrl2 : e16) {
                if (videoSpecUrl2.videoQuality == videoSpecUrl.videoQuality && videoSpecUrl2.videoCoding == videoCoding) {
                    return videoSpecUrl2;
                }
            }
        }
        List<VideoSpecUrl> e17 = e();
        if (e17 == null) {
            return null;
        }
        for (VideoSpecUrl videoSpecUrl3 : e17) {
            if (videoSpecUrl3.videoCoding == videoCoding) {
                return videoSpecUrl3;
            }
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.video.specurl.AbsWSVideoSpecStrategy
    public VideoSpecUrl b() {
        return h(1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.video.specurl.AbsWSVideoSpecStrategy
    public VideoSpecUrl c() {
        return h(2);
    }
}
