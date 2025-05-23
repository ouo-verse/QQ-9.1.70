package com.tencent.mobileqq.zplan.web.api.impl;

import cl3.b;
import com.tencent.mobileqq.zplan.web.api.IZPlanWebUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/api/impl/ZPlanWebUtilImpl;", "Lcom/tencent/mobileqq/zplan/web/api/IZPlanWebUtil;", "()V", "isApolloProxyEnable", "", "isZPlanWebOfflineResLoaded", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanWebUtilImpl implements IZPlanWebUtil {
    @Override // com.tencent.mobileqq.zplan.web.api.IZPlanWebUtil
    public boolean isApolloProxyEnable() {
        return false;
    }

    @Override // com.tencent.mobileqq.zplan.web.api.IZPlanWebUtil
    public boolean isZPlanWebOfflineResLoaded() {
        return ((b) vb3.a.f441346a.b(b.class)).getIsResDownloaded();
    }
}
