package com.tencent.tavcut.core.render.thumb;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.type.ClipType;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.core.render.util.CMTimeUtil;
import com.tencent.tavcut.core.utils.d;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.videocut.utils.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/tavcut/core/render/thumb/ThumbProviderAccessor;", "", "()V", "TAG", "", "getThumbProvider", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "clipSource", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "size", "Lorg/light/lightAssetKit/components/Size;", "ThumbProvider", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class ThumbProviderAccessor {
    public static final ThumbProviderAccessor INSTANCE = new ThumbProviderAccessor();
    private static final String TAG = "ThumbProviderAccessor";

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016JJ\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u001128\u0010\u0014\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u0015H\u0016JP\u0010\u001a\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b28\u0010\u0014\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00130\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/tavcut/core/render/thumb/ThumbProviderAccessor$ThumbProvider;", "Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "clipSource", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "size", "Lorg/light/lightAssetKit/components/Size;", "(Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;Lorg/light/lightAssetKit/components/Size;)V", "getClipSource", "()Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "imageThumb", "Landroid/graphics/Bitmap;", "getSize", "()Lorg/light/lightAssetKit/components/Size;", "tavSourceImageGenerator", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "getThumbAtTime", "atTimeUs", "", "getThumbAtTimeAsync", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", MimeHelper.IMAGE_SUBTYPE_BITMAP, "actualTime", "getThumbAtTimesAsync", "", "init", "release", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class ThumbProvider implements IThumbProvider {

        @NotNull
        private final ClipSource clipSource;
        private Bitmap imageThumb;

        @NotNull
        private final Size size;
        private TAVSourceImageGenerator tavSourceImageGenerator;

        public ThumbProvider(@NotNull ClipSource clipSource, @NotNull Size size) {
            Intrinsics.checkParameterIsNotNull(clipSource, "clipSource");
            Intrinsics.checkParameterIsNotNull(size, "size");
            this.clipSource = clipSource;
            this.size = size;
        }

        @NotNull
        public final ClipSource getClipSource() {
            return this.clipSource;
        }

        @NotNull
        public final Size getSize() {
            return this.size;
        }

        @Override // com.tencent.tavcut.core.render.thumb.IThumbProvider
        @Nullable
        public Bitmap getThumbAtTime(long atTimeUs) {
            init();
            if (this.clipSource.getType() == ClipType.VIDEO) {
                try {
                    TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
                    if (tAVSourceImageGenerator == null) {
                        return null;
                    }
                    return tAVSourceImageGenerator.generateThumbnailAtTimeSync(CMTimeUtil.INSTANCE.genCMTimeFromUs(atTimeUs));
                } catch (Exception e16) {
                    TavLogger.e(ThumbProviderAccessor.TAG, "getCoverAtTime " + atTimeUs + " exception: " + e16.getMessage());
                    return null;
                }
            }
            return this.imageThumb;
        }

        @Override // com.tencent.tavcut.core.render.thumb.IThumbProvider
        public void getThumbAtTimeAsync(long atTimeUs, @NotNull Function2<? super Bitmap, ? super Long, Unit> callback) {
            ArrayList arrayListOf;
            Intrinsics.checkParameterIsNotNull(callback, "callback");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(atTimeUs));
            getThumbAtTimesAsync(arrayListOf, callback);
        }

        @Override // com.tencent.tavcut.core.render.thumb.IThumbProvider
        public void getThumbAtTimesAsync(@NotNull List<Long> atTimeUs, @NotNull final Function2<? super Bitmap, ? super Long, Unit> callback) {
            Intrinsics.checkParameterIsNotNull(atTimeUs, "atTimeUs");
            Intrinsics.checkParameterIsNotNull(callback, "callback");
            init();
            if (this.clipSource.getType() == ClipType.VIDEO) {
                ArrayList arrayList = new ArrayList();
                Iterator<Long> it = atTimeUs.iterator();
                while (it.hasNext()) {
                    arrayList.add(CMTimeUtil.INSTANCE.genCMTimeFromUs(it.next().longValue()));
                }
                TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
                if (tAVSourceImageGenerator != null) {
                    tAVSourceImageGenerator.generateThumbnailAtTimes(arrayList, new AssetImageGenerator.ImageGeneratorListener() { // from class: com.tencent.tavcut.core.render.thumb.ThumbProviderAccessor$ThumbProvider$getThumbAtTimesAsync$1
                        @Override // com.tencent.tav.core.AssetImageGenerator.ImageGeneratorListener
                        public final void onCompletion(@NotNull CMTime cMTime, @Nullable Bitmap bitmap, @Nullable CMTime cMTime2, @NotNull AssetImageGenerator.AssetImageGeneratorResult assetImageGeneratorResult) {
                            long j3;
                            Intrinsics.checkParameterIsNotNull(cMTime, "<anonymous parameter 0>");
                            Intrinsics.checkParameterIsNotNull(assetImageGeneratorResult, "<anonymous parameter 3>");
                            Function2 function2 = Function2.this;
                            if (cMTime2 != null) {
                                j3 = cMTime2.getTimeUs();
                            } else {
                                j3 = 0;
                            }
                            function2.invoke(bitmap, Long.valueOf(TimeUtil.us2Milli(j3)));
                        }
                    });
                    return;
                }
                return;
            }
            Iterator<Long> it5 = atTimeUs.iterator();
            while (it5.hasNext()) {
                callback.invoke(this.imageThumb, Long.valueOf(it5.next().longValue()));
            }
        }

        @Override // com.tencent.tavcut.core.render.thumb.IThumbProvider
        public void init() {
            long j3;
            float f16;
            long roundToLong;
            ArrayList arrayListOf;
            AssetImageGenerator assetImageGenerator;
            String path = this.clipSource.getPath();
            if (path != null) {
                if (this.clipSource.getType() == ClipType.VIDEO) {
                    if (this.tavSourceImageGenerator != null) {
                        return;
                    }
                    String path2 = this.clipSource.getPath();
                    if (path2 == null) {
                        path2 = "";
                    }
                    URLAsset a16 = d.a(path2);
                    if (a16 != null) {
                        TAVAssetTrackResource tAVAssetTrackResource = new TAVAssetTrackResource(a16);
                        CMTimeUtil cMTimeUtil = CMTimeUtil.INSTANCE;
                        Long startOffset = this.clipSource.getStartOffset();
                        if (startOffset != null) {
                            j3 = startOffset.longValue();
                        } else {
                            j3 = 0;
                        }
                        tAVAssetTrackResource.setSourceTimeRange(cMTimeUtil.genCMTimeRangeFromUs(j3, this.clipSource.getDuration()));
                        float duration = (float) this.clipSource.getDuration();
                        Float speed = this.clipSource.getSpeed();
                        if (speed != null) {
                            f16 = speed.floatValue();
                        } else {
                            f16 = 1.0f;
                        }
                        roundToLong = MathKt__MathJVMKt.roundToLong(duration / f16);
                        tAVAssetTrackResource.setScaledDuration(cMTimeUtil.genCMTimeFromUs(roundToLong));
                        TAVClip tAVClip = new TAVClip(tAVAssetTrackResource);
                        TAVComposition tAVComposition = new TAVComposition();
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(tAVClip);
                        tAVComposition.addVideoChannel(arrayListOf);
                        TAVSource buildSource = new TAVCompositionBuilder(tAVComposition).buildSource();
                        Size size = this.size;
                        TAVSourceImageGenerator tAVSourceImageGenerator = new TAVSourceImageGenerator(buildSource, new CGSize(size.width, size.height));
                        this.tavSourceImageGenerator = tAVSourceImageGenerator;
                        AssetImageGenerator assetImageGenerator2 = tAVSourceImageGenerator.getAssetImageGenerator();
                        if (assetImageGenerator2 != null) {
                            assetImageGenerator2.setApertureMode(AssetImageGenerator.ApertureMode.aspectFill);
                        }
                        TAVSourceImageGenerator tAVSourceImageGenerator2 = this.tavSourceImageGenerator;
                        if (tAVSourceImageGenerator2 != null && (assetImageGenerator = tAVSourceImageGenerator2.getAssetImageGenerator()) != null) {
                            assetImageGenerator.setForceUseFbo(true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                Bitmap bitmap = this.imageThumb;
                if (bitmap == null || (bitmap != null && bitmap.isRecycled())) {
                    b bVar = b.f384233a;
                    Size size2 = this.size;
                    this.imageThumb = bVar.b(path, new android.util.Size(size2.width, size2.height));
                }
            }
        }

        @Override // com.tencent.tavcut.core.render.thumb.IThumbProvider
        public void release() {
            AssetImageGenerator assetImageGenerator;
            TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
            if (tAVSourceImageGenerator != null && (assetImageGenerator = tAVSourceImageGenerator.getAssetImageGenerator()) != null) {
                assetImageGenerator.release();
            }
            this.tavSourceImageGenerator = null;
        }
    }

    ThumbProviderAccessor() {
    }

    @JvmStatic
    @NotNull
    public static final IThumbProvider getThumbProvider(@NotNull ClipSource clipSource, @NotNull Size size) {
        Intrinsics.checkParameterIsNotNull(clipSource, "clipSource");
        Intrinsics.checkParameterIsNotNull(size, "size");
        return new ThumbProvider(clipSource, size);
    }
}
