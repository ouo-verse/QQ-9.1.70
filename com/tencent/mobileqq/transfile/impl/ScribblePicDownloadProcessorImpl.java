package com.tencent.mobileqq.transfile.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.IScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.ScribblePicDownloadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

/* loaded from: classes19.dex */
public class ScribblePicDownloadProcessorImpl implements IScribblePicDownloadProcessor {
    static IPatchRedirector $redirector_;

    public ScribblePicDownloadProcessorImpl() {
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
        return new ScribblePicDownloadProcessor(baseTransFileController, transferRequest);
    }

    @Override // com.tencent.mobileqq.transfile.api.ITransProcessorCreater
    public Class<?> getProcessorClazz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ScribblePicDownloadProcessor.class;
    }
}
