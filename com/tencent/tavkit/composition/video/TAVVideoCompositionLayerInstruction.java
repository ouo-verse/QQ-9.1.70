package com.tencent.tavkit.composition.video;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import androidx.annotation.NonNull;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVVideoCompositionLayerInstruction implements VideoCompositionLayerInstruction {
    private final TAVVideoCompositionTrack imageSource;
    private Matrix preferredTransform;
    private CMTimeRange timeRange;
    private int trackID;
    private TAVVideoTransition transition;
    private final TAVVideoConfiguration videoConfiguration;

    public TAVVideoCompositionLayerInstruction(int i3, @NonNull TAVVideoConfiguration tAVVideoConfiguration, @NonNull TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        this.trackID = i3;
        this.videoConfiguration = tAVVideoConfiguration;
        this.imageSource = tAVVideoCompositionTrack;
        this.preferredTransform = new Matrix();
    }

    public Bitmap applySourceImage(Bitmap bitmap, CMTime cMTime, CGSize cGSize) {
        return null;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public VideoCompositionLayerInstruction.CropRectangleRamp getCropRectangleRampForTime(CMTime cMTime) {
        return new VideoCompositionLayerInstruction.CropRectangleRamp(CMTimeRange.fromSeconds(0.0f, 0.0f));
    }

    @NonNull
    public TAVVideoCompositionTrack getImageSource() {
        return this.imageSource;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public VideoCompositionLayerInstruction.OpacityRamp getOpacityRampForTime(CMTime cMTime) {
        return new VideoCompositionLayerInstruction.OpacityRamp(CMTimeRange.fromSeconds(0.0f, 0.0f));
    }

    public Matrix getPreferredTransform() {
        return this.preferredTransform;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public int getTrackID() {
        return this.trackID;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public VideoCompositionLayerInstruction.TransformRamp getTransformRampForTime(CMTime cMTime) {
        return new VideoCompositionLayerInstruction.TransformRamp(CMTimeRange.fromSeconds(0.0f, 0.0f));
    }

    public TAVVideoTransition getTransition() {
        return this.transition;
    }

    @NotNull
    public TAVVideoConfiguration getVideoConfiguration() {
        return this.videoConfiguration;
    }

    public void setPreferredTransform(Matrix matrix) {
        this.preferredTransform = matrix;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public void setTrackID(int i3) {
        this.trackID = i3;
    }

    public void setTransition(TAVVideoTransition tAVVideoTransition) {
        this.transition = tAVVideoTransition;
    }

    public String toString() {
        return "TAVVideoCompositionLayerInstruction{trackID=" + this.trackID + ", timeRange=" + this.timeRange.toSimpleString() + ", preferredTransform=" + this.preferredTransform + ", transition=" + this.transition + ", videoConfiguration=" + this.videoConfiguration + '}';
    }

    public TAVVideoCompositionLayerInstruction(int i3, TAVTransitionableVideo tAVTransitionableVideo) {
        this(i3, tAVTransitionableVideo.getVideoConfiguration(), tAVTransitionableVideo);
        setTimeRange(tAVTransitionableVideo.getTimeRange());
        setTransition(tAVTransitionableVideo.getVideoTransition());
    }
}
