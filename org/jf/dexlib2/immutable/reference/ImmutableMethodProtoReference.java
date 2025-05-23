package org.jf.dexlib2.immutable.reference;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseMethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.immutable.util.CharSequenceConverter;
import org.jf.util.ImmutableUtils;

/* loaded from: classes29.dex */
public class ImmutableMethodProtoReference extends BaseMethodProtoReference implements ImmutableReference {

    @Nonnull
    protected final ImmutableList<String> parameters;

    @Nonnull
    protected final String returnType;

    public ImmutableMethodProtoReference(@Nullable ImmutableList<String> immutableList, @Nonnull String str) {
        this.parameters = ImmutableUtils.nullToEmptyList(immutableList);
        this.returnType = str;
    }

    @Nonnull
    public static ImmutableMethodProtoReference of(@Nonnull MethodProtoReference methodProtoReference) {
        if (methodProtoReference instanceof ImmutableMethodProtoReference) {
            return (ImmutableMethodProtoReference) methodProtoReference;
        }
        return new ImmutableMethodProtoReference(methodProtoReference.getParameterTypes(), methodProtoReference.getReturnType());
    }

    @Override // org.jf.dexlib2.iface.reference.MethodProtoReference
    public List<? extends CharSequence> getParameterTypes() {
        return this.parameters;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodProtoReference
    public String getReturnType() {
        return this.returnType;
    }

    public ImmutableMethodProtoReference(@Nullable Iterable<? extends CharSequence> iterable, @Nonnull String str) {
        this.parameters = CharSequenceConverter.immutableStringList(iterable);
        this.returnType = str;
    }
}
