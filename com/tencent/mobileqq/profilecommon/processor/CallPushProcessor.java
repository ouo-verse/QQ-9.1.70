package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class CallPushProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public CallPushProcessor(AppRuntime appRuntime) {
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
        return "CallPushProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        if (i3 == 27393) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) byteStringMicro);
            return;
        }
        if (i3 == 27393) {
            if (QLog.isColorLevel()) {
                QLog.d("CallPushProcessor", 2, "call_push ok");
            }
            AppRuntime appRuntime = this.appRuntime;
            if (appRuntime instanceof QQAppInterface) {
                ((VipSetFunCallHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER)).Q2(1, new Bundle(), true);
            }
        }
    }
}
