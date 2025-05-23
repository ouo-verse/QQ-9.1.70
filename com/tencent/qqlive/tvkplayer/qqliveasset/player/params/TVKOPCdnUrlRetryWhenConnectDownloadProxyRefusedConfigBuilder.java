package com.tencent.qqlive.tvkplayer.qqliveasset.player.params;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKOPCdnUrlRetryWhenConnectDownloadProxyRefusedConfigBuilder implements ITVKOptionalParamBuilder {
    private boolean isAllowSwitchToCdnUrls(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        TVKNetVideoInfo netVideoInfo = tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo == null || netVideoInfo.isMatchDrmType(3) || netVideoInfo.isMatchDrmType(5) || netVideoInfo.isMatchDrmType(7)) {
            return false;
        }
        if (netVideoInfo.getAdInfo() != null && netVideoInfo.getAdInfo().getPluginAdInfos() != null && !netVideoInfo.getAdInfo().getPluginAdInfos().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.params.ITVKOptionalParamBuilder
    @NonNull
    public List<TPOptionalParam<?>> buildOptionalParamList(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, boolean z16) {
        ArrayList arrayList = new ArrayList();
        if (isAllowSwitchToCdnUrls(tVKQQLiveAssetPlayerContext) && TVKMediaPlayerConfig.PlayerConfig.enable_cdn_url_retry_when_connect_download_proxy_refused) {
            arrayList.add(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_RETRY_ORIGINAL_URL_WHEN_DOWNLOAD_PROXY_EXCEPTION_AND_CONNECT_REFUSED, true));
        }
        return arrayList;
    }
}
