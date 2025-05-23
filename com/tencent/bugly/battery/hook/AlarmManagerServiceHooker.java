package com.tencent.bugly.battery.hook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import com.tencent.bugly.battery.data.AlarmInfo;
import com.tencent.bugly.battery.hook.SystemServiceBinderHooker;
import com.tencent.bugly.matrix.util.MatrixLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class AlarmManagerServiceHooker {
    private static final String TAG = "Bugly.AlarmHooker";
    private static SystemServiceBinderHooker.HookCallback sHookCallback;
    private static SystemServiceBinderHooker sHookHelper;
    private static List<IListener> sListeners;
    private static boolean sTryHook;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class CancelArgs {
        AlarmManager.OnAlarmListener onAlarmListener;
        PendingIntent operation;

        CancelArgs() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class CancelArgsCompatible {
        CancelArgsCompatible() {
        }

        public static CancelArgs createCancelArgs(Object[] objArr) {
            if (objArr == null) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs args null", new Object[0]);
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            MatrixLog.i(AlarmManagerServiceHooker.TAG, "createCancelArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i3), Build.VERSION.CODENAME, Integer.valueOf(i3));
            return createCancelArgsAccordingToArgsLength(objArr);
        }

        private static CancelArgs createCancelArgs1(Object[] objArr) {
            if (objArr.length != 1) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs1 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            CancelArgs cancelArgs = new CancelArgs();
            Object obj = objArr[0];
            if (obj != null && !(obj instanceof PendingIntent)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs1 args idx 0 not PendingIntent, %s", obj);
                return null;
            }
            cancelArgs.operation = (PendingIntent) obj;
            return cancelArgs;
        }

        private static CancelArgs createCancelArgs2(Object[] objArr) {
            if (objArr.length != 2) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            CancelArgs cancelArgs = new CancelArgs();
            Object obj = objArr[0];
            if (obj != null && !(obj instanceof PendingIntent)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createCancelArgs2 args idx 0 not PendingIntent, %s", obj);
                return null;
            }
            cancelArgs.operation = (PendingIntent) obj;
            return cancelArgs;
        }

        private static CancelArgs createCancelArgsAccordingToArgsLength(Object[] objArr) {
            int length = objArr.length;
            MatrixLog.i(AlarmManagerServiceHooker.TAG, "createCancelArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
            if (length != 1) {
                return createCancelArgs2(objArr);
            }
            return createCancelArgs1(objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface IListener {
        void onAlarmRemove(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener);

        void onAlarmSet(AlarmInfo alarmInfo, long j3, long j16, int i3, AlarmManager.OnAlarmListener onAlarmListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class SetArgs {
        int flags;
        long intervalMillis;
        AlarmManager.OnAlarmListener onAlarmListener;
        PendingIntent operation;
        long triggerAtMillis;
        int type;
        long windowMillis;

        SetArgs() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class SetArgsCompatible {
        SetArgsCompatible() {
        }

        public static SetArgs createSetArgs(Object[] objArr) {
            if (objArr == null) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args null", new Object[0]);
                return null;
            }
            int i3 = Build.VERSION.SDK_INT;
            MatrixLog.i(AlarmManagerServiceHooker.TAG, "createSetArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(i3), Build.VERSION.CODENAME, Integer.valueOf(i3));
            return createSetArgsAccordingToArgsLength(objArr);
        }

        private static SetArgs createSetArgs11(Object[] objArr) {
            if (objArr.length != 11) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[1];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[2];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[3];
            if (!(obj3 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 3 not Long, %s", obj3);
                return null;
            }
            setArgs.windowMillis = ((Long) obj3).longValue();
            Object obj4 = objArr[4];
            if (!(obj4 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 4 not Long, %s", obj4);
                return null;
            }
            setArgs.intervalMillis = ((Long) obj4).longValue();
            Object obj5 = objArr[5];
            if (!(obj5 instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 5 not Integer, %s", obj5);
                return null;
            }
            setArgs.flags = ((Integer) obj5).intValue();
            Object obj6 = objArr[6];
            if (obj6 != null && !(obj6 instanceof PendingIntent)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 6 not PendingIntent, %s", obj6);
                return null;
            }
            setArgs.operation = (PendingIntent) obj6;
            return setArgs;
        }

        private static SetArgs createSetArgs3(Object[] objArr) {
            if (objArr.length != 3) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[0];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 0 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[2];
            if (obj3 != null && !(obj3 instanceof PendingIntent)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not PendingIntent, %s", obj3);
                return null;
            }
            setArgs.operation = (PendingIntent) obj3;
            return setArgs;
        }

        private static SetArgs createSetArgs4(Object[] objArr) {
            if (objArr.length != 4) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[0];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 0 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[2];
            if (!(obj3 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not Long, %s", obj3);
                return null;
            }
            setArgs.intervalMillis = ((Long) obj3).longValue();
            Object obj4 = objArr[3];
            if (obj4 != null && !(obj4 instanceof PendingIntent)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 3 not PendingIntent, %s", obj4);
                return null;
            }
            setArgs.operation = (PendingIntent) obj4;
            return setArgs;
        }

        private static SetArgs createSetArgs7or6(Object[] objArr) {
            if (objArr.length != 7 && objArr.length != 6) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[0];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 0 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[2];
            if (!(obj3 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not Long, %s", obj3);
                return null;
            }
            setArgs.windowMillis = ((Long) obj3).longValue();
            Object obj4 = objArr[3];
            if (!(obj4 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 3 not Long, %s", obj4);
                return null;
            }
            setArgs.intervalMillis = ((Long) obj4).longValue();
            Object obj5 = objArr[4];
            if (obj5 != null && !(obj5 instanceof PendingIntent)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 4 not PendingIntent, %s", obj5);
                return null;
            }
            setArgs.operation = (PendingIntent) obj5;
            return setArgs;
        }

        private static SetArgs createSetArgs8(Object[] objArr) {
            if (objArr.length != 8) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            SetArgs setArgs = new SetArgs();
            Object obj = objArr[0];
            if (!(obj instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 0 not Integer, %s", obj);
                return null;
            }
            setArgs.type = ((Integer) obj).intValue();
            Object obj2 = objArr[1];
            if (!(obj2 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 1 not Long, %s", obj2);
                return null;
            }
            setArgs.triggerAtMillis = ((Long) obj2).longValue();
            Object obj3 = objArr[2];
            if (!(obj3 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 2 not Long, %s", obj3);
                return null;
            }
            setArgs.windowMillis = ((Long) obj3).longValue();
            Object obj4 = objArr[3];
            if (!(obj4 instanceof Long)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 3 not Long, %s", obj4);
                return null;
            }
            setArgs.intervalMillis = ((Long) obj4).longValue();
            Object obj5 = objArr[4];
            if (!(obj5 instanceof Integer)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 4 not Integer, %s", obj5);
                return null;
            }
            setArgs.flags = ((Integer) obj5).intValue();
            Object obj6 = objArr[5];
            if (obj6 != null && !(obj6 instanceof PendingIntent)) {
                MatrixLog.w(AlarmManagerServiceHooker.TAG, "createSetArgs args idx 5 not PendingIntent, %s", obj6);
                return null;
            }
            setArgs.operation = (PendingIntent) obj6;
            return setArgs;
        }

        private static SetArgs createSetArgsAccordingToArgsLength(Object[] objArr) {
            int length = objArr.length;
            MatrixLog.i(AlarmManagerServiceHooker.TAG, "createSetArgsAccordingToArgsLength: length:%s", Integer.valueOf(length));
            if (length != 3) {
                if (length != 4) {
                    if (length != 6 && length != 7) {
                        if (length != 8) {
                            return createSetArgs11(objArr);
                        }
                        return createSetArgs8(objArr);
                    }
                    return createSetArgs7or6(objArr);
                }
                return createSetArgs4(objArr);
            }
            return createSetArgs3(objArr);
        }
    }

    static {
        SystemServiceBinderHooker.HookCallback hookCallback = new SystemServiceBinderHooker.HookCallback() { // from class: com.tencent.bugly.battery.hook.AlarmManagerServiceHooker.1
            @Override // com.tencent.bugly.battery.hook.SystemServiceBinderHooker.HookCallback
            @Nullable
            public Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) {
                return null;
            }

            @Override // com.tencent.bugly.battery.hook.SystemServiceBinderHooker.HookCallback
            public void onServiceMethodInvoke(Method method, Object[] objArr) {
                MatrixLog.v(AlarmManagerServiceHooker.TAG, "onServiceMethodInvoke: method name %s", method.getName());
                AlarmManagerServiceHooker.dispatchListeners(method, objArr);
            }
        };
        sHookCallback = hookCallback;
        sHookHelper = new SystemServiceBinderHooker(NotificationCompat.CATEGORY_ALARM, "android.app.IAlarmManager", hookCallback);
        sListeners = new ArrayList();
    }

    public static synchronized void addListener(IListener iListener) {
        synchronized (AlarmManagerServiceHooker.class) {
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

    private static void dispatchCancel(Object[] objArr) {
        CancelArgs createCancelArgs = CancelArgsCompatible.createCancelArgs(objArr);
        if (createCancelArgs == null) {
            MatrixLog.w(TAG, "dispatchCancel cancelArgs null", new Object[0]);
            return;
        }
        synchronized (AlarmManagerServiceHooker.class) {
            for (int i3 = 0; i3 < sListeners.size(); i3++) {
                sListeners.get(i3).onAlarmRemove(createCancelArgs.operation, createCancelArgs.onAlarmListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchListeners(Method method, Object[] objArr) {
        if (!method.getName().equals("set") && !method.getName().equals("setRepeating") && !method.getName().equals("setInexactRepeating")) {
            if (method.getName().equals("remove")) {
                dispatchCancel(objArr);
                return;
            }
            return;
        }
        dispatchSet(objArr);
    }

    private static void dispatchSet(Object[] objArr) {
        SetArgs createSetArgs = SetArgsCompatible.createSetArgs(objArr);
        if (createSetArgs == null) {
            MatrixLog.w(TAG, "dispatchSet setArgs null", new Object[0]);
            return;
        }
        synchronized (AlarmManagerServiceHooker.class) {
            AlarmInfo alarmInfo = new AlarmInfo();
            alarmInfo.type = createSetArgs.type;
            alarmInfo.operation = createSetArgs.operation;
            alarmInfo.triggerAtMillis = createSetArgs.triggerAtMillis;
            alarmInfo.onAlarmListener = createSetArgs.onAlarmListener;
            for (int i3 = 0; i3 < sListeners.size(); i3++) {
                sListeners.get(i3).onAlarmSet(alarmInfo, createSetArgs.windowMillis, createSetArgs.intervalMillis, createSetArgs.flags, createSetArgs.onAlarmListener);
            }
        }
    }

    public static synchronized void release() {
        synchronized (AlarmManagerServiceHooker.class) {
            sListeners.clear();
            checkUnHook();
        }
    }

    public static synchronized void removeListener(IListener iListener) {
        synchronized (AlarmManagerServiceHooker.class) {
            if (iListener == null) {
                return;
            }
            sListeners.remove(iListener);
            checkUnHook();
        }
    }
}
