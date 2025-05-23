package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttUploadProcessor;
import com.tencent.mobileqq.transfile.JSPttDownloadProcessor;
import com.tencent.mobileqq.transfile.JSPttUploadProcessor;
import com.tencent.mobileqq.transfile.PAAudioPttDownloadProcessor;
import com.tencent.mobileqq.transfile.PttSilkSliceUploadProcessor;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class PttTransProcessorHelperImpl implements IPttTransProcessorHelper {
    static IPatchRedirector $redirector_;

    public PttTransProcessorHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public boolean checkIsJsPttClass(IHttpCommunicatorListener iHttpCommunicatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) iHttpCommunicatorListener)).booleanValue();
        }
        if (iHttpCommunicatorListener != null && ((iHttpCommunicatorListener instanceof JSPttUploadProcessor) || (iHttpCommunicatorListener instanceof JSPttDownloadProcessor))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public BaseTransProcessor createPttTransProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseTransProcessor) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
        int i3 = transferRequest.mFileType;
        if (i3 == 327699) {
            return new PttSilkSliceUploadProcessor(baseTransFileController, transferRequest);
        }
        if (i3 == 327696) {
            return new PttSliceUploadProcessor(baseTransFileController, transferRequest);
        }
        int i16 = transferRequest.mUinType;
        if (i16 != 1 && i16 != 3000 && i16 != 1026) {
            if (transferRequest.mIsUp) {
                if (i3 == 2) {
                    return new C2CPttUploadProcessor(baseTransFileController, transferRequest);
                }
                if (i3 == 32) {
                    return new JSPttUploadProcessor(baseTransFileController, transferRequest);
                }
                return null;
            }
            if (i3 == 2) {
                return new C2CPttDownloadProcessor(baseTransFileController, transferRequest);
            }
            if (i3 == 32) {
                return new JSPttDownloadProcessor(baseTransFileController, transferRequest);
            }
            if (i3 == 33) {
                return new PAAudioPttDownloadProcessor(baseTransFileController, transferRequest);
            }
            return null;
        }
        if (transferRequest.mIsUp) {
            if (i3 == 2) {
                return new GroupPttUploadProcessor(baseTransFileController, transferRequest);
            }
            return null;
        }
        if (i3 == 2) {
            return new GroupPttDownloadProcessor(baseTransFileController, transferRequest);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public Class getC2CPttDownloadProcessorClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return C2CPttDownloadProcessor.class;
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public Class getC2CPttUpProcessorClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return C2CPttUploadProcessor.class;
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public Class getGroupPttDownloadProcessorClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return GroupPttDownloadProcessor.class;
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public Class getGroupPttUpProcessorClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Class) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return GroupPttUploadProcessor.class;
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public Class getJSPttDownloadProcessorClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return JSPttDownloadProcessor.class;
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public Class getJSPttUpProcessorClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return JSPttUploadProcessor.class;
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public Class getPAAudioDownloadProcessorClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return PAAudioPttDownloadProcessor.class;
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public String getPAAudioPttPath(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime, (Object) str);
        }
        return PAAudioPttDownloadProcessor.getPttPath(appRuntime, str);
    }

    @Override // com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper
    public Class getSlicePttUpProcessorClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Class) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return PttSliceUploadProcessor.class;
    }
}
