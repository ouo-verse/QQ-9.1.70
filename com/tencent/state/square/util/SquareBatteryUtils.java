package com.tencent.state.square.util;

import android.app.Application;
import android.os.BatteryManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/state/square/util/SquareBatteryUtils;", "", "()V", "SYNC_INTERVAL", "", "TAG", "", "capacityCache", "", "Ljava/lang/Integer;", "lastSyncTime", "powerConnectCache", "", "Ljava/lang/Boolean;", "checkSystemPowerConnect", "default", "getSystemBatteryCapacity", "syncSystemBatteryCapacityInner", "", "syncSystemBatteryInfo", "syncSystemPowerConnectInner", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class SquareBatteryUtils {

    @NotNull
    public static final SquareBatteryUtils INSTANCE = new SquareBatteryUtils();
    private static final long SYNC_INTERVAL = 10000;
    private static final String TAG = "SquareBatteryUtils";
    private static Integer capacityCache;
    private static long lastSyncTime;
    private static Boolean powerConnectCache;

    SquareBatteryUtils() {
    }

    private final void syncSystemBatteryCapacityInner() {
        SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.square.util.SquareBatteryUtils$syncSystemBatteryCapacityInner$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                try {
                    Application app = SquareBase.INSTANCE.getApp();
                    Object obj = null;
                    Object systemService = app != null ? app.getSystemService("batterymanager") : null;
                    if (systemService instanceof BatteryManager) {
                        obj = systemService;
                    }
                    BatteryManager batteryManager = (BatteryManager) obj;
                    int intProperty = batteryManager != null ? SystemMethodProxy.getIntProperty(batteryManager, 4) : -1;
                    SquareBaseKt.getSquareLog().d("SquareBatteryUtils", "syncSystemBatteryCapacityInner, " + intProperty);
                    SquareBatteryUtils squareBatteryUtils = SquareBatteryUtils.INSTANCE;
                    SquareBatteryUtils.capacityCache = intProperty < 0 ? 100 : Integer.valueOf(intProperty);
                } catch (Throwable th5) {
                    SquareBaseKt.getSquareLog().e("SquareBatteryUtils", "getSystemBatteryCapacity t:", th5);
                }
            }
        });
    }

    private final void syncSystemPowerConnectInner() {
        SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.square.util.SquareBatteryUtils$syncSystemPowerConnectInner$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                try {
                    Application app = SquareBase.INSTANCE.getApp();
                    Object obj = null;
                    Object systemService = app != null ? app.getSystemService("batterymanager") : null;
                    if (systemService instanceof BatteryManager) {
                        obj = systemService;
                    }
                    BatteryManager batteryManager = (BatteryManager) obj;
                    if (batteryManager != null) {
                        boolean isCharging = batteryManager.isCharging();
                        int intProperty = SystemMethodProxy.getIntProperty(batteryManager, 6);
                        SquareBaseKt.getSquareLog().d("SquareBatteryUtils", "syncSystemPowerConnectInner, " + isCharging + ", " + intProperty);
                        SquareBatteryUtils squareBatteryUtils = SquareBatteryUtils.INSTANCE;
                        if (intProperty != 2 && intProperty != 5 && !isCharging) {
                            z16 = false;
                            SquareBatteryUtils.powerConnectCache = Boolean.valueOf(z16);
                        }
                        z16 = true;
                        SquareBatteryUtils.powerConnectCache = Boolean.valueOf(z16);
                    }
                } catch (Throwable th5) {
                    SquareBaseKt.getSquareLog().e("SquareBatteryUtils", "checkPowerConnect t:", th5);
                }
            }
        });
    }

    public final boolean checkSystemPowerConnect(boolean r26) {
        syncSystemBatteryInfo();
        Boolean bool = powerConnectCache;
        if (bool != null) {
            return bool.booleanValue();
        }
        return r26;
    }

    public final int getSystemBatteryCapacity(int r26) {
        syncSystemBatteryInfo();
        Integer num = capacityCache;
        if (num != null) {
            return num.intValue();
        }
        return r26;
    }

    public final void syncSystemBatteryInfo() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastSyncTime <= 10000) {
            return;
        }
        lastSyncTime = currentTimeMillis;
        syncSystemPowerConnectInner();
        syncSystemBatteryCapacityInner();
    }
}
