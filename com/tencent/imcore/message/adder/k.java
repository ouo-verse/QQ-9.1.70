package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class k implements h {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.adder.h
    public void a(AppRuntime appRuntime, IMessageManager iMessageManager, MessageRecord messageRecord, boolean z16, boolean z17, boolean z18, Map<String, MessageRecord> map, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, iMessageManager, messageRecord, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), map, str, Integer.valueOf(i3));
        } else if (messageRecord instanceof MessageForUniteGrayTip) {
            ((MessageForUniteGrayTip) messageRecord).getClass();
        }
    }
}
