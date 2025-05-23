package com.tencent.qqlive.tvkplayer.vinfo.vod;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOfflineVodVidAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoProxyCacheListener;

/* loaded from: classes23.dex */
public class TVKVodProxyCache {
    private static final String MODULE_NAME = "TVKVodProxyCache";
    private final String mDefinition;
    private final boolean mIsVideoInfoValid;
    private final ITVKLogger mLogger;
    private final ITVKVodInfoProxyCacheListener mProxyCacheListener;

    @NonNull
    private final ITVKAsset mVodVidAsset;

    public TVKVodProxyCache(@NonNull TVKContext tVKContext, @NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, @NonNull ITVKAsset iTVKAsset, String str, ITVKVodInfoProxyCacheListener iTVKVodInfoProxyCacheListener) throws IllegalArgumentException {
        this.mIsVideoInfoValid = isVideoInfoValid(tVKPlayerVideoInfo, iTVKAsset);
        this.mLogger = new TVKLogger(tVKContext, MODULE_NAME);
        this.mVodVidAsset = iTVKAsset;
        this.mDefinition = str;
        this.mProxyCacheListener = iTVKVodInfoProxyCacheListener;
    }

    private boolean isVideoInfoValid(TVKPlayerVideoInfo tVKPlayerVideoInfo, ITVKAsset iTVKAsset) {
        if (tVKPlayerVideoInfo == null || !TVKAssetUtils.isValidAsset(iTVKAsset)) {
            return false;
        }
        int assetType = iTVKAsset.getAssetType();
        if (assetType != 262144 && assetType != 524288) {
            return false;
        }
        return true;
    }

    public String getOfflineCache() {
        if (!this.mIsVideoInfoValid) {
            return "";
        }
        ITVKVodInfoProxyCacheListener iTVKVodInfoProxyCacheListener = this.mProxyCacheListener;
        if (iTVKVodInfoProxyCacheListener != null) {
            return iTVKVodInfoProxyCacheListener.getOfflineCache(getVid(), this.mDefinition);
        }
        this.mLogger.error("VOD CGI: video info process : offline video , cacheCallback is null. asset:" + this.mVodVidAsset, new Object[0]);
        return "";
    }

    public String getOfflineVInfoForQuickPlay(TVKVodVideoInfo tVKVodVideoInfo) {
        if (!this.mIsVideoInfoValid) {
            return "";
        }
        if (!TVKMediaPlayerConfig.PlayerConfig.use_offline_resource_for_quick_play) {
            this.mLogger.info("VOD CGI: failed to get recorded offline VInfo: config off", new Object[0]);
            return "";
        }
        if (this.mVodVidAsset.getAssetType() != 524288) {
            this.mLogger.info("VOD CGI: failed to get recorded offline VInfo: not a quick play task", new Object[0]);
            return "";
        }
        if (TextUtils.isEmpty(tVKVodVideoInfo.getVid())) {
            this.mLogger.info("VOD CGI: failed to get recorded offline VInfo: empty vid", new Object[0]);
            return "";
        }
        if (tVKVodVideoInfo.isPreview()) {
            this.mLogger.info("VOD CGI: failed to get recorded offline VInfo: preview task", new Object[0]);
            return "";
        }
        ITVKVodInfoProxyCacheListener iTVKVodInfoProxyCacheListener = this.mProxyCacheListener;
        if (iTVKVodInfoProxyCacheListener == null) {
            this.mLogger.info("VOD CGI: failed to get recorded offline VInfo: cannot get download proxy query service", new Object[0]);
            return "";
        }
        String offlineCache = iTVKVodInfoProxyCacheListener.getOfflineCache(tVKVodVideoInfo.getVid(), null);
        if (offlineCache == null) {
            return "";
        }
        return offlineCache;
    }

    public String getVid() {
        if (!this.mIsVideoInfoValid || this.mVodVidAsset.getAssetType() != 262144) {
            return "";
        }
        return ((TVKOfflineVodVidAsset) this.mVodVidAsset).getVid();
    }
}
