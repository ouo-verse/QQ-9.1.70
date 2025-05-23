package com.tencent.qqlive.tvkplayer.tpplayer.tools;

import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKElapsedTimeStatistics;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerMsgValueMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes23.dex */
public class TVKPlayerMsgValueConverter {
    private static final String REVERSE_MAP_NAME_SUFFIX = ".reverseMap";
    private static final String TAG = "TVKPlayerMsgValueConverter";
    private static final Map<String, Map<Number, Number>> sNameToMap = new ConcurrentHashMap();
    private static final Map<Class<?>, AtomicBoolean> sHasThisAnnotationInitMap = new ConcurrentHashMap();

    private static <T extends Annotation> void buildBiDirectionMapForAnnotation(Class<T> cls) throws IllegalArgumentException, IllegalStateException {
        AtomicBoolean atomicBoolean;
        TVKLogUtil.i(TAG, "buildBiDirectionMapForAnnotation, clazz=" + cls);
        Map<Class<?>, AtomicBoolean> map = sHasThisAnnotationInitMap;
        synchronized (map) {
            atomicBoolean = map.get(cls);
            if (atomicBoolean == null) {
                atomicBoolean = new AtomicBoolean(false);
                map.put(cls, atomicBoolean);
            }
        }
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                TVKLogUtil.i(TAG, "className=" + cls.getSimpleName() + " already init");
                return;
            }
            searchClassToFillMap(cls);
            atomicBoolean.set(true);
        }
    }

    private static <T extends Annotation> void checkFillMapValidity(Class<T> cls, Map<Number, Number> map, Map<Number, Number> map2, Class<?> cls2, Number number, Number number2) throws IllegalStateException {
        if (!map.containsKey(number2)) {
            if (!map2.containsKey(number)) {
                return;
            }
            throw new IllegalStateException(cls2.getName() + " \u914d\u7f6e\u4e86\u91cd\u590d\u7684\u6ce8\u89e3\u503c\uff0c\u6ce8\u89e3=" + cls.getName() + " \u6210\u5458\u53d8\u91cf\u503c=" + number2 + " \u8bf7\u67e5\u627e\u4e00\u4e0b@" + cls.getName() + "(\u8fd9\u4e2a\u503c)\u5728\u54ea\u91cc\u91cd\u590d\u4e86");
        }
        throw new IllegalStateException(cls2.getName() + " \u914d\u7f6e\u4e86\u91cd\u590d\u7684\u6210\u5458\u53d8\u91cf\uff0c\u6ce8\u89e3=" + cls.getName() + " \u6210\u5458\u53d8\u91cf\u503c=" + number2 + " \u8bf7\u67e5\u627e\u4e00\u4e0b\u4f7f\u7528\u8fd9\u4e2a\u6ce8\u89e3@" + cls.getName() + "\u7684\u54ea\u4e24\u4e2a\u6210\u5458\u53d8\u91cf\u503c\u76f8\u7b49");
    }

    private static <T extends Annotation> Map<Number, Number> getMapForAnnotation(Class<T> cls, boolean z16) throws IllegalArgumentException, IllegalStateException {
        String mapKey = getMapKey(cls, z16);
        Map<String, Map<Number, Number>> map = sNameToMap;
        Map<Number, Number> map2 = map.get(mapKey);
        if (map2 == null || map2.size() == 0) {
            buildBiDirectionMapForAnnotation(cls);
            map2 = map.get(mapKey);
        }
        if (((TVKPlayerMsgValueMap.SearchConfig) cls.getAnnotation(TVKPlayerMsgValueMap.SearchConfig.class)) != null) {
            if (map2 != null && map2.size() != 0) {
                return map2;
            }
            throw new IllegalStateException(cls.getSimpleName() + " is null after buildBiDirectionMap");
        }
        throw new IllegalArgumentException(cls.getSimpleName() + "has not SearchConfig annotation");
    }

    private static <T extends Annotation> String getMapKey(Class<T> cls, boolean z16) {
        String canonicalName = cls.getCanonicalName();
        if (z16) {
            return canonicalName;
        }
        return canonicalName + REVERSE_MAP_NAME_SUFFIX;
    }

    public static void init() throws IllegalStateException, IllegalArgumentException {
        TVKElapsedTimeStatistics tVKElapsedTimeStatistics = new TVKElapsedTimeStatistics();
        tVKElapsedTimeStatistics.startPoint();
        Class<?>[] declaredClasses = TVKPlayerMsgValueMap.class.getDeclaredClasses();
        TVKLogUtil.i(TAG, "init BiDirectionMap for tp&tvk value");
        for (Class<?> cls : declaredClasses) {
            if (cls.isAnnotation() && Modifier.isPublic(cls.getModifiers()) && ((TVKPlayerMsgValueMap.SearchConfig) cls.getAnnotation(TVKPlayerMsgValueMap.SearchConfig.class)) != null) {
                buildBiDirectionMapForAnnotation(cls);
            }
        }
        tVKElapsedTimeStatistics.costTimeMsFromStartPoint();
        TVKLogUtil.i(TAG, "init cost time=" + tVKElapsedTimeStatistics.costTimeMsFromStartPoint());
    }

    private static <T extends Annotation> void parseFieldToMap(Class<T> cls, TVKPlayerMsgValueMap.SearchConfig searchConfig, Field field, Map<Number, Number> map, Map<Number, Number> map2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Annotation annotation;
        Class<? extends Number> valueClass = searchConfig.valueClass();
        Class<? extends Number> cls2 = Integer.TYPE;
        if (valueClass == cls2) {
            if (!field.getType().toString().equals(PoiListCacheRecord.WEIGHT_TYPE) || (annotation = field.getAnnotation(cls)) == null) {
                return;
            }
            field.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("value", new Class[0]);
            declaredMethod.setAccessible(true);
            if (searchConfig.valueClass() == cls2) {
                Integer num = (Integer) declaredMethod.invoke(annotation, new Object[0]);
                Integer valueOf = Integer.valueOf(field.getInt(searchConfig.searchClass()));
                checkFillMapValidity(cls, map, map2, searchConfig.searchClass(), num, valueOf);
                map.put(valueOf, num);
                map2.put(num, valueOf);
                return;
            }
            throw new IllegalArgumentException("\u4ee3\u7801\u8fd8\u6ca1\u5b9e\u73b0\u5bf9" + searchConfig.valueClass().getName() + "\u7684\u652f\u6301");
        }
        throw new IllegalArgumentException("\u4ee3\u7801\u8fd8\u6ca1\u5b9e\u73b0\u5bf9" + searchConfig.valueClass().getName() + "\u7684\u652f\u6301");
    }

    private static <T extends Annotation> void searchClassToFillMap(Class<T> cls) throws IllegalArgumentException, IllegalStateException {
        String mapKey = getMapKey(cls, true);
        Map<String, Map<Number, Number>> map = sNameToMap;
        Map<Number, Number> map2 = map.get(mapKey);
        String mapKey2 = getMapKey(cls, false);
        Map<Number, Number> map3 = map.get(mapKey2);
        if (map2 == null || map3 == null) {
            map2 = new HashMap<>();
            map.put(mapKey, map2);
            map3 = new HashMap<>();
            map.put(mapKey2, map3);
        }
        try {
            TVKPlayerMsgValueMap.SearchConfig searchConfig = (TVKPlayerMsgValueMap.SearchConfig) cls.getAnnotation(TVKPlayerMsgValueMap.SearchConfig.class);
            if (searchConfig != null) {
                for (Field field : searchConfig.searchClass().getDeclaredFields()) {
                    parseFieldToMap(cls, searchConfig, field, map2, map3);
                }
                return;
            }
            throw new IllegalArgumentException(cls.getCanonicalName() + "has not SearchConfig annotation");
        } catch (IllegalAccessException e16) {
            e = e16;
            TVKLogUtil.e(TAG, e);
        } catch (NoSuchMethodException e17) {
            TVKLogUtil.e(TAG, e17);
            throw new IllegalStateException("com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerMsgValueMap\u4e0b\u6240\u6709\u5143\u7d20\u9700\u8981\u52a0\u5230\u6df7\u6dc6\u4e2d, \u5e76\u4e14\u6bcf\u4e2aMapXXX\u6ce8\u89e3\u9700\u8981\u6709value\u65b9\u6cd5");
        } catch (InvocationTargetException e18) {
            e = e18;
            TVKLogUtil.e(TAG, e);
        }
    }

    public static <T extends Annotation> int toTPIntValue(Class<T> cls, int i3) {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, true);
        if (!mapForAnnotation.containsKey(Integer.valueOf(i3))) {
            TVKLogUtil.e(TAG, "toTPIntValue, tvkValue=" + i3 + "return default value, clazz" + cls);
            return (int) ((TVKPlayerMsgValueMap.SearchConfig) cls.getAnnotation(TVKPlayerMsgValueMap.SearchConfig.class)).tpDefValue();
        }
        return mapForAnnotation.get(Integer.valueOf(i3)).intValue();
    }

    public static <T extends Annotation> int toTVKIntValue(Class<T> cls, int i3) throws IllegalArgumentException, IllegalStateException {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, false);
        if (!mapForAnnotation.containsKey(Integer.valueOf(i3))) {
            TVKLogUtil.i(TAG, "toTVKIntValue, tpValue=" + i3 + "return default value, clazz" + cls);
            return (int) ((TVKPlayerMsgValueMap.SearchConfig) cls.getAnnotation(TVKPlayerMsgValueMap.SearchConfig.class)).tpDefValue();
        }
        return mapForAnnotation.get(Integer.valueOf(i3)).intValue();
    }
}
