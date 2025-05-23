package com.tencent.imcore.message.adder;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LongMixAddMessageHandler implements h {
    static IPatchRedirector $redirector_;

    public LongMixAddMessageHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (!messageRecord.isSendFromLocal()) {
            int i3 = messageRecord.msgtype;
            if (i3 == -1036 || i3 == -1035) {
                MixedMsgManager mixedMsgManager = (MixedMsgManager) qQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER);
                if (qQAppInterface.mAutomator.getInActionLoginB() == 1) {
                    mixedMsgManager.v(messageRecord);
                } else {
                    ThreadManager.getSubThreadHandler().postDelayed(new Runnable(mixedMsgManager, messageRecord) { // from class: com.tencent.imcore.message.adder.LongMixAddMessageHandler.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ MixedMsgManager f116468d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ MessageRecord f116469e;

                        {
                            this.f116468d = mixedMsgManager;
                            this.f116469e = messageRecord;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, LongMixAddMessageHandler.this, mixedMsgManager, messageRecord);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                this.f116468d.v(this.f116469e);
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
            QLog.d("Q.msg.BaseMessageManager", 1, "mixexmsg receive report error!", e16);
        }
    }
}
