package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPSecurityConfigBuilder implements ITVKOptionalParamBuilder {
    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        TVKNetVideoInfo netVideoInfo = tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo != null && !(netVideoInfo instanceof TVKLiveVideoInfo)) {
            int i3 = TVKMediaPlayerConfig.PlayerConfig.vod_proxy_authentication_strategy;
            boolean z17 = true;
            if (i3 != 2 && (i3 != 1 || netVideoInfo.getPttn() <= 0)) {
                z17 = false;
            }
            TPOptionalParam<Boolean> buildBoolean = TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_USE_PROXY_AUTHENTICATION, z17);
            ArrayList arrayList = new ArrayList();
            arrayList.add(buildBoolean);
            return arrayList;
        }
        return Collections.emptyList();
    }
}
