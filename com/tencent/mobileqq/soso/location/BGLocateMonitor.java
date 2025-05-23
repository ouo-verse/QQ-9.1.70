package com.tencent.mobileqq.soso.location;

import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.location.LocationManager;
import android.os.IBinder;
import android.os.IInterface;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.bo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BGLocateMonitor {
    static IPatchRedirector $redirector_ = null;
    private static final String[] LOCATION_MANAGER_METHOD_LIST;
    private static final String TAG = "BGLocateMonitor";
    private static final String[] TELEPHONY_MANAGER_METHOD_LIST;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class ILocationManagerProxy implements InvocationHandler {
        static IPatchRedirector $redirector_;
        Object mBase;

        ILocationManagerProxy(IBinder iBinder, Class<?> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder, (Object) cls);
                return;
            }
            try {
                this.mBase = cls.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            } catch (Exception e16) {
                QLog.d(BGLocateMonitor.TAG, 1, "FixBinder init", e16);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, this, obj, method, objArr);
            }
            ThreadManagerV2.excute(new Runnable(method) { // from class: com.tencent.mobileqq.soso.location.BGLocateMonitor.ILocationManagerProxy.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Method val$method;

                {
                    this.val$method = method;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ILocationManagerProxy.this, (Object) method);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (BGLocateMonitor.needReport(this.val$method.getName(), BGLocateMonitor.LOCATION_MANAGER_METHOD_LIST)) {
                        BGLocateMonitor.report(this.val$method.getName());
                    }
                }
            }, 16, null, true);
            return method.invoke(this.mBase, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class ITelephonyManagerProxy implements InvocationHandler {
        static IPatchRedirector $redirector_;
        Object mBase;

        ITelephonyManagerProxy(IBinder iBinder, Class<?> cls) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder, (Object) cls);
                return;
            }
            try {
                this.mBase = cls.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
            } catch (Exception e16) {
                QLog.d(BGLocateMonitor.TAG, 1, "ITelephonyManagerProxy init", e16);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, this, obj, method, objArr);
            }
            ThreadManagerV2.excute(new Runnable(method) { // from class: com.tencent.mobileqq.soso.location.BGLocateMonitor.ITelephonyManagerProxy.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Method val$method;

                {
                    this.val$method = method;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ITelephonyManagerProxy.this, (Object) method);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (BGLocateMonitor.needReport(this.val$method.getName(), BGLocateMonitor.TELEPHONY_MANAGER_METHOD_LIST)) {
                        BGLocateMonitor.report(this.val$method.getName());
                    }
                }
            }, 16, null, true);
            return method.invoke(this.mBase, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class LocationBinderProxy implements InvocationHandler {
        static IPatchRedirector $redirector_;
        IBinder mBase;
        Class<?> mInterface;
        Class<?> mStub;

        LocationBinderProxy(IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                return;
            }
            this.mBase = iBinder;
            try {
                this.mStub = Class.forName("android.location.ILocationManager$Stub");
                this.mInterface = Class.forName("android.location.ILocationManager");
            } catch (Exception e16) {
                QLog.d(BGLocateMonitor.TAG, 1, "LocationBinderProxy init", e16);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, this, obj, method, objArr);
            }
            if ("queryLocalInterface".equals(method.getName())) {
                return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{IBinder.class, IInterface.class, this.mInterface}, new ILocationManagerProxy(this.mBase, this.mStub));
            }
            return method.invoke(this.mBase, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class TelephonyBinderProxy implements InvocationHandler {
        static IPatchRedirector $redirector_;
        IBinder mBase;
        Class<?> mInterface;
        Class<?> mStub;

        TelephonyBinderProxy(IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                return;
            }
            this.mBase = iBinder;
            try {
                this.mStub = Class.forName("com.android.internal.telephony.ITelephony$Stub");
                this.mInterface = Class.forName("com.android.internal.telephony.ITelephony");
            } catch (Exception e16) {
                QLog.d(BGLocateMonitor.TAG, 1, "TelephonyBinderProxy init", e16);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, this, obj, method, objArr);
            }
            if ("queryLocalInterface".equals(method.getName())) {
                return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{IBinder.class, IInterface.class, this.mInterface}, new ITelephonyManagerProxy(this.mBase, this.mStub));
            }
            return method.invoke(this.mBase, objArr);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34583);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            LOCATION_MANAGER_METHOD_LIST = new String[]{"getLastLocation", "requestLocationUpdates"};
            TELEPHONY_MANAGER_METHOD_LIST = new String[]{"getCellLocation", "getAllCellInfo", "getNeighboringCellInfo", "getServiceStateForSubscriber", "requestNetworkScan", "requestCellInfoUpdate", "getAvailableNetworks", "getServiceState"};
        }
    }

    public BGLocateMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkTencentLocateReport(int i3) {
        if (!isAppOnForeground()) {
            RuntimeException runtimeException = new RuntimeException("BGLocate# SOSOInterface#startLocation perCheckCode = " + i3);
            QLog.d(TAG, 1, "SOSOInterface#startLocation in background, perCheckCode = " + i3, runtimeException);
            if (!bo.d()) {
                CaughtExceptionReportProxy.e(runtimeException, "BGLocate# SOSOInterface#startLocation perCheckCode = " + i3);
            }
        }
    }

    private static void clearLocationManagerCache(Context context) {
        Context context2;
        QLog.d(TAG, 1, "clearLocationManagerCache");
        if (context == null) {
            QLog.e(TAG, 1, "context == null");
            return;
        }
        if (context instanceof ContextWrapper) {
            context2 = ((ContextWrapper) context).getBaseContext();
        } else {
            context2 = null;
        }
        try {
            Field declaredField = Class.forName("android.app.ContextImpl").getDeclaredField("mServiceCache");
            declaredField.setAccessible(true);
            Object[] objArr = (Object[]) declaredField.get(context2);
            if (objArr != null) {
                QLog.d(TAG, 1, "serviceCache: " + objArr.length);
                int i3 = -1;
                for (int i16 = 0; i16 < objArr.length; i16++) {
                    Object obj = objArr[i16];
                    if (obj != null) {
                        QLog.d(TAG, 1, "serviceType: " + obj.getClass().getName() + " i: " + i16);
                        if ((obj instanceof LocationManager) || (obj instanceof TelephonyManager)) {
                            i3 = i16;
                        }
                    }
                }
                if (i3 != -1) {
                    objArr[i3] = null;
                    QLog.d(TAG, 1, "real clear locationManager cache");
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.d(TAG, 1, "clearLocationManagerCache", th5);
        }
    }

    private static void hookLocationManager() {
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{IBinder.class}, new LocationBinderProxy((IBinder) cls.getDeclaredMethod("getService", String.class).invoke(null, "location")));
            Field declaredField = cls.getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put("location", iBinder);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "monitorSystemLocation", e16);
        }
    }

    private static void hookTelephonyManager() {
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            IBinder iBinder = (IBinder) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{IBinder.class}, new TelephonyBinderProxy((IBinder) cls.getDeclaredMethod("getService", String.class).invoke(null, "phone")));
            Field declaredField = cls.getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put("phone", iBinder);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "monitorSystemLocation", e16);
        }
    }

    public static boolean isAppOnForeground() {
        if (Foreground.getActivityCount() > 0) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) MobileQQ.sMobileQQ.getBaseContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        String packageName = MobileQQ.sMobileQQ.getBaseContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith(packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needReport(String str, String[] strArr) {
        boolean z16;
        if (TextUtils.isEmpty(str) || isAppOnForeground()) {
            return false;
        }
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (strArr[i3].equals(str)) {
                    z16 = true;
                    break;
                }
                i3++;
            } else {
                z16 = false;
                break;
            }
        }
        if (z16) {
            QLog.e(TAG, 1, "needReport, " + str + ", isMonitorMethod: true, isAppOnForeground: false", new RuntimeException("BGLocateMonitor MonitorMethod"));
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report(String str) {
        RuntimeException runtimeException = new RuntimeException("BGLocate Report");
        QLog.e(TAG, 1, String.format("call LocationManager#%s locate in background!", str), runtimeException);
        CaughtExceptionReportProxy.e(runtimeException, "BGLocate Report");
    }

    public static void start() {
        QLog.d(TAG, 1, "start background location monitor..");
        hookLocationManager();
        hookTelephonyManager();
        clearLocationManagerCache(MobileQQ.sMobileQQ.getApplicationContext());
    }
}
