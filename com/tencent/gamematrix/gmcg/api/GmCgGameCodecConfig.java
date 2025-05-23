package com.tencent.gamematrix.gmcg.api;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgGameCodecConfig {
    public boolean pEnableVoice;
    public int pFps;
    public int pReferencesCnt;
    public boolean pEnabled = false;
    public String pCodecType = "H264";
    public String pRenderViewType = "SurfaceView";
    public boolean pEnableTunnel = false;
    public String pResolution = "720p";

    public String asString() {
        return this.pEnabled + "|" + this.pCodecType + "|" + this.pRenderViewType + "|" + this.pEnableTunnel + "|" + this.pReferencesCnt + "|" + this.pFps + "|" + this.pResolution + "|" + this.pEnableVoice;
    }

    public boolean canUseVoice() {
        if (this.pEnabled && this.pEnableVoice) {
            return true;
        }
        return false;
    }

    public boolean enabled() {
        return this.pEnabled;
    }

    public boolean shouldUseH265() {
        if (this.pEnabled && "H265".equalsIgnoreCase(this.pCodecType)) {
            return true;
        }
        return false;
    }

    public boolean shouldUseTextureView() {
        if (this.pEnabled && "TextureView".equalsIgnoreCase(this.pRenderViewType)) {
            return true;
        }
        return false;
    }
}
