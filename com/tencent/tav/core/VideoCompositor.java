package com.tencent.tav.core;

import android.graphics.Matrix;
import androidx.annotation.Nullable;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.IVideoCompositionInstruction;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.coremedia.Transform;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.RenderContext;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoCompositor implements VideoCompositing {
    private MultiTextureFilter filter;

    private boolean checkRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        if (asynchronousVideoCompositionRequest.getRenderContext() != null && asynchronousVideoCompositionRequest.getSourceTrackIDs() != null && !asynchronousVideoCompositionRequest.getSourceTrackIDs().isEmpty()) {
            return true;
        }
        return false;
    }

    private void drawInstructionBuffer(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest, IVideoCompositionInstruction iVideoCompositionInstruction) {
        Matrix matrix;
        this.filter.clearBufferBuffer(iVideoCompositionInstruction.getBackgroundColor());
        for (VideoCompositionLayerInstruction videoCompositionLayerInstruction : iVideoCompositionInstruction.getLayerInstructions()) {
            CMSampleBuffer sourceFrameByTrackID = asynchronousVideoCompositionRequest.sourceFrameByTrackID(videoCompositionLayerInstruction.getTrackID());
            if (sourceFrameByTrackID != null && sourceFrameByTrackID.getTextureInfo() != null) {
                CMTime compositionTime = asynchronousVideoCompositionRequest.getCompositionTime();
                Transform transformForTime = getTransformForTime(compositionTime, videoCompositionLayerInstruction.getTransformRampForTime(compositionTime));
                if (transformForTime == null) {
                    matrix = null;
                } else {
                    matrix = transformForTime.toMatrix();
                }
                CGRect cropRectangleForTime = getCropRectangleForTime(compositionTime, videoCompositionLayerInstruction.getCropRectangleRampForTime(compositionTime));
                this.filter.applyFilter(sourceFrameByTrackID.getTextureInfo(), matrix, null, getOpacityForTime(compositionTime, videoCompositionLayerInstruction.getOpacityRampForTime(compositionTime)), cropRectangleForTime);
            }
        }
    }

    private void drawSrcBuffer(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        this.filter.clearBufferBuffer(-16777216);
        Iterator<Integer> it = asynchronousVideoCompositionRequest.getSourceTrackIDs().iterator();
        while (it.hasNext()) {
            CMSampleBuffer sourceFrameByTrackID = asynchronousVideoCompositionRequest.sourceFrameByTrackID(it.next().intValue());
            if (sourceFrameByTrackID != null && sourceFrameByTrackID.getTextureInfo() != null) {
                TextureInfo textureInfo = sourceFrameByTrackID.getTextureInfo();
                Matrix matrix = new Matrix();
                DecoderUtils.getRotationMatrix(matrix, textureInfo.preferRotation, textureInfo.width, textureInfo.height);
                this.filter.applyFilter(sourceFrameByTrackID.getTextureInfo(), matrix, textureInfo.getTextureMatrix(), 1.0f, null);
            }
        }
    }

    @Nullable
    private static CGRect getCropRectangleForTime(CMTime cMTime, VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp) {
        if (cropRectangleRamp.startCropRectangle != null && cropRectangleRamp.endCropRectangle != null && cropRectangleRamp.timeRange.containsTime(cMTime)) {
            float timeUs = (((float) (cMTime.getTimeUs() - cropRectangleRamp.timeRange.getStartUs())) * 1.0f) / ((float) cropRectangleRamp.timeRange.getDurationUs());
            return new CGRect(interpolation(timeUs, cropRectangleRamp.startCropRectangle.origin.x, cropRectangleRamp.endCropRectangle.origin.x), interpolation(timeUs, cropRectangleRamp.startCropRectangle.origin.y, cropRectangleRamp.endCropRectangle.origin.y), interpolation(timeUs, cropRectangleRamp.startCropRectangle.size.width, cropRectangleRamp.endCropRectangle.size.width), interpolation(timeUs, cropRectangleRamp.startCropRectangle.size.height, cropRectangleRamp.endCropRectangle.size.height));
        }
        return null;
    }

    private static float getOpacityForTime(CMTime cMTime, VideoCompositionLayerInstruction.OpacityRamp opacityRamp) {
        if (!opacityRamp.timeRange.containsTime(cMTime)) {
            return 1.0f;
        }
        return interpolation((((float) (cMTime.getTimeUs() - opacityRamp.timeRange.getStartUs())) * 1.0f) / ((float) opacityRamp.timeRange.getDurationUs()), opacityRamp.startOpacity, opacityRamp.endOpacity);
    }

    @Nullable
    private static Transform getTransformForTime(CMTime cMTime, VideoCompositionLayerInstruction.TransformRamp transformRamp) {
        if (transformRamp.timeRange.containsTime(cMTime) && transformRamp.startTransform != null && transformRamp.endTransform != null) {
            float timeUs = (((float) (cMTime.getTimeUs() - transformRamp.timeRange.getStartUs())) * 1.0f) / ((float) transformRamp.timeRange.getDurationUs());
            return new Transform(interpolation(timeUs, transformRamp.startTransform.scaleX, transformRamp.endTransform.scaleX), interpolation(timeUs, transformRamp.startTransform.scaleY, transformRamp.endTransform.scaleY), interpolation(timeUs, transformRamp.startTransform.translateX, transformRamp.endTransform.translateX), interpolation(timeUs, transformRamp.startTransform.translateY, transformRamp.endTransform.translateY), interpolation(timeUs, transformRamp.startTransform.degrees, transformRamp.endTransform.degrees));
        }
        return null;
    }

    private void initFilter(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        if (this.filter == null) {
            CGSize size = asynchronousVideoCompositionRequest.getRenderContext().getSize();
            int i3 = (int) size.width;
            int i16 = (int) size.height;
            MultiTextureFilter multiTextureFilter = new MultiTextureFilter();
            this.filter = multiTextureFilter;
            multiTextureFilter.setRendererWidth(i3);
            this.filter.setRendererHeight(i16);
            this.filter.setRenderForScreen(false);
        }
    }

    private static float interpolation(float f16, float f17, float f18) {
        if (f17 == f18) {
            return f17;
        }
        return ((f18 - f17) * f16) + f17;
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void release() {
        MultiTextureFilter multiTextureFilter = this.filter;
        if (multiTextureFilter != null) {
            multiTextureFilter.release();
            this.filter = null;
        }
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public HashMap<String, Object> requiredPixelBufferAttributesForRenderContext() {
        return null;
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public HashMap<String, Object> sourcePixelBufferAttributes() {
        return null;
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void startVideoCompositionRequest(AsynchronousVideoCompositionRequest asynchronousVideoCompositionRequest) {
        if (!checkRequest(asynchronousVideoCompositionRequest)) {
            return;
        }
        initFilter(asynchronousVideoCompositionRequest);
        CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(asynchronousVideoCompositionRequest.getCompositionTime(), asynchronousVideoCompositionRequest.getRenderContext().newTextureInfo(), false);
        if (cMSampleBuffer.getTextureInfo() == null) {
            return;
        }
        this.filter.setDesTextureInfo(cMSampleBuffer.getTextureInfo());
        IVideoCompositionInstruction videoCompositionInstruction = asynchronousVideoCompositionRequest.getVideoCompositionInstruction();
        if (videoCompositionInstruction != null && videoCompositionInstruction.getLayerInstructions() != null && videoCompositionInstruction.getLayerInstructions().size() != 0) {
            drawInstructionBuffer(asynchronousVideoCompositionRequest, videoCompositionInstruction);
        } else {
            drawSrcBuffer(asynchronousVideoCompositionRequest);
        }
        asynchronousVideoCompositionRequest.finishWithComposedVideoFrame(finishComposedVideoFrame(asynchronousVideoCompositionRequest.getRenderContext().getRenderContext(), cMSampleBuffer));
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void cancelAllPendingVideoCompositionRequests() {
    }

    @Override // com.tencent.tav.core.compositing.VideoCompositing
    public void renderContextChanged(VideoCompositionRenderContext videoCompositionRenderContext) {
    }

    public CMSampleBuffer finishComposedVideoFrame(RenderContext renderContext, CMSampleBuffer cMSampleBuffer) {
        return cMSampleBuffer;
    }
}
