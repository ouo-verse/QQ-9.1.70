package com.tencent.rmonitor.sla;

import android.os.Debug;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SLAReporter {

    /* renamed from: a, reason: collision with root package name */
    private long f365825a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f365826b = false;

    public void b() {
        if (this.f365825a == 0) {
            this.f365825a = System.currentTimeMillis();
        }
    }

    public boolean c(int i3) {
        if (this.f365825a == 0) {
            Logger.f365497g.e("RMonitor_sla", "endStartRMonitor invalid call not start yet.");
            return false;
        }
        if (this.f365826b) {
            return true;
        }
        this.f365826b = true;
        e(i3);
        return true;
    }

    int d(AttaEvent attaEvent) {
        if (attaEvent == null || Debug.isDebuggerConnected() || attaEvent.getEventCost() >= 80 || attaEvent.getEventResult() == 0) {
            return 1;
        }
        return 0;
    }

    void e(final int i3) {
        Runnable runnable = new Runnable() { // from class: com.tencent.rmonitor.sla.SLAReporter.1
            @Override // java.lang.Runnable
            public void run() {
                boolean c16 = e.b().c("RMSLALaunchEvent");
                if (c16) {
                    long currentTimeMillis = System.currentTimeMillis();
                    AttaEvent attaEvent = new AttaEvent("RMSLALaunchEvent");
                    attaEvent.U(SLAReporter.this.f365825a);
                    attaEvent.S((int) Math.abs(currentTimeMillis - attaEvent.getEventTime()));
                    attaEvent.T(i3);
                    attaEvent.O(SLAReporter.this.d(attaEvent));
                    SLAReporter.this.f(attaEvent);
                }
                Logger.f365497g.d("RMonitor_sla", "try to report sla hitSampling: " + c16);
            }
        };
        if (ThreadManager.inMonitorThread()) {
            runnable.run();
        } else {
            ThreadManager.runInMonitorThread(runnable, 0L);
        }
    }

    void f(@NotNull AttaEvent attaEvent) {
        AttaEventReporter.INSTANCE.a().i(attaEvent, true);
    }
}
