package com.tencent.mtt.hippy.modules.nativemodules;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.PromiseImpl;
import com.tencent.mtt.hippy.runtime.builtins.a.b;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class HippyNativeModuleInfo {
    private static final String TAG = "HippyNativeModuleInfo";
    private final Class<?> mClass;
    private HippyNativeModuleBase mInstance;

    @Nullable
    private Map<String, HippyNativeMethod> mMethods;
    private String mName;
    private String[] mNames;
    private final Provider<? extends HippyNativeModuleBase> mProvider;
    private HippyNativeModule.Thread mThread;
    private boolean mInit = false;
    private boolean mIsDestroyed = false;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class HippyNativeMethod {
        private final boolean mIsSync;

        @NonNull
        private final Method mMethod;

        @Nullable
        private final Type[] mParamTypes;
        private final boolean mUseJSValueType;

        public HippyNativeMethod(@NonNull Method method, boolean z16, boolean z17) {
            this.mMethod = method;
            this.mIsSync = z16;
            this.mUseJSValueType = z17;
            this.mParamTypes = method.getGenericParameterTypes();
        }

        private boolean checkArgumentType(@NonNull Object obj) {
            boolean z16 = this.mUseJSValueType;
            if (z16 && (obj instanceof b)) {
                return true;
            }
            if (!z16 && (obj instanceof HippyArray)) {
                return true;
            }
            return false;
        }

        @Nullable
        private Object[] prepareArguments(@NonNull Object obj, PromiseImpl promiseImpl) throws IllegalArgumentException {
            int size;
            Type[] typeArr = this.mParamTypes;
            if (typeArr != null && typeArr.length > 0) {
                if (checkArgumentType(obj)) {
                    Object[] objArr = new Object[this.mParamTypes.length];
                    if (this.mUseJSValueType) {
                        size = ((b) obj).h();
                    } else {
                        size = ((HippyArray) obj).size();
                    }
                    int i3 = 0;
                    int i16 = 0;
                    while (true) {
                        Type[] typeArr2 = this.mParamTypes;
                        if (i3 < typeArr2.length) {
                            Type type = typeArr2[i3];
                            if (type == Promise.class) {
                                objArr[i3] = promiseImpl;
                                promiseImpl.setNeedResolveBySelf(false);
                            } else if (size > i16) {
                                if (this.mUseJSValueType) {
                                    objArr[i3] = ((b) obj).a(i16);
                                } else {
                                    objArr[i3] = ArgumentUtils.parseArgument(type, (HippyArray) obj, i16);
                                }
                                i16++;
                            } else {
                                throw new IllegalArgumentException("The number of parameters does not match");
                            }
                            i3++;
                        } else {
                            return objArr;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("The data type of parameters mismatch!");
                }
            } else {
                return null;
            }
        }

        public void invoke(Object obj, @Nullable Object obj2, PromiseImpl promiseImpl) throws Exception {
            Object[] objArr;
            if (obj2 != null) {
                objArr = prepareArguments(obj2, promiseImpl);
            } else {
                objArr = null;
            }
            this.mMethod.invoke(obj, objArr);
            if (promiseImpl.needResolveBySelf()) {
                promiseImpl.resolve("");
            }
        }

        public boolean isSync() {
            return this.mIsSync;
        }

        public boolean useJSValueType() {
            return this.mUseJSValueType;
        }
    }

    public HippyNativeModuleInfo(@NonNull Class<?> cls, Provider<? extends HippyNativeModuleBase> provider) {
        this.mThread = HippyNativeModule.Thread.BRIDGE;
        HippyNativeModule hippyNativeModule = (HippyNativeModule) cls.getAnnotation(HippyNativeModule.class);
        this.mClass = cls;
        this.mProvider = provider;
        if (hippyNativeModule != null) {
            this.mName = hippyNativeModule.name();
            this.mNames = hippyNativeModule.names();
            this.mThread = hippyNativeModule.thread();
            initImmediately(hippyNativeModule);
        }
    }

    private void checkModuleMethods() {
        if (this.mMethods != null) {
            return;
        }
        synchronized (this) {
            if (this.mMethods != null) {
                return;
            }
            this.mMethods = new ConcurrentHashMap();
            for (Method method : this.mClass.getMethods()) {
                HippyMethod hippyMethod = (HippyMethod) method.getAnnotation(HippyMethod.class);
                if (hippyMethod != null) {
                    String name = hippyMethod.name();
                    if (TextUtils.isEmpty(name)) {
                        name = method.getName();
                    }
                    if (this.mMethods.containsKey(name)) {
                        LogUtils.e(TAG, "Register the same method twice, moduleName=" + this.mName + ", methodName=" + name);
                    } else {
                        this.mMethods.put(name, new HippyNativeMethod(method, hippyMethod.isSync(), hippyMethod.useJSValueType()));
                    }
                }
            }
        }
    }

    private void initImmediately(@NonNull HippyNativeModule hippyNativeModule) {
        if (hippyNativeModule.init()) {
            try {
                initialize();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public void destroy() {
        HippyNativeModuleBase hippyNativeModuleBase = this.mInstance;
        if (hippyNativeModuleBase != null) {
            hippyNativeModuleBase.destroy();
        }
    }

    @Nullable
    public HippyNativeMethod findMethod(String str) {
        checkModuleMethods();
        return this.mMethods.get(str);
    }

    public HippyNativeModuleBase getInstance() {
        return this.mInstance;
    }

    public String getName() {
        return this.mName;
    }

    public String[] getNames() {
        return this.mNames;
    }

    public HippyNativeModule.Thread getThread() {
        return this.mThread;
    }

    public void initialize() {
        if (this.mInit) {
            return;
        }
        checkModuleMethods();
        HippyNativeModuleBase hippyNativeModuleBase = this.mProvider.get();
        this.mInstance = hippyNativeModuleBase;
        hippyNativeModuleBase.initialize();
        this.mInit = true;
    }

    public void onDestroy() {
        this.mIsDestroyed = true;
    }

    public boolean shouldDestroy() {
        return !this.mIsDestroyed;
    }
}
