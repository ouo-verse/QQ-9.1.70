package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* loaded from: classes29.dex */
public class PostEffect3DComponent extends Component {
    private boolean enable = true;
    private BloomConfig bloom = new BloomConfig();
    private ColorGradingConfig colorGrading = new ColorGradingConfig();
    private VignetteConfig vignette = new VignetteConfig();
    private boolean enableDithering = false;
    private boolean enableMSAA = false;
    private boolean enableFXAA = true;
    private SSAOConfig ssao = new SSAOConfig();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof PostEffect3DComponent) {
            PostEffect3DComponent postEffect3DComponent = (PostEffect3DComponent) componentBase;
            this.enable = postEffect3DComponent.enable;
            this.bloom = postEffect3DComponent.bloom;
            this.colorGrading = postEffect3DComponent.colorGrading;
            this.vignette = postEffect3DComponent.vignette;
            this.enableDithering = postEffect3DComponent.enableDithering;
            this.enableMSAA = postEffect3DComponent.enableMSAA;
            this.enableFXAA = postEffect3DComponent.enableFXAA;
            this.ssao = postEffect3DComponent.ssao;
        }
        super.doUpdate(componentBase);
    }

    public BloomConfig getBloom() {
        return this.bloom;
    }

    public ColorGradingConfig getColorGrading() {
        return this.colorGrading;
    }

    public boolean getEnable() {
        return this.enable;
    }

    public boolean getEnableDithering() {
        return this.enableDithering;
    }

    public boolean getEnableFXAA() {
        return this.enableFXAA;
    }

    public boolean getEnableMSAA() {
        return this.enableMSAA;
    }

    public SSAOConfig getSsao() {
        return this.ssao;
    }

    public VignetteConfig getVignette() {
        return this.vignette;
    }

    public void setBloom(BloomConfig bloomConfig) {
        this.bloom = bloomConfig;
        reportPropertyChange("bloom", bloomConfig);
    }

    public void setColorGrading(ColorGradingConfig colorGradingConfig) {
        this.colorGrading = colorGradingConfig;
        reportPropertyChange("colorGrading", colorGradingConfig);
    }

    public void setEnable(boolean z16) {
        this.enable = z16;
        reportPropertyChange("enable", Boolean.valueOf(z16));
    }

    public void setEnableDithering(boolean z16) {
        this.enableDithering = z16;
        reportPropertyChange("enableDithering", Boolean.valueOf(z16));
    }

    public void setEnableFXAA(boolean z16) {
        this.enableFXAA = z16;
        reportPropertyChange("enableFXAA", Boolean.valueOf(z16));
    }

    public void setEnableMSAA(boolean z16) {
        this.enableMSAA = z16;
        reportPropertyChange("enableMSAA", Boolean.valueOf(z16));
    }

    public void setSsao(SSAOConfig sSAOConfig) {
        this.ssao = sSAOConfig;
        reportPropertyChange("ssao", sSAOConfig);
    }

    public void setVignette(VignetteConfig vignetteConfig) {
        this.vignette = vignetteConfig;
        reportPropertyChange("vignette", vignetteConfig);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "PostEffect3DComponent";
    }
}
