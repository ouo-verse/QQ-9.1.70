package com.tencent.mobileqq.zplan.api.impl;

import com.tencent.mobileqq.zplan.api.IZPlanUECacheHelper;
import com.tencent.mobileqq.zplan.api.UECacheData;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanUECacheHelperImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanUECacheHelper;", "()V", "getAllCacheData", "", "Lcom/tencent/mobileqq/zplan/api/UECacheData;", "refreshCache", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanUECacheHelperImpl implements IZPlanUECacheHelper {
    @Override // com.tencent.mobileqq.zplan.api.IZPlanUECacheHelper
    public List<UECacheData> getAllCacheData() {
        return ((ue3.b) vb3.a.f441346a.b(ue3.b.class)).getAllCacheData();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanUECacheHelper
    public void refreshCache() {
        ((ue3.b) vb3.a.f441346a.b(ue3.b.class)).refreshCache();
    }
}
