package com.tencent.commonsdk.util.notification;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NotificationFactory {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NotificationFactory";

    public NotificationFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Notification createNotification(String str, int i3, CharSequence charSequence, long j3) {
        Notification.Builder builder;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("createNotification:String channel ");
            sb5.append(str);
            sb5.append(", int icon ");
            sb5.append(i3);
            sb5.append(", CharSequence tickerText ");
            sb5.append(charSequence);
            sb5.append(", long when");
            sb5.append(j3);
            QLog.d(TAG, 2, sb5);
        }
        if (SdkInfoUtil.isOreo()) {
            if (str.isEmpty()) {
                builder = new Notification.Builder(BaseApplication.getContext());
            } else {
                builder = new Notification.Builder(BaseApplication.getContext(), str);
            }
            builder.setSmallIcon(i3).setTicker(charSequence).setWhen(j3);
            return builder.build();
        }
        return new Notification(i3, charSequence, j3);
    }

    public static Notification.Builder createNotificationBuilder(String str) {
        if (SdkInfoUtil.isOreo()) {
            if (str.isEmpty()) {
                return new Notification.Builder(BaseApplication.getContext());
            }
            return new Notification.Builder(BaseApplication.context, str);
        }
        return new Notification.Builder(BaseApplication.getContext());
    }

    public static NotificationCompat.Builder createNotificationCompatBuilder(String str) {
        if (SdkInfoUtil.isOreo()) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(BaseApplication.getContext());
            if (!str.isEmpty()) {
                builder.setChannelId(str);
                return builder;
            }
            return builder;
        }
        return new NotificationCompat.Builder(BaseApplication.getContext());
    }
}
