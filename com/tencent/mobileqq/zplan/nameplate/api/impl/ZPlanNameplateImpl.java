package com.tencent.mobileqq.zplan.nameplate.api.impl;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.zplan.nameplate.ZPlanNameplateManager;
import com.tencent.mobileqq.zplan.nameplate.api.IZPlanNameplate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/nameplate/api/impl/ZPlanNameplateImpl;", "Lcom/tencent/mobileqq/zplan/nameplate/api/IZPlanNameplate;", "()V", "generateManager", "Lcom/tencent/mobileqq/zplan/nameplate/ZPlanNameplateManager;", "nameplateContainer", "Landroid/widget/RelativeLayout;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanNameplateImpl implements IZPlanNameplate {
    @Override // com.tencent.mobileqq.zplan.nameplate.api.IZPlanNameplate
    public ZPlanNameplateManager generateManager(RelativeLayout nameplateContainer) {
        Intrinsics.checkNotNullParameter(nameplateContainer, "nameplateContainer");
        return new ZPlanNameplateManager(nameplateContainer);
    }
}
