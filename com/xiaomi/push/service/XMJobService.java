package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.hz;

/* compiled from: P */
/* loaded from: classes28.dex */
public class XMJobService extends Service {

    /* renamed from: a, reason: collision with root package name */
    static Service f389488a;

    /* renamed from: a, reason: collision with other field name */
    private IBinder f24864a = null;

    /* compiled from: P */
    @TargetApi(21)
    /* loaded from: classes28.dex */
    static class a extends JobService {

        /* renamed from: d, reason: collision with root package name */
        Binder f389489d;

        /* renamed from: e, reason: collision with root package name */
        private Handler f389490e;

        /* compiled from: P */
        /* renamed from: com.xiaomi.push.service.XMJobService$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        private static class HandlerC10089a extends Handler {

            /* renamed from: a, reason: collision with root package name */
            JobService f389491a;

            HandlerC10089a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f389491a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    JobParameters jobParameters = (JobParameters) message.obj;
                    jz4.c.m("Job finished " + jobParameters.getJobId());
                    this.f389491a.jobFinished(jobParameters, false);
                    if (jobParameters.getJobId() == 1) {
                        Cdo.d(false);
                    }
                }
            }
        }

        a(Service service) {
            this.f389489d = null;
            this.f389489d = (Binder) com.xiaomi.push.y.e(this, "onBind", new Intent());
            com.xiaomi.push.y.e(this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            jz4.c.m("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f389490e == null) {
                this.f389490e = new HandlerC10089a(this);
            }
            Handler handler = this.f389490e;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            jz4.c.m("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f24864a;
        if (iBinder != null) {
            return iBinder;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f24864a = new a(this).f389489d;
        f389488a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f389488a = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        int onStartCommand = super.onStartCommand(intent, i3, i16);
        if (!hz.j(this)) {
            return 2;
        }
        return onStartCommand;
    }
}
