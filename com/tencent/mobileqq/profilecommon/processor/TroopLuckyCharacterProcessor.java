package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class TroopLuckyCharacterProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public TroopLuckyCharacterProcessor(AppRuntime appRuntime) {
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
        return "TroopLuckyCharacterProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (i3 == 42495) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oidb_0x5eb_reqbody)).booleanValue();
        }
        oidb_0x5eb_reqbody.uint32_troop_lucky_character_switch.set(1);
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle bundle, boolean z16, oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bundle, Boolean.valueOf(z16), oidb_0x5eb_udcuindata);
            return;
        }
        boolean has = oidb_0x5eb_udcuindata.uint32_troop_lucky_character_switch.has();
        if (has && (this.appRuntime instanceof QQAppInterface)) {
            if (oidb_0x5eb_udcuindata.uint32_troop_lucky_character_switch.get() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            com.tencent.mobileqq.troop.luckycharacter.a.c((QQAppInterface) this.appRuntime, z17);
        } else {
            z17 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopLuckyCharacterProcessor", 2, String.format("handleGetProfileInfoForLogin hasLuckyCharacterSwitch=%s luckyCharacterSwitch=%s", Boolean.valueOf(has), Boolean.valueOf(z17)));
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) byteStringMicro);
            return;
        }
        if (i3 == 42495) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopLuckyCharacterProcessor", 2, "get apollo head update push.");
            }
            if (ByteBuffer.wrap(byteStringMicro.toByteArray()).asShortBuffer().get() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "c2c online push, field id: 42495, changed troopLuckyCharacterSwitch: ", Boolean.valueOf(z16));
            }
            AppRuntime appRuntime = this.appRuntime;
            if (appRuntime instanceof QQAppInterface) {
                com.tencent.mobileqq.troop.luckycharacter.a.c((QQAppInterface) appRuntime, z16);
            }
        }
    }
}
