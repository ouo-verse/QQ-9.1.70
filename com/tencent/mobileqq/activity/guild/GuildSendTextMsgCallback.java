package com.tencent.mobileqq.activity.guild;

import com.tencent.biz.pubaccount.util.m;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.base.l;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import st1.h;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GuildSendTextMsgCallback extends l {
    @Override // com.tencent.mobileqq.guild.message.base.l
    public void a(final AppInterface appInterface, final MessageRecord messageRecord, h.a aVar) {
        if (messageRecord instanceof MessageForText) {
            MessageForText messageForText = (MessageForText) messageRecord;
            ArrayList<AtTroopMemberInfo> arrayList = aVar.f434702d;
            if (arrayList != null) {
                messageForText.atInfoList = arrayList;
            }
            ChatActivityFacade.d dVar = new ChatActivityFacade.d();
            dVar.f175143g = aVar.f434704f;
            dVar.f175155s = aVar.f434705g;
            messageForText.setSendMsgParams(dVar);
        }
        if (aVar.f434703e) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.guild.GuildSendTextMsgCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    AppInterface appInterface2 = appInterface;
                    if (appInterface2 instanceof QQAppInterface) {
                        ((QQAppInterface) appInterface2).getMessageFacade().h1(messageRecord.frienduin, 10014);
                    }
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.l
    public void b(MessageRecord messageRecord) {
        boolean z16;
        AbsStructMsg absStructMsg;
        if ((messageRecord instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) messageRecord).structingMsg) != null) {
            z16 = m.f(absStructMsg);
        } else {
            z16 = false;
        }
        if (MessageForRichText.class.isInstance(messageRecord) && !z16) {
            ((MessageForRichText) messageRecord).richText = null;
        }
    }

    @Override // com.tencent.mobileqq.guild.message.base.l
    public void c(AppInterface appInterface, long j3) {
        if (appInterface instanceof QQAppInterface) {
            com.tencent.mobileqq.activity.aio.forward.b.d().k((QQAppInterface) appInterface, j3);
        }
    }
}
