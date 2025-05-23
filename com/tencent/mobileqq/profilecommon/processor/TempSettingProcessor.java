package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class TempSettingProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public TempSettingProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void a(int i3, ByteStringMicro byteStringMicro, QQAppInterface qQAppInterface) {
        short s16;
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d("TempSettingProcessor", 2, "handleTempSettingInBoxSwitch() called with: type = [" + i3 + "], bytesValue = [" + byteStringMicro + "]");
        }
        byte[] byteArray = byteStringMicro.toByteArray();
        boolean z18 = false;
        if (byteArray.length == 1) {
            s16 = byteArray[0];
        } else {
            s16 = ByteBuffer.wrap(byteArray).asShortBuffer().get();
        }
        TempMsgManager tempMsgManager = (TempMsgManager) qQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
        if (i3 == 45079) {
            if (s16 != 1) {
                z18 = true;
            }
            z17 = tempMsgManager.K((short) i3);
            z16 = z18;
        } else {
            boolean F = tempMsgManager.F((short) i3);
            if (s16 == 1) {
                z18 = true;
            }
            z16 = F;
            z17 = z18;
        }
        tempMsgManager.Q((short) i3, false, "", z16, z17);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TempSettingProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        if (i3 != 45079 && i3 != 45075 && i3 != 45076 && i3 != 45077) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) byteStringMicro);
            return;
        }
        switch (i3) {
            case 45075:
            case 45076:
            case 45077:
            case 45079:
            case 45081:
                AppRuntime appRuntime = this.appRuntime;
                if (appRuntime instanceof QQAppInterface) {
                    a(i3, byteStringMicro, (QQAppInterface) appRuntime);
                    return;
                }
                return;
            case 45078:
            case 45080:
            default:
                return;
        }
    }
}
