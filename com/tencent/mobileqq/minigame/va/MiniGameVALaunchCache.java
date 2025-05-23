package com.tencent.mobileqq.minigame.va;

import android.util.LruCache;
import com.tencent.mobileqq.minigame.va.downloadui.MiniGameVAStartData;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/MiniGameVALaunchCache;", "", "()V", "launchDataMap", "Landroid/util/LruCache;", "", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVAStartData;", "getMiniGameStartData", PushClientConstants.TAG_PKG_NAME, "onMiniGameVALaunch", "", "startData", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameVALaunchCache {
    public static final MiniGameVALaunchCache INSTANCE = new MiniGameVALaunchCache();
    private static final LruCache<String, MiniGameVAStartData> launchDataMap = new LruCache<>(5);

    MiniGameVALaunchCache() {
    }

    public final MiniGameVAStartData getMiniGameStartData(String pkgName) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        return launchDataMap.get(pkgName);
    }

    public final void onMiniGameVALaunch(MiniGameVAStartData startData) {
        Intrinsics.checkNotNullParameter(startData, "startData");
        MiniGameDownloadDataWrapper dataWrapper = startData.getDataWrapper();
        Intrinsics.checkNotNull(dataWrapper);
        MiniGameDownloadData data = dataWrapper.getData();
        Intrinsics.checkNotNull(data);
        launchDataMap.put(data.getPkgName(), startData);
    }
}
