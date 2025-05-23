package com.tencent.rdelivery.update;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.RDeliveryRequest;
import com.tencent.rdelivery.net.g;
import com.tencent.rdelivery.update.AbsUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001&B\u001f\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u0017\u0010\u001e\u00a8\u0006'"}, d2 = {"Lcom/tencent/rdelivery/update/c;", "Lcom/tencent/rdelivery/update/AbsUpdater;", "", "delayInterval", "", h.F, "i", "g", "Lcom/tencent/rdelivery/update/AbsUpdater$Event;", "event", "c", "Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "b", "I", "requestPeriod", "", "d", "Z", "isRunning", "", "e", "J", "enterBackgroundTs", "f", "nextUpdateTs", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Lcom/tencent/rdelivery/RDeliverySetting;", "Lcom/tencent/rdelivery/RDeliverySetting;", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "Lcom/tencent/rdelivery/net/g;", "requestManager", "Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "<init>", "(Lcom/tencent/rdelivery/net/g;Lcom/tencent/raft/standard/task/IRTask;Lcom/tencent/rdelivery/RDeliverySetting;)V", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class c extends AbsUpdater {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile int requestPeriod;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isRunning;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long enterBackgroundTs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long nextUpdateTs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Handler handler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RDeliverySetting setting;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/rdelivery/update/c$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkParameterIsNotNull(msg2, "msg");
            if (msg2.what == 1) {
                com.tencent.rdelivery.util.c logger = c.this.getSetting().getLogger();
                if (logger != null) {
                    com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_PeriodicUpdater", c.this.getSetting().getRdInstanceIdentifier()), "handleMessage MSG_PERIODIC_UPDATE", false, 4, null);
                }
                c.this.a();
                msg2.getTarget().removeMessages(1);
                msg2.getTarget().sendEmptyMessageDelayed(1, c.this.requestPeriod * 1000);
                c cVar = c.this;
                cVar.g(cVar.requestPeriod);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull g requestManager, @NotNull IRTask taskInterface, @NotNull RDeliverySetting setting) {
        super(requestManager, taskInterface);
        Intrinsics.checkParameterIsNotNull(requestManager, "requestManager");
        Intrinsics.checkParameterIsNotNull(taskInterface, "taskInterface");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        this.setting = setting;
        this.requestPeriod = 14400;
        this.enterBackgroundTs = -1L;
        this.nextUpdateTs = -1L;
        this.requestPeriod = setting.getRealUpdateInterval();
        this.handler = new b(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(int delayInterval) {
        this.nextUpdateTs = SystemClock.uptimeMillis() + (delayInterval * 1000);
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, "RDelivery_PeriodicUpdater", "refreshNextUpdateTs " + this.nextUpdateTs, false, 4, null);
        }
    }

    private final void h(int delayInterval) {
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_PeriodicUpdater", this.setting.getRdInstanceIdentifier()), "start delayInterval = " + delayInterval, false, 4, null);
        }
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, delayInterval * 1000);
        g(delayInterval);
        this.isRunning = true;
    }

    private final void i() {
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_PeriodicUpdater", this.setting.getRdInstanceIdentifier()), "stop", false, 4, null);
        }
        this.handler.removeMessages(1);
        this.isRunning = false;
    }

    @Override // com.tencent.rdelivery.update.AbsUpdater
    @NotNull
    public RDeliveryRequest.RequestSource b() {
        return RDeliveryRequest.RequestSource.PERIODIC;
    }

    @Override // com.tencent.rdelivery.update.AbsUpdater
    public void c(@NotNull AbsUpdater.Event event) {
        int i3;
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event == AbsUpdater.Event.SDK_INIT) {
            h(this.requestPeriod);
            return;
        }
        if (event == AbsUpdater.Event.APP_ENTER_BACKGROUND) {
            this.enterBackgroundTs = SystemClock.uptimeMillis();
            i();
            return;
        }
        if (event == AbsUpdater.Event.APP_ENTER_FOREGROUND && this.enterBackgroundTs > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            com.tencent.rdelivery.util.c logger = this.setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDelivery_PeriodicUpdater", "onNotifyEvent enter foreground currentTs = " + uptimeMillis + ", nextUpdateTs = " + this.nextUpdateTs, false, 4, null);
            }
            long j3 = this.nextUpdateTs;
            if (uptimeMillis >= j3) {
                i3 = this.requestPeriod;
                a();
            } else {
                i3 = (int) ((j3 - uptimeMillis) / 1000);
            }
            h(i3);
        }
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final RDeliverySetting getSetting() {
        return this.setting;
    }
}
