package com.tencent.mobileqq.onlinestatus.guide;

import com.tencent.mobileqq.config.business.ai;
import com.tencent.mobileqq.config.business.ak;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e {
    /* JADX INFO: Access modifiers changed from: protected */
    public ai a() {
        return ak.f202506a.a();
    }

    public long b(AppRuntime appRuntime) {
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        long M = af.C().M(appRuntime);
        QLog.i("StatusUiHelper", 1, "getSelfStatus status=" + onlineStatus + ",extOnlineStatus=" + M);
        if (onlineStatus == AppRuntime.Status.online) {
            return M;
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long c() {
        return NetConnInfoCenter.getServerTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d() {
        return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
    }
}
