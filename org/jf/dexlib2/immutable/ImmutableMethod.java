package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.HiddenApiRestriction;
import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.Annotation;
import org.jf.dexlib2.iface.Method;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.MethodParameter;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableMethod extends BaseMethodReference implements Method {
    private static final ImmutableConverter<ImmutableMethod, Method> CONVERTER = new ImmutableConverter<ImmutableMethod, Method>() { // from class: org.jf.dexlib2.immutable.ImmutableMethod.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull Method method) {
            return method instanceof ImmutableMethod;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableMethod makeImmutable(@Nonnull Method method) {
            return ImmutableMethod.of(method);
        }
    };
    protected final int accessFlags;

    @Nonnull
    protected final ImmutableSet<? extends ImmutableAnnotation> annotations;

    @Nonnull
    protected final String definingClass;

    @Nonnull
    protected final ImmutableSet<HiddenApiRestriction> hiddenApiRestrictions;

    @Nullable
    protected final ImmutableMethodImplementation methodImplementation;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final ImmutableList<? extends ImmutableMethodParameter> parameters;

    @Nonnull
    protected final String returnType;

    public ImmutableMethod(@Nonnull String str, @Nonnull String str2, @Nullable Iterable<? extends MethodParameter> iterable, @Nonnull String str3, int i3, @Nullable Set<? extends Annotation> set, @Nullable Set<HiddenApiRestriction> set2, @Nullable MethodImplementation methodImplementation) {
        this.definingClass = str;
        this.name = str2;
        this.parameters = ImmutableMethodParameter.immutableListOf(iterable);
        this.returnType = str3;
        this.accessFlags = i3;
        this.annotations = ImmutableAnnotation.immutableSetOf(set);
        this.hiddenApiRestrictions = set2 == null ? ImmutableSet.of() : ImmutableSet.copyOf((Collection) set2);
        this.methodImplementation = ImmutableMethodImplementation.of(methodImplementation);
    }

    @Nonnull
    public static ImmutableSortedSet<ImmutableMethod> immutableSetOf(@Nullable Iterable<? extends Method> iterable) {
        return CONVERTER.toSortedSet(Ordering.natural(), iterable);
    }

    public static ImmutableMethod of(Method method) {
        if (method instanceof ImmutableMethod) {
            return (ImmutableMethod) method;
        }
        return new ImmutableMethod(method.getDefiningClass(), method.getName(), method.getParameters(), method.getReturnType(), method.getAccessFlags(), method.getAnnotations(), method.getHiddenApiRestrictions(), method.getImplementation());
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    public int getAccessFlags() {
        return this.accessFlags;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.definingClass;
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public Set<HiddenApiRestriction> getHiddenApiRestrictions() {
        return this.hiddenApiRestrictions;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method
    @Nonnull
    public String getReturnType() {
        return this.returnType;
    }

    @Override // org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Annotatable
    @Nonnull
    public ImmutableSet<? extends ImmutableAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nullable
    public ImmutableMethodImplementation getImplementation() {
        return this.methodImplementation;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference
    @Nonnull
    public ImmutableList<? extends CharSequence> getParameterTypes() {
        return this.parameters;
    }

    @Override // org.jf.dexlib2.iface.Method
    @Nonnull
    public ImmutableList<? extends ImmutableMethodParameter> getParameters() {
        return this.parameters;
    }

    public ImmutableMethod(@Nonnull String str, @Nonnull String str2, @Nullable ImmutableList<? extends ImmutableMethodParameter> immutableList, @Nonnull String str3, int i3, @Nullable ImmutableSet<? extends ImmutableAnnotation> immutableSet, @Nullable ImmutableSet<HiddenApiRestriction> immutableSet2, @Nullable ImmutableMethodImplementation immutableMethodImplementation) {
        this.definingClass = str;
        this.name = str2;
        this.parameters = ImmutableUtils.nullToEmptyList(immutableList);
        this.returnType = str3;
        this.accessFlags = i3;
        this.annotations = ImmutableUtils.nullToEmptySet(immutableSet);
        this.hiddenApiRestrictions = ImmutableUtils.nullToEmptySet(immutableSet2);
        this.methodImplementation = immutableMethodImplementation;
    }
}
