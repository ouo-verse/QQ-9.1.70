package com.tencent.mobileqq.loginprocessor;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusLikeStatusApi;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import ec2.c;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes15.dex */
public class OnlineStatusNotifyProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public OnlineStatusNotifyProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "OnlineStatusNotifyProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x5eb_reqbody)).booleanValue();
        }
        if (oidb_0x5eb_reqbody == null) {
            QLog.i("OnlineStatusNotifyProcessor", 1, "reqBody == null");
            return true;
        }
        oidb_0x5eb_reqbody.unit32_online_state_praise_notify.set(1);
        QLog.i("OnlineStatusNotifyProcessor", 1, "onGetProfileDetailRequestForLogin");
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
            return;
        }
        if (oidb_0x5eb_udcuindata == null) {
            QLog.i("OnlineStatusNotifyProcessor", 1, "onGetProfileDetailResponse udcUinData == null");
            return;
        }
        if (this.appRuntime == null) {
            QLog.i("OnlineStatusNotifyProcessor", 1, "onGetProfileDetailResponse appRuntime == null");
            return;
        }
        PBUInt32Field pBUInt32Field = oidb_0x5eb_udcuindata.unit32_online_state_praise_notify;
        QLog.d("OnlineStatusNotifyProcessor", 1, "onGetProfileDetailResponse " + pBUInt32Field.get());
        if (pBUInt32Field.get() == 1) {
            ((c) ((BaseQQAppInterface) this.appRuntime).getBusinessHandler(((IOnlineStatusLikeStatusApi) QRoute.api(IOnlineStatusLikeStatusApi.class)).getOnlineStatusAggregationHandlerName())).d("login");
        }
    }
}
