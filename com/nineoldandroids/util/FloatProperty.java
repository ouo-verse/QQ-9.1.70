package com.nineoldandroids.util;

/* loaded from: classes2.dex */
public abstract class FloatProperty<T> extends Property<T, Float> {
    public FloatProperty(String str) {
        super(Float.class, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nineoldandroids.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f16) {
        set2((FloatProperty<T>) obj, f16);
    }

    public abstract void setValue(T t16, float f16);

    /* renamed from: set, reason: avoid collision after fix types in other method */
    public final void set2(T t16, Float f16) {
        setValue(t16, f16.floatValue());
    }
}
