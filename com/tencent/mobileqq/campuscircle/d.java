package com.tencent.mobileqq.campuscircle;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.i;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.k;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import mqq.manager.Manager;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$MQQCampusNotify;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    int f201028d;

    /* renamed from: e, reason: collision with root package name */
    final ArrayList<Integer> f201029e;

    /* renamed from: f, reason: collision with root package name */
    QQAppInterface f201030f;

    /* renamed from: h, reason: collision with root package name */
    RecentItemNoticeData f201031h;

    /* renamed from: i, reason: collision with root package name */
    MessageForText f201032i;

    public d(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f201028d = 1000;
        this.f201029e = new ArrayList<>();
        this.f201030f = qQAppInterface;
    }

    public MessageForText a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MessageForText) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        RecentItemNoticeData recentItemNoticeData = this.f201031h;
        if (recentItemNoticeData == null) {
            return null;
        }
        if (this.f201032i == null) {
            MessageForText messageForText = (MessageForText) q.d(-1000);
            this.f201032i = messageForText;
            messageForText.msgtype = -1000;
            messageForText.istroop = 1030;
            messageForText.isread = false;
            messageForText.selfuin = this.f201030f.getCurrentAccountUin();
            MessageForText messageForText2 = this.f201032i;
            String str = AppConstants.CAMPUS_NOTICE_UIN;
            messageForText2.senderuin = str;
            messageForText2.frienduin = str;
            messageForText2.f203106msg = recentItemNoticeData.wording;
            messageForText2.time = recentItemNoticeData.time;
        }
        String str2 = this.f201032i.f203106msg;
        if (str2 == null || !str2.equals(recentItemNoticeData.mTitleName)) {
            this.f201032i.f203106msg = recentItemNoticeData.mTitleName;
        }
        MessageForText messageForText3 = this.f201032i;
        long j3 = messageForText3.time;
        long j16 = recentItemNoticeData.time;
        if (j3 != j16) {
            messageForText3.time = j16;
        }
        return messageForText3;
    }

    public RecentBaseData b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecentBaseData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f201031h;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.f201031h == null) {
            return 0;
        }
        return 1;
    }

    public void d(int i3, long j3, String str, String str2, String str3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), str, str2, str3);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        boolean k3 = QQUtils.k(context);
        QQAppInterface qQAppInterface = this.f201030f;
        Intent intent = null;
        if (qQAppInterface.isBackgroundPause || qQAppInterface.isBackgroundStop || k3) {
            synchronized (this) {
                i16 = this.f201028d + 1;
                this.f201028d = i16;
            }
            String[] strArr = {str, str3, str};
            Intent aliasIntent = SplashActivity.getAliasIntent(this.f201030f.getApp());
            aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 4);
            aliasIntent.setFlags(603979776);
            aliasIntent.putExtra("forward", 3);
            aliasIntent.putExtra("url", str2);
            aliasIntent.putExtra("from", "campus_notice");
            aliasIntent.putExtra("uintype", 1030);
            aliasIntent.putExtra(QQNotificationManager.PARAM_FROMUIN, String.valueOf(j3));
            aliasIntent.putExtra("campus_notice_tag", "campus_notification_tag");
            aliasIntent.putExtra("campus_notice_id", i16);
            if (QLog.isColorLevel()) {
                QLog.d("CampusNoticeManager", 2, "onReceiveNotice notifyUI campus_notice_id:", Integer.valueOf(i16), " ,url:", str2);
            }
            RecentItemNoticeData recentItemNoticeData = this.f201031h;
            if (recentItemNoticeData != null) {
                recentItemNoticeData.r(aliasIntent);
            }
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f201030f.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
            toServiceMsg.extraData.putStringArray("cmds", strArr);
            toServiceMsg.extraData.putParcelable("intent", aliasIntent);
            toServiceMsg.extraData.putParcelable(MimeHelper.IMAGE_SUBTYPE_BITMAP, null);
            this.f201030f.sendToService(toServiceMsg);
            synchronized (this.f201029e) {
                this.f201029e.add(Integer.valueOf(i16));
            }
            intent = aliasIntent;
        }
        if (k3) {
            i iVar = (i) this.f201030f.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
            if (SettingCloneUtil.readValue((Context) context, this.f201030f.getCurrentAccountUin(), context.getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true)) {
                if (QLog.isColorLevel()) {
                    QLog.d("CampusNoticeManager", 2, "campus notice start lsActivity from appinterface ");
                }
                QQAppInterface qQAppInterface2 = this.f201030f;
                String str4 = AppConstants.CAMPUS_NOTICE_UIN;
                iVar.f(qQAppInterface2, str4, 1030, false, com.tencent.mobileqq.managers.d.a(str4, 1030, intent));
            }
            this.f201030f.getMessageFacade().notifyObservers(b());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(SubMsgType0x27$MQQCampusNotify subMsgType0x27$MQQCampusNotify) {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) subMsgType0x27$MQQCampusNotify);
            return;
        }
        if (subMsgType0x27$MQQCampusNotify == null) {
            return;
        }
        int i3 = subMsgType0x27$MQQCampusNotify.uint32_type.get();
        long j3 = subMsgType0x27$MQQCampusNotify.uint64_from_uin.get();
        String str4 = null;
        if (subMsgType0x27$MQQCampusNotify.str_wording.has()) {
            str = subMsgType0x27$MQQCampusNotify.str_wording.get();
        } else {
            str = null;
        }
        if (subMsgType0x27$MQQCampusNotify.str_target.has()) {
            str2 = subMsgType0x27$MQQCampusNotify.str_target.get();
            if (!TextUtils.isEmpty(str2)) {
                try {
                    str2 = new String(com.tencent.mobileqq.musicpendant.a.a(str2), "UTF-8");
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("CampusNoticeManager", 2, "decode url fail ", e16);
                    }
                }
            }
            if (subMsgType0x27$MQQCampusNotify.str_source.has()) {
                str4 = subMsgType0x27$MQQCampusNotify.str_source.get();
            }
            if (str4 != null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (QLog.isColorLevel()) {
                QLog.i("CampusNoticeManager", 2, String.format(Locale.getDefault(), "onReceiveNotice [type: %d uin: %d wording: %s url: %s from: %s", Integer.valueOf(i3), Long.valueOf(j3), str, str2, str3));
            }
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                k.a aVar = new k.a();
                aVar.f290023e = "0X800923D";
                aVar.f290022d = "\u6536\u5230Push\u534f\u8bae";
                k.b(str2, aVar);
                k.d(this.f201030f, aVar);
                long K0 = e.K0();
                RecentItemNoticeData recentItemNoticeData = this.f201031h;
                if (recentItemNoticeData == null) {
                    RecentUser recentUser = new RecentUser();
                    recentUser.uin = AppConstants.CAMPUS_NOTICE_UIN;
                    recentUser.msgType = 1030;
                    recentUser.setType(1030);
                    RecentItemNoticeData recentItemNoticeData2 = new RecentItemNoticeData(recentUser);
                    this.f201031h = recentItemNoticeData2;
                    recentItemNoticeData2.p(i3, j3, str, str2, str3, K0);
                    d(i3, j3, str, str2, str3);
                    return;
                }
                if (!recentItemNoticeData.q(i3, j3, str, str2, str3, K0)) {
                    this.f201031h.p(i3, j3, str, str2, str3, K0);
                    d(i3, j3, str, str2, str3);
                    return;
                }
                return;
            }
        }
        str2 = null;
        if (subMsgType0x27$MQQCampusNotify.str_source.has()) {
        }
        if (str4 != null) {
        }
        if (QLog.isColorLevel()) {
        }
        if (TextUtils.isEmpty(str)) {
        }
    }

    public void f(QQNotificationManager qQNotificationManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQNotificationManager);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "setReaded seq: %d", Integer.valueOf(this.f201028d)));
        }
        this.f201031h = null;
        if (qQNotificationManager == null) {
            try {
                BaseApplication.getContext();
                qQNotificationManager = QQNotificationManager.getInstance();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("CampusNoticeManager", 2, "setReaded", e16);
                    return;
                }
                return;
            }
        }
        synchronized (this.f201029e) {
            Iterator<Integer> it = this.f201029e.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (next != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("CampusNoticeManager", 2, String.format(Locale.getDefault(), "cancel campus_notice [%d, %s]", next, "campus_notification_tag"));
                    }
                    qQNotificationManager.cancelUseTag("CampusNoticeManager_removeNotification", "campus_notification_tag", next.intValue());
                }
            }
            this.f201029e.clear();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }
}
