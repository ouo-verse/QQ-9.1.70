package com.tencent.tav.core.composition;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Transform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MutableVideoCompositionLayerInstruction implements VideoCompositionLayerInstruction {
    private AssetTrack assetTrack;
    private List<VideoCompositionLayerInstruction.CropRectangleRamp> cropRectangleRampList;
    private CMTime duration;
    private boolean flipX;
    private boolean flipY;
    private List<VideoCompositionLayerInstruction.OpacityRamp> opacityRampList;
    private int trackID;
    private List<VideoCompositionLayerInstruction.TransformRamp> transformRampList;

    public MutableVideoCompositionLayerInstruction(@NonNull AssetTrack assetTrack) {
        this.transformRampList = new ArrayList();
        this.opacityRampList = new ArrayList();
        this.cropRectangleRampList = new ArrayList();
        this.duration = new CMTime(TTL.MAX_VALUE);
        this.flipX = false;
        this.flipY = false;
        this.trackID = assetTrack.getTrackID();
        this.assetTrack = assetTrack;
        this.duration = assetTrack.getDuration();
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    @NonNull
    public VideoCompositionLayerInstruction.CropRectangleRamp getCropRectangleRampForTime(CMTime cMTime) {
        for (VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp : this.cropRectangleRampList) {
            if (cropRectangleRamp.timeRange.containsTime(cMTime)) {
                return cropRectangleRamp;
            }
        }
        return new VideoCompositionLayerInstruction.CropRectangleRamp(new CMTimeRange(CMTime.CMTimeZero, this.duration));
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    @NonNull
    public VideoCompositionLayerInstruction.OpacityRamp getOpacityRampForTime(CMTime cMTime) {
        for (VideoCompositionLayerInstruction.OpacityRamp opacityRamp : this.opacityRampList) {
            if (opacityRamp.timeRange.containsTime(cMTime)) {
                return opacityRamp;
            }
        }
        return new VideoCompositionLayerInstruction.OpacityRamp(new CMTimeRange(CMTime.CMTimeZero, this.duration));
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public int getTrackID() {
        return this.trackID;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    @NonNull
    public VideoCompositionLayerInstruction.TransformRamp getTransformRampForTime(CMTime cMTime) {
        for (VideoCompositionLayerInstruction.TransformRamp transformRamp : this.transformRampList) {
            if (transformRamp.timeRange.containsTime(cMTime)) {
                return transformRamp;
            }
        }
        return new VideoCompositionLayerInstruction.TransformRamp(new CMTimeRange(CMTime.CMTimeZero, this.duration));
    }

    public void setCropRectangle(CGRect cGRect, @NonNull CMTime cMTime) {
        CMTime cMTime2 = this.duration;
        Iterator<VideoCompositionLayerInstruction.CropRectangleRamp> it = this.cropRectangleRampList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            VideoCompositionLayerInstruction.CropRectangleRamp next = it.next();
            if (next.timeRange.containsTime(cMTime)) {
                cMTime2 = next.timeRange.getEnd();
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTime.sub(next.timeRange.getStart()));
                break;
            }
        }
        VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp = new VideoCompositionLayerInstruction.CropRectangleRamp(new CMTimeRange(cMTime, cMTime2.sub(cMTime)));
        cropRectangleRamp.startCropRectangle = cGRect;
        cropRectangleRamp.endCropRectangle = cGRect;
        this.cropRectangleRampList.add(cropRectangleRamp);
    }

    public void setCropRectangleRampFromStartCropRectangle(CGRect cGRect, CGRect cGRect2, @NonNull CMTimeRange cMTimeRange) {
        VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp = new VideoCompositionLayerInstruction.CropRectangleRamp(cMTimeRange);
        cropRectangleRamp.startCropRectangle = cGRect;
        cropRectangleRamp.endCropRectangle = cGRect2;
        Iterator<VideoCompositionLayerInstruction.CropRectangleRamp> it = this.cropRectangleRampList.iterator();
        if (it.hasNext()) {
            VideoCompositionLayerInstruction.CropRectangleRamp next = it.next();
            CMTime start = next.timeRange.getStart();
            CMTime end = next.timeRange.getEnd();
            if (cMTimeRange.containsTime(start) && cMTimeRange.containsTime(end)) {
                next.timeRange = CMTimeRange.CMTimeRangeInvalid;
            } else if (cMTimeRange.containsTime(start) && !cMTimeRange.containsTime(end)) {
                next.timeRange = new CMTimeRange(cMTimeRange.getEnd(), next.timeRange.getEnd().sub(cMTimeRange.getEnd()));
            } else if (cMTimeRange.containsTime(end) && !cMTimeRange.containsTime(start)) {
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTimeRange.getStart().sub(next.timeRange.getStart()));
            }
        }
        int i3 = 0;
        while (i3 < this.cropRectangleRampList.size()) {
            VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp2 = this.cropRectangleRampList.get(i3);
            if (cropRectangleRamp2.timeRange == CMTimeRange.CMTimeRangeInvalid) {
                this.cropRectangleRampList.remove(cropRectangleRamp2);
                i3--;
            }
            i3++;
        }
        this.cropRectangleRampList.add(cropRectangleRamp);
    }

    public void setFlipX(boolean z16) {
        this.flipX = z16;
    }

    public void setFlipY(boolean z16) {
        this.flipY = z16;
    }

    public void setOpacity(float f16, @NonNull CMTime cMTime) {
        CMTime cMTime2 = this.duration;
        Iterator<VideoCompositionLayerInstruction.OpacityRamp> it = this.opacityRampList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            VideoCompositionLayerInstruction.OpacityRamp next = it.next();
            if (next.timeRange.containsTime(cMTime)) {
                cMTime2 = next.timeRange.getEnd();
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTime.sub(next.timeRange.getStart()));
                break;
            }
        }
        VideoCompositionLayerInstruction.OpacityRamp opacityRamp = new VideoCompositionLayerInstruction.OpacityRamp(new CMTimeRange(cMTime, cMTime2.sub(cMTime)));
        opacityRamp.startOpacity = f16;
        opacityRamp.endOpacity = f16;
        this.opacityRampList.add(opacityRamp);
    }

    public void setOpacityRampFromStartOpacity(float f16, float f17, @NonNull CMTimeRange cMTimeRange) {
        VideoCompositionLayerInstruction.OpacityRamp opacityRamp = new VideoCompositionLayerInstruction.OpacityRamp(cMTimeRange);
        opacityRamp.startOpacity = f16;
        opacityRamp.endOpacity = f17;
        Iterator<VideoCompositionLayerInstruction.OpacityRamp> it = this.opacityRampList.iterator();
        if (it.hasNext()) {
            VideoCompositionLayerInstruction.OpacityRamp next = it.next();
            CMTime start = next.timeRange.getStart();
            CMTime end = next.timeRange.getEnd();
            if (cMTimeRange.containsTime(start) && cMTimeRange.containsTime(end)) {
                next.timeRange = CMTimeRange.CMTimeRangeInvalid;
            } else if (cMTimeRange.containsTime(start) && !cMTimeRange.containsTime(end)) {
                next.timeRange = new CMTimeRange(cMTimeRange.getEnd(), next.timeRange.getEnd().sub(cMTimeRange.getEnd()));
            } else if (cMTimeRange.containsTime(end) && !cMTimeRange.containsTime(start)) {
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTimeRange.getStart().sub(next.timeRange.getStart()));
            }
        }
        int i3 = 0;
        while (i3 < this.opacityRampList.size()) {
            VideoCompositionLayerInstruction.OpacityRamp opacityRamp2 = this.opacityRampList.get(i3);
            if (opacityRamp2.timeRange == CMTimeRange.CMTimeRangeInvalid) {
                this.opacityRampList.remove(opacityRamp2);
                i3--;
            }
            i3++;
        }
        this.opacityRampList.add(opacityRamp);
    }

    public void setTrackID(int i3) {
        this.trackID = i3;
    }

    public void setTransform(@Nullable Transform transform, @NonNull CMTime cMTime) {
        CMTime cMTime2 = this.duration;
        Iterator<VideoCompositionLayerInstruction.TransformRamp> it = this.transformRampList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            VideoCompositionLayerInstruction.TransformRamp next = it.next();
            if (next.timeRange.containsTime(cMTime)) {
                cMTime2 = next.timeRange.getEnd();
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTime.sub(next.timeRange.getStart()));
                break;
            }
        }
        VideoCompositionLayerInstruction.TransformRamp transformRamp = new VideoCompositionLayerInstruction.TransformRamp(new CMTimeRange(cMTime, cMTime2.sub(cMTime)));
        transformRamp.startTransform = transform;
        transformRamp.endTransform = transform;
        this.transformRampList.add(transformRamp);
    }

    public void setTransformRampFromStartTransform(@Nullable Transform transform, @Nullable Transform transform2, @NonNull CMTimeRange cMTimeRange) {
        VideoCompositionLayerInstruction.TransformRamp transformRamp = new VideoCompositionLayerInstruction.TransformRamp(cMTimeRange);
        transformRamp.startTransform = transform;
        transformRamp.endTransform = transform2;
        Iterator<VideoCompositionLayerInstruction.TransformRamp> it = this.transformRampList.iterator();
        if (it.hasNext()) {
            VideoCompositionLayerInstruction.TransformRamp next = it.next();
            CMTime start = next.timeRange.getStart();
            CMTime end = next.timeRange.getEnd();
            if (cMTimeRange.containsTime(start) && cMTimeRange.containsTime(end)) {
                next.timeRange = CMTimeRange.CMTimeRangeInvalid;
            } else if (cMTimeRange.containsTime(start) && !cMTimeRange.containsTime(end)) {
                next.timeRange = new CMTimeRange(cMTimeRange.getEnd(), next.timeRange.getEnd().sub(cMTimeRange.getEnd()));
            } else if (cMTimeRange.containsTime(end) && !cMTimeRange.containsTime(start)) {
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTimeRange.getStart().sub(next.timeRange.getStart()));
            }
        }
        int i3 = 0;
        while (i3 < this.transformRampList.size()) {
            VideoCompositionLayerInstruction.TransformRamp transformRamp2 = this.transformRampList.get(i3);
            if (transformRamp2.timeRange == CMTimeRange.CMTimeRangeInvalid) {
                this.transformRampList.remove(transformRamp2);
                i3--;
            }
            i3++;
        }
        this.transformRampList.add(transformRamp);
    }

    public MutableVideoCompositionLayerInstruction(int i3) {
        this.transformRampList = new ArrayList();
        this.opacityRampList = new ArrayList();
        this.cropRectangleRampList = new ArrayList();
        this.duration = new CMTime(TTL.MAX_VALUE);
        this.flipX = false;
        this.flipY = false;
        this.trackID = i3;
    }

    public MutableVideoCompositionLayerInstruction() {
        this.transformRampList = new ArrayList();
        this.opacityRampList = new ArrayList();
        this.cropRectangleRampList = new ArrayList();
        this.duration = new CMTime(TTL.MAX_VALUE);
        this.flipX = false;
        this.flipY = false;
    }
}
