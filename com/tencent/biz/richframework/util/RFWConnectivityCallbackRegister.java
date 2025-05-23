package com.tencent.biz.richframework.util;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/richframework/util/RFWConnectivityCallbackRegister;", "", "", "registerKey", "Landroid/net/ConnectivityManager$NetworkCallback;", "callback", "", "registerNetworkCallback", "", "unregisterNetworkCallback", "", "listeners", "Ljava/util/Set;", "listenerLock", "Ljava/lang/Object;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "registerSet", "Ljava/util/HashSet;", "com/tencent/biz/richframework/util/RFWConnectivityCallbackRegister$networkCallback$1", "networkCallback", "Lcom/tencent/biz/richframework/util/RFWConnectivityCallbackRegister$networkCallback$1;", "Landroid/net/ConnectivityManager;", "connectivityManager$delegate", "Lkotlin/Lazy;", "getConnectivityManager", "()Landroid/net/ConnectivityManager;", "connectivityManager", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWConnectivityCallbackRegister {

    /* renamed from: connectivityManager$delegate, reason: from kotlin metadata */
    @Nullable
    private static final Lazy connectivityManager;

    @NotNull
    public static final RFWConnectivityCallbackRegister INSTANCE = new RFWConnectivityCallbackRegister();
    private static final Set<ConnectivityManager.NetworkCallback> listeners = new LinkedHashSet();
    private static final Object listenerLock = new Object();
    private static final HashSet<String> registerSet = new HashSet<>();
    private static final RFWConnectivityCallbackRegister$networkCallback$1 networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.tencent.biz.richframework.util.RFWConnectivityCallbackRegister$networkCallback$1
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            Object obj;
            Set set;
            Intrinsics.checkNotNullParameter(network, "network");
            RFWConnectivityCallbackRegister rFWConnectivityCallbackRegister = RFWConnectivityCallbackRegister.INSTANCE;
            obj = RFWConnectivityCallbackRegister.listenerLock;
            synchronized (obj) {
                set = RFWConnectivityCallbackRegister.listeners;
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((ConnectivityManager.NetworkCallback) it.next()).onAvailable(network);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NotNull Network network) {
            Object obj;
            Set set;
            Intrinsics.checkNotNullParameter(network, "network");
            RFWConnectivityCallbackRegister rFWConnectivityCallbackRegister = RFWConnectivityCallbackRegister.INSTANCE;
            obj = RFWConnectivityCallbackRegister.listenerLock;
            synchronized (obj) {
                set = RFWConnectivityCallbackRegister.listeners;
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((ConnectivityManager.NetworkCallback) it.next()).onLost(network);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    };

    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.biz.richframework.util.RFWConnectivityCallbackRegister$networkCallback$1] */
    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConnectivityManager>() { // from class: com.tencent.biz.richframework.util.RFWConnectivityCallbackRegister$connectivityManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ConnectivityManager invoke() {
                Object systemService = RFWApplication.getApplication().getSystemService("connectivity");
                if (!(systemService instanceof ConnectivityManager)) {
                    systemService = null;
                }
                return (ConnectivityManager) systemService;
            }
        });
        connectivityManager = lazy;
    }

    RFWConnectivityCallbackRegister() {
    }

    @Nullable
    public final ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) connectivityManager.getValue();
    }

    public final boolean registerNetworkCallback(@NotNull String registerKey, @NotNull ConnectivityManager.NetworkCallback callback) {
        Intrinsics.checkNotNullParameter(registerKey, "registerKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (listenerLock) {
            listeners.add(callback);
            HashSet<String> hashSet = registerSet;
            if (hashSet.contains(registerKey)) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ConnectivityManager connectivityManager2 = INSTANCE.getConnectivityManager();
                    if (connectivityManager2 != null) {
                        connectivityManager2.registerDefaultNetworkCallback(networkCallback);
                    }
                    hashSet.add(registerKey);
                    return true;
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(Result.m476constructorimpl(ResultKt.createFailure(th5)));
                    if (m479exceptionOrNullimpl != null) {
                        RFWLog.e("RFWConnectivityCallbackRegister", RFWLog.USR, "registerDefaultNetworkCallback failed: " + m479exceptionOrNullimpl.getMessage());
                    }
                    return false;
                }
            }
            RFWConnectivityCallbackRegister rFWConnectivityCallbackRegister = INSTANCE;
            try {
                Result.Companion companion3 = Result.INSTANCE;
                NetworkRequest build = new NetworkRequest.Builder().build();
                Intrinsics.checkNotNullExpressionValue(build, "NetworkRequest.Builder().build()");
                ConnectivityManager connectivityManager3 = rFWConnectivityCallbackRegister.getConnectivityManager();
                if (connectivityManager3 != null) {
                    connectivityManager3.registerNetworkCallback(build, networkCallback);
                }
                hashSet.add(registerKey);
                return true;
            } catch (Throwable th6) {
                Result.Companion companion4 = Result.INSTANCE;
                Throwable m479exceptionOrNullimpl2 = Result.m479exceptionOrNullimpl(Result.m476constructorimpl(ResultKt.createFailure(th6)));
                if (m479exceptionOrNullimpl2 != null) {
                    RFWLog.e("RFWConnectivityCallbackRegister", RFWLog.USR, "registerNetworkCallback failed: " + m479exceptionOrNullimpl2.getMessage());
                }
                return false;
            }
        }
    }

    public final void unregisterNetworkCallback(@NotNull String registerKey, @NotNull ConnectivityManager.NetworkCallback callback) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(registerKey, "registerKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (listenerLock) {
            Set<ConnectivityManager.NetworkCallback> set = listeners;
            set.remove(callback);
            if (set.isEmpty()) {
                HashSet<String> hashSet = registerSet;
                if (hashSet.contains(registerKey)) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        ConnectivityManager connectivityManager2 = INSTANCE.getConnectivityManager();
                        if (connectivityManager2 != null) {
                            connectivityManager2.unregisterNetworkCallback(networkCallback);
                        }
                        m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(hashSet.remove(registerKey)));
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != null) {
                        RFWLog.e("RFWConnectivityCallbackRegister", RFWLog.USR, "unregisterNetworkCallback failed: " + m479exceptionOrNullimpl.getMessage());
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
