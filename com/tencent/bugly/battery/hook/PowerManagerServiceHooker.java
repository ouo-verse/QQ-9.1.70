package com.tencent.bugly.battery.hook;

import android.os.Build;
import android.os.IBinder;
import android.os.WorkSource;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.tencent.bugly.battery.data.WakeLockInfo;
import com.tencent.bugly.battery.hook.SystemServiceBinderHooker;
import com.tencent.bugly.matrix.util.MatrixLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public final class PowerManagerServiceHooker {
    private static final String TAG = "Bugly.PowerHooker";
    private static SystemServiceBinderHooker.HookCallback sHookCallback;
    private static SystemServiceBinderHooker sHookHelper;
    private static List<IListener> sListeners = new ArrayList();
    private static boolean sTryHook;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AcquireWakeLockArgs {
        int flags;
        String historyTag;
        String packageName;
        String tag;
        IBinder token;

        /* renamed from: ws, reason: collision with root package name */
        WorkSource f97810ws;

        AcquireWakeLockArgs() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AcquireWakeLockArgsCompatible {
        AcquireWakeLockArgsCompatible() {
        }

        public static AcquireWakeLockArgs createAcquireWakeLockArgs(Object[] objArr) {
            if (objArr == null) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs args null", new Object[0]);
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            MatrixLog.i(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i3), Build.VERSION.CODENAME, Integer.valueOf(i3));
            return createAcquireWakeLockArgsAccordingToArgsLength(objArr);
        }

        private static AcquireWakeLockArgs createAcquireWakeLockArgs4(Object[] objArr) {
            if (objArr.length != 4) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs4 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            AcquireWakeLockArgs acquireWakeLockArgs = new AcquireWakeLockArgs();
            Object obj = objArr[2];
            if (obj != null && !(obj instanceof String)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 2 not String, %s", obj);
                return null;
            }
            acquireWakeLockArgs.tag = (String) obj;
            Object obj2 = objArr[3];
            if (obj2 != null && !(obj2 instanceof WorkSource)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 3 not WorkSource, %s", obj2);
                return null;
            }
            acquireWakeLockArgs.f97810ws = (WorkSource) obj2;
            Object obj3 = objArr[0];
            if (obj3 instanceof Integer) {
                acquireWakeLockArgs.flags = ((Integer) obj3).intValue();
                Object obj4 = objArr[1];
                if (!(obj4 instanceof IBinder)) {
                    MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 1 not IBinder, %s", obj4);
                    return null;
                }
                acquireWakeLockArgs.token = (IBinder) obj4;
            } else if (obj3 instanceof IBinder) {
                acquireWakeLockArgs.token = (IBinder) obj3;
                Object obj5 = objArr[1];
                if (!(obj5 instanceof Integer)) {
                    MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs4 args idx 1 not Integer, %s", obj5);
                    return null;
                }
                acquireWakeLockArgs.flags = ((Integer) obj5).intValue();
            } else {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs4 args idx 0 not IBinder an Integer, %s", obj3);
                return null;
            }
            return acquireWakeLockArgs;
        }

        private static AcquireWakeLockArgs createAcquireWakeLockArgsAbove4(Object[] objArr) {
            AcquireWakeLockArgs acquireWakeLockArgs = new AcquireWakeLockArgs();
            Object obj = objArr[0];
            if (!(obj instanceof IBinder)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 0 not IBinder, %s", obj);
                return null;
            }
            acquireWakeLockArgs.token = (IBinder) obj;
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Integer)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 1 not Integer, %s", obj2);
                return null;
            }
            acquireWakeLockArgs.flags = ((Integer) obj2).intValue();
            Object obj3 = objArr[2];
            if (obj3 != null && !(obj3 instanceof String)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 2 not String, %s", obj3);
                return null;
            }
            acquireWakeLockArgs.tag = (String) obj3;
            Object obj4 = objArr[3];
            if (obj4 != null && !(obj4 instanceof String)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 3 not String, %s", obj4);
                return null;
            }
            acquireWakeLockArgs.packageName = (String) obj4;
            Object obj5 = objArr[4];
            if (obj5 != null && !(obj5 instanceof WorkSource)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 4 not WorkSource, %s", obj5);
                return null;
            }
            acquireWakeLockArgs.f97810ws = (WorkSource) obj5;
            if (objArr.length == 5) {
                return acquireWakeLockArgs;
            }
            Object obj6 = objArr[5];
            if (obj6 != null && !(obj6 instanceof String)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgs6 args idx 5 not String, %s", obj6);
                return null;
            }
            acquireWakeLockArgs.historyTag = (String) obj6;
            return acquireWakeLockArgs;
        }

        private static AcquireWakeLockArgs createAcquireWakeLockArgsAccordingToArgsLength(Object[] objArr) {
            int length = objArr.length;
            MatrixLog.i(PowerManagerServiceHooker.TAG, "createAcquireWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
            if (length != 4) {
                return createAcquireWakeLockArgsAbove4(objArr);
            }
            return createAcquireWakeLockArgs4(objArr);
        }
    }

    /* loaded from: classes5.dex */
    public interface IListener {
        void onAcquireWakeLock(WakeLockInfo wakeLockInfo, String str, @Nullable WorkSource workSource, @Nullable String str2);

        void onReleaseWakeLock(IBinder iBinder, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ReleaseWakeLockArgs {
        int flags;
        IBinder token;

        ReleaseWakeLockArgs() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ReleaseWakeLockArgsCompatible {
        ReleaseWakeLockArgsCompatible() {
        }

        public static ReleaseWakeLockArgs createReleaseWakeLockArgs(Object[] objArr) {
            if (objArr == null) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs args null", new Object[0]);
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            MatrixLog.i(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i3), Build.VERSION.CODENAME, Integer.valueOf(i3));
            return createReleaseWakeLockArgsAccordingToArgsLength(objArr);
        }

        private static ReleaseWakeLockArgs createReleaseWakeLockArgs2(Object[] objArr) {
            if (objArr.length != 2) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            ReleaseWakeLockArgs releaseWakeLockArgs = new ReleaseWakeLockArgs();
            Object obj = objArr[0];
            if (!(obj instanceof IBinder)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs2 args idx 0 not IBinder, %s", obj);
                return null;
            }
            releaseWakeLockArgs.token = (IBinder) obj;
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Integer)) {
                MatrixLog.w(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgs2 args idx 1 not Integer, %s", obj2);
                return null;
            }
            releaseWakeLockArgs.flags = ((Integer) obj2).intValue();
            return releaseWakeLockArgs;
        }

        private static ReleaseWakeLockArgs createReleaseWakeLockArgsAccordingToArgsLength(Object[] objArr) {
            MatrixLog.i(PowerManagerServiceHooker.TAG, "createReleaseWakeLockArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
            return createReleaseWakeLockArgs2(objArr);
        }
    }

    static {
        SystemServiceBinderHooker.HookCallback hookCallback = new SystemServiceBinderHooker.HookCallback() { // from class: com.tencent.bugly.battery.hook.PowerManagerServiceHooker.1
            @Override // com.tencent.bugly.battery.hook.SystemServiceBinderHooker.HookCallback
            @Nullable
            public Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) {
                return null;
            }

            @Override // com.tencent.bugly.battery.hook.SystemServiceBinderHooker.HookCallback
            public void onServiceMethodInvoke(Method method, Object[] objArr) {
                MatrixLog.v(PowerManagerServiceHooker.TAG, "onServiceMethodInvoke: method name %s", method.getName());
                PowerManagerServiceHooker.dispatchListeners(method, objArr);
            }
        };
        sHookCallback = hookCallback;
        sHookHelper = new SystemServiceBinderHooker("power", "android.os.IPowerManager", hookCallback);
    }

    public static synchronized void addListener(IListener iListener) {
        synchronized (PowerManagerServiceHooker.class) {
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

    private static void dispatchAcquireWakeLock(Object[] objArr) {
        AcquireWakeLockArgs createAcquireWakeLockArgs = AcquireWakeLockArgsCompatible.createAcquireWakeLockArgs(objArr);
        if (createAcquireWakeLockArgs == null) {
            MatrixLog.w(TAG, "dispatchAcquireWakeLock AcquireWakeLockArgs null", new Object[0]);
            return;
        }
        synchronized (PowerManagerServiceHooker.class) {
            WakeLockInfo wakeLockInfo = new WakeLockInfo();
            wakeLockInfo.flags = createAcquireWakeLockArgs.flags;
            wakeLockInfo.tag = createAcquireWakeLockArgs.tag;
            wakeLockInfo.token = createAcquireWakeLockArgs.token;
            for (int i3 = 0; i3 < sListeners.size(); i3++) {
                sListeners.get(i3).onAcquireWakeLock(wakeLockInfo, createAcquireWakeLockArgs.packageName, createAcquireWakeLockArgs.f97810ws, createAcquireWakeLockArgs.historyTag);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchListeners(Method method, Object[] objArr) {
        if (method.getName().equals("acquireWakeLock")) {
            dispatchAcquireWakeLock(objArr);
        } else if (method.getName().equals("releaseWakeLock")) {
            dispatchReleaseWakeLock(objArr);
        }
    }

    private static void dispatchReleaseWakeLock(Object[] objArr) {
        ReleaseWakeLockArgs createReleaseWakeLockArgs = ReleaseWakeLockArgsCompatible.createReleaseWakeLockArgs(objArr);
        if (createReleaseWakeLockArgs == null) {
            MatrixLog.w(TAG, "dispatchReleaseWakeLock AcquireWakeLockArgs null", new Object[0]);
            return;
        }
        synchronized (PowerManagerServiceHooker.class) {
            for (int i3 = 0; i3 < sListeners.size(); i3++) {
                sListeners.get(i3).onReleaseWakeLock(createReleaseWakeLockArgs.token, createReleaseWakeLockArgs.flags);
            }
        }
    }

    public static synchronized void release() {
        synchronized (PowerManagerServiceHooker.class) {
            sListeners.clear();
            checkUnHook();
        }
    }

    public static synchronized void removeListener(IListener iListener) {
        synchronized (PowerManagerServiceHooker.class) {
            if (iListener == null) {
                return;
            }
            sListeners.remove(iListener);
            checkUnHook();
        }
    }
}
