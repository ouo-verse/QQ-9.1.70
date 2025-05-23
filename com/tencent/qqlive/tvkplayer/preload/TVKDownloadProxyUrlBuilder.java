package com.tencent.qqlive.tvkplayer.preload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.ITVKDownloadProxyUrlBuilder;
import com.tencent.qqlive.tvkplayer.api.TVKDownloadProgressInfo;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.TVKLiveTPMediaAssetBuilder;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.TVKVodTPMediaAssetBuilder;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.localproxy.ITPLocalProxy;
import com.tencent.thumbplayer.api.localproxy.TPLocalProxyFactory;

/* loaded from: classes23.dex */
public class TVKDownloadProxyUrlBuilder implements ITVKDownloadProxyUrlBuilder {
    private static final String TAG = "TVKDownloadProxyUrlGetter";
    private final ITPLocalProxy mLocalProxy;

    /* loaded from: classes23.dex */
    private static class InnerListener implements ITPLocalProxy.LocalProxyListener {
        private final ITVKDownloadProxyUrlBuilder.ProxyListener mListener;

        public InnerListener(ITVKDownloadProxyUrlBuilder.ProxyListener proxyListener) {
            this.mListener = proxyListener;
        }

        @Override // com.tencent.thumbplayer.api.localproxy.ITPLocalProxy.LocalProxyListener
        public void onDownloadError(TPError tPError) {
            if (this.mListener == null) {
                return;
            }
            this.mListener.onDownloadError(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, tPError.getErrorCode()));
        }

        @Override // com.tencent.thumbplayer.api.localproxy.ITPLocalProxy.LocalProxyListener
        public void onDownloadProgressUpdate(TPDownloadProgressInfo tPDownloadProgressInfo) {
            if (this.mListener == null) {
                return;
            }
            TVKDownloadProgressInfo tVKDownloadProgressInfo = new TVKDownloadProgressInfo();
            tVKDownloadProgressInfo.setAvailablePositionMs(tPDownloadProgressInfo.getAvailablePositionMs());
            tVKDownloadProgressInfo.setDownloadSpeedbps(tPDownloadProgressInfo.getDownloadSpeedbps());
            tVKDownloadProgressInfo.setDownloadBytes(tPDownloadProgressInfo.getDownloadBytes());
            tVKDownloadProgressInfo.setFileTotalBytes(tPDownloadProgressInfo.getFileTotalBytes());
            tVKDownloadProgressInfo.setExtraInfo(tPDownloadProgressInfo.getExtraInfo());
            this.mListener.onDownloadProgressUpdate(tVKDownloadProgressInfo);
        }

        @Override // com.tencent.thumbplayer.api.localproxy.ITPLocalProxy.LocalProxyListener
        public void onDownloadSuccess() {
            ITVKDownloadProxyUrlBuilder.ProxyListener proxyListener = this.mListener;
            if (proxyListener == null) {
                return;
            }
            proxyListener.onDownloadSuccess();
        }
    }

    public TVKDownloadProxyUrlBuilder() throws UnsupportedOperationException {
        ITPLocalProxy createTPLocalProxy = TPLocalProxyFactory.createTPLocalProxy();
        this.mLocalProxy = createTPLocalProxy;
        if (createTPLocalProxy != null) {
        } else {
            throw new UnsupportedOperationException("Failed to create local proxy");
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKDownloadProxyUrlBuilder
    @NonNull
    public String buildDownloadProxyUrl(TVKNetVideoInfo tVKNetVideoInfo, @Nullable ITVKDownloadProxyUrlBuilder.ProxyListener proxyListener) throws IllegalStateException, IllegalArgumentException {
        ITPMediaAsset build;
        String str;
        if (tVKNetVideoInfo != null && tVKNetVideoInfo.getCurDefinition() != null) {
            if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
                build = TVKVodTPMediaAssetBuilder.newBuilder().inputDefinition(tVKNetVideoInfo.getCurDefinition().getDefn()).flowId(TVKUtils.generateFlowId()).vodVideoInfo((TVKVodVideoInfo) tVKNetVideoInfo).build();
            } else if (tVKNetVideoInfo instanceof TVKLiveVideoInfo) {
                build = TVKLiveTPMediaAssetBuilder.newBuilder().inputDefinition(tVKNetVideoInfo.getCurDefinition().getDefn()).flowId(TVKUtils.generateFlowId()).liveVideoInfo((TVKLiveVideoInfo) tVKNetVideoInfo).build();
            } else {
                throw new IllegalArgumentException("Unrecognized net video info type");
            }
            build.setParam("dl_param_scene_id", "dlna_local_play_type");
            try {
                ITPLocalProxy iTPLocalProxy = this.mLocalProxy;
                if (iTPLocalProxy != null) {
                    str = iTPLocalProxy.buildProxyUrl(build, new InnerListener(proxyListener));
                } else {
                    str = "";
                }
                TVKLogUtil.i(TAG, "buildDownloadProxyUrl, localProxyUrl=" + str);
                return str;
            } catch (IllegalArgumentException | IllegalStateException e16) {
                TVKLogUtil.e(TAG, e16);
                throw e16;
            }
        }
        TVKLogUtil.w(TAG, "buildDownloadProxyUrl failed, netVideoInfo or curDefnInfo is null");
        throw new IllegalArgumentException("netVideoInfo or curDefnInfo is null");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKDownloadProxyUrlBuilder
    public void stop() {
        ITPLocalProxy iTPLocalProxy = this.mLocalProxy;
        if (iTPLocalProxy != null) {
            iTPLocalProxy.release();
        }
    }
}
