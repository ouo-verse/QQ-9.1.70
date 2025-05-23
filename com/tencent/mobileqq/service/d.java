package com.tencent.mobileqq.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.preference.PreferenceManager;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NotificationDeleteReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.k;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.util.ba;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    public static HashMap<String, UniPacket> f286089m;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f286090f;

    /* renamed from: g, reason: collision with root package name */
    private Random f286091g;

    /* renamed from: h, reason: collision with root package name */
    private int f286092h;

    /* renamed from: i, reason: collision with root package name */
    private Map<Integer, Integer> f286093i;

    /* renamed from: j, reason: collision with root package name */
    private QQNotificationManager f286094j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f286095k;

    /* renamed from: l, reason: collision with root package name */
    boolean f286096l;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74897);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f286089m = new HashMap<>();
        }
    }

    public d(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f286091g = new Random();
        this.f286092h = 0;
        this.f286093i = new HashMap();
        this.f286095k = false;
        this.f286096l = true;
        this.f286090f = qQAppInterface;
        E();
    }

    private void A(ToServiceMsg toServiceMsg) {
        Intent intent = (Intent) toServiceMsg.extraData.getParcelable("intent");
        Notification w3 = w(toServiceMsg, intent);
        if (w3 == null) {
            return;
        }
        if (this.f286090f.isShowMsgContent()) {
            o(intent, w3);
        } else {
            n(intent, w3);
        }
    }

    private void E() {
        if (this.f286094j == null && this.f286092h < 3) {
            QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
            this.f286094j = qQNotificationManager;
            if (qQNotificationManager == null) {
                this.f286094j = QQNotificationManager.getInstance();
            }
            MobileQQServiceBase.seq = Math.abs(this.f286091g.nextInt());
            if (QLog.isColorLevel()) {
                QLog.i("MobileQQServiceWrapper", 2, "MobileQQService has created. mNM=" + this.f286094j);
            }
        }
        this.f286092h++;
    }

    private Notification e(Intent intent, Bitmap bitmap, String str, String str2) {
        intent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 275);
        PendingIntent activity = PendingIntent.getActivity(BaseApplication.getContext(), 0, intent, y(134217728));
        NotificationCompat.Builder when = NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_HIDE_BADGE).setSmallIcon(R.drawable.b8f).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis());
        when.setContentTitle(str).setContentText(str2).setContentIntent(activity);
        if (bitmap != null) {
            when.setLargeIcon(bitmap);
        }
        return when.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0231  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Notification f(Intent intent, Bitmap bitmap, String str, String str2, String str3) {
        int i3;
        PendingIntent activity;
        Bitmap g16;
        PendingIntent activity2;
        PendingIntent pendingIntent;
        int i16;
        boolean booleanExtra;
        boolean z16;
        NotificationCompat.Builder ticker;
        boolean isOpenNoClearNotification = this.f286090f.isOpenNoClearNotification();
        int intExtra = intent.getIntExtra(QQNotificationManager.PARAM_NOTIFYID, 0);
        if (intExtra >= 512 && intExtra <= 522) {
            i3 = 134217728;
        } else {
            intExtra = 0;
            i3 = 268435456;
        }
        if (intent.getBooleanExtra("is_broadcast_notification", false)) {
            activity = PendingIntent.getBroadcast(BaseApplication.getContext(), intExtra, intent, y(i3));
        } else {
            activity = PendingIntent.getActivity(BaseApplication.getContext(), intExtra, intent, y(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.i("MobileQQServiceWrapper", 2, "buildNotification by getActivity. contentIntent=" + activity);
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusNoticeManager", 2, "buildNotification url :", intent.getStringExtra("url"));
        }
        int intExtra2 = intent.getIntExtra("uintype", -1);
        String str4 = QQNotificationManager.CHANNEL_ID_SHOW_BADGE;
        if (intExtra2 == 1008) {
            if (!AppConstants.REMINDER_UIN.equals(intent.getStringExtra("uin")) && !intent.getBooleanExtra("activepull_push_flag", false)) {
                i16 = R.drawable.br7;
                pendingIntent = activity;
                g16 = bitmap;
                booleanExtra = intent.getBooleanExtra(AppConstants.Key.KEY_NOTIFYCATION_ONEWAY_MESSAGE, false);
                if (booleanExtra && intExtra2 == 1010) {
                    i16 = R.drawable.eya;
                }
                if (!booleanExtra && (intExtra2 == 1001 || intExtra2 == 10002)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i16 = R.drawable.icon_recent_lbs_hello_notify_small;
                }
                if (intent.getBooleanExtra("qav_notify_flag", false)) {
                    i16 = R.drawable.h9n;
                }
                if (intExtra2 == 1045 && intExtra2 != 1044) {
                    if (intExtra2 == 1) {
                        SdkInfoUtil.isAndroidQ();
                    }
                } else {
                    str4 = QQNotificationManager.CHANNEL_ID_LIMIT_CHAT;
                }
                ticker = NotificationFactory.createNotificationCompatBuilder(str4).setSmallIcon(i16).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(str);
                if (intExtra2 != 1030 && intExtra2 != 1035 && intExtra2 != 1041 && intExtra2 != 1042 && isOpenNoClearNotification) {
                    ticker.setOngoing(true);
                }
                if (ba.a(BaseApplication.getContext(), this.f286090f)) {
                    Calendar.getInstance().get(11);
                    ticker.setLights(-16711936, 2000, 2000);
                }
                ticker.setContentTitle(str2).setContentText(str3).setContentIntent(pendingIntent);
                if (g16 != null) {
                    ticker.setLargeIcon(g16);
                }
                if (!this.f286095k) {
                    this.f286095k = true;
                    this.f286096l = PreferenceManager.getDefaultSharedPreferences(this.f286090f.getApp()).getBoolean(this.f286090f.getAccount() + "_" + AppConstants.Preferences.HEADS_UP_NOTIFY_SWITCH, true);
                    if (QLog.isColorLevel()) {
                        QLog.i("MobileQQServiceWrapper", 2, "notify init priority flag, " + this.f286096l);
                    }
                }
                if (Build.VERSION.SDK_INT < 24 || this.f286096l) {
                    ticker.setPriority(1).setVibrate(new long[0]);
                }
                return ticker.build();
            }
        } else {
            if (intExtra2 == 1030) {
                int intExtra3 = intent.getIntExtra("campus_notice_id", 100);
                g16 = com.tencent.mobileqq.util.j.g(BaseApplication.getContext().getResources(), R.drawable.icon);
                activity2 = PendingIntent.getActivity(BaseApplication.getContext(), intExtra3, intent, y(268435456));
                if (QLog.isColorLevel()) {
                    QLog.d("CampusNoticeManager", 2, "buildNotification UIN_TYPE_CAMPUS_NOTICE url :", intent.getStringExtra("url"));
                }
            } else if (intExtra2 == 1035 || intExtra2 == 1041 || intExtra2 == 1042) {
                int intExtra4 = intent.getIntExtra(QQNotificationManager.PARAM_NOTIFYID, 100);
                g16 = com.tencent.mobileqq.util.j.g(BaseApplication.getContext().getResources(), R.drawable.icon);
                activity2 = PendingIntent.getActivity(BaseApplication.getContext(), intExtra4, intent, y(268435456));
                if (QLog.isColorLevel()) {
                    QLog.d("PushNoticeManager", 2, "buildNotification UIN_TYPE_PUSH_NOTICE url :", intent.getStringExtra("url"));
                }
                str4 = QQNotificationManager.CHANNEL_ID_OTHER;
            }
            pendingIntent = activity2;
            i16 = R.drawable.b8f;
            booleanExtra = intent.getBooleanExtra(AppConstants.Key.KEY_NOTIFYCATION_ONEWAY_MESSAGE, false);
            if (booleanExtra) {
                i16 = R.drawable.eya;
            }
            if (!booleanExtra) {
            }
            z16 = false;
            if (z16) {
            }
            if (intent.getBooleanExtra("qav_notify_flag", false)) {
            }
            if (intExtra2 == 1045) {
            }
            str4 = QQNotificationManager.CHANNEL_ID_LIMIT_CHAT;
            ticker = NotificationFactory.createNotificationCompatBuilder(str4).setSmallIcon(i16).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(str);
            if (intExtra2 != 1030) {
                ticker.setOngoing(true);
            }
            if (ba.a(BaseApplication.getContext(), this.f286090f)) {
            }
            ticker.setContentTitle(str2).setContentText(str3).setContentIntent(pendingIntent);
            if (g16 != null) {
            }
            if (!this.f286095k) {
            }
            if (Build.VERSION.SDK_INT < 24) {
            }
            ticker.setPriority(1).setVibrate(new long[0]);
            return ticker.build();
        }
        i16 = R.drawable.b8g;
        pendingIntent = activity;
        g16 = bitmap;
        booleanExtra = intent.getBooleanExtra(AppConstants.Key.KEY_NOTIFYCATION_ONEWAY_MESSAGE, false);
        if (booleanExtra) {
        }
        if (!booleanExtra) {
        }
        z16 = false;
        if (z16) {
        }
        if (intent.getBooleanExtra("qav_notify_flag", false)) {
        }
        if (intExtra2 == 1045) {
        }
        str4 = QQNotificationManager.CHANNEL_ID_LIMIT_CHAT;
        ticker = NotificationFactory.createNotificationCompatBuilder(str4).setSmallIcon(i16).setAutoCancel(true).setWhen(System.currentTimeMillis()).setTicker(str);
        if (intExtra2 != 1030) {
        }
        if (ba.a(BaseApplication.getContext(), this.f286090f)) {
        }
        ticker.setContentTitle(str2).setContentText(str3).setContentIntent(pendingIntent);
        if (g16 != null) {
        }
        if (!this.f286095k) {
        }
        if (Build.VERSION.SDK_INT < 24) {
        }
        ticker.setPriority(1).setVibrate(new long[0]);
        return ticker.build();
    }

    private boolean i(ToServiceMsg toServiceMsg) {
        String serviceCmd = toServiceMsg.getServiceCmd();
        if ("CMD_SHOW_NOTIFIYCATION".equals(serviceCmd)) {
            if (!((IPhoneContactService) this.f286090f.getRuntimeService(IPhoneContactService.class, "")).shouldBlockMessageTips()) {
                A(toServiceMsg);
            } else if (QLog.isColorLevel()) {
                QLog.d("MobileQQServiceWrapper", 2, "pcm blocked msg notification");
            }
            return true;
        }
        if ("CMD_IDLE_NOTIFIYCATION".equals(serviceCmd)) {
            this.f286090f.clearMsgCounter();
            z(toServiceMsg);
            return true;
        }
        if ("CMD_STOP_NOTIFIYCATION".equals(serviceCmd)) {
            this.f286090f.clearMsgCounter();
            D(275);
            return true;
        }
        if ("CMD_CANCLE_NOTIFIYCATION".equals(serviceCmd)) {
            g(275);
            return true;
        }
        return false;
    }

    private void k(Intent intent, Notification notification, String str, int i3) {
        intent.getStringExtra("campus_notice_tag");
        m(intent, notification, intent.getIntExtra("campus_notice_id", 0));
    }

    private void l(Intent intent, Notification notification) {
        int intExtra = intent.getIntExtra(QQNotificationManager.PARAM_NOTIFYID, 0);
        PushNoticeManager.h(this.f286090f, intent.getStringExtra("push_notice_service_id"), intent.getStringExtra("push_notice_content_id"), intent.getStringExtra("url"), "0X800923F", "Android\u7cfb\u7edf\u901a\u77e5\u66dd\u5149");
        m(intent, notification, intExtra);
        this.f286090f.vibratorAndAudio();
    }

    private void n(Intent intent, Notification notification) {
        String stringExtra = intent.getStringExtra(QQNotificationManager.PARAM_FROMUIN);
        int intExtra = intent.getIntExtra("uintype", -1);
        int s16 = s(intent, intExtra);
        if (intent.getBooleanExtra("qav_notify_flag", false)) {
            m(intent, notification, 236);
            return;
        }
        if (intExtra == 1030) {
            k(intent, notification, stringExtra, s16);
            return;
        }
        if (intExtra != 1035 && intExtra != 1041 && intExtra != 1042) {
            x(intent, intExtra);
            QQNotificationManager qQNotificationManager = this.f286094j;
            if (qQNotificationManager != null) {
                qQNotificationManager.cancel("MobileQQServiceWrapper.showMsgNotification", 275);
            }
            m(intent, notification, 265);
            return;
        }
        l(intent, notification);
    }

    private void o(Intent intent, Notification notification) {
        String stringExtra = intent.getStringExtra(QQNotificationManager.PARAM_FROMUIN);
        int intExtra = intent.getIntExtra("uintype", -1);
        String stringExtra2 = intent.getStringExtra("KEY_FRIEND_UIN");
        int s16 = s(intent, intExtra);
        boolean booleanExtra = intent.getBooleanExtra(AppConstants.Key.KEY_NOTIFYCATION_ONEWAY_MESSAGE, false);
        if (booleanExtra && intExtra == 1010) {
            m(intent, notification, 272);
            return;
        }
        if ((booleanExtra && intExtra == 1001) || intExtra == 10002) {
            m(intent, notification, 268);
            return;
        }
        if (intExtra == 1030) {
            k(intent, notification, stringExtra, s16);
            k.a aVar = new k.a();
            aVar.f290023e = "0X800923F";
            aVar.f290022d = "Android\u7cfb\u7edf\u901a\u77e5\u66dd\u5149";
            k.b(intent.getStringExtra("url"), aVar);
            k.d(this.f286090f, aVar);
            return;
        }
        if (intExtra != 1035 && intExtra != 1041 && intExtra != 1042) {
            if (intent.getBooleanExtra("activepull_push_flag", false)) {
                m(intent, notification, 269);
                return;
            }
            if (intExtra == 3001) {
                m(intent, notification, 271);
                return;
            }
            if (intent.getBooleanExtra("qav_notify_flag", false)) {
                m(intent, notification, 236);
                return;
            }
            x(intent, intExtra);
            if (!com.tencent.util.notification.d.j(intExtra, stringExtra2)) {
                QQNotificationManager qQNotificationManager = this.f286094j;
                if (qQNotificationManager != null) {
                    qQNotificationManager.cancel("MobileQQServiceWrapper.showMsgNotification", 275);
                }
                m(intent, notification, 265);
                return;
            }
            return;
        }
        l(intent, notification);
    }

    private int s(Intent intent, int i3) {
        if (i3 == -1) {
            return intent.getIntExtra(QQNotificationManager.PARAM_UINTYPE, -1);
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int t(String str, int i3, boolean z16) {
        int i16;
        int i17;
        int i18;
        com.tencent.mobileqq.qcall.f callFacade = this.f286090f.getCallFacade();
        int i19 = 0;
        if (callFacade != null) {
            i16 = callFacade.v();
        } else {
            i16 = 0;
        }
        QQMessageFacade messageFacade = this.f286090f.getMessageFacade();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("notification_get_badge_count_on_miui_8988", true)) {
            i17 = ((IAppBadgeService) this.f286090f.getRuntimeService(IAppBadgeService.class)).getAppBadgeCount(-1);
        } else if (messageFacade != null) {
            i17 = messageFacade.H1();
        } else {
            i17 = 0;
        }
        if (TextUtils.isEmpty(str)) {
            if (i3 != 265 && (i3 < 512 || i3 > 522)) {
                if (i3 == 236) {
                    i18 = i16;
                }
            } else {
                i18 = u(i3, messageFacade, i17, z16);
            }
            if (i3 >= 482 && i3 <= 511) {
                i18 = 0;
            }
            if (i3 != 266) {
                i19 = i18;
            }
            if (i3 == 527) {
                i19 = u(i3, messageFacade, i19, z16);
            }
            QLog.i(BadgeUtilImpl.TAG, 1, "startForegroundCompat changeMI6Badge count=" + i19 + ",callUnread=" + i16 + ",msgUnread=" + i17);
            return i19;
        }
        i18 = 1;
        if (i3 >= 482) {
            i18 = 0;
        }
        if (i3 != 266) {
        }
        if (i3 == 527) {
        }
        QLog.i(BadgeUtilImpl.TAG, 1, "startForegroundCompat changeMI6Badge count=" + i19 + ",callUnread=" + i16 + ",msgUnread=" + i17);
        return i19;
    }

    private void z(ToServiceMsg toServiceMsg) {
        String[] stringArray = toServiceMsg.extraData.getStringArray("cmds");
        if (stringArray.length != 3) {
            return;
        }
        Notification e16 = e((Intent) toServiceMsg.extraData.getParcelable("intent"), (Bitmap) toServiceMsg.extraData.getParcelable(MimeHelper.IMAGE_SUBTYPE_BITMAP), stringArray[1], stringArray[2]);
        e16.flags = 34;
        E();
        QLog.i("MobileQQServiceWrapper", 1, "showNotCancelNotification nf=" + e16);
        B(275, e16, this.f286090f.getCurrentUin(), 0);
    }

    void B(int i3, Notification notification, String str, int i16) {
        C(null, i3, notification, str, i16, false, 0L);
    }

    void C(String str, int i3, Notification notification, String str2, int i16, boolean z16, long j3) {
        if (this.f286094j == null) {
            QLog.i("MobileQQServiceWrapper", 2, "startForegroundCompat. notification manager is null, id=" + i3 + " msgId=" + j3);
            return;
        }
        try {
            int t16 = t(str, i3, z16);
            if (BadgeUtils.j(BaseApplicationImpl.getApplication().getApplicationContext())) {
                BadgeUtils.p(this.f286090f.getApp(), t16, notification);
            }
            if (!TextUtils.isEmpty(str)) {
                QQNotificationManager qQNotificationManager = this.f286094j;
                qQNotificationManager.notifyUseTag("MobileQQServiceWrapper.startForegroundCompat", str, notification, qQNotificationManager.createNotifyBundle(i3, str2, i16));
            } else {
                QQNotificationManager qQNotificationManager2 = this.f286094j;
                qQNotificationManager2.notify("MobileQQServiceWrapper.startForegroundCompat", notification, qQNotificationManager2.createNotifyBundle(i3, str2, i16));
            }
        } catch (Throwable th5) {
            QLog.w("MobileQQServiceWrapper", 1, "startForegroundCompat exception. id=" + i3 + ", mNM=" + this.f286094j, th5);
        }
    }

    void D(int i3) {
        if (this.f286094j != null && this.f286090f.getApplication() != null) {
            try {
                this.f286094j.cancel("MobileQQServiceWrapper.stopForegroundCompat", i3);
            } catch (Throwable unused) {
            }
        }
        com.tencent.mobileqq.perf.process.state.notification.a.f257942a.c(false);
    }

    @Override // com.tencent.mobileqq.service.b, com.tencent.mobileqq.service.MobileQQServiceBase
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        h(false);
        D(275);
        if (QLog.isColorLevel()) {
            QLog.i("MobileQQServiceWrapper", 2, "MobileQQServiceWrapper has destroyed.");
        }
        super.destroy();
    }

    void g(int i3) {
        QQNotificationManager qQNotificationManager = this.f286094j;
        if (qQNotificationManager != null) {
            qQNotificationManager.cancel("MobileQQServiceWrapper.cancelNotification", i3);
        }
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public AppInterface getAppInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AppInterface) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f286090f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public Map<String, String[]> getCompatibleCmd2HandlerMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return com.tencent.mobileqq.app.f.a();
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    protected Class<? extends MSFServlet> getServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return com.tencent.mobileqq.compatible.a.class;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public UniPacket getUniPacketClient(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (UniPacket) iPatchRedirector.redirect((short) 12, (Object) this, (Object) toServiceMsg);
        }
        if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("MobileQQServiceWrapper", 2, "stream ptt");
            }
            String string = toServiceMsg.extraData.getString("filepath");
            UniPacket uniPacket = f286089m.get(string);
            if (uniPacket == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MobileQQServiceWrapper", 2, "no saved packet, new one " + string);
                }
                uniPacket = new PttUniPacket(true);
                f286089m.clear();
                f286089m.put(string, uniPacket);
            } else if (QLog.isColorLevel()) {
                QLog.d("MobileQQServiceWrapper", 2, "got last packet, reuse it " + string);
            }
            short s16 = toServiceMsg.extraData.getShort("PackSeq");
            short o16 = com.tencent.mobileqq.streamtransfile.b.o(string);
            if (s16 <= o16) {
                f286089m.remove(string);
                if (QLog.isColorLevel()) {
                    QLog.d("MobileQQServiceWrapper", 2, "last stream, remove " + ((int) o16) + ", " + ((int) s16));
                }
            }
            return uniPacket;
        }
        return super.getUniPacketClient(toServiceMsg);
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public void handleNoProtocolCoder(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public void handleResponse(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Exception exc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), toServiceMsg, fromServiceMsg, exc);
        } else {
            com.tencent.mobileqq.managers.b.b().i(fromServiceMsg, this.f286090f);
            super.handleResponse(z16, toServiceMsg, fromServiceMsg, exc);
        }
    }

    public void j(ToServiceMsg toServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (!((IPhoneContactService) this.f286090f.getRuntimeService(IPhoneContactService.class, "")).shouldBlockMessageTips()) {
            Intent intent = (Intent) toServiceMsg.extraData.getParcelable("intent");
            Notification w3 = w(toServiceMsg, intent);
            if (intent != null && w3 != null) {
                com.tencent.mobileqq.pushnotice.message.i.m(this.f286090f, intent.getIntExtra(QQNotificationManager.PARAM_UINTYPE, -1));
                int intExtra = intent.getIntExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", -113);
                if (intExtra != -113) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    m(intent, w3, intExtra);
                    return;
                }
                QQNotificationManager r16 = r();
                if (r16 != null) {
                    r16.cancel("MobileQQServiceWrapper.showMsgNotification", 275);
                }
                x(intent, intent.getIntExtra("uintype", -1));
                m(intent, w3, 265);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MobileQQServiceWrapper", 2, "pcm blocked msg notification");
        }
    }

    public void m(Intent intent, Notification notification, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, intent, notification, Integer.valueOf(i3));
            return;
        }
        String stringExtra = intent.getStringExtra(QQNotificationManager.PARAM_FROMUIN);
        long longExtra = intent.getLongExtra(AppConstants.Key.MSG_UNISEQ, 0L);
        int intExtra = intent.getIntExtra("uintype", -1);
        int s16 = s(intent, intExtra);
        boolean h16 = BadgeUtils.h(i3, this.f286090f);
        QQNotificationManager qQNotificationManager = this.f286094j;
        if (qQNotificationManager != null && !h16) {
            qQNotificationManager.cancel("MobileQQServiceWrapper.showMsgNotification", i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("[NotificationRebuild] MobileQQServiceWrapper", 2, "[notify] generateNotificationAfterCancel: invoked. ", " reportUinType: ", Integer.valueOf(s16), " uinType: ", Integer.valueOf(intExtra), " notifyId: ", Integer.valueOf(i3), " isIgnoreCancel: ", Boolean.valueOf(h16));
        }
        C(null, i3, notification, stringExtra, s16, h16, longExtra);
        com.tencent.mobileqq.perf.process.state.notification.a.f257942a.c(true);
    }

    public PendingIntent p(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PendingIntent) iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra("uin");
            int intExtra = intent.getIntExtra(QQNotificationManager.PARAM_NOTIFYID, 0);
            Intent intent2 = new Intent(BaseApplication.getContext(), (Class<?>) NotificationDeleteReceiver.class);
            intent2.putExtra("uin", stringExtra);
            intent2.putExtra(QQNotificationManager.PARAM_NOTIFYID, intExtra);
            return PendingIntent.getBroadcast(BaseApplication.getContext(), 0, intent2, y(268435456));
        }
        return null;
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        try {
            return ((IFeatureRuntimeService) this.f286090f.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("kapalai_message_set_mutable_flag");
        } catch (Exception e16) {
            QLog.e("MobileQQServiceWrapper", 1, "getKapalaiMutableFlagSwitch", e16);
            return false;
        }
    }

    QQNotificationManager r() {
        return this.f286094j;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public void realHandleRequest(ToServiceMsg toServiceMsg, Class<? extends MSFServlet> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) toServiceMsg, (Object) cls);
        } else {
            if (toServiceMsg == null || i(toServiceMsg)) {
                return;
            }
            super.realHandleRequest(toServiceMsg, com.tencent.mobileqq.compatible.a.class);
        }
    }

    public int u(int i3, QQMessageFacade qQMessageFacade, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), qQMessageFacade, Integer.valueOf(i16), Boolean.valueOf(z16))).intValue();
        }
        if (CommonBadgeUtilImpl.isMIUI6() && qQMessageFacade != null) {
            QQNotificationManager r16 = r();
            if (r16 == null) {
                return i16;
            }
            StatusBarNotification[] activeNotifications = r16.getActiveNotifications();
            for (int i17 = 0; activeNotifications != null && i17 < activeNotifications.length; i17++) {
                StatusBarNotification statusBarNotification = activeNotifications[i17];
                Integer num = this.f286093i.get(Integer.valueOf(statusBarNotification.getId()));
                if (num != null) {
                    if (z16 && statusBarNotification.getId() == i3) {
                        QLog.i("MobileQQServiceWrapper", 1, "getUnreadMIUI() ignoreCancel id" + statusBarNotification.getId() + "], activeUnRead = [" + num + "], unread = [" + i16 + "]");
                    } else {
                        QLog.i("MobileQQServiceWrapper", 1, "getUnreadMIUI() minus activeUnRead with: id = [" + statusBarNotification.getId() + "], activeUnRead = [" + num + "], unread = [" + i16 + "]");
                        i16 -= num.intValue();
                    }
                }
            }
            this.f286093i.put(Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return i16;
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            h(true);
        }
    }

    @Nullable
    Notification w(ToServiceMsg toServiceMsg, Intent intent) {
        int i3;
        Bitmap bitmap;
        String str;
        String[] strArr;
        String str2;
        Intent intent2;
        Notification f16;
        RemoteViews remoteViews;
        String[] stringArray = toServiceMsg.extraData.getStringArray("cmds");
        if (stringArray.length != 3) {
            return null;
        }
        Bitmap bitmap2 = (Bitmap) toServiceMsg.extraData.getParcelable(MimeHelper.IMAGE_SUBTYPE_BITMAP);
        if (!wy2.d.f446755e) {
            wy2.c d16 = wy2.c.d();
            String str3 = stringArray[0];
            String str4 = stringArray[1];
            String str5 = stringArray[2];
            QQAppInterface qQAppInterface = this.f286090f;
            f16 = d16.g(intent, bitmap2, str3, str4, str5, false, qQAppInterface, qQAppInterface.isOpenNoClearNotification(), q());
            i3 = 0;
            bitmap = bitmap2;
            str = MimeHelper.IMAGE_SUBTYPE_BITMAP;
            strArr = stringArray;
            str2 = "cmds";
            intent2 = intent;
        } else if (wy2.d.f446763m) {
            String str6 = stringArray[0];
            String str7 = stringArray[1];
            String str8 = stringArray[2];
            i3 = 0;
            bitmap = bitmap2;
            str = MimeHelper.IMAGE_SUBTYPE_BITMAP;
            strArr = stringArray;
            str2 = "cmds";
            intent2 = intent;
            f16 = f(intent, null, str6, str7, str8);
            int androidInternalId = this.f286090f.getAndroidInternalId("icon");
            if (androidInternalId > 0 && (remoteViews = f16.contentView) != null) {
                remoteViews.setImageViewBitmap(androidInternalId, bitmap);
            }
        } else {
            i3 = 0;
            bitmap = bitmap2;
            str = MimeHelper.IMAGE_SUBTYPE_BITMAP;
            strArr = stringArray;
            str2 = "cmds";
            intent2 = intent;
            f16 = f(intent, bitmap, strArr[0], strArr[1], strArr[2]);
        }
        f16.deleteIntent = p(intent2);
        E();
        boolean isShowMsgContent = this.f286090f.isShowMsgContent();
        Intent intent3 = new Intent(QQAppInterface.BROADCAST_NEW_MESSAGE_NOFITY);
        intent3.setPackage("com.tencent.mobileqq");
        intent3.putExtra(str2, strArr);
        intent3.putExtra("intent", intent2);
        intent3.putExtra("type", i3);
        intent3.putExtra(str, bitmap);
        this.f286090f.getApp().sendBroadcast(intent3);
        xx.b.INSTANCE.B(isShowMsgContent, intent2);
        return f16;
    }

    void x(Intent intent, int i3) {
        if (i3 == 0 && intent.getBooleanExtra("key_reactive_push_tip", false)) {
            ReportController.o(this.f286090f, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 2, 0, "", "", "", "");
        }
    }

    public int y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        try {
            if (((IFeatureRuntimeService) this.f286090f.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("MOBILE_SERVICE_EXTEND_SET_MUTABLE_FLAG")) {
                return i3 | 67108864;
            }
        } catch (Exception e16) {
            QLog.e("MobileQQServiceWrapper", 1, "setMutableFlag", e16);
        }
        return i3;
    }
}
