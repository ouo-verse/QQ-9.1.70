package com.tencent.turingcam;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes27.dex */
public class rBDKv {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, Class<?>> f382353a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Field>> f382354b;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Method>> f382355c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14190);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f382353a = new HashMap<>();
        f382354b = new HashMap<>();
        f382355c = new HashMap<>();
    }

    public static Object a(String str, String str2) {
        Class<?> cls;
        try {
            try {
                cls = f382353a.get(str);
                if (cls == null) {
                    cls = Class.forName(str);
                }
                f382353a.put(str, cls);
            } catch (Throwable th5) {
                th5.printStackTrace();
                cls = null;
            }
            return a(cls, str2, (Object) null);
        } catch (Throwable th6) {
            th6.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0037 A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:8:0x0037, B:23:0x0030, B:12:0x0004, B:14:0x000e, B:15:0x0018, B:17:0x0020, B:20:0x0027), top: B:2:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(Class<?> cls, String str, Object obj) {
        HashMap<String, Field> hashMap;
        Field field;
        try {
            if (cls != null) {
                try {
                    hashMap = f382354b.get(cls);
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                        f382354b.put(cls, hashMap);
                    }
                    field = hashMap.get(str);
                    if (field == null) {
                        field = cls.getDeclaredField(str);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (field != null) {
                    field.setAccessible(true);
                    hashMap.put(str, field);
                    if (field != null) {
                        return null;
                    }
                    return field.get(obj);
                }
            }
            field = null;
            if (field != null) {
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
            return null;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(str);
            if (clsArr != null) {
                for (Class<?> cls2 : clsArr) {
                    stringBuffer.append(Marker.ANY_NON_NULL_MARKER);
                    stringBuffer.append(cls2.getName());
                }
            }
            String stringBuffer2 = stringBuffer.toString();
            HashMap<String, Method> hashMap = f382355c.get(cls);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                f382355c.put(cls, hashMap);
            }
            Method method = hashMap.get(stringBuffer2);
            if (method == null) {
                method = cls.getDeclaredMethod(str, clsArr);
            }
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            hashMap.put(stringBuffer2, method);
            return method;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
