package com.tencent.autotemplate.filter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.report.IReportable;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TAVAspectFillEffect implements TAVVideoEffect {
    static IPatchRedirector $redirector_ = null;
    private static final float MAX_COLOR_RANGE = 255.0f;
    private static final String TAG = "TAVAspectFillEffect";
    private String bgCIColor;
    private CGSize renderSize;
    protected String reportKey;

    public TAVAspectFillEffect(CGSize cGSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cGSize);
        } else {
            this.reportKey = TAG;
            this.renderSize = cGSize;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TAVVideoEffect.Filter) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new AspectFillVideoCompositionEffect(this, null);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoEffect
    @NonNull
    public String effectId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return TAG + hashCode();
    }

    public String getBgCIColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bgCIColor;
    }

    public void setBgCIColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.bgCIColor = str;
        }
    }

    public void setReportKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.reportKey = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class AspectFillVideoCompositionEffect implements TAVVideoEffect.Filter, IReportable {
        static IPatchRedirector $redirector_;
        private GaosiBlurFilter hGaosiBlurFilter;
        private MergeTextureFilter mergeTextureFilter;
        private ScaleTextureFilter scaleTextureFilter;
        private HashMap<String, TextureInfo> textureMap;
        private GaosiBlurFilter vGaosiBlurFilter;

        AspectFillVideoCompositionEffect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TAVAspectFillEffect.this);
                return;
            }
            this.textureMap = new HashMap<>();
            this.hGaosiBlurFilter = new GaosiBlurFilter(true, 20);
            this.vGaosiBlurFilter = new GaosiBlurFilter(false, 20);
            this.mergeTextureFilter = new MergeTextureFilter();
            this.scaleTextureFilter = new ScaleTextureFilter();
        }

        private CIImage applyBackgroundColor(RenderInfo renderInfo, CIImage cIImage, float f16, float f17, float f18) {
            TAVTextureInfo tavTextureInfo = TAVAspectFillEffect.this.getTavTextureInfo(renderInfo.getCiContext().convertImageToTexture(cIImage, getCacheTextureInfo((int) cIImage.getSize().width, (int) cIImage.getSize().height)));
            this.scaleTextureFilter.scale(f16, f17, f18);
            try {
                int parseColor = Color.parseColor(TAVAspectFillEffect.this.bgCIColor);
                this.scaleTextureFilter.setBackgroundColor(((parseColor >> 16) & 255) / TAVAspectFillEffect.MAX_COLOR_RANGE, ((parseColor >> 8) & 255) / TAVAspectFillEffect.MAX_COLOR_RANGE, ((parseColor >> 0) & 255) / TAVAspectFillEffect.MAX_COLOR_RANGE, 1.0f);
                return new CIImage(TAVAspectFillEffect.this.getOutputTextureInfo(this.scaleTextureFilter.applyFilter(tavTextureInfo)));
            } catch (Exception unused) {
                return cIImage;
            }
        }

        private CIImage applyBlurFilter(RenderInfo renderInfo, CIImage cIImage, float f16, float f17, float f18, float f19, float f26) {
            TAVTextureInfo tavTextureInfo = TAVAspectFillEffect.this.getTavTextureInfo(renderInfo.getCiContext().convertImageToTexture(cIImage, getCacheTextureInfo((int) cIImage.getSize().width, (int) cIImage.getSize().height)));
            this.scaleTextureFilter.scale(f16, Math.round(f17), Math.round(f18));
            TAVTextureInfo applyFilter = this.scaleTextureFilter.applyFilter(tavTextureInfo);
            TAVTextureInfo applyFilter2 = this.vGaosiBlurFilter.applyFilter(this.hGaosiBlurFilter.applyFilter(tavTextureInfo));
            this.mergeTextureFilter.setOffsetX(f19);
            this.mergeTextureFilter.setOffsetY(f26);
            return new CIImage(TAVAspectFillEffect.this.getOutputTextureInfo(this.mergeTextureFilter.mergeTexture(applyFilter2, applyFilter)));
        }

        private CIImage applyFilter(RenderInfo renderInfo, CIImage cIImage, float f16, float f17, float f18, float f19, float f26) {
            if (!TextUtils.isEmpty(TAVAspectFillEffect.this.bgCIColor)) {
                return applyBackgroundColor(renderInfo, cIImage, f16, f17, f18);
            }
            return applyBlurFilter(renderInfo, cIImage, f16, f17, f18, f19, f26);
        }

        private TextureInfo getCacheTextureInfo(int i3, int i16) {
            TextureInfo textureInfo;
            String str = i3 + "_" + i16;
            if (this.textureMap.containsKey(str)) {
                textureInfo = this.textureMap.get(str);
            } else {
                textureInfo = null;
            }
            if (textureInfo == null) {
                TextureInfo newTextureInfo = CIContext.newTextureInfo(i3, i16);
                this.textureMap.put(str, newTextureInfo);
                return newTextureInfo;
            }
            return textureInfo;
        }

        private void prepareFilter(float f16, float f17, float f18, float f19, boolean z16) {
            float f26;
            float f27;
            this.scaleTextureFilter.setRendererWidth((int) TAVAspectFillEffect.this.renderSize.width);
            this.scaleTextureFilter.setRendererHeight((int) TAVAspectFillEffect.this.renderSize.height);
            this.hGaosiBlurFilter.setRendererWidth((int) TAVAspectFillEffect.this.renderSize.width);
            this.hGaosiBlurFilter.setRendererHeight((int) TAVAspectFillEffect.this.renderSize.height);
            this.vGaosiBlurFilter.setRendererWidth((int) TAVAspectFillEffect.this.renderSize.width);
            this.vGaosiBlurFilter.setRendererHeight((int) TAVAspectFillEffect.this.renderSize.height);
            this.mergeTextureFilter.setRendererWidth((int) TAVAspectFillEffect.this.renderSize.width);
            this.mergeTextureFilter.setRendererHeight((int) TAVAspectFillEffect.this.renderSize.height);
            float f28 = 0.0f;
            if (z16) {
                float f29 = (-(((TAVAspectFillEffect.this.renderSize.height / f19) * TAVAspectFillEffect.this.renderSize.width) - TAVAspectFillEffect.this.renderSize.width)) / 2.0f;
                f27 = TAVAspectFillEffect.this.renderSize.height / f17;
                f26 = 0.0f;
                f28 = f29;
            } else {
                f26 = (-(((TAVAspectFillEffect.this.renderSize.width / f18) * TAVAspectFillEffect.this.renderSize.height) - TAVAspectFillEffect.this.renderSize.height)) / 2.0f;
                f27 = TAVAspectFillEffect.this.renderSize.width / f16;
            }
            this.hGaosiBlurFilter.scale(f27, f28, f26);
        }

        @Override // com.tencent.tavkit.composition.video.TAVVideoEffect.Filter
        public CIImage apply(TAVVideoEffect tAVVideoEffect, CIImage cIImage, RenderInfo renderInfo) {
            float f16;
            float f17;
            float f18;
            float f19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CIImage) iPatchRedirector.redirect((short) 2, this, tAVVideoEffect, cIImage, renderInfo);
            }
            float f26 = cIImage.getSize().width;
            float f27 = cIImage.getSize().height;
            float f28 = TAVAspectFillEffect.this.renderSize.width / TAVAspectFillEffect.this.renderSize.height;
            float f29 = f26 / f27;
            if (f29 == f28) {
                return cIImage;
            }
            float f36 = 0.0f;
            if (f29 > f28) {
                float f37 = TAVAspectFillEffect.this.renderSize.width;
                f16 = f37 / f29;
                float f38 = (TAVAspectFillEffect.this.renderSize.height - f16) / 2.0f;
                f19 = ((TAVAspectFillEffect.this.renderSize.height - f16) / 2.0f) / TAVAspectFillEffect.this.renderSize.height;
                prepareFilter(f26, f27, f37, f16, true);
                f18 = 0.0f;
                f17 = f38;
            } else {
                f16 = TAVAspectFillEffect.this.renderSize.height;
                float f39 = f16 * f29;
                float f46 = (TAVAspectFillEffect.this.renderSize.width - f39) / 2.0f;
                float f47 = ((TAVAspectFillEffect.this.renderSize.width - f39) / 2.0f) / TAVAspectFillEffect.this.renderSize.width;
                prepareFilter(f26, f27, f39, f16, false);
                f17 = 0.0f;
                f18 = f46;
                f36 = f47;
                f19 = 0.0f;
            }
            return applyFilter(renderInfo, cIImage, f16 / f27, f18, f17, f36, f19);
        }

        @Override // com.tencent.tavkit.report.IReportable
        public String getReportKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return TAVAspectFillEffect.this.reportKey;
        }

        @Override // com.tencent.tavkit.composition.video.Releasable
        public void release() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            GaosiBlurFilter gaosiBlurFilter = this.hGaosiBlurFilter;
            if (gaosiBlurFilter != null) {
                gaosiBlurFilter.release();
            }
            GaosiBlurFilter gaosiBlurFilter2 = this.vGaosiBlurFilter;
            if (gaosiBlurFilter2 != null) {
                gaosiBlurFilter2.release();
            }
            ScaleTextureFilter scaleTextureFilter = this.scaleTextureFilter;
            if (scaleTextureFilter != null) {
                scaleTextureFilter.release();
            }
            MergeTextureFilter mergeTextureFilter = this.mergeTextureFilter;
            if (mergeTextureFilter != null) {
                mergeTextureFilter.release();
            }
            HashMap<String, TextureInfo> hashMap = this.textureMap;
            if (hashMap != null) {
                Iterator<TextureInfo> it = hashMap.values().iterator();
                while (it.hasNext()) {
                    it.next().release();
                }
                this.textureMap.clear();
            }
        }

        /* synthetic */ AspectFillVideoCompositionEffect(TAVAspectFillEffect tAVAspectFillEffect, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tAVAspectFillEffect, (Object) anonymousClass1);
        }
    }
}
