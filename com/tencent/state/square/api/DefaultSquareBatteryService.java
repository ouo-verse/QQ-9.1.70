package com.tencent.state.square.api;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.util.SquareBatteryUtils;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015*\u0001\f\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/square/api/DefaultSquareBatteryService;", "Lcom/tencent/state/square/api/ISquareBatteryService;", "Lcom/tencent/state/square/api/ISquareBatteryServiceObserver;", "()V", "batteryCapacity", "", "mock", "", "observers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "powerConnect", "receiver", "com/tencent/state/square/api/DefaultSquareBatteryService$receiver$1", "Lcom/tencent/state/square/api/DefaultSquareBatteryService$receiver$1;", "registered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "addObserver", "", "observer", "destroy", "getBatteryCapacity", "init", "isPowerConnect", "mockCapacity", "onBatteryChange", "oldLevel", "newLevel", "onPowerConnectChange", "oldState", "newState", "registerReceiver", "removeObserver", "setBatteryCapacity", "capacity", "setPowerConnect", UploadQualityReportBuilder.STATE_CONNECT, "unregisterReceiver", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultSquareBatteryService implements ISquareBatteryService, ISquareBatteryServiceObserver {
    private static final String TAG = "DefaultSquareBatteryService";
    private int batteryCapacity;
    private boolean mock;
    private boolean powerConnect;
    private final CopyOnWriteArraySet<ISquareBatteryServiceObserver> observers = new CopyOnWriteArraySet<>();
    private final AtomicBoolean registered = new AtomicBoolean(false);
    private final DefaultSquareBatteryService$receiver$1 receiver = new BroadcastReceiver() { // from class: com.tencent.state.square.api.DefaultSquareBatteryService$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            boolean z16;
            int i3;
            boolean z17;
            boolean z18;
            if (intent != null) {
                String action = intent.getAction();
                if (TextUtils.equals(action, "android.intent.action.ACTION_POWER_CONNECTED")) {
                    DefaultSquareBatteryService defaultSquareBatteryService = DefaultSquareBatteryService.this;
                    z18 = defaultSquareBatteryService.powerConnect;
                    defaultSquareBatteryService.onPowerConnectChange(z18, true);
                    return;
                }
                if (TextUtils.equals(action, "android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    DefaultSquareBatteryService defaultSquareBatteryService2 = DefaultSquareBatteryService.this;
                    z17 = defaultSquareBatteryService2.powerConnect;
                    defaultSquareBatteryService2.onPowerConnectChange(z17, false);
                } else if (TextUtils.equals(action, "android.intent.action.BATTERY_CHANGED")) {
                    z16 = DefaultSquareBatteryService.this.mock;
                    if (z16) {
                        return;
                    }
                    int intExtra = intent.getIntExtra("level", 0);
                    int intExtra2 = intent.getIntExtra("scale", 100);
                    if (intExtra2 != 0) {
                        intExtra = (intExtra * 100) / intExtra2;
                    }
                    DefaultSquareBatteryService defaultSquareBatteryService3 = DefaultSquareBatteryService.this;
                    i3 = defaultSquareBatteryService3.batteryCapacity;
                    defaultSquareBatteryService3.onBatteryChange(i3, intExtra);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final void mockCapacity() {
        SquareBaseKt.getSquareThread().postOnUiDelayed(1000L, new Function0<Unit>() { // from class: com.tencent.state.square.api.DefaultSquareBatteryService$mockCapacity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i3;
                boolean z16;
                DefaultSquareBatteryService defaultSquareBatteryService = DefaultSquareBatteryService.this;
                i3 = defaultSquareBatteryService.batteryCapacity;
                defaultSquareBatteryService.setBatteryCapacity((i3 + 1) % 101);
                z16 = DefaultSquareBatteryService.this.mock;
                if (z16) {
                    DefaultSquareBatteryService.this.mockCapacity();
                }
            }
        });
    }

    private final void registerReceiver() {
        if (!this.registered.compareAndSet(false, true)) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "register");
        try {
            Application app = SquareBase.INSTANCE.getApp();
            if (app != null) {
                DefaultSquareBatteryService$receiver$1 defaultSquareBatteryService$receiver$1 = this.receiver;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                Unit unit = Unit.INSTANCE;
                app.registerReceiver(defaultSquareBatteryService$receiver$1, intentFilter);
            }
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "registerReceiver, " + th5.getMessage(), null, 4, null);
        }
    }

    private final void unregisterReceiver() {
        if (!this.registered.get()) {
            return;
        }
        try {
            Application app = SquareBase.INSTANCE.getApp();
            if (app != null) {
                app.unregisterReceiver(this.receiver);
            }
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "unregisterReceiver, " + th5.getMessage(), null, 4, null);
        }
    }

    @Override // com.tencent.state.square.api.ISquareBatteryService
    public void addObserver(@NotNull ISquareBatteryServiceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.add(observer);
    }

    @Override // com.tencent.state.square.api.ISquareBatteryService
    public void destroy() {
        SquareBaseKt.getSquareLog().i(TAG, "destroy");
        unregisterReceiver();
        this.observers.clear();
        this.batteryCapacity = 0;
        this.powerConnect = false;
        this.registered.set(false);
        this.mock = false;
    }

    @Override // com.tencent.state.square.api.ISquareBatteryService
    public int getBatteryCapacity() {
        return this.batteryCapacity;
    }

    @Override // com.tencent.state.square.api.ISquareBatteryService
    public void init(boolean mock) {
        int systemBatteryCapacity;
        SquareBaseKt.getSquareLog().i(TAG, "init");
        this.mock = mock;
        if (mock) {
            systemBatteryCapacity = 0;
        } else {
            systemBatteryCapacity = SquareBatteryUtils.INSTANCE.getSystemBatteryCapacity(100);
        }
        this.batteryCapacity = systemBatteryCapacity;
        this.powerConnect = SquareBatteryUtils.INSTANCE.checkSystemPowerConnect(false);
        registerReceiver();
        if (mock) {
            mockCapacity();
        }
    }

    @Override // com.tencent.state.square.api.ISquareBatteryService
    /* renamed from: isPowerConnect, reason: from getter */
    public boolean getPowerConnect() {
        return this.powerConnect;
    }

    @Override // com.tencent.state.square.api.ISquareBatteryServiceObserver
    public void onBatteryChange(int oldLevel, int newLevel) {
        this.batteryCapacity = newLevel;
        if (newLevel != oldLevel) {
            Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                ((ISquareBatteryServiceObserver) it.next()).onBatteryChange(oldLevel, newLevel);
            }
        }
    }

    @Override // com.tencent.state.square.api.ISquareBatteryServiceObserver
    public void onPowerConnectChange(boolean oldState, boolean newState) {
        this.powerConnect = newState;
        if (oldState != newState) {
            Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                ((ISquareBatteryServiceObserver) it.next()).onPowerConnectChange(oldState, newState);
            }
        }
    }

    @Override // com.tencent.state.square.api.ISquareBatteryService
    public void removeObserver(@NotNull ISquareBatteryServiceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
    }

    @Override // com.tencent.state.square.api.ISquareBatteryService
    public void setBatteryCapacity(int capacity) {
        onBatteryChange(this.batteryCapacity, capacity);
    }

    @Override // com.tencent.state.square.api.ISquareBatteryService
    public void setPowerConnect(boolean connect) {
        onPowerConnectChange(this.powerConnect, connect);
    }
}
