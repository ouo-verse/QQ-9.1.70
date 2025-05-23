package com.tencent.qqlive.tvkplayer.api.asset;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAssetUtils {
    public static boolean isLiveAsset(ITVKAsset iTVKAsset) {
        if (!(iTVKAsset instanceof TVKAssetBase)) {
            return false;
        }
        return ((TVKAssetBase) iTVKAsset).isLiveAsset();
    }

    public static boolean isQQLiveAsset(ITVKAsset iTVKAsset) {
        if (!(iTVKAsset instanceof TVKAssetBase)) {
            return false;
        }
        return ((TVKAssetBase) iTVKAsset).isQQLiveAsset();
    }

    public static boolean isValidAsset(ITVKAsset iTVKAsset) {
        if (iTVKAsset != null && iTVKAsset.isAssetValid()) {
            return true;
        }
        return false;
    }

    public static boolean isVodAsset(ITVKAsset iTVKAsset) {
        if (!(iTVKAsset instanceof TVKAssetBase)) {
            return false;
        }
        return ((TVKAssetBase) iTVKAsset).isVodAsset();
    }
}
