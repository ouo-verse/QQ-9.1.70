package com.tencent.mobileqq.pushnotice.proxy;

import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.HmsProfile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class HuaWeiPushProcessor extends ThirdPushProcessorImpl {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements OnCompleteListener<Void> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f261385a;

        a(String str) {
            this.f261385a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HuaWeiPushProcessor.this, (Object) str);
            }
        }

        @Override // com.huawei.hmf.tasks.OnCompleteListener
        public void onComplete(Task<Void> task) {
            String message;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
                return;
            }
            if (task.isSuccessful()) {
                HuaWeiPushProcessor.this.f261390b = this.f261385a;
                QLog.d("HPush", 1, "add profileid sucess : " + HuaWeiPushProcessor.this.f261390b);
            } else {
                Exception exception = task.getException();
                if (exception == null) {
                    message = "null";
                } else {
                    message = exception.getMessage();
                }
                QLog.d("HPush", 1, "add profileid failed : " + message);
            }
            HuaWeiPushProcessor.this.u();
        }
    }

    public HuaWeiPushProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        o();
    }

    private void t() {
        try {
            boolean isSupportProfile = HmsProfile.getInstance(BaseApplication.getContext()).isSupportProfile();
            QLog.i("HPUSH", 1, "registerHuaweiPushTokenToServer :isSupportHmsProfileID=" + isSupportProfile);
            if (isSupportProfile) {
                r();
            } else {
                u();
            }
        } catch (Exception e16) {
            QLog.e("HPUSH", 1, "registerHuaweiPushTokenToServer : " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (TextUtils.isEmpty(k())) {
            ThreadManagerV2.newFreeThread(new Runnable() { // from class: com.tencent.mobileqq.pushnotice.proxy.HuaWeiPushProcessor.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) HuaWeiPushProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        QLog.d("HPush", 1, "HPush_Huawei getPush Token run : ");
                        BaseApplication context = BaseApplication.getContext();
                        if (MobileQQ.sProcessId == 1) {
                            HuaWeiPushProcessor.this.a(HmsInstanceId.getInstance(context).getToken(AGConnectServicesConfig.fromContext(context).getString("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE));
                            HuaWeiPushProcessor.this.o();
                            boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(context);
                            if (areNotificationsEnabled) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            ReportController.n(BaseApplicationImpl.getApplication().getRuntime(), "CliStatus", "", "", "0X800BAC8", "0X800BAC8", 0, 1, i3, String.valueOf(i3), "", "", "");
                            if (QLog.isColorLevel()) {
                                QLog.d("HPush", 2, "HPush_Huawei Push Token is not null: " + TextUtils.isEmpty(HuaWeiPushProcessor.this.k()), ",msgNotifyEnable = ", Boolean.valueOf(areNotificationsEnabled));
                            }
                        }
                    } catch (Exception e16) {
                        QLog.d("HPush", 1, "HPush_Huawei getPush Token : " + e16);
                    }
                }
            }, "huawei_push_token_get", 5).start();
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.pushnotice.proxy.a
            @Override // java.lang.Runnable
            public final void run() {
                HuaWeiPushProcessor.this.s();
            }
        }, 128, null, true);
        if (QLog.isColorLevel()) {
            QLog.d("HPush", 2, "HPush_Huawei Push Token-By not HmsInstanceId : ");
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f261389a = str;
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void b(Context context) {
        String channelId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        super.b(context);
        if (Build.VERSION.SDK_INT >= 26) {
            for (StatusBarNotification statusBarNotification : QQNotificationManager.getInstance().getActiveNotifications()) {
                channelId = statusBarNotification.getNotification().getChannelId();
                Integer valueOf = Integer.valueOf(statusBarNotification.getId());
                String packageName = statusBarNotification.getPackageName();
                String obj = ReflectionUtil.invokeMethodWithArgs(statusBarNotification, statusBarNotification.getClass().getName(), "getOpPkg", null, new Object[0]).toString();
                String key = statusBarNotification.getKey();
                if (obj.equals("com.huawei.android.pushagent") && channelId.equals(QQNotificationManager.CHANNEL_ID_SHOW_BADGE)) {
                    QQNotificationManager.getInstance().cancel("HPUSH", valueOf.intValue());
                    QLog.d("HPUSH", 1, "HPush_mChannelId = ", channelId, ", nId = ", valueOf, ",pkg = ", packageName, ",key = ", key, ",opPkg = ", obj);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return 3;
        }
        return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            t();
            j();
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl
    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            String md5 = MD5.toMD5(runtime.getCurrentUin());
            if (!TextUtils.isEmpty(md5)) {
                if (md5.length() > 8) {
                    md5 = md5.substring(0, 8);
                }
                HmsProfile.getInstance(BaseApplicationImpl.getApplication()).addProfile(2, md5).addOnCompleteListener(new a(md5));
            }
        }
    }
}
