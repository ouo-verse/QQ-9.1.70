package org.jf.dexlib2.immutable.reference;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseCallSiteReference;
import org.jf.dexlib2.iface.reference.CallSiteReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValue;
import org.jf.dexlib2.immutable.value.ImmutableEncodedValueFactory;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableCallSiteReference extends BaseCallSiteReference implements ImmutableReference {

    @Nonnull
    protected final ImmutableList<? extends ImmutableEncodedValue> extraArguments;

    @Nonnull
    protected final ImmutableMethodHandleReference methodHandle;

    @Nonnull
    protected final String methodName;

    @Nonnull
    protected final ImmutableMethodProtoReference methodProto;

    @Nonnull
    protected final String name;

    public ImmutableCallSiteReference(@Nonnull String str, @Nonnull MethodHandleReference methodHandleReference, @Nonnull String str2, @Nonnull MethodProtoReference methodProtoReference, @Nonnull Iterable<? extends EncodedValue> iterable) {
        this.name = str;
        this.methodHandle = ImmutableMethodHandleReference.of(methodHandleReference);
        this.methodName = str2;
        this.methodProto = ImmutableMethodProtoReference.of(methodProtoReference);
        this.extraArguments = ImmutableEncodedValueFactory.immutableListOf(iterable);
    }

    @Nonnull
    public static ImmutableCallSiteReference of(@Nonnull CallSiteReference callSiteReference) {
        if (callSiteReference instanceof ImmutableCallSiteReference) {
            return (ImmutableCallSiteReference) callSiteReference;
        }
        return new ImmutableCallSiteReference(callSiteReference.getName(), ImmutableMethodHandleReference.of(callSiteReference.getMethodHandle()), callSiteReference.getMethodName(), ImmutableMethodProtoReference.of(callSiteReference.getMethodProto()), (ImmutableList<? extends ImmutableEncodedValue>) ImmutableEncodedValueFactory.immutableListOf(callSiteReference.getExtraArguments()));
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public List<? extends EncodedValue> getExtraArguments() {
        return this.extraArguments;
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public MethodHandleReference getMethodHandle() {
        return this.methodHandle;
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public String getMethodName() {
        return this.methodName;
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public MethodProtoReference getMethodProto() {
        return this.methodProto;
    }

    @Override // org.jf.dexlib2.iface.reference.CallSiteReference
    @Nonnull
    public String getName() {
        return this.name;
    }

    public ImmutableCallSiteReference(@Nonnull String str, @Nonnull ImmutableMethodHandleReference immutableMethodHandleReference, @Nonnull String str2, @Nonnull ImmutableMethodProtoReference immutableMethodProtoReference, @Nullable ImmutableList<? extends ImmutableEncodedValue> immutableList) {
        this.name = str;
        this.methodHandle = immutableMethodHandleReference;
        this.methodName = str2;
        this.methodProto = immutableMethodProtoReference;
        this.extraArguments = ImmutableUtils.nullToEmptyList(immutableList);
    }
}
