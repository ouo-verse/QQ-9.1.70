package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data;

import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.MediaRawDataAdapterFactory;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.m;
import qj1.v;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0004\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f2\u0006\u0010\u0003\u001a\u00020\u0001J\u0016\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f2\u0006\u0010\u0003\u001a\u00020\u0001\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/MediaRawDataAdapterFactory;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "rawData", "com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/MediaRawDataAdapterFactory$a", "b", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;)Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/MediaRawDataAdapterFactory$a;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/MediaRawDataAdapterFactory$getGProStVideoMetaAdapter$1", "c", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;)Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/MediaRawDataAdapterFactory$getGProStVideoMetaAdapter$1;", "Lqj1/m;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IMediaSourceUrlAdapter;", "d", "Lqj1/v;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IVideoMetaAdapter;", "e", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MediaRawDataAdapterFactory {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/MediaRawDataAdapterFactory$a", "Lqj1/m;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/IMediaSourceUrlAdapter;", "", "level", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProStImage f221137a;

        a(GProStImage gProStImage) {
            this.f221137a = gProStImage;
        }

        @Override // qj1.m
        @NotNull
        public String a(int level) {
            return pl1.a.c(this.f221137a, level);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a b(GProStImage rawData) {
        return new a(rawData);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.MediaRawDataAdapterFactory$getGProStVideoMetaAdapter$1] */
    private final MediaRawDataAdapterFactory$getGProStVideoMetaAdapter$1 c(final GProStVideo rawData) {
        return new v(this) { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.MediaRawDataAdapterFactory$getGProStVideoMetaAdapter$1

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy coverUrlProvider;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<MediaRawDataAdapterFactory.a>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.MediaRawDataAdapterFactory$getGProStVideoMetaAdapter$1$coverUrlProvider$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final MediaRawDataAdapterFactory.a invoke() {
                        MediaRawDataAdapterFactory.a b16;
                        MediaRawDataAdapterFactory mediaRawDataAdapterFactory = MediaRawDataAdapterFactory.this;
                        GProStImage gProStImage = r2.cover;
                        Intrinsics.checkNotNullExpressionValue(gProStImage, "rawData.cover");
                        b16 = mediaRawDataAdapterFactory.b(gProStImage);
                        return b16;
                    }
                });
                this.coverUrlProvider = lazy;
            }

            @Override // qj1.v
            @NotNull
            public m a() {
                return (m) this.coverUrlProvider.getValue();
            }

            @Override // qj1.v
            public long getDurationMs() {
                return GProStVideo.this.duration;
            }
        };
    }

    @Nullable
    public final m d(@NotNull Object rawData) {
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        if (rawData instanceof GProStImage) {
            return b((GProStImage) rawData);
        }
        return null;
    }

    @Nullable
    public final v e(@NotNull Object rawData) {
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        if (rawData instanceof GProStVideo) {
            return c((GProStVideo) rawData);
        }
        return null;
    }
}
