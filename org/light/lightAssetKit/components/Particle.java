package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.ParticleTriggerType;

/* loaded from: classes29.dex */
public class Particle extends Component {
    private ParticleTriggerType triggerType;
    private String materialPath = "";
    private String triggerJson = "";
    private String texturePath = "";
    private String colorTexturePath = "";
    private String backgroundTexturePath = "";
    private String backgroundPath = "";
    private String sourcePositionPath = "";
    private String inputRenderTarget = "";
    private boolean useColorReference = false;
    private int triggerTime = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Particle) {
            Particle particle = (Particle) componentBase;
            this.triggerType = particle.triggerType;
            this.materialPath = particle.materialPath;
            this.triggerJson = particle.triggerJson;
            this.texturePath = particle.texturePath;
            this.colorTexturePath = particle.colorTexturePath;
            this.backgroundTexturePath = particle.backgroundTexturePath;
            this.backgroundPath = particle.backgroundPath;
            this.sourcePositionPath = particle.sourcePositionPath;
            this.inputRenderTarget = particle.inputRenderTarget;
            this.useColorReference = particle.useColorReference;
            this.triggerTime = particle.triggerTime;
        }
        super.doUpdate(componentBase);
    }

    public String getBackgroundPath() {
        return this.backgroundPath;
    }

    public String getBackgroundTexturePath() {
        return this.backgroundTexturePath;
    }

    public String getColorTexturePath() {
        return this.colorTexturePath;
    }

    public String getInputRenderTarget() {
        return this.inputRenderTarget;
    }

    public String getMaterialPath() {
        return this.materialPath;
    }

    public String getSourcePositionPath() {
        return this.sourcePositionPath;
    }

    public String getTexturePath() {
        return this.texturePath;
    }

    public String getTriggerJson() {
        return this.triggerJson;
    }

    public int getTriggerTime() {
        return this.triggerTime;
    }

    public ParticleTriggerType getTriggerType() {
        return this.triggerType;
    }

    public boolean getUseColorReference() {
        return this.useColorReference;
    }

    public void setBackgroundPath(String str) {
        this.backgroundPath = str;
        reportPropertyChange("backgroundPath", str);
    }

    public void setBackgroundTexturePath(String str) {
        this.backgroundTexturePath = str;
        reportPropertyChange("backgroundTexturePath", str);
    }

    public void setColorTexturePath(String str) {
        this.colorTexturePath = str;
        reportPropertyChange("colorTexturePath", str);
    }

    public void setInputRenderTarget(String str) {
        this.inputRenderTarget = str;
        reportPropertyChange("inputRenderTarget", str);
    }

    public void setMaterialPath(String str) {
        this.materialPath = str;
        reportPropertyChange("materialPath", str);
    }

    public void setSourcePositionPath(String str) {
        this.sourcePositionPath = str;
        reportPropertyChange("sourcePositionPath", str);
    }

    public void setTexturePath(String str) {
        this.texturePath = str;
        reportPropertyChange("texturePath", str);
    }

    public void setTriggerJson(String str) {
        this.triggerJson = str;
        reportPropertyChange("triggerJson", str);
    }

    public void setTriggerTime(int i3) {
        this.triggerTime = i3;
        reportPropertyChange("triggerTime", Integer.valueOf(i3));
    }

    public void setTriggerType(ParticleTriggerType particleTriggerType) {
        this.triggerType = particleTriggerType;
        reportPropertyChange("triggerType", particleTriggerType);
    }

    public void setUseColorReference(boolean z16) {
        this.useColorReference = z16;
        reportPropertyChange("useColorReference", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Particle";
    }
}
