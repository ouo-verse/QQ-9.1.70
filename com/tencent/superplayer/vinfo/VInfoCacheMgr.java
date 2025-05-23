package com.tencent.superplayer.vinfo;

import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.LogUtil;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
class VInfoCacheMgr {
    private static final String TAG = "VInfoCacheMgr";
    private static final int VINFO_CACHE_SAVE_TIME_MILLIS = 7200000;
    private static ConcurrentHashMap<String, SuperPlayerVideoInfo> mVinfoCache = new ConcurrentHashMap<>();

    VInfoCacheMgr() {
    }

    private static boolean checkVInfoIsValid(SuperPlayerVideoInfo superPlayerVideoInfo) {
        if (superPlayerVideoInfo != null && superPlayerVideoInfo.getVideoType() == 1 && !TextUtils.isEmpty(getKeyFromVInfo(superPlayerVideoInfo)) && !superPlayerVideoInfo.getIsDisableTVideoCache()) {
            return true;
        }
        return false;
    }

    private static boolean checkVInfoUpdateTimeIsValid(SuperPlayerVideoInfo superPlayerVideoInfo) {
        if (superPlayerVideoInfo == null || superPlayerVideoInfo.getTVideoNetInfo() == null) {
            return false;
        }
        if (System.currentTimeMillis() - superPlayerVideoInfo.getTVideoNetInfo().getUpdateTimeMillis() >= 7200000) {
            return false;
        }
        return true;
    }

    private static String getKeyFromVInfo(SuperPlayerVideoInfo superPlayerVideoInfo) {
        return superPlayerVideoInfo.getVid() + superPlayerVideoInfo.getRequestDefinition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SuperPlayerVideoInfo getVInfoFromCache(SuperPlayerVideoInfo superPlayerVideoInfo) {
        String keyFromVInfo;
        SuperPlayerVideoInfo superPlayerVideoInfo2;
        if (!checkVInfoIsValid(superPlayerVideoInfo) || (superPlayerVideoInfo2 = mVinfoCache.get((keyFromVInfo = getKeyFromVInfo(superPlayerVideoInfo)))) == null) {
            return null;
        }
        if (checkVInfoUpdateTimeIsValid(superPlayerVideoInfo2)) {
            LogUtil.d(TAG, "\u817e\u8baf\u89c6\u9891\u6362\u94fe\u547d\u4e2d\u672c\u5730\u7f13\u5b58, cacheInfo = " + superPlayerVideoInfo2.toString());
            return superPlayerVideoInfo2;
        }
        mVinfoCache.remove(keyFromVInfo);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveVInfoToCache(SuperPlayerVideoInfo superPlayerVideoInfo) {
        if (!checkVInfoIsValid(superPlayerVideoInfo)) {
            return;
        }
        String keyFromVInfo = getKeyFromVInfo(superPlayerVideoInfo);
        try {
            mVinfoCache.put(keyFromVInfo, (SuperPlayerVideoInfo) superPlayerVideoInfo.clone());
        } catch (Exception e16) {
            LogUtil.e(TAG, e16.toString());
        }
    }
}
