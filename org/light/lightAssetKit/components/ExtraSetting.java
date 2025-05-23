package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExtraSetting extends Component {
    private boolean enableRotation = true;
    private boolean resetWhenStartRecord = true;
    private boolean useMetal = false;
    private boolean sync3dRenderEnable = false;
    private boolean needVoiceDecibel = false;
    private boolean needAutoBeauty = false;
    private boolean enableDowngradeAsset = true;
    private int fixedRenderWidth = 0;
    private int fixedRenderHeight = 0;
    private int supportCameraPosition = 0;
    private int defaultCameraPosition = 0;
    private long fixedExposureTime = 0;
    private boolean useWideAngleLens = false;
    private boolean renderAtMaxSize = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof ExtraSetting) {
            ExtraSetting extraSetting = (ExtraSetting) componentBase;
            this.enableRotation = extraSetting.enableRotation;
            this.resetWhenStartRecord = extraSetting.resetWhenStartRecord;
            this.useMetal = extraSetting.useMetal;
            this.sync3dRenderEnable = extraSetting.sync3dRenderEnable;
            this.needVoiceDecibel = extraSetting.needVoiceDecibel;
            this.needAutoBeauty = extraSetting.needAutoBeauty;
            this.enableDowngradeAsset = extraSetting.enableDowngradeAsset;
            this.fixedRenderWidth = extraSetting.fixedRenderWidth;
            this.fixedRenderHeight = extraSetting.fixedRenderHeight;
            this.supportCameraPosition = extraSetting.supportCameraPosition;
            this.defaultCameraPosition = extraSetting.defaultCameraPosition;
            this.fixedExposureTime = extraSetting.fixedExposureTime;
            this.useWideAngleLens = extraSetting.useWideAngleLens;
            this.renderAtMaxSize = extraSetting.renderAtMaxSize;
        }
        super.doUpdate(componentBase);
    }

    public int getDefaultCameraPosition() {
        return this.defaultCameraPosition;
    }

    public boolean getEnableDowngradeAsset() {
        return this.enableDowngradeAsset;
    }

    public boolean getEnableRotation() {
        return this.enableRotation;
    }

    public long getFixedExposureTime() {
        return this.fixedExposureTime;
    }

    public int getFixedRenderHeight() {
        return this.fixedRenderHeight;
    }

    public int getFixedRenderWidth() {
        return this.fixedRenderWidth;
    }

    public boolean getNeedAutoBeauty() {
        return this.needAutoBeauty;
    }

    public boolean getNeedVoiceDecibel() {
        return this.needVoiceDecibel;
    }

    public boolean getRenderAtMaxSize() {
        return this.renderAtMaxSize;
    }

    public boolean getResetWhenStartRecord() {
        return this.resetWhenStartRecord;
    }

    public int getSupportCameraPosition() {
        return this.supportCameraPosition;
    }

    public boolean getSync3dRenderEnable() {
        return this.sync3dRenderEnable;
    }

    public boolean getUseMetal() {
        return this.useMetal;
    }

    public boolean getUseWideAngleLens() {
        return this.useWideAngleLens;
    }

    public void setDefaultCameraPosition(int i3) {
        this.defaultCameraPosition = i3;
        reportPropertyChange("defaultCameraPosition", Integer.valueOf(i3));
    }

    public void setEnableDowngradeAsset(boolean z16) {
        this.enableDowngradeAsset = z16;
        reportPropertyChange("enableDowngradeAsset", Boolean.valueOf(z16));
    }

    public void setEnableRotation(boolean z16) {
        this.enableRotation = z16;
        reportPropertyChange("enableRotation", Boolean.valueOf(z16));
    }

    public void setFixedExposureTime(long j3) {
        this.fixedExposureTime = j3;
        reportPropertyChange("fixedExposureTime", Long.valueOf(j3));
    }

    public void setFixedRenderHeight(int i3) {
        this.fixedRenderHeight = i3;
        reportPropertyChange("fixedRenderHeight", Integer.valueOf(i3));
    }

    public void setFixedRenderWidth(int i3) {
        this.fixedRenderWidth = i3;
        reportPropertyChange("fixedRenderWidth", Integer.valueOf(i3));
    }

    public void setNeedAutoBeauty(boolean z16) {
        this.needAutoBeauty = z16;
        reportPropertyChange("needAutoBeauty", Boolean.valueOf(z16));
    }

    public void setNeedVoiceDecibel(boolean z16) {
        this.needVoiceDecibel = z16;
        reportPropertyChange("needVoiceDecibel", Boolean.valueOf(z16));
    }

    public void setRenderAtMaxSize(boolean z16) {
        this.renderAtMaxSize = z16;
        reportPropertyChange("renderAtMaxSize", Boolean.valueOf(z16));
    }

    public void setResetWhenStartRecord(boolean z16) {
        this.resetWhenStartRecord = z16;
        reportPropertyChange("resetWhenStartRecord", Boolean.valueOf(z16));
    }

    public void setSupportCameraPosition(int i3) {
        this.supportCameraPosition = i3;
        reportPropertyChange("supportCameraPosition", Integer.valueOf(i3));
    }

    public void setSync3dRenderEnable(boolean z16) {
        this.sync3dRenderEnable = z16;
        reportPropertyChange("sync3dRenderEnable", Boolean.valueOf(z16));
    }

    public void setUseMetal(boolean z16) {
        this.useMetal = z16;
        reportPropertyChange("useMetal", Boolean.valueOf(z16));
    }

    public void setUseWideAngleLens(boolean z16) {
        this.useWideAngleLens = z16;
        reportPropertyChange("useWideAngleLens", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "ExtraSetting";
    }
}
