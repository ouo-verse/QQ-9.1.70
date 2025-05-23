package com.tencent.qqlive.tvkplayer.api;

import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKCapabilityQuery {
    int getHevcLv();

    int getSuggestedVideoFormat(ITVKAsset iTVKAsset);

    boolean isGaussianBlurVideoOverlayEffectSupported();

    boolean isRenderColorManagementSupported();

    boolean isSyncVideoTrackSupported();

    boolean isTVMSuperResolutionSupportedForVideoSize(int i3, int i16);
}
