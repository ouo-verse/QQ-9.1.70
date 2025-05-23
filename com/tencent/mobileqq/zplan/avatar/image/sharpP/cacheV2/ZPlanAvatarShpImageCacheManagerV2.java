package com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.zplan.meme.frameanim.StrategyId;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/cacheV2/ZPlanAvatarShpImageCacheManagerV2;", "Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/cacheV2/d;", "", "c", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/StrategyId;", "Lcom/tencent/mobileqq/zplan/avatar/image/sharpP/cacheV2/b;", "Lkotlin/collections/HashMap;", "b", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "cacheKey", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarShpImageCacheManagerV2 implements d {

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<StrategyId, a> f331861b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy<ZPlanAvatarShpImageCacheManagerV2> f331862c;

    static {
        Lazy<ZPlanAvatarShpImageCacheManagerV2> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ZPlanAvatarShpImageCacheManagerV2>() { // from class: com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2.ZPlanAvatarShpImageCacheManagerV2$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanAvatarShpImageCacheManagerV2 invoke() {
                return new ZPlanAvatarShpImageCacheManagerV2();
            }
        });
        f331862c = lazy;
    }

    public ZPlanAvatarShpImageCacheManagerV2() {
        c();
    }

    private final HashMap<StrategyId, CacheProperties> b() {
        return new HashMap<>();
    }

    private final void c() {
        HashMap<StrategyId, CacheProperties> b16 = b();
        f331861b = new HashMap<>();
        for (StrategyId strategyId : StrategyId.values()) {
            CacheProperties cacheProperties = b16.get(strategyId);
            if (strategyId == StrategyId.QQ_STATUS) {
                f331861b.put(strategyId, new e(cacheProperties != null ? cacheProperties.getOwnerCacheCapacity() : 3, cacheProperties != null ? cacheProperties.getTotalCacheCapacity() : 6));
            } else {
                f331861b.put(strategyId, new c(strategyId, cacheProperties != null ? cacheProperties.getOwnerCacheCapacity() : -1, cacheProperties != null ? cacheProperties.getTotalCacheCapacity() : 6));
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2.d
    public String a(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        File file = new File(MobileQQ.sMobileQQ.getApplicationContext().getExternalCacheDir(), "zplan/shpimagev2/" + cacheKey);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + File.separator;
    }

    @Override // com.tencent.mobileqq.zplan.avatar.image.sharpP.cacheV2.d
    public void clearCache() {
        QLog.i("ZPlanAvatarShpImageCacheManagerV2", 1, "[clearCache]");
        Iterator<Map.Entry<StrategyId, a>> it = f331861b.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }
}
