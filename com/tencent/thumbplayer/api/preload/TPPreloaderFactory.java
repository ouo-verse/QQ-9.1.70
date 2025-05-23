package com.tencent.thumbplayer.api.preload;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.datatransport.preload.TPPreloader;

/* loaded from: classes26.dex */
public class TPPreloaderFactory {
    private static final String TAG = "TPPreloaderFactory";

    @Nullable
    public static ITPPreloader createPreloader() {
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return null;
        }
        try {
            return new TPPreloader();
        } catch (UnsupportedOperationException e16) {
            TPLogUtil.e(TAG, e16);
            return null;
        }
    }
}
