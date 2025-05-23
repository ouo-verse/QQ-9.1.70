package org.jf.dexlib2.analysis.reflection;

import com.google.common.base.d;
import com.google.common.base.k;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.r;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.analysis.reflection.util.ReflectionUtils;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.ClassDef;
import org.jf.dexlib2.iface.Field;
import org.jf.dexlib2.iface.Method;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ReflectionClassDef extends BaseTypeReference implements ClassDef {
    private static final int DIRECT_MODIFIERS = 10;
    private final Class cls;

    public ReflectionClassDef(Class cls) {
        this.cls = cls;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    public int getAccessFlags() {
        return this.cls.getModifiers();
    }

    @Override // org.jf.dexlib2.iface.ClassDef, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public Set<? extends Annotation> getAnnotations() {
        return ImmutableSet.of();
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends Method> getDirectMethods() {
        return new Iterable<Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.5
            @Override // java.lang.Iterable
            @Nonnull
            public Iterator<Method> iterator() {
                return r.f(r.x(r.m(ReflectionClassDef.this.cls.getDeclaredConstructors()), new d<Constructor, Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.5.1
                    @Override // com.google.common.base.d
                    @Nullable
                    public Method apply(@Nullable Constructor constructor) {
                        return new ReflectionConstructor(constructor);
                    }
                }), r.x(r.l(r.m(ReflectionClassDef.this.cls.getDeclaredMethods()), new k<java.lang.reflect.Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.5.2
                    @Override // com.google.common.base.k
                    public boolean apply(@Nullable java.lang.reflect.Method method) {
                        return (method == null || (method.getModifiers() & 10) == 0) ? false : true;
                    }
                }), new d<java.lang.reflect.Method, Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.5.3
                    @Override // com.google.common.base.d
                    @Nullable
                    public Method apply(@Nullable java.lang.reflect.Method method) {
                        return new ReflectionMethod(method);
                    }
                }));
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends Field> getInstanceFields() {
        return new Iterable<Field>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.3
            @Override // java.lang.Iterable
            @Nonnull
            public Iterator<Field> iterator() {
                return r.x(r.l(r.m(ReflectionClassDef.this.cls.getDeclaredFields()), new k<java.lang.reflect.Field>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.3.1
                    @Override // com.google.common.base.k
                    public boolean apply(@Nullable java.lang.reflect.Field field) {
                        return (field == null || Modifier.isStatic(field.getModifiers())) ? false : true;
                    }
                }), new d<java.lang.reflect.Field, Field>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.3.2
                    @Override // com.google.common.base.d
                    @Nullable
                    public Field apply(@Nullable java.lang.reflect.Field field) {
                        return new ReflectionField(field);
                    }
                });
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public List<String> getInterfaces() {
        return ImmutableList.copyOf(r.x(r.m(this.cls.getInterfaces()), new d<Class, String>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.1
            @Override // com.google.common.base.d
            @Nullable
            public String apply(@Nullable Class cls) {
                if (cls == null) {
                    return null;
                }
                return ReflectionUtils.javaToDexName(cls.getName());
            }
        }));
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nullable
    public String getSourceFile() {
        return null;
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends Field> getStaticFields() {
        return new Iterable<Field>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.2
            @Override // java.lang.Iterable
            @Nonnull
            public Iterator<Field> iterator() {
                return r.x(r.l(r.m(ReflectionClassDef.this.cls.getDeclaredFields()), new k<java.lang.reflect.Field>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.2.1
                    @Override // com.google.common.base.k
                    public boolean apply(@Nullable java.lang.reflect.Field field) {
                        return field != null && Modifier.isStatic(field.getModifiers());
                    }
                }), new d<java.lang.reflect.Field, Field>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.2.2
                    @Override // com.google.common.base.d
                    @Nullable
                    public Field apply(@Nullable java.lang.reflect.Field field) {
                        return new ReflectionField(field);
                    }
                });
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nullable
    public String getSuperclass() {
        if (Modifier.isInterface(this.cls.getModifiers())) {
            return "Ljava/lang/Object;";
        }
        Class superclass = this.cls.getSuperclass();
        if (superclass == null) {
            return null;
        }
        return ReflectionUtils.javaToDexName(superclass.getName());
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public String getType() {
        return ReflectionUtils.javaToDexName(this.cls.getName());
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Iterable<? extends Method> getVirtualMethods() {
        return new Iterable<Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.6
            @Override // java.lang.Iterable
            @Nonnull
            public Iterator<Method> iterator() {
                return r.x(r.l(r.m(ReflectionClassDef.this.cls.getDeclaredMethods()), new k<java.lang.reflect.Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.6.1
                    @Override // com.google.common.base.k
                    public boolean apply(@Nullable java.lang.reflect.Method method) {
                        return method != null && (method.getModifiers() & 10) == 0;
                    }
                }), new d<java.lang.reflect.Method, Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.6.2
                    @Override // com.google.common.base.d
                    @Nullable
                    public Method apply(@Nullable java.lang.reflect.Method method) {
                        return new ReflectionMethod(method);
                    }
                });
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Set<? extends Field> getFields() {
        return new AbstractSet<Field>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.4
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            @Nonnull
            public Iterator<Field> iterator() {
                return r.x(r.m(ReflectionClassDef.this.cls.getDeclaredFields()), new d<java.lang.reflect.Field, Field>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.4.1
                    @Override // com.google.common.base.d
                    @Nullable
                    public Field apply(@Nullable java.lang.reflect.Field field) {
                        return new ReflectionField(field);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return ReflectionClassDef.this.cls.getDeclaredFields().length;
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public Set<? extends Method> getMethods() {
        return new AbstractSet<Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.7
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            @Nonnull
            public Iterator<Method> iterator() {
                return r.f(r.x(r.m(ReflectionClassDef.this.cls.getDeclaredConstructors()), new d<Constructor, Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.7.1
                    @Override // com.google.common.base.d
                    @Nullable
                    public Method apply(@Nullable Constructor constructor) {
                        return new ReflectionConstructor(constructor);
                    }
                }), r.x(r.m(ReflectionClassDef.this.cls.getDeclaredMethods()), new d<java.lang.reflect.Method, Method>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionClassDef.7.2
                    @Override // com.google.common.base.d
                    @Nullable
                    public Method apply(@Nullable java.lang.reflect.Method method) {
                        return new ReflectionMethod(method);
                    }
                }));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return ReflectionClassDef.this.cls.getDeclaredMethods().length + ReflectionClassDef.this.cls.getDeclaredConstructors().length;
            }
        };
    }
}
