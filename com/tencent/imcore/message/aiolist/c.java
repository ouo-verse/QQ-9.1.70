package com.tencent.imcore.message.aiolist;

import com.tencent.mobileqq.ark.m;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements f {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.aiolist.f
    public Object[] a(AppRuntime appRuntime, String str, int i3, boolean z16, List<ChatMessage> list, List<ChatMessage> list2, List<ChatMessage> list3, MessageRecord messageRecord) {
        MessageForArkApp b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, appRuntime, str, Integer.valueOf(i3), Boolean.valueOf(z16), list, list2, list3, messageRecord);
        }
        if ((messageRecord instanceof MessageForArkApp) && (b16 = m.d().b()) != null && messageRecord.uniseq == b16.uniseq) {
            com.tencent.mobileqq.activity.aio.item.b c16 = m.d().c();
            if (c16 != null) {
                b16.arkContainer = c16;
                messageRecord = b16;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArkTipsManager", 2, "refill ark msg: " + b16.uniseq + " ark c=" + b16.arkContainer);
            }
        }
        return new Object[]{messageRecord, Boolean.FALSE};
    }
}
