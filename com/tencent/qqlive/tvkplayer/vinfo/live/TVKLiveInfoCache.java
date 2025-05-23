package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKNetVideoInfoCache;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKLiveInfoCache extends TVKNetVideoInfoCache {
    private static final List<String> KEYS_TO_BE_REMOVED_FROM_HEADERS_MAP;
    private static final List<String> KEYS_TO_BE_REMOVED_FROM_REQUEST_MAP;
    private static final TVKLiveInfoCache sInstance;

    static {
        ArrayList arrayList = new ArrayList();
        KEYS_TO_BE_REMOVED_FROM_REQUEST_MAP = arrayList;
        KEYS_TO_BE_REMOVED_FROM_HEADERS_MAP = new ArrayList();
        arrayList.add("flowid");
        arrayList.add(TVKLiveRequestBuilder.RequestParamKey.CKEY);
        arrayList.add(TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP);
        arrayList.add(TVKLiveRequestBuilder.RequestParamKey.BANDWIDTH);
        arrayList.add(TVKLiveRequestBuilder.RequestParamKey.RANDOM_NUMBER);
        sInstance = new TVKLiveInfoCache();
    }

    protected TVKLiveInfoCache() {
        super(KEYS_TO_BE_REMOVED_FROM_REQUEST_MAP, KEYS_TO_BE_REMOVED_FROM_HEADERS_MAP);
    }

    public static TVKLiveInfoCache getInstance() {
        return sInstance;
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.common.TVKNetVideoInfoCache
    protected boolean isObjectToBeCachedInvalid(TVKNetVideoInfo tVKNetVideoInfo) {
        if (!(tVKNetVideoInfo instanceof TVKLiveVideoInfo)) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: not a live video info object");
            return true;
        }
        if (tVKNetVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_SERVER_BY_MULTI_NIC) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: multi nic response result");
            return true;
        }
        if (tVKNetVideoInfo.getFromType() == TVKVideoInfoFromType.FROM_TYPE_CACHE) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: cache object has already been cached");
            return true;
        }
        if (tVKNetVideoInfo.isPreview()) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: preview mode");
            return true;
        }
        if (TextUtils.isEmpty(((TVKLiveVideoInfo) tVKNetVideoInfo).getPlayUrl())) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: empty url");
            return true;
        }
        if (tVKNetVideoInfo.getDefinitionList().isEmpty()) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "invalid cache object: empty definition list");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqlive.tvkplayer.vinfo.common.TVKNetVideoInfoCache
    public void modifyParamsMap(Map<String, String> map) {
        super.modifyParamsMap(map);
        if (!map.containsKey(TVKLiveRequestBuilder.RequestParamKey.PLAYER_SCENE)) {
            return;
        }
        map.put(TVKLiveRequestBuilder.RequestParamKey.PLAYER_SCENE, String.valueOf(TVKUtils.optInt(map.get(TVKLiveRequestBuilder.RequestParamKey.PLAYER_SCENE), 0) | 1));
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.common.TVKNetVideoInfoCache
    public boolean put(String str, TVKNetVideoInfo tVKNetVideoInfo) {
        return super.put(str, tVKNetVideoInfo, TVKMediaPlayerConfig.PlayerConfig.live_cgi_cached_object_valid_duration_sec);
    }

    @Override // com.tencent.qqlive.tvkplayer.vinfo.common.TVKNetVideoInfoCache
    @Nullable
    public TVKLiveVideoInfo get(String str) {
        TVKNetVideoInfo tVKNetVideoInfo = super.get(str);
        if (!(tVKNetVideoInfo instanceof TVKLiveVideoInfo)) {
            TVKLogUtil.w("TVKNetVideoInfoCache", "failed to get: not a live video info object");
            return null;
        }
        return (TVKLiveVideoInfo) tVKNetVideoInfo;
    }
}
