package org.jf.dexlib2.base.reference;

import javax.annotation.Nonnull;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.reference.FieldReference;
import org.jf.dexlib2.iface.reference.MethodHandleReference;
import org.jf.dexlib2.iface.reference.MethodReference;
import org.jf.dexlib2.iface.reference.Reference;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseMethodHandleReference extends BaseReference implements MethodHandleReference {
    @Override // org.jf.dexlib2.iface.reference.MethodHandleReference
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MethodHandleReference)) {
            return false;
        }
        MethodHandleReference methodHandleReference = (MethodHandleReference) obj;
        if (getMethodHandleType() != methodHandleReference.getMethodHandleType() || !getMemberReference().equals(methodHandleReference.getMemberReference())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.reference.MethodHandleReference
    public int hashCode() {
        return (getMethodHandleType() * 31) + getMemberReference().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getMethodHandle(this);
    }

    @Override // org.jf.dexlib2.iface.reference.MethodHandleReference, java.lang.Comparable
    public int compareTo(@Nonnull MethodHandleReference methodHandleReference) {
        int a16 = c.a(getMethodHandleType(), methodHandleReference.getMethodHandleType());
        if (a16 != 0) {
            return a16;
        }
        Reference memberReference = getMemberReference();
        if (memberReference instanceof FieldReference) {
            if (methodHandleReference.getMemberReference() instanceof FieldReference) {
                return ((FieldReference) memberReference).compareTo((FieldReference) methodHandleReference.getMemberReference());
            }
            return -1;
        }
        if (methodHandleReference.getMemberReference() instanceof MethodReference) {
            return ((MethodReference) memberReference).compareTo((MethodReference) methodHandleReference.getMemberReference());
        }
        return 1;
    }
}
