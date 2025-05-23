package com.tencent.thumbplayer.common.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.common.TPTimeoutException;
import com.tencent.thumbplayer.common.TPFutureResult;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes26.dex */
public class TPThreadSwitchProxy implements java.lang.reflect.InvocationHandler {
    private static final long DEFAULT_TIMEOUT_MS = Long.MAX_VALUE;
    private static final String TAG = "TPThreadSwitchProxy";
    private final InvocationHandler mHandler;
    private final Looper mLooper;
    private final Object mProxyInstance;
    private final Class<?> mTargetClass;
    private final Object mTargetInstance;
    private final long mTimeoutMs;
    private static final Map<String, MethodInfo> sRegisteredThreadSwitchMethods = new ConcurrentHashMap();
    private static final AtomicInteger sMethodIdBase = new AtomicInteger(100);

    /* loaded from: classes26.dex */
    public interface IPreprocessing {
        void beforeThreadSwitch(Method method, Object[] objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class InvocationHandler extends Handler {
        private final WeakReference<Object> mTargetWeakReference;

        public InvocationHandler(Looper looper, Object obj) {
            super(looper);
            this.mTargetWeakReference = new WeakReference<>(obj);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Object obj = this.mTargetWeakReference.get();
            if (obj != null) {
                TPThreadSwitchProxy.invokeMethod(obj, (InvocationInfo) message.obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class InvocationInfo {
        public Object[] args;
        public TPFutureResult futureResult;
        public boolean isWaiting;
        public Method method;
        public String methodSignature;

        InvocationInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class MethodInfo {
        public ThreadSwitch annotation;

        /* renamed from: id, reason: collision with root package name */
        public int f376098id;

        MethodInfo() {
        }
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes26.dex */
    public @interface ThreadSwitch {
        boolean needWaiting() default false;

        boolean printBeforeSwitching() default false;

        boolean removeRepeated() default false;
    }

    public TPThreadSwitchProxy(@NonNull Object obj, @NonNull Looper looper, long j3) {
        this.mTargetInstance = obj;
        this.mLooper = looper;
        this.mTimeoutMs = j3 <= 0 ? Long.MAX_VALUE : j3;
        this.mHandler = new InvocationHandler(looper, obj);
        Class<?> cls = obj.getClass();
        this.mTargetClass = cls;
        registerThreadSwitchMethods();
        this.mProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
    }

    private String generateMethodSignature(Method method) {
        return this.mTargetClass.getName() + "-" + method.getName() + "-" + Arrays.toString(method.getParameterTypes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void invokeMethod(Object obj, InvocationInfo invocationInfo) {
        try {
            invocationInfo.futureResult.setResult(invocationInfo.method.invoke(obj, invocationInfo.args));
        } catch (InvocationTargetException e16) {
            throwThrowable(e16.getTargetException(), invocationInfo);
        } catch (Throwable th5) {
            throwThrowable(th5, invocationInfo);
        }
    }

    private void registerThreadSwitchMethods() {
        for (Method method : this.mTargetClass.getMethods()) {
            ThreadSwitch threadSwitch = (ThreadSwitch) method.getAnnotation(ThreadSwitch.class);
            if (threadSwitch != null) {
                String generateMethodSignature = generateMethodSignature(method);
                Map<String, MethodInfo> map = sRegisteredThreadSwitchMethods;
                if (map.containsKey(generateMethodSignature)) {
                    continue;
                } else {
                    synchronized (map) {
                        if (!map.containsKey(generateMethodSignature)) {
                            MethodInfo methodInfo = new MethodInfo();
                            methodInfo.f376098id = sMethodIdBase.incrementAndGet();
                            methodInfo.annotation = threadSwitch;
                            map.put(generateMethodSignature, methodInfo);
                        }
                    }
                }
            }
        }
    }

    private Object safelyGetResult(TPFutureResult tPFutureResult, Class<?> cls, boolean z16) throws Throwable {
        Object obj;
        try {
            obj = tPFutureResult.getResult(this.mTimeoutMs);
        } catch (TPTimeoutException e16) {
            if (!z16) {
                obj = null;
            } else {
                throw e16;
            }
        }
        if (obj == null && !cls.equals(Void.TYPE)) {
            if (cls.equals(Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (cls.equals(Character.TYPE)) {
                return (char) 0;
            }
            if (cls.equals(Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (cls.equals(Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (cls.equals(Long.TYPE)) {
                return 0L;
            }
            if (cls.equals(Integer.TYPE)) {
                return 0;
            }
            if (cls.equals(Short.TYPE)) {
                return (short) 0;
            }
            if (!cls.equals(Byte.TYPE)) {
                return null;
            }
            return (byte) 0;
        }
        return obj;
    }

    private boolean shouldNotifyTimeout(Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (cls == TPTimeoutException.class) {
                return true;
            }
        }
        return false;
    }

    private void threadSwitchInvokeMethod(InvocationInfo invocationInfo) {
        if (this.mLooper == Looper.myLooper()) {
            invokeMethod(this.mTargetInstance, invocationInfo);
            return;
        }
        Map<String, MethodInfo> map = sRegisteredThreadSwitchMethods;
        MethodInfo methodInfo = map.get(invocationInfo.methodSignature);
        Message message = new Message();
        message.what = methodInfo.f376098id;
        message.obj = invocationInfo;
        if (methodInfo.annotation.removeRepeated()) {
            synchronized (map.get(invocationInfo.methodSignature)) {
                this.mHandler.removeMessages(methodInfo.f376098id);
                this.mHandler.sendMessage(message);
            }
            return;
        }
        this.mHandler.sendMessage(message);
    }

    private static void throwThrowable(Throwable th5, InvocationInfo invocationInfo) {
        if (invocationInfo.isWaiting) {
            invocationInfo.futureResult.setThrowable(th5);
            return;
        }
        throw new RuntimeException("FATAL: Unhandled Throwable was thrown after thread switching: " + th5, th5);
    }

    public Object getProxyInstance() {
        return this.mProxyInstance;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        boolean z16;
        String generateMethodSignature = generateMethodSignature(method);
        Map<String, MethodInfo> map = sRegisteredThreadSwitchMethods;
        if (!map.containsKey(generateMethodSignature)) {
            return method.invoke(this.mTargetInstance, objArr);
        }
        Object obj2 = this.mTargetInstance;
        if (obj2 instanceof IPreprocessing) {
            ((IPreprocessing) obj2).beforeThreadSwitch(method, objArr);
        }
        TPFutureResult tPFutureResult = new TPFutureResult();
        InvocationInfo invocationInfo = new InvocationInfo();
        invocationInfo.method = method;
        invocationInfo.args = objArr;
        invocationInfo.futureResult = tPFutureResult;
        invocationInfo.methodSignature = generateMethodSignature;
        ThreadSwitch threadSwitch = map.get(generateMethodSignature).annotation;
        Class<?> returnType = method.getReturnType();
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        if (!threadSwitch.needWaiting() && returnType.equals(Void.TYPE) && exceptionTypes.length <= 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        invocationInfo.isWaiting = z16;
        if (threadSwitch.printBeforeSwitching()) {
            TPLogUtil.i(TAG, "method invoked before thread switching: " + generateMethodSignature);
        }
        threadSwitchInvokeMethod(invocationInfo);
        if (!z16) {
            return null;
        }
        return safelyGetResult(tPFutureResult, returnType, shouldNotifyTimeout(exceptionTypes));
    }
}
