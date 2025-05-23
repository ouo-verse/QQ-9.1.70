package com.tencent.qqlive.tvkplayer.vinfo.api.feature;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKLiveFeature extends ITVKFeatureBase {
    void buildLiveCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map);

    void parseLiveCGIResponse(@NonNull TVKLiveVideoInfo tVKLiveVideoInfo, @NonNull JSONObject jSONObject) throws Exception;
}
