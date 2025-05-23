package com.tencent.mobileqq.crossend.communication.core;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.config.toggle.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Class<?>> f203040a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23058);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203040a = new HashMap<>();
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName(String.format("com.tencent.mobileqq.crossend.communication.generated.%s_BusinessNode", str));
            Field declaredField = cls.getDeclaredField("classPath");
            declaredField.setAccessible(true);
            return (String) declaredField.get(cls.newInstance());
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException e16) {
            QLog.e("QQCrossEndWebEventDispatcher", 1, e16, new Object[0]);
            return b(str);
        }
    }

    private static String b(String str) {
        c cVar = c.f364698k;
        if (!cVar.g(false)) {
            return "";
        }
        String d16 = cVar.d(str, "");
        if (TextUtils.isEmpty(d16) && str != null && str.length() > 20) {
            return cVar.d(str.substring(0, 20), "");
        }
        return d16;
    }

    private static Method c(Object obj, String str) {
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.getName().equals(str)) {
                return method;
            }
        }
        return null;
    }

    public static void d(String str, String str2, JSONObject jSONObject, @NotNull ab1.a aVar) {
        HashMap<String, Class<?>> hashMap = f203040a;
        if (!hashMap.containsKey(str)) {
            String a16 = a(str);
            if (a16 != null && a16.length() > 0) {
                try {
                    hashMap.put(str, Class.forName(a16));
                } catch (ClassNotFoundException e16) {
                    QLog.e("QQCrossEndWebEventDispatcher", 1, e16, new Object[0]);
                }
            } else {
                QLog.e("QQCrossEndWebEventDispatcher", 1, "onWebEventRequest, business-" + str + "'s impl not found");
                return;
            }
        }
        HashMap<String, Class<?>> hashMap2 = f203040a;
        if (!hashMap2.containsKey(str)) {
            QLog.e("QQCrossEndWebEventDispatcher", 1, "onWebEventRequest, business-" + str + "'s impl not found");
            return;
        }
        try {
            e(hashMap2.get(str).newInstance(), str2, jSONObject, aVar);
        } catch (IllegalAccessException | InstantiationException e17) {
            QLog.e("QQCrossEndWebEventDispatcher", 1, e17, new Object[0]);
        }
    }

    private static void e(Object obj, String str, JSONObject jSONObject, ab1.a aVar) {
        Method c16 = c(obj, str);
        if (c16 == null) {
            QLog.e("QQCrossEndWebEventDispatcher", 1, str + " not found");
            return;
        }
        try {
            c16.setAccessible(true);
            c16.invoke(obj, jSONObject, aVar);
        } catch (IllegalAccessException | InvocationTargetException e16) {
            QLog.e("QQCrossEndWebEventDispatcher", 1, e16, new Object[0]);
        }
    }
}
