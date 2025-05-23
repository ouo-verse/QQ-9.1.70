package com.tencent.bugly.battery.hook;

import android.os.IBinder;
import android.os.IInterface;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.tencent.bugly.matrix.util.MatrixLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class SystemServiceBinderHooker {
    private static final String TAG = "Bugly.SystemServiceBinderHooker";

    @Nullable
    private IBinder mDelegateServiceBinder;
    private final HookCallback mHookCallback;

    @Nullable
    private IBinder mOriginServiceBinder;
    private final String mServiceClass;
    private final String mServiceName;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static final class BinderProxyHandler implements InvocationHandler {
        private final IBinder mOriginBinder;
        private final Object mServiceManagerProxy;

        BinderProxyHandler(String str, String str2, HookCallback hookCallback) throws Exception {
            IBinder currentBinder = getCurrentBinder(str);
            this.mOriginBinder = currentBinder;
            this.mServiceManagerProxy = createServiceManagerProxy(str2, currentBinder, hookCallback);
        }

        private static Object createServiceManagerProxy(String str, IBinder iBinder, final HookCallback hookCallback) throws Exception {
            Class<?> cls = Class.forName(str);
            Class<?> cls2 = Class.forName(str + "$Stub");
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader != null) {
                final Object invoke = cls2.getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
                return Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class, IInterface.class, cls}, new InvocationHandler() { // from class: com.tencent.bugly.battery.hook.SystemServiceBinderHooker.BinderProxyHandler.1
                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                        HookCallback hookCallback2 = HookCallback.this;
                        if (hookCallback2 != null) {
                            hookCallback2.onServiceMethodInvoke(method, objArr);
                            Object onServiceMethodIntercept = HookCallback.this.onServiceMethodIntercept(invoke, method, objArr);
                            if (onServiceMethodIntercept != null) {
                                return onServiceMethodIntercept;
                            }
                        }
                        return method.invoke(invoke, objArr);
                    }
                });
            }
            throw new IllegalStateException("get service manager ClassLoader fail!");
        }

        static IBinder getCurrentBinder(String str) throws Exception {
            return (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, str);
        }

        public IBinder createProxyBinder() throws Exception {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                return (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, this);
            }
            throw new IllegalStateException("Can not get ClassLoader of " + cls.getName());
        }

        public IBinder getOriginBinder() {
            return this.mOriginBinder;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if ("queryLocalInterface".equals(method.getName())) {
                return this.mServiceManagerProxy;
            }
            return method.invoke(this.mOriginBinder, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface HookCallback {
        @Nullable
        Object onServiceMethodIntercept(Object obj, Method method, Object[] objArr) throws Throwable;

        void onServiceMethodInvoke(Method method, Object[] objArr);
    }

    public SystemServiceBinderHooker(String str, String str2, HookCallback hookCallback) {
        this.mServiceName = str;
        this.mServiceClass = str2;
        this.mHookCallback = hookCallback;
    }

    public boolean doHook() {
        MatrixLog.i(TAG, "doHook: serviceName:%s, serviceClsName:%s", this.mServiceName, this.mServiceClass);
        try {
            BinderProxyHandler binderProxyHandler = new BinderProxyHandler(this.mServiceName, this.mServiceClass, this.mHookCallback);
            IBinder createProxyBinder = binderProxyHandler.createProxyBinder();
            Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.mServiceName, createProxyBinder);
            this.mDelegateServiceBinder = createProxyBinder;
            this.mOriginServiceBinder = binderProxyHandler.getOriginBinder();
            return true;
        } catch (Throwable th5) {
            MatrixLog.e(TAG, "#doHook exp: " + th5.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    public boolean doUnHook() {
        if (this.mOriginServiceBinder == null) {
            MatrixLog.w(TAG, "#doUnHook mOriginServiceBinder null", new Object[0]);
            return false;
        }
        if (this.mDelegateServiceBinder == null) {
            MatrixLog.w(TAG, "#doUnHook mDelegateServiceBinder null", new Object[0]);
            return false;
        }
        try {
            if (this.mDelegateServiceBinder != BinderProxyHandler.getCurrentBinder(this.mServiceName)) {
                MatrixLog.w(TAG, "#doUnHook mDelegateServiceBinder != currentBinder", new Object[0]);
                return false;
            }
            Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
            declaredField.setAccessible(true);
            ((Map) declaredField.get(null)).put(this.mServiceName, this.mOriginServiceBinder);
            return true;
        } catch (Throwable th5) {
            MatrixLog.e(TAG, "#doUnHook exp: " + th5.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }
}
