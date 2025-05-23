package com.tencent.vas.update.module.impl;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.ITimerListener;
import com.tencent.vas.update.module.thread.ThreadManager;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;
import uw4.c;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TimerModuleImpl implements c {

    /* renamed from: a, reason: collision with root package name */
    private ITimerListener f384021a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<Integer, ScheduledFuture> f384022b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class TaskRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private b f384023d;

        public TaskRunnable(@NonNull b bVar) {
            this.f384023d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TimerModuleImpl.this.f384022b.containsKey(Integer.valueOf(this.f384023d.f384024a))) {
                return;
            }
            TimerModuleImpl.this.f384022b.remove(Integer.valueOf(this.f384023d.f384024a));
            VasUpdateWrapper.getLog().i("VasUpdate_TimerModule", "timer run = " + this.f384023d.toString());
            if (TimerModuleImpl.this.f384021a != null) {
                TimerModuleImpl.this.f384021a.onTime(this.f384023d.f384024a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f384024a;

        /* renamed from: b, reason: collision with root package name */
        public long f384025b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f384026c;

        b() {
        }

        @NonNull
        public String toString() {
            return "timer type = " + this.f384024a + " delay = " + this.f384025b + " loop = " + this.f384026c;
        }
    }

    public TimerModuleImpl(ITimerListener iTimerListener) {
        this.f384021a = iTimerListener;
    }

    private void e(@NonNull b bVar) {
        VasUpdateWrapper.getLog().i("VasUpdate_TimerModule", "send timer task = " + bVar.toString());
        this.f384022b.put(Integer.valueOf(bVar.f384024a), ThreadManager.getInstance().postDelay(2, new TaskRunnable(bVar), bVar.f384025b));
    }

    @Override // uw4.c
    public void a(int i3) {
        if (this.f384022b.containsKey(Integer.valueOf(i3)) && this.f384022b.get(Integer.valueOf(i3)) != null) {
            ScheduledFuture scheduledFuture = this.f384022b.get(Integer.valueOf(i3));
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.f384022b.remove(Integer.valueOf(i3));
            VasUpdateWrapper.getLog().i("VasUpdate_TimerModule", "stop true");
        }
    }

    @Override // uw4.c
    public void b(int i3, long j3, boolean z16) {
        if (this.f384022b.containsKey(Integer.valueOf(i3))) {
            VasUpdateWrapper.getLog().i("VasUpdate_TimerModule", "setTimer repeat type = " + i3);
            return;
        }
        b bVar = new b();
        bVar.f384024a = i3;
        bVar.f384025b = j3;
        bVar.f384026c = z16;
        e(bVar);
    }
}
