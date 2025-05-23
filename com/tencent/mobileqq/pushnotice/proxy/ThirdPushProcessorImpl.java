package com.tencent.mobileqq.pushnotice.proxy;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecommon.processor.QZoneSwitchProcessor;
import com.tencent.mobileqq.pushnotice.ThirdPushNotifyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.online.push.pb.OnlinePushField$SetTokenReq;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class ThirdPushProcessorImpl implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final CharSequence f261387d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f261388e;

    /* renamed from: a, reason: collision with root package name */
    protected String f261389a;

    /* renamed from: b, reason: collision with root package name */
    protected String f261390b;

    /* renamed from: c, reason: collision with root package name */
    private String f261391c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74337);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f261387d = "\u65b0\u6d88\u606f\u901a\u77e5";
            f261388e = null;
        }
    }

    public ThirdPushProcessorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f261389a = "";
        this.f261390b = "";
        this.f261391c = "";
    }

    private void g(b bVar) {
        boolean z16;
        CharSequence charSequence;
        StatusBarNotification[] activeNotifications = QQNotificationManager.getInstance().getActiveNotifications();
        if (activeNotifications == null) {
            return;
        }
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            if (bVar != null && !bVar.a(statusBarNotification.getId())) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QQNotificationManager.getInstance().cancel("TPUSH", statusBarNotification.getId());
                QQNotificationManager.getInstance().cancelUseTag("TPUSH", statusBarNotification.getTag(), statusBarNotification.getId());
            }
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && (charSequence = notification.tickerText) != null) {
                charSequence.toString();
            }
            QLog.i("TPUSH", 1, "clearNotifications id=" + statusBarNotification.getId() + " clear=" + z16);
        }
    }

    private void h() {
        List notificationChannelGroups;
        boolean z16;
        NotificationChannel notificationChannel;
        String id5;
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 26) {
                QLog.i("TPUSH", 1, "createHuaWeiAVThirdPushNotificationChannel no supper v=" + i3);
                return;
            }
            NotificationManager notificationManager = (NotificationManager) BaseApplication.getContext().getSystemService("notification");
            notificationChannelGroups = notificationManager.getNotificationChannelGroups();
            if (notificationChannelGroups != null) {
                Iterator it = notificationChannelGroups.iterator();
                while (it.hasNext()) {
                    id5 = ((NotificationChannelGroup) it.next()).getId();
                    if (id5.equals("GROUP_ID_TOP")) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                notificationChannel = notificationManager.getNotificationChannel("CHANNEL_ID_THIRD_PUSH_QAV_MSG");
                if (notificationChannel != null) {
                    QLog.i("TPUSH", 1, "createHuaWeiAVThirdPushNotificationChannel no has CHANNEL_ID_THIRD_PUSH_MSG");
                    return;
                }
                NotificationChannel notificationChannel2 = new NotificationChannel("CHANNEL_ID_THIRD_PUSH_QAV_MSG", f261387d, 4);
                notificationChannel2.setShowBadge(true);
                notificationChannel2.setGroup("GROUP_ID_TOP");
                notificationChannel2.enableLights(true);
                notificationChannel2.enableVibration(true);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.setLockscreenVisibility(1);
                notificationChannel2.setBypassDnd(true);
                notificationChannel2.setSound(Uri.parse("android.resource://" + BaseApplication.getContext().getPackageName() + "/raw/" + R.raw.f169425es), new AudioAttributes.Builder().setContentType(1).setUsage(7).build());
                notificationChannel2.setVibrationPattern(new long[]{100, 600, 200, 400});
                QLog.i("TPUSH", 1, "createHuaWeiAVThirdPushNotificationChannel create sec");
                notificationManager.createNotificationChannel(notificationChannel2);
                return;
            }
            QLog.i("TPUSH", 1, "createHuaWeiAVThirdPushNotificationChannel no hasGroupCreated");
        } catch (Exception e16) {
            QLog.i("TPUSH", 1, "createHuaWeiAVThirdPushNotificationChannel", e16);
        }
    }

    private void i() {
        List notificationChannelGroups;
        boolean z16;
        NotificationChannel notificationChannel;
        String id5;
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 26) {
                QLog.i("TPUSH", 1, "createThirdPushNotificationChannel no supper v=" + i3);
                return;
            }
            NotificationManager notificationManager = (NotificationManager) BaseApplication.getContext().getSystemService("notification");
            notificationChannelGroups = notificationManager.getNotificationChannelGroups();
            if (notificationChannelGroups != null) {
                Iterator it = notificationChannelGroups.iterator();
                while (it.hasNext()) {
                    id5 = ((NotificationChannelGroup) it.next()).getId();
                    if (id5.equals("GROUP_ID_TOP")) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                notificationChannel = notificationManager.getNotificationChannel("CHANNEL_ID_THIRD_PUSH_MSG");
                if (notificationChannel != null) {
                    QLog.i("TPUSH", 1, "createThirdPushNotificationChannel no has CHANNEL_ID_THIRD_PUSH_MSG");
                    return;
                }
                NotificationChannel notificationChannel2 = new NotificationChannel("CHANNEL_ID_THIRD_PUSH_MSG", f261387d, 4);
                notificationChannel2.setShowBadge(true);
                notificationChannel2.setGroup("GROUP_ID_TOP");
                notificationChannel2.enableLights(true);
                notificationChannel2.enableVibration(true);
                notificationChannel2.setLightColor(-16711936);
                notificationChannel2.setLockscreenVisibility(0);
                notificationChannel2.setBypassDnd(true);
                notificationChannel2.setVibrationPattern(new long[]{100, 200, 200, 100});
                QLog.i("TPUSH", 1, "createThirdPushNotificationChannel create sec");
                notificationManager.createNotificationChannel(notificationChannel2);
                return;
            }
            QLog.i("TPUSH", 1, "createThirdPushNotificationChannel no hasGroupCreated");
        } catch (Exception e16) {
            QLog.i("TPUSH", 1, "createThirdPushNotificationChannel", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(int i3, String str) {
        QLog.d("TPUSH", 1, "uploadToken setTokenForMqq result=" + i3 + ", msg=" + str);
    }

    private static boolean n() {
        if (f261388e == null) {
            f261388e = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("third_push_clear_all_notifications_9130", false));
        }
        return f261388e.booleanValue();
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.c
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        this.f261389a = str;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ThirdPushProcessorImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ThirdPushProcessorImpl.this.o();
                    }
                }
            }, 128, null, false);
        } else {
            o();
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.c
    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
        } else {
            QLog.d("TPUSH", 1, "clearNotificationsBackground");
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.c
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.c
    public void e(Context context, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) bVar);
            return;
        }
        if (!l()) {
            return;
        }
        QLog.d("TPUSH", 1, "clearNotifications");
        if (n()) {
            QQNotificationManager.getInstance().cancelAll();
            return;
        }
        try {
            g(bVar);
        } catch (Exception e16) {
            QLog.w("TPUSH", 1, "[clearNotifications] exception:" + e16);
            QQNotificationManager.getInstance().cancelAll();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i("TPUSH", 1, "createThirdPushNotificationChannelByToggle app == null");
                return;
            }
            String string = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getString("third_push_set_chanel", "");
            if (TextUtils.isEmpty(string)) {
                QLog.i("TPUSH", 1, "createThirdPushNotificationChannelByToggle config isEmpty");
                return;
            }
            String valueOf = String.valueOf(c());
            QLog.i("TPUSH", 1, "createThirdPushNotificationChannelByToggle config =" + string + "\uff0cpushType=" + valueOf);
            if (string.contains(valueOf)) {
                i();
                if (c() == 3) {
                    h();
                }
            }
        } catch (Exception e16) {
            QLog.i("TPUSH", 1, "createThirdPushNotificationChannelByToggle", e16);
        }
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("TPUSH", 1, "getToken success:" + this.f261389a);
        }
        return this.f261389a;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        String k3 = k();
        synchronized (this) {
            if (!TextUtils.isEmpty(k3) && !k3.equals(this.f261391c)) {
                this.f261391c = k3;
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                ThirdPushNotifyManager.k(c(), BaseApplicationImpl.getApplication().getRuntime().getCurrentUin(), k3);
                if (qQAppInterface.isLogin()) {
                    String str = this.f261390b;
                    OnlinePushField$SetTokenReq onlinePushField$SetTokenReq = new OnlinePushField$SetTokenReq();
                    onlinePushField$SetTokenReq.uin.set(qQAppInterface.getLongAccountUin());
                    onlinePushField$SetTokenReq.new_token.set(ByteStringMicro.copyFromUtf8(k3));
                    if (!TextUtils.isEmpty(str)) {
                        onlinePushField$SetTokenReq.profile_id.set(ByteStringMicro.copyFromUtf8(str));
                    }
                    onlinePushField$SetTokenReq.enter_version.set(37);
                    onlinePushField$SetTokenReq.push_msg.set(1);
                    onlinePushField$SetTokenReq.push_qzone.set(QZoneSwitchProcessor.a(qQAppInterface.getCurrentUin()));
                    onlinePushField$SetTokenReq.group_pro_switch.set(((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab() ? 1 : 0);
                    onlinePushField$SetTokenReq.dev_type.set(DeviceInfoMonitor.getModel());
                    onlinePushField$SetTokenReq.os_version.set(Build.VERSION.RELEASE);
                    onlinePushField$SetTokenReq.vendor_type.set(c());
                    onlinePushField$SetTokenReq.notify_switch.set(SettingCloneUtil.readValue(qQAppInterface.getApplicationContext(), qQAppInterface.getCurrentUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true) ? 1 : 0);
                    onlinePushField$SetTokenReq.bind_uin_notify_switch.set(((ISubAccountService) qQAppInterface.getRuntimeService(ISubAccountService.class, "")).getNotifySwitch() ? 1 : 0);
                    onlinePushField$SetTokenReq.ios_version.set(Integer.parseInt(Build.VERSION.SDK));
                    w msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class)).getMsgService();
                    if (msgService != null) {
                        msgService.setTokenForMqq(onlinePushField$SetTokenReq.toByteArray(), new IOperateCallback() { // from class: com.tencent.mobileqq.pushnotice.proxy.e
                            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                            public final void onResult(int i3, String str2) {
                                ThirdPushProcessorImpl.m(i3, str2);
                            }
                        });
                    }
                    QLog.d("TPUSH", 1, "uploadToken sendThirdPartyTokenToServer profile_id=" + this.f261390b + " new_token=" + k3);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.c
    public void onLogout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            QLog.i("TPUSH", 1, "onLogout");
            this.f261391c = "";
        }
    }
}
