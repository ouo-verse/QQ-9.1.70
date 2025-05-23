package com.tencent.tavkit.composition.video;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;

/* compiled from: P */
/* loaded from: classes26.dex */
class DefaultVideoMixFilter implements TAVVideoMixEffect.Filter {
    private void checkFillInRenderSize(RenderInfo renderInfo, ImageCollection.TrackImagePair trackImagePair, CIImage cIImage) {
        if (!(trackImagePair.getTrack() instanceof TAVClip)) {
            return;
        }
        TAVVideoConfiguration videoConfiguration = ((TAVClip) trackImagePair.getTrack()).getVideoConfiguration();
        if (videoConfiguration.frameEnable()) {
            return;
        }
        cIImage.applyFillInFrame(new CGRect(new PointF(0.0f, 0.0f), renderInfo.getRenderSize()), videoConfiguration.getContentMode());
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
    @NonNull
    public CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo) {
        CIImage cIImage = new CIImage(renderInfo.getRenderSize());
        for (ImageCollection.TrackImagePair trackImagePair : imageCollection.getVideoChannelImages()) {
            CIImage image = trackImagePair.getImage();
            checkFillInRenderSize(renderInfo, trackImagePair, image);
            image.imageByCompositingOverImage(cIImage);
        }
        for (ImageCollection.TrackImagePair trackImagePair2 : imageCollection.getOverlayImages()) {
            CIImage image2 = trackImagePair2.getImage();
            checkFillInRenderSize(renderInfo, trackImagePair2, image2);
            image2.imageByCompositingOverImage(cIImage);
        }
        return cIImage;
    }

    @Override // com.tencent.tavkit.composition.video.Releasable
    public void release() {
    }
}
