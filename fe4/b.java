package fe4;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lfe4/b;", "", "", "Lfe4/b$a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "setVideoChannelImages", "(Ljava/util/List;)V", "videoChannelImages", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<a> videoChannelImages = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lfe4/b$a;", "", "Lcom/tencent/tavkit/ciimage/CIImage;", "a", "Lcom/tencent/tavkit/ciimage/CIImage;", "()Lcom/tencent/tavkit/ciimage/CIImage;", "b", "(Lcom/tencent/tavkit/ciimage/CIImage;)V", "image", "Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;", "Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;", "getTrack", "()Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;", "track", "<init>", "(Lcom/tencent/tavkit/ciimage/CIImage;Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private CIImage image;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final TAVVideoCompositionTrack track;

        public a(@NotNull CIImage image, @Nullable TAVVideoCompositionTrack tAVVideoCompositionTrack) {
            Intrinsics.checkParameterIsNotNull(image, "image");
            this.image = image;
            this.track = tAVVideoCompositionTrack;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final CIImage getImage() {
            return this.image;
        }

        public final void b(@NotNull CIImage cIImage) {
            Intrinsics.checkParameterIsNotNull(cIImage, "<set-?>");
            this.image = cIImage;
        }
    }

    @NotNull
    public final List<a> a() {
        return this.videoChannelImages;
    }
}
