package org.jf.dexlib2.immutable.reference;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseMethodHandleReference;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableMethodHandleReference extends BaseMethodHandleReference implements ImmutableReference {

    @Nonnull
    protected final ImmutableReference memberReference;
    protected final int methodHandleType;

    public ImmutableMethodHandleReference(int i3, @Nonnull ImmutableReference immutableReference) {
        this.methodHandleType = i3;
        this.memberReference = immutableReference;
    }

    @Nonnull
    public static ImmutableMethodHandleReference of(@Nonnull MethodHandleReference methodHandleReference) {
        ImmutableReference of5;
        if (methodHandleReference instanceof ImmutableMethodHandleReference) {
            return (ImmutableMethodHandleReference) methodHandleReference;
        }
        int methodHandleType = methodHandleReference.getMethodHandleType();
        switch (methodHandleType) {
            case 0:
            case 1:
            case 2:
            case 3:
                of5 = ImmutableFieldReference.of((FieldReference) methodHandleReference.getMemberReference());
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                of5 = ImmutableMethodReference.of((MethodReference) methodHandleReference.getMemberReference());
                break;
            default:
                throw new ExceptionWithContext("Invalid method handle type: %d", Integer.valueOf(methodHandleType));
        }
        return new ImmutableMethodHandleReference(methodHandleType, of5);
    }

    @Override // org.jf.dexlib2.iface.reference.MethodHandleReference
    @Nonnull
    public Reference getMemberReference() {
        return this.memberReference;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodHandleReference
    public int getMethodHandleType() {
        return this.methodHandleType;
    }

    public ImmutableMethodHandleReference(int i3, @Nonnull Reference reference) {
        this.methodHandleType = i3;
        this.memberReference = ImmutableReferenceFactory.of(reference);
    }
}
