package com.tencent.biz.pubaccount.weishi.video.specurl;

import NS_KING_SOCIALIZE_META.VideoSpecUrl;
import com.tencent.biz.pubaccount.weishi.player.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\b&\u0018\u0000 \b2\u00020\u0001:\u0001\u000bB\u001d\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016R%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/video/specurl/AbsWSVideoSpecStrategy;", "", "", "", "LNS_KING_SOCIALIZE_META/VideoSpecUrl;", "videoSpecUrlMap", "", "g", "c", "b", "d", "a", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "Lkotlin/Lazy;", "e", "()Ljava/util/List;", "videoSpecUrlList", "<init>", "(Ljava/util/Map;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class AbsWSVideoSpecStrategy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, VideoSpecUrl> videoSpecUrlMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy videoSpecUrlList;

    public AbsWSVideoSpecStrategy(Map<Integer, VideoSpecUrl> map) {
        Lazy lazy;
        this.videoSpecUrlMap = map;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends VideoSpecUrl>>() { // from class: com.tencent.biz.pubaccount.weishi.video.specurl.AbsWSVideoSpecStrategy$videoSpecUrlList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends VideoSpecUrl> invoke() {
                List<? extends VideoSpecUrl> g16;
                AbsWSVideoSpecStrategy absWSVideoSpecStrategy = AbsWSVideoSpecStrategy.this;
                g16 = absWSVideoSpecStrategy.g(absWSVideoSpecStrategy.f());
                return g16;
            }
        });
        this.videoSpecUrlList = lazy;
    }

    public abstract VideoSpecUrl b();

    public abstract VideoSpecUrl c();

    public VideoSpecUrl d() {
        Map<Integer, VideoSpecUrl> map = this.videoSpecUrlMap;
        if (map != null) {
            return map.get(999);
        }
        return null;
    }

    public final List<VideoSpecUrl> e() {
        return (List) this.videoSpecUrlList.getValue();
    }

    public final Map<Integer, VideoSpecUrl> f() {
        return this.videoSpecUrlMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<VideoSpecUrl> g(Map<Integer, VideoSpecUrl> videoSpecUrlMap) {
        if (videoSpecUrlMap == null || videoSpecUrlMap.isEmpty()) {
            return null;
        }
        Object[] array = new Regex("\\|").split(y10.a.f449262a.e(), 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        ArrayList arrayList = new ArrayList();
        for (String str : (String[]) array) {
            VideoSpecUrl videoSpecUrl = videoSpecUrlMap.get(Integer.valueOf(i.N(str, -1)));
            if (videoSpecUrl != null) {
                arrayList.add(videoSpecUrl);
            }
        }
        return arrayList;
    }
}
