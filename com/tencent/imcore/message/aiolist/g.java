package com.tencent.imcore.message.aiolist;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g implements f {
    static IPatchRedirector $redirector_;

    public g() {
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
        if (!z16) {
            if (i3 == 0 && (messageRecord instanceof MessageForPoke)) {
                MessageForPoke messageForPoke = (MessageForPoke) messageRecord;
                if (!messageForPoke.isSend()) {
                    list2.add(messageForPoke);
                }
                if (messageForPoke.interactType == 126 && !messageForPoke.isPlayed && !messageForPoke.isSend()) {
                    return new Object[]{messageRecord, Boolean.TRUE};
                }
                if (messageForPoke.isread && !messageForPoke.isPlayed && !messageForPoke.isSend()) {
                    messageForPoke.setPlayed((QQAppInterface) appRuntime);
                }
            }
            if (i3 == 0 && (messageRecord instanceof MessageForPokeEmo)) {
                list3.add((MessageForPokeEmo) messageRecord);
            }
        }
        return new Object[]{messageRecord, Boolean.FALSE};
    }
}
