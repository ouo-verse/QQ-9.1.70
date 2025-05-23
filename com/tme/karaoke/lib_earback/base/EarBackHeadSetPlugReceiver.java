package com.tme.karaoke.lib_earback.base;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.component.utils.LogUtil;
import com.tme.karaoke.lib_earback.base.a;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tme/karaoke/lib_earback/base/EarBackHeadSetPlugReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/tme/karaoke/lib_earback/base/e;", "listener", "a", "", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "headSetPlugListenerList", "<init>", "()V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class EarBackHeadSetPlugReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "EarBackHeadSetPlugReceiver";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<e> headSetPlugListenerList = new CopyOnWriteArrayList<>();

    public final void a(@NotNull e listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (!this.headSetPlugListenerList.contains(listener)) {
            this.headSetPlugListenerList.add(listener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e5  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String action;
        boolean z16;
        HeadPhoneStatus headPhoneStatus;
        long currentTimeMillis;
        BluetoothAdapter defaultAdapter;
        int i3;
        boolean z17;
        Object invoke;
        if (context != null && intent != null && (action = intent.getAction()) != null) {
            String str = this.TAG + " onReceive>>>";
            c.m("in " + this.TAG + ",receive action = " + action);
            try {
                boolean z18 = false;
                if (!Intrinsics.areEqual(action, "android.intent.action.HEADSET_PLUG") && !Intrinsics.areEqual(action, "android.bluetooth.device.action.ACL_CONNECTED") && !Intrinsics.areEqual(action, "android.bluetooth.device.action.ACL_DISCONNECTED") && !Intrinsics.areEqual(action, "android.bluetooth.adapter.action.STATE_CHANGED")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    int a16 = d.a();
                    if (a16 != 1) {
                        if (a16 != 2) {
                            if (a16 != 3) {
                                Iterator<T> it = this.headSetPlugListenerList.iterator();
                                while (it.hasNext()) {
                                    ((e) it.next()).b(HeadPhoneStatus.Speaker);
                                }
                                return;
                            }
                            c.m("RecordHeadphoneModule before getDeviceInfo,judge is bluetooth,then get address");
                            try {
                                currentTimeMillis = System.currentTimeMillis();
                                defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                            } catch (Throwable th5) {
                                th = th5;
                                z18 = true;
                                if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                                }
                                c.m("exception occur in try," + th.getMessage());
                                th.printStackTrace();
                                Unit unit = Unit.INSTANCE;
                                while (r10.hasNext()) {
                                }
                                return;
                            }
                            if (defaultAdapter != null) {
                                try {
                                    i3 = defaultAdapter.getProfileConnectionState(1);
                                } catch (SecurityException e16) {
                                    LogUtil.e(this.TAG, "tryConnectSabin e.getCause = " + e16.getCause());
                                    LogUtil.e(this.TAG, "tryConnectSabin e.getMessage = " + e16.getMessage());
                                    i3 = 0;
                                }
                                if (i3 == 2) {
                                    Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                                    if (bondedDevices != null && bondedDevices.size() > 0) {
                                        boolean z19 = true;
                                        for (BluetoothDevice bluetooth : bondedDevices) {
                                            try {
                                                String str2 = this.TAG;
                                                StringBuilder sb5 = new StringBuilder();
                                                sb5.append("getHeadSetInfo -> ");
                                                Intrinsics.checkExpressionValueIsNotNull(bluetooth, "bluetooth");
                                                sb5.append(bluetooth.getName());
                                                sb5.append(", ");
                                                sb5.append(bluetooth.getAddress());
                                                LogUtil.i(str2, sb5.toString());
                                                try {
                                                    Method isConnectedMethod = BluetoothDevice.class.getDeclaredMethod("isConnected", new Class[0]);
                                                    Intrinsics.checkExpressionValueIsNotNull(isConnectedMethod, "isConnectedMethod");
                                                    isConnectedMethod.setAccessible(true);
                                                    invoke = isConnectedMethod.invoke(bluetooth, new Object[0]);
                                                } catch (Exception e17) {
                                                    c.m("try call isConnected method,but faied");
                                                    e17.printStackTrace();
                                                    z17 = false;
                                                }
                                                if (invoke != null) {
                                                    z17 = ((Boolean) invoke).booleanValue();
                                                    if (z17) {
                                                        StringBuilder sb6 = new StringBuilder();
                                                        sb6.append("bluetoothdevices is connecting,find it>>>");
                                                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                                        String format = String.format("Bluetooth:[Address:%s, Name:%s]", Arrays.copyOf(new Object[]{bluetooth.getAddress(), bluetooth.getName()}, 2));
                                                        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                                                        sb6.append(format);
                                                        c.m(sb6.toString());
                                                    } else {
                                                        try {
                                                            LogUtil.i(this.TAG, "connect is false: ");
                                                            z19 = false;
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                                                            }
                                                            c.m("exception occur in try," + th.getMessage());
                                                            th.printStackTrace();
                                                            Unit unit2 = Unit.INSTANCE;
                                                            while (r10.hasNext()) {
                                                            }
                                                            return;
                                                        }
                                                    }
                                                } else {
                                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                                                    break;
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                                z18 = z19;
                                                if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                                                    c.m("need report");
                                                } else if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.b.f386972a)) {
                                                    c.m("EarBackErrorType report for otherearbacktype");
                                                }
                                                c.m("exception occur in try," + th.getMessage());
                                                th.printStackTrace();
                                                Unit unit22 = Unit.INSTANCE;
                                                while (r10.hasNext()) {
                                                }
                                                return;
                                            }
                                        }
                                        z18 = z19;
                                    }
                                }
                                c.m("getBluetoothContectedTime = " + (System.currentTimeMillis() - currentTimeMillis));
                                Unit unit3 = Unit.INSTANCE;
                                for (e eVar : this.headSetPlugListenerList) {
                                    if (z18) {
                                        headPhoneStatus = HeadPhoneStatus.BlueTooth;
                                    } else {
                                        headPhoneStatus = HeadPhoneStatus.Speaker;
                                    }
                                    eVar.b(headPhoneStatus);
                                }
                                return;
                            }
                            c.m("bluetoothAdapter is null");
                            z18 = true;
                            c.m("getBluetoothContectedTime = " + (System.currentTimeMillis() - currentTimeMillis));
                            Unit unit32 = Unit.INSTANCE;
                            while (r10.hasNext()) {
                            }
                            return;
                        }
                        Iterator<T> it5 = this.headSetPlugListenerList.iterator();
                        while (it5.hasNext()) {
                            ((e) it5.next()).b(HeadPhoneStatus.Wired);
                        }
                        return;
                    }
                    Iterator<T> it6 = this.headSetPlugListenerList.iterator();
                    while (it6.hasNext()) {
                        ((e) it6.next()).b(HeadPhoneStatus.Speaker);
                    }
                    return;
                }
                c.m("don't support action name = " + action);
                throw new IllegalStateException(Unit.INSTANCE.toString());
            } catch (IllegalStateException unused) {
                c.m(str + "illageStateException occur");
            }
        }
    }
}
