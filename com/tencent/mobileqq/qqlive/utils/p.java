package com.tencent.mobileqq.qqlive.utils;

import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePremier;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends V2TXLivePremier.V2TXLivePremierObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.live2.V2TXLivePremier.V2TXLivePremierObserver
        public void onLog(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TRTC.QQLive", 2, " " + i3 + "||" + str);
                return;
            }
            if (i3 >= 2) {
                QLog.d("TRTC.QQLive", 2, " " + i3 + "||" + str);
            }
        }
    }

    public static void a() {
        V2TXLiveDef.V2TXLiveLogConfig v2TXLiveLogConfig = new V2TXLiveDef.V2TXLiveLogConfig();
        v2TXLiveLogConfig.enableObserver = true;
        if (QLog.isColorLevel()) {
            v2TXLiveLogConfig.logLevel = 0;
        } else {
            v2TXLiveLogConfig.logLevel = 2;
        }
        v2TXLiveLogConfig.enableConsole = false;
        v2TXLiveLogConfig.enableLogFile = false;
        V2TXLivePremier.setLogConfig(v2TXLiveLogConfig);
        V2TXLivePremier.setObserver(new a());
    }
}
