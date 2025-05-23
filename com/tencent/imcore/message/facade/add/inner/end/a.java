package com.tencent.imcore.message.facade.add.inner.end;

import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
class a implements com.tencent.imcore.message.facade.a<QQMessageFacade, QQAppInterface> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.facade.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(QQMessageFacade qQMessageFacade, QQAppInterface qQAppInterface, List<MessageRecord> list, BaseMessageManager.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQMessageFacade, qQAppInterface, list, aVar, Boolean.valueOf(z16));
            return;
        }
        Iterator<String> it = aVar.f116299d.keySet().iterator();
        while (it.hasNext()) {
            MessageRecord messageRecord = aVar.f116299d.get(it.next());
            if (messageRecord != null) {
                Message lastMessage = qQMessageFacade.getLastMessage(messageRecord.frienduin, messageRecord.istroop);
                qQMessageFacade.w(lastMessage);
                if (messageRecord instanceof MessageForPic) {
                    String msgSummaryForAnimationPic = ((IPicHelper) QRoute.api(IPicHelper.class)).getMsgSummaryForAnimationPic((MessageForPic) messageRecord);
                    if (!TextUtils.isEmpty(msgSummaryForAnimationPic)) {
                        lastMessage.f203106msg = msgSummaryForAnimationPic;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DecodeMsgProcessor", 2, "addMessage decodeMsg uin = " + lastMessage.frienduin + " , type = " + lastMessage.istroop + " ,msgType:" + lastMessage.msgtype + ", con = " + lastMessage.getLogColorContent());
                }
            }
        }
    }
}
