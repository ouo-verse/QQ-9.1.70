package com.qzone.proxy.feedcomponent.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class JsonORM {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class, a[]> f50867a = new IdentityHashMap();

    /* compiled from: P */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes39.dex */
    public @interface Column {
        String key();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class JsonParseException extends Exception {
        public JsonParseException() {
        }

        public JsonParseException(String str) {
            super(str);
        }

        public JsonParseException(Throwable th5) {
            super(th5);
        }

        public JsonParseException(String str, Throwable th5) {
            super(str, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f50868a;

        /* renamed from: b, reason: collision with root package name */
        public final int f50869b;

        /* renamed from: c, reason: collision with root package name */
        public final Field f50870c;

        public a(String str, int i3, Field field) {
            this.f50868a = str;
            this.f50869b = i3;
            this.f50870c = field;
            field.setAccessible(true);
        }
    }

    public static int a(Class<?> cls) throws JsonParseException {
        if (cls == String.class) {
            return 0;
        }
        if (cls == Boolean.TYPE) {
            return 1;
        }
        if (cls == Integer.TYPE) {
            return 2;
        }
        if (cls == Long.TYPE) {
            return 3;
        }
        if (cls == Double.TYPE) {
            return 4;
        }
        if (cls.isArray()) {
            return 6;
        }
        if (!cls.isPrimitive()) {
            return 5;
        }
        throw new JsonParseException("un-support primitive field : " + cls);
    }

    private static void b(Class<?> cls, ArrayList<a> arrayList) throws JsonParseException {
        Field[] declaredFields = cls.getDeclaredFields();
        for (int i3 = 0; i3 != declaredFields.length; i3++) {
            Field field = declaredFields[i3];
            Column column = (Column) field.getAnnotation(Column.class);
            if (column != null) {
                arrayList.add(new a(column.key(), a(field.getType()), field));
            }
        }
    }

    private static a[] c(Class<?> cls) throws JsonParseException {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            b(cls, arrayList);
            cls = cls.getSuperclass();
        }
        a[] aVarArr = new a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return aVarArr;
    }

    private static void f(int i3, JSONArray jSONArray, Field field, Object obj) throws IllegalAccessException, JsonParseException {
        int length = jSONArray.length();
        int i16 = 0;
        if (i3 == 0) {
            String[] strArr = new String[length];
            while (i16 < length) {
                strArr[i16] = jSONArray.optString(i16);
                i16++;
            }
            field.set(obj, strArr);
            return;
        }
        if (i3 == 1) {
            boolean[] zArr = new boolean[length];
            while (i16 < length) {
                zArr[i16] = jSONArray.optBoolean(i16);
                i16++;
            }
            field.set(obj, zArr);
            return;
        }
        if (i3 == 2) {
            int[] iArr = new int[length];
            while (i16 < length) {
                iArr[i16] = jSONArray.optInt(i16);
                i16++;
            }
            field.set(obj, iArr);
            return;
        }
        if (i3 == 3) {
            long[] jArr = new long[length];
            while (i16 < length) {
                jArr[i16] = jSONArray.optLong(i16);
                i16++;
            }
            field.set(obj, jArr);
            return;
        }
        if (i3 == 4) {
            double[] dArr = new double[length];
            while (i16 < length) {
                dArr[i16] = jSONArray.optDouble(i16);
                i16++;
            }
            field.set(obj, dArr);
            return;
        }
        throw new JsonParseException("un-support array field type : " + i3);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0021. Please report as an issue. */
    public static <T> T d(JSONObject jSONObject, Class<T> cls) throws JsonParseException {
        if (jSONObject != null && cls != null) {
            Map<Class, a[]> map = f50867a;
            a[] aVarArr = map.get(cls);
            if (aVarArr == null) {
                aVarArr = c(cls);
                map.put(cls, aVarArr);
            }
            try {
                T newInstance = cls.newInstance();
                for (a aVar : aVarArr) {
                    try {
                        int i3 = aVar.f50869b;
                        switch (i3) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                g(i3, jSONObject, aVar.f50868a, aVar.f50870c, newInstance);
                            case 5:
                                JSONObject optJSONObject = jSONObject.optJSONObject(aVar.f50868a);
                                if (optJSONObject != null) {
                                    Field field = aVar.f50870c;
                                    field.set(newInstance, d(optJSONObject, field.getType()));
                                }
                            case 6:
                                JSONArray optJSONArray = jSONObject.optJSONArray(aVar.f50868a);
                                if (optJSONArray != null) {
                                    Class<?> componentType = aVar.f50870c.getType().getComponentType();
                                    int a16 = a(componentType);
                                    if (a16 != 0 && a16 != 1 && a16 != 2 && a16 != 3 && a16 != 4) {
                                        aVar.f50870c.set(newInstance, e(optJSONArray, componentType));
                                    } else {
                                        f(a16, optJSONArray, aVar.f50870c, newInstance);
                                    }
                                }
                                break;
                            default:
                                throw new JsonParseException("un-support type : " + aVar.f50869b);
                        }
                    } catch (IllegalAccessException e16) {
                        throw new JsonParseException("access field failed : " + aVar.f50870c.getName(), e16);
                    }
                }
                return newInstance;
            } catch (Exception e17) {
                throw new JsonParseException("create class instance failed : " + cls.getName(), e17);
            }
        }
        throw new IllegalArgumentException("both jsonObject and clazz should not be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] e(JSONArray jSONArray, Class<T> cls) throws JsonParseException {
        if (jSONArray != null && cls != null) {
            if (!cls.isPrimitive()) {
                int length = jSONArray.length();
                T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        tArr[i3] = d(optJSONObject, cls);
                    } else {
                        tArr[i3] = 0;
                    }
                }
                return tArr;
            }
            throw new JsonParseException("do not support primitive array field : " + cls);
        }
        throw new IllegalArgumentException("both jsonArray and clazz should not be null");
    }

    private static void g(int i3, JSONObject jSONObject, String str, Field field, Object obj) throws IllegalAccessException, JsonParseException {
        if (i3 == 0) {
            field.set(obj, jSONObject.optString(str));
            return;
        }
        if (i3 == 1) {
            field.set(obj, Boolean.valueOf(jSONObject.optBoolean(str)));
            return;
        }
        if (i3 == 2) {
            field.set(obj, Integer.valueOf(jSONObject.optInt(str)));
            return;
        }
        if (i3 == 3) {
            field.set(obj, Long.valueOf(jSONObject.optLong(str)));
        } else {
            if (i3 == 4) {
                field.set(obj, Double.valueOf(jSONObject.optDouble(str)));
                return;
            }
            throw new JsonParseException("un-support field type : " + i3);
        }
    }
}
