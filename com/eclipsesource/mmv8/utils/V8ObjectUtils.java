package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.Releasable;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8ArrayBuffer;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.V8TypedArray;
import com.eclipsesource.mmv8.V8Value;
import com.eclipsesource.mmv8.utils.typedarrays.ArrayBuffer;
import com.eclipsesource.mmv8.utils.typedarrays.Float32Array;
import com.eclipsesource.mmv8.utils.typedarrays.Float64Array;
import com.eclipsesource.mmv8.utils.typedarrays.Int16Array;
import com.eclipsesource.mmv8.utils.typedarrays.Int32Array;
import com.eclipsesource.mmv8.utils.typedarrays.Int8Array;
import com.eclipsesource.mmv8.utils.typedarrays.TypedArray;
import com.eclipsesource.mmv8.utils.typedarrays.UInt16Array;
import com.eclipsesource.mmv8.utils.typedarrays.UInt32Array;
import com.eclipsesource.mmv8.utils.typedarrays.UInt8Array;
import com.eclipsesource.mmv8.utils.typedarrays.UInt8ClampedArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8ObjectUtils {
    private static final Object IGNORE = new Object();
    private static final TypeAdapter DEFAULT_TYPE_ADAPTER = new DefaultTypeAdapter();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DefaultTypeAdapter implements TypeAdapter {
        @Override // com.eclipsesource.mmv8.utils.TypeAdapter
        public Object adapt(int i3, Object obj) {
            return TypeAdapter.DEFAULT;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ListWrapper {
        private List<? extends Object> list;

        public ListWrapper(List<? extends Object> list) {
            this.list = list;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ListWrapper) || ((ListWrapper) obj).list != this.list) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return System.identityHashCode(this.list);
        }
    }

    V8ObjectUtils() {
    }

    public static Object getTypedArray(V8Array v8Array, int i3, Object obj) {
        int length = v8Array.length();
        if (i3 == 1) {
            int[] iArr = (int[]) obj;
            if (iArr == null || iArr.length < length) {
                iArr = new int[length];
            }
            v8Array.getIntegers(0, length, iArr);
            return iArr;
        }
        if (i3 == 2) {
            double[] dArr = (double[]) obj;
            if (dArr == null || dArr.length < length) {
                dArr = new double[length];
            }
            v8Array.getDoubles(0, length, dArr);
            return dArr;
        }
        if (i3 == 3) {
            boolean[] zArr = (boolean[]) obj;
            if (zArr == null || zArr.length < length) {
                zArr = new boolean[length];
            }
            v8Array.getBooleans(0, length, zArr);
            return zArr;
        }
        if (i3 == 4) {
            String[] strArr = (String[]) obj;
            if (strArr == null || strArr.length < length) {
                strArr = new String[length];
            }
            v8Array.getStrings(0, length, strArr);
            return strArr;
        }
        if (i3 == 9) {
            byte[] bArr = (byte[]) obj;
            if (bArr == null || bArr.length < length) {
                bArr = new byte[length];
            }
            v8Array.getBytes(0, length, bArr);
            return bArr;
        }
        throw new RuntimeException("Unsupported bulk load type: " + i3);
    }

    public static Object getV8Result(V8 v85, Object obj) {
        if (obj == null) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        try {
            Object v8Result = getV8Result(v85, obj, hashtable);
            if (v8Result instanceof V8Object) {
                return ((V8Object) v8Result).twin();
            }
            Iterator it = hashtable.values().iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
            return v8Result;
        } finally {
            Iterator it5 = hashtable.values().iterator();
            while (it5.hasNext()) {
                ((V8Value) it5.next()).release();
            }
        }
    }

    public static Object getValue(Object obj) {
        return getValue(obj, DEFAULT_TYPE_ADAPTER);
    }

    public static void pushValue(V8 v85, V8Array v8Array, Object obj) {
        Hashtable hashtable = new Hashtable();
        try {
            pushValue(v85, v8Array, obj, hashtable);
        } finally {
            Iterator it = hashtable.values().iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
        }
    }

    private static void setValue(V8 v85, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Object.addUndefined(str);
            return;
        }
        if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            v8Object.add(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Float) {
            v8Object.add(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof String) {
            v8Object.add(str, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof V8Object) {
            v8Object.add(str, (V8Object) obj);
            return;
        }
        if (obj instanceof TypedArray) {
            v8Object.add(str, toV8TypedArray(v85, (TypedArray) obj, map));
            return;
        }
        if (obj instanceof ArrayBuffer) {
            v8Object.add(str, toV8ArrayBuffer(v85, (ArrayBuffer) obj, map));
            return;
        }
        if (obj instanceof Map) {
            v8Object.add(str, toV8Object(v85, (Map<String, ? extends Object>) obj, map));
        } else {
            if (obj instanceof List) {
                v8Object.add(str, toV8Array(v85, (List<? extends Object>) obj, map));
                return;
            }
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }

    public static List<? super Object> toList(V8Array v8Array) {
        return toList(v8Array, DEFAULT_TYPE_ADAPTER);
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object) {
        return toMap(v8Object, DEFAULT_TYPE_ADAPTER);
    }

    private static Object toTypedArray(V8Array v8Array) {
        int type = v8Array.getType();
        ByteBuffer byteBuffer = ((V8TypedArray) v8Array).getByteBuffer();
        if (type != 1) {
            if (type != 2) {
                if (type != 9) {
                    switch (type) {
                        case 11:
                            return new UInt8Array(byteBuffer);
                        case 12:
                            return new UInt8ClampedArray(byteBuffer);
                        case 13:
                            return new Int16Array(byteBuffer);
                        case 14:
                            return new UInt16Array(byteBuffer);
                        case 15:
                            return new UInt32Array(byteBuffer);
                        case 16:
                            return new Float32Array(byteBuffer);
                        default:
                            throw new IllegalStateException("Known Typed Array type: " + V8Value.getStringRepresentation(type));
                    }
                }
                return new Int8Array(byteBuffer);
            }
            return new Float64Array(byteBuffer);
        }
        return new Int32Array(byteBuffer);
    }

    public static V8Array toV8Array(V8 v85, List<? extends Object> list) {
        Hashtable hashtable = new Hashtable();
        try {
            return toV8Array(v85, list, hashtable).twin();
        } finally {
            Iterator it = hashtable.values().iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
        }
    }

    private static V8ArrayBuffer toV8ArrayBuffer(V8 v85, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        if (map.containsKey(arrayBuffer)) {
            return (V8ArrayBuffer) map.get(arrayBuffer);
        }
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(v85, arrayBuffer.getByteBuffer());
        map.put(arrayBuffer, v8ArrayBuffer);
        return v8ArrayBuffer;
    }

    public static V8Object toV8Object(V8 v85, Map<String, ? extends Object> map) {
        Hashtable hashtable = new Hashtable();
        try {
            return toV8Object(v85, map, hashtable).twin();
        } finally {
            Iterator it = hashtable.values().iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
        }
    }

    private static V8TypedArray toV8TypedArray(V8 v85, TypedArray typedArray, Map<Object, V8Value> map) {
        if (map.containsKey(typedArray)) {
            return (V8TypedArray) map.get(typedArray);
        }
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(v85, typedArray.getByteBuffer());
        try {
            V8TypedArray v8TypedArray = new V8TypedArray(v85, v8ArrayBuffer, typedArray.getType(), 0, typedArray.length());
            map.put(typedArray, v8TypedArray);
            return v8TypedArray;
        } finally {
            v8ArrayBuffer.release();
        }
    }

    public static Object getValue(Object obj, TypeAdapter typeAdapter) {
        V8Map v8Map = new V8Map();
        try {
            return obj instanceof V8Value ? getValue(obj, ((V8Value) obj).getV8Type(), v8Map, typeAdapter) : obj;
        } finally {
            v8Map.release();
        }
    }

    public static List<? super Object> toList(V8Array v8Array, TypeAdapter typeAdapter) {
        V8Map v8Map = new V8Map();
        try {
            return toList(v8Array, v8Map, typeAdapter);
        } finally {
            v8Map.release();
        }
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object, TypeAdapter typeAdapter) {
        V8Map v8Map = new V8Map();
        try {
            return toMap(v8Object, v8Map, typeAdapter);
        } finally {
            v8Map.release();
        }
    }

    private static V8ArrayBuffer toV8ArrayBuffer(V8Context v8Context, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        if (map.containsKey(arrayBuffer)) {
            return (V8ArrayBuffer) map.get(arrayBuffer);
        }
        V8ArrayBuffer newV8ArrayBuffer = v8Context.newV8ArrayBuffer(arrayBuffer.getByteBuffer());
        map.put(arrayBuffer, newV8ArrayBuffer);
        return newV8ArrayBuffer;
    }

    private static List<? super Object> toList(V8Array v8Array, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        Object obj;
        if (v8Array == null) {
            return Collections.emptyList();
        }
        if (v8Map.containsKey(v8Array)) {
            return (List) v8Map.get(v8Array);
        }
        ArrayList arrayList = new ArrayList();
        v8Map.put2((V8Value) v8Array, (V8Array) arrayList);
        for (int i3 = 0; i3 < v8Array.length(); i3++) {
            try {
                obj = v8Array.get(i3);
            } catch (Throwable th5) {
                th = th5;
                obj = null;
            }
            try {
                Object value = getValue(obj, v8Array.getType(i3), v8Map, typeAdapter);
                if (value != IGNORE) {
                    arrayList.add(value);
                }
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
            } catch (Throwable th6) {
                th = th6;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                throw th;
            }
        }
        return arrayList;
    }

    private static Map<String, ? super Object> toMap(V8Object v8Object, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        Object obj;
        if (v8Object == null) {
            return Collections.emptyMap();
        }
        if (v8Map.containsKey(v8Object)) {
            return (Map) v8Map.get(v8Object);
        }
        V8PropertyMap v8PropertyMap = new V8PropertyMap();
        v8Map.put2((V8Value) v8Object, (V8Object) v8PropertyMap);
        for (String str : v8Object.getKeys()) {
            try {
                obj = v8Object.get(str);
            } catch (Throwable th5) {
                th = th5;
                obj = null;
            }
            try {
                Object value = getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
                if (value != IGNORE) {
                    v8PropertyMap.put((V8PropertyMap) str, (String) value);
                }
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
            } catch (Throwable th6) {
                th = th6;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                throw th;
            }
        }
        return v8PropertyMap;
    }

    public static Object getValue(V8Array v8Array, int i3) {
        Object obj;
        V8Map v8Map = new V8Map();
        try {
            obj = v8Array.get(i3);
        } catch (Throwable th5) {
            th = th5;
            obj = null;
        }
        try {
            Object value = getValue(obj, v8Array.getType(i3), v8Map, DEFAULT_TYPE_ADAPTER);
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            return value;
        } catch (Throwable th6) {
            th = th6;
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            throw th;
        }
    }

    public static void pushValue(V8Context v8Context, V8Array v8Array, Object obj) {
        Hashtable hashtable = new Hashtable();
        try {
            pushValue(v8Context, v8Array, obj, hashtable);
        } finally {
            Iterator it = hashtable.values().iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
        }
    }

    public static V8Array toV8Array(V8Context v8Context, List<? extends Object> list) {
        Hashtable hashtable = new Hashtable();
        try {
            return toV8Array(v8Context, list, hashtable).twin();
        } finally {
            Iterator it = hashtable.values().iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
        }
    }

    public static V8Object toV8Object(V8Context v8Context, Map<String, ? extends Object> map) {
        Hashtable hashtable = new Hashtable();
        try {
            return toV8Object(v8Context, map, hashtable).twin();
        } finally {
            Iterator it = hashtable.values().iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
        }
    }

    private static V8TypedArray toV8TypedArray(V8Context v8Context, TypedArray typedArray, Map<Object, V8Value> map) {
        if (map.containsKey(typedArray)) {
            return (V8TypedArray) map.get(typedArray);
        }
        V8ArrayBuffer newV8ArrayBuffer = v8Context.newV8ArrayBuffer(typedArray.getByteBuffer());
        try {
            V8TypedArray newV8TypedArray = v8Context.newV8TypedArray(newV8ArrayBuffer, typedArray.getType(), 0, typedArray.length());
            map.put(typedArray, newV8TypedArray);
            return newV8TypedArray;
        } finally {
            newV8ArrayBuffer.release();
        }
    }

    public static Object getV8Result(V8Context v8Context, Object obj) {
        if (obj == null) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        try {
            Object v8Result = getV8Result(v8Context, obj, hashtable);
            if (v8Result instanceof V8Object) {
                return ((V8Object) v8Result).twin();
            }
            Iterator it = hashtable.values().iterator();
            while (it.hasNext()) {
                ((V8Value) it.next()).release();
            }
            return v8Result;
        } finally {
            Iterator it5 = hashtable.values().iterator();
            while (it5.hasNext()) {
                ((V8Value) it5.next()).release();
            }
        }
    }

    private static void pushValue(V8 v85, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Array.pushUndefined();
            return;
        }
        if (obj instanceof Integer) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof Long) {
            v8Array.push(new Double(((Long) obj).longValue()));
            return;
        }
        if (obj instanceof Double) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof Float) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof String) {
            v8Array.push((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof V8Object) {
            v8Array.push((V8Value) obj);
            return;
        }
        if (obj instanceof TypedArray) {
            v8Array.push((V8Value) toV8TypedArray(v85, (TypedArray) obj, map));
            return;
        }
        if (obj instanceof ArrayBuffer) {
            v8Array.push((V8Value) toV8ArrayBuffer(v85, (ArrayBuffer) obj, map));
            return;
        }
        if (obj instanceof Map) {
            v8Array.push((V8Value) toV8Object(v85, (Map<String, ? extends Object>) obj, map));
        } else {
            if (obj instanceof List) {
                v8Array.push((V8Value) toV8Array(v85, (List<? extends Object>) obj, map));
                return;
            }
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }

    private static V8Array toV8Array(V8 v85, List<? extends Object> list, Map<Object, V8Value> map) {
        if (map.containsKey(new ListWrapper(list))) {
            return (V8Array) map.get(new ListWrapper(list));
        }
        V8Array v8Array = new V8Array(v85);
        map.put(new ListWrapper(list), v8Array);
        for (int i3 = 0; i3 < list.size(); i3++) {
            try {
                pushValue(v85, v8Array, list.get(i3), map);
            } catch (IllegalStateException e16) {
                v8Array.release();
                throw e16;
            }
        }
        return v8Array;
    }

    private static V8Object toV8Object(V8 v85, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        if (map2.containsKey(map)) {
            return (V8Object) map2.get(map);
        }
        V8Object v8Object = new V8Object(v85);
        map2.put(map, v8Object);
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                setValue(v85, v8Object, entry.getKey(), entry.getValue(), map2);
            }
            return v8Object;
        } catch (IllegalStateException e16) {
            v8Object.release();
            throw e16;
        }
    }

    public static Object getValue(V8Array v8Array, int i3, TypeAdapter typeAdapter) {
        Object obj;
        V8Map v8Map = new V8Map();
        try {
            obj = v8Array.get(i3);
            try {
                Object value = getValue(obj, v8Array.getType(i3), v8Map, typeAdapter);
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                return value;
            } catch (Throwable th5) {
                th = th5;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            obj = null;
        }
    }

    public static Object getTypedArray(V8Array v8Array, int i3) {
        int length = v8Array.length();
        if (i3 == 1) {
            return v8Array.getIntegers(0, length);
        }
        if (i3 == 2) {
            return v8Array.getDoubles(0, length);
        }
        if (i3 == 3) {
            return v8Array.getBooleans(0, length);
        }
        if (i3 == 4) {
            return v8Array.getStrings(0, length);
        }
        throw new RuntimeException("Unsupported bulk load type: " + i3);
    }

    private static Object getV8Result(V8 v85, Object obj, Map<Object, V8Value> map) {
        if (map.containsKey(obj)) {
            return map.get(obj);
        }
        if (obj instanceof Map) {
            return toV8Object(v85, (Map<String, ? extends Object>) obj, map);
        }
        if (obj instanceof List) {
            return toV8Array(v85, (List<? extends Object>) obj, map);
        }
        if (obj instanceof TypedArray) {
            return toV8TypedArray(v85, (TypedArray) obj, map);
        }
        return obj instanceof ArrayBuffer ? toV8ArrayBuffer(v85, (ArrayBuffer) obj, map) : obj;
    }

    private static V8Object toV8Object(V8Context v8Context, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        if (map2.containsKey(map)) {
            return (V8Object) map2.get(map);
        }
        V8Object newV8Object = v8Context.newV8Object();
        map2.put(map, newV8Object);
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                setValue(v8Context, newV8Object, entry.getKey(), entry.getValue(), map2);
            }
            return newV8Object;
        } catch (IllegalStateException e16) {
            newV8Object.release();
            throw e16;
        }
    }

    private static V8Array toV8Array(V8Context v8Context, List<? extends Object> list, Map<Object, V8Value> map) {
        if (map.containsKey(new ListWrapper(list))) {
            return (V8Array) map.get(new ListWrapper(list));
        }
        V8Array newV8Array = v8Context.newV8Array();
        map.put(new ListWrapper(list), newV8Array);
        for (int i3 = 0; i3 < list.size(); i3++) {
            try {
                pushValue(v8Context, newV8Array, list.get(i3), map);
            } catch (IllegalStateException e16) {
                newV8Array.release();
                throw e16;
            }
        }
        return newV8Array;
    }

    private static void setValue(V8Context v8Context, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Object.addUndefined(str);
            return;
        }
        if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            v8Object.add(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Float) {
            v8Object.add(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof String) {
            v8Object.add(str, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof V8Object) {
            v8Object.add(str, (V8Object) obj);
            return;
        }
        if (obj instanceof TypedArray) {
            v8Object.add(str, toV8TypedArray(v8Context, (TypedArray) obj, map));
            return;
        }
        if (obj instanceof ArrayBuffer) {
            v8Object.add(str, toV8ArrayBuffer(v8Context, (ArrayBuffer) obj, map));
            return;
        }
        if (obj instanceof Map) {
            v8Object.add(str, toV8Object(v8Context, (Map<String, ? extends Object>) obj, map));
        } else {
            if (obj instanceof List) {
                v8Object.add(str, toV8Array(v8Context, (List<? extends Object>) obj, map));
                return;
            }
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }

    public static Object getValue(V8Object v8Object, String str) {
        return getValue(v8Object, str, DEFAULT_TYPE_ADAPTER);
    }

    public static Object getValue(V8Object v8Object, String str, TypeAdapter typeAdapter) {
        Object obj;
        V8Map v8Map = new V8Map();
        try {
            obj = v8Object.get(str);
            try {
                Object value = getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                return value;
            } catch (Throwable th5) {
                th = th5;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.release();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            obj = null;
        }
    }

    private static Object getV8Result(V8Context v8Context, Object obj, Map<Object, V8Value> map) {
        if (map.containsKey(obj)) {
            return map.get(obj);
        }
        if (obj instanceof Map) {
            return toV8Object(v8Context, (Map<String, ? extends Object>) obj, map);
        }
        if (obj instanceof List) {
            return toV8Array(v8Context, (List<? extends Object>) obj, map);
        }
        if (obj instanceof TypedArray) {
            return toV8TypedArray(v8Context, (TypedArray) obj, map);
        }
        return obj instanceof ArrayBuffer ? toV8ArrayBuffer(v8Context, (ArrayBuffer) obj, map) : obj;
    }

    private static Object getValue(Object obj, int i3, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        Object adapt = typeAdapter.adapt(i3, obj);
        if (TypeAdapter.DEFAULT != adapt) {
            return adapt;
        }
        if (i3 == 10) {
            return new ArrayBuffer(((V8ArrayBuffer) obj).getBackingStore());
        }
        if (i3 != 99) {
            switch (i3) {
                case 0:
                    return null;
                case 1:
                case 2:
                case 3:
                case 4:
                    return obj;
                case 5:
                    return toList((V8Array) obj, v8Map, typeAdapter);
                case 6:
                    return toMap((V8Object) obj, v8Map, typeAdapter);
                case 7:
                    return IGNORE;
                case 8:
                    return toTypedArray((V8Array) obj);
                default:
                    throw new IllegalStateException("Cannot convert type " + V8Value.getStringRepresentation(i3));
            }
        }
        return V8.getUndefined();
    }

    private static void pushValue(V8Context v8Context, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Array.pushUndefined();
            return;
        }
        if (obj instanceof Integer) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof Long) {
            v8Array.push(new Double(((Long) obj).longValue()));
            return;
        }
        if (obj instanceof Double) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof Float) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof String) {
            v8Array.push((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof V8Object) {
            v8Array.push((V8Value) obj);
            return;
        }
        if (obj instanceof TypedArray) {
            v8Array.push((V8Value) toV8TypedArray(v8Context, (TypedArray) obj, map));
            return;
        }
        if (obj instanceof ArrayBuffer) {
            v8Array.push((V8Value) toV8ArrayBuffer(v8Context, (ArrayBuffer) obj, map));
            return;
        }
        if (obj instanceof Map) {
            v8Array.push((V8Value) toV8Object(v8Context, (Map<String, ? extends Object>) obj, map));
        } else {
            if (obj instanceof List) {
                v8Array.push((V8Value) toV8Array(v8Context, (List<? extends Object>) obj, map));
                return;
            }
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }
}
