package com.tencent.mobileqq.matchfriend.voicechat;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.voicechat.api.IVoiceChatApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.activity.QPublicTransFragmentActivityForQQStranger;
import mqq.app.AppService;

/* compiled from: P */
/* loaded from: classes15.dex */
public class VoiceChatService extends AppService {
    static IPatchRedirector $redirector_;

    public VoiceChatService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void r() {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), QPublicTransFragmentActivityForQQStranger.class);
        ((IVoiceChatApi) QRoute.api(IVoiceChatApi.class)).setRestoreVoiceChatIntent(intent);
        startForeground(NotificationUtil.Constants.NOTIFY_ID_MATCH_FRIEND_VOICE_CHAT, NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_OTHER).setSmallIcon(R.drawable.icon).setAutoCancel(true).setOngoing(true).setWhen(System.currentTimeMillis()).setContentTitle(getResources().getString(R.string.f1644225s)).setContentText(getResources().getString(R.string.f1644125r)).setContentIntent(PendingIntent.getActivity(this.app.getApplicationContext(), 0, intent, 167772160)).build());
    }

    public static void s(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) VoiceChatService.class);
        intent.putExtra("key_is_foreground", true);
        context.startService(intent);
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onCreate();
            QLog.i("VoiceChatService", 1, "onCreate");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.i("VoiceChatService", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, intent, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        QLog.i("VoiceChatService", 1, "onStartCommand");
        super.onStartCommand(intent, i3, i16);
        if (intent != null && intent.getBooleanExtra("key_is_preload", false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 2;
        }
        if (intent != null && intent.getBooleanExtra("key_is_foreground", false)) {
            z17 = true;
        }
        if (z17) {
            r();
        } else {
            stopForeground(true);
        }
        return 2;
    }
}
