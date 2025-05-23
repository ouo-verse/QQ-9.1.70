package com.tencent.qqlive.tvkplayer.vinfo.api.feature;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import java.util.Map;
import org.w3c.dom.Node;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKVodFeature extends ITVKFeatureBase {
    void buildVodCGIParams(@NonNull TVKCGIRequestParam tVKCGIRequestParam, ITVKFeatureParamGroup iTVKFeatureParamGroup, @NonNull Map<String, String> map);

    void parseVodCGIResponse(@NonNull TVKVodVideoInfo tVKVodVideoInfo, @NonNull Node node) throws Exception;
}
