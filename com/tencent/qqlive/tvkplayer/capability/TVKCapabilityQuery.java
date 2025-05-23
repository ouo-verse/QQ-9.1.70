package com.tencent.qqlive.tvkplayer.capability;

import android.os.Build;
import com.tencent.qqlive.tvkplayer.api.ITVKCapabilityQuery;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.postprocess.api.TVKMonetCapability;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.thumbplayer.api.manager.TPMgr;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKCapabilityQuery implements ITVKCapabilityQuery {
    private static final String TAG = "TVKCapabilityQuery";
    private static final ITVKCapabilityQuery sInstance = new TVKCapabilityQuery();

    TVKCapabilityQuery() {
    }

    public static ITVKCapabilityQuery getInstance() {
        return sInstance;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCapabilityQuery
    public int getHevcLv() {
        return TVKCapabilityMgr.getInstance().getVideoCodecCgiLevel(1);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCapabilityQuery
    public int getSuggestedVideoFormat(ITVKAsset iTVKAsset) {
        if (iTVKAsset == null) {
            return 0;
        }
        int assetType = iTVKAsset.getAssetType();
        if (assetType != 131072 && assetType != 524288 && assetType != 1048576 && assetType != 256 && assetType != 512) {
            return 0;
        }
        return TVKFormatIDChooser.chooseFormatID(new TVKPlayerVideoInfo(iTVKAsset));
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCapabilityQuery
    public boolean isGaussianBlurVideoOverlayEffectSupported() {
        return TVKMonetCapability.isGaussianBlurVideoOverlayEffectSupported();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCapabilityQuery
    public boolean isRenderColorManagementSupported() {
        return TVKMonetCapability.isColorManagementSupported();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCapabilityQuery
    public boolean isSyncVideoTrackSupported() {
        boolean z16;
        if (TPMgr.isSelfDevPlayerAvailable() && Build.VERSION.SDK_INT >= TVKMediaPlayerConfig.PlayerConfig.sync_player_low_api) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.sync_no_support_model)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKCapabilityQuery
    public boolean isTVMSuperResolutionSupportedForVideoSize(int i3, int i16) {
        return TVKMonetCapability.isTVMSuperResolutionSupportedForVideoSize(i3, i16);
    }
}
