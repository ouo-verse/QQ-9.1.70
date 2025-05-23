package com.tencent.tavmovie.filter;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
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

/* loaded from: classes26.dex */
public class TAVMovieFilterProxy implements TAVVideoEffect {
    private static final String TAG = "TAVMovieFilterProxy";
    public static final int TYPE_CAN_YING = 2;
    public static final int TYPE_CHONG_DIE = 3;
    public static final int TYPE_GAN_RAO = 4;
    public static final int TYPE_HUAN_JUE = 5;
    public static final int TYPE_LOOK_UP = 0;
    public static final int TYPE_LV_DONG = 6;
    public static final int TYPE_RGB = 1;
    public static final int TYPE_SHAN_BAI = 7;
    private Bitmap bitmap;
    private int effectID;

    /* loaded from: classes26.dex */
    private class TAVMovieFilterEffect implements TAVVideoEffect.Filter {
        private TextureInfo cacheTextureInfo;
        private BaseEffect mEffect;

        public TAVMovieFilterEffect() {
            this.mEffect = TAVMovieFilterProxy.this.createEffect();
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            CIContext ciContext = renderInfo.getCiContext();
            int i3 = (int) cIImage.getSize().width;
            int i16 = (int) cIImage.getSize().height;
            if (this.mEffect == null) {
                BaseEffect createEffect = TAVMovieFilterProxy.this.createEffect();
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
            TextureInfo outputTextureInfo = TAVMovieFilterProxy.this.getOutputTextureInfo(this.mEffect.applyFilter(TAVMovieFilterProxy.this.getTavTextureInfo(this.cacheTextureInfo)));
            outputTextureInfo.setTextureMatrix(this.cacheTextureInfo.getTextureMatrix());
            return new CIImage(outputTextureInfo);
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
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

    public TAVMovieFilterProxy(int i3) {
        this.effectID = i3;
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

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    public TAVVideoEffect.Filter createFilter() {
        return new TAVMovieFilterEffect();
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    /* renamed from: effectId */
    public String getMEffectId() {
        return TAG;
    }

    public void release() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
    }

    public TAVMovieFilterProxy(int i3, Bitmap bitmap) {
        this.effectID = i3;
        this.bitmap = bitmap;
    }
}
