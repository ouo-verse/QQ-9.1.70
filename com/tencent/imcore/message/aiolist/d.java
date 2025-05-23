package com.tencent.imcore.message.aiolist;

import com.tencent.mobileqq.app.message.k;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d implements f {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.aiolist.f
    public Object[] a(AppRuntime appRuntime, String str, int i3, boolean z16, List<ChatMessage> list, List<ChatMessage> list2, List<ChatMessage> list3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, appRuntime, str, Integer.valueOf(i3), Boolean.valueOf(z16), list, list2, list3, messageRecord);
        }
        if (messageRecord instanceof ChatMessage) {
            list.add((ChatMessage) messageRecord);
            return new Object[]{messageRecord, Boolean.FALSE};
        }
        QLog.e("MsgInvalidTypeErr", 1, "err msg" + messageRecord.getBaseInfoString());
        if ("2747277822".equals(str)) {
            return new Object[]{messageRecord, Boolean.TRUE};
        }
        k.c(messageRecord);
        return new Object[]{messageRecord, Boolean.TRUE};
    }
}
