package com.tencent.rdelivery.update;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.monitor.AppStateMonitor;
import com.tencent.rdelivery.monitor.NetworkMonitor;
import com.tencent.rdelivery.net.g;
import com.tencent.rdelivery.update.AbsUpdater;
import com.tencent.rdelivery.update.UpdateManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0017\u001a\u0018\u0000 +2\u00020\u0001:\u0001\fB'\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/rdelivery/update/UpdateManager;", "", "", "targetStrategy", "", "d", "Lcom/tencent/rdelivery/update/AbsUpdater$Event;", "event", "", "e", "", "Lcom/tencent/rdelivery/update/AbsUpdater;", "a", "Ljava/util/List;", "updaters", "Lcom/tencent/rdelivery/monitor/AppStateMonitor;", "b", "Lcom/tencent/rdelivery/monitor/AppStateMonitor;", "appStateMonitor", "Lcom/tencent/rdelivery/monitor/NetworkMonitor;", "c", "Lcom/tencent/rdelivery/monitor/NetworkMonitor;", "networkMonitor", "com/tencent/rdelivery/update/UpdateManager$b", "Lcom/tencent/rdelivery/update/UpdateManager$b;", "appStateChangeListener", "com/tencent/rdelivery/update/UpdateManager$c", "Lcom/tencent/rdelivery/update/UpdateManager$c;", "networkChangeListener", "Lcom/tencent/rdelivery/RDeliverySetting;", "f", "Lcom/tencent/rdelivery/RDeliverySetting;", "getSetting", "()Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "Landroid/content/Context;", "context", "Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "Lcom/tencent/rdelivery/net/g;", "requestManager", "<init>", "(Landroid/content/Context;Lcom/tencent/rdelivery/RDeliverySetting;Lcom/tencent/raft/standard/task/IRTask;Lcom/tencent/rdelivery/net/g;)V", "g", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class UpdateManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<AbsUpdater> updaters;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AppStateMonitor appStateMonitor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private NetworkMonitor networkMonitor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b appStateChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c networkChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RDeliverySetting setting;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/rdelivery/update/UpdateManager$b", "Lcom/tencent/rdelivery/monitor/AppStateMonitor$a;", "", "onEnterBackground", "onEnterForeground", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class b implements AppStateMonitor.a {
        b() {
        }

        @Override // com.tencent.rdelivery.monitor.AppStateMonitor.a
        public void onEnterBackground() {
            UpdateManager.this.e(AbsUpdater.Event.APP_ENTER_BACKGROUND);
        }

        @Override // com.tencent.rdelivery.monitor.AppStateMonitor.a
        public void onEnterForeground() {
            UpdateManager.this.e(AbsUpdater.Event.APP_ENTER_FOREGROUND);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/rdelivery/update/UpdateManager$c", "Lcom/tencent/rdelivery/monitor/NetworkMonitor$b;", "", "onReconnect", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class c implements NetworkMonitor.b {
        c() {
        }

        @Override // com.tencent.rdelivery.monitor.NetworkMonitor.b
        public void onReconnect() {
            UpdateManager.this.e(AbsUpdater.Event.NETWORK_RECONNECT);
        }
    }

    public UpdateManager(@NotNull final Context context, @NotNull RDeliverySetting setting, @NotNull final IRTask taskInterface, @NotNull final g requestManager) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        Intrinsics.checkParameterIsNotNull(taskInterface, "taskInterface");
        Intrinsics.checkParameterIsNotNull(requestManager, "requestManager");
        this.setting = setting;
        this.updaters = new ArrayList();
        this.appStateChangeListener = new b();
        this.networkChangeListener = new c();
        Integer updateStrategy = setting.getUpdateStrategy();
        if (updateStrategy != null) {
            int intValue = updateStrategy.intValue();
            if (d(intValue, RDeliverySetting.UpdateStrategy.START_UP.getValue())) {
                this.updaters.add(new d(requestManager));
            }
            if (d(intValue, RDeliverySetting.UpdateStrategy.PERIODIC.getValue())) {
                this.updaters.add(new com.tencent.rdelivery.update.c(requestManager, taskInterface, setting));
            }
            if (d(intValue, RDeliverySetting.UpdateStrategy.HOT_RELOAD.getValue())) {
                this.updaters.add(new a(requestManager));
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.rdelivery.update.UpdateManager$$special$$inlined$let$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppStateMonitor appStateMonitor;
                        UpdateManager.b bVar;
                        UpdateManager.this.appStateMonitor = new AppStateMonitor();
                        appStateMonitor = UpdateManager.this.appStateMonitor;
                        if (appStateMonitor != null) {
                            bVar = UpdateManager.this.appStateChangeListener;
                            appStateMonitor.a(bVar);
                        }
                    }
                });
            }
            if (d(intValue, RDeliverySetting.UpdateStrategy.NETWORK_RECONNECT.getValue())) {
                this.updaters.add(new com.tencent.rdelivery.update.b(requestManager));
                NetworkMonitor networkMonitor = new NetworkMonitor(context, setting.getLogger());
                this.networkMonitor = networkMonitor;
                networkMonitor.a(this.networkChangeListener);
            }
        }
        com.tencent.rdelivery.util.c logger = setting.getLogger();
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_UpdateManager", setting.getRdInstanceIdentifier()), "init updaters.size = " + this.updaters.size(), false, 4, null);
        }
    }

    public final boolean d(int i3, int i16) {
        if ((i3 & i16) == i16) {
            return true;
        }
        return false;
    }

    public final void e(@NotNull AbsUpdater.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        com.tencent.rdelivery.util.c logger = this.setting.getLogger();
        if (logger != null) {
            com.tencent.rdelivery.util.c.b(logger, com.tencent.rdelivery.util.d.a("RDelivery_UpdateManager", this.setting.getRdInstanceIdentifier()), "notifyUpdater event = " + event, false, 4, null);
        }
        for (AbsUpdater absUpdater : this.updaters) {
            com.tencent.rdelivery.util.c logger2 = this.setting.getLogger();
            if (logger2 != null) {
                com.tencent.rdelivery.util.c.b(logger2, com.tencent.rdelivery.util.d.a("RDelivery_UpdateManager", this.setting.getRdInstanceIdentifier()), "notifyUpdater event = " + event + ", updater = " + absUpdater, false, 4, null);
            }
            absUpdater.c(event);
        }
    }
}
