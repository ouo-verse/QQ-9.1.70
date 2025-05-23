package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import android.util.SparseLongArray;
import com.tencent.mobileqq.emoticon.CommonUsedSystemEmojiManagerConstants;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.utils.MiniAppMMKVUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007J\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/MiniAppExpRequestRefreshConfig;", "", "()V", "mLastRequestTimes", "Landroid/util/SparseLongArray;", "mRefreshIntervals", "getLastRequestTime", "", "scene", "Lcom/tencent/mobileqq/mini/entry/desktop/GetAppListV2Scene;", "getRefreshInterval", "isExpired", "", "setLastRequestTime", "", CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, "setRefreshInterval", "refreshInterval", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpRequestRefreshConfig {
    private static final String KEY_LAST_REFRESH_TIME = "exp_desktop_last_refresh_time";
    private static final String KEY_REFRESH_INTERVAL = "exp_desktop_refresh_interval";
    private static final String TAG = "MiniAppExpRequestRefreshConfig";
    private final SparseLongArray mLastRequestTimes = new SparseLongArray();
    private final SparseLongArray mRefreshIntervals = new SparseLongArray();

    public final long getLastRequestTime(GetAppListV2Scene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.mLastRequestTimes.indexOfKey(scene.ordinal()) < 0) {
            this.mLastRequestTimes.put(scene.ordinal(), MiniAppMMKVUtils.getLong("exp_desktop_last_refresh_time_" + scene.ordinal(), 0L));
        }
        return this.mLastRequestTimes.get(scene.ordinal(), 0L);
    }

    public final long getRefreshInterval(GetAppListV2Scene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.mRefreshIntervals.indexOfKey(scene.ordinal()) < 0) {
            this.mRefreshIntervals.put(scene.ordinal(), MiniAppMMKVUtils.getLong("exp_desktop_refresh_interval_" + scene.ordinal(), 0L));
        }
        return this.mRefreshIntervals.get(scene.ordinal(), 0L);
    }

    public final boolean isExpired(GetAppListV2Scene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        long lastRequestTime = getLastRequestTime(scene);
        long refreshInterval = getRefreshInterval(scene);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < lastRequestTime) {
            lastRequestTime = 0;
            setLastRequestTime(scene, 0L);
            QLog.w(TAG, 1, "currentTime is before lastRequestTime, reset lastRequestTime");
        }
        long j3 = currentTimeMillis - lastRequestTime;
        boolean z16 = j3 >= ((long) 1000) * refreshInterval;
        QLog.i(TAG, 1, "check isExpired, scene: " + scene + ", lastRequestTime: " + lastRequestTime + ", currentTime: " + currentTimeMillis + ", gap: " + j3 + ", interval: " + refreshInterval + ", expired: " + z16);
        return z16;
    }

    public final void setLastRequestTime(GetAppListV2Scene scene, long lastRequestTime) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.mLastRequestTimes.put(scene.ordinal(), lastRequestTime);
        MiniAppMMKVUtils.putLong("exp_desktop_last_refresh_time_" + scene.ordinal(), lastRequestTime);
    }

    public final void setRefreshInterval(GetAppListV2Scene scene, long refreshInterval) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.mRefreshIntervals.put(scene.ordinal(), refreshInterval);
        MiniAppMMKVUtils.putLong("exp_desktop_refresh_interval_" + scene.ordinal(), refreshInterval);
    }
}
