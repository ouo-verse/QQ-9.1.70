package com.tencent.tav.core.composition;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Transform;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface VideoCompositionLayerInstruction {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class CropRectangleRamp {

        @NonNull
        public boolean available = true;

        @Nullable
        public CGRect endCropRectangle;

        @Nullable
        public CGRect startCropRectangle;

        @NonNull
        public CMTimeRange timeRange;

        public CropRectangleRamp(@NonNull CMTimeRange cMTimeRange) {
            this.timeRange = cMTimeRange;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class OpacityRamp {

        @NonNull
        public CMTimeRange timeRange;
        public float startOpacity = 1.0f;
        public float endOpacity = 1.0f;

        @NonNull
        public boolean available = true;

        public OpacityRamp(@NonNull CMTimeRange cMTimeRange) {
            this.timeRange = cMTimeRange;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class TransformRamp {

        @NonNull
        public boolean available = true;

        @Nullable
        public Transform endTransform;

        @Nullable
        public Transform startTransform;

        @NonNull
        public CMTimeRange timeRange;

        public TransformRamp(@NonNull CMTimeRange cMTimeRange) {
            this.timeRange = cMTimeRange;
        }
    }

    @NonNull
    CropRectangleRamp getCropRectangleRampForTime(CMTime cMTime);

    @NonNull
    OpacityRamp getOpacityRampForTime(CMTime cMTime);

    int getTrackID();

    @NonNull
    TransformRamp getTransformRampForTime(CMTime cMTime);
}
