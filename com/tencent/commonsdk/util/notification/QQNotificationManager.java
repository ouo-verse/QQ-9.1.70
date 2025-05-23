package com.tencent.commonsdk.util.notification;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class QQNotificationManager {
    static IPatchRedirector $redirector_ = null;
    public static final String CHANNEL_ID_GROUP_MSG = "CHANNEL_ID_GROUP_MSG";
    public static final String CHANNEL_ID_HIDE_BADGE = "CHANNEL_ID_HIDE_BADGE";
    public static final String CHANNEL_ID_LIMIT_CHAT = "CHANNEL_ID_LIMIT_CHAT";
    public static final String CHANNEL_ID_OTHER = "CHANNEL_ID_OTHER";
    public static final String CHANNEL_ID_SHOW_BADGE = "CHANNEL_ID_SHOW_BADGE";
    private static final CharSequence CHANNEL_NAME_GROUP_MSG;
    private static final CharSequence CHANNEL_NAME_HIDE_BADGE;
    private static final CharSequence CHANNEL_NAME_LIMIT_CHAT;
    private static final CharSequence CHANNEL_NAME_OTHER;
    private static final CharSequence CHANNEL_NAME_SHOW_BADGE;
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    private static final String GROUP_ID_TOP = "GROUP_ID_TOP";
    private static final CharSequence GROUP_NAME_TOP;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    public static final String PARAM_FROMUIN = "param_fromuin";
    public static final String PARAM_NOTIFYID = "param_notifyid";
    public static final String PARAM_UINTYPE = "param_uinType";
    public static final String TAG = "QQNotification";
    private static QQNotificationManager s_instance;
    private HashMap<String, NotificationChannelGroup> mChannelGroups;
    private NotificationManager mLocalManager;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        GROUP_NAME_TOP = "\u6d88\u606f\u901a\u77e5";
        CHANNEL_NAME_SHOW_BADGE = "\u666e\u901a\u6d88\u606f";
        CHANNEL_NAME_HIDE_BADGE = "\u901a\u77e5\u680f\u663e\u793aQQ\u56fe\u6807";
        CHANNEL_NAME_LIMIT_CHAT = "\u6269\u5217\u6d88\u606f";
        CHANNEL_NAME_OTHER = "\u5176\u5b83\u901a\u77e5";
        CHANNEL_NAME_GROUP_MSG = "\u7fa4\u6d88\u606f";
    }

    QQNotificationManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLocalManager = null;
        this.mChannelGroups = new HashMap<>();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "create QQNotificationManager");
        }
        this.mLocalManager = (NotificationManager) BaseApplication.getContext().getSystemService("notification");
    }

    public static void addChannelIfNeed(Notification notification, String str) {
        String channelId;
        if (SdkInfoUtil.isOreo() && SdkInfoUtil.isTargetSDKOreo()) {
            channelId = notification.getChannelId();
            if (channelId == null) {
                try {
                    setProperty(notification, Notification.class, "mChannelId", str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    @Deprecated
    private void createNotificationChannel(String str, CharSequence charSequence, int i3, String str2, boolean z16) {
        List channels;
        boolean canShowBadge;
        if (!SdkInfoUtil.isOreo()) {
            return;
        }
        NotificationChannelGroup notificationChannelGroup = getNotificationChannelGroup(str2);
        if (notificationChannelGroup == null) {
            QLog.i(TAG, 2, "[createNotificationChannel] channelGroup not create, try create first. groupId=" + str2);
            createNotificationChannelGroup(str, GROUP_NAME_TOP);
            notificationChannelGroup = this.mChannelGroups.get(str2);
        }
        if (notificationChannelGroup == null) {
            QLog.i(TAG, 2, "[createNotificationChannel] channelGroup second create fail. groupId=" + str2);
            return;
        }
        if (getNotificationChannelFromGroup(notificationChannelGroup, str) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(str, charSequence, i3);
            notificationChannel.setShowBadge(z16);
            notificationChannel.setGroup(str2);
            if (i3 > 3) {
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.setLockscreenVisibility(0);
                notificationChannel.setBypassDnd(true);
                if (!CHANNEL_ID_SHOW_BADGE.equals(str) || Build.VERSION.SDK_INT > 28) {
                    notificationChannel.enableVibration(true);
                    notificationChannel.setVibrationPattern(new long[]{100, 200, 200, 100});
                } else {
                    notificationChannel.enableVibration(false);
                }
            }
            notificationChannel.setSound(null, null);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[createNotificationChannel] ");
                sb5.append(str);
                sb5.append("canShowBadge ");
                canShowBadge = notificationChannel.canShowBadge();
                sb5.append(canShowBadge);
                QLog.i(TAG, 2, sb5.toString());
            }
            CHANNEL_ID_GROUP_MSG.equals(str);
            this.mLocalManager.createNotificationChannel(notificationChannel);
            if (getNotificationChannelFromGroup(notificationChannelGroup, str2) == null) {
                channels = notificationChannelGroup.getChannels();
                channels.add(notificationChannel);
                QLog.d(TAG, 1, "[createNotificationChannel] initChannels: add to cache. groupId=" + str2 + ", id=" + str);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[createNotificationChannel] " + str + " has been create");
        }
    }

    @Deprecated
    private void createNotificationChannelGroup(String str, CharSequence charSequence) {
        if (SdkInfoUtil.isOreo()) {
            NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(str, charSequence);
            this.mChannelGroups.put(GROUP_ID_TOP, notificationChannelGroup);
            this.mLocalManager.createNotificationChannelGroup(notificationChannelGroup);
        }
    }

    public static QQNotificationManager getInstance() {
        if (s_instance == null) {
            synchronized (QQNotificationManager.class) {
                if (s_instance == null) {
                    s_instance = new QQNotificationManager();
                }
            }
        }
        return s_instance;
    }

    @Nullable
    @RequiresApi(api = 26)
    private NotificationChannel getNotificationChannel(@NonNull String str, @NonNull String str2) {
        NotificationChannelGroup notificationChannelGroup = getNotificationChannelGroup(str2);
        if (notificationChannelGroup != null) {
            return getNotificationChannelFromGroup(notificationChannelGroup, str);
        }
        return null;
    }

    @Nullable
    @RequiresApi(api = 26)
    private NotificationChannel getNotificationChannelFromGroup(@NonNull NotificationChannelGroup notificationChannelGroup, @NonNull String str) {
        List<NotificationChannel> channels;
        String id5;
        channels = notificationChannelGroup.getChannels();
        for (NotificationChannel notificationChannel : channels) {
            id5 = notificationChannel.getId();
            if (str.equals(id5)) {
                return notificationChannel;
            }
        }
        return null;
    }

    @Nullable
    @RequiresApi(api = 26)
    private NotificationChannelGroup getNotificationChannelGroup(String str) {
        List<NotificationChannelGroup> notificationChannelGroups;
        String id5;
        NotificationChannelGroup notificationChannelGroup = this.mChannelGroups.get(str);
        if (notificationChannelGroup == null) {
            QLog.i(TAG, 2, "[getNotificationChannelGroup] no channelGroup on cache, try find on Service. groupId=" + str);
            notificationChannelGroups = this.mLocalManager.getNotificationChannelGroups();
            if (notificationChannelGroups != null) {
                for (NotificationChannelGroup notificationChannelGroup2 : notificationChannelGroups) {
                    this.mChannelGroups.put(str, notificationChannelGroup2);
                    id5 = notificationChannelGroup2.getId();
                    if (id5.equals(str)) {
                        notificationChannelGroup = notificationChannelGroup2;
                    }
                }
            }
        }
        return notificationChannelGroup;
    }

    private void initChannels() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initChannels");
        }
        if (SdkInfoUtil.isOreo()) {
            createNotificationChannel(CHANNEL_ID_SHOW_BADGE, CHANNEL_NAME_SHOW_BADGE, 4, GROUP_ID_TOP, true);
            SdkInfoUtil.isAndroidQ();
            createNotificationChannel(CHANNEL_ID_OTHER, CHANNEL_NAME_OTHER, 4, GROUP_ID_TOP, false);
            createNotificationChannel(CHANNEL_ID_HIDE_BADGE, CHANNEL_NAME_HIDE_BADGE, 2, GROUP_ID_TOP, false);
        }
    }

    private void initGroup() {
        createNotificationChannelGroup(GROUP_ID_TOP, GROUP_NAME_TOP);
    }

    private synchronized void initManager() {
        initGroup();
        initChannels();
    }

    public static void setProperty(Object obj, Class cls, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public boolean areNotificationsEnabled(Context context) {
        boolean areNotificationsEnabled;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context)).booleanValue();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            areNotificationsEnabled = this.mLocalManager.areNotificationsEnabled();
            return areNotificationsEnabled;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i3 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, (Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class), Integer.valueOf(i3), packageName)).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public boolean c2cChannelVibrateOn() {
        boolean shouldVibrate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (!SdkInfoUtil.isAndroidQ()) {
            return false;
        }
        NotificationChannel notificationChannel = getNotificationChannel(GROUP_ID_TOP, CHANNEL_ID_SHOW_BADGE);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "c2cChannelVibrateOn: invoked. ", " channel: ", notificationChannel);
        }
        if (notificationChannel != null) {
            shouldVibrate = notificationChannel.shouldVibrate();
            return shouldVibrate;
        }
        return false;
    }

    public void cancel(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, str + " cancel id:" + i3);
        }
        NotificationManager notificationManager = this.mLocalManager;
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
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "clearAll");
        }
        NotificationManager notificationManager = this.mLocalManager;
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
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, str + " cancel UseTag:" + str2 + " id:" + i3);
        }
        NotificationManager notificationManager = this.mLocalManager;
        if (notificationManager != null) {
            notificationManager.cancel(str2, i3);
        }
    }

    @Deprecated
    public void createLimitChatNotificationChannel() {
        List channels;
        boolean canShowBadge;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (!SdkInfoUtil.isOreo()) {
            return;
        }
        NotificationChannelGroup notificationChannelGroup = getNotificationChannelGroup(GROUP_ID_TOP);
        if (notificationChannelGroup == null) {
            QLog.i(TAG, 2, "[createLimitChatNotificationChannel] channelGroup not create, try create first");
            createNotificationChannelGroup(GROUP_ID_TOP, GROUP_NAME_TOP);
            notificationChannelGroup = this.mChannelGroups.get(GROUP_ID_TOP);
        }
        if (notificationChannelGroup == null) {
            QLog.i(TAG, 2, "[createLimitChatNotificationChannel] channelGroup second create fail");
            return;
        }
        if (getNotificationChannelFromGroup(notificationChannelGroup, CHANNEL_ID_LIMIT_CHAT) != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[createLimitChatNotificationChannel] channel has been create");
                return;
            }
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID_LIMIT_CHAT, CHANNEL_NAME_LIMIT_CHAT, 4);
        notificationChannel.setShowBadge(false);
        notificationChannel.setGroup(GROUP_ID_TOP);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setLockscreenVisibility(0);
        notificationChannel.setBypassDnd(true);
        notificationChannel.setVibrationPattern(new long[]{100, 200, 200, 100});
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[createLimitChatNotificationChannel] canShowBadge ");
            canShowBadge = notificationChannel.canShowBadge();
            sb5.append(canShowBadge);
            QLog.i(TAG, 2, sb5.toString());
        }
        this.mLocalManager.createNotificationChannel(notificationChannel);
        if (getNotificationChannelFromGroup(notificationChannelGroup, GROUP_ID_TOP) == null) {
            channels = notificationChannelGroup.getChannels();
            channels.add(notificationChannel);
            QLog.d(TAG, 1, "[createLimitChatNotificationChannel] initChannels: add to cache");
        }
    }

    public Bundle createNotifyBundle(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bundle) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
        }
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_NOTIFYID, i3);
        if (!TextUtils.isEmpty(str) && i16 != -1) {
            bundle.putString(PARAM_FROMUIN, str);
            bundle.putInt(PARAM_UINTYPE, i16);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "invalid notifyBundleparam notify DontUseTag notifyId:" + i3 + " fromUin:" + str + " uinType:" + i16);
        }
        return bundle;
    }

    public StatusBarNotification[] getActiveNotifications() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (StatusBarNotification[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        NotificationManager notificationManager = this.mLocalManager;
        if (notificationManager != null) {
            return notificationManager.getActiveNotifications();
        }
        return new StatusBarNotification[0];
    }

    public boolean groupChannelVibrateOn() {
        boolean shouldVibrate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (!SdkInfoUtil.isAndroidQ()) {
            return false;
        }
        NotificationChannel notificationChannel = getNotificationChannel(GROUP_ID_TOP, CHANNEL_ID_GROUP_MSG);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "groupChannelVibrateOn: invoked. ", " channel: ", notificationChannel);
        }
        if (notificationChannel != null) {
            shouldVibrate = notificationChannel.shouldVibrate();
            return shouldVibrate;
        }
        return false;
    }

    public boolean isIdValid(String str, int i3) {
        boolean z16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3)).booleanValue();
        }
        if ((i3 >= 232 && i3 <= 3001549) || (i3 >= 268435456 && i3 <= 536870911)) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str3 = "Valid";
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append(" notify id:");
            sb5.append(i3);
            sb5.append(" is ");
            if (z16) {
                str2 = "Valid";
            } else {
                str2 = "InValid";
            }
            sb5.append(str2);
            QLog.i(TAG, 2, sb5.toString());
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str);
            sb6.append(" studymode_fight.notify id:");
            sb6.append(i3);
            sb6.append(" is ");
            if (!z16) {
                str3 = "InValid";
            }
            sb6.append(str3);
            QLog.i(TAG, 2, sb6.toString());
        }
        return z16;
    }

    public void notify(String str, int i3, Notification notification) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), notification);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, str + " notify1 DontUseTag id:" + i3 + " " + notification);
        }
        if (this.mLocalManager != null && isIdValid(str, i3) && NotificationLimiterUtil.shouldNotify(i3)) {
            NotificationReportUtil.reportNotification(i3, "", -1);
            this.mLocalManager.notify(i3, notification);
        }
    }

    public void notifyUseTag(String str, String str2, Notification notification, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, notification, bundle);
            return;
        }
        if (this.mLocalManager != null) {
            int i3 = bundle.getInt(PARAM_NOTIFYID, -1);
            String string = bundle.getString(PARAM_FROMUIN, "");
            int i16 = bundle.getInt(PARAM_UINTYPE, -1);
            if (isIdValid(str, i3) && NotificationLimiterUtil.shouldNotify(i3)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, str + " notify3 UseTag:" + str2 + " notifyId:" + i3 + " notification:" + notification);
                }
                NotificationReportUtil.reportNotification(i3, string, i16);
                this.mLocalManager.notify(str2, i3, notification);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, str + " NotificationManager is null.");
        }
    }

    public void notify(String str, Notification notification, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, notification, bundle);
            return;
        }
        if (this.mLocalManager != null) {
            int i3 = bundle.getInt(PARAM_NOTIFYID, -1);
            String string = bundle.getString(PARAM_FROMUIN, "");
            int i16 = bundle.getInt(PARAM_UINTYPE, -1);
            if (isIdValid(str, i3) && NotificationLimiterUtil.shouldNotify(i3)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, str + " notify2 DontUseTag notifyId:" + i3 + " " + notification);
                }
                NotificationReportUtil.reportNotification(i3, string, i16);
                this.mLocalManager.notify(i3, notification);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, str + " NotificationManager is null.");
        }
    }
}
