package com.tencent.mobileqq.mini.entry;

import com.tencent.mobileqq.mini.utils.MiniAppMMKVUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GdtAdManager {
    public static final String LAST_ALLOW_REQUEST_TIME = "last_allow_request_time";
    private static final String TAG = "GdtAdManager";
    private static long mLastAllowRequestTime;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class SingletonHolder {
        private static final GdtAdManager INSTANCE = new GdtAdManager();

        SingletonHolder() {
        }
    }

    GdtAdManager() {
        mLastAllowRequestTime = MiniAppMMKVUtils.getLong(LAST_ALLOW_REQUEST_TIME, 0L);
    }

    public static GdtAdManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public boolean isValidGdtAdRequest() {
        mLastAllowRequestTime = MiniAppMMKVUtils.getLong(LAST_ALLOW_REQUEST_TIME, 0L);
        if (System.currentTimeMillis() > mLastAllowRequestTime) {
            com.tencent.xaction.log.b.a(TAG, 1, "is Valid GdtAdRequest");
            return true;
        }
        com.tencent.xaction.log.b.a(TAG, 1, "is InvalidGdtAdRequest");
        return false;
    }

    public void updateLastAllowRequestTime(int i3) {
        MiniAppMMKVUtils.putLong(LAST_ALLOW_REQUEST_TIME, System.currentTimeMillis() + (i3 * 1000));
    }
}
