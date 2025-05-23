package com.tencent.state.battery;

import com.tencent.state.SquareDebug;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasBatteryResourceService;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareBatteryService;
import com.tencent.state.square.api.ISquareBatteryServiceObserver;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.util.SquareBatteryUtils;
import com.tencent.state.view.OnlineStatusBubbleViewHelperKt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001J\u0010\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016J(\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u0016J \u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0004J\u001a\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u0004H\u0002J\u0006\u0010#\u001a\u00020\bJ \u0010$\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016J&\u0010'\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004J(\u0010(\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\"\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001J\u001e\u0010,\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/state/battery/SquareBatteryStatusManager;", "Lcom/tencent/state/battery/ISquareBatteryStatusObserver;", "()V", "TAG", "", "batteryService", "Lcom/tencent/state/square/api/ISquareBatteryService;", "initingBatteryInfo", "", "observers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "serviceObserver", "com/tencent/state/battery/SquareBatteryStatusManager$serviceObserver$1", "Lcom/tencent/state/battery/SquareBatteryStatusManager$serviceObserver$1;", "squareBatteryLevelInfo", "Lcom/tencent/state/battery/SquareBatteryLevelInfo;", "addObserver", "", "observer", "destroy", "canCacheInfo", "getBatteryCapacity", "", "getBatteryLevel", "capacity", "getBatteryLevelResource", "Lcom/tencent/state/square/data/Resource;", "uin", "isMale", "dressKey", "getCurBatteryLevel", "getCurBatteryLevelResource", "initService", "mock", "from", "isPowerConnect", "onBatteryInfoChange", "levelChange", "powerConnect", "onDressKeyChange", "onStatusChange", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "removeObserver", "syncBatteryInfoIfNeeded", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class SquareBatteryStatusManager implements ISquareBatteryStatusObserver {
    private static final String TAG = "SquareBatteryManager";
    private static ISquareBatteryService batteryService;
    private static boolean initingBatteryInfo;
    private static SquareBatteryLevelInfo squareBatteryLevelInfo;
    public static final SquareBatteryStatusManager INSTANCE = new SquareBatteryStatusManager();
    private static final SquareBatteryStatusManager$serviceObserver$1 serviceObserver = new ISquareBatteryServiceObserver() { // from class: com.tencent.state.battery.SquareBatteryStatusManager$serviceObserver$1
        @Override // com.tencent.state.square.api.ISquareBatteryServiceObserver
        public void onBatteryChange(int oldCapacity, int newCapacity) {
            SquareBatteryStatusManager squareBatteryStatusManager = SquareBatteryStatusManager.INSTANCE;
            int batteryLevel = squareBatteryStatusManager.getBatteryLevel(oldCapacity);
            int batteryLevel2 = squareBatteryStatusManager.getBatteryLevel(newCapacity);
            squareBatteryStatusManager.onBatteryInfoChange(newCapacity, (batteryLevel == -1 || batteryLevel2 == -1 || batteryLevel == batteryLevel2) ? false : true, squareBatteryStatusManager.isPowerConnect());
        }

        @Override // com.tencent.state.square.api.ISquareBatteryServiceObserver
        public void onPowerConnectChange(boolean oldState, boolean newState) {
            SquareBatteryStatusManager squareBatteryStatusManager = SquareBatteryStatusManager.INSTANCE;
            squareBatteryStatusManager.onBatteryInfoChange(squareBatteryStatusManager.getBatteryCapacity(), false, newState);
        }
    };
    private static final CopyOnWriteArraySet<ISquareBatteryStatusObserver> observers = new CopyOnWriteArraySet<>();

    SquareBatteryStatusManager() {
    }

    private final void initService(boolean mock, String from) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initService, ");
            sb5.append(from);
            sb5.append(", ");
            sb5.append(batteryService == null);
            squareLog.i(TAG, sb5.toString());
        }
        if (batteryService != null) {
            return;
        }
        ISquareBatteryService createBatteryService = Square.INSTANCE.getConfig().getServiceProvider().createBatteryService();
        batteryService = createBatteryService;
        if (createBatteryService != null) {
            createBatteryService.init(mock);
        }
        ISquareBatteryService iSquareBatteryService = batteryService;
        if (iSquareBatteryService != null) {
            iSquareBatteryService.addObserver(serviceObserver);
        }
    }

    public final void addObserver(ISquareBatteryStatusObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        CopyOnWriteArraySet<ISquareBatteryStatusObserver> copyOnWriteArraySet = observers;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.add(observer);
        }
    }

    public final void destroy(boolean canCacheInfo) {
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareBaseKt.getSquareLog().d(TAG, "destroy, " + canCacheInfo);
        }
        ISquareBatteryService iSquareBatteryService = batteryService;
        if (iSquareBatteryService != null) {
            iSquareBatteryService.removeObserver(serviceObserver);
        }
        ISquareBatteryService iSquareBatteryService2 = batteryService;
        if (iSquareBatteryService2 != null) {
            iSquareBatteryService2.destroy();
        }
        batteryService = null;
        CopyOnWriteArraySet<ISquareBatteryStatusObserver> copyOnWriteArraySet = observers;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
        if (canCacheInfo) {
            return;
        }
        squareBatteryLevelInfo = null;
        initingBatteryInfo = false;
    }

    public final int getBatteryCapacity() {
        ISquareBatteryService iSquareBatteryService = batteryService;
        if (iSquareBatteryService != null) {
            return iSquareBatteryService.getBatteryCapacity();
        }
        return SquareBatteryUtils.INSTANCE.getSystemBatteryCapacity(100);
    }

    public final int getBatteryLevel(int capacity) {
        List<SquareBatteryLevelItem> list;
        SquareBatteryLevelInfo squareBatteryLevelInfo2 = squareBatteryLevelInfo;
        if (squareBatteryLevelInfo2 == null || (list = squareBatteryLevelInfo2.getList()) == null) {
            return -1;
        }
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            SquareBatteryLevelItem squareBatteryLevelItem = (SquareBatteryLevelItem) obj;
            if (capacity >= squareBatteryLevelItem.getMinLevel() && capacity <= squareBatteryLevelItem.getMaxLevel()) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    public final Resource getBatteryLevelResource(String uin, boolean isMale, String dressKey, int capacity) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        SquareBatteryLevelInfo squareBatteryLevelInfo2 = squareBatteryLevelInfo;
        if (squareBatteryLevelInfo2 != null && squareBatteryLevelInfo2.isSamePersonInfo(uin, isMale)) {
            if (squareBatteryLevelInfo2.isDressKeyDiff(dressKey)) {
                squareBatteryLevelInfo2.changeDressKey(dressKey);
                return null;
            }
            List<SquareBatteryLevelItem> list = squareBatteryLevelInfo2.getList();
            if (list != null) {
                int i3 = 0;
                for (Object obj : list) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    SquareBatteryLevelItem squareBatteryLevelItem = (SquareBatteryLevelItem) obj;
                    if (capacity >= squareBatteryLevelItem.getMinLevel() && capacity <= squareBatteryLevelItem.getMaxLevel()) {
                        return squareBatteryLevelItem.getResource();
                    }
                    i3 = i16;
                }
            }
            return null;
        }
        syncBatteryInfoIfNeeded(uin, isMale, "getBatteryLevelResource");
        return null;
    }

    public final int getCurBatteryLevel() {
        return getBatteryLevel(getBatteryCapacity());
    }

    public final Resource getCurBatteryLevelResource(String uin, boolean isMale, String dressKey) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        return getBatteryLevelResource(uin, isMale, dressKey, getBatteryCapacity());
    }

    public final boolean isPowerConnect() {
        ISquareBatteryService iSquareBatteryService = batteryService;
        if (iSquareBatteryService != null) {
            return iSquareBatteryService.getPowerConnect();
        }
        return SquareBatteryUtils.INSTANCE.checkSystemPowerConnect(false);
    }

    @Override // com.tencent.state.battery.ISquareBatteryStatusObserver
    public void onBatteryInfoChange(int capacity, boolean levelChange, boolean powerConnect) {
        CopyOnWriteArraySet<ISquareBatteryStatusObserver> copyOnWriteArraySet = observers;
        if (copyOnWriteArraySet != null) {
            Iterator<T> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                ((ISquareBatteryStatusObserver) it.next()).onBatteryInfoChange(capacity, levelChange, powerConnect);
            }
        }
    }

    public final void onDressKeyChange(String uin, boolean isMale, String dressKey, String from) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
        Intrinsics.checkNotNullParameter(from, "from");
        SquareBatteryLevelInfo squareBatteryLevelInfo2 = squareBatteryLevelInfo;
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onDressKeyChange, ");
            sb5.append(isMale);
            sb5.append(", ");
            sb5.append(squareBatteryLevelInfo2 != null ? squareBatteryLevelInfo2.getDressKey() : null);
            sb5.append(", ");
            sb5.append(dressKey);
            sb5.append(", ");
            sb5.append(from);
            squareLog.d(TAG, sb5.toString());
        }
        if (squareBatteryLevelInfo2 != null && squareBatteryLevelInfo2.isDressKeyDiff(dressKey)) {
            squareBatteryLevelInfo2.changeDressKey(dressKey);
        }
        syncBatteryInfoIfNeeded(uin, isMale, "onDressKeyChange");
    }

    public final void onStatusChange(String uin, boolean isMale, OnlineStatus status, String from) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(from, "from");
        if (SquareBaseKt.getSquareLog().isColorLevel()) {
            SquareLogger squareLog = SquareBaseKt.getSquareLog();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onStatusChange, ");
            sb5.append(isMale);
            sb5.append(", ");
            sb5.append(status != null ? Boolean.valueOf(OnlineStatusBubbleViewHelperKt.isBatteryStatus(status)) : null);
            sb5.append(", ");
            sb5.append(from);
            squareLog.d(TAG, sb5.toString());
        }
        boolean z16 = false;
        if (status != null && OnlineStatusBubbleViewHelperKt.isBatteryStatus(status)) {
            SquareBatteryUtils.INSTANCE.syncSystemBatteryInfo();
            syncBatteryInfoIfNeeded(uin, isMale, "onStatusChange");
            if (Square.INSTANCE.getConfig().isDebug() && SquareDebug.INSTANCE.getEnableBatteryMock()) {
                z16 = true;
            }
            initService(z16, from);
            return;
        }
        destroy$default(this, false, 1, null);
    }

    public final void removeObserver(ISquareBatteryStatusObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        CopyOnWriteArraySet<ISquareBatteryStatusObserver> copyOnWriteArraySet = observers;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.remove(observer);
        }
    }

    public final void syncBatteryInfoIfNeeded(String uin, boolean isMale, String from) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(from, "from");
        if (initingBatteryInfo) {
            return;
        }
        SquareBatteryLevelInfo squareBatteryLevelInfo2 = squareBatteryLevelInfo;
        if (squareBatteryLevelInfo2 == null || !squareBatteryLevelInfo2.isSamePersonInfo(uin, isMale)) {
            if (SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareBaseKt.getSquareLog().d(TAG, "syncBatteryInfoIfNeeded, " + from);
            }
            initingBatteryInfo = true;
            squareBatteryLevelInfo = null;
            new VasBatteryResourceService().getBatteryResourceList(uin, isMale, new ResultCallback<SquareBatteryLevelInfo>() { // from class: com.tencent.state.battery.SquareBatteryStatusManager$syncBatteryInfoIfNeeded$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    SquareBaseKt.getSquareLog().i("SquareBatteryManager", "syncBatteryInfo failed: " + error + ", " + message);
                    SquareBatteryStatusManager squareBatteryStatusManager = SquareBatteryStatusManager.INSTANCE;
                    SquareBatteryStatusManager.squareBatteryLevelInfo = null;
                    SquareBatteryStatusManager.initingBatteryInfo = false;
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(SquareBatteryLevelInfo result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    SquareBaseKt.getSquareLog().i("SquareBatteryManager", "syncBatteryInfo success: " + result);
                    SquareBatteryStatusManager squareBatteryStatusManager = SquareBatteryStatusManager.INSTANCE;
                    SquareBatteryStatusManager.squareBatteryLevelInfo = result;
                    SquareBatteryStatusManager.initingBatteryInfo = false;
                }
            });
        }
    }

    static /* synthetic */ void initService$default(SquareBatteryStatusManager squareBatteryStatusManager, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        squareBatteryStatusManager.initService(z16, str);
    }

    public static /* synthetic */ void destroy$default(SquareBatteryStatusManager squareBatteryStatusManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        squareBatteryStatusManager.destroy(z16);
    }
}
