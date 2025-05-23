package com.tencent.tmassistantbase.util.t;

import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f380526a = true;

    public Object a(Object obj, Method method, Object[] objArr, Object obj2) {
        return obj2;
    }

    public abstract String a();

    public Object b(Object obj, Method method, Object... objArr) {
        method.setAccessible(true);
        return method.invoke(obj, objArr);
    }

    public boolean a(Object obj, Method method, Object... objArr) {
        return true;
    }

    public void a(boolean z16) {
        this.f380526a = z16;
    }

    public boolean b() {
        return this.f380526a;
    }
}
