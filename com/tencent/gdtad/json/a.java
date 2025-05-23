package com.tencent.gdtad.json;

import com.google.gson.GsonBuilder;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    public static <T> T a(String str, Class<T> cls, T t16) {
        try {
            return (T) new GsonBuilder().disableHtmlEscaping().create().fromJson(str, (Class) cls);
        } catch (Throwable th5) {
            QLog.e("GdtGsonUtil", 1, "[fromJson]", th5);
            return t16;
        }
    }

    public static String b(Object obj, String str) {
        try {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(obj);
        } catch (Throwable th5) {
            QLog.e("GdtGsonUtil", 1, "[toString]", th5);
            return str;
        }
    }
}
