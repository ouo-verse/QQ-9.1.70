package com.tencent.imcore.message.facade;

import android.os.SystemClock;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f116633a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f116634b;

    /* renamed from: c, reason: collision with root package name */
    private final QQMessageFacade f116635c;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f116636d;

    public h(QQMessageFacade qQMessageFacade, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQMessageFacade, (Object) qQAppInterface);
            return;
        }
        this.f116633a = false;
        this.f116634b = -1;
        this.f116635c = qQMessageFacade;
        this.f116636d = qQAppInterface;
    }

    private void e(String str, int i3) {
        List<MessageRecord> o16 = this.f116636d.getMessageProxy(i3).o(str, i3);
        if (o16 != null && !o16.isEmpty()) {
            for (MessageRecord messageRecord : o16) {
                if (ao.F(messageRecord.senderuin)) {
                    e(messageRecord.senderuin, messageRecord.istroop);
                } else if (com.tencent.qqnt.contact.friends.b.f355778a.c(messageRecord.senderuin, "QQMessageFacadeRefresher")) {
                    this.f116636d.getConversationFacade().k0(str, i3, messageRecord.frienduin, messageRecord.istroop);
                    h(str, i3, messageRecord.senderuin, messageRecord.selfuin);
                    Message lastMessage = this.f116635c.getLastMessage(messageRecord.senderuin, i3);
                    RecentUserProxy m3 = this.f116636d.getProxyManager().m();
                    RecentUser findRecentUserByUin = m3.findRecentUserByUin(lastMessage.frienduin, lastMessage.istroop);
                    findRecentUserByUin.lastmsgtime = lastMessage.time;
                    RecentUtil.K0(findRecentUserByUin, this.f116636d.getMessageFacade());
                    m3.saveRecentUser(findRecentUserByUin);
                    if (QLog.isColorLevel()) {
                        QLog.d("QQMessageFacadeRefresher", 2, "refreshMsgBox uin=" + str + ",type=" + i3 + ",move " + messageRecord.senderuin + " from box to recentlist");
                    }
                    this.f116635c.L0();
                    this.f116635c.notifyObservers(findRecentUserByUin);
                }
            }
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f116634b;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f116633a;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.f116633a = false;
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        e(AppConstants.SAME_STATE_BOX_UIN, 1009);
        String str = AppConstants.LBS_HELLO_UIN;
        e(str, 1001);
        e(str, 10002);
        e(AppConstants.DATE_UIN, 1010);
        e(AppConstants.MATCH_CHAT_UIN, 1044);
    }

    public Message f(String str, int i3, EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Message) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), entityManager);
        }
        return g(str, i3, entityManager, 0);
    }

    public Message g(String str, int i3, EntityManager entityManager, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Message) iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), entityManager, Integer.valueOf(i16));
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Message R = this.f116635c.F(i3).R(str, i3, entityManager, i16);
        if (QLog.isColorLevel()) {
            QLog.d("QQMessageFacadeRefresher", 2, "refreshSingleLastMsg() called with: uin = [" + str + "], uinType = [" + i3 + "], topicId = [" + i16 + "], cost = [" + (SystemClock.uptimeMillis() - uptimeMillis) + "]ms");
        }
        return R;
    }

    public void h(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), str2, str3);
        } else {
            this.f116635c.F(i3).W(str, i3, str2, str3);
        }
    }
}
