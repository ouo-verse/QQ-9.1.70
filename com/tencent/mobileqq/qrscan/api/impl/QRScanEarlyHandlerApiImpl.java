package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.earlydownload.handler.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.api.IQRScanEarlyHandlerApi;
import com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler;
import com.tencent.mobileqq.qrscan.earlydown.e;
import com.tencent.mobileqq.qrscan.earlydown.f;
import com.tencent.mobileqq.qrscan.earlydown.h;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRScanEarlyHandlerApiImpl implements IQRScanEarlyHandlerApi {
    static IPatchRedirector $redirector_;

    public QRScanEarlyHandlerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanEarlyHandlerApi
    public b getHandler(int i3, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) appRuntime);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return new ChirpSoHandler(appRuntime);
                    }
                    return new h(appRuntime);
                }
                return new e(appRuntime);
            }
            return new f(appRuntime);
        }
        return new com.tencent.mobileqq.qrscan.earlydown.b(appRuntime);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanEarlyHandlerApi
    public String getResName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return "qq.android.system.chirp";
                    }
                    return "qq.android.qbarnative.model_v8.6.0";
                }
                return "qq.android.minidetect.model_v8.9.85";
            }
            return "qq.android.minidetect.so_v8.9.85";
        }
        return "qq.android.minidecode.so_v8.8.5";
    }
}
