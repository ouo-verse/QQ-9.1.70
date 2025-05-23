package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.cache;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.e;
import kotlin.Metadata;
import zz0.a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/cache/QzoneProtocolCacheManager;", "", "()V", "TAG", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "cacheKey", "loadRspCache", "", "saveRspCache", "byteArr", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneProtocolCacheManager {
    public static final int $stable = 0;
    public static final QzoneProtocolCacheManager INSTANCE = new QzoneProtocolCacheManager();
    public static final String TAG = "QzoneProtocolCacheManager_";

    QzoneProtocolCacheManager() {
    }

    public final void clearCache(String cacheKey) {
        try {
            a aVar = a.f453719a;
            long a16 = aVar.a();
            KLog kLog = KLog.INSTANCE;
            kLog.d(TAG, "start clearCache, cacheKey: " + cacheKey);
            ((e) c.f117352a.g().acquireModule("KRDiskCacheModule")).d(cacheKey);
            kLog.d(TAG, "clearCache success, cacheKey: " + cacheKey + ", costTime: " + (aVar.a() - a16) + "ms");
        } catch (Throwable th5) {
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("clearCache failed, cacheKey: ", cacheKey, ", error: ");
            m3.append(th5.getMessage());
            kLog2.e(TAG, m3.toString());
        }
    }

    public final byte[] loadRspCache(String cacheKey) {
        try {
            a aVar = a.f453719a;
            long a16 = aVar.a();
            KLog kLog = KLog.INSTANCE;
            kLog.d(TAG, "start loadRspCache, cacheKey: " + cacheKey);
            byte[] a17 = ((e) c.f117352a.g().acquireModule("KRDiskCacheModule")).a(cacheKey);
            long a18 = aVar.a() - a16;
            if (a17 != null) {
                kLog.d(TAG, "loadRspCache success, cacheKey: " + cacheKey + ", byteArr size: " + a17.length + ", costTime: " + a18 + "ms");
            } else {
                kLog.d(TAG, "loadRspCache not found, cacheKey: " + cacheKey + ", costTime: " + a18 + "ms");
            }
            return a17;
        } catch (Throwable th5) {
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("loadRspCache failed, cacheKey: ", cacheKey, ", error: ");
            m3.append(th5.getMessage());
            kLog2.e(TAG, m3.toString());
            return null;
        }
    }

    public final void saveRspCache(String cacheKey, byte[] byteArr) {
        try {
            a aVar = a.f453719a;
            long a16 = aVar.a();
            KLog kLog = KLog.INSTANCE;
            kLog.d(TAG, "start saveRspCache, cacheKey: " + cacheKey + ", byteArr size: " + byteArr.length);
            ((e) c.f117352a.g().acquireModule("KRDiskCacheModule")).e(cacheKey, byteArr);
            kLog.d(TAG, "saveRspCache success, cacheKey: " + cacheKey + ", byteArr size: " + byteArr.length + ", costTime: " + (aVar.a() - a16) + "ms");
        } catch (Throwable th5) {
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("saveRspCache failed, cacheKey: ", cacheKey, ", error: ");
            m3.append(th5.getMessage());
            kLog2.e(TAG, m3.toString());
        }
    }
}
