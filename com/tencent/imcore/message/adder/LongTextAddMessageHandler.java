package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LongTextAddMessageHandler implements h {
    static IPatchRedirector $redirector_;

    public LongTextAddMessageHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (!messageRecord.isSendFromLocal()) {
            if (messageRecord.msgtype == -1051 || (messageRecord.isLongMsg() && messageRecord.longMsgCount == messageRecord.longMsgIndex + 1)) {
                com.tencent.mobileqq.multimsg.f fVar = (com.tencent.mobileqq.multimsg.f) qQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER);
                if (qQAppInterface.mAutomator.getInActionLoginB() == 1) {
                    fVar.e(qQAppInterface, messageRecord);
                } else {
                    ThreadManager.getSubThreadHandler().postDelayed(new Runnable(fVar, qQAppInterface, messageRecord) { // from class: com.tencent.imcore.message.adder.LongTextAddMessageHandler.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.multimsg.f f116470d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ QQAppInterface f116471e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ MessageRecord f116472f;

                        {
                            this.f116470d = fVar;
                            this.f116471e = qQAppInterface;
                            this.f116472f = messageRecord;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, LongTextAddMessageHandler.this, fVar, qQAppInterface, messageRecord);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                this.f116470d.e(this.f116471e, this.f116472f);
                            }
                        }
                    }, 10000L);
                }
            }
        }
    }

    @Override // com.tencent.imcore.message.adder.h
    public void a(AppRuntime appRuntime, IMessageManager iMessageManager, MessageRecord messageRecord, boolean z16, boolean z17, boolean z18, Map<String, MessageRecord> map, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, iMessageManager, messageRecord, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), map, str, Integer.valueOf(i3));
            return;
        }
        try {
            b((QQAppInterface) appRuntime, messageRecord);
        } catch (Exception e16) {
            QLog.d("Q.msg.BaseMessageManager", 1, "longmsg receive report error!", e16);
        }
    }
}
