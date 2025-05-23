package com.tencent.mobileqq.persistence;

import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes16.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static j f258324a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static Method f258325b = null;

    public static j b() {
        return f258324a;
    }

    public OGAbstractDao a(Class cls) {
        return EntityDaoRegister.getEntityDao(cls);
    }
}
