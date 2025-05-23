package com.tencent.mobileqq.dating.widget;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemVoteData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.d;
import com.tencent.mobileqq.managers.i;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$MCardNotificationLike;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f203460a;

    /* renamed from: b, reason: collision with root package name */
    RecentItemVoteData f203461b;

    /* renamed from: c, reason: collision with root package name */
    MessageForText f203462c;

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f203460a = qQAppInterface;
        }
    }

    private Intent a(Context context) {
        String format = String.format("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10002&from_type=0&mode=2&source_id=1001&uid=%s&PUSH_CONTENT=%s", this.f203460a.getCurrentAccountUin(), this.f203461b.mTitleName);
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(format));
        return intent;
    }

    private void e() {
        BaseApplication context = BaseApplication.getContext();
        boolean k3 = QQUtils.k(context);
        QQAppInterface qQAppInterface = this.f203460a;
        if (qQAppInterface.isBackgroundPause || qQAppInterface.isBackgroundStop || k3) {
            Bitmap g16 = j.g(context.getResources(), R.drawable.qq_leba_list_seek_neighbour);
            NotificationCompat.Builder when = new NotificationCompat.Builder(context).setContentTitle(this.f203461b.mTitleName).setAutoCancel(true).setSmallIcon(BaseApplication.appnewmsgicon).setTicker(this.f203461b.mTitleName).setWhen(System.currentTimeMillis());
            if (g16 != null) {
                when.setLargeIcon(g16);
            }
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.atp);
            when.setContent(remoteViews);
            remoteViews.setCharSequence(R.id.title, IECSearchBar.METHOD_SET_TEXT, this.f203461b.mTitleName);
            remoteViews.setCharSequence(R.id.jl7, IECSearchBar.METHOD_SET_TEXT, en.p(System.currentTimeMillis(), true, TuxDateStringUtils.TUX_COMMON_DATE_FORMAT));
            Intent a16 = a(context);
            a16.putExtra(QQNotificationManager.PARAM_NOTIFYID, 240);
            when.setContentIntent(PendingIntent.getActivity(context, 0, a16, 167772160));
            Notification build = when.build();
            build.flags |= 16;
            build.defaults = build.defaults | 1 | 4;
            build.icon = R.drawable.qq_leba_list_seek_neighbour;
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel("nearby_like_notification_tag", 240);
                qQNotificationManager.notify("nearby_like_notification_tag", 240, build);
            }
            ReportController.o(this.f203460a, "CliOper", "", "", "0X80053CD", "0X80053CD", 0, 0, "", "", "", "");
        }
        if (k3) {
            i iVar = (i) this.f203460a.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
            if (SettingCloneUtil.readValue((Context) context, this.f203460a.getCurrentAccountUin(), context.getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface VoteEventMgr.notifyVoteEvent");
                }
                QQAppInterface qQAppInterface2 = this.f203460a;
                String str = AppConstants.VOTE_UIN;
                iVar.f(qQAppInterface2, str, 1012, false, d.a(str, 1012, null));
            }
            this.f203460a.getMessageFacade().notifyObservers(c());
        }
    }

    public MessageForText b(RecentBaseData recentBaseData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MessageForText) iPatchRedirector.redirect((short) 3, (Object) this, (Object) recentBaseData);
        }
        RecentItemVoteData recentItemVoteData = (RecentItemVoteData) recentBaseData;
        if (this.f203462c == null) {
            MessageForText messageForText = (MessageForText) q.d(-1000);
            this.f203462c = messageForText;
            messageForText.msgtype = -1000;
            messageForText.istroop = 1012;
            messageForText.isread = false;
            messageForText.selfuin = this.f203460a.getCurrentAccountUin();
            MessageForText messageForText2 = this.f203462c;
            String str = AppConstants.DATE_UIN;
            messageForText2.senderuin = str;
            messageForText2.frienduin = str;
            messageForText2.f203106msg = recentItemVoteData.mTitleName;
            messageForText2.time = recentItemVoteData.time;
        }
        String str2 = this.f203462c.f203106msg;
        if (str2 == null || !str2.equals(recentItemVoteData.mTitleName)) {
            this.f203462c.f203106msg = recentItemVoteData.mTitleName;
        }
        MessageForText messageForText3 = this.f203462c;
        long j3 = messageForText3.time;
        long j16 = recentItemVoteData.time;
        if (j3 != j16) {
            messageForText3.time = j16;
        }
        return messageForText3;
    }

    public RecentBaseData c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecentBaseData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f203461b;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.f203461b == null) {
            return 0;
        }
        return 1;
    }

    public void f(SubMsgType0x6f$MCardNotificationLike subMsgType0x6f$MCardNotificationLike) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) subMsgType0x6f$MCardNotificationLike);
            return;
        }
        if (subMsgType0x6f$MCardNotificationLike != null && subMsgType0x6f$MCardNotificationLike.str_wording.has()) {
            str = subMsgType0x6f$MCardNotificationLike.str_wording.get();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long K0 = e.K0();
        RecentItemVoteData recentItemVoteData = this.f203461b;
        if (recentItemVoteData == null) {
            RecentUser recentUser = new RecentUser(AppConstants.VOTE_UIN, 1012);
            recentUser.msgType = 1012;
            RecentItemVoteData recentItemVoteData2 = new RecentItemVoteData(recentUser);
            this.f203461b = recentItemVoteData2;
            recentItemVoteData2.p(str, K0);
            e();
            return;
        }
        if (!recentItemVoteData.mTitleName.equals(str) || this.f203461b.time != K0) {
            this.f203461b.p(str, K0);
            e();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        BaseApplication.getContext();
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel("nearby_like_notification_tag", 240);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f203461b = null;
        BaseApplication.getContext();
        QQNotificationManager.getInstance().cancel("nearby_like_notification_tag", 240);
    }
}
