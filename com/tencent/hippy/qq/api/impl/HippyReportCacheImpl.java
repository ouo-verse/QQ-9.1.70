package com.tencent.hippy.qq.api.impl;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.hippy.qq.api.IHippyReportCache;
import com.tencent.hippy.qq.obj.HippyEngineReportData;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyReportCacheImpl implements IHippyReportCache {
    LruCache<String, HippyEngineReportData> reportDataCache = new LruCache<>(3);

    @Override // com.tencent.hippy.qq.api.IHippyReportCache
    public void clearAllReportData() {
        synchronized (this.reportDataCache) {
            this.reportDataCache.evictAll();
        }
    }

    @Override // com.tencent.hippy.qq.api.IHippyReportCache
    public void clearReportData(@NotNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.reportDataCache) {
            this.reportDataCache.remove(str);
        }
    }

    @Override // com.tencent.hippy.qq.api.IHippyReportCache
    public HippyEngineReportData getReportData(@NotNull String str) {
        HippyEngineReportData hippyEngineReportData;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.reportDataCache) {
            hippyEngineReportData = this.reportDataCache.get(str);
        }
        return hippyEngineReportData;
    }

    @Override // com.tencent.hippy.qq.api.IHippyReportCache
    public void saveReportData(@NotNull String str, HippyEngineReportData hippyEngineReportData) {
        if (!TextUtils.isEmpty(str) && hippyEngineReportData != null) {
            synchronized (this.reportDataCache) {
                this.reportDataCache.put(str, hippyEngineReportData);
            }
        }
    }
}
