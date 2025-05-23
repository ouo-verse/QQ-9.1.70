package com.tencent.biz.pubaccount.util;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static final String f80335b = "com.tencent.biz.pubaccount.util.d";

    /* renamed from: c, reason: collision with root package name */
    private static d f80336c;

    /* renamed from: a, reason: collision with root package name */
    private Gson f80337a = new GsonBuilder().serializeSpecialFloatingPointValues().setLongSerializationPolicy(LongSerializationPolicy.STRING).create();

    d() {
    }

    public static d b() {
        if (f80336c == null) {
            f80336c = new d();
        }
        return f80336c;
    }

    public <T> T a(String str, Class<T> cls) {
        try {
            if (str == null) {
                return cls.newInstance();
            }
            return (T) this.f80337a.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException unused) {
            Log.e(f80335b, "form json error.");
            return null;
        } catch (IllegalAccessException unused2) {
            Log.e(f80335b, cls.getName() + "clazz IllegalAccessException error.");
            return null;
        } catch (InstantiationException unused3) {
            Log.e(f80335b, cls.getName() + "clazz new instance instantiation error.");
            return null;
        } catch (NumberFormatException unused4) {
            Log.e(f80335b, cls.getName() + "clazz NumberFormatException error.");
            return null;
        }
    }

    public String c(Object obj) {
        return this.f80337a.toJson(obj);
    }

    public String d(Object obj, Type type) {
        return this.f80337a.toJson(obj, type);
    }
}
