package com.tencent.mobileqq.profilecommon.processor;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.troop.api.handler.d;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class TroopHonorSwitchProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public TroopHonorSwitchProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void a(boolean z16) {
        FriendsManager friendsManager = (FriendsManager) this.appRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card r16 = friendsManager.r(this.appRuntime.getCurrentUin());
        if (r16 != null && r16.troopHonorSwitch != z16) {
            r16.troopHonorSwitch = z16;
            friendsManager.p0(r16);
            AppRuntime appRuntime = this.appRuntime;
            if (appRuntime instanceof QQAppInterface) {
                ((CardHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(109, true, Boolean.valueOf(r16.troopHonorSwitch));
                ((d) ((QQAppInterface) this.appRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a(e.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
                ((ITroopHonorService) this.appRuntime.getRuntimeService(ITroopHonorService.class, "")).notifyTroopHonorGlobalUpdate();
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopHonorSwitchProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (i3 == 42360) {
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
        oidb_0x5eb_reqbody.uint32_troophonor_switch.set(1);
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
        if (z16) {
            boolean has = oidb_0x5eb_udcuindata.uint32_troophonor_switch.has();
            if (has) {
                if (oidb_0x5eb_udcuindata.uint32_troophonor_switch.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                a(z17);
            } else {
                z17 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopHonorSwitchProcessor", 2, String.format("onGetProfileDetailResponse hasHonorSwitch=%s honorSwitch=%s", Boolean.valueOf(has), Boolean.valueOf(z17)));
                return;
            }
            return;
        }
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime instanceof QQAppInterface) {
            ((CardHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(109, false, null);
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
        if (i3 == 42360) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopHonorSwitchProcessor", 2, "get apollo head update push.");
            }
            if (ByteBuffer.wrap(byteStringMicro.toByteArray()).asShortBuffer().get() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "c2c online push, field id: 42495, changed troopLuckyCharacterSwitch: ", Boolean.valueOf(z16));
            }
            a(z16);
        }
    }
}
