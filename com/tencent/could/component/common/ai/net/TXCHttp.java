package com.tencent.could.component.common.ai.net;

import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TXCHttp {
    static IPatchRedirector $redirector_;

    public TXCHttp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void sendRequest(NetWorkParam netWorkParam, IJsonDataListener iJsonDataListener) {
        if (netWorkParam == null) {
            if (iJsonDataListener != null) {
                iJsonDataListener.onFailed("input param is null!");
            }
        } else {
            ThreadManager.getInstance().addTask(new HttpTask(new JsonCallBackListener(iJsonDataListener), netWorkParam));
        }
    }

    public static void stopCurrentRequest() {
        ThreadManager.getInstance().stopCurrentRequest();
    }
}
