package com.tencent.mobileqq.activity.recent.msgbox.businesshandler;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b
    public void a(AppInterface appInterface, Message message, int i3, MsgSummary msgSummary) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInterface, message, Integer.valueOf(i3), msgSummary);
        } else {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).handleGameMsgRecentUserSummery(appInterface, message, i3, msgSummary);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b
    public boolean b(AppInterface appInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, i3)).booleanValue();
        }
        return ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).isIgnoreGameMsg(appInterface, i3);
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b
    public String c(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) str);
        }
        return ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(str, appInterface);
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b
    public void d(AppInterface appInterface, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInterface, Integer.valueOf(i3), str);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.businesshandler.b
    public boolean e(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appInterface, (Object) str)).booleanValue();
        }
        return ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).isShowMsg(appInterface, str);
    }
}
