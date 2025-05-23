package com.tencent.imcore.message.adder;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g implements h {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(BaseMessageManager baseMessageManager, MessageRecord messageRecord, Map<String, MessageRecord> map, String str, int i3) {
        if (baseMessageManager.o0(messageRecord, false, 1)) {
            if (map.containsKey(ao.f(str, i3)) && !messageRecord.isSendFromLocal()) {
                if (baseMessageManager.A(messageRecord) >= baseMessageManager.A(map.get(ao.f(str, i3)))) {
                    map.put(ao.f(str, i3), messageRecord);
                    return;
                }
                return;
            }
            map.put(ao.f(str, i3), messageRecord);
        }
    }

    @Override // com.tencent.imcore.message.adder.h
    public void a(AppRuntime appRuntime, IMessageManager iMessageManager, MessageRecord messageRecord, boolean z16, boolean z17, boolean z18, Map<String, MessageRecord> map, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, iMessageManager, messageRecord, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), map, str, Integer.valueOf(i3));
            return;
        }
        int i16 = messageRecord.istroop;
        if (i16 != 3000 && i16 != 1 && i16 != 0) {
            ((BaseMessageManager) iMessageManager).o0(messageRecord, true, 1);
        } else {
            b((BaseMessageManager) iMessageManager, messageRecord, map, str, i3);
        }
    }
}
