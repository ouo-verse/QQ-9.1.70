package com.tencent.mobileqq.processor;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class EmotionProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public EmotionProcessor(AppRuntime appRuntime) {
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
        return "EmotionProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x5eb_reqbody)).booleanValue();
        }
        if (oidb_0x5eb_reqbody == null) {
            QLog.i("EmotionProcessor", 1, "reqBody == null");
            return true;
        }
        oidb_0x5eb_reqbody.unit32_hide_cm_show_emoticon_flag.set(1);
        oidb_0x5eb_reqbody.unit32_hide_camera_emoticon_flag.set(1);
        QLog.i("EmotionProcessor", 1, "onGetProfileDetailRequestForLogin");
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
            return;
        }
        if (oidb_0x5eb_udcuindata == null) {
            QLog.i("EmotionProcessor", 1, "onGetProfileDetailResponse udcUinData == null");
            return;
        }
        PBUInt32Field pBUInt32Field = oidb_0x5eb_udcuindata.unit32_hide_cm_show_emoticon_flag;
        PBUInt32Field pBUInt32Field2 = oidb_0x5eb_udcuindata.unit32_hide_camera_emoticon_flag;
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            QLog.i("EmotionProcessor", 1, "onGetProfileDetailResponse appRuntime == null");
            return;
        }
        Context applicationContext = appRuntime.getApplicationContext();
        String currentAccountUin = this.appRuntime.getCurrentAccountUin();
        if (pBUInt32Field.has()) {
            if (pBUInt32Field.get() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            EmoticonUtils.setCmshowEmoticonSwitch(applicationContext, currentAccountUin, z17);
        }
        if (pBUInt32Field2.has()) {
            if (pBUInt32Field2.get() == 0) {
                z18 = true;
            }
            EmoticonUtils.setCameraEmoticonSwitch(applicationContext, currentAccountUin, z18);
        }
        QLog.i("EmotionProcessor", 1, "onGetProfileDetailResponse hideCmShow has=" + pBUInt32Field.has() + ",value=" + pBUInt32Field.get() + ",hideCamera has=" + pBUInt32Field2.has() + ",value=" + pBUInt32Field2.get());
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onSetProfileDetailResponse(Bundle bundle, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bundle, Boolean.valueOf(z16));
            return;
        }
        QLog.i("EmotionProcessor", 1, "onSetProfileDetailResponse success=" + z16);
    }
}
