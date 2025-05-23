package cooperation.qqcircle.utils;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class JsonBinder {
    private static final String TAG = "cooperation.qqcircle.utils.JsonBinder";
    private static JsonBinder jsonBinder;
    private Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();

    JsonBinder() {
    }

    public static JsonBinder getInstance() {
        if (jsonBinder == null) {
            jsonBinder = new JsonBinder();
        }
        return jsonBinder;
    }

    public <T> T fromJson(String str, Class<T> cls) {
        try {
            if (str == null) {
                return cls.newInstance();
            }
            return (T) this.gson.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            Log.e(TAG, "form json error.");
            return null;
        } catch (IllegalAccessException unused2) {
            Log.e(TAG, cls.getName() + "clazz IllegalAccessException error.");
            return null;
        } catch (InstantiationException unused3) {
            Log.e(TAG, cls.getName() + "clazz new instance instantiation error.");
            return null;
        } catch (NumberFormatException unused4) {
            Log.e(TAG, cls.getName() + "clazz NumberFormatException error.");
            return null;
        }
    }

    public <T> T generticfromJson(String str, Type type) {
        try {
            return (T) this.gson.fromJson(str, type);
        } catch (JsonSyntaxException unused) {
            Log.e(TAG, "form json error.");
            return null;
        }
    }

    public String toJson(Object obj) {
        return this.gson.toJson(obj);
    }

    public <T> String toJson(List<T> list) {
        return this.gson.toJson(list, new TypeToken<List<T>>() { // from class: cooperation.qqcircle.utils.JsonBinder.1
        }.getType());
    }

    public <T> List<T> fromJson(String str, Type type) {
        if (str == null) {
            return new ArrayList();
        }
        try {
            return (List) this.gson.fromJson(str, type);
        } catch (JsonSyntaxException unused) {
            Log.e(TAG, "form json error.");
            return new ArrayList();
        }
    }
}
