package com.tencent.autotemplate.stickertransition;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSourceImage;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVStickerTransition implements TAVVideoTransition {
    static IPatchRedirector $redirector_;
    private TAVStickerRenderContext tavStickerContext;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class StickerVideoTransitionEffect implements TAVVideoTransition.Filter {
        static IPatchRedirector $redirector_;
        private RenderContext renderContext;
        private TAVStickerRenderContext stickerContext;

        public StickerVideoTransitionEffect(TAVStickerRenderContext tAVStickerRenderContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TAVStickerTransition.this, (Object) tAVStickerRenderContext);
            } else {
                this.stickerContext = tAVStickerRenderContext;
            }
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoTransition.Filter
        public CIImage apply(TAVVideoTransition tAVVideoTransition, CIImage cIImage, CIImage cIImage2, float f16, RenderInfo renderInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CIImage) iPatchRedirector.redirect((short) 2, this, tAVVideoTransition, cIImage, cIImage2, Float.valueOf(f16), renderInfo);
            }
            TAVStickerRenderContext tAVStickerRenderContext = this.stickerContext;
            if (tAVStickerRenderContext == null) {
                return cIImage;
            }
            tAVStickerRenderContext.setRenderSize(renderInfo.getRenderSize());
            this.renderContext = renderInfo.getCiContext().getRenderContext();
            ArrayList arrayList = new ArrayList();
            TextureInfo newTextureInfo = CIContext.newTextureInfo((int) cIImage2.getSize().width, (int) cIImage2.getSize().height);
            renderInfo.getCiContext().convertImageToTexture(cIImage2, newTextureInfo);
            arrayList.add(new TAVSourceImage(newTextureInfo, 0));
            TextureInfo newTextureInfo2 = CIContext.newTextureInfo((int) cIImage.getSize().width, (int) cIImage.getSize().height);
            renderInfo.getCiContext().convertImageToTexture(cIImage, newTextureInfo2);
            arrayList.add(new TAVSourceImage(newTextureInfo2, 1));
            CMSampleBuffer renderSticker = this.stickerContext.renderSticker(f16, arrayList, this.renderContext.eglContext());
            this.renderContext.makeCurrent();
            if (newTextureInfo2 != null) {
                newTextureInfo2.release();
            }
            if (newTextureInfo != null) {
                newTextureInfo.release();
            }
            if (renderSticker != null) {
                try {
                    if (renderSticker.isNewFrame()) {
                        this.stickerContext.getStickerTexture().awaitNewImage(1000L);
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return new CIImage(renderSticker.getTextureInfo());
            }
            return cIImage;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            RenderContext renderContext = this.renderContext;
            if (renderContext != null) {
                renderContext.makeCurrent();
            }
            TAVStickerRenderContext tAVStickerRenderContext = this.stickerContext;
            if (tAVStickerRenderContext != null) {
                tAVStickerRenderContext.release();
                this.stickerContext = null;
            }
        }
    }

    public TAVStickerTransition(TAVStickerContext tAVStickerContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tAVStickerContext);
        } else {
            this.tavStickerContext = tAVStickerContext;
        }
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoTransition
    public TAVVideoTransition.Filter createFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TAVVideoTransition.Filter) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new StickerVideoTransitionEffect(this.tavStickerContext);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoTransition
    public String effectId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TAVStickerTransition";
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoTransition
    public CMTime getDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CMTime) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }
}
