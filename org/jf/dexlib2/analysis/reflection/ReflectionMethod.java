package org.jf.dexlib2.analysis.reflection;

import com.google.common.collect.ImmutableSet;
import java.util.AbstractList;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.analysis.reflection.util.ReflectionUtils;
import org.jf.dexlib2.base.BaseMethodParameter;
import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ReflectionMethod extends BaseMethodReference implements Method {
    private final java.lang.reflect.Method method;

    public ReflectionMethod(java.lang.reflect.Method method) {
        this.method = method;
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    public int getAccessFlags() {
        return this.method.getModifiers();
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public Set<? extends Annotation> getAnnotations() {
        return ImmutableSet.of();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return ReflectionUtils.javaToDexName(this.method.getDeclaringClass().getName());
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return ImmutableSet.of();
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nullable
    public MethodImplementation getImplementation() {
        return null;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.method.getName();
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference
    @Nonnull
    public List<String> getParameterTypes() {
        return new AbstractList<String>() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionMethod.2
            private final List<? extends MethodParameter> parameters;

            {
                this.parameters = ReflectionMethod.this.getParameters();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return this.parameters.size();
            }

            @Override // java.util.AbstractList, java.util.List
            public String get(int i3) {
                return this.parameters.get(i3).getType();
            }
        };
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nonnull
    public List<? extends MethodParameter> getParameters() {
        return new AbstractList<MethodParameter>(this.method) { // from class: org.jf.dexlib2.analysis.reflection.ReflectionMethod.1
            private final Class[] parameters;
            final /* synthetic */ java.lang.reflect.Method val$method;

            {
                this.val$method = r2;
                this.parameters = r2.getParameterTypes();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return this.parameters.length;
            }

            @Override // java.util.AbstractList, java.util.List
            public MethodParameter get(final int i3) {
                return new BaseMethodParameter() { // from class: org.jf.dexlib2.analysis.reflection.ReflectionMethod.1.1
                    @Override // org.jf.dexlib2.iface.MethodParameter
                    @Nonnull
                    public Set<? extends Annotation> getAnnotations() {
                        return ImmutableSet.of();
                    }

                    @Override // org.jf.dexlib2.iface.MethodParameter, org.jf.dexlib2.iface.debug.LocalInfo
                    @Nullable
                    public String getName() {
                        return null;
                    }

                    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
                    @Nonnull
                    public String getType() {
                        return ReflectionUtils.javaToDexName(AnonymousClass1.this.parameters[i3].getName());
                    }
                };
            }
        };
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
    @Nonnull
    public String getReturnType() {
        return ReflectionUtils.javaToDexName(this.method.getReturnType().getName());
    }
}
