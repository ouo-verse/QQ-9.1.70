package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameStorageExceedManager {
    private static boolean hasShowStorageExceedDialog = false;
    private static int storageExceedCount;

    public static void showStorageExceedDialog(WeakReference<Activity> weakReference, String str, MiniAppInfo miniAppInfo) {
        if (hasShowStorageExceedDialog || !GameWnsUtils.enableStorageExceedDialog()) {
            return;
        }
        int i3 = storageExceedCount + 1;
        storageExceedCount = i3;
        if (i3 >= GameWnsUtils.enableStorageExceedLimit()) {
            hasShowStorageExceedDialog = true;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            MiniCacheFreeManager.freeCacheDialog(weakReference.get(), str, miniAppInfo, GameWnsUtils.getCacheFreeContent());
        }
    }

    public static void resetStorageExceedDialogStatus() {
        hasShowStorageExceedDialog = false;
        storageExceedCount = 0;
    }
}
