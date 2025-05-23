package com.tencent.mobileqq.openpay.processor;

import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* loaded from: classes16.dex */
public final class ApiProcessorCenter {
    static IPatchRedirector $redirector_;
    private final HashMap<String, IApiProcessor> mApiName2ProcessorMap;

    public ApiProcessorCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mApiName2ProcessorMap = new HashMap<String, IApiProcessor>() { // from class: com.tencent.mobileqq.openpay.processor.ApiProcessorCenter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ApiProcessorCenter.this);
                    } else {
                        put(OpenConstants.ApiName.PAY, new PayApiProcessor());
                        put(OpenConstants.ApiName.PAY_V2, new PayApiV2Processor());
                    }
                }
            };
        }
    }

    public IApiProcessor get(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IApiProcessor) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return this.mApiName2ProcessorMap.get(str);
    }
}
