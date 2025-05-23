package com.tencent.qqlive.tvkplayer.logic;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKThreadAnnotations {
    private static final Map<String, RegisterMethod> sClzNameToRegisterMethodMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MethodAnnotation {
        private final boolean letCallerThreadWait;

        @NonNull
        private final Method method;

        @NonNull
        private final String methodSignature;
        private final String[] waitApiSignatures;

        public MethodAnnotation(@NonNull Method method, boolean z16, String[] strArr) {
            this.method = method;
            this.methodSignature = convertMethodToSignature(method);
            this.letCallerThreadWait = z16;
            this.waitApiSignatures = strArr;
        }

        @NonNull
        private static String convertMethodToSignature(Method method) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(method.getName());
            sb5.append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                sb5.append(parameterTypes[i3].getSimpleName());
                if (i3 != parameterTypes.length - 1) {
                    sb5.append(",");
                    sb5.append(" ");
                }
            }
            sb5.append("): ");
            sb5.append(method.getReturnType().getName());
            return sb5.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class RegisterMethod {
        Map<Integer, MethodAnnotation> methodIdToAnnotationMap;

        RegisterMethod() {
        }
    }

    /* compiled from: P */
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes23.dex */
    public @interface ThreadSwitch {
        boolean letCallerThreadWait() default false;

        String[] waitApiSignatures() default {};
    }

    public static String getApi(Class<?> cls, int i3) {
        MethodAnnotation methodAnnotation;
        Map<Integer, MethodAnnotation> registerMethodMap = getRegisterMethodMap(cls);
        if (registerMethodMap == null || (methodAnnotation = registerMethodMap.get(Integer.valueOf(i3))) == null) {
            return "unknown";
        }
        return methodAnnotation.method.getName();
    }

    public static Method getMethod(Class<?> cls, String str, Object[] objArr) {
        Map<Integer, MethodAnnotation> registerMethodMap = getRegisterMethodMap(cls);
        if (registerMethodMap == null) {
            return null;
        }
        Iterator<Integer> it = registerMethodMap.keySet().iterator();
        while (it.hasNext()) {
            MethodAnnotation methodAnnotation = registerMethodMap.get(Integer.valueOf(it.next().intValue()));
            if (methodAnnotation != null && methodAnnotation.method.getName().equals(str) && isMatchParams(methodAnnotation.method, objArr)) {
                return methodAnnotation.method;
            }
        }
        return null;
    }

    public static Method getMethodByMethodId(Class<?> cls, int i3) {
        MethodAnnotation methodAnnotation;
        Map<Integer, MethodAnnotation> registerMethodMap = getRegisterMethodMap(cls);
        if (registerMethodMap != null && (methodAnnotation = registerMethodMap.get(Integer.valueOf(i3))) != null) {
            return methodAnnotation.method;
        }
        return null;
    }

    public static int getMethodId(Class<?> cls, String str, Object[] objArr) {
        Map<Integer, MethodAnnotation> registerMethodMap = getRegisterMethodMap(cls);
        if (registerMethodMap == null) {
            return -1;
        }
        Iterator<Integer> it = registerMethodMap.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            MethodAnnotation methodAnnotation = registerMethodMap.get(Integer.valueOf(intValue));
            if (methodAnnotation != null && methodAnnotation.method.getName().equals(str) && isMatchParams(methodAnnotation.method, objArr)) {
                return intValue;
            }
        }
        return -1;
    }

    private static Map<Integer, MethodAnnotation> getRegisterMethodMap(Class<?> cls) {
        RegisterMethod registerMethod = sClzNameToRegisterMethodMap.get(cls.getName());
        if (registerMethod == null) {
            return null;
        }
        return registerMethod.methodIdToAnnotationMap;
    }

    public static boolean hasWaitApiSignatures(Class<?> cls, int i3) {
        Map<Integer, MethodAnnotation> map;
        MethodAnnotation methodAnnotation;
        RegisterMethod registerMethod = sClzNameToRegisterMethodMap.get(cls.getName());
        if (registerMethod == null || (map = registerMethod.methodIdToAnnotationMap) == null || (methodAnnotation = map.get(Integer.valueOf(i3))) == null || methodAnnotation.waitApiSignatures == null || methodAnnotation.waitApiSignatures.length <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isInvokeMethodNeedWaitOtherApi(Class<?> cls, int i3, int i16) {
        Map<Integer, MethodAnnotation> map;
        MethodAnnotation methodAnnotation;
        MethodAnnotation methodAnnotation2;
        RegisterMethod registerMethod = sClzNameToRegisterMethodMap.get(cls.getName());
        if (registerMethod != null && (map = registerMethod.methodIdToAnnotationMap) != null && (methodAnnotation = map.get(Integer.valueOf(i3))) != null && (methodAnnotation2 = map.get(Integer.valueOf(i16))) != null) {
            for (String str : methodAnnotation.waitApiSignatures) {
                if (TextUtils.equals(methodAnnotation2.methodSignature, str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean isLetCallerThreadWait(Class<?> cls, int i3) {
        Map<Integer, MethodAnnotation> map;
        MethodAnnotation methodAnnotation;
        RegisterMethod registerMethod = sClzNameToRegisterMethodMap.get(cls.getName());
        if (registerMethod == null || (map = registerMethod.methodIdToAnnotationMap) == null || (methodAnnotation = map.get(Integer.valueOf(i3))) == null || !methodAnnotation.letCallerThreadWait) {
            return false;
        }
        return true;
    }

    private static boolean isMatchParams(Method method, Object[] objArr) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (objArr != null && objArr.length != 0) {
            if (parameterTypes.length != objArr.length) {
                return false;
            }
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                Class<?> cls = parameterTypes[i3];
                Object obj = objArr[i3];
                if (obj == null) {
                    if (cls.isPrimitive()) {
                        return false;
                    }
                } else if (!cls.isAssignableFrom(obj.getClass()) && !isSamePrimitive(cls, objArr[i3])) {
                    return false;
                }
            }
            return true;
        }
        if (parameterTypes.length == 0) {
            return true;
        }
        return false;
    }

    private static boolean isRegistered(Class<?> cls) {
        if (sClzNameToRegisterMethodMap.get(cls.getName()) != null) {
            return true;
        }
        return false;
    }

    private static boolean isSamePrimitive(Class<?> cls, Object obj) {
        if (cls.isPrimitive()) {
            return isSamePrimitive(cls, Integer.TYPE, obj, Integer.class) || isSamePrimitive(cls, Long.TYPE, obj, Long.class) || isSamePrimitive(cls, Float.TYPE, obj, Float.class) || isSamePrimitive(cls, Double.TYPE, obj, Double.class) || isSamePrimitive(cls, Boolean.TYPE, obj, Boolean.class) || isSamePrimitive(cls, Character.TYPE, obj, Character.class);
        }
        return false;
    }

    public static synchronized boolean register(Class<?> cls, int i3) {
        synchronized (TVKThreadAnnotations.class) {
            if (isRegistered(cls)) {
                return true;
            }
            HashMap hashMap = new HashMap();
            try {
                for (Method method : cls.getMethods()) {
                    ThreadSwitch threadSwitch = (ThreadSwitch) method.getAnnotation(ThreadSwitch.class);
                    if (threadSwitch != null) {
                        boolean letCallerThreadWait = threadSwitch.letCallerThreadWait();
                        String[] waitApiSignatures = threadSwitch.waitApiSignatures();
                        if (!letCallerThreadWait && waitApiSignatures.length > 0) {
                            throw new RuntimeException("method[" + method.getName() + "], @ThreadSwitch has letCallerThreadWait=false but waitApiSignatures.length > 0");
                        }
                        hashMap.put(Integer.valueOf(i3), new MethodAnnotation(method, letCallerThreadWait, waitApiSignatures));
                        i3++;
                    }
                }
                RegisterMethod registerMethod = new RegisterMethod();
                registerMethod.methodIdToAnnotationMap = hashMap;
                sClzNameToRegisterMethodMap.put(cls.getName(), registerMethod);
                return true;
            } catch (Exception unused) {
                hashMap.clear();
                return false;
            }
        }
    }

    private static boolean isSamePrimitive(Class<?> cls, Class<?> cls2, Object obj, Class<?> cls3) {
        return cls.equals(cls2) && obj.getClass().equals(cls3);
    }
}
