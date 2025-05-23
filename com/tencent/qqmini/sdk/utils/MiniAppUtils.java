package com.tencent.qqmini.sdk.utils;

import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppUtils {
    private static final Set<Integer> PULL_DOWN_REFER;
    private static final String TAG = "MiniAppUtils";
    private static MiniAppInfo mMiniAppInfo;

    static {
        HashSet hashSet = new HashSet();
        PULL_DOWN_REFER = hashSet;
        hashSet.add(3001);
        hashSet.add(3002);
        hashSet.add(3003);
        hashSet.add(3004);
        hashSet.add(3005);
        hashSet.add(3006);
        hashSet.add(3007);
        hashSet.add(3008);
        hashSet.add(3009);
        hashSet.add(3010);
        hashSet.add(3011);
        hashSet.add(3012);
        hashSet.add(3013);
        hashSet.add(1001);
        hashSet.add(1022);
    }

    public static synchronized MiniAppInfo getMiniAppInfo() {
        MiniAppInfo miniAppInfo;
        synchronized (MiniAppUtils.class) {
            miniAppInfo = mMiniAppInfo;
        }
        return miniAppInfo;
    }

    public static boolean isFromPullDownEntry(MiniAppInfo miniAppInfo) {
        LaunchParam launchParam;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && PULL_DOWN_REFER.contains(Integer.valueOf(launchParam.scene))) {
            return true;
        }
        return false;
    }

    public static synchronized void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        synchronized (MiniAppUtils.class) {
            mMiniAppInfo = miniAppInfo;
        }
    }

    public void release() {
        mMiniAppInfo = null;
    }
}
