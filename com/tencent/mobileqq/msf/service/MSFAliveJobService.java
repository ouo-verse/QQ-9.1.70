package com.tencent.mobileqq.msf.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes15.dex */
public class MSFAliveJobService extends JobService {
    static IPatchRedirector $redirector_ = null;
    private static final int MESSAGE_ID_TASK = 1;
    public static final String TAG = "MSFAliveJobService";
    public final Handler mHandler;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Handler.Callback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MSFAliveJobService.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            com.tencent.mobileqq.msf.core.c0.j jVar;
            j.e eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            if (!j.d()) {
                QLog.d(MSFAliveJobService.TAG, 1, "MSF_Alive_Log MSFAliveJobService handleMessage not enable");
                try {
                    JobScheduler jobScheduler = (JobScheduler) BaseApplication.getContext().getSystemService("jobscheduler");
                    if (jobScheduler != null) {
                        jobScheduler.cancel(1);
                        QLog.d(MSFAliveJobService.TAG, 1, "MSF_Alive_Log MSFAliveJobService handleMessage job cancelled");
                    }
                } catch (Exception e16) {
                    QLog.d(MSFAliveJobService.TAG, 1, "MSF_Alive_Log MSFAliveJobService handleMessage e ", e16);
                }
                MSFAliveJobService.this.jobFinished((JobParameters) message.obj, false);
                return true;
            }
            QLog.d(MSFAliveJobService.TAG, 1, "MSF_Alive_Log MSFAliveJobService handleMessage start service");
            MsfCore msfCore = MsfCore.sCore;
            if (msfCore != null && (jVar = msfCore.statReporter) != null && (eVar = jVar.f247848b) != null) {
                boolean z16 = eVar.f247860a;
                long j3 = eVar.f247866g;
                long j16 = eVar.f247861b;
                long j17 = eVar.f247862c;
                long abs = Math.abs(System.currentTimeMillis() - j3);
                QLog.d(MSFAliveJobService.TAG, 1, "MSF_Alive_Log : isDeviceIdleMode=", Boolean.valueOf(z16), ", netWorkFailTime=", Long.valueOf(j3), ", enterIdle=", Long.valueOf(j16), " levelIdle=", Long.valueOf(j17), ",netFailInterval=", Long.valueOf(abs));
                try {
                    com.tencent.mobileqq.msf.core.stepcount.f.c().a();
                } catch (Exception e17) {
                    QLog.d(MSFAliveJobService.TAG, 1, "MSF_Alive_Log MSFAliveJobService step report e ", e17);
                }
                if (j3 != 0 && abs > 270000.0d) {
                    QLog.d(MSFAliveJobService.TAG, 1, "MSF_Alive_Log MSFAliveJobService handleMessage send push query");
                    if (MsfCore.sCore.pushManager != null) {
                        QLog.d(MSFAliveJobService.TAG, 1, "MSF_Alive_Log MSFAliveJobService handleMessage send push query real");
                        MsfCore.sCore.pushManager.u();
                    }
                }
            }
            if (!MsfService.inited) {
                j.a(false);
                QLog.d(MSFAliveJobService.TAG, 1, "MSF_Alive_Log MSFAliveJobService handleMessage init MSF Service");
                Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) MsfService.class);
                intent.putExtra(j.R, true);
                NetConnInfoCenter.startOrBindService(intent);
            }
            MSFAliveJobService.this.jobFinished((JobParameters) message.obj, false);
            return true;
        }
    }

    public MSFAliveJobService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mHandler = new Handler(q.n().getLooper(), new a());
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onCreate();
            QLog.d(TAG, 1, "MSF_Alive_Log MSFAliveJobService onCreate ");
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jobParameters)).booleanValue();
        }
        QLog.d(TAG, 1, "MSF_Alive_Log MSFAliveJobService onStartJob ");
        this.mHandler.sendMessage(Message.obtain(this.mHandler, 1, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) jobParameters)).booleanValue();
        }
        QLog.d(TAG, 1, "MSF_Alive_Log MSFAliveJobService onStopJob ");
        return false;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        } else {
            QLog.d(TAG, 1, "MSF_Alive_Log MSFAliveJobService onTaskRemoved");
            super.onTaskRemoved(intent);
        }
    }
}
