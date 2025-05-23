package org.jf.dexlib2.base.reference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.reference.FieldReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseFieldReference extends BaseReference implements FieldReference {
    @Override // org.jf.dexlib2.iface.reference.FieldReference
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FieldReference)) {
            return false;
        }
        FieldReference fieldReference = (FieldReference) obj;
        if (!getDefiningClass().equals(fieldReference.getDefiningClass()) || !getName().equals(fieldReference.getName()) || !getType().equals(fieldReference.getType())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference
    public int hashCode() {
        return (((getDefiningClass().hashCode() * 31) + getName().hashCode()) * 31) + getType().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getFieldDescriptor(this);
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, java.lang.Comparable
    public int compareTo(@Nonnull FieldReference fieldReference) {
        int compareTo = getDefiningClass().compareTo(fieldReference.getDefiningClass());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = getName().compareTo(fieldReference.getName());
        return compareTo2 != 0 ? compareTo2 : getType().compareTo(fieldReference.getType());
    }
}
