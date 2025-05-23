package com.tencent.imcore.message.facade.send.sender;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import st1.h;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b implements com.tencent.imcore.message.facade.f<QQAppInterface> {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Contact d(MessageRecord messageRecord) {
        return new Contact(4, messageRecord.frienduin, String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(messageRecord)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(int i3, String str) {
        QLog.i("GuildMsgSender", 4, "MessageForMarketFace result=" + i3 + " errMsg=" + str);
    }

    private ArrayList<MsgElement> g(MessageForMarketFace messageForMarketFace) {
        return d.f116641a.b(messageForMarketFace);
    }

    @Override // com.tencent.imcore.message.facade.f
    public boolean a(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        if (messageRecord.istroop == 10014) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.facade.f
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void b(QQAppInterface qQAppInterface, MessageRecord messageRecord, BusinessObserver businessObserver, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, messageRecord, businessObserver, Boolean.valueOf(z16));
        } else if (messageRecord instanceof MessageForMarketFace) {
            QLog.i("GuildMsgSender", 4, "send MessageForMarketFace==NT");
            ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(d(messageRecord), g((MessageForMarketFace) messageRecord), new IOperateCallback() { // from class: com.tencent.imcore.message.facade.send.sender.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    b.e(i3, str);
                }
            });
        } else {
            ((h) qQAppInterface.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).O1(messageRecord, businessObserver, z16);
        }
    }
}
