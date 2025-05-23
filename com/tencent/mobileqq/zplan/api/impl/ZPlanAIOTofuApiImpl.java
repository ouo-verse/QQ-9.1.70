package com.tencent.mobileqq.zplan.api.impl;

import android.content.Context;
import com.tencent.mobileqq.zplan.api.IZPlanAIOTofuApi;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanAIOTofuApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOTofuApi;", "()V", "openPortalStore", "", "context", "Landroid/content/Context;", "url", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanAIOTofuApiImpl implements IZPlanAIOTofuApi {
    @Override // com.tencent.mobileqq.zplan.api.IZPlanAIOTofuApi
    public void openPortalStore(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        PortalStoreCreateRoleBubbleHelper.f371421a.g(context, url);
    }
}
