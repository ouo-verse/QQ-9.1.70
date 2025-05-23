package com.tencent.biz.qqcircle.utils;

import com.google.gson.Gson;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bv {

    /* renamed from: a, reason: collision with root package name */
    private static final Gson f92730a = new Gson();

    public static <T> T a(String str, Type type) {
        try {
            return (T) f92730a.fromJson(str, type);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> String b(T t16) {
        if (t16 == null) {
            return null;
        }
        try {
            return f92730a.toJson(t16);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> String c(T t16, Type type) {
        if (t16 == null) {
            return null;
        }
        try {
            return f92730a.toJson(t16, type);
        } catch (Throwable unused) {
            return null;
        }
    }
}
