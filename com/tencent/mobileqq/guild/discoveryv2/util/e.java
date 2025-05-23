package com.tencent.mobileqq.guild.discoveryv2.util;

import android.graphics.Typeface;
import android.util.Size;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransVideo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImageUrl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideoUrl;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0004\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0000*\u00020\u0004\u001a\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\f\u001a\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010\u001a\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n\"\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0017\u0010\u001e\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProImage;", "", "d", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "b", "", "e", "a", "cover", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;", "g", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVideo;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "i", "url", "", "w", h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/h;", "f", "", "[F", "getDEFAULT_MEDIA_ROUND_CORNER", "()[F", "DEFAULT_MEDIA_ROUND_CORNER", "", "[I", "getDEFAULT_TEXT_PADDING", "()[I", "DEFAULT_TEXT_PADDING", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final float[] f217795a = new float[0];

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final int[] f217796b = new int[0];

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/util/e$a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;", "", "d", "Ljava/lang/String;", "getMediaCoverURL", "()Ljava/lang/String;", "mediaCoverURL", "Landroid/util/Size;", "e", "Landroid/util/Size;", "getMediaRawSize", "()Landroid/util/Size;", "mediaRawSize", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements k {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String mediaCoverURL;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Size mediaRawSize;

        a(IGProImage iGProImage) {
            Object obj;
            Size size;
            boolean z16;
            this.mediaCoverURL = e.d(iGProImage);
            ArrayList<IGProThumbImage> thumbImages = iGProImage.getThumbImages();
            Intrinsics.checkNotNullExpressionValue(thumbImages, "cover.thumbImages");
            Iterator<T> it = thumbImages.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    IGProThumbImage iGProThumbImage = (IGProThumbImage) obj;
                    if (iGProThumbImage.getWidth() != 0 && iGProThumbImage.getHeight() != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IGProThumbImage iGProThumbImage2 = (IGProThumbImage) obj;
            if (iGProThumbImage2 != null) {
                size = new Size(iGProThumbImage2.getWidth(), iGProThumbImage2.getHeight());
            } else {
                Size size2 = new Size(iGProImage.getWidth(), iGProImage.getHeight());
                Size size3 = size2.getWidth() != 0 ? size2 : null;
                if (size3 == null) {
                    size = new Size(100, 100);
                } else {
                    size = size3;
                }
            }
            this.mediaRawSize = size;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k
        @NotNull
        public String getMediaCoverURL() {
            return this.mediaCoverURL;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k
        @NotNull
        public Size getMediaRawSize() {
            return this.mediaRawSize;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/util/e$b", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/k;", "", "d", "Ljava/lang/String;", "getMediaCoverURL", "()Ljava/lang/String;", "mediaCoverURL", "Landroid/util/Size;", "e", "Landroid/util/Size;", "getMediaRawSize", "()Landroid/util/Size;", "mediaRawSize", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements k {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String mediaCoverURL;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Size mediaRawSize;

        b(String str, int i3, int i16) {
            this.mediaCoverURL = str;
            this.mediaRawSize = new Size(i3, i16);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k
        @NotNull
        public String getMediaCoverURL() {
            return this.mediaCoverURL;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k
        @NotNull
        public Size getMediaRawSize() {
            return this.mediaRawSize;
        }
    }

    @Nullable
    public static final IGProImage a(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed) {
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        IGProImage customCover = iGProContentRecommendFeed.getCustomCover();
        if (!e(iGProContentRecommendFeed)) {
            return null;
        }
        return customCover;
    }

    @NotNull
    public static final String b(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed) {
        String d16;
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        IGProImage customCover = iGProContentRecommendFeed.getCustomCover();
        if (customCover == null || (d16 = d(customCover)) == null) {
            return "";
        }
        return d16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final String c(@NotNull IGProImage iGProImage) {
        boolean z16;
        Intrinsics.checkNotNullParameter(iGProImage, "<this>");
        ArrayList<IGProThumbImage> thumbImages = iGProImage.getThumbImages();
        IGProThumbImage iGProThumbImage = null;
        if (thumbImages != null) {
            Iterator<T> it = thumbImages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((IGProThumbImage) next).getLevel() == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    iGProThumbImage = next;
                    break;
                }
            }
            iGProThumbImage = iGProThumbImage;
        }
        if (iGProThumbImage != null && iGProImage.getImageType() != 1) {
            String url = iGProThumbImage.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "{\n        thumbImage.url\n    }");
            return url;
        }
        String url2 = iGProImage.getUrl();
        Intrinsics.checkNotNullExpressionValue(url2, "{\n        url\n    }");
        return url2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final String d(@NotNull IGProImage iGProImage) {
        boolean z16;
        Intrinsics.checkNotNullParameter(iGProImage, "<this>");
        ArrayList<IGProThumbImage> thumbImages = iGProImage.getThumbImages();
        IGProThumbImage iGProThumbImage = null;
        if (thumbImages != null) {
            Iterator<T> it = thumbImages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((IGProThumbImage) next).getLevel() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    iGProThumbImage = next;
                    break;
                }
            }
            iGProThumbImage = iGProThumbImage;
        }
        if (iGProThumbImage != null && iGProImage.getImageType() != 1) {
            String url = iGProThumbImage.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "{\n        thumbImage.url\n    }");
            return url;
        }
        String url2 = iGProImage.getUrl();
        Intrinsics.checkNotNullExpressionValue(url2, "{\n        url\n    }");
        return url2;
    }

    public static final boolean e(@NotNull IGProContentRecommendFeed iGProContentRecommendFeed) {
        Intrinsics.checkNotNullParameter(iGProContentRecommendFeed, "<this>");
        if (b(iGProContentRecommendFeed).length() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.h f(@Nullable k kVar) {
        Object m476constructorimpl;
        float coerceIn;
        float f16;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (kVar != null && kVar.getMediaRawSize().getWidth() != 0) {
            f16 = kVar.getMediaRawSize().getHeight() / kVar.getMediaRawSize().getWidth();
            m476constructorimpl = Result.m476constructorimpl(Float.valueOf(f16));
            Float valueOf = Float.valueOf(0.75f);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = valueOf;
            }
            coerceIn = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl).floatValue(), 0.75f, 1.25f);
            float[] fArr = f217795a;
            int[] iArr = f217796b;
            Typeface DEFAULT_BOLD = Typeface.DEFAULT_BOLD;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_BOLD, "DEFAULT_BOLD");
            return new com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.h(true, coerceIn, fArr, iArr, 2, DEFAULT_BOLD, 0, 64, null);
        }
        f16 = 0.75f;
        m476constructorimpl = Result.m476constructorimpl(Float.valueOf(f16));
        Float valueOf2 = Float.valueOf(0.75f);
        if (Result.m482isFailureimpl(m476constructorimpl)) {
        }
        coerceIn = RangesKt___RangesKt.coerceIn(((Number) m476constructorimpl).floatValue(), 0.75f, 1.25f);
        float[] fArr2 = f217795a;
        int[] iArr2 = f217796b;
        Typeface DEFAULT_BOLD2 = Typeface.DEFAULT_BOLD;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_BOLD2, "DEFAULT_BOLD");
        return new com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.h(true, coerceIn, fArr2, iArr2, 2, DEFAULT_BOLD2, 0, 64, null);
    }

    @NotNull
    public static final k g(@NotNull IGProImage cover) {
        Intrinsics.checkNotNullParameter(cover, "cover");
        return new a(cover);
    }

    @NotNull
    public static final k h(@NotNull String url, int i3, int i16) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new b(url, i3, i16);
    }

    @NotNull
    public static final GProStVideo i(@NotNull IGProVideo iGProVideo) {
        int collectionSizeOrDefault;
        Object m476constructorimpl;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(iGProVideo, "<this>");
        GProStVideo gProStVideo = new GProStVideo();
        gProStVideo.height = iGProVideo.getFileSize();
        gProStVideo.duration = iGProVideo.getDuration();
        gProStVideo.width = iGProVideo.getWidth();
        gProStVideo.height = iGProVideo.getHeight();
        gProStVideo.playUrl = iGProVideo.getPlayUrl();
        gProStVideo.videoPrior = iGProVideo.getPrior();
        gProStVideo.videoRate = iGProVideo.getRate();
        GProStImage gProStImage = new GProStImage();
        IGProImage cover = iGProVideo.getCover();
        gProStImage.picUrl = cover.getUrl();
        gProStImage.width = cover.getWidth();
        gProStImage.height = cover.getHeight();
        ArrayList<IGProThumbImage> thumbImages = cover.getThumbImages();
        Intrinsics.checkNotNullExpressionValue(thumbImages, "videoCover.thumbImages");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(thumbImages, 10);
        ArrayList<GProStImageUrl> arrayList = new ArrayList<>(collectionSizeOrDefault);
        for (IGProThumbImage iGProThumbImage : thumbImages) {
            GProStImageUrl gProStImageUrl = new GProStImageUrl();
            gProStImageUrl.width = iGProThumbImage.getWidth();
            gProStImageUrl.height = iGProThumbImage.getHeight();
            gProStImageUrl.url = iGProThumbImage.getUrl();
            gProStImageUrl.levelType = iGProThumbImage.getLevel();
            arrayList.add(gProStImageUrl);
        }
        gProStImage.vecImageUrlList = arrayList;
        gProStVideo.cover = gProStImage;
        gProStVideo.displayIndex = iGProVideo.getDisplayIndex();
        gProStVideo.fileId = iGProVideo.getFileId();
        try {
            Result.Companion companion = Result.INSTANCE;
            ArrayList<IGProTransVideo> transVideos = iGProVideo.getTransVideos();
            Intrinsics.checkNotNullExpressionValue(transVideos, "video.getTransVideos()");
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(transVideos, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            for (IGProTransVideo iGProTransVideo : transVideos) {
                GProStVideoUrl gProStVideoUrl = new GProStVideoUrl();
                gProStVideoUrl.levelType = iGProTransVideo.getSpecification();
                gProStVideoUrl.playUrl = iGProTransVideo.getPlayUrl();
                gProStVideoUrl.videoPrior = iGProTransVideo.getPrior();
                gProStVideoUrl.videoRate = iGProTransVideo.getRate();
                arrayList2.add(gProStVideoUrl);
            }
            m476constructorimpl = Result.m476constructorimpl(arrayList2);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = gProStVideo.vecVideoUrlList;
        }
        gProStVideo.vecVideoUrlList = (ArrayList) m476constructorimpl;
        return gProStVideo;
    }
}
