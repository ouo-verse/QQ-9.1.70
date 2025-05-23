package com.tencent.biz.pubaccount.weishi.video.specurl;

import NS_KING_SOCIALIZE_META.VideoSpecUrl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/video/specurl/a;", "Lcom/tencent/biz/pubaccount/weishi/video/specurl/AbsWSVideoSpecStrategy;", "LNS_KING_SOCIALIZE_META/VideoSpecUrl;", "c", "b", "", "", "videoSpecUrlMap", "<init>", "(Ljava/util/Map;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class a extends AbsWSVideoSpecStrategy {
    public a(Map<Integer, VideoSpecUrl> map) {
        super(map);
    }

    @Override // com.tencent.biz.pubaccount.weishi.video.specurl.AbsWSVideoSpecStrategy
    public VideoSpecUrl b() {
        List<VideoSpecUrl> e16 = e();
        if (e16 == null) {
            return null;
        }
        for (VideoSpecUrl videoSpecUrl : e16) {
            if (videoSpecUrl.videoCoding == 1) {
                return videoSpecUrl;
            }
        }
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.video.specurl.AbsWSVideoSpecStrategy
    public VideoSpecUrl c() {
        List<VideoSpecUrl> e16 = e();
        if (e16 == null) {
            return null;
        }
        for (VideoSpecUrl videoSpecUrl : e16) {
            if (videoSpecUrl.videoCoding == 2) {
                return videoSpecUrl;
            }
        }
        return null;
    }
}
