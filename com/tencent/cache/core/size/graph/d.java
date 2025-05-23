package com.tencent.cache.core.size.graph;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final e<Class<?>, SoftReference<Collection<Field>>> f98799a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final d f98800b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f98800b = new d();
        e<Class<?>, Long> eVar = a.f98788a;
        f98799a = new e<>(null);
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final String a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, obj);
        }
        if (obj != null) {
            return obj.getClass().getSimpleName() + util.base64_pad_url + obj.hashCode();
        }
        return "null";
    }

    public final Collection<Field> b(Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Collection) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                Intrinsics.checkNotNullExpressionValue(field, "field");
                if (!Modifier.isStatic(field.getModifiers())) {
                    Class<?> type = field.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "field.type");
                    if (!type.isPrimitive()) {
                        try {
                            field.setAccessible(true);
                            arrayList.add(field);
                        } catch (SecurityException | RuntimeException unused) {
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }
}
