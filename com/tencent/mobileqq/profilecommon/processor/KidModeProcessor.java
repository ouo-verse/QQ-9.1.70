package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class KidModeProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public KidModeProcessor(AppRuntime appRuntime) {
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
        return "KidModeProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (i3 != 42362 && i3 != 42432 && i3 != 42285 && i3 != 42490 && i3 != 42430 && i3 != 42429 && i3 != 42428 && i3 != 42482) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x5eb_reqbody)).booleanValue();
        }
        if (oidb_0x5eb_reqbody != null) {
            oidb_0x5eb_reqbody.uint32_flag_kid_mode_can_filter_url.set(1);
            return true;
        }
        return false;
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
        if (z16 && oidb_0x5eb_udcuindata != null && oidb_0x5eb_udcuindata.uint32_flag_kid_mode_can_filter_url.has()) {
            int i3 = oidb_0x5eb_udcuindata.uint32_flag_kid_mode_can_filter_url.get();
            if (i3 != 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            StudyModeManager.W(80, z17);
            if (i3 != 0) {
                z18 = true;
            }
            StudyModeManager.W(96, z18);
            bundle.putInt("KID_MODE_URL_FILTER", i3);
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) byteStringMicro);
            return;
        }
        switch (i3) {
            case ProfileContants.FILED_SIMPLE_UI_SWITCH /* 42285 */:
            case ProfileContants.FILED_STUDY_MODE_FLAG /* 42362 */:
            case ProfileContants.FILED_KID_MODE_FLAG /* 42432 */:
                if (QLog.isColorLevel()) {
                    QLog.d("KidModeProcessor", 2, "handler push fot theme switch");
                    return;
                }
                return;
            case ProfileContants.FILED_KID_MODE_SEARCH_BY_STRANGER_SWITCH /* 42428 */:
            case ProfileContants.FILED_KID_MODE_INVITE_TO_TROOP_BY_STRANGER_SWITCH /* 42429 */:
            case ProfileContants.FILED_KID_MODE_SEARCH_FRIEND_SWITCH /* 42430 */:
            case ProfileContants.FIELD_KID_MODE_CLOSE_LEDA_PLUGIN /* 42482 */:
            case ProfileContants.FILED_KID_MODE_NEED_VERIFY_PHONE /* 42490 */:
                if (QLog.isColorLevel()) {
                    QLog.d("KidModeProcessor", 2, "handler push fot setting change");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(Short.valueOf((short) i3));
                TempGetProfileDetailProcessor tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(this.appRuntime, TempGetProfileDetailProcessor.class);
                if (tempGetProfileDetailProcessor != null) {
                    tempGetProfileDetailProcessor.getDetailCardInfo(arrayList, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
