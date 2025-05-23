package com.tencent.mobileqq.zplan.api.impl;

import com.tencent.mobileqq.zplan.api.IZootopiaPortalFilamentConfigHelper;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZootopiaPortalFilamentConfigHelperImpl;", "Lcom/tencent/mobileqq/zplan/api/IZootopiaPortalFilamentConfigHelper;", "", "refreshConfig", "Lcom/tencent/mobileqq/zplan/api/a;", "configData", "loadConfig", "", "enableFilament", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaPortalFilamentConfigHelperImpl implements IZootopiaPortalFilamentConfigHelper {
    @Override // com.tencent.mobileqq.zplan.api.IZootopiaPortalFilamentConfigHelper
    public boolean enableFilament() {
        return FilamentApiImpl.f369933a.d();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZootopiaPortalFilamentConfigHelper
    public void loadConfig(com.tencent.mobileqq.zplan.api.a configData) {
        FilamentApiImpl.f369933a.loadConfig(configData);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZootopiaPortalFilamentConfigHelper
    public void refreshConfig() {
        FilamentApiImpl.f369933a.f();
    }
}
