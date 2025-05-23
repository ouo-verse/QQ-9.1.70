package com.tencent.thumbplayer.api.localproxy;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.manager.TPMgr;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.datatransport.localproxy.TPLocalProxy;

/* loaded from: classes26.dex */
public class TPLocalProxyFactory {
    private static final String TAG = "TPLocalProxyFactory";

    @Nullable
    public static ITPLocalProxy createTPLocalProxy() {
        if (!TPMgr.isInitialized()) {
            return null;
        }
        try {
            return new TPLocalProxy();
        } catch (UnsupportedOperationException e16) {
            TPLogUtil.e(TAG, e16);
            return null;
        }
    }
}
