package com.tencent.mobileqq.vas.adv.preload.api.impl;

import com.tencent.mobileqq.vas.adv.preload.api.IVasAdvPreloadApi;
import com.tencent.mobileqq.vas.adv.preload.f;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R7\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r`\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/preload/api/impl/VasAdvPreloadApiImpl;", "Lcom/tencent/mobileqq/vas/adv/preload/api/IVasAdvPreloadApi;", "", "businessId", "", "posIdList", "", "addPreloadAd", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "removeAd", "loadAd", "getAdAsJson", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/vas/adv/preload/f;", "Lkotlin/collections/HashMap;", "preloadServiceMap$delegate", "Lkotlin/Lazy;", "getPreloadServiceMap", "()Ljava/util/HashMap;", "preloadServiceMap", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdvPreloadApiImpl implements IVasAdvPreloadApi {

    /* renamed from: preloadServiceMap$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy preloadServiceMap;

    public VasAdvPreloadApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, f>>() { // from class: com.tencent.mobileqq.vas.adv.preload.api.impl.VasAdvPreloadApiImpl$preloadServiceMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, f> invoke() {
                return new HashMap<>();
            }
        });
        this.preloadServiceMap = lazy;
    }

    private final HashMap<String, f> getPreloadServiceMap() {
        return (HashMap) this.preloadServiceMap.getValue();
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasAdvPreloadApi
    public void addPreloadAd(@NotNull String businessId, @NotNull List<String> posIdList) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(posIdList, "posIdList");
        getPreloadServiceMap().put(businessId, new f(businessId, posIdList));
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasAdvPreloadApi
    @Nullable
    public String getAdAsJson(@NotNull String businessId) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        return f.INSTANCE.b(businessId);
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasAdvPreloadApi
    public void loadAd(@NotNull String businessId) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        f fVar = getPreloadServiceMap().get(businessId);
        if (fVar != null) {
            fVar.f();
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.preload.api.IVasAdvPreloadApi
    @Nullable
    public qq_ad_get.QQAdGetRsp removeAd(@NotNull String businessId) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        getPreloadServiceMap().remove(businessId);
        return f.INSTANCE.c(businessId);
    }
}
