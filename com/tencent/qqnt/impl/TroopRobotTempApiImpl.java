package com.tencent.qqnt.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qqnt.ITroopRobotTempApi;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/impl/TroopRobotTempApiImpl;", "Lcom/tencent/qqnt/ITroopRobotTempApi;", "()V", "isRobotUin", "", "uin", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class TroopRobotTempApiImpl implements ITroopRobotTempApi {
    static IPatchRedirector $redirector_;

    public TroopRobotTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ITroopRobotTempApi
    public boolean isRobotUin(@Nullable String uin) {
        ITroopRobotService iTroopRobotService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iTroopRobotService = (ITroopRobotService) peekAppRuntime.getRuntimeService(ITroopRobotService.class, "all")) != null) {
            return iTroopRobotService.isRobotUin(uin);
        }
        return false;
    }
}
