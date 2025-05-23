package com.tencent.mobileqq.vashealth.api.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.vashealth.StepAlarmReceiver;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.mobileqq.vashealth.step.SportEventManager;
import com.tencent.mobileqq.vashealth.step.k;
import com.tencent.mobileqq.vashealth.u;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import g43.HealthTimerConfigData;
import java.util.Calendar;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SportManagerImpl implements ISportManager {
    static final int MAX_CALLBACK_VALUE = 99999999;
    public static final int MSG_REPORT = 1;
    public static final String TAG = "SportManager";
    static SensorManager sSensorManager = null;
    public static boolean sStepSensorEnable = false;
    Handler mHandler;
    StepAlarmReceiver mStepAlarmReceiver;
    int mTimer2ReportTimes;
    PendingIntent mReportIntent1 = null;
    PendingIntent mReportIntent2 = null;
    PendingIntent mReportIntentMorning = null;
    public AlarmManager mAlarmManager = null;
    long lastCallRefresh = 0;
    BusinessObserver mRefreshStepsObserver = new BusinessObserver() { // from class: com.tencent.mobileqq.vashealth.api.impl.SportManagerImpl.3
        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, final Bundle bundle) {
            if (!z16) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.api.impl.SportManagerImpl.3.1
                @Override // java.lang.Runnable
                public void run() {
                    SSOHttpUtils.u(MobileQQ.sMobileQQ.peekAppRuntime(), bundle);
                }
            }, 128, null, true);
        }
    };
    Handler.Callback mCallBack = new b();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements Handler.Callback {
        b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            HealthTimerConfigData healthTimerConfigData = (HealthTimerConfigData) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100505");
            int timer2Interval = healthTimerConfigData.getTimer2Interval();
            int timer2RetryTimes = healthTimerConfigData.getTimer2RetryTimes();
            if (SSOHttpUtils.f312185c != 0 && NetConnInfoCenter.getServerTimeMillis() - SSOHttpUtils.f312185c >= timer2Interval) {
                if (SportManagerImpl.this.mTimer2ReportTimes >= timer2RetryTimes) {
                    QLog.i(SportManagerImpl.TAG, 2, "retry time enough cancel task.");
                    SportManagerImpl.this.mHandler.removeCallbacksAndMessages(null);
                    return true;
                }
                int timer2StartHour = healthTimerConfigData.getTimer2StartHour();
                int timer2EndHour = healthTimerConfigData.getTimer2EndHour();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
                int i3 = calendar.get(11);
                if (i3 >= timer2StartHour) {
                    SportManagerImpl sportManagerImpl = SportManagerImpl.this;
                    sportManagerImpl.mTimer2ReportTimes++;
                    sportManagerImpl.refreshCurrentStep("timer2 callback report1");
                } else if (i3 < timer2EndHour) {
                    calendar.set(11, 0);
                    calendar.set(12, 0);
                    calendar.set(13, 0);
                    calendar.set(14, 0);
                    if (SSOHttpUtils.f312185c - calendar.getTimeInMillis() > 0) {
                        QLog.i(SportManagerImpl.TAG, 2, "already report cancel task.");
                        SportManagerImpl.this.mHandler.removeCallbacksAndMessages(null);
                        return true;
                    }
                    SportManagerImpl sportManagerImpl2 = SportManagerImpl.this;
                    sportManagerImpl2.mTimer2ReportTimes++;
                    sportManagerImpl2.refreshCurrentStep("timer2 callback report2");
                } else {
                    QLog.i(SportManagerImpl.TAG, 2, "over time cancel task.");
                    SportManagerImpl.this.mHandler.removeCallbacksAndMessages(null);
                    return true;
                }
                SportManagerImpl.this.mHandler.sendEmptyMessageDelayed(1, timer2Interval + 2000);
                return true;
            }
            SportManagerImpl.this.mHandler.sendEmptyMessageDelayed(1, timer2Interval);
            return true;
        }
    }

    @NotNull
    private SensorEventListener getSensorEventListener(int i3, int i16, long j3) {
        return new a(j3, i3, i16);
    }

    public static boolean isSupportStepCounter(Context context) {
        if (sStepSensorEnable) {
            return true;
        }
        if (sSensorManager == null) {
            sSensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        if (SensorMonitor.getDefaultSensor(sSensorManager, 19) != null) {
            sStepSensorEnable = true;
            return true;
        }
        return false;
    }

    private void setTimer(Long l3, PendingIntent pendingIntent) {
        AlarmManager alarmManager = this.mAlarmManager;
        if (alarmManager == null) {
            return;
        }
        try {
            alarmManager.set(1, l3.longValue(), pendingIntent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "setTimer failed\uff0c error is " + e16);
        }
    }

    public void cancelTimer() {
        AlarmManager alarmManager = this.mAlarmManager;
        if (alarmManager == null) {
            return;
        }
        PendingIntent pendingIntent = this.mReportIntentMorning;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
            this.mReportIntentMorning = null;
        }
        PendingIntent pendingIntent2 = this.mReportIntent1;
        if (pendingIntent2 != null) {
            this.mAlarmManager.cancel(pendingIntent2);
            this.mReportIntent1 = null;
        }
        PendingIntent pendingIntent3 = this.mReportIntent2;
        if (pendingIntent3 != null) {
            this.mAlarmManager.cancel(pendingIntent3);
            this.mReportIntent2 = null;
        }
        this.mAlarmManager = null;
    }

    @Override // com.tencent.mobileqq.vashealth.api.ISportManager
    public void doOnLogin() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            if (this.mStepAlarmReceiver == null) {
                this.mStepAlarmReceiver = new StepAlarmReceiver(peekAppRuntime);
            }
            Context applicationContext = peekAppRuntime.getApplication().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_sport_timer1");
            intentFilter.addAction("action_sport_timer2");
            intentFilter.addAction(StepCounterConstants.ACTION_SSO_STEP_REPORT);
            intentFilter.addAction(IECScreenReceiver.ACTION_QQ_FOREGROUND);
            intentFilter.addAction("action_sport_timer_morning");
            try {
                applicationContext.registerReceiver(this.mStepAlarmReceiver, intentFilter);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "registerReceiver error", e16);
            }
            HealthTimerConfigData healthTimerConfigData = (HealthTimerConfigData) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100505");
            if (healthTimerConfigData != null && healthTimerConfigData.getConfigReady()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intent intent = new Intent("action_sport_timer1");
                Intent intent2 = new Intent("action_sport_timer2");
                Intent intent3 = new Intent("action_sport_timer_morning");
                if (this.mReportIntent1 == null) {
                    this.mReportIntent1 = PendingIntent.getBroadcast(applicationContext, 0, intent, 167772160);
                }
                if (this.mReportIntent2 == null) {
                    this.mReportIntent2 = PendingIntent.getBroadcast(applicationContext, 0, intent2, 167772160);
                }
                if (this.mReportIntentMorning == null) {
                    this.mReportIntentMorning = PendingIntent.getBroadcast(applicationContext, 0, intent3, 167772160);
                }
                if (this.mAlarmManager == null) {
                    this.mAlarmManager = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
                }
                int timer1SpanMinute = healthTimerConfigData.getTimer1SpanMinute();
                if (timer1SpanMinute <= 0) {
                    timer1SpanMinute = 20;
                }
                int nextInt = new Random().nextInt(timer1SpanMinute);
                int nextInt2 = new Random().nextInt(59);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
                calendar.set(11, healthTimerConfigData.getTimer1StartHour());
                calendar.set(12, healthTimerConfigData.getTimer1StartMin() + nextInt);
                calendar.set(13, nextInt2);
                calendar.set(14, 0);
                long timeInMillis = calendar.getTimeInMillis();
                setTimer(Long.valueOf(timeInMillis), this.mReportIntent1);
                QLog.i(TAG, 1, "register AlarmManager, alarmTime1:" + timeInMillis);
                calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
                int nextInt3 = new Random().nextInt(25);
                int nextInt4 = new Random().nextInt(59);
                calendar.set(12, nextInt3 + 5);
                calendar.set(13, nextInt4);
                calendar.set(14, 0);
                if (calendar.get(11) < healthTimerConfigData.getTimer2EndHour()) {
                    calendar.set(11, 0);
                } else {
                    calendar.set(11, healthTimerConfigData.getTimer2StartHour());
                }
                long timeInMillis2 = calendar.getTimeInMillis();
                setTimer(Long.valueOf(timeInMillis2), this.mReportIntent2);
                QLog.i(TAG, 1, "register AlarmManager, alarmTime2:" + timeInMillis2);
                calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
                calendar.set(11, healthTimerConfigData.getTimer3StartHour() + new Random().nextInt(2));
                calendar.set(12, healthTimerConfigData.getTimer3StartMin() + nextInt);
                calendar.set(13, nextInt2);
                calendar.set(14, 0);
                long timeInMillis3 = calendar.getTimeInMillis();
                setTimer(Long.valueOf(timeInMillis3), this.mReportIntentMorning);
                QLog.i(TAG, 1, "register AlarmManager, alarmTimeMoring:" + timeInMillis3);
            }
            QLog.e(TAG, 1, "isConfigReady:" + z16);
            g43.a.f401222a.a();
            return;
        }
        QLog.e(TAG, 1, "cancel register alarm");
    }

    @Override // com.tencent.mobileqq.vashealth.api.ISportManager
    public void doOnTimer1() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnTimer1");
        }
        HealthTimerConfigData healthTimerConfigData = (HealthTimerConfigData) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100505");
        int timer1Interval = healthTimerConfigData.getTimer1Interval();
        int timer1Increment = healthTimerConfigData.getTimer1Increment();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        calendar.set(11, healthTimerConfigData.getTimer1EndHour());
        calendar.set(12, healthTimerConfigData.getTimer1EndMin());
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        QLog.i(TAG, 1, "do on timer 1,interval:" + timer1Interval + ",increment:" + timer1Increment);
        if (timer1Increment != 0 && timer1Interval != 0) {
            SensorEventListener sensorEventListener = getSensorEventListener(timer1Interval, timer1Increment, timeInMillis);
            SensorManager sensorManager = sSensorManager;
            if (sensorManager != null) {
                try {
                    SensorMonitor.registerListener(sSensorManager, sensorEventListener, SensorMonitor.getDefaultSensor(sensorManager, 19), 1, 60000);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, e16, new Object[0]);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.ISportManager
    public void doOnTimer2() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnTimer2");
        }
        this.mTimer2ReportTimes = 0;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this.mCallBack);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vashealth.api.impl.SportManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (SportManagerImpl.sSensorManager == null) {
                    SportManagerImpl.sSensorManager = (SensorManager) MobileQQ.sMobileQQ.waitAppRuntime(null).getApplication().getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
                }
            }
        }, 5, null, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        cancelTimer();
        if (this.mStepAlarmReceiver != null) {
            try {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    return;
                }
                peekAppRuntime.getApplication().getApplicationContext().unregisterReceiver(this.mStepAlarmReceiver);
                this.mStepAlarmReceiver.a();
                this.mStepAlarmReceiver = null;
            } catch (Exception unused) {
            }
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        sSensorManager = null;
    }

    @Override // com.tencent.mobileqq.vashealth.api.ISportManager
    public void refreshCurrentStep(String str) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && System.currentTimeMillis() - this.lastCallRefresh >= 10000) {
            if (!StepCounterPermissionUtils.g()) {
                QLog.e(TAG, 1, "permissionDenied");
                return;
            }
            this.lastCallRefresh = System.currentTimeMillis();
            QLog.i(TAG, 2, "refreshCurrentStep call from:" + str);
            SportEventManager.f312326a.c();
            k kVar = k.f312340a;
            if (kVar.j()) {
                kVar.q();
                return;
            }
            NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication().getApplicationContext(), u.class);
            newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_REFRESH_STEPS);
            if (!TextUtils.equals(str, "login")) {
                newIntent.putExtra(StepCounterConstants.ATTR_IS_REPORT_STEP, true);
            }
            newIntent.setObserver(this.mRefreshStepsObserver);
            waitAppRuntime.startServlet(newIntent);
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.ISportManager
    public void refreshStepConfig() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication().getApplicationContext(), u.class);
        newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_UPDATE_CONFIG);
        waitAppRuntime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements SensorEventListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f312242d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f312243e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f312244f;

        a(long j3, int i3, int i16) {
            this.f312242d = j3;
            this.f312243e = i3;
            this.f312244f = i16;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.values[0] <= 1.0E8f && NetConnInfoCenter.getServerTimeMillis() <= this.f312242d) {
                if (SSOHttpUtils.f312185c != 0 && SSOHttpUtils.f312189g != 0) {
                    long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() - SSOHttpUtils.f312185c;
                    int i3 = (int) (sensorEvent.values[0] - SSOHttpUtils.f312189g);
                    if (serverTimeMillis > this.f312243e && i3 > this.f312244f) {
                        SportManagerImpl.this.refreshCurrentStep("timer1 report");
                        return;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.e(SportManagerImpl.TAG, 1, "sensor event step:" + sensorEvent.values[0] + ",cur_total:" + SSOHttpUtils.f312189g + ",interval time:" + serverTimeMillis);
                        return;
                    }
                    return;
                }
                if (QLog.isDebugVersion()) {
                    QLog.e(SportManagerImpl.TAG, 1, "lastReportStepTime:" + SSOHttpUtils.f312185c + ",cur_total:" + SSOHttpUtils.f312189g);
                    return;
                }
                return;
            }
            QLog.e(SportManagerImpl.TAG, 1, "unregister listener:" + sensorEvent.values[0]);
            SensorManager sensorManager = SportManagerImpl.sSensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
