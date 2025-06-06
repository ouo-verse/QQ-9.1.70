package com.nineoldandroids.util;

/* loaded from: classes2.dex */
public abstract class Property<T, V> {
    private final String mName;
    private final Class<V> mType;

    public Property(Class<V> cls, String str) {
        this.mName = str;
        this.mType = cls;
    }

    public static <T, V> Property<T, V> of(Class<T> cls, Class<V> cls2, String str) {
        return new ReflectiveProperty(cls, cls2, str);
    }

    public abstract V get(T t16);

    public String getName() {
        return this.mName;
    }

    public Class<V> getType() {
        return this.mType;
    }

    public boolean isReadOnly() {
        return false;
    }

    public void set(T t16, V v3) {
        throw new UnsupportedOperationException("Property " + getName() + " is read-only");
    }
}
