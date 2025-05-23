package com.tencent.qqmini.sdk.manager;

import android.app.Activity;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniGameStorageExceedManager {
    private static boolean hasShowStorageExceedDialog = false;
    private static int storageExceedCount;

    public static void resetStorageExceedDialogStatus() {
        hasShowStorageExceedDialog = false;
        storageExceedCount = 0;
    }

    public static void showStorageExceedDialog(WeakReference<Activity> weakReference, String str, MiniAppInfo miniAppInfo, IMiniAppContext iMiniAppContext) {
        if (!hasShowStorageExceedDialog && GameWnsUtils.enableStorageExceedDialog()) {
            int i3 = storageExceedCount + 1;
            storageExceedCount = i3;
            if (i3 >= GameWnsUtils.enableStorageExceedLimit()) {
                hasShowStorageExceedDialog = true;
                if (weakReference != null && weakReference.get() != null) {
                    MiniCacheFreeManager.freeCacheDialog(weakReference.get(), str, miniAppInfo, GameWnsUtils.getCacheFreeContent(), iMiniAppContext);
                }
            }
        }
    }
}
