package com.tencent.ad.tangram.util;

import android.view.Window;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdStatusBarUtil {
    private static final String TAG = "AdStatusBarUtil";

    public static void setTransparent(Window window) {
        if (window == null) {
            AdLog.e(TAG, "[setTransparent] error, window is null");
            return;
        }
        try {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } catch (Throwable th5) {
            AdLog.e(TAG, "[setTransparent]", th5);
        }
    }
}
