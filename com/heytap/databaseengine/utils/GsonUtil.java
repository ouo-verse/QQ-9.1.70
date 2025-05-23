package com.heytap.databaseengine.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GsonUtil {
    public static <T> T fromJson(String str, Class<T> cls) {
        try {
            return (T) new Gson().fromJson(str, (Class) cls);
        } catch (Exception e16) {
            HLog.d("fromJson err ", str);
            HLog.e("GsonUtil", e16.getMessage());
            return null;
        }
    }

    public static <T> List<T> fromJsonToDoubleList(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (List) new Gson().fromJson(str, new ParameterizedTypeImpl(Double.class));
        } catch (JsonSyntaxException e16) {
            HLog.e("GsonUtil", e16.getMessage());
            return null;
        }
    }

    public static <T> List<T> fromJsonToList(String str, Class cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (List) new Gson().fromJson(str, new ParameterizedTypeImpl(cls));
        } catch (JsonSyntaxException e16) {
            HLog.e("GsonUtil", e16.getMessage());
            return null;
        }
    }

    public static String realToJson(Object obj) {
        return new GsonBuilder().setPrettyPrinting().serializeSpecialFloatingPointValues().create().toJson(obj);
    }

    public static <K, V> HashMap<K, V> toHashMap(String str, Class<K> cls, Class<V> cls2) {
        return (HashMap) new Gson().fromJson(str, TypeToken.getParameterized(HashMap.class, cls, cls2).getType());
    }

    public static String toJson(Object obj) {
        return new Gson().toJson(obj);
    }

    public static <T> T fromJson(String str, Type type) {
        try {
            return (T) new Gson().fromJson(str, type);
        } catch (JsonSyntaxException e16) {
            HLog.e("GsonUtil", e16.getMessage());
            return null;
        }
    }
}
