package com.tencent.mobileqq.msf.sdk;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public final class QNotificationManager {
    static IPatchRedirector $redirector_ = null;
    public static final String CHANNEL_ID_OFFLINEMSG = "CHANNEL_ID_OFFLINEMSG";
    public static final String CHANNEL_ID_OTHER = "CHANNEL_ID_MSF";
    private static final CharSequence CHANNEL_NAME_OFFLINEMSG;
    private static final CharSequence CHANNEL_NAME_OTHER;
    private static final String GROUP_ID_TOP = "GROUP_ID_TOP";
    private static final CharSequence GROUP_NAME_TOP;
    public static final String TAG = "QNotificationMsf";
    private NotificationManager localManager;
    private HashMap<String, NotificationChannelGroup> mChannelGroups;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23122);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        GROUP_NAME_TOP = "\u6d88\u606f\u901a\u77e5";
        CHANNEL_NAME_OTHER = "\u5176\u5b83\u901a\u77e5";
        CHANNEL_NAME_OFFLINEMSG = "\u79bb\u7ebf\u6d88\u606f";
    }

    public QNotificationManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.localManager = null;
        this.mChannelGroups = new HashMap<>();
        this.localManager = (NotificationManager) context.getSystemService("notification");
        initOreo(context);
    }

    @Deprecated
    private void createNotificationChannelGroup(String str, CharSequence charSequence) {
        if (isOreo()) {
            NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(str, charSequence);
            this.mChannelGroups.put(GROUP_ID_TOP, notificationChannelGroup);
            this.localManager.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public static boolean isOreo() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static void setProperty(Object obj, Class cls, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public void addChannelIfNeed(Notification notification) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            addChannelIfNeed(notification, CHANNEL_ID_OTHER);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) notification);
        }
    }

    public void cancel(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
            return;
        }
        QLog.i(TAG, 1, str + " cancel id:" + i3);
        NotificationManager notificationManager = this.localManager;
        if (notificationManager != null) {
            notificationManager.cancel(i3);
        }
    }

    public void cancelAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.i(TAG, 1, "clearAll");
        NotificationManager notificationManager = this.localManager;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    public void cancelUseTag(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, Integer.valueOf(i3));
            return;
        }
        QLog.i(TAG, 1, str + " cancel UseTag:" + str2 + " id:" + i3);
        NotificationManager notificationManager = this.localManager;
        if (notificationManager != null) {
            notificationManager.cancel(str2, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createNotificationChannel(String str, CharSequence charSequence, int i3, String str2, boolean z16) {
        List notificationChannelGroups;
        boolean z17;
        NotificationChannel notificationChannel;
        boolean canShowBadge;
        String id5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, charSequence, Integer.valueOf(i3), str2, Boolean.valueOf(z16));
            return;
        }
        if (isOreo()) {
            notificationChannelGroups = this.localManager.getNotificationChannelGroups();
            if (notificationChannelGroups != null) {
                Iterator it = notificationChannelGroups.iterator();
                if (it.hasNext()) {
                    id5 = ((NotificationChannelGroup) it.next()).getId();
                    id5.equals(str2);
                    z17 = true;
                    if (!z17 && QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "please create NotificationChannelGroup First, create NotificationChannelGroup with id " + str2);
                    }
                    notificationChannel = this.localManager.getNotificationChannel(str);
                    if (notificationChannel == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "NotificationChannel " + str + " has been create");
                            return;
                        }
                        return;
                    }
                    NotificationChannel notificationChannel2 = new NotificationChannel(str, charSequence, i3);
                    notificationChannel2.setShowBadge(z16);
                    notificationChannel2.setGroup(str2);
                    if (i3 > 3) {
                        notificationChannel2.enableLights(true);
                        notificationChannel2.enableVibration(true);
                        notificationChannel2.setLightColor(-16711936);
                        notificationChannel2.setLockscreenVisibility(0);
                        notificationChannel2.setBypassDnd(true);
                        notificationChannel2.setVibrationPattern(new long[]{100});
                    }
                    notificationChannel2.setSound(null, null);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("NotificationChannel ");
                        sb5.append(str);
                        sb5.append("canShowBadge ");
                        canShowBadge = notificationChannel2.canShowBadge();
                        sb5.append(canShowBadge);
                        QLog.i(TAG, 2, sb5.toString());
                    }
                    this.localManager.createNotificationChannel(notificationChannel2);
                    return;
                }
            }
            z17 = false;
            if (!z17) {
                QLog.i(TAG, 2, "please create NotificationChannelGroup First, create NotificationChannelGroup with id " + str2);
            }
            notificationChannel = this.localManager.getNotificationChannel(str);
            if (notificationChannel == null) {
            }
        }
    }

    public NotificationManager getNotificationManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (NotificationManager) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.localManager;
    }

    public void initOreo(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else if (isOreo() && context.getApplicationContext().getApplicationInfo().targetSdkVersion >= 26) {
            createNotificationChannelGroup(GROUP_ID_TOP, GROUP_NAME_TOP);
            createNotificationChannel(CHANNEL_ID_OTHER, CHANNEL_NAME_OTHER, 3, GROUP_ID_TOP, false);
            createNotificationChannel(CHANNEL_ID_OFFLINEMSG, CHANNEL_NAME_OFFLINEMSG, 3, GROUP_ID_TOP, false);
        }
    }

    public void notify(String str, int i3, Notification notification) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), notification);
            return;
        }
        addChannelIfNeed(notification);
        QLog.i(TAG, 1, str + " notify DontUseTag id:" + i3 + " " + notification);
        NotificationManager notificationManager = this.localManager;
        if (notificationManager != null) {
            notificationManager.notify(i3, notification);
        }
    }

    public void notifyUseTag(String str, String str2, int i3, Notification notification) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, Integer.valueOf(i3), notification);
            return;
        }
        addChannelIfNeed(notification);
        QLog.i(TAG, 1, str + " notify UseTag:" + str2 + " id:" + i3 + " " + notification);
        NotificationManager notificationManager = this.localManager;
        if (notificationManager != null) {
            notificationManager.notify(str2, i3, notification);
        }
    }

    public void addChannelIfNeed(Notification notification, CharSequence charSequence) {
        String channelId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) notification, (Object) charSequence);
            return;
        }
        if (!isOreo() || BaseApplication.getContext().getApplicationInfo().targetSdkVersion < 26) {
            return;
        }
        channelId = notification.getChannelId();
        if (channelId == null) {
            try {
                setProperty(notification, Notification.class, "mChannelId", charSequence);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
