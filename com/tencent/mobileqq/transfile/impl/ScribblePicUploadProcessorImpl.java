package com.tencent.mobileqq.transfile.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.IScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.ScribblePicUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

/* loaded from: classes19.dex */
public class ScribblePicUploadProcessorImpl implements IScribblePicUploadProcessor {
    static IPatchRedirector $redirector_;

    public ScribblePicUploadProcessorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.ITransProcessorCreater
    public BaseTransProcessor createProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
        return new ScribblePicUploadProcessor(baseTransFileController, transferRequest);
    }

    @Override // com.tencent.mobileqq.transfile.api.ITransProcessorCreater
    public Class<?> getProcessorClazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ScribblePicUploadProcessor.class;
    }
}
