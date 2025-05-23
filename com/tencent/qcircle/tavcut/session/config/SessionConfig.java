package com.tencent.qcircle.tavcut.session.config;

import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SessionConfig {
    private TAVVideoConfiguration.TAVVideoConfigurationContentMode contentMode;
    private List<CropConfig> imageInitCropConfigs;
    private VideoComposition.RenderLayoutMode renderLayoutMode;
    private StickerEditViewIconConfig stickerEditViewIconConfig;
    private CropConfig videoInitCropConfig;
    private int maxIntermediateRenderSize = -1;
    private int minIntermediateRenderSize = -1;
    private boolean autoPlayVideo = true;
    private int maxImageDecodeSize = -1;
    private boolean isNoTempleSupportNineSize = false;

    public TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode() {
        return this.contentMode;
    }

    public List<CropConfig> getImageInitCropConfigs() {
        return this.imageInitCropConfigs;
    }

    public int getMaxImageDecodeSize() {
        return this.maxImageDecodeSize;
    }

    public int getMaxIntermediateRenderSize() {
        return this.maxIntermediateRenderSize;
    }

    public int getMinIntermediateRenderSize() {
        return this.minIntermediateRenderSize;
    }

    public boolean getNoTempleSupportNineSize() {
        return this.isNoTempleSupportNineSize;
    }

    public VideoComposition.RenderLayoutMode getRenderLayoutMode() {
        return this.renderLayoutMode;
    }

    public StickerEditViewIconConfig getStickerEditViewIconConfig() {
        return this.stickerEditViewIconConfig;
    }

    public CropConfig getVideoInitCropConfig() {
        return this.videoInitCropConfig;
    }

    public boolean isAutoPlayVideo() {
        return this.autoPlayVideo;
    }

    public void setAutoPlayVideo(boolean z16) {
        this.autoPlayVideo = z16;
    }

    public void setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        this.contentMode = tAVVideoConfigurationContentMode;
    }

    public void setImageInitCropConfigs(List<CropConfig> list) {
        this.imageInitCropConfigs = list;
    }

    public void setMaxImageDecodeSize(int i3) {
        this.maxImageDecodeSize = i3;
    }

    public void setMaxIntermediateRenderSize(int i3) {
        this.maxIntermediateRenderSize = i3;
    }

    public void setMinIntermediateRenderSize(int i3) {
        this.minIntermediateRenderSize = i3;
    }

    public void setNoTempleSupportNineSize(boolean z16) {
        this.isNoTempleSupportNineSize = z16;
    }

    public void setRenderLayoutMode(VideoComposition.RenderLayoutMode renderLayoutMode) {
        this.renderLayoutMode = renderLayoutMode;
    }

    public void setStickerEditViewIconConfig(StickerEditViewIconConfig stickerEditViewIconConfig) {
        this.stickerEditViewIconConfig = stickerEditViewIconConfig;
    }

    public void setVideoInitCropConfig(CropConfig cropConfig) {
        this.videoInitCropConfig = cropConfig;
    }
}
