package com.tencent.mobileqq.vas.onlinestatus.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CustomOnlineStatusManagerImpl implements ICustomOnlineStatusManager {
    @Override // com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager
    public boolean featureEnable() {
        return CustomOnlineStatusManager.d().c();
    }

    @Override // com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager
    public String getOwnerOnlineStatus() {
        return CustomOnlineStatusManager.d().e();
    }

    @Override // com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager
    public void openH5(Activity activity, String str) {
        CustomOnlineStatusManager.Utils.j(activity, str);
    }

    @Override // com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager
    public void registerChangeWeakListener(Runnable runnable) {
        CustomOnlineStatusManager.d().h(runnable);
    }

    @Override // com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager
    public void removeChangeWeakCallBack() {
        CustomOnlineStatusManager.d().i();
    }
}
