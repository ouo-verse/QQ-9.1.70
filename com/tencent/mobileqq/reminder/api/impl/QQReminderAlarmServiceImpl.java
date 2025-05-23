package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.api.IQQReminderAlarmService;
import com.tencent.mobileqq.reminder.biz.QQReminderAlarmReceiver;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderAlarmServiceImpl implements IQQReminderAlarmService {
    static IPatchRedirector $redirector_ = null;
    public static final String NOTIFICATION_ALRAM_ACTION = "notification_alram_action";
    public static final String SP_KEY_ALRMAIDS = "sp_key_alarmids";
    private static final String TAG = "ActivateFriends.Manager";
    private CopyOnWriteArraySet<String> mAlarmIds;
    private AlarmManager mAlarmManager;
    private AppRuntime mApp;
    private Context mContext;
    private boolean mIsRegistered;
    private QQReminderAlarmReceiver mReminderAlarmReceiver;
    private SharedPreferences pref;

    public QQReminderAlarmServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsRegistered = false;
        }
    }

    private void registAlarmBroadcastReceiver() {
        if (this.mReminderAlarmReceiver == null) {
            this.mReminderAlarmReceiver = new QQReminderAlarmReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NOTIFICATION_ALRAM_ACTION);
        try {
            this.mContext.registerReceiver(this.mReminderAlarmReceiver, intentFilter);
            this.mIsRegistered = true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "register QQReminderAlarmReceiver failed!!!!\n", e16);
        }
    }

    private void unRegistAlarmBroadcastReceiver() {
        QQReminderAlarmReceiver qQReminderAlarmReceiver = this.mReminderAlarmReceiver;
        if (qQReminderAlarmReceiver != null && this.mIsRegistered) {
            try {
                this.mContext.unregisterReceiver(qQReminderAlarmReceiver);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "unregister QQReminderAlarmReceiver failed!!!!\n", e16);
            }
        }
        this.mIsRegistered = false;
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderAlarmService
    public void cancelAlarmById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cancelAlarmById alarmId: " + i3);
            }
            String valueOf = String.valueOf(i3);
            if (this.mAlarmIds.contains(valueOf)) {
                this.mAlarmIds.remove(valueOf);
            }
            this.pref.edit().putStringSet(SP_KEY_ALRMAIDS + this.mApp.getAccount(), this.mAlarmIds).apply();
            Intent intent = new Intent();
            intent.setAction(NOTIFICATION_ALRAM_ACTION);
            this.mAlarmManager.cancel(PendingIntent.getBroadcast(this.mContext, i3, intent, 33554432));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "cancelAlarmById throw an exceptio: " + th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderAlarmService
    public void clearAllAlarm() {
        CopyOnWriteArraySet<String> copyOnWriteArraySet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            if (!this.pref.getStringSet(SP_KEY_ALRMAIDS + this.mApp.getAccount(), new HashSet()).isEmpty() && (copyOnWriteArraySet = this.mAlarmIds) != null) {
                Iterator<String> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    cancelAlarmById(Integer.parseInt(it.next()));
                }
            }
            CopyOnWriteArraySet<String> copyOnWriteArraySet2 = this.mAlarmIds;
            if (copyOnWriteArraySet2 != null && !copyOnWriteArraySet2.isEmpty()) {
                this.mAlarmIds.clear();
            }
            this.pref.edit().remove(SP_KEY_ALRMAIDS + this.mApp.getAccount()).apply();
        } catch (Exception e16) {
            QLog.e(TAG, 2, "clearAllAlarm throw an exception: " + e16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ActivateFriends.Manager--onCreate---");
        }
        this.mAlarmIds = new CopyOnWriteArraySet<>();
        this.mApp = appRuntime;
        this.pref = appRuntime.getApplicationContext().getSharedPreferences(QQConstants.PREF_ACTIVATE_FRIENDS + this.mApp.getAccount(), 0);
        Context applicationContext = this.mApp.getApplicationContext();
        this.mContext = applicationContext;
        this.mAlarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        registAlarmBroadcastReceiver();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "ActivateFriends.Manager--onDestroy---");
        }
        unRegistAlarmBroadcastReceiver();
        clearAllAlarm();
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQReminderAlarmService
    public void setAlarmTimer(AcsMsg acsMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) acsMsg);
            return;
        }
        if (acsMsg != null && acsMsg.type != 1) {
            try {
                long j3 = acsMsg.notice_time * 1000;
                int hashCode = acsMsg.msg_id.hashCode();
                String str = acsMsg.title;
                if (j3 > NetConnInfoCenter.getServerTimeMillis()) {
                    String valueOf = String.valueOf(hashCode);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "setAlarmTimer at " + QQReminderUtil.o(j3, "yyyyMMdd HH:mm:ss") + " msg: " + str + " alarmId: " + hashCode);
                    }
                    if (!this.mAlarmIds.contains(valueOf)) {
                        this.mAlarmIds.add(valueOf);
                        this.pref.edit().putStringSet(SP_KEY_ALRMAIDS + this.mApp.getAccount(), this.mAlarmIds).apply();
                    }
                    Intent intent = new Intent();
                    intent.setAction(NOTIFICATION_ALRAM_ACTION);
                    intent.putExtra("msg", str);
                    intent.putExtra("msg_id", QQReminderUtil.p(acsMsg));
                    PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, hashCode, intent, 33554432);
                    AlarmManager alarmManager = this.mAlarmManager;
                    if (alarmManager != null) {
                        alarmManager.setExactAndAllowWhileIdle(0, j3, broadcast);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "has already setAlarmTimer at " + QQReminderUtil.o(j3, "yyyyMMdd HH:mm:ss"));
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "setAlarmTimer throw an exceptio: " + th5);
                }
            }
        }
    }
}
