package com.tencent.mobileqq.security;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final LinkedList<Integer> f285276a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21995);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f285276a = new LinkedList<>();
        }
    }

    private static synchronized boolean a(int i3) {
        synchronized (a.class) {
            LinkedList<Integer> linkedList = f285276a;
            if (linkedList.contains(Integer.valueOf(i3))) {
                return false;
            }
            linkedList.add(Integer.valueOf(i3));
            if (linkedList.size() > 5) {
                linkedList.removeFirst();
            }
            return true;
        }
    }

    public static void b(int i3, String str, String str2) {
        if (!a(i3)) {
            if (QLog.isColorLevel()) {
                QLog.i("LoginOnlinePushHandler", 2, "is duplicate msg seq " + i3);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.i("LoginOnlinePushHandler", 2, "receive push, show notification seq=" + i3);
            }
            c(BaseApplication.getContext(), str, str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LoginOnlinePushHandler", 2, "push title or content is null");
        }
    }

    private static void c(Context context, String str, String str2) {
        try {
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), context.getPackageName());
            if (launchIntentForPackage == null) {
                QLog.w("LoginOnlinePushHandler", 1, "showNotification launch intent is null");
                return;
            }
            Notification build = NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_OTHER).setSmallIcon(R.drawable.b8f).setAutoCancel(true).setWhen(System.currentTimeMillis()).setContentTitle(str).setContentText(str2).setContentIntent(PendingIntent.getActivity(context, 0, launchIntentForPackage, 201326592)).build();
            QQNotificationManager.addChannelIfNeed(build, QQNotificationManager.CHANNEL_ID_OTHER);
            QQNotificationManager.getInstance().cancel("LoginOnlinePushHandler", 264);
            QQNotificationManager.getInstance().notify("LoginOnlinePushHandler", 264, build);
        } catch (Exception e16) {
            QLog.w("LoginOnlinePushHandler", 1, "show notification exception", e16);
        }
    }
}
