package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import com.tencent.biz.qqcircle.manager.QFSUsersLiveStatusManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class co extends u {
    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_query_posters_live_status", true);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QFSUsersLiveStatusManager.i().p();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QFSUsersLiveStatusManager.i().o();
    }
}
