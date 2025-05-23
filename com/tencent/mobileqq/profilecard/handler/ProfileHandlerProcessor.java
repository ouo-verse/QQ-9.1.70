package com.tencent.mobileqq.profilecard.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileHandlerApi;
import com.tencent.mobileqq.profilecommon.api.IProfileCommonService;
import com.tencent.mobileqq.profilecommon.api.impl.ProfileCommonServiceImpl;
import com.tencent.mobileqq.profilecommon.handler.ProfileCommonHandler;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.profilecommon.processor.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.handler.c;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;

/* loaded from: classes16.dex */
public class ProfileHandlerProcessor implements c {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "I0x5ebHandlerProcessor.ProfileHandlerProcessor";

    public ProfileHandlerProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.relation.common.handler.c
    public oidb_0x5eb$ReqBody get0x5ebReqBody(Bundle bundle, oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (oidb_0x5eb$ReqBody) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) oidb_0x5eb_reqbody);
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody2 = new oidb_0x5eb$ReqBody();
        oidb_0x5eb_reqbody2.set(oidb_0x5eb_reqbody);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 2, "appRuntime = null");
            return oidb_0x5eb_reqbody;
        }
        IProfileCommonService iProfileCommonService = (IProfileCommonService) peekAppRuntime.getRuntimeService(IProfileCommonService.class, "all");
        if (iProfileCommonService != null && (iProfileCommonService instanceof ProfileCommonServiceImpl)) {
            a processorFactory = ((ProfileCommonServiceImpl) iProfileCommonService).getProcessorFactory();
            if (processorFactory == null) {
                QLog.d(TAG, 2, "null == processorFactory");
                return oidb_0x5eb_reqbody;
            }
            Iterator<AbsProfileCommonProcessor> it = processorFactory.c().iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                z16 |= it.next().onGetProfileDetailRequestForLogin(oidb_0x5eb_reqbody);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("getProfileDetailForLogin needRequest=%s", Boolean.valueOf(z16)));
            }
            if (!z16) {
                return oidb_0x5eb_reqbody2;
            }
            return oidb_0x5eb_reqbody;
        }
        QLog.d(TAG, 2, "null == profileCommonService || (!(profileCommonService instanceof ProfileCommonServiceImpl))");
        return oidb_0x5eb_reqbody;
    }

    @Override // com.tencent.relation.common.handler.c
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // com.tencent.relation.common.handler.c
    public Bundle getRequestExtraData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new Bundle();
    }

    @Override // com.tencent.relation.common.handler.c
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, oidb_0x5eb$RspBody oidb_0x5eb_rspbody, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj, oidb_0x5eb_rspbody, Boolean.valueOf(z16));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof AppInterface)) {
            ProfileCommonHandler profileCommonHandler = (ProfileCommonHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(((IProfileHandlerApi) QRoute.api(IProfileHandlerApi.class)).getProfileCommonHandler());
            if (profileCommonHandler == null) {
                QLog.d(TAG, 2, "onReceive null == handler");
                return;
            } else {
                profileCommonHandler.D2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
        }
        QLog.d(TAG, 2, "onReceive null == appRuntime || (!(appRuntime instanceof AppInterface))");
    }
}
