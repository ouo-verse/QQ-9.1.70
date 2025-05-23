package com.tencent.superplayer.datatransport;

import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;

/* loaded from: classes26.dex */
public class SPProxyConfig {
    private static final String TAG = "SPProxyConfig";

    public static void init(SuperPlayerSdkOption superPlayerSdkOption) {
        if (superPlayerSdkOption == null) {
            return;
        }
        LogUtil.d(TAG, "init: " + superPlayerSdkOption);
        TPDataTransportMgr.setGlobalOptionalConfigParam("platform", String.valueOf(SuperPlayerSDKMgr.getPlatform()));
        TPDataTransportMgr.setGlobalOptionalConfigParam("pcdn_biz_id", superPlayerSdkOption.pcdnBizID);
        TPDataTransportMgr.setGlobalOptionalConfigParam("proxy_config", superPlayerSdkOption.getDownloadProxyConfig());
    }
}
