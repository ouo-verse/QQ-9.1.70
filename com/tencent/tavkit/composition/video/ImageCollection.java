package com.tencent.tavkit.composition.video;

import androidx.annotation.NonNull;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ImageCollection {

    @NonNull
    private final List<TrackImagePair> videoChannelImages = new ArrayList();

    @NonNull
    private final List<TrackImagePair> overlayImages = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class TrackImagePair {

        @NonNull
        private CIImage image;

        @NonNull
        private TAVVideoCompositionTrack track;

        public TrackImagePair(@NonNull CIImage cIImage, @NonNull TAVVideoCompositionTrack tAVVideoCompositionTrack) {
            this.image = cIImage;
            this.track = tAVVideoCompositionTrack;
        }

        @NonNull
        public CIImage getImage() {
            return this.image;
        }

        @NonNull
        public TAVVideoCompositionTrack getTrack() {
            return this.track;
        }

        public void setImage(@NonNull CIImage cIImage) {
            this.image = cIImage;
        }

        public void setTrack(@NonNull TAVVideoCompositionTrack tAVVideoCompositionTrack) {
            this.track = tAVVideoCompositionTrack;
        }
    }

    public void addChannelImage(CIImage cIImage, TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        this.videoChannelImages.add(new TrackImagePair(cIImage, tAVVideoCompositionTrack));
    }

    public void addOverlayImage(CIImage cIImage, TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        this.overlayImages.add(new TrackImagePair(cIImage, tAVVideoCompositionTrack));
    }

    @NonNull
    public List<TrackImagePair> getOverlayImages() {
        return this.overlayImages;
    }

    @NonNull
    public List<TrackImagePair> getVideoChannelImages() {
        return this.videoChannelImages;
    }

    public String toString() {
        return "ImageCollection{videoChannelImages=" + this.videoChannelImages + ", overlayImages=" + this.overlayImages + '}';
    }
}
