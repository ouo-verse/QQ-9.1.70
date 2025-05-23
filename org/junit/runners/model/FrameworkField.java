package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FrameworkField extends FrameworkMember<FrameworkField> {
    private final Field field;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameworkField(Field field) {
        if (field != null) {
            this.field = field;
            return;
        }
        throw new NullPointerException("FrameworkField cannot be created without an underlying field.");
    }

    public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return this.field.get(obj);
    }

    @Override // org.junit.runners.model.Annotatable
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.field.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.Annotatable
    public Annotation[] getAnnotations() {
        return this.field.getAnnotations();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public Field getField() {
        return this.field;
    }

    @Override // org.junit.runners.model.FrameworkMember
    protected int getModifiers() {
        return this.field.getModifiers();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public String getName() {
        return getField().getName();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getType() {
        return this.field.getType();
    }

    public String toString() {
        return this.field.toString();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public boolean isShadowedBy(FrameworkField frameworkField) {
        return frameworkField.getName().equals(getName());
    }
}
