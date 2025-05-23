package com.tencent.mobileqq.zplan.api.impl;

import android.content.Context;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0016Ro\u0010\u0016\u001aV\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00070\u0004j*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007`\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015Ro\u0010\u0019\u001aV\u0012\u0004\u0012\u00020\t\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00070\u0004j*\u0012\u0004\u0012\u00020\t\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007`\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZplanCacheApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZplanCacheApi;", "Landroid/content/Context;", "ctx", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/zplan/api/ZplanCacheComponentType;", "", "Lkotlin/collections/HashMap;", "getOrCreateCache", "", "uniquePageKey", "context", "cacheType", "cacheObj", "", "saveCache", "getCache", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "mCachePoolForContext$delegate", "Lkotlin/Lazy;", "getMCachePoolForContext", "()Ljava/util/HashMap;", "mCachePoolForContext", "mCachePoolForUniqueKey$delegate", "getMCachePoolForUniqueKey", "mCachePoolForUniqueKey", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanCacheApiImpl implements IZplanCacheApi {
    private static final String TAG = "ZplanCommonCacheImpl";

    /* renamed from: mCachePoolForContext$delegate, reason: from kotlin metadata */
    private final Lazy mCachePoolForContext;

    /* renamed from: mCachePoolForUniqueKey$delegate, reason: from kotlin metadata */
    private final Lazy mCachePoolForUniqueKey;

    public ZplanCacheApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<Context, HashMap<ZplanCacheComponentType, Object>>>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZplanCacheApiImpl$mCachePoolForContext$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<Context, HashMap<ZplanCacheComponentType, Object>> invoke() {
                return new HashMap<>();
            }
        });
        this.mCachePoolForContext = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, HashMap<ZplanCacheComponentType, Object>>>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZplanCacheApiImpl$mCachePoolForUniqueKey$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<String, HashMap<ZplanCacheComponentType, Object>> invoke() {
                return new HashMap<>();
            }
        });
        this.mCachePoolForUniqueKey = lazy2;
    }

    private final HashMap<Context, HashMap<ZplanCacheComponentType, Object>> getMCachePoolForContext() {
        return (HashMap) this.mCachePoolForContext.getValue();
    }

    private final HashMap<String, HashMap<ZplanCacheComponentType, Object>> getMCachePoolForUniqueKey() {
        return (HashMap) this.mCachePoolForUniqueKey.getValue();
    }

    private final HashMap<ZplanCacheComponentType, Object> getOrCreateCache(Context ctx) {
        HashMap<ZplanCacheComponentType, Object> hashMap = getMCachePoolForContext().get(ctx);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        getMCachePoolForContext().put(ctx, hashMap);
        return hashMap;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanCacheApi
    public void clearCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getMCachePoolForContext().remove(context);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanCacheApi
    public Object getCache(Context context, ZplanCacheComponentType cacheType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        HashMap<ZplanCacheComponentType, Object> orCreateCache = getOrCreateCache(context);
        QLog.i(TAG, 1, "getCache, context: " + context + ", KV --- " + cacheType + " = " + cacheType);
        return orCreateCache.get(cacheType);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanCacheApi
    public void saveCache(Context context, ZplanCacheComponentType cacheType, Object cacheObj) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        Intrinsics.checkNotNullParameter(cacheObj, "cacheObj");
        QLog.i(TAG, 1, "saveCache, cachePoolKey: " + context + ", KV --- " + cacheType + " = " + cacheObj);
        getOrCreateCache(context).put(cacheType, cacheObj);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanCacheApi
    public void clearCache(String uniquePageKey) {
        Intrinsics.checkNotNullParameter(uniquePageKey, "uniquePageKey");
        getMCachePoolForUniqueKey().remove(uniquePageKey);
    }

    private final HashMap<ZplanCacheComponentType, Object> getOrCreateCache(String uniquePageKey) {
        HashMap<ZplanCacheComponentType, Object> hashMap = getMCachePoolForUniqueKey().get(uniquePageKey);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        getMCachePoolForUniqueKey().put(uniquePageKey, hashMap);
        return hashMap;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanCacheApi
    public Object getCache(String uniquePageKey, ZplanCacheComponentType cacheType) {
        Intrinsics.checkNotNullParameter(uniquePageKey, "uniquePageKey");
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        return getOrCreateCache(uniquePageKey).get(cacheType);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanCacheApi
    public void saveCache(String uniquePageKey, ZplanCacheComponentType cacheType, Object cacheObj) {
        Intrinsics.checkNotNullParameter(uniquePageKey, "uniquePageKey");
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        Intrinsics.checkNotNullParameter(cacheObj, "cacheObj");
        QLog.i(TAG, 1, "saveCache, cachePoolKey: " + uniquePageKey + ", KV --- " + cacheType + " = " + cacheObj);
        getOrCreateCache(uniquePageKey).put(cacheType, cacheObj);
    }
}
