package com.tencent.tavcut.core.render.rendernode;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/core/render/rendernode/ImageParams;", "", "()V", "videoChannelImages", "", "Lcom/tencent/tavcut/core/render/rendernode/ImageParams$ImageTrackPair;", "getVideoChannelImages", "()Ljava/util/List;", "setVideoChannelImages", "(Ljava/util/List;)V", "ImageTrackPair", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class ImageParams {

    @NotNull
    private List<ImageTrackPair> videoChannelImages = new ArrayList();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/tavcut/core/render/rendernode/ImageParams$ImageTrackPair;", "", "image", "Lcom/tencent/tavkit/ciimage/CIImage;", "track", "Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;", "(Lcom/tencent/tavkit/ciimage/CIImage;Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;)V", "getImage", "()Lcom/tencent/tavkit/ciimage/CIImage;", "setImage", "(Lcom/tencent/tavkit/ciimage/CIImage;)V", "getTrack", "()Lcom/tencent/tavkit/composition/model/TAVVideoCompositionTrack;", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class ImageTrackPair {

        @NotNull
        private CIImage image;

        @Nullable
        private final TAVVideoCompositionTrack track;

        public ImageTrackPair(@NotNull CIImage image, @Nullable TAVVideoCompositionTrack tAVVideoCompositionTrack) {
            Intrinsics.checkParameterIsNotNull(image, "image");
            this.image = image;
            this.track = tAVVideoCompositionTrack;
        }

        @NotNull
        public final CIImage getImage() {
            return this.image;
        }

        @Nullable
        public final TAVVideoCompositionTrack getTrack() {
            return this.track;
        }

        public final void setImage(@NotNull CIImage cIImage) {
            Intrinsics.checkParameterIsNotNull(cIImage, "<set-?>");
            this.image = cIImage;
        }
    }

    @NotNull
    public final List<ImageTrackPair> getVideoChannelImages() {
        return this.videoChannelImages;
    }

    public final void setVideoChannelImages(@NotNull List<ImageTrackPair> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.videoChannelImages = list;
    }
}
