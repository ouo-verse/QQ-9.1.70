package com.tencent.commonsdk.util.notification;

import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GroupChannelController {
    static IPatchRedirector $redirector_ = null;
    public static final boolean ENABLE_GROUP_CHANNEL = false;
    private static final String TAG = "GroupChannelController";

    public GroupChannelController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    void alignGroupChannelToOriginMessageChannel(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        int importance;
        boolean canShowBadge;
        Uri sound;
        AudioAttributes audioAttributes;
        boolean shouldVibrate;
        long[] vibrationPattern;
        int lightColor;
        boolean shouldShowLights;
        int lockscreenVisibility;
        boolean canBypassDnd;
        int importance2;
        AudioAttributes audioAttributes2;
        Uri sound2;
        boolean shouldVibrate2;
        long[] vibrationPattern2;
        boolean canShowBadge2;
        boolean canBypassDnd2;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "alignGroupChannelToOriginMessageChannel: invoked. ", " messageChannel: ", notificationChannel2, " groupChannel: ", notificationChannel);
        }
        if (notificationChannel != null && notificationChannel2 != null) {
            importance = notificationChannel2.getImportance();
            notificationChannel.setImportance(importance);
            canShowBadge = notificationChannel2.canShowBadge();
            notificationChannel.setShowBadge(canShowBadge);
            sound = notificationChannel2.getSound();
            audioAttributes = notificationChannel2.getAudioAttributes();
            notificationChannel.setSound(sound, audioAttributes);
            shouldVibrate = notificationChannel2.shouldVibrate();
            notificationChannel.enableVibration(shouldVibrate);
            vibrationPattern = notificationChannel2.getVibrationPattern();
            notificationChannel.setVibrationPattern(vibrationPattern);
            lightColor = notificationChannel2.getLightColor();
            notificationChannel.setLightColor(lightColor);
            shouldShowLights = notificationChannel2.shouldShowLights();
            notificationChannel.enableLights(shouldShowLights);
            lockscreenVisibility = notificationChannel2.getLockscreenVisibility();
            notificationChannel.setLockscreenVisibility(lockscreenVisibility);
            canBypassDnd = notificationChannel2.canBypassDnd();
            notificationChannel.setBypassDnd(canBypassDnd);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "alignGroupChannelToOriginMessageChannel: invoked. origin channel switch ", " \nimportance: ", Integer.valueOf(importance), " \naudioAttributes: ", audioAttributes, " \nsound: ", sound, " \nshouldVibrate: ", Boolean.valueOf(shouldVibrate), " \nvibrationPattern: ", vibrationPattern, " \nshowBadge: ", Boolean.valueOf(canShowBadge), " \nbypassDnd: ", Boolean.valueOf(canBypassDnd));
            }
            if (QLog.isColorLevel()) {
                importance2 = notificationChannel.getImportance();
                audioAttributes2 = notificationChannel.getAudioAttributes();
                sound2 = notificationChannel.getSound();
                shouldVibrate2 = notificationChannel.shouldVibrate();
                vibrationPattern2 = notificationChannel.getVibrationPattern();
                canShowBadge2 = notificationChannel.canShowBadge();
                canBypassDnd2 = notificationChannel.canBypassDnd();
                QLog.d(TAG, 2, "alignGroupChannelToOriginMessageChannel: invoked. group channel switch ", " \nimportance: ", Integer.valueOf(importance2), " \naudioAttributes: ", audioAttributes2, " \nsound: ", sound2, " \nshouldVibrate: ", Boolean.valueOf(shouldVibrate2), " \nvibrationPattern: ", vibrationPattern2, " \nshowBadge: ", Boolean.valueOf(canShowBadge2), " \nbypassDnd: ", Boolean.valueOf(canBypassDnd2));
            }
        }
    }
}
