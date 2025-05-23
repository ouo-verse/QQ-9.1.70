package com.tencent.mobileqq.hotpic;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IPopupEmotionSearchManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i extends MSFServlet {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime != null && (appRuntime instanceof AppInterface)) {
            if (intent.getBooleanExtra(IEmotionSearchManagerService.IS_FROM_EMOTION_SEARCH, false)) {
                ((IEmotionSearchManagerService) ((BaseQQAppInterface) appRuntime).getRuntimeService(IEmotionSearchManagerService.class)).handleResonpse(intent, fromServiceMsg);
            } else if (intent.getBooleanExtra(IEmotionSearchManagerService.IS_FROM_POPUP_EMOTION_SEARCH, false)) {
                ((IPopupEmotionSearchManagerService) ((BaseQQAppInterface) appRuntime).getRuntimeService(IPopupEmotionSearchManagerService.class)).handleResonpse(intent, fromServiceMsg);
            } else {
                ((IEmosmService) QRoute.api(IEmosmService.class)).handleResonpse((BaseQQAppInterface) appRuntime, intent, fromServiceMsg);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
        } else {
            if (intent == null) {
                QLog.e("HotPicServlet", 1, "onSend : req is null");
                return;
            }
            packet.setSSOCommand(intent.getStringExtra("key_cmd"));
            packet.putSendData(intent.getByteArrayExtra(ProtoServlet.KEY_BODY));
            packet.setTimeout(intent.getLongExtra(ProtoServlet.KEY_TIMEOUT, 6000L));
        }
    }
}
