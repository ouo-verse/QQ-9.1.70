package com.huawei.agconnect.core;

import com.huawei.agconnect.annotation.AutoCreated;
import com.huawei.agconnect.annotation.SharedInstance;
import com.huawei.agconnect.annotation.Singleton;
import java.lang.reflect.Modifier;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Service {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f36505a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f36506b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f36507c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f36508d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f36509e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f36510f;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        Class<?> f36511a;

        /* renamed from: b, reason: collision with root package name */
        Class<?> f36512b;

        /* renamed from: c, reason: collision with root package name */
        Object f36513c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f36514d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f36515e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f36516f;

        public Service build() {
            Class<?> cls = this.f36511a;
            if (cls != null) {
                Class<?> cls2 = this.f36512b;
                if (cls2 != null) {
                    if (!cls2.isInterface() && Modifier.isPublic(this.f36512b.getModifiers())) {
                        Service service = new Service((Class) this.f36511a, (Class) this.f36512b);
                        service.f36508d = this.f36514d;
                        service.f36509e = this.f36515e;
                        service.f36510f = this.f36516f;
                        return service;
                    }
                    throw new IllegalArgumentException("the clazz parameter cant be interface type or not public");
                }
                Object obj = this.f36513c;
                if (obj != null) {
                    Service service2 = new Service(cls, obj);
                    service2.f36508d = this.f36514d;
                    return service2;
                }
                throw new IllegalArgumentException("the clazz or object parameter must set one");
            }
            throw new IllegalArgumentException("the interface parameter cannot be NULL");
        }

        public Builder isAutoCreated(boolean z16) {
            this.f36516f = z16;
            return this;
        }

        public Builder isSharedInstance(boolean z16) {
            this.f36515e = z16;
            return this;
        }

        public Builder isSingleton(boolean z16) {
            this.f36514d = z16;
            return this;
        }

        public Builder setClass(Class<?> cls) {
            this.f36512b = cls;
            return this;
        }

        public Builder setInterface(Class<?> cls) {
            this.f36511a = cls;
            return this;
        }

        public Builder setObject(Object obj) {
            this.f36513c = obj;
            return this;
        }
    }

    Service(Class<?> cls, Class<?> cls2) {
        this.f36505a = cls;
        this.f36506b = cls2;
        this.f36507c = null;
    }

    public static Builder builder(Class<?> cls) {
        return new Builder().setInterface(cls).setClass(cls).isSingleton(cls.isAnnotationPresent(Singleton.class)).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }

    public Object getInstance() {
        return this.f36507c;
    }

    public Class<?> getInterface() {
        return this.f36505a;
    }

    public Class<?> getType() {
        return this.f36506b;
    }

    public boolean isAutoCreated() {
        return this.f36510f;
    }

    public boolean isSharedInstance() {
        return this.f36509e;
    }

    public boolean isSingleton() {
        return this.f36508d;
    }

    public static Builder builder(Class<?> cls, Class<?> cls2) {
        return new Builder().setInterface(cls).setClass(cls2).isSingleton(cls2.isAnnotationPresent(Singleton.class)).isSharedInstance(cls2.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls2.isAnnotationPresent(AutoCreated.class));
    }

    Service(Class<?> cls, Object obj) {
        this.f36505a = cls;
        this.f36506b = null;
        this.f36507c = obj;
    }

    public static Builder builder(Class<?> cls, Object obj) {
        return new Builder().setInterface(cls).setObject(obj).isSingleton(true).isSharedInstance(cls.isAnnotationPresent(SharedInstance.class)).isAutoCreated(cls.isAnnotationPresent(AutoCreated.class));
    }
}
