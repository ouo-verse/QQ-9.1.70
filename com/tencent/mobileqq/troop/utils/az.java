package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.bt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0xab.SubMsgType0xab$MsgBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class az implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f302096e;

    /* renamed from: f, reason: collision with root package name */
    public static int f302097f;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f302098d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76791);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f302096e = 1080;
            f302097f = 1920;
        }
    }

    public az(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f302098d = qQAppInterface;
        }
    }

    private MessageForTroopReward a(String str, int i3, int i16, String str2, String str3, int i17) {
        MessageForTroopReward messageForTroopReward = new MessageForTroopReward();
        messageForTroopReward.selfuin = this.f302098d.getCurrentAccountUin();
        messageForTroopReward.frienduin = str;
        messageForTroopReward.senderuin = this.f302098d.getCurrentAccountUin();
        messageForTroopReward.msgUid = com.tencent.mobileqq.service.message.s.f(i3);
        messageForTroopReward.f203106msg = bt.i(null);
        messageForTroopReward.msgtype = MessageRecord.MSG_TYPE_TROOP_REWARD;
        messageForTroopReward.isread = true;
        messageForTroopReward.issend = 1;
        messageForTroopReward.istroop = 1;
        messageForTroopReward.time = com.tencent.mobileqq.service.message.e.K0();
        messageForTroopReward.rewardCreateTime = (int) (System.currentTimeMillis() / 1000);
        messageForTroopReward.rewardMoney = i16;
        messageForTroopReward.rewardContent = str2;
        messageForTroopReward.rewardType = i17;
        messageForTroopReward.mediaPath = str3;
        messageForTroopReward.rewardStatus = 10000;
        messageForTroopReward.rewardSeq = messageForTroopReward.uniseq;
        messageForTroopReward.prewrite();
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_REWARD, 2, "buildTroopRewardMgr success");
        }
        return messageForTroopReward;
    }

    public static void e(QQAppInterface qQAppInterface, SubMsgType0xab$MsgBody subMsgType0xab$MsgBody) {
        if (subMsgType0xab$MsgBody == null) {
            return;
        }
        String str = subMsgType0xab$MsgBody.uint64_gc.get() + "";
        String str2 = subMsgType0xab$MsgBody.uint64_uin.get() + "";
        String str3 = subMsgType0xab$MsgBody.string_reward_id.get();
        int i3 = subMsgType0xab$MsgBody.uint32_reward_status.get();
        if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_reward.push", 2, "onLinePush receive 0x210_0xab: gc=" + str + ", ownerUin=" + str2 + ", id=" + str3 + ", status=" + i3);
        }
        az azVar = (az) qQAppInterface.getManager(QQManagerFactory.TROOP_REWARD_MGR);
        MessageForTroopReward d16 = azVar.d(str, str3);
        if (d16 != null) {
            d16.rewardStatus = i3;
            azVar.h(d16);
            qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER).notifyUI(com.tencent.mobileqq.troop.onlinepush.api.b.TYPE_NOTIFY_TROOP_REWARD_CHANGE, true, new Object[]{str, str3});
        }
    }

    public static void g(QQAppInterface qQAppInterface, Context context, String str, boolean z16) {
        String str2 = "https://qun.qq.com/qunpay/reward/index.html?_wv=1039&_bid=2313&gc=" + str;
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str2);
        if (z16) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_TROOP_REWARD, 2, "openNewReward:" + str2);
        }
    }

    protected List<MessageRecord> b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        }
        MsgPool I = this.f302098d.getMessageProxy(0).I();
        Lock e16 = I.e(str, i3);
        e16.lock();
        try {
            List<MessageRecord> list = I.d().get(c(str, i3));
            if (list != null) {
                return (List) ((ArrayList) list).clone();
            }
            return list;
        } finally {
            e16.unlock();
        }
    }

    protected String c(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
        }
        return com.tencent.imcore.message.ao.f(str, i3);
    }

    public MessageForTroopReward d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MessageForTroopReward) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        }
        MessageForTroopReward messageForTroopReward = null;
        if (TextUtils.isEmpty(str2) || this.f302098d.getMessageProxy(1) == null) {
            return null;
        }
        List<MessageRecord> b16 = b(str, 1);
        if (b16 != null) {
            Iterator<MessageRecord> it = b16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MessageRecord next = it.next();
                if (next instanceof MessageForTroopReward) {
                    MessageForTroopReward messageForTroopReward2 = (MessageForTroopReward) next;
                    if (str2.equals(messageForTroopReward2.rewardId)) {
                        messageForTroopReward = messageForTroopReward2;
                        break;
                    }
                }
            }
        }
        if (messageForTroopReward == null) {
            for (MessageRecord messageRecord : this.f302098d.getMessageFacade().D(str, 1, new int[]{MessageRecord.MSG_TYPE_TROOP_REWARD})) {
                if (messageRecord instanceof MessageForTroopReward) {
                    MessageForTroopReward messageForTroopReward3 = (MessageForTroopReward) messageRecord;
                    messageForTroopReward3.parse();
                    if (str2.equals(messageForTroopReward3.rewardId)) {
                        return messageForTroopReward3;
                    }
                }
            }
            return messageForTroopReward;
        }
        return messageForTroopReward;
    }

    public void f(String str, int i3, String str2, String str3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, str3, Integer.valueOf(i16));
        } else {
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.e(LogTag.TAG_TROOP_REWARD, 2, "insertAIOMsg troop uin empty");
                    return;
                }
                return;
            }
            this.f302098d.getMessageFacade().c(a(str, Math.abs(new Random().nextInt()), i3, str2, str3, i16), this.f302098d.getCurrentAccountUin());
        }
    }

    public void h(MessageForTroopReward messageForTroopReward) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageForTroopReward);
        } else if (messageForTroopReward != null) {
            messageForTroopReward.prewrite();
            this.f302098d.getMessageFacade().Y0(messageForTroopReward.frienduin, 1, messageForTroopReward.uniseq, messageForTroopReward.msgData);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }
}
