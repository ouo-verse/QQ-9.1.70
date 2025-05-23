package com.tencent.mobileqq.zplan.api.impl;

import com.tencent.mobileqq.zootopia.lua.ZPlanPortalStoreLuaPlugin;
import com.tencent.mobileqq.zplan.api.IZPlanPortalStoreLuaPluginHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanPortalStoreLuaPluginHelperImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanPortalStoreLuaPluginHelper;", "()V", "setPayPanelShowingState", "", "isPayPanelShowing", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanPortalStoreLuaPluginHelperImpl implements IZPlanPortalStoreLuaPluginHelper {
    @Override // com.tencent.mobileqq.zplan.api.IZPlanPortalStoreLuaPluginHelper
    public void setPayPanelShowingState(boolean isPayPanelShowing) {
        ZPlanPortalStoreLuaPlugin.INSTANCE.e(isPayPanelShowing);
    }
}
