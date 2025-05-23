package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class AvatarHistoryNumProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public AvatarHistoryNumProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AvatarHistoryNumProcessor", 2, "getAvatarHistoryNumFlag");
        }
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
        oidb_0x5eb_reqbody.int32_history_num_flag.set(1);
        getProfileDetail(oidb_0x5eb_reqbody, null);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AvatarHistoryNumProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AvatarHistoryNumProcessor", 2, String.format("onGetProfileDetailResponse request=%s success=%s", bundle, Boolean.valueOf(z16)));
        }
        if (oidb_0x5eb_udcuindata != null && oidb_0x5eb_udcuindata.int32_history_num_flag.has()) {
            int i3 = oidb_0x5eb_udcuindata.int32_history_num_flag.get();
            if (QLog.isColorLevel()) {
                QLog.d("AvatarHistoryNumProcessor", 2, String.format("onGetProfileDetailResponse numFlag=%s", Integer.valueOf(i3)));
            }
            ea.f4(this.appRuntime.getApplication(), this.appRuntime.getCurrentAccountUin(), i3);
        }
    }
}
