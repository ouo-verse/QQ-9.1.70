package com.tencent.qcircle.weseevideo.composition.image;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.EGLContext;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.weseevideo.composition.TAVAutomaticTransRenderContext;
import com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WSImageRender {
    private AssetImageGenerator imageGenerator;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface ImageRenderCallback {
        void onCompletion(@Nullable Bitmap bitmap, @Nullable List<PointF> list);
    }

    public void init(TAVComposition tAVComposition, CGSize cGSize) {
        TAVSource buildSource = new TAVCompositionBuilder(tAVComposition).buildSource();
        AssetImageGenerator assetImageGenerator = new AssetImageGenerator(buildSource.getAsset());
        this.imageGenerator = assetImageGenerator;
        assetImageGenerator.setMaximumSize(cGSize);
        this.imageGenerator.setAppliesPreferredTrackTransform(true);
        this.imageGenerator.setVideoComposition(buildSource.getVideoComposition());
    }

    public void release() {
        AssetImageGenerator assetImageGenerator = this.imageGenerator;
        if (assetImageGenerator != null) {
            assetImageGenerator.release();
            this.imageGenerator = null;
        }
    }

    public void render(final ImageRenderCallback imageRenderCallback, EGLContext eGLContext, AssetImageGenerator.ImageGeneratorThread imageGeneratorThread, RenderContext renderContext) {
        if (this.imageGenerator != null) {
            DurationUtil.start("image render");
            ArrayList arrayList = new ArrayList();
            arrayList.add(CMTime.CMTimeZero);
            this.imageGenerator.generateCGImagesAsynchronouslyForTimes(arrayList, new AssetImageGenerator.ImageGeneratorListener() { // from class: com.tencent.qcircle.weseevideo.composition.image.WSImageRender.1
                @Override // com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorListener
                public void onCompletion(@NonNull CMTime cMTime, @Nullable Bitmap bitmap, @Nullable List<PointF> list, @Nullable CMTime cMTime2, @NonNull AssetImageGenerator.AssetImageGeneratorResult assetImageGeneratorResult) {
                    DurationUtil.end("image render");
                    imageRenderCallback.onCompletion(bitmap, list);
                }
            }, eGLContext, imageGeneratorThread, renderContext);
        }
    }

    public void setTansRenderContext(TAVAutomaticTransRenderContext tAVAutomaticTransRenderContext) {
        AssetImageGenerator assetImageGenerator = this.imageGenerator;
        if (assetImageGenerator != null) {
            assetImageGenerator.setTansRenderContext(tAVAutomaticTransRenderContext);
        }
    }
}
