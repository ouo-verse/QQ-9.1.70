package com.tencent.mobileqq.replymsg;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.multimsg.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f281241a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static d c() {
        if (f281241a == null) {
            synchronized (d.class) {
                if (f281241a == null) {
                    f281241a = new d();
                }
            }
        }
        return f281241a;
    }

    public void a(QQAppInterface qQAppInterface, MessageForMixedMsg messageForMixedMsg, SessionInfo sessionInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, qQAppInterface, messageForMixedMsg, sessionInfo, Integer.valueOf(i3));
            return;
        }
        if (messageForMixedMsg == null) {
            return;
        }
        if (messageForMixedMsg.getReplyMessage(qQAppInterface) != null) {
            new ArrayList(1).add(messageForMixedMsg);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(messageForMixedMsg);
            h hVar = new h();
            hVar.f251624h = 0;
            hVar.f251617a = sessionInfo;
            hVar.f251618b = arrayList;
            hVar.f251619c = null;
            hVar.f251625i = 9;
            hVar.f251621e = new MessageForStructing();
            new b(qQAppInterface).u(hVar);
            return;
        }
        ((MixedMsgManager) qQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).l(sessionInfo, messageForMixedMsg, false, i3);
    }

    public void b(QQAppInterface qQAppInterface, SessionInfo sessionInfo, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, sessionInfo, intent);
            return;
        }
        long longExtra = intent.getLongExtra(AppConstants.Key.FORWARD_UNISEQ, 0L);
        if (longExtra == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ReplyMsgSender", 2, "sendReplyMessage uniseq=0");
                return;
            }
            return;
        }
        ChatMessage a16 = ((a) qQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(longExtra);
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ReplyMsgSender", 2, "sendReplyMessage chatMessage is null");
                return;
            }
            return;
        }
        d(qQAppInterface, a16, sessionInfo, 0, intent.getIntExtra("KEY_MSG_FORWARD_ID", 0), true);
    }

    public void d(QQAppInterface qQAppInterface, ChatMessage chatMessage, p pVar, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, chatMessage, pVar, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        new ArrayList(1).add(chatMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(chatMessage);
        h hVar = new h();
        hVar.f251624h = i3;
        hVar.f251617a = (SessionInfo) pVar;
        hVar.f251618b = arrayList;
        hVar.f251619c = null;
        hVar.f251633q = i16;
        hVar.f251625i = 8;
        hVar.f251621e = new MessageForStructing();
        hVar.f251634r = z16;
        new c(qQAppInterface).u(hVar);
    }
}
