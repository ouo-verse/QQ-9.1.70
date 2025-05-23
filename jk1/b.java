package jk1;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Ljk1/b;", "", "", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "video", "", "progress", "g", "", "videoKey", h.F, "e", "f", "d", "Landroid/util/LruCache;", "a", "Landroid/util/LruCache;", "mVideoProgressCache", "<init>", "()V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static volatile b f410319c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, Integer> mVideoProgressCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Ljk1/b$a;", "", "Ljk1/b;", "a", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Ljk1/b;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: jk1.b$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            b bVar = b.f410319c;
            if (bVar == null) {
                synchronized (this) {
                    bVar = b.f410319c;
                    if (bVar == null) {
                        bVar = new b(null);
                        b.f410319c = bVar;
                    }
                }
            }
            return bVar;
        }

        Companion() {
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void c() {
        this.mVideoProgressCache.evictAll();
    }

    @NotNull
    public final String d(@Nullable GProStVideo video) {
        if (video == null) {
            return "";
        }
        if (!TextUtils.isEmpty(video.fileId)) {
            String str = video.fileId;
            Intrinsics.checkNotNullExpressionValue(str, "video.fileId");
            return str;
        }
        String str2 = video.playUrl;
        Intrinsics.checkNotNullExpressionValue(str2, "video.playUrl");
        return str2;
    }

    public final int e(@NotNull GProStVideo video) {
        Intrinsics.checkNotNullParameter(video, "video");
        Integer num = this.mVideoProgressCache.get(d(video));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final int f(@NotNull String videoKey) {
        Intrinsics.checkNotNullParameter(videoKey, "videoKey");
        Integer num = this.mVideoProgressCache.get(videoKey);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void g(@NotNull GProStVideo video, int progress) {
        Intrinsics.checkNotNullParameter(video, "video");
        this.mVideoProgressCache.put(d(video), Integer.valueOf(progress));
    }

    public final void h(@NotNull String videoKey, int progress) {
        Intrinsics.checkNotNullParameter(videoKey, "videoKey");
        this.mVideoProgressCache.put(videoKey, Integer.valueOf(progress));
    }

    b() {
        this.mVideoProgressCache = new LruCache<>(5);
    }
}
