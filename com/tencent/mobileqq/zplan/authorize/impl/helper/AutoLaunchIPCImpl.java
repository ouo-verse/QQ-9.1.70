package com.tencent.mobileqq.zplan.authorize.impl.helper;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/helper/AutoLaunchIPCImpl;", "Lcom/tencent/mobileqq/zplan/authorize/impl/helper/e;", "", "isAutoLaunchSwitchOn", "", "mapId", "", ZPlanPublishSource.FROM_SCHEME, "saveScheme", "", "clearScheme", "getScheme", "canAutoLaunch", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AutoLaunchIPCImpl implements e {
    private final boolean isAutoLaunchSwitchOn() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100289", true);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.helper.e
    public boolean canAutoLaunch(String mapId) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        return isAutoLaunchSwitchOn() && f.f331488a.a(mapId);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.helper.e
    public void clearScheme(int mapId) {
        f.f331488a.b(mapId);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.helper.e
    public String getScheme(int mapId) {
        return f.f331488a.c(mapId);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.helper.e
    public int saveScheme(int mapId, String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        return f.f331488a.d(mapId, scheme);
    }
}
