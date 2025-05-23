package com.tencent.thumbplayer.retry;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.config.TPConfig;

/* loaded from: classes26.dex */
public class TPPlayerRetryAdapterFactory {
    public static ITPPlayerRetryAdapter createTPPlayerRetryAdapter(@NonNull TPContext tPContext, @Nullable TPPlayerConstructParams tPPlayerConstructParams) throws TPLoadLibraryException {
        if (((Boolean) TPConfig.getConfigValue(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_PLAYING_QUALITY_REPORT, Boolean.FALSE)).booleanValue()) {
            return (ITPPlayerRetryAdapter) new TPPlayerRetryAdapterProxy(new TPPlayerRetryAdapter(tPContext, tPPlayerConstructParams), tPContext).getProxyInstance();
        }
        return new TPPlayerRetryAdapter(tPContext, tPPlayerConstructParams);
    }
}
