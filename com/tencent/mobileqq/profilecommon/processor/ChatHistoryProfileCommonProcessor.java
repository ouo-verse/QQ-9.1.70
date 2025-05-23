package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class ChatHistoryProfileCommonProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f260937a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74191);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f260937a = "SYNC_C2C_MESSAGE_SWITCH";
        }
    }

    public ChatHistoryProfileCommonProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private String a(oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        if (oidb_0x5eb_udcuindata.uint64_uin.has()) {
            return String.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get());
        }
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            return "";
        }
        return appRuntime.getCurrentUin();
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ChatHistoryProfileCommonProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x5eb_reqbody)).booleanValue();
        }
        if (oidb_0x5eb_reqbody == null) {
            return true;
        }
        oidb_0x5eb_reqbody.uint32_sync_C2C_message_switch.set(1);
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
            return;
        }
        if (z16 && oidb_0x5eb_udcuindata != null) {
            String a16 = a(oidb_0x5eb_udcuindata);
            if (TextUtils.isEmpty(a16)) {
                QLog.i("ChatHistoryProfileCommonProcessor", 1, "[onGetProfileDetailResponse] uin is empty, uin=\"" + a16 + "\"");
                return;
            }
            if (!oidb_0x5eb_udcuindata.uint32_sync_C2C_message_switch.has()) {
                QLog.i("ChatHistoryProfileCommonProcessor", 1, "[onGetProfileDetailResponse] switch not exist, uin=" + a16);
                return;
            }
            int i3 = oidb_0x5eb_udcuindata.uint32_sync_C2C_message_switch.get();
            QLog.i("ChatHistorySettingFragment", 1, "[onGetProfileDetailResponse] switch exist, value=" + i3);
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt(f260937a + "_" + a16, i3);
            return;
        }
        QLog.i("ChatHistoryProfileCommonProcessor", 1, "onGetProfileDetailResponse udcUinData == null");
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onSetProfileDetailResponse(Bundle bundle, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bundle, Boolean.valueOf(z16));
            return;
        }
        QLog.i("ChatHistoryProfileCommonProcessor", 1, "onSetProfileDetailResponse success=" + z16 + " request: " + bundle);
        if (!z16 || bundle == null || (i3 = bundle.getInt(f260937a, -1)) == -1) {
            return;
        }
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt(f260937a + "_" + this.appRuntime.getCurrentUin(), i3);
    }
}
