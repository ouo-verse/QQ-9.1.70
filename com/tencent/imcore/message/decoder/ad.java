package com.tencent.imcore.message.decoder;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.ac;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ad implements j {
    static IPatchRedirector $redirector_;

    public ad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
            return;
        }
        if (message.msgtype == -2067) {
            MessageForTroopConfess messageForTroopConfess = new MessageForTroopConfess();
            messageForTroopConfess.msgData = message.msgData;
            messageForTroopConfess.doParse();
            message.f203106msg = messageForTroopConfess.f203106msg;
            ac.a a16 = com.tencent.mobileqq.troop.utils.ac.a(message);
            if (a16 != null) {
                message.nickName = a16.f301997d;
            }
            if (TextUtils.isEmpty(message.nickName)) {
                message.nickName = HardCodeUtil.qqStr(R.string.jys);
            }
        }
    }
}
