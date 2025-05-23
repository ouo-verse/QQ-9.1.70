package com.tencent.mobileqq.stt;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISttManagerApi extends QRouteApi {
    int getConfigVersion(AppRuntime appRuntime);

    boolean getSttAbility(AppRuntime appRuntime);

    void initAutoToTextSwitch(AppRuntime appRuntime);

    boolean isSttSession(int i3);

    void resetSttAbility();

    void saveConfigVersion(AppRuntime appRuntime, int i3);

    boolean setSttAbility(AppRuntime appRuntime, boolean z16);
}
