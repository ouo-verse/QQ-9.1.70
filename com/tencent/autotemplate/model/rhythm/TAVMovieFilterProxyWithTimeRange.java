package com.tencent.autotemplate.model.rhythm;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.effects.CanyingEffect;
import com.tencent.taveffect.effects.ChongdieEffect;
import com.tencent.taveffect.effects.GanraoEffect;
import com.tencent.taveffect.effects.HuanjueEffect;
import com.tencent.taveffect.effects.LookupFilter;
import com.tencent.taveffect.effects.LvdongEffect;
import com.tencent.taveffect.effects.RGBEffect;
import com.tencent.taveffect.effects.ShanbaiEffect;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavmovie.filter.TAVMovieFilterProxy;

/* loaded from: classes3.dex */
public class TAVMovieFilterProxyWithTimeRange extends TAVMovieFilterProxy {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TAVMovieFilterProxyWithTimeRange";
    private Bitmap bitmap;
    private int effectID;
    private CMTimeRange timeRange;

    /* loaded from: classes3.dex */
    private class TAVMovieFilterEffect implements TAVVideoEffect.Filter {
        static IPatchRedirector $redirector_;
        private TextureInfo cacheTextureInfo;
        private BaseEffect mEffect;

        public TAVMovieFilterEffect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TAVMovieFilterProxyWithTimeRange.this);
            } else {
                this.mEffect = TAVMovieFilterProxyWithTimeRange.this.createEffect();
            }
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        @NonNull
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CIImage) iPatchRedirector.redirect((short) 2, this, tAVVideoEffect, cIImage, renderInfo);
            }
            if (TAVMovieFilterProxyWithTimeRange.this.timeRange != null && !TAVMovieFilterProxyWithTimeRange.this.timeRange.containsTime(renderInfo.getTime())) {
                return cIImage;
            }
            CIContext ciContext = renderInfo.getCiContext();
            int i3 = (int) renderInfo.getRenderSize().width;
            int i16 = (int) renderInfo.getRenderSize().height;
            if (this.mEffect == null) {
                BaseEffect createEffect = TAVMovieFilterProxyWithTimeRange.this.createEffect();
                this.mEffect = createEffect;
                if (createEffect == null) {
                    return cIImage;
                }
            }
            this.mEffect.setRendererWidth(i3);
            this.mEffect.setRendererHeight(i16);
            if (this.cacheTextureInfo == null) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheTextureInfo = CIContext.newTextureInfo(i3, i16);
            }
            TextureInfo textureInfo = this.cacheTextureInfo;
            if (textureInfo.width != i3 || textureInfo.height != i16) {
                ciContext.getRenderContext().makeCurrent();
                this.cacheTextureInfo.release();
                this.cacheTextureInfo = CIContext.newTextureInfo(i3, i16);
            }
            ciContext.convertImageToTexture(cIImage, this.cacheTextureInfo);
            TextureInfo outputTextureInfo = TAVMovieFilterProxyWithTimeRange.this.getOutputTextureInfo(this.mEffect.applyFilter(TAVMovieFilterProxyWithTimeRange.this.getTavTextureInfo(this.cacheTextureInfo)));
            outputTextureInfo.setTextureMatrix(this.cacheTextureInfo.getTextureMatrix());
            return new CIImage(outputTextureInfo);
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            BaseEffect baseEffect = this.mEffect;
            if (baseEffect != null) {
                baseEffect.release();
                this.mEffect = null;
            }
            TextureInfo textureInfo = this.cacheTextureInfo;
            if (textureInfo != null && !textureInfo.isReleased()) {
                this.cacheTextureInfo.release();
            }
        }
    }

    public TAVMovieFilterProxyWithTimeRange(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.effectID = i3;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public BaseEffect createEffect() {
        switch (this.effectID) {
            case 0:
                if (this.bitmap == null) {
                    return null;
                }
                return new LookupFilter(this.bitmap);
            case 1:
                return new RGBEffect();
            case 2:
                return new CanyingEffect();
            case 3:
                return new ChongdieEffect();
            case 4:
                return new GanraoEffect();
            case 5:
                return new HuanjueEffect();
            case 6:
                return new LvdongEffect();
            case 7:
                return new ShanbaiEffect();
            default:
                return new RGBEffect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public TextureInfo getOutputTextureInfo(TAVTextureInfo tAVTextureInfo) {
        return new TextureInfo(tAVTextureInfo.textureID, tAVTextureInfo.textureType, tAVTextureInfo.width, tAVTextureInfo.height, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public TAVTextureInfo getTavTextureInfo(TextureInfo textureInfo) {
        return new TAVTextureInfo(textureInfo.textureID, textureInfo.textureType, textureInfo.width, textureInfo.height, null, 0);
    }

    @Override // com.tencent.tavmovie.filter.TAVMovieFilterProxy, com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TAVVideoEffect.Filter) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new TAVMovieFilterEffect();
    }

    @Override // com.tencent.tavmovie.filter.TAVMovieFilterProxy
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cMTimeRange);
        } else {
            this.timeRange = cMTimeRange;
        }
    }

    public TAVMovieFilterProxyWithTimeRange(int i3, Bitmap bitmap) {
        super(i3, bitmap);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bitmap);
        } else {
            this.effectID = i3;
            this.bitmap = bitmap;
        }
    }
}
