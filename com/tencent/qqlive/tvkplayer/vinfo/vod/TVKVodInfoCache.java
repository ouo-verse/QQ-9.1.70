package com.tencent.qqlive.tvkplayer.vinfo.vod;

import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKNetVideoInfoCache;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVodInfoCache extends TVKNetVideoInfoCache {
    private static final List<String> KEYS_TO_BE_REMOVED_FROM_HEADERS_MAP;
    private static final List<String> KEYS_TO_BE_REMOVED_FROM_REQUEST_MAP;
    private static final TVKVodInfoCache sInstance;

    static {
        ArrayList arrayList = new ArrayList();
        KEYS_TO_BE_REMOVED_FROM_REQUEST_MAP = arrayList;
        ArrayList arrayList2 = new ArrayList();
        KEYS_TO_BE_REMOVED_FROM_HEADERS_MAP = arrayList2;
        arrayList.add("flowid");
        arrayList.add("cKey");
        arrayList.add("bitrate");
        arrayList.add("pageId");
        arrayList.add(TVKCommonParamEnum.REQ_PARAM_KEY_AD_PASS);
        arrayList.add("ad_request_id");
        arrayList2.add(TVKCommonParamEnum.RequestHeaders.HOST);
        sInstance = new TVKVodInfoCache();
    }

    protected TVKVodInfoCache() {
        super(KEYS_TO_BE_REMOVED_FROM_REQUEST_MAP, KEYS_TO_BE_REMOVED_FROM_HEADERS_MAP);
    }

    private static int calculateCachedObjectValidDurationSec(TVKVodVideoInfo tVKVodVideoInfo) {
        int min = Math.min(tVKVodVideoInfo.getCt(), TVKMediaPlayerConfig.PlayerConfig.vod_cgi_cached_object_valid_duration_sec);
        long expirationTimeSec = tVKVodVideoInfo.getExpirationTimeSec();
        if (expirationTimeSec <= 0) {
            return min;
        }
        return Math.min(min, (int) (expirationTimeSec - tVKVodVideoInfo.getTm()));
    }

    public static TVKVodInfoCache getInstance() {
        return sInstance;
    }

    private static boolean hasPluginAdInfo(TVKVodVideoInfo tVKVodVideoInfo) {
        if (tVKVodVideoInfo.getAdInfo() != null && tVKVodVideoInfo.getAdInfo().getPluginAdInfos() != null && !tVKVodVideoInfo.getAdInfo().getPluginAdInfos().isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isClipMP4Invalid(TVKVodVideoInfo tVKVodVideoInfo) {
        if ((tVKVodVideoInfo.getDownloadType() != 4 && tVKVodVideoInfo.getDownloadType() != 5) || (tVKVodVideoInfo.getSectionList() != null && tVKVodVideoInfo.getSectionList().size() != 0)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.common.TVKNetVideoInfoCache
    protected boolean isObjectToBeCachedInvalid(TVKNetVideoInfo tVKNetVideoInfo) {
        if (!(tVKNetVideoInfo instanceof TVKVodVideoInfo)) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: not a vod video info object");
            return true;
        }
        TVKVodVideoInfo tVKVodVideoInfo = (TVKVodVideoInfo) tVKNetVideoInfo;
        if (tVKVodVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_SERVER_BY_MULTI_NIC) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: multi nic response result");
            return true;
        }
        if (tVKVodVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_CACHE) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: already been cached");
            return true;
        }
        if (hasPluginAdInfo(tVKVodVideoInfo)) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: plugin ad info contained");
            return true;
        }
        if (tVKVodVideoInfo.isPreview()) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: preview mode");
            return true;
        }
        if (tVKVodVideoInfo.getCached() == 0) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: forbidden by server");
            return true;
        }
        if (tVKVodVideoInfo.getUrlList().isEmpty()) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: empty url list");
            return true;
        }
        if (tVKVodVideoInfo.getDefinitionList().isEmpty()) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: empty definition list");
            return true;
        }
        if (isClipMP4Invalid(tVKVodVideoInfo)) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: empty section list for clip mp4 resource");
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.common.TVKNetVideoInfoCache
    public boolean put(String str, TVKNetVideoInfo tVKNetVideoInfo) {
        if (!(tVKNetVideoInfo instanceof TVKVodVideoInfo)) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "failed to put: not a vod video info object");
            return false;
        }
        return super.put(str, tVKNetVideoInfo, calculateCachedObjectValidDurationSec((TVKVodVideoInfo) tVKNetVideoInfo));
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.common.TVKNetVideoInfoCache
    @Nullable
    public TVKVodVideoInfo get(String str) {
        TVKNetVideoInfo tVKNetVideoInfo = super.get(str);
        if (!(tVKNetVideoInfo instanceof TVKVodVideoInfo)) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "failed to get: not a vod video info object");
            return null;
        }
        return (TVKVodVideoInfo) tVKNetVideoInfo;
    }
}
