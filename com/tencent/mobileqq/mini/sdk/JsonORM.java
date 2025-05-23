package com.tencent.mobileqq.mini.sdk;

import android.support.annotation.NonNull;
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
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class JsonORM {
    public static final int TYPE_ARRAY = 6;
    public static final int TYPE_BOOLEAN = 1;
    public static final int TYPE_DOUBLE = 4;
    public static final int TYPE_INT = 2;
    public static final int TYPE_LONG = 3;
    public static final int TYPE_OBJECT = 5;
    public static final int TYPE_STRING = 0;
    private static final Map<Class, ColumnInfo[]> sColumnInfoMap = new IdentityHashMap();

    /* compiled from: P */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes15.dex */
    public @interface Column {
        String key();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class ColumnInfo {
        public final Field field;
        public final String key;
        public final int type;

        public ColumnInfo(String str, int i3, Field field) {
            this.key = str;
            this.type = i3;
            this.field = field;
            field.setAccessible(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
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

    public static int getColumnInfoType(Class<?> cls) throws JsonParseException {
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

    private static ColumnInfo[] parseColumnInfo(Class<?> cls) throws JsonParseException {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            parseColumnInfo(cls, arrayList);
            cls = cls.getSuperclass();
        }
        ColumnInfo[] columnInfoArr = new ColumnInfo[arrayList.size()];
        arrayList.toArray(columnInfoArr);
        return columnInfoArr;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0021. Please report as an issue. */
    @NonNull
    public static <T> T parseFrom(JSONObject jSONObject, Class<T> cls) throws JsonParseException {
        if (jSONObject != null && cls != null) {
            Map<Class, ColumnInfo[]> map = sColumnInfoMap;
            ColumnInfo[] columnInfoArr = map.get(cls);
            if (columnInfoArr == null) {
                columnInfoArr = parseColumnInfo(cls);
                map.put(cls, columnInfoArr);
            }
            try {
                T newInstance = cls.newInstance();
                for (ColumnInfo columnInfo : columnInfoArr) {
                    try {
                        int i3 = columnInfo.type;
                        switch (i3) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                writePrimitiveField(i3, jSONObject, columnInfo.key, columnInfo.field, newInstance);
                            case 5:
                                JSONObject optJSONObject = jSONObject.optJSONObject(columnInfo.key);
                                if (optJSONObject != null) {
                                    Field field = columnInfo.field;
                                    field.set(newInstance, parseFrom(optJSONObject, field.getType()));
                                }
                            case 6:
                                JSONArray optJSONArray = jSONObject.optJSONArray(columnInfo.key);
                                if (optJSONArray != null) {
                                    Class<?> componentType = columnInfo.field.getType().getComponentType();
                                    int columnInfoType = getColumnInfoType(componentType);
                                    if (columnInfoType != 0 && columnInfoType != 1 && columnInfoType != 2 && columnInfoType != 3 && columnInfoType != 4) {
                                        columnInfo.field.set(newInstance, parseFrom(optJSONArray, componentType));
                                    } else {
                                        writePrimitiveArrayField(columnInfoType, optJSONArray, columnInfo.field, newInstance);
                                    }
                                }
                                break;
                            default:
                                throw new JsonParseException("un-support type : " + columnInfo.type);
                        }
                    } catch (IllegalAccessException e16) {
                        throw new JsonParseException("access field failed : " + columnInfo.field.getName(), e16);
                    }
                }
                return newInstance;
            } catch (Exception e17) {
                throw new JsonParseException("create class instance failed : " + cls.getName(), e17);
            }
        }
        throw new IllegalArgumentException("both jsonObject and clazz should not be null");
    }

    public static JSONObject toJSON(Object obj) throws JsonParseException {
        Object obj2;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Map<Class, ColumnInfo[]> map = sColumnInfoMap;
            ColumnInfo[] columnInfoArr = map.get(cls);
            if (columnInfoArr == null) {
                columnInfoArr = parseColumnInfo(cls);
                map.put(cls, columnInfoArr);
            }
            JSONObject jSONObject = new JSONObject();
            for (ColumnInfo columnInfo : columnInfoArr) {
                try {
                    int i3 = columnInfo.type;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                        if (i3 == 5 && (obj2 = columnInfo.field.get(obj)) != null) {
                                            jSONObject.put(columnInfo.key, toJSON(obj2));
                                        }
                                    } else {
                                        jSONObject.put(columnInfo.key, columnInfo.field.getDouble(obj));
                                    }
                                } else {
                                    jSONObject.put(columnInfo.key, columnInfo.field.getLong(obj));
                                }
                            } else {
                                jSONObject.put(columnInfo.key, columnInfo.field.getInt(obj));
                            }
                        } else {
                            jSONObject.put(columnInfo.key, columnInfo.field.getBoolean(obj));
                        }
                    } else {
                        Object obj3 = columnInfo.field.get(obj);
                        if (obj3 != null) {
                            jSONObject.put(columnInfo.key, obj3);
                        }
                    }
                } catch (IllegalAccessException e16) {
                    throw new JsonParseException("access field failed", e16);
                } catch (JSONException e17) {
                    throw new JsonParseException("operate json object error", e17);
                }
            }
            return jSONObject;
        }
        throw new IllegalArgumentException("object should not be null");
    }

    private static void writePrimitiveArrayField(int i3, JSONArray jSONArray, Field field, Object obj) throws IllegalAccessException, JsonParseException {
        int length = jSONArray.length();
        int i16 = 0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
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
                    long[] jArr = new long[length];
                    while (i16 < length) {
                        jArr[i16] = jSONArray.optLong(i16);
                        i16++;
                    }
                    field.set(obj, jArr);
                    return;
                }
                int[] iArr = new int[length];
                while (i16 < length) {
                    iArr[i16] = jSONArray.optInt(i16);
                    i16++;
                }
                field.set(obj, iArr);
                return;
            }
            boolean[] zArr = new boolean[length];
            while (i16 < length) {
                zArr[i16] = jSONArray.optBoolean(i16);
                i16++;
            }
            field.set(obj, zArr);
            return;
        }
        String[] strArr = new String[length];
        while (i16 < length) {
            strArr[i16] = jSONArray.optString(i16);
            i16++;
        }
        field.set(obj, strArr);
    }

    private static void writePrimitiveField(int i3, JSONObject jSONObject, String str, Field field, Object obj) throws IllegalAccessException, JsonParseException {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            field.set(obj, Double.valueOf(jSONObject.optDouble(str)));
                            return;
                        }
                        throw new JsonParseException("un-support field type : " + i3);
                    }
                    field.set(obj, Long.valueOf(jSONObject.optLong(str)));
                    return;
                }
                field.set(obj, Integer.valueOf(jSONObject.optInt(str)));
                return;
            }
            field.set(obj, Boolean.valueOf(jSONObject.optBoolean(str)));
            return;
        }
        field.set(obj, jSONObject.optString(str));
    }

    private static void parseColumnInfo(Class<?> cls, ArrayList<ColumnInfo> arrayList) throws JsonParseException {
        Field[] declaredFields = cls.getDeclaredFields();
        for (int i3 = 0; i3 != declaredFields.length; i3++) {
            Field field = declaredFields[i3];
            Column column = (Column) field.getAnnotation(Column.class);
            if (column != null) {
                arrayList.add(new ColumnInfo(column.key(), getColumnInfoType(field.getType()), field));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static <T> T[] parseFrom(JSONArray jSONArray, Class<T> cls) throws JsonParseException {
        if (jSONArray != null && cls != null) {
            if (!cls.isPrimitive()) {
                int length = jSONArray.length();
                T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        tArr[i3] = parseFrom(optJSONObject, cls);
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
}
