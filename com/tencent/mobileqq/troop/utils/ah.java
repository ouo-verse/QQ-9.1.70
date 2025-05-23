package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ah {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static ah f302008c;

    /* renamed from: a, reason: collision with root package name */
    public QQAppInterface f302009a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.mobileqq.app.c f302010b;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.app.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ah.this);
            }
        }

        @Override // com.tencent.mobileqq.app.c
        protected void g(Object obj) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, obj);
                return;
            }
            if (ah.this.f302009a == null) {
                return;
            }
            com.tencent.mobileqq.troop.data.t tVar = (com.tencent.mobileqq.troop.data.t) obj;
            if (tVar.f294972f == 12) {
                for (ChatMessage chatMessage : ah.this.f302009a.getMessageFacade().l1(String.valueOf(tVar.f294971e), 1)) {
                    if (chatMessage.msgtype == -2017 && ((i3 = chatMessage.extraflag) == 32772 || i3 == 32768)) {
                        if (chatMessage.isSendFromLocal()) {
                            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) chatMessage;
                            String str = messageForTroopFile.uuid;
                            if (str != null && str.equals(tVar.f294967a.toString())) {
                                ah.this.f302009a.getMessageFacade().T1(messageForTroopFile.frienduin, messageForTroopFile.istroop, messageForTroopFile.uniseq);
                            } else if (!TextUtils.isEmpty(messageForTroopFile.url) && !TextUtils.isEmpty(tVar.f294985s) && messageForTroopFile.url.equals(tVar.f294985s)) {
                                ah.this.f302009a.getMessageFacade().T1(messageForTroopFile.frienduin, messageForTroopFile.istroop, messageForTroopFile.uniseq);
                            }
                        }
                    }
                }
            }
        }
    }

    public ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f302010b = new a();
        }
    }

    public static void a(QQAppInterface qQAppInterface) {
        ah ahVar = f302008c;
        if (ahVar != null) {
            qQAppInterface.removeObserver(ahVar.f302010b);
            f302008c.f302009a = null;
            f302008c = null;
        }
    }

    private static void b(QQAppInterface qQAppInterface) {
        ah ahVar = new ah();
        f302008c = ahVar;
        ahVar.f302009a = qQAppInterface;
        qQAppInterface.addObserver(ahVar.f302010b);
    }

    public static synchronized ah c(QQAppInterface qQAppInterface) {
        ah ahVar;
        synchronized (ah.class) {
            ah ahVar2 = f302008c;
            if (ahVar2 == null) {
                b(qQAppInterface);
            } else {
                QQAppInterface qQAppInterface2 = ahVar2.f302009a;
                if (qQAppInterface2 != qQAppInterface) {
                    if (qQAppInterface2 != null) {
                        qQAppInterface2.removeObserver(ahVar2.f302010b);
                        f302008c.f302009a = null;
                    }
                    f302008c = null;
                    b(qQAppInterface);
                }
            }
            ahVar = f302008c;
        }
        return ahVar;
    }
}
