package com.tencent.qqlive.module.videoreport.utils;

import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKLivePidAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKLiveSidAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOfflineVodVidAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodVidAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodXmlAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKUrlAsset;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    public static String a(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo == null || tVKPlayerVideoInfo.getAsset() == null) {
            return "";
        }
        ITVKAsset asset = tVKPlayerVideoInfo.getAsset();
        int assetType = asset.getAssetType();
        if (assetType != 1) {
            if (assetType != 2) {
                return "";
            }
            return ((TVKOfflineVodVidAsset) asset).getCid();
        }
        return ((TVKOnlineVodVidAsset) asset).getCid();
    }

    public static String b(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.getAsset() != null) {
            ITVKAsset asset = tVKPlayerVideoInfo.getAsset();
            if (asset.getAssetType() == 3) {
                return ((TVKOnlineVodXmlAsset) asset).getFlowId();
            }
        }
        return "";
    }

    public static String c(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo == null || tVKPlayerVideoInfo.getAsset() == null) {
            return "";
        }
        ITVKAsset asset = tVKPlayerVideoInfo.getAsset();
        int assetType = asset.getAssetType();
        if (assetType != 1) {
            if (assetType != 2) {
                if (assetType != 4) {
                    if (assetType != 5) {
                        if (assetType != 6) {
                            return "";
                        }
                        return ((TVKUrlAsset) asset).getUrl();
                    }
                    return ((TVKLiveSidAsset) asset).getSid();
                }
                return ((TVKLivePidAsset) asset).getPid();
            }
            return ((TVKOfflineVodVidAsset) asset).getVid();
        }
        return ((TVKOnlineVodVidAsset) asset).getVid();
    }

    public static void d(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) {
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.getAsset() != null) {
            ITVKAsset asset = tVKPlayerVideoInfo.getAsset();
            if (asset.getAssetType() == 3) {
                ((TVKOnlineVodXmlAsset) asset).setFlowId(str);
            }
        }
    }
}
