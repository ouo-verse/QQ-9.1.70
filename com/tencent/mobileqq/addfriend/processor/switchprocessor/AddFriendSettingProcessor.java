package com.tencent.mobileqq.addfriend.processor.switchprocessor;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.profilecommon.utils.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class AddFriendSettingProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public AddFriendSettingProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    public static int b(AppRuntime appRuntime) {
        int i3 = MobileQQ.sMobileQQ.getSharedPreferences(appRuntime.getCurrentAccountUin(), 0).getInt("e_add_friend_setting", 101);
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendSettingProcessor", 2, "getSelfAddFriendSettingValue  settingValue:" + i3);
        }
        return i3;
    }

    public static void c(AppRuntime appRuntime) {
        try {
            AddFriendSettingProcessor addFriendSettingProcessor = (AddFriendSettingProcessor) a.a(AddFriendSettingProcessor.class, appRuntime);
            if (addFriendSettingProcessor != null) {
                addFriendSettingProcessor.a();
            }
        } catch (Exception e16) {
            QLog.e("AddFriendSettingProcessor", 1, "getSelfAddFriendSetting error " + e16.getMessage());
        }
    }

    public static void d(int i3, AppRuntime appRuntime) {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(appRuntime.getCurrentAccountUin(), 0);
        int i16 = sharedPreferences.getInt("e_add_friend_setting", 101);
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendSettingProcessor", 2, "handleGetSelfAddFriendSetting settingValue=" + i3 + "  oldValue:" + i16);
        }
        if (i16 != i3) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("e_add_friend_setting", i3);
            edit.commit();
        }
    }

    void a() {
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendSettingProcessor", 2, "getSelfAddFriendSetting");
        }
        try {
            oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
            oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(this.appRuntime.getCurrentAccountUin())));
            oidb_0x5eb_reqbody.uint32_req_allow.set(1);
            Bundle bundle = new Bundle();
            bundle.putBoolean("uint32_req_allow", true);
            bundle.putString("reqUin", this.appRuntime.getCurrentAccountUin());
            getProfileDetail(oidb_0x5eb_reqbody, bundle);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendSettingProcessor", 2, "getSelfAddFriendSetting ex", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "AddFriendSettingProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x5eb_reqbody)).booleanValue();
        }
        oidb_0x5eb_reqbody.uint32_req_allow.set(1);
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendSettingProcessor", 2, "onGetProfileDetailResponse success: " + z16);
        }
        if (!bundle.getBoolean("uint32_req_allow", false)) {
            return;
        }
        if (z16) {
            int i3 = oidb_0x5eb_udcuindata.uint32_allow.get();
            this.handler.notifyUI(3, z16, Integer.valueOf(i3));
            if (i3 != 101) {
                d(i3, this.appRuntime);
            }
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendSettingProcessor", 2, "onGetProfileDetailResponse settingValue: " + i3);
                return;
            }
            return;
        }
        this.handler.notifyUI(3, false, Integer.valueOf(b(this.appRuntime)));
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) byteStringMicro);
            return;
        }
        if (i3 == 20014) {
            int size = byteStringMicro.size();
            if (byteStringMicro.size() > 0) {
                b16 = byteStringMicro.byteAt(0);
                if (b16 != 101) {
                    d(b16, this.appRuntime);
                }
            } else {
                b16 = -1;
            }
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendSettingProcessor", 2, "20014 push a ProfileInfo size = " + size + "  settingValue = " + ((int) b16));
            }
        }
    }
}
