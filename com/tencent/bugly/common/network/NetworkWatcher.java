package com.tencent.bugly.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0019\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\rJ\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\rJ\u0006\u0010%\u001a\u00020\rJ\u0018\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u0016J\b\u00100\u001a\u00020\u001cH\u0002J\u0006\u00101\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078BX\u0082\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001a\u00a8\u00062"}, d2 = {"Lcom/tencent/bugly/common/network/NetworkWatcher;", "", "()V", "ACTION_CONN_CHANGE", "", "TAG", "apn", "Lcom/tencent/bugly/common/network/Apn;", "getApn", "()Lcom/tencent/bugly/common/network/Apn;", "handler", "Landroid/os/Handler;", "isInited", "", "isNetAvailable", "()Z", "setNetAvailable", "(Z)V", "isWifiAvailable", "setWifiAvailable", "mListeners", "Ljava/util/HashSet;", "Lcom/tencent/bugly/common/network/INetworkStateListener;", "Lkotlin/collections/HashSet;", "netStatusReceive", "com/tencent/bugly/common/network/NetworkWatcher$netStatusReceive$1", "Lcom/tencent/bugly/common/network/NetworkWatcher$netStatusReceive$1;", "checkConnInfo", "", "networkState", "Lcom/tencent/bugly/common/network/NetworkState;", "getMobileDetailState", "getNetworkState", "fetchMobileDetailState", "getOperatorName", "init", "isNetworkConnectedRealtime", "isWiFiConnectedRealtime", "isWiFiType", "connManager", "Landroid/net/ConnectivityManager;", "activeNetInfo", "Landroid/net/NetworkInfo;", "notifyListener", "processApn", "it", "registerListener", "listener", "resetApn", "unInit", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class NetworkWatcher {
    private static final String ACTION_CONN_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
    private static final String TAG = "Bugly_NetWatcher";
    private static Handler handler;
    private static volatile boolean isInited;
    private static volatile boolean isNetAvailable;
    private static volatile boolean isWifiAvailable;
    private static HashSet<INetworkStateListener> mListeners;
    public static final NetworkWatcher INSTANCE = new NetworkWatcher();
    private static volatile Apn apn = Apn.TYPE_INIT;
    private static final NetworkWatcher$netStatusReceive$1 netStatusReceive = new BroadcastReceiver() { // from class: com.tencent.bugly.common.network.NetworkWatcher$netStatusReceive$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Handler handler2;
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            if (ContextUtil.getGlobalContext() != null) {
                NetworkWatcher networkWatcher = NetworkWatcher.INSTANCE;
                handler2 = NetworkWatcher.handler;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.tencent.bugly.common.network.NetworkWatcher$netStatusReceive$1$onReceive$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            NetworkWatcher.INSTANCE.checkConnInfo();
                        }
                    });
                }
            }
        }
    };

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            int[] iArr = new int[Apn.values().length];
            $EnumSwitchMapping$0 = iArr;
            Apn apn = Apn.TYPE_WIFI;
            iArr[apn.ordinal()] = 1;
            iArr[Apn.TYPE_UNKNOWN.ordinal()] = 2;
            int[] iArr2 = new int[Apn.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[apn.ordinal()] = 1;
            int[] iArr3 = new int[NetworkState.values().length];
            $EnumSwitchMapping$2 = iArr3;
            NetworkState networkState = NetworkState.NETWORK_2G;
            iArr3[networkState.ordinal()] = 1;
            NetworkState networkState2 = NetworkState.NETWORK_3G;
            iArr3[networkState2.ordinal()] = 2;
            int[] iArr4 = new int[NetworkState.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[networkState.ordinal()] = 1;
            iArr4[networkState2.ordinal()] = 2;
            int[] iArr5 = new int[NetworkState.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[networkState.ordinal()] = 1;
            iArr5[networkState2.ordinal()] = 2;
            int[] iArr6 = new int[NetworkState.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[NetworkState.NETWORK_WIFI.ordinal()] = 1;
            iArr6[NetworkState.NETWORK_NONE.ordinal()] = 2;
        }
    }

    NetworkWatcher() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkConnInfo() {
        boolean z16;
        resetApn();
        boolean z17 = false;
        if (WhenMappings.$EnumSwitchMapping$1[getApn().ordinal()] != 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        isWifiAvailable = z16;
        if (getApn() != Apn.TYPE_UNKNOWN) {
            z17 = true;
        }
        isNetAvailable = z17;
        notifyListener();
    }

    private final Apn getApn() {
        if (apn == Apn.TYPE_INIT) {
            resetApn();
        }
        return apn;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d2, code lost:
    
        if (r1.intValue() != 15) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0066, code lost:
    
        if (r1.intValue() != 11) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final NetworkState getMobileDetailState() {
        Object obj;
        try {
            if (!DeviceInfoUtil.hasPermission(ContextUtil.getGlobalContext(), DeviceInfoUtil.PERMISSION_READ_PHONE)) {
                return NetworkState.NETWORK_MOBILE;
            }
            Context globalContext = ContextUtil.getGlobalContext();
            Integer num = null;
            if (globalContext != null) {
                obj = globalContext.getSystemService("phone");
            } else {
                obj = null;
            }
            if (!(obj instanceof TelephonyManager)) {
                obj = null;
            }
            TelephonyManager telephonyManager = (TelephonyManager) obj;
            if (telephonyManager != null) {
                num = Integer.valueOf(NetworkMonitor.getNetworkType(telephonyManager));
            }
            if (num != null && num.intValue() == 1) {
                return NetworkState.NETWORK_2G;
            }
            if (num.intValue() == 4) {
                return NetworkState.NETWORK_2G;
            }
            if (num != null && num.intValue() == 2) {
                return NetworkState.NETWORK_2G;
            }
            if (num.intValue() == 7) {
                return NetworkState.NETWORK_2G;
            }
            if (num != null) {
            }
            if (num != null && num.intValue() == 6) {
                return NetworkState.NETWORK_3G;
            }
            if (num.intValue() == 3) {
                return NetworkState.NETWORK_3G;
            }
            if (num != null && num.intValue() == 5) {
                return NetworkState.NETWORK_3G;
            }
            if (num.intValue() == 8) {
                return NetworkState.NETWORK_3G;
            }
            if (num != null && num.intValue() == 9) {
                return NetworkState.NETWORK_3G;
            }
            if (num.intValue() == 10) {
                return NetworkState.NETWORK_3G;
            }
            if (num != null && num.intValue() == 12) {
                return NetworkState.NETWORK_3G;
            }
            if (num.intValue() == 14) {
                return NetworkState.NETWORK_3G;
            }
            if (num != null) {
            }
            if (num != null && num.intValue() == 13) {
                return NetworkState.NETWORK_4G;
            }
            return NetworkState.NETWORK_MOBILE;
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
            return NetworkState.NETWORK_MOBILE;
        }
    }

    private final boolean isWiFiType(ConnectivityManager connManager, NetworkInfo activeNetInfo) {
        if (!AndroidVersion.INSTANCE.isOverL()) {
            if (activeNetInfo.isConnectedOrConnecting() && NetworkMonitor.getType(activeNetInfo) == 1) {
                return true;
            }
        } else {
            for (Network network : connManager.getAllNetworks()) {
                NetworkInfo it = connManager.getNetworkInfo(network);
                if (it != null) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    if (NetworkMonitor.getType(it) == 1 && (it.getState() == NetworkInfo.State.CONNECTED || it.getState() == NetworkInfo.State.CONNECTING)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final void notifyListener() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[getApn().ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 == 2) {
                i16 = 3;
            }
        }
        HashSet<INetworkStateListener> hashSet = mListeners;
        if (hashSet != null) {
            if (hashSet == null) {
                Intrinsics.throwNpe();
            }
            Iterator<INetworkStateListener> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().onNetworkStateChanged(i16);
            }
        }
    }

    private final Apn processApn(String it, NetworkState networkState) {
        int hashCode = it.hashCode();
        if (hashCode != 618558396) {
            if (hashCode != 618596989) {
                if (hashCode == 618663094 && it.equals("\u4e2d\u56fd\u8054\u901a")) {
                    int i3 = WhenMappings.$EnumSwitchMapping$4[networkState.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return Apn.T_APN_WONET;
                        }
                        return Apn.T_APN_3GNET;
                    }
                    return Apn.T_APN_UNINET;
                }
            } else if (it.equals("\u4e2d\u56fd\u79fb\u52a8")) {
                int i16 = WhenMappings.$EnumSwitchMapping$2[networkState.ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        return Apn.T_APN_CMLTE;
                    }
                    return Apn.T_APN_CM3G;
                }
                return Apn.T_APN_CMNET;
            }
        } else if (it.equals("\u4e2d\u56fd\u7535\u4fe1")) {
            int i17 = WhenMappings.$EnumSwitchMapping$3[networkState.ordinal()];
            if (i17 != 1) {
                if (i17 != 2) {
                    return Apn.T_APN_CTLTE;
                }
                return Apn.T_APN_CTNET;
            }
            return Apn.TYPE_UNKNOWN;
        }
        return Apn.TYPE_NET;
    }

    private final void resetApn() {
        Apn apn2;
        try {
            NetworkState networkState = getNetworkState(true);
            int i3 = WhenMappings.$EnumSwitchMapping$5[networkState.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    apn2 = getApn(networkState);
                } else {
                    apn2 = Apn.TYPE_UNKNOWN;
                }
            } else {
                apn2 = Apn.TYPE_WIFI;
            }
        } catch (Exception e16) {
            Log.w(TAG, e16 + ": cannot get apn from network state, so use default");
            apn2 = Apn.TYPE_UNKNOWN;
        }
        apn = apn2;
    }

    @NotNull
    public final NetworkState getNetworkState(boolean fetchMobileDetailState) {
        Object obj;
        Context globalContext = ContextUtil.getGlobalContext();
        Object obj2 = null;
        if (globalContext != null) {
            obj = globalContext.getSystemService("connectivity");
        } else {
            obj = null;
        }
        if (obj instanceof ConnectivityManager) {
            obj2 = obj;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) obj2;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (isWiFiType(connectivityManager, activeNetworkInfo)) {
                    return NetworkState.NETWORK_WIFI;
                }
                if (fetchMobileDetailState) {
                    return getMobileDetailState();
                }
                return NetworkState.NETWORK_MOBILE;
            }
            return NetworkState.NETWORK_NONE;
        }
        return NetworkState.NETWORK_NONE;
    }

    @Nullable
    public final String getOperatorName() {
        Object obj;
        Context globalContext = ContextUtil.getGlobalContext();
        if (globalContext != null) {
            obj = globalContext.getSystemService("phone");
        } else {
            obj = null;
        }
        if (!(obj instanceof TelephonyManager)) {
            obj = null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) obj;
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getSimOperatorName();
    }

    public final void init() {
        synchronized (NetworkWatcher.class) {
            if (!isInited) {
                Context globalContext = ContextUtil.getGlobalContext();
                if (globalContext != null) {
                    try {
                        globalContext.registerReceiver(netStatusReceive, new IntentFilter(ACTION_CONN_CHANGE));
                    } catch (Throwable th5) {
                        Logger.f365497g.e(TAG, "unInit, " + th5);
                    }
                }
                handler = new Handler(ThreadManager.INSTANCE.getMonitorThreadLooper());
                isInited = true;
                INSTANCE.checkConnInfo();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean isNetAvailable() {
        return isNetAvailable;
    }

    public final boolean isNetworkConnectedRealtime() {
        if (getNetworkState(false) == NetworkState.NETWORK_NONE) {
            return false;
        }
        return true;
    }

    public final boolean isWiFiConnectedRealtime() {
        if (getNetworkState(false) != NetworkState.NETWORK_WIFI) {
            return false;
        }
        return true;
    }

    public final boolean isWifiAvailable() {
        return isWifiAvailable;
    }

    public final void registerListener(@NotNull INetworkStateListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (mListeners == null) {
            mListeners = new HashSet<>();
        }
        HashSet<INetworkStateListener> hashSet = mListeners;
        if (hashSet != null) {
            if (hashSet == null) {
                Intrinsics.throwNpe();
            }
            if (!hashSet.contains(listener)) {
                HashSet<INetworkStateListener> hashSet2 = mListeners;
                if (hashSet2 == null) {
                    Intrinsics.throwNpe();
                }
                hashSet2.add(listener);
            }
        }
    }

    public final void setNetAvailable(boolean z16) {
        isNetAvailable = z16;
    }

    public final void setWifiAvailable(boolean z16) {
        isWifiAvailable = z16;
    }

    public final void unInit() {
        synchronized (NetworkWatcher.class) {
            if (isInited) {
                try {
                    Context globalContext = ContextUtil.getGlobalContext();
                    if (globalContext != null) {
                        globalContext.unregisterReceiver(netStatusReceive);
                    }
                } catch (IllegalArgumentException e16) {
                    Logger.f365497g.e(TAG, "unInit, " + e16);
                }
                isInited = false;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Apn getApn(NetworkState networkState) {
        Apn processApn;
        String operatorName = getOperatorName();
        return (operatorName == null || (processApn = INSTANCE.processApn(operatorName, networkState)) == null) ? Apn.TYPE_NET : processApn;
    }
}
