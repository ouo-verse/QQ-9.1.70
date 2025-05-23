package org.jf.dexlib2.immutable.reference;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseMethodReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.immutable.util.CharSequenceConverter;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableMethodReference extends BaseMethodReference implements ImmutableReference {

    @Nonnull
    protected final String definingClass;

    @Nonnull
    protected final String name;

    @Nonnull
    protected final ImmutableList<String> parameters;

    @Nonnull
    protected final String returnType;

    public ImmutableMethodReference(@Nonnull String str, @Nonnull String str2, @Nullable Iterable<? extends CharSequence> iterable, @Nonnull String str3) {
        this.definingClass = str;
        this.name = str2;
        this.parameters = CharSequenceConverter.immutableStringList(iterable);
        this.returnType = str3;
    }

    @Nonnull
    public static ImmutableMethodReference of(@Nonnull MethodReference methodReference) {
        if (methodReference instanceof ImmutableMethodReference) {
            return (ImmutableMethodReference) methodReference;
        }
        return new ImmutableMethodReference(methodReference.getDefiningClass(), methodReference.getName(), methodReference.getParameterTypes(), methodReference.getReturnType());
    }

    @Override // org.jf.dexlib2.iface.reference.MethodReference, org.jf.dexlib2.iface.Method, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.definingClass;
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

    @Override // org.jf.dexlib2.iface.reference.MethodReference
    @Nonnull
    public ImmutableList<String> getParameterTypes() {
        return this.parameters;
    }

    public ImmutableMethodReference(@Nonnull String str, @Nonnull String str2, @Nullable ImmutableList<String> immutableList, @Nonnull String str3) {
        this.definingClass = str;
        this.name = str2;
        this.parameters = ImmutableUtils.nullToEmptyList(immutableList);
        this.returnType = str3;
    }
}
