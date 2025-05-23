package com.tencent.bugly.battery.hook;

import android.app.PendingIntent;
import android.support.annotation.AnyThread;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.tencent.bugly.battery.data.LocationInfo;
import com.tencent.bugly.battery.hook.SystemServiceBinderHooker;
import com.tencent.bugly.matrix.util.MatrixLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public final class LocationManagerServiceHooker {
    private static final String TAG = "Bugly.LocationHooker";
    private static SystemServiceBinderHooker.HookCallback sHookCallback;
    private static SystemServiceBinderHooker sHookHelper;
    private static List<IListener> sListeners = new ArrayList();
    private static boolean sTryHook;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface IListener {
        @AnyThread
        void onRemoveLocationUpdates(int i3, PendingIntent pendingIntent);

        @AnyThread
        void onRequestLocationUpdates(LocationInfo locationInfo, long j3, float f16);
    }

    static {
        SystemServiceBinderHooker.HookCallback hookCallback = new SystemServiceBinderHooker.HookCallback() { // from class: com.tencent.bugly.battery.hook.LocationManagerServiceHooker.1
            @Override // com.tencent.bugly.battery.hook.SystemServiceBinderHooker.HookCallback
            @Nullable
            public Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) {
                return null;
            }

            @Override // com.tencent.bugly.battery.hook.SystemServiceBinderHooker.HookCallback
            public void onServiceMethodInvoke(Method method, Object[] objArr) {
                if ("requestLocationUpdates".equals(method.getName())) {
                    LocationManagerServiceHooker.dispatchRequestLocationUpdates(objArr);
                } else if ("removeUpdates".equals(method.getName())) {
                    LocationManagerServiceHooker.dispatchRemoveLocationUpdates(objArr);
                }
            }
        };
        sHookCallback = hookCallback;
        sHookHelper = new SystemServiceBinderHooker("location", "android.location.ILocationManager", hookCallback);
    }

    public static synchronized void addListener(IListener iListener) {
        synchronized (LocationManagerServiceHooker.class) {
            if (iListener == null) {
                return;
            }
            if (sListeners.contains(iListener)) {
                return;
            }
            sListeners.add(iListener);
            checkHook();
        }
    }

    private static void checkHook() {
        if (sTryHook || sListeners.isEmpty()) {
            return;
        }
        MatrixLog.i(TAG, "checkHook hookRet:%b", Boolean.valueOf(sHookHelper.doHook()));
        sTryHook = true;
    }

    private static void checkUnHook() {
        if (!sTryHook || !sListeners.isEmpty()) {
            return;
        }
        MatrixLog.i(TAG, "checkUnHook unHookRet:%b", Boolean.valueOf(sHookHelper.doUnHook()));
        sTryHook = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchRemoveLocationUpdates(Object[] objArr) {
        Object obj;
        if (objArr != null && objArr.length >= 1) {
            if (objArr[0] != null) {
                Iterator<IListener> it = sListeners.iterator();
                while (it.hasNext()) {
                    it.next().onRemoveLocationUpdates(objArr[0].hashCode(), null);
                }
            } else if (objArr.length > 1 && (obj = objArr[1]) != null && "android.app.PendingIntent".equals(obj.getClass().getName())) {
                Iterator<IListener> it5 = sListeners.iterator();
                while (it5.hasNext()) {
                    it5.next().onRemoveLocationUpdates(0, (PendingIntent) objArr[1]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchRequestLocationUpdates(Object[] objArr) {
        Object obj;
        Object obj2;
        LocationInfo locationInfo = new LocationInfo();
        long j3 = -1;
        float f16 = -1.0f;
        if (objArr != null) {
            for (Object obj3 : objArr) {
                if (obj3 != null && "android.location.LocationRequest".equals(obj3.getClass().getName())) {
                    try {
                        Method declaredMethod = obj3.getClass().getDeclaredMethod("getFastestInterval", new Class[0]);
                        declaredMethod.setAccessible(true);
                        j3 = ((Long) declaredMethod.invoke(obj3, new Object[0])).longValue();
                        Method declaredMethod2 = obj3.getClass().getDeclaredMethod("getSmallestDisplacement", new Class[0]);
                        declaredMethod2.setAccessible(true);
                        f16 = ((Float) declaredMethod2.invoke(obj3, new Object[0])).floatValue();
                    } catch (Throwable th5) {
                        MatrixLog.printErrStackTrace(TAG, th5, "", new Object[0]);
                    }
                }
            }
            if (objArr.length > 1 && (obj2 = objArr[1]) != null && "android.location.LocationManager$LocationListenerTransport".equals(obj2.getClass().getName())) {
                locationInfo.locationListener = objArr[1].hashCode();
            }
            if (objArr.length > 2 && (obj = objArr[2]) != null && "android.app.PendingIntent".equals(obj.getClass().getName())) {
                locationInfo.pendingIntent = (PendingIntent) objArr[2];
            }
        }
        if (locationInfo.pendingIntent != null || locationInfo.locationListener != 0) {
            Iterator<IListener> it = sListeners.iterator();
            while (it.hasNext()) {
                it.next().onRequestLocationUpdates(locationInfo, j3, f16);
            }
        }
    }

    public static synchronized void release() {
        synchronized (LocationManagerServiceHooker.class) {
            sListeners.clear();
            checkUnHook();
        }
    }

    public static synchronized void removeListener(IListener iListener) {
        synchronized (LocationManagerServiceHooker.class) {
            if (iListener == null) {
                return;
            }
            sListeners.remove(iListener);
            checkUnHook();
        }
    }
}
