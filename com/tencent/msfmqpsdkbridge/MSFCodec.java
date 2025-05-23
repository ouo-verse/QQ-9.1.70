package com.tencent.msfmqpsdkbridge;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mqpsdk.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes21.dex */
public class MSFCodec implements a.InterfaceC9207a {
    static IPatchRedirector $redirector_;
    private String mCmd;

    public MSFCodec(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mCmd = str;
        }
    }

    @Override // com.tencent.mqpsdk.a.InterfaceC9207a
    public Object decode(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, obj);
        }
        return ((FromServiceMsg) obj).getWupBuffer();
    }

    @Override // com.tencent.mqpsdk.a.InterfaceC9207a
    public Object encode(Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        if (obj == null || TextUtils.isEmpty(this.mCmd)) {
            return null;
        }
        AppRuntime waitAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
        if (waitAppRuntime != null) {
            str = waitAppRuntime.getAccount();
        } else {
            str = "";
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", str, this.mCmd);
        toServiceMsg.putWupBuffer((byte[]) obj);
        return toServiceMsg;
    }
}
