package com.tencent.qqlive.tvkplayer.preload;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineVodXmlAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKPositionTransformUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.TVKVodTPMediaAssetBuilder;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIFactory;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPDownloadProgressInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.preload.ITPPreloader;
import com.tencent.thumbplayer.api.preload.TPPreloaderFactory;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes23.dex */
public class TVKPreloadMgr implements ITVKPreloadMgr {
    private static final String TAG = "TVKPreloadMgr";
    private static final TVKPreloadMgr sInstance = new TVKPreloadMgr();
    private final TVKPlayerFeatureGroup mFeatureGroup;
    private final ITVKLiveInfoGetter.ITVKLiveInfoGetterListener mLiveInfoListener;
    private ITPPreloader mMediaAssetPreloader;
    private final Map<Integer, Integer> mPreloadIdToRequestId;
    private final Map<Integer, Object> mRequestIdToGetter;
    private final Map<Integer, InnerPreloadParam> mRequestIdToInnerPreloadParam;
    private final Map<Integer, Integer> mRequestIdToPreloadId;
    private final TVKContext mTVKContext;
    private final ITVKVodInfoGetter.ITVKVodInfoGetterListener mVodInfoListener;
    private final ITVKDataParseGetter.ITVKVodDataParseGetterListener mVodXmlParseListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class InnerPreloadParam {
        private final String mDefinition;
        private final String mFlowId;
        private final TVKPlayerVideoInfo mPlayerVideoInfo;
        private final ITVKPreloadMgr.IPreloadListener mPreloadListener;
        private final ITVKPreloadMgr.PreloadParam mPreloadParam;
        private final TVKUserInfo mUserInfo;

        public InnerPreloadParam(TVKPlayerVideoInfo tVKPlayerVideoInfo, TVKUserInfo tVKUserInfo, String str, ITVKPreloadMgr.PreloadParam preloadParam, ITVKPreloadMgr.IPreloadListener iPreloadListener, String str2) {
            this.mPlayerVideoInfo = tVKPlayerVideoInfo;
            this.mUserInfo = tVKUserInfo;
            this.mDefinition = str;
            this.mPreloadParam = preloadParam;
            this.mPreloadListener = iPreloadListener;
            this.mFlowId = str2;
        }

        public String getDefinition() {
            return this.mDefinition;
        }

        public String getFlowId() {
            return this.mFlowId;
        }

        public TVKPlayerVideoInfo getPlayerVideoInfo() {
            return this.mPlayerVideoInfo;
        }

        public ITVKPreloadMgr.IPreloadListener getPreloadListener() {
            return this.mPreloadListener;
        }

        public ITVKPreloadMgr.PreloadParam getPreloadParam() {
            return this.mPreloadParam;
        }

        public TVKUserInfo getUserInfo() {
            return this.mUserInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class MediaAssetPreloadListener implements ITPPreloader.ITPPreloadListener {
        MediaAssetPreloadListener() {
        }

        private ITVKPreloadMgr.IPreloadListener.DownloadProgressInfo convertDownloadProgressInfo(TPDownloadProgressInfo tPDownloadProgressInfo) {
            ITVKPreloadMgr.IPreloadListener.DownloadProgressInfo downloadProgressInfo = new ITVKPreloadMgr.IPreloadListener.DownloadProgressInfo();
            downloadProgressInfo.setPlayableDurationMs((int) tPDownloadProgressInfo.getAvailablePositionMs());
            downloadProgressInfo.setDownloadSpeedKBs((int) ((tPDownloadProgressInfo.getDownloadSpeedbps() / 1024) / 8));
            downloadProgressInfo.setCurrentDownloadSizeByte(tPDownloadProgressInfo.getDownloadBytes());
            downloadProgressInfo.setTotalFileSizeByte(tPDownloadProgressInfo.getFileTotalBytes());
            downloadProgressInfo.setExtraInfo(tPDownloadProgressInfo.getExtraInfo());
            return downloadProgressInfo;
        }

        @Override // com.tencent.thumbplayer.api.preload.ITPPreloader.ITPPreloadListener
        public void onPreloadError(int i3, TPError tPError) {
            ITVKPreloadMgr.IPreloadListener preloadListener;
            Integer num = (Integer) TVKPreloadMgr.this.mPreloadIdToRequestId.remove(Integer.valueOf(i3));
            if (num == null) {
                return;
            }
            TVKLogUtil.i(TVKPreloadMgr.TAG, "[onPreloadError] request id=" + num + ", error=" + tPError);
            TVKPreloadMgr.this.mRequestIdToPreloadId.remove(num);
            InnerPreloadParam innerPreloadParam = (InnerPreloadParam) TVKPreloadMgr.this.mRequestIdToInnerPreloadParam.remove(num);
            if (innerPreloadParam == null || (preloadListener = innerPreloadParam.getPreloadListener()) == null) {
                return;
            }
            preloadListener.onPreloadError(i3);
        }

        @Override // com.tencent.thumbplayer.api.preload.ITPPreloader.ITPPreloadListener
        public void onPreloadProgressUpdate(int i3, TPDownloadProgressInfo tPDownloadProgressInfo) {
            InnerPreloadParam innerPreloadParam;
            ITVKPreloadMgr.IPreloadListener preloadListener;
            Integer num = (Integer) TVKPreloadMgr.this.mPreloadIdToRequestId.get(Integer.valueOf(i3));
            if (num == null || (innerPreloadParam = (InnerPreloadParam) TVKPreloadMgr.this.mRequestIdToInnerPreloadParam.get(num)) == null || (preloadListener = innerPreloadParam.getPreloadListener()) == null) {
                return;
            }
            preloadListener.onPreloadDownloadProgressUpdate(num.intValue(), convertDownloadProgressInfo(tPDownloadProgressInfo));
        }

        @Override // com.tencent.thumbplayer.api.preload.ITPPreloader.ITPPreloadListener
        public void onPreloadSuccess(int i3) {
            ITVKPreloadMgr.IPreloadListener preloadListener;
            Integer num = (Integer) TVKPreloadMgr.this.mPreloadIdToRequestId.remove(Integer.valueOf(i3));
            if (num == null) {
                return;
            }
            TVKLogUtil.i(TVKPreloadMgr.TAG, "[onPreloadSuccess] request id=" + num);
            TVKPreloadMgr.this.mRequestIdToPreloadId.remove(num);
            InnerPreloadParam innerPreloadParam = (InnerPreloadParam) TVKPreloadMgr.this.mRequestIdToInnerPreloadParam.remove(num);
            if (innerPreloadParam == null || (preloadListener = innerPreloadParam.getPreloadListener()) == null) {
                return;
            }
            preloadListener.onPreloadSuccess(num.intValue());
        }
    }

    TVKPreloadMgr() {
        TVKContext tVKContext = new TVKContext(TVKCommParams.getApplicationContext());
        this.mTVKContext = tVKContext;
        this.mRequestIdToGetter = new ConcurrentHashMap();
        this.mRequestIdToInnerPreloadParam = new ConcurrentHashMap();
        this.mRequestIdToPreloadId = new ConcurrentHashMap();
        this.mPreloadIdToRequestId = new ConcurrentHashMap();
        this.mLiveInfoListener = new ITVKLiveInfoGetter.ITVKLiveInfoGetterListener() { // from class: com.tencent.qqlive.tvkplayer.preload.TVKPreloadMgr.1
            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.ITVKLiveInfoGetterListener
            public void onFailure(int i3, @NonNull TVKError tVKError) {
                TVKLogUtil.e(TVKPreloadMgr.TAG, "preload live video info failed, error:" + tVKError + ", requestId:" + i3);
                TVKPreloadMgr.this.mRequestIdToGetter.remove(Integer.valueOf(i3));
                TVKPreloadMgr.this.notifyPreloadFinished(i3, false);
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.ITVKLiveInfoGetterListener
            public void onSuccess(int i3, @NonNull TVKLiveVideoInfo tVKLiveVideoInfo) {
                TVKLogUtil.i(TVKPreloadMgr.TAG, "preload live video info success, pid:" + tVKLiveVideoInfo.getLivePid() + ", chid:" + tVKLiveVideoInfo.getLiveChid() + ", requestId:" + i3);
                TVKPreloadMgr.this.mRequestIdToGetter.remove(Integer.valueOf(i3));
                TVKPreloadMgr.this.preloadMediaAsset(i3, tVKLiveVideoInfo);
            }
        };
        this.mVodInfoListener = new ITVKVodInfoGetter.ITVKVodInfoGetterListener() { // from class: com.tencent.qqlive.tvkplayer.preload.TVKPreloadMgr.2
            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterListener
            public void onFailure(int i3, @NonNull TVKError tVKError) {
                TVKLogUtil.e(TVKPreloadMgr.TAG, "preload vod video info failed, error:" + tVKError + ", requestId:" + i3);
                TVKPreloadMgr.this.mRequestIdToGetter.remove(Integer.valueOf(i3));
                TVKPreloadMgr.this.notifyPreloadFinished(i3, false);
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKVodInfoGetter.ITVKVodInfoGetterListener
            public void onSuccess(int i3, @NonNull TVKVodVideoInfo tVKVodVideoInfo) {
                TVKLogUtil.i(TVKPreloadMgr.TAG, "preload vod video info success, vid:" + tVKVodVideoInfo.getVid() + ", requestId:" + i3);
                TVKPreloadMgr.this.mRequestIdToGetter.remove(Integer.valueOf(i3));
                TVKPreloadMgr.this.preloadMediaAsset(i3, tVKVodVideoInfo);
            }
        };
        this.mVodXmlParseListener = new ITVKDataParseGetter.ITVKVodDataParseGetterListener() { // from class: com.tencent.qqlive.tvkplayer.preload.TVKPreloadMgr.3
            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter.ITVKVodDataParseGetterListener
            public void onFailure(int i3, @NonNull TVKError tVKError) {
                TVKLogUtil.e(TVKPreloadMgr.TAG, "preload vod video info from xml failed, error:" + tVKError + ", requestId:" + i3);
                TVKPreloadMgr.this.mRequestIdToGetter.remove(Integer.valueOf(i3));
                TVKPreloadMgr.this.notifyPreloadFinished(i3, false);
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKDataParseGetter.ITVKVodDataParseGetterListener
            public void onSuccess(int i3, @NonNull TVKVodVideoInfo tVKVodVideoInfo) {
                TVKLogUtil.i(TVKPreloadMgr.TAG, "preload vod video info from xml success, vid:" + tVKVodVideoInfo.getVid() + ", requestId:" + i3);
                TVKPreloadMgr.this.mRequestIdToGetter.remove(Integer.valueOf(i3));
                TVKPreloadMgr.this.preloadMediaAsset(i3, tVKVodVideoInfo);
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(TVKFeatureFactory.createVodFeatureList(tVKContext));
        arrayList.addAll(TVKFeatureFactory.createLiveFeatureList(tVKContext));
        this.mFeatureGroup = new TVKPlayerFeatureGroup(arrayList);
        tryToCreateMediaAssetPreloaderIfNecessary();
    }

    private ITPMediaAsset generateVodMediaAsset(InnerPreloadParam innerPreloadParam, TVKVodVideoInfo tVKVodVideoInfo) {
        long startPositionMs;
        long skipEndPositionMs;
        long preloadSize;
        long preloadDurationMs;
        ITVKPreloadMgr.PreloadParam preloadParam = innerPreloadParam.getPreloadParam();
        long j3 = 0;
        if (preloadParam == null) {
            startPositionMs = 0;
        } else {
            startPositionMs = preloadParam.getStartPositionMs();
        }
        if (preloadParam == null) {
            skipEndPositionMs = 0;
        } else {
            skipEndPositionMs = preloadParam.getSkipEndPositionMs();
        }
        long adjustSkipStartPositionForEmbeddedAd = TVKPositionTransformUtils.adjustSkipStartPositionForEmbeddedAd(startPositionMs, tVKVodVideoInfo);
        long adjustSkipEndPositionForEmbeddedAd = TVKPositionTransformUtils.adjustSkipEndPositionForEmbeddedAd(skipEndPositionMs, tVKVodVideoInfo);
        long adjustSkipStartPositionForVodPreview = TVKPositionTransformUtils.adjustSkipStartPositionForVodPreview(adjustSkipStartPositionForEmbeddedAd, tVKVodVideoInfo);
        long adjustSkipEndPositionForVodPreview = TVKPositionTransformUtils.adjustSkipEndPositionForVodPreview(adjustSkipEndPositionForEmbeddedAd, tVKVodVideoInfo);
        TVKLogUtil.i(TAG, "[generateVodMediaAsset] position adjusted for preload: start=" + adjustSkipStartPositionForVodPreview + ", end=" + adjustSkipEndPositionForVodPreview);
        try {
            ITPMediaAsset build = TVKVodTPMediaAssetBuilder.newBuilder().playerVideoInfo(innerPreloadParam.getPlayerVideoInfo()).inputDefinition(innerPreloadParam.getDefinition()).startPositionMs(adjustSkipStartPositionForVodPreview).skipEndPositionMs(adjustSkipEndPositionForVodPreview).flowId(innerPreloadParam.getFlowId()).vodVideoInfo(tVKVodVideoInfo).build();
            if (preloadParam == null) {
                preloadSize = 0;
            } else {
                preloadSize = preloadParam.getPreloadSize();
            }
            build.setParam("dl_param_preload_size", String.valueOf(preloadSize));
            if (preloadParam == null) {
                preloadDurationMs = 0;
            } else {
                preloadDurationMs = preloadParam.getPreloadDurationMs();
            }
            build.setParam("dl_param_preload_duration", String.valueOf(preloadDurationMs));
            if (preloadParam != null) {
                j3 = preloadParam.getPreloadHttpStartTimeMs();
            }
            build.setParam("dl_param_prepare_http_start_time", String.valueOf(j3));
            return build;
        } catch (IllegalArgumentException e16) {
            TVKLogUtil.e(TAG, e16, "[generateVodMediaAsset] failed to build media asset: ");
            return null;
        }
    }

    public static TVKPreloadMgr getInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPreloadFinished(int i3, boolean z16) {
        ITVKPreloadMgr.IPreloadListener preloadListener;
        InnerPreloadParam remove = this.mRequestIdToInnerPreloadParam.remove(Integer.valueOf(i3));
        if (remove == null || (preloadListener = remove.getPreloadListener()) == null) {
            return;
        }
        if (z16) {
            preloadListener.onPreloadSuccess(i3);
        } else {
            preloadListener.onPreloadError(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadMediaAsset(int i3, TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo instanceof TVKLiveVideoInfo) {
            TVKLogUtil.i(TAG, "[preloadMediaAsset] preloading live media asset unsupported by far");
            notifyPreloadFinished(i3, true);
            return;
        }
        if (tVKNetVideoInfo instanceof TVKVodVideoInfo) {
            tryToCreateMediaAssetPreloaderIfNecessary();
            if (this.mMediaAssetPreloader == null) {
                notifyPreloadFinished(i3, false);
                return;
            }
            TVKVodVideoInfo tVKVodVideoInfo = (TVKVodVideoInfo) tVKNetVideoInfo;
            if (tVKVodVideoInfo.isPreview() && tVKVodVideoInfo.getPreviewDurationSec() == 0) {
                TVKLogUtil.e(TAG, "[preloadMediaAsset] do not preload preview media asset without playable duration");
                notifyPreloadFinished(i3, false);
                return;
            }
            InnerPreloadParam innerPreloadParam = this.mRequestIdToInnerPreloadParam.get(Integer.valueOf(i3));
            if (innerPreloadParam == null) {
                TVKLogUtil.e(TAG, "[preloadMediaAsset] literally impossible. FIX ME");
                return;
            }
            ITPMediaAsset generateVodMediaAsset = generateVodMediaAsset(innerPreloadParam, tVKVodVideoInfo);
            if (generateVodMediaAsset == null) {
                notifyPreloadFinished(i3, false);
                return;
            }
            int start = this.mMediaAssetPreloader.start(generateVodMediaAsset);
            if (start == -1) {
                TVKLogUtil.e(TAG, "[preloadMediaAsset] failed to start the media asset preload task");
                notifyPreloadFinished(i3, false);
                return;
            }
            this.mRequestIdToPreloadId.put(Integer.valueOf(i3), Integer.valueOf(start));
            this.mPreloadIdToRequestId.put(Integer.valueOf(start), Integer.valueOf(i3));
            TVKLogUtil.i(TAG, "[preloadMediaAsset] media asset preload started. requestId=" + i3 + ", preloadId=" + start);
        }
    }

    private void tryToCreateMediaAssetPreloaderIfNecessary() {
        if (this.mMediaAssetPreloader != null) {
            return;
        }
        synchronized (this) {
            if (this.mMediaAssetPreloader != null) {
                return;
            }
            ITPPreloader createPreloader = TPPreloaderFactory.createPreloader();
            this.mMediaAssetPreloader = createPreloader;
            if (createPreloader != null) {
                createPreloader.setPreloadListener(new MediaAssetPreloadListener());
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr
    public int preload(@Nullable TVKUserInfo tVKUserInfo, @NonNull TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, ITVKPreloadMgr.PreloadParam preloadParam, ITVKPreloadMgr.IPreloadListener iPreloadListener) {
        int requestOnlinePlayInfo;
        int i3;
        if (TVKDefinitionType.DEFINITION_TYPE_ADAPTIVE.equalsIgnoreCase(str)) {
            TVKLogUtil.e(TAG, "[preload] video preload unsupported: adaptive definition.");
            return -1;
        }
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.isAssetValid()) {
            TVKLogUtil.i(TAG, "[preload] preload by asset:" + tVKPlayerVideoInfo.getAsset() + ", definition:" + str + ", preloadParam: " + preloadParam + ", listener: " + iPreloadListener);
            TVKUserInfo tVKUserInfo2 = tVKUserInfo == null ? new TVKUserInfo() : tVKUserInfo;
            this.mTVKContext.increaseSequence();
            ITVKAsset asset = tVKPlayerVideoInfo.getAsset();
            int assetType = tVKPlayerVideoInfo.getAsset().getAssetType();
            String generateFlowId = TVKUtils.generateFlowId();
            try {
                if (tVKPlayerVideoInfo.isLivePlay()) {
                    ITVKLiveInfoGetter createLiveInfoGetter = TVKCGIFactory.createLiveInfoGetter(this.mTVKContext, Looper.myLooper());
                    createLiveInfoGetter.setLiveInfoListener(this.mLiveInfoListener);
                    requestOnlinePlayInfo = createLiveInfoGetter.requestLivePlayInfo(new TVKCGIRequestParam.Builder(tVKPlayerVideoInfo, asset, tVKUserInfo2).definition(str).streamFormatId(TVKFormatIDChooser.chooseFormatID(tVKPlayerVideoInfo)).flowId(generateFlowId).requestSource(1).build(), this.mFeatureGroup, TVKFeatureFactory.createFeatureParamGroupForPreload(preloadParam));
                    this.mRequestIdToGetter.put(Integer.valueOf(requestOnlinePlayInfo), createLiveInfoGetter);
                } else {
                    if (assetType == 65536) {
                        ITVKDataParseGetter createVodXmlParseGetter = TVKCGIFactory.createVodXmlParseGetter(this.mTVKContext, Looper.myLooper());
                        createVodXmlParseGetter.setListener(this.mVodXmlParseListener);
                        int parse = createVodXmlParseGetter.parse(((TVKOnlineVodXmlAsset) tVKPlayerVideoInfo.getAsset()).getXml(), this.mFeatureGroup);
                        this.mRequestIdToGetter.put(Integer.valueOf(parse), createVodXmlParseGetter);
                        i3 = parse;
                        this.mRequestIdToInnerPreloadParam.put(Integer.valueOf(i3), new InnerPreloadParam(tVKPlayerVideoInfo, tVKUserInfo2, str, preloadParam, iPreloadListener, generateFlowId));
                        TVKLogUtil.i(TAG, "[preload] video info request sent with requestId:" + i3);
                        return i3;
                    }
                    if (assetType != 131072 && assetType != 524288) {
                        TVKLogUtil.e(TAG, "[preload] video preload unsupported: invalid asset.");
                        return -1;
                    }
                    ITVKVodInfoGetter createVodInfoGetter = TVKCGIFactory.createVodInfoGetter(this.mTVKContext, Looper.myLooper());
                    createVodInfoGetter.setVodInfoListener(this.mVodInfoListener);
                    requestOnlinePlayInfo = createVodInfoGetter.requestOnlinePlayInfo(new TVKCGIRequestParam.Builder(tVKPlayerVideoInfo, asset, tVKUserInfo2).definition(str).streamFormatId(TVKFormatIDChooser.chooseFormatID(tVKPlayerVideoInfo)).flowId(generateFlowId).requestSource(1).build(), this.mFeatureGroup, TVKFeatureFactory.createFeatureParamGroupForPreload(preloadParam));
                    this.mRequestIdToGetter.put(Integer.valueOf(requestOnlinePlayInfo), createVodInfoGetter);
                }
                i3 = requestOnlinePlayInfo;
                this.mRequestIdToInnerPreloadParam.put(Integer.valueOf(i3), new InnerPreloadParam(tVKPlayerVideoInfo, tVKUserInfo2, str, preloadParam, iPreloadListener, generateFlowId));
                TVKLogUtil.i(TAG, "[preload] video info request sent with requestId:" + i3);
                return i3;
            } catch (IllegalArgumentException e16) {
                TVKLogUtil.e(TAG, e16, "[preload] failed to execute request");
                return -1;
            }
        }
        TVKLogUtil.e(TAG, "[preload] video preload unsupported: invalid videoInfo.");
        return -1;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr
    public void stopPreload(int i3) {
        TVKLogUtil.i(TAG, "stopPreload, requestId:" + i3);
        Object remove = this.mRequestIdToGetter.remove(Integer.valueOf(i3));
        if (remove instanceof ITVKLiveInfoGetter) {
            ((ITVKLiveInfoGetter) remove).cancelRequest(i3);
        } else if (remove instanceof ITVKDataParseGetter) {
            ((ITVKDataParseGetter) remove).cancelRequest(i3);
        } else if (remove instanceof ITVKVodInfoGetter) {
            ((ITVKVodInfoGetter) remove).cancelRequest(i3);
        }
        Integer remove2 = this.mRequestIdToPreloadId.remove(Integer.valueOf(i3));
        if (remove2 != null) {
            this.mMediaAssetPreloader.stop(remove2.intValue());
            this.mPreloadIdToRequestId.remove(remove2);
        }
        this.mRequestIdToInnerPreloadParam.remove(Integer.valueOf(i3));
    }
}
