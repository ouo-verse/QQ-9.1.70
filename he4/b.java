package he4;

import android.graphics.Bitmap;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import le4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lhe4/b;", "", "Lcom/tencent/tavcut/model/ClipSource;", "clipSource", "Lcom/tencent/tavcut/composition/model/component/Size;", "size", "Lhe4/a;", "a", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f404814a = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lhe4/b$a;", "Lhe4/a;", "", "a", "", "atTimeUs", "Landroid/graphics/Bitmap;", "getThumbAtTime", "release", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "Lcom/tencent/tavkit/component/TAVSourceImageGenerator;", "tavSourceImageGenerator", "b", "Landroid/graphics/Bitmap;", "imageThumb", "Lcom/tencent/tavcut/model/ClipSource;", "c", "Lcom/tencent/tavcut/model/ClipSource;", "getClipSource", "()Lcom/tencent/tavcut/model/ClipSource;", "clipSource", "Lcom/tencent/tavcut/composition/model/component/Size;", "d", "Lcom/tencent/tavcut/composition/model/component/Size;", "getSize", "()Lcom/tencent/tavcut/composition/model/component/Size;", "size", "<init>", "(Lcom/tencent/tavcut/model/ClipSource;Lcom/tencent/tavcut/composition/model/component/Size;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class a implements he4.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private TAVSourceImageGenerator tavSourceImageGenerator;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private Bitmap imageThumb;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ClipSource clipSource;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Size size;

        public a(@NotNull ClipSource clipSource, @NotNull Size size) {
            Intrinsics.checkParameterIsNotNull(clipSource, "clipSource");
            Intrinsics.checkParameterIsNotNull(size, "size");
            this.clipSource = clipSource;
            this.size = size;
        }

        public void a() {
            int i3;
            long j3;
            float f16;
            long roundToLong;
            ArrayList arrayListOf;
            float f17;
            AssetImageGenerator assetImageGenerator;
            ClipSource clipSource = this.clipSource;
            String str = clipSource.path;
            if (str != null) {
                int i16 = 0;
                if (clipSource.type == ClipSource.ClipType.VIDEO) {
                    if (this.tavSourceImageGenerator != null) {
                        return;
                    }
                    if (str == null) {
                        str = "";
                    }
                    URLAsset a16 = f.a(str);
                    if (a16 != null) {
                        TAVAssetTrackResource tAVAssetTrackResource = new TAVAssetTrackResource(a16);
                        ie4.a aVar = ie4.a.f407564a;
                        Long l3 = this.clipSource.startOffset;
                        if (l3 != null) {
                            j3 = l3.longValue();
                        } else {
                            j3 = 0;
                        }
                        tAVAssetTrackResource.setSourceTimeRange(aVar.b(j3, this.clipSource.duration));
                        ClipSource clipSource2 = this.clipSource;
                        float f18 = (float) clipSource2.duration;
                        Float f19 = clipSource2.speed;
                        if (f19 != null) {
                            f16 = f19.floatValue();
                        } else {
                            f16 = 1.0f;
                        }
                        roundToLong = MathKt__MathJVMKt.roundToLong(f18 / f16);
                        tAVAssetTrackResource.setScaledDuration(aVar.a(roundToLong));
                        TAVClip tAVClip = new TAVClip(tAVAssetTrackResource);
                        TAVComposition tAVComposition = new TAVComposition();
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(tAVClip);
                        tAVComposition.addVideoChannel(arrayListOf);
                        TAVSource buildSource = new TAVCompositionBuilder(tAVComposition).buildSource();
                        Integer num = this.size.width;
                        float f26 = 0.0f;
                        if (num != null) {
                            f17 = num.intValue();
                        } else {
                            f17 = 0.0f;
                        }
                        Integer num2 = this.size.height;
                        if (num2 != null) {
                            f26 = num2.intValue();
                        }
                        TAVSourceImageGenerator tAVSourceImageGenerator = new TAVSourceImageGenerator(buildSource, new CGSize(f17, f26));
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
                    com.tencent.videocut.utils.b bVar = com.tencent.videocut.utils.b.f384233a;
                    Integer num3 = this.size.width;
                    if (num3 != null) {
                        i3 = num3.intValue();
                    } else {
                        i3 = 0;
                    }
                    Integer num4 = this.size.height;
                    if (num4 != null) {
                        i16 = num4.intValue();
                    }
                    this.imageThumb = bVar.b(str, new android.util.Size(i3, i16));
                }
            }
        }

        @Override // he4.a
        @Nullable
        public Bitmap getThumbAtTime(long atTimeUs) {
            a();
            if (this.clipSource.type == ClipSource.ClipType.VIDEO) {
                TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
                if (tAVSourceImageGenerator != null) {
                    return tAVSourceImageGenerator.generateThumbnailAtTimeSync(ie4.a.f407564a.a(atTimeUs));
                }
                return null;
            }
            return this.imageThumb;
        }

        @Override // he4.a
        public void release() {
            AssetImageGenerator assetImageGenerator;
            TAVSourceImageGenerator tAVSourceImageGenerator = this.tavSourceImageGenerator;
            if (tAVSourceImageGenerator != null && (assetImageGenerator = tAVSourceImageGenerator.getAssetImageGenerator()) != null) {
                assetImageGenerator.release();
            }
            this.tavSourceImageGenerator = null;
        }
    }

    b() {
    }

    @JvmStatic
    @NotNull
    public static final he4.a a(@NotNull ClipSource clipSource, @NotNull Size size) {
        Intrinsics.checkParameterIsNotNull(clipSource, "clipSource");
        Intrinsics.checkParameterIsNotNull(size, "size");
        return new a(clipSource, size);
    }
}
