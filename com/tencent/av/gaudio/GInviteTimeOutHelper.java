package com.tencent.av.gaudio;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GInviteTimeOutHelper {

    /* renamed from: b, reason: collision with root package name */
    private static volatile GInviteTimeOutHelper f73821b;

    /* renamed from: a, reason: collision with root package name */
    Timer f73822a = null;

    GInviteTimeOutHelper() {
    }

    public static GInviteTimeOutHelper b() {
        if (f73821b == null) {
            synchronized (GInviteTimeOutHelper.class) {
                if (f73821b == null) {
                    f73821b = new GInviteTimeOutHelper();
                }
            }
        }
        return f73821b;
    }

    public void a() {
        QLog.i("GInviteTimeOutHelper", 1, "destroyTimer");
        Timer timer = this.f73822a;
        if (timer != null) {
            timer.cancel();
            this.f73822a = null;
        }
    }

    public void c(long j3, int i3, long j16) {
        QLog.i("GInviteTimeOutHelper", 1, "startTimer");
        Timer timer = this.f73822a;
        if (timer != null) {
            timer.cancel();
        }
        this.f73822a = new BaseTimer(true);
        this.f73822a.schedule(new TimerTask() { // from class: com.tencent.av.gaudio.GInviteTimeOutHelper.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                VideoAppInterface.N().k0(new Object[]{311});
            }
        }, j3);
    }
}
