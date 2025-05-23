package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileassistant.top.FileAssistTopHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;

@KeepClassConstructor
/* loaded from: classes16.dex */
public class FileAssistProcessor extends AbsProfileCommonProcessor {
    static IPatchRedirector $redirector_;

    public FileAssistProcessor(AppRuntime appRuntime) {
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
        return "FileAssistProcessor";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean interceptProfileModifyPush(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        if (i3 == 42489) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int i3, ByteStringMicro byteStringMicro) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) byteStringMicro);
            return;
        }
        if (i3 != 42489) {
            return;
        }
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime instanceof QQAppInterface) {
            FileAssistTopHandler fileAssistTopHandler = (FileAssistTopHandler) ((QQAppInterface) appRuntime).getBusinessHandler(BusinessHandlerFactory.FILE_ASSIST_TOP);
            if (ByteBuffer.wrap(byteStringMicro.toByteArray()).asShortBuffer().get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            fileAssistTopHandler.F2(z16);
        }
    }
}
