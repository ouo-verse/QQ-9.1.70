package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class TroopHonorRichProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public TroopHonorRichProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void a(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        PBUInt32Field pBUInt32Field = oidb_0x5eb_udcuindata.uint32_troop_honor_rich_flag;
        if (pBUInt32Field.has()) {
            ITroopHonorService iTroopHonorService = (ITroopHonorService) this.appRuntime.getRuntimeService(ITroopHonorService.class, "");
            iTroopHonorService.saveHostHonorListRichTag((byte) pBUInt32Field.get());
            iTroopHonorService.updateHostHonorList(false);
            if (QLog.isColorLevel()) {
                QLog.d("TroopHonor", 2, "honor_rich_0x5eb," + pBUInt32Field.get());
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopHonorRichProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x5eb_reqbody)).booleanValue();
        }
        oidb_0x5eb_reqbody.uint32_troop_honor_rich_flag.set(1);
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
        } else {
            a(oidb_0x5eb_udcuindata);
        }
    }
}
