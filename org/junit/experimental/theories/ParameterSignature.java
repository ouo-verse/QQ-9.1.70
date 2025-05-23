package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes29.dex */
public class ParameterSignature {
    private static final Map<Class<?>, Class<?>> CONVERTABLE_TYPES_MAP = buildConvertableTypesMap();
    private final Annotation[] annotations;
    private final Class<?> type;

    ParameterSignature(Class<?> cls, Annotation[] annotationArr) {
        this.type = cls;
        this.annotations = annotationArr;
    }

    private static Map<Class<?>, Class<?>> buildConvertableTypesMap() {
        HashMap hashMap = new HashMap();
        putSymmetrically(hashMap, Boolean.TYPE, Boolean.class);
        putSymmetrically(hashMap, Byte.TYPE, Byte.class);
        putSymmetrically(hashMap, Short.TYPE, Short.class);
        putSymmetrically(hashMap, Character.TYPE, Character.class);
        putSymmetrically(hashMap, Integer.TYPE, Integer.class);
        putSymmetrically(hashMap, Long.TYPE, Long.class);
        putSymmetrically(hashMap, Float.TYPE, Float.class);
        putSymmetrically(hashMap, Double.TYPE, Double.class);
        return Collections.unmodifiableMap(hashMap);
    }

    private boolean isAssignableViaTypeConversion(Class<?> cls, Class<?> cls2) {
        Map<Class<?>, Class<?>> map = CONVERTABLE_TYPES_MAP;
        if (map.containsKey(cls2)) {
            return cls.isAssignableFrom(map.get(cls2));
        }
        return false;
    }

    private static <T> void putSymmetrically(Map<T, T> map, T t16, T t17) {
        map.put(t16, t17);
        map.put(t17, t16);
    }

    public static ArrayList<ParameterSignature> signatures(Method method) {
        return signatures(method.getParameterTypes(), method.getParameterAnnotations());
    }

    public boolean canAcceptType(Class<?> cls) {
        if (!this.type.isAssignableFrom(cls) && !isAssignableViaTypeConversion(this.type, cls)) {
            return false;
        }
        return true;
    }

    public boolean canAcceptValue(Object obj) {
        if (obj == null) {
            if (!this.type.isPrimitive()) {
                return true;
            }
            return false;
        }
        return canAcceptType(obj.getClass());
    }

    public boolean canPotentiallyAcceptType(Class<?> cls) {
        if (!cls.isAssignableFrom(this.type) && !isAssignableViaTypeConversion(cls, this.type) && !canAcceptType(cls)) {
            return false;
        }
        return true;
    }

    public <T extends Annotation> T findDeepAnnotation(Class<T> cls) {
        return (T) findDeepAnnotation(this.annotations, cls, 3);
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        for (Annotation annotation : getAnnotations()) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    public List<Annotation> getAnnotations() {
        return Arrays.asList(this.annotations);
    }

    public Class<?> getType() {
        return this.type;
    }

    public boolean hasAnnotation(Class<? extends Annotation> cls) {
        if (getAnnotation(cls) != null) {
            return true;
        }
        return false;
    }

    public static List<ParameterSignature> signatures(Constructor<?> constructor) {
        return signatures(constructor.getParameterTypes(), constructor.getParameterAnnotations());
    }

    private <T extends Annotation> T findDeepAnnotation(Annotation[] annotationArr, Class<T> cls, int i3) {
        if (i3 == 0) {
            return null;
        }
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return cls.cast(annotation);
            }
            Annotation findDeepAnnotation = findDeepAnnotation(annotation.annotationType().getAnnotations(), cls, i3 - 1);
            if (findDeepAnnotation != null) {
                return cls.cast(findDeepAnnotation);
            }
        }
        return null;
    }

    private static ArrayList<ParameterSignature> signatures(Class<?>[] clsArr, Annotation[][] annotationArr) {
        ArrayList<ParameterSignature> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            arrayList.add(new ParameterSignature(clsArr[i3], annotationArr[i3]));
        }
        return arrayList;
    }
}
