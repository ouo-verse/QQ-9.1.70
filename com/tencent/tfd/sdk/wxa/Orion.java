package com.tencent.tfd.sdk.wxa;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Orion {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Field>> f375660a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Method>> f375661b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62696);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        new HashMap();
        f375660a = new HashMap<>();
        f375661b = new HashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #0 {all -> 0x0039, blocks: (B:15:0x0034, B:24:0x002d, B:3:0x0001, B:5:0x000b, B:6:0x0015, B:8:0x001d, B:18:0x0024), top: B:2:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(Class<?> cls, String str, Object obj) {
        Field field;
        HashMap<String, Field> hashMap;
        try {
            try {
                hashMap = f375660a.get(cls);
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                    f375660a.put(cls, hashMap);
                }
                field = hashMap.get(str);
                if (field == null) {
                    field = cls.getDeclaredField(str);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (field == null) {
                field = null;
                if (field != null) {
                    return null;
                }
                return field.get(obj);
            }
            field.setAccessible(true);
            hashMap.put(str, field);
            if (field != null) {
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
            return null;
        }
    }

    public static Method a(Class cls) {
        try {
            if (TextUtils.isEmpty("getAccessibilityInteractionController")) {
                return null;
            }
            String stringBuffer = new StringBuffer("getAccessibilityInteractionController").toString();
            HashMap<String, Method> hashMap = f375661b.get(cls);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                f375661b.put(cls, hashMap);
            }
            Method method = hashMap.get(stringBuffer);
            if (method == null) {
                method = cls.getDeclaredMethod("getAccessibilityInteractionController", null);
            }
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            hashMap.put(stringBuffer, method);
            return method;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
