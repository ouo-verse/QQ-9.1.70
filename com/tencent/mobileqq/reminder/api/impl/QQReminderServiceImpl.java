package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsAckMsgReq;
import Wallet.AcsBatchSubNoticeReq;
import Wallet.AcsDelMsgReq;
import Wallet.AcsGetMsgListReq;
import Wallet.AcsGetMsgReq;
import Wallet.AcsPullMsgReq;
import Wallet.AcsQueryReq;
import Wallet.AcsSubNoticeReq;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.QQReminderServlet;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderServiceImpl implements IQQReminderService {
    static IPatchRedirector $redirector_;
    private AppRuntime mAppRuntime;

    public QQReminderServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime);
        } else {
            this.mAppRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderService
    public void queryNotifyIsSubscribed(String str, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) businessObserver);
            return;
        }
        if (this.mAppRuntime == null) {
            return;
        }
        AcsQueryReq acsQueryReq = new AcsQueryReq();
        acsQueryReq.head = QQReminderServlet.a(this.mAppRuntime);
        acsQueryReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
        acsQueryReq.msg_id = str;
        NewIntent newIntent = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
        newIntent.putExtra("account", this.mAppRuntime.getAccount());
        newIntent.putExtra("req", acsQueryReq);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2006);
        newIntent.setObserver(businessObserver);
        this.mAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderService
    public void sendAckMsgs(ArrayList<String> arrayList, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList, (Object) businessObserver);
            return;
        }
        if (this.mAppRuntime == null) {
            return;
        }
        AcsAckMsgReq acsAckMsgReq = new AcsAckMsgReq();
        acsAckMsgReq.head = QQReminderServlet.a(this.mAppRuntime);
        acsAckMsgReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
        acsAckMsgReq.msg_id_list = arrayList;
        NewIntent newIntent = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
        newIntent.putExtra("account", this.mAppRuntime.getAccount());
        newIntent.putExtra("req", acsAckMsgReq);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2004);
        newIntent.setObserver(businessObserver);
        this.mAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderService
    public void sendBatchSubscribeReminder(ArrayList<String> arrayList, String str, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, arrayList, str, businessObserver);
            return;
        }
        if (this.mAppRuntime == null) {
            return;
        }
        AcsBatchSubNoticeReq acsBatchSubNoticeReq = new AcsBatchSubNoticeReq();
        acsBatchSubNoticeReq.domain = str;
        ArrayList<String> arrayList2 = new ArrayList<>();
        acsBatchSubNoticeReq.msg_id_list = arrayList2;
        arrayList2.addAll(arrayList);
        acsBatchSubNoticeReq.head = QQReminderServlet.a(this.mAppRuntime);
        acsBatchSubNoticeReq.uin = this.mAppRuntime.getLongAccountUin();
        NewIntent newIntent = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
        newIntent.putExtra("account", this.mAppRuntime.getAccount());
        newIntent.putExtra("req", acsBatchSubNoticeReq);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2007);
        newIntent.setObserver(businessObserver);
        this.mAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderService
    public void sendDelReminderListById(String str, long j3, int i3, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Long.valueOf(j3), Integer.valueOf(i3), businessObserver);
            return;
        }
        if (this.mAppRuntime == null) {
            return;
        }
        AcsDelMsgReq acsDelMsgReq = new AcsDelMsgReq();
        acsDelMsgReq.head = QQReminderServlet.a(this.mAppRuntime);
        acsDelMsgReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
        acsDelMsgReq.msg_id = str;
        acsDelMsgReq.mn_appid = j3;
        acsDelMsgReq.source = i3;
        NewIntent newIntent = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
        newIntent.putExtra("account", this.mAppRuntime.getAccount());
        newIntent.putExtra("req", acsDelMsgReq);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2001);
        newIntent.setObserver(businessObserver);
        this.mAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderService
    public void sendGetMsgs(String str, String str2, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, businessObserver);
            return;
        }
        if (this.mAppRuntime == null) {
            return;
        }
        AcsGetMsgReq acsGetMsgReq = new AcsGetMsgReq();
        acsGetMsgReq.head = QQReminderServlet.a(this.mAppRuntime);
        acsGetMsgReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
        acsGetMsgReq.msg_id = str;
        acsGetMsgReq.domain = str2;
        NewIntent newIntent = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
        newIntent.putExtra("account", this.mAppRuntime.getAccount());
        newIntent.putExtra("req", acsGetMsgReq);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2005);
        newIntent.setObserver(businessObserver);
        this.mAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderService
    public void sendReminderList(int i3, int i16, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), businessObserver);
            return;
        }
        if (this.mAppRuntime == null) {
            return;
        }
        AcsGetMsgListReq acsGetMsgListReq = new AcsGetMsgListReq();
        acsGetMsgListReq.head = QQReminderServlet.a(this.mAppRuntime);
        acsGetMsgListReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
        acsGetMsgListReq.record_start = i3;
        acsGetMsgListReq.record_size = i16;
        NewIntent newIntent = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
        newIntent.putExtra("account", this.mAppRuntime.getAccount());
        newIntent.putExtra("req", acsGetMsgListReq);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2000);
        newIntent.setObserver(businessObserver);
        this.mAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderService
    public void sendReminderListByDay(String str, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) businessObserver);
            return;
        }
        if (this.mAppRuntime == null) {
            return;
        }
        AcsPullMsgReq acsPullMsgReq = new AcsPullMsgReq();
        acsPullMsgReq.head = QQReminderServlet.a(this.mAppRuntime);
        acsPullMsgReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
        acsPullMsgReq.day = str;
        NewIntent newIntent = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
        newIntent.putExtra("account", this.mAppRuntime.getAccount());
        newIntent.putExtra("req", acsPullMsgReq);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2003);
        newIntent.setObserver(businessObserver);
        this.mAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderService
    public void sendSubscribeReminder(String str, String str2, BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, businessObserver);
            return;
        }
        if (this.mAppRuntime == null) {
            return;
        }
        AcsSubNoticeReq acsSubNoticeReq = new AcsSubNoticeReq();
        acsSubNoticeReq.head = QQReminderServlet.a(this.mAppRuntime);
        acsSubNoticeReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
        acsSubNoticeReq.msg_id = str;
        acsSubNoticeReq.domain = str2;
        NewIntent newIntent = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
        newIntent.putExtra("account", this.mAppRuntime.getAccount());
        newIntent.putExtra("req", acsSubNoticeReq);
        newIntent.putExtra(QZoneCheckSendGiftServlet.PARAM_REQ_TYPE, 2002);
        newIntent.setObserver(businessObserver);
        this.mAppRuntime.startServlet(newIntent);
    }
}
