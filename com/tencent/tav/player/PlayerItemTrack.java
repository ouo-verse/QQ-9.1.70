package com.tencent.tav.player;

import com.tencent.tav.asset.AssetTrack;

/* loaded from: classes26.dex */
public class PlayerItemTrack {
    private AssetTrack assetTrack;
    private float currentVideoFrameRate;
    private boolean enabled = true;
    private String videoFieldMode;

    public AssetTrack getAssetTrack() {
        return this.assetTrack;
    }

    public float getCurrentVideoFrameRate() {
        return this.currentVideoFrameRate;
    }

    public String getVideoFieldMode() {
        return this.videoFieldMode;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAssetTrack(AssetTrack assetTrack) {
        this.assetTrack = assetTrack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurrentVideoFrameRate(float f16) {
        this.currentVideoFrameRate = f16;
    }

    public void setEnabled(boolean z16) {
        this.enabled = z16;
    }

    public void setVideoFieldMode(String str) {
        this.videoFieldMode = str;
    }
}
