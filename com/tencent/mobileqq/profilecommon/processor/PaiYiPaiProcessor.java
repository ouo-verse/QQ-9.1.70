package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class PaiYiPaiProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public PaiYiPaiProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private void a(ByteStringMicro byteStringMicro, QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiProcessor", 2, "handlePaiYiPaiAction() called with: bytesValue = [" + byteStringMicro + "]");
        }
        ((z51.a) qQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).b(ByteBuffer.wrap(byteStringMicro.toByteArray()).asShortBuffer().get());
    }

    private void b(ByteStringMicro byteStringMicro, QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiProcessor", 2, "handlePaiYiPaiEffect() called with: bytesValue = [" + byteStringMicro + "]");
        }
        ((z51.a) qQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).c(ByteBuffer.wrap(byteStringMicro.toByteArray()).asShortBuffer().get());
    }

    private void c(ByteStringMicro byteStringMicro, QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("PaiYiPaiProcessor", 2, "handlePaiYiPaiSwitch() called with: bytesValue = [" + byteStringMicro + "]");
        }
        ((z51.a) qQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).d(ByteBuffer.wrap(byteStringMicro.toByteArray()).asShortBuffer().get());
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "PaiYiPaiProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        if (i3 != 42433 && i3 != 42434 && i3 != 27390) {
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
        if (i3 != 27390) {
            switch (i3) {
                case ProfileContants.FIELD_PAI_YI_PAI_SWITCH /* 42433 */:
                    AppRuntime appRuntime = this.appRuntime;
                    if (appRuntime instanceof QQAppInterface) {
                        c(byteStringMicro, (QQAppInterface) appRuntime);
                        return;
                    }
                    return;
                case ProfileContants.FIELD_PAI_YI_PAI_ACTION /* 42434 */:
                    AppRuntime appRuntime2 = this.appRuntime;
                    if (appRuntime2 instanceof QQAppInterface) {
                        a(byteStringMicro, (QQAppInterface) appRuntime2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        AppRuntime appRuntime3 = this.appRuntime;
        if (appRuntime3 instanceof QQAppInterface) {
            b(byteStringMicro, (QQAppInterface) appRuntime3);
        }
    }
}
