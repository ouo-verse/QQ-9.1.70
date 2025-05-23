package com.tencent.biz.pubaccount.weishi.video.specurl;

import NS_KING_SOCIALIZE_META.VideoSpecUrl;
import com.tencent.biz.pubaccount.weishi.player.wrapper.WSPlayerDecodeCapabilityHelper;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u001e\u0010\r\u001a\u0004\u0018\u00010\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tJ\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/video/specurl/d;", "", "LNS_KING_SOCIALIZE_META/VideoSpecUrl;", "h264VideoSpecUrl", "recommendVideoSpecUrl", "", "selectedVideoSpecReason", "Lcom/tencent/biz/pubaccount/weishi/video/specurl/c;", "d", "", "videoSpecUrlMap", "Lcom/tencent/biz/pubaccount/weishi/video/specurl/AbsWSVideoSpecStrategy;", "b", "c", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f82378a = new d();

    d() {
    }

    private final AbsWSVideoSpecStrategy b(Map<Integer, VideoSpecUrl> videoSpecUrlMap) {
        if (y10.a.f449262a.d() == 1) {
            return new a(videoSpecUrlMap);
        }
        return new b(videoSpecUrlMap);
    }

    public final WSVideoSpecUrl c(Map<Integer, VideoSpecUrl> videoSpecUrlMap) {
        boolean a16;
        y10.a aVar = y10.a.f449262a;
        if (!aVar.a()) {
            return null;
        }
        int i3 = 1;
        if (videoSpecUrlMap == null || videoSpecUrlMap.isEmpty()) {
            return null;
        }
        AbsWSVideoSpecStrategy b16 = b(videoSpecUrlMap);
        VideoSpecUrl c16 = b16.c();
        VideoSpecUrl b17 = b16.b();
        VideoSpecUrl d16 = b16.d();
        if (c16 == null) {
            return d(b17, d16, 1);
        }
        if (aVar.b()) {
            a16 = WSPlayerDecodeCapabilityHelper.f81190a.b(c16.width, c16.height, (int) c16.fps);
            i3 = 2;
        } else {
            a16 = WSPlayerDecodeCapabilityHelper.f81190a.a(c16.width, c16.height, (int) c16.fps);
        }
        if (a16) {
            return new WSVideoSpecUrl(c16, i3, 2);
        }
        return d(b17, d16, 3);
    }

    private final WSVideoSpecUrl d(VideoSpecUrl h264VideoSpecUrl, VideoSpecUrl recommendVideoSpecUrl, int selectedVideoSpecReason) {
        if (h264VideoSpecUrl != null) {
            return new WSVideoSpecUrl(h264VideoSpecUrl, 3, selectedVideoSpecReason);
        }
        if (recommendVideoSpecUrl != null) {
            return new WSVideoSpecUrl(recommendVideoSpecUrl, 0, selectedVideoSpecReason);
        }
        return null;
    }

    public final WSVideoSpecUrl a(Map<Integer, VideoSpecUrl> videoSpecUrlMap) {
        if (videoSpecUrlMap == null || videoSpecUrlMap.isEmpty()) {
            return null;
        }
        AbsWSVideoSpecStrategy b16 = b(videoSpecUrlMap);
        return d(b16.b(), b16.d(), 4);
    }
}
